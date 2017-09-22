package com.nassir.weekly.repository;

import com.nassir.weekly.domain.TaskModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nassir on 9/21/17.
 */
public interface WeeklyRepository extends CrudRepository<TaskModel, Integer> {
}
