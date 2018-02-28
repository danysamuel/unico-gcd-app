package com.danyprj.jms.messagereceiver;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.danyprj.endpoints.GcdEndpoint;
import com.danyprj.models.soap.gcd.UnicoParamPojo;
import com.danyprj.service.gcd.UnicoAdService;

@Component
public class UnicoParamReciver {
	
	private static final Logger logger = Logger.getLogger(UnicoParamReciver.class);
	
	@Autowired
	private UnicoAdService unicoService;
	
	@JmsListener(destination = "unicoparams", containerFactory = "myFactory")
	public void receiveMessage(UnicoParamPojo unicoParamPojo) throws IOException {
	
		unicoParamPojo.setSumNumber(unicoParamPojo.getFirstNumber() + unicoParamPojo.getSecondNumber());
		unicoParamPojo.setGcdNumber(unicoService.greatestCommonDivisor(unicoParamPojo.getFirstNumber(),unicoParamPojo.getSecondNumber()));
		unicoService.save(unicoParamPojo);
		GcdEndpoint.setUnicoParamPojo(unicoParamPojo);
		logger.info("Que Received --- > "+unicoParamPojo.toString());
	}
	
	 
  
	

}
