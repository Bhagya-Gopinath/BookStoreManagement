package com.example.Books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Books.entity.MyBookList;
import com.example.Books.repository.MyBookRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository mybook;
	
	// save
	public void saveMyBook(MyBookList books) {
     mybook.save(books);
}
	
	// to list the data in the form of table
	
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}

	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}