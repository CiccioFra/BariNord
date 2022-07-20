-- creazione USER
CREATE USER 'BariNord'@'%' IDENTIFIED VIA mysql_native_password
    USING '***';GRANT ALL PRIVILEGES ON *.* TO 'BariNord'@'%' REQUIRE NONE
    WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
-- creazione DB
CREATE DATABASE IF NOT EXISTS `BariNord`;
-- concessione privilegi ad USER su DB
GRANT ALL PRIVILEGES ON `BariNord`.* TO 'BariNord'@'%';

-- Creazione Tabella fermate
Create TABLE fermate (id_fermata INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100) NOT NULL, urbana INT NOT NULL DEFAULT 0, zona VARCHAR(5) NOT NULL);

-- Creazione Tabella LINEE
Create TABLE linee (id_linea INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100) NOT NULL);

-- Creazione Tabella preventivi
Create TABLE preventivi (id_preventivo INT AUTO_INCREMENT PRIMARY KEY, nomeAzienda VARCHAR(100) NOT NULL, nomePiano VARCHAR(100) NOT NULL,
                         nrMaxFermate INT, nrMaxFermateExtra INT, nrMaxZone INT, prezzo DOUBLE NOT NULL);

-- Creazione Tabella Relazionale Linee_fermate
Create TABLE linee_fermate (id INT AUTO_INCREMENT PRIMARY KEY, id_linea INT, id_fermata INT);

INSERT INTO fermate ( `nome`, `urbana`, `zona`)
    VALUE ('Piazza Bengasi', '1', 'c'),
            ('Italia 61', 1, 'c'),
            ('Non ti ricordo', 1, 'b'),
            ('Dante', 0, 'a');

SELECT * FROM fermate;
SELECT * FROM linee;
SELECT * FROM preventivi;
SELECT * FROM linee_fermate;
