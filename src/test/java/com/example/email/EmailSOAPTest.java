
package com.example.email;



import java.util.concurrent.Future;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.example.email.client.Email;
import com.example.email.client.EmailAsyncHandler;
import com.example.email.client.type.EmailRequest;


/*
import org.junit.Test;
import static org.junit.Assert.assertEquals;
*/

public class EmailSOAPTest 
{

	/*
    @Test
	*/
	public static final void main(String[] a )
    {
    	
    	  QName serviceName = new QName("http://prosodie.com/ws/email/", "EmailService");
          QName portName = new QName("http://prosodie.com/ws/email/", "EmailPort");

          try
          {

        	  Service service = Service.create(serviceName);
        	  service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,"http://localhost:8080/email/ws/email"); 
        	 
        	  
        	  Email client = service.getPort(portName,  Email.class);
        	  
        	  Client c = ClientProxy.getClient(client);
        	  c.getInInterceptors().add(new LoggingInInterceptor());
              c.getOutInterceptors().add(new LoggingOutInterceptor()); 

   
        	  EmailRequest request = new EmailRequest();
        	  request.setAddress("jzaragoza@prosodie.es");
        			  
        	 
        	  /*
        	  EmailResponse r = client.send(request);
        	  System.out.println("Resultado sincrono[" + r.getCode() + "][" + r.getError() + "]");
        	  */
        	  
        	  /*
        	 EmailWrapper r = new EmailWrapper();
        	 r.setEmailRequest(request);
        	 */
        	  
        	  Future<?> future = client.sendAsync(request, new EmailAsyncHandler());
        	  while (!future.isDone()) 
        	  {
        		  System.out.println("Waiting ...");
        	      Thread.sleep(100);
        	  }
        
        	



          }
          catch(Exception e)
          {
        	  System.err.println("Client exception");
        	  e.printStackTrace();
          }

          
          System.out.println("Finished");
		
		          
          

          
    }
}
