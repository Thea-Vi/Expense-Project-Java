package com.villanueva.omikuji_form.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.villanueva.omikuji_form.models.SaveTravel;
import com.villanueva.omikuji_form.services.SaveTravelService;

@Controller
public class SaveTravelController {
//	tells the controller about the service

	private final SaveTravelService saveTravelService;

	public SaveTravelController(SaveTravelService saveTravelService) {
		this.saveTravelService = saveTravelService;
	}

	@GetMapping("/expenses")
	public String getAllSaveTravel(Model model) {
		List<SaveTravel> allSaveTravel = this.saveTravelService.allSaveTravel();

		model.addAttribute("allSaveTravel", allSaveTravel);

		return "index.jsp";

	}

//	create request
	@GetMapping("/expenses/new")
	public String newSaveTravel(@ModelAttribute("saveTravel") SaveTravel saveTravel) {

		return "form.jsp";
	}

//	post request
	@PostMapping("/expenses/create")
	public String createNewSaveTravel(@Valid @ModelAttribute("saveTravel") SaveTravel saveTravel,
			BindingResult result) {
		System.out.println(saveTravel);
		if (result.hasErrors()) {

			return "form.jsp";
		}

		this.saveTravelService.createSaveTravel(saveTravel);
		return "redirect:/expenses";

	}

//	GET DETAILS FOR ONE

//	USE @PATHVARIABLE TO COLLECT INFO FROM THE ID
	@GetMapping("expense/{id}")
	public String showSaveTravelInfo(@PathVariable("id") Long id, Model model) {

//		using the id, we can request Service to return an object that has the id
		SaveTravel saveTravel = this.saveTravelService.findOneSaveTravel(id);
		model.addAttribute("saveTravelDetails", saveTravel);

		return "details.jsp";
	}

//	EDIT FORM

	@GetMapping("/expense/edit/{id}")
	public String editSaveTravel(@PathVariable("id") Long id, Model model) {

//		get the object to send the info to the edit form to populate info
		SaveTravel saveTravel = this.saveTravelService.findOneSaveTravel(id);

		model.addAttribute("saveTravelEdit", saveTravel);

		return "edit.jsp";
	}

//	UPDATE POST
	@PostMapping("/expense/update/{id}")
	public String updateSaveTravel(@Valid @ModelAttribute("saveTravelEdit") SaveTravel saveTravel,
			BindingResult result) {

		if (result.hasErrors()) {

			return "edit.jsp";
		}
		System.out.println(saveTravel.getName());
		System.out.println(saveTravel.getVendor());
		System.out.println(saveTravel.getAmount());
		System.out.println(saveTravel.getDescription());

		this.saveTravelService.updateSaveTravel(saveTravel);
		return "redirect:/expenses";

	}

	@RequestMapping(value = "/expense/delete/{id}", method = RequestMethod.DELETE)
	public String deleteSaveTravel(@PathVariable("id") Long id) {
		saveTravelService.deleteSaveTravel(id);

		return "redirect:/expenses";
	}

}

// ANOTHER WAY TO DELETE

//@RequestMapping("/expense/delete/{id}")
//public String deleteSaveTravel(@PathVariable("id") Long id) {
//	this.saveTravelService.deleteSaveTravel(id);
//
//	return "redirect:/expenses";
//}

//	DELETE

//@Controller
//public class SaveTravelController {
////	tells the controller about the service
//
//	private final SaveTravelService saveTravelService;
//
//	public SaveTravelController(SaveTravelService saveTravelService) {
//		this.saveTravelService = saveTravelService;
//	}
//
//	@GetMapping("/expenses")
//	public String getAllSaveTravel(Model model) {
//		List<SaveTravel> allSaveTravel = this.saveTravelService.allSaveTravel();
//
//		model.addAttribute("allSaveTravel", allSaveTravel);
//
//		return "index.jsp";
//
//	}
//
////	@GetMapping("/expenses/new")
////	public String newSaveTravel(@ModelAttribute("saveTravel") SaveTravel saveTravelt) {
////
////		return "form.jsp";
////	}
//
//	@PostMapping("/expenses/create")
//	public String createNewSaveTravel(@Valid @ModelAttribute("saveTravel") SaveTravel saveTravel, BindingResult result,
//			Model model) {
//		if (result.hasErrors()) {
//
//			List<SaveTravel> allSaveTravel = this.saveTravelService.allSaveTravel();
//
//			model.addAttribute("allSaveTravel", allSaveTravel);
//			return "index.jsp";
//		} else {
//			saveTravelService.createSaveTravel(saveTravel);
//
//			this.saveTravelService.createSaveTravel(saveTravel);
//			return "redirect:/saveTravel";
//
//		}
//
//	}
//
//}
