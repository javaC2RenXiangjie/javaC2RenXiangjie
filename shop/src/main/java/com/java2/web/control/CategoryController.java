package com.java2.web.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.CategoryDto;
import com.java2.web.services.ICategoryService;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public void addCategory(@RequestBody CategoryDto categoryDto) {
		iCategoryService.addCategory(categoryDto);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteCategoryById(@PathVariable Integer id) {
		iCategoryService.deleteCategoryById(id);
	}
	
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public void updateCategory(@RequestBody CategoryDto categoryDto) {
		iCategoryService.updateCategory(categoryDto);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<CategoryDto> getAllCategories() {
		return iCategoryService.getAllCategories();
	}
}
