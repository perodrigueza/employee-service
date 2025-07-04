# employee-service  
***
Servicio Rest de Empleados

## General info 
***
Servicio Rest diseñado para la evaluación técnica de la posición de Líder Técnico para Aeromexico.
Utiliza una base de datos mysql con dos tablas employee y address con la siguiente estructura

Employee  
+-------------+--------------+------+-----+---------+----------------+  
| Field       | Type         | Null | Key | Default | Extra          |  
+-------------+--------------+------+-----+---------+----------------+  
| birth_date  | date         | YES  |     | NULL    |                |  
| address_id  | bigint       | YES  | UNI | NULL    |                |  
| id          | bigint       | NO   | PRI | NULL    | auto_increment |  
| first_name  | varchar(255) | YES  |     | NULL    |                |  
| gender      | varchar(255) | YES  |     | NULL    |                |  
| last_name   | varchar(255) | YES  |     | NULL    |                |  
| nationality | varchar(255) | YES  |     | NULL    |                |  
| rfc         | varchar(255) | YES  |     | NULL    |                |  
| sur_name    | varchar(255) | YES  |     | NULL    |                |  
+-------------+--------------+------+-----+---------+----------------+  

Address  
+--------+--------------+------+-----+---------+----------------+  
| Field  | Type         | Null | Key | Default | Extra          |  
+--------+--------------+------+-----+---------+----------------+  
| id     | bigint       | NO   | PRI | NULL    | auto_increment |  
| cp     | varchar(255) | YES  |     | NULL    |                |  
| number | varchar(255) | YES  |     | NULL    |                |  
| region | varchar(255) | YES  |     | NULL    |                |  
| state  | varchar(255) | YES  |     | NULL    |                |  
| street | varchar(255) | YES  |     | NULL    |                |  
+--------+--------------+------+-----+---------+----------------+  

## Tecnologías
***
* Java 17
* Spring boot 3.5.3
* Spring JPA
* Mysql

