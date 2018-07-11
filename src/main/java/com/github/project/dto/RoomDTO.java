package com.github.project.dto;

import com.github.project.model.Room;

import java.math.BigDecimal;

public class RoomDTO {
    private Long roomId;
    private Integer roomSize;
    private BigDecimal price;


    public RoomDTO() {
    }

    public RoomDTO(Room room) {
        this.roomSize = room.getRoomSize();
        this.price = room.getPrice();
        this.roomId = room.getId();
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
