package com.ng.geolocation.repository;

import com.ng.geolocation.domain.GeoLocation;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface to provde access to the GeoLocation datastore repository.
 */
public interface GeoLocationRepository {

    /**
     * Add a GeoLocation to the repository
     * @param geoLocationId
     * @param geolocation
     */

    public void addGeoLocation(final UUID geoLocationId, final GeoLocation geolocation);

    /**
     * Retrive all GeoLocations in the repository
     * @return a List of GeoLocations
     */
    public List<GeoLocation> getGeoLocations();

    /**
     * Retrive a GeoLocation using it's locationId
     * @param geoLocationId
     * @return a GeoLocation object
     */
    public GeoLocation findById(final UUID geoLocationId);
}
