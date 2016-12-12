使用文件夹中的 StudentJDBCTemplate ，MainApp 文件替换 SpringEvent 中的StudentJDBCTemplate ,MainApp 文件。

使用 grant 语句为用户赋权：

GRANT SELECT ON mysql.proc TO 'user'@'localhost';  

（user 是用户名，localhost 是数据库的 sid）

建表语句：
create table Student( id int not null auto_increment,
name varchar(20) not null,
age int not null,
primary key(id)
);
