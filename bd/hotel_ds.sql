-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22-Out-2024 às 19:04
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `hotel_ds`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `quartos`
--

CREATE TABLE `quartos` (
  `N_Quarto` int(3) NOT NULL,
  `acomoda` int(2) NOT NULL,
  `varanda` tinyint(1) DEFAULT NULL,
  `microondas` tinyint(1) DEFAULT NULL,
  `frigobar` tinyint(1) DEFAULT NULL,
  `tv` tinyint(1) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `ocupado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `quartos`
--

INSERT INTO `quartos` (`N_Quarto`, `acomoda`, `varanda`, `microondas`, `frigobar`, `tv`, `cpf`, `ocupado`) VALUES
(101, 2, 1, 1, 1, 1, NULL, 0),
(102, 2, 0, 1, 1, 0, '98765432100', 0);

--
-- Acionadores `quartos`
--
DELIMITER $$
CREATE TRIGGER `update_cpf` BEFORE UPDATE ON `quartos` FOR EACH ROW BEGIN
    IF NEW.ocupado = 0 THEN
        SET NEW.cpf = null;
    END IF;
END
$$
DELIMITER ;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `quartos`
--
ALTER TABLE `quartos`
  ADD PRIMARY KEY (`N_Quarto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
