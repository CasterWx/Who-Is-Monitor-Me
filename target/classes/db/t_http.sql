CREATE TABLE t_http (
	`id` int primary key auto_increment,
	`hostname` VARCHAR(50) not null ,
	`ip` VARCHAR(50) ,
	`address` VARCHAR(256),
	`date` DATE
) ;