package com.manolo.giraldes.services;

import org.springframework.stereotype.Service;

@Service
public class FreightServices {

    public double amountTax(double amount) {
        double tax = 0.0;

        if (amount < 100.0)
            tax = 20.0;
        else if (amount >= 100 && amount < 200.0)
            tax = 12.0;

        return tax;

    }

    public FreightServices() {
    }
}