package com.examplejride.jride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplejride.jride.model.Ride;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByPassengerId(Long passengerId);

    List<Ride> findByDriverId(Long driverId);
}
