package com.ng.geolocation.web.request;

import java.util.UUID;

/**
 * Simple value object used to define and provide access to request parameters for the /distanceByLocation endpoint
 */
public class GeoLocationDistanceByLocationRequest {
    private UUID fromGeoLocationId;
    private UUID toGeoLocationId;

    public UUID getFromGeoLocationId() {
        return fromGeoLocationId;
    }

    public void setFromGeoLocationId(UUID fromGeoLocationId) {
        this.fromGeoLocationId = fromGeoLocationId;
    }

    public UUID getToGeoLocationId() {
        return toGeoLocationId;
    }

    public void setToGeoLocationId(UUID toLocationId) {
        this.toGeoLocationId = toGeoLocationId;
    }
}
