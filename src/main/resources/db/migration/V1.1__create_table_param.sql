USE football;
DROP TABLE IF EXISTS `params`;
CREATE TABLE `params` (
  `s_type` varchar(200) NOT NULL COMMENT 'loai tham so',
  `s_code` varchar(200) NOT NULL DEFAULT '1' COMMENT 'ma tham so',
  `s_name` varchar(2000) COLLATE utf8_unicode_ci DEFAULT 'Ten tham so' COMMENT 'ten tham so',
  `s_value` varchar(3000) COLLATE utf8_unicode_ci NOT NULL DEFAULT '1' COMMENT 'gia tri tham so',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
