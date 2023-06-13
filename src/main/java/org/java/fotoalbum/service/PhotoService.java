package org.java.fotoalbum.service;

import java.util.List;
import java.util.Optional;

import org.java.fotoalbum.pojo.Photo;
import org.java.fotoalbum.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
	@Autowired
	private PhotoRepo photoRepo;

	
	public List<Photo> findAll() {
		return photoRepo.findAll();
	}
	
	public Optional<Photo> findById(int id) {
		return photoRepo.findById(id);
	}
	
	public Photo save(Photo photo) {
		return photoRepo.save(photo);
	}
	
	public void deletePhoto(Photo photo) {
		photoRepo.delete(photo);
	}
}
