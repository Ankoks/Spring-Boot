package com.example.postgresdemo.controller;

import com.example.postgresdemo.component.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: ankoks
 * Date: 28/01/2019
 */
@RestController
public class MathController {

    @Autowired
    private MathService service;

    @GetMapping(value = "/arithmetic")
    public int getSumm() {
        long before = System.nanoTime();
        int summ = service.arithmeticProgression(100);
        System.out.println("evaluate summ = " + (System.nanoTime() - before) + " ms");

        return summ;
    }
}
