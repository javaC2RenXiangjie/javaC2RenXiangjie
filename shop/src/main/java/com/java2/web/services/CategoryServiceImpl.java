package com.java2.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dtos.CategoryDto;
import com.java2.web.dtos.ProductionDto;
import com.java2.web.entities.CategoryEntity;
import com.java2.web.entities.ProductionEntity;
import com.java2.web.repositories.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	ICategoryRepository iCategoryRepository;
	
	@Transactional
	@Override
	public void addCategory(CategoryDto categoryDto) {
		CategoryEntity ce = new CategoryEntity();
		ce.setId(categoryDto.getId());
		ce.setName(categoryDto.getName());
		for(ProductionDto pd: categoryDto.getProductionDto()){
			ProductionEntity pe = new ProductionEntity();
			pe.setId(pd.getId());
			pe.setName(pd.getName());
			pe.setOriginPrice(pd.getOriginPrice());
			pe.setPrice(pd.getPrice());
			ce.getProduction().add(pe);
		}
		iCategoryRepository.addCategory(ce);
	}

	@Transactional
	@Override
	public void deleteCategoryById(Integer id) {
		iCategoryRepository.deleteCategoryById(id);
	}

	@Transactional
	@Override
	public void updateCategory(CategoryDto categoryDto) {
		CategoryEntity ce = new CategoryEntity();
		ce.setId(categoryDto.getId());
		ce.setName(categoryDto.getName());
		for(ProductionDto pd: categoryDto.getProductionDto()) {
			ProductionEntity pe = new ProductionEntity();
			pe.setId(pd.getId());
			pe.setName(pd.getName());
			pe.setOriginPrice(pd.getOriginPrice());
			pe.setPrice(pd.getPrice());
			//关联回去？？？？？？？？？？？？？？？？？？？
//			pe.setCategory();
		}
		iCategoryRepository.updateCategory(ce);
	}

	@Transactional
	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryDto> ct = new ArrayList<CategoryDto>();
		List<CategoryEntity> ce = iCategoryRepository.getAllCategorys();
		for(CategoryEntity cate: ce) {
			CategoryDto caDto = new CategoryDto();
			caDto.setId(cate.getId());
			caDto.setName(cate.getName());
			for(ProductionEntity pe: cate.getProduction()) {
				ProductionDto pd = new ProductionDto();
				pd.setId(pe.getId());
				pd.setName(pe.getName());
				pd.setDescription(pe.getDescription());
				pd.setOriginPrice(pe.getOriginPrice());
				pd.setPrice(pe.getPrice());
				caDto.getProductionDto().add(pd);
			}
			ct.add(caDto);
		}
		return ct;
	}
}
