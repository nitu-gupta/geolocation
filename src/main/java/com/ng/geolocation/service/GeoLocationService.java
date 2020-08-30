package com.ng.geolocation.service;

import com.ng.geolocation.domain.GeoLocation;

import java.util.List;
import java.util.UUID;

public interface GeoLocationService {

    /**
     * Create a new GeoLocation and add it to the repository
     * @param geolocation
     * @return the geoLocationId created
     */
    public UUID create(final GeoLocation geolocation);

    /**
     * Retrieve all GeoLocations from the repository
     * @return a List of GeoLocations
     */
    public List<GeoLocation> findAll();

    /**
     * Calcualte the distance from one geolocation to another
     *
     * @param fromGeoLocation
     * @param toGeoLocation
     * @return the distance in miles between the two geolocations
     */
    public double getDistance(final GeoLocation fromGeoLocation, final GeoLocation toGeoLocation);

    /**
     * Calcuate the distance between two geolocations stored in the repository
     *
     * @param fromGeoLocationId
     * @param toGeoLocationId
     * @return the distance in miles between the two geolocations
     */
    public double getDistanceByLocation(final UUID fromGeoLocationId, final UUID toGeoLocationId);

    /**
     * Retrieve a geolocation stored in the repository
     *
     * @param geoLocationId
     * @return the geolocation from the repository
     */
    public GeoLocation findById(final UUID geoLocationId);
}
