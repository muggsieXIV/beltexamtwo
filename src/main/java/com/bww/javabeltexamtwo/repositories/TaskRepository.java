package com.bww.javabeltexamtwo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bww.javabeltexamtwo.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
