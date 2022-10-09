package top.lucky.servicePassengerUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Jane
 * @date 2022/10/9, 10:24
 */
@SpringBootApplication
@MapperScan("top.lucky.servicePassengerUser.mapper")
public class ServicePassengerUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServicePassengerUserApplication.class, args);
	}
}
