package vdd.service.web;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldClient {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8888/hello?wsdl");
		QName qname = new QName("http://web.service.vdd/", "HelloVddWSService");

		Service service = Service.create(url, qname);
		HelloVdd hello=service.getPort(HelloVdd.class);
		System.out.println(hello.diBonjour("Philippe"));
	}
}
