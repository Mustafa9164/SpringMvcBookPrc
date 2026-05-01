package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Book;
import com.repo.BookRepo;


@Controller
public class BookController {
	
	@Autowired
	private BookRepo bookRepo;
	
	@GetMapping("/book")
	private String getBookById(@RequestParam("id") Integer id, Model  model) {
		
		Optional<Book> findById = bookRepo.findById(id);
		
		if(findById.isPresent()) {
			Book bookObj = findById.get();
			model.addAttribute("book", bookObj);
		}
		
		 return "index";
		
	}
	

}
