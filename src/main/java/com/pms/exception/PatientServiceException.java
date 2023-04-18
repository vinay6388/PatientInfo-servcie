package com.pms.exception;

public class PatientServiceException extends Exception {
	private static final long serialVersionUID = 526706541554094375L;

	public PatientServiceException(String message) {
		super(message);
	}

	public PatientServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PatientServiceException(Throwable cause) {
		super(cause);
	}

}
