package ec.flights.v2;

public class PremiumFlight extends Flight {
    @Override
    public boolean add(Passenger passenger) {
        if(passenger.isVip())
            return passengers.add(passenger);
        return false;
    }

    @Override
    public boolean remove(Passenger passenger) {
        return passengers.remove(passenger);
    }
}
