create table customer (
  id integer generated by default as identity,
  name varchar(255) not null,
  email varchar(255) not null,
  primary key (id)
);

alter table customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email);

INSERT INTO customer(name, email) values ('Gabriel', 'gabriel@email.com');
INSERT INTO customer(name, email) values ('Daniel', 'daniel@email.com');
