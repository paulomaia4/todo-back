package com.paulomaia.todo2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulomaia.todo2022.model.Todo;

public interface TodoRepository  extends JpaRepository<Todo, Long>{

}
