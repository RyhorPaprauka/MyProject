CREATE SCHEMA shop_storage;

CREATE TABLE shop_storage.user (
                                 id SERIAL PRIMARY KEY,
                                 login VARCHAR(124) NOT NULL UNIQUE ,
                                 password VARCHAR(124) NOT NULL ,
                                 real_name VARCHAR(124) NOT NULL ,
                                 mail VARCHAR(124) NOT NULL ,
                                 address VARCHAR(124) NOT NULL ,
                                 phone CHAR(17),
                                 role VARCHAR(32)
);

CREATE TABLE shop_storage.book(
                                id BIGSERIAL PRIMARY KEY ,
                                name VARCHAR(124) NOT NULL,
                                img_link VARCHAR(254),
                                genre VARCHAR(64) NOT NULL ,
                                price INTEGER NOT NULL ,
                                quantity INTEGER NOT NULL
)