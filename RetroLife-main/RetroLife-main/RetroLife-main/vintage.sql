-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-02-2024 a las 18:41:18
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
-- Base de datos: `vintage`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `Id_carrito` int(11) NOT NULL,
  `Id_cliente_carrito` int(11) DEFAULT NULL,
  `Nombre_carrito` varchar(50) DEFAULT NULL,
  `Precio_carrito` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Id_cliente` int(11) NOT NULL,
  `Nombre_cliente` varchar(30) DEFAULT NULL,
  `Contrasena_cliente` varchar(30) DEFAULT NULL,
  `Email_cliente` varchar(30) DEFAULT NULL,
  `Telefono_cliente` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Id_cliente`, `Nombre_cliente`, `Contrasena_cliente`, `Email_cliente`, `Telefono_cliente`) VALUES
(1, 'Antonio García Pérez', 'agp', 'antoniogp@gmail.com', '+34637593628'),
(2, 'Luis Alcazar González', 'lag', 'luisag@gmail.com', '+34627593588'),
(3, 'Mónica Naranjo Martín', 'mnm', 'monicanm@gmail.com', '+34624353081'),
(4, 'Sara Ruíz Sánchez', 'srs', 'sarars@gmail.com', '+34624354380'),
(5, 'Alejandro Benedito Carrascal', 'abc', 'alejandrobc@gmail.com', '+34614343087');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `Id_direccion` int(11) NOT NULL,
  `Codigo_postal` varchar(5) DEFAULT NULL,
  `Municipio` varchar(30) DEFAULT NULL,
  `Nombre_via` varchar(30) DEFAULT NULL,
  `Id_cliente_direccion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`Id_direccion`, `Codigo_postal`, `Municipio`, `Nombre_via`, `Id_cliente_direccion`) VALUES
(1, '28231', 'Madrid', 'Payaso Fofo', 1),
(2, '28018', 'Madrid', 'Arturo Soria', 2),
(3, '13022', 'Ciudad Real', 'Pablo Neruda', 3),
(4, '8982', 'Barcelona', 'Miguel Hernández', 4),
(5, '18556', 'Granada', 'Fuencarral', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `Id_pedido` int(11) NOT NULL,
  `Fecha_entrega` date DEFAULT NULL,
  `Precio_total` double DEFAULT NULL,
  `Id_cliente_pedido` int(11) DEFAULT NULL,
  `Id_tarjeta_pedido` int(11) DEFAULT NULL,
  `Id_direccion_pedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`Id_pedido`, `Fecha_entrega`, `Precio_total`, `Id_cliente_pedido`, `Id_tarjeta_pedido`, `Id_direccion_pedido`) VALUES
(1, '2024-03-09', 32.08, 1, 1, 1),
(2, '2024-02-11', 50, 2, 2, 2),
(3, '2024-06-20', 25.8, 3, 3, 3),
(4, '2024-03-16', 12.6, 4, 4, 4),
(5, '2024-09-11', 82, 5, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_producto`
--

CREATE TABLE `pedido_producto` (
  `Id_producto_pedido` int(11) DEFAULT NULL,
  `Id_pedido_producto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido_producto`
--

INSERT INTO `pedido_producto` (`Id_producto_pedido`, `Id_pedido_producto`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `Id_producto` int(11) NOT NULL,
  `Nombre_producto` varchar(30) DEFAULT NULL,
  `Descripcion_producto` varchar(50) DEFAULT NULL,
  `Precio_producto` double DEFAULT NULL,
  `Url_producto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`Id_producto`, `Nombre_producto`, `Descripcion_producto`, `Precio_producto`, `Url_producto`) VALUES
