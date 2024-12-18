package com.solum.aims.msp.controller.response;

import com.solum.aims.msp.comstant.Constants;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class AimsApiResponse {

	private String responseMessage = "The request has been completed";

	private String responseCode = Constants.OK;

	private String customBatchId;

	private List<String> templates;

	public AimsApiResponse() {
		super();
	}

	public AimsApiResponse(String customerBatchId) {
		super();
		this.customBatchId = customerBatchId;
	}

	@Builder
	public AimsApiResponse(String responseMessage, String responseCode, String customBatchId, List<String> templates) {
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
		this.customBatchId = customBatchId;
		this.templates = templates;
	}
}