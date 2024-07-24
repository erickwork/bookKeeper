package com.erick.bookKeeper.repository;

import com.erick.bookKeeper.domain.Loan;
import com.erick.bookKeeper.enums.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByUser(Long user);

    Loan findById(BigInteger loanId);

    List<Loan> findByUserAndStatus(Long userId, LoanStatus status);
}
