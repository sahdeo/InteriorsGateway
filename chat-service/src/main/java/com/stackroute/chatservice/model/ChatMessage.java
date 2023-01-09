package com.stackroute.chatservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class ChatMessage {
	private String content;
	private String sender;
	private MessageType type;

	public enum MessageType {
		CHAT, LEAVE, JOIN
	}

}
