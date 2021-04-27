package com.zensar.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Coupon;
import com.zensar.model.Product;
import com.zensar.restclient.CouponClient;
import com.zensar.services.ProductService;

@RestController
@RequestMapping("/productapi")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	private CouponClient client;
	
	@PostMapping("/products")
	public Product insertProduct(@RequestBody Product product) {
		
		Coupon coupon=client.getCoupon(product.getCode());
		
		//Coupon coupon = restTemplate.getForObject("http://localhost:8080/couponapi/coupons/"+product.getCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(new BigDecimal(coupon.getDiscount())));
		return productService.insertProduct(product);
	}
	
	
	
	
	

}
