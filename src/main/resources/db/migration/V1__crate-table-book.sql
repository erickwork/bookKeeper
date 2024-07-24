CREATE TABLE book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      genre VARCHAR(50),
                      availableCopies INT NOT NULL
);