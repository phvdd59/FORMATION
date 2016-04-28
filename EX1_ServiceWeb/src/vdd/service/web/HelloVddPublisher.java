package vdd.service.web;

import javax.xml.ws.Endpoint;

public class HelloVddPublisher {
	public static final String URI = "http://localhost:8888/hello";
	
	public static void main(String[] args) {
		HelloVddWS impl = new HelloVddWS();
		
		Endpoint endpoint= Endpoint.publish(URI, impl);
		
		boolean status = endpoint.isPublished();
		System.out.println("Web service disponible ? "+ status);
	}
	
}
