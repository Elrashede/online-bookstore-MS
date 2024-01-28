package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{requestedId}")
//   @PreAuthorize("hasAuthority('CUSTOMER') or hasRole(ADMIN)")
    private ResponseEntity<Book> findById(@PathVariable Long requestedId) {
        Optional<Book> foundBook = bookService.findBookByID(requestedId);
        if (foundBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(foundBook.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ADMIN')")
    private ResponseEntity<String> addBook(@RequestBody Book newBook) {
        Book savedBook = bookService.addBook(newBook);
        if(savedBook!=null)
         return ResponseEntity.status(HttpStatus.CREATED).body("Book Added Successfully");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't Add Book, Please Enter a Valid Date and The Title Must be Unique");
    }
    @PutMapping("/update/{requestedId}")
//   @PreAuthorize("hasAuthority('ADMIN')")
    private ResponseEntity<Book> updateBook(@PathVariable Long requestedId, @RequestBody Book bookUpdated, Principal principal) {
        Book book = bookService.updateBook(requestedId, bookUpdated);
        if (book != null) return ResponseEntity.status(HttpStatus.CREATED).body(book);
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/category/{category}")
//   @PreAuthorize("hasAuthority('CUSTOMER')or hasRole(ADMIN)")
    private ResponseEntity<List<Book>> findByCategory(@PathVariable String category) {
        List<Book> foundBooks = bookService.findBooksByCategory(category);
        if (foundBooks.size()>0) {
            return ResponseEntity.status(HttpStatus.OK).body(foundBooks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/borrow/{id}")
//    @PreAuthorize("hasAuthority('CUSTOMER')or hasRole(ADMIN)")
    private ResponseEntity<String> requestToBorrowBook(@PathVariable Long id) {
        boolean availableBook = bookService.requestToBorrowBook(id);
        if (availableBook==true) {
            return ResponseEntity.status(HttpStatus.OK).body("The Book Is Available For Borrowing");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Book Is Not_Available For Borrowing");
        }
    }
}
