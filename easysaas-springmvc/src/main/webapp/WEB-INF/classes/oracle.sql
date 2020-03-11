create table js_cuour_school 
(
   id                   number                         not null,
   company_id           number                         not null,
   name                 varchar2(100)                  not null,
   desp                 varchar2(400)                  null,
   constraint PK_JS_CUOUR_SCHOOL primary key (id)
);

create sequence js_cuour_school_id_seq;

create table js_cuour_subject 
(
   id                   number                         not null,
   company_id           number                         not null,
   name                 varchar2(100)                  not null,
   desp                 varchar2(400)                  null,
   constraint PK_JS_CUOUR_SUBJECT primary key (id)
);

create sequence js_cuour_subject_id_seq;

create table js_cuour_sale_type 
(
   id                   number                         not null,
   company_id           number                         not null,
   name                 varchar2(100)                  not null,
   weight               number                         null,
   constraint PK_JS_CUOUR_SALE_TYPE primary key (id)
);

create sequence js_cuour_sale_type_id_seq;

create table js_cuour_business_group 
(
   id                   number                         not null,
   company_id           number                         not null,
   name                 varchar2(100)                  not null,
   desp                 varchar2(400)                  null,
   constraint PK_JS_CUOUR_BUSINESS_GROUP primary key (id)
);

create sequence js_cuour_business_group_id_seq;

create table js_cuour_sales 
(
   user_id              varchar2(100)                  not null,
   company_id           number                         not null,
   school_id            number                         not null,
   subject_id           number                         not null,
   business_group_id    number                         not null,
   sales_type_id        number                         not null,
   constraint PK_JS_CUOUR_SALES primary key (user_id)
);

alter table js_cuour_sales
   add constraint FK_JS_CUOUR_SALES_REFE_1 foreign key (school_id)
      references js_cuour_school (id);

alter table js_cuour_sales
   add constraint FK_JS_CUOUR_SALES_REFE_2 foreign key (subject_id)
      references js_cuour_subject (id);

alter table js_cuour_sales
   add constraint FK_JS_CUOUR_SALES_REFE_3 foreign key (business_group_id)
      references js_cuour_business_group (id);

alter table js_cuour_sales
   add constraint FK_JS_CUOUR_SALES_REFE_4 foreign key (sales_type_id)
      references js_cuour_sale_type (id);

create sequence js_cuour_sales_id_seq;

alter table JS_CUOUR_SALES
  add constraint UNQ_JS_CUOUR_SALES unique (USER_ID, SALES_TYPE_ID);
  
  
create table js_cuour_card_rule 
(
   company_id           number                         not null,
   use_allocation       number(1)                      not null,
   time_interval        number                         null,
   allocation_size      number                         null,
   max_allocation_size  number                         null,
   constraint PK_JS_CUOUR_CARD_RULE primary key (company_id)
);

create table js_scheduling 
(
   id                   number                         not null,
   company_id           number                         null,
   name                 varchar2(100)                  null,
   desp                 varchar2(400)                  null,
   start_time           varchar2(8)                    null,
   end_time             varchar2(8)                    null,
   constraint PK_JS_SCHEDULING primary key (id)
);

create sequence js_scheduling_id_seq;


create table js_scheduling_user 
(
   id                   number                         not null,
   company_id           number                         null,
   scheduling_time      varchar2(10)                   null,
   scheduling_id        number                         null,
   user_id              varchar2(100)                  null,
   scheduling_type      number                         null,
   constraint PK_JS_SCHEDULING_USER primary key (id)
);

alter table js_scheduling_user
   add constraint FK_JS_SCHED_REFERENCE_JS_SCHED foreign key (scheduling_id)
      references js_scheduling (id);
      
create sequence js_scheduling_user_id_seq;

create table js_cuour_card_log 
(
   id                   number                         not null,
   company_id           number                         null,
   card_id              number                         null,
   user_id              varchar2(100)                  null,
   allocation_type      number                         null,
   allocation_time      date                         null,
   constraint PK_JS_CUOUR_CARD_LOG primary key (id)
);

create sequence js_cuour_card_log_id_seq;

