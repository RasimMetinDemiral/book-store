package com.project.bookstore;

import com.project.bookstore.model.Book;
import com.project.bookstore.model.Order;
import com.project.bookstore.repository.OrderRepository;
import com.project.bookstore.service.BookService;
import com.project.bookstore.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    @Mock
    private BookService bookService;

    @Mock
    private OrderRepository orderRepository;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(bookService, orderRepository);
    }

    @Test
    void putAnOrder_shouldCreateOrderAndReturnIt() {
        List<Integer> bookIdList = Arrays.asList(1, 2, 3);
        String userName = "testUser";

        when(bookService.findBookById(anyInt())).thenReturn(Optional.of(new Book(15,"testName","testAuthor",15.0,2)));
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Order resultOrder = orderService.putAnOrder(bookIdList, userName);

        assertEquals(bookIdList, resultOrder.getBookIdList());
        assertEquals(userName, resultOrder.getUserName());

    }
    @Test
    void getAllOrder_shouldReturnAllOrders() {

        List<Order> mockOrders = Arrays.asList(
                new Order(15,"testOrder",new ArrayList<>(15),15.0)
        );
        when(orderRepository.findAll()).thenReturn(mockOrders);

        List<Order> resultOrders = orderService.getAllOrder();
        assertEquals(mockOrders.size(), resultOrders.size());

    }

}