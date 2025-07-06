package com.examplejride.jride.service;

import com.examplejride.jride.exception.*;
import com.examplejride.jride.model.*;
import com.examplejride.jride.repository.*;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RideService {
  private final RideRepository rideRepo;
  private final UserRepository userRepo;
  private final DriverRepository driverRepo;

  public RideService(RideRepository rideRepo, UserRepository userRepo, DriverRepository driverRepo) {
    this.rideRepo = rideRepo;
    this.userRepo = userRepo;
    this.driverRepo = driverRepo;
  }

  public User registerPassenger(User user) {
    return userRepo.save(user);
  }

  public Driver registerDriver(Driver driver) {
    return driverRepo.save(driver);
  }

  public Ride requestRide(Long passengerId, String pickup, String drop, String type) {
    User passenger = userRepo.findById(passengerId)
        .orElseThrow(() -> new ResourceNotFoundException("Passenger not found"));

    Ride ride = new Ride();
    ride.setPassenger(passenger);
    ride.setPickupLocation(pickup);
    ride.setDropOffLocation(drop);
    ride.setRideType(type);
    ride.setStatus("Requested");
    return rideRepo.save(ride);
  }

  public Ride assignDriver(Long rideId, Long driverId, boolean accept) {
    Ride ride = rideRepo.findById(rideId).orElseThrow(() -> new ResourceNotFoundException("Ride not found"));

    if (!accept) {
      ride.setStatus("Rejected");
      return rideRepo.save(ride);
    }

    Driver driver = driverRepo.findById(driverId)
        .orElseThrow(() -> new ResourceNotFoundException("Driver not found"));

    if (!"Available".equalsIgnoreCase(driver.getAvailabilityStatus())) {
      throw new BadRequestException("Driver not available");
    }

    ride.setDriver(driver);
    ride.setStatus("Accepted");
    driver.setAvailabilityStatus("Unavailable");
    driverRepo.save(driver);
    return rideRepo.save(ride);
  }

  public Ride updateRideStatus(Long rideId, String status) {
    Ride ride = rideRepo.findById(rideId).orElseThrow(() -> new ResourceNotFoundException("Ride not found"));

    status = status.trim();
    ride.setStatus(status);

    if ("Completed".equalsIgnoreCase(status) && ride.getDriver() != null) {
      Driver driver = ride.getDriver();
      driver.setAvailabilityStatus("Available");
      driverRepo.save(driver);
    }

    return rideRepo.save(ride);
  }

  public List<Ride> getRideHistory(Long passengerId) {
    return rideRepo.findByPassengerId(passengerId);
  }

  public List<Ride> getDriverRides(Long driverId) {
    return rideRepo.findByDriverId(driverId);
  }

  // ✅ Get ride status by ride ID
  public String getRideStatus(Long rideId) {
    Ride ride = rideRepo.findById(rideId)
        .orElseThrow(() -> new ResourceNotFoundException("Ride not found"));
    return ride.getStatus();
  }

  // ✅ Get driver info by driver ID
  public Driver getDriverById(Long id) {
    return driverRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Driver not found"));
  }

  // (Optional) Get all rides for admin or debugging
  public List<Ride> getAllRides() {
    return rideRepo.findAll();
  }
}
