package org.java.fotoalbum.controller;

import java.util.List;

import org.java.fotoalbum.pojo.Category;
import org.java.fotoalbum.pojo.Photo;
import org.java.fotoalbum.service.CategoryService;
import org.java.fotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/")
	public String photoIndex(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		List<Photo> photos = photoService.findAll();
		model.addAttribute("photos", photos);
		
		return "index";
	}
}
