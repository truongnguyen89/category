USE football;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_username` varchar(50) NOT NULL COMMENT 'tai khoan dang nhap',
  `s_password` varchar(100) NOT NULL COMMENT 'mat khau',
  `s_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'ten hien thi',
  `s_email` varchar(100) COMMENT 'email',
  `s_phone` varchar(50) NOT NULL DEFAULT '0987654321' COMMENT 'SDT',
  `s_address` varchar(200) COLLATE utf8_unicode_ci COMMENT 'dia chi',
  `n_type` int(2) NOT NULL DEFAULT '1' COMMENT 'loai tai khoan',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
