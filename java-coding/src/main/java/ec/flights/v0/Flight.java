package ec.flights.v0;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Flight {
    private FlightType flightType;
    private Set<Passenger> passengers;

    public Flight(FlightType flightType) {
        this.flightType = flightType;
        this.passengers = new HashSet<>();
    }

    public boolean add(Passenger passenger) {
        if(flightType.equals(FlightType.Economy) || passenger.isVip() ){
            return passengers.add(passenger);
        }
        return false;
    }
    public boolean remove(Passenger passenger) {
        if(!passenger.isVip() || flightType.equals(FlightType.Premium))
            return passengers.remove(passenger);
        return false;

    }
    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers.stream().toList());
    }
}
