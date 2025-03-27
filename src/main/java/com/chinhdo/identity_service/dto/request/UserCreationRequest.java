package com.chinhdo.identity_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data //bao gom ca setter va getter
@NoArgsConstructor // constructor ko can tham so
@AllArgsConstructor //constructor day du tham so
@Builder //xay dung object nhanh hon
@FieldDefaults(level = AccessLevel.PRIVATE) //moi field neu ko xac dinh cu the thi mac dinh la private
public class UserCreationRequest {

    @Size(min = 3,message = "USERNAME_INVALID") //truyen vao key cua error code
    String username;

    @Size(min = 8, message = "INVALID_PASSWORD")//logic yeu cau pass toi thieu la 8 neu ko thi bao message
    String password;
    String firstName;
    String lastName;
    LocalDate dob;


}
