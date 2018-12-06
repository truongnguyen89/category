USE football;

DROP TABLE IF EXISTS `match`;
CREATE TABLE `match` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_sub_stadium_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi sub stadium',
  `n_match_schedule_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi match_schedule, lich cua san bong',
  `n_price` bigint(11) NOT NULL DEFAULT '600000' COMMENT 'gia thue cho san nay khung gio nay',
  `n_type` int(2) NOT NULL DEFAULT '1' COMMENT 'loai tran dau',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `match_sub_stadium_fk` FOREIGN KEY (`n_sub_stadium_id`) REFERENCES `sub_stadium` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `match_match_schedule_fk` FOREIGN KEY (`n_match_schedule_id`) REFERENCES `match_schedule` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

