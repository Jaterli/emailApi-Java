package com.example.emailApi.repository;

import com.example.emailApi.models.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
}
