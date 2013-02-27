
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

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.apache.cxf.jaxws.ServerAsyncResponse;

import com.example.email.client.Email;
import com.example.email.client.type.EmailRequest;
import com.example.email.client.type.EmailResponse;
import com.example.email.client.type.EmailResponseWrapper;



@WebService(endpointInterface = "com.example.email.client.Email", serviceName = "EmailService", portName = "EmailPort")
@InInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingInInterceptor")
@OutInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingOutInterceptor")
@Path("{text}")
public class EmailService implements Email
{
	
	// JAX-RS
	@Context HttpHeaders context;

	
	@GET
	@Produces("application/json")
    public EmailResponse sendrs(@PathParam("text") String text)  
    {     

		/*
		EmailResponse response = new EmailResponse();
		response.setUser(text);
		response.setAddress("jzaragoza@prosodie.es");
		
				
	    return response;
	    */
		
		return null;
    	
    }
		
	
	 // JAX-WS
	@Override
    public EmailResponse send(EmailRequest emailRequest)  
    {     
		System.out.println("Invoked sync send method...");
		
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			
		}
		
		EmailResponse response = new  EmailResponse();
		response.setCode(0);
		response.setError("Mensaje enviado correctamente para:" + emailRequest.getAddress());
	    
		return response;
    	
    }
	
	
    
    @Override
    public Future<?> sendAsync(EmailRequest emailRequest, AsyncHandler<EmailResponseWrapper> sendHandler) 
    {

    	return null;

    }

    @Override
	public Response<EmailResponseWrapper> sendAsync(EmailRequest emailRequest)
	{
    	
        return null;
		
		
	}








	
	
    
}


