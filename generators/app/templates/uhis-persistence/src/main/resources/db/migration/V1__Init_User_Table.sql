create table <%= APPNAME_UPPERCASE %>_AUTH_USER(
	id bigserial not null,
	username varchar(255) not null,
	password varchar(255),
	primary key (id)
);