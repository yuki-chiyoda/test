set names utf8;
set foreign_key_checks = 0;

-- glanqデータベース作成
drop database if exists glanq;
create database if not exists glanq;

use glanq;

-- 会員情報テーブル作成
/*
 * 備考
 * IDはpk, auto_increment
 * ユーザーIDはunique
 * 性別は0:男性、1:女性
 * ステータスは0:無効、1:有効
 * ログインフラグは0:未ログイン、1:ログイン済
 *
 */

create table user_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) unique not null comment "ユーザーID",
password varchar(16) not null comment "パスワード",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
sex tinyint not null default 0 comment "性別",
email varchar(32) not null comment "メールアドレス",
status tinyint not null default 0 comment "ステータス",
logined tinyint not null default 0 comment "ログインフラグ",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
)

default charset=utf8
comment="会員情報テーブル";

-- 会員情報のinsert文を挿入
insert into user_info VALUES
(1, "guest", "guest", "インターノウス", "ゲストユーザー", "いんたーのうす", "げすとゆーざー", 0, "guest@gmail.com", 0, 0, now(), now()),
(2, "guest2", "guest2", "インターノウス", "ゲストユーザー2", "いんたーのうす", "げすとゆーざー2", 0, "guest2@gmail.com", 0, 0, now(), now()),
(3, "guest3", "guest3", "インターノウス", "ゲストユーザー3", "いんたーのうす", "げすとゆーざー3", 0, "guest3@gmail.com", 0, 0, now(), now()),
(4, "guest4", "guest4", "インターノウス", "ゲストユーザー4", "いんたーのうす", "げすとゆーざー4", 0, "guest4@gmail.com", 0, 0, now(), now()),
(5, "guest5", "guest5", "インターノウス", "ゲストユーザー5", "いんたーのうす", "げすとゆーざー5", 0, "guest5@gmail.com", 0, 0, now(), now()),
(6, "guest6", "guest6", "インターノウス", "ゲストユーザー6", "いんたーのうす", "げすとゆーざー6", 0, "guest6@gmail.com", 0, 0, now(), now()),
(7, "guest7", "guest7", "インターノウス", "ゲストユーザー7", "いんたーのうす", "げすとゆーざー7", 0, "guest7@gmail.com", 0, 0, now(), now()),
(8, "guest8", "guest8", "インターノウス", "ゲストユーザー8", "いんたーのうす", "げすとゆーざー8", 0, "guest8@gmail.com", 0, 0, now(), now()),
(9, "guest9", "guest9", "インターノウス", "ゲストユーザー9", "いんたーのうす", "げすとゆーざー9", 0, "guest9@gmail.com", 0, 0, now(), now()),
(10, "guest10", "guest10", "インターノウス", "ゲストユーザー10", "いんたーのうす", "げすとゆーざー10", 0, "guest10@gmail.com", 0, 0, now(), now()),
(11, "guest11", "guest11", "インターノウス", "ゲストユーザー11", "いんたーのうす", "げすとゆーざー11", 0, "guest11@gmail.com", 0, 0, now(), now()),
(12, "guest12", "guest12", "インターノウス", "ゲストユーザー12", "いんたーのうす", "げすとゆーざー12", 0, "guest12@gmail.com", 0, 0, now(), now()),
(13, "guest13", "guest13", "インターノウス", "ゲストユーザー13", "いんたーのうす", "げすとゆーざー13", 0, "guest13@gmail.com", 0, 0, now(), now()),
(14, "guest14", "guest14", "インターノウス", "ゲストユーザー14", "いんたーのうす", "げすとゆーざー14", 0, "guest14@gmail.com", 0, 0, now(), now()),
(15, "admin", "admin", "インターノウス", "管理者ユーザー", "いんたーのうす", "かんりしゃゆーざー", 0, "admin@gmail.com", 1, 0, now(), now()),
(16, "admin2", "admin2", "インターノウス", "管理者ユーザー2", "いんたーのうす", "かんりしゃゆーざ2ー", 0, "admin2@gmail.com", 1, 0, now(), now()),
(17, "admin3", "admin3", "インターノウス", "管理者ユーザー3", "いんたーのうす", "かんりしゃゆーざー3", 0, "admin3@gmail.com", 1, 0, now(), now()),
(18, "admin4", "admin4", "インターノウス", "管理者ユーザー4", "いんたーのうす", "かんりしゃゆーざー4", 0, "admin4@gmail.com", 1, 0, now(), now()),
(19, "admin5", "admin5", "インターノウス", "管理者ユーザー5", "いんたーのうす", "かんりしゃゆーざー5", 0, "admin5@gmail.com", 1, 0, now(), now()),
(20, "admin6", "admin6", "インターノウス", "管理者ユーザー6", "いんたーのうす", "かんりしゃゆーざー6", 0, "admin6@gmail.com", 1, 0, now(), now()),
(21, "admin7", "admin7", "インターノウス", "管理者ユーザー7", "いんたーのうす", "かんりしゃゆーざー7", 0, "admin7@gmail.com", 1, 0, now(), now()),
(22, "admin8", "admin8", "インターノウス", "管理者ユーザー8", "いんたーのうす", "かんりしゃゆーざー8", 0, "admin8@gmail.com", 1, 0, now(), now()),
(23, "admin9", "admin9", "インターノウス", "管理者ユーザー9", "いんたーのうす", "かんりしゃゆーざー9", 0, "admin9@gmail.com", 1, 0, now(), now()),
(24, "admin10", "admin10", "インターノウス", "管理者ユーザー10", "いんたーのうす", "かんりしゃゆーざー10", 0, "admin10@gmail.com", 1, 0, now(), now()),
(25, "admin11", "admin11", "インターノウス", "管理者ユーザー11", "いんたーのうす", "かんりしゃゆーざー11", 0, "admin11@gmail.com", 1, 0, now(), now()),
(26, "admin12", "admin12", "インターノウス", "管理者ユーザー12", "いんたーのうす", "かんりしゃゆーざー12", 0, "admin12@gmail.com", 1, 0, now(), now()),
(27, "admin13", "admin13", "インターノウス", "管理者ユーザー13", "いんたーのうす", "かんりしゃゆーざー13", 0, "admin12@gmail.com", 1, 0, now(), now()),
(28, "admin14", "admin14", "インターノウス", "管理者ユーザー14", "いんたーのうす", "かんりしゃゆーざー14", 0, "admin12@gmail.com", 1, 0, now(), now()),
(29, "test", "123", "シナリオ", "試験", "しなりお", "しけん", 0, "shinario1@gmail.com", 0, 0, now(), now()),
(30, "123", "test", "シナリオ", "試験", "しなりお", "しけん", 0, "shinario2@gmail.com", 0, 0, now(), now()),
(31, "test123", "test123", "シナリオ", "試験", "しなりお", "しけん", 0, "shinario3@gmil.com", 0, 0, now(), now()),
(32, "a", "test", "シナリオ", "試験", "しなりお", "しけん", 0, "shinario4@gmil.com", 0, 0, now(), now()),
(33, "aaaaaaaa", "test", "シナリオ", "試験", "しなりお", "しけん", 0, "shinario5@gmil.com", 0, 0, now(), now()),
(34, "test2", "a", "シナリオ", "試験", "しなりお", "しけん", 0, "shinario6@gmil.com", 0, 0, now(), now()),
(35, "test3", "aaaaaaaaaaaaaaaa", "シナリオ", "試験", "しなりお", "しけん", 0, "shinario7@gmil.com", 0, 0, now(), now());
-- 商品情報テーブル作成
/*
 * 備考
 * IDはpk, auto_increment
 * product_id, _name, _name_kanaはunique
 * カテゴリIDはm_categoryのcategory_idとfk
 * ステータスは0:無効、1:有効
 */

