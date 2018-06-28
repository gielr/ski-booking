package com.github.project.dto;

import com.github.project.model.Client;
import com.github.project.model.ServiceType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AnotherServiceDTO {


    private Timestamp rentFrom;
    private Timestamp rentTo;


    private Client client;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    public AnotherServiceDTO() {
    }

    public AnotherServiceDTO(Timestamp rentFrom, Timestamp rentTo, Client client, ServiceType serviceType) {
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
        this.client = client;
        this.serviceType = serviceType;
    }

    public Timestamp getRentFrom() {
        return rentFrom;
    }

    public void setRentFrom(Timestamp rentFrom) {
        this.rentFrom = rentFrom;
    }

    public Timestamp getRentTo() {
        return rentTo;
    }

    public void setRentTo(Timestamp rentTo) {
        this.rentTo = rentTo;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
