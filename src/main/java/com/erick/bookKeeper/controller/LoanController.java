package com.erick.bookKeeper.controller;


import com.erick.bookKeeper.loan.CadastroLoan;
import com.erick.bookKeeper.loan.Loan;
import com.erick.bookKeeper.loan.LoanRepository;
import com.erick.bookKeeper.user.CadastroUser;
import com.erick.bookKeeper.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @PostMapping
    @Transactional
    public void addBook(@RequestBody @Valid CadastroLoan cadastroLoan) {
        loanRepository.save(new Loan(cadastroLoan));
    }
}
