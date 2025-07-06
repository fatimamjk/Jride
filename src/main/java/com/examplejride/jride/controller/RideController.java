package com.examplejride.jride.controller;

import com.examplejride.jride.model.*;
import com.examplejride.jride.service.RideService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RideController {
  private final RideService rideService;

  public RideController(RideService rideService) {
    this.rideService = rideService;
  }

  @PostMapping("/register/passenger")
  public User registerPassenger(@Valid @RequestBody User user) {
    return rideService.registerPassenger(user);
  }

  @PostMapping("/register/driver")
  public Driver registerDriver(@RequestBody Driver driver) {
    return rideService.registerDriver(driver);
  }

  @PostMapping("/ride/request")
  public Ride requestRide(@RequestParam Long passengerId,
      @RequestParam String pickup,
      @RequestParam String drop,
      @RequestParam String type) {
    return rideService.requestRide(passengerId, pickup, drop, type);
  }

  @PutMapping("/ride/accept")
  public Ride assignDriver(@RequestParam Long rideId,
      @RequestParam Long driverId,
      @RequestParam boolean accept) {
    return rideService.assignDriver(rideId, driverId, accept);
  }

  @PutMapping("/ride/status")
  public Ride updateRideStatus(@RequestParam Long rideId,
      @RequestParam String status) {
    return rideService.updateRideStatus(rideId, status);
  }

  @GetMapping("/ride/history/passenger")
  public List<Ride> rideHistory(@RequestParam Long passengerId) {
    return rideService.getRideHistory(passengerId);
  }

  @GetMapping("/ride/history/driver")
  public List<Ride> driverRideHistory(@RequestParam Long driverId) {
    return rideService.getDriverRides(driverId);
  }
}
