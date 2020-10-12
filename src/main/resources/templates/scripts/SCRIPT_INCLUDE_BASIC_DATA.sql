USE GAME_STORE;

insert into doc_types(
	DOC_DESCRIPTION,
    DOC_INITIALS
    )
values ('Cédula de Ciudadanía','CC'),
	('Cédula de Extranjería','CE'),
	('Pasaporte','PA'),
	('Registro Civil','RC'),
	('Tarjeta de Identidad','TI');
commit;
insert into STATES_TYPES(
	ST_TYPE_DESCRIPTION,
    ST_TYPE_ALIAS
    )
values ('ESTADOS USUARIOS','USERS');
commit;
insert into STATES(
	STATE_DESC,
    STATE_ALIAS,
    STATE_TYPE
    )
values ('USUARIO ACTIVO','USER_ON',1),
		('USUARIO INACTIVO','USER_OFF',1);
commit;

insert into USERS(
	USER_NAMES,
    LAST_NAME1,
    LAST_NAME2,
    DOC_TYPE_ID,
    DOC_NUMBER
    )
values ('JONATHAN ANDRES','BARRRERA','ARBOLEDA',1,1214746858);
commit;

insert into USERS_SECURITY(
	USER_ID,
    USER_PASSWORD
    )
values (1,'LaFG40DZO2kLoMFL9NUkMw==');
commit;

insert into hist_user_states(
	USER_ID,
    STATE_ID,
    MODIFICATION_DATE
    )
values (1,1,'2020-10-11');
commit;

insert into CHARACTER_ROLS(
	CHARACTER_ROL_DESC
    )
values ('ACTOR'),
	('PROTAGONISTA'),
	('DIRECTOR'),
	('PRODUCTOR');
commit;

insert into BRANDS(
	BRAND_NAME
    )
values ('EA SPORT'),
	('KONAMI'),
	('ACTIVISION');
commit;

insert into TECHNOLOGIES(
	TECH_NAME
    )
values ('XBOX ONE'),
	('XBOX SERIES X'),
	('PLAY STATION 4'),
	('PLAY STATION 5');
commit;