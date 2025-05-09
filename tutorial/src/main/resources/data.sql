INSERT INTO category(name) VALUES ('Eurogames');
INSERT INTO category(name) VALUES ('Ameritrash');
INSERT INTO category(name) VALUES ('Familiar');

INSERT INTO author(name, nationality) VALUES ('Alan R. Moon', 'US');
INSERT INTO author(name, nationality) VALUES ('Vital Lacerda', 'PT');
INSERT INTO author(name, nationality) VALUES ('Simone Luciani', 'IT');
INSERT INTO author(name, nationality) VALUES ('Perepau Llistosella', 'ES');
INSERT INTO author(name, nationality) VALUES ('Michael Kiesling', 'DE');
INSERT INTO author(name, nationality) VALUES ('Phil Walker-Harding', 'US');

INSERT INTO game(title, age, category_id, author_id) VALUES ('On Mars', '14', 1, 2);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Aventureros al tren', '8', 3, 1);
INSERT INTO game(title, age, category_id, author_id) VALUES ('1920: Wall Street', '12', 1, 4);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Barrage', '14', 1, 3);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Azul', '8', 3, 5);
INSERT INTO game(title, age, category_id, author_id) VALUES ('El señor de los anillos', '12', 1, 1);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Catan', '10', 3, 3);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Gloomhaven', '14', 2, 4);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Ronaldo', '10', 3, 5);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Messi', '14', 2, 6);


INSERT INTO clientes(name) VALUES ('Cliente 1');
INSERT INTO clientes(name) VALUES ('Cliente 2');
INSERT INTO clientes(name) VALUES ('Cliente 3');
INSERT INTO clientes(name) VALUES ('Cliente 4');
INSERT INTO clientes(name) VALUES ('Cliente 5');
INSERT INTO clientes(name) VALUES ('Cliente 6');
INSERT INTO clientes(name) VALUES ('Cliente 7');
INSERT INTO clientes(name) VALUES ('Cliente 8');

INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (1, 4, 1, '2025-01-01', '2025-01-06');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (2, 1, 2, '2025-02-01', '2025-02-12');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (3, 2, 3, '2025-03-01', '2025-03-10');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (4, 5, 4, '2025-04-01', '2025-04-13');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (5, 3, 5, '2025-05-01', '2025-05-07');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (6, 6, 6, '2025-06-01', '2025-06-10');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (7, 5, 7, '2025-02-24', '2025-03-05');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (8, 4, 3, '2025-10-01', '2025-10-02');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (9, 7, 5, '2025-07-08', '2025-07-20');
INSERT INTO prestamos (id, juego_id, cliente_id, fecha_prestamo, fecha_devolucion) VALUES (10, 10, 1, '2025-04-06', '2025-04-13');

