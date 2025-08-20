package com.i2s.vehicleapp.controller;

import com.i2s.vehicleapp.dto.ApiResponse;
import com.i2s.vehicleapp.model.Vehicle;
import com.i2s.vehicleapp.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<List<Vehicle>>> getVehicles() {
        List<Vehicle>vehicles=vehicleService.getAllVehicles();
       return ResponseEntity.ok(new ApiResponse<>(200,"successfully fetch vehicles", vehicles));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Vehicle>>addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(201, "successfully create new vehicle", savedVehicle));
    }

    @PutMapping("/{regNo}")
    public ResponseEntity<ApiResponse<Vehicle>> updateVehicle(
            @PathVariable String regNo,
            @RequestBody Vehicle vehicleData) {
        Vehicle updateVehicle = vehicleService.updateVehicle(regNo, vehicleData);
        return ResponseEntity.ok(new ApiResponse<>(200,"successfully updated vehicle", updateVehicle));
    }

    @DeleteMapping("/{regNo}")
    public ResponseEntity<ApiResponse<Void>> deleteVehicle(@PathVariable String regNo) {
        vehicleService.deleteVehicle(regNo);
        return ResponseEntity.ok(new ApiResponse<>(200, "successfully delete vehicle", null));
    }
}