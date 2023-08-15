package processes;

import dataGenerator.datatypes.TaxiRide;
import dataGenerator.utils.GeoUtils;
import org.apache.flink.api.common.functions.FilterFunction;
public class NYCFilter implements FilterFunction<TaxiRide> {
    @Override
    public boolean filter(TaxiRide taxiRide) throws Exception {
        return GeoUtils.isInNYC(taxiRide.getStartLon(), taxiRide.getStartLat()) && GeoUtils.isInNYC(taxiRide.getEndLon(), taxiRide.getEndLat());
    }
}
