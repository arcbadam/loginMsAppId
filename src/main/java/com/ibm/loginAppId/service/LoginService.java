package com.ibm.loginAppId.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.loginAppId.client.OrderMsAppIdClient;
import com.ibm.loginAppId.dto.OrderCheckoutDTO;
import com.ibm.loginAppId.dto.ProductDTO;
import com.ibm.loginAppId.dto.ResponseDTO;

@Service
public class LoginService {

	
	final OrderMsAppIdClient orderMsAppIdClient;
	
	public LoginService(OrderMsAppIdClient orderMsAppIdClient) {
		this.orderMsAppIdClient = orderMsAppIdClient;
	}
	
	public List<ProductDTO> getProducts() {

		return orderMsAppIdClient.getProducts();
	}
	
	public Long checkoutOrder (String userToken, String serviceToken, String transactionToken) {
		
		return orderMsAppIdClient.checkoutOrder(userToken,serviceToken,transactionToken);
	}
		


}
