package com.store.online.Exception;

import java.util.List;

public class ErrorResponse {
	String error;
	List<String> details;

	public ErrorResponse(String error, List<String> details) {
		this.error = error;
		this.details = details;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

}
