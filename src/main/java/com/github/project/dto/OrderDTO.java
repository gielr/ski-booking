package com.github.project.dto;

import com.github.project.model.Order;

import java.time.format.DateTimeFormatter;

public class OrderDTO {
    private String bookFrom;
    private String bookTo;

    private Long roomId;
    private Long clientId;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.bookFrom = order.getBookFrom().format(formatter);
        this.bookTo = order.getBookTo().format(formatter);
        this.roomId = order.getRoom().getId();
        this.clientId = order.getClient().getId();
    }

    public String getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(String bookFrom) {
        this.bookFrom = bookFrom;
    }

    public String getBookTo() {
        return bookTo;
    }

    public void setBookTo(String bookTo) {
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
