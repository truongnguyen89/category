USE football;

DROP TABLE IF EXISTS `sub_stadium`;
CREATE TABLE `sub_stadium` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_stadium_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi stadium',
  `s_number` varchar(20) NOT NULL COMMENT 'san so may',
  `n_length` int(3) DEFAULT '100' COMMENT 'chieu dai san, don vi tinh bang met',
  `n_width` int(3) DEFAULT '50' COMMENT 'chieu rong san, don vi tinh bang met',
  `n_type` int(2) NOT NULL DEFAULT '1' COMMENT 'san bong may nguoi',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `sub_stadium_fk` FOREIGN KEY (`n_stadium_id`) REFERENCES `stadium` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

