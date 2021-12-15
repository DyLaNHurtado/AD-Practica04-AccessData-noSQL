SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO,NO_ZERO_IN_DATE,NO_ZERO_DATE';

USE adSL;

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `conocimiento`;
CREATE TABLE `conocimiento`
(
    `idConocimiento` varchar(36)  NOT NULL,
    `idProgramador`  varchar(36)  NOT NULL,
    `idTecnologia`    varchar(36) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `conocimiento` (`idConocimiento`, `idProgramador`, `idTecnologia`)
VALUES ('df59793e-0d47-4347-bcfa-e4c86d6974cb', '1376acc9-79a9-4bf1-9084-c82e9a07f432','20bcca63-7b60-4a43-bb10-4c9735587d16');
INSERT INTO `conocimiento` (`idConocimiento`, `idProgramador`, `idTecnologia`)
VALUES ('de9eeebf-fe95-4d9c-a127-1a86d22c1363', '53269670-1586-49ac-9df5-62ddd55f96cc', '4f119f1b-7ccf-49f4-b56f-fdace8589b1c');

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento`
(
    `idDepartamento`   varchar(36)  NOT NULL,
    `nombre`           varchar(40)  NOT NULL,
    `presupuesto`      double       NOT NULL,
    `presupuestoAnual` double       NOT NULL,
    PRIMARY KEY (`idDepartamento`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `departamento` (`idDepartamento`, `nombre`, `presupuesto`, `presupuestoAnual`)
VALUES ('1e89386d-be37-4930-b6ae-bcba6c9917b4', 'Recursos Humanos', 5000,  25000);

INSERT INTO `departamento` (`idDepartamento`, `nombre`, `presupuesto`, `presupuestoAnual`)
VALUES ('2d1d1422-fede-4e27-8883-3ffdb1be1a7c', 'Marketing', 12000,  100000);

INSERT INTO `departamento` (`idDepartamento`, `nombre`, `presupuesto`,  `presupuestoAnual`)
VALUES ('512a0695-3294-4c2c-86d9-4babd4485fa8', 'Logistica',  15500 ,92800);

DROP TABLE IF EXISTS `historialJefesDep`;
CREATE TABLE `historialJefesDep`
(

    `idHistorialJefesDep`   varchar(36)  NOT NULL,
    `idDepartamento`   varchar(36)  NOT NULL,
    `idProgramador`    varchar(36)  NOT NULL,
    PRIMARY KEY (`idHistorialJefesDep`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `historialJefesDep` (`idHistorialJefesDep`,`idDepartamento` ,`idProgramador`)
VALUES ('34236e74-4aad-4d5d-acbb-5dcd7fd1eb41', '512a0695-3294-4c2c-86d9-4babd4485fa8', '6a69db52-f903-4978-ac08-dc32831d362e');

INSERT INTO `historialJefesDep` (`idHistorialJefesDep`,`idDepartamento` ,`idProgramador`)
VALUES ('2b04c7e2-5aab-11ec-bf63-0242ac130002', '2d1d1422-fede-4e27-8883-3ffdb1be1a7c','1376acc9-79a9-4bf1-9084-c82e9a07f432');


DROP TABLE IF EXISTS `programador`;
CREATE TABLE `programador`
(
    `idProgramador`      varchar(36)  NOT NULL,
    `nombre`             varchar(40)  NOT NULL,
    `fechaAlta`          date         NOT NULL,
    `idDepartamento`     varchar(36)  ,
    `idProyecto`            varchar(36)  ,
    `salario`            double       NOT NULL,
    `esJefeDepartamento`   boolean      NOT NULL,
    `esJefeProyecto`       boolean      NOT NULL,
    PRIMARY KEY (`idProgramador`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `programador` (`idProgramador`, `nombre`, `fechaAlta`, `idDepartamento`,`idProyecto`,`salario`, `esjefeDepartamento`, `esjefeProyecto`)
VALUES ('1376acc9-79a9-4bf1-9084-c82e9a07f432', 'Barnie Stinson', '2019-06-03', '2d1d1422-fede-4e27-8883-3ffdb1be1a7c', '81ee1211-760c-493d-968a-380e6af67363', 1500, true, false);
INSERT INTO `programador` (`idProgramador`, `nombre`, `fechaAlta`, `idDepartamento`,`idProyecto`,`salario`, `esjefeDepartamento`, `esjefeProyecto`)

VALUES ('53269670-1586-49ac-9df5-62ddd55f96cc', 'Rick Sanchez', '2015-11-09', '1e89386d-be37-4930-b6ae-bcba6c9917b4','233b5d47-0ced-4e6f-8982-b2f95b6b25b9', 1200, false, false);
INSERT INTO `programador` (`idProgramador`, `nombre`, `fechaAlta`, `idDepartamento`,`idProyecto`,`salario`, `esjefeDepartamento`, `esjefeProyecto`)
VALUES ('606aba4c-b76e-4fa3-9eb8-48e20d729353', 'Andres Iniesta', '2010-02-27', '512a0695-3294-4c2c-86d9-4babd4485fa8','2d1d1422-fede-4e27-8883-3ffdb1be1a7c',  1500, false, true);
INSERT INTO `programador` (`idProgramador`, `nombre`, `fechaAlta`, `idDepartamento`,`idProyecto`,`salario`, `esjefeDepartamento`, `esjefeProyecto`)
VALUES ('6a69db52-f903-4978-ac08-dc32831d362e', 'Hulk Hogan', '2001-03-21', '512a0695-3294-4c2c-86d9-4babd4485fa8','2d1d1422-fede-4e27-8883-3ffdb1be1a7c',  1300, true, false);
INSERT INTO `programador` (`idProgramador`, `nombre`, `fechaAlta`, `idDepartamento`,`idProyecto`,`salario`, `esjefeDepartamento`, `esjefeProyecto`)

VALUES ('6ba7cbcb-7f95-4c6f-b735-2a5e0a363e52', 'Mark Knofler', '1999-05-23', '512a0695-3294-4c2c-86d9-4babd4485fa8','2d1d1422-fede-4e27-8883-3ffdb1be1a7c', 2000, false, false);
INSERT INTO `programador` (`idProgramador`, `nombre`, `fechaAlta`, `idDepartamento`,`idProyecto`,`salario`, `esjefeDepartamento`, `esjefeProyecto`)

VALUES ('ba2bfe86-855d-4f2c-bb92-2ad8f1db788e', 'Jack Sparrow', '2006-12-07', '1e89386d-be37-4930-b6ae-bcba6c9917b4','233b5d47-0ced-4e6f-8982-b2f95b6b25b9',  900, false, false);

INSERT INTO `programador` (`idProgramador`, `nombre`, `fechaAlta`, `idDepartamento`,`idProyecto`,`salario`, `esjefeDepartamento`, `esjefeProyecto`)
VALUES ('5cc55142-469b-4d42-9b9b-b9df2614bcc7', 'Will Smith', '2003-11-11', '2d1d1422-fede-4e27-8883-3ffdb1be1a7c','233b5d47-0ced-4e6f-8982-b2f95b6b25b9',  3000, false, false);
INSERT INTO `programador` (`idProgramador`, `nombre`, `fechaAlta`, `idDepartamento`,`idProyecto`,`salario`, `esjefeDepartamento`, `esjefeProyecto`)
VALUES ('d63f0d73-3f1b-4afd-b5d0-821449daa4a3', 'Mike Wazowski', '2011-04-03', '2d1d1422-fede-4e27-8883-3ffdb1be1a7c','10f2db5c-a0c3-40ec-a1bf-a95cab6bebdf', 1600, false, true);


DROP TABLE IF EXISTS `proyecto`;
CREATE TABLE `proyecto`
(
    `idProyecto`     varchar(36)  NOT NULL,
    `nombre`         varchar(20)  NOT NULL,
    `presupuesto`    double       NOT NULL,
    `fechaInicio`    date         NOT NULL,
    `fechaFin`       date         NOT NULL,
    `idDepartamento` varchar(36)  ,
    PRIMARY KEY (`idProyecto`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `proyecto` (`idProyecto`, `nombre`, `presupuesto`,`fechaInicio`, `fechaFin`,`idDepartamento`)
VALUES ('81ee1211-760c-493d-968a-380e6af67363', 'Power Project',8000, '2017-05-02', '2019-11-20','1e89386d-be37-4930-b6ae-bcba6c9917b4');

INSERT INTO `proyecto` (`idProyecto`, `nombre`, `presupuesto`,`fechaInicio`, `fechaFin`,`idDepartamento`)
VALUES ('f89062d9-ba34-40a4-b6af-a21a0dc093be', 'HR Project', 3000, '2019-09-22', '2019-12-31','1e89386d-be37-4930-b6ae-bcba6c9917b4');

INSERT INTO `proyecto` (`idProyecto`, `nombre`, `presupuesto`,`fechaInicio`, `fechaFin`,`idDepartamento`)
VALUES ('10f2db5c-a0c3-40ec-a1bf-a95cab6bebdf', 'DF Project', 1000,'2009-02-22', '2017-04-03', '1e89386d-be37-4930-b6ae-bcba6c9917b4');

INSERT INTO `proyecto` (`idProyecto`, `nombre`, `presupuesto`,`fechaInicio`, `fechaFin`, `idDepartamento`)
VALUES ('2d1d1422-fede-4e27-8883-3ffdb1be1a7c', 'CD Project',8500,'2009-02-22', '2014-04-03', '2d1d1422-fede-4e27-8883-3ffdb1be1a7c');
INSERT INTO `proyecto` (`idProyecto`, `nombre`, `presupuesto`,`fechaInicio`, `fechaFin`,`idDepartamento`)
VALUES ('233b5d47-0ced-4e6f-8982-b2f95b6b25b9', 'Logic Project',5000,'2008-05-23', '2010-04-03', '512a0695-3294-4c2c-86d9-4babd4485fa8');
INSERT INTO `proyecto` (`idProyecto`, `nombre`, `presupuesto`,`fechaInicio`, `fechaFin`, `idDepartamento`)
VALUES ('3730b275-3ed2-4d77-8ff4-f5ce82ea98ea', 'JS Project',7100,'1999-05-23', '2004-09-15', '512a0695-3294-4c2c-86d9-4babd4485fa8');

DROP TABLE IF EXISTS `tecnologia`;
CREATE TABLE `tecnologia`
(
    `idTecnologia`  varchar(36)  NOT NULL,
    `nombre`        varchar(20)  NOT NULL,
    PRIMARY KEY (`idTecnologia`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


INSERT INTO `tecnologia` (`idTecnologia`, `nombre`)

VALUES ('20bcca63-7b60-4a43-bb10-4c9735587d16','Python'),

       ('4f119f1b-7ccf-49f4-b56f-fdace8589b1c','Kotlin'),

       ('cb231a1d-ffc8-4a64-b090-1334f5f4f740','Java');

DROP TABLE IF EXISTS `utilidades`;
CREATE TABLE `utilidades`
(
    `idUtilidades` varchar(36)  ,
    `idProyecto`   varchar(36)  ,
    `idTecnologia`  varchar(36) ,
    PRIMARY KEY (`idUtilidades`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `utilidades` (`idUtilidades`, `idProyecto`, `idTecnologia`)

VALUES ('a861eeba-2983-46ea-a3c1-6ccdaed4f21e', '81ee1211-760c-493d-968a-380e6af67363','20bcca63-7b60-4a43-bb10-4c9735587d16');
INSERT INTO `utilidades` (`idUtilidades`, `idProyecto`, `idTecnologia`)
VALUES ('69b2ae91-8762-4bb3-8181-cbb8c80334f9', 'f89062d9-ba34-40a4-b6af-a21a0dc093be','4f119f1b-7ccf-49f4-b56f-fdace8589b1c');
INSERT INTO `utilidades` (`idUtilidades`, `idProyecto`, `idTecnologia`)
VALUES ('405fda30-1677-4f96-8ae4-b37db5d1a99b', '10f2db5c-a0c3-40ec-a1bf-a95cab6bebdf','20bcca63-7b60-4a43-bb10-4c9735587d16');


DROP TABLE IF EXISTS `participaciones`;
CREATE TABLE `participaciones`
(
    `idParticipaciones` varchar(36)  NOT NULL,
    `idProyecto`        varchar(36)  NOT NULL,
    `idProgramador`     varchar(36) NOT NULL,
    PRIMARY KEY (`idParticipaciones`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `participaciones` (`idParticipaciones`, `idProyecto`, `idProgramador`)

VALUES ('37928235-0838-4663-88e8-5fd05330a52d', '81ee1211-760c-493d-968a-380e6af67363','1376acc9-79a9-4bf1-9084-c82e9a07f432');
INSERT INTO `participaciones` (`idParticipaciones`, `idProyecto`, `idProgramador`)
VALUES ('21ee0a9c-002f-4cd2-8500-67b65eae015a', 'f89062d9-ba34-40a4-b6af-a21a0dc093be','d63f0d73-3f1b-4afd-b5d0-821449daa4a3');
INSERT INTO `participaciones` (`idParticipaciones`, `idProyecto`, `idProgramador`)
VALUES ('dbde1829-9951-44dd-9b41-3f66cc87bd09', '10f2db5c-a0c3-40ec-a1bf-a95cab6bebdf','d63f0d73-3f1b-4afd-b5d0-821449daa4a3');