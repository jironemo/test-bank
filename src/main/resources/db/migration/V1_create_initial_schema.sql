
CREATE TABLE `merchant_information` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` varchar(255) DEFAULT NULL,
  `merchant_address` varchar(255) DEFAULT NULL,
  `merchant_code` varchar(255) DEFAULT NULL,
  `merchant_name` varchar(255) DEFAULT NULL,
  `org_name` varchar(255) DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `user_account_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8so8kl9lj9l2clj7j37ftjpva` (`user_account_id`),
  UNIQUE KEY `UKi255693i3vilxej4v1p5k295f` (`merchant_code`),
  CONSTRAINT `FKd56mvth5noa7vdalm9ofogc6d` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`),
  CONSTRAINT `merchant_information_chk_1` CHECK ((`status` between 0 and 2))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;