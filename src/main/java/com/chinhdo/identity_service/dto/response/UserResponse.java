package com.chinhdo.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data //bao gom ca setter va getter
@NoArgsConstructor // constructor ko can tham so
@AllArgsConstructor //constructor day du tham so
@Builder //xay dung object nhanh hon
@FieldDefaults(level = AccessLevel.PRIVATE) //moi field neu ko xac dinh cu the thi mac dinh la private
public class UserResponse {
    String id;
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
