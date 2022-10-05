package com.bosonit.tripfrontend.ticket;

import com.bosonit.tripfrontend.client.User;
import com.bosonit.tripfrontend.ticket.feign.TicketFeignProxy;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Objects;

@RestController
@Component
public class TicketController {
    /*@Autowired
    TicketFeignProxy proxy;*/

    @PostMapping("/generateTicket/{tripId}/{userId}")
    public Ticket generateTicket(@PathVariable Long tripId, @PathVariable Long userId){

        HashMap<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("tripId",tripId);
        uriVariables.put("userId",userId);

        ResponseEntity<User> userEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/user/{userId}", User.class, uriVariables);

        User userResponse = userEntity.getBody();



        assert userResponse != null;
        System.out.println(userResponse.getName());
        return new Ticket(1L,userResponse.getName(),"vitoria","logroño");
    }
}
