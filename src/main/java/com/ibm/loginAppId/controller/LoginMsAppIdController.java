package com.ibm.loginAppId.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.loginAppId.config.JwtTokenUtil;
import com.ibm.loginAppId.dto.LoginDTO;
import com.ibm.loginAppId.dto.ResponseDTO;
import com.ibm.loginAppId.service.LoginService;

@RestController
//@RequestMapping("/")
public class LoginMsAppIdController {

	private String token;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/user")
    public Principal user(Principal principal) {
        //Principal holds the logged in user information.
        // Spring automatically populates this principal object after login.
    	
        return principal;
    }
 
    @RequestMapping("/userInfo")
    public String userInfo(Principal principal){
        final OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
        final Authentication authentication = oAuth2Authentication.getUserAuthentication();
        //Manually getting the details from the authentication, and returning them as String.
        return authentication.getDetails().toString();
    }
    
    @RequestMapping("/getProductData")
    public LoginDTO getProductData(Principal principal){
    	
    	token = jwtTokenUtil.generateToken(principal.getName());
    	System.out.println("JWT Token  = "+token);
    	
    	LoginDTO loginDto = new LoginDTO();
    	loginDto.setProductDto(loginService.getProducts());
    	int size = loginDto.getProductDto().size();
    	System.out.println("size in loginApp :"+size);
		return loginDto;
       
    }
    
    @PostMapping("/checkoutOrder")
	public Long checkoutOrder(@RequestParam("serviceToken") String serviceToken) throws Exception {
	
      	String uniqueID = UUID.randomUUID().toString();
      	
    	System.out.println("serviceToken =  "+serviceToken);
    	System.out.println("token =  "+token);
    	System.out.println("uniqueID =  "+uniqueID);
		
    	return loginService.checkoutOrder(token,serviceToken,uniqueID);
	}
    
  

}
