package com.freeclassroom.freeclassroom.utils;

import com.freeclassroom.freeclassroom.dto.request.AuthenticationRequest;
import com.freeclassroom.freeclassroom.entity.account.AccountEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtils {

    @NonFinal
    @Value("${spring.jwt.signerKey}")
    protected String SIGNER_KEY;


    public String generateToken (AccountEntity account) throws JOSEException {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        //payload
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .jwtID(UUID.randomUUID().toString())
                .subject(account.getUsername()) // sub
                .issuer("freeclassroom.com") // iss
                .issueTime(new Date()) // iat
                .expirationTime(new Date(System.currentTimeMillis() + 3600 * 1000)) // exp (1 giờ)
                .claim("scope", account.getRole()) // Custom claim
                .build();

        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));

        return jwsObject.serialize();
    }


    public Boolean introspect (String token) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expirationDate = signedJWT.getJWTClaimsSet().getExpirationTime();
//        String jwtId = signedJWT.getJWTClaimsSet().getJWTID();

        if (!(expirationDate.after(new Date())
                && signedJWT.verify(verifier)))
            return false;

        return true;
    }

}
