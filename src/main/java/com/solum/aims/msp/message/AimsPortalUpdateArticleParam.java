package com.solum.aims.msp.message;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class AimsPortalUpdateArticleParam {

	private List<AimsPortalArticleMessage> dataList = new ArrayList<>();
}
