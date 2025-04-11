package com.chinhdo.identity_service.dto.request;

import com.chinhdo.identity_service.validator.DobConstraint;
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

    @Size(min = 4,message = "USERNAME_INVALID") //truyen vao key cua error code
    String username;

    @Size(min = 6, message = "INVALID_PASSWORD")//logic yeu cau pass toi thieu la 8 neu ko thi bao message
    String password;
    String firstName;
    String lastName;

    @DobConstraint(min = 16, message = "INVALID_DOB")
    LocalDate dob;
}
