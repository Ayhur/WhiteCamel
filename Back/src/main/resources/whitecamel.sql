-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2024 a las 16:20:14
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `whitecamel`
--

--
-- Estructura de tabla para la tabla `wh_test_correcciones`
--

CREATE TABLE `wh_test_correcciones` (
  `wh_test_correcciones_id` int(11) NOT NULL,
  `wh_test_correcciones_pre` int(11) NOT NULL,
  `wh_test_correcciones_res` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `wh_test_correcciones`
--

INSERT INTO `wh_test_correcciones` (`wh_test_correcciones_id`, `wh_test_correcciones_pre`, `wh_test_correcciones_res`) VALUES
(1, 1, 1),
(2, 2, 5),
(3, 3, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `wh_test_preguntas`
--

CREATE TABLE `wh_test_preguntas` (
  `wh_test_pre_id` int(11) NOT NULL COMMENT 'id incremental',
  `wh_test_pre_descripcion` varchar(255) NOT NULL COMMENT 'Descripcion de la pregunta',
  `wh_test_pre_test` int(11) NOT NULL COMMENT 'FK del test al que esta vinculada la pregunta'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `wh_test_preguntas`
--

INSERT INTO `wh_test_preguntas` (`wh_test_pre_id`, `wh_test_pre_descripcion`, `wh_test_pre_test`) VALUES
(1, '¿Cuál es la velocidad máxima en áreas urbanas?', 1),
(2, '¿Qué indica una señal de stop?', 2),
(3, '¿Cuáles son las luces adecuadas para conducir de noche?', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `wh_test_respuestas`
--

CREATE TABLE `wh_test_respuestas` (
  `wh_test_res_id` int(11) NOT NULL COMMENT 'id autoincremental',
  `wh_test_res_descripcion` varchar(255) NOT NULL,
  `wh_test_res_pre` int(11) NOT NULL COMMENT 'FK de la pregunta  a la que esta vinculada la respuesta'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `wh_test_respuestas`
--

INSERT INTO `wh_test_respuestas` (`wh_test_res_id`, `wh_test_res_descripcion`, `wh_test_res_pre`) VALUES
(1, '50 km/h', 1),
(2, '80 km/h', 1),
(3, '30 km/h', 1),
(4, 'Ceder el paso a todos los vehículos', 2),
(5, 'Detenerse completamente y ceder el paso', 2),
(6, 'Acelerar antes de cruzar', 2),
(7, 'Luces altas siempre', 3),
(8, 'Luces bajas en zonas urbanas', 3),
(9, 'Luces de emergencia', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `wh_user`
--

CREATE TABLE `wh_user` (
  `wh_id` bigint(20) NOT NULL,
  `wh_nombre` varchar(50) NOT NULL COMMENT 'Nombre de la persona',
  `wh_apellido1` varchar(40) NOT NULL COMMENT 'Priemr apellido',
  `wh_apellido2` varchar(40) DEFAULT NULL COMMENT 'Segundo apellido en caso de tenerlo',
  `wh_dni` varchar(9) NOT NULL COMMENT 'el dni de usuario',
  `wh_password` varchar(16) NOT NULL COMMENT 'Paswword maximo 16 caracteres'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `wh_user`
--

INSERT INTO `wh_user` (`wh_id`, `wh_nombre`, `wh_apellido1`, `wh_apellido2`, `wh_dni`, `wh_password`) VALUES
(1, 'Juan', 'Perez', 'García', '1234', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `wh_test_correcciones`
--
ALTER TABLE `wh_test_correcciones`
  ADD PRIMARY KEY (`wh_test_correcciones_id`),
  ADD KEY `fk_wh_test_correcciones_pre` (`wh_test_correcciones_pre`),
  ADD KEY `fk_wh_test_correcciones_res` (`wh_test_correcciones_res`);

--
-- Indices de la tabla `wh_test_preguntas`
--
ALTER TABLE `wh_test_preguntas`
  ADD PRIMARY KEY (`wh_test_pre_id`);

--
-- Indices de la tabla `wh_test_respuestas`
--
ALTER TABLE `wh_test_respuestas`
  ADD PRIMARY KEY (`wh_test_res_id`);

--
-- Indices de la tabla `wh_user`
--
ALTER TABLE `wh_user`
  ADD PRIMARY KEY (`wh_id`),
  ADD UNIQUE KEY `dni_unique` (`wh_dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `wh_test_correcciones`
--
ALTER TABLE `wh_test_correcciones`
  MODIFY `wh_test_correcciones_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `wh_test_preguntas`
--
ALTER TABLE `wh_test_preguntas`
  MODIFY `wh_test_pre_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id incremental', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `wh_test_respuestas`
--
ALTER TABLE `wh_test_respuestas`
  MODIFY `wh_test_res_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id autoincremental', AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `wh_test_correcciones`
--
ALTER TABLE `wh_test_correcciones`
  ADD CONSTRAINT `fk_wh_test_correcciones_pre` FOREIGN KEY (`wh_test_correcciones_pre`) REFERENCES `wh_test_preguntas` (`wh_test_pre_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_wh_test_correcciones_res` FOREIGN KEY (`wh_test_correcciones_res`) REFERENCES `wh_test_respuestas` (`wh_test_res_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
