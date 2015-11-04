package com.kthree.resource;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kthree.data.ServerStatusResponse;
import com.kthree.ws.ServerStatus;
import com.kthree.ws.ServerStatusService;

@RequestScoped
@Path("BO2")
public class ServerStatusResource {

    @GET
    @Path("/getStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public ServerStatusResponse getStatus() {
    	ServerStatusService statusService = new ServerStatusService();
		ServerStatus status = statusService.getServerStatusPort();
		System.out.println("Server status>"+status.getServerStatus());
		if(status.getServerStatus()){
			Response.status(Response.Status.OK).build();
			return new ServerStatusResponse("SUCCESS",200);
		}else{
			Response.status(Response.Status.PRECONDITION_FAILED).build();
			return new ServerStatusResponse("UNAVAILABLE",503);
		}
    }

}