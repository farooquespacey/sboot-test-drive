package com.spacey.springboot.error;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	
//	@RequestMapping("/error")
	public String throwGenericError() {
		return "You cannot misuse the app";
	}
}
