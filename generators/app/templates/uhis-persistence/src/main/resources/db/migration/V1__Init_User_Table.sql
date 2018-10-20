create table UHIS_AUTH_USER(
	id bigserial not null,
	username varchar(255) not null,
	password varchar(255),
	primary key (id)
);