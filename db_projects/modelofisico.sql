/* logico: */

CREATE TABLE Book (
    id bigint PRIMARY KEY,
    title varchar(200),
    author varchar(100),
    year char(4),
    genre varchar(100),
    available boolean
);

CREATE TABLE User (
    id bigint PRIMARY KEY,
    name varchar(250),
    phoneNumber char(10),
    enrollment char(12),
    type varchar(50),
    fk_Loan_id bigint
);

CREATE TABLE Loan (
    id bigint PRIMARY KEY,
    loanDate date,
    returnDate date,
    closed boolean,
    overdue boolean,
    fk_Book_id bigint
);
 
ALTER TABLE User ADD CONSTRAINT FK_User_2
    FOREIGN KEY (fk_Loan_id)
    REFERENCES Loan (id)
    ON DELETE CASCADE;
 
ALTER TABLE Loan ADD CONSTRAINT FK_Loan_2
    FOREIGN KEY (fk_Book_id)
    REFERENCES Book (id)
    ON DELETE CASCADE;