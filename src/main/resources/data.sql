insert into PAIS(ID, CODIGO, NOMBRE) values (1, 'ES', 'España');
insert into PAIS(ID, CODIGO, NOMBRE) values (2, 'FR', 'Francia');

insert into SERIE(ID, ORDEN, PAIS) values (1, 1, 'ES');
insert into SERIE(ID, ORDEN, PAIS) values (2, 1, 'FR');

insert into MONEDA_COMUN(ID, VALOR, PAIS, MOTIVO, SERIE_ID) values (1, '1 centimo', 'ES', 'Don Quijote', 1);
insert into MONEDA_COMUN(ID, VALOR, PAIS, MOTIVO, SERIE_ID) values (2, '10 centimos', 'ES', 'Don Quijote', 1);
insert into MONEDA_COMUN(ID, VALOR, PAIS, MOTIVO, SERIE_ID) values (3, '20 centimos', 'ES', 'Don Quijote', 1);
insert into MONEDA_COMUN(ID, VALOR, PAIS, MOTIVO, SERIE_ID) values (4, '50 centimos', 'FR', 'Don Quijote', 2);

insert into MONEDA_CONMEMORATIVA(ID, PAIS, FECHA_EMISION, MOTIVO, IMAGEN, TIRADA) values (1, 'FR', '2012-09-29', 'Augusto Rodin', 'https://upload.wikimedia.org/wikipedia/de/9/94/2_euro_coin_Gr_serie_1a.png', 2500000);
insert into MONEDA_CONMEMORATIVA(ID, PAIS, FECHA_EMISION, MOTIVO, IMAGEN, TIRADA) values (2, 'ES', '2017-06-01', 'Iglesia de Santa María del Naranco', 'https://upload.wikimedia.org/wikipedia/de/9/94/2_euro_coin_Gr_serie_1a.png', 1000000);
insert into MONEDA_CONMEMORATIVA(ID, PAIS, FECHA_EMISION, MOTIVO, IMAGEN, TIRADA) values (3, 'ES', '2016-02-11', 'Acueducto de Segovia', 'https://upload.wikimedia.org/wikipedia/de/9/94/2_euro_coin_Gr_serie_1a.png', 1000000);
insert into MONEDA_CONMEMORATIVA(ID, PAIS, FECHA_EMISION, MOTIVO, IMAGEN, TIRADA) values (4, 'ES', '2015-12-23', 'Paque Well', 'https://upload.wikimedia.org/wikipedia/de/9/94/2_euro_coin_Gr_serie_1a.png', 1000000);

insert into APP_USER(ID, PASSWORD, USERNAME) values(1, '$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'svlada@gmail.com');
insert into USER_ROLE(APP_USER_ID, ROLE) values(1, 'ADMIN');
insert into USER_ROLE(APP_USER_ID, ROLE) values(1, 'PREMIUM_MEMBER');