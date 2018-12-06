USE football;

DROP TABLE IF EXISTS `match_schedule`;
CREATE TABLE `match_schedule` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_start_time` varchar(5) NOT NULL COMMENT 'khung gio bat dau tran dau, dinh dang HH:mi',
  `s_end_time` varchar(5) NOT NULL COMMENT 'khung gio ket thuc tran dau, dinh dang HH:mi',
  `n_type` int(2) NOT NULL DEFAULT '1' COMMENT 'loai khung gio, sau nay tinh phi',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

