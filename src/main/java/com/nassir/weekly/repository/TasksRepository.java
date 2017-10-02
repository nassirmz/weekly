package com.nassir.weekly.repository;

import com.nassir.weekly.domain.TaskModel;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.concurrent.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by nassir on 9/21/17.
 */
@Repository
public interface TasksRepository extends CrudRepository<TaskModel, Integer> {

    Collection<TaskModel> findAll();

    TaskModel save(TaskModel task);
}
