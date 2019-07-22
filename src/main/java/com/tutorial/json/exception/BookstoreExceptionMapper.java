package com.tutorial.json.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BookstoreExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
	            .entity(prepareMessage(exception))
	            .type("application/json")
	            .build();
	}

	private String prepareMessage(ConstraintViolationException exception) {
		StringBuilder message = new StringBuilder();
		message.append("[");
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            message
            	.append("{")
            	.append("\"title\": ")
            	.append(cv.getMessage())
            	.append("}");
        }
        message.append("]");
        return message.toString();
	}

}
