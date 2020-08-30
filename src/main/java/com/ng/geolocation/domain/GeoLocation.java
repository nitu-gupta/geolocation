package com.ng.geolocation.domain;

import java.io.Serializable;
import java.util.UUID;

/**
 * POJO representing the GeoLocation domain object.
 */
public class GeoLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID geoLocationId;
    private String locationName;
    private double latitude;
    private double longitude;

    public GeoLocation(final double latitude, final double longitude) {
        this.geoLocationId = UUID.randomUUID(); //@TODO move creation of this to the repository
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public UUID getGeoLocationId() {
        return geoLocationId;
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "geoLocationId=" + geoLocationId +
                ", locationName='" + locationName +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
