
package com.example.email.server;

import java.util.concurrent.Future;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;


import com.example.email.client.Email;
import com.example.email.client.EmailResponse;
import com.example.email.client.type.SendResponse;
/*
import com.example.email.client.type.SendResponse;
*/



import org.apache.cxf.jaxws.ServerAsyncResponse;


@WebService(endpointInterface = "com.example.email.client.Email", serviceName = "EmailService", portName = "EmailPort")
@Path("{text}")
public class EmailService implements Email
{
	
	// JAX-RS
	@Context HttpHeaders context;

	
	@GET
	@Produces("application/json")
    public EmailResponse sendrs(@PathParam("text") String text)  
    {     

	
		EmailResponse response = new EmailResponse();
		response.setUser(text);
		response.setAddress("jzaragoza@prosodie.es");
		
				
	    return response;
    	
    }
		
	
	 // JAX-WS
	
    public String send(String text)  
    {     

    	
	    return "Enviando correo para:" + text;
    	
    }
	
	
    
   
    public Future<?> sendAsync(String text, AsyncHandler<SendResponse> sendHandler) 
    {
    		
     		
    	final ServerAsyncResponse<SendResponse> r = new ServerAsyncResponse<SendResponse>();
    	
    	SendResponse response = new SendResponse();
    	response.setResponseType(this.send(text));
    	
    	
    	r.set(response);
    		
        return r;

    }


	public Response<SendResponse> sendAsync(String text)
	{

		        
final ServerAsyncResponse<SendResponse> r = new ServerAsyncResponse<SendResponse>();
    	
    	SendResponse response = new SendResponse();
    	response.setResponseType(this.send(text));
    	r.set(response);
  
        return r;
		
		
	}



	
	
    
}


