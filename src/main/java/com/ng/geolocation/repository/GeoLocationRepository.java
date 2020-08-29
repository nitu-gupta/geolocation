package com.ng.geolocation.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ng.geolocation.domain.GeoLocation;
import org.springframework.stereotype.Repository;

@Repository
public class GeoLocationRepository {

    private final List<GeoLocation> geolocations = new ArrayList<GeoLocation>();

    public void addGeoLocation(final GeoLocation geolocation) {
        geolocations.add(geolocation);
    }

    public List<GeoLocation> getGeoLocations() {
        return Collections.unmodifiableList(geolocations);
    }
}
