package com.chinhdo.identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data //bao gom ca setter va getter
@NoArgsConstructor // constructor ko can tham so
@AllArgsConstructor //constructor day du tham so
@Builder //xay dung object nhanh hon
@FieldDefaults(level = AccessLevel.PRIVATE) //moi field neu ko xac dinh cu the thi mac dinh la private
public class LogoutRequest {

    String token;
}
