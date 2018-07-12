package com.github.project.service.implementation;

import com.github.project.dto.OrderDTO;
import com.github.project.exceptions.ValidationError;
import com.github.project.exceptions.ValidationException;
import com.github.project.model.Order;
import com.github.project.repository.ClientRepository;
import com.github.project.repository.OrderRepository;
import com.github.project.repository.RoomRepository;
import com.github.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private RoomRepository roomRepository;
    private ClientRepository clientRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, RoomRepository roomRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Set<Order> findAllByClientId(Long clientId){
        return new HashSet<>(orderRepository.findAllByClientId(clientId));
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Set<Order> findAll() {
        return new HashSet<>(orderRepository.findAll());
    }

    @Override
    public Order createOrder(OrderDTO orders) {
        String bookingTime = " 13:00";
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long id = clientRepository.findByEmail(username).getId();
        orders.setClientId(id);

        String timeFrom = orders.getBookFrom() + bookingTime;
        String timeTo = orders.getBookTo() + bookingTime;
        orders.setBookFrom(timeFrom);
        orders.setBookTo(timeTo);

        validateCreation(orders.getBookFrom(), orders.getBookTo(),orders.getClientId(),orders.getRoomId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Order order = new Order();
        order.setBookDate(LocalDateTime.now());
        order.setBookFrom(LocalDateTime.parse(orders.getBookFrom(), formatter));
        order.setBookTo(LocalDateTime.parse(orders.getBookTo(), formatter));
        order.setBookPaid(false);
        order.setClient(clientRepository.findOne(orders.getClientId()));
        order.setRoom(roomRepository.findOne(orders.getRoomId()));
        order.setBookPrice(roomRepository.getOne(orders.getRoomId()).getPrice());

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findOne(id);
        validateFindById(order);
        orderRepository.delete(id);
    }

    private void validateCreation(String bookFrom, String bookTo, Long clientId, Long roomId) {
        List<ValidationError> errors = new ArrayList<>();
        if (bookFrom == null) {
            ValidationError error = new ValidationError("bookFrom", "May not be null");
            errors.add(error);
        } else if (bookFrom.isEmpty()) {
            ValidationError error = new ValidationError("bookFrom", "May not be null");
            errors.add(error);
        }

        if (bookTo == null) {
            ValidationError error = new ValidationError("BookTo", "May not be null");
            errors.add(error);
        } else if (bookTo.isEmpty()) {
            ValidationError error = new ValidationError("BookTo", "May not be null");
            errors.add(error);
        }

        if (clientId == null) {
            ValidationError error = new ValidationError("clientId", "May not be null");
            errors.add(error);
        }


        if (roomId == null) {
            ValidationError error = new ValidationError("roomId", "May not be null");
            errors.add(error);
        }


        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateFindById(Order order) {
        List<ValidationError> errors = new ArrayList<>();
        if (order == null) {
            ValidationError error = new ValidationError("id", "Wrong id");
            errors.add(error);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
