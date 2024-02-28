package com.ftn.realestatemanagement.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private long id;

    private String username;

    private String password;

    private String name;

    private String surname;
}
