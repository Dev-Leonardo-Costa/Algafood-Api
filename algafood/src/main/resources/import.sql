insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Brasileira');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Mexicana');

insert into restaurante (nome,taxa_frete, cozinha_id) VALUES ('Leo do pastel', 12, 1);
insert into restaurante (nome,taxa_frete, cozinha_id) VALUES ('Sushimans', 200, 2);
insert into restaurante (nome,taxa_frete, cozinha_id) VALUES ('Leo do pastel', 20.5, 1);
insert into restaurante (nome,taxa_frete, cozinha_id) VALUES ('Leo do pastel', 13.6, 1);

insert into estado (nome) values ('CEARA');
insert into estado (nome) values ('MINAS GERAIS');
insert into estado (nome) values ('RECIFE');
insert into estado (nome) values ('RIO DE JANEIRO');

insert into cidade(nome, estado_id) values ('Fortaleza', 1);
insert into cidade(nome, estado_id) values ('Araxá', 2);
insert into cidade(nome, estado_id) values ('Boa viagem', 3);
insert into cidade(nome, estado_id) values ('Duque de caxias', 4);

insert into forma_pagamento(descricao) values('CARTÃO DE CRÉDITO');
insert into forma_pagamento(descricao) values('CARTÃO DE DÉBITO');
insert into forma_pagamento(descricao) values('DINHEIRO');

insert into permissao(nome, descricao) values('CONSULTAR_COZINHAS','Permitir consultar cozinhas');
insert into permissao(nome, descricao) values('EDITAR_COZINHAS','Permitir editar cozinhas');