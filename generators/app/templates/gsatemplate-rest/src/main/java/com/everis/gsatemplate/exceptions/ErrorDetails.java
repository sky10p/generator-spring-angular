package com.everis.<%= appName %>.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class ErrorDetails
{

    private String name;
    private String message;
    private int status;
    
    public ErrorDetails(Throwable ex, int status, WebRequest request)
    {
        this(ex,status);

    }

    public ErrorDetails(Throwable ex, int status)
    {
        super();
        message = ex.getMessage();
        name = ex.getClass().getSimpleName();
        this.status = status;

    }

    public ResponseEntity<ErrorDetails> asResponseEntity()
    {
        ResponseEntity<ErrorDetails> responseEntity;
        HttpStatus httpStatus;

        httpStatus = HttpStatus.valueOf(status);
        responseEntity = new ResponseEntity<>(this, httpStatus);

        return responseEntity;
    }
    
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

}
