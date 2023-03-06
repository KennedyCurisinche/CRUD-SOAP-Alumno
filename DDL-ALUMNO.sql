CREATE DATABASE colesuper;

USE colesuper;

CREATE TABLE `alumno` (
  `idalumno` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(4) NOT NULL,
  `alumno` varchar(80) NOT NULL,
  PRIMARY KEY (`idalumno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
