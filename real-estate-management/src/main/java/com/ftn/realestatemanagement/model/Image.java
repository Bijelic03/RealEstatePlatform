package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String imagePath;
    private String name;

    @ManyToOne
    @JoinColumn(name = "estate_id") // ManyToOne relationship
    private Estate estate;
}