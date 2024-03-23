package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "Report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    private long id;
    private Date date;
    private double profit;

}
