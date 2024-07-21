INSERT INTO address (id, cep, city, complement, name, neighborhood, number, state, street)
VALUES (null, "89253308", "Jaraguá do Sul", null, "Casa", "Jaraguá Esquerdo", 25, 23, "Servidão 45"),
       (null, "89253309", "Jaraguá do Sul", "Apto 102", "Apartamento", "Centro", 222, 23, "Rua das Flores"),
       (null, "88000000", "Florianópolis", "Sala 301", "Escritório", "Centro", 100, 24, "Avenida Beira Mar"),
       (null, "70000000", "Brasília", "Bloco C", "Apartamento", "Asa Sul", 202, 27, "Quadra 312"),
       (null, "01000000", "São Paulo", "Andar 15", "Sala Comercial", "Centro", 500, 26, "Avenida Paulista");

INSERT INTO image (id, file)
VALUES (null, "image1"),
       (null, "image2"),
       (null, "image3"),
       (null, "image4"),
       (null, "image5");

INSERT INTO brand_image (id)
VALUES (1),
       (2),
       (3),
       (4),
       (5);

INSERT INTO brand (id, name, image_id)
VALUES (null, "Royal", 1),
       (null, "Pedigree", 2),
       (null, "Golden", 3),
       (null, "Whiskas", 4),
       (null, "Zee.dog", 5);

INSERT INTO user (id, cpf, email, fullname, password, role)
VALUES (null, "23514396000", "usuario@gmail.com", "Usuário da Silva", "usuario123", 3),
       (null, "87441197040", "usuario2@gmail.com", "Usuário2 da Silva", "usuario124", 2),
       (null, "56810850074", "usuario3@gmail.com", "Usuário3 da Silva", "usuario125", 1),
       (null, "24216922023", "usuario4@gmail.com", "Usuário4 da Silva", "usuario126", 0),
       (null, "75659052088", "usuario5@gmail.com", "Usuário5 da Silva", "usuario127", 3);