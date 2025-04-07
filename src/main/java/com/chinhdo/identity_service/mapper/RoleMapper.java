package com.chinhdo.identity_service.mapper;


import com.chinhdo.identity_service.dto.request.RoleRequest;
import com.chinhdo.identity_service.dto.response.RoleResponse;
import com.chinhdo.identity_service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") //generate mapper de su dung trong spring, su dung theo kieu di
public interface RoleMapper {
    @Mapping(target = "permissions",ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
