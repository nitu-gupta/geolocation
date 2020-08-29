package com.ng.geolocation.web.request;

import java.util.UUID;

/**
 * Simple value object used to define and provide access to request parameters for the /distanceByLocation enpoint
 */
public class GeoLocationDistanceByLocationRequest {
    private UUID fromLocationId;
    private UUID toLocationId;

    public UUID getFromLocationId() {
        return fromLocationId;
    }

    public void setFromLocationId(UUID fromLocationId) {
        this.fromLocationId = fromLocationId;
    }

    public UUID getToLocationId() {
        return toLocationId;
    }

    public void setToLocationId(UUID toLocationId) {
        this.toLocationId = toLocationId;
    }
}
