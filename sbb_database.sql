# DB 생성
DROP DATABASE IF EXISTS sbb;
CREATE DATABASE sbb;
USE sbb;

# 회원 테이블 생성
CREATE TABLE `user` (
    id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    reg_date DATETIME NOT NULL,
    update_date DATETIME NOT NULL,
    email VARCHAR(100) NOT NULL,
    `password` VARCHAR(150) NOT NULL,
    `name` CHAR(50) NOT NULL
);


# 회원 데이터 생성
INSERT INTO `user`
SET reg_date = NOW(),
update_date = NOW(),
email = 'use1@test.com',
`password` = '1234',
`name` = '유저1';

INSERT INTO `user`
SET reg_date = NOW(),
update_date = NOW(),
email = 'use2@test.com',
`password` = '1234',
`name` = '유저2';

INSERT INTO `user`
SET reg_date = NOW(),
update_date = NOW(),
email = 'use3@test.com',
`password` = '1234',
`name` = '유저3';

# 게시물 테이블 생성
CREATE TABLE `article` (
    id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    reg_date DATETIME NOT NULL,
    update_date DATETIME NOT NULL,
    title VARCHAR(100) NOT NULL,
    `body` TEXT NOT NULL,
    `user_id` BIGINT UNSIGNED NOT NULL
);

# 게시물 데이터 생성
INSERT INTO `article`
SET reg_date = NOW(),
update_date = NOW(),
title = '제목 1',
`body` = '내용 1',
`user_id` = 1;

INSERT INTO `article`
SET reg_date = NOW(),
update_date = NOW(),
title = '제목 2',
`body` = '내용 2',
`user_id` = 2;

INSERT INTO `article`
SET reg_date = NOW(),
update_date = NOW(),
title = '제목 3',
`body` = '내용 3',
`user_id` = 3;


CREATE TABLE Question (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `subject` VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    create_date DATETIME NOT NULL,
    view_count INT(11) UNSIGNED NOT NULL DEFAULT 0
);

INSERT INTO Question SET
create_date = NOW(),
`subject` = '질문 1',
content = '질문내용 1';

INSERT INTO Question SET
create_date = NOW(),
`subject` = '질문 2',
content = '질문내용 2';

INSERT INTO Question SET
create_date = NOW(),
`subject` = '질문 3',
content = '질문내용 3';

SELECT * FROM Question;


CREATE TABLE Answer (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    create_date DATETIME NOT NULL,
    question_id INT(11) UNSIGNED NOT NULL,
    reply_like VARCHAR(10) NOT NULL
);

INSERT INTO Answer SET
create_date = NOW(),
content = '답변내용 1',
question_id = 1;

INSERT INTO Answer SET
create_date = NOW(),
content = '답변내용 2',
question_id = 2;

INSERT INTO Answer SET
create_date = NOW(),
content = '답변내용 3',
question_id = 3; 

SELECT * FROM Answer;


CREATE TABLE site_user(
    id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username varchar(50) UNIQUE not null,
    `password` VARCHAR(150) not null,
    email VARCHAR(50) UNIQUE NOT NULL
);

insert into site_user set
username = "유저1",
`password` = "1234",
email = "test@test.com";

select * from site_user;