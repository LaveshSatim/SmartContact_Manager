package com.smart.exception;

public class SetProfileException extends IllegalStateException {

	private static final long serialVersionUID = 1L;

	public SetProfileException(String string) {
		super(string);
	}

	public SetProfileException() {
		super("please add profile");
	}

}
