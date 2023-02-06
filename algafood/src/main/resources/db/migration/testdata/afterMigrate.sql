
set foreign_key_checks = 0;

delete from cidade;
delete from cozinha;
delete from estado;
delete from forma_pagamento;
delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from produto;
delete from restaurante;
delete from restaurante_forma_pagamento;
delete from usuario;
delete from usuario_grupo;
delete from restaurante_usuario_responsavel;
delete from pedido;
delete from item_pedido;
delete from foto_produto;

set foreign_key_checks = 1;

alter table cidade auto_increment = 1;
alter table cozinha auto_increment = 1;
alter table estado auto_increment = 1;
alter table forma_pagamento auto_increment = 1;
alter table grupo auto_increment = 1;
alter table permissao auto_increment = 1;
alter table produto auto_increment = 1;
alter table restaurante auto_increment = 1;
alter table usuario auto_increment = 1;
alter table pedido auto_increment = 1;
alter table item_pedido auto_increment = 1;

insert into cozinha (id, nome) values (1, 'Tailandesa'),(2, 'Indiana'),(3, 'Argentina'),(4, 'Brasileira');

insert into estado (id, nome) values (1, 'Minas Gerais'),(2, 'São Paulo'), (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1),(2, 'Belo Horizonte', 1),(3, 'São Paulo', 2),(4, 'Campinas', 2),(5, 'Fortaleza', 3);

insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, ativo, aberto) values (1, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro', true, false);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo, aberto) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp, true, false);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo, aberto) values (3, 'Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp, true, false);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo, aberto) values (4, 'Java Steakhouse', 12, 3, utc_timestamp, utc_timestamp, true, false);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo, aberto) values (5, 'Lanchonete do Tio Sam', 11, 4, utc_timestamp, utc_timestamp, true, false);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo, aberto) values (6, 'Bar da Maria', 6, 4, utc_timestamp, utc_timestamp, true, false);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito'),(2, 'Cartão de débito'),(3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values
('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1),
('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1),
('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2),
('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3),
('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3),
('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4),
('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4),
('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5),
('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);

insert into grupo (id,nome) values (1,'Gerente'),(2,'Vendedor'),(3,'Secretátio'),(4,'Cadastrador');
insert into grupo_permissao (grupo_id, permissao_id) values (1, 1), (1, 2), (2, 1), (2, 2), (3, 1);

insert into usuario (id, nome, email, senha, data_cadastro) values
(1, 'João da Silva', 'joao.ger@algafood.com', '123', utc_timestamp),
(2, 'Maria Joaquina', 'maria.vnd@algafood.com', '123', utc_timestamp),
(3, 'José Souza', 'jose.aux@algafood.com', '123', utc_timestamp),
(4, 'Sebastião Martins', 'sebastiao.cad@algafood.com', '123', utc_timestamp);

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (2, 2);
insert into restaurante_usuario_responsavel (restaurante_id, usuario_id) values (1, 1), (1, 2), (2, 2);

insert into pedido (id, codigo, restaurante_id, usuario_cliente_id, forma_pagamento_id, endereco_cidade_id, endereco_cep,endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro,status, data_criacao, subtotal, taxa_frete, valor_total) values (1,'d8098d67-de95-4b83-9664-73f48f2c8681', 1, 1, 1, 1, '38400-000', 'Rua Floriano Peixoto', '500', 'Apto 801', 'Brasil','ENTREGUE', '2019-11-03 02:00:30', 298.90, 10, 308.90);
insert into pedido (id,codigo, restaurante_id, usuario_cliente_id, forma_pagamento_id, endereco_cidade_id, endereco_cep,endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro,status, data_criacao, subtotal, taxa_frete, valor_total)values (2,'9a850872-688a-4269-acd8-04e3a105f26f', 3, 2, 2, 1, '38400-111', 'Rua Florid', '2010', 'Casa 15', 'praça do abel','ENTREGUE', '2019-11-03 02:00:30', 89.20, 0, 104);
insert into pedido (id,codigo, restaurante_id, usuario_cliente_id, forma_pagamento_id, endereco_cidade_id, endereco_cep,endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro,status, data_criacao, subtotal, taxa_frete, valor_total)values (3,'044540a7-ccc0-420d-9628-96370ec2ebd8', 4, 2, 2, 1, '84756-480', 'Rua Geraldo barbosa', '2342', 'Casa', 'aperitif','CONFIRMADO', '2011-12-31 02:20:10', 79.99, 0, 600);
insert into pedido (id,codigo, restaurante_id, usuario_cliente_id, forma_pagamento_id, endereco_cidade_id, endereco_cep,endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro,status, data_criacao, subtotal, taxa_frete, valor_total)values (4,'6fc81c02-bd02-4158-9129-5a2c493bb882', 1, 1, 2, 1, '78948-978', 'Rua Oscar franca', '2244', 'Casa 05', 'aperitif','CONFIRMADO', '2023-12-31 08:33:43', 100.12, 0, 520);
insert into pedido (id,codigo, restaurante_id, usuario_cliente_id, forma_pagamento_id, endereco_cidade_id, endereco_cep,endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro,status, data_criacao, subtotal, taxa_frete, valor_total)values (5,'4c6567cb-331b-4d2e-a859-3f3885f9454d', 2, 3, 2, 1, '30124-486', 'Rua Oscar araripe', '1045', 'estabecimento comercial', 'Central norte','ENTREGUE', '2023-12-31 10:33:43', 820.29, 0, 1200);

insert into item_pedido (id, pedido_id, produto_id, quantidade, preco_unitario, preco_total, observacao) values (1, 1, 1, 1, 78.9, 78.9, 'Bem passado');
insert into item_pedido (id, pedido_id, produto_id, quantidade, preco_unitario, preco_total, observacao) values (2, 1, 2, 2, 110, 220, 'Menos picante, por favor');
insert into item_pedido (id, pedido_id, produto_id, quantidade, preco_unitario, preco_total, observacao)values (3, 2, 6, 1, 79, 79, 'Ao ponto');