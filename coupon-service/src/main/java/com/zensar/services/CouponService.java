package com.zensar.services;

import com.zensar.model.Coupon;

public interface CouponService {

	Coupon createCoupon(Coupon coupon);

	Coupon getCoupon(String couponCode);

}
