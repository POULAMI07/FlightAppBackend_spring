package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.discountModel;
import com.example.repository.DiscountRepository;

@Service
public class ManageDiscountService {
	@Autowired
	private DiscountRepository repository;

	public discountModel addDiscount(discountModel discount) {
		return repository.save(discount);
	}

	public List<discountModel> getallDiscount() {
		return repository.findAll();
	}

	public discountModel findDiscountById(int id) {
		System.out.println("in service id: " + id);
		Optional<discountModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	public boolean deleteDiscount(int id) {
		if (repository.existsById(id)) {
			this.repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	public discountModel updateDiscountbyId(int id,discountModel discount)
	{
		return repository.findById(id)
	            .map(existDiscount -> {
	            	existDiscount.setDiscount(discount.getDiscount());
	            	existDiscount.setDiscountPer(discount.getDiscountPer());
	            	existDiscount.setMaxdiscount(discount.getMaxdiscount());
	                return repository.save(existDiscount);
	            })
	            .orElseGet(() -> {
	                return null;
	            });
	}
	/*
	 * public AirlineModel UdateAirlineById(int id) {
	 * System.out.println("in service id: " + id); Optional<AirlineModel> optional =
	 * repository.findById(id); if (optional.isPresent()) { return optional.get(); }
	 * else { return null; } }
	 */

}
