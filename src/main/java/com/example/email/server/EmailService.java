
package com.example.email.server;

import java.util.concurrent.Future;

import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;


import com.example.email.client.Email;
import com.example.email.client.type.SendResponse;
/*
import com.example.email.client.type.SendResponse;
*/



import org.apache.cxf.jaxws.ServerAsyncResponse;


@WebService(endpointInterface = "com.example.email.client.Email", serviceName = "EmailService", portName = "EmailPort")
public class EmailService implements Email
{


    public String send(String text)  
    {     

	    	 
	        return "how are you !!!";
    	
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


