package ec.flights.v1;

import junit.framework.TestCase;

import org.junit.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest extends TestCase {
    private  Passenger ermi;
    private Passenger eyu;
    private Flight economy;
    private Flight business;
    private Flight premium;

    @BeforeEach
    public void setUp() {
        ermi = new Passenger("ermi", true);
        eyu = new Passenger("eyu", false);

        economy = new Flight(FlightType.Economy);
        business = new Flight(FlightType.Business);
        premium = new Flight(FlightType.Premium);
    }

    @DisplayName("Given economy flight")
    @Test
    public void testEconomyForNonVIP() {
        assertAll("Verify all condition for Non-vip passenger",
                () -> assertTrue( economy.add(eyu)),
                () -> assertEquals(1, economy.getPassengers().size()),
                () -> assertEquals("eyu", economy.getPassengers().get(0).getName()),
                () -> assertTrue(economy.remove(eyu)),
                () -> assertEquals(0, economy.getPassengers().size())
        );
    }
    @Test
    @DisplayName("Given economy flight")
    public void testEconomyForVIP(){
        //add
        assertAll("Verify all condition for Non-vip passenger",
                () -> assertTrue( economy.add(ermi)),
                () -> assertEquals(1, economy.getPassengers().size()),
                () -> assertEquals("ermi", economy.getPassengers().get(0).getName()),
                () -> assertFalse(economy.remove(ermi)),
                () -> assertEquals(1, economy.getPassengers().size())
        );
    }

    @Test
    @DisplayName("Given Business flight")
    public void testBusinessForNonVIP() {
        assertAll("Verify all condition for Non-vip passenger",
                //add
                () -> assertFalse(business.add(eyu)),// non vip
                () -> assertEquals(0, business.getPassengers().size()),
                // remove
                () -> assertFalse(business.remove(eyu)),
                () -> assertEquals(0, business.getPassengers().size())
        );
    }
    @Test
    @DisplayName("Given Business flight")
    public void testBusinessForVIP() {
        assertAll("Verify all condition for VIP passenger",
                //add
                () -> assertTrue(business.add(ermi)),//  vip
                () -> assertEquals(1, business.getPassengers().size()),
                () -> assertEquals("ermi", business.getPassengers().get(0).getName()),
                //remove
                () -> assertFalse(business.remove(ermi)),
                () -> assertEquals(1, business.getPassengers().size()),
                () -> assertEquals("ermi", business.getPassengers().get(0).getName())
        );
    }
    @Test
    @DisplayName("Given Premium flight")
    public void testPremiumForNonVIP() {
        assertAll("Verify all condition for Non-vip passenger",
                //add
                () -> assertFalse(premium.add(eyu)),
                () -> assertEquals(0, premium.getPassengers().size()),
                //remove
                () -> assertFalse(premium.remove(eyu)),
                () -> assertEquals(0, premium.getPassengers().size())
        );

    }
    @Test
    @DisplayName("Given Premium flight")
    public void testPremiumForVIP() {
        assertAll("Verify all condition for VIP passenger",
                //add
                () -> assertTrue(premium.add(ermi)),
                () -> assertEquals(1, premium.getPassengers().size()),
                () -> assertEquals("ermi", premium.getPassengers().get(0).getName()),
                //remove
                () -> assertTrue(premium.remove(ermi)),
                () -> assertEquals(0, premium.getPassengers().size())
        );
    }
}
