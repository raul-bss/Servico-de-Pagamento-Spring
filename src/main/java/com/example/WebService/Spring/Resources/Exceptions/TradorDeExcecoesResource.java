package com.example.WebService.Spring.Resources.Exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.WebService.Spring.Service.Exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TradorDeExcecoesResource {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ClasseDeErro> recursoNaoEncontrado (ResourceNotFoundException e, HttpServletRequest request){
		String errorMsg = "Recurso Não Encontrado";
		ClasseDeErro error = new ClasseDeErro(
				Instant.now(),
				HttpStatus.NOT_FOUND.value(),
				errorMsg,
				e.getMessage(),
				request.getRequestURI()
				);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
