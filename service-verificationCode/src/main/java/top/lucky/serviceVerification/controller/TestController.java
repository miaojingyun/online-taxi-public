package top.lucky.serviceVerification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jane
 * @date 2022/10/7, 20:01
 */
@RestController
public class TestController {
	@GetMapping("test")
	public String test() {
		return "test";
	}
}
