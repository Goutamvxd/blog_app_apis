package com.code.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategotyDto {

	private Integer categoryId;

	private String categoryTitle;

	private String categoryDescription;
}
