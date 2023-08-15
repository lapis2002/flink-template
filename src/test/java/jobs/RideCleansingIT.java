package jobs;

import dataGenerator.datatypes.TaxiRide;
import org.apache.flink.runtime.testutils.MiniClusterResourceConfiguration;
import org.apache.flink.test.util.MiniClusterWithClientResource;
import org.junit.Test;
import testBases.RideCleansingJobTestBase;
import org.junit.ClassRule;

public class RideCleansingIT extends RideCleansingJobTestBase {
    private static final int PARALLELISM = 2;

    @ClassRule
    public static MiniClusterWithClientResource flinkCluster =
            new MiniClusterWithClientResource(
                    new MiniClusterResourceConfiguration.Builder()
                            .setNumberSlotsPerTaskManager(PARALLELISM)
                            .setNumberTaskManagers(1)
                            .build());

    @Test
    public void testAMixtureOfLocations() throws Exception {

        TaxiRide toThePole = testRide(-73.9947F, 40.750626F, 0, 90);
        TaxiRide fromThePole = testRide(0, 90, -73.9947F, 40.750626F);
        TaxiRide atPennStation = testRide(-73.9947F, 40.750626F, -73.9947F, 40.750626F);
        TaxiRide atNorthPole = testRide(0, 90, 0, 90);
        CollectSink.values.clear();
//        ParallelTestSource<TaxiRide> source =
//                new ParallelTestSource<>(toThePole, fromThePole, atPennStation, atNorthPole);
//        TestSink<TaxiRide> sink = new TestSink<>();

//        JobExecutionResult jobResult = rideCleansingPipeline().execute(source, sink);
//        assertThat(sink.getResults(jobResult)).containsExactly(atPennStation);
    }
}
