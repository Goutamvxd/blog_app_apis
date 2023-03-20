package com.code.blog.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.blog.entities.Category;
import com.code.blog.exception.ResourceNotFoundException;
import com.code.blog.payloads.CategotyDto;
import com.code.blog.repositories.CategoryRepo;
import com.code.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategotyDto createCategory(CategotyDto categotyDto) {
		Category cat = this.modelMapper.map(categotyDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategotyDto.class);
	}

	@Override
	public CategotyDto updateCategory(CategotyDto categotyDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		cat.setCategoryTitle(categotyDto.getCategoryTitle());
		cat.setCategoryDescription(categotyDto.getCategoryDescription());
		Category updatedcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedcat, CategotyDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategotyDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

		return this.modelMapper.map(cat, CategotyDto.class);
	}

	@Override
	public List<CategotyDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategotyDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategotyDto.class))
				.collect(Collectors.toList());
		return catDtos;
	}

}
