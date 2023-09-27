package com.openai.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WebResponse {
	
	private Long id;
	private String modelName;
	private String description;
	private String job;

}
