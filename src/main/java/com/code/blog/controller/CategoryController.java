package com.code.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.code.blog.payloads.ApiResponse;
import com.code.blog.payloads.CategotyDto;
import com.code.blog.service.CategoryService;

@RestControllerAdvice
@RequestMapping("/api/categories")

public class CategoryController {

	private CategoryService categoryService;

	// create

	@PostMapping("/")
	public ResponseEntity<CategotyDto> createCategory(@RequestBody CategotyDto categotyDto) {
		CategotyDto createCategory = this.categoryService.createCategory(categotyDto);
		return new ResponseEntity<CategotyDto>(createCategory, HttpStatus.CREATED);
	}

	// update

	@PutMapping("/{catId}")
	public ResponseEntity<CategotyDto> updateCategory(@RequestBody CategotyDto categotyDto,
			@PathVariable Integer catId) {
		CategotyDto updatedCategory = this.categoryService.updateCategory(categotyDto, catId);
		return new ResponseEntity<CategotyDto>(updatedCategory, HttpStatus.OK);
	}

	// delete

	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully !!", true),
				HttpStatus.OK);
	}

	// get
	@GetMapping("/{catId}")
	public ResponseEntity<CategotyDto> getCategory(@PathVariable Integer catId){
		CategotyDto categotyDto = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategotyDto>(categotyDto,HttpStatus.OK);
	}

	

	// getAll
	
	@GetMapping("/")
	public ResponseEntity<List<CategotyDto>> getCategories(){
		List<CategotyDto> categories = this.categoryService.getCategories();
		return ResponseEntity.ok(categories);
		
	}

}
