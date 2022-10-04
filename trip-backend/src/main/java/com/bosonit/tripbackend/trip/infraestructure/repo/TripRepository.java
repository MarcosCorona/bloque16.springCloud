package com.bosonit.tripbackend.trip.infraestructure.repo;

import com.bosonit.tripbackend.trip.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

}