create table product_info(
id int primary key not null auto_increment comment "ID",
product_id int unique not null comment "商品ID",
product_name varchar(100) unique not null comment "商品名",
product_name_kana varchar(100) unique not null comment "商品名かな",
product_description varchar(255) not null comment "商品詳細",
category_id int not null not null comment "カテゴリID",
price int comment "価格",
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名",
release_date datetime not null comment "発売年月",
release_company varchar(50) comment "発売会社",
status tinyint not null default 0 comment "ステータス",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日",
foreign key(category_id) references m_category(category_id)
)

default charset=utf8
comment="商品情報テーブル";

-- 商品情報のinsert文を挿入

insert into product_info values
( 1, 1,"カルビ","かるび","カルビ 1人前(200g)",2,500,"./images","karubi.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 2, 2,"ロース","ろーす","ロース 1人前(200g)",2,500,"./images","ro-su.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 3, 3,"ホルモン","ほるもん","ホルモン 1人前(50g)",2,100,"./images","horumon.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 4, 4,"サーロイン","さーろいん","サーロイン 1人前(120g)",2,1000,"./images","sa-roin.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 5, 5,"豚バラ","ぶたばら","豚バラ 1人前(100g)",2,200,"./images","butabara.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 6, 6,"スペアリブ","すぺありぶ","スペアリブ 1人前(350g)",2,800,"./images","supearibu.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 7, 7,"鶏もも","とりもも","鶏もも 1人前(100g)",2,150,"./images","torimomo.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 8, 8,"ウインナー","ういんなー","ウインナー 1人前(150g)",2,300,"./images","so-se-zi.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 9, 9,"玉ねぎ串","たまねぎぐし","玉ねぎ串 (5本入) ",3,100,"./images","tamanegi.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 10, 10,"ピーマン","ぴーまん","ピーマン(1個)",3,40,"./images","pi-man.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 11, 11,"コーン","こーん","コーン(2本入)",3,300,"./images","toumorokoshi.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 12, 12,"エリンギ","えりんぎ","エリンギ(3個)",3,120,"./images","eringi.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 13, 13,"ジャガイモ","じゃがいも","ジャガイモ(1個)",3,40,"./images","zyagaimo.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 14, 14,"ニンジン","にんじん","ニンジン(1本)",3,40,"./images","ninzin.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 15, 15,"お手軽野菜セット","おてがるやさいせっと","お手軽野菜セット(2人前)",3,700,"./images","yasaiset.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 16, 16,"ギガ盛お肉セット","ぎがもりおにくせっと","ギガ盛お肉セット(4人前)",2,3000,"./images","niku4ninmae.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 17, 17,"BBQコンロ","ばーべきゅーこんろ","BBQコンロ",4,5000,"./images","bbqkonro.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 18, 18,"木炭","もくたん","木炭(3kg)",4,500,"./images","mokutan.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 19, 19,"テーブル","てーぶる","テーブル(1個)",4,5000,"./images","table.jpg",now(),"コマちゃんハウス",0,now(),now()),
( 20, 20,"アームチェア","あーむちぇあ","アームチェア(1個)",4,2000,"./images","isu.jpg",now(),"コマちゃんハウス",0,now(),now());

