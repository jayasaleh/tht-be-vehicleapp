package com.i2s.vehicleapp.repository;

import com.i2s.vehicleapp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
