package com.erick.bookKeeper.loan;


import com.erick.bookKeeper.book.Book;
import com.erick.bookKeeper.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loan")
@Entity(name = "Loan")
@EqualsAndHashCode(of = "id")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_id")
    private Long book;
    @Column(name = "user_id")
    private Long user;

    @Column(name = "loan_date", columnDefinition = "DATE")
    private LocalDate loanDate;
    @Column(name = "due_date", columnDefinition = "DATE")
    private LocalDate dueDate;
    @Column(name = "return_date", columnDefinition = "DATE")
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public Loan(CadastroLoan cadastroLoan) {

        this.book = cadastroLoan.book();
        this.user = cadastroLoan.user();
        this.loanDate = cadastroLoan.loanDate();
        this.dueDate = cadastroLoan.dueDate();
        this.returnDate = cadastroLoan.returnDate();
        this.status = Status.ACTIVE;

    }
}
