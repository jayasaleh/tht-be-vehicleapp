package com.i2s.vehicleapp.service;

import com.i2s.vehicleapp.repository.VehicleRepository;
import com.i2s.vehicleapp.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(String regNo) {
        vehicleRepository.deleteById(regNo);
    }
}
