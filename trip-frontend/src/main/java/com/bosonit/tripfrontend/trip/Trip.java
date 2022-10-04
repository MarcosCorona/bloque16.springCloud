package com.bosonit.tripfrontend.trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private String tripOrigin;
    private String tripDestination;
}
