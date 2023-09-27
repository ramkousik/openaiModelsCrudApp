package com.openai.Payload;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequestDTO {
	@NotEmpty(message = "Provide a model name")
	private String modelName;
	@NotEmpty(message = "Provide description")
	private String description;
	@NotEmpty(message = "provide the job of the model")
	private String job;

}
