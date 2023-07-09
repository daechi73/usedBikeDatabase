package ca.sheridancollege.hongjun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.hongjun.beans.Bike;
import ca.sheridancollege.hongjun.database.DatabaseAccess;

/**
 * The SymphonyUsedBikeController maps all the web addresses to the
 * corresponding html file and loads information using GetMapping. Postmapping
 * is used to grab information from the user.
 * 
 * @author Jp
 *
 */

@Controller
public class SymphonyUsedBikesController {

	@Autowired
	@Lazy
	private DatabaseAccess da;
	private int idPath;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/permission-denied")
	public String permissionDenied() {
		return "/error/index";
	}

	@GetMapping("/secure/delete")
	public String delete(Model model) {
		model.addAttribute("bikeList", da.getBike());
		return "/secure/delete";
	}

	@GetMapping("/secure/delete/deleteBike/{id}")
	public String deleteBike(Model model, @PathVariable int id) {
		da.deleteBike(id);
		model.addAttribute("bikeList", da.getBike());
		return "/secure/delete";
	}

	@GetMapping("/secure/update")
	public String update(Model model) {
		//model.addAttribute("bike", new Bike());
		model.addAttribute("bikeList", da.getBike());
		return "/secure/update";
	}

	@GetMapping("/secure/update/updateBike/{id}")
	public String updateBikeId(Model model, @PathVariable int id) {
		idPath = id;
		model.addAttribute("bikeList", da.getBike());
		Bike bike = da.getBikeById(id).get(0);
		model.addAttribute("bike", bike);
		return "/secure/updateWithForm";
	}

	@PostMapping("/secure/update/updateBike")
	public String updateBike(Model fmodel, @RequestParam String bikeModel, @RequestParam double price, Model model) {
		System.out.println(idPath);
		da.updateBike(bikeModel, price, idPath);
		idPath = 0;
		model.addAttribute("bike", new Bike());
		model.addAttribute("bikeList", da.getBike());
		return "/secure/update";
		// return "redirect:/";
	}

//	@GetMapping("/secure/update/updateBike/{id}")
//	public String updateBike(Model model, @PathVariable int id) {
//		Bike bike = da.getBikeById(id).get(0);
//		model.addAttribute("bike", bike);
//		da.deleteBike(id);
//		model.addAttribute("bikeList", da.getBike());
//		return "/secure/update";
//	}

	@GetMapping("/secure/insert")
	public String insert(Model model) {
		model.addAttribute("manufacturerIDList", da.getManufacturer());
		model.addAttribute("bikeList", da.getBike());
		return "/secure/insert";
	}

	@PostMapping("/secure/insert")
	public String insertBike(@RequestParam int manufacturerID, @RequestParam String bikeModel, @RequestParam int year,
			@RequestParam String colour, @RequestParam double price, Model model) {
		da.insertBike(manufacturerID, bikeModel, year, colour, price);
		model.addAttribute("manufacturerIDList", da.getManufacturer());
		model.addAttribute("bikeList", da.getBike());
		return "/secure/insert";
		// return "redirect:/";
	}

}
