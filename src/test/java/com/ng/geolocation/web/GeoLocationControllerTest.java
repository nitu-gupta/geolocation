package com.ng.geolocation.web;

import com.ng.geolocation.domain.GeoLocation;
import com.ng.geolocation.service.GeoLocationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//TODO implement unit tests

@WebMvcTest(GeoLocationController.class)
public class GeoLocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeoLocationService service;

    @Test
    public void create() {
    }

    @Test
    public void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    public void getDistance() {
    }

    @Test
    public void getDistanceByLocation() {
    }
}