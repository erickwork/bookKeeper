package com.erick.bookKeeper.controller;


import com.erick.bookKeeper.domain.Book;
import com.erick.bookKeeper.dto.CadastroLoan;
import com.erick.bookKeeper.domain.Loan;
import com.erick.bookKeeper.dto.DevolutionBook;
import com.erick.bookKeeper.enums.LoanStatus;
import com.erick.bookKeeper.repository.LoanRepository;
import com.erick.bookKeeper.service.BookService;
import com.erick.bookKeeper.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanService loanService;

    @Autowired
    private BookService bookService;

    @PostMapping
    @Transactional
    public void addBook(@RequestBody @Valid CadastroLoan cadastroLoan) {
        var disponivel = bookService.isBookAvailable(cadastroLoan.book());
        if(disponivel) {
            loanRepository.save(new Loan(cadastroLoan));
            bookService.rentBook(cadastroLoan.book());
        }
    }

    @GetMapping("/{loan}")
    public List<Loan> getLoans(@PathVariable Long loan) {
        return loanRepository.findByUser(loan);
    }

    @GetMapping("/active/{loan}")
    public List<Loan> getLoansStatusActive(@PathVariable Long loan) {
        return loanRepository.findByUserAndStatus(loan, LoanStatus.ACTIVE);
    }

    @GetMapping
    public List<Loan> getLoansStatusActive() {
        return loanRepository.findAll();
    }

    @PostMapping
    @RequestMapping("/devolver")
    @Transactional
    public void devolverLoan(@RequestBody DevolutionBook devolutionBook) {
        var emprestimo = loanRepository.findById(devolutionBook.loan());
        emprestimo.setStatus(LoanStatus.RETURNED);
        emprestimo.setReturnDate(devolutionBook.returnDate());
        bookService.devolutionBook(emprestimo.getBook());
    }


}
