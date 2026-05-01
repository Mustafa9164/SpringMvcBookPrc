package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	private ModelAndView getBookById(@RequestParam("id") Integer id) {
		System.out.println("Id"+id);
		ModelAndView mav =new ModelAndView();
		
		Optional<Book> findById = bookRepo.findById(id);
		
		if(findById.isPresent()) {
			Book bookObj = findById.get();
			mav.addObject("book", bookObj);
		}
		
		mav.setViewName("index");
		
		return mav;
	}
	

}
