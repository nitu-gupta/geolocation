package com.ng.geolocation.web.request;

public class GeoLocationDistanceRequest {

    private double fromLatitude;
    private double fromLongitude;
    private double toLatitude;
    private double toLongitude;
    private String locationName;

    public GeoLocationDistanceRequest(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude) {
        this.fromLatitude = fromLatitude;
        this.fromLongitude = fromLongitude;
        this.toLatitude = toLatitude;
        this.toLongitude = toLongitude;
    }

    public GeoLocationDistanceRequest(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude, String locationName) {
        this(fromLatitude, fromLongitude, toLatitude, toLongitude);
        this.locationName = locationName;
    }

    public double getFromLatitude() {
        return fromLatitude;
    }

    public double getFromLongitude() {
        return fromLongitude;
    }

    public double getToLatitude() {
        return toLatitude;
    }

    public double getToLongitude() {
        return toLongitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setFromLatitude(double fromLatitude) {
        this.fromLatitude = fromLatitude;
    }

    public void setFromLongitude(double fromLongitude) {
        this.fromLongitude = fromLongitude;
    }

    public void setToLatitude(double toLatitude) {
        this.toLatitude = toLatitude;
    }

    public void setToLongitude(double toLongitude) {
        this.toLongitude = toLongitude;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
