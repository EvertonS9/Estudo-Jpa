insert into produto (id, nome, preco, descricao) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (id, nome, preco, descricao) values (3, 'Hyoga', 5800.0, 'Pó de diamante');

insert into cliente (id, nome) values (1, 'RotaZ');

insert into pedido(id, cliente_id, data_pedido, total, status) values (1, 1, sysdate(), 1000, 'AGUARDANDO');

insert into item_Pedido(id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 499.0, 2);

insert into categoria (id, nome) values (1, 'Eletrônicos');