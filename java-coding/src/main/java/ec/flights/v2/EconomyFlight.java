package ec.flights.v2;

public class EconomyFlight extends Flight {
    @Override
    public boolean add(Passenger passenger) {
        return passengers.add(passenger);
    }

    @Override
    public boolean remove(Passenger passenger) {
        if(!passenger.isVip())
            return passengers.remove(passenger);
        return false;
    }
}
