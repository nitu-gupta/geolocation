package com.ng.geolocation.web;

import com.ng.geolocation.domain.GeoLocation;
import com.ng.geolocation.service.GeoLocationService;
import com.ng.geolocation.web.request.GeoLocationDistanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/geolocation")
public class GeoLocationController {
    @Autowired
    private GeoLocationService service;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public GeoLocation create(@RequestBody GeoLocation geolocation) {
        return service.create(geolocation);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GeoLocation> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/distance", method = RequestMethod.GET, produces = "application/json")
    public double getDistance(@RequestBody GeoLocationDistanceRequest distanceRequest) {
        final GeoLocation fromGeoLocation = new GeoLocation(distanceRequest.getFromLatitude(), distanceRequest.getFromLongitude());
        final GeoLocation toGeoLocation = new GeoLocation(distanceRequest.getToLatitude(), distanceRequest.getToLongitude());
        return service.getDistance(fromGeoLocation, toGeoLocation);
    }
}
