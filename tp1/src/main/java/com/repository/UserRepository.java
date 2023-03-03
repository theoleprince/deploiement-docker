package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
