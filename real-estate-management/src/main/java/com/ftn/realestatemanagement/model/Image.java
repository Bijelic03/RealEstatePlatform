package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    private long id;
    private String imagePath;
    private String name;
}
