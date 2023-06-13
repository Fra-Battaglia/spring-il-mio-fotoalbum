package org.java.fotoalbum.controller;

import java.util.List;
import java.util.Optional;

import org.java.fotoalbum.pojo.Category;
import org.java.fotoalbum.pojo.Photo;
import org.java.fotoalbum.service.CategoryService;
import org.java.fotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhotoController {
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String photoIndex(Model model) {
		List<Photo> photos = photoService.findAll();
		model.addAttribute("photos", photos);
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		return "index";
	}
	
	// Create
	@GetMapping("photo/new")
	public String createNewPhoto(Model model) {
		return "new-photo";
	}
	
	@PostMapping("/photo/new")
	public String storeNewPizza(@ModelAttribute Photo photo) {
		photoService.save(photo);
		
		return "redirect:/";
	}
	
	// Show
	@GetMapping("/photo/{id}")
	public String getPizza(
		Model model,
		@PathVariable("id") int id
	) {
		Optional<Photo> optPhoto = photoService.findById(id);
		Photo photo = optPhoto.get();
		
		List<Category> categories = categoryService.findAll();
		
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);
	
		return "photo";
	}
	
	// Update
	@GetMapping("/photo/edit/{id}")
	public String editPhoto(
				Model model,
				@PathVariable("id") int id
			) {
		
		Optional<Photo> photoOpt = photoService.findById(id);
		List<Category> categories = categoryService.findAll();
		
		Photo photo = photoOpt.get();
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);
		
		return "edit-photo";
	}
	
	// Delete
	
		@GetMapping("/photo/delete/{id}")
		public String deletePhoto(
				@PathVariable int id
			) {
			
			Optional<Photo> photoOpt = photoService.findById(id);
			Photo photo = photoOpt.get();
			photoService.deletePhoto(photo);
			
			return "redirect:/";
		}
		@GetMapping("/photo/soft-delete/{id}")
		public String softDeleteBook(
				@PathVariable int id
			) {
			
			Optional<Photo> photoOpt = photoService.findById(id);
			Photo photo = photoOpt.get();
			
			photo.setDeleted(true);
			photoService.save(photo);
			
			return "redirect:/";
		}
}
