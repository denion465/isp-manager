create schema if not exists isp_manager;

create sequence isp_manager.user_id_seq;

create table isp_manager.user(
  id integer not null default nextval('isp_manager.user_id_seq'::regclass),
  public_id varchar(40) not null,
  name varchar(100) not null,
  cpf varchar(30) not null,
  rg varchar(30) not null,
  email varchar(30) not null,
  password varchar(30) not null,
  encrypted_password varchar(100) not null,
  registration_date timestamp not null,
  permission varchar(20) not null,

  constraint pk_user primary key (id)
);

create sequence isp_manager.order_id_seq;

create table isp_manager.order(
  id integer not null default nextval('isp_manager.order_id_seq'::regclass),
  street_address varchar(30) not null,
  street_number varchar(30) not null,
  complement varchar(30) not null,
  zip_code varchar(30) not null,
  district varchar(30) not null,
  internet_speed varchar(30) not null,
  equip_lending boolean not null,
  observations varchar(255),

  constraint pk_order primary key (id)
);
