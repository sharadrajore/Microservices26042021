package com.zensar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Coupon;
import com.zensar.services.CouponService;

@RestController
@RequestMapping("/couponapi")
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	// http://localhost:8080/couponapi/coupons -> POST
	
	@PostMapping("/coupons")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponService.createCoupon(coupon);
		
	}
	
	// http://localhost:8080/couponapi/coupons -> GET
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code")String couponCode) {
		return couponService.getCoupon(couponCode);
	}
	

}
