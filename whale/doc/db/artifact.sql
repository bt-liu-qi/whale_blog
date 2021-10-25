/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.31.105
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 192.168.31.105:3307
 Source Schema         : artifact

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 25/10/2021 22:55:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标题',
  `sort_id` int(11) NULL DEFAULT NULL COMMENT '分类',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `cover_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '封面',
  `sketch` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '简介',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文章作者',
  `is_comment` int(2) NULL DEFAULT NULL COMMENT '是否开启评论',
  `comment_count` int(255) NULL DEFAULT NULL COMMENT '评论数',
  `pv` bigint(255) NULL DEFAULT NULL COMMENT '浏览量',
  `publish_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `is_del` int(2) NOT NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '博客' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (1, '小说中反派人物的塑造', 1, 0, '', '最近在精英群（QQ：107124703）中看到有人问到这样一个问题，就是表格中记录的编号是英文与数字杂合的，如果要批量加上或减去一个数值，不知道怎么做了。下面，我就在Excel2010中为...', '107124703', 0, 1, 1, '2021-10-22 21:55:54', 1, '2021-10-22 21:55:57', '2021-10-22 21:56:00', NULL, 0);
INSERT INTO `t_blog` VALUES (2, '什么！蘑菇博客在国庆期间仅有1人访问？', 2, 0, '', '最近在精英群（QQ：107124703）中看到有人问到这样一个问题，就是表格中记录的编号是英文与数字杂合的，如果要批量加上或减去一个数值，不知道怎么做了。下面，我就在Excel2010中为...', '107124703', 0, 1, 1, '2021-10-22 21:55:54', 1, '2021-10-22 21:55:57', '2021-10-22 21:56:00', NULL, 0);
INSERT INTO `t_blog` VALUES (1452543970397941762, '关于蘑菇博客如何不与宝塔冲突', 1, 1, '', '还记得，我第一次搭建蘑菇时只有一台2C4G的服务器，当时服务器上面用的是宝塔面板，跑着两个PHP的网站，为了让二者共存当时就修改了一下各自的端口，后来又发现其他小伙伴，遇到了相似的问题于是就将这篇文章整理了出来。', '泪梦红尘', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_blog` VALUES (1452614326856990722, 'Kubernetes控制器Controller详解', 1, 0, '', ' Kubernetes控制器Controller详解', '陌溪_', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_blog_content
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_content`;
CREATE TABLE `t_blog_content`  (
  `id` bigint(20) NOT NULL COMMENT '文章id',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '文章内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_blog_content
-- ----------------------------
INSERT INTO `t_blog_content` VALUES (1, '<p>最近在精英群（QQ：107124703）中看到有人问到这样一个问题，就是表格中记录的编号是英文与数字杂合的，如果要批量加上或减去一个数值，不知道怎么做了。下面，我就在Excel2010中为...</p>');
INSERT INTO `t_blog_content` VALUES (2, '<p>不会吧，国庆竟然没有人访问蘑菇博客？说好的国庆一起在家卷，结果小伙伴们都出去玩了么？抱着对这个数据质疑的态度，陌溪找到了蘑菇博客 PV 和 UV 的显示面板。 PV (page view)：页面浏览量 UV(unique visitor)：浏览网页的人数 image-20211003100047131 结果发现，从 9 月 28 号以后的 IP 数就一直为 1 个，但是访问量却还是正常的，按道理这个访问量应该不可能都是1 个用户产生的。同时查看用户访问记录，发现后台只有一个访问 IP，并且该 ip 地址都是自己云服务器的地址。 image-20211003122235478 抱着排查错误的想法，陌溪定位了以下几个可能出错的场景 获取 IP 的接口出错 Nginx 出现问题 云服务器故障 故障排查 客户端的请求信息都包含在 HttpServletRequest 中，同时客户端访问服务器一般分为两种情况 客户端不经过代理，直接连接服务器 客户端经过多级代理，最终到达服务器 若客户端不经过代理，直接连接服务器，可以通过 getRemoteAddr() 方法获取该客户端的 IP。 image-20211003102429995 若客户端经过多级代理（如 nginx），最终到达服务器，此时通过 getRemoteAddr() 方法是无法该客户端的 IP，只能获取到代理服务器的 IP 地址了。 此时，被 nginx 代理后，会通过 x-forwarded-for 把浏览器的真实 ip 地址以及代理服务器的 ip 地址记录下来。当客户端请求被转发的时候，IP将会被追加到 x-forwarded-for 字段的后面，并通过逗号进行隔开。 image-20211003111326555 因此，当通过 getRemoteAddr() 获取到 ip 地址的时候，会获取到最近的一个 nginx 地址，即 39.198.27.3，而非用户的真实浏览器 ip 地址 39.182.27.1。 若想获取到用户的真实 ip 地址，这个时候就需要解析HttpServletRequest 中 x-forwarded-for 字段的内容了。上面提到了，客户端经过转发，IP 将追加到其后，以逗号进行隔开。因此只需要把第一个逗号之前的 ip 地址获取出来，即可找到用户的真实 ip 地址了。 String ipAddress = request.getHeader(\"x-forwarded-for\"); if (ipAddress != null &amp;&amp; ipAddress.length() &gt; 15) { if (ipAddress.indexOf(\",\") &gt; 0) { ipAddress = ipAddress.substring(0, ipAddress.indexOf(\",\")); } } 完整的获取用户真实 ip 流程图如下所示 image-20211003114727659 首先是判断 Request 的请求头 Proxy-Client-IP 、WL-Proxy-Client-IP 以及 HTTP_CLIENT_IP 字段是否携带了用户的真实 ip 地址，若没有的话，在判断请求地址是否来源于本地，最后在从 x-forwarded-for 中解析出正式的 ip 地址。获取用户真实 ip 的方法如下： public static String getIpAddr(HttpServletRequest request) { String ipAddress = request.getHeader(\"x-forwarded-for\"); if (ipAddress == null || ipAddress.length() == 0 || \"unknown\".equalsIgnoreCase(ipAddress)) { ipAddress = request.getHeader(\"Proxy-Client-IP\"); return ipAddress; } if (ipAddress == null || ipAddress.length() == 0 || \"unknown\".equalsIgnoreCase(ipAddress)) { ipAddress = request.getHeader(\"WL-Proxy-Client-IP\"); return ipAddress; } if (ipAddress == null || ipAddress.length() == 0 || \"unknown\".equalsIgnoreCase(ipAddress)) { ipAddress = request.getHeader(\"HTTP_CLIENT_IP\"); return ipAddress; } if (ipAddress == null || ipAddress.length() == 0 || \"unknown\".equalsIgnoreCase(ipAddress)) { ipAddress = request.getRemoteAddr(); if (ipAddress.equals(\"127.0.0.1\") || ipAddress.equals(\"0:0:0:0:0:0:0:1\")) { //根据网卡取本机配置的IP InetAddress inet = null; try { inet = InetAddress.getLocalHost(); } catch (UnknownHostException e) { e.printStackTrace(); } ipAddress = inet.getHostAddress(); return ipAddress; } } //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照\',\'分割 if (ipAddress != null &amp;&amp; ipAddress.length() &gt; 15) { if (ipAddress.indexOf(\",\") &gt; 0) { ipAddress = ipAddress.substring(0, ipAddress.indexOf(\",\")); return ipAddress; } } return ipAddress; } 到这里，其实错误的问题就有些眉目了。首先获取 ip 的方法，是一直没有修改过的，因此不可能是代码问题，而造成 ip 获取异常的。陌溪回顾了一下 9 月 28 号左右发生的事情，发现我那会把蘑菇博客所有的页面都配置了域名的方式访问，因此还修改过对应的 nginx 配置文件。 image-20211003121230185 在还没配置域名访问的时候，前端接口在请求后台的时候，是直接通过 ip 地址 + 网关端口号来访问的，修改后是通过域名访问。 # 修改前 http://39.182.27.4:8607/mogu-picture # 修改后 http://gw.moguit.cn/mogu-picture 因为修改成了域名，就需要在 nginx 配置一下反向代理，请求到蘑菇博客的网关上。 server { listen 80; server_name gw.moguit.cn; location / { proxy_pass http://39.182.27.4:8607/; } } 最开始，陌溪其实是没有发现有什么问题的，但是后面通过查阅资料发现 nginx 在配置反向代理的时候，若想获取用户真实 ip，需要设置请求头 X-Real-IP 和 X-Forwarded-For，修改后的配置如下所示： server { listen 80; server_name gw.moguit.cn; location / { proxy_pass http://39.182.27.4:8607/; proxy_set_header Host $host; proxy_set_header X-Real-IP $remote_addr; proxy_set_header REMOTE-HOST $remote_addr; proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for; } } 到这里其实就已经破案了，如果没有在 nginx 上配置对应的请求头的话，获取到的是最近的一个代理服务器 nginx 所在 IP 地址，也就是云服务器的地址。 修改配置后，等待一段时间再次查看，已经能够显示不同的 ip 地址了image-20211003145738822 好了，本期就到这里啦，我是陌溪，我们下期再见~</p>');
INSERT INTO `t_blog_content` VALUES (1452543970397941762, '1213131');

-- ----------------------------
-- Table structure for t_blog_sort
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_sort`;
CREATE TABLE `t_blog_sort`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '分类名称',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `is_del` int(2) NOT NULL COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文章分类' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_blog_sort
-- ----------------------------
INSERT INTO `t_blog_sort` VALUES (1, '反派人物', 1, '2021-10-22 22:07:00', '2021-10-22 22:07:03', 1, 0);
INSERT INTO `t_blog_sort` VALUES (2, '后端开发', 1, '2021-10-22 22:17:46', '2021-10-22 22:17:48', 1, 0);

-- ----------------------------
-- Table structure for t_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tag`;
CREATE TABLE `t_blog_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标签名称',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `is_del` int(2) NOT NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_tag
-- ----------------------------
INSERT INTO `t_blog_tag` VALUES (1, 'Java', 1, '2021-10-25 21:03:21', '2021-10-25 21:03:24', 1, 0);
INSERT INTO `t_blog_tag` VALUES (2, '学习笔记', NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_blog_tag` VALUES (3, '面试', NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_blog_tag` VALUES (4, '前端开发', NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_blog_tag` VALUES (5, 'Linux', NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_blog_tag` VALUES (6, '机器学习', NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_blog_tag` VALUES (7, '校园生活', NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_blog_tag` VALUES (8, 'Spring Cloud', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_blog_tag_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tag_ref`;
CREATE TABLE `t_blog_tag_ref`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_tag_ref
-- ----------------------------

-- ----------------------------
-- Table structure for t_link
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '外链名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '外链url',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `is_del` int(2) NOT NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '网站外链' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_link
-- ----------------------------

-- ----------------------------
-- Table structure for t_navigation_bar
-- ----------------------------
DROP TABLE IF EXISTS `t_navigation_bar`;
CREATE TABLE `t_navigation_bar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sort_id` int(11) NULL DEFAULT NULL COMMENT '排序',
  `level` int(11) NULL DEFAULT NULL COMMENT '级别',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图标',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '路由跳转地址',
  `url_type` int(4) NULL DEFAULT NULL COMMENT 'url类型 1 内部 2 外链',
  `is_show` int(2) NULL DEFAULT NULL COMMENT '是否显示',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `is_del` int(2) NOT NULL COMMENT '删除',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标题',
  `css_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'css样式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_navigation_bar
-- ----------------------------
INSERT INTO `t_navigation_bar` VALUES (1, 1, 1, NULL, '/index', 1, 1, 1, '2021-10-17 10:12:27', '2021-10-17 10:12:31', 1, 0, '首页', 'hover');
INSERT INTO `t_navigation_bar` VALUES (2, 1, 1, NULL, '/', 1, 1, 1, '2021-10-17 10:15:29', '2021-10-17 10:15:32', 1, 0, '关于我', '');
INSERT INTO `t_navigation_bar` VALUES (3, 1, 1, NULL, '/', 1, 1, 1, '2021-10-17 10:15:29', '2021-10-17 10:15:32', 1, 0, '归档', '');
INSERT INTO `t_navigation_bar` VALUES (4, 1, 1, NULL, '/', 1, 1, 1, '2021-10-17 10:15:29', '2021-10-17 10:15:32', 1, 0, '分类', '');
INSERT INTO `t_navigation_bar` VALUES (5, 1, 1, NULL, '/', 1, 1, 1, '2021-10-17 10:15:29', '2021-10-17 10:15:32', 1, 0, '标签', '');
INSERT INTO `t_navigation_bar` VALUES (6, 1, 1, NULL, '/', 1, 1, 1, '2021-10-17 10:15:29', '2021-10-17 10:15:32', 1, 0, '问答', '');
INSERT INTO `t_navigation_bar` VALUES (11, 1, 1, NULL, '/', 1, 1, 1, '2021-10-17 10:15:29', '2021-10-17 10:15:32', 1, 0, '专栏', '');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像',
  `birthdate` datetime NULL DEFAULT NULL COMMENT '出生日期',
  `sex` int(2) NULL DEFAULT NULL COMMENT '性别',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `secret_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '秘钥',
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标签',
  `last_login_time` datetime NOT NULL COMMENT '最后登录时间',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '昵称',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `is_del` int(2) NOT NULL COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2021-10-17 00:01:59', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_viewpager
-- ----------------------------
DROP TABLE IF EXISTS `t_viewpager`;
CREATE TABLE `t_viewpager`  (
  `id` bigint(20) NOT NULL,
  `type` int(4) NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '轮播图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_viewpager
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