(1, 'Camiseta Puma', 'Camiseta blanca de Puma del año 1992', 15, 'https://th.bing.com/th/id/OIP.B3-RCgtwQj0KUvuUipeadwHaHa?w=198&h=197&c=7&r=0&o=5&pid=1.7'),
(2, 'Camiseta Jordan', 'Camiseta de Jordan del año 1996', 25, 'https://th.bing.com/th/id/OIP.PKVsvAye80z0CEyopTQNCgHaHa?w=209&h=209&c=7&r=0&o=5&pid=1.7'),
(3, 'Maquina recreativa', 'Máquina arcade del año 2000', 499.99, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTc0vUuftSNsNUVjtf1OUOK2CTV6vl8QYT35w&usqp=CAU'),
(4, 'Póster ACP', 'Póster de Aterriza comp puedas del año 1985', 10.5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlqCZJhbczCfNJIkdIsj0O1dkONuJNOV14fg&usqp=CAU'),
(5, 'Sudadera Nike', 'Sudadera Nike del año 2006', 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOn7ojNtDiYzEKhPKZgUnUkKvRg6Sr7C8Ow&usqp=CAU'),
(6, 'Cámara Nikon', 'Cámara Nikon del año 1991', 42.98, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUdDoGMWhJJ1pzVHm4BOUm88dtHoevRiMSBw&usqp=CAU'),
(7, 'Zapatillas Converse', 'Zapatillas Converse de los años 90', 38.9, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6ze0AEVlPoZIQ-Gnfdt01KaldSibcSOQ4FbsgTmHzDEJcC8KiLIXMm-h75a6ZGs5ihq4&usqp=CAU'),
(8, 'Nintendo DS', 'Consola del año 2001', 18, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRb7nsFuPNXYcHXHjj2snOCbT8sZPKSwEDKAw&usqp=CAU'),
(9, 'Guantes Charlie', 'Guantes de boxeo Charlie del año 1985', 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSORLohMehRduCBBsoRmGY96x9SDs5CcgWULQ&usqp=CAU'),
(10, 'Camiseta Maradona', 'Camiseta de Maradona del 1986', 35.95, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz4v6F9pYUpfuHaF2cR3YZ_ogrmDQk656Pjw&usqp=CAU');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `Id_tarjeta` int(11) NOT NULL,
  `Numero_tarjeta` varchar(16) DEFAULT NULL,
  `Fecha_caducidad` varchar(5) DEFAULT NULL,
  `CVV_tarjeta` varchar(3) DEFAULT NULL,
  `Id_cliente_tarjeta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`Id_tarjeta`, `Numero_tarjeta`, `Fecha_caducidad`, `CVV_tarjeta`, `Id_cliente_tarjeta`) VALUES
(1, '3859412426352151', '12/26', '493', 1),
(2, '4850837428931543', '08/25', '245', 2),
(3, '1934112312381223', '07/28', '658', 3),
(4, '4327121717232173', '07/26', '283', 4),
(5, '0243129299219231', '17/29', '834', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`Id_carrito`),
  ADD KEY `Id_cliente_carrito` (`Id_cliente_carrito`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Id_cliente`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`Id_direccion`),
  ADD KEY `Id_cliente_direccion` (`Id_cliente_direccion`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`Id_pedido`),
  ADD KEY `Id_cliente_pedido` (`Id_cliente_pedido`),
  ADD KEY `Id_tarjeta_pedido` (`Id_tarjeta_pedido`),
  ADD KEY `Id_direccion_pedido` (`Id_direccion_pedido`);

--
-- Indices de la tabla `pedido_producto`
--
ALTER TABLE `pedido_producto`
  ADD KEY `Id_producto_pedido` (`Id_producto_pedido`),
  ADD KEY `Id_pedido_producto` (`Id_pedido_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`Id_producto`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`Id_tarjeta`),
  ADD KEY `Id_cliente_tarjeta` (`Id_cliente_tarjeta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carrito`
--
ALTER TABLE `carrito`
  MODIFY `Id_carrito` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `Id_direccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `Id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `Id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  MODIFY `Id_tarjeta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`Id_cliente_carrito`) REFERENCES `cliente` (`Id_cliente`);

--
-- Filtros para la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD CONSTRAINT `direccion_ibfk_1` FOREIGN KEY (`Id_cliente_direccion`) REFERENCES `cliente` (`Id_cliente`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`Id_cliente_pedido`) REFERENCES `cliente` (`Id_cliente`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`Id_tarjeta_pedido`) REFERENCES `tarjeta` (`Id_tarjeta`),
  ADD CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`Id_direccion_pedido`) REFERENCES `direccion` (`Id_direccion`);

--
-- Filtros para la tabla `pedido_producto`
--
ALTER TABLE `pedido_producto`
  ADD CONSTRAINT `pedido_producto_ibfk_1` FOREIGN KEY (`Id_producto_pedido`) REFERENCES `producto` (`Id_producto`),
  ADD CONSTRAINT `pedido_producto_ibfk_2` FOREIGN KEY (`Id_pedido_producto`) REFERENCES `pedido` (`Id_pedido`);

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `tarjeta_ibfk_1` FOREIGN KEY (`Id_cliente_tarjeta`) REFERENCES `cliente` (`Id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
