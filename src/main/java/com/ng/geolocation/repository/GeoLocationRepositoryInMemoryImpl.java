package com.ng.geolocation.repository;

import java.util.*;

import com.ng.geolocation.domain.GeoLocation;
import org.springframework.stereotype.Repository;

/**
 * Repository implementation to provde access to the GeoLocation in memory Map.
 * TODO Think about exception handling and logging
 */
@Repository
public class GeoLocationRepositoryInMemoryImpl implements GeoLocationRepository {

    private final Map<UUID, GeoLocation> geolocations = new HashMap<>();

    /**
     * Add a GeoLocation to the repository
     * @param geoLocationId
     * @param geolocation
     */
    public void addGeoLocation(final UUID geoLocationId, final GeoLocation geolocation) {
        geolocations.put(geoLocationId, geolocation);
    }

    /**
     * Retrive all GeoLocations in the repository
     * @return a List of GeoLocations
     */
    public List<GeoLocation> getGeoLocations() {
        return new ArrayList(geolocations.values());
    }

    /**
     * Retrive a GeoLocation using it's locationId
     * @param geoLocationId
     * @return a GeoLocation object
     */
    public GeoLocation findById(final UUID geoLocationId) {
        return geolocations.get(geoLocationId);
    }
}
