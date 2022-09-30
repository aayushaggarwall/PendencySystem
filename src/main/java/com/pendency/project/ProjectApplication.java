package com.pendency.project;

import com.pendency.project.service.PaymentTransactionService;
import com.pendency.project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan
public class ProjectApplication {

	@Autowired
	PaymentTransactionService paymentTransactionService;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@PostConstruct
	public void testMethod(){
//		PaymentTransactionService paymentTransactionService = new PaymentTransactionService();
		List<String> tagList = Arrays.asList("UPI", "Karnataka", "Bangalore");
		paymentTransactionService.startTracking(1112, tagList);
		paymentTransactionService.startTracking(2451, Arrays.asList("UPI", "Karnataka", "Mysore"));
		paymentTransactionService.startTracking(3421, Arrays.asList("UPI", "Rajasthan", "Jaipur"));
		paymentTransactionService.startTracking(1221, Arrays.asList("Wallet", "Karnataka", "Bangalore"));
    System.out.println("Answer: "+paymentTransactionService.getCounts(Arrays.asList("UPI")));
		System.out.println("Answer: "+paymentTransactionService.getCounts(Arrays.asList("UPI", "Karnataka")));
		System.out.println("Answer: "+paymentTransactionService.getCounts(Arrays.asList("UPI", "Karnataka", "Bangalore")));
		System.out.println("Answer: "+paymentTransactionService.getCounts(Arrays.asList("Bangalore")));
		paymentTransactionService.startTracking(4221, Arrays.asList("Wallet", "Karnataka", "Bangalore"));
		paymentTransactionService.stopTracking(1112);
		paymentTransactionService.stopTracking(2451);
		System.out.println("Answer: "+paymentTransactionService.getCounts(Arrays.asList("UPI")));
		System.out.println("Answer: "+paymentTransactionService.getCounts(Arrays.asList("Wallet")));
		System.out.println("Answer: "+paymentTransactionService.getCounts(Arrays.asList("UPI", "Karnataka", "Bangalore")));
//		Integer count = paymentTransactionService.getCounts(tagList);
//		paymentTransactionService.stopTracking(1112);
//    System.out.println(count);
	}
}
