# challenge-crud-clientes

##script data base
        CREATE DATABASE taller_bd
        USE taller_bd
        
        
        CREATE TABLE clientes(
            id INT(11) PRIMARY KEY AUTO_INCREMENT,
            name VARCHAR(30) NOT NULL,
            lastname VARCHAR(30)NOT NULL,
            birthdate CHAR(10) NOT NULL,
            age INT(3) NOT NULL
        );
        
        INSERT INTO clientes (name, lastname, birthdate,age) VALUES ('Danilo', 'Carrasco', '2010-10-08', 24);
        INSERT INTO clientes (name, lastname, birthdate,age) VALUES ('David', 'Guerra', '2010-10-08', 24);
