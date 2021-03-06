package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
	Coupon getByCode(String couponCode);
}
