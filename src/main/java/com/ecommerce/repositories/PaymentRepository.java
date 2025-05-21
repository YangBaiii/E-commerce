package com.ecommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}