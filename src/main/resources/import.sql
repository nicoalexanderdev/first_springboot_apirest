INSERT INTO maker (id, name) VALUES (1, 'Makita');
INSERT INTO maker (id, name) VALUES (2, 'Bosch');
INSERT INTO maker (id, name) VALUES (3, 'Einhell');
INSERT INTO maker (id, name) VALUES (4, 'Hyundai');

INSERT INTO category (id, name) VALUES(1, 'Herramientas manuales');
INSERT INTO category (id, name) VALUES(2, 'Implementos de seguridad');

INSERT INTO product (id, name, description, price, id_maker, id_category) VALUES(1, 'Taladro', 'Taladro marca Einhell', 54990, 3, 1);
INSERT INTO product (id, name, description, price, id_maker, id_category) VALUES(2, 'Casco de seguridad', 'Casco de seguridad marca Makita', 65990, 1, 2);

