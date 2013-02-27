

package com.example.email.client;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import com.example.email.client.type.EmailResponse;
import com.example.email.client.type.EmailResponseWrapper;


/*
 * 
 * java.lang.ClassCastException: com.example.email.client.type.EmailResponseWrapper cannot be cast to com.example.email.client.type.EmailResponse
 */

public class EmailAsyncHandler implements AsyncHandler<EmailResponseWrapper> 
{


    public void handleResponse(Response<EmailResponseWrapper> response) 
    {
        try       
        {	
        	EmailResponse r = response.get().getEmailResponse();
        	
        	System.out.println("Asynchronous response[" + r.getCode() + "]["+ r.getError() + "]");
        
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    
}
