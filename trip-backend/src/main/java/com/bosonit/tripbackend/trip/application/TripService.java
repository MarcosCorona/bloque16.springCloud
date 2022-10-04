package com.bosonit.tripbackend.trip.application;

import com.bosonit.tripbackend.trip.domain.Trip;
import com.bosonit.tripbackend.trip.exception.TripException;
import com.bosonit.tripbackend.trip.infraestructure.repo.TripRepository;
import com.bosonit.tripbackend.user.domain.User;
import com.bosonit.tripbackend.user.infraestructure.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    TripRepository tripRepository;

    @Autowired
    UserRepo userRepository;

    public List<Trip> getTrips(){
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long tripId){
        return tripRepository.findById(tripId);
    }

    public Trip addTrip(Trip newTrip){
        return tripRepository.save(newTrip);
    }

    public Trip addUserToTrip(Long userId, Long tripId){
        Trip tripFetched = tripRepository.findById(tripId).orElseThrow(() -> new TripException("Trip by id " + tripId + " doesn't exists."));
        if(countOfPassengers(tripFetched.getTripId()) <= 40){
            tripFetched.getPassengers().add(new User(userRepository.findById(userId)));
        }else{
            throw new TripException("Can't fit more passengers");
        }
        return tripRepository.save(tripFetched);
    }

    public int countOfPassengers(Long tripId){
        Optional<Trip> tripFetched = getTripById(tripId);
        return tripFetched.map(trip -> trip.getPassengers().size()).orElse(0);
    }



    public void deleteTrip(Long travelId){
        tripRepository.deleteById(travelId);
    }

    public Trip updateTrip(Trip tripUpdated){
        return tripRepository.save(tripUpdated);
    }

    public List<Trip> checkTripAvailable(String destination, LocalDate date, Time time) {
        List<Trip> tripsAvailable = new ArrayList<>();
        for (Trip trip : getTrips())
        {
            if(trip.getDestination().equals(destination)
            && trip.getDate().equals(date)
            && trip.getTime().equals(time)){
                tripsAvailable.add(trip);
            }
        }
        return tripsAvailable;
    }
}
