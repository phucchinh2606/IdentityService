package com.chinhdo.identity_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //danh dau la table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //tao ra chuoi id ko trung lap
    String id;
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;

    @ManyToMany
    Set<Role> roles;

}
