package top.lucky.serviceVerification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jane
 * @date 2022/10/7, 19:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceVerificationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceVerificationApplication.class, args);
	}
}
