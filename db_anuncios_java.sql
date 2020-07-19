-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-07-2020 a las 20:05:45
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_anuncios_java`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_anuncios`
--

CREATE TABLE `tabla_anuncios` (
  `id` int(11) NOT NULL,
  `articulo` varchar(70) NOT NULL,
  `cambio` varchar(3) DEFAULT 'No',
  `anuncio` varchar(300) NOT NULL,
  `envio` tinyint(1) NOT NULL,
  `precio` decimal(6,2) NOT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_categoria` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tabla_anuncios`
--

INSERT INTO `tabla_anuncios` (`id`, `articulo`, `cambio`, `anuncio`, `envio`, `precio`, `telefono`, `email`, `id_categoria`) VALUES
(1, 'Patines Linea ', '1', 'Vendo patines en linea blancos talla 38-39', 0, '150.00', 123456789, 'patines@patines.es', 4),
(2, 'Láminas de Tarantino', '1', 'Láminas de películas de Tarantino, perfectas para decoración como cuadros. Se venden individualmente', 0, '20.00', 666666666, 'laminas@gmail.com', 2),
(3, 'Prueba', '1', 'Probando booleano', 1, '45.00', 657842136, 'sissi@gmail.com', 1),
(4, '2323', '1', '23', 0, '452.00', 123456789, 'silvia@gmail.com', 1),
(5, 'Gss', '1', '1233', 1, '124.00', 123456789, 'jjj@gmail.com', 1),
(6, '12', '1', '12', 1, '12.00', 121212, 'adad@gmail.com', 1),
(8, 'prueba true', '1', 'qwqewe', 0, '123.00', 542368, 'ssddf@gmail.com', 1),
(9, '1212', 'No', '2323', 0, '12.00', 23234234, 'sss@gail.es', 2),
(13, 'sin marcar', '1', '233', 0, '123.00', 1324, 'asdsdsds@dff.ws', 1),
(16, 'Cámara Nikon', 'No', '\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ut labore et dolore magna aliqua', 1, '96.50', 652479625, 'asds@gmail.com', 6),
(17, 'Huawei P10', 'No', 'Vendo móvil negro Huawei P10, libre con funda de gel transparente', 1, '250.00', 452965742, 'movil@gmail.com', 1),
(18, 'Xbox 360', 'No', 'Funciona perfectamente,más de 50 juegos (escríbeme para más información)', 1, '100.00', 654875963, 'xbox@gmail.es', 3),
(19, 'Lg Sound System 3.6', 'No', 'Barra de sonido 5.1', 1, '75.50', 569874236, 'barrasonido@gmai.com', 6),
(20, 'Bolso de tela', 'Si', 'Bolso de tela artesanal', 1, '15.00', 652478935, 'bolso@gmail.es', 7),
(21, 'Lampara luces arbol', 'Si', 'Vendo lápara decorativa con árbol,', 1, '25.36', 452136987, 'lampara@gmai.com', 2),
(22, 'Gorra NY Yankees-', 'Si', 'Gorra de chica  New York Yankees oficial. Tall 43,.', 1, '23.56', 123456755, 'gorra@gmail.es', 7),
(23, 'Lg Sound System 3.6', 'No', 'Barra de sonido 5.1', 0, '75.50', 569874236, 'barrasonido@gmai.com', 6),
(24, 'Ajedrez cristal', 'No', 'Totalmente nuevo, con estuche de madera..', 0, '45.25', 546987123, 'aledrez@gmail.com', 3),
(25, 'Camara Réflex', 'No', 'Cámara semi nueva, solo 120 disparos. Sony', 1, '75.00', 123456789, 'camara@gmail.com', 6),
(26, 'Camara reflex Sony', 'No', 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur', 0, '12.20', 123456789, 'camara1@gmail.es', 6),
(27, 'Cámara Fotos', 'No', 'simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took ', 0, '78.12', 123456789, 'camara@gmail.com', 2),
(28, 'Bici de montaña', 'No', 'Bici de montaña de chica de 1.45 a 1.70cm. Ruedas de 24pulgadas.\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ', 0, '80.50', 123456789, 'bicicleta@gmail.com', 4),
(34, 'Prueba', 'No', 'dgggggggggggdg ggfhgj thhhhhhhhhhhhhhhh', 1, '12.45', 123456789, 'prueba@gmail.es', 1),
(36, 'gg@gmail.es', 'No', 'gg@gmail.es', 0, '12.00', 123456789, 'gg@gmail.es', 3),
(39, 'dddd@gmail.com', 'No', 'dddd@gmail.com', 0, '12.00', 123456789, 'dddd@gmail.com', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_categorias`
--

CREATE TABLE `tabla_categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tabla_categorias`
--

INSERT INTO `tabla_categorias` (`id`, `nombre`) VALUES
(1, 'SIN CATEGORIA'),
(2, 'HOGAR'),
(3, 'OCIO'),
(4, 'DEPORTE'),
(5, 'TELECOMUNICACIONES'),
(6, 'IMAGEN Y SONIDO'),
(7, 'MODA Y COMPLEMENTOS');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tabla_anuncios`
--
ALTER TABLE `tabla_anuncios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tabla_categorias`
--
ALTER TABLE `tabla_categorias`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tabla_anuncios`
--
ALTER TABLE `tabla_anuncios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `tabla_categorias`
--
ALTER TABLE `tabla_categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
