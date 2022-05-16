ALTER TABLE customer ADD COLUMN status varchar(30);

UPDATE customer SET status = 'ATIVO';