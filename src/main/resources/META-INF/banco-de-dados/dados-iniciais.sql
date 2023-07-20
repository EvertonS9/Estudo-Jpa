insert into produto (id, nome, preco, data_criacao, descricao) values (1, 'Kindle', 499.0, date_sub(sysdate(), interval 1 day), 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (id, nome, preco, data_criacao, descricao) values (3, 'Hyoga', 5800.0, date_sub(sysdate(), interval 1 day), 'Pó de diamante');

insert into cliente (id, nome) values (1, 'RotaZ');
insert into cliente (id, nome) values (2, 'Vitoria Ferreira');

insert into pedido(id, cliente_id, data_criacao, total, status) values (1, 1, sysdate(), 1000, 'AGUARDANDO');

insert into item_Pedido( pedido_id, produto_id, preco_produto, quantidade) values ( 1, 1, 499.0, 2);

insert into categoria (id, nome) values (1, 'Eletrônicos');