CREATE DATABASE belajar_spring_restful_api;

USE belajar_spring_restful_api;

CREATE TABLE users
(
    username         VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    name             VARCHAR(100) NOT NULL,
    token            VARCHAR(100),
    token_expired_at BIGINT,
    PRIMARY KEY (username),
    UNIQUE (token)
) ENGINE InnoDB;

SELECT *
FROM users;

DESC users;

CREATE TABLE contacts
(
    id         varchar(100) not null,
    username   varchar(100) not null,
    first_name varchar(100) not null,
    last_name  varchar(100),
    phone      varchar(100),
    email      varchar(100),
    primary key (id),
    foreign key fk_users_contacts (username) REFERENCES users (username)
) engine InnoDB;

DESC contacts;