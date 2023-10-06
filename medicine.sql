CREATE TABLE `address`  (
  `id` UUID NOT NULL,
  `city` varchar(255) NULL,
  `country` varchar(255) NULL,
  `id_province` varchar(255) NULL,
  `line1` varchar(255) NULL,
  `line2` varchar(255) NULL,
  `name` varchar(255) NULL,
  `code` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `cart`  (
  `id` UUID NOT NULL,
  `customers_id` UUID NULL,
  `session_id` int NULL,
  `token` varchar(255) NULL,
  `status` varchar(255) NULL COMMENT 'new, cart, checkout, paid, complete, abandones',
  `content` varchar(255) NULL,
  `quantity` int NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `cart_item`  (
  `product_id` UUID NOT NULL,
  `cart_id` UUID NULL,
  `sku` varchar(255) NULL,
  `price` decimal(10, 2) NULL,
  `discount` varchar(255) NULL,
  `active` varchar(255) NULL,
  `content` varchar(255) NULL,
  PRIMARY KEY (`product_id`)
);

CREATE TABLE `category`  (
  `id` UUID NOT NULL,
  `parent_id` int NULL,
  `title` varchar(255) NULL,
  `meta_title` varchar(255) NULL,
  `slug` varchar(255) NULL,
  `content` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `commune`  (
  `id` UUID NOT NULL,
  `id_district` varchar(255) NULL,
  `name` varchar(255) NULL,
  `code` varchar(255) NULL,
  `zip` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `customer`  (
  `id` UUID NOT NULL,
  `first_name` varchar(255) NULL,
  `mid_name` varchar(255) NULL,
  `lastname` varchar(255) NULL,
  `mobile` varchar(255) NULL,
  `email` varchar(255) NULL,
  `password` varchar(255) NULL,
  `admin` varchar(255) NULL,
  `vendor` varchar(255) NULL,
  `registered_at` timestamp NULL,
  `last_login` varchar(255) NULL,
  `intro` varchar(255) NULL,
  `profile` varchar(255) NULL,
  `id_address` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `customers`  ();

CREATE TABLE `district`  (
  `id` UUID NOT NULL,
  `id_province` varchar(255) NULL,
  `name` varchar(255) NULL,
  `code` varchar(255) NULL,
  `zip` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `oauth_acces_token`  (
  `token_id` varchar(255) NOT NULL,
  `token` long NULL,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255) NULL,
  `client_id` int NULL,
  `authentication` long NULL,
  `refresh_token` varchar(255) NULL,
  PRIMARY KEY (`authentication_id`)
);

CREATE TABLE `oauth_approvals`  (
  `userId` int NOT NULL,
  `clientId` int NULL,
  `scope` varchar(255) NULL,
  `status` varchar(10) NULL,
  `expiresAt` timestamp NULL,
  `lastModifierAt` timestamp NULL,
  PRIMARY KEY (`userId`)
);

CREATE TABLE `oauth_client_token`  (
  `token_id` varchar(255) NOT NULL,
  `token` long NULL,
  `authentication_id` varchar(255) NULL,
  `user_name` varchar(255) NULL,
  `client_id` int NULL,
  PRIMARY KEY (`token_id`)
);

CREATE TABLE `oauth_code`  (
  `code` varchar(255) NULL,
  `authentication` long NULL
);

CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(255) NOT NULL,
  `token` long NULL,
  `authentication` long NULL,
  PRIMARY KEY (`token_id`)
);

CREATE TABLE `order`  (
  `id` UUID NOT NULL,
  `customers_id` UUID NOT NULL,
  `session_id` int NULL,
  `token` varchar(255) NULL,
  `status` varchar(255) NULL,
  `sub_total` varchar(255) NULL,
  `item_discount` varchar(255) NULL,
  `tax` varchar(255) NULL,
  `shipping` varchar(255) NULL,
  `total` varchar(255) NULL,
  `promo` varchar(255) NULL,
  `discount` varchar(255) NULL,
  `id_address` varchar(255) NULL,
  `grand_total` varchar(255) NULL,
  `content` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `order_item`  (
  `product_id` UUID NOT NULL,
  `order_id` UUID NULL,
  `sku` varchar(255) NULL,
  `price` decimal(10, 2) NULL,
  `discount` varchar(255) NULL,
  `quantity` varchar(255) NULL,
  `content` varchar(255) NULL,
  PRIMARY KEY (`product_id`)
);

CREATE TABLE `ouath_client_details`  (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) NULL,
  `client_secret` varchar(255) NULL,
  `scope` varchar(255) NULL,
  `authorized_grant_types` varchar(255) NULL,
  `web_server_redirect_uri` varchar(255) NULL,
  `authorities` varchar(255) NULL,
  `access_token_validity` integer NULL,
  `refresh_token_validity` integer NULL,
  `additional_information` varchar(4096) NULL,
  `autoapprove` varchar(255) NULL,
  PRIMARY KEY (`client_id`)
);

CREATE TABLE `product`  (
  `id` UUID NOT NULL,
  `user_id` int NULL,
  `title` varchar(255) NULL,
  `meta_title` varchar(255) NULL,
  `slug` varchar(255) NULL COMMENT 'slug from url',
  `sumary` varchar(255) NULL,
  `type` varchar(255) NULL,
  `sku` varchar(255) NULL,
  `price` decimal(10, 2) NULL,
  `discount` varchar(255) NULL,
  `quantity` varchar(255) NULL,
  `shop` varchar(255) NULL,
  `published_at` varchar(255) NULL,
  `start_at` varchar(255) NULL,
  `end_at` varchar(255) NULL,
  `content` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product_category`  (
  `id` UUID NOT NULL,
  `product_id` UUID NULL,
  `category_id` UUID NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product_meta`  (
  `id` UUID NOT NULL,
  `product_id` int NULL,
  `key` varchar(255) NULL,
  `content` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product_thietbi_preview`  (
  `id` UUID NOT NULL,
  `product_id` int NULL,
  `parent_id` int NULL,
  `title` varchar(255) NULL,
  `rating` varchar(255) NULL,
  `published_at` varchar(255) NULL,
  `published` varchar(255) NULL,
  `content` varchar(255) NULL,
  `file` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product_thuoc_preview`  (
  `id` UUID NOT NULL,
  `product_id` int NULL,
  `parent_id` int NULL,
  `title` varchar(255) NULL,
  `rating` varchar(255) NULL,
  `published_at` varchar(255) NULL,
  `published` varchar(255) NULL,
  `content` varchar(255) NULL,
  `file` varchar(255) NULL,
  `cong_dung` varchar(255) NULL,
  `doi_tuong_su_dung` varchar(255) NULL,
  `thuong_hieu` varchar(255) NULL,
  `nha_san__xuat` varchar(255) NULL,
  `noi_san_xuat` varchar(255) NULL,
  `dang_bao_che` varchar(255) NULL,
  `cach_dong_goi` varchar(255) NULL,
  `han_dung` varchar(255) NULL,
  `kich_thuoc` varchar(255) NULL,
  `trong_luong` varchar(255) NULL,
  `pham_vi_do` varchar(255) NULL,
  `phu_kien_kem_theo` varchar(255) NULL,
  `do_chinh_xac` varchar(255) NULL,
  `khac` varchar(255) NULL,
  `type` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `province`  (
  `id` UUID NOT NULL,
  `name` varchar(255) NULL,
  `code` varchar(255) NULL,
  `zip` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `transaction`  (
  `id` UUID NOT NULL,
  `customers_id` int NULL,
  `order_id` int NULL,
  `code` varchar(255) NULL,
  `type` varchar(255) NULL,
  `mode` varchar(255) NULL COMMENT 'offline, cod, cheque, draft, wired, online',
  `status` varchar(255) NULL COMMENT 'new, cancel, fail, pending, declined, reject, sucsess',
  `content` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `address` ADD CONSTRAINT `fk_address_province_1` FOREIGN KEY (`id_province`) REFERENCES `province` (`id`);
ALTER TABLE `address` ADD CONSTRAINT `fk_address_customer_1` FOREIGN KEY (`id`) REFERENCES `customer` (`id_address`);
ALTER TABLE `cart` ADD CONSTRAINT `fk_cart_cart_item_1` FOREIGN KEY (`id`) REFERENCES `cart_item` (`cart_id`);
ALTER TABLE `cart` ADD CONSTRAINT `fk_cart_customer_1` FOREIGN KEY (`customers_id`) REFERENCES `customer` (`id`);
ALTER TABLE `category` ADD CONSTRAINT `fk_category_product_category_1` FOREIGN KEY (`id`) REFERENCES `product_category` (`category_id`);
ALTER TABLE `customer` ADD CONSTRAINT `fk_customer_order_1` FOREIGN KEY (`id`) REFERENCES `order` (`customers_id`);
ALTER TABLE `customer` ADD CONSTRAINT `fk_customer_transaction_1` FOREIGN KEY (`id`) REFERENCES `transaction` (`customers_id`);
ALTER TABLE `district` ADD CONSTRAINT `fk_district_commune_1` FOREIGN KEY (`id`) REFERENCES `commune` (`id_district`);
ALTER TABLE `order` ADD CONSTRAINT `fk_order_order_item_1` FOREIGN KEY (`id`) REFERENCES `order_item` (`order_id`);
ALTER TABLE `order` ADD CONSTRAINT `fk_order_transaction_1` FOREIGN KEY (`id`) REFERENCES `transaction` (`order_id`);
ALTER TABLE `product` ADD CONSTRAINT `fk_product_product_meta_1` FOREIGN KEY (`id`) REFERENCES `product_meta` (`product_id`);
ALTER TABLE `product` ADD CONSTRAINT `fk_product_product_preview_1` FOREIGN KEY (`id`) REFERENCES `product_thuoc_preview` (`product_id`);
ALTER TABLE `product` ADD CONSTRAINT `fk_product_product_category_1` FOREIGN KEY (`id`) REFERENCES `product_category` (`product_id`);
ALTER TABLE `product` ADD CONSTRAINT `fk_product_order_item_1` FOREIGN KEY (`id`) REFERENCES `order_item` (`product_id`);
ALTER TABLE `product` ADD CONSTRAINT `fk_product_cart_item_1` FOREIGN KEY (`id`) REFERENCES `cart_item` (`product_id`);
ALTER TABLE `province` ADD CONSTRAINT `fk_province_district_1` FOREIGN KEY (`id`) REFERENCES `district` (`id_province`);

