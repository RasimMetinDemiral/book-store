package com.project.bookstore.controller;


import com.project.bookstore.dto.BookOrderRequest;
import com.project.bookstore.model.Book;
import com.project.bookstore.model.Order;
import com.project.bookstore.service.BookService;
import com.project.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookStore")
public class BookStoreController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> gelAllBook(){
        List<Book> bookList = bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> gelAllOrders(){
        List<Order> orderList = orderService.getAllOrder();
        return ResponseEntity.ok(orderList);
    }
    @PostMapping
    public ResponseEntity<Order> putAndOrder(@RequestBody BookOrderRequest bookOrderRequest){
        Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(),bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }
}
