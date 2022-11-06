//ErrorDetails.java

package com.kaiburr.document;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

	private LocalDateTime time;
	private String status;
	private String message;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime time, String status, String message) {
		super();
		this.time = time;
		this.status = status;
		this.message = message;
	}

}
