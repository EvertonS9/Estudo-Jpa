insert into produto (id, nome, preco, data_criacao, descricao) values (1, 'Kindle', 499.0, date_sub(sysdate(), interval 1 day), 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (id, nome, preco, data_criacao, descricao) values (3, 'Hyoga', 5800.0, date_sub(sysdate(), interval 1 day), 'Pó de diamante');

insert into cliente (id, nome, cpf) values (1, 'RotaZ', '123');
insert into cliente (id, nome, cpf) values (2, 'Vitoria Ferreira', '456');

insert into cliente_detalhe (cliente_id, sexo, data_nascimento) values (1, 'MASCULINO', date_sub(sysdate(), interval 27 year));
insert into cliente_detalhe (cliente_id, sexo, data_nascimento) values (2, 'FEMININO', date_sub(sysdate(), interval 30 year));

insert into pedido (id, cliente_id, data_criacao, total, status) values (1, 1, date_sub(sysdate(), interval 5 day), 998.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (2, 1, sysdate(), 499.0, 'AGUARDANDO');

insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 499, 2);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 3, 1400, 1);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (2, 1, 499, 1);

insert into pagamento (pedido_id, status, tipo_pagamento, numero_cartao, codigo_barras) values (2, 'PROCESSANDO', 'cartao', '123', null);

insert into nota_fiscal (pedido_id, xml, data_emissao) values (2, '<xml />', sysdate());

insert into categoria (nome) values ('Eletrodomésticos');
insert into categoria (nome) values ('Livros');
insert into categoria (nome) values ('Cavaleiros de bronze');
insert into categoria (nome) values ('Cavaleiros de ouro');
insert into categoria (nome) values ('Shaka de Virgo');
insert into categoria (nome) values ('Saga de Gêmeos')
insert into categoria (nome) values ('Deuses');

insert into produto_categoria (produto_id, categoria_id) values (1, 2);