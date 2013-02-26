
package com.example.email;



import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.example.email.client.Email;
import com.example.email.client.EmailAsyncHandler;


/*
import org.junit.Test;
import static org.junit.Assert.assertEquals;
*/

public class EmailTest 
{

	/*
    @Test
	public void testSayHi()
	*/
	public static final void main(String[] a )
    {
    	
    	  QName serviceName = new QName("http://prosodie.com/ws/email/", "EmailService");
          QName portName = new QName("http://prosodie.com/ws/email/", "EmailPort");

          try
          {

        	  Service service = Service.create(serviceName);
        	  service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,"http://localhost:8080/email/email"); 
        	 
        	  
        	  Email client = service.getPort(portName,  Email.class);

        	  String r = client.send("Texto asincrono");
        	  System.out.println("Resultado asincrono:" + r);
        	  
        	  
        	  
        	 client.sendAsync("Texto a enviar", new EmailAsyncHandler());
        	 
        
        	



          }
          catch(Exception e)
          {
        	  System.err.println("EXCEPCION CLIENTE");
        	  e.printStackTrace();
          }

          
          System.out.println("Finished");
		
		          
          

          
    }
}
