create schema if not exists isp_manager;

create sequence isp_manager.usuario_id_seq;

create table isp_manager.usuario(
  id integer not null default nextval('isp_manager.usuario_id_seq'::regclass),
  nome varchar(100) not null,
  cpf varchar(30) not null,
  rg varchar(30) not null,
  email varchar(30) not null,
  senha varchar(30) not null,
  data_cadastro timestamp not null,
  permissao varchar(20) not null,

  constraint pk_usuario primary key (id)
);

create sequence isp_manager.pedido_id_seq;

create table isp_manager.pedido(
  id integer not null default nextval('isp_manager.pedido_id_seq'::regclass),
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
