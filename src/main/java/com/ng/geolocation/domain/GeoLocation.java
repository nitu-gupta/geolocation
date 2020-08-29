package com.ng.geolocation.domain;

import java.io.Serializable;
import java.util.UUID;

public class GeoLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    private double latitude;
    private double longitude;
    private String locationName;
    private UUID locationId;

    public GeoLocation(final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationId = UUID.randomUUID();
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

    public UUID getLocationId() {
        return locationId;
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", locationName='" + locationName + '\'' +
                ", locationId=" + locationId +
                '}';
    }
}
