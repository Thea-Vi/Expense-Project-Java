package com.villanueva.omikuji_form.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.villanueva.omikuji_form.models.SaveTravel;

//hub to access all methods that are already available to perform CRUD
//
@Repository
public interface SaveTravelRepository extends CrudRepository<SaveTravel, Long> {

//	this or cast it on the service
//	List<SaveTravel> findAll();

//	// this method finds books with descriptions containing the search string
//	List<SaveTravel> findByDescriptionContaining(String search);
//
//	// this method counts how many titles contain a certain string
//	Long countByTitleContaining(String search);
//
//	// this method deletes a book that starts with a specific title
//	Long deleteByTitleStartingWith(String search);

}
