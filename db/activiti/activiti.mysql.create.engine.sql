create table act_ge_property (
    name_ varchar(64),
    value_ varchar(300),
    rev_ integer,
    primary key (name_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

insert into act_ge_property
values ('schema.version', '5.22.0.0', 1);

insert into act_ge_property
values ('schema.history', 'create(5.22.0.0)', 1);

insert into act_ge_property
values ('next.dbid', '1', 1);

create table act_ge_bytearray (
    id_ varchar(64),
    rev_ integer,
    name_ varchar(255),
    deployment_id_ varchar(64),
    bytes_ longblob,
    generated_ tinyint,
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_re_deployment (
    id_ varchar(64),
    name_ varchar(255),
    category_ varchar(255),
    tenant_id_ varchar(255) default '',
    deploy_time_ timestamp(3) null,
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_re_model (
    id_ varchar(64) not null,
    rev_ integer,
    name_ varchar(255),
    key_ varchar(255),
    category_ varchar(255),
    create_time_ timestamp(3) null,
    last_update_time_ timestamp(3) null,
    version_ integer,
    meta_info_ varchar(4000),
    deployment_id_ varchar(64),
    editor_source_value_id_ varchar(64),
    editor_source_extra_value_id_ varchar(64),
    tenant_id_ varchar(255) default '',
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_ru_execution (
    id_ varchar(64),
    rev_ integer,
    proc_inst_id_ varchar(64),
    business_key_ varchar(255),
    parent_id_ varchar(64),
    proc_def_id_ varchar(64),
    super_exec_ varchar(64),
    act_id_ varchar(255),
    is_active_ tinyint,
    is_concurrent_ tinyint,
    is_scope_ tinyint,
    is_event_scope_ tinyint,
    suspension_state_ integer,
    cached_ent_state_ integer,
    tenant_id_ varchar(255) default '',
    name_ varchar(255),
    lock_time_ timestamp(3) null,
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_ru_job (
    id_ varchar(64) not null,
    rev_ integer,
    type_ varchar(255) not null,
    lock_exp_time_ timestamp(3) null,
    lock_owner_ varchar(255),
    exclusive_ boolean,
    execution_id_ varchar(64),
    process_instance_id_ varchar(64),
    proc_def_id_ varchar(64),
    retries_ integer,
    exception_stack_id_ varchar(64),
    exception_msg_ varchar(4000),
    duedate_ timestamp(3) null,
    repeat_ varchar(255),
    handler_type_ varchar(255),
    handler_cfg_ varchar(4000),
    tenant_id_ varchar(255) default '',
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_re_procdef (
    id_ varchar(64) not null,
    rev_ integer,
    category_ varchar(255),
    name_ varchar(255),
    key_ varchar(255) not null,
    version_ integer not null,
    deployment_id_ varchar(64),
    resource_name_ varchar(4000),
    dgrm_resource_name_ varchar(4000),
    description_ varchar(4000),
    has_start_form_key_ tinyint,
    has_graphical_notation_ tinyint,
    suspension_state_ integer,
    tenant_id_ varchar(255) default '',
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_ru_task (
    id_ varchar(64),
    rev_ integer,
    execution_id_ varchar(64),
    proc_inst_id_ varchar(64),
    proc_def_id_ varchar(64),
    name_ varchar(255),
    parent_task_id_ varchar(64),
    description_ varchar(4000),
    task_def_key_ varchar(255),
    owner_ varchar(255),
    assignee_ varchar(255),
    delegation_ varchar(64),
    priority_ integer,
    create_time_ timestamp(3) null,
    due_date_ datetime(3),
    category_ varchar(255),
    suspension_state_ integer,
    tenant_id_ varchar(255) default '',
    form_key_ varchar(255),
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_ru_identitylink (
    id_ varchar(64),
    rev_ integer,
    group_id_ varchar(255),
    type_ varchar(255),
    user_id_ varchar(255),
    task_id_ varchar(64),
    proc_inst_id_ varchar(64),
    proc_def_id_ varchar(64),    
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_ru_variable (
    id_ varchar(64) not null,
    rev_ integer,
    type_ varchar(255) not null,
    name_ varchar(255) not null,
    execution_id_ varchar(64),
    proc_inst_id_ varchar(64),
    task_id_ varchar(64),
    bytearray_id_ varchar(64),
    double_ double,
    long_ bigint,
    text_ varchar(4000),
    text2_ varchar(4000),
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_ru_event_subscr (
    id_ varchar(64) not null,
    rev_ integer,
    event_type_ varchar(255) not null,
    event_name_ varchar(255),
    execution_id_ varchar(64),
    proc_inst_id_ varchar(64),
    activity_id_ varchar(64),
    configuration_ varchar(255),
    created_ timestamp(3) not null default current_timestamp(3),
    proc_def_id_ varchar(64),
    tenant_id_ varchar(255) default '',
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_evt_log (
    log_nr_ bigint auto_increment,
    type_ varchar(64),
    proc_def_id_ varchar(64),
    proc_inst_id_ varchar(64),
    execution_id_ varchar(64),
    task_id_ varchar(64),
    time_stamp_ timestamp(3) not null,
    user_id_ varchar(255),
    data_ longblob,
    lock_owner_ varchar(255),
    lock_time_ timestamp(3) null,
    is_processed_ tinyint default 0,
    primary key (log_nr_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create table act_procdef_info (
	id_ varchar(64) not null,
    proc_def_id_ varchar(64) not null,
    rev_ integer,
    info_json_id_ varchar(64),
    primary key (id_)
) engine=InnoDB default charset=utf8 collate utf8_bin;

create index act_idx_exec_buskey on act_ru_execution(business_key_);
create index act_idx_task_create on act_ru_task(create_time_);
create index act_idx_ident_lnk_user on act_ru_identitylink(user_id_);
create index act_idx_ident_lnk_group on act_ru_identitylink(group_id_);
create index act_idx_event_subscr_config_ on act_ru_event_subscr(configuration_);
create index act_idx_variable_task_id on act_ru_variable(task_id_);
create index act_idx_athrz_procedef on act_ru_identitylink(proc_def_id_);
create index act_idx_info_procdef on act_procdef_info(proc_def_id_);

alter table act_ge_bytearray
    add constraint act_fk_bytearr_depl 
    foreign key (deployment_id_) 
    references act_re_deployment (id_);

alter table act_re_procdef
    add constraint act_uniq_procdef
    unique (key_,version_, tenant_id_);
    
alter table act_ru_execution
    add constraint act_fk_exe_procinst 
    foreign key (proc_inst_id_) 
    references act_ru_execution (id_) on delete cascade on update cascade;

alter table act_ru_execution
    add constraint act_fk_exe_parent 
    foreign key (parent_id_) 
    references act_ru_execution (id_);
    
alter table act_ru_execution
    add constraint act_fk_exe_super 
    foreign key (super_exec_) 
    references act_ru_execution (id_);

alter table act_ru_execution
    add constraint act_fk_exe_procdef 
    foreign key (proc_def_id_) 
    references act_re_procdef (id_);
    
alter table act_ru_identitylink
    add constraint act_fk_tskass_task 
    foreign key (task_id_) 
    references act_ru_task (id_);
    
alter table act_ru_identitylink
    add constraint act_fk_athrz_procedef 
    foreign key (proc_def_id_) 
    references act_re_procdef(id_);
    
alter table act_ru_identitylink
    add constraint act_fk_idl_procinst
    foreign key (proc_inst_id_) 
    references act_ru_execution (id_);       
    
alter table act_ru_task
    add constraint act_fk_task_exe
    foreign key (execution_id_)
    references act_ru_execution (id_);
    
alter table act_ru_task
    add constraint act_fk_task_procinst
    foreign key (proc_inst_id_)
    references act_ru_execution (id_);
    
alter table act_ru_task
  	add constraint act_fk_task_procdef
  	foreign key (proc_def_id_)
  	references act_re_procdef (id_);
  
alter table act_ru_variable 
    add constraint act_fk_var_exe 
    foreign key (execution_id_) 
    references act_ru_execution (id_);

alter table act_ru_variable
    add constraint act_fk_var_procinst
    foreign key (proc_inst_id_)
    references act_ru_execution(id_);

alter table act_ru_variable 
    add constraint act_fk_var_bytearray 
    foreign key (bytearray_id_) 
    references act_ge_bytearray (id_);

alter table act_ru_job 
    add constraint act_fk_job_exception 
    foreign key (exception_stack_id_) 
    references act_ge_bytearray (id_);

alter table act_ru_event_subscr
    add constraint act_fk_event_exec
    foreign key (execution_id_)
    references act_ru_execution(id_);
    
alter table act_re_model 
    add constraint act_fk_model_source 
    foreign key (editor_source_value_id_) 
    references act_ge_bytearray (id_);

alter table act_re_model 
    add constraint act_fk_model_source_extra 
    foreign key (editor_source_extra_value_id_) 
    references act_ge_bytearray (id_);
    
alter table act_re_model 
    add constraint act_fk_model_deployment 
    foreign key (deployment_id_) 
    references act_re_deployment (id_);        

alter table act_procdef_info 
    add constraint act_fk_info_json_ba 
    foreign key (info_json_id_) 
    references act_ge_bytearray (id_);

alter table act_procdef_info 
    add constraint act_fk_info_procdef 
    foreign key (proc_def_id_) 
    references act_re_procdef (id_);
    
alter table act_procdef_info
    add constraint act_uniq_info_procdef
    unique (proc_def_id_);
    