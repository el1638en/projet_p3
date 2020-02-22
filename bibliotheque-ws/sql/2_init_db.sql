-- creation table work
create table T_WORK
(
    W_ID               SERIAL,
    W_TITLE            VARCHAR(100) NOT NULL,
    W_AUTHOR           VARCHAR(50)  NOT NULL,
    W_PUBLICATION_DATE VARCHAR(4)         NOT NULL,
    W_DESCRIPTION      VARCHAR(255) NOT NULL,
    PRIMARY KEY (W_ID) -- Définition de la clé primaire de la table
);

INSERT INTO T_WORK (W_TITLE, W_AUTHOR, W_PUBLICATION_DATE, W_DESCRIPTION)
VALUES ('Vacances dans le comas', 'Frederic Beigbeder', '1994', 'Roman'),
       ('99 Francs', 'Frederic Beigbeder', '2000', 'Roman'),
       ('Windows on the world', 'Frederic Beigbeder', '2003', 'Roman'),
       ('Un roman francais', 'Frederic Beigbeder', '2009', 'Roman'),
       ('Une vie sans fin', 'Frederic Beigbeder', '2018', 'Roman'),
       ('Harry Potter et le coupe de feu', 'JK Rowling', '2000', 'Fantastique'),
       ('Harry Potter et lordre du phoenix', 'JK Rowling', '2003', 'Fantastique'),
       ('Harry Potter et les reliques de la mort', 'JK Rowling', '2009', 'Fantastique'),
       ('Insomnie', 'Stephen King', '1994', 'Fiction'),
       ('Sleaping Beauties', 'Stephen King', '2018', 'Fiction');


-- creation table user
create table T_USER
(
    U_ID       SERIAL,
    U_USERNAME VARCHAR(100) NOT NULL,
    U_PASSWORD VARCHAR(50)  NOT NULL,
    U_NAME VARCHAR(100) NOT NULL,
    U_FIRST_NAME VARCHAR(100)  NOT NULL,
    PRIMARY KEY (U_ID) -- Définition de la clé primaire de la table
);

INSERT INTO T_USER (U_USERNAME, U_PASSWORD, U_NAME, U_FIRST_NAME)
VALUES ('clement', 'CLEMENT', 'clement', 'biotteau'),
       ('serge', 'SERGE', 'serge', 'biotteau'),
       ('oscar', 'OSCAR','oscar', 'biotteau');

-- creation table member
create table T_MEMBER
(
    M_ID       SERIAL,
    M_NAME VARCHAR(50)  NOT NULL,
    M_MAIL VARCHAR(100) NOT NULL,
    M_FIRST_NAME VARCHAR(50) NOT NULL,
    M_TEL VARCHAR(10) NOT NULL,
    M_ADRESS VARCHAR(100) NOT NULL,
    PRIMARY KEY (M_ID) -- Définition de la clé primaire de la table
);


INSERT INTO T_MEMBER (M_NAME, M_MAIL, M_FIRST_NAME, M_TEL, M_ADRESS)
VALUES ('clement', 'clem.biotteau@gmail.com', 'biotteau', '0642335349', 'clichy'),
       ('oscar', 'oscar.biotteau@gmail.com', 'biotteau', '0642335349', 'clichy');

-- creation table library
create table T_LIBRARY
(
    L_ID   SERIAL,
    L_NAME VARCHAR(100) NOT NULL,
    L_CITY VARCHAR(100) NOT NULL,
    PRIMARY KEY (L_ID) -- Définition de la clé primaire de la table
);

-- creation table book
create table T_BOOK
(
    BOOK_ID        SERIAL,
    BOOK_AVAILABLE BOOLEAN NOT NULL,

    PRIMARY KEY (BOOK_ID) -- Définition de la clé primaire de la table
);

-- creation table borrow
create table T_BORROW
(
    B_ID                SERIAL,
    B_STATUS            VARCHAR(100) NOT NULL,
    B_START_BORROW_DATE DATE         NOT NULL,
    B_END_BORROW_DATE   DATE         NOT NULL,
    B_EXTENDED          BOOLEAN      NOT NULL,
    B_WORK_TITLE        VARCHAR(100) NOT NULL,
    B_MEMBER_ID         INTEGER REFERENCES T_MEMBER(M_ID),
    B_BOOK_ID           INTEGER REFERENCES T_BOOK(BOOK_ID),
    PRIMARY KEY (B_ID) -- Définition de la clé primaire de la table
);



INSERT INTO T_BOOK (BOOK_AVAILABLE)
VALUES ('false'),
       ('false'),
       ('false'),
       ('false'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true'),
       ('true');



-- creation table work_book
create table T_WORK_BOOK
(
    WB_BOOK_ID INTEGER REFERENCES T_BOOK(BOOK_ID),
    WB_WORK_ID INTEGER REFERENCES T_WORK(W_ID),

    PRIMARY KEY (WB_BOOK_ID) -- Définition de la clé primaire de la table


);

INSERT INTO T_WORK_BOOK (WB_BOOK_ID, WB_WORK_ID)
VALUES (1,1),
       (2,1),
       (3,2),
       (4,3),
       (5,3),
       (6,4),
       (7,4),
       (8,4),
       (9,5),
       (10,6),
       (11,7),
       (12,7),
       (13,7),
       (14,8),
       (15,8),
       (16,9),
       (17,9),
       (18,10),
       (19,10),
       (20,10);





