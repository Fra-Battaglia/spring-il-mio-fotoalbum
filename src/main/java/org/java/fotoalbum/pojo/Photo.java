package org.java.fotoalbum.pojo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.java.fotoalbum.repo.PhotoRepo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	private String title;
	private String description;
	private String url;
	private Boolean visible;
	private boolean deleted;
	
	public Photo() { }
	public Photo(String title, String description, String url, Boolean visible, Category...categories) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
	}
	
	@ManyToMany
	private List<Category> categories;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void setCategories(Category[] categories) {
		setCategories(Arrays.asList(categories));
	}
	
	public void addCategory(Category category) {
		getCategories().add(category);
	}
	
	public void removeCategory(Category category) {
		getCategories().remove(category);
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] photo" + 
		"\ntitle: " + getTitle() + 
		"\ndescription: " + getDescription() +
		"\nurl: " + getUrl() + 
		"\nvisible: " + isVisible();
	}
	
}
