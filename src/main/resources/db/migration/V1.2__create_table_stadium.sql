USE football;

DROP TABLE IF EXISTS `stadium`;
CREATE TABLE `stadium` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT 'ten san bong da',
  `s_address` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT 'dia chi',
  `s_email` varchar(100) COMMENT 'email',
  `s_phone` varchar(500) NOT NULL COMMENT 'SDT',
  `s_longitude` varchar(100) DEFAULT '21.020093' COMMENT 'kinh do',
  `s_latitude` varchar(100) DEFAULT '105.764075' COMMENT 'vi do',
  `n_count_sub_stadium` int(2) NOT NULL DEFAULT '1' COMMENT 'so san con',
  `n_type` int(2) NOT NULL DEFAULT '1' COMMENT 'loai san bong',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `stadium` (`n_id`,`s_name`,`s_address`,`s_email`,`s_phone`,`s_longitude`,`s_latitude`,`n_count_sub_stadium`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (1,'Sân bóng Thành Phát','Hoàng Minh Giám','thanhphat@gmail.com','0989666777','21.898989','105.787878',4,1,1,sysdate(),NULL);
INSERT INTO `stadium` (`n_id`,`s_name`,`s_address`,`s_email`,`s_phone`,`s_longitude`,`s_latitude`,`n_count_sub_stadium`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (2,'Sân bóng Thuỷ Lợi','Đại Học Thuỷ Lợi','thuyloi@gmail.com','0989666777','21.898989','105.787878',4,1,1,sysdate(),NULL);
INSERT INTO `stadium` (`n_id`,`s_name`,`s_address`,`s_email`,`s_phone`,`s_longitude`,`s_latitude`,`n_count_sub_stadium`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (3,'Sân bóng Định Công','Định Công','dinhcong@gmail.com','0989666777','21.898989','105.787878',4,1,1,sysdate(),NULL);
INSERT INTO `stadium` (`n_id`,`s_name`,`s_address`,`s_email`,`s_phone`,`s_longitude`,`s_latitude`,`n_count_sub_stadium`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (4,'Sân bóng Hai Bà Trưng','Hai Bà Trưng','haibatrung@gmail.com','0989666777','21.898989','105.787878',4,1,1,sysdate(),NULL);
