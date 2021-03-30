create table tipocampanha (
	idtipocampanha serial primary key,
	nometipocampanha varchar(150),
	descricaotipocampanha varchar(400) not null
);

insert into tipocampanha (nometipocampanha, descricaotipocampanha)
values ('Campanha do Agasalho', 'O inverno está chegando e podemos fazer a nossa parte. Participe dessa campanha e ajude a quem precisa. Mais do que nunca precisamos ajudar . O inverno está chegando e podemos fazer a nossa parte ajudando os menos favorecidos.');