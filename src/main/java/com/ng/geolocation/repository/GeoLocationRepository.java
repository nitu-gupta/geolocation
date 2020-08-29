package com.ng.geolocation.repository;

import com.ng.geolocation.domain.GeoLocation;

import java.util.List;
import java.util.UUID;

public interface GeoLocationRepository {

    public void addGeoLocation(final UUID locationId, final GeoLocation geolocation);
    public List<GeoLocation> getGeoLocations();
    public GeoLocation findById(UUID locationId);
}
