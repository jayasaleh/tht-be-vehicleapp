package com.i2s.vehicleapp.controller;

import com.i2s.vehicleapp.model.Vehicle;
import com.i2s.vehicleapp.service.VehicleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @DeleteMapping("/{regNo}")
    public void deleteVehicle(@PathVariable String regNo) {
        vehicleService.deleteVehicle(regNo);
    }
}