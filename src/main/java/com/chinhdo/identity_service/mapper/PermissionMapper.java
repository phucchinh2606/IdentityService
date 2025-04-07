package com.chinhdo.identity_service.mapper;


import com.chinhdo.identity_service.dto.request.PermissionRequest;
import com.chinhdo.identity_service.dto.response.PermissionResponse;
import com.chinhdo.identity_service.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") //generate mapper de su dung trong spring, su dung theo kieu di
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
