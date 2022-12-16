package ec.flights.v0;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Passenger {

    private String name;
    private boolean isVip;
}
