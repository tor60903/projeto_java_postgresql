create table pessoa(
	idpessoa	 serial	     		primary key,
	nome	     varchar(150)   	not null,
	cpf          varchar(15)    	not null,
	email        varchar(100)   	not null
);
