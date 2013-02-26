

package com.example.email.client;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import com.example.email.client.type.SendResponse;



public class EmailAsyncHandler implements AsyncHandler<SendResponse> 
{


    public void handleResponse(Response<SendResponse> response) 
    {
        try       
        {	
        	System.out.println("Asynchronous response:" + response.get().getResponseType());
        /*
        	String r = response.get();
            System.out.println("Asynchronous response:" + r);
            */
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    
}
