package com.bosonit.tripfrontend.ticket.feign;

import com.bosonit.tripfrontend.client.User;
import com.bosonit.tripfrontend.ticket.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="trip-backend")
public interface TicketFeignProxy {
    @GetMapping("/back/user/{userId}")
    User retrieveUser(@PathVariable Long userId);
}
