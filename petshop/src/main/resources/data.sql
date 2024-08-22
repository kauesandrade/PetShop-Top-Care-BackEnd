INSERT INTO address (id, cep, city, complement, name, neighborhood, number, state, street)
VALUES (null, "89253308", "Jaraguá do Sul", null, "Casa", "Jaraguá Esquerdo", 25, 23, "Servidão 45"),
       (null, "89253309", "Jaraguá do Sul", "Apto 102", "Apartamento", "Centro", 222, 23, "Rua das Flores"),
       (null, "88000000", "Florianópolis", "Sala 301", "Escritório", "Centro", 100, 24, "Avenida Beira Mar"),
       (null, "70000000", "Brasília", "Bloco C", "Apartamento", "Asa Sul", 202, 27, "Quadra 312"),
       (null, "89253309", "Jaraguá do Sul", "Apto 102", "Apartamento", "Centro", 222, 23, "Rua das Flores"),
       (null, "88000000", "Florianópolis", "Sala 301", "Escritório", "Centro", 100, 24, "Avenida Beira Mar"),
       (null, "70000000", "Brasília", "Bloco C", "Apartamento", "Asa Sul", 202, 27, "Quadra 312"),
       (null, "89253309", "Jaraguá do Sul", "Apto 102", "Apartamento", "Centro", 222, 23, "Rua das Flores"),
       (null, "88000000", "Florianópolis", "Sala 301", "Escritório", "Centro", 100, 24, "Avenida Beira Mar"),
       (null, "70000000", "Brasília", "Bloco C", "Apartamento", "Asa Sul", 202, 27, "Quadra 312"),
       (null, "70000000", "Brasília", "Bloco C", "Apartamento", "Asa Sul", 202, 27, "Quadra 312"),
       (null, "88000000", "Florianópolis", "Sala 301", "Escritório", "Centro", 100, 24, "Avenida Beira Mar"),
       (null, "70000000", "Brasília", "Bloco C", "Apartamento", "Asa Sul", 202, 27, "Quadra 312"),
       (null, "70000000", "Brasília", "Bloco C", "Apartamento", "Asa Sul", 202, 27, "Quadra 312"),
       (null, "01000000", "São Paulo", "Andar 15", "Sala Comercial", "Centro", 500, 26, "Avenida Paulista");

INSERT INTO image (id, size, name, type, file)
VALUES (null, 200, "imagem massa", "image/jpeg", "image1"),
       (null, 200, "imagem massa", "image/jpeg", "image2"),
       (null, 200, "imagem massa", "image/jpeg", "image3"),
       (null, 200, "imagem massa", "image/jpeg", "image4"),
       (null, 200, "imagem massa", "image/jpeg", "image5"),
       (null, 200, "imagem massa", "image/jpeg", "image6"),
       (null, 200, "imagem massa", "image/jpeg", "image7"),
       (null, 200, "imagem massa", "image/jpeg", "image8"),
       (null, 200, "imagem massa", "image/jpeg", "image9"),
       (null, 200, "imagem massa", "image/jpeg", "image10"),
       (null, 200, "imagem massa", "image/jpeg", "image11"),
       (null, 200, "imagem massa", "image/jpeg", "image12"),
       (null, 200, "imagem massa", "image/jpeg", "image13"),
       (null, 200, "imagem massa", "image/jpeg", "image14"),
       (null, 200, "imagem massa", "image/jpeg", "image15"),
       (null, 200, "imagem massa", "image/jpeg", "image16"),
       (null, 200, "imagem massa", "image/jpeg", "image17"),
       (null, 200, "imagem massa", "image/jpeg", "image18"),
       (null, 200, "imagem massa", "image/jpeg", "image19"),
       (null, 200, "imagem massa", "image/jpeg", "image20"),
       (null, 200, "imagem massa", "image/jpeg", "image21"),
       (null, 200, "imagem massa", "image/jpeg", "image22"),
       (null, 200, "imagem massa", "image/jpeg", "image23"),
       (null, 200, "imagem massa", "image/jpeg", "image24"),
       (null, 200, "imagem massa", "image/jpeg", "image25"),
       (null, 200, "imagem massa", "image/jpeg", "image26"),
       (null, 200, "imagem massa", "image/jpeg", "image27"),
       (null, 200, "imagem massa", "image/jpeg", "image28"),
       (null, 200, "imagem massa", "image/jpeg", "image29"),
       (null, 200, "imagem massa", "image/jpeg", "image30"),
       (null, 200, "imagem massa", "image/jpeg", "image31"),
       (null, 200, "imagem massa", "image/jpeg", "image32");

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

INSERT INTO category_image (id)
VALUES (6),
       (7),
       (8),
       (9),
       (10);

INSERT INTO customer_image (id)
VALUES (11),
       (12),
       (13),
       (14),
       (15);

