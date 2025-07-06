package com.examplejride.jride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplejride.jride.model.Driver;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByAvailabilityStatus(String status);
}
