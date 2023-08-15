package jobs;

import dataGenerator.datatypes.TaxiRide;
import org.junit.jupiter.api.Test;
import processes.NYCFilter;
import testBases.RideCleansingJobTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RideCleansingJobTest extends RideCleansingJobTestBase {
    public NYCFilter filterFunction = new NYCFilter();
    @Test
    public void testRideThatStartsAndEndsInNYC() throws Exception {

        TaxiRide atPennStation = testRide(-73.9947F, 40.750626F, -73.9947F, 40.750626F);
        assert(filterFunction.filter(atPennStation));
    }

    @Test
    public void testRideThatStartsOutsideNYC() throws Exception {

        TaxiRide fromThePole = testRide(0, 90, -73.9947F, 40.750626F);
        assert(!filterFunction.filter(fromThePole));
    }

    @Test
    public void testRideThatEndsOutsideNYC() throws Exception {

        TaxiRide toThePole = testRide(-73.9947F, 40.750626F, 0, 90);
        assert(!filterFunction.filter(toThePole));
    }

    @Test
    public void testRideThatStartsAndEndsOutsideNYC() throws Exception {

        TaxiRide atNorthPole = testRide(0, 90, 0, 90);
        assert(!filterFunction.filter(atNorthPole));
    }
}
