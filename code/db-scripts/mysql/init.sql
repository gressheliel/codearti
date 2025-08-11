CREATE DATABASE IF NOT EXISTS inventory;
use inventory;

CREATE TABLE products (
    id INT NOT NULL,
    code varchar(50) NOT NULL,
    nameProduct varchar(250) NOT NULL,
    stock INT NOT NULL,
    price DOUBLE NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE products MODIFY COLUMN id int auto_increment NOT NULL;

ALTER TABLE products MODIFY COLUMN code varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci unique NOT NULL;