package org.java.fotoalbum.api.controller;

import java.util.List;
import java.util.Optional;

import org.java.fotoalbum.pojo.Category;
import org.java.fotoalbum.pojo.Photo;
import org.java.fotoalbum.service.CategoryService;
import org.java.fotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class MyRestController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	@GetMapping("/photo")
	public ResponseEntity<List<Photo>> getPhotos(@RequestParam(required = false) String title) {
		
		if(title == null || title == "") {
			List<Photo> photos = photoService.findAll();
			return new ResponseEntity<>(photos, HttpStatus.OK);
		} else {			
			List<Photo> photos = photoService.findByTitle(title);
			return new ResponseEntity<>(photos, HttpStatus.OK);
		}
	}
	
	@GetMapping("/photo/{id}")
	public ResponseEntity<Optional<Photo>> getPhoto(Model model,
			@PathVariable("id") int id) {
		
		Optional<Photo> optPhoto = photoService.findById(id);
		return new ResponseEntity<>(optPhoto, HttpStatus.OK);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories() {
		
		List<Category> categories = categoryService.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<Optional<Category>> getCategory(Model model,
			@PathVariable("id") int id) {
		
		Optional<Category> optCategory = categoryService.findById(id);
		return new ResponseEntity<>(optCategory, HttpStatus.OK);
	}
	
	
}
