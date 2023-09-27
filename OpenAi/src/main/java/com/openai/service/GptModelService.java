package com.openai.service;


import java.util.List;

import com.openai.Payload.RequestDTO;
import com.openai.response.WebResponse;

public interface GptModelService {
	WebResponse createModel(RequestDTO requestDTO);
	WebResponse getModel(Long id);
	List<WebResponse> getAllModels();
	WebResponse updateModel(Long id, RequestDTO requestDTO);
}
