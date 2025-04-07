package com.chinhdo.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data //bao gom ca setter va getter
@NoArgsConstructor // constructor ko can tham so
@AllArgsConstructor //constructor day du tham so
@Builder //xay dung object nhanh hon
@FieldDefaults(level = AccessLevel.PRIVATE) //moi field neu ko xac dinh cu the thi mac dinh la private
public class RoleResponse {

    String name;
    String description;
    Set<PermissionResponse> permissions;
}
