USE football;

CREATE TABLE `user` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_username` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'tai khoan dang nhap',
  `s_password` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '1' COMMENT 'mat khau',
  `s_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'ten hien thi',
  `s_email` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '1' COMMENT 'email',
  `s_phone` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'SDT',
  `s_address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'dia chi',
  `n_type` int(2) NOT NULL DEFAULT '5' COMMENT 'loai tai khoan',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime DEFAULT NULL,
  `d_updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
