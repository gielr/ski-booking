package com.github.project.repository;

import com.github.project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Set<Order> findAllByClientId(Long clientId);
}
