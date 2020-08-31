package com.ng.geolocation;

import com.ng.geolocation.web.GeoLocationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GeoLocationApplicationTests {

	@Autowired
	private GeoLocationController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
