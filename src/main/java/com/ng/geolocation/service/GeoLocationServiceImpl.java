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

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private GeoLocationRepository repository;

    @Override
    public GeoLocation create(final GeoLocation geolocation) {
        repository.addGeoLocation(geolocation.getLocationId(), geolocation);
        return geolocation;
    }

    @Override
    public List<GeoLocation> findAll() {
        return repository.getGeoLocations();
    }

    @Override
    public GeoLocation findById(final UUID locationId) {
        return repository.findById(locationId);
    }

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

    @Override
    public double getDistanceByLocation(final UUID fromLocationId, final UUID toLocationId) {
        final GeoLocation fromLocation = repository.findById(fromLocationId);
        final GeoLocation toLocation = repository.findById(toLocationId);

        return getDistance(fromLocation, toLocation);

    }
}
