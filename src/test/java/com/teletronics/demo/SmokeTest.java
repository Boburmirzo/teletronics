package com.teletronics.demo;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teletronics.demo.controller.ProjectDetailsController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private ProjectDetailsController projectDetailsController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(projectDetailsController).isNotNull();
    }
}