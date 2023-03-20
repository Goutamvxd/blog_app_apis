package com.code.blog.service;

import java.util.List;

import com.code.blog.payloads.CategotyDto;

public interface CategoryService {
	
	//create
	CategotyDto createCategory(CategotyDto categotyDto);
	
	//update
	
	CategotyDto updateCategory(CategotyDto categotyDto,Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId );
	
	//get
	
	CategotyDto getCategory(Integer categoryId);
	
	//getAll
	
	List<CategotyDto> getCategories();

}
