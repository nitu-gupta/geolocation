package com.ng.geolocation.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.UUID;

import com.ng.geolocation.domain.GeoLocation;
import com.ng.geolocation.repository.GeoLocationRepository;
import com.ng.geolocation.util.GeoLocationDistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

//TODO Think about exception handling and logging

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private GeoLocationRepository repository;

    /**
     * Create a new GeoLocation and add it to the repository
     * @param geolocation
     * @return the geoLocationId created
     */
    @Override
    public UUID create(final GeoLocation geolocation) {
        repository.addGeoLocation(geolocation.getGeoLocationId(), geolocation);
        return geolocation.getGeoLocationId();
    }

    /**
     * Retrieve all GeoLocations from the repository
     * @return a List of GeoLocations
     */
    @Override
    public List<GeoLocation> findAll() {
        return repository.getGeoLocations();
    }

    /**
     * Retrieve all GeoLocations from the repository
     * @return a List of GeoLocations
     */
    @Override
    public GeoLocation findById(final UUID geoLocationId) {
        return repository.findById(geoLocationId);
    }

    /**
     * Calcualte the distance from one geolocation to another
     *
     * @param fromGeoLocation
     * @param toGeoLocation
     * @return the distance between the two geolocations
     */
    @Override
    public double getDistance(final GeoLocation fromGeoLocation, final GeoLocation toGeoLocation) {
        double fromLatitude = fromGeoLocation.getLatitude();
        double fromLongitude = fromGeoLocation.getLongitude();
        double toLatitude = toGeoLocation.getLatitude();
        double toLongitude = toGeoLocation.getLongitude();

        // Format results to 2 decimal places
        MathContext mathContext = new MathContext(5);
        double distance = GeoLocationDistanceCalculator.distance(fromLatitude, fromLongitude, toLatitude, toLongitude,"M");
        return new BigDecimal(distance,mathContext).doubleValue();
    }

    /**
     * Calcuate the distance between two geolocations stored in the repository
     *
     * @param fromGeoLocationId
     * @param toGeoLocationId
     * @return the distance between the two geolocations
     */
    @Override
    public double getDistanceByLocation(final UUID fromGeoLocationId, final UUID toGeoLocationId) {
        final GeoLocation fromLocation = repository.findById(fromGeoLocationId);
        final GeoLocation toLocation = repository.findById(toGeoLocationId);

        return getDistance(fromLocation, toLocation);

    }
}
