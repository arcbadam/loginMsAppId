package com.ibm.loginAppId.dto;

import java.util.List;

public class LoginDTO {

	private String userId;
	
	private List<ProductDTO> productDto;

	public String getUserAccountId() {
		return userId;
	}

	public void setUserAccountId(String userId) {
		this.userId = userId;
	}

	public List<ProductDTO> getProductDto() {
		return productDto;
	}

	public void setProductDto(List<ProductDTO> productDto) {
		this.productDto = productDto;
	}

}
