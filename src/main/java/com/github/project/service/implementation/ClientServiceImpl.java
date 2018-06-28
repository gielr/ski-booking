package com.github.project.service.implementation;

import com.github.project.dto.ClientDTO;
import com.github.project.exceptions.ValidationError;
import com.github.project.exceptions.ValidationException;
import com.github.project.model.Client;
import com.github.project.repository.ClientRepository;
import com.github.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(Long id) {
        Client client = clientRepository.findOne(id);
        validateFindById(client);
        return client;
    }

    @Override
    public Set<Client> findAll() {
        return new HashSet<>(clientRepository.findAll());
    }

    @Override
    public Client createClient(ClientDTO clientDTO) {
        validateCreation(clientDTO.getName(), clientDTO.getSurname());

        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findOne(id);
        validateFindById(client);
        clientRepository.delete(id);
    }

    private void validateCreation(String name, String surname) {
        List<ValidationError> errors = new ArrayList<>();
        if (name == null) {
            ValidationError error = new ValidationError("name", "May not be null");
            errors.add(error);
        } else if (name.isEmpty()) {
            ValidationError error = new ValidationError("name", "May not be null");
            errors.add(error);
        }

        if (surname == null) {
            ValidationError error = new ValidationError("surname", "May not be null");
            errors.add(error);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateFindById(Client client) {
        List<ValidationError> errors = new ArrayList<>();
        if (client == null) {
            ValidationError error = new ValidationError("id", "Wrong id");
            errors.add(error);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}