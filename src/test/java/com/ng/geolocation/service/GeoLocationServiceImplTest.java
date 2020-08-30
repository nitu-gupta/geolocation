package com.ng.geolocation.service;

import com.ng.geolocation.domain.GeoLocation;
import com.ng.geolocation.repository.GeoLocationRepository;
import com.ng.geolocation.service.GeoLocationService;
import com.ng.geolocation.service.GeoLocationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

//TODO Create better unit tests using mocks with Mokito
//TODO Create unit tests for Controller
public class GeoLocationServiceImplTest {

    @Autowired
    private GeoLocationService service;

    @MockBean
    private GeoLocationRepository repository;

    @Test
    @DisplayName("Test create")
    public void create() {

    }

/*    @Test
    public void findAll() {
        GeoLocationService service = new GeoLocationServiceImpl();
        service.create(new GeoLocation(51.5073,-0.1277));
        service.create(new GeoLocation(52.5073,-0.2277));
        service.create(new GeoLocation(53.5073,-0.3277));

        assertEquals(3, service.findAll().size());
    }*/

    /*@Test
    @DisplayName("Test findById Success")
    public void findById() {

        //Setup mock repository
        GeoLocation geoLocation = new GeoLocation(51.5073, -0.1277);
        doReturn(Optional.of(geoLocation)).when(repository).findById(geoLocation.getLocationId());

        // Execute the service call
        GeoLocation returnedGeoLocation = service.findById(geoLocation.getLocationId());

        // Assert the response
        assertTrue(!isNull(returnedGeoLocation));
        assertEquals(geoLocation.getLocationId(), returnedGeoLocation.getLocationId());

    }*/

    @Test
    public void getDistance() {
        // Format results to 2 decimal places
        MathContext mathContext = new MathContext(5);

        GeoLocation fromGeoLocation = new GeoLocation(51.5073, -0.1277);
        GeoLocation toGeoLocation = new GeoLocation(53.4793, -2.2479);

        GeoLocationService service = new GeoLocationServiceImpl();
        double distance = service.getDistance(fromGeoLocation, toGeoLocation);
        assertEquals(162.82, new BigDecimal(distance,mathContext).doubleValue());
    }
}