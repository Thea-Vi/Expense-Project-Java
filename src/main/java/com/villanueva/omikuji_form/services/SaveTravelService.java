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

//	GET ALL save travels

	public List<SaveTravel> allSaveTravel() {
		return (List<SaveTravel>) this.saveTravelRepository.findAll();
	}

//	CREATE
	public SaveTravel createSaveTravel(SaveTravel saveTravel) {
		return this.saveTravelRepository.save(saveTravel);
	}

//	FIND A SAVE TRAVEL USING AN ID
	public SaveTravel findOneSaveTravel(Long id) {
		return this.saveTravelRepository.findById(id).orElse(null);
	}

//	DELETE A SAVETRAVEL USING AN ID

	public void deleteSaveTravel(Long id) {
		this.saveTravelRepository.deleteById(id);
	}

// UPDATE A SAVETRAVEL USING AN ID
	public SaveTravel updateSaveTravel(SaveTravel saveTravel) {
		return this.saveTravelRepository.save(saveTravel);
	}

}
