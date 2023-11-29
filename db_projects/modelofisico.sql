/* logico: */

CREATE TABLE Book (
    id bigint PRIMARY KEY,
    title varchar(200),
    author varchar(100),
    year char(4),
    genre varchar(100),
    available boolean,
    fk_Loan_id bigint
);

CREATE TABLE User (
    id bigint PRIMARY KEY,
    name varchar(250),
    phoneNumber char(10),
    enrollment char(12),
    type varchar(50)
);

CREATE TABLE Loan (
    id bigint PRIMARY KEY,
    loanDate date,
    returnDate date,
    closed boolean,
    overdue boolean,
    fk_User_id bigint
);
 
ALTER TABLE Book ADD CONSTRAINT FK_Book_2
    FOREIGN KEY (fk_Loan_id)
    REFERENCES Loan (id)
    ON DELETE CASCADE;
 
ALTER TABLE Loan ADD CONSTRAINT FK_Loan_2
    FOREIGN KEY (fk_User_id)
    REFERENCES User (id)
    ON DELETE CASCADE;