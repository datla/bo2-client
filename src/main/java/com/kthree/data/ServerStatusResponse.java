package com.kthree.data;

public class ServerStatusResponse {

	private String statusMessage;
	private int statusCode;
	
	public ServerStatusResponse(String statusMessage, int statusCode) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	
}	
