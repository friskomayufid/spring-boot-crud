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

CREATE TABLE addresses
(
    id          varchar(100) not null,
    contact_id  varchar(100) not null,
    street      varchar(200),
    city        varchar(100),
    province    varchar(100),
    country     varchar(100) not null,
    postal_code varchar(10)  not null,
    primary key (id),
    foreign key fk_contacts_addresses (contact_id) references contacts (id)
) engine InnoDB;

DESC addresses;