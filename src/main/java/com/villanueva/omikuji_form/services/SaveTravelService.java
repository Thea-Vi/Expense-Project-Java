package com.villanueva.omikuji_form.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.villanueva.omikuji_form.models.SaveTravel;
import com.villanueva.omikuji_form.repositories.SaveTravelRepository;

//what is service? access the data through repository
@Service
public class SaveTravelService {

//	tells the service about the repository

//	
	private final SaveTravelRepository saveTravelRepository;

//	create a constructor for the service
	public SaveTravelService(SaveTravelRepository saveTravelRepository) {
		this.saveTravelRepository = saveTravelRepository;
	}

//	shows the service how to access repository methods
//	get all savetravels

	public List<SaveTravel> allSaveTravel() {
		return (List<SaveTravel>) this.saveTravelRepository.findAll();
	}

//	create a new save travel
	public SaveTravel createSaveTravel(SaveTravel saveTravel) {
		return this.saveTravelRepository.save(null)
	}

}
