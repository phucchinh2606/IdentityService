package com.chinhdo.identity_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //danh dau la table
public class InvalidateToken {

    @Id
    String id;
    Date expiryTime;
}
