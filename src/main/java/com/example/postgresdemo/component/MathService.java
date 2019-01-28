package com.example.postgresdemo.component;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * User: ankoks
 * Date: 28/01/2019
 */
@Component
public class MathService {

    @Cacheable(value = "mycache", key="#n")
    public int arithmeticProgression(int n) {
        System.out.println("Executing evaluate progression");
        int summ = 0;
        for (int i = 0; i < n; i++) {
            summ += i;
        }

        return summ;
    }
}
