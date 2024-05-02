package com.example.WebService.Spring.Resources.Exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.WebService.Spring.Service.Exceptions.DatabaseException;
import com.example.WebService.Spring.Service.Exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TradorDeExcecoesResource {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ClasseDeErro> recursoNaoEncontrado (ResourceNotFoundException e, HttpServletRequest request){
		
		String errorMsg = "Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ClasseDeErro error = new ClasseDeErro(
				Instant.now(),
				status.value(),
				errorMsg,
				e.getMessage(),
				request.getRequestURI()					
				);	
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ClasseDeErro> database (DatabaseException e, HttpServletRequest request){
		
		String errorMsg = "Database Error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ClasseDeErro error = new ClasseDeErro(
				Instant.now(),
				status.value(),
				errorMsg,
				e.getMessage(),
				request.getRequestURI()					
				);	
		
		return ResponseEntity.status(status).body(error);
	}

}
