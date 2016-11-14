# EsseChat2
Projeto de SW WEB


Workspace ESSEDB
Usuario ESSE
Login esse

no MySQL
create database essechat
use essechat

create table status(	
statusid integer primary key auto_increment,	
status varchar(15) not null
)

create table chatter(	
userid integer primary key auto_increment,	
nome varchar(100) not null,	
nickname varchar(20) not null unique,	
senha varchar(15) not null,    
sexo char not null,	
nascimento date not null,	
email varchar(80) not null,	
status integer not null,	
FOREIGN KEY (status) REFERENCES status(statusid)
);

create table chatroom(	
roomid integer primary key auto_increment,	
nome varchar(60) not null unique,	
descricao varchar(255) not null,	
professor integer,	
FOREIGN KEY (professor) REFERENCES chatter(userid)
);

create table monitores(
roomid integer not null,
userid integer not null,
FOREIGN KEY (roomid) REFERENCES chatroom(roomid),
FOREIGN KEY (userid) REFERENCES chatter(userid)
)


use essechat;

drop table arquivo;
create table arquivo(
ARQUIVO_ID integer primary key auto_increment,
ROOM_ID integer not null,
ARQUIVO_NOME varchar(250) not null,
ARQUIVO_CHATTER varchar(20) not null,
ARQUIVO_DATA TIMESTAMP not null,  
ARQUIVO_TIPO varchar(20) not null,
ARQUIVO LONGBLOB
)


INSERT INTO `essechat`.`status` (`status`) VALUES ('Aluno');
INSERT INTO `essechat`.`status` (`status`) VALUES ('Professor');
INSERT INTO `essechat`.`status` (`status`) VALUES ('Administrador');

INSERT INTO `essechat`.`chatroom` (`nome`, `descricao`) VALUES ('SalaVip', 'Antesala do chat');
INSERT INTO `essechat`.`chatroom` (`nome`, `descricao`) VALUES ('WEB 3 - Desenvolvimento de Sistemas Web III', 'Docente: Paulo Maurício Gonçalves Júnior');
INSERT INTO `essechat`.`chatroom` (`nome`, `descricao`) VALUES ('SW CORP - Desenvolvimento de Software Corporativo', 'Docente: Marcos Andre da Silva Costa');
INSERT INTO `essechat`.`chatroom` (`nome`, `descricao`) VALUES ('PROC NEGÓC - Modelagem de Processos de Negócio', 'Docente: Danilo Farias Soares da Silva');
INSERT INTO `essechat`.`chatroom` (`nome`, `descricao`) VALUES ('PDSWEB - Projeto de Desenvolvimento de Sistema Web', 'Docente: Paulo Maurício Gonçalves Júnior');
INSERT INTO `essechat`.`chatroom` (`nome`, `descricao`) VALUES ('TCCI - Trabalho de Conclusão do Curso I', 'Docente: Aida Araujo Ferreira');
INSERT INTO `essechat`.`chatroom` (`nome`, `descricao`) VALUES ('TESTE SW - Teste de Software', 'Docente: Ramide Augusto Sales Dantas');
INSERT INTO `essechat`.`chatroom` (`nome`, `descricao`) VALUES ('STR - Sistema de Tempo Real', 'Docente: Paulo Abadie Guedes');

INSERT INTO `essechat`.`chatter` (`nome`, `nickname`, `senha`, `sexo`, `nascimento`, `email`, `status`) VALUES ('Edgleyson Menezes', 'EDDE', 'edde', 'm', '1968-12-03', 'ema@a.recife.ifpe.edu.br', '3');
INSERT INTO `essechat`.`chatter` (`nome`, `nickname`, `senha`, `sexo`, `nascimento`, `email`, `status`) VALUES ('Paulo Mauricio Gonçalves Junior', 'PAULO', 'web3', 'm', '1980-06-11', 'paulomgj@ifpe.edu.br', '2');
INSERT INTO `essechat`.`chatter` (`nome`, `nickname`, `senha`, `sexo`, `nascimento`, `email`, `status`) VALUES ('Edlas Oliveira', 'EDLAS', 'edlas', 'm', '1966-03-25', 'eado@a.recife.ifpe.edu.br', '1');
INSERT INTO `essechat`.`chatter` (`nome`, `nickname`, `senha`, `sexo`, `nascimento`, `email`, `status`) VALUES ('Saulo Dias', 'SAULO', 'saulo', 'm', '1978-09-14', 'sad@a.recife.ifpe.edu.br', '1');
INSERT INTO `essechat`.`chatter` (`nome`, `nickname`, `senha`, `sexo`, `nascimento`, `email`, `status`) VALUES ('Sergio Alencar', 'SERGIO', 'sergio', 'm', '1984-11-02', 'sma@a.recife.ifpe.edu.br', '1');
