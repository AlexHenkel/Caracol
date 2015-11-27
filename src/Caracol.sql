/*
 Navicat MySQL Data Transfer

 Source Server         : connection
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : 127.0.0.1
 Source Database       : Caracol

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : utf-8

 Date: 11/26/2015 18:23:25 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Administrador`
-- ----------------------------
DROP TABLE IF EXISTS `Administrador`;
CREATE TABLE `Administrador` (
  `id_Administrador` smallint(5) NOT NULL,
  `id_Usuario` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id_Administrador`),
  KEY `id_Usuario` (`id_Usuario`),
  CONSTRAINT `fk_UsuarioAdministrador` FOREIGN KEY (`id_Usuario`) REFERENCES `Usuario` (`id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `Beneficiario`
-- ----------------------------
DROP TABLE IF EXISTS `Beneficiario`;
CREATE TABLE `Beneficiario` (
  `id_Beneficiario` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `id_Persona` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id_Beneficiario`),
  KEY `id_Persona` (`id_Persona`),
  CONSTRAINT `fk_PersonaBeneficiario` FOREIGN KEY (`id_Persona`) REFERENCES `Persona` (`id_Persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `Curso`
-- ----------------------------
DROP TABLE IF EXISTS `Curso`;
CREATE TABLE `Curso` (
  `id_Curso` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id_Curso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `Grupo`
-- ----------------------------
DROP TABLE IF EXISTS `Grupo`;
CREATE TABLE `Grupo` (
  `id_Grupo` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `id_Curso` smallint(5) unsigned NOT NULL,
  `cupo` smallint(5) unsigned DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `num_grupo` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_Grupo`),
  KEY `id_Curso` (`id_Curso`),
  CONSTRAINT `fk_CursoGrupo` FOREIGN KEY (`id_Curso`) REFERENCES `Curso` (`id_Curso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `GrupoBeneficiario`
-- ----------------------------
DROP TABLE IF EXISTS `GrupoBeneficiario`;
CREATE TABLE `GrupoBeneficiario` (
  `id_Grupo` smallint(5) unsigned NOT NULL,
  `id_Beneficiario` smallint(5) unsigned NOT NULL,
  `asistencias` smallint(5) unsigned NOT NULL DEFAULT '0',
  `calificacion` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_Grupo`,`id_Beneficiario`),
  KEY `id_Beneficiario` (`id_Beneficiario`),
  CONSTRAINT `fk_GrupoBeneficiarioB` FOREIGN KEY (`id_Beneficiario`) REFERENCES `Beneficiario` (`id_Beneficiario`),
  CONSTRAINT `fk_GrupoBeneficiarioG` FOREIGN KEY (`id_Grupo`) REFERENCES `Grupo` (`id_Grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `GrupoSocio`
-- ----------------------------
DROP TABLE IF EXISTS `GrupoSocio`;
CREATE TABLE `GrupoSocio` (
  `id_Grupo` smallint(5) unsigned NOT NULL,
  `id_Socio` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id_Grupo`,`id_Socio`),
  KEY `id_Socio` (`id_Socio`),
  CONSTRAINT `fk_GrupoSocioG` FOREIGN KEY (`id_Grupo`) REFERENCES `Grupo` (`id_Grupo`),
  CONSTRAINT `fk_GrupoSocioS` FOREIGN KEY (`id_Socio`) REFERENCES `Socio` (`id_Socio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `GrupoTutor`
-- ----------------------------
DROP TABLE IF EXISTS `GrupoTutor`;
CREATE TABLE `GrupoTutor` (
  `id_Tutor` smallint(5) unsigned NOT NULL,
  `id_Grupo` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id_Tutor`,`id_Grupo`),
  KEY `id_Grupo` (`id_Grupo`),
  CONSTRAINT `fk_GrupoTutorG` FOREIGN KEY (`id_Grupo`) REFERENCES `Grupo` (`id_Grupo`),
  CONSTRAINT `fk_GrupoTutorT` FOREIGN KEY (`id_Tutor`) REFERENCES `Tutor` (`id_Tutor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `Persona`
-- ----------------------------
DROP TABLE IF EXISTS `Persona`;
CREATE TABLE `Persona` (
  `id_Persona` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `direccion` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_Persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `Socio`
-- ----------------------------
DROP TABLE IF EXISTS `Socio`;
CREATE TABLE `Socio` (
  `id_Socio` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `id_Usuario` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id_Socio`),
  KEY `id_Usuario` (`id_Usuario`),
  CONSTRAINT `fk_UsuarioSocio` FOREIGN KEY (`id_Usuario`) REFERENCES `Usuario` (`id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `Tutor`
-- ----------------------------
DROP TABLE IF EXISTS `Tutor`;
CREATE TABLE `Tutor` (
  `id_Tutor` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `id_Usuario` smallint(5) unsigned NOT NULL,
  `experiencia` smallint(5) DEFAULT '0',
  PRIMARY KEY (`id_Tutor`),
  KEY `id_Usuario` (`id_Usuario`),
  CONSTRAINT `fk_UsuarioTutor` FOREIGN KEY (`id_Usuario`) REFERENCES `Usuario` (`id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `Usuario`
-- ----------------------------
DROP TABLE IF EXISTS `Usuario`;
CREATE TABLE `Usuario` (
  `id_Usuario` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `id_Persona` smallint(5) unsigned NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `permiso` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_Usuario`),
  KEY `id_Persona` (`id_Persona`),
  CONSTRAINT `fk_PersonaUsuario` FOREIGN KEY (`id_Persona`) REFERENCES `Persona` (`id_Persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