-- カート情報テーブルを作成
/*
 * 備考
 * IDはpk, auto_increment
 */

create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
temp_user_id varchar(16) comment "仮ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)

default charset=utf8
comment="カート情報テーブル";

-- 購入履歴情報テーブルを作成
/*
 * 備考
 * IDはpk, auto_increment
 * product_idはproduct_infoのproduct_idとfk
 */

create table purchase_history_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
destination_id int not null comment "宛先情報ID",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日",
foreign key(product_id) references product_info(product_id)
)

default charset=utf8
comment="購入履歴情報テーブル";

-- 宛先情報テーブルの作成
/*
 * 備考
 * IDはpk, auto_increment
 */

create table destination_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
email varchar(32) not null comment "メールアドレス",
tel_number varchar(13) not null comment "電話番号",
user_address varchar(50) not null comment "住所",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
)

default charset=utf8
comment="宛先情報テーブル";

-- 宛先情報のinsert文を挿入
insert into destination_info values
(1,"admin","GLANQコーポレーション","コマバーベキュー場","ぐらんきゅーこーぽれーしょん","こまばーべきゅーじょう","glamqpark@internous.co.jp","090-1234-5678","東京都千代田区半蔵門公園",now(),now()),
(2,"admin","株式会社GLANQ","GLANQ場","かぶしきがいしゃぐらんきゅー","ぐらんきゅーじょう","glanqpark@internous.co.jp","090-9785-5678","東京都東京市東京タワー公園",now(),now()),
(3,"admin","GLANQ商会","駒バーベキュー場","ぐらんきゅーしょうかい","こまばーべきゅーじょう","bbqpark@internous.co.jp","090-1234-7263","埼玉県さいたま市埼玉公園",now(),now()),
(4,"guest","インターノウス","テストユーザー","いんたーのうす","てすとゆーざー","guest@internous.co.jp","090-1234-5678","東京都千代田区三番町１ー１　ＫＹ三番町ビル１Ｆ",now(),now());

-- カテゴリマスターテーブルの作成
/*
 * IDはpk
 * category_id, _nameはunique
 */


create table m_category(
id int primary key not null comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)

default charset=utf8
comment="カテゴリマスタテーブル";

-- カテゴリのinsert文を挿入
insert into m_category values
(1,1,"全てのカテゴリー","肉、野菜、機材全てのカテゴリーが対象となります",now(), null),
(2,2,"肉","肉に関するカテゴリーが対象となります",now(),null),
(3,3,"野菜","野菜に関するカテゴリーが対象となります",now(),null),
(4,4,"機材","機材に関するカテゴリーが対象となります",now(),null);