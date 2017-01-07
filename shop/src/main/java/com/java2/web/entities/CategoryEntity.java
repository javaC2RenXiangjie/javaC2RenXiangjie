package com.java2.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToMany(fetch=FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinTable(name="production_category",joinColumns = @JoinColumn(name="categoryId",referencedColumnName="id")
				,inverseJoinColumns = @JoinColumn(name="productionId",referencedColumnName = "id"))
	private List<ProductionEntity> production = new ArrayList<ProductionEntity>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ProductionEntity> getProduction() {
		return production;
	}
	public void setProduction(List<ProductionEntity> production) {
		this.production = production;
	}
	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", name=" + name + ", production=" + production + "]";
	}
	
}
