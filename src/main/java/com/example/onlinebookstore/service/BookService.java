package com.example.onlinebookstore.service;

import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.model.Status;
import com.example.onlinebookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final  BookRepository bookRepository;

    public Book addBook(Book book) {
        //check the book title doesn't exist
        if (book != null) {
            //check that user enter all required data.
            if (book.getCategory() != null && book.getStatus() != null && book.getTitle() != null) {
                Book findedTitleBook = bookRepository.findByTitle(book.getTitle());
                //check the book title doesn't exist
                if (findedTitleBook == null) {
                    bookRepository.save(book);
                    return book;
                }
                else return null;
            }
            else return null;
        }

           return null;
    }

    public Optional<Book> findBookByID(Long id) {
        if (id != null && id > 0) {
            Optional<Book> book = bookRepository.findById(id);
            return book;
        }
        return null;
    }
    public Book updateBook(Long id,Book bookUpdated){
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent()){
         Book updatedBook=new Book();

         if(bookUpdated.getStatus()!=null)updatedBook.setStatus(bookUpdated.getStatus());
         else updatedBook.setStatus(book.get().getStatus());
         if(bookUpdated.getTitle()!=null)updatedBook.setTitle(bookUpdated.getTitle());
         else updatedBook.setTitle(book.get().getTitle());
         if(bookUpdated.getCategory()!=null)updatedBook.setCategory(bookUpdated.getCategory());
         else updatedBook.setCategory(book.get().getCategory());

         updatedBook.setId(id);

            bookRepository.save(updatedBook);

            return updatedBook;
        }
        else return null;
    }

    public List<Book> findBooksByCategory(String category){
        List<Book>books=bookRepository.findByCategory(category);
        return books;
    }
    public boolean requestToBorrowBook(Long id){
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent()){
            if(book.get().getStatus().equals(Status.AVAILABLE))return true;
            else return false;
        }
        else return false;
    }
}
