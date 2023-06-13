package org.java.fotoalbum.service;

import java.util.List;

import org.java.fotoalbum.pojo.Category;
import org.java.fotoalbum.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}
	
	public Category save(Category category) {
		return categoryRepo.save(category);
	}
}
