package com.villanueva.omikuji_form.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.villanueva.omikuji_form.models.SaveTravel;
import com.villanueva.omikuji_form.services.SaveTravelService;

@RestController
public class SaveTravelAPI {

//	lets the controller know about the service
	private final SaveTravelService saveTravelService;

	public SaveTravelAPI(SaveTravelService saveTravelService) {
		this.saveTravelService = saveTravelService;

	}

//	the controller requests
	@RequestMapping("api/expenses")
//	when this api gets requested, getAllSaveTravel method runs and the controller talks to the service which then contains the repository that has access to all the methods available to access the database
	public List<SaveTravel> getAllSaveTravel() {
		return this.saveTravelService.allSaveTravel();
	}

//		Create SaveTravel
	@PostMapping("api/expenses")
	public SaveTravel createSaveTravel(@RequestParam(value="name") String name, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") Double amount, @RequestParam(value="description") String description) {
		this.saveTravelService.get
		
	}

}
