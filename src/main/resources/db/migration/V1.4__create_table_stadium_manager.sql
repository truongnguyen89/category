USE football;

DROP TABLE IF EXISTS `stadium_manager`;
CREATE TABLE `stadium_manager` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_user_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi user, nguoi quan ly san bong',
  `n_stadium_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi stadium',
  `n_type` int(2) NOT NULL DEFAULT '1' COMMENT 'loai nguoi quan ly, pho hay truong, chu hay lam thue',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `manager_user_fk` FOREIGN KEY (`n_user_id`) REFERENCES `user` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `manager_stadium_fk` FOREIGN KEY (`n_stadium_id`) REFERENCES `stadium` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

