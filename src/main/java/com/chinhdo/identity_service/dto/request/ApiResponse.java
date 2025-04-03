package com.chinhdo.identity_service.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data //bao gom ca setter va getter
@NoArgsConstructor // constructor ko can tham so
@AllArgsConstructor //constructor day du tham so
@Builder //xay dung object nhanh hon
@FieldDefaults(level = AccessLevel.PRIVATE) //moi field neu ko xac dinh cu the thi mac dinh la private
@JsonInclude(JsonInclude.Include.NON_NULL) //field nao null thi ko kem vao json response
public class ApiResponse<T> {

    @Builder.Default
    int code = 1000;
    String message;
    T result;

}
