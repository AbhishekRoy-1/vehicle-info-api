package io.nirmitee.roy.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nirmitee.roy.workshop.entities.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

}
