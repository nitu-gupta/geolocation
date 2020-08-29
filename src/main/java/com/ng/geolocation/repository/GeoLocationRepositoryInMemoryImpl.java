package com.ng.geolocation.repository;

import java.util.*;

import com.ng.geolocation.domain.GeoLocation;
import org.springframework.stereotype.Repository;

@Repository
public class GeoLocationRepositoryInMemoryImpl implements GeoLocationRepository {

    /*private final List<GeoLocation> geolocations = new ArrayList<GeoLocation>();

    public void addGeoLocation(final GeoLocation geolocation) {
        geolocations.add(geolocation);
    }

    public List<GeoLocation> getGeoLocations() {
        return Collections.unmodifiableList(geolocations);
    }*/

    private final Map<UUID, GeoLocation> geolocations = new HashMap<>();

    public void addGeoLocation(final UUID locationId, final GeoLocation geolocation) {
        geolocations.put(locationId, geolocation);
    }

    public List<GeoLocation> getGeoLocations() {
        return new ArrayList(geolocations.values());
    }

    public GeoLocation findById(UUID locationId) {
        return geolocations.get(locationId);
    }
}
