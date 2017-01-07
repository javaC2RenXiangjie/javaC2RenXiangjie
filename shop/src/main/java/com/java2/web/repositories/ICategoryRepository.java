package com.java2.web.repositories;

import java.util.List;

import com.java2.web.entities.CategoryEntity;

public interface ICategoryRepository {

	public void addCategory(CategoryEntity category);
	
	public void deleteCategoryById(Integer id);
	
	public void updateCategory(CategoryEntity category);
	
	public List<CategoryEntity> getAllCategorys();
}
