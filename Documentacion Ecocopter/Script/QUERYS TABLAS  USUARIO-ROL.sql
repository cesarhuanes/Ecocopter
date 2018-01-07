--TABLA DE ADMINISTRACION DE USUARIOS Y ROLES BY CESAR HUANES 12/04/2016
CREATE TABLE TBL_USUARIOS(
DNI CHAR(8) NOT NULL,
NOMBRES VARCHAR2(50) NOT NULL ,
APATERNO VARCHAR2(50) NOT NULL,
AMATERNO VARCHAR2(50) NOT NULL,
CUSUARIO VARCHAR2(50) NOT NULL,
PASSWORD VARCHAR2(50) NOT NULL,
ESTADO CHAR(1) DEFAULT 'A',
USU_CREACION VARCHAR2(50) NOT NULL,
FEC_CREACION DATE DEFAULT SYSDATE,
USU_MODIFICACION VARCHAR2(50),
FEC_MODIFICACION DATE
);

ALTER TABLE TBL_USUARIOS
ADD CONSTRAINT PK_TBL_USUARIOS PRIMARY KEY (DNI);
ALTER TABLE TBL_USUARIOS ADD CONSTRAINT UQ_CUSUARIO UNIQUE(CUSUARIO);


CREATE TABLE TBL_ROL(
COD_ROL CHAR(4) NOT NULL PRIMARY KEY,
NOM_ROL CHAR(50) NOT NULL
);


CREATE TABLE TBL_USU_ROL_SIS(
DNI CHAR(8) NOT NULL,
COD_ROL1 CHAR(4) NOT NULL,
COD_ROL2 CHAR(4) NOT NULL,
FECHA_CADUCIDAD DATE NOT NULL,
USU_CREACION VARCHAR2(50) NOT NULL,
FEC_CREACION DATE DEFAULT SYSDATE,
USU_MODIFICACION VARCHAR2(50),
FEC_MODIFICACION DATE

);

ALTER TABLE TBL_USU_ROL_SIS
ADD CONSTRAINT PK_PBL_USU_ROL_SIS PRIMARY KEY (DNI);

ALTER TABLE TBL_USU_ROL_SIS
ADD CONSTRAINT FK_TBL_USU_ROL_SIS FOREIGN KEY (DNI)
REFERENCES TBL_USUARIOS (DNI);
   
ALTER TABLE TBL_USU_ROL_SIS
ADD CONSTRAINT FK_TBL_USU_ROL_SIS2 FOREIGN KEY (COD_ROL1)
REFERENCES TBL_ROL (COD_ROL);
   
ALTER TABLE TBL_USU_ROL_SIS
ADD CONSTRAINT FK_TBL_USU_ROL_SIS3 FOREIGN KEY (COD_ROL2)
REFERENCES TBL_ROL (COD_ROL);
  
  
INSERT INTO TBL_ROL (COD_ROL,NOM_ROL)VALUES('0001','SUPER ADMINISTRADOR');
INSERT INTO TBL_ROL (COD_ROL,NOM_ROL)VALUES('0002',' ADMINISTRADOR');
INSERT INTO TBL_ROL (COD_ROL,NOM_ROL)VALUES('0003',' ASISTENTE');

COMMIT;

