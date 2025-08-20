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
        if(vehicleRepository.existsById(vehicle.getRegNo())){
            throw new RuntimeException("Vehicle With regNo "+ vehicle.getRegNo()+" already exists!");
        }
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(String regNo, Vehicle vehicleData) {
        Vehicle existingVehicle = vehicleRepository.findById(regNo)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if (vehicleData.getOwnerName() != null) {
            existingVehicle.setOwnerName(vehicleData.getOwnerName());
        }
        if (vehicleData.getAddress() != null) {
            existingVehicle.setAddress(vehicleData.getAddress());
        }
        if (vehicleData.getBrand() != null) {
            existingVehicle.setBrand(vehicleData.getBrand());
        }
        if (vehicleData.getManufactureYear() != null) {
            existingVehicle.setManufactureYear(vehicleData.getManufactureYear());
        }
        if (vehicleData.getEngineCapacityCc() != null) {
            existingVehicle.setEngineCapacityCc(vehicleData.getEngineCapacityCc());
        }
        if (vehicleData.getColor() != null) {
            existingVehicle.setColor(vehicleData.getColor());
        }
        if (vehicleData.getFuelType() != null) {
            existingVehicle.setFuelType(vehicleData.getFuelType());
        }

        return vehicleRepository.save(existingVehicle);
    }

    public void deleteVehicle(String regNo) {
        vehicleRepository.deleteById(regNo);
    }
}
