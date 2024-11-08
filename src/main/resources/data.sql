INSERT INTO `department` (`id`, `name`, `chief_id`) VALUES
(1, 'Recursos Humanos', NULL),
(2, 'Desarrollo', NULL),
(3, 'Marketing', NULL),
(4, 'Ventas', NULL);

INSERT INTO `position` (`id`, `name`, `salary`) VALUES
(1, 'Gerente', 80000),
(2, 'Desarrollador Senior', 60000),
(3, 'Desarrollador Junior', 40000),
(4, 'Asistente de Marketing', 35000),
(5, 'Representante de Ventas', 45000);

INSERT INTO `employee` (`id`, `dep_id`, `pos_id`, `birth_date`, `entry_date`, `first_name`, `last_name`) VALUES
(1, 1, 1, '1980-03-15 00:00:00.000000', '2010-05-01 00:00:00.000000', 'Carlos', 'López'),
(2, 2, 2, '1985-07-20 00:00:00.000000', '2012-06-15 00:00:00.000000', 'Ana', 'Gómez'),
(3, 2, 3, '1992-11-30 00:00:00.000000', '2018-03-22 00:00:00.000000', 'Pedro', 'Martínez'),
(4, 3, 4, '1995-01-10 00:00:00.000000', '2019-08-12 00:00:00.000000', 'Laura', 'Fernández'),
(5, 4, 5, '1990-04-25 00:00:00.000000', '2017-11-05 00:00:00.000000', 'Juan', 'Pérez');

-- Asignar jefes a los departamentos (utilizando los IDs de empleados ya insertados)
UPDATE `department` SET `chief_id` = 1 WHERE `id` = 1;
UPDATE `department` SET `chief_id` = 2 WHERE `id` = 2;
UPDATE `department` SET `chief_id` = 4 WHERE `id` = 3;
UPDATE `department` SET `chief_id` = 5 WHERE `id` = 4;


INSERT INTO `project` (`id`, `name`, `description`, `start_date`, `end_date`) VALUES
(1, 'Proyecto A', 'Desarrollo de sistema de gestión', '2024-01-01 00:00:00.000000', '2024-12-31 00:00:00.000000'),
(2, 'Proyecto B', 'Campaña de marketing digital', '2024-03-01 00:00:00.000000', '2024-09-30 00:00:00.000000'),
(3, 'Proyecto C', 'Plataforma de ventas en línea', '2024-05-15 00:00:00.000000', '2025-05-15 00:00:00.000000');

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'Líder de Proyecto'),
(2, 'Desarrollador'),
(3, 'Asistente'),
(4, 'Analista');

INSERT INTO `project_assignment` (`id`, `employee_id`, `project_id`, `role_id`) VALUES
(1, 2, 1, 1),
(2, 3, 1, 2),
(3, 4, 2, 3),
(4, 1, 3, 4),
(5, 5, 2, 1);

INSERT INTO `visit` (`department_id`, `employee_id`) VALUES
(1, 2),
(1, 3),
(2, 4),
(3, 5),
(4, 1);
