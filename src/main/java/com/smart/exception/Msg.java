package com.smart.exception;

import lombok.Getter;
import lombok.ToString;

/**
 * @author lavesh
 *
 */

@ToString
@Getter
public class Msg {

	private String content;
	private String type;

	public Msg(String content, String type) {
		this.content = content;
		this.type = type;
	}

}
