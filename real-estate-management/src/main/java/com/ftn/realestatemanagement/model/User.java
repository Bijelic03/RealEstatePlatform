package com.ftn.realestatemanagement.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class User extends Person {
    private String phone;
    private String email;

    @Builder
    public User(long id, String username, String password, String name, String surname, String phone, String email) {
        super(id, username, password, name, surname);
        this.phone = phone;
        this.email = email;
    }
}
