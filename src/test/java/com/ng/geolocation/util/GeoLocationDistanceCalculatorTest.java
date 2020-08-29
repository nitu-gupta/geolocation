package com.ng.geolocation.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoLocationDistanceCalculatorTest {

    @Test
    public void testDistance() {

        // Format results to 2 decimal places
        MathContext mathContext = new MathContext(5);

        double distInMiles = GeoLocationDistanceCalculator.distance(32.9697, -96.80322, 29.46786, -98.53506, "M");
        assertEquals(262.68,new BigDecimal(distInMiles,mathContext).doubleValue());

        double distInKM = GeoLocationDistanceCalculator.distance(32.9697, -96.80322, 29.46786, -98.53506, "K");
        assertEquals(422.74,new BigDecimal(distInKM,mathContext).doubleValue());

        double distInNauticalMiles = GeoLocationDistanceCalculator.distance(32.9697, -96.80322, 29.46786, -98.53506, "N");
        assertEquals(228.11, new BigDecimal(distInNauticalMiles,mathContext).doubleValue());

    }
}