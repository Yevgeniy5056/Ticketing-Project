package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean isEnabled;
    private String phone;
    private Role role;
    private Gender gender;

    public User(Long id, LocalDateTime insertDateTime,
                Long insertUserId, LocalDateTime lastUpdateDateTime,
                Long lastUpdateUserId, String firstName,
                String lastName, String userName,
                String password, boolean isEnabled,
                String phone, Role role, Gender gender) {

        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.isEnabled = isEnabled;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }
}
