insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Brasileira');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Mexicana');

insert into estado (nome) values ('CEARA');
insert into estado (nome) values ('MINAS GERAIS');
insert into estado (nome) values ('RECIFE');
insert into estado (nome) values ('RIO DE JANEIRO');

insert into cidade(nome, estado_id) values ('Fortaleza', 1);
insert into cidade(nome, estado_id) values ('Araxá', 2);
insert into cidade(nome, estado_id) values ('Boa viagem', 3);
insert into cidade(nome, estado_id) values ('Duque de caxias', 4);

insert into restaurante (data_cadastro, data_atualizacao, nome,taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logadouro, endereco_numero, endereco_bairro, endereco_complemento) VALUES (utc_timestamp, utc_timestamp, 'Blue Elephant', 12, 1, 1,'99999-999','Rua major celestino','1045','Antonio bezerra','Apartamento 201');
insert into restaurante (data_cadastro, data_atualizacao,nome,taxa_frete, cozinha_id) VALUES (utc_timestamp, utc_timestamp,'Coco Bambu', 200, 2);
insert into restaurante (data_cadastro, data_atualizacao,nome,taxa_frete, cozinha_id) VALUES (utc_timestamp, utc_timestamp,'Sr. Japa', 20.5, 1);
insert into restaurante (data_cadastro, data_atualizacao,nome,taxa_frete, cozinha_id) VALUES (utc_timestamp, utc_timestamp,'La Vicenta Vallejo', 13.6, 1);
insert into restaurante (data_cadastro, data_atualizacao,nome,taxa_frete, cozinha_id) VALUES (utc_timestamp, utc_timestamp,'La Vicenta Vallejo', 13.6, 3);
insert into restaurante (data_cadastro, data_atualizacao,nome,taxa_frete, cozinha_id) VALUES (utc_timestamp, utc_timestamp,'La Vicenta Vallejo', 13.6, 3);


insert into forma_pagamento(descricao) values ('Cartão de crédito');
insert into forma_pagamento(descricao) values ('Cartão de débito');
insert into forma_pagamento(descricao) values ('Dinheiro');

insert into permissao(nome, descricao) values ('CONSULTAR_COZINHAS','Permitir consultar cozinhas');
insert into permissao(nome, descricao) values ('EDITAR_COZINHAS','Permitir editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);