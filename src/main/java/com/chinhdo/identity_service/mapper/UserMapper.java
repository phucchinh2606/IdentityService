package com.chinhdo.identity_service.mapper;


import com.chinhdo.identity_service.dto.request.UserCreationRequest;
import com.chinhdo.identity_service.dto.request.UserUpdateRequest;
import com.chinhdo.identity_service.dto.response.UserResponse;
import com.chinhdo.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") //generate mapper de su dung trong spring, su dung theo kieu di
public interface UserMapper {
    User toUser(UserCreationRequest request);
    void updateUser(@MappingTarget User user, UserUpdateRequest request); //map request voi user o 2 tham so

    UserResponse toUserResponse(User user);
}
