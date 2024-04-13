package com.springmap.Association;

import com.springmap.Association.service.Servicejpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AssociationApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext con=SpringApplication.run(AssociationApplication.class, args);
		Servicejpa ser=con.getBean(Servicejpa.class);
 ser.save();
	}

}
