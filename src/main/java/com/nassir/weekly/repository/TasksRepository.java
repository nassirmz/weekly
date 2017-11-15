package com.nassir.weekly.repository;

import com.nassir.weekly.domain.TaskModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TasksRepository extends CrudRepository<TaskModel, Integer> {

    Collection<TaskModel> findAll();

    TaskModel save(TaskModel task);

    void deleteAll();
}
