package com.ng.geolocation.web;

import com.ng.geolocation.domain.GeoLocation;
import com.ng.geolocation.service.GeoLocationService;
import com.ng.geolocation.web.request.GeoLocationDistanceByLocationRequest;
import com.ng.geolocation.web.request.GeoLocationDistanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "/{locationId}", method = RequestMethod.GET, produces = "application/json")
    public GeoLocation findById(@PathVariable("locationId") UUID locationId) {
        return service.findById(locationId);
    }

    @RequestMapping(value = "/distance", method = RequestMethod.GET, produces = "application/json")
    public double getDistance(@RequestBody GeoLocationDistanceRequest distanceRequest) {
        final GeoLocation fromGeoLocation = new GeoLocation(distanceRequest.getFromLatitude(), distanceRequest.getFromLongitude());
        final GeoLocation toGeoLocation = new GeoLocation(distanceRequest.getToLatitude(), distanceRequest.getToLongitude());
        return service.getDistance(fromGeoLocation, toGeoLocation);
    }

    @RequestMapping(value = "/distanceByLocation", method = RequestMethod.GET, produces = "application/json")
    public double getDistanceByLocation(@RequestBody GeoLocationDistanceByLocationRequest distanceByLocationRequest) {
        return service.getDistanceByLocation(distanceByLocationRequest.getFromLocationId(), distanceByLocationRequest.getToLocationId());
    }
}
