package com.example.postgresdemo.controller;

import com.example.postgresdemo.component.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: ankoks
 * Date: 28/01/2019
 */
@RestController(value = "/math")
public class MathController {

    @Autowired
    private MathService service;

    @GetMapping(value = "/arithmetic/{n}")
//    @PreAuthorize(value = RoleConstants.HAS_AUTHORITY_USER)
    public int getSumm(@PathVariable("n") Integer n) {
        long before = System.nanoTime();
        int summ = service.arithmeticProgression(n);
        System.out.println("evaluate summ = " + (System.nanoTime() - before) + " ms");

        return summ;
    }
}
