package com.example.Books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Books.entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer>{

}
