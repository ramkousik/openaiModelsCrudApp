package com.openai.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openai.Payload.RequestDTO;
import com.openai.entity.GptModel;
import com.openai.response.WebResponse;
import com.openai.service.impl.GptModelServiceImpl;

@RestController
@RequestMapping("/api/model")
public class GptModelController {
	
	@Autowired
	GptModelServiceImpl gptModelServiceImpl;
	
	@PostMapping
	public ResponseEntity<WebResponse> createMode(@RequestBody RequestDTO requestDTO){
		WebResponse response = gptModelServiceImpl.createModel(requestDTO);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<WebResponse> getModel(@PathVariable Long id){
		WebResponse webResponse = gptModelServiceImpl.getModel(id);
		return ResponseEntity.ok().body(webResponse);
	}
	
	@GetMapping
	public ResponseEntity<List<WebResponse>> getAllModels(){
		List<WebResponse> response = gptModelServiceImpl.getAllModels();
		return ResponseEntity.ok().body(response);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<WebResponse> updateModel(@PathVariable Long id, @RequestBody RequestDTO requestDTO){
		WebResponse response = gptModelServiceImpl.updateModel(id, requestDTO);
		return ResponseEntity.ok().body(response);
	}
}
