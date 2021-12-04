create schema if not exists telecom_sys;

create sequence telecom_sys.usuario_id_seq;

create table telecom_sys.usuario(
  id integer not null default nextval('telecom_sys.usuario_id_seq'::regclass),
  nome varchar(100) not null,
  cpf varchar(30) not null,
  rg varchar(30) not null,
  email varchar(30) not null,
  senha varchar(30) not null,
  data_cadastro timestamp not null,
  permissao varchar(20) not null,

  constraint pk_usuario primary key (id)
);

create sequence telecom_sys.pedido_id_seq;

create table telecom_sys.pedido(
  id integer not null default nextval('telecom_sys.pedido_id_seq'::regclass),
  endereco_logradouro varchar(30) not null,
  endereco_numero varchar(30) not null,
  endereco_complemento varchar(30) not null,
  endereco_bairro varchar(30) not null,
  endereco_cep varchar(30) not null,
  velocidade varchar(30) not null,
  equip_comodato boolean not null,
  observacoes varchar(255),

  constraint pk_pedido primary key (id)
);
