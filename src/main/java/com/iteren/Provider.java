package com.iteren;

import org.springframework.stereotype.Component;

@Component
public class Provider {
    private String name = "Ihor";

    public String methA() {
        System.out.println("Inside methA...");
        return "methA";
    }

    public String methB() {
        System.out.println("Inside methB...");
        return "methA";
    }

    public String methC() {
        System.out.println("Inside methC...");
        return "methA";
    }
}
