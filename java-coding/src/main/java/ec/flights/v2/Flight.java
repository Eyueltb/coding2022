package ec.flights.v2;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Flight {
    protected Set<Passenger> passengers;
    public Flight() {
        this.passengers = new HashSet<>();
    }
    public abstract boolean add(Passenger passenger);
    public abstract boolean remove(Passenger passenger);

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers.stream().toList());
    }
}
