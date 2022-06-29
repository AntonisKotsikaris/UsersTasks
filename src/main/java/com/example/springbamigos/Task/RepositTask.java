package com.example.springbamigos.Task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RepositTask extends PagingAndSortingRepository<Task,Integer> {
    Task getById(Long id);

    Page<Task> findTasksByUserId(Long userId, Pageable page);



}
