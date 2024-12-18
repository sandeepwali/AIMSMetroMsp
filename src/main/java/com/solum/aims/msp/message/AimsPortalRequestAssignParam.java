package com.solum.aims.msp.message;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class AimsPortalRequestAssignParam {

	private String labelCode;
	
	private List<String> articleIdList = new ArrayList<>();

//	@JsonIgnore
//	private List<String> templateNameList = new ArrayList<>();
	@Size(min=1, max=255)
	private String templateName;
	public AimsPortalRequestAssignParam(String labelCode, String articleId) {
		this.labelCode = labelCode;
		this.getArticleIdList().add(articleId);
	}
}
