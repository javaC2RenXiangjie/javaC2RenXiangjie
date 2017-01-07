package com.java2.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.entities.CategoryEntity;

@Repository
public class CategoryRepo implements ICategoryRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addCategory(CategoryEntity category) {
		em.persist(category);
	}

	@Override
	public void deleteCategoryById(Integer id) {
		em.remove(em.find(CategoryEntity.class, id));
	}

	@Override
	public void updateCategory(CategoryEntity category) {
		em.merge(category);
	}

	@Override
	public List<CategoryEntity> getAllCategorys() {
		return em.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
	}

}
