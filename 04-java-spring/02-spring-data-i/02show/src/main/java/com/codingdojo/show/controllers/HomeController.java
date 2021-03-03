package com.codingdojo.show.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.show.models.Book;
import com.codingdojo.show.repositories.BookRepository;
import com.codingdojo.show.service.BookService;


 @Controller
 public class HomeController {
 private BookService bookService = null;
 public HomeController(BookService bookService) {
     this.bookService = bookService;
 }
 
 @RequestMapping("/books")
 public String index(Model model) {
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "/books/index.jsp";
 }
 /*@RequestMapping("/books/{id}")
 public String findBookByIndex(Model model, @PathVariable("id") Long id) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "showBook.jsp";
 }*/
 @RequestMapping("/books/{index}")
 public String findBookByIndex(Model model, @PathVariable("index") int index) {
     Book book = bookService.findBookByIndex(index);
     model.addAttribute("book", book);
     return "showBook.jsp";
 }
 @RequestMapping("/books/new")
 public String newBook(@ModelAttribute("book") Book book) {
     return "/books/new.jsp";
 }
 @RequestMapping(value="/books", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/new.jsp";
     } else {
         bookService.createBook(book);
         return "redirect:/books";
     }
 }
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
 public Book update(@PathVariable("id") int id, @RequestParam(value="book") Book book) {
     Book book1 = bookService.updateBook(id, book);
     return book1;
 }
 @RequestMapping("/books/edit/{id}")
 public String editBook(@PathVariable("id") int id, Model model) {
     Book book = bookService.findBookByIndex(id);
     if (book != null){
         model.addAttribute("book", book);
         return "editBook.jsp";
     }else{
         return "redirect:/books";
     }
 }
 @PostMapping("/books/edit/{id}")
 public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "editBook.jsp";
     }
     else{
         bookService.updateBook(id, book);
         return "redirect:/books";
     }
 }
}
