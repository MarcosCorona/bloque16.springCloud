package com.bosonit.tripfrontend.ticket;

import com.bosonit.tripfrontend.client.User;
import com.bosonit.tripfrontend.trip.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
public class TicketController {
    @GetMapping("/generateTicket/{tripId}/{userId}")
    public Ticket generateTicket(@PathVariable Long tripId, @PathVariable Long userId){
        ResponseEntity<User> user = new RestTemplate().getForEntity("/user/{userId}", User.class);
        ResponseEntity<Trip> trip = new RestTemplate().getForEntity("/trip/{tripId}", Trip.class);

        Ticket trueTicket = new Ticket();
        trueTicket.setPassengerName(Objects.requireNonNull(user.getBody()).getName());
        trueTicket.setTripOrigin("vitoria");
        trueTicket.setTripDestination(Objects.requireNonNull(trip.getBody()).getTripDestination());

        return null;
    }
}
