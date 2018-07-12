package com.github.project.controller;

import com.github.project.dto.ClientDTO;
import com.github.project.model.Client;
import com.github.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/adminPage")
public class AdminPageController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String adminPage(Model model) {
        Set<Client> all = clientService.findAll();
        model.addAttribute("clients", all.stream().map(ClientDTO::new).collect(Collectors.toSet()));

        ClientDTO clientDTO = new ClientDTO();
        model.addAttribute("clientDTO",clientDTO);

        return "adminPage";
    }
}
