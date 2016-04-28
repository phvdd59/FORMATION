package vdd.service.web;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloVdd {

	@WebResult(partName = "reponse")
	public String diBonjour(@WebParam(name = "nom") String nom);

	@WebResult(partName = "somme")
	public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j);

	@WebResult(partName = "operation")
	public String operation(@WebParam(name = "param_name") String param);

}
