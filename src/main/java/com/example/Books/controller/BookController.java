package com.example.Books.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Books.entity.Books;
import com.example.Books.entity.MyBookList;
import com.example.Books.service.BookServices;
import com.example.Books.service.MyBookListService;



@Controller
public class BookController {
	
	@Autowired
	private BookServices service;
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// register a new book
	
	@GetMapping("/book_register")
	public String bookRegister() {
		
		return "bookRegister";
	}
	
	//display all books
	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<Books> list=service.getAllBooks();
		return new ModelAndView("booklist","books",list);
	}
	
	//saving new book
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Books b) {
		service.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks( Model model) {
		List<MyBookList> list=myBookService.getAllMyBooks();
		// sending the list in the mybook page
		model.addAttribute( "books",list);
		return "myBooks";
	}

	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Books b= service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBook(mb);
		return "redirect:/my_books";
}
@RequestMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
	Books b=service.getBookById(id);
	model.addAttribute("books", b);
		return "bookEdit";
	}

@RequestMapping("/deletebook/{id}")
public String deleteBook(@PathVariable("id") int id) {
	service.deleteById(id);
	return "redirect:/available_books";
}
}