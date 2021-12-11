alter table isp_manager.pedido add column mensalidade varchar(30);

alter table isp_manager.pedido add column usuario_id integer not null;

alter table isp_manager.pedido add constraint fk_pedido_usuario
  foreign key (usuario_id) references isp_manager.usuario (id);
