package com.github.project.controller;

import com.github.project.dto.OrderDTO;
import com.github.project.dto.RoomDTO;
import com.github.project.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room/roomInfo")
public class RoomInfoController {
    private RoomService roomService;

    @Autowired
    public RoomInfoController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    public String findOneById(@PathVariable Long id, Model model) {
        RoomDTO roomDTO = new RoomDTO(roomService.findById(id));
        model.addAttribute("room", roomDTO);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setRoomId(id);
        model.addAttribute("orderDTO", orderDTO);
        return "roomInfo";
    }
}
