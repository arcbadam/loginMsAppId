package com.ibm.loginAppId.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ibm.loginAppId.dto.ProductDTO;
import com.ibm.loginAppId.dto.ResponseDTO;

@FeignClient(name = "ordercart")
public interface OrderMsAppIdClient {
	
	@GetMapping("/os/products/")
	public List<ProductDTO> getProducts();
	

	@PostMapping("/os/checkoutOrder/{userToken}/{serviceToken}/{transactionToken}")
	public Long checkoutOrder(@PathVariable(value="userToken") String userToken,@PathVariable(value="serviceToken") String serviceToken,@PathVariable(value="transactionToken") String transactionToken);
	
}