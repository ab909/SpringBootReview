package com.springreview.SpringBootReview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    Greeting greeting;

    AtomicLong atomicLong = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name")String name){


        greeting.setId(atomicLong.incrementAndGet());
        greeting.setContent("Hey, I'm doing a spring boot test " + name);

        return greeting;


    }
}
