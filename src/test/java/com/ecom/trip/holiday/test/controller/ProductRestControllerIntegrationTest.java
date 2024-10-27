package com.ecom.trip.holiday.test.controller;

import com.ecom.trip.holiday.HolidayApplication;
import com.ecom.trip.holiday.bo.Product;
import com.ecom.trip.holiday.service.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = HolidayApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
// @TestPropertySource(locations = "classpath:application-integrationtest.properties")
@AutoConfigureTestDatabase
public class ProductRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private static ProductRepository productRepository;

   /* @After
    public void resetDb() {
        productRepository.deleteAll();
    }*/

    @Test
    @Ignore
    public void whenValidInput_thenCreateProduct() throws IOException, Exception {
        Product product = new Product(1,"product-1",100);
        mvc.perform(MockMvcRequestBuilders.post("/products").contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)));
                //List<Product> found = productRepository.findAll();
       // Assertions.assertThat(found).extracting(Product::getName).containsOnly("product-1");
        System.out.println("Success");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
