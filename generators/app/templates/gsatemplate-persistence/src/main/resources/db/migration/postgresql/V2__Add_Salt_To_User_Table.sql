ALTER TABLE <%= APPNAME_UPPERCASE %>_AUTH_USER
    ALTER COLUMN password SET NOT NULL;

ALTER TABLE <%= APPNAME_UPPERCASE %>_AUTH_USER
    ADD COLUMN salt varchar(1024) NOT NULL DEFAULT 'salt';