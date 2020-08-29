package com.ng.geolocation.service;

import com.ng.geolocation.domain.GeoLocation;
import com.ng.geolocation.service.GeoLocationService;
import com.ng.geolocation.service.GeoLocationServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.*;

public class GeoLocationServiceImplTest {

    @Test
    public void create() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void getDistance() {
        // Format results to 2 decimal places
        MathContext mathContext = new MathContext(5);

        GeoLocationService service = new GeoLocationServiceImpl();
        GeoLocation fromGeoLocation = new GeoLocation(51.5073, -0.1277);
        GeoLocation toGeoLocation = new GeoLocation(53.4793, -2.2479);

        //GeoLocation fromGeoLocation = new GeoLocation(51.5073, -0.1277,"Home");
        //GeoLocation toGeoLocation = new GeoLocation(53.4793, -2.2479,"Work");

        double distance = service.getDistance(fromGeoLocation, toGeoLocation);
        assertEquals(162.82, new BigDecimal(distance,mathContext).doubleValue());
    }
}