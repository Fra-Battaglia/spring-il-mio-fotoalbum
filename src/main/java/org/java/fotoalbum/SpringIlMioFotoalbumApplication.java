package org.java.fotoalbum;

import org.java.fotoalbum.service.CategoryService;
import org.java.fotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.java.fotoalbum.pojo.Photo;
import org.java.fotoalbum.pojo.Category;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category("People");
		Category c2 = new Category("Landscape");
		Category c3 = new Category("Animals");
		Category c4 = new Category("Day");
		Category c5 = new Category("Night");
		
		categoryService.save(c1);
		categoryService.save(c2);
		categoryService.save(c3);
		categoryService.save(c4);
		categoryService.save(c5);
		
		Photo p1 = new Photo("panda", "chilling panda", "https://i.pinimg.com/564x/2c/0c/80/2c0c802e0e11000b3284d5ec49f3e163.jpg", true, c3, c4);
		Photo p2 = new Photo("lava", "dripping lava", "https://i.pinimg.com/564x/53/f4/1b/53f41b8059b8608d82823fda528168f4.jpg", true, c2, c4);
		Photo p3 = new Photo("aurora", "northen lights", "https://i.pinimg.com/564x/ba/8a/d3/ba8ad302cc5ef519bbe62aa402db42b7.jpg", true, c2, c5);
		Photo p4 = new Photo("ice", "cold", "https://i.pinimg.com/564x/cc/14/5a/cc145a99ae8492107169bbf306a387f9.jpg", true, c2, c4);
		
		photoService.save(p1);
		photoService.save(p2);
		photoService.save(p3);
		photoService.save(p4);
	}
}
