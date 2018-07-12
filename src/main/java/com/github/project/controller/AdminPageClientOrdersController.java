package com.github.project.controller;

import com.github.project.dto.ClientDTO;
import com.github.project.model.Client;
import com.github.project.model.Order;
import com.github.project.service.ClientService;
import com.github.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/adminPage/clientOrders")
public class AdminPageClientOrdersController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String show(Model model, ClientDTO clientDTO) {
        String email = clientDTO.getEmail();
        Client client = clientService.findByEmail(email);
        Long clientId = client.getId();

        Set<Order> clientOrders = orderService.findAllByClientId(clientId);
        model.addAttribute("clientOrders",clientOrders);

        return "adminPageClientOrders";
    }
}
