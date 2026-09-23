package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPayment extends JpaRepository<Payment,Long> {
}
