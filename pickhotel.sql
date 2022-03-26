# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 54.180.153.61 (MySQL 5.7.36)
# Database: pichoteldb
# Generation Time: 2022-03-14 04:52:10 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table alarm
# ------------------------------------------------------------

DROP TABLE IF EXISTS `alarm`;

CREATE TABLE `alarm` (
                         `al_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '알림번호',
                         `al_type` char(1) NOT NULL DEFAULT '1' COMMENT '알림유형 (1: 새 댓글, 2: 새 답글,  3: 등업, 4: 이벤트 당첨, 5: 게시글 신고, 6: 댓글 신고)',
                         `al_read` tinyint(1) NOT NULL DEFAULT '0' COMMENT '읽음여부(0:미열람, 1:열람)',
                         `al_content` text COMMENT '알림내용',
                         `al_url` text COMMENT '알림 랜딩 페이지',
                         `al_datetime` datetime DEFAULT NULL COMMENT '알림 생성일시',
                         `mb_no` int(11) NOT NULL COMMENT '회원번호',
                         PRIMARY KEY (`al_no`),
                         KEY `FK_member_TO_alarm` (`mb_no`),
                         CONSTRAINT `FK_member_TO_alarm` FOREIGN KEY (`mb_no`) REFERENCES `member` (`mb_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='알림';

LOCK TABLES `alarm` WRITE;
/*!40000 ALTER TABLE `alarm` DISABLE KEYS */;

INSERT INTO `alarm` (`al_no`, `al_type`, `al_read`, `al_content`, `al_url`, `al_datetime`, `mb_no`)
VALUES
    (82,'1',0,'내 게시글에 댓글이 달렸어요.','/board/32/post/92#comment_1','2022-01-18 14:42:33',10),
    (83,'1',0,'내 게시글에 댓글이 달렸어요.','/board/32/post/93#comment_2','2022-01-18 14:43:17',10),
    (84,'1',0,'내 게시글에 댓글이 달렸어요.','/board/32/post/92#comment_3','2022-01-18 14:43:41',10),
    (87,'1',0,'내 게시글에 댓글이 달렸어요.','/board/32/post/92#comment_4','2022-01-18 14:54:06',10),
    (89,'1',0,'내 게시글에 댓글이 달렸어요.','/board/32/post/93#comment_6','2022-01-18 14:54:52',10),
    (103,'1',1,'내 게시글에 댓글이 달렸어요.','/board/32/post/102#comment_14','2022-01-18 15:59:22',4),
    (104,'2',1,'내 댓글에 답글이 달렸어요.','/board/32/post/96#comment_16','2022-01-18 16:24:47',4),
    (116,'3',1,'4등급으로 등업되었어요. 축하해요!',NULL,'2022-01-18 17:54:50',4),
    (117,'3',1,'3등급으로 등업되었어요. 축하해요!',NULL,'2022-01-18 17:55:02',4),
    (118,'3',1,'3등급으로 등업되었어요. 축하해요!',NULL,'2022-01-18 17:55:10',4),
    (119,'3',1,'3등급으로 등업되었어요. 축하해요!',NULL,'2022-01-18 17:55:23',4),
    (120,'3',1,'4등급으로 등업되었어요. 축하해요!',NULL,'2022-01-18 17:55:51',4),
    (121,'3',1,'4등급으로 등업되었어요. 축하드려요!\n다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-18 17:55:51',4),
    (122,'3',1,'3등급으로 등업되었어요. 축하해요!',NULL,'2022-01-18 17:56:38',4),
    (123,'3',1,'4등급으로 등업되었어요. 축하해요!',NULL,'2022-01-18 17:57:49',4),
    (124,'3',1,'4등급으로 등업되었어요. 축하드려요!\n다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-18 17:57:49',4),
    (174,'3',0,'2등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-18 20:46:08',13),
    (175,'3',0,'2등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-18 20:46:08',12),
    (176,'3',0,'1등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-18 20:46:21',13),
    (177,'3',0,'1등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-18 20:46:21',12),
    (178,'3',1,'2등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-18 20:46:44',4),
    (181,'3',1,'4등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 10:04:19',4),
    (188,'2',1,'멘션되었습니다.','/board/32/post/108#comment_30','2022-01-19 10:44:15',5),
    (189,'2',1,'내 댓글에 답글이 달렸어요.','/board/32/post/108#comment_30','2022-01-19 10:44:21',5),
    (190,'2',1,'내 댓글에 답글이 달렸어요.','/board/32/post/108#comment_30','2022-01-19 10:44:43',5),
    (191,'2',1,'내 댓글에 답글이 달렸어요.','/board/32/post/108#comment_31','2022-01-19 10:44:45',5),
    (206,'3',1,'2등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 12:40:09',2),
    (208,'3',1,'3등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 12:42:52',3),
    (209,'3',1,'2등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 13:23:13',4),
    (210,'3',1,'1등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 13:23:21',3),
    (212,'2',0,'내 댓글에 답글이 달렸어요.','/board/32/post/108#comment_40','2022-01-19 14:47:11',2),
    (213,'1',1,'내 게시글에 댓글이 달렸어요.','/board/32/post/112#comment_44','2022-01-19 15:29:05',1),
    (214,'2',0,'멘션되었습니다.','/board/32/post/112#comment_46','2022-01-19 15:30:13',2),
    (215,'3',1,'2등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 15:33:04',3),
    (216,'1',1,'내 게시글에 댓글이 달렸어요.','/board/32/post/111#comment_47','2022-01-19 15:33:04',1),
    (217,'3',1,'3등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 15:35:17',4),
    (218,'3',0,'3등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 15:36:21',22),
    (219,'3',0,'3등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 15:36:21',13),
    (220,'3',0,'3등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.',NULL,'2022-01-19 15:36:21',12);

/*!40000 ALTER TABLE `alarm` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table attach
# ------------------------------------------------------------

DROP TABLE IF EXISTS `attach`;

CREATE TABLE `attach` (
                          `atta_no` int(11) NOT NULL AUTO_INCREMENT,
                          `post_no` int(11) NOT NULL COMMENT '게시글 번호',
                          `atta_sysname` text COMMENT '첨부파일 저장 이름',
                          `atta_realname` text COMMENT '첨부파일 실제 저장 이름',
                          `atta_size` int(11) DEFAULT NULL COMMENT '첨부파일 사이즈',
                          `atta_type` int(11) DEFAULT NULL COMMENT '파일 유형(1: 이미지, 2: 동영상)',
                          PRIMARY KEY (`atta_no`),
                          KEY `post_no` (`post_no`),
                          CONSTRAINT `FK_attach_TO_post` FOREIGN KEY (`post_no`) REFERENCES `post` (`post_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='첨부파일';

LOCK TABLES `attach` WRITE;
/*!40000 ALTER TABLE `attach` DISABLE KEYS */;

INSERT INTO `attach` (`atta_no`, `post_no`, `atta_sysname`, `atta_realname`, `atta_size`, `atta_type`)
VALUES
    (20,92,'202201853635569.jpg','IMG_8430.jpg',237851,1),
    (21,95,'20220186212322.jpg','3.jpg',194348,1),
    (22,95,'20220186212326.jpg','4.jpg',194042,1),
    (29,95,'20220186212350.jpg','11.jpg',212071,1),
    (31,94,'20220186352677.jpg','11.jpg',86825,1),
    (32,94,'20220186352680.jpg','22.jpg',82395,1),
    (33,94,'20220186352686.jpg','33.jpg',85791,1),
    (34,102,'202201864917382.jpg','22.jpg',82395,1),
    (35,102,'202201864917386.jpg','55.jpg',282385,1),
    (48,112,'202201962749890.png','KakaoTalk_20220119_101913989.png',395811,1),
    (49,112,'202201962749895.png','KakaoTalk_20220119_101924323.png',521834,1),
    (50,112,'202201962749899.png','KakaoTalk_20220119_101933178.png',2807097,1);

/*!40000 ALTER TABLE `attach` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table board
# ------------------------------------------------------------

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
                         `bo_no` int(11) NOT NULL AUTO_INCREMENT,
                         `bo_group_no` int(11) NOT NULL COMMENT '게시판 그룹 번호',
                         `bo_name` varchar(255) NOT NULL COMMENT '게시판 이름',
                         `bo_type` enum('basic','review') NOT NULL DEFAULT 'basic' COMMENT '게시판 유형',
                         `bo_use_photo` tinyint(1) DEFAULT '0' COMMENT '사진 첨부 여부(0:N, 1:Y)',
                         `bo_use_video` tinyint(1) DEFAULT '0' COMMENT '영상 첨부 여부(0:N, 1:Y)',
                         `bo_use_fupdown` tinyint(1) DEFAULT '0' COMMENT '파일 업로드 및 다운로드 여부(0:N, 1:Y)',
                         `bo_use_comment` tinyint(1) DEFAULT '0' COMMENT '댓글 사용 여부(0:N, 1:Y)',
                         `bo_datetime` datetime DEFAULT NULL COMMENT '게시판 생성 일시',
                         `bo_post` int(11) NOT NULL DEFAULT '0' COMMENT '게시글 갯수',
                         `bo_grade` int(4) NOT NULL DEFAULT '1' COMMENT '게시판 접근 등급',
                         PRIMARY KEY (`bo_no`),
                         KEY `FK_board_group_TO_board` (`bo_group_no`),
                         CONSTRAINT `FK_board_group_TO_board` FOREIGN KEY (`bo_group_no`) REFERENCES `board_group` (`bo_group_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판';

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;

INSERT INTO `board` (`bo_no`, `bo_group_no`, `bo_name`, `bo_type`, `bo_use_photo`, `bo_use_video`, `bo_use_fupdown`, `bo_use_comment`, `bo_datetime`, `bo_post`, `bo_grade`)
VALUES
    (32,2,'호텔 리뷰','review',1,1,NULL,1,'2022-01-18 14:03:13',12,0),
    (33,1,'바닷가 근처 숙소 리뷰','review',1,1,NULL,1,'2022-01-18 14:04:09',1,2),
    (34,1,'에디터의 고급 리뷰','review',1,1,NULL,1,'2022-01-18 14:05:31',0,3),
    (42,2,'숲속 산장 리뷰','review',1,1,1,1,'2022-01-18 17:49:56',0,2),
    (43,1,'자유게시판','basic',0,0,NULL,0,'2022-01-18 17:52:53',1,1),
    (44,2,'숲속 산장','basic',1,1,NULL,1,'2022-01-19 11:29:08',0,1);

/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

DELIMITER ;;
/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" */;;
/*!50003 TRIGGER `board_insert_trigger` AFTER INSERT ON `board` FOR EACH ROW BEGIN

		if
			NEW.bo_grade >= 1
			then
				INSERT INTO role_resources (resource_name, role_name)
				VALUE (CONCAT('/board/',NEW.bo_no,'/**'), CONCAT('ROLE_GRADE',NEW.bo_grade));

				INSERT INTO resources (resource_name, resource_type)
				VALUE (CONCAT('/board/',NEW.bo_no,'/**'), 'url');
		END if;

END */;;
/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" */;;
/*!50003 TRIGGER `board_update_trigger` BEFORE UPDATE ON `board` FOR EACH ROW BEGIN

		if
			OLD.bo_grade != NEW.bo_grade
			then
		if
			NEW.bo_grade = 0
			then
				DELETE FROM role_resources WHERE resource_name = CONCAT('/board/', NEW.bo_no,'/**');
				DELETE FROM resources WHERE resource_name = CONCAT('/board/', NEW.bo_no,'/**');
		ELSEIF
			NEW.bo_grade != 0 AND
			(SELECT IFNULL(MAX(resource_name), NULL) FROM role_resources
			WHERE resource_name = CONCAT('/board/', NEW.bo_no,'/**')) <=> NULL
			then
				INSERT INTO role_resources (resource_name, role_name)
				VALUE (CONCAT('/board/',NEW.bo_no,'/**'), CONCAT('ROLE_GRADE',NEW.bo_grade));

				INSERT INTO resources (resource_name, resource_type)
				VALUE (CONCAT('/board/',NEW.bo_no,'/**'), 'url');
		ELSE
			UPDATE role_resources SET role_name = CONCAT('ROLE_GRADE', NEW.bo_grade)
			WHERE resource_name = CONCAT('/board/', NEW.bo_no, '/**');
		END if;
		END if;

END */;;
/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" */;;
/*!50003 TRIGGER `board_delete_trigger` AFTER DELETE ON `board` FOR EACH ROW BEGIN

		if
			OLD.bo_grade >= 1
			then
				DELETE FROM role_resources
				WHERE resource_name = CONCAT('/board/',old.bo_no,'/**');

				DELETE FROM resources
				WHERE resource_name = CONCAT('/board/',old.bo_no,'/**');
		END if;

END */;;
DELIMITER ;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE */;


# Dump of table board_group
# ------------------------------------------------------------

DROP TABLE IF EXISTS `board_group`;

CREATE TABLE `board_group` (
  `bo_group_no` int(11) NOT NULL AUTO_INCREMENT,
  `bo_group_name` varchar(255) DEFAULT NULL COMMENT '게시판 그룹 이름',
  PRIMARY KEY (`bo_group_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판 그룹';

LOCK TABLES `board_group` WRITE;
/*!40000 ALTER TABLE `board_group` DISABLE KEYS */;

INSERT INTO `board_group` (`bo_group_no`, `bo_group_name`)
VALUES
	(1,'숙소 톡톡'),
	(2,'숙소 리뷰');

/*!40000 ALTER TABLE `board_group` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table comment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `co_no` int(11) NOT NULL AUTO_INCREMENT,
  `post_no` int(11) NOT NULL COMMENT '게시글 번호',
  `co_mb_no` int(11) NOT NULL COMMENT '작성자 회원번호',
  `co_content` text COMMENT '내용',
  `co_class` int(11) NOT NULL DEFAULT '0' COMMENT '댓글 계층',
  `co_order` int(11) NOT NULL DEFAULT '0' COMMENT '댓글과 대댓글 순서',
  `co_p_no` int(11) NOT NULL DEFAULT '0' COMMENT '댓글 그룹',
  `co_p_mb_no` int(11) NOT NULL DEFAULT '0' COMMENT '대댓글 회원pk',
  `co_isblind` tinyint(1) NOT NULL DEFAULT '0' COMMENT '블라인드 여부(0:N, 1:Y)',
  `co_datetime` datetime DEFAULT NULL COMMENT '댓글 작성일',
  PRIMARY KEY (`co_no`),
  KEY `FK_member_TO_comment` (`co_mb_no`),
  CONSTRAINT `FK_member_TO_comment` FOREIGN KEY (`co_mb_no`) REFERENCES `member` (`mb_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='댓글';

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;

INSERT INTO `comment` (`co_no`, `post_no`, `co_mb_no`, `co_content`, `co_class`, `co_order`, `co_p_no`, `co_p_mb_no`, `co_isblind`, `co_datetime`)
VALUES
	(1,92,12,'와 백숙,, 저도 생각만해도 침이 고이네요ㅠㅠ',0,0,1,0,0,'2022-01-18 14:42:32'),
	(2,93,1,'분위기고급짐이 장난아니네요',0,0,2,0,0,'2022-01-18 14:43:17'),
	(3,92,1,'음식 가격이 너무 비싼게 아닌가요;',0,0,3,0,0,'2022-01-18 14:43:41'),
	(4,92,3,'좋네요. 다음에 한번 가봐야겠어요',0,0,4,0,0,'2022-01-18 14:54:06'),
	(5,92,3,'그러게요 조금 쎄긴하네요',1,1,3,0,0,'2022-01-18 14:54:36'),
	(6,93,3,'엄청 좋아보이네요.',0,0,6,0,0,'2022-01-18 14:54:52'),
	(7,93,3,'리뷰만 봐도 비쌀 것 같은?',1,1,2,0,0,'2022-01-18 14:55:06'),
	(8,94,3,'바다는 원없이 보셨겠네요 ㅎㅎ 부럽습니다',0,0,8,0,0,'2022-01-18 14:55:25'),
	(9,96,4,'방이 굉장히 아득해 보여요~',0,0,9,0,0,'2022-01-18 15:11:44'),
	(10,97,4,'자판기들이 신기한게 많네요',0,0,10,0,0,'2022-01-18 15:49:54'),
	(11,95,4,'뭔가 독특한 숙소네요',0,0,11,0,0,'2022-01-18 15:50:31'),
	(12,92,4,'비싸도 맛있으면 장땡이죠',1,2,3,3,0,'2022-01-18 15:51:09'),
	(13,93,4,'생각보단 괜찮지 않을까요?',1,2,2,3,0,'2022-01-18 15:51:30'),
	(14,102,1,'슬리퍼까지 사야한다니 서비스가 좋지는 않군요...',0,0,14,0,0,'2022-01-18 15:59:22'),
	(15,102,1,'그러게 말이예요',1,1,14,0,0,'2022-01-18 15:59:31'),
	(16,96,2,'동의합니다',1,1,9,0,0,'2022-01-18 16:24:47'),
	(17,94,2,'저도 바다를 참 좋아하는데요!  이번 겨울에 한번 가봐야 겠어요',1,1,8,0,0,'2022-01-18 16:25:29'),
	(18,94,2,'솔직담백.뼈때리는 리뷰잘봤습니다.ㅎㅎ숙박은 패스하고,우동먹으러 가봐야겠네요.',0,0,18,0,0,'2022-01-18 16:28:17'),
	(19,96,1,'야자수가 상당히 이국적이네요~',0,0,19,0,0,'2022-01-18 18:04:35'),
	(20,106,1,'저도 가고 싶네용',0,0,20,0,0,'2022-01-18 20:03:34'),
	(22,94,1,'ㅇㅇ',1,2,8,2,0,'2022-01-18 20:08:44'),
	(23,94,1,'추천 합니다',1,1,21,0,0,'2022-01-18 20:09:38'),
	(24,94,1,'가고싶퍼요',1,2,21,1,0,'2022-01-18 20:09:53'),
	(26,94,2,'답글',1,1,25,0,0,'2022-01-18 20:11:08'),
	(27,105,1,'조야오ㅛ',0,0,27,0,0,'2022-01-18 20:21:04'),
	(29,108,5,'ㅎ',1,1,28,0,0,'2022-01-19 10:44:02'),
	(30,108,1,'ㅓㅜ',1,2,28,0,0,'2022-01-19 10:44:43'),
	(32,108,1,'ㅗㅗ',1,4,28,1,0,'2022-01-19 10:45:07'),
	(33,105,2,'추천해요',0,0,33,0,0,'2022-01-19 11:12:52'),
	(35,110,1,'추천합니다!!',1,1,34,0,0,'2022-01-19 12:36:42'),
	(36,110,2,'추천해요',1,2,34,1,0,'2022-01-19 12:37:08'),
	(37,108,2,'가성비짱',0,0,37,0,0,'2022-01-19 12:40:09'),
	(38,108,10,'짱이다 ! 진짜 좋아보여요',0,0,38,0,0,'2022-01-19 14:46:22'),
	(39,108,10,'그러니까요!',1,1,38,0,0,'2022-01-19 14:46:29'),
	(40,108,1,'gg',1,1,37,0,0,'2022-01-19 14:47:11'),
	(41,108,10,'나도 가고싶다 ㅠㅠ',1,2,38,0,0,'2022-01-19 14:51:23'),
	(42,111,1,'ㅈㄷㅈㄷ',0,0,42,0,0,'2022-01-19 14:51:57'),
	(43,111,1,'ㅈㄷㅈㄷ',1,1,42,0,0,'2022-01-19 14:52:08'),
	(45,112,2,'추천합니다',1,1,44,0,0,'2022-01-19 15:29:56'),
	(46,112,1,'저도 꼭 가보고 싶네요',1,2,44,2,0,'2022-01-19 15:30:13'),
	(47,111,3,'좋습니다',0,0,47,0,0,'2022-01-19 15:33:04');

/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table gradeup
# ------------------------------------------------------------

DROP TABLE IF EXISTS `gradeup`;

CREATE TABLE `gradeup` (
  `gu_no` int(11) NOT NULL AUTO_INCREMENT,
  `mb_no` int(11) NOT NULL COMMENT '회원번호',
  `gu_bef_grade` int(4) DEFAULT NULL COMMENT '신청시 회원등급',
  `gu_aft_grade` int(4) DEFAULT NULL COMMENT '신청등급',
  `gu_datetime` datetime DEFAULT NULL COMMENT '신청일시',
  `gu_state` char(1) DEFAULT '1' COMMENT '1: 대기중, 2:승인, 3:반려',
  PRIMARY KEY (`gu_no`),
  KEY `FK_member_TO_gradeup` (`mb_no`),
  CONSTRAINT `FK_member_TO_gradeup` FOREIGN KEY (`mb_no`) REFERENCES `member` (`mb_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='등업 신청';

LOCK TABLES `gradeup` WRITE;
/*!40000 ALTER TABLE `gradeup` DISABLE KEYS */;

INSERT INTO `gradeup` (`gu_no`, `mb_no`, `gu_bef_grade`, `gu_aft_grade`, `gu_datetime`, `gu_state`)
VALUES
	(7,3,2,3,'2022-01-19 11:17:39','2'),
	(8,3,2,3,'2022-01-19 12:42:22','2'),
	(9,4,2,3,'2022-01-19 15:34:50','2');

/*!40000 ALTER TABLE `gradeup` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table logrecord
# ------------------------------------------------------------

DROP TABLE IF EXISTS `logrecord`;

CREATE TABLE `logrecord` (
  `log_no` int(11) NOT NULL AUTO_INCREMENT,
  `mb_ip` varchar(255) DEFAULT NULL COMMENT '회원 아이피',
  `mb_id` varchar(255) DEFAULT NULL COMMENT '회원 아이디',
  `mb_log` datetime DEFAULT NULL COMMENT '회원 로그일자',
  PRIMARY KEY (`log_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='로그기록';



# Dump of table member
# ------------------------------------------------------------

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `mb_no` int(11) NOT NULL AUTO_INCREMENT,
  `mb_id` varchar(255) NOT NULL COMMENT '아이디',
  `mb_pwd` varchar(255) NOT NULL COMMENT '비밀번호',
  `mb_name` varchar(255) NOT NULL COMMENT '이름',
  `mb_nick` varchar(255) DEFAULT NULL COMMENT '닉네임',
  `mb_gender` enum('F','M') DEFAULT NULL COMMENT '성별',
  `mb_hp` varchar(255) DEFAULT NULL COMMENT '휴대전화번호',
  `mb_birth` date NOT NULL COMMENT '생년월일',
  `mb_datetime` datetime DEFAULT NULL COMMENT '가입 일시',
  `mb_state` char(1) NOT NULL DEFAULT '1' COMMENT '상태(1: 정상, 2: 탈퇴, 3. 강제탈퇴)',
  `mb_board` int(11) DEFAULT '0' COMMENT '작성 게시글 수',
  `mb_visit` int(11) DEFAULT '0' COMMENT '방문 횟수',
  `mb_comment` int(11) DEFAULT '0' COMMENT '작성 댓글 수',
  `mb_grade` int(11) DEFAULT '1',
  PRIMARY KEY (`mb_no`),
  KEY `FK_membergrade_TO_member` (`mb_grade`),
  CONSTRAINT `FK_membergrade_TO_member` FOREIGN KEY (`mb_grade`) REFERENCES `membergrade` (`mg_grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원';

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;

INSERT INTO `member` (`mb_no`, `mb_id`, `mb_pwd`, `mb_name`, `mb_nick`, `mb_gender`, `mb_hp`, `mb_birth`, `mb_datetime`, `mb_state`, `mb_board`, `mb_visit`, `mb_comment`, `mb_grade`)
VALUES
	(1,'airbnb1@java.com','$2a$10$e3RQMXL1RM8qEWUBoOYdSOToZ7l9b5cHriMJ8AONZaNZZjCJQO9z6','일등급','여행조야용','M','010-1313-1313','1999-01-01','2021-10-11 09:01:11','1',3,2,5,1),
	(2,'airbnb2@java.com','$2a$10$1gnJs7wt0JI7C43Jg/gDquJCbWUaXQv8a.LF1wHOLO6lfgF3UJ7ae','이등급','아뇨용','F','010-1313-1313','1999-02-02','2021-10-12 09:02:11','1',5,3,6,2),
	(3,'airbnb3@java.com','$2a$10$4x.x00ybMtslXMQc4634Ruetjxw/ufw8ePwNXNr/g3GQ4F/e0n/ba','삼등급','트레블링','M','010-2000-2000','1999-03-03','2021-10-13 09:01:11','1',5,2,5,2),
	(4,'airbnb4@java.com','$2a$10$e3RQMXL1RM8qEWUBoOYdSOToZ7l9b5cHriMJ8AONZaNZZjCJQO9z6','사등급','여미여미','F','010-1313-1313','1999-04-04','2021-10-15 09:01:11','1',10,6,10,3),
	(5,'admin@java.com','$2a$10$e3RQMXL1RM8qEWUBoOYdSOToZ7l9b5cHriMJ8AONZaNZZjCJQO9z6','최고관리자','최고관리자','M','010-1313-1313','2020-11-11','2001-10-12 09:02:11','1',8,3,3,5),
	(6,'block@java.com','$2a$10$e3RQMXL1RM8qEWUBoOYdSOToZ7l9b5cHriMJ8AONZaNZZjCJQO9z6','나탈퇴','나탈퇴','F','010-1313-1313','2002-10-22','2001-10-12 09:02:11','2',0,1,0,1),
	(7,'java1@java.com','$2a$10$wMBU0t.RGGP9BIt4jdE1tedSnHs/.H1vmVSAMAyqmLNSc2GMGwsX2','김준식','junsik2','M','010-2255-2255','2022-01-22','2022-01-10 01:29:10','2',0,1,0,1),
	(8,'java2@java.com','$2a$10$.19KPIaNUW3t8fUns66VeuKDQ9/qsfXft0lvJ8FD.6uMEg1byLUUS','홍길동1','junsik22','F','010-2000-2000','2022-01-27','2022-01-11 01:31:39','1',0,2,0,1),
	(9,'java3@java.com','$2a$10$BYcl7fFJ3VQ2cikqpQFHI.7.wObbdEzOmGEcMNtII7ZXWPXOeaWyC','나자바','junsik234','M','010-2000-2000','2019-11-20','2022-01-12 00:58:25','1',0,0,0,1),
	(10,'5126537@naver.com','$2a$10$rxkXmlne.DIb7s6QQ8zMguuQoLjOcKMou2P0CPUz6IGtXYOkKG6gO','김소진','호이짜','M','010-5264-6537','1998-04-10','2022-01-12 07:07:11','1',2,3,3,1),
	(11,'java5@java.com','$2a$10$FGZ784C152yXpZzTTffKoeeWJGwjyaF6vhOV.P4qrlbH32HAgp21C','장준혁','junsik2232','M','010-2000-2000','2022-01-26','2022-01-13 01:30:08','1',0,2,0,1),
	(12,'topyoung98@naver.com','$2a$10$QPYWfO6XrWURdMGA26aLvuYmRToTG3fVPe3b/1CF0SB5D9dgfOjry','김소진','호이','F','010-5264-6537','1998-04-10','2022-01-14 14:57:15','1',0,2,1,3),
	(13,'arc551234@gmail.com','$2a$10$KtjzSnpQaqJOarBV1n88iu7bLpj74OiS0abZbiVytKPTTvzCEHEcC','자바2','junsik222','M','010-2000-2000','2022-01-12','2022-01-16 15:52:44','1',0,1,0,3),
	(22,'arc552@naver.com','$2a$10$VQdoq64Ce8QOlvfhLw69iOsJAeEFuvEr02pvvaa/dKIRnYojgmUq2','김준식','여행조하','M','010-2900-7789','2022-01-01','2022-01-17 12:31:27','1',0,3,0,3),
	(25,'5126537@gmail.com','$2a$10$Bs9awPpVmXWSbm8lpDKHdeSbSEk8LARyhPocPkGuNL5Rs59mCETp.','김소진','호랑이','F','010-5264-6537','1998-04-11','2022-01-18 23:53:12','2',0,1,0,1);

/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

DELIMITER ;;
/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" */;;
/*!50003 TRIGGER `member_update_trigger` BEFORE UPDATE ON `member` FOR EACH ROW BEGIN

		DECLARE boardTemp INT;
		DECLARE visitTemp INT;
		DECLARE commentTemp INT;
		DECLARE gradeTemp INT;

		SET boardTemp = NEW.mb_board;
		SET visitTemp = NEW.mb_visit;
		SET commentTemp = NEW.mb_comment;
		SET gradeTemp = NEW.mb_grade;


		while gradeTemp <= 5 do
		if
			boardTemp >= (SELECT mg_board FROM membergrade WHERE mg_grade = gradeTemp)
			AND
			visitTemp >=  (SELECT mg_visit FROM membergrade WHERE mg_grade = gradeTemp)
			AND
			commentTemp >= (SELECT mg_com FROM membergrade WHERE mg_grade = gradeTemp)
			AND
			(SELECT mg_use FROM membergrade WHERE mg_grade = gradeTemp) = 1
			AND
			(SELECT mg_type FROM membergrade WHERE mg_grade = gradeTemp) = 0
			then
				set new.mb_grade = gradeTemp ;
		END if;
			set gradeTemp = gradeTemp + 1 ;
		END while;


		if
			OLD.mb_grade != NEW.mb_grade
			then
				INSERT INTO `alarm` (`al_type`, `al_read`, `al_content`, `al_datetime`, `mb_no`)
				VALUES ('3', 0, CONCAT(NEW.mb_grade, '등급으로 등업되었어요. 축하드려요! 다시 로그인하시면 등급이 적용됩니다.'), NOW(), NEW.mb_no) ;

				UPDATE member_role SET role_name = if(NEW.mb_grade = 5, 'ROLE_ADMIN', CONCAT('ROLE_GRADE',NEW.mb_grade))
				WHERE NEW.mb_id = mb_id ;
		END if;

END */;;
DELIMITER ;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE */;


# Dump of table member_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `member_role`;

CREATE TABLE `member_role` (
  `member_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `mb_id` varchar(20) DEFAULT NULL COMMENT '아이디',
  `role_name` varchar(20) DEFAULT 'ROLE_GRADE1' COMMENT '롤 이름',
  PRIMARY KEY (`member_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `member_role` WRITE;
/*!40000 ALTER TABLE `member_role` DISABLE KEYS */;

INSERT INTO `member_role` (`member_role_id`, `mb_id`, `role_name`)
VALUES
	(1,'airbnb1@java.com','ROLE_GRADE1'),
	(2,'airbnb2@java.com','ROLE_GRADE2'),
	(3,'airbnb3@java.com','ROLE_GRADE2'),
	(4,'airbnb4@java.com','ROLE_GRADE3'),
	(5,'block@java.com','ROLE_GRADE1'),
	(6,'admin@java.com','ROLE_ADMIN'),
	(7,'java1@java.com','ROLE_GRADE1'),
	(8,'java2@java.com','ROLE_GRADE1'),
	(9,'java3@java.com','ROLE_GRADE1'),
	(10,'5126537@naver.com','ROLE_GRADE1'),
	(11,'java5@java.com','ROLE_GRADE1'),
	(12,'topyoung98@naver.com','ROLE_GRADE3'),
	(13,'arc551234@gmail.com','ROLE_GRADE3'),
	(22,'arc552@naver.com','ROLE_GRADE3'),
	(25,'5126537@gmail.com','ROLE_GRADE1');

/*!40000 ALTER TABLE `member_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table membergrade
# ------------------------------------------------------------

DROP TABLE IF EXISTS `membergrade`;

CREATE TABLE `membergrade` (
  `mg_grade` int(4) NOT NULL COMMENT '등급 순위',
  `mg_name` varchar(255) DEFAULT NULL COMMENT '등급명',
  `mg_type` tinyint(1) DEFAULT NULL COMMENT '등업방식(0:자동, 1:수동)',
  `mg_board` int(11) DEFAULT NULL COMMENT '등업기준_게시물수',
  `mg_com` int(11) DEFAULT NULL COMMENT '등업기준_댓글수',
  `mg_visit` int(11) DEFAULT NULL COMMENT '등업기준_방문일수',
  `mg_use` tinyint(1) DEFAULT '0' COMMENT '등급사용여부(0:미사용, 1:사용)',
  PRIMARY KEY (`mg_grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사이트 회원 등급';

LOCK TABLES `membergrade` WRITE;
/*!40000 ALTER TABLE `membergrade` DISABLE KEYS */;

INSERT INTO `membergrade` (`mg_grade`, `mg_name`, `mg_type`, `mg_board`, `mg_com`, `mg_visit`, `mg_use`)
VALUES
	(1,'새싹멤버',0,0,0,0,1),
	(2,'일반멤버',0,5,5,2,1),
	(3,'열심멤버',1,10,10,5,1),
	(4,'우수멤버',1,50,50,25,1),
	(5,'최고관리자',1,99999,99999,99999,1);

/*!40000 ALTER TABLE `membergrade` ENABLE KEYS */;
UNLOCK TABLES;

DELIMITER ;;
/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" */;;
/*!50003 TRIGGER `membergrade_update_trigger` BEFORE UPDATE ON `membergrade` FOR EACH ROW BEGIN

	if
	NEW.mg_use = 0
		then
		DELETE FROM role_resources WHERE role_name = CONCAT('ROLE_GRADE',NEW.mg_grade);
	END if;

END */;;
DELIMITER ;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE */;


# Dump of table memberstate
# ------------------------------------------------------------

DROP TABLE IF EXISTS `memberstate`;

CREATE TABLE `memberstate` (
  `ms_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '상태 번호',
  `mb_no` int(11) NOT NULL COMMENT '회원번호',
  `ms_reason` text COMMENT '사유',
  `ms_datetime` datetime DEFAULT NULL COMMENT '탈퇴일자',
  PRIMARY KEY (`ms_no`),
  KEY `FK_member_TO_memberstate` (`mb_no`),
  CONSTRAINT `FK_member_TO_memberstate` FOREIGN KEY (`mb_no`) REFERENCES `member` (`mb_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원 탈퇴 정보';

LOCK TABLES `memberstate` WRITE;
/*!40000 ALTER TABLE `memberstate` DISABLE KEYS */;

INSERT INTO `memberstate` (`ms_no`, `mb_no`, `ms_reason`, `ms_datetime`)
VALUES
	(1,10,'의도가 불순해!','2022-01-13 18:25:53'),
	(2,9,'강제 탈퇴 사유','2022-01-16 13:44:56'),
	(3,8,'강제 탈퇴 사유','2022-01-16 13:44:56'),
	(4,7,'강제 탈퇴 사유','2022-01-16 15:11:41'),
	(17,25,'불순한 의도','2022-01-19 00:16:54'),
	(18,22,'불순한 의도','2022-01-19 00:16:54');

/*!40000 ALTER TABLE `memberstate` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table note
# ------------------------------------------------------------

DROP TABLE IF EXISTS `note`;

CREATE TABLE `note` (
  `note_no` int(11) NOT NULL AUTO_INCREMENT,
  `note_con` text COMMENT '쪽지 내용',
  PRIMARY KEY (`note_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='쪽지 내용';

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;

INSERT INTO `note` (`note_no`, `note_con`)
VALUES
	(1,'123'),
	(2,'asdf'),
	(3,'324232fdsf'),
	(4,'123'),
	(5,'wqfdsf'),
	(6,'132131'),
	(7,'asdfrafewaf'),
	(8,'zsgzfgzgz'),
	(9,'wzexsrcdo'),
	(10,'VVdzvdzv'),
	(11,'ㅁㅎㅁㄱㄻㄷㅁㄹㄷ'),
	(12,'zxyuimrwz'),
	(13,'12321'),
	(14,'qwerthuijwznhultryiuopasdjklxcvbnmetrewqwd'),
	(15,'asdfasdf');

/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table noteindex
# ------------------------------------------------------------

DROP TABLE IF EXISTS `noteindex`;

CREATE TABLE `noteindex` (
  `note_no` int(11) NOT NULL COMMENT '쪽지 번호',
  `note_get_mb_no` int(11) NOT NULL COMMENT '수신회원번호',
  `note_send_mb_no` int(11) NOT NULL COMMENT '발신회원번호',
  `note_getmb_del_state` tinyint(1) DEFAULT '0' COMMENT '수신한 회원 삭제여부(0:무, 1:유)',
  `note_getmb_save_state` tinyint(1) DEFAULT '0' COMMENT '수신한 회원 보관함 저장 상태(0:미사용, 1:사용)',
  `note_getmb_read_state` tinyint(1) DEFAULT '0' COMMENT '수신한 회원 읽음여부(0:무, 1:유)',
  `note_sendmb_del_state` tinyint(1) DEFAULT '0' COMMENT '발송한 회원 삭제여부(0:무, 1:유)',
  `note_sendmb_save_state` tinyint(1) DEFAULT '0' COMMENT '발송한 회원 보관함 저장 상태(0:미사용, 1:사용)',
  `note_datetime` datetime DEFAULT NULL COMMENT '발송날짜',
  `note_identify_send_get_state` tinyint(1) DEFAULT '0' COMMENT '수발신구분코드(0: 발신, 1:수신)',
  PRIMARY KEY (`note_no`,`note_get_mb_no`,`note_send_mb_no`),
  KEY `FK_member_TO_noteindex` (`note_send_mb_no`),
  KEY `FK_member_TO_noteindex2` (`note_get_mb_no`),
  CONSTRAINT `FK_member_TO_noteindex` FOREIGN KEY (`note_send_mb_no`) REFERENCES `member` (`mb_no`),
  CONSTRAINT `FK_member_TO_noteindex2` FOREIGN KEY (`note_get_mb_no`) REFERENCES `member` (`mb_no`),
  CONSTRAINT `FK_note_TO_noteindex` FOREIGN KEY (`note_no`) REFERENCES `note` (`note_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='쪽지 송수진정보';

LOCK TABLES `noteindex` WRITE;
/*!40000 ALTER TABLE `noteindex` DISABLE KEYS */;

INSERT INTO `noteindex` (`note_no`, `note_get_mb_no`, `note_send_mb_no`, `note_getmb_del_state`, `note_getmb_save_state`, `note_getmb_read_state`, `note_sendmb_del_state`, `note_sendmb_save_state`, `note_datetime`, `note_identify_send_get_state`)
VALUES
	(1,1,5,0,0,0,0,0,'2022-01-16 15:01:56',0),
	(2,5,5,1,0,0,1,0,'2022-01-16 15:05:32',0),
	(3,1,5,0,0,0,1,1,'2022-01-16 16:26:45',0),
	(3,2,5,0,0,0,1,1,'2022-01-16 16:26:45',0),
	(4,5,5,1,1,0,0,0,'2022-01-17 10:05:45',0),
	(5,5,5,1,1,0,1,0,'2022-01-17 12:40:45',0),
	(6,1,5,0,0,0,1,0,'2022-01-17 12:50:37',0),
	(7,1,5,0,0,0,1,0,'2022-01-17 17:37:09',0),
	(7,2,5,0,0,0,1,0,'2022-01-17 17:37:09',0),
	(8,1,5,0,0,0,0,1,'2022-01-17 17:38:35',0),
	(8,2,5,0,0,0,0,1,'2022-01-17 17:38:35',0),
	(9,1,5,0,0,0,0,1,'2022-01-17 17:48:15',0),
	(9,2,5,0,0,0,0,1,'2022-01-17 17:48:15',0),
	(10,1,5,0,0,0,1,0,'2022-01-17 18:50:52',0),
	(10,2,5,0,0,0,1,0,'2022-01-17 18:50:52',0),
	(11,1,5,0,0,0,0,1,'2022-01-17 19:00:48',0),
	(11,2,5,0,0,0,0,1,'2022-01-17 19:00:48',0),
	(12,5,1,0,1,0,0,0,'2022-01-17 19:07:43',0),
	(13,5,5,1,0,0,1,0,'2022-01-17 22:42:31',0),
	(14,1,5,0,0,0,1,0,'2022-01-18 09:57:14',0),
	(15,1,5,0,0,0,1,0,'2022-01-21 15:24:05',0);

/*!40000 ALTER TABLE `noteindex` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table post
# ------------------------------------------------------------

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `post_no` int(11) NOT NULL AUTO_INCREMENT,
  `bo_no` int(11) NOT NULL COMMENT '게시판 번호',
  `po_subject` text COMMENT '게시글 제목',
  `po_content` text COMMENT '게시글 내용',
  `po_mb_no` int(11) NOT NULL COMMENT '회원번호',
  `po_tag` text COMMENT '태그',
  `po_views` int(11) DEFAULT NULL COMMENT '조회수',
  `po_comment` int(11) DEFAULT NULL COMMENT '댓글수',
  `po_datetime` datetime DEFAULT NULL COMMENT '게시글 작성일',
  `po_isblind` tinyint(1) DEFAULT '0' COMMENT '블라인드 여부(0:N, 1:Y)',
  PRIMARY KEY (`post_no`),
  KEY `FK_board_TO_post` (`bo_no`),
  KEY `FK_member_TO_post` (`po_mb_no`),
  CONSTRAINT `FK_board_TO_post` FOREIGN KEY (`bo_no`) REFERENCES `board` (`bo_no`),
  CONSTRAINT `FK_member_TO_post` FOREIGN KEY (`po_mb_no`) REFERENCES `member` (`mb_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시글';

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;

INSERT INTO `post` (`post_no`, `bo_no`, `po_subject`, `po_content`, `po_mb_no`, `po_tag`, `po_views`, `po_comment`, `po_datetime`, `po_isblind`)
VALUES
	(92,32,'겨울 여행, 숲속 산장 느낌의 충주 제천ES리조트 패밀리룸 이용후기','<p>가족나들이로 딱 좋은 양주에 있는 숲속산장에 다녀왔다!</p><p>일요일 오후 한시쯤 도착했고 계곡 바로 옆 옆 테이블에 자리를 잡았다</p><p>일찍 올수록 바로 옆 자리 잡을수 있고</p><p>&nbsp;</p><p>사람들이 오후 3시정도 되니 빠져서 그때 와도 될듯했다 :)</p><p>가족나들이로 딱 좋은 양주에 있는 숲속산장에 다녀왔다!</p><p>일요일 오후 한시쯤 도착했고 계곡 바로 옆 옆 테이블에 자리를 잡았다</p><p>일찍 올수록 바로 옆 자리 잡을수 있고</p><p>사람들이 오후 3시정도 되니 빠져서 그때 와도 될듯했다 :)</p><p><img alt=\"\" src=\"https://postfiles.pstatic.net/MjAyMTA2MTVfNjUg/MDAxNjIzNzU0NDE1Mjg5.zQd9ilrRSk8RreCKxaeO6MUGLHsFO2o56qw2OKZRqdwg.iNimG7YYhT6hPrFFULGhc5cg3lkz7PxaMJv8yz8J44gg.JPEG.peakapoo/IMG_8430.jpg?type=w966\" /></p><p>주차는 아주 널널 함 !</p><p>&nbsp;</p><p>계곡을 중심으로 양쪽으로 자리가 있다.</p><p>&nbsp;</p><p>계곡 바로 옆+ 그늘막+나무 그늘 덕분에 아주 시원했다</p><p>(엄청 더웠던 날 31도 찍은날 ㅠ.ㅠ )</p><p>&nbsp;</p><p>계곡물 엄청 찼다</p><p>너무 차가와서 1분이상 못있겠는데</p><p>어린 아이들은 춥지도 않은지 너무 재밌게 노는게</p><p>신기할정도였다 ㅋㅋ</p><p>올챙이도 많고 물고기도 많음 !</p><p>&nbsp;</p><p>깊이는 깊은곳은 어른 허벅지 정도 까지 오는듯하고</p><p>얕은부분도 깊은 부분도 있어서 좋았다</p><p>&nbsp;</p><p>우리도 오빠 친구 가족이랑 갔는데</p><p>9살 하나 6살 하나 아이들이</p><p>물고기랑 올챙이 잡는데 정신팔려서</p><p>나도 거기에 홀려서</p><p>올챙이 열마리는 잡은듯 ...</p><p>&nbsp;</p><p>메뉴는</p><p>도토리묵무침 +닭백숙</p><p>도토리묵무침+오리백숙</p><p>&nbsp;</p><p>이런식으로 85000이였다</p><p>우리는 도토리묵 무침 +닭백숙에</p><p>파전( 2만원) +동동주 시킴 !</p><p>&nbsp;</p><p>밑반찬 잘 나온다</p>',10,'산장,민박',7,5,'2022-01-18 14:36:35',0),
	(93,33,'제주공항 근처 숙소, 호텔레오 vs 제주 엠버호텔 후기 (조식 굿 b)','<p>비행기를 타고 다녀온 제주도! 도착 직후 제주공항 근처 호텔에서 하루 머무르게 되었는데요. 최근에&nbsp;<strong>호텔 레오</strong>와&nbsp;<strong>엠버 호텔</strong><strong>&nbsp;</strong>두 곳이 후기 좋기로 유명해서 고르느라 꽤 애먹었지만, 결과적으로 저는 제주 엠버호텔에서 1박 하게 되었습니다. 아마도 많은 분들이 같은 고민을 하느라 아직 숙소 예약을 못하셨을 텐데...?<br /><br />그런 분들을 위해 직접 다녀온 제주 엠버호텔 후기와 함께 호텔레오의 장단점까지 비교해 봤어요. 잘 고른 숙소로 즐겁고 편리한 여행 만들어 봐요! 고고~</p><p>&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"818\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfNzQg/MDAxNjM3OTA4NDA5Mjg4.VCn6lToPy9skS3IYyKO7KDyO94kKCRknp9RtQdzBV2sg.oFm6SmuIbO_LkD2NFr94pSMRWEEBPwZLcvIxlcekeMwg.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_12.JPG?type=w1200\" /></a></p><p>ﻬﻬﻬﻬﻬ<br />호텔 레오</p><p>제주공항에서 6분 거리, 공항에서 픽업도 진행하고 있어 뚜벅이 여행객들에게도 인기 있는 호텔 레오! 시내에 위치하다 보니 기계식 주차장에 주차는 조금 불편하다는 후기가 있는데요. 발렛주차 서비스를 제공하니 크게 걱정하지 않아도 됩니다. 호텔 근처에는 식당들이 즐비해 식사를 해결하기도 좋다고 해요.<br />&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"840\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfMjU1/MDAxNjM3OTA4NDI5NjI0.LPLe1kDLkE67vtcdVT0DqGg_oRn480Gs-ZFZ8bXI-DAg.O_KCEJXMK42bszzpdEf50vi8fcIMQhx3feCmsC8OZDgg.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_10.jpg?type=w1200\" /></a></p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfMjUy/MDAxNjM3OTA4NDE2Njc0.sMIkTszpkbrDrqg_H4qQPT18aAUd03j2CL3Ef7gNT7cg.VIsChLccUpM4QWfQiHjexfnUrrF7iOZYwGveHuYh3YUg.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_8.JPG?type=w1200\" /></a></p><p>&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfMTUw/MDAxNjM3OTA4NDIwNzc0.MsxR5E8ErsEYiQp8Ir2sYTFWcoyCqmoKcQ0Jb8Mn_4Yg.paXguWYbwTeeHYCV8DzHL-5AoqZia6bAGdR0HNi1k7og.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_11.JPG?type=w1200\" /></a></p><p>호텔레오</p><p>제주특별자치도 제주시 삼무로 14 HOTEL LEO</p><p><a target=\"_blank\" href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#end\">지도보기</a></p><p>호텔에는 루프탑 바가 있어 바깥 풍경을 감상하며 맥주 한 잔 즐기면 그렇게 힐링 된다고! 청결한 객실에는 스타일러가 있어 여행 중 입을 예정이거나 입었던 옷들을 관리하기 좋아요. 무엇보다 직원분들이 무척 친절하셔서 1박에 10만 원도 안 되는 가성비에 5성급 서비스를 누렸다는 후기가 많아요!<br />&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"817\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfMjUz/MDAxNjM3OTA4NDQ1ODM3.jiCtVRDgBVyZYVBE1ZETKOaXCmzW5HkiL_k0wtP4jjgg.fi3atfzhjnwfPsZ0V9GAMDGtVr3783d10rFbqeH1VLUg.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_4.JPG?type=w1200\" /></a></p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfMTM2/MDAxNjM3OTA4NDYxNzk5.Py3m-i3YTo5k7x9b6OXOztXE81KURIzLPx8v9YH2Mlwg.xBpWMtlmsE7SNVvzm-hYyTqi8zNvF8l0azwbXTEWaPcg.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_6.JPG?type=w1200\" /></a></p><p>&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfNDQg/MDAxNjM3OTA4NDUwMDc1.9VmNaFEwF217NdgTSd0jp9G6uMXn75nwsxYaOUZVYFMg.hswncMz6e2y0Gl-sSSFvYAVynUs7FvwvM-5MONyTOZwg.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_5.JPG?type=w1200\" /></a></p><p><br /><strong>호텔 레오</strong>의&nbsp;<strong>실제 이용후기</strong>도 살펴보세요!<br /><br />&quot;5박6일&nbsp;일정으로 여행을 갔는데 마지막 숙박을 공항 근처로 잡으려고 알아보다 조식과 룸컨디션도 좋고 공항과 6분거리라 선택하게 되었어요 조식이 가지수는 많지않아도 맛은 최고 였어요 서귀포 숙소보다 더 맛있었던것같아요 룸컨디션도 좋았구요^^ 담에 제주도 여행을 간다면 또 레오로&nbsp;잡을께요^^&quot;<br /><br />&quot;가족여행 마지막 숙소인 호텔 레오 온돌방인데 침구도 너무 깨끗하고 편해 아이들과 숙면을 취할수 있었고 화장실도 깨끗하고 사용하지는 않았지만 칫솔도 준비되어 있어 여행객에게 아주 딱인 호텔이었습니다. USB 충전 가능하게 3곳에 마련하여 여러명이 편하게 충전도 가능하고 의류관리기도 있어 너무 편하고 즐겁게 지내고 왔어요~ 발렛주차도 가능하고 여러번 요청했는데도 친절하게 대해주셔서 다음에도 또 이용하고 싶은&nbsp;호텔 이었습니다.&quot;<br /><br />&quot;아기랑 방문한 호텔인데 일단 각 방마다 스타일러가 있어서 너무 편리했습니다. 물놀이 하고 젖은 옷은 손빨래해서 스타일러로 건조하니 찝찝함 1도 없었구요, 전 거실있는 룸이어서 저녁에 뭐 사다먹기도 편리했어요. 아기 재우고 티비보기도 좋아서 넷플 봤습니다 ㅎㅎ 근처에 먹자골목 있어서 좋았고, 뷰도 멀리보면 바다도 살짝 보였네요. 무엇보다 무료 발렛도 해줏거 직원분들이 너무 친절하셔서 여행내내 기분 좋았어요^^ 다음에 제주도 가면 또 이용하고 싶은 호텔이에요!&quot;</p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"840\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfMTA4/MDAxNjM3OTA4NDg3NDk1.P96Rml1lJzLKFEDWm7_1TYjS98akoXtcJnfLwXgt90cg.o8XHdOGN4mMm-68D8f8c_VGbdfe34enlPeSIdKmWK6wg.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_7.jpg?type=w1200\" /></a></p><p><a href=\"https://post.naver.com/viewer/postView.naver?volumeNo=32833126&amp;memberNo=45408110&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"840\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMTExMjZfMTQz/MDAxNjM3OTA4NDkxMTg4.FVFx_fAD6CWi5dVHLY4wQZ8ZKpjjsNmcAj7tvjkS544g.50z7WRuE04BRqEaaJqIzNr7q3ByyLROT4Bb_fSjiRRkg.JPEG/%EC%A0%9C%EC%A3%BC%ED%98%B8%ED%85%94%EB%A0%88%EC%98%A4_3.jpg?type=w1200\" /></a></p>',10,'',7,4,'2022-01-18 14:40:10',0),
	(94,32,'삼척 솔비치 뷰 맛집 호텔이네요!','<figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"773\" src=\"blob:http://54.180.150.136/d8d73d2d-4d98-44d5-b3b2-f9516d8a7af2\" /><figcaption></figcaption></figure><p>정말 얼마나 멋진지. 아이들이 깔깔 웃고 떠드는 모습만 봐도 힐링이고 다 힐링이었어요~ 다시 가고 싶네요 정말. 다시 돌아오니, 어른에겐 익숙한 집이 가장 편하긴 하지만. 아이들에겐 새로운 공간에서 새로운 경험들을 자주 선물해주면 마음도 몸도 더 쑥쑥 자랄 것 같다는 생각이 드네요.</p><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"773\" src=\"blob:http://54.180.150.136/00110338-931a-4d57-9555-5f93e3f5828b\" /><figcaption></figcaption></figure><p>화장실은 변기가 샤워 부스와 분리되어 있어서 편리하고 위생적으로도 더 좋았던 것 같아요.</p><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"773\" src=\"blob:http://54.180.150.136/1ebc1ac2-aa62-4454-b1b9-21404aaf0320\" /><figcaption></figcaption></figure><p>비치된 용품도 포장되어 있어 느낌적으로 위생적이다 생각되서 좋고 믿고 쓸 수 있었던 것 같아요.</p><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"773\" src=\"blob:http://54.180.150.136/e16cb497-352d-42bb-96b7-9ba2955b5721\" /><figcaption>여긴 거실. 오션뷰가 정말 최고입니다.<br />다음날 여기에서 일출도 실내에서 춥지 않게 편하게 보았어요.</figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"773\" src=\"blob:http://54.180.150.136/71331830-ae28-4667-8599-dfec1f30f9de\" /><figcaption><br />미니바도 있는데 미니바는 가격이..조금 후덜덜해서 이용 안했네요.</figcaption></figure><p>시원한 오션뷰라 눈호강은 더할나위 없이 제대로 하고 온 것 같아요.</p><p>다만 겨울바다 주변이다보니 난방을해도 좀 춥더라구요.</p>',1,'삼척,스위트오션뷰,바다뷰,일출,가족,힐링,여행,호캉스',9,7,'2022-01-18 14:42:24',0),
	(95,34,'제주 포도호텔 솔직담백 리뷰','<figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/9c416ef5-eca3-4658-87c6-a4b58bcacdf8\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/18cceb16-fdd6-407d-bc6b-f3ccd8fd1009\" /><figcaption></figcaption></figure><p>&nbsp;</p><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/31aed60e-8944-4adb-818d-22cd2fc419ba\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/a8cff521-ab4b-4d22-a1f3-ba65f801a550\" /><figcaption></figcaption></figure><p>몇년 전에도 포도호텔에 대해서 궁금해서 찾아봤던 적이 있었는데, 1박에 가격이 70만원대라는 이야기를 듣고 뒤로가기 버튼을</p><p>조용히 눌렀었다. ㅋㅋ 신혼여행이니까! 하는 마음으로 포도호텔 예약을 하려고 결심했을 때는 코로나가 아주 기승을 부리던 때로..</p><p>객실이 몇개 없는데도 불구하고 코로나로 인해 더욱 축소운영을 하던 포도호텔에 대기를 걸어놓았다.</p><p>우리가 신행을 떠나는 11월 중순이 다행히 <strong>위드로 전환된 시점</strong>이어서 포도호텔에서 1박을 할 수 있었다. 객실은 한실과 양실이 있는데,</p><p>한실이 인기가 더 많아서 <strong>양실에서 숙박할 수 밖에 없었다</strong>.</p><p>​</p><p>내가 느낀 <strong>포도호텔(양실)의 장점</strong>은 그닥 많이 있다고는 볼 수 없고, 아래 정도..?</p><p>1. 객실별 정원 뷰(노을, 별이 보이는 1층 객실)</p><p>2. 객실별 온천수(한실은 히노끼탕에 온천수)</p><p>3. 이타미 준의 철학이 담긴 건축물</p><p>4. 우동맛집</p><p>5. 맥주포함 미니바 무료</p><p>​</p><p>이외에 <strong>단점은</strong></p><p>1. 부대시설 없음(카페,헬스장, 프로그램, 수영장/사우나-디아넥스에서 유료 이용, 편의점)</p><p>2. 근처 맛집 없음(외진곳에 위치)</p><p>3. 조식이 명성에 비해 별로 맛이 없음</p><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/ceffebdf-b431-4cf1-ab49-671973933810\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/31303413-9870-4c4b-8d2a-16f4e1249f22\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/6653beb5-ec4d-43d5-9ea6-30cd65eb63f6\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/8602b384-f5f7-4edf-ac33-38820614fb4c\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/820cb390-91a3-42c8-82af-6f9284faa451\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/b9196b3d-a305-4e69-a98e-4bbd379d5a76\" /><figcaption>마지막 숙소여서 무거운 캐리어를 이끌고 도착해서 보니 다양한 주전부리들이 있었고,<br />초콜렛이나 감귤파이나 맛있어서 바로 뜯어서 해치웠다.<br />직원분의 손편지로 시작하는 첫날..<br />&nbsp;</figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/ca08f268-8505-4630-af3d-7abfc1304386\" /><figcaption>숙소는 아주 연식이 오래된 곳 같은 느낌이 들었다.<br />​<br />&nbsp;</figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/24a76a50-7400-492b-830f-69504294d0c6\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/07ed187b-acdc-41e9-b7fb-1840eeda5637\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/6ffb8f52-9e73-4569-91b1-de7d107bbd81\" /><figcaption>​<br />저녁때 목욕하고, 테라스 의자에 앉아서 먹는 맥주맛과 온천수에 몸담그고 마시는 감귤 주스맛은 최고셨다. 호텔 내에 따로 편의점이 없으니까 맥주 한캔 무료로 주니까 좋았다.<br />​<br />황금향인가.. 차게 미리 넣어준 황금향도 맛있어서 잘 먹었다.<br />​<figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/f5b09043-03dc-4b54-95b4-ea97d3049f82\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/f271da96-5d15-4c2c-b46f-be15631ea0c1\" /><figcaption></figcaption></figure><br />머그컵이랑 와인잔이 소독하는 곳에 들어가 있어서 뭔가 안심이 되었다. 세상에 이런일이 같은데 보면<br />고발하는 내용으로 비위생적으로 컵들까지 닦는 것도 봐서 맨날 의심스러운데,<br />이렇게 소독하는 곳에 들어가 있으니 조금 더는 느낌?<br />&nbsp;</figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/3e964244-a5ac-4afb-94ae-1a551b515835\" /><figcaption>욕실은 샤워부스 따로, 욕조 따로 있는데 욕조에서 나오는 물이 온천수여서 허연색 물이 쏟아지고 물을 안써서 내보내면 바닥에 흰색 온천수의 잔여물질이 남는다. 물을 수건으로 벅벅 닦지않고 흡수시키면 더 온천수의 효능을 느낄 수 있다는데 온천수는 신기했으나 효능까지는 잘....<br />&nbsp;</figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/06b20d66-6d1e-45c7-ae66-073e18a36323\" /><figcaption>어매너티는 불가리를 주는데, 불가리 냄새 완전 남자 냄새나서 이솝으로 바꿔달라고 하고,<br />이솝 어매너티를 사용했다. 꼭 한 종류만 있지 않으므로 냄새를 맡아보고 별로면<br />어매너티도 바꿀 수 있다는 점은 장점일지도.<figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/48a899b6-94d9-424b-a1ba-e5dbffed8db9\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/aa97d385-c71e-4806-a3f2-0618fa8ce38f\" /><figcaption></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/2cbabaf5-756f-4930-b53a-979308a92842\" /><figcaption></figcaption></figure></figcaption></figure><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"900\" src=\"blob:http://54.180.150.136/aa2a1148-34b5-43a3-92fb-4942001e2b24\" /><figcaption>지배인님과 함께한 투어는 몰랐던 건물에 스토리를 불어넣어 정말 유익했고,<br />이런 작품에 머문다는 느낌이 들어서 노후화 되어 보였던 객실에 중후함을 느끼게 해줬다.<br />열리고, 닫히고 하는 주제가 있는 호텔 투어는 다른 호텔들과는 차이점이 느껴지는 부분이었다.<br /><br />평생을 한국인과 일본인 사이의 정체성에서 예술작품을 펼쳐온 이타미 준의 건축물이<br />일본과 한국의 문을 표현해 놓은 방식을 건물에 표현한 것을 마지막으로 Q&amp;A 시간도 갖고 마무리했다.<br />설명도 재밌었고 안들었으면 너무 아쉬울뻔했다!<br />곳곳에 있는 요소들이 매우 흥미로웠던 공간이었다.<br />&nbsp;</figcaption></figure><p>&nbsp;</p>',1,'제주,포도호텔,힐링,휴식,안락함,신년,2022년',9,1,'2022-01-18 14:51:00',0),
	(96,32,'제주도 호텔,럭셔리 끝판왕 제주 신라호텔','<p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1280\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAxODExMzBfMTY0/MDAxNTQzNTY5NzIyMjIx.JsfiCruSyVE1MTBeAvxHtRzOHnJ2MkMVKwBS6RmpkiIg.zvMG2t3U2U2sGk424AXijCXoxnSrrSvmVdycoD0nrJYg.JPEG/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.jpeg?type=w1200\" /></a></p><p>아기가 없을 때는 매번 친구랑 또는 남편이랑 둘이서 가던 곳을 드디어 4살 된 딸내미랑 방문하게 되었습니다. 일전에는 게스트하우스에서도 묵고 마지막 일정은 제주신라호텔로 잡는 일정이었는데 이번만큼은 3박을 온전히 신라호텔에서 보내고 오기로 하였습니다. 그래서인지 거의 해외여행 가는 수준의 비용을 들였던 것 같습니다만, 그럼에도 불구하고 한 푼도 아깝지 않은 여정이었습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/-YKZvKXoODZ9jcjR_Z40dHNCSKA.jpeg\" /></a></p><p>많은 사람들이 보이는 이곳은 바로 신라호텔 로비 공간입니다. 지금 줄 서 있는 사람들은 모두 다 체크아웃 하기 위해 기다리고 있는 모습인데요, 작년 2016년 겨울 비수기 중의 비수기에, 심지어 평일에 갔음에도 불구하고 엄청나게 많은 사람들이 보입니다. 신라호텔의 인기는 정말 어마어마합니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/Ojl-a3EDeBUJQ59xVtDnr8Z_p98.jpeg\" /></a></p><p>로비 바로 앞에는 아주아주 멋진 카페가 있습니다. 제주신라호텔은 이렇게 전반적으로 핑크빛이 감도는 분위기인데요, 건너편 창가로 햇빛이 쏟아져 들어오는 것이 보이시나요? 실제로도 지중해풍의 아주 멋진 호텔에 입장한 기분이 드는 곳입니다. 그런데 커피값은 참 비쌉니다. 한 잔에 16,000원 정도 하지요. 해외여행을 포기하고 간만큼, 커피값이 비싼 만큼 더욱 값어치를 하는 곳이기도 합니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/wvmfiVlUXC3ld3fsYYjBJMimvsg.jpeg\" /></a></p><p>카페 왼쪽 공간입니다. 많은 사람들이 대기를 하고 있지요. 체크아웃 시간이 겹쳐서 정말 많은 사람들이, 로비로 쏟아져 나왔답니다. 하지만 전혀 혼잡스럽지 않습니다. 신라호텔에 있으면 왠지 모를 여유와 기다림이 생긴다고 해야 할까요.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/S8EZ70k3PeAQ56NWTeuvxjyluCI.jpeg\" /></a></p><p>로비에서 이어지는 계단을 따라 내려오면 식당가가 있습니다. 창가를 따라 쭉-의자들이 배치되어 있고요. 한 끼를 제외하고 모든 식사를 호텔 내부에서 해결했던 저희 가족이 주로 산책 겸 들렀던 코스이기도 합니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/p1bhd295Fv4XXv3Wz5Bxja0d3EE.jpeg\" /></a></p><p>&nbsp;<br /><br />계단 왼편으로는 식당들이 있는데요, 이렇게 테이블이 야외로도 나와있습니다. 재미있는 건 저녁에는 이곳에서 와인파티 비슷한 것이 열립니다. 작은 미니 와인 바가 나와서 노래도 듣고 와인도 즐길 수 있는데 신라호텔 내부의 음식들이 다 너무 맛있어서 저희는 와인까지 즐길 배를 만들어두지는 못했습니다..</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/29IjIW8V4EHdvs_WjpYyQgJ3JGg.jpeg\" /></a></p><p>신라호텔은 한식당, 양식당, 일식당 서너 개의 식당이 있는데요, 각자 다른 메뉴들이 판매됩니다. 저희는 4살 배기 딸내미가 있었기 때문에 주로 한식당을 이용했습니다. 제가 호텔 룸보다 먼저 식당을 소개하는 이유는 너무 허기가 져서 룸에 짐을 내려놓고 바로 식사를 하러 나왔기 때문입니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/U6gNEDfLjAUIil5es1pKI8C8a4E.jpeg\" /></a></p><p>한식당 내부의 모습입니다. 정말 한식당스럽지요? 메뉴를 한번 보도록 하겠습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/80oFn4NvkiqQOjA6RJ5JGy99VMM.jpeg\" /></a></p><p>저희는 묵은지 고등어조림과 제주도 흑돼지 삼겹살, 은갈치 조리 등 거의 세끼 정도를 여기서 먹었는데 꽤 먹을만합니다. 제주도 현지 물가가 너무너무 비싸기 때문에 차라리 차비 아낄 겸 내부에서 식사를 해결하는 것도 나쁘지 않습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/tmEM_dQfKYNpOCbXaiJwEcspLYc.jpeg\" /></a></p><p>남편이 시킨 전복 해물 뚝배기. 남편 말로는 온갖 좋은 재료가 듬뿍 들어가서 너무너무 맛있고 땀이 다 난다고 합니다. 힘이 넘친다나? 왠지 평소보다 비싼 돈을 주고 먹어서 그런지 더욱 값지게 느껴지나 봅니다. 그런데 말입니다 처음에 저희가 이곳에서 먹을 때는 너무너무 맛있었지만, 매끼를 호텔 내부에서만 해결하니 나중에는 조금 힘들긴 하였습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/QbbA9LUmAD2pTE7v0waSk69h-1U.jpeg\" /></a></p><p>남편 전복 해물뚝배기 전체 상 모습. 반찬도 정갈하게 나옵니다. 가격은 48,000원입니다. 남편은 한식당에서 먹었던 요리 중에 제일 맛있었다고 하네요. 고기와 뚝배기 모두 한데 어우러진.. 남자들이 좋아하는 코스인가 봅니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/_phb2xFpQD-Fm-PSykUV3qu7cz8.jpeg\" /></a></p><p>저는 묵은지 고등어조림과 성게미역국을 시켜 아기와 나눠먹었습니다. 미역국이 고소하고 맛있으니 4살 배기 딸내미가 참 잘 먹습니다. 고등어도 살이 통통하게 오른 게 참 맛있습니다. 그런데 말입니다 저 고등어조림에서 친숙한 서울의 맛(?)이 느껴집니다. 달달하고 짭짤하고 매콤하고, 바로 제가 원하던 그런 맛이지요.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/DHv-ITYwI4LP_odv2oquHF4Trt8.jpeg\" /></a></p><p>반찬 위에 보시면 귀여운 미니 반찬통 3개가 보이시나요? 아기들이 있으면 아기용 반찬을 따로 챙겨줍니다. 아기들이랑 함께 밥을 먹으려면 반드시 김은 필수인데.. 김을 여기서 보니 참 반갑습니다. 나중에 아기가 좋아해서 김 하나만 챙겨달라고 부탁드렸는데, 제가 먹을 때는 김이 너무 맛있어서 이 김은 다른 김인가 보다 싶었는데 서울에서 흔히 볼 수 있는 광천김이었습니다. 제주에서는 참으로 비싼 김으로 탈바꿈되는 순간이었습니다.<br />&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/bkOOwCcSv7QN78MamlwuJVRMnQg.jpeg\" /></a></p><p>식사를 모두 마친 후 도착한 우리의 방. 저는 신라호텔이 너무 좋은 이유가 이런 하늘빛이 도는 방 분위기가 너무 좋기 때문입니다. 이것은 순전히 개인 취향이지만, 연한 하늘빛과 핑크빛이 적절히 어우러져 자아내는 고급스러움이 저는 참 마음에 답니다. 낙서가 한가득 있는 저희 집과는 비교되는 모습이지요.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/RbMjH4noDXCVA2FEm9e7Z-YMflQ.jpeg\" /></a></p><p>가로로 찍어본 방의 모습. 침대가 정말 이렇게 편안할 수가 없습니다. 아마 템퍼 같이 비싼 침대를 사용하는 것이겠지요? 제가 넌지시 남편에게 듣기로는 이렇게 좋은 호텔들은 침대 매트만 몇백만 원 하는 걸 사용한다고 하지요. 그래서인지, 아니면 기분 탓인지 침대가 한층 더 편안하게 느껴집니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/6nD8K4I3751rr4X9RxcZYgB1w-M.jpeg\" /></a></p><p>제가 신라호텔에서 가장 좋아한 이 1인용 소파. 4살 배기 딸내미가 어찌나 열심히 오르내리던지. 제가 앉을 겨를이 없었습니다. 켄싱턴호텔에도 비슷한 소파가 있는데, 여기랑 켄싱턴 둘 다 분위기에 어울리는 소파가 배치되어 있습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/4f0LiPvpQ9efDoKTwlFEhd5r-QA.jpeg\" /></a></p><p>바깥으로 보이는 멋진... 멋진.. 뷰...? 저희가 이곳 제주신라호텔을 방문할 때 예약이 모두 다 차 있어서 좋은 뷰의 룸을 선택하지 못했습니다. 심지어 행사까지 있어서 좋은 뷰의 방은 모두 다 찼다고 하더라고요. 솔직히 말씀드리면 신라호텔에서 좋은 뷰의 방을 선택할 때 7~8만 원 정도 추가 비용을 내야 하는데, 그렇게 하는 편이 좋습니다. 이 창밖으로는... 사실 아무것도 감상할 수가 없습니다. 그리고 제주신라호텔의 수영장을 바라보며 멀리서 보이는 바다까지 동시에 감상하는 맛이 쏠쏠했는데, 이번에는 뷰는 포기하게 되었습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/IZGsc9p-nSZRTELfoM0HsQo7f0g.jpeg\" /></a></p><p>침대 건너편 화장대의 모습입니다. 공간이 꽤 넓은 편입니다. 그런데 켄싱턴호텔이 내부는 훨씬 넓다는 생각이 듭니다. 켄싱턴호텔은 구조도 조금 독특했지요. 제주신라호텔도 서울의 신라호텔의 방보다는 훨씬 넓은 편이기는 합니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/3ztZGFcEnhQKsuhfaDXW29d1AjM.jpeg\" /></a></p><p>그리고 내가 좋아했던 신라호텔의 화장실. 솔직히 말씀드리면 화장실의 고급스러움은 켄싱턴이 조금 더 센 것 같은데, 신라호텔은 단아한 고급 진 맛이 있습니다. 전반적으로 화이트 톤과 대비시킨다는 점도 제가 상당히 마음에 들어 하는 포인트입니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/kXhDLlGT_1XNa5mFcZQNneN5KaY.jpeg\" /></a></p><p>욕조도 꽤 넓은 편입니다. 제 남편은 2박 동안 내내 이곳을 즐기더라고요. 좁고 낡은 욕조가 있는 저희 집 욕실과 너무 비교되어서 일까요. 화장실을 통째로 떼어다가 저희 집에 붙여 넣고 싶습니다. 블록처럼 말이죠.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/xHgvoqag_gDUXxyx0_P3jLpTaGI.jpeg\" /></a></p><p>룸을 모두 둘러보고 한숨 잔 뒤 우리는 수영장으로 이동했습니다. 너무너무 아쉬웠던 것은 저희가 간 12월에 완전 비성수기에.. 태풍 같은 비가 몰아쳤다는 사실입니다. 그래서 저희는 너무 슬프게도 실내수영장만 즐기다 돌아왔습니다. 그런데 말입니다, 여러분 신라호텔 수영장에는 엄청난 보물이 숨겨져 있습니다. 무엇일까요?</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/cf6DEn97-CFbOfTFjki_405FR-k.jpeg\" /></a></p><p>바로 신라호텔만의 자랑, 차돌 해물짬뽕. 풀 바에서 시켜 먹을 수 있는 이 요리는.. 정말이지... 한 번도 안 먹어본 사람은 있어도 한 번만 먹은 사람은 없다는 바로 그 맛입니다. 게다가 가격도 호텔 내부치고는 저렴한 편입니다. 34,000원 정도 했습니다. 대부분이 4~5만 원을 넘다 보니 이 짬뽕이 훨씬 저렴하게 느껴집니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/Jz_WOHyz_JLhtK-6jnzQ8OsFpLI.jpeg\" /></a></p><p>자 제가 한번 맛있게 먹어보도록 하겠습니다. 와아아- 열심히 리뷰를 쓰는 지금도 이 짬뽕이 생각납니다. 보통 해물과 고기가 섞이는 경우 국물이 잘 어우러지지 않는 경우가 많은데요, 제주신라호텔은 절대 그렇지 않습니다. 고기와 해물이 잘 어우러져 마치 하나의 칵테일처럼 잘 조합된 맛을 선보이고 있었고, 탄력 있는 면발과 함께 차돌 가득 한입 베어 물으면 정말 천국에 와있는 기분이 들 정도입니다. 특히 가격이 가격이니만큼 해산물도 정말 싱싱하고 전복도 몽땅 들어 있었기 때문에 제주신라호텔에서 가장 가성비가 좋은 음식이 아닐까 싶은 생각마저 듭니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/2sRplJaVHNWjlcFrLGC90aHB4J8.jpeg\" /></a></p><p>그런 우리를 지켜보고 있을 4살 배기 딸내미를 위해 시킨 치킨입니다. 치킨은 나쁘지 않았습니다만, 짬뽕을 먹고 먹으니 정말.. 안 들어가더라고요. 짬뽕은 국물까지 쪽쪽. 하지만 그렇다고 치킨이 맛이 없는 건 아닙니다. 정말 고소하고, 윤식당에 윤여정이 직접 튀기는 치킨만큼이나 맛있어 보이고, 또 맛있습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/gRp_LVJ6OW-iZuLZ80T1K0U96Nc.jpeg\" /></a></p><p>하지만 저는 짬뽕을 먹느라 여념이 없지요. 제가 혹시나 방문하실 분들이 계시다면 조언 하나만 드리자면 짬뽕이 양이 너무 많습니다. 그래서 짬뽕을 먼저 시킨 뒤에 다른 식사를 시키는 것이 좋을 것 같아요. 저희는 치킨을 거의 남겼기 때문입니다. 그리고.. 갑자기 짬뽕하니 생각이 났는데, 제주신라호텔 짬뽕이 너무 맛있어서 켄싱턴호텔에서 똑같이 짬뽕과 치킨을 시켜 먹었다가 큰코다친 경험이 있습니다. 맛있는 짬뽕은 오로지 제주신라호텔에만 있다는 사실.. 꼭 명심하시기를 바랍니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/lGtU26j-qmoXKVDolIUfz4RkLtw.jpeg\" /></a></p><p>내부에서는 우리 아기가 입고 있는 것처럼 큰 가운을 입고 있을 수 있습니다. 왜? 너무 추우니까. 아기용 가운도 있습니다. 히든 클리프에는 없는 그것, 유아용 가운을 바로 이곳 제주신라호텔에서 보실 수가 있습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/46hgdGCyg9-SFDjrsmMYkpkXR5g.jpeg\" /></a></p><p>열심히 실내 풀장을 즐기고 저녁에 바깥으로 구경 나온 우리들. 바깥 수영장도 너무너무 즐기고 싶었지만 날씨가 정말 최악이었습니다. 바로 태풍 같은 비가 내리기 전이었는데요, 비가 오던 오지 않던 너무 추웠습니다. 날씨만 좋았으면 하루 종일 실내, 실외 풀장 모두 즐길 수 있는 건데 말입니다. 너무 아쉬웠습니다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=17220814&amp;memberNo=24269379&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"700\" alt=\"\" src=\"https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/h7UMogrLyxgrd2j3G3WRjwH-6zQ.jpeg\" /></a></p><p>하지만 끝내주는 제주 신라호텔의 경치. 태풍 같은 비와 기타 등등으로 제대로 즐기지 못했지만 제주신라호텔에는 또 다른 특별함이 있습니다. 바로 제주신라호텔만의 프라이빗 비치인데요. 제주신라호텔 내부를 통과해서만 도달할 수 있는 바다입니다. 성수기 낮에 방문하면 야외에 움막 같은 것들이 펼쳐져 있고, 카드키만 있으면 제주신라호텔 이용 고객 누구나 이용할 수 있습니다. 그곳까지 걸어가는 코스도 너무 이쁘고, 프라이빗 한 공간을 즐기는 것도 기분 최고랍니다.</p>',3,'',6,3,'2022-01-18 15:06:51',0),
	(97,33,'인천/호텔 네스트호텔','<p><strong>자연&nbsp;속에&nbsp;숨겨둔&nbsp;나만의&nbsp;은신처</strong></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1730\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfNCAg/MDAxNTkxMTQ4Nzc2MjIw.XoL9lpYIb3a_SP1Z4-vscDl6W2rTScJbBUUBKyOC4Psg.50ZZJ-v84mT-fTsh0d1IO1vyL7IZkszI2jIpqysEsXkg.JPEG/201908141713001641637311.jpg?type=w1200\" /></a></p><p>이유 없이 익숙한 장소를 벗어나고 싶은 순간이 있다. 여행보다 가벼운 마음으로 훌쩍 떠나고 싶을 때, 낯선 공간의 신선함과 휴식의 편안함을 동시에 안겨주는 네스트호텔에서 하루를 보낸다.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTMw/MDAxNTkxMTQ4Nzg1NTMw.h73zeTy-2usrdRDYuzgPtmmGWOs1XLUBiGg_gJ50Jrwg._4BuZKYvKPg1xnipHJXzoj3im5zDOc9wFSVFsNv3pW8g.JPEG/201908141713101129828570.jpg?type=w1200\" /></a></p><p>인천공항에서 10여 분 떨어져 있어 하루에도 수십 번 머리 위로 비행기가 뜨고 지는 곳. 영종도의 갈대 숲을 배경으로 자리한 네스트는 &lsquo;둥지&rsquo;라는 이름에 걸맞게 창조적인 생각을 부화시키는 공간이자, 아늑한 쉼터의 역할을 하고 있다. 여행자에게는 출국에 앞서 여행의 시작점이 되기도 한다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjQ5/MDAxNTkxMTQ4Nzk4MTg4.AT1t3Ztmt0x0lprRPZ7R8pKw6KENRRB_wP7KFBJXw74g.eBxxMkckLuEeWPGUFFp_Xbtrxxqnrs5VtFlyCnZtXJwg.JPEG/201908141713181964574616.jpg?type=w1200\" /></a></p><p>잔잔한 서해안과 마주해 해돋이와 해넘이 명소로도 손꼽히는 곳이다. 독특한 디자인과 자연친화적인 분위기로 인해 특별한 날이 아니더라도 호텔을 찾는 젊은 투숙객이 많은 편이다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfODIg/MDAxNTkxMTQ4ODMwOTk3.3eMO_6IuqWwAmqae1b05VIYR3gDDfGvcAk4wjRHnjj0g.Uf36AMO67FtooWPezF37irn4l0v4mnYXzE-kWO5fsZEg.JPEG/201908141713251455816239.jpg?type=w1200\" /></a></p><p><strong>스타일</strong><br /><strong>국내 최초 디자인 호텔스 멤버 선정</strong></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTU3/MDAxNTkxMTQ4ODE1Mjkx.1JWZy9Mmmee8QzJFTd1TUBkLuVQk6y312mnGjZGJJ7Yg.d6MA0eY0dMi8DOyfTydC4_btO-WZTsqRasyNbOZv1isg.JPEG/20190814171526434634457.jpg?type=w1200\" /></a></p><p>전 세계의 독창적인 디자인 호텔들을 소개하는 디자인 호텔스에 국내 첫 멤버로 선정되었을 만큼 감각적인 디자인이 특징이다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTE2/MDAxNTkxMTQ4ODQxNDIy.DjpMccZpBUigk1lKIToSrQ8b38dFwVaxpqNLqCu7Tykg.YIFUFi9xEPutFoGjsD3WrK5PRTbT5gXvYgMMTPjYLPAg.JPEG/201908141715311209714023.jpg?type=w1200\" /></a></p><p>모든 객실의 창을 비스듬한 사선 형태로 설계한 외관부터 남다르다. 객실 하나 하나에 빛을 깊숙이 들이려는 시도에서 이러한 디자인이 탄생했다. 노출 콘크리트의 외벽은 주변 갈대의 색감과 인위적인&nbsp;느낌 없이 어우러진다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTY4/MDAxNTkxMTQ4ODU0MzY4.2JupODIps65iBwEdRoi3hQcKlDOMQzdfCyXg6gh1zaIg.JHNhAQRUob88T0hBQnvOpOBgK93MPsGW4Xt-FvRFoQUg.JPEG/20190814171537490103928.jpg?type=w1200\" /></a></p><p>입구에 들어서서 가장 먼저 마주하게 되는 것 또한 프론트 데스크가 아닌 잔잔한 서해의 풍경이다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTc4/MDAxNTkxMTQ4ODY5Mzgx.wqYniasBrztSKzSZBTjBFgyLEDhxSCJe_nTB1nJ8iOYg._svz_mF_USfOQ6KEvkoP4LU21TE26Nfh4UZCePNIeBcg.JPEG/201908141715431913569670.jpg?type=w1200\" /></a></p><p>모노톤으로 꾸며진 로비가 모던하면서도 빈티지하다.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTY1/MDAxNTkxMTQ4ODc3ODk3.frp0zsunHFi0W8j8X2QrB5krleNiUKBui8cNqHcWZegg.pkSqhlafEoFslnlDR96nXmCDDdzd-gLeEOwd2-6QM0wg.JPEG/20190814171547110495370.jpg?type=w1200\" /></a></p><p>&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjQ0/MDAxNTkxMTQ4ODkwMjMw.h777fiPYdHCUrDgLj4uuGV44TdS06fhXxgkN4sh5CLAg.NKTqWvpxQslA6LaHmqhcysjwCyP2wjgVucDzwwVpSTYg.JPEG/201908141715521298251301.jpg?type=w1200\" /></a></p><p>가죽 소파를 무심하게 배치한 라운지가 호텔이라기보다 트렌디한 분위기의 카페 또는 갤러리를 연상시킨다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTgy/MDAxNTkxMTQ4OTAyMzE2.AHKulcj1SxnPFRTSo3Ue11bGSyAqn9U4qrG5bPekBukg.ORejBSTr2D9e_piOkYgXxK7MAJ8EYXDzfNySZQNF6Y0g.JPEG/201908141715591818354893.jpg?type=w1200\" /></a></p><p>호텔에 머무는 내내 은은한 피톤치드 향을 느낄 수 있는데, 내부 곳곳에 피톤치드 디퓨저를 비치해둔 덕이다. 마치 숲 속을 거니는 듯한 기분이 든다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjU3/MDAxNTkxMTQ4OTEyODUz.aikOh-c3CYsMEnnkL56dSimtxB2dRbrb1yLiyNFhSnIg.jUZtzIp_xl_Bd0JxU5DFNYZQmeZsLErNWOgqdFTpzVAg.JPEG/201908141716041373069206.jpg?type=w1200\" /></a></p><p>&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfNzYg/MDAxNTkxMTQ4OTEyODg2.UaM8Viq6tYpdKfEjOihp12S8clZrpGdoqVSWZJsQqIwg.SGbC_424aQl8FGNPUANGSMVL5tw1KnwLZ-gEnxCRwjcg.JPEG/20190814171608361883084.jpg?type=w1200\" /></a></p><p>객실로 향하는 복도의 카펫조차 갈대와 나무를 패턴화 시킨 디자인다. 조명 하나, 세면대와 주전자, 쓰레기통 하나에도 디자인 요소를 놓치지 않은 디테일이 돋보인다.&nbsp;</p><p><strong>객실</strong></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTEx/MDAxNTkxMTQ4OTIzNDA4.d4PPc-cYS-I718KKC0Iyl2uz8PwnYxKHakEvUnI-Ejkg.5cTrZvjlNud_ogbfYUFyJlWu9Zos73G4PWl-l8_NWNkg.JPEG/201908141716141127504377.jpg?type=w1200\" /></a></p><p>총 370개의 객실은 자연 속에 위치한 &lsquo;나만의 은신처&rsquo;를 콘셉트로 자연에서 모티브를 얻은 따뜻한 온도의 인테리어를 선보인다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTc2/MDAxNTkxMTQ4OTMxODg3.MTL9vdZB63kHbr9u6-xSWVXmnMZXMWLSMD_Ai7rZjH4g.rOTu_v9jbMi5m557MgSzQjGds8GgssWG6bTJivrrqtcg.JPEG/20190814171619439048300.jpg?type=w1200\" /></a></p><p>전 객실이 테라스를 갖추고 있으며, 이는 씨사이드 뷰와 마운틴 뷰 전망으로 나뉜다. 씨사이드 뷰 객실의 경우 서해안의 일출과 일몰을 모두 바라보여 인기가 높다고. 연말에는 두어 달 전에 예약이 마감될 정도다</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTIx/MDAxNTkxMTQ4OTQzNDA5.hFFtRnmZUXnLGMN62mUcW0GtFGZR-r7LkuMt7PGqelAg.mXAl8N6CSOudY_CkPE7jboKag92OpBVnKe74I6Ks7gsg.JPEG/201908141716241323027357.jpg?type=w1200\" /></a></p><p>블루투스 스피커가 침대 머리맡에 내장되어 있어 원하는 음악을 플레이할 수 있다.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjQ0/MDAxNTkxMTQ4OTU0MzM1.tD5z7bzxuJ9Cdihy1v2g5vTNkmV6DFCKxGJBS2uPzuog.HFPNcdvMqn_MnmAJwiMnx1t7dUHBkwGldQyp-IBrgvkg.JPEG/20190814171629690513200.jpg?type=w1200\" /></a></p><p>머리맡의 독서등을 켜고 늦도록 책을 읽거나 USB와 TV를 연결해 준비해온 콘텐츠를 시청하는 것도 가능했다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjg4/MDAxNTkxMTQ4OTYzMjM5.Kt2TcqcuK7y0gpR5SMJolo_qK-RSh5MJcgrE6e-kac4g.Mg413kQ_KKJ8wjL0_hFp1kpaX_NluOGyLaA_5hqvliEg.JPEG/201908141716381434279977.jpg?type=w1200\" /></a></p><p>비품 위생을 철저히 관리하고 있었지만, 고객의 불안감을 해소하기 위해 종이컵도 따로 비치해둔 점도 만족스러운 점 중 하나다.<br />&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfNTIg/MDAxNTkxMTQ4OTc5MjAx.wrI9Sjb2dDkjIkw1dARchaVJu6bNZ6pUQKmX_5vM-SYg.ufLB-sppok367oUXyPaEb78EZcdknPXHWZPh2aWpMr8g.JPEG/2019081417164380569458.jpg?type=w1200\" /></a></p><p><strong>디럭스 트윈 (벙커룸)</strong><br />네스트의 시그니처 객실. 창 바로 앞에 더블 침대가 놓여있어 자연 또는 바다 전망을 더욱 가깝게 누린다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTMw/MDAxNTkxMTQ4OTkxOTI3.Lg95ovJJ-dixwJCDKu68why0maxuPwiTTLPGXBmmcCog.M47U3jiJgTG6IQxtIFHPf2vBW_az7O8wGJttjOojDJsg.JPEG/20190814171649556468391.jpg?type=w1200\" /></a></p><p>싱글 침대가 놓인 이색 벙커 룸이 특징이다. 친구 또는 가족과 이곳을 찾을 때면, 아늑함 때문인지 넓은 침대를 두고 서로 이곳을 차지하려 든다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjE1/MDAxNTkxMTQ5MDAxNTUz.e98wBWFPUdzdbjuI477st26Tfie3Ia7wBvB01fImHPgg.ssyu_hdaD9oQtIX_7hVWI3idRJ2ZdL1hRbJzM8FnWYQg.JPEG/201908141716561391933917.jpg?type=w1200\" /></a></p><p>소파와 소파 테이블이 넓어 룸서비스 이용 시에도 무척 편리하다. 소파 위에 침구만 추가하면 최대 4명까지도 무리 없이 투숙 가능하다.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTQy/MDAxNTkxMTQ5MDEwMjk0.dwbmOc2NDoFTnavBSGGFE1z5P1mbtxBYyL3Ohgp9Sagg.3-32SlB9PeSIAYuIFIAtiEbPQnsu7tz442PBTqzl8kUg.JPEG/201908141717011705101237.jpg?type=w1200\" /></a></p><p>긴 사다리꼴 형태의 책상이 소파와 침대 사이에 놓여있어 업무를 보기에도 불편함이 없다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTMg/MDAxNTkxMTQ5MDE3NjAx.axmN1ZyDp1AqCKNiy91QNXq65X2hiRqRMobC7Jv7rJog._bIljtq6d5Pl5priYPQSbN1d2VpUVvpGnqpRiiv344kg.JPEG/20190814171706806143325.jpg?type=w1200\" /></a></p><p>코너 공간을 활용한 욕조가 널찍하면서도 멋스럽다. 욕조에 몸을 담근 채로 바깥을 조망할 수 있게 욕실 벽면에도 긴 창을 냈다.<br />&nbsp;*침구 추가 비용 1인 22,000원</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"480\" alt=\"\" src=\"https://editor.naver.com/static/img/no_image_404.png\" /></a></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjQ4/MDAxNTkxMTQ5MDMyODk2.arndAU6LaNMrGMIQrd1TP9rr2o0C2EZeeF4E7IIGPq0g.yf8IUPQackxDjAubjvOnScgv_bmII7oXJgPkoLTUFA8g.JPEG/20190814171715322735514.jpg?type=w1200\" /></a></p><p>&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjE4/MDAxNTkxMTQ5MDMyOTE5.a_na6f2-Hkdn10qYAX4MBo0Ki2YQXoEOie8ox8flCFYg.tiguKCN4iZev50VExUiBtYaSdybTcrCDfFUMF7aiaL4g.JPEG/201908141717241529414886.jpg?type=w1200\" /></a></p><p><strong>디럭스 더블</strong><br />디럭스 트윈과 동일한 구조이나, 벙커 룸이 없는 대신 화장실과 파우더룸, 드레스룸이 이어진 넓은 욕실이 쾌적함을 더한다.<br />&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfNTAg/MDAxNTkxMTQ5MDQzODc0._aPK0HggZ9Q_nmhqmHZsDFUmzuBJbvf9qyh9pOhu7QUg.4h0wLT3QN4Uu8TRbNIwiBURazZxUclCyUXxyuRb3ZQgg.JPEG/20190814171728228717755.jpg?type=w1200\" /></a></p><p><strong>디럭스 패밀리</strong><br />탁 트인 실내와 창가의 업무 공간이 넓고 여유롭다. 욕조를 없애고 객실을 확장했다.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTYw/MDAxNTkxMTQ5MDUwOTA0.zvr4BjHmSeH7VZalElOaff5zI4r6OqvwVn07M1V-yY4g.7DAbAjkhlNxcOuaZp8zD68oyUYXRSt5TXMIvimbZtUAg.JPEG/20190814171733672022132.jpg?type=w1200\" /></a></p><p>더블 침대 두 개로 최대 4명까지 투숙할 수 있다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMzgg/MDAxNTkxMTQ5MDU4NTk3.BrXdhLXkd668v8-Qp_kFlKEg7axTejLCz1wadLgIzJAg.sewiwnULgzMZIgXWf6oUMKOUAMy4KudaWHMOZFI8fcEg.JPEG/20190814171737612697542.jpg?type=w1200\" /></a></p><p><strong>스탠다드</strong><br />짙은 네이비 컬러의 카펫과 노출 콘크리트 내벽으로 빈티지한 감성이 느껴지는 스탠다드.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTY5/MDAxNTkxMTQ5MDY5MDA1.9RonMK6wFG4Z_u4ZB52TWWPZPDM_VBhyQWCnoRFwTIsg.PlzcKpgXvBKtT8B-KnGaaXMaORY6Fq8arGe8X-4KAB8g.JPEG/20190814171741276773151.jpg?type=w1200\" /></a></p><p>10평 넓이의 내부는 휴식에 최적화된 공간으로 간결하게 꾸며졌다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjU4/MDAxNTkxMTQ5MDc2MzE1.oDliQQT4YZkKwGyHfG4AHuh82qgdgJUuNeZ0FcLjb68g.c66d9jjlQQmov7x8ovzjZWR9dF44x2hUW6lSecAKw60g.JPEG/20190814171745885552654.jpg?type=w1200\" /></a></p><p>가장 마음에 드는 부분은 1인 책상이다. 벽을 파고든 모양새와 책상 위로 빛을 직접 떨어트리는 조명등이 집중하기 좋은 분위기를 연출한다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfNTQg/MDAxNTkxMTQ5MDg0NDgz.yQMSQ0fF5tx4bCD_7TK67pPg1AO9mvsXXQ2R6zCT0sMg.EWx6DoOJpxRUcqcJihhng0bADeLvGYEOl4zxl111vJYg.JPEG/20190814171751207516561.jpg?type=w1200\" /></a></p><p>욕실에는 욕조 대신 샤워부스를 설치해 공간 효율을 높였다.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTUx/MDAxNTkxMTQ5MDkzNDk4.VSx4GfmZx9zvW4Oh0M1AhAOS6BfZw5Ae0qZ1_nlOfJAg.zM5rxdM2DGN1KwCGky9Nd3gJw0eKHNwj0IBlRIJj0Dsg.JPEG/20190814171755179134906.jpg?type=w1200\" /></a></p><p><strong>리드 스위트</strong><br />낮은 분리벽으로 거실과 침실 영역을 구분 지은 스튜디오 형태의 스위트.<br />&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTgz/MDAxNTkxMTQ5MTAxMjE2.r1JzbwodIFC3iI15CsZrSoLIVwkjENQqpVlG_Vh1JR8g.6iJd8BMO2f60oTQjOCeD0J8darkcIXEm61XjdOGsC78g.JPEG/20190814171801757218693.jpg?type=w1200\" /></a></p><p>2인 기준 룸이지만 엑스트라 베드를 추가하면 3명까지도 투숙할 수 있다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTQ4/MDAxNTkxMTQ5MTEwOTEx.WATm0RfsCP0OnF_2TOsiKBOSFogIBcWaTxT5RA31C0Qg.Tp_8wsWtRd0jkt7Y_zIhFA1FsNp0ag1d_QpaWT3jtnUg.JPEG/20190814171810504620994.jpg?type=w1200\" /></a></p><p>히노끼 목재로 마감된 욕실에선 은은한 나무 향이 난다. 욕실이 경계 없이 오픈 되어 있어 바다를 바라보며 거품 목욕을 즐길 수 있다.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTc5/MDAxNTkxMTQ5MTIxMTcx.FxxQPeYq9Tb--4-5NZe2OZUi7-Py9WgZQIiy8v5Io_Yg.vUS9CK3ljzAXMd0ocqOHRKe9B-pDIYlb8KSMx0mO0vAg.JPEG/20190814171818279622587.jpg?type=w1200\" /></a></p><p>로맨틱한 아일랜드 욕조가 있어 특별한 날 연인들에게 추천하는 객실이다.<br />*엑스트라 베드 추가 비용 55,000원&nbsp;</p><p><strong>어메니티</strong></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfNzQg/MDAxNTkxMTQ5MTQxNTk0.IUIEjdsQf98AzBy70CG7tWx-mmosdNn6vVUOfcHKcDMg.0cDlaSDrzut4kg02qjg69GiaCLOOKFgsEDEbpen-qQQg.JPEG/201908141718242004726256.jpg?type=w1200\" /></a></p><p>청정 호주에서 탄생한 홈 스파 브랜드 쿠도스 스파 제품이 어메니티로 제공된다.<br /><br />샴푸, 바디워시, 컨디셔너, 바디로션과 같은 기본 품목 외에도 칫솔과 치약, 샤워 스폰지 등이 세심하게 구성되어 있다.&nbsp;무엇보다 페이스 클렌저가 포함되어 있는 여성 고객들의 만족도가 높다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTgx/MDAxNTkxMTQ5MTUzNTA3.Duh8FzyjswGUL3U-RBtucinLmMY8AkvnN1Ow9OyQ5DUg.iYn2Z_sN2z9GktsvyXYUDDyEhEGdSjcwFNnF81mSkOkg.JPEG/201908141718301582540257.jpg?type=w1200\" /></a></p><p>욕조가 있는 객실의 경우 오가닉 사해소금 입욕제가, 샤워부스가 있는 객실의 경우 오가닉 사해소금 스크럽이 스페셜 기프트로 제공되어 특별함을 더한다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTA5/MDAxNTkxMTQ5MTY1MDkx.jpd_uxVxJXiVmamOg6ASN-3qKo-bQX2CdY9IfecPVHsg.0hN1BBLW_9X8CnvYCdvYa4X3IATrJgro32vvJkwn2QYg.JPEG/20190814171835973161.jpg?type=w1200\" /></a></p><p>샤워가운은 가벼운 면 소재로 제작되어 잠옷 대신 걸치기 좋다.</p><p><strong>부대시설</strong></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTk3/MDAxNTkxMTQ5MTc4MTE1.Zf_yGvOEI6jySHidTEL2TjmOI_DqyCkACUh_172cde8g.RixuZjSddVz6bW5wXYPzyxBVJYOuotSXOzDIOMq7jiIg.JPEG/201908141718421862733921.jpg?type=w1200\" /></a></p><p><strong>인피니티 풀</strong><br />서해안과 소나무 숲과 맞닿은 25m 길이의 인피니티 풀. 36℃의 온수로 사계절 내내 운영되고 있으며, 투숙객뿐 아니라 외부인도 유료로 이용할 수 있어 인천에서 떠오르는 핫 스팟 중 하나다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"480\" alt=\"\" src=\"https://editor.naver.com/static/img/no_image_404.png\" /></a></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTM2/MDAxNTkxMTQ5MTg5NDI4.-as0fWIShhMEzk0s7He3Nw9NZJ3ZiG3XRor8ztn-Lfwg.YnB8A1ysojWfRUzhYHEkZKnfj-ckVyGHEBgAscXhOcEg.JPEG/20190814171848823760530.jpg?type=w1200\" /></a></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTYx/MDAxNTkxMTQ5MTg5NDI4.h9uDzzJz2RuxdlaxZ1CMdn47WCpyHht1PQMzWlUNaj0g.jv4qKS7T0g8I9AUi3ksq_sgH8WsZM2Ui7SO3wKCRQSkg.JPEG/20190814171854814077845.jpg?type=w1200\" /></a></p><p>수심 1.3m의 인피니티 풀 바로 옆에는 42℃ 수온의 스파 풀과 핀란드식 실내 사우나가 있어 떨어진 체온을 회복시키기에도 그만이다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMzAw/MDAxNTkxMTQ5MTk4NTgw.vEhAeUOFMyEww0WCuzweE-leUE5uGYYnjeAqgiKQkjEg.eXbvltomDGEfrjA11LPdWMmRcAHGNgYkfp9F6weQ0z0g.JPEG/201908141718581984189305.jpg?type=w1200\" /></a></p><p>키즈 전용 풀은 한층 아래 위치해 있다. 야외 계단을 통해 곧장 이어지며, 수심은 0.9m다.&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTgx/MDAxNTkxMTQ5MjA3MDM2.Erz4Zy018HcMPnD7iS4HESEfybTnhuTMSsKnA_7qE3gg.o0RJ7RyVSKmJesbb0UlF5XbBVtFLeP-ykGaCES3BMa0g.JPEG/20190814171903178889828.jpg?type=w1200\" /></a></p><p>어린이용 암 튜브와 라이프 자켓도 무료로 대여해주고 있다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjM3/MDAxNTkxMTQ5MjE2NzUy.Nmslo5zr8lvih-KjfLibRwIf8uRY0tqKjV5LvS6XeSkg.0GSlY0X6Z0MY4bsLDWtvZIMuciFKzGzd0CbwXNlCqK4g.JPEG/20190814171908686846436.jpg?type=w1200\" /></a></p><p>매주 금요일과 토요일 저녁 7시 30분부터 9시 30분까지, 풀사이드바에서는 DJ 스테이지와 함께 무제한 드링크 이벤트를 진행한다. 1인당 25,000원만 지불하면 보드카 토닉과 스크류 드라이버, 스파클링 와인을 무제한으로 즐길 수 있다. 만 19세 이상만 참여 가능하다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTg0/MDAxNTkxMTQ5MjI4NDMz.-IjcEkLNEZSBCBV-HQYmHejhm7iSglrcrptg3yLto6gg.wUSJedYGxHZgcsK8vWkxYDawrhQLon9yGBDMg9V1rrEg.JPEG/20190814171914157354016.jpg?type=w1200\" /></a></p><p>선베드는 주중 10,000원, 주말 20,000원에 이용 가능하며, 카바나는 사전 예약 필수다. 튜브는 안전상의 이유로 지름 1m이하까지만 반입할 수 있으니 유의할 것.</p><p>이용금액 시즌별/요일별/시간대별 상이<br />투숙객 기준: 대인 20,000원~48,000원, 소인 8,000원~24,000원 (140cm 미만 소인 요금 적용)</p><p>&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfNDgg/MDAxNTkxMTQ5MjU4MTcy.iYt9LxEr7A30S-cDYOzY_JAHTcoA-6KBrfQsHCBJMCcg.VUFuI2CvFRWkKmStOMVURLnAAW4OILDZIoqbSTMdq9gg.JPEG/201908141719201332124334.jpg?type=w1200\" /></a></p><p><strong>실내외 프리 키즈존</strong><br />아이들을 위한 놀이터를 실내외에 모두 갖춘 것도 장점이다. 실내 키즈존 크림하우스는 아이들의안전을 고려한 소프트한 재질의 매트와 놀이기구들로 꾸며졌다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTkw/MDAxNTkxMTQ5MjY1NTU2.a5CpeTyQWD03pjuJmiVKw3aWkQzEYuzeV_7THZsx8ugg.EGmeylu_-6sxD5DQYavcNbQvTkPcdEnYUGssKb-OzD8g.JPEG/201908141719242045567350.jpg?type=w1200\" /></a></p><p>천연 잔디 위에 나무 소재의 미끄럼틀과 그네, 시소가 설치된 야외 놀이터 외에도 아이들을 위한 작은 인공 해변을 조성했다. 키즈존 이용요금은 전부 무료. 컨시어지에 문의할 경우 모래 장난감도 빌려준다.</p><p><strong>다이닝</strong></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjU1/MDAxNTkxMTQ5Mjc0NDE5.KRqBt21ERRwm_BZx2n_rOZAkUmRWtfd8O3Y2IgjKG_Mg.c4yPVwaYyk01nDl2JxXoWjBz096LuxNbq4NXs37mr0Ug.JPEG/201908141719291867107675.jpg?type=w1200\" /></a></p><p><strong>쿤스트라운지</strong><br />로비층에 위치한 라이브러리 컨셉의 카페&amp;바. 고급 오디오 시스템과 프로젝트 빔 등의 설비로 프라이빗 파티, 전시 등의 대관도 활발히 이루어 지는 곳이다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"480\" alt=\"\" src=\"https://editor.naver.com/static/img/no_image_404.png\" /></a></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjIy/MDAxNTkxMTQ5Mjg1NTkz.JAS6pfwrFFZ0XPwMtrWfVzdUI-rif1qd_X3MA28RzVcg.aavk2ncuWUSuJbk5LZJXLvoaMxdHJxgFI7Fn8OAYCmEg.JPEG/201908141719361793276032.jpg?type=w1200\" /></a></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjc4/MDAxNTkxMTQ5Mjg1NTk1.77ZI7i_hoC3AjAGklPvgrBqMP9DDpIoo6om1LjxI0G4g.61uao_mVXZwRV8_6uzxTBlQRP5ZmyA1M7oKBuy2Pqu4g.JPEG/201908141719432124827895.jpg?type=w1200\" /></a></p><p>각종 예술 서적이 구비되어 있으며, 각종 디자인 소품도 판매하고 있다.</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMyAg/MDAxNTkxMTQ5MjkzNzU1.Ujo14pCsT6SS7N25V4Tyawr1Ul4Y5fLEwZ6RZ90FhN0g.lsW2ghgBTOfO1xsL0AFXExfeJuQzauuVSzQXaPN5QTgg.JPEG/201908141719481436046743.jpg?type=w1200\" /></a></p><p>매일 오전 10시부터 오후 3시 사이에만 주문 가능한 브런치는 그 종류도 다양하지만 음료가 포함된 실속 있는 메뉴 구성으로 인기가 많다. 가격도 여느 카페와 비슷한 수준이다.<br />&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMjM4/MDAxNTkxMTQ5MzAyODM3.5Q5IJfJQ5_dD7YA_4tFB9KcW8P1j0RVpXLd3D9po7OAg.UN22zdJB-TbPIeObyVmdw03FPEpvd7j-z8bghfNzZvog.JPEG/201908141719531651071648.jpg?type=w1200\" /></a></p><p><strong>플라츠</strong><br />로비와 이어진 바다 전망의 올데이 다이닝 레스토랑. 독특한 계단식 배열과 전면 통창으로 인해 어디에 앉더라도 바다가 바라보인다.<br /><br />조식과 주말, 공휴일은 뷔페로 운영되나, 주중 점심과 저녁에는 단품 메뉴만 주문을 받는다.</p><p>운영 시간 06:30 - 21:00 (조식: 평일 06:30 - 10:00, 주말 06:30 - 10:30)</p><p>&nbsp;</p><p><strong>에디터팁</strong></p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfNzcg/MDAxNTkxMTQ5MzEzMTk2.q04sPFhlEDictwdrrFKc53UxUF1NPs0S2YErmdLoevog.ReRk06lJo6dAfeKLOBDcV4mV9kr_IqJhbZpINVVU3-Eg.JPEG/20190814171958467657631.jpg?type=w1200\" /></a></p><p><strong>컨시어지 무료 대여 서비스</strong><br />몸만 훌쩍 떠나온 즉흥 여행이라면, 컨시어지 데스크의 무료 대여 서비스를 적극 활용해보자.<br /><br />편의물품부터 아이 동반 고객을 위한 유아용 변기와 발판, 아기침대와 침대가드, 유모차 등을 무료로 대여해주고 있다. 뿐만 아니라 플레이스테이션과 노트북과 TV를 연결할 수 있는 HDMI 케이블까지, 혹시 모를 지루함을 달래 줄 아이템까지 세심하게 구비했다.<br />&nbsp;</p><p><a href=\"https://post.naver.com/viewer/postView.nhn?volumeNo=26338642&amp;memberNo=25599212&amp;vType=VERTICAL#\" onclick=\"return false;\"><img width=\"1125\" alt=\"\" src=\"https://post-phinf.pstatic.net/MjAyMDA2MDNfMTE1/MDAxNTkxMTQ5MzIzNDcy.DRzhD0fW54wdoPvMbXLQKJZR39aVBy4GLW0UPerCotcg.NIUAcKANUJe6uoiCKlc-01c6d_-suTNjpEgUUghIWe0g.JPEG/20190814172002275613870.jpg?type=w1200\" /></a></p><p><strong>편의점 대신 밴딩머신</strong><br />간단한 주전부리와 간편식, 생필품 등을 구입하고 싶다면 호텔 밖으로 나갈 필요 없이 호텔 내 자판기 코너를 이용하면 된다. 프론트 데스크 뒤 크림하우스 내에 위치한다.</p>',3,'호캉스',8,1,'2022-01-18 15:12:13',0),
	(102,32,'강릉 세인트존스호텔','<p>​</p><p><img alt=\"\" src=\"https://postfiles.pstatic.net/MjAyMTEyMjRfMTQ3/MDAxNjQwMzM0NjY2MzA3.z5fxaybVPq568oXcLep5tbOqIQj_O33nW7y1iQ5x4GIg.5TWvGBXVf7gWmSU0x_Cx7i9GvLkJzBUsNMj-403ATeUg.JPEG.gayeonmusic/20211221_152139.jpg?type=w966\" /></p><p>세인트존스호텔 수영장</p><p>​</p><p>​</p><p>저는 2시 40분경 세인트존스호텔에 도착하였고 2시 45분경 수영장에 입장하였습니다. 제가 입장했을 때는 사람이 한명도 없을 정도였으니 운이 좋았죠. 수영장 사진은 아래 포스팅에서도 확인하실 수 있습니다.</p><p>&nbsp;</p><p>​</p><p>&nbsp;</p><p>​</p><p>​</p><p>투숙객 및 사전 예약 할인을 적용해도 4만원이라는 다소 비싼 감이 있지만 수영장에 들어가니 역시 수영장에 오길 잘했다는 생각이 들었습니다. 평일 오후라 사람도 많지 않아 편안하게 바다 뷰를 감상할 수 있었죠. 직원 분도 친절하셔서 영상도 찍어주셨습니다. 다만 겨울인지라 수영장에서 문을 열고 밖으로 나가서 화장실을 가는 것은 다소 불편했는데요. 문을 열자마자 엄청난 바람에 너무 놀라 절로 탄성이 나왔습니다. 화장실이 실내에 바로 있었다면 좋았을 텐데 아쉬웠습니다. 하지만 밖으로 나가서 거의 바로 위치해있어 여름에는 큰 문제가 되지 않을 겁니다.</p><p>​</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><figure class=\"easyimage easyimage-full\"><img alt=\"\" width=\"16\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAJCAYAAAA7KqwyAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3wccBTIrwFRftwAAAB1pVFh0Q29tbWVudAAAAAAAQ3JlYXRlZCB3aXRoIEdJTVBkLmUHAAAAD0lEQVQoz2NgGAWjgAoAAAJJAAEMrHXpAAAAAElFTkSuQmCC\" /><figcaption></figcaption></figure><p>&nbsp;</p><p><strong>세인트존스호텔 수영장 바다뷰</strong></p><p>​</p><p>​</p><p>또한 타월에 대한 안내도 부족했습니다. 비치타월을 대여하실 거냐고 물어봤는데, 저는 탈의실에서 수영장이 바로 연결되어 있는 줄 알고 필요 없다고 했으나 탈의실에서 수영장까지 거리가 상당했습니다. 탈의실에서 수영복 차림으로 수영장까지 이동하는 것은 거의 불가능할 정도로 민망하고 너무 추운 지경이었죠. 그래서 탈의실 문에서 직원분께 부탁하여 비치타월 대여를 부탁드리게 되었죠. 또한 저에겐 수영을 마치고 탈의실/사우나로 돌아왔을 때 쓸 수 있는 수건이 없었습니다. 사우나에서 쓸 수건 역시 비치타월을 대여하던 데스크에서 받았어야 했는데 주지 않으셨던 거죠. 그래서 탈의실에서 직원분께 수건을 부탁드려야 했어요. 수건에 대한 안내는 아예 없던 게 당황스러웠어요.</p><p>​</p><p>​</p><p><img alt=\"\" src=\"https://postfiles.pstatic.net/MjAyMTEyMjRfMjU1/MDAxNjQwMzM1MDg5NTgx.GcVLarWJA46O1qW-Khf7jPhWuoIjXRoZZEvprRrLhtIg.13bEAtLbG_GBxbgKfz9V4FNa6GvCTXPtVsIDeSw3fHAg.JPEG.gayeonmusic/20211221_170318.jpg?type=w966\" /></p><p>강릉 세인트존스호텔 건물 입구</p><p>​</p><p>​</p><p>수영장에서 사우나까지 들리고 5시가 넘어서 체크인을 하게 되었습니다. 체크인 가능 시각은 4시인데, 오기 전 리뷰를 통해 체크인이 오래 걸리기로 악명 높다는 글을 여러 번 읽어서 걱정이 되었는데요. 역시 번호표를 뽑아보니 대기가 9팀이 있었습니다. 화요일인데도 이 정도라면 금, 토, 일에는 체크인까지 얼마나 오래 기다려야 할까 싶네요. 셀프 체크인 기기들이 비치되어있지만 현재는 모두 운영 중단된 상태였습니다. 그나마 은행처럼 번호가 전광판에 크게 뜨고 앞에 대기할 의자가 있어 다행이었습니다.</p><p>​</p><p>​</p><p><img alt=\"\" src=\"https://postfiles.pstatic.net/MjAyMTEyMjRfMjUw/MDAxNjQwMzM2Mjc5MDM2.bJAbA6B5xcFc90aYCDELLm5tvZYXf3BJMSvbr2bnM7gg.WKnmwMTOv2J8W8phA-3HsPaGtatF61Gr33HntprQQyUg.JPEG.gayeonmusic/20211221_172119.jpg?type=w966\" /></p><p>세인트존스호텔 객실</p><p>​</p><p>​</p><p>다음은 객실 모습인데요. 저는 가장 꼭대기층인 16층에 배정받았습니다. 오션뷰는 아니지만 만족스러웠습니다. 이미 5시 반이 되어 해가 지고 체크인을 한데다 아침에는 바로 조식을 먹고 체크아웃을 해야 하기 때문에 오션뷰가 필요가 없었죠. 2박 3일 정도 일정이라면 오션뷰도 괜찮을 텐데 1박 2일 일정에는 오션뷰가 아까울 것 같아요.</p><p>​</p><p>​</p><p>​</p><p>방은 전반적으로 괜찮았으나 친환경 정책으로 슬리퍼, 칫솔, 치약 등 어메니티는 샴푸와 바디워시를 제외하고 전부 제공되지 않았습니다. 지난 제주도 여행에서 방문했던 호텔도 칫솔, 치약이 없어 당황했으나 그래도 슬리퍼는 제공되었는데요.. 전부 호텔 내 자판기에서 판매하는 것을 보아 아무래도 별도 구매를 유도하는 것이 느껴졌어요. 특히 슬리퍼가 없어서 저는 맨발로 방을 돌아다녔어요.</p><p>&nbsp;</p>',4,'호캉스',14,2,'2022-01-18 15:48:20',0),
	(103,33,'숙소 리뷰입니다.','',1,'',4,0,'2022-01-18 19:42:53',0),
	(105,32,'숙소','<p>가족끼리 좋아요 정말로</p>',1,'',9,2,'2022-01-18 19:57:41',0),
	(108,32,'도심 속 호캉스! 추천합니다','<p>가족끼리 호캉스 즐기러 다녀왔어요!</p>',1,'호캉스,가족여행',6,8,'2022-01-19 10:37:19',0),
	(109,43,'<script>alert(\"테스트\")</script>','<p>&lt;script&gt;alert(&quot;테스트&quot;)&lt;/script&gt;</p>',1,'',2,0,'2022-01-19 10:54:21',0),
	(111,32,'추천해요','<p>ㅈㄷㅈㄷ</p>',1,'',3,3,'2022-01-19 14:51:52',0),
	(112,32,'<script></script>','<p>가족끼리 여행하기 조아요</p>',1,'',4,2,'2022-01-19 15:27:49',0),
	(113,32,'ㅁㄴㅇㄹ','<p>ㅇㄹ</p>',5,'',2,0,'2022-01-21 15:25:05',0);

/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table report
# ------------------------------------------------------------

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `repo_no` int(11) NOT NULL AUTO_INCREMENT,
  `mb_no` int(11) NOT NULL COMMENT '회원번호',
  `post_no` int(11) DEFAULT NULL COMMENT '게시글 번호',
  `co_no` int(11) DEFAULT NULL COMMENT '댓글 번호',
  `repo_datetime` datetime DEFAULT NULL COMMENT '신고 접수 일자',
  PRIMARY KEY (`repo_no`),
  KEY `FK_post_TO_report` (`post_no`),
  KEY `FK_comment_TO_report` (`co_no`),
  KEY `FK_member_TO_report` (`mb_no`),
  CONSTRAINT `FK_comment_TO_report` FOREIGN KEY (`co_no`) REFERENCES `comment` (`co_no`),
  CONSTRAINT `FK_member_TO_report` FOREIGN KEY (`mb_no`) REFERENCES `member` (`mb_no`),
  CONSTRAINT `FK_post_TO_report` FOREIGN KEY (`post_no`) REFERENCES `post` (`post_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='신고접수';



# Dump of table resources
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resources`;

CREATE TABLE `resources` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(20) DEFAULT NULL COMMENT '리소스 이름',
  `resource_type` varchar(20) DEFAULT NULL COMMENT '리소스 종류',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;

INSERT INTO `resources` (`resource_id`, `resource_name`, `resource_type`)
VALUES
	(1,'/intranet/**','url'),
	(2,'/member/**','url'),
	(22,'/board/33/**','url'),
	(32,'/board/34/**','url'),
	(33,'/board/42/**','url'),
	(34,'/board/43/**','url'),
	(35,'/board/44/**','url');

/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table review
# ------------------------------------------------------------

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `post_no` int(11) NOT NULL COMMENT '게시글 번호',
  `roo_no` int(11) DEFAULT NULL COMMENT '숙소번호',
  `re_rate_loc` int(4) DEFAULT NULL COMMENT '별점후기_위치',
  `re_rate_clean` int(4) DEFAULT NULL COMMENT '별점후기_위생',
  `re_rate_comu` int(4) DEFAULT NULL COMMENT '별점후기_의사소통',
  `re_rate_chip` int(4) DEFAULT NULL COMMENT '별점후기_가성비',
  `re_vsdate` date DEFAULT NULL COMMENT '숙소 방문 일자',
  `re_push_pl` text COMMENT '주변추천',
  `re_push_npl` text COMMENT '비추',
  PRIMARY KEY (`post_no`),
  CONSTRAINT `FK_post_TO_review` FOREIGN KEY (`post_no`) REFERENCES `post` (`post_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='리뷰 게시글';

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;

INSERT INTO `review` (`post_no`, `roo_no`, `re_rate_loc`, `re_rate_clean`, `re_rate_comu`, `re_rate_chip`, `re_vsdate`, `re_push_pl`, `re_push_npl`)
VALUES
	(92,25,0,0,0,0,'2021-10-12','숲속 산장에 와 있는 것처럼 조용하게 경치를 즐길 수 있는 곳이어서 좋았어요.','나쁜 점 없었어요!'),
	(93,26,0,0,0,0,'2021-04-14','여기 조식 맛집임. 바닷가 근처여서 물놀이 하기에 좋음','커플단위보다는 가족단위에 추천드려요.'),
	(94,27,0,0,0,0,'2022-01-18','솔비치 내에 이탈리안 레스토랑 마마티라 뷰 맛집이에요 추천합니다.','겨울이라 많이 춥더라구요. 추위 많이 타시면 별로일 것 같아요.'),
	(95,28,0,0,0,0,'2022-01-01','그냥 주변 곳곳이 뷰가 끝내주는 곳 입니다.','비위생적이라 깨끗한거 조용한 거 싫어하시는 분들에게는 비추합니다.'),
	(96,29,5,5,5,5,'2021-12-24','글에 있어요!','비추천할만한 게 없었어요'),
	(97,30,0,0,0,0,'2021-12-21','잘 모르겠어요.','가성비를 좋아하시면 별로에요'),
	(102,35,0,0,0,0,'2022-01-10','교통이 불편해요','조용한 거 싫어하시는 분들에게는 비추합니다.'),
	(103,36,0,0,0,0,NULL,'',''),
	(105,38,4,4,4,5,'2022-01-13','유명한 카페','위생 별로에요'),
	(108,41,5,5,4,3,'2022-01-04','주변에 유명한 카페가 있어요','가성비는 별로에요'),
	(111,43,4,4,5,5,NULL,'ㅈㄷㅈㄷ','ㅈㄷㅈㄷ'),
	(112,44,4,5,5,4,'2022-01-12','유명한 카페가 있어요','가성비는 별로'),
	(113,45,2,2,5,5,'2022-01-18','ㅇㄹ','ㅇㄹ');

/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_desc` int(11) DEFAULT NULL COMMENT '상위 등급',
  `role_name` varchar(20) DEFAULT NULL COMMENT '롤 이름',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`role_id`, `role_desc`, `role_name`)
VALUES
	(1,0,'ROLE_ADMIN'),
	(2,1,'ROLE_GRADE4'),
	(3,2,'ROLE_GRADE3'),
	(4,3,'ROLE_GRADE2'),
	(5,4,'ROLE_GRADE1');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role_resources
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role_resources`;

CREATE TABLE `role_resources` (
  `role_resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(20) DEFAULT NULL COMMENT '리소스 이름',
  `role_name` varchar(20) DEFAULT NULL COMMENT '롤 이름',
  PRIMARY KEY (`role_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role_resources` WRITE;
/*!40000 ALTER TABLE `role_resources` DISABLE KEYS */;

INSERT INTO `role_resources` (`role_resource_id`, `resource_name`, `role_name`)
VALUES
	(1,'/intranet/**','ROLE_ADMIN'),
	(6,'/member/**','ROLE_GRADE1'),
	(21,'/board/33/**','ROLE_GRADE2'),
	(34,'/board/34/**','ROLE_GRADE3'),
	(35,'/board/42/**','ROLE_GRADE2'),
	(36,'/board/43/**','ROLE_GRADE1'),
	(37,'/board/44/**','ROLE_GRADE1');

/*!40000 ALTER TABLE `role_resources` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
