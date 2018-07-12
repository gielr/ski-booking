package com.github.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookingTime")
public class BookingTimeController {
    @GetMapping
    public String bookingTime() {
        return "bookingTime";
    }

    @PostMapping
    public String showAvailableRooms(){
        return "bookingTime";
    }
}
