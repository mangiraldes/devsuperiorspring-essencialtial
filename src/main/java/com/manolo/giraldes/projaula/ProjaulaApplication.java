package com.manolo.giraldes.projaula;


import com.manolo.giraldes.entities.Order;
import com.manolo.giraldes.services.FreightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.manolo.giraldes.services","com.manolo.giraldes.entities"})
public class ProjaulaApplication implements CommandLineRunner {

	@Autowired
	FreightServices freightServices;

	public static void main(String[] args) {
		SpringApplication.run(ProjaulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order(150.0,133,20,freightServices);
		System.out.println("Pedido código " + order.getCode() );
		System.out.println("Valot Total " + order.getNetAmountOrder() );



	}
}