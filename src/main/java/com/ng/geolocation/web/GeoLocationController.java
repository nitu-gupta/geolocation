package com.ng.geolocation.web;

import com.ng.geolocation.domain.GeoLocation;
import com.ng.geolocation.service.GeoLocationService;
import com.ng.geolocation.web.request.GeoLocationDistanceByLocationRequest;
import com.ng.geolocation.web.request.GeoLocationDistanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//TODO Think about exception handling and logging
//TODO Implement a DELETE method to delete a geolocation from the repository
//TODO Create API documentation using OAS 3.0

@RestController
@RequestMapping("/geolocation")
public class GeoLocationController {
    @Autowired
    private GeoLocationService service;

    /**
     * Create a new GeoLocation and add it to the repository
     * @param geolocation
     * @return the geoLocationId created
     *
     * Sample request
     *  curl -H "Content-Type: application/json" -X POST -d'{"latitude": 51.5073, "longitude": -0.1277, "locationName":"Home"}' http://localhost:8080/geolocation
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public UUID create(@RequestBody GeoLocation geolocation) {
        return service.create(geolocation);
    }

    /**
     * Retrieve all GeoLocations from the repository
     * @return a List of GeoLocations
     *
     * Sample request
     * curl http://localhost:8080/geolocation
     *
     * TODO Returning the GeoLocation domain model here tightly couples the domain with the HTTP Response.  Refactor HTTP Response into a new object.
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GeoLocation> findAll() {
        return service.findAll();
    }

    /**
     * Retrieve a geolocation stored in the repository
     * @param locationId
     * @return the geolocation from the repository
     *
     * Sample request (replace UUID
     * curl http://localhost:8080/geolocation/{50352911-61e9-4700-96a1-4cc325098b48}
     *
     * TODO Returning the GeoLocation domain model here tightly couples the domain with the HTTP Response.  Refactor HTTP Response into a new object.
     */
    @RequestMapping(value = "/{locationId}", method = RequestMethod.GET, produces = "application/json")
    public GeoLocation findById(@PathVariable("locationId") UUID locationId) {
        return service.findById(locationId);
    }

    /**
     * Calcualte the distance from one geolocation to another
     * @param distanceRequest
     * @return the distance in miles
     *
     * Sample request
     *  curl -H "Content-Type: application/json" -X GET -d'{"fromLatitude": 51.5073, "fromLongitude": -0.1277, "toLatitude": 53.4793, "toLongitude": -2.2479}' http://localhost:8080/geolocation/distance
     */
    @RequestMapping(value = "/distance", method = RequestMethod.GET, produces = "application/json")
    public double getDistance(@RequestBody GeoLocationDistanceRequest distanceRequest) {
        final GeoLocation fromGeoLocation = new GeoLocation(distanceRequest.getFromLatitude(), distanceRequest.getFromLongitude());
        final GeoLocation toGeoLocation = new GeoLocation(distanceRequest.getToLatitude(), distanceRequest.getToLongitude());
        return service.getDistance(fromGeoLocation, toGeoLocation);
    }

    /**
     * Calcuate the distance between two geolocations stored in the repository
     * @param distanceByLocationRequest
     * @return the distance in miles
     *
     * Sample request (replace UUID)
     * curl -H "Content-Type: application/json" -X GET -d'{"fromGeoLocationId": "50352911-61e9-4700-96a1-4cc325098b48", "toGeoLocationId": "b9da367c-7eda-4189-9f53-fa6314bc86c0"}' http://localhost:8080/geolocation/distanceByLocation
     */
    @RequestMapping(value = "/distanceByLocation", method = RequestMethod.GET, produces = "application/json")
    public double getDistanceByLocation(@RequestBody GeoLocationDistanceByLocationRequest distanceByLocationRequest) {
        return service.getDistanceByLocation(distanceByLocationRequest.getFromGeoLocationId(), distanceByLocationRequest.getToGeoLocationId());
    }
}
