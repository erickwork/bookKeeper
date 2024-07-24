package com.erick.bookKeeper.repository;

import com.erick.bookKeeper.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
