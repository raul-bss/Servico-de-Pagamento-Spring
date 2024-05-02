package com.example.WebService.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.WebService.Spring.Entites.User;
import com.example.WebService.Spring.Repositories.UserRepository;
import com.example.WebService.Spring.Service.Exceptions.DatabaseException;
import com.example.WebService.Spring.Service.Exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {	
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Id not found " + id));
	}
	
	public User insert (User obj) {
		return repository.save(obj);
	}
	
	public void deleteUser(Long id) {
	    try {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    }catch(DataIntegrityViolationException  e) {			
	    	throw new DatabaseException(e.getMessage());
		}
	} 
	
	public User updateUser (Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity,obj);
			return repository.save(entity);
			
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

		
	}
	
	public void updateData(User entity, User obj) {
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPhone(obj.getPhone());
		
	}
}
