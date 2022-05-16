create table book (
  id integer generated by default as identity,
  name varchar(255) not null,
  price decimal(10,2) not null,
  status varchar(255) not null,
  customer_id int not null,
  primary key (id)
);

alter table book add constraint FK_dwk6cx0afu8bs9o4t536v1j5v foreign key (customer_id) references customer(id);

INSERT INTO book(name, price, status, customer_id) values ('Livro 1', 59.90, 'ATIVO', 1);
INSERT INTO book(name, price, status, customer_id) values ('Livro 2', 49.90, 'ATIVO', 2);
INSERT INTO book(name, price, status, customer_id) values ('Livro 3', 29.90, 'ATIVO', 1);
