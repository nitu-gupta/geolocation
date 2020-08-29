package com.ng.geolocation.service;

import com.ng.geolocation.domain.GeoLocation;

import java.util.List;
import java.util.UUID;

public interface GeoLocationService {

    public GeoLocation create(final GeoLocation geolocation);
    public List<GeoLocation> findAll();
    public double getDistance(final GeoLocation fromGeoLocation, final GeoLocation toGeoLocation);
    public double getDistanceByLocation(final UUID fromLocationId, final UUID toLocationId);
    public GeoLocation findById(final UUID locationId);
}
