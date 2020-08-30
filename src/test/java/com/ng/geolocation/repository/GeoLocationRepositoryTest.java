package com.ng.geolocation.repository;

import com.ng.geolocation.domain.GeoLocation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//TODO Create better unit tests using mocks with Mokito
public class GeoLocationRepositoryTest {

    private static GeoLocationRepository repository;

    @BeforeAll
    public static void init() {
        repository = new GeoLocationRepositoryInMemoryImpl();
    }

    @Test
    public void addGeoLocation() {
        GeoLocation geolocation = new GeoLocation(51.5073, -0.1277);
        repository.addGeoLocation(geolocation.getGeoLocationId(), geolocation);

        List<GeoLocation> allGeoLocations = repository.getGeoLocations();
        assertTrue(repository.getGeoLocations().contains(geolocation));
    }

    @Test
    public void getGeoLocations() {
        assertTrue(repository.getGeoLocations().size()>=0);
    }

    @Test
    public void findById() {
        GeoLocation geoLocation = new GeoLocation(51.5073, -0.1277);
        UUID locationId = geoLocation.getGeoLocationId();
        repository.addGeoLocation(geoLocation.getGeoLocationId(), geoLocation);

        GeoLocation retrievedGeoLocation = repository.findById(locationId);
        assertEquals(locationId, retrievedGeoLocation.getGeoLocationId());
    }
}