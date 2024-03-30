package com.ftn.realestatemanagement.dto;

import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.model.Person;
import com.ftn.realestatemanagement.model.PersonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.cglib.core.Local;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PersonDto {

    private long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String address;

    private String email;

    private String phone;

    private PersonType role;

    public static PersonDto convertToDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .username(person.getUsername())
                .password(person.getPassword())
                .name(person.getName())
                .surname(person.getSurname())
                .address(person.getAddress())
                .phone(person.getPhone())
                .role(person.getRole())
                .email(person.getEmail())
                .build();
    }

    public Person convertToModel() {
        return Person.builder()
                .id(getId())
                .username(getUsername())
                .password(getPassword())
                .name(getName())
                .surname(getSurname())
                .address(getAddress())
                .phone(getPhone())
                .role(getRole())
                .email(getEmail())
                .build();
    }
}

