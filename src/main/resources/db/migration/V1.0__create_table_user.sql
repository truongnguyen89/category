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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `football`.`user` (`n_id`, `s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `d_created_at`)
VALUES ('1', 'truongnq', '123456', 'Nguyễn Quang Trường', 'truongnq@gmail.com', '0962266682', 'Hà Nội', '1', '1', sysdate());
INSERT INTO `football`.`user` (`n_id`, `s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `d_created_at`)
VALUES ('2', 'truongnq2', '123456', 'Nguyễn Quang Trường 2', 'truongnq2@gmail.com', '0962266682', 'Hà Nội', '1', '1', sysdate());
INSERT INTO `football`.`user` (`n_id`, `s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `d_created_at`)
VALUES ('3', 'truongnq3', '123456', 'Nguyễn Quang Trường 3', 'truongnq3@gmail.com', '0962266682', 'Hà Nội', '1', '1', sysdate());
INSERT INTO `football`.`user` (`n_id`, `s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `d_created_at`)
VALUES ('4', 'truongnq4', '123456', 'Nguyễn Quang Trường 4', 'truongnq4@gmail.com', '0962266682', 'Hà Nội', '1', '1', sysdate());
