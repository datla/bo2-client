package com.kthree.ws.client;

import com.kthree.ws.ServerStatus;
import com.kthree.ws.ServerStatusService;

public class WsClient {

	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			ServerStatusService statusService = new ServerStatusService();
			ServerStatus status = statusService.getServerStatusPort();
			System.out.println("Server status>"+status.getServerStatus());
		}
	}

}