INSERT INTO pet_image (id)
VALUES (16),
       (17),
       (18),
       (19),
       (20);

INSERT INTO petshop_image (id)
VALUES (21),
       (22),
       (23),
       (24),
       (25);

INSERT INTO product (id, code, title, rating, description, short_description, brand_id)
VALUES (null, 1, "Ração Golden Special", 3, "- Indicada para cães adultos;
- Redução do odor das fezes, seleção de ingredientes especiais que auxiliam na redução do odor das fezes;
- Blend de proteínas, máxima satisfação para o paladar;
- Maior rendimento, ingredientes de alto aproveitamento;
- Saúde e vitalidade, alimento de alta qualidade, rico em vitaminas e minerais;
- Disponível em embalagens de 15kg e 20kg.", "Massa pra caramba!", 1),
       (null, 2, "Areia Higiênica Pipicat", 4, "- Indicada para gatos;
- Controle de odores superior com pipicat odor block;
- Forma torrões mais firmes;
- Fácil de limpar;
- Grãos finos;
- Sem fragrância;
- Disponível em embalagem com 4kg, 12kg e 20kg.", "Legal pra caramba!", 2),
       (null, 3, "Super Secão Tapete Higiênico para Cachorro", 4.5, "- Indicado para cães;
- Fofinho igual fralda de bebê;
- Ideal para quem faz trocas menos frequentes do tapete no ambiente, com superabsorção;
- Alças no pacote que facilitam para levar para qualquer lugar;
- Gel superabsorvente;
- Atrativo canino que faz com que o seu pet encontre o tapete e tenha vontade de fazer xixi nele;
- Fitas adesivas em todas as extremidades do tapete, que podem ser coladas no piso ou na parede, caso seu pet levante a pata para fazer xixi;
- Mantém a sua casa sempre limpa, sem patas molhadas pelo chão;
- Disponível em embalagem com 7 unidades, 14 unidades e 30 unidades.", "Show pra caramba!", 3);

INSERT INTO product_variant (id, variant_code, variant_title, available, discount, price, stock, product_id)
VALUES (null, 11, "15kg", 1, 0, 149.99, 100, 1),
       (null, 21, "12kg", 1, 0, 45.90, 250, 2),
       (null, 31, "14un", 1, 0, 149.99, 100, 3);

INSERT INTO product_image (id, product_variant_id)
VALUES (26, 1),
       (27, 2);

INSERT INTO service_image (id)
VALUES (28),
       (29),
       (30),
       (31),
       (32);

INSERT INTO user (id, cpf, email, fullname, password, role)
VALUES (null, "23514396000", "usuario@gmail.com", "Usuário da Silva", "usuario123", 3),
       (null, "87441197040", "usuario2@gmail.com", "Usuário2 da Silva", "usuario124", 2),
       (null, "56810850074", "usuario3@gmail.com", "Usuário3 da Silva", "usuario125", 1),
       (null, "24216922023", "usuario4@gmail.com", "Usuário4 da Silva", "usuario126", 0),
       (null, "75659052088", "usuario5@gmail.com", "Usuário5 da Silva", "usuario127", 3);

INSERT INTO shipping_type (id, price, time, shipping_time)
VALUES (null, 10, 48, "2 dias"),
       (null, 20, 12, "12 horas");

INSERT INTO cart (id, shipping_type_id)
VALUES (null, 1),
       (null, 2);

INSERT INTO cart_item (id, amount, product_id, cart_id)
VALUES (null, 3, 1, 1),
       (null, 1, 1, 2);

INSERT INTO customer (id, birth, gender, cart_id, profile_image_id)
VALUES (1, "2000-06-15", 0, 1, 11),
       (5, "2000-06-15", 1, 2, 12);

INSERT INTO card (id, name, last_digits, expiration_date, main_card, customer_id)
VALUES (null, "Usuário da Silva", "1234", "2034-07-01", 1, 1),
       (null, "Usuário5 da Silva", "4321", "2034-08-01", 1, 5);

INSERT INTO category_group (id, title, image_id)
VALUES (null, "Pet", 6),
       (null, "Porte de Raça", 7),
       (null, "Idade", 8),
       (null, "Marca", 9);

INSERT INTO contact (id, cellphone, telephone, customer_id)
VALUES (null, "47999999999", null, 1),
       (null, "47888888888", null, 5);

INSERT INTO customer_address (id, customer_id)
VALUES (1, 1),
       (2, 5);

INSERT INTO customer_favorites (customer_id, favorites_id)
VALUES (1, 1),
       (5, 2);

INSERT INTO payment_method (id)
VALUES (null),
       (null);

INSERT INTO payment (id, sub_total, shipping_fee, total, method_id, parcels, status)
VALUES (null, 149.90, 24.99, 174.89, 1, 1, 0),
       (null, 45.90, 14.99, 60.89, 2, 2, 0);

INSERT INTO shipping (id, shipping_code, shipping_by, shipping_type_id)
VALUES (null, 1, "Azul", 1),
       (null, 2, "Sedex", 2);

INSERT INTO customer_order(id, code, delivery_address_id, expected_delivery_date, payment_id, order_date, shipping_id, customer_id)
VALUES (null, 1, 1, "2024-07-30", 1, "2024-07-29", 1, 1),
       (null, 2, 2, "2024-07-30", 2, "2024-07-29", 2, 5);

INSERT INTO petshop_address (id)
VALUES (3), (4);

INSERT INTO petshop (id, name, telephone, image_id, address_id)
VALUES (null, "Topcare Vila Nova", "47111111111", 21, 3),
       (null, "Topcare Figueira", "47222222222", 22, 4);

INSERT INTO employee (id, petshop_id)
VALUES (2, 1),
       (3, 2),
       (4, 2);

INSERT INTO order_item (id, amount, product_id, order_id)
VALUES (null, 2, 1, 1),
       (null, 4, 2, 2);

INSERT INTO pet_type (id, type)
VALUES (null, "Roedor"),
       (null, "Ave");

INSERT INTO pet (id, id_color, image_id, name, type_id, race, size, microchip, gender, color, birth, rga, weight, customer_id)
VALUES (null, 0, 16, "Topolino da Silva", 1, "Rato de esgoto", "Colossal", null, 0, "Cinza", null, null, 25.8, 1),
       (null, 0, 17, "Cleyton", 2, "Galinha de macumba", "Médio", null, 1, "Branca", null, null, 2.2, 5);

INSERT INTO product_category (id, title, category_group_id)
VALUES (null, "Gato", 1),
       (null, "Cachorro", 1),
       (null, "Pequeno", 2),
       (null, "Grande", 3);

INSERT INTO product_categories (categories_id, product_id)
VALUES (1, 1),
       (2, 2),
       (2, 3),
       (3, 1);

INSERT INTO product_review (id, creation_date, customer_id, rating, review)
VALUES (null, "2024-07-29", 1, 4, "Muito bom esse produto!"),
       (null, "2024-07-29", 5, 5, "Muito legal esse produto!");

INSERT INTO product_specification (id, product_id, title, description)
VALUES (null, 1, "Idade", "Filhotes/Adultos"),
       (null, 1, "Linha", "Biodegradável"),
       (null, 2, "Pet", "Gato"),
       (null, 2, "Tipo", "Areia Seca"),
       (null, 3, "Apresentação", "Disponível em embalagem de 1.5kg, 3kg e 4kg");

INSERT INTO schedule (id, pet_id, customer_id, petshop_id, payment_id, date_time)
VALUES (null, 1, 1, 1, 1, "2024-08-15 13:30:00"),
       (null, 2, 5, 2, 2, "2024-08-17 13:30:00");

INSERT INTO service_category (id, title)
VALUES (null, "Higiene"),
       (null, "Saúde");

INSERT INTO service (id, code, category_id, image_id, title, description)
VALUES (null, 1, 1, 28, "Banho e Tosa", "Deixe seu pequeno ou grandinho bem cheirosinho"),
       (null, 2, 2, 29, "Veterinária", "Seu pet com a saúde em dia alegra todos da família"),
       (null, 3, 2, 30, "Vacinação", "Chô doença, vai embora!");

INSERT INTO service_variant (id, service_id, variant_code, variant_title, estimated_time, price)
VALUES (null, 1, 11, "Banho higiênico", "00:30:00", 59.90),
       (null, 2, 22, "Consulta veterinária", "01:30:00", 109.90),
       (null, 3, 33, "Vacina contra raiva", "00:15:00", 69.90);

INSERT INTO service_served_pets(served_pets_id, service_id)
VALUES (1, 1),
       (2, 2),
       (2, 3);

INSERT INTO schedule_services (schedule_id, services_id)
VALUES (1, 1),
       (1, 2),
       (2, 3);

INSERT INTO shipping_status (id, value, date_time)
VALUES (null, 0, "2024-07-29 18:00:00"),
       (null, 1, "2024-07-30 18:00:00"),
       (null, 2, null),
       (null, 3, null),
       (null, 4, null),
       (null, 5, null),
       (null, 0, "2024-07-30 18:00:00"),
       (null, 1, "2024-07-31 18:00:00"),
       (null, 2, null),
       (null, 3, null),
       (null, 4, null),
       (null, 5, null);

INSERT INTO shipping_shipping_status (shipping_id, shipping_status_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (2, 7),
       (2, 8),
       (2, 9),
       (2, 10),
       (2, 11),
       (2, 12);