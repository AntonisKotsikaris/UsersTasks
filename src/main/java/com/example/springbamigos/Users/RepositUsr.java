package com.example.springbamigos.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RepositUsr extends PagingAndSortingRepository<User,Integer> {
    User getById(long id);
    Page<User> findAll(Pageable page);


}
