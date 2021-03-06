package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.discountModel;
import com.example.service.ManageDiscountService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/API/discountController")
@CrossOrigin
public class ManageDiscountController {
	@Autowired
	private ManageDiscountService service;

	@GetMapping("")
	@Cacheable(value = "discount")
	@ApiOperation(
	        value = "Find all discounts",
	        notes = "Header is not required",
	        response = List.class
	    )
	public List<discountModel> getDiscount() {
		return service.getallDiscount();
	}
	@PostMapping("")
	public discountModel saveDiscount(@RequestBody discountModel discount) {
		return service.addDiscount(discount);
	}

	@GetMapping("/{id}")
	public discountModel FindScheduleId(@PathVariable int id) {
		return service.findDiscountById(id);
	}
	@DeleteMapping("/{id}")
	public boolean DeleteDiscountId(@PathVariable int id) {
		return service.deleteDiscount(id);
	}
	
	@GetMapping("test")
	public String saveAirline() {
		return "Hi";
	}
	
	@PutMapping("/{id}")
	public discountModel updateDiscount(@RequestBody discountModel newdiscount,@PathVariable int id) {
		return service.updateDiscountbyId(id,newdiscount);
	}

	/*
	 * @GetMapping("/{id}") //@Cacheable(key="#id", value="books",
	 * condition="#id==4") public AirlineModel findAirlineById(@PathVariable int
	 * id){ System.out.println("finding book ("+id+") from db"); return
	 * service.findAirlineById(id); }
	 */

}
