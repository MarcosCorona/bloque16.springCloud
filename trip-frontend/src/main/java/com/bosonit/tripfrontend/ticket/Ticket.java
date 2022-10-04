package com.bosonit.tripfrontend.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Long id;
    private String passengerName;
    private String tripOrigin;
    private String tripDestination;
}
