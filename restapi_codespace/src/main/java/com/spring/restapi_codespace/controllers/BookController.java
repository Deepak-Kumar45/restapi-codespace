package com.spring.restapi_codespace.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi_codespace.entity.Book;
import com.spring.restapi_codespace.exceptionhandling.UserNotFoundException;

@RestController
public class BookController {
    
    private static List<Book> books=new ArrayList<>();
    static{
        books.add(new Book(101, "Spring in Action", 324, new Date()));
        books.add(new Book(102, "Book of java programming", 200, new Date()));
        books.add(new Book(103, "codechef tips", 400, new Date()));
        books.add(new Book(104, "master python", 654, new Date()));
        books.add(new Book(106, "C programming", 235, new Date()));
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable(name = "id") int bookid){
        System.out.println("BOOK ID  "+bookid);
        Book b=null;
        try {
            b=books.stream().filter(i->i.getBookid()==bookid).findFirst().get();    
        } catch (Exception e) {
            if(e.getClass().getSimpleName().contains("NoSuchElementException"))
            {
                throw new UserNotFoundException("Book is not present with "+bookid+" Book-ID");
            }
        }
        return b;
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Book book)
    {
            Book existingBook=null;
        try {
        existingBook=books.stream().filter(i->i.getBookid()==book.getBookid()).findFirst().get();    
        } catch (Exception e) {
        }
        
        if(existingBook!=null){
            return "Book is already present with "+book.getBookid()+" Id";
        }else{
            books.add(book);
            return "Book has been sucessfully saved";
        }
    }
}
