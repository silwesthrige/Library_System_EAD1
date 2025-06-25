CREATE DATABASE library;
USE library;

CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
);

CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    category VARCHAR(100),
    quantity INT
);

CREATE TABLE issued_books (
    issue_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    book_id INT,
    issue_date VARCHAR(100) NOT NULL,
    return_date VARCHAR(100) NOT NULL,
    status VARCHAR(20),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role ENUM('Admin', 'User') NOT NULL
);

-- Insert a default admin
INSERT INTO users (username, password, role)
VALUES ('admin', 'admin123', 'Admin');

-- Insert a sample user
INSERT INTO users (username, password, role)
VALUES ('student1', 'pass123', 'User');
DROP table issued_books;
SELECT * FROM users;
SELECT * FROM books;
SELECT * FROM issued_books;
DELETE  FROM issued_books WHERE issue_id = 1;


UPDATE books SET quantity = quantity - 1 WHERE book_id = 1;
SELECT ib.issue_id, s.name AS student_name, b.title AS book_title
FROM issued_books ib
JOIN students s ON ib.student_id = s.student_id
JOIN books b ON ib.book_id = b.book_id
WHERE ib.status = 'Issued';
        