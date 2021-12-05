alter table telecom_sys.pedido add column mensalidade varchar(30);

alter table telecom_sys.pedido add column usuario_id integer not null;

alter table telecom_sys.pedido add constraint fk_pedido_usuario
  foreign key (usuario_id) references telecom_sys.usuario (id);
