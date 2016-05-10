package com.X.common.http;

import java.io.IOException;

public class HttpRequestException extends RuntimeException {

	private static final long serialVersionUID = -1170466989781746231L;
	
	public HttpRequestException(final IOException cause) {
		super(cause);
	}
	
	@Override
	public IOException getCause() {
		return (IOException) super.getCause();
	}
}