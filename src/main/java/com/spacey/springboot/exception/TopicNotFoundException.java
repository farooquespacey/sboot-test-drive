package com.spacey.springboot.exception;

public class TopicNotFoundException extends RuntimeException {
	public TopicNotFoundException(String message) {
		super(message);
	}
}
