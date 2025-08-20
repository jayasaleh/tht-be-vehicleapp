package com.i2s.vehicleapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @Column(name = "reg_no", length = 20)
    private String regNo;

    @NotBlank
    @Column(name = "owner_name", length = 120, nullable = false)
    private String ownerName;

    private String address;
    private String brand;

    @Min(1900)
    private Integer manufactureYear;

    @Positive
    private Integer engineCapacityCc;

    private String color;
    private String fuelType;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Vehicle() {}
    // getter & setter...
}
