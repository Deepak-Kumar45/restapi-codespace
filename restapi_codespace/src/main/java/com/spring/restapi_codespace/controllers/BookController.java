package com.spring.restapi_codespace.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi_codespace.entity.Book;
import com.spring.restapi_codespace.exceptionhandling.UserNotFoundException;
import org.springframework.web.bind.annotation.PutMapping;


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
        Book b=getSingleBook(bookid);
        return b;
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Book book)
    {
        Book existingBook=null;
        try{
            existingBook=books.stream().filter(i->i.getBookid()==book.getBookid()).findFirst().get();
        }catch(Exception ex){
            System.out.println(ex.getClass().getSimpleName());
            if(ex.getClass().getSimpleName().contains("NoSuchElementException")){
                existingBook=null;
            }
        }

        if(existingBook!=null){
            return "Book is already present with this id. Try Another id";
        }else{
            books.add(book);
        }
        return "Book has been sucessfully saved with "+book.getBookid()+" ID";
        
    }

    public Book getSingleBook(int id)
    {
      Book b=null;
      try {
        b=books.stream().filter(i->i.getBookid()==id).findFirst().get();
      } catch (Exception e) {
        if(e.getClass().getSimpleName().contains("NoSuchElementException"))
        {
             throw new UserNotFoundException("Book is not present with "+id+" Book-ID");
        }else{
            e.printStackTrace();
        }
      }
      return b;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") int bookid)
    {
        Book book=getSingleBook(bookid);
        if(book!=null)
        {
            books.remove(book);
            return "Book has been succesfully removed with "+bookid+" ID";
        }else{
            return "No data is available with "+bookid+" ID";
        }
    }

    @PutMapping(value="books/{id}")
    public Book putMethodName(@PathVariable("id") String bookid, @RequestBody Book book) {
        System.out.println("Put mapping is callled");

        return book;
    }

}
