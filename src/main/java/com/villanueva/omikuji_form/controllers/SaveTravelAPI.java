package com.villanueva.omikuji_form.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//	GETALL
	@RequestMapping("api/expenses")
//	when this api gets requested, getAllSaveTravel method runs and the controller talks to the service which then contains the repository that has access to all the methods available to access the database
	public List<SaveTravel> getAllSaveTravel() {
		return this.saveTravelService.allSaveTravel();
	}

//		CREATE

	@PostMapping("api/expenses")
	public SaveTravel createSaveTravel(@RequestParam(value = "name") String name,
			@RequestParam(value = "vendor") String vendor, @RequestParam(value = "amount") Double amount,
			@RequestParam(value = "description") String description) {

//		create objects using the constructor from the model
		SaveTravel saveTravel = new SaveTravel(name, vendor, amount, description);

		return this.saveTravelService.createSaveTravel(saveTravel);

	}

//	FIND ONE

	@GetMapping("/api/expenses/{id}")
	public SaveTravel findSaveTravel(@PathVariable("id") Long id) {
		return this.saveTravelService.findOneSaveTravel(id);
	}

//	DELETE ONE
	@DeleteMapping("/api/expenses/delete/{id}")
	public void deleteSaveTravel(@PathVariable("id") Long id) {
		this.saveTravelService.deleteSaveTravel(id);

	}

// UPDATE ONE
	@PutMapping("/api/expenses/update/{id}")
	public SaveTravel updaSaveTravel(@PathVariable("id") Long id, @RequestParam(value = "name") String name,
			@RequestParam(value = "vendor") String vendor, @RequestParam(value = "amount") Double amount,
			@RequestParam(value = "description") String description) {

//		retrieve a save travel from the db that has that id
		SaveTravel saveTravel = this.saveTravelService.findOneSaveTravel(id);

//		update the object
		saveTravel.setName(name);
		saveTravel.setVendor(vendor);
		saveTravel.setAmount(amount);
		saveTravel.setDescription(description);

		this.saveTravelService.updateSaveTravel(saveTravel);

		return saveTravel;

	}

}
