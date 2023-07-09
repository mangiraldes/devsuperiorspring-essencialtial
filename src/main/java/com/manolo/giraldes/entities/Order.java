package com.manolo.giraldes.entities;

import com.manolo.giraldes.services.FreightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Order {
    private double totalAmountOrder;
    private double netAmountOrder;
    private int code;
    private double discount;

    private FreightServices freightServices;

    public Order(double totalAmountOrder, int code, int discount,FreightServices freightServices) {
        this.totalAmountOrder = totalAmountOrder;
        this.code = code;
        this.discount = discount;
        this.freightServices = freightServices;
    }

    public double getTotalAmountOrder() {
        return totalAmountOrder;
    }

    public double getNetAmountOrder() {
        calcNetAmountOrder();
        return this.netAmountOrder;

    }

    private void calcNetAmountOrder() {
        double freightOrder = freightServices.amountTax(this.totalAmountOrder);
        this.netAmountOrder = this.totalAmountOrder - calcDiscountFromOrder() + freightOrder;
    }

    private double calcDiscountFromOrder(){

        return this.totalAmountOrder * this.getDiscount();

    }

    public void setTotalAmountOrder(double totalAmountOrder) {
        this.totalAmountOrder = totalAmountOrder;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getDiscount() {
        return (this.discount/100);
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


}