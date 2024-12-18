package com.solum.aims.msp.controller.request;

import lombok.Data;

@Data
public class MessageResponse {


    private String pfiMessage;

    private String sign;

    private String dataPath;


    private String startPath;


    private String answerPath;

    private String messageFilePath;


}