create table js_cuour_back_type
(
	id					number 					not null,
	company_id 			number					not null,
	name				varchar2(100)			null,
	desp				varchar2(400)			null,
	constraint PK_JS_CUOUR_BACK_TYPE primary key (id)
);

create sequence js_cuour_back_type_id_seq;


alter table js_visitor_info add back_type number default 0;

alter table js_visitor_info add allocation_time date;

alter table js_sys_menu modify modify MENU_ID varchar2(100);

alter table JS_SYS_ROLE_MENU modify MENU_ID varchar2(100);


insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour', '名片分配', '', '', 30, 'cuour', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);

insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.rule.index', '分配规则配置', 'setting/rule/index', 'cuour', 1, 'cuour.cuour.setting.rule.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
	
insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.school.index', '校区配置', 'setting/school/index', 'cuour', 2, 'cuour.cuour.setting.school.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
	
insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.subject.index', '项目配置', 'setting/subject/index', 'cuour', 3, 'cuour.cuour.setting.subject.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);

insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.businessGroup.index', '业务组配置', 'setting/businessGroup/index', 'cuour', 4, 'cuour.cuour.setting.businessGroup.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
		
insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.saleType.index', '销售类别配置', 'setting/saleType/index', 'cuour', 5, 'cuour.cuour.setting.saleType.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
	
insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.sale.index', '销售人员配置', 'setting/sale/index', 'cuour', 6, 'cuour.cuour.setting.sale.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
	
insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.scheduling.index', '排班班次', 'setting/scheduling/index', 'cuour', 7, 'cuour.cuour.setting.scheduling.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
	
insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.scheduling.user.index', '排班设置', 'setting/scheduling/user/index', 'cuour', 8, 'cuour.cuour.setting.scheduling.user.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
	
insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.backType.index', '退回类型设置', 'setting/backType/index', 'cuour', 9, 'cuour.cuour.setting.backType.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
	
insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.setting.allocation.index', '名片分配', 'setting/allocation/index', 'cuour', 10, 'cuour.cuour.setting.allocation.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);

insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.sale.scheduling.index', '个人排班', 'sale/scheduling/index', 'cuour', 11, 'cuour.cuour.sale.scheduling.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);

insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.sale.card.index', '名片处理', 'sale/scheduling/index', 'cuour', 12, 'cuour.cuour.sale.card.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);

insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.report.monitor.allocation.index', '名片分配监控', 'report/monitor/allocation/index', 'cuour', 13, 'cuour.cuour.report.monitor.allocation.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);

insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.report.customer.index', '咨询师考核', 'report/customer/index', 'cuour', 14, 'cuour.cuour.report.customer.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);

insert into js_sys_menu(menu_id, menu_name, menu_url, parent_id, menu_index, menu_pathids, menu_status, create_user, create_time, company_id, menu_type) 
	values('cuour.report.mycard.index', '我录入的名片', 'report/mycard/index', 'cuour', 15, 'cuour.cuour.report.mycard.index', 1, 'admin', to_date('20170101', 'yyyyMMdd'), 1, 30);
	
	
alter table js_cuour_card_rule add expired_recover number(1) default 0;
alter table js_cuour_card_rule add expired_hour number default 24;

alter table js_visitor_info add is_expired number(1) default 0;

alter table js_cuour_card_rule add reset_time varchar2(5);

alter table js_cuour_card_rule add mobile_hide_time number default 0;


--20170904
alter table js_cuour_sales add max_card_size number default 10;

--20170905
alter table js_visitor_info add back_user_id varchar2(100);
alter table js_visitor_info add back_time date;

alter table js_cuour_card_log add operator_user_id varchar2(100);

--20181109
alter table js_cuour_card_rule add server_name varchar2(20) default 'cluster-prd7';

--20190109
alter table js_cuour_card_rule add allocation_delay number default 0;

alter table js_cuour_card_rule add default_subject_id number default 0;

alter table js_cuour_card_rule add default_school_id number default 0;

alter table js_cuour_card_rule add need_onLine number default 1;

alter table js_cuour_card_rule add need_scheeduling number default 1;

--20190129
alter table js_cuour_card_rule add allocation_model number default 0;

