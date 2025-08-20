package com.i2s.vehicleapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(length = 255)
    private String address;

    @Column(length = 50)
    private String brand;

    @Min(1900)
    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    @Positive
    @Column(name = "engine_capacity_cc")
    private Integer engineCapacityCc;

    @Column(length = 30)
    private String color;

    @Column(name = "fuel_type", length = 30)
    private String fuelType;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Default constructor (Hibernate butuh)
    public Vehicle() {
    }

    // Getter & Setter
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public Integer getEngineCapacityCc() {
        return engineCapacityCc;
    }

    public void setEngineCapacityCc(Integer engineCapacityCc) {
        this.engineCapacityCc = engineCapacityCc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
