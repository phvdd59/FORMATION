package vdd.service.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "vdd.service.web.HelloVdd")
public class HelloVddWS implements HelloVdd {

	@Override
	public String diBonjour(String nom) {
		return "BONJOUR, " + nom + " !";
	}

	@WebMethod(action = "add")
	public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
		int k = i + j;
		return k;
	}

	@WebMethod(action = "sample_operation")
	public String operation(@WebParam(name = "param_name") String param) {
		return param;
	}

}
