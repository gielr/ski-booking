package com.github.project.dto;

import com.github.project.model.Order;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

public class OrderDTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookTo;

    private Long roomId;
    private Long clientId;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.bookFrom = order.getBookFrom();
        this.bookTo = order.getBookTo();
        this.roomId = order.getRoom().getId();
        this.clientId = order.getClient().getId();
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
