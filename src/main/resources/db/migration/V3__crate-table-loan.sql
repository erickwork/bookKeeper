CREATE TABLE loan (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      book_id BIGINT NOT NULL,
                      user_id BIGINT NOT NULL,
                      loanDate DATE NOT NULL,
                      dueDate DATE NOT NULL,
                      returnDate DATE,
                      status VARCHAR(10) NOT NULL,
                      FOREIGN KEY (book_id) REFERENCES book(id),
                      FOREIGN KEY (user_id) REFERENCES user(id)
);