package com.ng.geolocation.repository;

import com.ng.geolocation.domain.GeoLocation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GeoLocationRepositoryTest {

    @Test
    public void addGeoLocation() {
        GeoLocation geolocation = new GeoLocation(51.5073, -0.1277);
        GeoLocationRepository repository = new GeoLocationRepositoryInMemoryImpl();
        repository.addGeoLocation(geolocation.getLocationId(), geolocation);

        List<GeoLocation> allGeoLocations = repository.getGeoLocations();
        assertEquals(1, allGeoLocations.size());
        assertTrue(repository.getGeoLocations().contains(geolocation));
    }

    @Test
    public void getGeoLocations() {
        GeoLocationRepository repository = new GeoLocationRepositoryInMemoryImpl();
        assertNotNull(repository.getGeoLocations());
    }
}