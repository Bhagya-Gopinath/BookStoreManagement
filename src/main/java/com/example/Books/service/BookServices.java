package com.example.Books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Books.entity.Books;
import com.example.Books.repository.BookRepository;

@Service
public class BookServices {
	
	@Autowired
	private BookRepository brepo;
	public void save(Books b) {
		brepo.save(b);
	}

	
	public List<Books> getAllBooks(){
		return brepo.findAll();
	}
	
	public Books getBookById(int id) {
		return brepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		brepo.deleteById(id);
	}
}
