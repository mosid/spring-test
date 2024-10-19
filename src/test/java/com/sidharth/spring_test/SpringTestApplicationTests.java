package com.sidharth.spring_test;

import com.sidharth.spring_test.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringTestApplicationTests {

	@Autowired
	private HomeController homeController;

	@Test
	void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}


}
