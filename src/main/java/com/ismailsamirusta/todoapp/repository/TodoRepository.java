package com.ismailsamirusta.todoapp.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.repository.CrudRepository;

import com.ismailsamirusta.todoapp.model.Todo;

public interface TodoRepository  extends CrudRepository<Todo, String> {
    List<Todo> findByTitle(String title);
    List<Todo> findByTitleContaining(String title);
    List<Todo> findByDescriptionContaining(String description);
    List<Todo> findByComplete(boolean complete);
    List<Todo> findByDueLessThan(DateTime date);
    List<Todo> findByDueGreaterThan(DateTime date);
}
