package com.paulomaia.todo2022.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.paulomaia.todo2022.model.Todo;
import com.paulomaia.todo2022.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {
	
	@Autowired
	private TodoRepository repository;
	
	@PostMapping
	public Todo save( @RequestBody Todo todo ) {
		return repository.save(todo);
	}
	
	@GetMapping("{id}")
	public Todo getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	@GetMapping
	public List<Todo> getAll(){
		return repository.findAll();
		
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PatchMapping("{id}/finalizado")//ATUALIZAÇÃO PARCIAL DO OBJETO
	public Todo concluido(@PathVariable Long id) {
		return repository.findById(id).map(todo -> {
			todo.setFinalizado(true);
			todo.setDataTermino(LocalDateTime.now());
			repository.save(todo);
			return todo;
		}).orElse(null);
	}

}
