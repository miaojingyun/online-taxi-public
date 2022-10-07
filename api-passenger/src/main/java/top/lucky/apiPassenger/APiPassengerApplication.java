package top.lucky.apiPassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Jane
 * @date 2022/10/7, 15:39
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class APiPassengerApplication {
	public static void main(String[] args) {
		SpringApplication.run(APiPassengerApplication.class, args);
	}
}
