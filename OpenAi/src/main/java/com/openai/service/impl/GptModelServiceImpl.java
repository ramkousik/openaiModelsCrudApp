package com.openai.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openai.Payload.RequestDTO;
import com.openai.entity.GptModel;
import com.openai.exception.ModelNotFoundException;
import com.openai.repository.GptModelRepository;
import com.openai.response.WebResponse;
import com.openai.service.GptModelService;

@Service
public class GptModelServiceImpl implements GptModelService{
	
	@Autowired
	private GptModelRepository gptModelrepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public WebResponse createModel(RequestDTO requestDTO) {
		GptModel newGptModel =  modelMapper.map(requestDTO, GptModel.class);
		GptModel gptModel= gptModelrepository.save(newGptModel);
		WebResponse webResponse = modelMapper.map(gptModel, WebResponse.class);
		return webResponse;
	}

	@Override
	public WebResponse getModel(Long id) {
		GptModel gptModel = gptModelrepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundException("No model with provided Id"));
		
		WebResponse webResponse = modelMapper.map(gptModel, WebResponse.class);
		
		return  webResponse;
	}

	@Override
	public List<WebResponse> getAllModels(){
		try {

	           List<GptModel> gptModels = gptModelrepository.findAll();
	           if (!gptModels.isEmpty()){
	               List<WebResponse> webResponseList = new ArrayList<>();
	               for (GptModel p : gptModels) {
	                   WebResponse webResponseUtil = modelMapper.map(p, WebResponse.class);
	                   webResponseList.add(webResponseUtil);
	               }
	               return webResponseList;
	           } throw new ModelNotFoundException("No models found");

	       } catch (ModelNotFoundException e) {
	           throw new ModelNotFoundException(e.getMessage());
	           
	       }


	    }

	@Override
	public WebResponse updateModel(Long id, RequestDTO requestDTO) {
		GptModel gptModel = gptModelrepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundException("No model with provided Id"));
		
		GptModel gptModelEntity = modelMapper.map(requestDTO, GptModel.class);
	
		gptModelEntity.setId(id);
		
		GptModel updatedModel = gptModelrepository.save(gptModelEntity);
		WebResponse webResponse = modelMapper.map(updatedModel, WebResponse.class);
		return webResponse;
	}

}
