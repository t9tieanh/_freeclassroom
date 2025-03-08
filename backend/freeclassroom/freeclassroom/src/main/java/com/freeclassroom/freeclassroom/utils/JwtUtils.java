package com.freeclassroom.freeclassroom.utils;

import com.freeclassroom.freeclassroom.constant.TokenEnum;
import com.freeclassroom.freeclassroom.dto.request.AuthenticationRequest;
import com.freeclassroom.freeclassroom.entity.account.AccountEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.persistence.EnumType;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    @Value("${spring.jwt.signerKey}")
    private String SIGNER_KEY;

    @Value("${spring.jwt.access-token-expiration}")
    private Long accessTokenExpiration;

    @Value("${spring.jwt.refresh-token-expiration}")
    private Long refreshTokenExpiration;



    public String generateToken (AccountEntity account, TokenEnum tokenType) throws JOSEException {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        Long date = (tokenType.equals(TokenEnum.ACCESS_TOKEN)) ? accessTokenExpiration : refreshTokenExpiration;

        //payload
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .jwtID(UUID.randomUUID().toString())
                .subject(account.getUsername()) // sub
                .issuer("freeclassroom.com") // iss
                .issueTime(new Date()) // iat
                .expirationTime(new Date(System.currentTimeMillis() + date))
                .claim("scope", account.getRole()) // Custom claim
                .claim("type",tokenType.name())
                .build();

        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));

        return jwsObject.serialize();
    }


    public Boolean validToken (String token, TokenEnum tokenType) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expirationDate = signedJWT.getJWTClaimsSet().getExpirationTime();
        TokenEnum tokenTypeEnum = TokenEnum.valueOf(signedJWT.getJWTClaimsSet().getClaim("type").toString());
//        String jwtId = signedJWT.getJWTClaimsSet().getJWTID();

//        String tokenvalue = tokenTypeEnum.getValue();
//        String tmp = tokenType.getValue();
        boolean flag = tokenTypeEnum.getValue().equals(tokenType.getValue());

        if (!(expirationDate.after(new Date()))
                || !signedJWT.verify(verifier) || !flag)
            return false;

        return true;
    }

    public String getUserName (String token) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT.getJWTClaimsSet().getSubject().toString();
    }

}
