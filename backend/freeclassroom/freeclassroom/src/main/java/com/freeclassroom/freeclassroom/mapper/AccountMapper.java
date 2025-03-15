package com.freeclassroom.freeclassroom.mapper;

import com.freeclassroom.freeclassroom.dto.request.ActiveAccountRequest;
import com.freeclassroom.freeclassroom.dto.request.UserCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.UserCreationResponse;
import com.freeclassroom.freeclassroom.entity.account.AccountEntity;
import com.freeclassroom.freeclassroom.entity.user.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountEntity toAccountEntity(UserCreationRequest request);
    UserCreationResponse toUserCreationResponse(AccountEntity accountEntity);
    void updateAccountResponse( AccountEntity accountEntity, @MappingTarget UserCreationResponse userCreationResponse);
    void updateAccountEntity (UserCreationRequest request, @MappingTarget AccountEntity accountEntity);
}
