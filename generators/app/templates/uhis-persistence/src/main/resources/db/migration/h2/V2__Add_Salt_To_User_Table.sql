ALTER TABLE <%= APPNAME_UPPERCASE %>_AUTH_USER
    ALTER COLUMN password SET NOT NULL;

ALTER TABLE <%= APPNAME_UPPERCASE %>_AUTH_USER
    ADD COLUMN salt varchar(1024) NOT NULL DEFAULT 'salt';

INSERT INTO <%= APPNAME_UPPERCASE %>_AUTH_USER(username, password, salt) values ('pablo','e4d2f949a401c04e9cd0bd410e31d6f81b413974151fc458c18d2d186c379219','salt');
