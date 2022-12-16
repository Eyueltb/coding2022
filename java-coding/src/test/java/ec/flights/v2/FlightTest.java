package ec.flights.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {
    private Passenger ermi;
    private Passenger eyu;
    private Flight economy;
    private Flight business;
    private Flight premium;
    @BeforeEach
    void setUp() {
        ermi = new Passenger("ermi", true);
        eyu = new Passenger("eyu", false);

        economy = new EconomyFlight();
        business = new BusinessFlight();
        premium = new PremiumFlight();
    }
    @Nested
    @DisplayName("Given economy flight")
    class EconomyFlightTest {
        @DisplayName("For Non-vip flight")
        @Test
        public void testEconomyFlightNonVIPPassenger() {
            assertAll("Verify all conditions for a non-vip passenger and an economy flight",
                    () -> assertTrue( economy.add(eyu)),
                    () -> assertEquals(1, economy.getPassengers().size()),
                    () -> assertEquals("eyu", economy.getPassengers().get(0).getName()),
                    ()->assertTrue(economy.remove(eyu)),
                    () -> assertEquals(0, economy.getPassengers().size())
            );
        }
        @DisplayName("For Vip flight")
        @Test
        public void testEconomyFlightVIPPassenger() {
            assertAll("Verify all conditions for vip and an economy flight",
                    () -> assertTrue( economy.add(ermi)),
                    () -> assertEquals(1, economy.getPassengers().size()),
                    () -> assertEquals("ermi", economy.getPassengers().get(0).getName()),
                    ()->assertFalse(economy.remove(ermi)),
                    () -> assertEquals(1, economy.getPassengers().size())
            );
        }
    }

    @Nested
    @DisplayName("Given Business flight")
    class BusinessFlightTest {
        @DisplayName("For Non-vip flight")
        @Test
        public void testBusinessFlightNonVIPPassenger() {
            assertAll("Verify all conditions for a non-vip passenger and an business flight",
                    () -> assertFalse( business.add(eyu)),
                    () -> assertEquals(0, business.getPassengers().size()),
                    ()->assertFalse(business.remove(eyu)),
                    () -> assertEquals(0, business.getPassengers().size())
            );
        }
        @DisplayName("For Vip flight")
        @Test
        public void testBusinessFlightVIPPassenger() {
            assertAll("Verify all conditions for VIP and an business flight",
                    () -> assertTrue( business.add(ermi)),
                    () -> assertEquals(1, business.getPassengers().size()),
                    () -> assertEquals("ermi", business.getPassengers().get(0).getName()),
                    ()->assertFalse(business.remove(ermi)),
                    () -> assertEquals(1, business.getPassengers().size())
            );
        }
    }
    @Nested
    @DisplayName("Given Premium flight")
    class PremiumFlightTest {
        @DisplayName("For Non-vip flight")
        @Test
        public void testPremiumFlightNonVIPPassenger() {
            assertAll("Verify all conditions for a Non-VIP and an Premium flight",
                    () -> assertFalse( premium.add(eyu)),
                    () -> assertEquals(0, premium.getPassengers().size()),
                    ()->assertFalse(premium.remove(eyu)),
                    () -> assertEquals(0, premium.getPassengers().size())
            );
        }
        @DisplayName("For Vip flight")
        @Test
        public void testPremiumFlightVIPPassenger() {
            assertAll("Verify all conditions for vip and an Premium flight",
                    () -> assertTrue(premium.add(ermi)),
                    () -> assertEquals(1, premium.getPassengers().size()),
                    () -> assertEquals("ermi", premium.getPassengers().get(0).getName()),
                    ()->assertTrue(premium.remove(ermi)),
                    () -> assertEquals(0, premium.getPassengers().size())
            );
        }
    }
}
