package com.solum.aims.msp.message;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class MetroMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2274164180036986629L;

	@NotNull @NotEmpty 
	private PFiMessage pfiMessage;
	
	@NotNull @NotEmpty 
	private String sign;
	
	private String dataPath;
	
	@NotNull @NotEmpty 
	private String startPath;
	
	@NotNull @NotEmpty 
	private String answerPath;
	
	private String messageFilePath;
	
	public void setPfiMessage(String message) {
		this.pfiMessage = PFiMessage.valueOf(message.toUpperCase());
	}
	
	public enum PFiMessage {
		DELETE,
		UPDATE,
		TARGETLINK,
		NONE;
	}
}
