alter table isp_manager.order add column monthly_payment varchar(30);

alter table isp_manager.order add column user_id integer not null;

alter table isp_manager.order add constraint fk_user_order
  foreign key (user_id) references isp_manager.user (id);
