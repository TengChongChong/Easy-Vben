/*
 Navicat Premium Data Transfer

 Source Server         : 本地 - MySql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 127.0.0.1:3306
 Source Schema         : easy-vben

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 16/02/2023 13:06:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for district
-- ----------------------------
DROP TABLE IF EXISTS `district`;
CREATE TABLE `district` (
  `id` smallint(5) DEFAULT NULL,
  `name` varchar(270) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `parent_id` smallint(5) DEFAULT NULL,
  `initial` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `initials` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `pinyin` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `extra` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `suffix` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `code` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `area_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `order` tinyint(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='行政区划';

-- ----------------------------
-- Records of district
-- ----------------------------
BEGIN;
INSERT INTO `district` VALUES (1, '北京', 0, 'b', 'bj', 'beijing', '', '市', '110000', '010', 1);
INSERT INTO `district` VALUES (2, '天津', 0, 't', 'tj', 'tianjin', '', '市', '120000', '022', 2);
INSERT INTO `district` VALUES (3, '上海', 0, 's', 'sh', 'shanghai', '', '市', '310000', '021', 3);
INSERT INTO `district` VALUES (4, '重庆', 0, 'c', 'cq', 'chongqing', '', '市', '500000', '023', 4);
INSERT INTO `district` VALUES (5, '河北', 0, 'h', 'hb', 'hebei', '', '省', '130000', '', 5);
INSERT INTO `district` VALUES (6, '山西', 0, 's', 'sx', 'shanxi', '', '省', '140000', '', 6);
INSERT INTO `district` VALUES (7, '内蒙古', 0, 'n', 'nmg', 'neimenggu', '', '自治区', '150000', '', 7);
INSERT INTO `district` VALUES (8, '辽宁', 0, 'l', 'ln', 'liaoning', '', '省', '210000', '', 8);
INSERT INTO `district` VALUES (9, '吉林', 0, 'j', 'jl', 'jilin', '', '省', '220000', '', 9);
INSERT INTO `district` VALUES (10, '黑龙江', 0, 'h', 'hlj', 'heilongjiang', '', '省', '230000', '', 10);
INSERT INTO `district` VALUES (11, '江苏', 0, 'j', 'js', 'jiangsu', '', '省', '320000', '', 11);
INSERT INTO `district` VALUES (12, '浙江', 0, 'z', 'zj', 'zhejiang', '', '省', '330000', '', 12);
INSERT INTO `district` VALUES (13, '安徽', 0, 'a', 'ah', 'anhui', '', '省', '340000', '', 13);
INSERT INTO `district` VALUES (14, '福建', 0, 'f', 'fj', 'fujian', '', '省', '350000', '', 14);
INSERT INTO `district` VALUES (15, '江西', 0, 'j', 'jx', 'jiangxi', '', '省', '360000', '', 15);
INSERT INTO `district` VALUES (16, '山东', 0, 's', 'sd', 'shandong', '', '省', '370000', '', 16);
INSERT INTO `district` VALUES (17, '河南', 0, 'h', 'hn', 'henan', '', '省', '410000', '', 17);
INSERT INTO `district` VALUES (18, '湖北', 0, 'h', 'hb', 'hubei', '', '省', '420000', '', 18);
INSERT INTO `district` VALUES (19, '湖南', 0, 'h', 'hn', 'hunan', '', '省', '430000', '', 19);
INSERT INTO `district` VALUES (20, '广东', 0, 'g', 'gd', 'guangdong', '', '省', '440000', '', 20);
INSERT INTO `district` VALUES (21, '广西', 0, 'g', 'gx', 'guangxi', '壮族', '自治区', '450000', '', 21);
INSERT INTO `district` VALUES (22, '海南', 0, 'h', 'hn', 'hainan', '', '省', '460000', '', 22);
INSERT INTO `district` VALUES (23, '四川', 0, 's', 'sc', 'sichuan', '', '省', '510000', '', 23);
INSERT INTO `district` VALUES (24, '贵州', 0, 'g', 'gz', 'guizhou', '', '省', '520000', '', 24);
INSERT INTO `district` VALUES (25, '云南', 0, 'y', 'yn', 'yunnan', '', '省', '530000', '', 25);
INSERT INTO `district` VALUES (26, '西藏', 0, 'x', 'xz', 'xizang', '', '自治区', '540000', '', 26);
INSERT INTO `district` VALUES (27, '陕西', 0, 's', 'sx', 'shanxi', '', '省', '610000', '', 27);
INSERT INTO `district` VALUES (28, '甘肃', 0, 'g', 'gs', 'gansu', '', '省', '620000', '', 28);
INSERT INTO `district` VALUES (29, '青海', 0, 'q', 'qh', 'qinghai', '', '省', '630000', '', 29);
INSERT INTO `district` VALUES (30, '宁夏', 0, 'n', 'nx', 'ningxia', '回族', '自治区', '640000', '', 30);
INSERT INTO `district` VALUES (31, '新疆', 0, 'x', 'xj', 'xinjiang', '维吾尔', '自治区', '650000', '', 31);
INSERT INTO `district` VALUES (32, '台湾', 0, 't', 'tw', 'taiwan', '', '省', '710000', '', 32);
INSERT INTO `district` VALUES (33, '香港', 0, 'x', 'xg', 'xianggang', '', '特别行政区', '810000', '852', 33);
INSERT INTO `district` VALUES (34, '澳门', 0, 'a', 'am', 'aomen', '', '特别行政区', '820000', '853', 34);
INSERT INTO `district` VALUES (35, '海外', 0, 'h', 'hw', 'haiwai', '', '', '', '', 35);
INSERT INTO `district` VALUES (36, '东城', 1, 'd', 'dc', 'dongcheng', '', '区', '110101', '010', 1);
INSERT INTO `district` VALUES (37, '西城', 1, 'x', 'xc', 'xicheng', '', '区', '110102', '010', 2);
INSERT INTO `district` VALUES (40, '朝阳', 1, 'c', 'cy', 'chaoyang', '', '区', '110105', '010', 5);
INSERT INTO `district` VALUES (41, '丰台', 1, 'f', 'ft', 'fengtai', '', '区', '110106', '010', 6);
INSERT INTO `district` VALUES (42, '石景山', 1, 's', 'sjs', 'shijingshan', '', '区', '110107', '010', 7);
INSERT INTO `district` VALUES (43, '海淀', 1, 'h', 'hd', 'haidian', '', '区', '110108', '010', 8);
INSERT INTO `district` VALUES (44, '门头沟', 1, 'm', 'mtg', 'mentougou', '', '区', '110109', '010', 9);
INSERT INTO `district` VALUES (45, '房山', 1, 'f', 'fs', 'fangshan', '', '区', '110111', '010', 10);
INSERT INTO `district` VALUES (46, '通州', 1, 't', 'tz', 'tongzhou', '', '区', '110112', '010', 11);
INSERT INTO `district` VALUES (47, '顺义', 1, 's', 'sy', 'shunyi', '', '区', '110113', '010', 12);
INSERT INTO `district` VALUES (48, '昌平', 1, 'c', 'cp', 'changping', '', '区', '110114', '010', 13);
INSERT INTO `district` VALUES (49, '大兴', 1, 'd', 'dx', 'daxing', '', '区', '110115', '010', 14);
INSERT INTO `district` VALUES (50, '怀柔', 1, 'h', 'hr', 'huairou', '', '区', '110116', '010', 15);
INSERT INTO `district` VALUES (51, '平谷', 1, 'p', 'pg', 'pinggu', '', '区', '110117', '010', 16);
INSERT INTO `district` VALUES (52, '密云', 1, 'm', 'my', 'miyun', '', '区', '110228', '010', 17);
INSERT INTO `district` VALUES (53, '延庆', 1, 'y', 'yq', 'yanqing', '', '区', '110229', '010', 18);
INSERT INTO `district` VALUES (54, '和平', 2, 'h', 'hp', 'heping', '', '区', '120101', '022', 1);
INSERT INTO `district` VALUES (55, '河东', 2, 'h', 'hd', 'hedong', '', '区', '120102', '022', 2);
INSERT INTO `district` VALUES (56, '河西', 2, 'h', 'hx', 'hexi', '', '区', '120103', '022', 3);
INSERT INTO `district` VALUES (57, '南开', 2, 'n', 'nk', 'nankai', '', '区', '120104', '022', 4);
INSERT INTO `district` VALUES (58, '河北', 2, 'h', 'hb', 'hebei', '', '区', '120105', '022', 5);
INSERT INTO `district` VALUES (59, '红桥', 2, 'h', 'hq', 'hongqiao', '', '区', '120106', '022', 6);
INSERT INTO `district` VALUES (60, '东丽', 2, 'd', 'dl', 'dongli', '', '区', '120110', '022', 7);
INSERT INTO `district` VALUES (61, '西青', 2, 'x', 'xq', 'xiqing', '', '区', '120111', '022', 8);
INSERT INTO `district` VALUES (62, '津南', 2, 'j', 'jn', 'jinnan', '', '区', '120112', '022', 9);
INSERT INTO `district` VALUES (63, '北辰', 2, 'b', 'bc', 'beichen', '', '区', '120113', '022', 10);
INSERT INTO `district` VALUES (64, '武清', 2, 'w', 'wq', 'wuqing', '', '区', '120114', '022', 11);
INSERT INTO `district` VALUES (65, '宝坻', 2, 'b', 'bc', 'baochi', '', '区', '120115', '022', 12);
INSERT INTO `district` VALUES (66, '滨海新区', 2, 'b', 'bhxq', 'binhaixinqu', '', '', '120116', '022', 13);
INSERT INTO `district` VALUES (67, '宁河', 2, 'n', 'nh', 'ninghe', '', '区', '120117', '022', 14);
INSERT INTO `district` VALUES (68, '蓟州', 2, 'j', 'jz', 'jizhou', '', '区', '120119', '022', 16);
INSERT INTO `district` VALUES (69, '静海', 2, 'j', 'jh', 'jinghai', '', '区', '120118', '022', 15);
INSERT INTO `district` VALUES (70, '黄浦', 3, 'h', 'hp', 'huangpu', '', '区', '310101', '021', 1);
INSERT INTO `district` VALUES (71, '徐汇', 3, 'x', 'xh', 'xuhui', '', '区', '310104', '021', 2);
INSERT INTO `district` VALUES (72, '长宁', 3, 'c', 'cn', 'changning', '', '区', '310105', '021', 3);
INSERT INTO `district` VALUES (73, '静安', 3, 'j', 'ja', 'jingan', '', '区', '310106', '021', 4);
INSERT INTO `district` VALUES (74, '普陀', 3, 'p', 'pt', 'putuo', '', '区', '310107', '021', 5);
INSERT INTO `district` VALUES (76, '虹口', 3, 'h', 'hk', 'hongkou', '', '区', '310109', '021', 6);
INSERT INTO `district` VALUES (77, '杨浦', 3, 'y', 'yp', 'yangpu', '', '区', '310110', '021', 7);
INSERT INTO `district` VALUES (78, '闵行', 3, 'm', 'mx', 'minxing', '', '区', '310112', '021', 8);
INSERT INTO `district` VALUES (79, '宝山', 3, 'b', 'bs', 'baoshan', '', '区', '310113', '021', 9);
INSERT INTO `district` VALUES (80, '嘉定', 3, 'j', 'jd', 'jiading', '', '区', '310114', '021', 10);
INSERT INTO `district` VALUES (81, '浦东新区', 3, 'p', 'pdxq', 'pudongxinqu', '', '', '310115', '021', 11);
INSERT INTO `district` VALUES (82, '金山', 3, 'j', 'js', 'jinshan', '', '区', '310116', '021', 12);
INSERT INTO `district` VALUES (83, '松江', 3, 's', 'sj', 'songjiang', '', '区', '310117', '021', 13);
INSERT INTO `district` VALUES (84, '青浦', 3, 'q', 'qp', 'qingpu', '', '区', '310118', '021', 14);
INSERT INTO `district` VALUES (85, '奉贤', 3, 'f', 'fx', 'fengxian', '', '区', '310120', '021', 15);
INSERT INTO `district` VALUES (86, '崇明', 3, 'c', 'cm', 'chongming', '', '区', '310151', '021', 16);
INSERT INTO `district` VALUES (87, '万州', 4, 'w', 'wz', 'wanzhou', '', '区', '500101', '023', 1);
INSERT INTO `district` VALUES (88, '涪陵', 4, 'f', 'fl', 'fuling', '', '区', '500102', '023', 2);
INSERT INTO `district` VALUES (89, '渝中', 4, 'y', 'yz', 'yuzhong', '', '区', '500103', '023', 3);
INSERT INTO `district` VALUES (90, '大渡口', 4, 'd', 'ddk', 'dadukou', '', '区', '500104', '023', 4);
INSERT INTO `district` VALUES (91, '江北', 4, 'j', 'jb', 'jiangbei', '', '区', '500105', '023', 5);
INSERT INTO `district` VALUES (92, '沙坪坝', 4, 's', 'spb', 'shapingba', '', '区', '500106', '023', 6);
INSERT INTO `district` VALUES (93, '九龙坡', 4, 'j', 'jlp', 'jiulongpo', '', '区', '500107', '023', 7);
INSERT INTO `district` VALUES (94, '南岸', 4, 'n', 'na', 'nanan', '', '区', '500108', '023', 8);
INSERT INTO `district` VALUES (95, '北碚', 4, 'b', 'bb', 'beibei', '', '区', '500109', '023', 9);
INSERT INTO `district` VALUES (96, '綦江', 4, 'q', 'qj', 'qijiang', '', '区', '500110', '023', 10);
INSERT INTO `district` VALUES (97, '大足', 4, 'd', 'dz', 'dazu', '', '区', '500111', '023', 11);
INSERT INTO `district` VALUES (98, '渝北', 4, 'y', 'yb', 'yubei', '', '区', '500112', '023', 12);
INSERT INTO `district` VALUES (99, '巴南', 4, 'b', 'bn', 'banan', '', '区', '500113', '023', 13);
INSERT INTO `district` VALUES (100, '黔江', 4, 'q', 'qj', 'qianjiang', '', '区', '500114', '023', 14);
INSERT INTO `district` VALUES (101, '长寿', 4, 'c', 'cs', 'changshou', '', '区', '500115', '023', 15);
INSERT INTO `district` VALUES (102, '江津', 4, 'j', 'jj', 'jiangjin', '', '区', '500116', '023', 16);
INSERT INTO `district` VALUES (103, '合川', 4, 'h', 'hc', 'hechuan', '', '区', '500117', '023', 17);
INSERT INTO `district` VALUES (104, '永川', 4, 'y', 'yc', 'yongchuan', '', '区', '500118', '023', 18);
INSERT INTO `district` VALUES (105, '南川', 4, 'n', 'nc', 'nanchuan', '', '区', '500119', '023', 19);
INSERT INTO `district` VALUES (106, '潼南', 4, 't', 'tn', 'tongnan', '', '区', '500223', '023', 25);
INSERT INTO `district` VALUES (107, '铜梁', 4, 't', 'tl', 'tongliang', '', '区', '500151', '023', 21);
INSERT INTO `district` VALUES (108, '荣昌', 4, 'r', 'rc', 'rongchang', '', '区', '500226', '023', 26);
INSERT INTO `district` VALUES (109, '璧山', 4, 'b', 'bs', 'bishan', '', '区', '500120', '023', 20);
INSERT INTO `district` VALUES (110, '梁平', 4, 'l', 'lp', 'liangping', '', '区', '500155', '023', 23);
INSERT INTO `district` VALUES (111, '城口', 4, 'c', 'ck', 'chengkou', '', '县', '500229', '023', 27);
INSERT INTO `district` VALUES (112, '丰都', 4, 'f', 'fd', 'fengdu', '', '县', '500230', '023', 28);
INSERT INTO `district` VALUES (113, '垫江', 4, 'd', 'dj', 'dianjiang', '', '县', '500231', '023', 29);
INSERT INTO `district` VALUES (114, '武隆', 4, 'w', 'wl', 'wulong', '', '区', '500156', '023', 24);
INSERT INTO `district` VALUES (115, '忠县', 4, 'z', 'zx', 'zhongxian', '', '', '500233', '023', 30);
INSERT INTO `district` VALUES (116, '开州', 4, 'k', 'kz', 'kaizhou', '', '区', '500154', '023', 22);
INSERT INTO `district` VALUES (117, '云阳', 4, 'y', 'yy', 'yunyang', '', '县', '500235', '023', 31);
INSERT INTO `district` VALUES (118, '奉节', 4, 'f', 'fj', 'fengjie', '', '县', '500236', '023', 32);
INSERT INTO `district` VALUES (119, '巫山', 4, 'w', 'ws', 'wushan', '', '县', '500237', '023', 33);
INSERT INTO `district` VALUES (120, '巫溪', 4, 'w', 'wx', 'wuxi', '', '县', '500238', '023', 34);
INSERT INTO `district` VALUES (121, '石柱', 4, 's', 'sz', 'shizhu', '土家族', '自治县', '500240', '023', 35);
INSERT INTO `district` VALUES (122, '秀山', 4, 'x', 'xs', 'xiushan', '土家族苗族', '自治县', '500241', '023', 36);
INSERT INTO `district` VALUES (123, '酉阳', 4, 'y', 'yy', 'youyang', '土家族苗族', '自治县', '500242', '023', 37);
INSERT INTO `district` VALUES (124, '彭水', 4, 'p', 'ps', 'pengshui', '苗族土家族', '自治县', '500243', '023', 38);
INSERT INTO `district` VALUES (125, '石家庄', 5, 's', 'sjz', 'shijiazhuang', '', '市', '130100', '0311', 1);
INSERT INTO `district` VALUES (126, '唐山', 5, 't', 'ts', 'tangshan', '', '市', '130200', '0315', 2);
INSERT INTO `district` VALUES (127, '秦皇岛', 5, 'q', 'qhd', 'qinhuangdao', '', '市', '130300', '0335', 3);
INSERT INTO `district` VALUES (128, '邯郸', 5, 'h', 'hd', 'handan', '', '市', '130400', '0310', 4);
INSERT INTO `district` VALUES (129, '邢台', 5, 'x', 'xt', 'xingtai', '', '市', '130500', '0319', 5);
INSERT INTO `district` VALUES (130, '保定', 5, 'b', 'bd', 'baoding', '', '市', '130600', '0312', 6);
INSERT INTO `district` VALUES (131, '张家口', 5, 'z', 'zjk', 'zhangjiakou', '', '市', '130700', '0313', 7);
INSERT INTO `district` VALUES (132, '承德', 5, 'c', 'cd', 'chengde', '', '市', '130800', '0314', 8);
INSERT INTO `district` VALUES (133, '沧州', 5, 'c', 'cz', 'cangzhou', '', '市', '130900', '0317', 9);
INSERT INTO `district` VALUES (134, '廊坊', 5, 'l', 'lf', 'langfang', '', '市', '131000', '0316', 10);
INSERT INTO `district` VALUES (135, '衡水', 5, 'h', 'hs', 'hengshui', '', '市', '131100', '0318', 11);
INSERT INTO `district` VALUES (136, '太原', 6, 't', 'ty', 'taiyuan', '', '市', '140100', '0351', 1);
INSERT INTO `district` VALUES (137, '大同', 6, 'd', 'dt', 'datong', '', '市', '140200', '0352', 2);
INSERT INTO `district` VALUES (138, '阳泉', 6, 'y', 'yq', 'yangquan', '', '市', '140300', '0353', 3);
INSERT INTO `district` VALUES (139, '长治', 6, 'c', 'cz', 'changzhi', '', '市', '140400', '0355', 4);
INSERT INTO `district` VALUES (140, '晋城', 6, 'j', 'jc', 'jincheng', '', '市', '140500', '0356', 5);
INSERT INTO `district` VALUES (141, '朔州', 6, 's', 'sz', 'shuozhou', '', '市', '140600', '0349', 6);
INSERT INTO `district` VALUES (142, '晋中', 6, 'j', 'jz', 'jinzhong', '', '市', '140700', '0354', 7);
INSERT INTO `district` VALUES (143, '运城', 6, 'y', 'yc', 'yuncheng', '', '市', '140800', '0359', 8);
INSERT INTO `district` VALUES (144, '忻州', 6, 'x', 'xz', 'xinzhou', '', '市', '140900', '0350', 9);
INSERT INTO `district` VALUES (145, '临汾', 6, 'l', 'lf', 'linfen', '', '市', '141000', '0357', 10);
INSERT INTO `district` VALUES (146, '吕梁', 6, 'l', 'll', 'lvliang', '', '市', '141100', '0358', 11);
INSERT INTO `district` VALUES (147, '呼和浩特', 7, 'h', 'hhht', 'huhehaote', '', '市', '150100', '0471', 1);
INSERT INTO `district` VALUES (148, '包头', 7, 'b', 'bt', 'baotou', '', '市', '150200', '0472', 2);
INSERT INTO `district` VALUES (149, '乌海', 7, 'w', 'wh', 'wuhai', '', '市', '150300', '0473', 3);
INSERT INTO `district` VALUES (150, '赤峰', 7, 'c', 'cf', 'chifeng', '', '市', '150400', '0476', 4);
INSERT INTO `district` VALUES (151, '通辽', 7, 't', 'tl', 'tongliao', '', '市', '150500', '0475', 5);
INSERT INTO `district` VALUES (152, '鄂尔多斯', 7, 'e', 'eeds', 'eerduosi', '', '市', '150600', '0477', 6);
INSERT INTO `district` VALUES (153, '呼伦贝尔', 7, 'h', 'hlbe', 'hulunbeier', '', '市', '150700', '0470', 7);
INSERT INTO `district` VALUES (154, '巴彦淖尔', 7, 'b', 'byne', 'bayannaoer', '', '市', '150800', '0478', 8);
INSERT INTO `district` VALUES (155, '乌兰察布', 7, 'w', 'wlcb', 'wulanchabu', '', '市', '150900', '0474', 9);
INSERT INTO `district` VALUES (156, '兴安', 7, 'x', 'xa', 'xingan', '', '盟', '152200', '0482', 10);
INSERT INTO `district` VALUES (157, '锡林郭勒', 7, 'x', 'xlgl', 'xilinguole', '', '盟', '152500', '0479', 11);
INSERT INTO `district` VALUES (158, '阿拉善', 7, 'a', 'als', 'alashan', '', '盟', '152900', '0483', 12);
INSERT INTO `district` VALUES (159, '沈阳', 8, 's', 'sy', 'shenyang', '', '市', '210100', '024', 1);
INSERT INTO `district` VALUES (160, '大连', 8, 'd', 'dl', 'dalian', '', '市', '210200', '0411', 2);
INSERT INTO `district` VALUES (161, '鞍山', 8, 'a', 'as', 'anshan', '', '市', '210300', '0412', 3);
INSERT INTO `district` VALUES (162, '抚顺', 8, 'f', 'fs', 'fushun', '', '市', '210400', '0413', 4);
INSERT INTO `district` VALUES (163, '本溪', 8, 'b', 'bx', 'benxi', '', '市', '210500', '0414', 5);
INSERT INTO `district` VALUES (164, '丹东', 8, 'd', 'dd', 'dandong', '', '市', '210600', '0415', 6);
INSERT INTO `district` VALUES (165, '锦州', 8, 'j', 'jz', 'jinzhou', '', '市', '210700', '0416', 7);
INSERT INTO `district` VALUES (166, '营口', 8, 'y', 'yk', 'yingkou', '', '市', '210800', '0417', 8);
INSERT INTO `district` VALUES (167, '阜新', 8, 'f', 'fx', 'fuxin', '', '市', '210900', '0418', 9);
INSERT INTO `district` VALUES (168, '辽阳', 8, 'l', 'ly', 'liaoyang', '', '市', '211000', '0419', 10);
INSERT INTO `district` VALUES (169, '盘锦', 8, 'p', 'pj', 'panjin', '', '市', '211100', '0427', 11);
INSERT INTO `district` VALUES (170, '铁岭', 8, 't', 'tl', 'tieling', '', '市', '211200', '0410', 12);
INSERT INTO `district` VALUES (171, '朝阳', 8, 'c', 'cy', 'chaoyang', '', '市', '211300', '0421', 13);
INSERT INTO `district` VALUES (172, '葫芦岛', 8, 'h', 'hld', 'huludao', '', '市', '211400', '0429', 14);
INSERT INTO `district` VALUES (173, '长春', 9, 'c', 'cc', 'changchun', '', '市', '220100', '0431', 1);
INSERT INTO `district` VALUES (174, '吉林', 9, 'j', 'jl', 'jilin', '', '市', '220200', '0432', 2);
INSERT INTO `district` VALUES (175, '四平', 9, 's', 'sp', 'siping', '', '市', '220300', '0434', 3);
INSERT INTO `district` VALUES (176, '辽源', 9, 'l', 'ly', 'liaoyuan', '', '市', '220400', '0437', 4);
INSERT INTO `district` VALUES (177, '通化', 9, 't', 'th', 'tonghua', '', '市', '220500', '0435', 5);
INSERT INTO `district` VALUES (178, '白山', 9, 'b', 'bs', 'baishan', '', '市', '220600', '0439', 6);
INSERT INTO `district` VALUES (179, '松原', 9, 's', 'sy', 'songyuan', '', '市', '220700', '0438', 7);
INSERT INTO `district` VALUES (180, '白城', 9, 'b', 'bc', 'baicheng', '', '市', '220800', '0436', 8);
INSERT INTO `district` VALUES (181, '延边', 9, 'y', 'yb', 'yanbian', '朝鲜族', '自治州', '222400', '0433', 9);
INSERT INTO `district` VALUES (182, '哈尔滨', 10, 'h', 'heb', 'haerbin', '', '市', '230100', '0451', 1);
INSERT INTO `district` VALUES (183, '齐齐哈尔', 10, 'q', 'qqhe', 'qiqihaer', '', '市', '230200', '0452', 2);
INSERT INTO `district` VALUES (184, '鸡西', 10, 'j', 'jx', 'jixi', '', '市', '230300', '0467', 3);
INSERT INTO `district` VALUES (185, '鹤岗', 10, 'h', 'hg', 'hegang', '', '市', '230400', '0468', 4);
INSERT INTO `district` VALUES (186, '双鸭山', 10, 's', 'sys', 'shuangyashan', '', '市', '230500', '0469', 5);
INSERT INTO `district` VALUES (187, '大庆', 10, 'd', 'dq', 'daqing', '', '市', '230600', '0459', 6);
INSERT INTO `district` VALUES (188, '伊春', 10, 'y', 'yc', 'yichun', '', '市', '230700', '0458', 7);
INSERT INTO `district` VALUES (189, '佳木斯', 10, 'j', 'jms', 'jiamusi', '', '市', '230800', '0454', 8);
INSERT INTO `district` VALUES (190, '七台河', 10, 'q', 'qth', 'qitaihe', '', '市', '230900', '0464', 9);
INSERT INTO `district` VALUES (191, '牡丹江', 10, 'm', 'mdj', 'mudanjiang', '', '市', '231000', '0453', 10);
INSERT INTO `district` VALUES (192, '黑河', 10, 'h', 'hh', 'heihe', '', '市', '231100', '0456', 11);
INSERT INTO `district` VALUES (193, '绥化', 10, 's', 'sh', 'suihua', '', '市', '231200', '0455', 12);
INSERT INTO `district` VALUES (194, '大兴安岭', 10, 'd', 'dxal', 'daxinganling', '', '地区', '232700', '0457', 13);
INSERT INTO `district` VALUES (195, '南京', 11, 'n', 'nj', 'nanjing', '', '市', '320100', '', 1);
INSERT INTO `district` VALUES (196, '无锡', 11, 'w', 'wx', 'wuxi', '', '市', '320200', '0510', 2);
INSERT INTO `district` VALUES (197, '徐州', 11, 'x', 'xz', 'xuzhou', '', '市', '320300', '0516', 3);
INSERT INTO `district` VALUES (198, '常州', 11, 'c', 'cz', 'changzhou', '', '市', '320400', '0519', 4);
INSERT INTO `district` VALUES (199, '苏州', 11, 's', 'sz', 'suzhou', '', '市', '320500', '0512', 5);
INSERT INTO `district` VALUES (200, '南通', 11, 'n', 'nt', 'nantong', '', '市', '320600', '0513', 6);
INSERT INTO `district` VALUES (201, '连云港', 11, 'l', 'lyg', 'lianyungang', '', '市', '320700', '0518', 7);
INSERT INTO `district` VALUES (202, '淮安', 11, 'h', 'ha', 'huaian', '', '市', '320800', '0517', 8);
INSERT INTO `district` VALUES (203, '盐城', 11, 'y', 'yc', 'yancheng', '', '市', '320900', '0515', 9);
INSERT INTO `district` VALUES (204, '扬州', 11, 'y', 'yz', 'yangzhou', '', '市', '321000', '0514', 10);
INSERT INTO `district` VALUES (205, '镇江', 11, 'z', 'zj', 'zhenjiang', '', '市', '321100', '0511', 11);
INSERT INTO `district` VALUES (206, '泰州', 11, 't', 'tz', 'taizhou', '', '市', '321200', '0523', 12);
INSERT INTO `district` VALUES (207, '宿迁', 11, 's', 'sq', 'suqian', '', '市', '321300', '0527', 13);
INSERT INTO `district` VALUES (208, '杭州', 12, 'h', 'hz', 'hangzhou', '', '市', '330100', '0571', 1);
INSERT INTO `district` VALUES (209, '宁波', 12, 'n', 'nb', 'ningbo', '', '市', '330200', '0574', 2);
INSERT INTO `district` VALUES (210, '温州', 12, 'w', 'wz', 'wenzhou', '', '市', '330300', '0577', 3);
INSERT INTO `district` VALUES (211, '嘉兴', 12, 'j', 'jx', 'jiaxing', '', '市', '330400', '0573', 4);
INSERT INTO `district` VALUES (212, '湖州', 12, 'h', 'hz', 'huzhou', '', '市', '330500', '0572', 5);
INSERT INTO `district` VALUES (213, '绍兴', 12, 's', 'sx', 'shaoxing', '', '市', '330600', '0575', 6);
INSERT INTO `district` VALUES (214, '金华', 12, 'j', 'jh', 'jinhua', '', '市', '330700', '0579', 7);
INSERT INTO `district` VALUES (215, '衢州', 12, 'q', 'qz', 'quzhou', '', '市', '330800', '0570', 8);
INSERT INTO `district` VALUES (216, '舟山', 12, 'z', 'zs', 'zhoushan', '', '市', '330900', '0580', 9);
INSERT INTO `district` VALUES (217, '台州', 12, 't', 'tz', 'taizhou', '', '市', '331000', '0576', 10);
INSERT INTO `district` VALUES (218, '丽水', 12, 'l', 'ls', 'lishui', '', '市', '331100', '0578', 11);
INSERT INTO `district` VALUES (219, '合肥', 13, 'h', 'hf', 'hefei', '', '市', '340100', '0551', 1);
INSERT INTO `district` VALUES (220, '芜湖', 13, 'w', 'wh', 'wuhu', '', '市', '340200', '0553', 2);
INSERT INTO `district` VALUES (221, '蚌埠', 13, 'b', 'bb', 'bengbu', '', '市', '340300', '0552', 3);
INSERT INTO `district` VALUES (222, '淮南', 13, 'h', 'hn', 'huainan', '', '市', '340400', '0554', 4);
INSERT INTO `district` VALUES (223, '马鞍山', 13, 'm', 'mas', 'maanshan', '', '市', '340500', '0555', 5);
INSERT INTO `district` VALUES (224, '淮北', 13, 'h', 'hb', 'huaibei', '', '市', '340600', '0561', 6);
INSERT INTO `district` VALUES (225, '铜陵', 13, 't', 'tl', 'tongling', '', '市', '340700', '0562', 7);
INSERT INTO `district` VALUES (226, '安庆', 13, 'a', 'aq', 'anqing', '', '市', '340800', '0556', 8);
INSERT INTO `district` VALUES (227, '黄山', 13, 'h', 'hs', 'huangshan', '', '市', '341000', '0559', 9);
INSERT INTO `district` VALUES (228, '滁州', 13, 'c', 'cz', 'chuzhou', '', '市', '341100', '0550', 10);
INSERT INTO `district` VALUES (229, '阜阳', 13, 'f', 'fy', 'fuyang', '', '市', '341200', '0558', 11);
INSERT INTO `district` VALUES (230, '宿州', 13, 's', 'sz', 'suzhou', '', '市', '341300', '0557', 12);
INSERT INTO `district` VALUES (231, '六安', 13, 'l', 'la', 'liuan', '', '市', '341500', '0564', 13);
INSERT INTO `district` VALUES (232, '亳州', 13, 'b', 'bz', 'bozhou', '', '市', '341600', '0558', 14);
INSERT INTO `district` VALUES (233, '池州', 13, 'c', 'cz', 'chizhou', '', '市', '341700', '0566', 15);
INSERT INTO `district` VALUES (234, '宣城', 13, 'x', 'xc', 'xuancheng', '', '市', '341800', '0563', 16);
INSERT INTO `district` VALUES (235, '福州', 14, 'f', 'fz', 'fuzhou', '', '市', '350100', '0591', 1);
INSERT INTO `district` VALUES (236, '厦门', 14, 'x', 'xm', 'xiamen', '', '市', '350200', '0592', 2);
INSERT INTO `district` VALUES (237, '莆田', 14, 'p', 'pt', 'putian', '', '市', '350300', '0594', 3);
INSERT INTO `district` VALUES (238, '三明', 14, 's', 'sm', 'sanming', '', '市', '350400', '0598', 4);
INSERT INTO `district` VALUES (239, '泉州', 14, 'q', 'qz', 'quanzhou', '', '市', '350500', '0595', 5);
INSERT INTO `district` VALUES (240, '漳州', 14, 'z', 'zz', 'zhangzhou', '', '市', '350600', '0596', 6);
INSERT INTO `district` VALUES (241, '南平', 14, 'n', 'np', 'nanping', '', '市', '350700', '0599', 7);
INSERT INTO `district` VALUES (242, '龙岩', 14, 'l', 'ly', 'longyan', '', '市', '350800', '0597', 8);
INSERT INTO `district` VALUES (243, '宁德', 14, 'n', 'nd', 'ningde', '', '市', '350900', '0593', 9);
INSERT INTO `district` VALUES (244, '南昌', 15, 'n', 'nc', 'nanchang', '', '市', '360100', '0791', 1);
INSERT INTO `district` VALUES (245, '景德镇', 15, 'j', 'jdz', 'jingdezhen', '', '市', '360200', '0798', 2);
INSERT INTO `district` VALUES (246, '萍乡', 15, 'p', 'px', 'pingxiang', '', '市', '360300', '0799', 3);
INSERT INTO `district` VALUES (247, '九江', 15, 'j', 'jj', 'jiujiang', '', '市', '360400', '0792', 4);
INSERT INTO `district` VALUES (248, '新余', 15, 'x', 'xy', 'xinyu', '', '市', '360500', '0790', 5);
INSERT INTO `district` VALUES (249, '鹰潭', 15, 'y', 'yt', 'yingtan', '', '市', '360600', '0701', 6);
INSERT INTO `district` VALUES (250, '赣州', 15, 'g', 'gz', 'ganzhou', '', '市', '360700', '0797', 7);
INSERT INTO `district` VALUES (251, '吉安', 15, 'j', 'ja', 'jian', '', '市', '360800', '0796', 8);
INSERT INTO `district` VALUES (252, '宜春', 15, 'y', 'yc', 'yichun', '', '市', '360900', '0795', 9);
INSERT INTO `district` VALUES (253, '抚州', 15, 'f', 'fz', 'fuzhou', '', '市', '361000', '0794', 10);
INSERT INTO `district` VALUES (254, '上饶', 15, 's', 'sr', 'shangrao', '', '市', '361100', '0793', 11);
INSERT INTO `district` VALUES (255, '济南', 16, 'j', 'jn', 'jinan', '', '市', '370100', '0531', 1);
INSERT INTO `district` VALUES (256, '青岛', 16, 'q', 'qd', 'qingdao', '', '市', '370200', '0532', 2);
INSERT INTO `district` VALUES (257, '淄博', 16, 'z', 'zb', 'zibo', '', '市', '370300', '0533', 3);
INSERT INTO `district` VALUES (258, '枣庄', 16, 'z', 'zz', 'zaozhuang', '', '市', '370400', '0632', 4);
INSERT INTO `district` VALUES (259, '东营', 16, 'd', 'dy', 'dongying', '', '市', '370500', '0546', 5);
INSERT INTO `district` VALUES (260, '烟台', 16, 'y', 'yt', 'yantai', '', '市', '370600', '0535', 6);
INSERT INTO `district` VALUES (261, '潍坊', 16, 'w', 'wf', 'weifang', '', '市', '370700', '0536', 7);
INSERT INTO `district` VALUES (262, '济宁', 16, 'j', 'jn', 'jining', '', '市', '370800', '0537', 8);
INSERT INTO `district` VALUES (263, '泰安', 16, 't', 'ta', 'taian', '', '市', '370900', '0538', 9);
INSERT INTO `district` VALUES (264, '威海', 16, 'w', 'wh', 'weihai', '', '市', '371000', '0631', 10);
INSERT INTO `district` VALUES (265, '日照', 16, 'r', 'rz', 'rizhao', '', '市', '371100', '0633', 11);
INSERT INTO `district` VALUES (267, '临沂', 16, 'l', 'ly', 'linyi', '', '市', '371300', '0539', 13);
INSERT INTO `district` VALUES (268, '德州', 16, 'd', 'dz', 'dezhou', '', '市', '371400', '0534', 14);
INSERT INTO `district` VALUES (269, '聊城', 16, 'l', 'lc', 'liaocheng', '', '市', '371500', '0635', 15);
INSERT INTO `district` VALUES (270, '滨州', 16, 'b', 'bz', 'binzhou', '', '市', '371600', '0543', 16);
INSERT INTO `district` VALUES (271, '菏泽', 16, 'h', 'hz', 'heze', '', '市', '371700', '0530', 17);
INSERT INTO `district` VALUES (272, '郑州', 17, 'z', 'zz', 'zhengzhou', '', '市', '410100', '0371', 1);
INSERT INTO `district` VALUES (273, '开封', 17, 'k', 'kf', 'kaifeng', '', '市', '410200', '0378', 2);
INSERT INTO `district` VALUES (274, '洛阳', 17, 'l', 'ly', 'luoyang', '', '市', '410300', '0376', 3);
INSERT INTO `district` VALUES (275, '平顶山', 17, 'p', 'pds', 'pingdingshan', '', '市', '410400', '0375', 4);
INSERT INTO `district` VALUES (276, '安阳', 17, 'a', 'ay', 'anyang', '', '市', '410500', '0372', 5);
INSERT INTO `district` VALUES (277, '鹤壁', 17, 'h', 'hb', 'hebi', '', '市', '410600', '0392', 6);
INSERT INTO `district` VALUES (278, '新乡', 17, 'x', 'xx', 'xinxiang', '', '市', '410700', '0373', 7);
INSERT INTO `district` VALUES (279, '焦作', 17, 'j', 'jz', 'jiaozuo', '', '市', '410800', '0391', 8);
INSERT INTO `district` VALUES (280, '濮阳', 17, 'p', 'py', 'puyang', '', '市', '410900', '', 9);
INSERT INTO `district` VALUES (281, '许昌', 17, 'x', 'xc', 'xuchuang', '', '市', '411000', '0374', 10);
INSERT INTO `district` VALUES (282, '漯河', 17, 'l', 'lh', 'luohe', '', '市', '411100', '0395', 11);
INSERT INTO `district` VALUES (283, '三门峡', 17, 's', 'smx', 'sanmenxia', '', '市', '411200', '0398', 12);
INSERT INTO `district` VALUES (284, '南阳', 17, 'n', 'ny', 'nanyang', '', '市', '411300', '0377', 13);
INSERT INTO `district` VALUES (285, '商丘', 17, 's', 'sq', 'shangqiu', '', '市', '411400', '0370', 14);
INSERT INTO `district` VALUES (286, '信阳', 17, 'x', 'xy', 'xinyang', '', '市', '411500', '0376', 15);
INSERT INTO `district` VALUES (287, '周口', 17, 'z', 'zk', 'zhoukou', '', '市', '411600', '0394', 16);
INSERT INTO `district` VALUES (288, '驻马店', 17, 'z', 'zmd', 'zhumadian', '', '市', '411700', '0396', 17);
INSERT INTO `district` VALUES (289, '济源', 17, 'j', 'jy', 'jiyuan', '', '市', '419001', '0391', 18);
INSERT INTO `district` VALUES (290, '武汉', 18, 'w', 'wh', 'wuhan', '', '市', '420100', '027', 1);
INSERT INTO `district` VALUES (291, '黄石', 18, 'h', 'hs', 'huangshi', '', '市', '420200', '0714', 2);
INSERT INTO `district` VALUES (292, '十堰', 18, 's', 'sy', 'shiyan', '', '市', '420300', '0719', 3);
INSERT INTO `district` VALUES (293, '宜昌', 18, 'y', 'yc', 'yichang', '', '市', '420500', '0717', 4);
INSERT INTO `district` VALUES (294, '襄阳', 18, 'x', 'xy', 'xiangyang', '', '市', '420600', '0710', 5);
INSERT INTO `district` VALUES (295, '鄂州', 18, 'e', 'ez', 'ezhou', '', '市', '420700', '', 6);
INSERT INTO `district` VALUES (296, '荆门', 18, 'j', 'jm', 'jingmen', '', '市', '420800', '0724', 7);
INSERT INTO `district` VALUES (297, '孝感', 18, 'x', 'xg', 'xiaogan', '', '市', '420900', '0712', 8);
INSERT INTO `district` VALUES (298, '荆州', 18, 'j', 'jz', 'jingzhou', '', '市', '421000', '0716', 9);
INSERT INTO `district` VALUES (299, '黄冈', 18, 'h', 'hg', 'huanggang', '', '市', '421100', '0713', 10);
INSERT INTO `district` VALUES (300, '咸宁', 18, 'x', 'xn', 'xianning', '', '市', '421200', '0715', 11);
INSERT INTO `district` VALUES (301, '随州', 18, 's', 'sz', 'suizhou', '', '市', '421300', '0722', 12);
INSERT INTO `district` VALUES (302, '恩施', 18, 'e', 'es', 'enshi', '土家族苗族', '自治州', '422800', '0718', 13);
INSERT INTO `district` VALUES (303, '仙桃', 18, 'x', 'xt', 'xiantao', '', '市', '429004', '0728', 14);
INSERT INTO `district` VALUES (304, '潜江', 18, 'q', 'qj', 'qianjiang', '', '市', '429005', '0728', 15);
INSERT INTO `district` VALUES (305, '天门', 18, 't', 'tm', 'tianmen', '', '市', '429006', '0728', 16);
INSERT INTO `district` VALUES (306, '神农架林区', 18, 's', 'snjlq', 'shennongjialinqu', '', '', '429021', '0719', 17);
INSERT INTO `district` VALUES (307, '长沙', 19, 'c', 'cs', 'changsha', '', '市', '430100', '0731', 1);
INSERT INTO `district` VALUES (308, '株洲', 19, 'z', 'zz', 'zhuzhou', '', '市', '430200', '0731', 2);
INSERT INTO `district` VALUES (309, '湘潭', 19, 'x', 'xt', 'xiangtan', '', '市', '430300', '0731', 3);
INSERT INTO `district` VALUES (310, '衡阳', 19, 'h', 'hy', 'hengyang', '', '市', '430400', '0734', 4);
INSERT INTO `district` VALUES (311, '邵阳', 19, 's', 'sy', 'shaoyang', '', '市', '430500', '0739', 5);
INSERT INTO `district` VALUES (312, '岳阳', 19, 'y', 'yy', 'yueyang', '', '市', '430600', '0730', 6);
INSERT INTO `district` VALUES (313, '常德', 19, 'c', 'cd', 'changde', '', '市', '430700', '0736', 7);
INSERT INTO `district` VALUES (314, '张家界', 19, 'z', 'zjj', 'zhangjiajie', '', '市', '430800', '0744', 8);
INSERT INTO `district` VALUES (315, '益阳', 19, 'y', 'yy', 'yiyang', '', '市', '430900', '0737', 9);
INSERT INTO `district` VALUES (316, '郴州', 19, 'c', 'cz', 'chenzhou', '', '市', '431000', '0735', 10);
INSERT INTO `district` VALUES (317, '永州', 19, 'y', 'yz', 'yongzhou', '', '市', '431100', '0746', 11);
INSERT INTO `district` VALUES (318, '怀化', 19, 'h', 'hh', 'huaihua', '', '市', '431200', '0745', 12);
INSERT INTO `district` VALUES (319, '娄底', 19, 'l', 'ld', 'loudi', '', '市', '431300', '0738', 13);
INSERT INTO `district` VALUES (320, '湘西', 19, 'x', 'xx', 'xiangxi', '土家族苗族', '自治州', '433100', '0743', 14);
INSERT INTO `district` VALUES (321, '广州', 20, 'g', 'gz', 'guangzhou', '', '市', '440100', '020', 1);
INSERT INTO `district` VALUES (322, '韶关', 20, 's', 'sg', 'shaoguan', '', '市', '440200', '0751', 2);
INSERT INTO `district` VALUES (323, '深圳', 20, 's', 'sz', 'shenzhen', '', '市', '440300', '0755', 3);
INSERT INTO `district` VALUES (324, '珠海', 20, 'z', 'zh', 'zhuhai', '', '市', '440400', '0756', 4);
INSERT INTO `district` VALUES (325, '汕头', 20, 's', 'st', 'shantou', '', '市', '440500', '0754', 5);
INSERT INTO `district` VALUES (326, '佛山', 20, 'f', 'fs', 'foshan', '', '市', '440600', '0757', 6);
INSERT INTO `district` VALUES (327, '江门', 20, 'j', 'jm', 'jiangmen', '', '市', '440700', '0750', 7);
INSERT INTO `district` VALUES (328, '湛江', 20, 'z', 'zj', 'zhanjiang', '', '市', '440800', '0759', 8);
INSERT INTO `district` VALUES (329, '茂名', 20, 'm', 'mm', 'maoming', '', '市', '440900', '0668', 9);
INSERT INTO `district` VALUES (330, '肇庆', 20, 'z', 'zq', 'zhaoqing', '', '市', '441200', '0758', 10);
INSERT INTO `district` VALUES (331, '惠州', 20, 'h', 'hz', 'huizhou', '', '市', '441300', '0752', 11);
INSERT INTO `district` VALUES (332, '梅州', 20, 'm', 'mz', 'meizhou', '', '市', '441400', '0753', 12);
INSERT INTO `district` VALUES (333, '汕尾', 20, 's', 'sw', 'shanwei', '', '市', '441500', '0660', 13);
INSERT INTO `district` VALUES (334, '河源', 20, 'h', 'hy', 'heyuan', '', '市', '441600', '0762', 14);
INSERT INTO `district` VALUES (335, '阳江', 20, 'y', 'yj', 'yangjiang', '', '市', '441700', '0662', 15);
INSERT INTO `district` VALUES (336, '清远', 20, 'q', 'qy', 'qingyuan', '', '市', '441800', '0763', 16);
INSERT INTO `district` VALUES (337, '东莞', 20, 'd', 'dg', 'dongguan', '', '市', '441900', '0769', 17);
INSERT INTO `district` VALUES (338, '中山', 20, 'z', 'zs', 'zhongshan', '', '市', '442000', '0760', 18);
INSERT INTO `district` VALUES (339, '潮州', 20, 'c', 'cz', 'chaozhou', '', '市', '445100', '0768', 19);
INSERT INTO `district` VALUES (340, '揭阳', 20, 'j', 'jy', 'jieyang', '', '市', '445200', '0663', 20);
INSERT INTO `district` VALUES (341, '云浮', 20, 'y', 'yf', 'yunfu', '', '市', '445300', '0766', 21);
INSERT INTO `district` VALUES (342, '南宁', 21, 'n', 'nn', 'nanning', '', '市', '450100', '0771', 1);
INSERT INTO `district` VALUES (343, '柳州', 21, 'l', 'lz', 'liuzhou', '', '市', '450200', '0772', 2);
INSERT INTO `district` VALUES (344, '桂林', 21, 'g', 'gl', 'guilin', '', '市', '450300', '0773', 3);
INSERT INTO `district` VALUES (345, '梧州', 21, 'w', 'wz', 'wuzhou', '', '市', '450400', '0774', 4);
INSERT INTO `district` VALUES (346, '北海', 21, 'b', 'bh', 'beihai', '', '市', '450500', '0779', 5);
INSERT INTO `district` VALUES (347, '防城港', 21, 'f', 'fcg', 'fangchenggang', '', '市', '450600', '0770', 6);
INSERT INTO `district` VALUES (348, '钦州', 21, 'q', 'qz', 'qinzhou', '', '市', '450700', '0777', 7);
INSERT INTO `district` VALUES (349, '贵港', 21, 'g', 'gg', 'guigang', '', '市', '450800', '0775', 8);
INSERT INTO `district` VALUES (350, '玉林', 21, 'y', 'yl', 'yulin', '', '市', '450900', '0775', 9);
INSERT INTO `district` VALUES (351, '百色', 21, 'b', 'bs', 'baise', '', '市', '451000', '0776', 10);
INSERT INTO `district` VALUES (352, '贺州', 21, 'h', 'hz', 'hezhou', '', '市', '451100', '0774', 11);
INSERT INTO `district` VALUES (353, '河池', 21, 'h', 'hc', 'hechi', '', '市', '451200', '0778', 12);
INSERT INTO `district` VALUES (354, '来宾', 21, 'l', 'lb', 'laibin', '', '市', '451300', '0772', 13);
INSERT INTO `district` VALUES (355, '崇左', 21, 'c', 'cz', 'chongzuo', '', '市', '451400', '0771', 14);
INSERT INTO `district` VALUES (356, '海口', 22, 'h', 'hk', 'haikou', '', '市', '460100', '0898', 1);
INSERT INTO `district` VALUES (357, '三亚', 22, 's', 'sy', 'sanya', '', '市', '460200', '0898', 2);
INSERT INTO `district` VALUES (358, '三沙', 22, 's', 'ss', 'sansha', '', '市', '460300', '0898', 3);
INSERT INTO `district` VALUES (359, '五指山', 22, 'w', 'wzs', 'wuzhishan', '', '市', '469001', '0898', 5);
INSERT INTO `district` VALUES (360, '琼海', 22, 'q', 'qh', 'qionghai', '', '市', '469002', '0898', 6);
INSERT INTO `district` VALUES (361, '儋州', 22, 'd', 'dz', 'danzhou', '', '市', '460400', '0898', 4);
INSERT INTO `district` VALUES (362, '文昌', 22, 'w', 'wc', 'wenchang', '', '市', '469005', '0898', 7);
INSERT INTO `district` VALUES (363, '万宁', 22, 'w', 'wn', 'wanning', '', '市', '469006', '0898', 8);
INSERT INTO `district` VALUES (364, '东方', 22, 'd', 'df', 'dongfang', '', '市', '469007', '0898', 9);
INSERT INTO `district` VALUES (365, '定安', 22, 'd', 'da', 'dingan', '', '县', '469021', '0898', 10);
INSERT INTO `district` VALUES (366, '屯昌', 22, 't', 'tc', 'tunchang', '', '县', '469022', '0898', 11);
INSERT INTO `district` VALUES (367, '澄迈', 22, 'c', 'cm', 'chengmai', '', '县', '469023', '0898', 12);
INSERT INTO `district` VALUES (368, '临高', 22, 'l', 'lg', 'lingao', '', '县', '469024', '0898', 13);
INSERT INTO `district` VALUES (369, '白沙', 22, 'b', 'bs', 'baisha', '黎族', '自治县', '469025', '0898', 14);
INSERT INTO `district` VALUES (370, '昌江', 22, 'c', 'cj', 'changjiang', '黎族', '自治县', '469026', '0898', 15);
INSERT INTO `district` VALUES (371, '乐东', 22, 'l', 'ld', 'ledong', '黎族', '自治县', '469027', '0898', 16);
INSERT INTO `district` VALUES (372, '陵水', 22, 'l', 'ls', 'lingshui', '黎族', '自治县', '469028', '0898', 17);
INSERT INTO `district` VALUES (373, '保亭', 22, 'b', 'bt', 'baoting', '黎族苗族', '自治县', '469029', '0898', 18);
INSERT INTO `district` VALUES (374, '琼中', 22, 'q', 'qz', 'qiongzhong', '黎族苗族', '自治县', '469030', '0898', 19);
INSERT INTO `district` VALUES (375, '成都', 23, 'c', 'cd', 'chengdu', '', '市', '510100', '028', 1);
INSERT INTO `district` VALUES (376, '自贡', 23, 'z', 'zg', 'zigong', '', '市', '510300', '0813', 2);
INSERT INTO `district` VALUES (377, '攀枝花', 23, 'p', 'pzh', 'panzhihua', '', '市', '510400', '0812', 3);
INSERT INTO `district` VALUES (378, '泸州', 23, 'l', 'lz', 'luzhou', '', '市', '510500', '0830', 4);
INSERT INTO `district` VALUES (379, '德阳', 23, 'd', 'dy', 'deyang', '', '市', '510600', '0838', 5);
INSERT INTO `district` VALUES (380, '绵阳', 23, 'm', 'my', 'mianyang', '', '市', '510700', '0816', 6);
INSERT INTO `district` VALUES (381, '广元', 23, 'g', 'gy', 'guangyuan', '', '市', '510800', '0839', 7);
INSERT INTO `district` VALUES (382, '遂宁', 23, 's', 'sn', 'suining', '', '市', '510900', '0825', 8);
INSERT INTO `district` VALUES (383, '内江', 23, 'n', 'nj', 'neijiang', '', '市', '511000', '', 9);
INSERT INTO `district` VALUES (384, '乐山', 23, 'l', 'ls', 'leshan', '', '市', '511100', '0833', 10);
INSERT INTO `district` VALUES (385, '南充', 23, 'n', 'nc', 'nanchong', '', '市', '511300', '0817', 11);
INSERT INTO `district` VALUES (386, '眉山', 23, 'm', 'ms', 'meishan', '', '市', '511400', '028', 12);
INSERT INTO `district` VALUES (387, '宜宾', 23, 'y', 'yb', 'yibin', '', '市', '511500', '0831', 13);
INSERT INTO `district` VALUES (388, '广安', 23, 'g', 'ga', 'guangan', '', '市', '511600', '0826', 14);
INSERT INTO `district` VALUES (389, '达州', 23, 'd', 'dz', 'dazhou', '', '市', '511700', '0818', 15);
INSERT INTO `district` VALUES (390, '雅安', 23, 'y', 'ya', 'yaan', '', '市', '511800', '0835', 16);
INSERT INTO `district` VALUES (391, '巴中', 23, 'b', 'bz', 'bazhong', '', '市', '511900', '0827', 17);
INSERT INTO `district` VALUES (392, '资阳', 23, 'z', 'zy', 'ziyang', '', '市', '512000', '028', 18);
INSERT INTO `district` VALUES (393, '阿坝', 23, 'a', 'ab', 'aba', '藏族羌族', '自治州', '513200', '0837', 19);
INSERT INTO `district` VALUES (394, '甘孜', 23, 'g', 'gz', 'ganzi', '藏族', '自治州', '513300', '0836', 20);
INSERT INTO `district` VALUES (395, '凉山', 23, 'l', 'ls', 'liangshan', '彝族', '自治州', '615000', '0834', 21);
INSERT INTO `district` VALUES (396, '贵阳', 24, 'g', 'gy', 'guiyang', '', '市', '520100', '0851', 1);
INSERT INTO `district` VALUES (397, '六盘水', 24, 'l', 'lps', 'liupanshui', '', '市', '520200', '0858', 2);
INSERT INTO `district` VALUES (398, '遵义', 24, 'z', 'zy', 'zunyi', '', '市', '520300', '0852', 3);
INSERT INTO `district` VALUES (399, '安顺', 24, 'a', 'as', 'anshun', '', '市', '520400', '0853', 4);
INSERT INTO `district` VALUES (400, '毕节', 24, 'b', 'bj', 'bijie', '', '市', '520500', '0857', 5);
INSERT INTO `district` VALUES (401, '铜仁', 24, 't', 'tr', 'tongren', '', '市', '520600', '0856', 6);
INSERT INTO `district` VALUES (402, '黔西南', 24, 'q', 'qxn', 'qianxinan', '布依族苗族', '自治州', '522300', '0859', 7);
INSERT INTO `district` VALUES (403, '黔东南', 24, 'q', 'qdn', 'qiandongnan', '苗族侗族', '自治州', '522600', '0855', 8);
INSERT INTO `district` VALUES (404, '黔南', 24, 'q', 'qn', 'qiannan', '布依族苗族', '自治州', '522700', '0854', 9);
INSERT INTO `district` VALUES (405, '昆明', 25, 'k', 'km', 'kunming', '', '市', '530100', '0871', 1);
INSERT INTO `district` VALUES (406, '曲靖', 25, 'q', 'qj', 'qujing', '', '市', '530300', '0874', 2);
INSERT INTO `district` VALUES (407, '玉溪', 25, 'y', 'yx', 'yuxi', '', '市', '530400', '0877', 3);
INSERT INTO `district` VALUES (408, '昭通', 25, 'z', 'zt', 'zhaotong', '', '市', '530600', '0870', 4);
INSERT INTO `district` VALUES (409, '丽江', 25, 'l', 'lj', 'lijiang', '', '市', '530700', '0888', 5);
INSERT INTO `district` VALUES (410, '普洱', 25, 'p', 'pe', 'puer', '', '市', '530800', '0879', 6);
INSERT INTO `district` VALUES (411, '临沧', 25, 'l', 'lc', 'lincang', '', '市', '530900', '0883', 7);
INSERT INTO `district` VALUES (412, '楚雄', 25, 'c', 'cx', 'chuxiong', '彝族', '自治州', '532300', '0878', 8);
INSERT INTO `district` VALUES (413, '红河', 25, 'h', 'hh', 'honghe', '哈尼族彝族', '自治州', '532500', '0873', 9);
INSERT INTO `district` VALUES (414, '文山', 25, 'w', 'ws', 'wenshan', '壮族苗族', '自治州', '532600', '0876', 10);
INSERT INTO `district` VALUES (415, '西双版纳', 25, 'x', 'xsbn', 'xishuangbanna', '傣族', '自治州', '532800', '0691', 11);
INSERT INTO `district` VALUES (416, '大理', 25, 'd', 'dl', 'dali', '白族', '自治州', '532900', '0872', 12);
INSERT INTO `district` VALUES (417, '德宏', 25, 'd', 'dh', 'dehong', '傣族景颇族', '自治州', '533100', '0692', 13);
INSERT INTO `district` VALUES (418, '怒江', 25, 'n', 'nj', 'nujiang', '傈僳族', '自治州', '533300', '0886', 14);
INSERT INTO `district` VALUES (419, '迪庆', 25, 'd', 'dq', 'diqing', '藏族', '自治州', '533400', '0887', 15);
INSERT INTO `district` VALUES (420, '保山', 25, 'b', 'bs', 'baoshan', '', '市', '678000', '0875', 16);
INSERT INTO `district` VALUES (421, '拉萨', 26, 'l', 'ls', 'lasa', '', '市', '540100', '0891', 1);
INSERT INTO `district` VALUES (422, '昌都', 26, 'c', 'cd', 'changdu', '', '市', '542100', '0895', 2);
INSERT INTO `district` VALUES (423, '山南', 26, 's', 'sn', 'shannan', '', '市', '540500', '0893', 3);
INSERT INTO `district` VALUES (424, '日喀则', 26, 'r', 'rkz', 'rikaze', '', '市', '542300', '0892', 4);
INSERT INTO `district` VALUES (425, '那曲', 26, 'n', 'nq', 'neiqu', '', '市', '540600', '0896', 5);
INSERT INTO `district` VALUES (426, '阿里', 26, 'a', 'al', 'ali', '', '地区', '542500', '0897', 6);
INSERT INTO `district` VALUES (427, '林芝', 26, 'l', 'lz', 'linzhi', '', '市', '540400', '0894', 7);
INSERT INTO `district` VALUES (428, '西安', 27, 'x', 'xa', 'xian', '', '市', '610100', '029', 1);
INSERT INTO `district` VALUES (429, '铜川', 27, 't', 'tc', 'tongchuan', '', '市', '610200', '0919', 2);
INSERT INTO `district` VALUES (430, '宝鸡', 27, 'b', 'bj', 'baoji', '', '市', '610300', '0917', 3);
INSERT INTO `district` VALUES (431, '咸阳', 27, 'x', 'xy', 'xianyang', '', '市', '610400', '029', 4);
INSERT INTO `district` VALUES (432, '渭南', 27, 'w', 'wn', 'weinan', '', '市', '610500', '0913', 5);
INSERT INTO `district` VALUES (433, '延安', 27, 'y', 'ya', 'yanan', '', '市', '610600', '0911', 6);
INSERT INTO `district` VALUES (434, '汉中', 27, 'h', 'hz', 'hanzhong', '', '市', '610700', '0916', 7);
INSERT INTO `district` VALUES (435, '榆林', 27, 'y', 'yl', 'yulin', '', '市', '610800', '0912', 8);
INSERT INTO `district` VALUES (436, '安康', 27, 'a', 'ak', 'ankang', '', '市', '610900', '0915', 9);
INSERT INTO `district` VALUES (437, '商洛', 27, 's', 'sl', 'shangluo', '', '市', '611000', '0914', 10);
INSERT INTO `district` VALUES (438, '兰州', 28, 'l', 'lz', 'lanzhou', '', '市', '620100', '0931', 1);
INSERT INTO `district` VALUES (439, '嘉峪关', 28, 'j', 'jyg', 'jiayuguan', '', '市', '620200', '0937', 2);
INSERT INTO `district` VALUES (440, '金昌', 28, 'j', 'jc', 'jinchang', '', '市', '620300', '0935', 3);
INSERT INTO `district` VALUES (441, '白银', 28, 'b', 'by', 'baiyin', '', '市', '620400', '0943', 4);
INSERT INTO `district` VALUES (442, '天水', 28, 't', 'ts', 'tianshui', '', '市', '620500', '0938', 5);
INSERT INTO `district` VALUES (443, '武威', 28, 'w', 'ww', 'wuwei', '', '市', '620600', '0935', 6);
INSERT INTO `district` VALUES (444, '张掖', 28, 'z', 'zy', 'zhangye', '', '市', '620700', '0936', 7);
INSERT INTO `district` VALUES (445, '平凉', 28, 'p', 'pl', 'pingliang', '', '市', '620800', '0933', 8);
INSERT INTO `district` VALUES (446, '酒泉', 28, 'j', 'jq', 'jiuquan', '', '市', '620900', '0937', 9);
INSERT INTO `district` VALUES (447, '庆阳', 28, 'q', 'qy', 'qingyang', '', '市', '621000', '0934', 10);
INSERT INTO `district` VALUES (448, '定西', 28, 'd', 'dx', 'dingxi', '', '市', '621100', '0932', 11);
INSERT INTO `district` VALUES (449, '陇南', 28, 'l', 'ln', 'longnan', '', '市', '621200', '0939', 12);
INSERT INTO `district` VALUES (450, '临夏', 28, 'l', 'lx', 'linxia', '回族', '自治州', '622900', '0930', 13);
INSERT INTO `district` VALUES (451, '甘南', 28, 'g', 'gn', 'gannan', '藏族', '自治州', '623000', '0941', 14);
INSERT INTO `district` VALUES (452, '西宁', 29, 'x', 'xn', 'xining', '', '市', '630100', '0971', 1);
INSERT INTO `district` VALUES (453, '海东', 29, 'h', 'hd', 'haidong', '', '市', '632100', '0972', 2);
INSERT INTO `district` VALUES (454, '海北', 29, 'h', 'hb', 'haibei', '藏族', '自治州', '632200', '0970', 3);
INSERT INTO `district` VALUES (455, '黄南', 29, 'h', 'hn', 'huangnan', '藏族', '自治州', '632300', '0973', 4);
INSERT INTO `district` VALUES (456, '海南', 29, 'h', 'hn', 'hainan', '藏族', '自治州', '632500', '0974', 5);
INSERT INTO `district` VALUES (457, '果洛', 29, 'g', 'gl', 'guoluo', '藏族', '自治州', '632600', '0975', 6);
INSERT INTO `district` VALUES (458, '玉树', 29, 'y', 'ys', 'yushu', '藏族', '自治州', '632700', '0976', 7);
INSERT INTO `district` VALUES (459, '海西', 29, 'h', 'hx', 'haixi', '蒙古族藏族', '自治州', '632800', '0977', 8);
INSERT INTO `district` VALUES (460, '银川', 30, 'y', 'yc', 'yinchuan', '', '市', '640100', '0951', 1);
INSERT INTO `district` VALUES (461, '石嘴山', 30, 's', 'szs', 'shizuishan', '', '市', '640200', '0952', 2);
INSERT INTO `district` VALUES (462, '吴忠', 30, 'w', 'wz', 'wuzhong', '', '市', '640300', '0953', 3);
INSERT INTO `district` VALUES (463, '固原', 30, 'g', 'gy', 'guyuan', '', '市', '640400', '0954', 4);
INSERT INTO `district` VALUES (464, '中卫', 30, 'z', 'zw', 'zhongwei', '', '市', '640500', '', 5);
INSERT INTO `district` VALUES (465, '乌鲁木齐', 31, 'w', 'wlmq', 'wulumuqi', '', '市', '650100', '0991', 1);
INSERT INTO `district` VALUES (466, '克拉玛依', 31, 'k', 'klmy', 'kelamayi', '', '市', '650200', '0990', 2);
INSERT INTO `district` VALUES (467, '吐鲁番', 31, 't', 'tlf', 'tulufan', '', '市', '652100', '0995', 3);
INSERT INTO `district` VALUES (468, '哈密', 31, 'h', 'hm', 'hami', '', '市', '652200', '0902', 4);
INSERT INTO `district` VALUES (469, '昌吉', 31, 'c', 'cj', 'changji', '', '自治州', '652300', '0994', 5);
INSERT INTO `district` VALUES (470, '博尔塔拉', 31, 'b', 'betl', 'boertala', '蒙古', '自治州', '652700', '0909', 6);
INSERT INTO `district` VALUES (471, '巴音郭楞', 31, 'b', 'bygl', 'bayinguoleng', '蒙古', '自治州', '652800', '0996', 7);
INSERT INTO `district` VALUES (472, '阿克苏', 31, 'a', 'aks', 'akesu', '柯尔克孜', '地区', '652900', '0997', 8);
INSERT INTO `district` VALUES (473, '克孜勒苏', 31, 'k', 'kzls', 'kezilesu', '', '自治州', '653000', '0908', 9);
INSERT INTO `district` VALUES (474, '喀什', 31, 'k', 'ks', 'kashi', '', '地区', '653100', '0998', 10);
INSERT INTO `district` VALUES (475, '和田', 31, 'h', 'ht', 'hetian', '哈萨克', '地区', '653200', '0903', 11);
INSERT INTO `district` VALUES (476, '伊犁', 31, 'y', 'yl', 'yili', '', '自治州', '654000', '0999', 12);
INSERT INTO `district` VALUES (477, '塔城', 31, 't', 'tc', 'tacheng', '', '地区', '654200', '0901', 13);
INSERT INTO `district` VALUES (478, '阿勒泰', 31, 'a', 'alt', 'aletai', '', '地区', '654300', '0906', 14);
INSERT INTO `district` VALUES (479, '石河子', 31, 's', 'shz', 'shihezi', '', '市', '659001', '0993', 15);
INSERT INTO `district` VALUES (480, '阿拉尔', 31, 'a', 'ale', 'alaer', '', '市', '659002', '0997', 16);
INSERT INTO `district` VALUES (481, '图木舒克', 31, 't', 'tmsk', 'tumushuke', '', '市', '659003', '0998', 17);
INSERT INTO `district` VALUES (482, '五家渠', 31, 'w', 'wjq', 'wujiaqu', '', '市', '659004', '0994', 18);
INSERT INTO `district` VALUES (483, '北屯', 31, 'b', 'bt', 'beitun', '', '市', '659005', '0906', 19);
INSERT INTO `district` VALUES (484, '铁门关', 31, 't', 'tmg', 'tiemenguan', '', '市', '659006', '0996', 20);
INSERT INTO `district` VALUES (485, '台北', 32, 't', 'tb', 'taibei', '', '市', '63', '02', 1);
INSERT INTO `district` VALUES (486, '高雄', 32, 'g', 'gx', 'gaoxiong', '', '市', '64', '07', 2);
INSERT INTO `district` VALUES (487, '基隆', 32, 'j', 'jl', 'jilong', '', '市', '10017', '02', 3);
INSERT INTO `district` VALUES (488, '台中', 32, 't', 'tz', 'taizhong', '', '市', '10019', '04', 4);
INSERT INTO `district` VALUES (489, '台南', 32, 't', 'tn', 'tainan', '', '市', '10021', '06', 5);
INSERT INTO `district` VALUES (490, '新竹', 32, 'x', 'xz', 'xinzhu', '', '市', '10018', '', 6);
INSERT INTO `district` VALUES (491, '嘉义', 32, 'j', 'jy', 'jiayi', '', '市', '10020', '05', 7);
INSERT INTO `district` VALUES (492, '新北', 32, 'x', 'xb', 'xinbei', '', '市', '', '', 8);
INSERT INTO `district` VALUES (493, '宜兰', 32, 'y', 'yl', 'yilan', '', '县', '10002', '', 9);
INSERT INTO `district` VALUES (494, '桃园', 32, 't', 'ty', 'taoyuan', '', '县', '10003', '', 10);
INSERT INTO `district` VALUES (495, '新竹', 32, 'x', 'xz', 'xinzhu', '', '县', '10004', '', 11);
INSERT INTO `district` VALUES (496, '苗栗', 32, 'm', 'ml', 'miaoli', '', '县', '10005', '', 12);
INSERT INTO `district` VALUES (497, '彰化', 32, 'z', 'zh', 'zhanghua', '', '县', '10007', '', 13);
INSERT INTO `district` VALUES (498, '南投', 32, 'n', 'nt', 'nantou', '', '县', '10008', '', 14);
INSERT INTO `district` VALUES (499, '云林', 32, 'y', 'yl', 'yunlin', '', '县', '10009', '', 15);
INSERT INTO `district` VALUES (500, '嘉义', 32, 'j', 'jy', 'jiayi', '', '县', '10020', '', 16);
INSERT INTO `district` VALUES (501, '屏东', 32, 'p', 'pd', 'pingdong', '', '县', '10013', '', 17);
INSERT INTO `district` VALUES (502, '台东', 32, 't', 'td', 'taidong', '', '县', '10014', '', 18);
INSERT INTO `district` VALUES (503, '花莲', 32, 'h', 'hl', 'hualian', '', '县', '10015', '', 19);
INSERT INTO `district` VALUES (504, '澎湖', 32, 'p', 'ph', 'penghu', '', '县', '10016', '07', 20);
INSERT INTO `district` VALUES (505, '连江', 32, 'l', 'lj', 'lianjiang', '', '县', '', '', 21);
INSERT INTO `district` VALUES (506, '金门', 32, 'j', 'jm', 'jinmen', '', '县', '', '', 22);
INSERT INTO `district` VALUES (507, '中西', 33, 'z', 'zx', 'zhongxi', '', '区', '', '852', 1);
INSERT INTO `district` VALUES (508, '葵青', 33, 'k', 'kq', 'kuiqing', '', '区', '', '852', 2);
INSERT INTO `district` VALUES (509, '元朗', 33, 'y', 'yl', 'yuanlang', '', '区', '', '852', 3);
INSERT INTO `district` VALUES (510, '屯门', 33, 't', 'tm', 'tunmen', '', '区', '', '852', 4);
INSERT INTO `district` VALUES (511, '荃湾', 33, 'q', 'qw', 'quanwan', '', '区', '', '852', 5);
INSERT INTO `district` VALUES (512, '西贡', 33, 'x', 'xg', 'xigong', '', '区', '', '852', 6);
INSERT INTO `district` VALUES (513, '沙田', 33, 's', 'st', 'shatian', '', '区', '', '852', 7);
INSERT INTO `district` VALUES (514, '大埔', 33, 'd', 'dp', 'dapu', '', '区', '', '852', 8);
INSERT INTO `district` VALUES (515, '北区', 33, 'b', 'bq', 'beiqu', '', '', '', '852', 9);
INSERT INTO `district` VALUES (516, '观塘', 33, 'g', 'gt', 'guantang', '', '区', '', '852', 10);
INSERT INTO `district` VALUES (517, '黄大仙', 33, 'h', 'hdx', 'huangdaxian', '', '区', '', '852', 11);
INSERT INTO `district` VALUES (518, '深水埗', 33, 's', 'ssb', 'shenshuibu', '', '区', '', '852', 12);
INSERT INTO `district` VALUES (519, '油尖旺', 33, 'y', 'yjw', 'youjianwang', '', '区', '', '852', 13);
INSERT INTO `district` VALUES (520, '九龙城', 33, 'j', 'jlc', 'jiulongcheng', '', '区', '', '852', 14);
INSERT INTO `district` VALUES (521, '南区', 33, 'n', 'nq', 'nanqu', '', '', '', '852', 15);
INSERT INTO `district` VALUES (522, '东区', 33, 'd', 'dq', 'dongqu', '', '', '', '852', 16);
INSERT INTO `district` VALUES (523, '湾仔', 33, 'w', 'wz', 'wanzi', '', '区', '', '852', 17);
INSERT INTO `district` VALUES (524, '离岛', 33, 'l', 'ld', 'lidao', '', '区', '', '852', 18);
INSERT INTO `district` VALUES (525, '花地玛', 34, 'h', 'hdm', 'huadima', '', '堂区', '', '853', 1);
INSERT INTO `district` VALUES (526, '圣安多', 34, 's', 'sad', 'shenganduo', '', '堂区', '', '853', 2);
INSERT INTO `district` VALUES (527, '大堂区', 34, 'd', 'dtq', 'datangqu', '', '堂区', '', '853', 3);
INSERT INTO `district` VALUES (528, '望德', 34, 'w', 'wd', 'wangde', '', '堂区', '', '853', 4);
INSERT INTO `district` VALUES (529, '风顺', 34, 'f', 'fs', 'fengshun', '', '堂区', '', '853', 5);
INSERT INTO `district` VALUES (530, '嘉模', 34, 'j', 'jm', 'jiamo', '', '堂区', '', '853', 6);
INSERT INTO `district` VALUES (531, '圣方济各', 34, 's', 'sfjg', 'shengfangjige', '', '堂区', '', '853', 7);
INSERT INTO `district` VALUES (532, '路氹城', 34, 'l', 'ldc', 'ludangcheng', '', '', '', '853', 8);
INSERT INTO `district` VALUES (533, '长安', 125, 'c', 'ca', 'changan', '', '区', '130102', '0311', 1);
INSERT INTO `district` VALUES (535, '桥西', 125, 'q', 'qx', 'qiaoxi', '', '区', '130104', '0311', 2);
INSERT INTO `district` VALUES (536, '新华', 125, 'x', 'xh', 'xinhua', '', '区', '130105', '0311', 3);
INSERT INTO `district` VALUES (537, '井陉矿', 125, 'j', 'jxk', 'jingxingkuang', '', '区', '130107', '0311', 4);
INSERT INTO `district` VALUES (538, '裕华', 125, 'y', 'yh', 'yuhua', '', '区', '130108', '0311', 5);
INSERT INTO `district` VALUES (539, '井陉', 125, 'j', 'jx', 'jingxing', '', '县', '130121', '0311', 9);
INSERT INTO `district` VALUES (540, '正定', 125, 'z', 'zd', 'zhengding', '', '县', '130123', '0311', 10);
INSERT INTO `district` VALUES (541, '栾城', 125, 'l', 'lc', 'luancheng', '', '区', '130111', '0311', 8);
INSERT INTO `district` VALUES (542, '行唐', 125, 'x', 'xt', 'xingtang', '', '县', '130125', '0311', 11);
INSERT INTO `district` VALUES (543, '灵寿', 125, 'l', 'ls', 'lingshou', '', '县', '130126', '0311', 12);
INSERT INTO `district` VALUES (544, '高邑', 125, 'g', 'gy', 'gaoyi', '', '县', '130127', '0311', 13);
INSERT INTO `district` VALUES (545, '深泽', 125, 's', 'sz', 'shenze', '', '县', '130128', '0311', 14);
INSERT INTO `district` VALUES (546, '赞皇', 125, 'z', 'zh', 'zanhuang', '', '县', '130129', '0311', 15);
INSERT INTO `district` VALUES (547, '无极', 125, 'w', 'wj', 'wuji', '', '县', '130130', '0311', 16);
INSERT INTO `district` VALUES (548, '平山', 125, 'p', 'ps', 'pingshan', '', '县', '130131', '0311', 17);
INSERT INTO `district` VALUES (549, '元氏', 125, 'y', 'ys', 'yuanshi', '', '县', '130132', '0311', 18);
INSERT INTO `district` VALUES (550, '赵县', 125, 'z', 'zx', 'zhaoxian', '', '', '130133', '0311', 19);
INSERT INTO `district` VALUES (551, '辛集', 125, 'x', 'xj', 'xinji', '', '市', '130181', '0311', 20);
INSERT INTO `district` VALUES (552, '藁城', 125, 'g', 'gc', 'gaocheng', '', '区', '130109', '0311', 6);
INSERT INTO `district` VALUES (553, '晋州', 125, 'j', 'jz', 'jinzhou', '', '市', '130183', '0311', 21);
INSERT INTO `district` VALUES (554, '新乐', 125, 'x', 'xl', 'xinle', '', '市', '130184', '0311', 22);
INSERT INTO `district` VALUES (555, '鹿泉', 125, 'l', 'lq', 'luquan', '', '区', '130110', '0311', 7);
INSERT INTO `district` VALUES (556, '路南', 126, 'l', 'ln', 'lunan', '', '区', '130202', '0315', 1);
INSERT INTO `district` VALUES (557, '路北', 126, 'l', 'lb', 'lubei', '', '区', '130203', '0315', 2);
INSERT INTO `district` VALUES (558, '古冶', 126, 'g', 'gy', 'guye', '', '区', '130204', '0315', 3);
INSERT INTO `district` VALUES (559, '开平', 126, 'k', 'kp', 'kaiping', '', '区', '130205', '0315', 4);
INSERT INTO `district` VALUES (560, '丰南', 126, 'f', 'fn', 'fengnan', '', '区', '130207', '0315', 5);
INSERT INTO `district` VALUES (561, '丰润', 126, 'f', 'fr', 'fengrun', '', '区', '130208', '0315', 6);
INSERT INTO `district` VALUES (562, '滦州', 126, 'l', 'lz', 'luanzhou', '', '市', '130223', '0315', 7);
INSERT INTO `district` VALUES (563, '滦南', 126, 'l', 'ln', 'luannan', '', '县', '130224', '0315', 8);
INSERT INTO `district` VALUES (564, '乐亭', 126, 'l', 'lt', 'leting', '', '县', '130225', '0315', 9);
INSERT INTO `district` VALUES (565, '迁西', 126, 'q', 'qx', 'qianxi', '', '县', '130227', '0315', 10);
INSERT INTO `district` VALUES (566, '玉田', 126, 'y', 'yt', 'yutian', '', '县', '130229', '0315', 11);
INSERT INTO `district` VALUES (567, '唐海', 126, 't', 'th', 'tanghai', '', '县', '130230', '0315', 12);
INSERT INTO `district` VALUES (568, '遵化', 126, 'z', 'zh', 'zunhua', '', '市', '130281', '0315', 13);
INSERT INTO `district` VALUES (569, '迁安', 126, 'q', 'qa', 'qianan', '', '市', '130283', '0315', 14);
INSERT INTO `district` VALUES (570, '海港', 127, 'h', 'hg', 'haigang', '', '区', '130302', '0335', 1);
INSERT INTO `district` VALUES (571, '山海关', 127, 's', 'shg', 'shanhaiguan', '', '区', '130303', '0335', 2);
INSERT INTO `district` VALUES (572, '北戴河', 127, 'b', 'bdh', 'beidaihe', '', '区', '130304', '0335', 3);
INSERT INTO `district` VALUES (573, '青龙', 127, 'q', 'ql', 'qinglong', '满族', '自治县', '130321', '0335', 4);
INSERT INTO `district` VALUES (574, '昌黎', 127, 'c', 'cl', 'changli', '', '县', '130322', '0335', 5);
INSERT INTO `district` VALUES (575, '抚宁', 127, 'f', 'fn', 'funing', '', '区', '130323', '0335', 6);
INSERT INTO `district` VALUES (576, '卢龙', 127, 'l', 'll', 'lulong', '', '县', '130324', '0335', 7);
INSERT INTO `district` VALUES (577, '邯山', 128, 'h', 'hs', 'hanshan', '', '区', '130402', '0310', 1);
INSERT INTO `district` VALUES (578, '丛台', 128, 'c', 'ct', 'congtai', '', '区', '130403', '0310', 2);
INSERT INTO `district` VALUES (579, '复兴', 128, 'f', 'fx', 'fuxing', '', '区', '130404', '0310', 3);
INSERT INTO `district` VALUES (580, '峰峰矿', 128, 'f', 'ffk', 'fengfengkuang', '', '区', '130406', '0310', 4);
INSERT INTO `district` VALUES (582, '临漳', 128, 'l', 'lz', 'linzhang', '', '县', '130423', '0310', 7);
INSERT INTO `district` VALUES (583, '成安', 128, 'c', 'ca', 'chengan', '', '县', '130424', '0310', 8);
INSERT INTO `district` VALUES (584, '大名', 128, 'd', 'dm', 'daming', '', '县', '130425', '0310', 9);
INSERT INTO `district` VALUES (585, '涉县', 128, 's', 'sx', 'shexian', '', '', '130426', '0310', 10);
INSERT INTO `district` VALUES (586, '磁县', 128, 'c', 'cx', 'cixian', '', '', '130427', '0310', 11);
INSERT INTO `district` VALUES (587, '肥乡', 128, 'f', 'fx', 'feixiang', '', '区', '130407', '0310', 5);
INSERT INTO `district` VALUES (588, '永年', 128, 'y', 'yn', 'yongnian', '', '区', '130408', '0310', 6);
INSERT INTO `district` VALUES (589, '邱县', 128, 'q', 'qx', 'qiuxian', '', '', '130430', '0310', 12);
INSERT INTO `district` VALUES (590, '鸡泽', 128, 'j', 'jz', 'jize', '', '县', '130431', '0310', 13);
INSERT INTO `district` VALUES (591, '广平', 128, 'g', 'gp', 'guangping', '', '县', '130432', '0310', 14);
INSERT INTO `district` VALUES (592, '馆陶', 128, 'g', 'gt', 'guantao', '', '县', '130433', '0310', 15);
INSERT INTO `district` VALUES (593, '魏县', 128, 'w', 'wx', 'weixian', '', '', '130434', '0310', 16);
INSERT INTO `district` VALUES (594, '曲周', 128, 'q', 'qz', 'quzhou', '', '县', '130435', '0310', 17);
INSERT INTO `district` VALUES (595, '武安', 128, 'w', 'wa', 'wuan', '', '市', '130481', '0310', 18);
INSERT INTO `district` VALUES (596, '桥东', 129, 'q', 'qd', 'qiaodong', '', '区', '130502', '0319', 1);
INSERT INTO `district` VALUES (597, '桥西', 129, 'q', 'qx', 'qiaoxi', '', '区', '130503', '0319', 2);
INSERT INTO `district` VALUES (598, '邢台', 129, 'x', 'xt', 'xingtai', '', '县', '130521', '0319', 3);
INSERT INTO `district` VALUES (599, '临城', 129, 'l', 'lc', 'lincheng', '', '县', '130522', '0319', 4);
INSERT INTO `district` VALUES (600, '内丘', 129, 'n', 'nq', 'neiqiu', '', '县', '130523', '0319', 5);
INSERT INTO `district` VALUES (601, '柏乡', 129, 'b', 'bx', 'boxiang', '', '县', '130524', '0319', 6);
INSERT INTO `district` VALUES (602, '隆尧', 129, 'l', 'ly', 'longyao', '', '县', '130525', '0319', 7);
INSERT INTO `district` VALUES (603, '任县', 129, 'r', 'rx', 'renxian', '', '', '130526', '0319', 8);
INSERT INTO `district` VALUES (604, '南和', 129, 'n', 'nh', 'nanhe', '', '县', '130527', '0319', 9);
INSERT INTO `district` VALUES (605, '宁晋', 129, 'n', 'nj', 'ningjin', '', '县', '130528', '0319', 10);
INSERT INTO `district` VALUES (606, '巨鹿', 129, 'j', 'jl', 'julu', '', '县', '130529', '0319', 11);
INSERT INTO `district` VALUES (607, '新河', 129, 'x', 'xh', 'xinhe', '', '县', '130530', '0319', 12);
INSERT INTO `district` VALUES (608, '广宗', 129, 'g', 'gz', 'guangzong', '', '县', '130531', '0319', 13);
INSERT INTO `district` VALUES (609, '平乡', 129, 'p', 'px', 'pingxiang', '', '县', '130532', '0319', 14);
INSERT INTO `district` VALUES (610, '威县', 129, 'w', 'wx', 'weixian', '', '', '130533', '0319', 15);
INSERT INTO `district` VALUES (611, '清河', 129, 'q', 'qh', 'qinghe', '', '县', '130534', '0319', 16);
INSERT INTO `district` VALUES (612, '临西', 129, 'l', 'lx', 'linxi', '', '县', '130535', '0319', 17);
INSERT INTO `district` VALUES (613, '南宫', 129, 'n', 'ng', 'nangong', '', '市', '130581', '0319', 18);
INSERT INTO `district` VALUES (614, '沙河', 129, 's', 'sh', 'shahe', '', '市', '130582', '0319', 19);
INSERT INTO `district` VALUES (615, '竞秀', 130, 'j', 'jx', 'jingxiu', '', '区', '130602', '0312', 1);
INSERT INTO `district` VALUES (616, '莲池', 130, 'l', 'lc', 'lianchi', '', '区', '130603', '0312', 2);
INSERT INTO `district` VALUES (618, '满城', 130, 'm', 'mc', 'mancheng', '', '区', '130621', '0312', 4);
INSERT INTO `district` VALUES (619, '清苑', 130, 'q', 'qy', 'qingyuan', '', '区', '130622', '0312', 5);
INSERT INTO `district` VALUES (620, '涞水', 130, 'l', 'ls', 'laishui', '', '县', '130623', '0312', 6);
INSERT INTO `district` VALUES (621, '阜平', 130, 'f', 'fp', 'fuping', '', '县', '130624', '0312', 7);
INSERT INTO `district` VALUES (622, '徐水', 130, 'x', 'xs', 'xushui', '', '区', '130625', '0312', 8);
INSERT INTO `district` VALUES (623, '定兴', 130, 'd', 'dx', 'dingxing', '', '县', '130626', '0312', 9);
INSERT INTO `district` VALUES (624, '唐县', 130, 't', 'tx', 'tangxian', '', '', '130627', '0312', 10);
INSERT INTO `district` VALUES (625, '高阳', 130, 'g', 'gy', 'gaoyang', '', '县', '130628', '0312', 11);
INSERT INTO `district` VALUES (626, '容城', 130, 'r', 'rc', 'rongcheng', '', '县', '130629', '0312', 12);
INSERT INTO `district` VALUES (627, '涞源', 130, 'l', 'ly', 'laiyuan', '', '县', '130630', '0312', 13);
INSERT INTO `district` VALUES (628, '望都', 130, 'w', 'wd', 'wangdu', '', '县', '130631', '0312', 14);
INSERT INTO `district` VALUES (629, '安新', 130, 'a', 'ax', 'anxin', '', '县', '130632', '0312', 15);
INSERT INTO `district` VALUES (630, '易县', 130, 'y', 'yx', 'yixian', '', '', '130633', '0312', 16);
INSERT INTO `district` VALUES (631, '曲阳', 130, 'q', 'qy', 'quyang', '', '县', '130634', '0312', 17);
INSERT INTO `district` VALUES (632, '蠡县', 130, 'l', 'lx', 'lixian', '', '', '130635', '0312', 18);
INSERT INTO `district` VALUES (633, '顺平', 130, 's', 'sp', 'shunping', '', '县', '130636', '0312', 19);
INSERT INTO `district` VALUES (634, '博野', 130, 'b', 'by', 'boye', '', '县', '130637', '0312', 20);
INSERT INTO `district` VALUES (635, '雄县', 130, 'x', 'xx', 'xiongxian', '', '', '130638', '0312', 21);
INSERT INTO `district` VALUES (636, '涿州', 130, 'z', 'zz', 'zhuozhou', '', '市', '130681', '0312', 22);
INSERT INTO `district` VALUES (637, '定州', 130, 'd', 'dz', 'dingzhou', '', '市', '130682', '0312', 23);
INSERT INTO `district` VALUES (638, '安国', 130, 'a', 'ag', 'anguo', '', '市', '130683', '0312', 24);
INSERT INTO `district` VALUES (639, '高碑店', 130, 'g', 'gbd', 'gaobeidian', '', '市', '130684', '0312', 25);
INSERT INTO `district` VALUES (640, '桥东', 131, 'q', 'qd', 'qiaodong', '', '区', '130702', '0313', 1);
INSERT INTO `district` VALUES (641, '桥西', 131, 'q', 'qx', 'qiaoxi', '', '区', '130703', '0313', 2);
INSERT INTO `district` VALUES (642, '宣化', 131, 'x', 'xh', 'xuanhua', '', '区', '130705', '0313', 3);
INSERT INTO `district` VALUES (643, '下花园', 131, 'x', 'xhy', 'xiahuayuan', '', '区', '130706', '0313', 4);
INSERT INTO `district` VALUES (645, '张北', 131, 'z', 'zb', 'zhangbei', '', '县', '130722', '0313', 7);
INSERT INTO `district` VALUES (646, '康保', 131, 'k', 'kb', 'kangbao', '', '县', '130723', '0313', 8);
INSERT INTO `district` VALUES (647, '沽源', 131, 'g', 'gy', 'guyuan', '', '县', '130724', '0313', 9);
INSERT INTO `district` VALUES (648, '尚义', 131, 's', 'sy', 'shangyi', '', '县', '130725', '0313', 10);
INSERT INTO `district` VALUES (649, '蔚县', 131, 'y', 'yx', 'yuxian', '', '', '130726', '0313', 11);
INSERT INTO `district` VALUES (650, '阳原', 131, 'y', 'yy', 'yangyuan', '', '县', '130727', '0313', 12);
INSERT INTO `district` VALUES (651, '怀安', 131, 'h', 'ha', 'huaian', '', '县', '130728', '0313', 13);
INSERT INTO `district` VALUES (652, '万全', 131, 'w', 'wq', 'wanquan', '', '区', '130708', '0313', 5);
INSERT INTO `district` VALUES (653, '怀来', 131, 'h', 'hl', 'huailai', '', '县', '130730', '0313', 14);
INSERT INTO `district` VALUES (654, '涿鹿', 131, 'z', 'zl', 'zhuolu', '', '县', '130731', '0313', 15);
INSERT INTO `district` VALUES (655, '赤城', 131, 'c', 'cc', 'chicheng', '', '县', '130732', '0313', 16);
INSERT INTO `district` VALUES (656, '崇礼', 131, 'c', 'cl', 'chongli', '', '区', '130709', '0313', 6);
INSERT INTO `district` VALUES (657, '双桥', 132, 's', 'sq', 'shuangqiao', '', '区', '130802', '0314', 1);
INSERT INTO `district` VALUES (658, '双滦', 132, 's', 'sl', 'shuangluan', '', '区', '130803', '0314', 2);
INSERT INTO `district` VALUES (659, '鹰手营子', 132, 'y', 'ysyz', 'yingshouyingzi', '矿', '区', '130804', '0314', 3);
INSERT INTO `district` VALUES (660, '承德', 132, 'c', 'cd', 'chengde', '', '县', '130821', '0314', 4);
INSERT INTO `district` VALUES (661, '兴隆', 132, 'x', 'xl', 'xinglong', '', '县', '130822', '0314', 5);
INSERT INTO `district` VALUES (662, '平泉', 132, 'p', 'pq', 'pingquan', '', '市', '130881', '0314', 11);
INSERT INTO `district` VALUES (663, '滦平', 132, 'l', 'lp', 'luanping', '', '县', '130824', '0314', 6);
INSERT INTO `district` VALUES (664, '隆化', 132, 'l', 'lh', 'longhua', '', '县', '130825', '0314', 7);
INSERT INTO `district` VALUES (665, '丰宁', 132, 'f', 'fn', 'fengning', '满族', '自治县', '130826', '0314', 8);
INSERT INTO `district` VALUES (666, '宽城', 132, 'k', 'kc', 'kuancheng', '满族', '自治县', '130827', '0314', 9);
INSERT INTO `district` VALUES (667, '围场', 132, 'w', 'wc', 'weichang', '满族蒙古族', '自治县', '130828', '0314', 10);
INSERT INTO `district` VALUES (668, '新华', 133, 'x', 'xh', 'xinhua', '', '区', '130902', '0317', 1);
INSERT INTO `district` VALUES (669, '运河', 133, 'y', 'yh', 'yunhe', '', '区', '130903', '0317', 2);
INSERT INTO `district` VALUES (670, '沧县', 133, 'c', 'cx', 'cangxian', '', '', '130921', '0317', 3);
INSERT INTO `district` VALUES (671, '青县', 133, 'q', 'qx', 'qingxian', '', '', '130922', '0317', 4);
INSERT INTO `district` VALUES (672, '东光', 133, 'd', 'dg', 'dongguang', '', '县', '130923', '0317', 5);
INSERT INTO `district` VALUES (673, '海兴', 133, 'h', 'hx', 'haixing', '', '县', '130924', '0317', 6);
INSERT INTO `district` VALUES (674, '盐山', 133, 'y', 'ys', 'yanshan', '', '县', '130925', '0317', 7);
INSERT INTO `district` VALUES (675, '肃宁', 133, 's', 'sn', 'suning', '', '县', '130926', '0317', 8);
INSERT INTO `district` VALUES (676, '南皮', 133, 'n', 'np', 'nanpi', '', '县', '130927', '0317', 9);
INSERT INTO `district` VALUES (677, '吴桥', 133, 'w', 'wq', 'wuqiao', '', '县', '130928', '0317', 10);
INSERT INTO `district` VALUES (678, '献县', 133, 'x', 'xx', 'xianxian', '', '', '130929', '0317', 11);
INSERT INTO `district` VALUES (679, '孟村', 133, 'm', 'mc', 'mengcun', '回族', '自治县', '130930', '0317', 12);
INSERT INTO `district` VALUES (680, '泊头', 133, 'b', 'bt', 'botou', '', '市', '130981', '0317', 13);
INSERT INTO `district` VALUES (681, '任丘', 133, 'r', 'rq', 'renqiu', '', '市', '130982', '0317', 14);
INSERT INTO `district` VALUES (682, '黄骅', 133, 'h', 'hh', 'huanghua', '', '市', '130983', '0317', 15);
INSERT INTO `district` VALUES (683, '河间', 133, 'h', 'hj', 'hejian', '', '市', '130984', '0317', 16);
INSERT INTO `district` VALUES (684, '安次', 134, 'a', 'ac', 'anci', '', '区', '131002', '0316', 1);
INSERT INTO `district` VALUES (685, '广阳', 134, 'g', 'gy', 'guangyang', '', '区', '131003', '0316', 2);
INSERT INTO `district` VALUES (686, '固安', 134, 'g', 'ga', 'guan', '', '县', '131022', '0316', 3);
INSERT INTO `district` VALUES (687, '永清', 134, 'y', 'yq', 'yongqing', '', '县', '131023', '0316', 4);
INSERT INTO `district` VALUES (688, '香河', 134, 'x', 'xh', 'xianghe', '', '县', '131024', '0316', 5);
INSERT INTO `district` VALUES (689, '大城', 134, 'd', 'dc', 'dacheng', '', '县', '131025', '0316', 6);
INSERT INTO `district` VALUES (690, '文安', 134, 'w', 'wa', 'wenan', '', '县', '131026', '0316', 7);
INSERT INTO `district` VALUES (691, '大厂', 134, 'd', 'dc', 'dachang', '回族', '自治县', '131028', '0316', 8);
INSERT INTO `district` VALUES (692, '霸州', 134, 'b', 'bz', 'bazhou', '', '市', '131081', '0316', 9);
INSERT INTO `district` VALUES (693, '三河', 134, 's', 'sh', 'sanhe', '', '市', '131082', '0316', 10);
INSERT INTO `district` VALUES (694, '桃城', 135, 't', 'tc', 'taocheng', '', '区', '131102', '0318', 1);
INSERT INTO `district` VALUES (695, '枣强', 135, 'z', 'zq', 'zaoqiang', '', '县', '131121', '0318', 3);
INSERT INTO `district` VALUES (696, '武邑', 135, 'w', 'wy', 'wuyi', '', '县', '131122', '0318', 4);
INSERT INTO `district` VALUES (697, '武强', 135, 'w', 'wq', 'wuqiang', '', '县', '131123', '0318', 5);
INSERT INTO `district` VALUES (698, '饶阳', 135, 'r', 'ry', 'raoyang', '', '县', '131124', '0318', 6);
INSERT INTO `district` VALUES (699, '安平', 135, 'a', 'ap', 'anping', '', '县', '131125', '0318', 7);
INSERT INTO `district` VALUES (700, '故城', 135, 'g', 'gc', 'gucheng', '', '县', '131126', '0318', 8);
INSERT INTO `district` VALUES (701, '景县', 135, 'j', 'jx', 'jingxian', '', '', '131127', '0318', 9);
INSERT INTO `district` VALUES (702, '阜城', 135, 'f', 'fc', 'fucheng', '', '县', '131128', '0318', 10);
INSERT INTO `district` VALUES (703, '冀州', 135, 'j', 'jz', 'jizhou', '', '区', '131103', '0318', 2);
INSERT INTO `district` VALUES (704, '深州', 135, 's', 'sz', 'shenzhou', '', '市', '131182', '0318', 11);
INSERT INTO `district` VALUES (705, '小店', 136, 'x', 'xd', 'xiaodian', '', '区', '140105', '0351', 1);
INSERT INTO `district` VALUES (706, '迎泽', 136, 'y', 'yz', 'yingze', '', '区', '140106', '0351', 2);
INSERT INTO `district` VALUES (707, '杏花岭', 136, 'x', 'xhl', 'xinghualing', '', '区', '140107', '0351', 3);
INSERT INTO `district` VALUES (708, '尖草坪', 136, 'j', 'jcp', 'jiancaoping', '', '区', '140108', '0351', 4);
INSERT INTO `district` VALUES (709, '万柏林', 136, 'w', 'wbl', 'wanbolin', '', '区', '140109', '0351', 5);
INSERT INTO `district` VALUES (710, '晋源', 136, 'j', 'jy', 'jinyuan', '', '区', '140110', '0351', 6);
INSERT INTO `district` VALUES (711, '清徐', 136, 'q', 'qx', 'qingxu', '', '县', '140121', '0351', 7);
INSERT INTO `district` VALUES (712, '阳曲', 136, 'y', 'yq', 'yangqu', '', '县', '140122', '0351', 8);
INSERT INTO `district` VALUES (713, '娄烦', 136, 'l', 'lf', 'loufan', '', '县', '140123', '0351', 9);
INSERT INTO `district` VALUES (714, '古交', 136, 'g', 'gj', 'gujiao', '', '市', '140181', '0351', 10);
INSERT INTO `district` VALUES (715, '平城', 137, 'p', 'pc', 'pingcheng', '', '区', '140213', '0352', 2);
INSERT INTO `district` VALUES (716, '云冈', 137, 'y', 'yg', 'yugang', '', '', '140214', '0352', 3);
INSERT INTO `district` VALUES (718, '新荣', 137, 'x', 'xr', 'xinrong', '', '区', '140212', '0352', 1);
INSERT INTO `district` VALUES (719, '阳高', 137, 'y', 'yg', 'yanggao', '', '县', '140221', '0352', 5);
INSERT INTO `district` VALUES (720, '天镇', 137, 't', 'tz', 'tianzhen', '', '县', '140222', '0352', 6);
INSERT INTO `district` VALUES (721, '广灵', 137, 'g', 'gl', 'guangling', '', '县', '140223', '0352', 7);
INSERT INTO `district` VALUES (722, '灵丘', 137, 'l', 'lq', 'lingqiu', '', '县', '140224', '0352', 8);
INSERT INTO `district` VALUES (723, '浑源', 137, 'h', 'hy', 'hunyuan', '', '县', '140225', '0352', 9);
INSERT INTO `district` VALUES (724, '左云', 137, 'z', 'zy', 'zuoyun', '', '县', '140226', '0352', 10);
INSERT INTO `district` VALUES (725, '云州', 137, 'y', 'yz', 'yunzhou', '', '区', '140215', '0352', 4);
INSERT INTO `district` VALUES (726, '城区', 138, 'c', 'cq', 'chengqu', '', '', '140302', '0353', 1);
INSERT INTO `district` VALUES (727, '矿区', 138, 'k', 'kq', 'kuangqu', '', '', '140303', '0353', 2);
INSERT INTO `district` VALUES (728, '郊区', 138, 'j', 'jq', 'jiaoqu', '', '', '140311', '0353', 3);
INSERT INTO `district` VALUES (729, '平定', 138, 'p', 'pd', 'pingding', '', '县', '140321', '0353', 4);
INSERT INTO `district` VALUES (730, '盂县', 138, 'y', 'yx', 'yuxian', '', '', '140322', '0353', 5);
INSERT INTO `district` VALUES (731, '潞州', 139, 'l', 'lz', 'luzhou', '', '', '140403', '0355', 1);
INSERT INTO `district` VALUES (733, '上党', 139, 's', 'sd', 'shangdang', '', '区', '140404', '0355', 2);
INSERT INTO `district` VALUES (734, '襄垣', 139, 'x', 'xy', 'xiangyuan', '', '县', '140423', '0355', 5);
INSERT INTO `district` VALUES (735, '屯留', 139, 't', 'tl', 'tunliu', '', '区', '140405', '0355', 3);
INSERT INTO `district` VALUES (736, '平顺', 139, 'p', 'ps', 'pingshun', '', '县', '140425', '0355', 6);
INSERT INTO `district` VALUES (737, '黎城', 139, 'l', 'lc', 'licheng', '', '县', '140426', '0355', 7);
INSERT INTO `district` VALUES (738, '壶关', 139, 'h', 'hg', 'huguan', '', '县', '140427', '0355', 8);
INSERT INTO `district` VALUES (739, '长子', 139, 'z', 'zz', 'zhangzi', '', '县', '140428', '0355', 9);
INSERT INTO `district` VALUES (740, '武乡', 139, 'w', 'wx', 'wuxiang', '', '县', '140429', '0355', 10);
INSERT INTO `district` VALUES (741, '沁县', 139, 'q', 'qx', 'qinxian', '', '', '140430', '0355', 11);
INSERT INTO `district` VALUES (742, '沁源', 139, 'q', 'qy', 'qinyuan', '', '县', '140431', '0355', 12);
INSERT INTO `district` VALUES (743, '潞城', 139, 'l', 'lc', 'lucheng', '', '区', '140406', '0355', 4);
INSERT INTO `district` VALUES (744, '城区', 140, 'c', 'cq', 'chengqu', '', '', '140502', '0356', 1);
INSERT INTO `district` VALUES (745, '沁水', 140, 'q', 'qs', 'qinshui', '', '县', '140521', '0356', 2);
INSERT INTO `district` VALUES (746, '阳城', 140, 'y', 'yc', 'yangcheng', '', '县', '140522', '0356', 3);
INSERT INTO `district` VALUES (747, '陵川', 140, 'l', 'lc', 'lingchuan', '', '县', '140524', '0356', 4);
INSERT INTO `district` VALUES (748, '泽州', 140, 'z', 'zz', 'zezhou', '', '县', '140525', '0356', 5);
INSERT INTO `district` VALUES (749, '高平', 140, 'g', 'gp', 'gaoping', '', '市', '140581', '0356', 6);
INSERT INTO `district` VALUES (750, '朔城', 141, 's', 'sc', 'shuocheng', '', '区', '140602', '0349', 1);
INSERT INTO `district` VALUES (751, '平鲁', 141, 'p', 'pl', 'pinglu', '', '区', '140603', '0349', 2);
INSERT INTO `district` VALUES (752, '山阴', 141, 's', 'sy', 'shanyin', '', '县', '140621', '0349', 3);
INSERT INTO `district` VALUES (753, '应县', 141, 'y', 'yx', 'yingxian', '', '', '140622', '0349', 4);
INSERT INTO `district` VALUES (754, '右玉', 141, 'y', 'yy', 'youyu', '', '县', '140623', '0349', 5);
INSERT INTO `district` VALUES (755, '怀仁', 141, 'h', 'hr', 'huairen', '', '市', '140681', '0349', 6);
INSERT INTO `district` VALUES (756, '榆次', 142, 'y', 'yc', 'yuci', '', '区', '140702', '0354', 1);
INSERT INTO `district` VALUES (757, '榆社', 142, 'y', 'ys', 'yushe', '', '县', '140721', '0354', 3);
INSERT INTO `district` VALUES (758, '左权', 142, 'z', 'zq', 'zuoquan', '', '县', '140722', '0354', 4);
INSERT INTO `district` VALUES (759, '和顺', 142, 'h', 'hs', 'heshun', '', '县', '140723', '0354', 5);
INSERT INTO `district` VALUES (760, '昔阳', 142, 'x', 'xy', 'xiyang', '', '县', '140724', '0354', 6);
INSERT INTO `district` VALUES (761, '寿阳', 142, 's', 'sy', 'shouyang', '', '县', '140725', '0354', 7);
INSERT INTO `district` VALUES (762, '太谷', 142, 't', 'tg', 'taigu', '', '区', '140703', '0354', 2);
INSERT INTO `district` VALUES (763, '祁县', 142, 'q', 'qx', 'qixian', '', '', '140727', '0354', 8);
INSERT INTO `district` VALUES (764, '平遥', 142, 'p', 'py', 'pingyao', '', '县', '140728', '0354', 9);
INSERT INTO `district` VALUES (765, '灵石', 142, 'l', 'ls', 'lingshi', '', '县', '140729', '0354', 10);
INSERT INTO `district` VALUES (766, '介休', 142, 'j', 'jx', 'jiexiu', '', '市', '140781', '0354', 11);
INSERT INTO `district` VALUES (767, '盐湖', 143, 'y', 'yh', 'yanhu', '', '区', '140802', '0359', 1);
INSERT INTO `district` VALUES (768, '临猗', 143, 'l', 'ly', 'linyi', '', '县', '140821', '0359', 2);
INSERT INTO `district` VALUES (769, '万荣', 143, 'w', 'wr', 'wanrong', '', '县', '140822', '0359', 3);
INSERT INTO `district` VALUES (770, '闻喜', 143, 'w', 'wx', 'wenxi', '', '县', '140823', '0359', 4);
INSERT INTO `district` VALUES (771, '稷山', 143, 'j', 'js', 'jishan', '', '县', '140824', '0359', 5);
INSERT INTO `district` VALUES (772, '新绛', 143, 'x', 'xj', 'xinjiang', '', '县', '140825', '0359', 6);
INSERT INTO `district` VALUES (773, '绛县', 143, 'j', 'jx', 'jiangxian', '', '', '140826', '0359', 7);
INSERT INTO `district` VALUES (774, '垣曲', 143, 'y', 'yq', 'yuanqu', '', '县', '140827', '0359', 8);
INSERT INTO `district` VALUES (775, '夏县', 143, 'x', 'xx', 'xiaxian', '', '', '140828', '0359', 9);
INSERT INTO `district` VALUES (776, '平陆', 143, 'p', 'pl', 'pinglu', '', '县', '140829', '0359', 10);
INSERT INTO `district` VALUES (777, '芮城', 143, 'r', 'rc', 'ruicheng', '', '县', '140830', '0359', 11);
INSERT INTO `district` VALUES (778, '永济', 143, 'y', 'yj', 'yongji', '', '市', '140881', '0359', 12);
INSERT INTO `district` VALUES (779, '河津', 143, 'h', 'hj', 'hejin', '', '市', '140882', '0359', 13);
INSERT INTO `district` VALUES (780, '忻府', 144, 'x', 'xf', 'xinfu', '', '区', '140902', '0350', 1);
INSERT INTO `district` VALUES (781, '定襄', 144, 'd', 'dx', 'dingxiang', '', '县', '140921', '0350', 2);
INSERT INTO `district` VALUES (782, '五台', 144, 'w', 'wt', 'wutai', '', '县', '140922', '0350', 3);
INSERT INTO `district` VALUES (783, '代县', 144, 'd', 'dx', 'daixian', '', '', '140923', '0350', 4);
INSERT INTO `district` VALUES (784, '繁峙', 144, 'f', 'fz', 'fanzhi', '', '县', '140924', '0350', 5);
INSERT INTO `district` VALUES (785, '宁武', 144, 'n', 'nw', 'ningwu', '', '县', '140925', '0350', 6);
INSERT INTO `district` VALUES (786, '静乐', 144, 'j', 'jl', 'jingle', '', '县', '140926', '0350', 7);
INSERT INTO `district` VALUES (787, '神池', 144, 's', 'sc', 'shenchi', '', '县', '140927', '0350', 8);
INSERT INTO `district` VALUES (788, '五寨', 144, 'w', 'wz', 'wuzhai', '', '县', '140928', '0350', 9);
INSERT INTO `district` VALUES (789, '岢岚', 144, 'k', 'kl', 'kelan', '', '县', '140929', '0350', 10);
INSERT INTO `district` VALUES (790, '河曲', 144, 'h', 'hq', 'hequ', '', '县', '140930', '0350', 11);
INSERT INTO `district` VALUES (791, '保德', 144, 'b', 'bd', 'baode', '', '县', '140931', '0350', 12);
INSERT INTO `district` VALUES (792, '偏关', 144, 'p', 'pg', 'pianguan', '', '县', '140932', '0350', 13);
INSERT INTO `district` VALUES (793, '原平', 144, 'y', 'yp', 'yuanping', '', '市', '140981', '0350', 14);
INSERT INTO `district` VALUES (794, '尧都', 145, 'y', 'yd', 'yaodu', '', '区', '141002', '0357', 1);
INSERT INTO `district` VALUES (795, '曲沃', 145, 'q', 'qw', 'quwo', '', '县', '141021', '0357', 2);
INSERT INTO `district` VALUES (796, '翼城', 145, 'y', 'yc', 'yicheng', '', '县', '141022', '0357', 3);
INSERT INTO `district` VALUES (797, '襄汾', 145, 'x', 'xf', 'xiangfen', '', '县', '141023', '0357', 4);
INSERT INTO `district` VALUES (798, '洪洞', 145, 'h', 'hd', 'hongdong', '', '县', '141024', '0357', 5);
INSERT INTO `district` VALUES (799, '古县', 145, 'g', 'gx', 'guxian', '', '', '141025', '0357', 6);
INSERT INTO `district` VALUES (800, '安泽', 145, 'a', 'az', 'anze', '', '县', '141026', '0357', 7);
INSERT INTO `district` VALUES (801, '浮山', 145, 'f', 'fs', 'fushan', '', '县', '141027', '0357', 8);
INSERT INTO `district` VALUES (802, '吉县', 145, 'j', 'jx', 'jixian', '', '', '141028', '0357', 9);
INSERT INTO `district` VALUES (803, '乡宁', 145, 'x', 'xn', 'xiangning', '', '县', '141029', '0357', 10);
INSERT INTO `district` VALUES (804, '大宁', 145, 'd', 'dn', 'daning', '', '县', '141030', '0357', 11);
INSERT INTO `district` VALUES (805, '隰县', 145, 'x', 'xx', 'xixian', '', '', '141031', '0357', 12);
INSERT INTO `district` VALUES (806, '永和', 145, 'y', 'yh', 'yonghe', '', '县', '141032', '0357', 13);
INSERT INTO `district` VALUES (807, '蒲县', 145, 'p', 'px', 'puxian', '', '', '141033', '0357', 14);
INSERT INTO `district` VALUES (808, '汾西', 145, 'f', 'fx', 'fenxi', '', '县', '141034', '0357', 15);
INSERT INTO `district` VALUES (809, '侯马', 145, 'h', 'hm', 'houma', '', '市', '141081', '0357', 16);
INSERT INTO `district` VALUES (810, '霍州', 145, 'h', 'hz', 'huozhou', '', '市', '141082', '0357', 17);
INSERT INTO `district` VALUES (811, '离石', 146, 'l', 'ls', 'lishi', '', '区', '141102', '0358', 1);
INSERT INTO `district` VALUES (812, '文水', 146, 'w', 'ws', 'wenshui', '', '县', '141121', '0358', 2);
INSERT INTO `district` VALUES (813, '交城', 146, 'j', 'jc', 'jiaocheng', '', '县', '141122', '0358', 3);
INSERT INTO `district` VALUES (814, '兴县', 146, 'x', 'xx', 'xingxian', '', '', '141123', '0358', 4);
INSERT INTO `district` VALUES (815, '临县', 146, 'l', 'lx', 'linxian', '', '', '141124', '0358', 5);
INSERT INTO `district` VALUES (816, '柳林', 146, 'l', 'll', 'liulin', '', '县', '141125', '0358', 6);
INSERT INTO `district` VALUES (817, '石楼', 146, 's', 'sl', 'shilou', '', '县', '141126', '0358', 7);
INSERT INTO `district` VALUES (818, '岚县', 146, 'l', 'lx', 'lanxian', '', '', '141127', '0358', 8);
INSERT INTO `district` VALUES (819, '方山', 146, 'f', 'fs', 'fangshan', '', '县', '141128', '0358', 9);
INSERT INTO `district` VALUES (820, '中阳', 146, 'z', 'zy', 'zhongyang', '', '县', '141129', '0358', 10);
INSERT INTO `district` VALUES (821, '交口', 146, 'j', 'jk', 'jiaokou', '', '县', '141130', '0358', 11);
INSERT INTO `district` VALUES (822, '孝义', 146, 'x', 'xy', 'xiaoyi', '', '市', '141181', '0358', 12);
INSERT INTO `district` VALUES (823, '汾阳', 146, 'f', 'fy', 'fenyang', '', '市', '141182', '0358', 13);
INSERT INTO `district` VALUES (824, '新城', 147, 'x', 'xc', 'xincheng', '', '区', '150102', '0471', 1);
INSERT INTO `district` VALUES (825, '回民', 147, 'h', 'hm', 'huimin', '', '区', '150103', '0471', 2);
INSERT INTO `district` VALUES (826, '玉泉', 147, 'y', 'yq', 'yuquan', '', '区', '150104', '0471', 3);
INSERT INTO `district` VALUES (827, '赛罕', 147, 's', 'sh', 'saihan', '', '区', '150105', '0471', 4);
INSERT INTO `district` VALUES (828, '土默特左', 147, 't', 'tmtz', 'tumotezuo', '', '旗', '150121', '0471', 5);
INSERT INTO `district` VALUES (829, '托克托', 147, 't', 'tkt', 'tuoketuo', '', '县', '150122', '0471', 6);
INSERT INTO `district` VALUES (830, '和林格尔', 147, 'h', 'hlge', 'helingeer', '', '县', '150123', '0471', 7);
INSERT INTO `district` VALUES (831, '清水河', 147, 'q', 'qsh', 'qingshuihe', '', '县', '150124', '0471', 8);
INSERT INTO `district` VALUES (832, '武川', 147, 'w', 'wc', 'wuchuan', '', '县', '150125', '0471', 9);
INSERT INTO `district` VALUES (833, '东河', 148, 'd', 'dh', 'donghe', '', '区', '150202', '0472', 1);
INSERT INTO `district` VALUES (834, '昆都仑', 148, 'k', 'kdl', 'kundulun', '', '区', '150203', '0472', 2);
INSERT INTO `district` VALUES (835, '青山', 148, 'q', 'qs', 'qingshan', '', '区', '150204', '0472', 3);
INSERT INTO `district` VALUES (836, '石拐', 148, 's', 'sg', 'shiguai', '', '区', '150205', '0472', 4);
INSERT INTO `district` VALUES (837, '白云', 148, 'b', 'by', 'baiyun', '矿', '区', '150206', '0472', 5);
INSERT INTO `district` VALUES (838, '九原', 148, 'j', 'jy', 'jiuyuan', '', '区', '150207', '0472', 6);
INSERT INTO `district` VALUES (839, '土默特右', 148, 't', 'tmty', 'tumoteyou', '', '旗', '150221', '0472', 7);
INSERT INTO `district` VALUES (840, '固阳', 148, 'g', 'gy', 'guyang', '', '县', '150222', '0472', 8);
INSERT INTO `district` VALUES (841, '达尔罕茂明安', 148, 'd', 'dehmma', 'daerhanmaomingan', '联合', '旗', '150223', '0472', 9);
INSERT INTO `district` VALUES (842, '海勃湾', 149, 'h', 'hbw', 'haibowan', '', '区', '150302', '0473', 1);
INSERT INTO `district` VALUES (843, '海南', 149, 'h', 'hn', 'hainan', '', '区', '150303', '0473', 2);
INSERT INTO `district` VALUES (844, '乌达', 149, 'w', 'wd', 'wuda', '', '区', '150304', '0473', 3);
INSERT INTO `district` VALUES (845, '红山', 150, 'h', 'hs', 'hongshan', '', '区', '150402', '0476', 1);
INSERT INTO `district` VALUES (846, '元宝山', 150, 'y', 'ybs', 'yuanbaoshan', '', '区', '150403', '0476', 2);
INSERT INTO `district` VALUES (847, '松山', 150, 's', 'ss', 'songshan', '', '区', '150404', '0476', 3);
INSERT INTO `district` VALUES (848, '阿鲁科尔沁', 150, 'a', 'alkeq', 'alukeerqin', '', '旗', '150421', '0476', 4);
INSERT INTO `district` VALUES (849, '巴林左', 150, 'b', 'blz', 'balinzuo', '', '旗', '150422', '0476', 5);
INSERT INTO `district` VALUES (850, '巴林右', 150, 'b', 'bly', 'balinyou', '', '旗', '150423', '0476', 6);
INSERT INTO `district` VALUES (851, '林西', 150, 'l', 'lx', 'linxi', '', '县', '150424', '0476', 7);
INSERT INTO `district` VALUES (852, '克什克腾', 150, 'k', 'kskt', 'keshenketeng', '', '旗', '150425', '0476', 8);
INSERT INTO `district` VALUES (853, '翁牛特', 150, 'w', 'wnt', 'wengniute', '', '旗', '150426', '0476', 9);
INSERT INTO `district` VALUES (854, '喀喇沁', 150, 'k', 'klq', 'kalaqin', '', '旗', '150428', '0476', 10);
INSERT INTO `district` VALUES (855, '宁城', 150, 'n', 'nc', 'ningcheng', '', '县', '150429', '0476', 11);
INSERT INTO `district` VALUES (856, '敖汉', 150, 'a', 'ah', 'aohan', '', '旗', '150430', '0476', 12);
INSERT INTO `district` VALUES (857, '科尔沁', 151, 'k', 'keq', 'keerqin', '', '区', '150502', '0475', 1);
INSERT INTO `district` VALUES (858, '科尔沁左翼中', 151, 'k', 'keqzyz', 'keerqinzuoyizhong', '', '旗', '150521', '0475', 2);
INSERT INTO `district` VALUES (859, '科尔沁左翼后', 151, 'k', 'keqzyh', 'keerqinzuoyihou', '', '旗', '150522', '0475', 3);
INSERT INTO `district` VALUES (860, '开鲁', 151, 'k', 'kl', 'kailu', '', '县', '150523', '0475', 4);
INSERT INTO `district` VALUES (861, '库伦', 151, 'k', 'kl', 'kulun', '', '旗', '150524', '0475', 5);
INSERT INTO `district` VALUES (862, '奈曼', 151, 'n', 'nm', 'naiman', '', '旗', '150525', '0475', 6);
INSERT INTO `district` VALUES (863, '扎鲁特', 151, 'z', 'zlt', 'zhalute', '', '旗', '150526', '0475', 7);
INSERT INTO `district` VALUES (864, '霍林郭勒', 151, 'h', 'hlgl', 'huolinguole', '', '市', '150581', '0475', 8);
INSERT INTO `district` VALUES (865, '东胜', 152, 'd', 'ds', 'dongsheng', '', '区', '150602', '0477', 1);
INSERT INTO `district` VALUES (866, '达拉特', 152, 'd', 'dlt', 'dalate', '', '旗', '150621', '0477', 3);
INSERT INTO `district` VALUES (867, '准格尔', 152, 'z', 'zge', 'zhungeer', '', '旗', '150622', '0477', 4);
INSERT INTO `district` VALUES (868, '鄂托克前', 152, 'e', 'etkq', 'etuokeqian', '', '旗', '150623', '0477', 5);
INSERT INTO `district` VALUES (869, '鄂托克', 152, 'e', 'etk', 'etuoke', '', '旗', '150624', '0477', 6);
INSERT INTO `district` VALUES (870, '杭锦', 152, 'h', 'hj', 'hangjin', '', '旗', '150625', '0477', 7);
INSERT INTO `district` VALUES (871, '乌审', 152, 'w', 'ws', 'wushen', '', '旗', '150626', '0477', 8);
INSERT INTO `district` VALUES (872, '伊金霍洛', 152, 'y', 'yjhl', 'yijinhuoluo', '', '旗', '150627', '0477', 9);
INSERT INTO `district` VALUES (873, '海拉尔', 153, 'h', 'hle', 'hailaer', '', '区', '150702', '0470', 1);
INSERT INTO `district` VALUES (874, '阿荣', 153, 'a', 'ar', 'arong', '', '旗', '150721', '0470', 2);
INSERT INTO `district` VALUES (875, '莫力达瓦', 153, 'm', 'mldw', 'molidawa', '达斡尔族', '自治旗', '150722', '0470', 3);
INSERT INTO `district` VALUES (876, '鄂伦春', 153, 'e', 'elc', 'elunchun', '', '自治旗', '150723', '0470', 4);
INSERT INTO `district` VALUES (877, '鄂温克族', 153, 'e', 'ewkz', 'ewenkezu', '', '自治旗', '150724', '0470', 5);
INSERT INTO `district` VALUES (878, '陈巴尔虎', 153, 'c', 'cbeh', 'chenbaerhu', '', '旗', '150725', '0470', 6);
INSERT INTO `district` VALUES (879, '新巴尔虎左', 153, 'x', 'xbehz', 'xinbaerhuzuo', '', '旗', '150726', '0470', 7);
INSERT INTO `district` VALUES (880, '新巴尔虎右', 153, 'x', 'xbehy', 'xinbaerhuyou', '', '旗', '150727', '0470', 8);
INSERT INTO `district` VALUES (881, '满洲里', 153, 'm', 'mzl', 'manzhouli', '', '市', '150781', '0470', 9);
INSERT INTO `district` VALUES (882, '牙克石', 153, 'y', 'yks', 'yakeshi', '', '市', '150782', '0470', 10);
INSERT INTO `district` VALUES (883, '扎兰屯', 153, 'z', 'zlt', 'zhalantun', '', '市', '150783', '0470', 11);
INSERT INTO `district` VALUES (884, '额尔古纳', 153, 'e', 'eegn', 'eerguna', '', '市', '150784', '0470', 12);
INSERT INTO `district` VALUES (885, '根河', 153, 'g', 'gh', 'genhe', '', '市', '150785', '0470', 13);
INSERT INTO `district` VALUES (886, '临河', 154, 'l', 'lh', 'linhe', '', '区', '150802', '0478', 1);
INSERT INTO `district` VALUES (887, '五原', 154, 'w', 'wy', 'wuyuan', '', '县', '150821', '0478', 2);
INSERT INTO `district` VALUES (888, '磴口', 154, 'd', 'dk', 'dengkou', '', '县', '150822', '0478', 3);
INSERT INTO `district` VALUES (889, '乌拉特前', 154, 'w', 'wltq', 'wulateqian', '', '旗', '150823', '0478', 4);
INSERT INTO `district` VALUES (890, '乌拉特中', 154, 'w', 'wltz', 'wulatezhong', '', '旗', '150824', '0478', 5);
INSERT INTO `district` VALUES (891, '乌拉特后', 154, 'w', 'wlth', 'wulatehou', '', '旗', '150825', '0478', 6);
INSERT INTO `district` VALUES (892, '杭锦后', 154, 'h', 'hjh', 'hangjinhou', '', '旗', '150826', '0478', 7);
INSERT INTO `district` VALUES (893, '集宁', 155, 'j', 'jn', 'jining', '', '区', '150902', '0474', 1);
INSERT INTO `district` VALUES (894, '卓资', 155, 'z', 'zz', 'zhuozi', '', '县', '150921', '0474', 2);
INSERT INTO `district` VALUES (895, '化德', 155, 'h', 'hd', 'huade', '', '县', '150922', '0474', 3);
INSERT INTO `district` VALUES (896, '商都', 155, 's', 'sd', 'shangdu', '', '县', '150923', '0474', 4);
INSERT INTO `district` VALUES (897, '兴和', 155, 'x', 'xh', 'xinghe', '', '县', '150924', '0474', 5);
INSERT INTO `district` VALUES (898, '凉城', 155, 'l', 'lc', 'liangcheng', '', '县', '150925', '0474', 6);
INSERT INTO `district` VALUES (899, '察哈尔右翼前', 155, 'c', 'cheyyq', 'chahaeryouyiqian', '', '旗', '150926', '0474', 7);
INSERT INTO `district` VALUES (900, '察哈尔右翼中', 155, 'c', 'cheyyz', 'chahaeryouyizhong', '', '旗', '150927', '0474', 8);
INSERT INTO `district` VALUES (901, '察哈尔右翼后', 155, 'c', 'cheyyh', 'chahaeryouyihou', '', '旗', '150928', '0474', 9);
INSERT INTO `district` VALUES (902, '四子王', 155, 's', 'szw', 'siziwang', '', '旗', '150929', '0474', 10);
INSERT INTO `district` VALUES (903, '丰镇', 155, 'f', 'fz', 'fengzhen', '', '市', '150981', '0474', 11);
INSERT INTO `district` VALUES (904, '乌兰浩特', 156, 'w', 'wlht', 'wulanhaote', '', '市', '152201', '0482', 1);
INSERT INTO `district` VALUES (905, '阿尔山', 156, 'a', 'aes', 'aershan', '', '市', '152202', '0482', 2);
INSERT INTO `district` VALUES (906, '科尔沁右翼前', 156, 'k', 'keqyyq', 'keerqinyouyiqian', '', '旗', '152221', '0482', 3);
INSERT INTO `district` VALUES (907, '科尔沁右翼中', 156, 'k', 'keqyyz', 'keerqinyouyizhong', '', '旗', '152222', '0482', 4);
INSERT INTO `district` VALUES (908, '扎赉特', 156, 'z', 'zlt', 'zhalaite', '', '旗', '152223', '0482', 5);
INSERT INTO `district` VALUES (909, '突泉', 156, 't', 'tq', 'tuquan', '', '县', '152224', '0482', 6);
INSERT INTO `district` VALUES (910, '二连浩特', 157, 'e', 'elht', 'erlianhaote', '', '市', '152501', '0479', 1);
INSERT INTO `district` VALUES (911, '锡林浩特', 157, 'x', 'xlht', 'xilinhaote', '', '市', '152502', '0479', 2);
INSERT INTO `district` VALUES (912, '阿巴嘎', 157, 'a', 'abg', 'abaga', '', '旗', '152522', '0479', 3);
INSERT INTO `district` VALUES (913, '苏尼特左', 157, 's', 'sntz', 'sunitezuo', '', '旗', '152523', '0479', 4);
INSERT INTO `district` VALUES (914, '苏尼特右', 157, 's', 'snty', 'suniteyou', '', '旗', '152524', '0479', 5);
INSERT INTO `district` VALUES (915, '东乌珠穆沁', 157, 'd', 'dwzmq', 'dongwuzhumuqin', '', '旗', '152525', '0479', 6);
INSERT INTO `district` VALUES (916, '西乌珠穆沁', 157, 'x', 'xwzmq', 'xiwuzhumuqin', '', '旗', '152526', '0479', 7);
INSERT INTO `district` VALUES (917, '太仆寺', 157, 't', 'tps', 'taipusi', '', '旗', '152527', '0479', 8);
INSERT INTO `district` VALUES (918, '镶黄', 157, 'x', 'xh', 'xianghuang', '', '旗', '152528', '0479', 9);
INSERT INTO `district` VALUES (919, '正镶白', 157, 'z', 'zxb', 'zhengxiangbai', '', '旗', '152529', '0479', 10);
INSERT INTO `district` VALUES (920, '正蓝', 157, 'z', 'zl', 'zhenglan', '', '旗', '152530', '0479', 11);
INSERT INTO `district` VALUES (921, '多伦', 157, 'd', 'dl', 'duolun', '', '县', '152531', '0479', 12);
INSERT INTO `district` VALUES (922, '阿拉善左', 158, 'a', 'alsz', 'alashanzuo', '', '旗', '152921', '0483', 1);
INSERT INTO `district` VALUES (923, '阿拉善右', 158, 'a', 'alsy', 'alashanyou', '', '旗', '152922', '0483', 2);
INSERT INTO `district` VALUES (924, '额济纳', 158, 'e', 'ejn', 'ejina', '', '旗', '152923', '0483', 3);
INSERT INTO `district` VALUES (925, '和平', 159, 'h', 'hp', 'heping', '', '区', '210102', '024', 1);
INSERT INTO `district` VALUES (926, '沈河', 159, 's', 'sh', 'shenhe', '', '区', '210103', '024', 2);
INSERT INTO `district` VALUES (927, '大东', 159, 'd', 'dd', 'dadong', '', '区', '210104', '024', 3);
INSERT INTO `district` VALUES (928, '皇姑', 159, 'h', 'hg', 'huanggu', '', '区', '210105', '024', 4);
INSERT INTO `district` VALUES (929, '铁西', 159, 't', 'tx', 'tiexi', '', '区', '210106', '024', 5);
INSERT INTO `district` VALUES (930, '苏家屯', 159, 's', 'sjt', 'sujiatun', '', '区', '210111', '024', 6);
INSERT INTO `district` VALUES (931, '浑南', 159, 'h', 'hn', 'hunnan', '', '区', '210112', '024', 7);
INSERT INTO `district` VALUES (932, '沈北新区', 159, 's', 'sbxq', 'shenbeixinqu', '', '', '210113', '024', 8);
INSERT INTO `district` VALUES (933, '于洪', 159, 'y', 'yh', 'yuhong', '', '区', '210114', '024', 9);
INSERT INTO `district` VALUES (934, '辽中', 159, 'l', 'lz', 'liaozhong', '', '区', '210115', '024', 10);
INSERT INTO `district` VALUES (935, '康平', 159, 'k', 'kp', 'kangping', '', '县', '210123', '024', 11);
INSERT INTO `district` VALUES (936, '法库', 159, 'f', 'fk', 'faku', '', '县', '210124', '024', 12);
INSERT INTO `district` VALUES (937, '新民', 159, 'x', 'xm', 'xinmin', '', '市', '210181', '024', 13);
INSERT INTO `district` VALUES (938, '中山', 160, 'z', 'zs', 'zhongshan', '', '区', '210202', '0411', 1);
INSERT INTO `district` VALUES (939, '西岗', 160, 'x', 'xg', 'xigang', '', '区', '210203', '0411', 2);
INSERT INTO `district` VALUES (940, '沙河口', 160, 's', 'shk', 'shahekou', '', '区', '210204', '0411', 3);
INSERT INTO `district` VALUES (941, '甘井子', 160, 'g', 'gjz', 'ganjingzi', '', '区', '210211', '0411', 4);
INSERT INTO `district` VALUES (942, '旅顺口', 160, 'l', 'lsk', 'lu:shunkou', '', '区', '210212', '0411', 5);
INSERT INTO `district` VALUES (943, '金州', 160, 'j', 'jz', 'jinzhou', '', '区', '210213', '0411', 6);
INSERT INTO `district` VALUES (944, '长海', 160, 'c', 'ch', 'changhai', '', '县', '210224', '0411', 7);
INSERT INTO `district` VALUES (945, '瓦房店', 160, 'w', 'wfd', 'wafangdian', '', '市', '210281', '0411', 8);
INSERT INTO `district` VALUES (946, '普兰店', 160, 'p', 'pld', 'pulandian', '', '区', '210282', '0411', 9);
INSERT INTO `district` VALUES (947, '庄河', 160, 'z', 'zh', 'zhuanghe', '', '市', '210283', '0411', 10);
INSERT INTO `district` VALUES (948, '铁东', 161, 't', 'td', 'tiedong', '', '区', '210302', '0412', 1);
INSERT INTO `district` VALUES (949, '铁西', 161, 't', 'tx', 'tiexi', '', '区', '210303', '0412', 2);
INSERT INTO `district` VALUES (950, '立山', 161, 'l', 'ls', 'lishan', '', '区', '210304', '0412', 3);
INSERT INTO `district` VALUES (951, '千山', 161, 'q', 'qs', 'qianshan', '', '区', '210311', '0412', 4);
INSERT INTO `district` VALUES (952, '台安', 161, 't', 'ta', 'taian', '', '县', '210321', '0412', 5);
INSERT INTO `district` VALUES (953, '岫岩', 161, 'x', 'xy', 'xiuyan', '满族', '自治县', '210323', '0412', 6);
INSERT INTO `district` VALUES (954, '海城', 161, 'h', 'hc', 'haicheng', '', '市', '210381', '0412', 7);
INSERT INTO `district` VALUES (955, '新抚', 162, 'x', 'xf', 'xinfu', '', '区', '210402', '0413', 1);
INSERT INTO `district` VALUES (956, '东洲', 162, 'd', 'dz', 'dongzhou', '', '区', '210403', '0413', 2);
INSERT INTO `district` VALUES (957, '望花', 162, 'w', 'wh', 'wanghua', '', '区', '210404', '0413', 3);
INSERT INTO `district` VALUES (958, '顺城', 162, 's', 'sc', 'shuncheng', '', '区', '210411', '0413', 4);
INSERT INTO `district` VALUES (959, '抚顺', 162, 'f', 'fs', 'fushun', '', '县', '210421', '0413', 5);
INSERT INTO `district` VALUES (960, '新宾', 162, 'x', 'xb', 'xinbin', '满族', '自治县', '210422', '0413', 6);
INSERT INTO `district` VALUES (961, '清原', 162, 'q', 'qy', 'qingyuan', '满族', '自治县', '210423', '0413', 7);
INSERT INTO `district` VALUES (962, '平山', 163, 'p', 'ps', 'pingshan', '', '区', '210502', '0414', 1);
INSERT INTO `district` VALUES (963, '溪湖', 163, 'x', 'xh', 'xihu', '', '区', '210503', '0414', 2);
INSERT INTO `district` VALUES (964, '明山', 163, 'm', 'ms', 'mingshan', '', '区', '210504', '0414', 3);
INSERT INTO `district` VALUES (965, '南芬', 163, 'n', 'nf', 'nanfen', '', '区', '210505', '0414', 4);
INSERT INTO `district` VALUES (966, '本溪', 163, 'b', 'bx', 'benxi', '满族', '自治县', '210521', '0414', 5);
INSERT INTO `district` VALUES (967, '桓仁', 163, 'h', 'hr', 'huanren', '满族', '自治县', '210522', '0414', 6);
INSERT INTO `district` VALUES (968, '元宝', 164, 'y', 'yb', 'yuanbao', '', '区', '210602', '0415', 1);
INSERT INTO `district` VALUES (969, '振兴', 164, 'z', 'zx', 'zhenxing', '', '区', '210603', '0415', 2);
INSERT INTO `district` VALUES (970, '振安', 164, 'z', 'za', 'zhenan', '', '区', '210604', '0415', 3);
INSERT INTO `district` VALUES (971, '宽甸', 164, 'k', 'kd', 'kuandian', '满族', '自治县', '210624', '0415', 4);
INSERT INTO `district` VALUES (972, '东港', 164, 'd', 'dg', 'donggang', '', '市', '210681', '0415', 5);
INSERT INTO `district` VALUES (973, '凤城', 164, 'f', 'fc', 'fengcheng', '', '市', '210682', '0415', 6);
INSERT INTO `district` VALUES (974, '古塔', 165, 'g', 'gt', 'guta', '', '区', '210702', '0416', 1);
INSERT INTO `district` VALUES (975, '凌河', 165, 'l', 'lh', 'linghe', '', '区', '210703', '0416', 2);
INSERT INTO `district` VALUES (976, '太和', 165, 't', 'th', 'taihe', '', '区', '210711', '0416', 3);
INSERT INTO `district` VALUES (977, '黑山', 165, 'h', 'hs', 'heishan', '', '县', '210726', '0416', 4);
INSERT INTO `district` VALUES (978, '义县', 165, 'y', 'yx', 'yixian', '', '', '210727', '0416', 5);
INSERT INTO `district` VALUES (979, '凌海', 165, 'l', 'lh', 'linghai', '', '市', '210781', '0416', 6);
INSERT INTO `district` VALUES (980, '北镇', 165, 'b', 'bz', 'beizhen', '', '市', '210782', '0416', 7);
INSERT INTO `district` VALUES (981, '站前', 166, 'z', 'zq', 'zhanqian', '', '区', '210802', '0417', 1);
INSERT INTO `district` VALUES (982, '西市', 166, 'x', 'xs', 'xishi', '', '区', '210803', '0417', 2);
INSERT INTO `district` VALUES (983, '鲅鱼圈', 166, 'b', 'byq', 'bayuquan', '', '区', '210804', '0417', 3);
INSERT INTO `district` VALUES (984, '老边', 166, 'l', 'lb', 'laobian', '', '区', '210811', '0417', 4);
INSERT INTO `district` VALUES (985, '盖州', 166, 'g', 'gz', 'gaizhou', '', '市', '210881', '0417', 5);
INSERT INTO `district` VALUES (986, '大石桥', 166, 'd', 'dsq', 'dashiqiao', '', '市', '210882', '0417', 6);
INSERT INTO `district` VALUES (987, '海州', 167, 'h', 'hz', 'haizhou', '', '区', '210902', '0418', 1);
INSERT INTO `district` VALUES (988, '新邱', 167, 'x', 'xq', 'xinqiu', '', '区', '210903', '0418', 2);
INSERT INTO `district` VALUES (989, '太平', 167, 't', 'tp', 'taiping', '', '区', '210904', '0418', 3);
INSERT INTO `district` VALUES (990, '清河门', 167, 'q', 'qhm', 'qinghemen', '', '区', '210905', '0418', 4);
INSERT INTO `district` VALUES (991, '细河', 167, 'x', 'xh', 'xihe', '', '区', '210911', '0418', 5);
INSERT INTO `district` VALUES (992, '阜新', 167, 'f', 'fx', 'fuxin', '蒙古族', '自治县', '210921', '0418', 6);
INSERT INTO `district` VALUES (993, '彰武', 167, 'z', 'zw', 'zhangwu', '', '县', '210922', '0418', 7);
INSERT INTO `district` VALUES (994, '白塔', 168, 'b', 'bt', 'baita', '', '区', '211002', '0419', 1);
INSERT INTO `district` VALUES (995, '文圣', 168, 'w', 'ws', 'wensheng', '', '区', '211003', '0419', 2);
INSERT INTO `district` VALUES (996, '宏伟', 168, 'h', 'hw', 'hongwei', '', '区', '211004', '0419', 3);
INSERT INTO `district` VALUES (997, '弓长岭', 168, 'g', 'gcl', 'gongchangling', '', '区', '211005', '0419', 4);
INSERT INTO `district` VALUES (998, '辽阳', 168, 'l', 'ly', 'liaoyang', '', '县', '211021', '0419', 5);
INSERT INTO `district` VALUES (999, '灯塔', 168, 'd', 'dt', 'dengta', '', '市', '211081', '0419', 6);
INSERT INTO `district` VALUES (1000, '太子河', 168, 't', 'tzh', 'taizihe', '', '区', '211110', '0419', 7);
INSERT INTO `district` VALUES (1001, '双台子', 169, 's', 'stz', 'shuangtaizi', '', '区', '211103', '0427', 1);
INSERT INTO `district` VALUES (1002, '兴隆台', 169, 'x', 'xlt', 'xinglongtai', '', '区', '211103', '0427', 2);
INSERT INTO `district` VALUES (1003, '大洼', 169, 'd', 'dw', 'dawa', '', '区', '211104', '0427', 3);
INSERT INTO `district` VALUES (1004, '盘山', 169, 'p', 'ps', 'panshan', '', '县', '211122', '0427', 4);
INSERT INTO `district` VALUES (1005, '银州', 170, 'y', 'yz', 'yinzhou', '', '区', '211202', '0410', 1);
INSERT INTO `district` VALUES (1006, '清河', 170, 'q', 'qh', 'qinghe', '', '区', '211204', '0410', 2);
INSERT INTO `district` VALUES (1007, '铁岭', 170, 't', 'tl', 'tieling', '', '县', '211221', '0410', 3);
INSERT INTO `district` VALUES (1008, '西丰', 170, 'x', 'xf', 'xifeng', '', '县', '211223', '0410', 4);
INSERT INTO `district` VALUES (1009, '昌图', 170, 'c', 'ct', 'changtu', '', '县', '211224', '0410', 5);
INSERT INTO `district` VALUES (1010, '调兵山', 170, 'd', 'dbs', 'diaobingshan', '', '市', '211281', '0410', 6);
INSERT INTO `district` VALUES (1011, '开原', 170, 'k', 'ky', 'kaiyuan', '', '市', '211282', '0410', 7);
INSERT INTO `district` VALUES (1012, '双塔', 171, 's', 'st', 'shuangta', '', '区', '211302', '0421', 1);
INSERT INTO `district` VALUES (1013, '龙城', 171, 'l', 'lc', 'longcheng', '', '区', '211303', '0421', 2);
INSERT INTO `district` VALUES (1014, '朝阳', 171, 'c', 'cy', 'chaoyang', '', '县', '211321', '0421', 3);
INSERT INTO `district` VALUES (1015, '建平', 171, 'j', 'jp', 'jianping', '', '县', '211322', '0421', 4);
INSERT INTO `district` VALUES (1016, '喀喇沁左翼', 171, 'k', 'klqzy', 'kalaqinzuoyi', '蒙古族', '自治县', '211324', '0421', 5);
INSERT INTO `district` VALUES (1017, '北票', 171, 'b', 'bp', 'beipiao', '', '市', '211381', '0421', 6);
INSERT INTO `district` VALUES (1018, '凌源', 171, 'l', 'ly', 'lingyuan', '', '市', '211382', '0421', 7);
INSERT INTO `district` VALUES (1019, '连山', 172, 'l', 'ls', 'lianshan', '', '区', '211402', '0429', 1);
INSERT INTO `district` VALUES (1020, '龙港', 172, 'l', 'lg', 'longgang', '', '区', '211403', '0429', 2);
INSERT INTO `district` VALUES (1021, '南票', 172, 'n', 'np', 'nanpiao', '', '区', '211404', '0429', 3);
INSERT INTO `district` VALUES (1022, '绥中', 172, 's', 'sz', 'suizhong', '', '县', '211421', '0429', 4);
INSERT INTO `district` VALUES (1023, '建昌', 172, 'j', 'jc', 'jianchang', '', '县', '211422', '0429', 5);
INSERT INTO `district` VALUES (1024, '兴城', 172, 'x', 'xc', 'xingcheng', '', '市', '211481', '0429', 6);
INSERT INTO `district` VALUES (1025, '南关', 173, 'n', 'ng', 'nanguan', '', '区', '220102', '0431', 1);
INSERT INTO `district` VALUES (1026, '宽城', 173, 'k', 'kc', 'kuancheng', '', '区', '220103', '0431', 2);
INSERT INTO `district` VALUES (1027, '朝阳', 173, 'c', 'cy', 'chaoyang', '', '区', '220104', '0431', 3);
INSERT INTO `district` VALUES (1028, '二道', 173, 'e', 'ed', 'erdao', '', '区', '220105', '0431', 4);
INSERT INTO `district` VALUES (1029, '绿园', 173, 'l', 'ly', 'lu:yuan', '', '区', '220106', '0431', 5);
INSERT INTO `district` VALUES (1030, '双阳', 173, 's', 'sy', 'shuangyang', '', '区', '220112', '0431', 6);
INSERT INTO `district` VALUES (1031, '农安', 173, 'n', 'na', 'nongan', '', '县', '220122', '0431', 8);
INSERT INTO `district` VALUES (1032, '九台', 173, 'j', 'jt', 'jiutai', '', '区', '220113', '0431', 7);
INSERT INTO `district` VALUES (1033, '榆树', 173, 'y', 'ys', 'yushu', '', '市', '220182', '0431', 9);
INSERT INTO `district` VALUES (1034, '德惠', 173, 'd', 'dh', 'dehui', '', '市', '220183', '0431', 10);
INSERT INTO `district` VALUES (1035, '昌邑', 174, 'c', 'cy', 'changyi', '', '区', '220202', '0432', 1);
INSERT INTO `district` VALUES (1036, '龙潭', 174, 'l', 'lt', 'longtan', '', '区', '220203', '0432', 2);
INSERT INTO `district` VALUES (1037, '船营', 174, 'c', 'cy', 'chuanying', '', '区', '220204', '0432', 3);
INSERT INTO `district` VALUES (1038, '丰满', 174, 'f', 'fm', 'fengman', '', '区', '220211', '0432', 4);
INSERT INTO `district` VALUES (1039, '永吉', 174, 'y', 'yj', 'yongji', '', '县', '220221', '0432', 5);
INSERT INTO `district` VALUES (1040, '桦甸', 174, 'h', 'hd', 'huadian', '', '市', '220281', '0432', 6);
INSERT INTO `district` VALUES (1041, '蛟河', 174, 'j', 'jh', 'jiaohe', '', '市', '220282', '0432', 7);
INSERT INTO `district` VALUES (1042, '舒兰', 174, 's', 'sl', 'shulan', '', '市', '220283', '0432', 8);
INSERT INTO `district` VALUES (1043, '磐石', 174, 'p', 'ps', 'panshi', '', '市', '220284', '0432', 9);
INSERT INTO `district` VALUES (1044, '铁西', 175, 't', 'tx', 'tiexi', '', '区', '220302', '0434', 1);
INSERT INTO `district` VALUES (1045, '铁东', 175, 't', 'td', 'tiedong', '', '区', '220303', '0434', 2);
INSERT INTO `district` VALUES (1046, '梨树', 175, 'l', 'ls', 'lishu', '', '县', '220322', '0434', 3);
INSERT INTO `district` VALUES (1047, '伊通', 175, 'y', 'yt', 'yitong', '满族', '自治县', '220323', '0434', 4);
INSERT INTO `district` VALUES (1048, '公主岭', 175, 'g', 'gzl', 'gongzhuling', '', '市', '220381', '0434', 5);
INSERT INTO `district` VALUES (1049, '双辽', 175, 's', 'sl', 'shuangliao', '', '市', '220382', '0434', 6);
INSERT INTO `district` VALUES (1050, '龙山', 176, 'l', 'ls', 'longshan', '', '区', '220402', '0437', 1);
INSERT INTO `district` VALUES (1051, '西安', 176, 'x', 'xa', 'xian', '', '区', '220403', '0437', 2);
INSERT INTO `district` VALUES (1052, '东丰', 176, 'd', 'df', 'dongfeng', '', '县', '220421', '0437', 3);
INSERT INTO `district` VALUES (1053, '东辽', 176, 'd', 'dl', 'dongliao', '', '县', '220422', '0437', 4);
INSERT INTO `district` VALUES (1054, '东昌', 177, 'd', 'dc', 'dongchang', '', '区', '220502', '0435', 1);
INSERT INTO `district` VALUES (1055, '二道江', 177, 'e', 'edj', 'erdaojiang', '', '区', '220503', '0435', 2);
INSERT INTO `district` VALUES (1056, '通化', 177, 't', 'th', 'tonghua', '', '县', '220521', '0435', 3);
INSERT INTO `district` VALUES (1057, '辉南', 177, 'h', 'hn', 'huinan', '', '县', '220523', '0435', 4);
INSERT INTO `district` VALUES (1058, '柳河', 177, 'l', 'lh', 'liuhe', '', '县', '220524', '0435', 5);
INSERT INTO `district` VALUES (1059, '梅河口', 177, 'm', 'mhk', 'meihekou', '', '市', '220581', '0435', 6);
INSERT INTO `district` VALUES (1060, '集安', 177, 'j', 'ja', 'jian', '', '市', '220582', '0435', 7);
INSERT INTO `district` VALUES (1061, '浑江', 178, 'h', 'hj', 'hunjiang', '', '区', '220602', '0439', 1);
INSERT INTO `district` VALUES (1062, '江源', 178, 'j', 'jy', 'jiangyuan', '', '区', '220604', '0439', 2);
INSERT INTO `district` VALUES (1063, '抚松', 178, 'f', 'fs', 'fusong', '', '县', '220621', '0439', 3);
INSERT INTO `district` VALUES (1064, '靖宇', 178, 'j', 'jy', 'jingyu', '', '县', '220622', '0439', 4);
INSERT INTO `district` VALUES (1065, '长白', 178, 'c', 'cb', 'changbai', '朝鲜族', '自治县', '220623', '0439', 5);
INSERT INTO `district` VALUES (1066, '临江', 178, 'l', 'lj', 'linjiang', '', '市', '220681', '0439', 6);
INSERT INTO `district` VALUES (1067, '宁江', 179, 'n', 'nj', 'ningjiang', '', '区', '220702', '0438', 1);
INSERT INTO `district` VALUES (1068, '前郭尔罗斯', 179, 'q', 'qgels', 'qianguoerluosi', '蒙古族', '自治县', '220721', '0438', 2);
INSERT INTO `district` VALUES (1069, '长岭', 179, 'c', 'cl', 'changling', '', '县', '220722', '0438', 3);
INSERT INTO `district` VALUES (1070, '乾安', 179, 'q', 'qa', 'qianan', '', '县', '220723', '0438', 4);
INSERT INTO `district` VALUES (1071, '扶余', 179, 'f', 'fy', 'fuyu', '', '市', '220724', '0438', 5);
INSERT INTO `district` VALUES (1072, '洮北', 180, 't', 'tb', 'taobei', '', '区', '220802', '0436', 1);
INSERT INTO `district` VALUES (1073, '镇赉', 180, 'z', 'zl', 'zhenlai', '', '县', '220821', '0436', 2);
INSERT INTO `district` VALUES (1074, '洮南', 180, 't', 'tn', 'taonan', '', '市', '220881', '0436', 4);
INSERT INTO `district` VALUES (1075, '大安', 180, 'd', 'da', 'daan', '', '市', '220882', '0436', 5);
INSERT INTO `district` VALUES (1076, '通榆', 180, 't', 'ty', 'tongyu', '', '县', '220822', '0436', 3);
INSERT INTO `district` VALUES (1077, '延吉', 181, 'y', 'yj', 'yanji', '', '市', '222401', '0433', 1);
INSERT INTO `district` VALUES (1078, '图们', 181, 't', 'tm', 'tumen', '', '市', '222402', '0433', 2);
INSERT INTO `district` VALUES (1079, '敦化', 181, 'd', 'dh', 'dunhua', '', '市', '222403', '0433', 3);
INSERT INTO `district` VALUES (1080, '珲春', 181, 'h', 'hc', 'hunchun', '', '市', '222404', '0433', 4);
INSERT INTO `district` VALUES (1081, '龙井', 181, 'l', 'lj', 'longjing', '', '市', '222405', '0433', 5);
INSERT INTO `district` VALUES (1082, '和龙', 181, 'h', 'hl', 'helong', '', '市', '222406', '0433', 6);
INSERT INTO `district` VALUES (1083, '汪清', 181, 'w', 'wq', 'wangqing', '', '县', '222424', '0433', 7);
INSERT INTO `district` VALUES (1084, '安图', 181, 'a', 'at', 'antu', '', '县', '222426', '0433', 8);
INSERT INTO `district` VALUES (1085, '道里', 182, 'd', 'dl', 'daoli', '', '区', '230102', '0451', 1);
INSERT INTO `district` VALUES (1086, '南岗', 182, 'n', 'ng', 'nangang', '', '区', '230103', '0451', 2);
INSERT INTO `district` VALUES (1087, '道外', 182, 'd', 'dw', 'daowai', '', '区', '230104', '0451', 3);
INSERT INTO `district` VALUES (1088, '平房', 182, 'p', 'pf', 'pingfang', '', '区', '230108', '0451', 4);
INSERT INTO `district` VALUES (1089, '松北', 182, 's', 'sb', 'songbei', '', '区', '230109', '0451', 5);
INSERT INTO `district` VALUES (1090, '香坊', 182, 'x', 'xf', 'xiangfang', '', '区', '230110', '0451', 6);
INSERT INTO `district` VALUES (1091, '呼兰', 182, 'h', 'hl', 'hulan', '', '区', '230111', '0451', 7);
INSERT INTO `district` VALUES (1092, '阿城', 182, 'a', 'ac', 'acheng', '', '区', '230112', '0451', 8);
INSERT INTO `district` VALUES (1093, '依兰', 182, 'y', 'yl', 'yilan', '', '县', '230123', '0451', 9);
INSERT INTO `district` VALUES (1094, '方正', 182, 'f', 'fz', 'fangzheng', '', '县', '230124', '0451', 10);
INSERT INTO `district` VALUES (1095, '宾县', 182, 'b', 'bx', 'binxian', '', '', '230125', '0451', 11);
INSERT INTO `district` VALUES (1096, '巴彦', 182, 'b', 'by', 'bayan', '', '县', '230126', '0451', 12);
INSERT INTO `district` VALUES (1097, '木兰', 182, 'm', 'ml', 'mulan', '', '县', '230127', '0451', 13);
INSERT INTO `district` VALUES (1098, '通河', 182, 't', 'th', 'tonghe', '', '县', '230128', '0451', 14);
INSERT INTO `district` VALUES (1099, '延寿', 182, 'y', 'ys', 'yanshou', '', '县', '230129', '0451', 15);
INSERT INTO `district` VALUES (1100, '双城', 182, 's', 'sc', 'shuangcheng', '', '区', '230182', '0451', 16);
INSERT INTO `district` VALUES (1101, '尚志', 182, 's', 'sz', 'shangzhi', '', '市', '230183', '0451', 17);
INSERT INTO `district` VALUES (1102, '五常', 182, 'w', 'wc', 'wuchang', '', '市', '230184', '0451', 18);
INSERT INTO `district` VALUES (1103, '龙沙', 183, 'l', 'ls', 'longsha', '', '区', '230202', '0452', 1);
INSERT INTO `district` VALUES (1104, '建华', 183, 'j', 'jh', 'jianhua', '', '区', '230203', '0452', 2);
INSERT INTO `district` VALUES (1105, '铁锋', 183, 't', 'tf', 'tiefeng', '', '区', '230204', '0452', 3);
INSERT INTO `district` VALUES (1106, '昂昂溪', 183, 'a', 'aax', 'angangxi', '', '区', '230205', '0452', 4);
INSERT INTO `district` VALUES (1107, '富拉尔基', 183, 'f', 'flej', 'fulaerji', '', '区', '230206', '0452', 5);
INSERT INTO `district` VALUES (1108, '碾子山', 183, 'n', 'nzs', 'nianzishan', '', '区', '230207', '0452', 6);
INSERT INTO `district` VALUES (1109, '梅里斯', 183, 'm', 'mls', 'meilisi', '达斡尔族', '区', '230208', '0452', 7);
INSERT INTO `district` VALUES (1110, '龙江', 183, 'l', 'lj', 'longjiang', '', '县', '230221', '0452', 8);
INSERT INTO `district` VALUES (1111, '依安', 183, 'y', 'ya', 'yian', '', '县', '230223', '0452', 9);
INSERT INTO `district` VALUES (1112, '泰来', 183, 't', 'tl', 'tailai', '', '县', '230224', '0452', 10);
INSERT INTO `district` VALUES (1113, '甘南', 183, 'g', 'gn', 'gannan', '', '县', '230225', '0452', 11);
INSERT INTO `district` VALUES (1114, '富裕', 183, 'f', 'fy', 'fuyu', '', '县', '230227', '0452', 12);
INSERT INTO `district` VALUES (1115, '克山', 183, 'k', 'ks', 'keshan', '', '县', '230229', '0452', 13);
INSERT INTO `district` VALUES (1116, '克东', 183, 'k', 'kd', 'kedong', '', '县', '230230', '0452', 14);
INSERT INTO `district` VALUES (1117, '拜泉', 183, 'b', 'bq', 'baiquan', '', '县', '230231', '0452', 15);
INSERT INTO `district` VALUES (1118, '讷河', 183, 'n', 'nh', 'nehe', '', '市', '230281', '0452', 16);
INSERT INTO `district` VALUES (1119, '鸡冠', 184, 'j', 'jg', 'jiguan', '', '区', '230302', '0467', 1);
INSERT INTO `district` VALUES (1120, '恒山', 184, 'h', 'hs', 'hengshan', '', '区', '230303', '0467', 2);
INSERT INTO `district` VALUES (1121, '滴道', 184, 'd', 'dd', 'didao', '', '区', '230304', '0467', 3);
INSERT INTO `district` VALUES (1122, '梨树', 184, 'l', 'ls', 'lishu', '', '区', '230305', '0467', 4);
INSERT INTO `district` VALUES (1123, '城子河', 184, 'c', 'czh', 'chengzihe', '', '区', '230306', '0467', 5);
INSERT INTO `district` VALUES (1124, '麻山', 184, 'm', 'ms', 'mashan', '', '区', '230307', '0467', 6);
INSERT INTO `district` VALUES (1125, '鸡东', 184, 'j', 'jd', 'jidong', '', '县', '230321', '0467', 7);
INSERT INTO `district` VALUES (1126, '虎林', 184, 'h', 'hl', 'hulin', '', '市', '230381', '0467', 8);
INSERT INTO `district` VALUES (1127, '密山', 184, 'm', 'ms', 'mishan', '', '市', '230382', '0467', 9);
INSERT INTO `district` VALUES (1128, '向阳', 185, 'x', 'xy', 'xiangyang', '', '区', '230402', '0468', 1);
INSERT INTO `district` VALUES (1129, '工农', 185, 'g', 'gn', 'gongnong', '', '区', '230403', '0468', 2);
INSERT INTO `district` VALUES (1130, '南山', 185, 'n', 'ns', 'nanshan', '', '区', '230404', '0468', 3);
INSERT INTO `district` VALUES (1131, '兴安', 185, 'x', 'xa', 'xingan', '', '区', '230405', '0468', 4);
INSERT INTO `district` VALUES (1132, '东山', 185, 'd', 'ds', 'dongshan', '', '区', '230406', '0468', 5);
INSERT INTO `district` VALUES (1133, '兴山', 185, 'x', 'xs', 'xingshan', '', '区', '230407', '0468', 6);
INSERT INTO `district` VALUES (1134, '萝北', 185, 'l', 'lb', 'luobei', '', '县', '230421', '0468', 7);
INSERT INTO `district` VALUES (1135, '绥滨', 185, 's', 'sb', 'suibin', '', '县', '230422', '0468', 8);
INSERT INTO `district` VALUES (1136, '尖山', 186, 'j', 'js', 'jianshan', '', '区', '230502', '0469', 1);
INSERT INTO `district` VALUES (1137, '岭东', 186, 'l', 'ld', 'lingdong', '', '区', '230503', '0469', 2);
INSERT INTO `district` VALUES (1138, '四方台', 186, 's', 'sft', 'sifangtai', '', '区', '230505', '0469', 3);
INSERT INTO `district` VALUES (1139, '宝山', 186, 'b', 'bs', 'baoshan', '', '区', '230506', '0469', 4);
INSERT INTO `district` VALUES (1140, '集贤', 186, 'j', 'jx', 'jixian', '', '县', '230521', '0469', 5);
INSERT INTO `district` VALUES (1141, '友谊', 186, 'y', 'yy', 'youyi', '', '县', '230522', '0469', 6);
INSERT INTO `district` VALUES (1142, '宝清', 186, 'b', 'bq', 'baoqing', '', '县', '230523', '0469', 7);
INSERT INTO `district` VALUES (1143, '饶河', 186, 'r', 'rh', 'raohe', '', '县', '230524', '0469', 8);
INSERT INTO `district` VALUES (1144, '萨尔图', 187, 's', 'set', 'saertu', '', '区', '230602', '0459', 1);
INSERT INTO `district` VALUES (1145, '龙凤', 187, 'l', 'lf', 'longfeng', '', '区', '230603', '0459', 2);
INSERT INTO `district` VALUES (1146, '让胡路', 187, 'r', 'rhl', 'ranghulu', '', '区', '230604', '0459', 3);
INSERT INTO `district` VALUES (1147, '红岗', 187, 'h', 'hg', 'honggang', '', '区', '230605', '0459', 4);
INSERT INTO `district` VALUES (1148, '大同', 187, 'd', 'dt', 'datong', '', '区', '230606', '0459', 5);
INSERT INTO `district` VALUES (1149, '肇州', 187, 'z', 'zz', 'zhaozhou', '', '县', '230621', '0459', 6);
INSERT INTO `district` VALUES (1150, '肇源', 187, 'z', 'zy', 'zhaoyuan', '', '县', '230622', '0459', 7);
INSERT INTO `district` VALUES (1151, '林甸', 187, 'l', 'ld', 'lindian', '', '县', '230623', '0459', 8);
INSERT INTO `district` VALUES (1152, '杜尔伯特', 187, 'd', 'debt', 'duerbote', '蒙古族', '自治县', '230624', '0459', 9);
INSERT INTO `district` VALUES (1154, '南岔', 188, 'n', 'nc', 'nancha', '', '县', '230726', '0458', 8);
INSERT INTO `district` VALUES (1155, '友好', 188, 'y', 'yh', 'youhao', '', '区', '230719', '0458', 3);
INSERT INTO `district` VALUES (1156, '金林', 188, 'j', 'jl', 'jinlin', '', '区', '230751', '0458', 9);
INSERT INTO `district` VALUES (1157, '乌翠', 188, 'w', 'wc', 'wucui', '', '区', '230718', '0458', 2);
INSERT INTO `district` VALUES (1158, '丰林', 188, 'f', 'fl', 'fenglin', '', '县', '230724', '0458', 6);
INSERT INTO `district` VALUES (1162, '伊美', 188, 'y', 'ym', 'yimei', '', '区', '230717', '0458', 1);
INSERT INTO `district` VALUES (1163, '汤旺', 188, 't', 'tw', 'tangwang', '', '县', '230723', '0458', 5);
INSERT INTO `district` VALUES (1164, '大箐山', 188, 'd', 'dqs', 'daqingshan', '', '县', '230725', '0458', 7);
INSERT INTO `district` VALUES (1168, '嘉荫', 188, 'j', 'jy', 'jiayin', '', '县', '230722', '0458', 4);
INSERT INTO `district` VALUES (1169, '铁力', 188, 't', 'tl', 'tieli', '', '市', '230781', '0458', 10);
INSERT INTO `district` VALUES (1170, '向阳', 189, 'x', 'xy', 'xiangyang', '', '区', '230803', '0454', 1);
INSERT INTO `district` VALUES (1171, '前进', 189, 'q', 'qj', 'qianjin', '', '区', '230804', '0454', 2);
INSERT INTO `district` VALUES (1172, '东风', 189, 'd', 'df', 'dongfeng', '', '区', '230805', '0454', 3);
INSERT INTO `district` VALUES (1173, '郊区', 189, 'j', 'jq', 'jiaoqu', '', '', '230811', '0454', 4);
INSERT INTO `district` VALUES (1174, '桦南', 189, 'h', 'hn', 'huanan', '', '县', '230822', '0454', 5);
INSERT INTO `district` VALUES (1175, '桦川', 189, 'h', 'hc', 'huachuan', '', '县', '230826', '0454', 6);
INSERT INTO `district` VALUES (1176, '汤原', 189, 't', 'ty', 'tangyuan', '', '县', '230828', '0454', 7);
INSERT INTO `district` VALUES (1177, '抚远', 189, 'f', 'fy', 'fuyuan', '', '市', '230883', '0454', 10);
INSERT INTO `district` VALUES (1178, '同江', 189, 't', 'tj', 'tongjiang', '', '市', '230881', '0454', 8);
INSERT INTO `district` VALUES (1179, '富锦', 189, 'f', 'fj', 'fujin', '', '市', '230882', '0454', 9);
INSERT INTO `district` VALUES (1180, '新兴', 190, 'x', 'xx', 'xinxing', '', '区', '230902', '0464', 1);
INSERT INTO `district` VALUES (1181, '桃山', 190, 't', 'ts', 'taoshan', '', '区', '230903', '0464', 2);
INSERT INTO `district` VALUES (1182, '茄子河', 190, 'q', 'qzh', 'qiezihe', '', '区', '230904', '0464', 3);
INSERT INTO `district` VALUES (1183, '勃利', 190, 'b', 'bl', 'boli', '', '县', '230921', '0464', 4);
INSERT INTO `district` VALUES (1184, '东安', 191, 'd', 'da', 'dongan', '', '区', '231002', '0453', 1);
INSERT INTO `district` VALUES (1185, '阳明', 191, 'y', 'ym', 'yangming', '', '区', '231003', '0453', 2);
INSERT INTO `district` VALUES (1186, '爱民', 191, 'a', 'am', 'aimin', '', '区', '231004', '0453', 3);
INSERT INTO `district` VALUES (1187, '西安', 191, 'x', 'xa', 'xian', '', '区', '231005', '0453', 4);
INSERT INTO `district` VALUES (1188, '东宁', 191, 'd', 'dn', 'dongning', '', '市', '231086', '0453', 10);
INSERT INTO `district` VALUES (1189, '林口', 191, 'l', 'lk', 'linkou', '', '县', '231025', '0453', 5);
INSERT INTO `district` VALUES (1190, '绥芬河', 191, 's', 'sfh', 'suifenhe', '', '市', '231081', '0453', 6);
INSERT INTO `district` VALUES (1191, '海林', 191, 'h', 'hl', 'hailin', '', '市', '231083', '0453', 7);
INSERT INTO `district` VALUES (1192, '宁安', 191, 'n', 'na', 'ningan', '', '市', '231084', '0453', 8);
INSERT INTO `district` VALUES (1193, '穆棱', 191, 'm', 'ml', 'muleng', '', '市', '231085', '0453', 9);
INSERT INTO `district` VALUES (1194, '爱辉', 192, 'a', 'ah', 'aihui', '', '区', '231102', '0456', 1);
INSERT INTO `district` VALUES (1195, '嫩江', 192, 'n', 'nj', 'nenjiang', '', '市', '231183', '0456', 6);
INSERT INTO `district` VALUES (1196, '逊克', 192, 'x', 'xk', 'xunke', '', '县', '231123', '0456', 2);
INSERT INTO `district` VALUES (1197, '孙吴', 192, 's', 'sw', 'sunwu', '', '县', '231124', '0456', 3);
INSERT INTO `district` VALUES (1198, '北安', 192, 'b', 'ba', 'beian', '', '市', '231181', '0456', 4);
INSERT INTO `district` VALUES (1199, '五大连池', 192, 'w', 'wdlc', 'wudalianchi', '', '市', '231182', '0456', 5);
INSERT INTO `district` VALUES (1200, '北林', 193, 'b', 'bl', 'beilin', '', '区', '231202', '0455', 1);
INSERT INTO `district` VALUES (1201, '望奎', 193, 'w', 'wk', 'wangkui', '', '县', '231221', '0455', 2);
INSERT INTO `district` VALUES (1202, '兰西', 193, 'l', 'lx', 'lanxi', '', '县', '231222', '0455', 3);
INSERT INTO `district` VALUES (1203, '青冈', 193, 'q', 'qg', 'qinggang', '', '县', '231223', '0455', 4);
INSERT INTO `district` VALUES (1204, '庆安', 193, 'q', 'qa', 'qingan', '', '县', '231224', '0455', 5);
INSERT INTO `district` VALUES (1205, '明水', 193, 'm', 'ms', 'mingshui', '', '县', '231225', '0455', 6);
INSERT INTO `district` VALUES (1206, '绥棱', 193, 's', 'sl', 'suileng', '', '县', '231226', '0455', 7);
INSERT INTO `district` VALUES (1207, '安达', 193, 'a', 'ad', 'anda', '', '市', '231281', '0455', 8);
INSERT INTO `district` VALUES (1208, '肇东', 193, 'z', 'zd', 'zhaodong', '', '市', '231282', '0455', 9);
INSERT INTO `district` VALUES (1209, '海伦', 193, 'h', 'hl', 'hailun', '', '市', '231283', '0455', 10);
INSERT INTO `district` VALUES (1210, '加格达奇', 194, 'j', 'jgdq', 'jiagedaqi', '', '区', '232701', '0457', 1);
INSERT INTO `district` VALUES (1211, '松岭', 194, 's', 'sl', 'songling', '', '区', '232702', '0457', 2);
INSERT INTO `district` VALUES (1212, '新林', 194, 'x', 'xl', 'xinlin', '', '区', '232703', '0457', 3);
INSERT INTO `district` VALUES (1213, '呼中', 194, 'h', 'hz', 'huzhong', '', '区', '232704', '0457', 4);
INSERT INTO `district` VALUES (1214, '呼玛', 194, 'h', 'hm', 'huma', '', '县', '232721', '0457', 5);
INSERT INTO `district` VALUES (1215, '塔河', 194, 't', 'th', 'tahe', '', '县', '232722', '0457', 6);
INSERT INTO `district` VALUES (1216, '漠河', 194, 'm', 'mh', 'mohe', '', '市', '232701', '0457', 7);
INSERT INTO `district` VALUES (1217, '玄武', 195, 'x', 'xw', 'xuanwu', '', '区', '320102', '', 1);
INSERT INTO `district` VALUES (1218, '秦淮', 195, 'q', 'qh', 'qinhuai', '', '区', '320104', '', 2);
INSERT INTO `district` VALUES (1219, '建邺', 195, 'j', 'jy', 'jianye', '', '区', '320105', '', 3);
INSERT INTO `district` VALUES (1220, '鼓楼', 195, 'g', 'gl', 'gulou', '', '区', '320106', '', 4);
INSERT INTO `district` VALUES (1221, '浦口', 195, 'p', 'pk', 'pukou', '', '区', '320111', '', 5);
INSERT INTO `district` VALUES (1222, '栖霞', 195, 'q', 'qx', 'qixia', '', '区', '320113', '', 6);
INSERT INTO `district` VALUES (1223, '雨花台', 195, 'y', 'yht', 'yuhuatai', '', '区', '320114', '', 7);
INSERT INTO `district` VALUES (1224, '江宁', 195, 'j', 'jn', 'jiangning', '', '区', '320115', '', 8);
INSERT INTO `district` VALUES (1225, '六合', 195, 'l', 'lh', 'liuhe', '', '区', '320116', '', 9);
INSERT INTO `district` VALUES (1226, '溧水', 195, 'l', 'ls', 'lishui', '', '区', '320124', '', 10);
INSERT INTO `district` VALUES (1227, '高淳', 195, 'g', 'gc', 'gaochun', '', '区', '320125', '', 11);
INSERT INTO `district` VALUES (1228, '梁溪', 196, 'l', 'lx', 'liangxi', '', '区', '320202', '0510', 1);
INSERT INTO `district` VALUES (1229, '新吴', 196, 'x', 'xw', 'xinwu', '', '区', '', '0510', 2);
INSERT INTO `district` VALUES (1231, '锡山', 196, 'x', 'xs', 'xishan', '', '区', '320205', '0510', 4);
INSERT INTO `district` VALUES (1232, '惠山', 196, 'h', 'hs', 'huishan', '', '区', '320206', '0510', 5);
INSERT INTO `district` VALUES (1233, '滨湖', 196, 'b', 'bh', 'binhu', '', '区', '320211', '0510', 6);
INSERT INTO `district` VALUES (1234, '江阴', 196, 'j', 'jy', 'jiangyin', '', '市', '320281', '0510', 7);
INSERT INTO `district` VALUES (1235, '宜兴', 196, 'y', 'yx', 'yixing', '', '市', '320282', '0510', 8);
INSERT INTO `district` VALUES (1236, '鼓楼', 197, 'g', 'gl', 'gulou', '', '区', '320302', '0516', 1);
INSERT INTO `district` VALUES (1237, '云龙', 197, 'y', 'yl', 'yunlong', '', '区', '320303', '0516', 2);
INSERT INTO `district` VALUES (1238, '贾汪', 197, 'j', 'jw', 'jiawang', '', '区', '320305', '0516', 3);
INSERT INTO `district` VALUES (1239, '泉山', 197, 'q', 'qs', 'quanshan', '', '区', '320311', '0516', 4);
INSERT INTO `district` VALUES (1240, '铜山', 197, 't', 'ts', 'tongshan', '', '区', '320312', '0516', 5);
INSERT INTO `district` VALUES (1241, '丰县', 197, 'f', 'fx', 'fengxian', '', '', '320321', '0516', 6);
INSERT INTO `district` VALUES (1242, '沛县', 197, 'p', 'px', 'peixian', '', '', '320322', '0516', 7);
INSERT INTO `district` VALUES (1243, '睢宁', 197, 's', 'sn', 'suining', '', '县', '320324', '0516', 8);
INSERT INTO `district` VALUES (1244, '新沂', 197, 'x', 'xy', 'xinyi', '', '市', '320381', '0516', 9);
INSERT INTO `district` VALUES (1245, '邳州', 197, 'p', 'pz', 'pizhou', '', '市', '320382', '0516', 10);
INSERT INTO `district` VALUES (1246, '天宁', 198, 't', 'tn', 'tianning', '', '区', '320402', '0519', 1);
INSERT INTO `district` VALUES (1247, '钟楼', 198, 'z', 'zl', 'zhonglou', '', '区', '320404', '0519', 2);
INSERT INTO `district` VALUES (1249, '新北', 198, 'x', 'xb', 'xinbei', '', '区', '320411', '0519', 4);
INSERT INTO `district` VALUES (1250, '武进', 198, 'w', 'wj', 'wujin', '', '区', '320412', '0519', 5);
INSERT INTO `district` VALUES (1251, '溧阳', 198, 'l', 'ly', 'liyang', '', '市', '320481', '0519', 6);
INSERT INTO `district` VALUES (1252, '金坛', 198, 'j', 'jt', 'jintan', '', '区', '320482', '0519', 7);
INSERT INTO `district` VALUES (1253, '虎丘', 199, 'h', 'hq', 'huqiu', '', '区', '320505', '0512', 1);
INSERT INTO `district` VALUES (1254, '吴中', 199, 'w', 'wz', 'wuzhong', '', '区', '320506', '0512', 2);
INSERT INTO `district` VALUES (1255, '相城', 199, 'x', 'xc', 'xiangcheng', '', '区', '320507', '0512', 3);
INSERT INTO `district` VALUES (1256, '姑苏', 199, 'g', 'gs', 'gusu', '', '区', '320508', '0512', 4);
INSERT INTO `district` VALUES (1257, '吴江', 199, 'w', 'wj', 'wujiang', '', '市', '320509', '0512', 5);
INSERT INTO `district` VALUES (1258, '常熟', 199, 'c', 'cs', 'changshu', '', '市', '320581', '0512', 6);
INSERT INTO `district` VALUES (1259, '张家港', 199, 'z', 'zjg', 'zhangjiagang', '', '市', '320582', '0512', 7);
INSERT INTO `district` VALUES (1260, '昆山', 199, 'k', 'ks', 'kunshan', '', '市', '320583', '0512', 8);
INSERT INTO `district` VALUES (1261, '太仓', 199, 't', 'tc', 'taicang', '', '市', '320585', '0512', 9);
INSERT INTO `district` VALUES (1262, '崇川', 200, 'c', 'cc', 'chongchuan', '', '区', '320602', '0513', 1);
INSERT INTO `district` VALUES (1263, '港闸', 200, 'g', 'gz', 'gangzha', '', '区', '320611', '0513', 2);
INSERT INTO `district` VALUES (1264, '通州', 200, 't', 'tz', 'tongzhou', '', '区', '320612', '0513', 3);
INSERT INTO `district` VALUES (1265, '海安', 200, 'h', 'ha', 'haian', '', '市', '320685', '0513', 4);
INSERT INTO `district` VALUES (1266, '如东', 200, 'r', 'rd', 'rudong', '', '县', '320623', '0513', 5);
INSERT INTO `district` VALUES (1267, '启东', 200, 'q', 'qd', 'qidong', '', '市', '320681', '0513', 6);
INSERT INTO `district` VALUES (1268, '如皋', 200, 'r', 'rg', 'rugao', '', '市', '320682', '0513', 7);
INSERT INTO `district` VALUES (1269, '海门', 200, 'h', 'hm', 'haimen', '', '市', '320684', '0513', 8);
INSERT INTO `district` VALUES (1270, '连云', 201, 'l', 'ly', 'lianyun', '', '区', '320703', '0518', 1);
INSERT INTO `district` VALUES (1272, '海州', 201, 'h', 'hz', 'haizhou', '', '区', '320706', '0518', 2);
INSERT INTO `district` VALUES (1273, '赣榆', 201, 'g', 'gy', 'ganyu', '', '区', '320721', '0518', 3);
INSERT INTO `district` VALUES (1274, '东海', 201, 'd', 'dh', 'donghai', '', '县', '320722', '0518', 4);
INSERT INTO `district` VALUES (1275, '灌云', 201, 'g', 'gy', 'guanyun', '', '县', '320723', '0518', 5);
INSERT INTO `district` VALUES (1276, '灌南', 201, 'g', 'gn', 'guannan', '', '县', '320724', '0518', 6);
INSERT INTO `district` VALUES (1278, '淮安', 202, 'h', 'ha', 'huaian', '', '区', '320803', '0517', 1);
INSERT INTO `district` VALUES (1279, '淮阴', 202, 'h', 'hy', 'huaiyin', '', '区', '320804', '0517', 2);
INSERT INTO `district` VALUES (1280, '清江浦', 202, 'q', 'qjp', 'qingjiangpu', '', '区', '320812', '0517', 3);
INSERT INTO `district` VALUES (1281, '涟水', 202, 'l', 'ls', 'lianshui', '', '县', '320826', '0517', 5);
INSERT INTO `district` VALUES (1282, '洪泽', 202, 'h', 'hz', 'hongze', '', '区', '320813', '0517', 4);
INSERT INTO `district` VALUES (1283, '盱眙', 202, 'x', 'xy', 'xuyi', '', '县', '320830', '0517', 6);
INSERT INTO `district` VALUES (1284, '金湖', 202, 'j', 'jh', 'jinhu', '', '县', '320831', '0517', 7);
INSERT INTO `district` VALUES (1285, '亭湖', 203, 't', 'th', 'tinghu', '', '区', '320902', '0515', 1);
INSERT INTO `district` VALUES (1286, '盐都', 203, 'y', 'yd', 'yandu', '', '区', '320903', '0515', 2);
INSERT INTO `district` VALUES (1287, '响水', 203, 'x', 'xs', 'xiangshui', '', '县', '320921', '0515', 3);
INSERT INTO `district` VALUES (1288, '滨海', 203, 'b', 'bh', 'binhai', '', '县', '320922', '0515', 4);
INSERT INTO `district` VALUES (1289, '阜宁', 203, 'f', 'fn', 'funing', '', '县', '320923', '0515', 5);
INSERT INTO `district` VALUES (1290, '射阳', 203, 's', 'sy', 'sheyang', '', '县', '320924', '0515', 6);
INSERT INTO `district` VALUES (1291, '建湖', 203, 'j', 'jh', 'jianhu', '', '县', '320925', '0515', 7);
INSERT INTO `district` VALUES (1292, '东台', 203, 'd', 'dt', 'dongtai', '', '市', '320981', '0515', 8);
INSERT INTO `district` VALUES (1293, '大丰', 203, 'd', 'df', 'dafeng', '', '区', '320982', '0515', 9);
INSERT INTO `district` VALUES (1294, '广陵', 204, 'g', 'gl', 'guangling', '', '区', '321002', '0514', 1);
INSERT INTO `district` VALUES (1295, '邗江', 204, 'h', 'hj', 'hanjiang', '', '区', '321003', '0514', 2);
INSERT INTO `district` VALUES (1296, '江都', 204, 'j', 'jd', 'jiangu', '', '区', '321012', '0514', 3);
INSERT INTO `district` VALUES (1297, '宝应', 204, 'b', 'by', 'baoying', '', '县', '321023', '0514', 4);
INSERT INTO `district` VALUES (1298, '仪征', 204, 'y', 'yz', 'yizheng', '', '市', '321081', '0514', 5);
INSERT INTO `district` VALUES (1299, '高邮', 204, 'g', 'gy', 'gaoyou', '', '市', '321084', '0514', 6);
INSERT INTO `district` VALUES (1300, '京口', 205, 'j', 'jk', 'jingkou', '', '区', '321102', '0511', 1);
INSERT INTO `district` VALUES (1301, '润州', 205, 'r', 'rz', 'runzhou', '', '区', '321111', '0511', 2);
INSERT INTO `district` VALUES (1302, '丹徒', 205, 'd', 'dt', 'dantu', '', '区', '321112', '0511', 3);
INSERT INTO `district` VALUES (1303, '丹阳', 205, 'd', 'dy', 'danyang', '', '市', '321181', '0511', 4);
INSERT INTO `district` VALUES (1304, '扬中', 205, 'y', 'yz', 'yangzhong', '', '市', '321182', '0511', 5);
INSERT INTO `district` VALUES (1305, '句容', 205, 'j', 'jr', 'jurong', '', '市', '321183', '0511', 6);
INSERT INTO `district` VALUES (1306, '海陵', 206, 'h', 'hl', 'hailing', '', '区', '321202', '0523', 1);
INSERT INTO `district` VALUES (1307, '高港', 206, 'g', 'gg', 'gaogang', '', '区', '321203', '0523', 2);
INSERT INTO `district` VALUES (1308, '兴化', 206, 'x', 'xh', 'xinghua', '', '市', '321281', '0523', 3);
INSERT INTO `district` VALUES (1309, '靖江', 206, 'j', 'jj', 'jingjiang', '', '市', '321282', '0523', 4);
INSERT INTO `district` VALUES (1310, '泰兴', 206, 't', 'tx', 'taixing', '', '市', '321283', '0523', 5);
INSERT INTO `district` VALUES (1311, '姜堰', 206, 'j', 'jy', 'jiangyan', '', '区', '321284', '0523', 6);
INSERT INTO `district` VALUES (1312, '宿城', 207, 's', 'sc', 'sucheng', '', '区', '321302', '0527', 1);
INSERT INTO `district` VALUES (1313, '宿豫', 207, 's', 'sy', 'suyu', '', '区', '321311', '0527', 2);
INSERT INTO `district` VALUES (1314, '沭阳', 207, 's', 'sy', 'shuyang', '', '县', '321322', '0527', 3);
INSERT INTO `district` VALUES (1315, '泗阳', 207, 's', 'sy', 'siyang', '', '县', '321323', '0527', 4);
INSERT INTO `district` VALUES (1316, '泗洪', 207, 's', 'sh', 'sihong', '', '县', '321324', '0527', 5);
INSERT INTO `district` VALUES (1317, '上城', 208, 's', 'sc', 'shangcheng', '', '区', '330102', '0571', 1);
INSERT INTO `district` VALUES (1318, '下城', 208, 'x', 'xc', 'xiacheng', '', '区', '330103', '0571', 2);
INSERT INTO `district` VALUES (1319, '江干', 208, 'j', 'jg', 'jianggan', '', '区', '330104', '0571', 3);
INSERT INTO `district` VALUES (1320, '拱墅', 208, 'g', 'gs', 'gongshu', '', '区', '330105', '0571', 4);
INSERT INTO `district` VALUES (1321, '西湖', 208, 'x', 'xh', 'xihu', '', '区', '330106', '0571', 5);
INSERT INTO `district` VALUES (1322, '滨江', 208, 'b', 'bj', 'binjiang', '', '区', '330108', '0571', 6);
INSERT INTO `district` VALUES (1323, '萧山', 208, 'x', 'xs', 'xiaoshan', '', '区', '330109', '0571', 7);
INSERT INTO `district` VALUES (1324, '余杭', 208, 'y', 'yh', 'yuhang', '', '区', '330110', '0571', 8);
INSERT INTO `district` VALUES (1325, '桐庐', 208, 't', 'tl', 'tonglu', '', '县', '330122', '0571', 10);
INSERT INTO `district` VALUES (1326, '淳安', 208, 'c', 'ca', 'chunan', '', '县', '330127', '0571', 11);
INSERT INTO `district` VALUES (1327, '建德', 208, 'j', 'jd', 'jiande', '', '市', '330182', '0571', 12);
INSERT INTO `district` VALUES (1328, '富阳', 208, 'f', 'fy', 'fuyang', '', '区', '330183', '0571', 13);
INSERT INTO `district` VALUES (1329, '临安', 208, 'l', 'la', 'linan', '', '区', '330112', '0571', 9);
INSERT INTO `district` VALUES (1330, '海曙', 209, 'h', 'hs', 'haishu', '', '区', '330203', '0574', 1);
INSERT INTO `district` VALUES (1332, '江北', 209, 'j', 'jb', 'jiangbei', '', '区', '330205', '0574', 3);
INSERT INTO `district` VALUES (1333, '北仑', 209, 'b', 'bl', 'beilun', '', '区', '330206', '0574', 4);
INSERT INTO `district` VALUES (1334, '镇海', 209, 'z', 'zh', 'zhenhai', '', '区', '330211', '0574', 5);
INSERT INTO `district` VALUES (1335, '鄞州', 209, 'y', 'yz', 'yinzhou', '', '区', '330212', '0574', 6);
INSERT INTO `district` VALUES (1336, '象山', 209, 'x', 'xs', 'xiangshan', '', '县', '330225', '0574', 8);
INSERT INTO `district` VALUES (1337, '宁海', 209, 'n', 'nh', 'ninghai', '', '县', '330226', '0574', 9);
INSERT INTO `district` VALUES (1338, '余姚', 209, 'y', 'yy', 'yuyao', '', '市', '330281', '0574', 10);
INSERT INTO `district` VALUES (1339, '慈溪', 209, 'c', 'cx', 'cixi', '', '市', '330282', '0574', 11);
INSERT INTO `district` VALUES (1340, '奉化', 209, 'f', 'fh', 'fenghua', '', '区', '330213', '0574', 7);
INSERT INTO `district` VALUES (1341, '鹿城', 210, 'l', 'lc', 'lucheng', '', '区', '330302', '0577', 1);
INSERT INTO `district` VALUES (1342, '龙湾', 210, 'l', 'lw', 'longwan', '', '区', '330303', '0577', 2);
INSERT INTO `district` VALUES (1343, '瓯海', 210, 'o', 'oh', 'ouhai', '', '区', '330304', '0577', 3);
INSERT INTO `district` VALUES (1344, '洞头', 210, 'd', 'dt', 'dongtou', '', '区', '330322', '0577', 4);
INSERT INTO `district` VALUES (1345, '永嘉', 210, 'y', 'yj', 'yongjia', '', '县', '330324', '0577', 5);
INSERT INTO `district` VALUES (1346, '平阳', 210, 'p', 'py', 'pingyang', '', '县', '330326', '0577', 6);
INSERT INTO `district` VALUES (1347, '苍南', 210, 'c', 'cn', 'cangnan', '', '县', '330327', '0577', 7);
INSERT INTO `district` VALUES (1348, '文成', 210, 'w', 'wc', 'wencheng', '', '县', '330328', '0577', 8);
INSERT INTO `district` VALUES (1349, '泰顺', 210, 't', 'ts', 'taishun', '', '县', '330329', '0577', 9);
INSERT INTO `district` VALUES (1350, '瑞安', 210, 'r', 'ra', 'ruian', '', '市', '330381', '0577', 10);
INSERT INTO `district` VALUES (1351, '乐清', 210, 'l', 'lq', 'leqing', '', '市', '330382', '0577', 11);
INSERT INTO `district` VALUES (1352, '南湖', 211, 'n', 'nh', 'nanhu', '', '区', '330402', '0573', 1);
INSERT INTO `district` VALUES (1353, '秀洲', 211, 'x', 'xz', 'xiuzhou', '', '区', '330411', '0573', 2);
INSERT INTO `district` VALUES (1354, '嘉善', 211, 'j', 'js', 'jiashan', '', '县', '330421', '0573', 3);
INSERT INTO `district` VALUES (1355, '海盐', 211, 'h', 'hy', 'haiyan', '', '县', '330424', '0573', 4);
INSERT INTO `district` VALUES (1356, '海宁', 211, 'h', 'hn', 'haining', '', '市', '330481', '0573', 5);
INSERT INTO `district` VALUES (1357, '平湖', 211, 'p', 'ph', 'pinghu', '', '市', '330482', '0573', 6);
INSERT INTO `district` VALUES (1358, '桐乡', 211, 't', 'tx', 'tongxiang', '', '市', '330483', '0573', 7);
INSERT INTO `district` VALUES (1359, '吴兴', 212, 'w', 'wx', 'wuxing', '', '区', '330502', '0572', 1);
INSERT INTO `district` VALUES (1360, '南浔', 212, 'n', 'nx', 'nanxun', '', '区', '330503', '0572', 2);
INSERT INTO `district` VALUES (1361, '德清', 212, 'd', 'dq', 'deqing', '', '县', '330521', '0572', 3);
INSERT INTO `district` VALUES (1362, '长兴', 212, 'c', 'cx', 'changxing', '', '县', '330522', '0572', 4);
INSERT INTO `district` VALUES (1363, '安吉', 212, 'a', 'aj', 'anji', '', '县', '330523', '0572', 5);
INSERT INTO `district` VALUES (1364, '越城', 213, 'y', 'yc', 'yuecheng', '', '区', '330602', '0575', 1);
INSERT INTO `district` VALUES (1365, '柯桥', 213, 'k', 'kq', 'keqiao', '', '区', '330603', '0575', 2);
INSERT INTO `district` VALUES (1366, '新昌', 213, 'x', 'xc', 'xinchang', '', '县', '330624', '0575', 4);
INSERT INTO `district` VALUES (1367, '诸暨', 213, 'z', 'zj', 'zhuji', '', '市', '330681', '0575', 5);
INSERT INTO `district` VALUES (1368, '上虞', 213, 's', 'sy', 'shangyu', '', '区', '330604', '0575', 3);
INSERT INTO `district` VALUES (1369, '嵊州', 213, 's', 'sz', 'shengzhou', '', '市', '330683', '0575', 6);
INSERT INTO `district` VALUES (1370, '婺城', 214, 'w', 'wc', 'wucheng', '', '区', '330702', '0579', 1);
INSERT INTO `district` VALUES (1371, '金东', 214, 'j', 'jd', 'jindong', '', '区', '330703', '0579', 2);
INSERT INTO `district` VALUES (1372, '武义', 214, 'w', 'wy', 'wuyi', '', '县', '330723', '0579', 3);
INSERT INTO `district` VALUES (1373, '浦江', 214, 'p', 'pj', 'pujiang', '', '县', '330726', '0579', 4);
INSERT INTO `district` VALUES (1374, '磐安', 214, 'p', 'pa', 'panan', '', '县', '330727', '0579', 5);
INSERT INTO `district` VALUES (1375, '兰溪', 214, 'l', 'lx', 'lanxi', '', '市', '330781', '0579', 6);
INSERT INTO `district` VALUES (1376, '义乌', 214, 'y', 'yw', 'yiwu', '', '市', '330782', '0579', 7);
INSERT INTO `district` VALUES (1377, '东阳', 214, 'd', 'dy', 'dongyang', '', '市', '330783', '0579', 8);
INSERT INTO `district` VALUES (1378, '永康', 214, 'y', 'yk', 'yongkang', '', '市', '330784', '0579', 9);
INSERT INTO `district` VALUES (1379, '柯城', 215, 'k', 'kc', 'kecheng', '', '区', '330802', '0570', 1);
INSERT INTO `district` VALUES (1380, '衢江', 215, 'q', 'qj', 'qujiang', '', '区', '330803', '0570', 2);
INSERT INTO `district` VALUES (1381, '常山', 215, 'c', 'cs', 'changshan', '', '县', '330822', '0570', 3);
INSERT INTO `district` VALUES (1382, '开化', 215, 'k', 'kh', 'kaihua', '', '县', '330824', '0570', 4);
INSERT INTO `district` VALUES (1383, '龙游', 215, 'l', 'ly', 'longyou', '', '县', '330825', '0570', 5);
INSERT INTO `district` VALUES (1384, '江山', 215, 'j', 'js', 'jiangshan', '', '市', '330881', '0570', 6);
INSERT INTO `district` VALUES (1385, '定海', 216, 'd', 'dh', 'dinghai', '', '区', '330902', '0580', 1);
INSERT INTO `district` VALUES (1386, '普陀', 216, 'p', 'pt', 'putuo', '', '区', '330903', '0580', 2);
INSERT INTO `district` VALUES (1387, '岱山', 216, 'd', 'ds', 'daishan', '', '县', '330921', '0580', 3);
INSERT INTO `district` VALUES (1388, '嵊泗', 216, 's', 'ss', 'shengsi', '', '县', '330922', '0580', 4);
INSERT INTO `district` VALUES (1389, '椒江', 217, 'j', 'jj', 'jiaojiang', '', '区', '331002', '0576', 1);
INSERT INTO `district` VALUES (1390, '黄岩', 217, 'h', 'hy', 'huangyan', '', '区', '331003', '0576', 2);
INSERT INTO `district` VALUES (1391, '路桥', 217, 'l', 'lq', 'luqiao', '', '区', '331004', '0576', 3);
INSERT INTO `district` VALUES (1392, '玉环', 217, 'y', 'yh', 'yuhuan', '', '市', '331083', '0576', 9);
INSERT INTO `district` VALUES (1393, '三门', 217, 's', 'sm', 'sanmen', '', '县', '331022', '0576', 4);
INSERT INTO `district` VALUES (1394, '天台', 217, 't', 'tt', 'tiantai', '', '县', '331023', '0576', 5);
INSERT INTO `district` VALUES (1395, '仙居', 217, 'x', 'xj', 'xianju', '', '县', '331024', '0576', 6);
INSERT INTO `district` VALUES (1396, '温岭', 217, 'w', 'wl', 'wenling', '', '市', '331081', '0576', 7);
INSERT INTO `district` VALUES (1397, '临海', 217, 'l', 'lh', 'linhai', '', '市', '331082', '0576', 8);
INSERT INTO `district` VALUES (1398, '莲都', 218, 'l', 'ld', 'liandu', '', '区', '331102', '0578', 1);
INSERT INTO `district` VALUES (1399, '青田', 218, 'q', 'qt', 'qingtian', '', '县', '331121', '0578', 2);
INSERT INTO `district` VALUES (1400, '缙云', 218, 'j', 'jy', 'jinyun', '', '县', '331122', '0578', 3);
INSERT INTO `district` VALUES (1401, '遂昌', 218, 's', 'sc', 'suichang', '', '县', '331123', '0578', 4);
INSERT INTO `district` VALUES (1402, '松阳', 218, 's', 'sy', 'songyang', '', '县', '331124', '0578', 5);
INSERT INTO `district` VALUES (1403, '云和', 218, 'y', 'yh', 'yunhe', '', '县', '331125', '0578', 6);
INSERT INTO `district` VALUES (1404, '庆元', 218, 'q', 'qy', 'qingyuan', '', '县', '331126', '0578', 7);
INSERT INTO `district` VALUES (1405, '景宁', 218, 'j', 'jn', 'jingning', '畲族', '自治县', '331127', '0578', 8);
INSERT INTO `district` VALUES (1406, '龙泉', 218, 'l', 'lq', 'longquan', '', '市', '331181', '0578', 9);
INSERT INTO `district` VALUES (1407, '瑶海', 219, 'y', 'yh', 'yaohai', '', '区', '340102', '0551', 1);
INSERT INTO `district` VALUES (1408, '庐阳', 219, 'l', 'ly', 'luyang', '', '区', '340103', '0551', 2);
INSERT INTO `district` VALUES (1409, '蜀山', 219, 's', 'ss', 'shushan', '', '区', '340104', '0551', 3);
INSERT INTO `district` VALUES (1410, '包河', 219, 'b', 'bh', 'baohe', '', '区', '340111', '0551', 4);
INSERT INTO `district` VALUES (1411, '长丰', 219, 'c', 'cf', 'changfeng', '', '县', '340121', '0551', 5);
INSERT INTO `district` VALUES (1412, '肥东', 219, 'f', 'fd', 'feidong', '', '县', '340122', '0551', 6);
INSERT INTO `district` VALUES (1413, '肥西', 219, 'f', 'fx', 'feixi', '', '县', '340123', '0551', 7);
INSERT INTO `district` VALUES (1414, '庐江', 219, 'l', 'lj', 'lujiang', '', '县', '340124', '0551', 8);
INSERT INTO `district` VALUES (1415, '巢湖', 219, 'c', 'ch', 'chaohu', '', '市', '340181', '0551', 9);
INSERT INTO `district` VALUES (1416, '镜湖', 220, 'j', 'jh', 'jinghu', '', '区', '340202', '0553', 1);
INSERT INTO `district` VALUES (1417, '弋江', 220, 'y', 'yj', 'yijiang', '', '区', '340203', '0553', 2);
INSERT INTO `district` VALUES (1418, '鸠江', 220, 'j', 'jj', 'jiujiang', '', '区', '340207', '0553', 3);
INSERT INTO `district` VALUES (1419, '三山', 220, 's', 'ss', 'sanshan', '', '区', '340208', '0553', 4);
INSERT INTO `district` VALUES (1420, '芜湖', 220, 'w', 'wh', 'wuhu', '', '县', '340221', '0553', 5);
INSERT INTO `district` VALUES (1421, '繁昌', 220, 'f', 'fc', 'fanchang', '', '县', '340222', '0553', 6);
INSERT INTO `district` VALUES (1422, '南陵', 220, 'n', 'nl', 'nanling', '', '县', '340223', '0553', 7);
INSERT INTO `district` VALUES (1423, '无为', 220, 'w', 'ww', 'wuwei', '', '市', '340281', '0553', 8);
INSERT INTO `district` VALUES (1424, '龙子湖', 221, 'l', 'lzh', 'longzihu', '', '区', '340302', '0552', 1);
INSERT INTO `district` VALUES (1425, '蚌山', 221, 'b', 'bs', 'bangshan', '', '区', '340303', '0552', 2);
INSERT INTO `district` VALUES (1426, '禹会', 221, 'y', 'yh', 'yuhui', '', '区', '340304', '0552', 3);
INSERT INTO `district` VALUES (1427, '淮上', 221, 'h', 'hs', 'huaishang', '', '区', '340311', '0552', 4);
INSERT INTO `district` VALUES (1428, '怀远', 221, 'h', 'hy', 'huaiyuan', '', '县', '340321', '0552', 5);
INSERT INTO `district` VALUES (1429, '五河', 221, 'w', 'wh', 'wuhe', '', '县', '340322', '0552', 6);
INSERT INTO `district` VALUES (1430, '固镇', 221, 'g', 'gz', 'guzhen', '', '县', '340323', '0552', 7);
INSERT INTO `district` VALUES (1431, '大通', 222, 'd', 'dt', 'datong', '', '区', '340402', '0554', 1);
INSERT INTO `district` VALUES (1432, '田家庵', 222, 't', 'tja', 'tianjiaan', '', '区', '340403', '0554', 2);
INSERT INTO `district` VALUES (1433, '谢家集', 222, 'x', 'xjj', 'xiejiaji', '', '区', '340404', '0554', 3);
INSERT INTO `district` VALUES (1434, '八公山', 222, 'b', 'bgs', 'bagongshan', '', '区', '340405', '0554', 4);
INSERT INTO `district` VALUES (1435, '潘集', 222, 'p', 'pj', 'panji', '', '区', '340406', '0554', 5);
INSERT INTO `district` VALUES (1436, '凤台', 222, 'f', 'ft', 'fengtai', '', '县', '340421', '0554', 6);
INSERT INTO `district` VALUES (1437, '花山', 223, 'h', 'hs', 'huashan', '', '区', '340503', '0555', 1);
INSERT INTO `district` VALUES (1438, '雨山', 223, 'y', 'ys', 'yushan', '', '区', '340504', '0555', 2);
INSERT INTO `district` VALUES (1439, '博望', 223, 'b', 'bw', 'bowang', '', '区', '340506', '0555', 3);
INSERT INTO `district` VALUES (1440, '当涂', 223, 'd', 'dt', 'dangtu', '', '县', '340521', '0555', 4);
INSERT INTO `district` VALUES (1441, '含山', 223, 'h', 'hs', 'hanshan', '', '县', '340522', '0555', 5);
INSERT INTO `district` VALUES (1442, '和县', 223, 'h', 'hx', 'hexian', '', '', '340523', '0555', 6);
INSERT INTO `district` VALUES (1443, '杜集', 224, 'd', 'dj', 'duji', '', '区', '340602', '0561', 1);
INSERT INTO `district` VALUES (1444, '相山', 224, 'x', 'xs', 'xiangshan', '', '区', '340603', '0561', 2);
INSERT INTO `district` VALUES (1445, '烈山', 224, 'l', 'ls', 'lieshan', '', '区', '340604', '0561', 3);
INSERT INTO `district` VALUES (1446, '濉溪', 224, 's', 'sx', 'suixi', '', '县', '340621', '0561', 4);
INSERT INTO `district` VALUES (1447, '铜官山', 225, 't', 'tgs', 'tongguanshan', '', '区', '340702', '0562', 1);
INSERT INTO `district` VALUES (1449, '郊区', 225, 'j', 'jq', 'jiaoqu', '', '', '340711', '0562', 3);
INSERT INTO `district` VALUES (1450, '义安', 225, 'y', 'ya', 'yian', '', '区', '340721', '0562', 4);
INSERT INTO `district` VALUES (1451, '迎江', 226, 'y', 'yj', 'yingjiang', '', '区', '340802', '0556', 1);
INSERT INTO `district` VALUES (1452, '大观', 226, 'd', 'dg', 'daguan', '', '区', '340803', '0556', 2);
INSERT INTO `district` VALUES (1453, '宜秀', 226, 'y', 'yx', 'yixiu', '', '区', '340811', '0556', 3);
INSERT INTO `district` VALUES (1454, '怀宁', 226, 'h', 'hn', 'huaining', '', '县', '340822', '0556', 4);
INSERT INTO `district` VALUES (1455, '枞阳', 225, 'z', 'zy', 'zongyang', '', '县', '340823', '0556', 5);
INSERT INTO `district` VALUES (1456, '潜山', 226, 'q', 'qs', 'qianshan', '', '市', '340824', '0556', 6);
INSERT INTO `district` VALUES (1457, '太湖', 226, 't', 'th', 'taihu', '', '县', '340825', '0556', 7);
INSERT INTO `district` VALUES (1458, '宿松', 226, 's', 'ss', 'susong', '', '县', '340826', '0556', 8);
INSERT INTO `district` VALUES (1459, '望江', 226, 'w', 'wj', 'wangjiang', '', '县', '340827', '0556', 9);
INSERT INTO `district` VALUES (1460, '岳西', 226, 'y', 'yx', 'yuexi', '', '县', '340828', '0556', 10);
INSERT INTO `district` VALUES (1461, '桐城', 226, 't', 'tc', 'tongcheng', '', '市', '340881', '0556', 11);
INSERT INTO `district` VALUES (1462, '屯溪', 227, 't', 'tx', 'tunxi', '', '区', '341002', '0559', 1);
INSERT INTO `district` VALUES (1463, '黄山', 227, 'h', 'hs', 'huangshan', '', '区', '341003', '0559', 2);
INSERT INTO `district` VALUES (1464, '徽州', 227, 'h', 'hz', 'huizhou', '', '区', '341004', '0559', 3);
INSERT INTO `district` VALUES (1465, '歙县', 227, 's', 'sx', 'shexian', '', '', '341021', '0559', 4);
INSERT INTO `district` VALUES (1466, '休宁', 227, 'x', 'xn', 'xiuning', '', '县', '341022', '0559', 5);
INSERT INTO `district` VALUES (1467, '黟县', 227, 'y', 'yx', 'yixian', '', '', '341023', '0559', 6);
INSERT INTO `district` VALUES (1468, '祁门', 227, 'q', 'qm', 'qimen', '', '县', '341024', '0559', 7);
INSERT INTO `district` VALUES (1469, '琅玡', 228, 'l', 'ly', 'langya', '', '区', '341102', '0550', 1);
INSERT INTO `district` VALUES (1470, '南谯', 228, 'n', 'nq', 'nanqiao', '', '区', '341103', '0550', 2);
INSERT INTO `district` VALUES (1471, '来安', 228, 'l', 'la', 'laian', '', '县', '341122', '0550', 3);
INSERT INTO `district` VALUES (1472, '全椒', 228, 'q', 'qj', 'quanjiao', '', '县', '341124', '0550', 4);
INSERT INTO `district` VALUES (1473, '定远', 228, 'd', 'dy', 'dingyuan', '', '县', '341125', '0550', 5);
INSERT INTO `district` VALUES (1474, '凤阳', 228, 'f', 'fy', 'fengyang', '', '县', '341126', '0550', 6);
INSERT INTO `district` VALUES (1475, '天长', 228, 't', 'tc', 'tianchang', '', '市', '341181', '0550', 7);
INSERT INTO `district` VALUES (1476, '明光', 228, 'm', 'mg', 'mingguang', '', '市', '341182', '0550', 8);
INSERT INTO `district` VALUES (1477, '颍州', 229, 'y', 'yz', 'yingzhou', '', '区', '341202', '0558', 1);
INSERT INTO `district` VALUES (1478, '颍东', 229, 'y', 'yd', 'yingdong', '', '区', '341203', '0558', 2);
INSERT INTO `district` VALUES (1479, '颍泉', 229, 'y', 'yq', 'yingquan', '', '区', '341204', '0558', 3);
INSERT INTO `district` VALUES (1480, '临泉', 229, 'l', 'lq', 'linquan', '', '县', '341221', '0558', 4);
INSERT INTO `district` VALUES (1481, '太和', 229, 't', 'th', 'taihe', '', '县', '341222', '0558', 5);
INSERT INTO `district` VALUES (1482, '阜南', 229, 'f', 'fn', 'funan', '', '县', '341225', '0558', 6);
INSERT INTO `district` VALUES (1483, '颖上', 229, 'y', 'ys', 'yingshang', '', '县', '341226', '0558', 7);
INSERT INTO `district` VALUES (1484, '界首', 229, 'j', 'js', 'jieshou', '', '市', '341282', '0558', 8);
INSERT INTO `district` VALUES (1485, '埇桥', 230, 'y', 'yq', 'yongqiao', '', '区', '341302', '0557', 1);
INSERT INTO `district` VALUES (1486, '砀山', 230, 'd', 'ds', 'dangshan', '', '县', '341321', '0557', 2);
INSERT INTO `district` VALUES (1487, '萧县', 230, 'x', 'xx', 'xiaoxian', '', '', '341322', '0557', 3);
INSERT INTO `district` VALUES (1488, '灵璧', 230, 'l', 'lb', 'lingbi', '', '县', '341323', '0557', 4);
INSERT INTO `district` VALUES (1489, '泗县', 230, 's', 'sx', 'sixian', '', '', '341324', '0557', 5);
INSERT INTO `district` VALUES (1490, '金安', 231, 'j', 'ja', 'jinan', '', '区', '341502', '0564', 1);
INSERT INTO `district` VALUES (1491, '裕安', 231, 'y', 'ya', 'yuan', '', '区', '341503', '0564', 2);
INSERT INTO `district` VALUES (1492, '寿县', 222, 's', 'sx', 'shouxian', '', '', '341521', '0564', 3);
INSERT INTO `district` VALUES (1493, '霍邱', 231, 'h', 'hq', 'huoqiu', '', '县', '341522', '0564', 4);
INSERT INTO `district` VALUES (1494, '舒城', 231, 's', 'sc', 'shucheng', '', '县', '341523', '0564', 5);
INSERT INTO `district` VALUES (1495, '金寨', 231, 'j', 'jz', 'jinzhai', '', '县', '341524', '0564', 6);
INSERT INTO `district` VALUES (1496, '霍山', 231, 'h', 'hs', 'huoshan', '', '县', '341525', '0564', 7);
INSERT INTO `district` VALUES (1497, '谯城', 232, 'q', 'qc', 'qiaocheng', '', '区', '341602', '0558', 1);
INSERT INTO `district` VALUES (1498, '涡阳', 232, 'w', 'wy', 'woyang', '', '县', '341621', '0558', 2);
INSERT INTO `district` VALUES (1499, '蒙城', 232, 'm', 'mc', 'mengcheng', '', '县', '341622', '0558', 3);
INSERT INTO `district` VALUES (1500, '利辛', 232, 'l', 'lx', 'lixin', '', '县', '341623', '0558', 4);
INSERT INTO `district` VALUES (1501, '贵池', 233, 'g', 'gc', 'guichi', '', '区', '341702', '0566', 1);
INSERT INTO `district` VALUES (1502, '东至', 233, 'd', 'dz', 'dongzhi', '', '县', '341721', '0566', 2);
INSERT INTO `district` VALUES (1503, '石台', 233, 's', 'st', 'shitai', '', '县', '341722', '0566', 3);
INSERT INTO `district` VALUES (1504, '青阳', 233, 'q', 'qy', 'qingyang', '', '县', '341723', '0566', 4);
INSERT INTO `district` VALUES (1505, '宣州', 234, 'x', 'xz', 'xuanzhou', '', '区', '341802', '0563', 1);
INSERT INTO `district` VALUES (1506, '郎溪', 234, 'l', 'lx', 'langxi', '', '县', '341821', '0563', 2);
INSERT INTO `district` VALUES (1507, '广德', 234, 'g', 'gd', 'guangde', '', '市', '341882', '0563', 7);
INSERT INTO `district` VALUES (1508, '泾县', 234, 'j', 'jx', 'jingxian', '', '', '341823', '0563', 3);
INSERT INTO `district` VALUES (1509, '绩溪', 234, 'j', 'jx', 'jixi', '', '县', '341824', '0563', 4);
INSERT INTO `district` VALUES (1510, '旌德', 234, 'j', 'jd', 'jingde', '', '县', '341825', '0563', 5);
INSERT INTO `district` VALUES (1511, '宁国', 234, 'n', 'ng', 'ningguo', '', '市', '341881', '0563', 6);
INSERT INTO `district` VALUES (1512, '鼓楼', 235, 'g', 'gl', 'gulou', '', '区', '350102', '0591', 1);
INSERT INTO `district` VALUES (1513, '台江', 235, 't', 'tj', 'taijiang', '', '区', '350103', '0591', 2);
INSERT INTO `district` VALUES (1514, '仓山', 235, 'c', 'cs', 'cangshan', '', '区', '350104', '0591', 3);
INSERT INTO `district` VALUES (1515, '马尾', 235, 'm', 'mw', 'mawei', '', '区', '350105', '0591', 4);
INSERT INTO `district` VALUES (1516, '晋安', 235, 'j', 'ja', 'jinan', '', '区', '350111', '0591', 5);
INSERT INTO `district` VALUES (1517, '闽侯', 235, 'm', 'mh', 'minhou', '', '县', '350121', '0591', 7);
INSERT INTO `district` VALUES (1518, '连江', 235, 'l', 'lj', 'lianjiang', '', '县', '350122', '0591', 8);
INSERT INTO `district` VALUES (1519, '罗源', 235, 'l', 'ly', 'luoyuan', '', '县', '350123', '0591', 9);
INSERT INTO `district` VALUES (1520, '闽清', 235, 'm', 'mq', 'minqing', '', '县', '350124', '0591', 10);
INSERT INTO `district` VALUES (1521, '永泰', 235, 'y', 'yt', 'yongtai', '', '县', '350125', '0591', 11);
INSERT INTO `district` VALUES (1522, '平潭', 235, 'p', 'pt', 'pingtan', '', '县', '350128', '0591', 12);
INSERT INTO `district` VALUES (1523, '福清', 235, 'f', 'fq', 'fuqing', '', '市', '350181', '0591', 13);
INSERT INTO `district` VALUES (1524, '长乐', 235, 'c', 'cl', 'changle', '', '区', '350112', '0591', 6);
INSERT INTO `district` VALUES (1525, '思明', 236, 's', 'sm', 'siming', '', '区', '350203', '0592', 1);
INSERT INTO `district` VALUES (1526, '海沧', 236, 'h', 'hc', 'haicang', '', '区', '350205', '0592', 2);
INSERT INTO `district` VALUES (1527, '湖里', 236, 'h', 'hl', 'huli', '', '区', '350206', '0592', 3);
INSERT INTO `district` VALUES (1528, '集美', 236, 'j', 'jm', 'jimei', '', '区', '350211', '0592', 4);
INSERT INTO `district` VALUES (1529, '同安', 236, 't', 'ta', 'tongan', '', '区', '350212', '0592', 5);
INSERT INTO `district` VALUES (1530, '翔安', 236, 'x', 'xa', 'xiangan', '', '区', '350213', '0592', 6);
INSERT INTO `district` VALUES (1531, '城厢', 237, 'c', 'cx', 'chengxiang', '', '区', '350302', '0594', 1);
INSERT INTO `district` VALUES (1532, '涵江', 237, 'h', 'hj', 'hanjiang', '', '区', '350303', '0594', 2);
INSERT INTO `district` VALUES (1533, '荔城', 237, 'l', 'lc', 'licheng', '', '区', '350304', '0594', 3);
INSERT INTO `district` VALUES (1534, '秀屿', 237, 'x', 'xy', 'xiuyu', '', '区', '350305', '0594', 4);
INSERT INTO `district` VALUES (1535, '仙游', 237, 'x', 'xy', 'xianyou', '', '县', '350322', '0594', 5);
INSERT INTO `district` VALUES (1536, '梅列', 238, 'm', 'ml', 'meilie', '', '区', '350402', '0598', 1);
INSERT INTO `district` VALUES (1537, '三元', 238, 's', 'sy', 'sanyuan', '', '区', '350403', '0598', 2);
INSERT INTO `district` VALUES (1538, '明溪', 238, 'm', 'mx', 'mingxi', '', '县', '350421', '0598', 3);
INSERT INTO `district` VALUES (1539, '清流', 238, 'q', 'ql', 'qingliu', '', '县', '350423', '0598', 4);
INSERT INTO `district` VALUES (1540, '宁化', 238, 'n', 'nh', 'ninghua', '', '县', '350424', '0598', 5);
INSERT INTO `district` VALUES (1541, '大田', 238, 'd', 'dt', 'datian', '', '县', '350425', '0598', 6);
INSERT INTO `district` VALUES (1542, '尤溪', 238, 'y', 'yx', 'youxi', '', '县', '350426', '0598', 7);
INSERT INTO `district` VALUES (1543, '沙县', 238, 's', 'sx', 'shaxian', '', '', '350427', '0598', 8);
INSERT INTO `district` VALUES (1544, '将乐', 238, 'j', 'jl', 'jiangle', '', '县', '350428', '0598', 9);
INSERT INTO `district` VALUES (1545, '泰宁', 238, 't', 'tn', 'taining', '', '县', '350429', '0598', 10);
INSERT INTO `district` VALUES (1546, '建宁', 238, 'j', 'jn', 'jianning', '', '县', '350430', '0598', 11);
INSERT INTO `district` VALUES (1547, '永安', 238, 'y', 'ya', 'yongan', '', '市', '350481', '0598', 12);
INSERT INTO `district` VALUES (1548, '鲤城', 239, 'l', 'lc', 'licheng', '', '区', '350502', '0595', 1);
INSERT INTO `district` VALUES (1549, '丰泽', 239, 'f', 'fz', 'fengze', '', '区', '350503', '0595', 2);
INSERT INTO `district` VALUES (1550, '洛江', 239, 'l', 'lj', 'luojiang', '', '区', '350504', '0595', 3);
INSERT INTO `district` VALUES (1551, '泉港', 239, 'q', 'qg', 'quangang', '', '区', '350505', '0595', 4);
INSERT INTO `district` VALUES (1552, '惠安', 239, 'h', 'ha', 'huian', '', '县', '350521', '0595', 5);
INSERT INTO `district` VALUES (1553, '安溪', 239, 'a', 'ax', 'anxi', '', '县', '350524', '0595', 6);
INSERT INTO `district` VALUES (1554, '永春', 239, 'y', 'yc', 'yongchun', '', '县', '350525', '0595', 7);
INSERT INTO `district` VALUES (1555, '德化', 239, 'd', 'dh', 'dehua', '', '县', '350526', '0595', 8);
INSERT INTO `district` VALUES (1556, '金门', 239, 'j', 'jm', 'jinmen', '', '县', '350527', '0595', 9);
INSERT INTO `district` VALUES (1557, '石狮', 239, 's', 'ss', 'shishi', '', '市', '350581', '0595', 10);
INSERT INTO `district` VALUES (1558, '晋江', 239, 'j', 'jj', 'jinjiang', '', '市', '350582', '0595', 11);
INSERT INTO `district` VALUES (1559, '南安', 239, 'n', 'na', 'nanan', '', '市', '350583', '0595', 12);
INSERT INTO `district` VALUES (1560, '芗城', 240, 'x', 'xc', 'xiangcheng', '', '区', '350602', '0596', 1);
INSERT INTO `district` VALUES (1561, '龙文', 240, 'l', 'lw', 'longwen', '', '区', '350603', '0596', 2);
INSERT INTO `district` VALUES (1562, '云霄', 240, 'y', 'yx', 'yunxiao', '', '县', '350622', '0596', 3);
INSERT INTO `district` VALUES (1563, '漳浦', 240, 'z', 'zp', 'zhangpu', '', '县', '350623', '0596', 4);
INSERT INTO `district` VALUES (1564, '诏安', 240, 'z', 'za', 'zhaoan', '', '县', '350624', '0596', 5);
INSERT INTO `district` VALUES (1565, '长泰', 240, 'c', 'ct', 'changtai', '', '县', '350625', '0596', 6);
INSERT INTO `district` VALUES (1566, '东山', 240, 'd', 'ds', 'dongshan', '', '县', '350626', '0596', 7);
INSERT INTO `district` VALUES (1567, '南靖', 240, 'n', 'nj', 'nanjing', '', '县', '350627', '0596', 8);
INSERT INTO `district` VALUES (1568, '平和', 240, 'p', 'ph', 'pinghe', '', '县', '350628', '0596', 9);
INSERT INTO `district` VALUES (1569, '华安', 240, 'h', 'ha', 'huaan', '', '县', '350629', '0596', 10);
INSERT INTO `district` VALUES (1570, '龙海', 240, 'l', 'lh', 'longhai', '', '市', '350681', '0596', 11);
INSERT INTO `district` VALUES (1571, '延平', 241, 'y', 'yp', 'yanping', '', '区', '350702', '0599', 1);
INSERT INTO `district` VALUES (1572, '顺昌', 241, 's', 'sc', 'shunchang', '', '县', '350721', '0599', 3);
INSERT INTO `district` VALUES (1573, '浦城', 241, 'p', 'pc', 'pucheng', '', '县', '350722', '0599', 4);
INSERT INTO `district` VALUES (1574, '光泽', 241, 'g', 'gz', 'guangze', '', '县', '350723', '0599', 5);
INSERT INTO `district` VALUES (1575, '松溪', 241, 's', 'sx', 'songxi', '', '县', '350724', '0599', 6);
INSERT INTO `district` VALUES (1576, '政和', 241, 'z', 'zh', 'zhenghe', '', '县', '350725', '0599', 7);
INSERT INTO `district` VALUES (1577, '邵武', 241, 's', 'sw', 'shaowu', '', '市', '350781', '0599', 8);
INSERT INTO `district` VALUES (1578, '武夷山', 241, 'w', 'wys', 'wuyishan', '', '市', '350782', '0599', 9);
INSERT INTO `district` VALUES (1579, '建瓯', 241, 'j', 'jo', 'jianou', '', '市', '350783', '0599', 10);
INSERT INTO `district` VALUES (1580, '建阳', 241, 'j', 'jy', 'jianyang', '', '区', '350703', '0599', 2);
INSERT INTO `district` VALUES (1581, '新罗', 242, 'x', 'xl', 'xinluo', '', '区', '350802', '0597', 1);
INSERT INTO `district` VALUES (1582, '长汀', 242, 'c', 'ct', 'changting', '', '县', '350821', '0597', 3);
INSERT INTO `district` VALUES (1583, '永定', 242, 'y', 'yd', 'yongding', '', '区', '350803', '0597', 2);
INSERT INTO `district` VALUES (1584, '上杭', 242, 's', 'sh', 'shanghang', '', '县', '350823', '0597', 4);
INSERT INTO `district` VALUES (1585, '武平', 242, 'w', 'wp', 'wuping', '', '县', '350824', '0597', 5);
INSERT INTO `district` VALUES (1586, '连城', 242, 'l', 'lc', 'liancheng', '', '县', '350825', '0597', 6);
INSERT INTO `district` VALUES (1587, '漳平', 242, 'z', 'zp', 'zhangping', '', '市', '350881', '0597', 7);
INSERT INTO `district` VALUES (1588, '蕉城', 243, 'j', 'jc', 'jiaocheng', '', '区', '350902', '0593', 1);
INSERT INTO `district` VALUES (1589, '霞浦', 243, 'x', 'xp', 'xiapu', '', '县', '350921', '0593', 2);
INSERT INTO `district` VALUES (1590, '古田', 243, 'g', 'gt', 'gutian', '', '县', '350922', '0593', 3);
INSERT INTO `district` VALUES (1591, '屏南', 243, 'p', 'pn', 'pingnan', '', '县', '350923', '0593', 4);
INSERT INTO `district` VALUES (1592, '寿宁', 243, 's', 'sn', 'shouning', '', '县', '350924', '0593', 5);
INSERT INTO `district` VALUES (1593, '周宁', 243, 'z', 'zn', 'zhouning', '', '县', '350925', '0593', 6);
INSERT INTO `district` VALUES (1594, '柘荣', 243, 'z', 'zr', 'zherong', '', '县', '350926', '0593', 7);
INSERT INTO `district` VALUES (1595, '福安', 243, 'f', 'fa', 'fuan', '', '市', '350981', '0593', 8);
INSERT INTO `district` VALUES (1596, '福鼎', 243, 'f', 'fd', 'fuding', '', '市', '350982', '0593', 9);
INSERT INTO `district` VALUES (1597, '东湖', 244, 'd', 'dh', 'donghu', '', '区', '360102', '0791', 1);
INSERT INTO `district` VALUES (1598, '西湖', 244, 'x', 'xh', 'xihu', '', '区', '360103', '0791', 2);
INSERT INTO `district` VALUES (1599, '青云谱', 244, 'q', 'qyp', 'qingyunpu', '', '区', '360104', '0791', 3);
INSERT INTO `district` VALUES (1600, '红谷滩', 244, 'h', 'hgt', 'honggutan', '', '区', '360113', '0791', 6);
INSERT INTO `district` VALUES (1601, '青山湖', 244, 'q', 'qsh', 'qingshanhu', '', '区', '360111', '0791', 4);
INSERT INTO `district` VALUES (1602, '南昌', 244, 'n', 'nc', 'nanchang', '', '县', '360121', '0791', 7);
INSERT INTO `district` VALUES (1603, '新建', 244, 'x', 'xj', 'xinjian', '', '区', '360112', '0791', 5);
INSERT INTO `district` VALUES (1604, '安义', 244, 'a', 'ay', 'anyi', '', '县', '360123', '0791', 8);
INSERT INTO `district` VALUES (1605, '进贤', 244, 'j', 'jx', 'jinxian', '', '县', '360124', '0791', 9);
INSERT INTO `district` VALUES (1606, '昌江', 245, 'c', 'cj', 'changjiang', '', '区', '360202', '0798', 1);
INSERT INTO `district` VALUES (1607, '珠山', 245, 'z', 'zs', 'zhushan', '', '区', '360203', '0798', 2);
INSERT INTO `district` VALUES (1608, '浮梁', 245, 'f', 'fl', 'fuliang', '', '县', '360222', '0798', 3);
INSERT INTO `district` VALUES (1609, '乐平', 245, 'l', 'lp', 'leping', '', '市', '360281', '0798', 4);
INSERT INTO `district` VALUES (1610, '安源', 246, 'a', 'ay', 'anyuan', '', '区', '360302', '0799', 1);
INSERT INTO `district` VALUES (1611, '湘东', 246, 'x', 'xd', 'xiangdong', '', '区', '360313', '0799', 2);
INSERT INTO `district` VALUES (1612, '莲花', 246, 'l', 'lh', 'lianhua', '', '县', '360321', '0799', 3);
INSERT INTO `district` VALUES (1613, '上栗', 246, 's', 'sl', 'shangli', '', '县', '360322', '0799', 4);
INSERT INTO `district` VALUES (1614, '芦溪', 246, 'l', 'lx', 'luxi', '', '县', '360323', '0799', 5);
INSERT INTO `district` VALUES (1615, '濂溪', 247, 'l', 'lx', 'lianxi', '', '区', '360402', '0792', 1);
INSERT INTO `district` VALUES (1616, '浔阳', 247, 'x', 'xy', 'xunyang', '', '区', '360403', '0792', 2);
INSERT INTO `district` VALUES (1617, '柴桑', 247, 'c', 'cs', 'chaisang', '', '区', '360404', '0792', 3);
INSERT INTO `district` VALUES (1618, '武宁', 247, 'w', 'wn', 'wuning', '', '县', '360423', '0792', 4);
INSERT INTO `district` VALUES (1619, '修水', 247, 'x', 'xs', 'xiushui', '', '县', '360424', '0792', 5);
INSERT INTO `district` VALUES (1620, '永修', 247, 'y', 'yx', 'yongxiu', '', '县', '360425', '0792', 6);
INSERT INTO `district` VALUES (1621, '德安', 247, 'd', 'da', 'dean', '', '县', '360426', '0792', 7);
INSERT INTO `district` VALUES (1622, '庐山', 247, 'l', 'ls', 'lushan', '', '市', '360483', '0792', 13);
INSERT INTO `district` VALUES (1623, '都昌', 247, 'd', 'dc', 'duchang', '', '县', '360428', '0792', 8);
INSERT INTO `district` VALUES (1624, '湖口', 247, 'h', 'hk', 'hukou', '', '县', '360429', '0792', 9);
INSERT INTO `district` VALUES (1625, '彭泽', 247, 'p', 'pz', 'pengze', '', '县', '360430', '0792', 10);
INSERT INTO `district` VALUES (1626, '瑞昌', 247, 'r', 'rc', 'ruichang', '', '市', '360481', '0792', 11);
INSERT INTO `district` VALUES (1627, '共青城', 247, 'g', 'gqc', 'gongqingcheng', '', '市', '360482', '0792', 12);
INSERT INTO `district` VALUES (1628, '渝水', 248, 'y', 'ys', 'yushui', '', '区', '360502', '0790', 1);
INSERT INTO `district` VALUES (1629, '分宜', 248, 'f', 'fy', 'fenyi', '', '县', '360521', '0790', 2);
INSERT INTO `district` VALUES (1630, '月湖', 249, 'y', 'yh', 'yuehu', '', '区', '360602', '0701', 1);
INSERT INTO `district` VALUES (1631, '余江', 249, 'y', 'yj', 'yujiang', '', '区', '360603', '0701', 2);
INSERT INTO `district` VALUES (1632, '贵溪', 249, 'g', 'gx', 'guixi', '', '市', '360681', '0701', 3);
INSERT INTO `district` VALUES (1633, '章贡', 250, 'z', 'zg', 'zhanggong', '', '区', '360702', '0797', 1);
INSERT INTO `district` VALUES (1634, '赣县', 250, 'g', 'gx', 'ganxian', '', '区', '360704', '0797', 2);
INSERT INTO `district` VALUES (1635, '信丰', 250, 'x', 'xf', 'xinfeng', '', '县', '360722', '0797', 3);
INSERT INTO `district` VALUES (1636, '大余', 250, 'd', 'dy', 'dayu', '', '县', '360723', '0797', 4);
INSERT INTO `district` VALUES (1637, '上犹', 250, 's', 'sy', 'shangyou', '', '县', '360724', '0797', 5);
INSERT INTO `district` VALUES (1638, '崇义', 250, 'c', 'cy', 'chongyi', '', '县', '360725', '0797', 6);
INSERT INTO `district` VALUES (1639, '安远', 250, 'a', 'ay', 'anyuan', '', '县', '360726', '0797', 7);
INSERT INTO `district` VALUES (1640, '龙南', 250, 'l', 'ln', 'longnan', '', '县', '360727', '0797', 8);
INSERT INTO `district` VALUES (1641, '定南', 250, 'd', 'dn', 'dingnan', '', '县', '360728', '0797', 9);
INSERT INTO `district` VALUES (1642, '全南', 250, 'q', 'qn', 'quannan', '', '县', '360729', '0797', 10);
INSERT INTO `district` VALUES (1643, '宁都', 250, 'n', 'nd', 'ningdu', '', '县', '360730', '0797', 11);
INSERT INTO `district` VALUES (1644, '于都', 250, 'y', 'yd', 'yudu', '', '县', '360731', '0797', 12);
INSERT INTO `district` VALUES (1645, '兴国', 250, 'x', 'xg', 'xingguo', '', '县', '360732', '0797', 13);
INSERT INTO `district` VALUES (1646, '会昌', 250, 'h', 'hc', 'huichang', '', '县', '360733', '0797', 14);
INSERT INTO `district` VALUES (1647, '寻乌', 250, 'x', 'xw', 'xunwu', '', '县', '360734', '0797', 15);
INSERT INTO `district` VALUES (1648, '石城', 250, 's', 'sc', 'shicheng', '', '县', '360735', '0797', 16);
INSERT INTO `district` VALUES (1649, '瑞金', 250, 'r', 'rj', 'ruijin', '', '市', '360781', '0797', 17);
INSERT INTO `district` VALUES (1650, '南康', 250, 'n', 'nk', 'nankang', '', '区', '360782', '0797', 18);
INSERT INTO `district` VALUES (1651, '吉州', 251, 'j', 'jz', 'jizhou', '', '区', '360802', '0796', 1);
INSERT INTO `district` VALUES (1652, '青原', 251, 'q', 'qy', 'qingyuan', '', '区', '360803', '0796', 2);
INSERT INTO `district` VALUES (1653, '吉安', 251, 'j', 'ja', 'jian', '', '县', '360821', '0796', 3);
INSERT INTO `district` VALUES (1654, '吉水', 251, 'j', 'js', 'jishui', '', '县', '360822', '0796', 4);
INSERT INTO `district` VALUES (1655, '峡江', 251, 'x', 'xj', 'xiajiang', '', '县', '360823', '0796', 5);
INSERT INTO `district` VALUES (1656, '新干', 251, 'x', 'xg', 'xingan', '', '县', '360824', '0796', 6);
INSERT INTO `district` VALUES (1657, '永丰', 251, 'y', 'yf', 'yongfeng', '', '县', '360825', '0796', 7);
INSERT INTO `district` VALUES (1658, '泰和', 251, 't', 'th', 'taihe', '', '县', '360826', '0796', 8);
INSERT INTO `district` VALUES (1659, '遂川', 251, 's', 'sc', 'suichuan', '', '县', '360827', '0796', 9);
INSERT INTO `district` VALUES (1660, '万安', 251, 'w', 'wa', 'wanan', '', '县', '360828', '0796', 10);
INSERT INTO `district` VALUES (1661, '安福', 251, 'a', 'af', 'anfu', '', '县', '360829', '0796', 11);
INSERT INTO `district` VALUES (1662, '永新', 251, 'y', 'yx', 'yongxin', '', '县', '360830', '0796', 12);
INSERT INTO `district` VALUES (1663, '井冈山', 251, 'j', 'jgs', 'jinggangshan', '', '市', '360881', '0796', 13);
INSERT INTO `district` VALUES (1664, '袁州', 252, 'y', 'yz', 'yuanzhou', '', '区', '360902', '0795', 1);
INSERT INTO `district` VALUES (1665, '奉新', 252, 'f', 'fx', 'fengxin', '', '县', '360921', '0795', 2);
INSERT INTO `district` VALUES (1666, '万载', 252, 'w', 'wz', 'wanzai', '', '县', '360922', '0795', 3);
INSERT INTO `district` VALUES (1667, '上高', 252, 's', 'sg', 'shanggao', '', '县', '360923', '0795', 4);
INSERT INTO `district` VALUES (1668, '宜丰', 252, 'y', 'yf', 'yifeng', '', '县', '360924', '0795', 5);
INSERT INTO `district` VALUES (1669, '靖安', 252, 'j', 'ja', 'jingan', '', '县', '360925', '0795', 6);
INSERT INTO `district` VALUES (1670, '铜鼓', 252, 't', 'tg', 'tonggu', '', '县', '360926', '0795', 7);
INSERT INTO `district` VALUES (1671, '丰城', 252, 'f', 'fc', 'fengcheng', '', '市', '360981', '0795', 8);
INSERT INTO `district` VALUES (1672, '樟树', 252, 'z', 'zs', 'zhangshu', '', '市', '360982', '0795', 9);
INSERT INTO `district` VALUES (1673, '高安', 252, 'g', 'ga', 'gaoan', '', '市', '360983', '0795', 10);
INSERT INTO `district` VALUES (1674, '临川', 253, 'l', 'lc', 'linchuan', '', '区', '361002', '0794', 1);
INSERT INTO `district` VALUES (1675, '南城', 253, 'n', 'nc', 'nancheng', '', '县', '361021', '0794', 3);
INSERT INTO `district` VALUES (1676, '黎川', 253, 'l', 'lc', 'lichuan', '', '县', '361022', '0794', 4);
INSERT INTO `district` VALUES (1677, '南丰', 253, 'n', 'nf', 'nanfeng', '', '县', '361023', '0794', 5);
INSERT INTO `district` VALUES (1678, '崇仁', 253, 'c', 'cr', 'chongren', '', '县', '361024', '0794', 6);
INSERT INTO `district` VALUES (1679, '乐安', 253, 'l', 'la', 'lean', '', '县', '361025', '0794', 7);
INSERT INTO `district` VALUES (1680, '宜黄', 253, 'y', 'yh', 'yihuang', '', '县', '361026', '0794', 8);
INSERT INTO `district` VALUES (1681, '金溪', 253, 'j', 'jx', 'jinxi', '', '县', '361027', '0794', 9);
INSERT INTO `district` VALUES (1682, '资溪', 253, 'z', 'zx', 'zixi', '', '县', '361028', '0794', 10);
INSERT INTO `district` VALUES (1683, '东乡', 253, 'd', 'dx', 'dongxiang', '', '区', '361003', '0794', 2);
INSERT INTO `district` VALUES (1684, '广昌', 253, 'g', 'gc', 'guangchang', '', '县', '361030', '0794', 11);
INSERT INTO `district` VALUES (1685, '信州', 254, 'x', 'xz', 'xinzhou', '', '区', '361102', '0793', 1);
INSERT INTO `district` VALUES (1686, '广信', 254, 'g', 'gx', 'guangxin', '', '区', '361104', '0793', 3);
INSERT INTO `district` VALUES (1687, '广丰', 254, 'g', 'gf', 'guangfeng', '', '区', '361103', '0793', 2);
INSERT INTO `district` VALUES (1688, '玉山', 254, 'y', 'ys', 'yushan', '', '县', '361123', '0793', 4);
INSERT INTO `district` VALUES (1689, '铅山', 254, 'q', 'qs', 'qianshan', '', '县', '361124', '0793', 5);
INSERT INTO `district` VALUES (1690, '横峰', 254, 'h', 'hf', 'hengfeng', '', '县', '361125', '0793', 6);
INSERT INTO `district` VALUES (1691, '弋阳', 254, 'y', 'yy', 'yiyang', '', '县', '361126', '0793', 7);
INSERT INTO `district` VALUES (1692, '余干', 254, 'y', 'yg', 'yugan', '', '县', '361127', '0793', 8);
INSERT INTO `district` VALUES (1693, '鄱阳', 254, 'p', 'py', 'poyang', '', '县', '361128', '0793', 9);
INSERT INTO `district` VALUES (1694, '万年', 254, 'w', 'wn', 'wannian', '', '县', '361129', '0793', 10);
INSERT INTO `district` VALUES (1695, '婺源', 254, 'w', 'wy', 'wuyuan', '', '县', '361130', '0793', 11);
INSERT INTO `district` VALUES (1696, '德兴', 254, 'd', 'dx', 'dexing', '', '市', '361181', '0793', 12);
INSERT INTO `district` VALUES (1697, '历下', 255, 'l', 'lx', 'lixia', '', '区', '370102', '0531', 1);
INSERT INTO `district` VALUES (1698, '市中', 255, 's', 'sz', 'shizhong', '', '区', '370103', '0531', 2);
INSERT INTO `district` VALUES (1699, '槐荫', 255, 'h', 'hy', 'huaiyin', '', '区', '370104', '0531', 3);
INSERT INTO `district` VALUES (1700, '天桥', 255, 't', 'tq', 'tianqiao', '', '区', '370105', '0531', 4);
INSERT INTO `district` VALUES (1701, '历城', 255, 'l', 'lc', 'licheng', '', '区', '370112', '0531', 5);
INSERT INTO `district` VALUES (1702, '长清', 255, 'c', 'cq', 'changqing', '', '区', '370113', '0531', 6);
INSERT INTO `district` VALUES (1703, '平阴', 255, 'p', 'py', 'pingyin', '', '县', '370124', '0531', 11);
INSERT INTO `district` VALUES (1704, '济阳', 255, 'j', 'jy', 'jiyang', '', '区', '370115', '0531', 8);
INSERT INTO `district` VALUES (1705, '商河', 255, 's', 'sh', 'shanghe', '', '县', '370126', '0531', 12);
INSERT INTO `district` VALUES (1706, '章丘', 255, 'z', 'zq', 'zhangqiu', '', '区', '370114', '0531', 7);
INSERT INTO `district` VALUES (1707, '市南', 256, 's', 'sn', 'shinan', '', '区', '370202', '0532', 1);
INSERT INTO `district` VALUES (1708, '市北', 256, 's', 'sb', 'shibei', '', '区', '370203', '0532', 2);
INSERT INTO `district` VALUES (1709, '黄岛', 256, 'h', 'hd', 'huangdao', '', '区', '370211', '0532', 3);
INSERT INTO `district` VALUES (1710, '崂山', 256, 'l', 'ls', 'laoshan', '', '区', '370212', '0532', 4);
INSERT INTO `district` VALUES (1711, '李沧', 256, 'l', 'lc', 'licang', '', '区', '370213', '0532', 5);
INSERT INTO `district` VALUES (1712, '城阳', 256, 'c', 'cy', 'chengyang', '', '区', '370214', '0532', 6);
INSERT INTO `district` VALUES (1713, '胶州', 256, 'j', 'jz', 'jiaozhou', '', '市', '370281', '0532', 8);
INSERT INTO `district` VALUES (1714, '即墨', 256, 'j', 'jm', 'jimo', '', '区', '370215', '0532', 7);
INSERT INTO `district` VALUES (1715, '平度', 256, 'p', 'pd', 'pingdu', '', '市', '370283', '0532', 9);
INSERT INTO `district` VALUES (1716, '莱西', 256, 'l', 'lx', 'laixi', '', '市', '370285', '0532', 10);
INSERT INTO `district` VALUES (1717, '淄川', 257, 'z', 'zc', 'zichuan', '', '区', '370302', '0533', 1);
INSERT INTO `district` VALUES (1718, '张店', 257, 'z', 'zd', 'zhangdian', '', '区', '370303', '0533', 2);
INSERT INTO `district` VALUES (1719, '博山', 257, 'b', 'bs', 'boshan', '', '区', '370304', '0533', 3);
INSERT INTO `district` VALUES (1720, '临淄', 257, 'l', 'lz', 'linzi', '', '区', '370305', '0533', 4);
INSERT INTO `district` VALUES (1721, '周村', 257, 'z', 'zc', 'zhoucun', '', '区', '370306', '0533', 5);
INSERT INTO `district` VALUES (1722, '桓台', 257, 'h', 'ht', 'huantai', '', '县', '370321', '0533', 6);
INSERT INTO `district` VALUES (1723, '高青', 257, 'g', 'gq', 'gaoqing', '', '县', '370322', '0533', 7);
INSERT INTO `district` VALUES (1724, '沂源', 257, 'y', 'yy', 'yiyuan', '', '县', '370323', '0533', 8);
INSERT INTO `district` VALUES (1725, '市中', 258, 's', 'sz', 'shizhong', '', '区', '370402', '0632', 1);
INSERT INTO `district` VALUES (1726, '薛城', 258, 'x', 'xc', 'xuecheng', '', '区', '370403', '0632', 2);
INSERT INTO `district` VALUES (1727, '峄城', 258, 'y', 'yc', 'yicheng', '', '区', '370404', '0632', 3);
INSERT INTO `district` VALUES (1728, '台儿庄', 258, 't', 'tez', 'taierzhuang', '', '区', '370405', '0632', 4);
INSERT INTO `district` VALUES (1729, '山亭', 258, 's', 'st', 'shanting', '', '区', '370406', '0632', 5);
INSERT INTO `district` VALUES (1730, '滕州', 258, 't', 'tz', 'tengzhou', '', '市', '370481', '0632', 6);
INSERT INTO `district` VALUES (1731, '东营', 259, 'd', 'dy', 'dongying', '', '区', '370502', '0546', 1);
INSERT INTO `district` VALUES (1732, '河口', 259, 'h', 'hk', 'hekou', '', '区', '370503', '0546', 2);
INSERT INTO `district` VALUES (1733, '垦利', 259, 'k', 'kl', 'kenli', '', '区', '370505', '0546', 3);
INSERT INTO `district` VALUES (1734, '利津', 259, 'l', 'lj', 'lijin', '', '县', '370522', '0546', 4);
INSERT INTO `district` VALUES (1735, '广饶', 259, 'g', 'gr', 'guangrao', '', '县', '370523', '0546', 5);
INSERT INTO `district` VALUES (1736, '芝罘', 260, 'z', 'zf', 'zhifu', '', '区', '370602', '0535', 1);
INSERT INTO `district` VALUES (1737, '福山', 260, 'f', 'fs', 'fushan', '', '区', '370611', '0535', 2);
INSERT INTO `district` VALUES (1738, '牟平', 260, 'm', 'mp', 'mouping', '', '区', '370612', '0535', 3);
INSERT INTO `district` VALUES (1739, '莱山', 260, 'l', 'ls', 'laishan', '', '区', '370613', '0535', 4);
INSERT INTO `district` VALUES (1740, '长岛', 260, 'c', 'cd', 'changdao', '', '县', '370634', '0535', 5);
INSERT INTO `district` VALUES (1741, '龙口', 260, 'l', 'lk', 'longkou', '', '市', '370681', '0535', 6);
INSERT INTO `district` VALUES (1742, '莱阳', 260, 'l', 'ly', 'laiyang', '', '市', '370682', '0535', 7);
INSERT INTO `district` VALUES (1743, '莱州', 260, 'l', 'lz', 'laizhou', '', '市', '370683', '0535', 8);
INSERT INTO `district` VALUES (1744, '蓬莱', 260, 'p', 'pl', 'penglai', '', '市', '370684', '0535', 9);
INSERT INTO `district` VALUES (1745, '招远', 260, 'z', 'zy', 'zhaoyuan', '', '市', '370685', '0535', 10);
INSERT INTO `district` VALUES (1746, '栖霞', 260, 'q', 'qx', 'qixia', '', '市', '370686', '0535', 11);
INSERT INTO `district` VALUES (1747, '海阳', 260, 'h', 'hy', 'haiyang', '', '市', '370687', '0535', 12);
INSERT INTO `district` VALUES (1748, '潍城', 261, 'w', 'wc', 'weicheng', '', '区', '370702', '0536', 1);
INSERT INTO `district` VALUES (1749, '寒亭', 261, 'h', 'ht', 'hanting', '', '区', '370703', '0536', 2);
INSERT INTO `district` VALUES (1750, '坊子', 261, 'f', 'fz', 'fangzi', '', '区', '370704', '0536', 3);
INSERT INTO `district` VALUES (1751, '奎文', 261, 'k', 'kw', 'kuiwen', '', '区', '370705', '0536', 4);
INSERT INTO `district` VALUES (1752, '临朐', 261, 'l', 'lq', 'linqu', '', '县', '370724', '0536', 5);
INSERT INTO `district` VALUES (1753, '昌乐', 261, 'c', 'cl', 'changle', '', '县', '370725', '0536', 6);
INSERT INTO `district` VALUES (1754, '青州', 261, 'q', 'qz', 'qingzhou', '', '市', '370781', '0536', 7);
INSERT INTO `district` VALUES (1755, '诸城', 261, 'z', 'zc', 'zhucheng', '', '市', '370782', '0536', 8);
INSERT INTO `district` VALUES (1756, '寿光', 261, 's', 'sg', 'shouguang', '', '市', '370783', '0536', 9);
INSERT INTO `district` VALUES (1757, '安丘', 261, 'a', 'aq', 'anqiu', '', '市', '370784', '0536', 10);
INSERT INTO `district` VALUES (1758, '高密', 261, 'g', 'gm', 'gaomi', '', '市', '370785', '0536', 11);
INSERT INTO `district` VALUES (1759, '昌邑', 261, 'c', 'cy', 'changyi', '', '市', '370786', '0536', 12);
INSERT INTO `district` VALUES (1761, '任城', 262, 'r', 'rc', 'rencheng', '', '区', '370811', '0537', 1);
INSERT INTO `district` VALUES (1762, '微山', 262, 'w', 'ws', 'weishan', '', '县', '370826', '0537', 3);
INSERT INTO `district` VALUES (1763, '鱼台', 262, 'y', 'yt', 'yutai', '', '县', '370827', '0537', 4);
INSERT INTO `district` VALUES (1764, '金乡', 262, 'j', 'jx', 'jinxiang', '', '县', '370828', '0537', 5);
INSERT INTO `district` VALUES (1765, '嘉祥', 262, 'j', 'jx', 'jiaxiang', '', '县', '370829', '0537', 6);
INSERT INTO `district` VALUES (1766, '汶上', 262, 'w', 'ws', 'wenshang', '', '县', '370830', '0537', 7);
INSERT INTO `district` VALUES (1767, '泗水', 262, 's', 'ss', 'sishui', '', '县', '370831', '0537', 8);
INSERT INTO `district` VALUES (1768, '梁山', 262, 'l', 'ls', 'liangshan', '', '县', '370832', '0537', 9);
INSERT INTO `district` VALUES (1769, '曲阜', 262, 'q', 'qf', 'qufu', '', '市', '370881', '0537', 10);
INSERT INTO `district` VALUES (1770, '兖州', 262, 'y', 'yz', 'yanzhou', '', '区', '370812', '0537', 2);
INSERT INTO `district` VALUES (1771, '邹城', 262, 'z', 'zc', 'zoucheng', '', '市', '370883', '0537', 11);
INSERT INTO `district` VALUES (1772, '泰山', 263, 't', 'ts', 'taishan', '', '区', '370902', '0538', 1);
INSERT INTO `district` VALUES (1773, '岱岳', 263, 'd', 'dy', 'daiyue', '', '区', '370911', '0538', 2);
INSERT INTO `district` VALUES (1774, '宁阳', 263, 'n', 'ny', 'ningyang', '', '县', '370921', '0538', 3);
INSERT INTO `district` VALUES (1775, '东平', 263, 'd', 'dp', 'dongping', '', '县', '370923', '0538', 4);
INSERT INTO `district` VALUES (1776, '新泰', 263, 'x', 'xt', 'xintai', '', '市', '370982', '0538', 5);
INSERT INTO `district` VALUES (1777, '肥城', 263, 'f', 'fc', 'feicheng', '', '市', '370983', '0538', 6);
INSERT INTO `district` VALUES (1778, '环翠', 264, 'h', 'hc', 'huancui', '', '区', '371002', '0631', 1);
INSERT INTO `district` VALUES (1779, '文登', 264, 'w', 'wd', 'wendeng', '', '区', '371003', '0631', 2);
INSERT INTO `district` VALUES (1780, '荣成', 264, 'r', 'rc', 'rongcheng', '', '市', '371082', '0631', 3);
INSERT INTO `district` VALUES (1781, '乳山', 264, 'r', 'rs', 'rushan', '', '市', '371083', '0631', 4);
INSERT INTO `district` VALUES (1782, '东港', 265, 'd', 'dg', 'donggang', '', '区', '371102', '0633', 1);
INSERT INTO `district` VALUES (1783, '岚山', 265, 'l', 'ls', 'lanshan', '', '区', '371103', '0633', 2);
INSERT INTO `district` VALUES (1784, '五莲', 265, 'w', 'wl', 'wulian', '', '县', '371121', '0633', 3);
INSERT INTO `district` VALUES (1785, '莒县', 265, 'j', 'jx', 'juxian', '', '', '371122', '0633', 4);
INSERT INTO `district` VALUES (1786, '莱芜', 255, 'l', 'lw', 'laiwu', '', '区', '370116', '0634', 9);
INSERT INTO `district` VALUES (1787, '钢城', 255, 'g', 'gc', 'gangcheng', '', '区', '370117', '0634', 10);
INSERT INTO `district` VALUES (1788, '兰山', 267, 'l', 'ls', 'lanshan', '', '区', '371302', '0539', 1);
INSERT INTO `district` VALUES (1789, '罗庄', 267, 'l', 'lz', 'luozhuang', '', '区', '371311', '0539', 2);
INSERT INTO `district` VALUES (1790, '河东', 267, 'h', 'hd', 'hedong', '', '区', '371312', '0539', 3);
INSERT INTO `district` VALUES (1791, '沂南', 267, 'y', 'yn', 'yinan', '', '县', '371321', '0539', 4);
INSERT INTO `district` VALUES (1792, '郯城', 267, 't', 'tc', 'tancheng', '', '县', '371322', '0539', 5);
INSERT INTO `district` VALUES (1793, '沂水', 267, 'y', 'ys', 'yishui', '', '县', '371323', '0539', 6);
INSERT INTO `district` VALUES (1794, '兰陵', 267, 'l', 'll', 'lanling', '', '县', '371324', '0539', 7);
INSERT INTO `district` VALUES (1795, '费县', 267, 'f', 'fx', 'feixian', '', '', '371325', '0539', 8);
INSERT INTO `district` VALUES (1796, '平邑', 267, 'p', 'py', 'pingyi', '', '县', '371326', '0539', 9);
INSERT INTO `district` VALUES (1797, '莒南', 267, 'j', 'jn', 'junan', '', '县', '371327', '0539', 10);
INSERT INTO `district` VALUES (1798, '蒙阴', 267, 'm', 'my', 'mengyin', '', '县', '371328', '0539', 11);
INSERT INTO `district` VALUES (1799, '临沭', 267, 'l', 'ls', 'linshu', '', '县', '371329', '0539', 12);
INSERT INTO `district` VALUES (1800, '德城', 268, 'd', 'dc', 'decheng', '', '区', '371402', '0534', 1);
INSERT INTO `district` VALUES (1801, '陵城', 268, 'l', 'lc', 'lingcheng', '', '区', '371403', '0534', 2);
INSERT INTO `district` VALUES (1802, '宁津', 268, 'n', 'nj', 'ningjin', '', '县', '371422', '0534', 3);
INSERT INTO `district` VALUES (1803, '庆云', 268, 'q', 'qy', 'qingyun', '', '县', '371423', '0534', 4);
INSERT INTO `district` VALUES (1804, '临邑', 268, 'l', 'ly', 'linyi', '', '县', '371424', '0534', 5);
INSERT INTO `district` VALUES (1805, '齐河', 268, 'q', 'qh', 'qihe', '', '县', '371425', '0534', 6);
INSERT INTO `district` VALUES (1806, '平原', 268, 'p', 'py', 'pingyuan', '', '县', '371426', '0534', 7);
INSERT INTO `district` VALUES (1807, '夏津', 268, 'x', 'xj', 'xiajin', '', '县', '371427', '0534', 8);
INSERT INTO `district` VALUES (1808, '武城', 268, 'w', 'wc', 'wucheng', '', '县', '371428', '0534', 9);
INSERT INTO `district` VALUES (1809, '乐陵', 268, 'l', 'll', 'leling', '', '市', '371481', '0534', 10);
INSERT INTO `district` VALUES (1810, '禹城', 268, 'y', 'yc', 'yucheng', '', '市', '371482', '0534', 11);
INSERT INTO `district` VALUES (1811, '东昌府', 269, 'd', 'dcf', 'dongchangfu', '', '区', '371502', '0635', 1);
INSERT INTO `district` VALUES (1812, '阳谷', 269, 'y', 'yg', 'yanggu', '', '县', '371521', '0635', 3);
INSERT INTO `district` VALUES (1813, '莘县', 269, 'x', 'xx', 'xinxian', '', '', '371522', '0635', 4);
INSERT INTO `district` VALUES (1814, '茌平', 269, 'c', 'cp', 'chiping', '', '区', '371503', '0635', 2);
INSERT INTO `district` VALUES (1815, '东阿', 269, 'd', 'da', 'donga', '', '县', '371524', '0635', 5);
INSERT INTO `district` VALUES (1816, '冠县', 269, 'g', 'gx', 'guanxian', '', '', '371525', '0635', 6);
INSERT INTO `district` VALUES (1817, '高唐', 269, 'g', 'gt', 'gaotang', '', '县', '371526', '0635', 7);
INSERT INTO `district` VALUES (1818, '临清', 269, 'l', 'lq', 'linqing', '', '市', '371581', '0635', 8);
INSERT INTO `district` VALUES (1819, '滨城', 270, 'b', 'bc', 'bincheng', '', '区', '371602', '0543', 1);
INSERT INTO `district` VALUES (1820, '惠民', 270, 'h', 'hm', 'huimin', '', '县', '371621', '0543', 2);
INSERT INTO `district` VALUES (1821, '阳信', 270, 'y', 'yx', 'yangxin', '', '县', '371622', '0543', 3);
INSERT INTO `district` VALUES (1822, '无棣', 270, 'w', 'wd', 'wudi', '', '县', '371623', '0543', 4);
INSERT INTO `district` VALUES (1823, '沾化', 270, 'z', 'zh', 'zhanhua', '', '区', '371624', '0543', 5);
INSERT INTO `district` VALUES (1824, '博兴', 270, 'b', 'bx', 'boxing', '', '县', '371625', '0543', 6);
INSERT INTO `district` VALUES (1825, '邹平', 270, 'z', 'zp', 'zouping', '', '市', '371626', '0543', 7);
INSERT INTO `district` VALUES (1826, '牡丹', 271, 'm', 'md', 'mudan', '', '区', '371702', '0530', 1);
INSERT INTO `district` VALUES (1827, '曹县', 271, 'c', 'cx', 'caoxian', '', '', '371721', '0530', 3);
INSERT INTO `district` VALUES (1828, '单县', 271, 'd', 'dx', 'danxian', '', '', '371722', '0530', 4);
INSERT INTO `district` VALUES (1829, '成武', 271, 'c', 'cw', 'chengwu', '', '县', '371723', '0530', 5);
INSERT INTO `district` VALUES (1830, '巨野', 271, 'j', 'jy', 'juye', '', '县', '371724', '0530', 6);
INSERT INTO `district` VALUES (1831, '郓城', 271, 'y', 'yc', 'yuncheng', '', '县', '371725', '0530', 7);
INSERT INTO `district` VALUES (1832, '鄄城', 271, 'j', 'jc', 'juancheng', '', '县', '371726', '0530', 8);
INSERT INTO `district` VALUES (1833, '定陶', 271, 'd', 'dt', 'dingtao', '', '区', '371703', '0530', 2);
INSERT INTO `district` VALUES (1834, '东明', 271, 'd', 'dm', 'dongming', '', '县', '371728', '0530', 9);
INSERT INTO `district` VALUES (1835, '中原', 272, 'z', 'zy', 'zhongyuan', '', '区', '410102', '0371', 1);
INSERT INTO `district` VALUES (1836, '二七', 272, 'e', 'eq', 'erqi', '', '区', '410103', '0371', 2);
INSERT INTO `district` VALUES (1837, '管城', 272, 'g', 'gc', 'guancheng', '回族', '区', '410104', '0371', 3);
INSERT INTO `district` VALUES (1838, '金水', 272, 'j', 'js', 'jinshui', '', '区', '410105', '0371', 4);
INSERT INTO `district` VALUES (1839, '上街', 272, 's', 'sj', 'shangjie', '', '区', '410106', '0371', 5);
INSERT INTO `district` VALUES (1840, '惠济', 272, 'h', 'hj', 'huiji', '', '区', '410108', '0371', 6);
INSERT INTO `district` VALUES (1841, '中牟', 272, 'z', 'zm', 'zhongmou', '', '县', '410122', '0371', 7);
INSERT INTO `district` VALUES (1842, '巩义', 272, 'g', 'gy', 'gongyi', '', '市', '410181', '0371', 8);
INSERT INTO `district` VALUES (1843, '荥阳', 272, 'y', 'yy', 'yingyang', '', '市', '410182', '0371', 9);
INSERT INTO `district` VALUES (1844, '新密', 272, 'x', 'xm', 'xinmi', '', '市', '410183', '0371', 10);
INSERT INTO `district` VALUES (1845, '新郑', 272, 'x', 'xz', 'xinzheng', '', '市', '410184', '0371', 11);
INSERT INTO `district` VALUES (1846, '登封', 272, 'd', 'df', 'dengfeng', '', '市', '410185', '0371', 12);
INSERT INTO `district` VALUES (1847, '龙亭', 273, 'l', 'lt', 'longting', '', '区', '410202', '0378', 1);
INSERT INTO `district` VALUES (1848, '顺河', 273, 's', 'sh', 'shunhe', '回族', '区', '410203', '0378', 2);
INSERT INTO `district` VALUES (1849, '鼓楼', 273, 'g', 'gl', 'gulou', '', '区', '410204', '0378', 3);
INSERT INTO `district` VALUES (1850, '禹王台', 273, 'y', 'ywt', 'yuwangtai', '', '区', '410205', '0378', 4);
INSERT INTO `district` VALUES (1852, '杞县', 273, 'q', 'qx', 'qixian', '', '', '410221', '0378', 6);
INSERT INTO `district` VALUES (1853, '通许', 273, 't', 'tx', 'tongxu', '', '县', '410222', '0378', 7);
INSERT INTO `district` VALUES (1854, '尉氏', 273, 'w', 'ws', 'weishi', '', '县', '410223', '0378', 8);
INSERT INTO `district` VALUES (1855, '祥符', 273, 'x', 'xf', 'kaifeng', '', '区', '410212', '0378', 5);
INSERT INTO `district` VALUES (1856, '兰考', 273, 'l', 'lk', 'lankao', '', '县', '410225', '0378', 9);
INSERT INTO `district` VALUES (1857, '老城', 274, 'l', 'lc', 'laocheng', '', '区', '410302', '0376', 1);
INSERT INTO `district` VALUES (1858, '西工', 274, 'x', 'xg', 'xigong', '', '区', '410303', '0376', 2);
INSERT INTO `district` VALUES (1859, '瀍河', 274, 'c', 'ch', 'chanhe', '回族', '区', '410304', '0376', 3);
INSERT INTO `district` VALUES (1860, '涧西', 274, 'j', 'jx', 'jianxi', '', '区', '410305', '0376', 4);
INSERT INTO `district` VALUES (1861, '吉利', 274, 'j', 'jl', 'jili', '', '区', '410306', '0376', 5);
INSERT INTO `district` VALUES (1862, '洛龙', 274, 'l', 'll', 'luolong', '', '区', '410311', '0376', 6);
INSERT INTO `district` VALUES (1863, '孟津', 274, 'm', 'mj', 'mengjin', '', '县', '410322', '0376', 7);
INSERT INTO `district` VALUES (1864, '新安', 274, 'x', 'xa', 'xinan', '', '县', '410323', '0376', 8);
INSERT INTO `district` VALUES (1865, '栾川', 274, 'l', 'lc', 'luanchuan', '', '县', '410324', '0376', 9);
INSERT INTO `district` VALUES (1866, '嵩县', 274, 's', 'sx', 'songxian', '', '', '410325', '0376', 10);
INSERT INTO `district` VALUES (1867, '汝阳', 274, 'r', 'ry', 'ruyang', '', '县', '410326', '0376', 11);
INSERT INTO `district` VALUES (1868, '宜阳', 274, 'y', 'yy', 'yiyang', '', '县', '410327', '0376', 12);
INSERT INTO `district` VALUES (1869, '洛宁', 274, 'l', 'ln', 'luoning', '', '县', '410328', '0376', 13);
INSERT INTO `district` VALUES (1870, '伊川', 274, 'y', 'yc', 'yichuan', '', '县', '410329', '0376', 14);
INSERT INTO `district` VALUES (1871, '偃师', 274, 'y', 'ys', 'yanshi', '', '市', '410381', '0376', 15);
INSERT INTO `district` VALUES (1872, '新华', 275, 'x', 'xh', 'xinhua', '', '区', '410402', '0375', 1);
INSERT INTO `district` VALUES (1873, '卫东', 275, 'w', 'wd', 'weidong', '', '区', '410403', '0375', 2);
INSERT INTO `district` VALUES (1874, '石龙', 275, 's', 'sl', 'shilong', '', '区', '410404', '0375', 3);
INSERT INTO `district` VALUES (1875, '湛河', 275, 'z', 'zh', 'zhanhe', '', '区', '410411', '0375', 4);
INSERT INTO `district` VALUES (1876, '宝丰', 275, 'b', 'bf', 'baofeng', '', '县', '410421', '0375', 5);
INSERT INTO `district` VALUES (1877, '叶县', 275, 'y', 'yx', 'yexian', '', '', '410422', '0375', 6);
INSERT INTO `district` VALUES (1878, '鲁山', 275, 'l', 'ls', 'lushan', '', '县', '410423', '0375', 7);
INSERT INTO `district` VALUES (1879, '郏县', 275, 'j', 'jx', 'jiaxian', '', '', '410425', '0375', 8);
INSERT INTO `district` VALUES (1880, '舞钢', 275, 'w', 'wg', 'wugang', '', '市', '410481', '0375', 9);
INSERT INTO `district` VALUES (1881, '汝州', 275, 'r', 'rz', 'ruzhou', '', '市', '410482', '0375', 10);
INSERT INTO `district` VALUES (1882, '文峰', 276, 'w', 'wf', 'wenfeng', '', '区', '410502', '0372', 1);
INSERT INTO `district` VALUES (1883, '北关', 276, 'b', 'bg', 'beiguan', '', '区', '410503', '0372', 2);
INSERT INTO `district` VALUES (1884, '殷都', 276, 'y', 'yd', 'yindu', '', '区', '410505', '0372', 3);
INSERT INTO `district` VALUES (1885, '龙安', 276, 'l', 'la', 'longan', '', '区', '410506', '0372', 4);
INSERT INTO `district` VALUES (1886, '安阳', 276, 'a', 'ay', 'anyang', '', '县', '410522', '0372', 5);
INSERT INTO `district` VALUES (1887, '汤阴', 276, 't', 'ty', 'tangyin', '', '县', '410523', '0372', 6);
INSERT INTO `district` VALUES (1888, '滑县', 276, 'h', 'hx', 'huaxian', '', '', '410526', '0372', 7);
INSERT INTO `district` VALUES (1889, '内黄', 276, 'n', 'nh', 'neihuang', '', '县', '410527', '0372', 8);
INSERT INTO `district` VALUES (1890, '林州', 276, 'l', 'lz', 'linzhou', '', '市', '410581', '0372', 9);
INSERT INTO `district` VALUES (1891, '鹤山', 277, 'h', 'hs', 'heshan', '', '区', '410602', '0392', 1);
INSERT INTO `district` VALUES (1892, '山城', 277, 's', 'sc', 'shancheng', '', '区', '410603', '0392', 2);
INSERT INTO `district` VALUES (1893, '淇滨', 277, 'q', 'qb', 'qibin', '', '区', '410611', '0392', 3);
INSERT INTO `district` VALUES (1894, '浚县', 277, 'j', 'jx', 'junxian', '', '', '410621', '0392', 4);
INSERT INTO `district` VALUES (1895, '淇县', 277, 'q', 'qx', 'qixian', '', '', '410622', '0392', 5);
INSERT INTO `district` VALUES (1896, '红旗', 278, 'h', 'hq', 'hongqi', '', '区', '410702', '0373', 1);
INSERT INTO `district` VALUES (1897, '卫滨', 278, 'w', 'wb', 'weibin', '', '区', '410703', '0373', 2);
INSERT INTO `district` VALUES (1898, '凤泉', 278, 'f', 'fq', 'fengquan', '', '区', '410704', '0373', 3);
INSERT INTO `district` VALUES (1899, '牧野', 278, 'm', 'my', 'muye', '', '区', '410711', '0373', 4);
INSERT INTO `district` VALUES (1900, '新乡', 278, 'x', 'xx', 'xinxiang', '', '县', '410721', '0373', 5);
INSERT INTO `district` VALUES (1901, '获嘉', 278, 'h', 'hj', 'huojia', '', '县', '410724', '0373', 6);
INSERT INTO `district` VALUES (1902, '原阳', 278, 'y', 'yy', 'yuanyang', '', '县', '410725', '0373', 7);
INSERT INTO `district` VALUES (1903, '延津', 278, 'y', 'yj', 'yanjin', '', '县', '410726', '0373', 8);
INSERT INTO `district` VALUES (1904, '封丘', 278, 'f', 'fq', 'fengqiu', '', '县', '410727', '0373', 9);
INSERT INTO `district` VALUES (1905, '长垣', 278, 'c', 'cy', 'changyuan', '', '市', '410783', '0373', 12);
INSERT INTO `district` VALUES (1906, '卫辉', 278, 'w', 'wh', 'weihui', '', '市', '410781', '0373', 10);
INSERT INTO `district` VALUES (1907, '辉县', 278, 'h', 'hx', 'huixian', '', '市', '410782', '0373', 11);
INSERT INTO `district` VALUES (1908, '解放', 279, 'j', 'jf', 'jiefang', '', '区', '410802', '0391', 1);
INSERT INTO `district` VALUES (1909, '中站', 279, 'z', 'zz', 'zhongzhan', '', '区', '410803', '0391', 2);
INSERT INTO `district` VALUES (1910, '马村', 279, 'm', 'mc', 'macun', '', '区', '410804', '0391', 3);
INSERT INTO `district` VALUES (1911, '山阳', 279, 's', 'sy', 'shanyang', '', '区', '410811', '0391', 4);
INSERT INTO `district` VALUES (1912, '修武', 279, 'x', 'xw', 'xiuwu', '', '县', '410821', '0391', 5);
INSERT INTO `district` VALUES (1913, '博爱', 279, 'b', 'ba', 'boai', '', '县', '410822', '0391', 6);
INSERT INTO `district` VALUES (1914, '武陟', 279, 'w', 'wz', 'wuzhi', '', '县', '410823', '0391', 7);
INSERT INTO `district` VALUES (1915, '温县', 279, 'w', 'wx', 'wenxian', '', '', '410825', '0391', 8);
INSERT INTO `district` VALUES (1916, '沁阳', 279, 'q', 'qy', 'qinyang', '', '市', '410882', '0391', 9);
INSERT INTO `district` VALUES (1917, '孟州', 279, 'm', 'mz', 'mengzhou', '', '市', '410883', '0391', 10);
INSERT INTO `district` VALUES (1918, '华龙', 280, 'h', 'hl', 'hualong', '', '区', '410902', '', 1);
INSERT INTO `district` VALUES (1919, '清丰', 280, 'q', 'qf', 'qingfeng', '', '县', '410922', '', 2);
INSERT INTO `district` VALUES (1920, '南乐', 280, 'n', 'nl', 'nanle', '', '县', '410923', '', 3);
INSERT INTO `district` VALUES (1921, '范县', 280, 'f', 'fx', 'fanxian', '', '', '410926', '', 4);
INSERT INTO `district` VALUES (1922, '台前', 280, 't', 'tq', 'taiqian', '', '县', '410927', '', 5);
INSERT INTO `district` VALUES (1923, '濮阳', 280, 'p', 'py', 'puyang', '', '县', '410928', '', 6);
INSERT INTO `district` VALUES (1924, '魏都', 281, 'w', 'wd', 'weidu', '', '区', '411002', '0374', 1);
INSERT INTO `district` VALUES (1925, '建安', 281, 'j', 'ja', 'jianan', '', '区', '411003', '0374', 2);
INSERT INTO `district` VALUES (1926, '鄢陵', 281, 'y', 'yl', 'yanling', '', '县', '411024', '0374', 3);
INSERT INTO `district` VALUES (1927, '襄城', 281, 'x', 'xc', 'xiangcheng', '', '县', '411025', '0374', 4);
INSERT INTO `district` VALUES (1928, '禹州', 281, 'y', 'yz', 'yuzhou', '', '市', '411081', '0374', 5);
INSERT INTO `district` VALUES (1929, '长葛', 281, 'c', 'cg', 'changge', '', '市', '411082', '0374', 6);
INSERT INTO `district` VALUES (1930, '源汇', 282, 'y', 'yh', 'yuanhui', '', '区', '411102', '0395', 1);
INSERT INTO `district` VALUES (1931, '郾城', 282, 'y', 'yc', 'yancheng', '', '区', '411103', '0395', 2);
INSERT INTO `district` VALUES (1932, '召陵', 282, 'z', 'zl', 'zhaoling', '', '区', '411104', '0395', 3);
INSERT INTO `district` VALUES (1933, '舞阳', 282, 'w', 'wy', 'wuyang', '', '县', '411121', '0395', 4);
INSERT INTO `district` VALUES (1934, '临颍', 282, 'l', 'ly', 'linying', '', '县', '411122', '0395', 5);
INSERT INTO `district` VALUES (1935, '湖滨', 283, 'h', 'hb', 'hubin', '', '区', '411202', '0398', 1);
INSERT INTO `district` VALUES (1936, '渑池', 283, 'm', 'mc', 'mianchi', '', '县', '411221', '0398', 3);
INSERT INTO `district` VALUES (1937, '陕州', 283, 's', 'sz', 'shanzhou', '', '区', '411222', '0398', 2);
INSERT INTO `district` VALUES (1938, '卢氏', 283, 'l', 'ls', 'lushi', '', '县', '411224', '0398', 4);
INSERT INTO `district` VALUES (1939, '义马', 283, 'y', 'ym', 'yima', '', '市', '411281', '0398', 5);
INSERT INTO `district` VALUES (1940, '灵宝', 283, 'l', 'lb', 'lingbao', '', '市', '411282', '0398', 6);
INSERT INTO `district` VALUES (1941, '宛城', 284, 'w', 'wc', 'wancheng', '', '区', '411302', '0377', 1);
INSERT INTO `district` VALUES (1942, '卧龙', 284, 'w', 'wl', 'wolong', '', '区', '411303', '0377', 2);
INSERT INTO `district` VALUES (1943, '南召', 284, 'n', 'nz', 'nanzhao', '', '县', '411321', '0377', 3);
INSERT INTO `district` VALUES (1944, '方城', 284, 'f', 'fc', 'fangcheng', '', '县', '411322', '0377', 4);
INSERT INTO `district` VALUES (1945, '西峡', 284, 'x', 'xx', 'xixia', '', '县', '411323', '0377', 5);
INSERT INTO `district` VALUES (1946, '镇平', 284, 'z', 'zp', 'zhenping', '', '县', '411324', '0377', 6);
INSERT INTO `district` VALUES (1947, '内乡', 284, 'n', 'nx', 'neixiang', '', '县', '411325', '0377', 7);
INSERT INTO `district` VALUES (1948, '淅川', 284, 'x', 'xc', 'xichuan', '', '县', '411326', '0377', 8);
INSERT INTO `district` VALUES (1949, '社旗', 284, 's', 'sq', 'sheqi', '', '县', '411327', '0377', 9);
INSERT INTO `district` VALUES (1950, '唐河', 284, 't', 'th', 'tanghe', '', '县', '411328', '0377', 10);
INSERT INTO `district` VALUES (1951, '新野', 284, 'x', 'xy', 'xinye', '', '县', '411329', '0377', 11);
INSERT INTO `district` VALUES (1952, '桐柏', 284, 't', 'tb', 'tongbo', '', '县', '411330', '0377', 12);
INSERT INTO `district` VALUES (1953, '邓州', 284, 'd', 'dz', 'dengzhou', '', '市', '411381', '0377', 13);
INSERT INTO `district` VALUES (1954, '粱园', 285, 'l', 'ly', 'liangyuan', '', '区', '411402', '0370', 1);
INSERT INTO `district` VALUES (1955, '睢阳', 285, 's', 'sy', 'suiyang', '', '区', '411403', '0370', 2);
INSERT INTO `district` VALUES (1956, '民权', 285, 'm', 'mq', 'minquan', '', '县', '411421', '0370', 3);
INSERT INTO `district` VALUES (1957, '睢县', 285, 's', 'sx', 'suixian', '', '', '411422', '0370', 4);
INSERT INTO `district` VALUES (1958, '宁陵', 285, 'n', 'nl', 'ningling', '', '县', '411423', '0370', 5);
INSERT INTO `district` VALUES (1959, '柘城', 285, 'z', 'zc', 'zhecheng', '', '县', '411424', '0370', 6);
INSERT INTO `district` VALUES (1960, '虞城', 285, 'y', 'yc', 'yucheng', '', '县', '411425', '0370', 7);
INSERT INTO `district` VALUES (1961, '夏邑', 285, 'x', 'xy', 'xiayi', '', '县', '411426', '0370', 8);
INSERT INTO `district` VALUES (1962, '永城', 285, 'y', 'yc', 'yongcheng', '', '市', '411481', '0370', 9);
INSERT INTO `district` VALUES (1963, '浉河', 286, 's', 'sh', 'shihe', '', '区', '411502', '0376', 1);
INSERT INTO `district` VALUES (1964, '平桥', 286, 'p', 'pq', 'pingqiao', '', '区', '411503', '0376', 2);
INSERT INTO `district` VALUES (1965, '罗山', 286, 'l', 'ls', 'luoshan', '', '县', '411521', '0376', 3);
INSERT INTO `district` VALUES (1966, '光山', 286, 'g', 'gs', 'guangshan', '', '县', '411522', '0376', 4);
INSERT INTO `district` VALUES (1967, '新县', 286, 'x', 'xx', 'xinxian', '', '', '411523', '0376', 5);
INSERT INTO `district` VALUES (1968, '商城', 286, 's', 'sc', 'shangcheng', '', '县', '411524', '0376', 6);
INSERT INTO `district` VALUES (1969, '固始', 286, 'g', 'gs', 'gushi', '', '县', '411525', '0376', 7);
INSERT INTO `district` VALUES (1970, '潢川', 286, 'h', 'hc', 'huangchuan', '', '县', '411526', '0376', 8);
INSERT INTO `district` VALUES (1971, '淮滨', 286, 'h', 'hb', 'huaibin', '', '县', '411527', '0376', 9);
INSERT INTO `district` VALUES (1972, '息县', 286, 'x', 'xx', 'xixian', '', '', '411528', '0376', 10);
INSERT INTO `district` VALUES (1973, '川汇', 287, 'c', 'ch', 'chuanhui', '', '区', '411602', '0394', 1);
INSERT INTO `district` VALUES (1974, '扶沟', 287, 'f', 'fg', 'fugou', '', '县', '411621', '0394', 3);
INSERT INTO `district` VALUES (1975, '西华', 287, 'x', 'xh', 'xihua', '', '县', '411622', '0394', 4);
INSERT INTO `district` VALUES (1976, '商水', 287, 's', 'ss', 'shangshui', '', '县', '411623', '0394', 5);
INSERT INTO `district` VALUES (1977, '沈丘', 287, 's', 'sq', 'shenqiu', '', '县', '411624', '0394', 6);
INSERT INTO `district` VALUES (1978, '郸城', 287, 'd', 'dc', 'dancheng', '', '县', '411625', '0394', 7);
INSERT INTO `district` VALUES (1979, '淮阳', 287, 'h', 'hy', 'huaiyang', '', '区', '411603', '0394', 2);
INSERT INTO `district` VALUES (1980, '太康', 287, 't', 'tk', 'taikang', '', '县', '411627', '0394', 8);
INSERT INTO `district` VALUES (1981, '鹿邑', 287, 'l', 'ly', 'luyi', '', '县', '411628', '0394', 9);
INSERT INTO `district` VALUES (1982, '项城', 287, 'x', 'xc', 'xiangcheng', '', '市', '411681', '0394', 10);
INSERT INTO `district` VALUES (1983, '驿城', 288, 'y', 'yc', 'yicheng', '', '区', '411702', '0396', 1);
INSERT INTO `district` VALUES (1984, '西平', 288, 'x', 'xp', 'xiping', '', '县', '411721', '0396', 2);
INSERT INTO `district` VALUES (1985, '上蔡', 288, 's', 'sc', 'shangcai', '', '县', '411722', '0396', 3);
INSERT INTO `district` VALUES (1986, '平舆', 288, 'p', 'py', 'pingyu', '', '县', '411723', '0396', 4);
INSERT INTO `district` VALUES (1987, '正阳', 288, 'z', 'zy', 'zhengyang', '', '县', '411724', '0396', 5);
INSERT INTO `district` VALUES (1988, '确山', 288, 'q', 'qs', 'queshan', '', '县', '411725', '0396', 6);
INSERT INTO `district` VALUES (1989, '泌阳', 288, 'm', 'my', 'miyang', '', '县', '411726', '0396', 7);
INSERT INTO `district` VALUES (1990, '汝南', 288, 'r', 'rn', 'runan', '', '县', '411727', '0396', 8);
INSERT INTO `district` VALUES (1991, '遂平', 288, 's', 'sp', 'suiping', '', '县', '411728', '0396', 9);
INSERT INTO `district` VALUES (1992, '新蔡', 288, 'x', 'xc', 'xincai', '', '县', '411729', '0396', 10);
INSERT INTO `district` VALUES (1993, '江岸', 290, 'j', 'ja', 'jiangan', '', '区', '420102', '027', 1);
INSERT INTO `district` VALUES (1994, '江汉', 290, 'j', 'jh', 'jianghan', '', '区', '420103', '027', 2);
INSERT INTO `district` VALUES (1995, '硚口', 290, 'q', 'qk', 'qiaokou', '', '区', '420104', '027', 3);
INSERT INTO `district` VALUES (1996, '汉阳', 290, 'h', 'hy', 'hanyang', '', '区', '420105', '027', 4);
INSERT INTO `district` VALUES (1997, '武昌', 290, 'w', 'wc', 'wuchang', '', '区', '420106', '027', 5);
INSERT INTO `district` VALUES (1998, '青山', 290, 'q', 'qs', 'qingshan', '', '区', '420107', '027', 6);
INSERT INTO `district` VALUES (1999, '洪山', 290, 'h', 'hs', 'hongshan', '', '区', '420111', '027', 7);
INSERT INTO `district` VALUES (2000, '东西湖', 290, 'd', 'dxh', 'dongxihu', '', '区', '420112', '027', 8);
INSERT INTO `district` VALUES (2001, '汉南', 290, 'h', 'hn', 'hannan', '', '区', '420113', '027', 9);
INSERT INTO `district` VALUES (2002, '蔡甸', 290, 'c', 'cd', 'caidian', '', '区', '420114', '027', 10);
INSERT INTO `district` VALUES (2003, '江夏', 290, 'j', 'jx', 'jiangxia', '', '区', '420115', '027', 11);
INSERT INTO `district` VALUES (2004, '黄陂', 290, 'h', 'hp', 'huangpo', '', '区', '420116', '027', 12);
INSERT INTO `district` VALUES (2005, '新洲', 290, 'x', 'xz', 'xinzhou', '', '区', '420117', '027', 13);
INSERT INTO `district` VALUES (2006, '黄石港', 291, 'h', 'hsg', 'huangshigang', '', '区', '420202', '0714', 1);
INSERT INTO `district` VALUES (2007, '西塞山', 291, 'x', 'xss', 'xisaishan', '', '区', '420203', '0714', 2);
INSERT INTO `district` VALUES (2008, '下陆', 291, 'x', 'xl', 'xialu', '', '区', '420204', '0714', 3);
INSERT INTO `district` VALUES (2009, '铁山', 291, 't', 'ts', 'tieshan', '', '区', '420205', '0714', 4);
INSERT INTO `district` VALUES (2010, '阳新', 291, 'y', 'yx', 'yangxin', '', '县', '420222', '0714', 5);
INSERT INTO `district` VALUES (2011, '大冶', 291, 'd', 'dy', 'daye', '', '市', '420281', '0714', 6);
INSERT INTO `district` VALUES (2012, '茅箭', 292, 'm', 'mj', 'maojian', '', '区', '420302', '0719', 1);
INSERT INTO `district` VALUES (2013, '张湾', 292, 'z', 'zw', 'zhangwan', '', '区', '420303', '0719', 2);
INSERT INTO `district` VALUES (2014, '郧阳', 292, 'y', 'yy', 'yunyang', '', '区', '420304', '0719', 3);
INSERT INTO `district` VALUES (2015, '郧西', 292, 'y', 'yx', 'yunxi', '', '县', '420322', '0719', 4);
INSERT INTO `district` VALUES (2016, '竹山', 292, 'z', 'zs', 'zhushan', '', '县', '420323', '0719', 5);
INSERT INTO `district` VALUES (2017, '竹溪', 292, 'z', 'zx', 'zhuxi', '', '县', '420324', '0719', 6);
INSERT INTO `district` VALUES (2018, '房县', 292, 'f', 'fx', 'fangxian', '', '', '420325', '0719', 7);
INSERT INTO `district` VALUES (2019, '丹江口', 292, 'd', 'djk', 'danjiangkou', '', '市', '420381', '0719', 8);
INSERT INTO `district` VALUES (2020, '西陵', 293, 'x', 'xl', 'xiling', '', '区', '420502', '0717', 1);
INSERT INTO `district` VALUES (2021, '伍家岗', 293, 'w', 'wjg', 'wujiagang', '', '区', '420503', '0717', 2);
INSERT INTO `district` VALUES (2022, '点军', 293, 'd', 'dj', 'dianjun', '', '区', '420504', '0717', 3);
INSERT INTO `district` VALUES (2023, '虢亭', 293, 'g', 'gt', 'guoting', '', '区', '420505', '0717', 4);
INSERT INTO `district` VALUES (2024, '夷陵', 293, 'y', 'yl', 'yiling', '', '区', '420506', '0717', 5);
INSERT INTO `district` VALUES (2025, '远安', 293, 'y', 'ya', 'yuanan', '', '县', '420525', '0717', 6);
INSERT INTO `district` VALUES (2026, '兴山', 293, 'x', 'xs', 'xingshan', '', '县', '420526', '0717', 7);
INSERT INTO `district` VALUES (2027, '秭归', 293, 'z', 'zg', 'zigui', '', '县', '420527', '0717', 8);
INSERT INTO `district` VALUES (2028, '长阳', 293, 'c', 'cy', 'changyang', '土家族', '自治县', '420528', '0717', 9);
INSERT INTO `district` VALUES (2029, '五峰', 293, 'w', 'wf', 'wufeng', '土家族', '自治县', '420529', '0717', 10);
INSERT INTO `district` VALUES (2030, '宜都', 293, 'y', 'yd', 'yidu', '', '市', '420581', '0717', 11);
INSERT INTO `district` VALUES (2031, '当阳', 293, 'd', 'dy', 'dangyang', '', '市', '420582', '0717', 12);
INSERT INTO `district` VALUES (2032, '枝江', 293, 'z', 'zj', 'zhijiang', '', '市', '420583', '0717', 13);
INSERT INTO `district` VALUES (2033, '襄城', 294, 'x', 'xc', 'xiangcheng', '', '区', '420602', '0710', 1);
INSERT INTO `district` VALUES (2034, '樊城', 294, 'f', 'fc', 'fancheng', '', '区', '420606', '0710', 2);
INSERT INTO `district` VALUES (2035, '襄州', 294, 'x', 'xz', 'xiangzhou', '', '区', '420607', '0710', 3);
INSERT INTO `district` VALUES (2036, '南漳', 294, 'n', 'nz', 'nanzhang', '', '县', '420624', '0710', 4);
INSERT INTO `district` VALUES (2037, '谷城', 294, 'g', 'gc', 'gucheng', '', '县', '420625', '0710', 5);
INSERT INTO `district` VALUES (2038, '保康', 294, 'b', 'bk', 'baokang', '', '县', '420626', '0710', 6);
INSERT INTO `district` VALUES (2039, '老河口', 294, 'l', 'lhk', 'laohekou', '', '市', '420682', '0710', 7);
INSERT INTO `district` VALUES (2040, '枣阳', 294, 'z', 'zy', 'zaoyang', '', '市', '420683', '0710', 8);
INSERT INTO `district` VALUES (2041, '宜城', 294, 'y', 'yc', 'yicheng', '', '市', '420684', '0710', 9);
INSERT INTO `district` VALUES (2042, '粱子湖', 295, 'l', 'lzh', 'liangzihu', '', '区', '420702', '', 1);
INSERT INTO `district` VALUES (2043, '华容', 295, 'h', 'hr', 'huarong', '', '区', '420703', '', 2);
INSERT INTO `district` VALUES (2044, '鄂城', 295, 'e', 'ec', 'echeng', '', '区', '420704', '', 3);
INSERT INTO `district` VALUES (2045, '东宝', 296, 'd', 'db', 'dongbao', '', '区', '420802', '0724', 1);
INSERT INTO `district` VALUES (2046, '掇刀', 296, 'd', 'dd', 'duodao', '', '区', '420804', '0724', 2);
INSERT INTO `district` VALUES (2047, '京山', 296, 'j', 'js', 'jingshan', '', '市', '420882', '0724', 3);
INSERT INTO `district` VALUES (2048, '沙洋', 296, 's', 'sy', 'shayang', '', '县', '420822', '0724', 4);
INSERT INTO `district` VALUES (2049, '钟祥', 296, 'z', 'zx', 'zhongxiang', '', '市', '420881', '0724', 5);
INSERT INTO `district` VALUES (2050, '孝南', 297, 'x', 'xn', 'xiaonan', '', '区', '420902', '0712', 1);
INSERT INTO `district` VALUES (2051, '大悟', 297, 'd', 'dw', 'dawu', '', '县', '420922', '0712', 2);
INSERT INTO `district` VALUES (2052, '云梦', 297, 'y', 'ym', 'yunmeng', '', '县', '420923', '0712', 3);
INSERT INTO `district` VALUES (2053, '应城', 297, 'y', 'yc', 'yingcheng', '', '市', '420981', '0712', 4);
INSERT INTO `district` VALUES (2054, '安陆', 297, 'a', 'al', 'anlu', '', '市', '420982', '0712', 5);
INSERT INTO `district` VALUES (2055, '汉川', 297, 'h', 'hc', 'hanchuan', '', '市', '420984', '0712', 6);
INSERT INTO `district` VALUES (2056, '沙市', 298, 's', 'ss', 'shashi', '', '区', '421002', '0716', 1);
INSERT INTO `district` VALUES (2057, '荆州', 298, 'j', 'jz', 'jingzhou', '', '区', '421003', '0716', 2);
INSERT INTO `district` VALUES (2058, '公安', 298, 'g', 'ga', 'gongan', '', '县', '421022', '0716', 3);
INSERT INTO `district` VALUES (2059, '监利', 298, 'j', 'jl', 'jianli', '', '县', '421023', '0716', 4);
INSERT INTO `district` VALUES (2060, '江陵', 298, 'j', 'jl', 'jiangling', '', '县', '421024', '0716', 5);
INSERT INTO `district` VALUES (2061, '石首', 298, 's', 'ss', 'shishou', '', '市', '421081', '0716', 6);
INSERT INTO `district` VALUES (2062, '洪湖', 298, 'h', 'hh', 'honghu', '', '市', '421083', '0716', 7);
INSERT INTO `district` VALUES (2063, '松滋', 298, 's', 'sz', 'songzi', '', '市', '421087', '0716', 8);
INSERT INTO `district` VALUES (2064, '黄州', 299, 'h', 'hz', 'huangzhou', '', '区', '421102', '0713', 1);
INSERT INTO `district` VALUES (2065, '团风', 299, 't', 'tf', 'tuanfeng', '', '县', '421121', '0713', 2);
INSERT INTO `district` VALUES (2066, '红安', 299, 'h', 'ha', 'hongan', '', '县', '421122', '0713', 3);
INSERT INTO `district` VALUES (2067, '罗田', 299, 'l', 'lt', 'luotian', '', '县', '421123', '0713', 4);
INSERT INTO `district` VALUES (2068, '英山', 299, 'y', 'ys', 'yingshan', '', '县', '421124', '0713', 5);
INSERT INTO `district` VALUES (2069, '浠水', 299, 'x', 'xs', 'xishui', '', '县', '421125', '0713', 6);
INSERT INTO `district` VALUES (2070, '蕲春', 299, 'q', 'qc', 'qichun', '', '县', '421126', '0713', 7);
INSERT INTO `district` VALUES (2071, '黄梅', 299, 'h', 'hm', 'huangmei', '', '县', '421127', '0713', 8);
INSERT INTO `district` VALUES (2072, '麻城', 299, 'm', 'mc', 'macheng', '', '市', '421181', '0713', 9);
INSERT INTO `district` VALUES (2073, '武穴', 299, 'w', 'wx', 'wuxue', '', '市', '421182', '0713', 10);
INSERT INTO `district` VALUES (2074, '咸安', 300, 'x', 'xa', 'xianan', '', '区', '421202', '0715', 1);
INSERT INTO `district` VALUES (2075, '嘉鱼', 300, 'j', 'jy', 'jiayu', '', '县', '421221', '0715', 2);
INSERT INTO `district` VALUES (2076, '通城', 300, 't', 'tc', 'tongcheng', '', '县', '421222', '0715', 3);
INSERT INTO `district` VALUES (2077, '崇阳', 300, 'c', 'cy', 'chongyang', '', '县', '421223', '0715', 4);
INSERT INTO `district` VALUES (2078, '通山', 300, 't', 'ts', 'tongshan', '', '县', '421224', '0715', 5);
INSERT INTO `district` VALUES (2079, '赤壁', 300, 'c', 'cb', 'chibi', '', '市', '421281', '0715', 6);
INSERT INTO `district` VALUES (2080, '曾都', 301, 'c', 'cd', 'cengdu', '', '区', '421303', '0722', 1);
INSERT INTO `district` VALUES (2081, '随县', 301, 's', 'sx', 'suixian', '', '', '421321', '0722', 2);
INSERT INTO `district` VALUES (2082, '广水', 301, 'g', 'gs', 'guangshui', '', '市', '421381', '0722', 3);
INSERT INTO `district` VALUES (2083, '恩施', 302, 'e', 'es', 'enshi', '', '市', '422801', '0718', 1);
INSERT INTO `district` VALUES (2084, '利川', 302, 'l', 'lc', 'lichuan', '', '市', '422802', '0718', 2);
INSERT INTO `district` VALUES (2085, '建始', 302, 'j', 'js', 'jianshi', '', '县', '422822', '0718', 3);
INSERT INTO `district` VALUES (2086, '巴东', 302, 'b', 'bd', 'badong', '', '县', '422823', '0718', 4);
INSERT INTO `district` VALUES (2087, '宣恩', 302, 'x', 'xe', 'xuanen', '', '县', '422825', '0718', 5);
INSERT INTO `district` VALUES (2088, '咸丰', 302, 'x', 'xf', 'xianfeng', '', '县', '422826', '0718', 6);
INSERT INTO `district` VALUES (2089, '来凤', 302, 'l', 'lf', 'laifeng', '', '县', '422827', '0718', 7);
INSERT INTO `district` VALUES (2090, '鹤峰', 302, 'h', 'hf', 'hefeng', '', '县', '422828', '0718', 8);
INSERT INTO `district` VALUES (2091, '芙蓉', 307, 'f', 'fr', 'furong', '', '区', '430102', '0731', 1);
INSERT INTO `district` VALUES (2092, '天心', 307, 't', 'tx', 'tianxin', '', '区', '430103', '0731', 2);
INSERT INTO `district` VALUES (2093, '岳麓', 307, 'y', 'yl', 'yuelu', '', '区', '430104', '0731', 3);
INSERT INTO `district` VALUES (2094, '开福', 307, 'k', 'kf', 'kaifu', '', '区', '430105', '0731', 4);
INSERT INTO `district` VALUES (2095, '雨花', 307, 'y', 'yh', 'yuhua', '', '区', '430111', '0731', 5);
INSERT INTO `district` VALUES (2096, '望城', 307, 'w', 'wc', 'wangcheng', '', '区', '430112', '0731', 6);
INSERT INTO `district` VALUES (2097, '长沙', 307, 'c', 'cs', 'changsha', '', '县', '430121', '0731', 7);
INSERT INTO `district` VALUES (2098, '宁乡', 307, 'n', 'nx', 'ningxiang', '', '市', '430182', '0731', 8);
INSERT INTO `district` VALUES (2099, '浏阳', 307, 'l', 'ly', 'liuyang', '', '市', '430181', '0731', 9);
INSERT INTO `district` VALUES (2100, '荷塘', 308, 'h', 'ht', 'hetang', '', '区', '430202', '0731', 1);
INSERT INTO `district` VALUES (2101, '芦淞', 308, 'l', 'ls', 'lusong', '', '区', '430203', '0731', 2);
INSERT INTO `district` VALUES (2102, '石峰', 308, 's', 'sf', 'shifeng', '', '区', '430204', '0731', 3);
INSERT INTO `district` VALUES (2103, '天元', 308, 't', 'ty', 'tianyuan', '', '区', '430211', '0731', 4);
INSERT INTO `district` VALUES (2104, '渌口', 308, 'l', 'lk', 'lukou', '', '区', '430212', '0731', 5);
INSERT INTO `district` VALUES (2105, '攸县', 308, 'y', 'yx', 'youxian', '', '', '430223', '0731', 6);
INSERT INTO `district` VALUES (2106, '茶陵', 308, 'c', 'cl', 'chaling', '', '县', '430224', '0731', 7);
INSERT INTO `district` VALUES (2107, '炎陵', 308, 'y', 'yl', 'yanling', '', '县', '430225', '0731', 8);
INSERT INTO `district` VALUES (2108, '醴陵', 308, 'l', 'll', 'liling', '', '市', '430281', '0731', 9);
INSERT INTO `district` VALUES (2109, '雨湖', 309, 'y', 'yh', 'yuhu', '', '区', '430302', '0731', 1);
INSERT INTO `district` VALUES (2110, '岳塘', 309, 'y', 'yt', 'yuetang', '', '区', '430304', '0731', 2);
INSERT INTO `district` VALUES (2111, '湘潭', 309, 'x', 'xt', 'xiangtan', '', '县', '430321', '0731', 3);
INSERT INTO `district` VALUES (2112, '湘乡', 309, 'x', 'xx', 'xiangxiang', '', '市', '430381', '0731', 4);
INSERT INTO `district` VALUES (2113, '韶山', 309, 's', 'ss', 'shaoshan', '', '市', '430382', '0731', 5);
INSERT INTO `district` VALUES (2114, '珠晖', 310, 'z', 'zh', 'zhuhui', '', '区', '430405', '0734', 1);
INSERT INTO `district` VALUES (2115, '雁峰', 310, 'y', 'yf', 'yanfeng', '', '区', '430406', '0734', 2);
INSERT INTO `district` VALUES (2116, '石鼓', 310, 's', 'sg', 'shigu', '', '区', '430407', '0734', 3);
INSERT INTO `district` VALUES (2117, '蒸湘', 310, 'z', 'zx', 'zhengxiang', '', '区', '430408', '0734', 4);
INSERT INTO `district` VALUES (2118, '南岳', 310, 'n', 'ny', 'nanyue', '', '区', '430412', '0734', 5);
INSERT INTO `district` VALUES (2119, '衡阳', 310, 'h', 'hy', 'hengyang', '', '县', '430421', '0734', 6);
INSERT INTO `district` VALUES (2120, '衡南', 310, 'h', 'hn', 'hengnan', '', '县', '430422', '0734', 7);
INSERT INTO `district` VALUES (2121, '衡山', 310, 'h', 'hs', 'hengshan', '', '县', '430423', '0734', 8);
INSERT INTO `district` VALUES (2122, '衡东', 310, 'h', 'hd', 'hengdong', '', '县', '430424', '0734', 9);
INSERT INTO `district` VALUES (2123, '祁东', 310, 'q', 'qd', 'qidong', '', '县', '430426', '0734', 10);
INSERT INTO `district` VALUES (2124, '耒阳', 310, 'l', 'ly', 'leiyang', '', '市', '430481', '0734', 11);
INSERT INTO `district` VALUES (2125, '常宁', 310, 'c', 'cn', 'changning', '', '市', '430482', '0734', 12);
INSERT INTO `district` VALUES (2126, '双清', 311, 's', 'sq', 'shuangqing', '', '区', '430502', '0739', 1);
INSERT INTO `district` VALUES (2127, '大祥', 311, 'd', 'dx', 'daxiang', '', '区', '430503', '0739', 2);
INSERT INTO `district` VALUES (2128, '北塔', 311, 'b', 'bt', 'beita', '', '区', '430511', '0739', 3);
INSERT INTO `district` VALUES (2129, '邵东', 311, 's', 'sd', 'shaodong', '', '市', '430521', '0739', 4);
INSERT INTO `district` VALUES (2130, '新邵', 311, 'x', 'xs', 'xinshao', '', '县', '430582', '0739', 12);
INSERT INTO `district` VALUES (2131, '邵阳', 311, 's', 'sy', 'shaoyang', '', '县', '430523', '0739', 5);
INSERT INTO `district` VALUES (2132, '隆回', 311, 'l', 'lh', 'longhui', '', '县', '430524', '0739', 6);
INSERT INTO `district` VALUES (2133, '洞口', 311, 'd', 'dk', 'dongkou', '', '县', '430525', '0739', 7);
INSERT INTO `district` VALUES (2134, '绥宁', 311, 's', 'sn', 'suining', '', '县', '430527', '0739', 8);
INSERT INTO `district` VALUES (2135, '新宁', 311, 'x', 'xn', 'xinning', '', '县', '430528', '0739', 9);
INSERT INTO `district` VALUES (2136, '城步', 311, 'c', 'cb', 'chengbu', '苗族', '自治县', '430529', '0739', 10);
INSERT INTO `district` VALUES (2137, '武冈', 311, 'w', 'wg', 'wugang', '', '市', '430581', '0739', 11);
INSERT INTO `district` VALUES (2138, '岳阳楼', 312, 'y', 'yyl', 'yueyanglou', '', '区', '430602', '0730', 1);
INSERT INTO `district` VALUES (2139, '云溪', 312, 'y', 'yx', 'yunxi', '', '区', '430603', '0730', 2);
INSERT INTO `district` VALUES (2140, '君山', 312, 'j', 'js', 'junshan', '', '区', '430611', '0730', 3);
INSERT INTO `district` VALUES (2141, '岳阳', 312, 'y', 'yy', 'yueyang', '', '县', '430621', '0730', 4);
INSERT INTO `district` VALUES (2142, '华容', 312, 'h', 'hr', 'huarong', '', '县', '430623', '0730', 5);
INSERT INTO `district` VALUES (2143, '湘阴', 312, 'x', 'xy', 'xiangyin', '', '县', '430624', '0730', 6);
INSERT INTO `district` VALUES (2144, '平江', 312, 'p', 'pj', 'pingjiang', '', '县', '430626', '0730', 7);
INSERT INTO `district` VALUES (2145, '汨罗', 312, 'm', 'ml', 'miluo', '', '市', '430681', '0730', 8);
INSERT INTO `district` VALUES (2146, '临湘', 312, 'l', 'lx', 'linxiang', '', '市', '430682', '0730', 9);
INSERT INTO `district` VALUES (2147, '武陵', 313, 'w', 'wl', 'wuling', '', '区', '430702', '0736', 1);
INSERT INTO `district` VALUES (2148, '鼎城', 313, 'd', 'dc', 'dingcheng', '', '区', '430703', '0736', 2);
INSERT INTO `district` VALUES (2149, '安乡', 313, 'a', 'ax', 'anxiang', '', '县', '430721', '0736', 3);
INSERT INTO `district` VALUES (2150, '汉寿', 313, 'h', 'hs', 'hanshou', '', '县', '430722', '0736', 4);
INSERT INTO `district` VALUES (2151, '澧县', 313, 'l', 'lx', 'lixian', '', '', '430723', '0736', 5);
INSERT INTO `district` VALUES (2152, '临澧', 313, 'l', 'll', 'linli', '', '县', '430724', '0736', 6);
INSERT INTO `district` VALUES (2153, '桃源', 313, 't', 'ty', 'taoyuan', '', '县', '430725', '0736', 7);
INSERT INTO `district` VALUES (2154, '石门', 313, 's', 'sm', 'shimen', '', '县', '430726', '0736', 8);
INSERT INTO `district` VALUES (2155, '津市', 313, 'j', 'js', 'jinshi', '', '市', '430781', '0736', 9);
INSERT INTO `district` VALUES (2156, '永定', 314, 'y', 'yd', 'yongding', '', '区', '430802', '0744', 1);
INSERT INTO `district` VALUES (2157, '武陵源', 314, 'w', 'wly', 'wulingyuan', '', '区', '430811', '0744', 2);
INSERT INTO `district` VALUES (2158, '慈利', 314, 'c', 'cl', 'cili', '', '县', '430821', '0744', 3);
INSERT INTO `district` VALUES (2159, '桑植', 314, 's', 'sz', 'sangzhi', '', '县', '430822', '0744', 4);
INSERT INTO `district` VALUES (2160, '资阳', 315, 'z', 'zy', 'ziyang', '', '区', '430902', '0737', 1);
INSERT INTO `district` VALUES (2161, '赫山', 315, 'h', 'hs', 'heshan', '', '区', '430903', '0737', 2);
INSERT INTO `district` VALUES (2162, '南县', 315, 'n', 'nx', 'nanxian', '', '', '430921', '0737', 3);
INSERT INTO `district` VALUES (2163, '桃江', 315, 't', 'tj', 'taojiang', '', '县', '430922', '0737', 4);
INSERT INTO `district` VALUES (2164, '安化', 315, 'a', 'ah', 'anhua', '', '县', '430923', '0737', 5);
INSERT INTO `district` VALUES (2165, '沅江', 315, 'y', 'yj', 'yuanjiang', '', '市', '430981', '0737', 6);
INSERT INTO `district` VALUES (2166, '北湖', 316, 'b', 'bh', 'beihu', '', '区', '431002', '0735', 1);
INSERT INTO `district` VALUES (2167, '苏仙', 316, 's', 'sx', 'suxian', '', '区', '431003', '0735', 2);
INSERT INTO `district` VALUES (2168, '桂阳', 316, 'g', 'gy', 'guiyang', '', '县', '431021', '0735', 3);
INSERT INTO `district` VALUES (2169, '宜章', 316, 'y', 'yz', 'yizhang', '', '县', '431022', '0735', 4);
INSERT INTO `district` VALUES (2170, '永兴', 316, 'y', 'yx', 'yongxing', '', '县', '431023', '0735', 5);
INSERT INTO `district` VALUES (2171, '嘉禾', 316, 'j', 'jh', 'jiahe', '', '县', '431024', '0735', 6);
INSERT INTO `district` VALUES (2172, '临武', 316, 'l', 'lw', 'linwu', '', '县', '431025', '0735', 7);
INSERT INTO `district` VALUES (2173, '汝城', 316, 'r', 'rc', 'rucheng', '', '县', '431026', '0735', 8);
INSERT INTO `district` VALUES (2174, '桂东', 316, 'g', 'gd', 'guidong', '', '县', '431027', '0735', 9);
INSERT INTO `district` VALUES (2175, '安仁', 316, 'a', 'ar', 'anren', '', '县', '431028', '0735', 10);
INSERT INTO `district` VALUES (2176, '资兴', 316, 'z', 'zx', 'zixing', '', '市', '431081', '0735', 11);
INSERT INTO `district` VALUES (2177, '零陵', 317, 'l', 'll', 'lingling', '', '区', '431102', '0746', 1);
INSERT INTO `district` VALUES (2178, '冷水滩', 317, 'l', 'lst', 'lengshuitan', '', '区', '431103', '0746', 2);
INSERT INTO `district` VALUES (2179, '祁阳', 317, 'q', 'qy', 'qiyang', '', '县', '431121', '0746', 3);
INSERT INTO `district` VALUES (2180, '东安', 317, 'd', 'da', 'dongan', '', '县', '431122', '0746', 4);
INSERT INTO `district` VALUES (2181, '双牌', 317, 's', 'sp', 'shuangpai', '', '县', '431123', '0746', 5);
INSERT INTO `district` VALUES (2182, '道县', 317, 'd', 'dx', 'daoxian', '', '', '431124', '0746', 6);
INSERT INTO `district` VALUES (2183, '江永', 317, 'j', 'jy', 'jiangyong', '', '县', '431125', '0746', 7);
INSERT INTO `district` VALUES (2184, '宁远', 317, 'n', 'ny', 'ningyuan', '', '县', '431126', '0746', 8);
INSERT INTO `district` VALUES (2185, '蓝山', 317, 'l', 'ls', 'lanshan', '', '县', '431127', '0746', 9);
INSERT INTO `district` VALUES (2186, '新田', 317, 'x', 'xt', 'xintian', '', '县', '431128', '0746', 10);
INSERT INTO `district` VALUES (2187, '江华', 317, 'j', 'jh', 'jianghua', '瑶族', '自治县', '431129', '0746', 11);
INSERT INTO `district` VALUES (2188, '鹤城', 318, 'h', 'hc', 'hecheng', '', '区', '431202', '0745', 1);
INSERT INTO `district` VALUES (2189, '中方', 318, 'z', 'zf', 'zhongfang', '', '县', '431221', '0745', 2);
INSERT INTO `district` VALUES (2190, '沅陵', 318, 'y', 'yl', 'yuanling', '', '县', '431222', '0745', 3);
INSERT INTO `district` VALUES (2191, '辰溪', 318, 'c', 'cx', 'chenxi', '', '县', '431223', '0745', 4);
INSERT INTO `district` VALUES (2192, '溆浦', 318, 'x', 'xp', 'xupu', '', '县', '431224', '0745', 5);
INSERT INTO `district` VALUES (2193, '会同', 318, 'h', 'ht', 'huitong', '', '县', '431225', '0745', 6);
INSERT INTO `district` VALUES (2194, '麻阳', 318, 'm', 'my', 'mayang', '苗族', '自治县', '431226', '0745', 7);
INSERT INTO `district` VALUES (2195, '新晃', 318, 'x', 'xh', 'xinhuang', '侗族', '自治县', '431227', '0745', 8);
INSERT INTO `district` VALUES (2196, '芷江', 318, 'z', 'zj', 'zhijiang', '侗族', '自治县', '431228', '0745', 9);
INSERT INTO `district` VALUES (2197, '靖州', 318, 'j', 'jz', 'jingzhou', '苗族侗族', '自治县', '431229', '0745', 10);
INSERT INTO `district` VALUES (2198, '通道', 318, 't', 'td', 'tongdao', '侗族', '自治县', '431230', '0745', 11);
INSERT INTO `district` VALUES (2199, '洪江', 318, 'h', 'hj', 'hongjiang', '', '市', '431281', '0745', 12);
INSERT INTO `district` VALUES (2200, '娄星', 319, 'l', 'lx', 'louxing', '', '区', '431302', '0738', 1);
INSERT INTO `district` VALUES (2201, '双峰', 319, 's', 'sf', 'shuangfeng', '', '县', '431321', '0738', 2);
INSERT INTO `district` VALUES (2202, '新化', 319, 'x', 'xh', 'xinhua', '', '县', '431322', '0738', 3);
INSERT INTO `district` VALUES (2203, '冷水江', 319, 'l', 'lsj', 'lengshuijiang', '', '市', '431381', '0738', 4);
INSERT INTO `district` VALUES (2204, '涟源', 319, 'l', 'ly', 'lianyuan', '', '市', '431382', '0738', 5);
INSERT INTO `district` VALUES (2205, '吉首', 320, 'j', 'js', 'jishou', '', '市', '433101', '0743', 1);
INSERT INTO `district` VALUES (2206, '泸溪', 320, 'l', 'lx', 'luxi', '', '县', '433122', '0743', 2);
INSERT INTO `district` VALUES (2207, '凤凰', 320, 'f', 'fh', 'fenghuang', '', '县', '433123', '0743', 3);
INSERT INTO `district` VALUES (2208, '花垣', 320, 'h', 'hy', 'huayuan', '', '县', '433124', '0743', 4);
INSERT INTO `district` VALUES (2209, '保靖', 320, 'b', 'bj', 'baojing', '', '县', '433125', '0743', 5);
INSERT INTO `district` VALUES (2210, '古丈', 320, 'g', 'gz', 'guzhang', '', '县', '433126', '0743', 6);
INSERT INTO `district` VALUES (2211, '永顺', 320, 'y', 'ys', 'yongshun', '', '县', '433127', '0743', 7);
INSERT INTO `district` VALUES (2212, '龙山', 320, 'l', 'ls', 'longshan', '', '县', '433130', '0743', 8);
INSERT INTO `district` VALUES (2213, '荔湾', 321, 'l', 'lw', 'liwan', '', '区', '440103', '020', 1);
INSERT INTO `district` VALUES (2214, '越秀', 321, 'y', 'yx', 'yuexiu', '', '区', '440104', '020', 2);
INSERT INTO `district` VALUES (2215, '海珠', 321, 'h', 'hz', 'haizhu', '', '区', '440105', '020', 3);
INSERT INTO `district` VALUES (2216, '天河', 321, 't', 'th', 'tianhe', '', '区', '440106', '020', 4);
INSERT INTO `district` VALUES (2217, '白云', 321, 'b', 'by', 'baiyun', '', '区', '440111', '020', 5);
INSERT INTO `district` VALUES (2218, '黄埔', 321, 'h', 'hp', 'huangpu', '', '区', '440112', '020', 6);
INSERT INTO `district` VALUES (2219, '番禺', 321, 'f', 'fy', 'fanyu', '', '区', '440113', '020', 7);
INSERT INTO `district` VALUES (2220, '花都', 321, 'h', 'hd', 'huadu', '', '区', '440114', '020', 8);
INSERT INTO `district` VALUES (2221, '南沙', 321, 'n', 'ns', 'nansha', '', '区', '440115', '020', 9);
INSERT INTO `district` VALUES (2223, '增城', 321, 'z', 'zc', 'zengcheng', '', '区', '440118', '020', 12);
INSERT INTO `district` VALUES (2224, '从化', 321, 'c', 'ch', 'conghua', '', '区', '440117', '020', 11);
INSERT INTO `district` VALUES (2225, '武江', 322, 'w', 'wj', 'wujiang', '', '区', '440203', '0751', 1);
INSERT INTO `district` VALUES (2226, '浈江', 322, 'z', 'zj', 'zhenjiang', '', '区', '440204', '0751', 2);
INSERT INTO `district` VALUES (2227, '曲江', 322, 'q', 'qj', 'qujiang', '', '区', '440205', '0751', 3);
INSERT INTO `district` VALUES (2228, '始兴', 322, 's', 'sx', 'shixing', '', '县', '440222', '0751', 4);
INSERT INTO `district` VALUES (2229, '仁化', 322, 'r', 'rh', 'renhua', '', '县', '440224', '0751', 5);
INSERT INTO `district` VALUES (2230, '翁源', 322, 'w', 'wy', 'wengyuan', '', '县', '440229', '0751', 6);
INSERT INTO `district` VALUES (2231, '乳源', 322, 'r', 'ry', 'ruyuan', '瑶族', '自治县', '440232', '0751', 7);
INSERT INTO `district` VALUES (2232, '新丰', 322, 'x', 'xf', 'xinfeng', '', '县', '440233', '0751', 8);
INSERT INTO `district` VALUES (2233, '乐昌', 322, 'l', 'lc', 'lechang', '', '市', '440281', '0751', 9);
INSERT INTO `district` VALUES (2234, '南雄', 322, 'n', 'nx', 'nanxiong', '', '市', '440282', '0751', 10);
INSERT INTO `district` VALUES (2235, '罗湖', 323, 'l', 'lh', 'luohu', '', '区', '440303', '0755', 1);
INSERT INTO `district` VALUES (2236, '福田', 323, 'f', 'ft', 'futian', '', '区', '440304', '0755', 2);
INSERT INTO `district` VALUES (2237, '南山', 323, 'n', 'ns', 'nanshan', '', '区', '440305', '0755', 3);
INSERT INTO `district` VALUES (2238, '宝安', 323, 'b', 'ba', 'baoan', '', '区', '440306', '0755', 4);
INSERT INTO `district` VALUES (2239, '龙岗', 323, 'l', 'lg', 'longgang', '', '区', '440307', '0755', 5);
INSERT INTO `district` VALUES (2240, '盐田', 323, 'y', 'yt', 'yantian', '', '区', '440308', '0755', 6);
INSERT INTO `district` VALUES (2241, '香洲', 324, 'x', 'xz', 'xiangzhou', '', '区', '440402', '0756', 1);
INSERT INTO `district` VALUES (2242, '斗门', 324, 'd', 'dm', 'doumen', '', '区', '440403', '0756', 2);
INSERT INTO `district` VALUES (2243, '金湾', 324, 'j', 'jw', 'jinwan', '', '区', '440404', '0756', 3);
INSERT INTO `district` VALUES (2244, '龙湖', 325, 'l', 'lh', 'longhu', '', '区', '440507', '0754', 1);
INSERT INTO `district` VALUES (2245, '金平', 325, 'j', 'jp', 'jinping', '', '区', '440511', '0754', 2);
INSERT INTO `district` VALUES (2246, '濠江', 325, 'h', 'hj', 'haojiang', '', '区', '440512', '0754', 3);
INSERT INTO `district` VALUES (2247, '潮阳', 325, 'c', 'cy', 'chaoyang', '', '区', '440513', '0754', 4);
INSERT INTO `district` VALUES (2248, '潮南', 325, 'c', 'cn', 'chaonan', '', '区', '440514', '0754', 5);
INSERT INTO `district` VALUES (2249, '澄海', 325, 'c', 'ch', 'chenghai', '', '区', '440515', '0754', 6);
INSERT INTO `district` VALUES (2250, '南澳', 325, 'n', 'na', 'nanao', '', '县', '440523', '0754', 7);
INSERT INTO `district` VALUES (2251, '禅城', 326, 's', 'sc', 'shancheng', '', '区', '440604', '0757', 1);
INSERT INTO `district` VALUES (2252, '南海', 326, 'n', 'nh', 'nanhai', '', '区', '440605', '0757', 2);
INSERT INTO `district` VALUES (2253, '顺德', 326, 's', 'sd', 'shunde', '', '区', '440606', '0757', 3);
INSERT INTO `district` VALUES (2254, '三水', 326, 's', 'ss', 'sanshui', '', '区', '440607', '0757', 4);
INSERT INTO `district` VALUES (2255, '高明', 326, 'g', 'gm', 'gaoming', '', '区', '440608', '0757', 5);
INSERT INTO `district` VALUES (2256, '蓬江', 327, 'p', 'pj', 'pengjiang', '', '区', '440703', '0750', 1);
INSERT INTO `district` VALUES (2257, '江海', 327, 'j', 'jh', 'jianghai', '', '区', '440704', '0750', 2);
INSERT INTO `district` VALUES (2258, '新会', 327, 'x', 'xh', 'xinhui', '', '区', '440705', '0750', 3);
INSERT INTO `district` VALUES (2259, '台山', 327, 't', 'ts', 'taishan', '', '市', '440781', '0750', 4);
INSERT INTO `district` VALUES (2260, '开平', 327, 'k', 'kp', 'kaiping', '', '市', '440783', '0750', 5);
INSERT INTO `district` VALUES (2261, '鹤山', 327, 'h', 'hs', 'heshan', '', '市', '440784', '0750', 6);
INSERT INTO `district` VALUES (2262, '恩平', 327, 'e', 'ep', 'enping', '', '市', '440785', '0750', 7);
INSERT INTO `district` VALUES (2263, '赤坎', 328, 'c', 'ck', 'chikan', '', '区', '440802', '0759', 1);
INSERT INTO `district` VALUES (2264, '霞山', 328, 'x', 'xs', 'xiashan', '', '区', '440803', '0759', 2);
INSERT INTO `district` VALUES (2265, '坡头', 328, 'p', 'pt', 'potou', '', '区', '440804', '0759', 3);
INSERT INTO `district` VALUES (2266, '麻章', 328, 'm', 'mz', 'mazhang', '', '区', '440811', '0759', 4);
INSERT INTO `district` VALUES (2267, '遂溪', 328, 's', 'sx', 'suixi', '', '县', '440823', '0759', 5);
INSERT INTO `district` VALUES (2268, '徐闻', 328, 'x', 'xw', 'xuwen', '', '县', '440825', '0759', 6);
INSERT INTO `district` VALUES (2269, '廉江', 328, 'l', 'lj', 'lianjiang', '', '市', '440881', '0759', 7);
INSERT INTO `district` VALUES (2270, '雷州', 328, 'l', 'lz', 'leizhou', '', '市', '440882', '0759', 8);
INSERT INTO `district` VALUES (2271, '吴川', 328, 'w', 'wc', 'wuchuan', '', '市', '440883', '0759', 9);
INSERT INTO `district` VALUES (2272, '茂南', 329, 'm', 'mn', 'maonan', '', '区', '440902', '0668', 1);
INSERT INTO `district` VALUES (2274, '电白', 329, 'd', 'db', 'dianbai', '', '区', '440904', '0668', 2);
INSERT INTO `district` VALUES (2275, '高州', 329, 'g', 'gz', 'gaozhou', '', '市', '440981', '0668', 3);
INSERT INTO `district` VALUES (2276, '化州', 329, 'h', 'hz', 'huazhou', '', '市', '440982', '0668', 4);
INSERT INTO `district` VALUES (2277, '信宜', 329, 'x', 'xy', 'xinyi', '', '市', '440983', '0668', 5);
INSERT INTO `district` VALUES (2278, '端州', 330, 'd', 'dz', 'duanzhou', '', '区', '441202', '0758', 1);
INSERT INTO `district` VALUES (2279, '鼎湖', 330, 'd', 'dh', 'dinghu', '', '区', '441203', '0758', 2);
INSERT INTO `district` VALUES (2280, '广宁', 330, 'g', 'gn', 'guangning', '', '县', '441223', '0758', 3);
INSERT INTO `district` VALUES (2281, '怀集', 330, 'h', 'hj', 'huaiji', '', '县', '441224', '0758', 4);
INSERT INTO `district` VALUES (2282, '封开', 330, 'f', 'fk', 'fengkai', '', '县', '441225', '0758', 5);
INSERT INTO `district` VALUES (2283, '德庆', 330, 'd', 'dq', 'deqing', '', '县', '441226', '0758', 6);
INSERT INTO `district` VALUES (2284, '高要', 330, 'g', 'gy', 'gaoyao', '', '区', '441283', '0758', 7);
INSERT INTO `district` VALUES (2285, '四会', 330, 's', 'sh', 'sihui', '', '市', '441284', '0758', 8);
INSERT INTO `district` VALUES (2286, '惠城', 331, 'h', 'hc', 'huicheng', '', '区', '441302', '0752', 1);
INSERT INTO `district` VALUES (2287, '惠阳', 331, 'h', 'hy', 'huiyang', '', '区', '441303', '0752', 2);
INSERT INTO `district` VALUES (2288, '博罗', 331, 'b', 'bl', 'boluo', '', '县', '441322', '0752', 3);
INSERT INTO `district` VALUES (2289, '惠东', 331, 'h', 'hd', 'huidong', '', '县', '441323', '0752', 4);
INSERT INTO `district` VALUES (2290, '龙门', 331, 'l', 'lm', 'longmen', '', '县', '441324', '0752', 5);
INSERT INTO `district` VALUES (2291, '梅江', 332, 'm', 'mj', 'meijiang', '', '区', '441402', '0753', 1);
INSERT INTO `district` VALUES (2292, '梅县', 332, 'm', 'mx', 'meixian', '', '区', '441403', '0753', 2);
INSERT INTO `district` VALUES (2293, '大埔', 332, 'd', 'dp', 'dapu', '', '县', '441422', '0753', 3);
INSERT INTO `district` VALUES (2294, '丰顺', 332, 'f', 'fs', 'fengshun', '', '县', '441423', '0753', 4);
INSERT INTO `district` VALUES (2295, '五华', 332, 'w', 'wh', 'wuhua', '', '县', '441424', '0753', 5);
INSERT INTO `district` VALUES (2296, '平远', 332, 'p', 'py', 'pingyuan', '', '县', '441426', '0753', 6);
INSERT INTO `district` VALUES (2297, '蕉岭', 332, 'j', 'jl', 'jiaoling', '', '县', '441427', '0753', 7);
INSERT INTO `district` VALUES (2298, '兴宁', 332, 'x', 'xn', 'xingning', '', '市', '441481', '0753', 8);
INSERT INTO `district` VALUES (2299, '城区', 333, 'c', 'cq', 'chengqu', '', '区', '441502', '0660', 1);
INSERT INTO `district` VALUES (2300, '海丰', 333, 'h', 'hf', 'haifeng', '', '县', '441521', '0660', 2);
INSERT INTO `district` VALUES (2301, '陆河', 333, 'l', 'lh', 'luhe', '', '县', '441523', '0660', 3);
INSERT INTO `district` VALUES (2302, '陆丰', 333, 'l', 'lf', 'lufeng', '', '市', '441581', '0660', 4);
INSERT INTO `district` VALUES (2303, '源城', 334, 'y', 'yc', 'yuancheng', '', '区', '441602', '0762', 1);
INSERT INTO `district` VALUES (2304, '紫金', 334, 'z', 'zj', 'zijin', '', '县', '441621', '0762', 2);
INSERT INTO `district` VALUES (2305, '龙川', 334, 'l', 'lc', 'longchuan', '', '县', '441622', '0762', 3);
INSERT INTO `district` VALUES (2306, '连平', 334, 'l', 'lp', 'lianping', '', '县', '441623', '0762', 4);
INSERT INTO `district` VALUES (2307, '和平', 334, 'h', 'hp', 'heping', '', '县', '441624', '0762', 5);
INSERT INTO `district` VALUES (2308, '东源', 334, 'd', 'dy', 'dongyuan', '', '县', '441625', '0762', 6);
INSERT INTO `district` VALUES (2309, '江城', 335, 'j', 'jc', 'jiangcheng', '', '区', '441702', '0662', 1);
INSERT INTO `district` VALUES (2310, '阳西', 335, 'y', 'yx', 'yangxi', '', '县', '441721', '0662', 2);
INSERT INTO `district` VALUES (2311, '阳东', 335, 'y', 'yd', 'yangdong', '', '区', '441723', '0662', 3);
INSERT INTO `district` VALUES (2312, '阳春', 335, 'y', 'yc', 'yangchun', '', '市', '441781', '0662', 4);
INSERT INTO `district` VALUES (2313, '清城', 336, 'q', 'qc', 'qingcheng', '', '区', '441802', '0763', 1);
INSERT INTO `district` VALUES (2314, '佛冈', 336, 'f', 'fg', 'fogang', '', '县', '441821', '0763', 2);
INSERT INTO `district` VALUES (2315, '阳山', 336, 'y', 'ys', 'yangshan', '', '县', '441823', '0763', 3);
INSERT INTO `district` VALUES (2316, '连山', 336, 'l', 'ls', 'lianshan', '壮族瑶族', '自治县', '441825', '0763', 4);
INSERT INTO `district` VALUES (2317, '连南', 336, 'l', 'ln', 'liannan', '瑶族', '自治县', '441826', '0763', 5);
INSERT INTO `district` VALUES (2318, '清新', 336, 'q', 'qx', 'qingxin', '', '县', '441827', '0763', 6);
INSERT INTO `district` VALUES (2319, '英德', 336, 'y', 'yd', 'yingde', '', '市', '441881', '0763', 7);
INSERT INTO `district` VALUES (2320, '连州', 336, 'l', 'lz', 'lianzhou', '', '市', '441882', '0763', 8);
INSERT INTO `district` VALUES (2321, '湘桥', 339, 'x', 'xq', 'xiangqiao', '', '区', '445102', '0768', 1);
INSERT INTO `district` VALUES (2322, '潮安', 339, 'c', 'ca', 'chaoan', '', '区', '445121', '0768', 2);
INSERT INTO `district` VALUES (2323, '饶平', 339, 'r', 'rp', 'raoping', '', '县', '445122', '0768', 3);
INSERT INTO `district` VALUES (2324, '榕城', 340, 'r', 'rc', 'rongcheng', '', '区', '445202', '0663', 1);
INSERT INTO `district` VALUES (2325, '揭东', 340, 'j', 'jd', 'jiedong', '', '县', '445221', '0663', 2);
INSERT INTO `district` VALUES (2326, '揭西', 340, 'j', 'jx', 'jiexi', '', '县', '445222', '0663', 3);
INSERT INTO `district` VALUES (2327, '惠来', 340, 'h', 'hl', 'huilai', '', '县', '445224', '0663', 4);
INSERT INTO `district` VALUES (2328, '普宁', 340, 'p', 'pn', 'puning', '', '市', '445281', '0663', 5);
INSERT INTO `district` VALUES (2329, '云城', 341, 'y', 'yc', 'yuncheng', '', '区', '445302', '0766', 1);
INSERT INTO `district` VALUES (2330, '新兴', 341, 'x', 'xx', 'xinxing', '', '县', '445321', '0766', 3);
INSERT INTO `district` VALUES (2331, '郁南', 341, 'y', 'yn', 'yunan', '', '县', '445322', '0766', 4);
INSERT INTO `district` VALUES (2332, '云安', 341, 'y', 'ya', 'yunan', '', '区', '445302', '0766', 2);
INSERT INTO `district` VALUES (2333, '罗定', 341, 'l', 'ld', 'luoding', '', '市', '445381', '0766', 5);
INSERT INTO `district` VALUES (2334, '兴宁', 342, 'x', 'xn', 'xingning', '', '区', '450102', '0771', 1);
INSERT INTO `district` VALUES (2335, '青秀', 342, 'q', 'qx', 'qingxiu', '', '区', '450103', '0771', 2);
INSERT INTO `district` VALUES (2336, '江南', 342, 'j', 'jn', 'jiangnan', '', '区', '450105', '0771', 3);
INSERT INTO `district` VALUES (2337, '西乡塘', 342, 'x', 'xxt', 'xixiangtang', '', '区', '450107', '0771', 4);
INSERT INTO `district` VALUES (2338, '良庆', 342, 'l', 'lq', 'liangqing', '', '区', '450108', '0771', 5);
INSERT INTO `district` VALUES (2339, '邕宁', 342, 'y', 'yn', 'yongning', '', '区', '450109', '0771', 6);
INSERT INTO `district` VALUES (2340, '武鸣', 342, 'w', 'wm', 'wuming', '', '区', '450122', '0771', 7);
INSERT INTO `district` VALUES (2341, '隆安', 342, 'l', 'la', 'longan', '', '县', '450123', '0771', 8);
INSERT INTO `district` VALUES (2342, '马山', 342, 'm', 'ms', 'mashan', '', '县', '450124', '0771', 9);
INSERT INTO `district` VALUES (2343, '上林', 342, 's', 'sl', 'shanglin', '', '县', '450125', '0771', 10);
INSERT INTO `district` VALUES (2344, '宾阳', 342, 'b', 'by', 'binyang', '', '县', '450126', '0771', 11);
INSERT INTO `district` VALUES (2345, '横县', 342, 'h', 'hx', 'hengxian', '', '', '450127', '0771', 12);
INSERT INTO `district` VALUES (2346, '城中', 343, 'c', 'cz', 'chengzhong', '', '区', '450202', '0772', 1);
INSERT INTO `district` VALUES (2347, '鱼峰', 343, 'y', 'yf', 'yufeng', '', '区', '450203', '0772', 2);
INSERT INTO `district` VALUES (2348, '柳南', 343, 'l', 'ln', 'liunan', '', '区', '450204', '0772', 3);
INSERT INTO `district` VALUES (2349, '柳北', 343, 'l', 'lb', 'liubei', '', '区', '450205', '0772', 4);
INSERT INTO `district` VALUES (2350, '柳江', 343, 'l', 'lj', 'liujiang', '', '区', '450206', '0772', 5);
INSERT INTO `district` VALUES (2351, '柳城', 343, 'l', 'lc', 'liucheng', '', '县', '450222', '0772', 6);
INSERT INTO `district` VALUES (2352, '鹿寨', 343, 'l', 'lz', 'luzhai', '', '县', '450223', '0772', 7);
INSERT INTO `district` VALUES (2353, '融安', 343, 'r', 'ra', 'rongan', '', '县', '450224', '0772', 8);
INSERT INTO `district` VALUES (2354, '融水', 343, 'r', 'rs', 'rongshui', '苗族', '自治县', '450225', '0772', 9);
INSERT INTO `district` VALUES (2355, '三江', 343, 's', 'sj', 'sanjiang', '侗族', '自治县', '450226', '0772', 10);
INSERT INTO `district` VALUES (2356, '秀峰', 344, 'x', 'xf', 'xiufeng', '', '区', '450302', '0773', 1);
INSERT INTO `district` VALUES (2357, '叠彩', 344, 'd', 'dc', 'diecai', '', '区', '450303', '0773', 2);
INSERT INTO `district` VALUES (2358, '象山', 344, 'x', 'xs', 'xiangshan', '', '区', '450304', '0773', 3);
INSERT INTO `district` VALUES (2359, '七星', 344, 'q', 'qx', 'qixing', '', '区', '450305', '0773', 4);
INSERT INTO `district` VALUES (2360, '雁山', 344, 'y', 'ys', 'yanshan', '', '区', '450311', '0773', 5);
INSERT INTO `district` VALUES (2361, '阳朔', 344, 'y', 'ys', 'yangshuo', '', '县', '450321', '0773', 6);
INSERT INTO `district` VALUES (2362, '临桂', 344, 'l', 'lg', 'lingui', '', '区', '450322', '0773', 7);
INSERT INTO `district` VALUES (2363, '灵川', 344, 'l', 'lc', 'lingchuan', '', '县', '450323', '0773', 8);
INSERT INTO `district` VALUES (2364, '全州', 344, 'q', 'qz', 'quanzhou', '', '县', '450324', '0773', 9);
INSERT INTO `district` VALUES (2365, '兴安', 344, 'x', 'xa', 'xingan', '', '县', '450325', '0773', 10);
INSERT INTO `district` VALUES (2366, '永福', 344, 'y', 'yf', 'yongfu', '', '县', '450326', '0773', 11);
INSERT INTO `district` VALUES (2367, '灌阳', 344, 'g', 'gy', 'guanyang', '', '县', '450327', '0773', 12);
INSERT INTO `district` VALUES (2368, '龙胜', 344, 'l', 'ls', 'longsheng', '各族', '自治县', '450328', '0773', 13);
INSERT INTO `district` VALUES (2369, '资源', 344, 'z', 'zy', 'ziyuan', '', '县', '450329', '0773', 14);
INSERT INTO `district` VALUES (2370, '平乐', 344, 'p', 'pl', 'pingle', '', '县', '450330', '0773', 15);
INSERT INTO `district` VALUES (2371, '荔浦', 344, 'l', 'lp', 'lipu', '', '市', '450331', '0773', 16);
INSERT INTO `district` VALUES (2372, '恭城', 344, 'g', 'gc', 'gongcheng', '瑶族', '自治县', '450332', '0773', 17);
INSERT INTO `district` VALUES (2373, '龙圩', 345, 'l', 'lw', 'longwei', '', '区', '', '0774', 1);
INSERT INTO `district` VALUES (2374, '万秀', 345, 'w', 'wx', 'wanxiu', '', '区', '450403', '0774', 2);
INSERT INTO `district` VALUES (2375, '长洲', 345, 'c', 'cz', 'changzhou', '', '区', '450405', '0774', 3);
INSERT INTO `district` VALUES (2376, '苍梧', 345, 'c', 'cw', 'cangwu', '', '县', '450421', '0774', 4);
INSERT INTO `district` VALUES (2377, '藤县', 345, 't', 'tx', 'tengxian', '', '', '450422', '0774', 5);
INSERT INTO `district` VALUES (2378, '蒙山', 345, 'm', 'ms', 'mengshan', '', '县', '450423', '0774', 6);
INSERT INTO `district` VALUES (2379, '岑溪', 345, 'c', 'cx', 'cenxi', '', '市', '450481', '0774', 7);
INSERT INTO `district` VALUES (2380, '海城', 346, 'h', 'hc', 'haicheng', '', '区', '450502', '0779', 1);
INSERT INTO `district` VALUES (2381, '银海', 346, 'y', 'yh', 'yinhai', '', '区', '450503', '0779', 2);
INSERT INTO `district` VALUES (2382, '铁山港', 346, 't', 'tsg', 'tieshangang', '', '区', '450512', '0779', 3);
INSERT INTO `district` VALUES (2383, '合浦', 346, 'h', 'hp', 'hepu', '', '县', '450521', '0779', 4);
INSERT INTO `district` VALUES (2384, '港口', 347, 'g', 'gk', 'gangkou', '', '区', '450602', '0770', 1);
INSERT INTO `district` VALUES (2385, '防城', 347, 'f', 'fc', 'fangcheng', '', '区', '450603', '0770', 2);
INSERT INTO `district` VALUES (2386, '上思', 347, 's', 'ss', 'shangsi', '', '县', '450621', '0770', 3);
INSERT INTO `district` VALUES (2387, '东兴', 347, 'd', 'dx', 'dongxing', '', '市', '450681', '0770', 4);
INSERT INTO `district` VALUES (2388, '钦南', 348, 'q', 'qn', 'qinnan', '', '区', '450702', '0777', 1);
INSERT INTO `district` VALUES (2389, '钦北', 348, 'q', 'qb', 'qinbei', '', '区', '450703', '0777', 2);
INSERT INTO `district` VALUES (2390, '灵山', 348, 'l', 'ls', 'lingshan', '', '县', '450721', '0777', 3);
INSERT INTO `district` VALUES (2391, '浦北', 348, 'p', 'pb', 'pubei', '', '县', '450722', '0777', 4);
INSERT INTO `district` VALUES (2392, '港北', 349, 'g', 'gb', 'gangbei', '', '区', '450802', '0775', 1);
INSERT INTO `district` VALUES (2393, '港南', 349, 'g', 'gn', 'gangnan', '', '区', '450803', '0775', 2);
INSERT INTO `district` VALUES (2394, '覃塘', 349, 't', 'tt', 'tantang', '', '区', '450804', '0775', 3);
INSERT INTO `district` VALUES (2395, '桂平', 349, 'g', 'gp', 'guiping', '', '市', '450821', '0775', 4);
INSERT INTO `district` VALUES (2396, '平南', 349, 'p', 'pn', 'pingnan', '', '县', '450881', '0775', 5);
INSERT INTO `district` VALUES (2397, '玉州', 350, 'y', 'yz', 'yuzhou', '', '区', '450902', '0775', 1);
INSERT INTO `district` VALUES (2398, '容县', 350, 'r', 'rx', 'rongxian', '', '', '450921', '0775', 3);
INSERT INTO `district` VALUES (2399, '陆川', 350, 'l', 'lc', 'luchuan', '', '县', '450922', '0775', 4);
INSERT INTO `district` VALUES (2400, '博白', 350, 'b', 'bb', 'bobai', '', '县', '450923', '0775', 5);
INSERT INTO `district` VALUES (2401, '兴业', 350, 'x', 'xy', 'xingye', '', '县', '450924', '0775', 6);
INSERT INTO `district` VALUES (2402, '北流', 350, 'b', 'bl', 'beiliu', '', '市', '450981', '0775', 7);
INSERT INTO `district` VALUES (2403, '右江', 351, 'y', 'yj', 'youjiang', '', '区', '451002', '0776', 1);
INSERT INTO `district` VALUES (2404, '田阳', 351, 't', 'ty', 'tianyang', '', '区', '451003', '0776', 2);
INSERT INTO `district` VALUES (2405, '田东', 351, 't', 'td', 'tiandong', '', '县', '451022', '0776', 3);
INSERT INTO `district` VALUES (2406, '平果', 351, 'p', 'pg', 'pingguo', '', '市', '451082', '0776', 12);
INSERT INTO `district` VALUES (2407, '德保', 351, 'd', 'db', 'debao', '', '县', '451024', '0776', 4);
INSERT INTO `district` VALUES (2408, '靖西', 351, 'j', 'jx', 'jingxi', '', '市', '451081', '0776', 11);
INSERT INTO `district` VALUES (2409, '那坡', 351, 'n', 'np', 'neipo', '', '县', '451026', '0776', 5);
INSERT INTO `district` VALUES (2410, '凌云', 351, 'l', 'ly', 'lingyun', '', '县', '451027', '0776', 6);
INSERT INTO `district` VALUES (2411, '乐业', 351, 'l', 'ly', 'leye', '', '县', '451028', '0776', 7);
INSERT INTO `district` VALUES (2412, '田林', 351, 't', 'tl', 'tianlin', '', '县', '451029', '0776', 8);
INSERT INTO `district` VALUES (2413, '西林', 351, 'x', 'xl', 'xilin', '', '县', '451030', '0776', 9);
INSERT INTO `district` VALUES (2414, '隆林', 351, 'l', 'll', 'longlin', '各族', '自治县', '451031', '0776', 10);
INSERT INTO `district` VALUES (2415, '八步', 352, 'b', 'bb', 'babu', '', '区', '451102', '0774', 1);
INSERT INTO `district` VALUES (2416, '昭平', 352, 'z', 'zp', 'zhaoping', '', '县', '451121', '0774', 3);
INSERT INTO `district` VALUES (2417, '钟山', 352, 'z', 'zs', 'zhongshan', '', '县', '451122', '0774', 4);
INSERT INTO `district` VALUES (2418, '富川', 352, 'f', 'fc', 'fuchuan', '瑶族', '自治县', '451123', '0774', 5);
INSERT INTO `district` VALUES (2419, '金城江', 353, 'j', 'jcj', 'jinchengjiang', '', '区', '451202', '0778', 1);
INSERT INTO `district` VALUES (2420, '南丹', 353, 'n', 'nd', 'nandan', '', '县', '451221', '0778', 3);
INSERT INTO `district` VALUES (2421, '天峨', 353, 't', 'te', 'tiane', '', '县', '451222', '0778', 4);
INSERT INTO `district` VALUES (2422, '凤山', 353, 'f', 'fs', 'fengshan', '', '县', '451223', '0778', 5);
INSERT INTO `district` VALUES (2423, '东兰', 353, 'd', 'dl', 'donglan', '', '县', '451224', '0778', 6);
INSERT INTO `district` VALUES (2424, '罗城', 353, 'l', 'lc', 'luocheng', '仫佬族', '自治县', '451225', '0778', 7);
INSERT INTO `district` VALUES (2425, '环江', 353, 'h', 'hj', 'huanjiang', '毛南族', '自治县', '451226', '0778', 8);
INSERT INTO `district` VALUES (2426, '巴马', 353, 'b', 'bm', 'bama', '瑶族', '自治县', '451227', '0778', 9);
INSERT INTO `district` VALUES (2427, '都安', 353, 'd', 'da', 'duan', '瑶族', '自治县', '451228', '0778', 10);
INSERT INTO `district` VALUES (2428, '大化', 353, 'd', 'dh', 'dahua', '瑶族', '自治县', '451229', '0778', 11);
INSERT INTO `district` VALUES (2429, '宜州', 353, 'y', 'yz', 'yizhou', '', '区', '451203', '0778', 2);
INSERT INTO `district` VALUES (2430, '兴宾', 354, 'x', 'xb', 'xingbin', '', '区', '451302', '0772', 1);
INSERT INTO `district` VALUES (2431, '忻城', 354, 'x', 'xc', 'xincheng', '', '县', '451321', '0772', 2);
INSERT INTO `district` VALUES (2432, '象州', 354, 'x', 'xz', 'xiangzhou', '', '县', '451322', '0772', 3);
INSERT INTO `district` VALUES (2433, '武宣', 354, 'w', 'wx', 'wuxuan', '', '县', '451323', '0772', 4);
INSERT INTO `district` VALUES (2434, '金秀', 354, 'j', 'jx', 'jinxiu', '瑶族', '自治县', '451324', '0772', 5);
INSERT INTO `district` VALUES (2435, '合山', 354, 'h', 'hs', 'heshan', '', '市', '451381', '0772', 6);
INSERT INTO `district` VALUES (2436, '江州', 355, 'j', 'jz', 'jiangzhou', '', '区', '451402', '0771', 1);
INSERT INTO `district` VALUES (2437, '扶绥', 355, 'f', 'fs', 'fusui', '', '县', '451421', '0771', 2);
INSERT INTO `district` VALUES (2438, '宁明', 355, 'n', 'nm', 'ningming', '', '县', '451422', '0771', 3);
INSERT INTO `district` VALUES (2439, '龙州', 355, 'l', 'lz', 'longzhou', '', '县', '451423', '0771', 4);
INSERT INTO `district` VALUES (2440, '大新', 355, 'd', 'dx', 'daxin', '', '县', '451424', '0771', 5);
INSERT INTO `district` VALUES (2441, '天等', 355, 't', 'td', 'tiandeng', '', '县', '451425', '0771', 6);
INSERT INTO `district` VALUES (2442, '凭祥', 355, 'p', 'px', 'pingxiang', '', '市', '451481', '0771', 7);
INSERT INTO `district` VALUES (2443, '秀英', 356, 'x', 'xy', 'xiuying', '', '区', '460105', '0898', 1);
INSERT INTO `district` VALUES (2444, '龙华', 356, 'l', 'lh', 'longhua', '', '区', '460106', '0898', 2);
INSERT INTO `district` VALUES (2445, '琼山', 356, 'q', 'qs', 'qiongshan', '', '区', '460107', '0898', 3);
INSERT INTO `district` VALUES (2446, '美兰', 356, 'm', 'ml', 'meilan', '', '区', '460108', '0898', 4);
INSERT INTO `district` VALUES (2447, '锦江', 375, 'j', 'jj', 'jinjiang', '', '区', '510104', '028', 1);
INSERT INTO `district` VALUES (2448, '青羊', 375, 'q', 'qy', 'qingyang', '', '区', '510105', '028', 2);
INSERT INTO `district` VALUES (2449, '金牛', 375, 'j', 'jn', 'jinniu', '', '区', '510106', '028', 3);
INSERT INTO `district` VALUES (2450, '武侯', 375, 'w', 'wh', 'wuhou', '', '区', '510107', '028', 4);
INSERT INTO `district` VALUES (2451, '成华', 375, 'c', 'ch', 'chenghua', '', '区', '510108', '028', 5);
INSERT INTO `district` VALUES (2452, '龙泉驿', 375, 'l', 'lqy', 'longquanyi', '', '区', '510112', '028', 6);
INSERT INTO `district` VALUES (2453, '青白江', 375, 'q', 'qbj', 'qingbaijiang', '', '区', '510113', '028', 7);
INSERT INTO `district` VALUES (2454, '新都', 375, 'x', 'xd', 'xindu', '', '区', '510114', '028', 8);
INSERT INTO `district` VALUES (2455, '温江', 375, 'w', 'wj', 'wenjiang', '', '区', '510115', '028', 9);
INSERT INTO `district` VALUES (2456, '金堂', 375, 'j', 'jt', 'jintang', '', '县', '510121', '028', 12);
INSERT INTO `district` VALUES (2457, '双流', 375, 's', 'sl', 'shuangliu', '', '区', '510116', '028', 10);
INSERT INTO `district` VALUES (2458, '郫都', 375, 'p', 'pd', 'pidu', '', '区', '510117', '028', 11);
INSERT INTO `district` VALUES (2459, '大邑', 375, 'd', 'dy', 'dayi', '', '县', '510129', '028', 13);
INSERT INTO `district` VALUES (2460, '蒲江', 375, 'p', 'pj', 'pujiang', '', '县', '510131', '028', 14);
INSERT INTO `district` VALUES (2461, '新津', 375, 'x', 'xj', 'xinjin', '', '县', '510132', '028', 15);
INSERT INTO `district` VALUES (2462, '都江堰', 375, 'd', 'djy', 'dujiangyan', '', '市', '510181', '028', 16);
INSERT INTO `district` VALUES (2463, '彭州', 375, 'p', 'pz', 'pengzhou', '', '市', '510182', '028', 17);
INSERT INTO `district` VALUES (2464, '邛崃', 375, 'q', 'ql', 'qionglai', '', '市', '510183', '028', 18);
INSERT INTO `district` VALUES (2465, '崇州', 375, 'c', 'cz', 'chongzhou', '', '市', '510184', '028', 19);
INSERT INTO `district` VALUES (2466, '自流井', 376, 'z', 'zlj', 'ziliujing', '', '区', '510302', '0813', 1);
INSERT INTO `district` VALUES (2467, '贡井', 376, 'g', 'gj', 'gongjing', '', '区', '510303', '0813', 2);
INSERT INTO `district` VALUES (2468, '大安', 376, 'd', 'da', 'daan', '', '区', '510304', '0813', 3);
INSERT INTO `district` VALUES (2469, '沿滩', 376, 'y', 'yt', 'yantan', '', '区', '510311', '0813', 4);
INSERT INTO `district` VALUES (2470, '荣县', 376, 'r', 'rx', 'rongxian', '', '', '510321', '0813', 5);
INSERT INTO `district` VALUES (2471, '富顺', 376, 'f', 'fs', 'fushun', '', '县', '510322', '0813', 6);
INSERT INTO `district` VALUES (2472, '东区', 377, 'd', 'dq', 'dongqu', '', '', '510402', '0812', 1);
INSERT INTO `district` VALUES (2473, '西区', 377, 'x', 'xq', 'xiqu', '', '', '510403', '0812', 2);
INSERT INTO `district` VALUES (2474, '仁和', 377, 'r', 'rh', 'renhe', '', '区', '510411', '0812', 3);
INSERT INTO `district` VALUES (2475, '米易', 377, 'm', 'my', 'miyi', '', '县', '510421', '0812', 4);
INSERT INTO `district` VALUES (2476, '盐边', 377, 'y', 'yb', 'yanbian', '', '县', '510422', '0812', 5);
INSERT INTO `district` VALUES (2477, '江阳', 378, 'j', 'jy', 'jiangyang', '', '区', '510502', '0830', 1);
INSERT INTO `district` VALUES (2478, '纳溪', 378, 'n', 'nx', 'naxi', '', '区', '510503', '0830', 2);
INSERT INTO `district` VALUES (2479, '龙马潭', 378, 'l', 'lmt', 'longmatan', '', '区', '510504', '0830', 3);
INSERT INTO `district` VALUES (2480, '泸县', 378, 'l', 'lx', 'luxian', '', '', '510521', '0830', 4);
INSERT INTO `district` VALUES (2481, '合江', 378, 'h', 'hj', 'hejiang', '', '县', '510522', '0830', 5);
INSERT INTO `district` VALUES (2482, '叙永', 378, 'x', 'xy', 'xuyong', '', '县', '510524', '0830', 6);
INSERT INTO `district` VALUES (2483, '古蔺', 378, 'g', 'gl', 'gulin', '', '县', '510525', '0830', 7);
INSERT INTO `district` VALUES (2484, '旌阳', 379, 'j', 'jy', 'jingyang', '', '区', '510603', '0838', 1);
INSERT INTO `district` VALUES (2485, '中江', 379, 'z', 'zj', 'zhongjiang', '', '县', '510623', '0838', 3);
INSERT INTO `district` VALUES (2486, '罗江', 379, 'l', 'lj', 'luojiang', '', '区', '510604', '0838', 2);
INSERT INTO `district` VALUES (2487, '广汉', 379, 'g', 'gh', 'guanghan', '', '市', '510681', '0838', 4);
INSERT INTO `district` VALUES (2488, '什邡', 379, 's', 'sf', 'shenfang', '', '市', '510682', '0838', 5);
INSERT INTO `district` VALUES (2489, '绵竹', 379, 'm', 'mz', 'mianzhu', '', '市', '510683', '0838', 6);
INSERT INTO `district` VALUES (2490, '涪城', 380, 'f', 'fc', 'fucheng', '', '区', '510703', '0816', 1);
INSERT INTO `district` VALUES (2491, '游仙', 380, 'y', 'yx', 'youxian', '', '区', '510704', '0816', 2);
INSERT INTO `district` VALUES (2492, '三台', 380, 's', 'st', 'santai', '', '县', '510722', '0816', 4);
INSERT INTO `district` VALUES (2493, '盐亭', 380, 'y', 'yt', 'yanting', '', '县', '510723', '0816', 5);
INSERT INTO `district` VALUES (2494, '安州', 380, 'a', 'az', 'anzhou', '', '区', '510705', '0816', 3);
INSERT INTO `district` VALUES (2495, '梓潼', 380, 'z', 'zt', 'zitong', '', '县', '510725', '0816', 6);
INSERT INTO `district` VALUES (2496, '北川', 380, 'b', 'bc', 'beichuan', '羌族', '自治县', '510726', '0816', 7);
INSERT INTO `district` VALUES (2497, '平武', 380, 'p', 'pw', 'pingwu', '', '县', '510727', '0816', 8);
INSERT INTO `district` VALUES (2498, '江油', 380, 'j', 'jy', 'jiangyou', '', '市', '510781', '0816', 9);
INSERT INTO `district` VALUES (2499, '利州', 381, 'l', 'lz', 'lizhou', '', '区', '510802', '0839', 1);
INSERT INTO `district` VALUES (2500, '昭化', 381, 'z', 'zh', 'zhaohua', '', '区', '510811', '0839', 2);
INSERT INTO `district` VALUES (2501, '朝天', 381, 'c', 'ct', 'chaotian', '', '区', '510812', '0839', 3);
INSERT INTO `district` VALUES (2502, '旺苍', 381, 'w', 'wc', 'wangcang', '', '县', '510821', '0839', 4);
INSERT INTO `district` VALUES (2503, '青川', 381, 'q', 'qc', 'qingchuan', '', '县', '510822', '0839', 5);
INSERT INTO `district` VALUES (2504, '剑阁', 381, 'j', 'jg', 'jiange', '', '县', '510823', '0839', 6);
INSERT INTO `district` VALUES (2505, '苍溪', 381, 'c', 'cx', 'cangxi', '', '县', '510824', '0839', 7);
INSERT INTO `district` VALUES (2506, '船山', 382, 'c', 'cs', 'chuanshan', '', '区', '510903', '0825', 1);
INSERT INTO `district` VALUES (2507, '安居', 382, 'a', 'aj', 'anju', '', '区', '510904', '0825', 2);
INSERT INTO `district` VALUES (2508, '蓬溪', 382, 'p', 'px', 'pengxi', '', '县', '510921', '0825', 3);
INSERT INTO `district` VALUES (2509, '射洪', 382, 's', 'sh', 'shehong', '', '市', '510981', '0825', 5);
INSERT INTO `district` VALUES (2510, '大英', 382, 'd', 'dy', 'daying', '', '县', '510923', '0825', 4);
INSERT INTO `district` VALUES (2511, '市中', 383, 's', 'sz', 'shizhong', '', '区', '511002', '', 1);
INSERT INTO `district` VALUES (2512, '东兴', 383, 'd', 'dx', 'dongxing', '', '区', '511011', '', 2);
INSERT INTO `district` VALUES (2513, '威远', 383, 'w', 'wy', 'weiyuan', '', '县', '511024', '', 3);
INSERT INTO `district` VALUES (2514, '资中', 383, 'z', 'zz', 'zizhong', '', '县', '511025', '', 4);
INSERT INTO `district` VALUES (2515, '隆昌', 383, 'l', 'lc', 'longchang', '', '市', '511083', '', 5);
INSERT INTO `district` VALUES (2516, '市中', 384, 's', 'sz', 'shizhong', '', '区', '511102', '0833', 1);
INSERT INTO `district` VALUES (2517, '沙湾', 384, 's', 'sw', 'shawan', '', '区', '511111', '0833', 2);
INSERT INTO `district` VALUES (2518, '五通桥', 384, 'w', 'wtq', 'wutongqiao', '', '区', '511112', '0833', 3);
INSERT INTO `district` VALUES (2519, '金口河', 384, 'j', 'jkh', 'jinkouhe', '', '区', '511113', '0833', 4);
INSERT INTO `district` VALUES (2520, '犍为', 384, 'j', 'jw', 'jianwei', '', '县', '511123', '0833', 5);
INSERT INTO `district` VALUES (2521, '井研', 384, 'j', 'jy', 'jingyan', '', '县', '511124', '0833', 6);
INSERT INTO `district` VALUES (2522, '夹江', 384, 'j', 'jj', 'jiajiang', '', '县', '511126', '0833', 7);
INSERT INTO `district` VALUES (2523, '沐川', 384, 'm', 'mc', 'muchuan', '', '县', '511129', '0833', 8);
INSERT INTO `district` VALUES (2524, '峨边', 384, 'e', 'eb', 'ebian', '彝族', '自治县', '511132', '0833', 9);
INSERT INTO `district` VALUES (2525, '马边', 384, 'm', 'mb', 'mabian', '彝族', '自治县', '511133', '0833', 10);
INSERT INTO `district` VALUES (2526, '峨眉山', 384, 'e', 'ems', 'emeishan', '', '市', '511181', '0833', 11);
INSERT INTO `district` VALUES (2527, '顺庆', 385, 's', 'sq', 'shunqing', '', '区', '511302', '0817', 1);
INSERT INTO `district` VALUES (2528, '高坪', 385, 'g', 'gp', 'gaoping', '', '区', '511303', '0817', 2);
INSERT INTO `district` VALUES (2529, '嘉陵', 385, 'j', 'jl', 'jialing', '', '区', '511304', '0817', 3);
INSERT INTO `district` VALUES (2530, '南部', 385, 'n', 'nb', 'nanbu', '', '县', '511321', '0817', 4);
INSERT INTO `district` VALUES (2531, '营山', 385, 'y', 'ys', 'yingshan', '', '县', '511322', '0817', 5);
INSERT INTO `district` VALUES (2532, '蓬安', 385, 'p', 'pa', 'pengan', '', '县', '511323', '0817', 6);
INSERT INTO `district` VALUES (2533, '仪陇', 385, 'y', 'yl', 'yilong', '', '县', '511324', '0817', 7);
INSERT INTO `district` VALUES (2534, '西充', 385, 'x', 'xc', 'xichong', '', '县', '511325', '0817', 8);
INSERT INTO `district` VALUES (2535, '阆中', 385, 'l', 'lz', 'langzhong', '', '市', '511381', '0817', 9);
INSERT INTO `district` VALUES (2536, '东坡', 386, 'd', 'dp', 'dongpo', '', '区', '511402', '028', 1);
INSERT INTO `district` VALUES (2537, '仁寿', 386, 'r', 'rs', 'renshou', '', '县', '511421', '028', 2);
INSERT INTO `district` VALUES (2538, '彭山', 386, 'p', 'ps', 'pengshan', '', '区', '511422', '028', 3);
INSERT INTO `district` VALUES (2539, '洪雅', 386, 'h', 'hy', 'hongya', '', '县', '511423', '028', 4);
INSERT INTO `district` VALUES (2540, '丹棱', 386, 'd', 'dl', 'danleng', '', '县', '511424', '028', 5);
INSERT INTO `district` VALUES (2541, '青神', 386, 'q', 'qs', 'qingshen', '', '县', '511425', '028', 6);
INSERT INTO `district` VALUES (2542, '翠屏', 387, 'c', 'cp', 'cuiping', '', '区', '511502', '0831', 1);
INSERT INTO `district` VALUES (2543, '南溪', 387, 'n', 'nx', 'nanxi', '', '区', '511503', '0831', 2);
INSERT INTO `district` VALUES (2544, '叙州', 387, 'x', 'xz', 'xuzhou', '', '区', '511504', '0831', 3);
INSERT INTO `district` VALUES (2545, '江安', 387, 'j', 'ja', 'jiangan', '', '县', '511523', '0831', 4);
INSERT INTO `district` VALUES (2546, '长宁', 387, 'c', 'cn', 'changning', '', '县', '511524', '0831', 5);
INSERT INTO `district` VALUES (2547, '高县', 387, 'g', 'gx', 'gaoxian', '', '', '511525', '0831', 6);
INSERT INTO `district` VALUES (2548, '珙县', 387, 'g', 'gx', 'gongxian', '', '', '511526', '0831', 7);
INSERT INTO `district` VALUES (2549, '筠连', 387, 'y', 'yl', 'yunlian', '', '县', '511527', '0831', 8);
INSERT INTO `district` VALUES (2550, '兴文', 387, 'x', 'xw', 'xingwen', '', '县', '511528', '0831', 9);
INSERT INTO `district` VALUES (2551, '屏山', 387, 'p', 'ps', 'pingshan', '', '县', '511529', '0831', 10);
INSERT INTO `district` VALUES (2552, '广安', 388, 'g', 'ga', 'guangan', '', '区', '511602', '0826', 1);
INSERT INTO `district` VALUES (2553, '岳池', 388, 'y', 'yc', 'yuechi', '', '县', '511621', '0826', 3);
INSERT INTO `district` VALUES (2554, '武胜', 388, 'w', 'ws', 'wusheng', '', '县', '511622', '0826', 4);
INSERT INTO `district` VALUES (2555, '邻水', 388, 'l', 'ls', 'linshui', '', '县', '511623', '0826', 5);
INSERT INTO `district` VALUES (2556, '华蓥', 388, 'h', 'hy', 'huaying', '', '市', '511681', '0826', 6);
INSERT INTO `district` VALUES (2557, '通川', 389, 't', 'tc', 'tongchuan', '', '区', '511702', '0818', 1);
INSERT INTO `district` VALUES (2558, '达川', 389, 'd', 'dc', 'dachuan', '', '区', '511721', '0818', 2);
INSERT INTO `district` VALUES (2559, '宣汉', 389, 'x', 'xh', 'xuanhan', '', '县', '511722', '0818', 3);
INSERT INTO `district` VALUES (2560, '开江', 389, 'k', 'kj', 'kaijiang', '', '县', '511723', '0818', 4);
INSERT INTO `district` VALUES (2561, '大竹', 389, 'd', 'dz', 'dazhu', '', '县', '511724', '0818', 5);
INSERT INTO `district` VALUES (2562, '渠县', 389, 'q', 'qx', 'quxian', '', '', '511725', '0818', 6);
INSERT INTO `district` VALUES (2563, '万源', 389, 'w', 'wy', 'wanyuan', '', '市', '511781', '0818', 7);
INSERT INTO `district` VALUES (2564, '雨城', 390, 'y', 'yc', 'yucheng', '', '区', '511802', '0835', 1);
INSERT INTO `district` VALUES (2565, '名山', 390, 'm', 'ms', 'mingshan', '', '区', '511803', '0835', 2);
INSERT INTO `district` VALUES (2566, '荥经', 390, 'y', 'yj', 'yingjing', '', '县', '511822', '0835', 3);
INSERT INTO `district` VALUES (2567, '汉源', 390, 'h', 'hy', 'hanyuan', '', '县', '511823', '0835', 4);
INSERT INTO `district` VALUES (2568, '石棉', 390, 's', 'sm', 'shimian', '', '县', '511824', '0835', 5);
INSERT INTO `district` VALUES (2569, '天全', 390, 't', 'tq', 'tianquan', '', '县', '511825', '0835', 6);
INSERT INTO `district` VALUES (2570, '芦山', 390, 'l', 'ls', 'lushan', '', '县', '511826', '0835', 7);
INSERT INTO `district` VALUES (2571, '宝兴', 390, 'b', 'bx', 'baoxing', '', '县', '511827', '0835', 8);
INSERT INTO `district` VALUES (2572, '巴州', 391, 'b', 'bz', 'bazhou', '', '区', '511902', '0827', 1);
INSERT INTO `district` VALUES (2573, '通江', 391, 't', 'tj', 'tongjiang', '', '县', '511921', '0827', 2);
INSERT INTO `district` VALUES (2574, '南江', 391, 'n', 'nj', 'nanjiang', '', '县', '511922', '0827', 3);
INSERT INTO `district` VALUES (2575, '平昌', 391, 'p', 'pc', 'pingchang', '', '县', '511923', '0827', 4);
INSERT INTO `district` VALUES (2576, '雁江', 392, 'y', 'yj', 'yanjiang', '', '区', '512002', '028', 1);
INSERT INTO `district` VALUES (2577, '安岳', 392, 'a', 'ay', 'anyue', '', '县', '512021', '028', 2);
INSERT INTO `district` VALUES (2578, '乐至', 392, 'l', 'lz', 'lezhi', '', '县', '512022', '028', 3);
INSERT INTO `district` VALUES (2579, '简阳', 375, 'j', 'jy', 'jianyang', '', '市', '510185', '028', 4);
INSERT INTO `district` VALUES (2580, '马尔康', 393, 'm', 'mek', 'maerkang', '', '市', '513229', '0837', 1);
INSERT INTO `district` VALUES (2581, '汶川', 393, 'w', 'wc', 'wenchuan', '', '县', '513221', '0837', 2);
INSERT INTO `district` VALUES (2582, '理县', 393, 'l', 'lx', 'lixian', '', '', '513222', '0837', 3);
INSERT INTO `district` VALUES (2583, '茂县', 393, 'm', 'mx', 'maoxian', '', '', '513223', '0837', 4);
INSERT INTO `district` VALUES (2584, '松潘', 393, 's', 'sp', 'songpan', '', '县', '513224', '0837', 5);
INSERT INTO `district` VALUES (2585, '九寨沟', 393, 'j', 'jzg', 'jiuzhaigou', '', '县', '513225', '0837', 6);
INSERT INTO `district` VALUES (2586, '金川', 393, 'j', 'jc', 'jinchuan', '', '县', '513226', '0837', 7);
INSERT INTO `district` VALUES (2587, '小金', 393, 'x', 'xj', 'xiaojin', '', '县', '513227', '0837', 8);
INSERT INTO `district` VALUES (2588, '黑水', 393, 'h', 'hs', 'heishui', '', '县', '513228', '0837', 9);
INSERT INTO `district` VALUES (2589, '壤塘', 393, 'r', 'rt', 'rangtang', '', '县', '513230', '0837', 10);
INSERT INTO `district` VALUES (2590, '阿坝', 393, 'a', 'ab', 'aba', '', '县', '513231', '0837', 11);
INSERT INTO `district` VALUES (2591, '若尔盖', 393, 'r', 'reg', 'ruoergai', '', '县', '513232', '0837', 12);
INSERT INTO `district` VALUES (2592, '红原', 393, 'h', 'hy', 'hongyuan', '', '县', '513233', '0837', 13);
INSERT INTO `district` VALUES (2593, '康定', 394, 'k', 'kd', 'kangding', '', '市', '513301', '0836', 1);
INSERT INTO `district` VALUES (2594, '泸定', 394, 'l', 'ld', 'luding', '', '县', '513322', '0836', 2);
INSERT INTO `district` VALUES (2595, '丹巴', 394, 'd', 'db', 'danba', '', '县', '513323', '0836', 3);
INSERT INTO `district` VALUES (2596, '九龙', 394, 'j', 'jl', 'jiulong', '', '县', '513324', '0836', 4);
INSERT INTO `district` VALUES (2597, '雅江', 394, 'y', 'yj', 'yajiang', '', '县', '513325', '0836', 5);
INSERT INTO `district` VALUES (2598, '道孚', 394, 'd', 'df', 'daofu', '', '县', '513326', '0836', 6);
INSERT INTO `district` VALUES (2599, '炉霍', 394, 'l', 'lh', 'luhuo', '', '县', '513327', '0836', 7);
INSERT INTO `district` VALUES (2600, '甘孜', 394, 'g', 'gz', 'ganzi', '', '县', '513328', '0836', 8);
INSERT INTO `district` VALUES (2601, '新龙', 394, 'x', 'xl', 'xinlong', '', '县', '513329', '0836', 9);
INSERT INTO `district` VALUES (2602, '德格', 394, 'd', 'dg', 'dege', '', '县', '513330', '0836', 10);
INSERT INTO `district` VALUES (2603, '白玉', 394, 'b', 'by', 'baiyu', '', '县', '513331', '0836', 11);
INSERT INTO `district` VALUES (2604, '石渠', 394, 's', 'sq', 'shiqu', '', '县', '513332', '0836', 12);
INSERT INTO `district` VALUES (2605, '色达', 394, 's', 'sd', 'seda', '', '县', '513333', '0836', 13);
INSERT INTO `district` VALUES (2606, '理塘', 394, 'l', 'lt', 'litang', '', '县', '513334', '0836', 14);
INSERT INTO `district` VALUES (2607, '巴塘', 394, 'b', 'bt', 'batang', '', '县', '513335', '0836', 15);
INSERT INTO `district` VALUES (2608, '乡城', 394, 'x', 'xc', 'xiangcheng', '', '县', '513336', '0836', 16);
INSERT INTO `district` VALUES (2609, '稻城', 394, 'd', 'dc', 'daocheng', '', '县', '513337', '0836', 17);
INSERT INTO `district` VALUES (2610, '得荣', 394, 'd', 'dr', 'derong', '', '县', '513338', '0836', 18);
INSERT INTO `district` VALUES (2611, '西昌', 395, 'x', 'xc', 'xichang', '', '市', '513401', '0834', 1);
INSERT INTO `district` VALUES (2612, '木里', 395, 'm', 'ml', 'muli', '藏族', '自治县', '513422', '0834', 2);
INSERT INTO `district` VALUES (2613, '盐源', 395, 'y', 'yy', 'yanyuan', '', '县', '513423', '0834', 3);
INSERT INTO `district` VALUES (2614, '德昌', 395, 'd', 'dc', 'dechang', '', '县', '513424', '0834', 4);
INSERT INTO `district` VALUES (2615, '会理', 395, 'h', 'hl', 'huili', '', '县', '513425', '0834', 5);
INSERT INTO `district` VALUES (2616, '会东', 395, 'h', 'hd', 'huidong', '', '县', '513426', '0834', 6);
INSERT INTO `district` VALUES (2617, '宁南', 395, 'n', 'nn', 'ningnan', '', '县', '513427', '0834', 7);
INSERT INTO `district` VALUES (2618, '普格', 395, 'p', 'pg', 'puge', '', '县', '513428', '0834', 8);
INSERT INTO `district` VALUES (2619, '布拖', 395, 'b', 'bt', 'butuo', '', '县', '513429', '0834', 9);
INSERT INTO `district` VALUES (2620, '金阳', 395, 'j', 'jy', 'jinyang', '', '县', '513430', '0834', 10);
INSERT INTO `district` VALUES (2621, '昭觉', 395, 'z', 'zj', 'zhaojue', '', '县', '513431', '0834', 11);
INSERT INTO `district` VALUES (2622, '喜德', 395, 'x', 'xd', 'xide', '', '县', '513432', '0834', 12);
INSERT INTO `district` VALUES (2623, '冕宁', 395, 'm', 'mn', 'mianning', '', '县', '513433', '0834', 13);
INSERT INTO `district` VALUES (2624, '越西', 395, 'y', 'yx', 'yuexi', '', '县', '513434', '0834', 14);
INSERT INTO `district` VALUES (2625, '甘洛', 395, 'g', 'gl', 'ganluo', '', '县', '513435', '0834', 15);
INSERT INTO `district` VALUES (2626, '美姑', 395, 'm', 'mg', 'meigu', '', '县', '513436', '0834', 16);
INSERT INTO `district` VALUES (2627, '雷波', 395, 'l', 'lb', 'leibo', '', '县', '513437', '0834', 17);
INSERT INTO `district` VALUES (2628, '观山湖', 396, 'g', 'gsh', 'guanshanhu', '', '区', '', '0851', 1);
INSERT INTO `district` VALUES (2629, '南明', 396, 'n', 'nm', 'nanming', '', '区', '520102', '0851', 2);
INSERT INTO `district` VALUES (2630, '云岩', 396, 'y', 'yy', 'yunyan', '', '区', '520103', '0851', 3);
INSERT INTO `district` VALUES (2631, '花溪', 396, 'h', 'hx', 'huaxi', '', '区', '520111', '0851', 4);
INSERT INTO `district` VALUES (2632, '乌当', 396, 'w', 'wd', 'wudang', '', '区', '520112', '0851', 5);
INSERT INTO `district` VALUES (2633, '白云', 396, 'b', 'by', 'baiyun', '', '区', '520113', '0851', 6);
INSERT INTO `district` VALUES (2634, '开阳', 396, 'k', 'ky', 'kaiyang', '', '县', '520121', '0851', 7);
INSERT INTO `district` VALUES (2635, '息烽', 396, 'x', 'xf', 'xifeng', '', '县', '520122', '0851', 8);
INSERT INTO `district` VALUES (2636, '修文', 396, 'x', 'xw', 'xiuwen', '', '县', '520123', '0851', 9);
INSERT INTO `district` VALUES (2637, '清镇', 396, 'q', 'qz', 'qingzhen', '', '市', '520181', '0851', 10);
INSERT INTO `district` VALUES (2638, '钟山', 397, 'z', 'zs', 'zhongshan', '', '区', '520201', '0858', 1);
INSERT INTO `district` VALUES (2639, '六枝特', 397, 'l', 'lzt', 'liuzhite', '', '区', '520203', '0858', 2);
INSERT INTO `district` VALUES (2640, '水城', 397, 's', 'sc', 'shuicheng', '', '县', '520221', '0858', 3);
INSERT INTO `district` VALUES (2641, '盘州', 397, 'p', 'pz', 'panzhou', '', '市', '520281', '0858', 4);
INSERT INTO `district` VALUES (2642, '红花岗', 398, 'h', 'hhg', 'honghuagang', '', '区', '520302', '0852', 1);
INSERT INTO `district` VALUES (2643, '汇川', 398, 'h', 'hc', 'huichuan', '', '区', '520303', '0852', 2);
INSERT INTO `district` VALUES (2644, '播州', 398, 'b', 'bz', 'bozhou', '', '区', '520304', '0852', 3);
INSERT INTO `district` VALUES (2645, '桐梓', 398, 't', 'tz', 'tongzi', '', '县', '520322', '0852', 4);
INSERT INTO `district` VALUES (2646, '绥阳', 398, 's', 'sy', 'suiyang', '', '县', '520323', '0852', 5);
INSERT INTO `district` VALUES (2647, '正安', 398, 'z', 'za', 'zhengan', '', '县', '520324', '0852', 6);
INSERT INTO `district` VALUES (2648, '道真', 398, 'd', 'dz', 'daozhen', '仡佬族苗族', '自治县', '520325', '0852', 7);
INSERT INTO `district` VALUES (2649, '务川', 398, 'w', 'wc', 'wuchuan', '仡佬族苗族', '自治县', '520326', '0852', 8);
INSERT INTO `district` VALUES (2650, '凤冈', 398, 'f', 'fg', 'fenggang', '', '县', '520327', '0852', 9);
INSERT INTO `district` VALUES (2651, '湄潭', 398, 'm', 'mt', 'meitan', '', '县', '520328', '0852', 10);
INSERT INTO `district` VALUES (2652, '余庆', 398, 'y', 'yq', 'yuqing', '', '县', '520329', '0852', 11);
INSERT INTO `district` VALUES (2653, '习水', 398, 'x', 'xs', 'xishui', '', '县', '520330', '0852', 12);
INSERT INTO `district` VALUES (2654, '赤水', 398, 'c', 'cs', 'chishui', '', '市', '520381', '0852', 13);
INSERT INTO `district` VALUES (2655, '仁怀', 398, 'r', 'rh', 'renhuai', '', '市', '520382', '0852', 14);
INSERT INTO `district` VALUES (2656, '西秀', 399, 'x', 'xx', 'xixiu', '', '区', '520402', '0853', 1);
INSERT INTO `district` VALUES (2657, '平坝', 399, 'p', 'pb', 'pingba', '', '区', '520403', '0853', 2);
INSERT INTO `district` VALUES (2658, '普定', 399, 'p', 'pd', 'puding', '', '县', '520422', '0853', 3);
INSERT INTO `district` VALUES (2659, '镇宁', 399, 'z', 'zn', 'zhenning', '布依族苗族', '自治县', '520423', '0853', 4);
INSERT INTO `district` VALUES (2660, '关岭', 399, 'g', 'gl', 'guanling', '布依族苗族', '自治县', '520424', '0853', 5);
INSERT INTO `district` VALUES (2661, '紫云', 399, 'z', 'zy', 'ziyun', '苗族布依族', '自治县', '520425', '0853', 6);
INSERT INTO `district` VALUES (2662, '七星关', 400, 'q', 'qxg', 'qixingguan', '', '区', '520502', '0857', 1);
INSERT INTO `district` VALUES (2663, '大方', 400, 'd', 'df', 'dafang', '', '县', '520521', '0857', 2);
INSERT INTO `district` VALUES (2664, '黔西', 400, 'q', 'qx', 'qianxi', '', '县', '520522', '0857', 3);
INSERT INTO `district` VALUES (2665, '金沙', 400, 'j', 'js', 'jinsha', '', '县', '520523', '0857', 4);
INSERT INTO `district` VALUES (2666, '织金', 400, 'z', 'zj', 'zhijin', '', '县', '520524', '0857', 5);
INSERT INTO `district` VALUES (2667, '纳雍', 400, 'n', 'ny', 'nayong', '', '县', '520525', '0857', 6);
INSERT INTO `district` VALUES (2668, '威宁', 400, 'w', 'wn', 'weining', '彝族回族苗族', '自治县', '520526', '0857', 7);
INSERT INTO `district` VALUES (2669, '赫章', 400, 'h', 'hz', 'hezhang', '', '县', '520527', '0857', 8);
INSERT INTO `district` VALUES (2670, '碧江', 401, 'b', 'bj', 'bijiang', '', '区', '520602', '0856', 1);
INSERT INTO `district` VALUES (2671, '万山', 401, 'w', 'ws', 'wanshan', '', '区', '520603', '0856', 2);
INSERT INTO `district` VALUES (2672, '江口', 401, 'j', 'jk', 'jiangkou', '', '县', '520621', '0856', 3);
INSERT INTO `district` VALUES (2673, '玉屏', 401, 'y', 'yp', 'yuping', '侗族', '自治县', '520622', '0856', 4);
INSERT INTO `district` VALUES (2674, '石阡', 401, 's', 'sq', 'shiqian', '', '县', '520623', '0856', 5);
INSERT INTO `district` VALUES (2675, '思南', 401, 's', 'sn', 'sinan', '', '县', '520624', '0856', 6);
INSERT INTO `district` VALUES (2676, '印江', 401, 'y', 'yj', 'yinjiang', '土家族苗族', '自治县', '520625', '0856', 7);
INSERT INTO `district` VALUES (2677, '德江', 401, 'd', 'dj', 'dejiang', '', '县', '520626', '0856', 8);
INSERT INTO `district` VALUES (2678, '沿河', 401, 'y', 'yh', 'yanhe', '土家族', '自治县', '520627', '0856', 9);
INSERT INTO `district` VALUES (2679, '松桃', 401, 's', 'st', 'songtao', '苗族', '自治县', '520628', '0856', 10);
INSERT INTO `district` VALUES (2680, '兴义', 402, 'x', 'xy', 'xingyi', '', '市', '522301', '0859', 1);
INSERT INTO `district` VALUES (2681, '兴仁', 402, 'x', 'xr', 'xingren', '', '市', '522322', '0859', 2);
INSERT INTO `district` VALUES (2682, '普安', 402, 'p', 'pa', 'puan', '', '县', '522323', '0859', 3);
INSERT INTO `district` VALUES (2683, '晴隆', 402, 'q', 'ql', 'qinglong', '', '县', '522324', '0859', 4);
INSERT INTO `district` VALUES (2684, '贞丰', 402, 'z', 'zf', 'zhenfeng', '', '县', '522325', '0859', 5);
INSERT INTO `district` VALUES (2685, '望谟', 402, 'w', 'wm', 'wangmo', '', '县', '522326', '0859', 6);
INSERT INTO `district` VALUES (2686, '册亨', 402, 'c', 'ch', 'ceheng', '', '县', '522327', '0859', 7);
INSERT INTO `district` VALUES (2687, '安龙', 402, 'a', 'al', 'anlong', '', '县', '522328', '0859', 8);
INSERT INTO `district` VALUES (2688, '凯里', 403, 'k', 'kl', 'kaili', '', '市', '522601', '0855', 1);
INSERT INTO `district` VALUES (2689, '黄平', 403, 'h', 'hp', 'huangping', '', '县', '522622', '0855', 2);
INSERT INTO `district` VALUES (2690, '施秉', 403, 's', 'sb', 'shibing', '', '县', '522623', '0855', 3);
INSERT INTO `district` VALUES (2691, '三穗', 403, 's', 'ss', 'sansui', '', '县', '522624', '0855', 4);
INSERT INTO `district` VALUES (2692, '镇远', 403, 'z', 'zy', 'zhenyuan', '', '县', '522625', '0855', 5);
INSERT INTO `district` VALUES (2693, '岑巩', 403, 'c', 'cg', 'cengong', '', '县', '522626', '0855', 6);
INSERT INTO `district` VALUES (2694, '天柱', 403, 't', 'tz', 'tianzhu', '', '县', '522627', '0855', 7);
INSERT INTO `district` VALUES (2695, '锦屏', 403, 'j', 'jp', 'jinping', '', '县', '522628', '0855', 8);
INSERT INTO `district` VALUES (2696, '剑河', 403, 'j', 'jh', 'jianhe', '', '县', '522629', '0855', 9);
INSERT INTO `district` VALUES (2697, '台江', 403, 't', 'tj', 'taijiang', '', '县', '522630', '0855', 10);
INSERT INTO `district` VALUES (2698, '黎平', 403, 'l', 'lp', 'liping', '', '县', '522631', '0855', 11);
INSERT INTO `district` VALUES (2699, '榕江', 403, 'r', 'rj', 'rongjiang', '', '县', '522632', '0855', 12);
INSERT INTO `district` VALUES (2700, '从江', 403, 'c', 'cj', 'congjiang', '', '县', '522633', '0855', 13);
INSERT INTO `district` VALUES (2701, '雷山', 403, 'l', 'ls', 'leishan', '', '县', '522634', '0855', 14);
INSERT INTO `district` VALUES (2702, '麻江', 403, 'm', 'mj', 'majiang', '', '县', '522635', '0855', 15);
INSERT INTO `district` VALUES (2703, '丹寨', 403, 'd', 'dz', 'danzhai', '', '县', '522636', '0855', 16);
INSERT INTO `district` VALUES (2704, '都匀', 404, 'd', 'dy', 'duyun', '', '市', '522701', '0854', 1);
INSERT INTO `district` VALUES (2705, '福泉', 404, 'f', 'fq', 'fuquan', '', '市', '522702', '0854', 2);
INSERT INTO `district` VALUES (2706, '荔波', 404, 'l', 'lb', 'libo', '', '县', '522722', '0854', 3);
INSERT INTO `district` VALUES (2707, '贵定', 404, 'g', 'gd', 'guiding', '', '县', '522723', '0854', 4);
INSERT INTO `district` VALUES (2708, '瓮安', 404, 'w', 'wa', 'wengan', '', '县', '522725', '0854', 5);
INSERT INTO `district` VALUES (2709, '独山', 404, 'd', 'ds', 'dushan', '', '县', '522726', '0854', 6);
INSERT INTO `district` VALUES (2710, '平塘', 404, 'p', 'pt', 'pingtang', '', '县', '522727', '0854', 7);
INSERT INTO `district` VALUES (2711, '罗甸', 404, 'l', 'ld', 'luodian', '', '县', '522728', '0854', 8);
INSERT INTO `district` VALUES (2712, '长顺', 404, 'c', 'cs', 'changshun', '', '县', '522729', '0854', 9);
INSERT INTO `district` VALUES (2713, '龙里', 404, 'l', 'll', 'longli', '', '县', '522730', '0854', 10);
INSERT INTO `district` VALUES (2714, '惠水', 404, 'h', 'hs', 'huishui', '', '县', '522731', '0854', 11);
INSERT INTO `district` VALUES (2715, '三都', 404, 's', 'sd', 'sandu', '水族', '自治县', '522732', '0854', 12);
INSERT INTO `district` VALUES (2716, '五华', 405, 'w', 'wh', 'wuhua', '', '区', '530102', '0871', 1);
INSERT INTO `district` VALUES (2717, '盘龙', 405, 'p', 'pl', 'panlong', '', '区', '530103', '0871', 2);
INSERT INTO `district` VALUES (2718, '官渡', 405, 'g', 'gd', 'guandu', '', '区', '530111', '0871', 3);
INSERT INTO `district` VALUES (2719, '西山', 405, 'x', 'xs', 'xishan', '', '区', '530112', '0871', 4);
INSERT INTO `district` VALUES (2720, '东川', 405, 'd', 'dc', 'dongchuan', '', '区', '530113', '0871', 5);
INSERT INTO `district` VALUES (2721, '呈贡', 405, 'c', 'cg', 'chenggong', '', '区', '530114', '0871', 6);
INSERT INTO `district` VALUES (2722, '晋宁', 405, 'j', 'jn', 'jinning', '', '区', '530115', '0871', 7);
INSERT INTO `district` VALUES (2723, '富民', 405, 'f', 'fm', 'fumin', '', '县', '530124', '0871', 8);
INSERT INTO `district` VALUES (2724, '宜良', 405, 'y', 'yl', 'yiliang', '', '县', '530125', '0871', 9);
INSERT INTO `district` VALUES (2725, '石林', 405, 's', 'sl', 'shilin', '彝族', '自治县', '530126', '0871', 10);
INSERT INTO `district` VALUES (2726, '嵩明', 405, 's', 'sm', 'songming', '', '县', '530127', '0871', 11);
INSERT INTO `district` VALUES (2727, '禄劝', 405, 'l', 'lq', 'luquan', '彝族苗族', '自治县', '530128', '0871', 12);
INSERT INTO `district` VALUES (2728, '寻甸', 405, 'x', 'xd', 'xundian', '回族彝族', '自治县', '530129', '0871', 13);
INSERT INTO `district` VALUES (2729, '安宁', 405, 'a', 'an', 'anning', '', '市', '530181', '0871', 14);
INSERT INTO `district` VALUES (2730, '麒麟', 406, 'q', 'ql', 'qilin', '', '区', '530302', '0874', 1);
INSERT INTO `district` VALUES (2731, '马龙', 406, 'm', 'ml', 'malong', '', '区', '530304', '0874', 3);
INSERT INTO `district` VALUES (2732, '陆良', 406, 'l', 'll', 'luliang', '', '县', '530322', '0874', 4);
INSERT INTO `district` VALUES (2733, '师宗', 406, 's', 'sz', 'shizong', '', '县', '530323', '0874', 5);
INSERT INTO `district` VALUES (2734, '罗平', 406, 'l', 'lp', 'luoping', '', '县', '530324', '0874', 6);
INSERT INTO `district` VALUES (2735, '富源', 406, 'f', 'fy', 'fuyuan', '', '县', '530325', '0874', 7);
INSERT INTO `district` VALUES (2736, '会泽', 406, 'h', 'hz', 'huize', '', '县', '530326', '0874', 8);
INSERT INTO `district` VALUES (2737, '沾益', 406, 'z', 'zy', 'zhanyi', '', '区', '530303', '0874', 2);
INSERT INTO `district` VALUES (2738, '宣威', 406, 'x', 'xw', 'xuanwei', '', '市', '530381', '0874', 9);
INSERT INTO `district` VALUES (2739, '红塔', 407, 'h', 'ht', 'hongta', '', '区', '530402', '0877', 1);
INSERT INTO `district` VALUES (2740, '江川', 407, 'j', 'jc', 'jiangchuan', '', '区', '530421', '0877', 2);
INSERT INTO `district` VALUES (2741, '澄江', 407, 'c', 'cj', 'chengjiang', '', '市', '530481', '0877', 9);
INSERT INTO `district` VALUES (2742, '通海', 407, 't', 'th', 'tonghai', '', '县', '530423', '0877', 3);
INSERT INTO `district` VALUES (2743, '华宁', 407, 'h', 'hn', 'huaning', '', '县', '530424', '0877', 4);
INSERT INTO `district` VALUES (2744, '易门', 407, 'y', 'ym', 'yimen', '', '县', '530425', '0877', 5);
INSERT INTO `district` VALUES (2745, '峨山', 407, 'e', 'es', 'eshan', '彝族', '自治县', '530426', '0877', 6);
INSERT INTO `district` VALUES (2746, '新平', 407, 'x', 'xp', 'xinping', '彝族傣族', '自治县', '530427', '0877', 7);
INSERT INTO `district` VALUES (2747, '元江', 407, 'y', 'yj', 'yuanjiang', '哈尼族彝族傣族', '自治县', '530428', '0877', 8);
INSERT INTO `district` VALUES (2748, '昭阳', 408, 'z', 'zy', 'zhaoyang', '', '区', '530602', '0870', 1);
INSERT INTO `district` VALUES (2749, '鲁甸', 408, 'l', 'ld', 'ludian', '', '县', '530621', '0870', 2);
INSERT INTO `district` VALUES (2750, '巧家', 408, 'q', 'qj', 'qiaojia', '', '县', '530622', '0870', 3);
INSERT INTO `district` VALUES (2751, '盐津', 408, 'y', 'yj', 'yanjin', '', '县', '530623', '0870', 4);
INSERT INTO `district` VALUES (2752, '大关', 408, 'd', 'dg', 'daguan', '', '县', '530624', '0870', 5);
INSERT INTO `district` VALUES (2753, '永善', 408, 'y', 'ys', 'yongshan', '', '县', '530625', '0870', 6);
INSERT INTO `district` VALUES (2754, '绥江', 408, 's', 'sj', 'suijiang', '', '县', '530626', '0870', 7);
INSERT INTO `district` VALUES (2755, '镇雄', 408, 'z', 'zx', 'zhenxiong', '', '县', '530627', '0870', 8);
INSERT INTO `district` VALUES (2756, '彝良', 408, 'y', 'yl', 'yiliang', '', '县', '530628', '0870', 9);
INSERT INTO `district` VALUES (2757, '威信', 408, 'w', 'wx', 'weixin', '', '县', '530629', '0870', 10);
INSERT INTO `district` VALUES (2758, '水富', 408, 's', 'sf', 'shuifu', '', '市', '530630', '0870', 11);
INSERT INTO `district` VALUES (2759, '古城', 409, 'g', 'gc', 'gucheng', '', '区', '530702', '0888', 1);
INSERT INTO `district` VALUES (2760, '玉龙', 409, 'y', 'yl', 'yulong', '纳西族', '自治县', '530721', '0888', 2);
INSERT INTO `district` VALUES (2761, '永胜', 409, 'y', 'ys', 'yongsheng', '', '县', '530722', '0888', 3);
INSERT INTO `district` VALUES (2762, '华坪', 409, 'h', 'hp', 'huaping', '', '县', '530723', '0888', 4);
INSERT INTO `district` VALUES (2763, '宁蒗', 409, 'n', 'nl', 'ninglang', '彝族', '自治县', '530724', '0888', 5);
INSERT INTO `district` VALUES (2764, '思茅', 410, 's', 'sm', 'simao', '', '区', '530802', '0879', 1);
INSERT INTO `district` VALUES (2765, '宁洱', 410, 'n', 'ne', 'ninger', '哈尼族彝族', '县', '530821', '0879', 2);
INSERT INTO `district` VALUES (2766, '墨江', 410, 'm', 'mj', 'mojiang', '哈尼族', '县', '530822', '0879', 3);
INSERT INTO `district` VALUES (2767, '景东', 410, 'j', 'jd', 'jingdong', '彝族', '县', '530823', '0879', 4);
INSERT INTO `district` VALUES (2768, '景谷', 410, 'j', 'jg', 'jinggu', '傣族彝族', '县', '530824', '0879', 5);
INSERT INTO `district` VALUES (2769, '镇沅', 410, 'z', 'zy', 'zhenyuan', '彝族哈尼族拉祜族', '县', '530825', '0879', 6);
INSERT INTO `district` VALUES (2770, '江城', 410, 'j', 'jc', 'jiangcheng', '哈尼族彝族', '县', '530826', '0879', 7);
INSERT INTO `district` VALUES (2771, '孟连', 410, 'm', 'ml', 'menglian', '傣族拉祜族佤族', '县', '530827', '0879', 8);
INSERT INTO `district` VALUES (2772, '澜沧', 410, 'l', 'lc', 'lancang', '拉祜族', '县', '530828', '0879', 9);
INSERT INTO `district` VALUES (2773, '西盟', 410, 'x', 'xm', 'ximeng', '佤族', '县', '530829', '0879', 10);
INSERT INTO `district` VALUES (2774, '临翔', 411, 'l', 'lx', 'linxiang', '', '区', '530902', '0883', 1);
INSERT INTO `district` VALUES (2775, '凤庆', 411, 'f', 'fq', 'fengqing', '', '县', '530921', '0883', 2);
INSERT INTO `district` VALUES (2776, '云县', 411, 'y', 'yx', 'yunxian', '', '', '530922', '0883', 3);
INSERT INTO `district` VALUES (2777, '永德', 411, 'y', 'yd', 'yongde', '', '县', '530923', '0883', 4);
INSERT INTO `district` VALUES (2778, '镇康', 411, 'z', 'zk', 'zhenkang', '', '县', '530924', '0883', 5);
INSERT INTO `district` VALUES (2779, '双江', 411, 's', 'sj', 'shuangjiang', '拉祜族佤族布朗族傣族', '自治县', '530925', '0883', 6);
INSERT INTO `district` VALUES (2780, '耿马', 411, 'g', 'gm', 'gengma', '傣族佤族', '自治县', '530926', '0883', 7);
INSERT INTO `district` VALUES (2781, '沧源', 411, 'c', 'cy', 'cangyuan', '佤族', '自治县', '530927', '0883', 8);
INSERT INTO `district` VALUES (2782, '楚雄', 412, 'c', 'cx', 'chuxiong', '', '市', '532301', '0878', 1);
INSERT INTO `district` VALUES (2783, '双柏', 412, 's', 'sb', 'shuangbo', '', '县', '532322', '0878', 2);
INSERT INTO `district` VALUES (2784, '牟定', 412, 'm', 'md', 'mouding', '', '县', '532323', '0878', 3);
INSERT INTO `district` VALUES (2785, '南华', 412, 'n', 'nh', 'nanhua', '', '县', '532324', '0878', 4);
INSERT INTO `district` VALUES (2786, '姚安', 412, 'y', 'ya', 'yaoan', '', '县', '532325', '0878', 5);
INSERT INTO `district` VALUES (2787, '大姚', 412, 'd', 'dy', 'dayao', '', '县', '532326', '0878', 6);
INSERT INTO `district` VALUES (2788, '永仁', 412, 'y', 'yr', 'yongren', '', '县', '532327', '0878', 7);
INSERT INTO `district` VALUES (2789, '元谋', 412, 'y', 'ym', 'yuanmou', '', '县', '532328', '0878', 8);
INSERT INTO `district` VALUES (2790, '武定', 412, 'w', 'wd', 'wuding', '', '县', '532329', '0878', 9);
INSERT INTO `district` VALUES (2791, '禄丰', 412, 'l', 'lf', 'lufeng', '', '县', '532331', '0878', 10);
INSERT INTO `district` VALUES (2792, '个旧', 413, 'g', 'gj', 'gejiu', '', '市', '532501', '0873', 1);
INSERT INTO `district` VALUES (2793, '开远', 413, 'k', 'ky', 'kaiyuan', '', '市', '532502', '0873', 2);
INSERT INTO `district` VALUES (2794, '蒙自', 413, 'm', 'mz', 'mengzi', '', '市', '532503', '0873', 3);
INSERT INTO `district` VALUES (2795, '屏边', 413, 'p', 'pb', 'pingbian', '苗族', '自治县', '532523', '0873', 4);
INSERT INTO `district` VALUES (2796, '建水', 413, 'j', 'js', 'jianshui', '', '县', '532524', '0873', 5);
INSERT INTO `district` VALUES (2797, '石屏', 413, 's', 'sp', 'shiping', '', '县', '532525', '0873', 6);
INSERT INTO `district` VALUES (2798, '弥勒', 413, 'm', 'ml', 'mile', '', '市', '532526', '0873', 7);
INSERT INTO `district` VALUES (2799, '泸西', 413, 'l', 'lx', 'luxi', '', '县', '532527', '0873', 8);
INSERT INTO `district` VALUES (2800, '元阳', 413, 'y', 'yy', 'yuanyang', '', '县', '532528', '0873', 9);
INSERT INTO `district` VALUES (2801, '红河', 413, 'h', 'hh', 'honghe', '', '县', '532529', '0873', 10);
INSERT INTO `district` VALUES (2802, '金平', 413, 'j', 'jp', 'jinping', '苗族瑶族傣族', '自治县', '532530', '0873', 11);
INSERT INTO `district` VALUES (2803, '绿春', 413, 'l', 'lc', 'lu:chun', '', '县', '532531', '0873', 12);
INSERT INTO `district` VALUES (2804, '河口', 413, 'h', 'hk', 'hekou', '瑶族', '自治县', '532532', '0873', 13);
INSERT INTO `district` VALUES (2805, '文山', 414, 'w', 'ws', 'wenshan', '', '县', '532601', '0876', 1);
INSERT INTO `district` VALUES (2806, '砚山', 414, 'y', 'ys', 'yanshan', '', '县', '532622', '0876', 2);
INSERT INTO `district` VALUES (2807, '西畴', 414, 'x', 'xc', 'xichou', '', '县', '532623', '0876', 3);
INSERT INTO `district` VALUES (2808, '麻栗坡', 414, 'm', 'mlp', 'malipo', '', '县', '532624', '0876', 4);
INSERT INTO `district` VALUES (2809, '马关', 414, 'm', 'mg', 'maguan', '', '县', '532625', '0876', 5);
INSERT INTO `district` VALUES (2810, '丘北', 414, 'q', 'qb', 'qiubei', '', '县', '532626', '0876', 6);
INSERT INTO `district` VALUES (2811, '广南', 414, 'g', 'gn', 'guangnan', '', '县', '532627', '0876', 7);
INSERT INTO `district` VALUES (2812, '富宁', 414, 'f', 'fn', 'funing', '', '县', '532628', '0876', 8);
INSERT INTO `district` VALUES (2813, '景洪', 415, 'j', 'jh', 'jinghong', '', '市', '532801', '0691', 1);
INSERT INTO `district` VALUES (2814, '勐海', 415, 'm', 'mh', 'menghai', '', '县', '532822', '0691', 2);
INSERT INTO `district` VALUES (2815, '勐腊', 415, 'm', 'ml', 'mengla', '', '县', '532823', '0691', 3);
INSERT INTO `district` VALUES (2816, '大理', 416, 'd', 'dl', 'dali', '', '市', '532901', '0872', 1);
INSERT INTO `district` VALUES (2817, '漾濞', 416, 'y', 'yb', 'yangbi', '彝族', '自治县', '532922', '0872', 2);
INSERT INTO `district` VALUES (2818, '祥云', 416, 'x', 'xy', 'xiangyun', '', '县', '532923', '0872', 3);
INSERT INTO `district` VALUES (2819, '宾川', 416, 'b', 'bc', 'binchuan', '', '县', '532924', '0872', 4);
INSERT INTO `district` VALUES (2820, '弥渡', 416, 'm', 'md', 'midu', '', '县', '532925', '0872', 5);
INSERT INTO `district` VALUES (2821, '南涧', 416, 'n', 'nj', 'nanjian', '彝族', '自治县', '532926', '0872', 6);
INSERT INTO `district` VALUES (2822, '巍山', 416, 'w', 'ws', 'weishan', '彝族回族', '自治县', '532927', '0872', 7);
INSERT INTO `district` VALUES (2823, '永平', 416, 'y', 'yp', 'yongping', '', '县', '532928', '0872', 8);
INSERT INTO `district` VALUES (2824, '云龙', 416, 'y', 'yl', 'yunlong', '', '县', '532929', '0872', 9);
INSERT INTO `district` VALUES (2825, '洱源', 416, 'e', 'ey', 'eryuan', '', '县', '532930', '0872', 10);
INSERT INTO `district` VALUES (2826, '剑川', 416, 'j', 'jc', 'jianchuan', '', '县', '532931', '0872', 11);
INSERT INTO `district` VALUES (2827, '鹤庆', 416, 'h', 'hq', 'heqing', '', '县', '532932', '0872', 12);
INSERT INTO `district` VALUES (2828, '瑞丽', 417, 'r', 'rl', 'ruili', '', '市', '533102', '0692', 1);
INSERT INTO `district` VALUES (2829, '芒市', 417, 'm', 'ms', 'mangshi', '', '', '533103', '0692', 2);
INSERT INTO `district` VALUES (2830, '梁河', 417, 'l', 'lh', 'lianghe', '', '县', '533122', '0692', 3);
INSERT INTO `district` VALUES (2831, '盈江', 417, 'y', 'yj', 'yingjiang', '', '县', '533123', '0692', 4);
INSERT INTO `district` VALUES (2832, '陇川', 417, 'l', 'lc', 'longchuan', '', '县', '533124', '0692', 5);
INSERT INTO `district` VALUES (2833, '泸水', 418, 'l', 'ls', 'lushui', '', '市', '533301', '0886', 1);
INSERT INTO `district` VALUES (2834, '福贡', 418, 'f', 'fg', 'fugong', '', '县', '533323', '0886', 2);
INSERT INTO `district` VALUES (2835, '贡山', 418, 'g', 'gs', 'gongshan', '独龙族怒族', '县', '533324', '0886', 3);
INSERT INTO `district` VALUES (2836, '兰坪', 418, 'l', 'lp', 'lanping', '白族普米族', '县', '533325', '0886', 4);
INSERT INTO `district` VALUES (2837, '香格里拉', 419, 'x', 'xgll', 'xianggelila', '', '市', '533421', '0887', 1);
INSERT INTO `district` VALUES (2838, '德钦', 419, 'd', 'dq', 'deqin', '', '县', '533422', '0887', 2);
INSERT INTO `district` VALUES (2839, '维西', 419, 'w', 'wx', 'weixi', '', '县', '533423', '0887', 3);
INSERT INTO `district` VALUES (2840, '隆阳', 420, 'l', 'ly', 'longyang', '', '区', '530502', '0875', 1);
INSERT INTO `district` VALUES (2841, '施甸', 420, 's', 'sd', 'shidian', '', '县', '530521', '0875', 2);
INSERT INTO `district` VALUES (2842, '腾冲', 420, 't', 'tc', 'tengchong', '', '市', '530522', '0875', 3);
INSERT INTO `district` VALUES (2843, '龙陵', 420, 'l', 'll', 'longling', '', '县', '530523', '0875', 4);
INSERT INTO `district` VALUES (2844, '昌宁', 420, 'c', 'cn', 'changning', '', '县', '530524', '0875', 5);
INSERT INTO `district` VALUES (2845, '城关', 421, 'c', 'cg', 'chengguan', '', '区', '540102', '0891', 1);
INSERT INTO `district` VALUES (2846, '林周', 421, 'l', 'lz', 'linzhou', '', '县', '540121', '0891', 3);
INSERT INTO `district` VALUES (2847, '当雄', 421, 'd', 'dx', 'dangxiong', '', '县', '540122', '0891', 4);
INSERT INTO `district` VALUES (2848, '尼木', 421, 'n', 'nm', 'nimu', '', '县', '540123', '0891', 5);
INSERT INTO `district` VALUES (2849, '曲水', 421, 'q', 'qs', 'qushui', '', '县', '540124', '0891', 6);
INSERT INTO `district` VALUES (2850, '堆龙德庆', 421, 'd', 'dldq', 'duilongdeqing', '', '区', '540125', '0891', 7);
INSERT INTO `district` VALUES (2851, '达孜', 421, 'd', 'dz', 'dazi', '', '区', '540104', '0891', 2);
INSERT INTO `district` VALUES (2852, '墨竹工卡', 421, 'm', 'mzgk', 'mozhugongka', '', '县', '540127', '0891', 8);
INSERT INTO `district` VALUES (2853, '卡若', 422, 'k', 'kr', 'karuo', '', '区', '542121', '0895', 1);
INSERT INTO `district` VALUES (2854, '江达', 422, 'j', 'jd', 'jiangda', '', '县', '542122', '0895', 2);
INSERT INTO `district` VALUES (2855, '贡觉', 422, 'g', 'gj', 'gongjue', '', '县', '542123', '0895', 3);
INSERT INTO `district` VALUES (2856, '类乌齐', 422, 'l', 'lwq', 'leiwuqi', '', '县', '542124', '0895', 4);
INSERT INTO `district` VALUES (2857, '丁青', 422, 'd', 'dq', 'dingqing', '', '县', '542125', '0895', 5);
INSERT INTO `district` VALUES (2858, '察雅', 422, 'c', 'cy', 'chaya', '', '县', '542126', '0895', 6);
INSERT INTO `district` VALUES (2859, '八宿', 422, 'b', 'bs', 'basu', '', '县', '542127', '0895', 7);
INSERT INTO `district` VALUES (2860, '左贡', 422, 'z', 'zg', 'zuogong', '', '县', '542128', '0895', 8);
INSERT INTO `district` VALUES (2861, '芒康', 422, 'm', 'mk', 'mangkang', '', '县', '542129', '0895', 9);
INSERT INTO `district` VALUES (2862, '洛隆', 422, 'l', 'll', 'luolong', '', '县', '542132', '0895', 10);
INSERT INTO `district` VALUES (2863, '边坝', 422, 'b', 'bb', 'bianba', '', '县', '542133', '0895', 11);
INSERT INTO `district` VALUES (2864, '乃东', 423, 'n', 'nd', 'naidong', '', '区', '540502', '0893', 1);
INSERT INTO `district` VALUES (2865, '扎囊', 423, 'z', 'zn', 'zhanang', '', '县', '540521', '0893', 2);
INSERT INTO `district` VALUES (2866, '贡嘎', 423, 'g', 'gg', 'gongga', '', '县', '540522', '0893', 3);
INSERT INTO `district` VALUES (2867, '桑日', 423, 's', 'sr', 'sangri', '', '县', '540523', '0893', 4);
INSERT INTO `district` VALUES (2868, '琼结', 423, 'q', 'qj', 'qiongjie', '', '县', '540524', '0893', 5);
INSERT INTO `district` VALUES (2869, '曲松', 423, 'q', 'qs', 'qusong', '', '县', '540525', '0893', 6);
INSERT INTO `district` VALUES (2870, '措美', 423, 'c', 'cm', 'cuomei', '', '县', '540526', '0893', 7);
INSERT INTO `district` VALUES (2871, '洛扎', 423, 'l', 'lz', 'luozha', '', '县', '540527', '0893', 8);
INSERT INTO `district` VALUES (2872, '加查', 423, 'j', 'jc', 'jiacha', '', '县', '540528', '0893', 9);
INSERT INTO `district` VALUES (2873, '隆子', 423, 'l', 'lz', 'longzi', '', '县', '540529', '0893', 10);
INSERT INTO `district` VALUES (2874, '错那', 423, 'c', 'cn', 'cuonei', '', '县', '540530', '0893', 11);
INSERT INTO `district` VALUES (2875, '浪卡子', 423, 'l', 'lkz', 'langkazi', '', '县', '540531', '0893', 12);
INSERT INTO `district` VALUES (2876, '桑珠孜', 424, 's', 'szz', 'sangzhuzi', '', '区', '542301', '0892', 1);
INSERT INTO `district` VALUES (2877, '南木林', 424, 'n', 'nml', 'nanmulin', '', '县', '542322', '0892', 2);
INSERT INTO `district` VALUES (2878, '江孜', 424, 'j', 'jz', 'jiangzi', '', '县', '542323', '0892', 3);
INSERT INTO `district` VALUES (2879, '定日', 424, 'd', 'dr', 'dingri', '', '县', '542324', '0892', 4);
INSERT INTO `district` VALUES (2880, '萨迦', 424, 's', 'sj', 'sajia', '', '县', '542325', '0892', 5);
INSERT INTO `district` VALUES (2881, '拉孜', 424, 'l', 'lz', 'lazi', '', '县', '542326', '0892', 6);
INSERT INTO `district` VALUES (2882, '昂仁', 424, 'a', 'ar', 'angren', '', '县', '542327', '0892', 7);
INSERT INTO `district` VALUES (2883, '谢通门', 424, 'x', 'xtm', 'xietongmen', '', '县', '542328', '0892', 8);
INSERT INTO `district` VALUES (2884, '白朗', 424, 'b', 'bl', 'bailang', '', '县', '542329', '0892', 9);
INSERT INTO `district` VALUES (2885, '仁布', 424, 'r', 'rb', 'renbu', '', '县', '542330', '0892', 10);
INSERT INTO `district` VALUES (2886, '康马', 424, 'k', 'km', 'kangma', '', '县', '542331', '0892', 11);
INSERT INTO `district` VALUES (2887, '定结', 424, 'd', 'dj', 'dingjie', '', '县', '542332', '0892', 12);
INSERT INTO `district` VALUES (2888, '仲巴', 424, 'z', 'zb', 'zhongba', '', '县', '542333', '0892', 13);
INSERT INTO `district` VALUES (2889, '亚东', 424, 'y', 'yd', 'yadong', '', '县', '542334', '0892', 14);
INSERT INTO `district` VALUES (2890, '吉隆', 424, 'j', 'jl', 'jilong', '', '县', '542335', '0892', 15);
INSERT INTO `district` VALUES (2891, '聂拉木', 424, 'n', 'nlm', 'nielamu', '', '县', '542336', '0892', 16);
INSERT INTO `district` VALUES (2892, '萨嘎', 424, 's', 'sg', 'saga', '', '县', '542337', '0892', 17);
INSERT INTO `district` VALUES (2893, '岗巴', 424, 'g', 'gb', 'gangba', '', '县', '542338', '0892', 18);
INSERT INTO `district` VALUES (2894, '双湖', 425, 's', 'sh', 'shuanghu', '', '县', '540630', '0896', 11);
INSERT INTO `district` VALUES (2895, '色尼', 425, 's', 'sn', 'seni', '', '区', '540602', '0896', 1);
INSERT INTO `district` VALUES (2896, '嘉黎', 425, 'j', 'jl', 'jiali', '', '县', '540621', '0896', 2);
INSERT INTO `district` VALUES (2897, '比如', 425, 'b', 'br', 'biru', '', '县', '540622', '0896', 3);
INSERT INTO `district` VALUES (2898, '聂荣', 425, 'n', 'nr', 'nierong', '', '县', '540623', '0896', 4);
INSERT INTO `district` VALUES (2899, '安多', 425, 'a', 'ad', 'anduo', '', '县', '540624', '0896', 5);
INSERT INTO `district` VALUES (2900, '申扎', 425, 's', 'sz', 'shenzha', '', '县', '540625', '0896', 6);
INSERT INTO `district` VALUES (2901, '索县', 425, 's', 'sx', 'suoxian', '', '', '540626', '0896', 7);
INSERT INTO `district` VALUES (2902, '班戈', 425, 'b', 'bg', 'bange', '', '县', '540627', '0896', 8);
INSERT INTO `district` VALUES (2903, '巴青', 425, 'b', 'bq', 'baqing', '', '县', '540628', '0896', 9);
INSERT INTO `district` VALUES (2904, '尼玛', 425, 'n', 'nm', 'nima', '', '县', '540629', '0896', 10);
INSERT INTO `district` VALUES (2905, '普兰', 426, 'p', 'pl', 'pulan', '', '县', '542521', '0897', 1);
INSERT INTO `district` VALUES (2906, '札达', 426, 'z', 'zd', 'zhada', '', '县', '542522', '0897', 2);
INSERT INTO `district` VALUES (2907, '噶尔', 426, 'g', 'ge', 'gaer', '', '县', '542523', '0897', 3);
INSERT INTO `district` VALUES (2908, '日土', 426, 'r', 'rt', 'ritu', '', '县', '542524', '0897', 4);
INSERT INTO `district` VALUES (2909, '革吉', 426, 'g', 'gj', 'geji', '', '县', '542525', '0897', 5);
INSERT INTO `district` VALUES (2910, '改则', 426, 'g', 'gz', 'gaize', '', '县', '542526', '0897', 6);
INSERT INTO `district` VALUES (2911, '措勤', 426, 'c', 'cq', 'cuoqin', '', '县', '542527', '0897', 7);
INSERT INTO `district` VALUES (2912, '巴宜', 427, 'b', 'by', 'bayi', '', '区', '540402', '0894', 1);
INSERT INTO `district` VALUES (2913, '工布江达', 427, 'g', 'gbjd', 'gongbujiangda', '', '县', '542621', '0894', 2);
INSERT INTO `district` VALUES (2914, '米林', 427, 'm', 'ml', 'milin', '', '县', '542621', '0894', 3);
INSERT INTO `district` VALUES (2915, '墨脱', 427, 'm', 'mt', 'motuo', '', '县', '542621', '0894', 4);
INSERT INTO `district` VALUES (2916, '波密', 427, 'b', 'bm', 'bomi', '', '县', '542621', '0894', 5);
INSERT INTO `district` VALUES (2917, '察隅', 427, 'c', 'cy', 'chayu', '', '县', '542621', '0894', 6);
INSERT INTO `district` VALUES (2918, '朗县', 427, 'l', 'lx', 'langxian', '', '', '542621', '0894', 7);
INSERT INTO `district` VALUES (2919, '新城', 428, 'x', 'xc', 'xincheng', '', '区', '610102', '029', 1);
INSERT INTO `district` VALUES (2920, '碑林', 428, 'b', 'bl', 'beilin', '', '区', '610103', '029', 2);
INSERT INTO `district` VALUES (2921, '莲湖', 428, 'l', 'lh', 'lianhu', '', '区', '610104', '029', 3);
INSERT INTO `district` VALUES (2922, '灞桥', 428, 'b', 'bq', 'baqiao', '', '区', '610111', '029', 4);
INSERT INTO `district` VALUES (2923, '未央', 428, 'w', 'wy', 'weiyang', '', '区', '610112', '029', 5);
INSERT INTO `district` VALUES (2924, '雁塔', 428, 'y', 'yt', 'yanta', '', '区', '610113', '029', 6);
INSERT INTO `district` VALUES (2925, '阎良', 428, 'y', 'yl', 'yanliang', '', '区', '610114', '029', 7);
INSERT INTO `district` VALUES (2926, '临潼', 428, 'l', 'lt', 'lintong', '', '区', '610115', '029', 8);
INSERT INTO `district` VALUES (2927, '长安', 428, 'c', 'ca', 'changan', '', '区', '610116', '029', 9);
INSERT INTO `district` VALUES (2928, '蓝田', 428, 'l', 'lt', 'lantian', '', '县', '610122', '029', 12);
INSERT INTO `district` VALUES (2929, '周至', 428, 'z', 'zz', 'zhouzhi', '', '县', '610124', '029', 13);
INSERT INTO `district` VALUES (2930, '鄠邑', 428, 'h', 'hy', 'huyi', '', '区', '610118', '029', 11);
INSERT INTO `district` VALUES (2931, '高陵', 428, 'g', 'gl', 'gaoling', '', '区', '610117', '029', 10);
INSERT INTO `district` VALUES (2932, '王益', 429, 'w', 'wy', 'wangyi', '', '区', '610202', '0919', 1);
INSERT INTO `district` VALUES (2933, '印台', 429, 'y', 'yt', 'yintai', '', '区', '610203', '0919', 2);
INSERT INTO `district` VALUES (2934, '耀州', 429, 'y', 'yz', 'yaozhou', '', '区', '610204', '0919', 3);
INSERT INTO `district` VALUES (2935, '宜君', 429, 'y', 'yj', 'yijun', '', '县', '610222', '0919', 4);
INSERT INTO `district` VALUES (2936, '渭滨', 430, 'w', 'wb', 'weibin', '', '区', '610302', '0917', 1);
INSERT INTO `district` VALUES (2937, '金台', 430, 'j', 'jt', 'jintai', '', '区', '610303', '0917', 2);
INSERT INTO `district` VALUES (2938, '陈仓', 430, 'c', 'cc', 'chencang', '', '区', '610304', '0917', 3);
INSERT INTO `district` VALUES (2939, '凤翔', 430, 'f', 'fx', 'fengxiang', '', '县', '610322', '0917', 4);
INSERT INTO `district` VALUES (2940, '岐山', 430, 'q', 'qs', 'qishan', '', '县', '610323', '0917', 5);
INSERT INTO `district` VALUES (2941, '扶风', 430, 'f', 'ff', 'fufeng', '', '县', '610324', '0917', 6);
INSERT INTO `district` VALUES (2942, '眉县', 430, 'm', 'mx', 'meixian', '', '', '610326', '0917', 7);
INSERT INTO `district` VALUES (2943, '陇县', 430, 'l', 'lx', 'longxian', '', '', '610327', '0917', 8);
INSERT INTO `district` VALUES (2944, '千阳', 430, 'q', 'qy', 'qianyang', '', '县', '610328', '0917', 9);
INSERT INTO `district` VALUES (2945, '麟游', 430, 'l', 'ly', 'linyou', '', '县', '610329', '0917', 10);
INSERT INTO `district` VALUES (2946, '凤县', 430, 'f', 'fx', 'fengxian', '', '', '610330', '0917', 11);
INSERT INTO `district` VALUES (2947, '太白', 430, 't', 'tb', 'taibai', '', '县', '610331', '0917', 12);
INSERT INTO `district` VALUES (2948, '秦都', 431, 'q', 'qd', 'qindu', '', '区', '610402', '029', 1);
INSERT INTO `district` VALUES (2949, '杨陵', 431, 'y', 'yl', 'yangling', '', '区', '610403', '029', 2);
INSERT INTO `district` VALUES (2950, '渭城', 431, 'w', 'wc', 'weicheng', '', '区', '610404', '029', 3);
INSERT INTO `district` VALUES (2951, '三原', 431, 's', 'sy', 'sanyuan', '', '县', '610422', '029', 4);
INSERT INTO `district` VALUES (2952, '泾阳', 431, 'j', 'jy', 'jingyang', '', '县', '610423', '029', 5);
INSERT INTO `district` VALUES (2953, '乾县', 431, 'q', 'qx', 'qianxian', '', '', '610424', '029', 6);
INSERT INTO `district` VALUES (2954, '礼泉', 431, 'l', 'lq', 'liquan', '', '县', '610425', '029', 7);
INSERT INTO `district` VALUES (2955, '永寿', 431, 'y', 'ys', 'yongshou', '', '县', '610426', '029', 8);
INSERT INTO `district` VALUES (2956, '彬州', 431, 'b', 'bz', 'binzhou', '', '市', '610482', '029', 14);
INSERT INTO `district` VALUES (2957, '长武', 431, 'c', 'cw', 'changwu', '', '县', '610428', '029', 9);
INSERT INTO `district` VALUES (2958, '旬邑', 431, 'x', 'xy', 'xunyi', '', '县', '610429', '029', 10);
INSERT INTO `district` VALUES (2959, '淳化', 431, 'c', 'ch', 'chunhua', '', '县', '610430', '029', 11);
INSERT INTO `district` VALUES (2960, '武功', 431, 'w', 'wg', 'wugong', '', '县', '610431', '029', 12);
INSERT INTO `district` VALUES (2961, '兴平', 431, 'x', 'xp', 'xingping', '', '市', '610481', '029', 13);
INSERT INTO `district` VALUES (2962, '临渭', 432, 'l', 'lw', 'linwei', '', '区', '610502', '0913', 1);
INSERT INTO `district` VALUES (2963, '华州', 432, 'h', 'hz', 'huazhou', '', '区', '610521', '0913', 2);
INSERT INTO `district` VALUES (2964, '潼关', 432, 't', 'tg', 'tongguan', '', '县', '610522', '0913', 3);
INSERT INTO `district` VALUES (2965, '大荔', 432, 'd', 'dl', 'dali', '', '县', '610523', '0913', 4);
INSERT INTO `district` VALUES (2966, '合阳', 432, 'h', 'hy', 'heyang', '', '县', '610524', '0913', 5);
INSERT INTO `district` VALUES (2967, '澄城', 432, 'c', 'cc', 'chengcheng', '', '县', '610525', '0913', 6);
INSERT INTO `district` VALUES (2968, '蒲城', 432, 'p', 'pc', 'pucheng', '', '县', '610526', '0913', 7);
INSERT INTO `district` VALUES (2969, '白水', 432, 'b', 'bs', 'baishui', '', '县', '610527', '0913', 8);
INSERT INTO `district` VALUES (2970, '富平', 432, 'f', 'fp', 'fuping', '', '县', '610528', '0913', 9);
INSERT INTO `district` VALUES (2971, '韩城', 432, 'h', 'hc', 'hancheng', '', '市', '610581', '0913', 10);
INSERT INTO `district` VALUES (2972, '华阴', 432, 'h', 'hy', 'huayin', '', '市', '610582', '0913', 11);
INSERT INTO `district` VALUES (2973, '宝塔', 433, 'b', 'bt', 'baota', '', '区', '610602', '0911', 1);
INSERT INTO `district` VALUES (2974, '延长', 433, 'y', 'yc', 'yanchang', '', '县', '610621', '0911', 3);
INSERT INTO `district` VALUES (2975, '延川', 433, 'y', 'yc', 'yanchuan', '', '县', '610622', '0911', 4);
INSERT INTO `district` VALUES (2976, '子长', 433, 'z', 'zc', 'zichang', '', '市', '610681', '0911', 13);
INSERT INTO `district` VALUES (2977, '安塞', 433, 'a', 'as', 'ansai', '', '区', '610603', '0911', 2);
INSERT INTO `district` VALUES (2978, '志丹', 433, 'z', 'zd', 'zhidan', '', '县', '610625', '0911', 5);
INSERT INTO `district` VALUES (2979, '吴起', 433, 'w', 'wq', 'wuqi', '', '县', '610626', '0911', 6);
INSERT INTO `district` VALUES (2980, '甘泉', 433, 'g', 'gq', 'ganquan', '', '县', '610627', '0911', 7);
INSERT INTO `district` VALUES (2981, '富县', 433, 'f', 'fx', 'fuxian', '', '', '610628', '0911', 8);
INSERT INTO `district` VALUES (2982, '洛川', 433, 'l', 'lc', 'luochuan', '', '县', '610629', '0911', 9);
INSERT INTO `district` VALUES (2983, '宜川', 433, 'y', 'yc', 'yichuan', '', '县', '610630', '0911', 10);
INSERT INTO `district` VALUES (2984, '黄龙', 433, 'h', 'hl', 'huanglong', '', '县', '610631', '0911', 11);
INSERT INTO `district` VALUES (2985, '黄陵', 433, 'h', 'hl', 'huangling', '', '县', '610632', '0911', 12);
INSERT INTO `district` VALUES (2986, '汉台', 434, 'h', 'ht', 'hantai', '', '区', '610702', '0916', 1);
INSERT INTO `district` VALUES (2987, '南郑', 434, 'n', 'nz', 'nanzheng', '', '区', '610703', '0916', 2);
INSERT INTO `district` VALUES (2988, '城固', 434, 'c', 'cg', 'chenggu', '', '县', '610722', '0916', 3);
INSERT INTO `district` VALUES (2989, '洋县', 434, 'y', 'yx', 'yangxian', '', '', '610723', '0916', 4);
INSERT INTO `district` VALUES (2990, '西乡', 434, 'x', 'xx', 'xixiang', '', '县', '610724', '0916', 5);
INSERT INTO `district` VALUES (2991, '勉县', 434, 'm', 'mx', 'mianxian', '', '', '610725', '0916', 6);
INSERT INTO `district` VALUES (2992, '宁强', 434, 'n', 'nq', 'ningqiang', '', '县', '610726', '0916', 7);
INSERT INTO `district` VALUES (2993, '略阳', 434, 'l', 'ly', 'lu:eyang', '', '县', '610727', '0916', 8);
INSERT INTO `district` VALUES (2994, '镇巴', 434, 'z', 'zb', 'zhenba', '', '县', '610728', '0916', 9);
INSERT INTO `district` VALUES (2995, '留坝', 434, 'l', 'lb', 'liuba', '', '县', '610729', '0916', 10);
INSERT INTO `district` VALUES (2996, '佛坪', 434, 'f', 'fp', 'foping', '', '县', '610730', '0916', 11);
INSERT INTO `district` VALUES (2997, '榆阳', 435, 'y', 'yy', 'yuyang', '', '区', '610802', '0912', 1);
INSERT INTO `district` VALUES (2998, '神木', 435, 's', 'sm', 'shenmu', '', '市', '610881', '0912', 12);
INSERT INTO `district` VALUES (2999, '府谷', 435, 'f', 'fg', 'fugu', '', '县', '610822', '0912', 2);
INSERT INTO `district` VALUES (3000, '横山', 435, 'h', 'hs', 'hengshan', '', '区', '610823', '0912', 3);
INSERT INTO `district` VALUES (3001, '靖边', 435, 'j', 'jb', 'jingbian', '', '县', '610824', '0912', 4);
INSERT INTO `district` VALUES (3002, '定边', 435, 'd', 'db', 'dingbian', '', '县', '610825', '0912', 5);
INSERT INTO `district` VALUES (3003, '绥德', 435, 's', 'sd', 'suide', '', '县', '610826', '0912', 6);
INSERT INTO `district` VALUES (3004, '米脂', 435, 'm', 'mz', 'mizhi', '', '县', '610827', '0912', 7);
INSERT INTO `district` VALUES (3005, '佳县', 435, 'j', 'jx', 'jiaxian', '', '', '610828', '0912', 8);
INSERT INTO `district` VALUES (3006, '吴堡', 435, 'w', 'wb', 'wubao', '', '县', '610829', '0912', 9);
INSERT INTO `district` VALUES (3007, '清涧', 435, 'q', 'qj', 'qingjian', '', '县', '610830', '0912', 10);
INSERT INTO `district` VALUES (3008, '子洲', 435, 'z', 'zz', 'zizhou', '', '县', '610831', '0912', 11);
INSERT INTO `district` VALUES (3009, '汉滨', 436, 'h', 'hb', 'hanbin', '', '区', '610902', '0915', 1);
INSERT INTO `district` VALUES (3010, '汉阴', 436, 'h', 'hy', 'hanyin', '', '县', '610921', '0915', 2);
INSERT INTO `district` VALUES (3011, '石泉', 436, 's', 'sq', 'shiquan', '', '县', '610922', '0915', 3);
INSERT INTO `district` VALUES (3012, '宁陕', 436, 'n', 'ns', 'ningshan', '', '县', '610923', '0915', 4);
INSERT INTO `district` VALUES (3013, '紫阳', 436, 'z', 'zy', 'ziyang', '', '县', '610924', '0915', 5);
INSERT INTO `district` VALUES (3014, '岚皋', 436, 'l', 'lg', 'langao', '', '县', '610925', '0915', 6);
INSERT INTO `district` VALUES (3015, '平利', 436, 'p', 'pl', 'pingli', '', '县', '610926', '0915', 7);
INSERT INTO `district` VALUES (3016, '镇坪', 436, 'z', 'zp', 'zhenping', '', '县', '610927', '0915', 8);
INSERT INTO `district` VALUES (3017, '旬阳', 436, 'x', 'xy', 'xunyang', '', '县', '610928', '0915', 9);
INSERT INTO `district` VALUES (3018, '白河', 436, 'b', 'bh', 'baihe', '', '县', '610929', '0915', 10);
INSERT INTO `district` VALUES (3019, '商州', 437, 's', 'sz', 'shangzhou', '', '区', '611002', '0914', 1);
INSERT INTO `district` VALUES (3020, '洛南', 437, 'l', 'ln', 'luonan', '', '县', '611021', '0914', 2);
INSERT INTO `district` VALUES (3021, '丹凤', 437, 'd', 'df', 'danfeng', '', '县', '611022', '0914', 3);
INSERT INTO `district` VALUES (3022, '商南', 437, 's', 'sn', 'shangnan', '', '县', '611023', '0914', 4);
INSERT INTO `district` VALUES (3023, '山阳', 437, 's', 'sy', 'shanyang', '', '县', '611024', '0914', 5);
INSERT INTO `district` VALUES (3024, '镇安', 437, 'z', 'za', 'zhenan', '', '县', '611025', '0914', 6);
INSERT INTO `district` VALUES (3025, '柞水', 437, 'z', 'zs', 'zuoshui', '', '县', '611026', '0914', 7);
INSERT INTO `district` VALUES (3026, '城关', 438, 'c', 'cg', 'chengguan', '', '区', '620102', '0931', 1);
INSERT INTO `district` VALUES (3027, '七里河', 438, 'q', 'qlh', 'qilihe', '', '区', '620103', '0931', 2);
INSERT INTO `district` VALUES (3028, '西固', 438, 'x', 'xg', 'xigu', '', '区', '620104', '0931', 3);
INSERT INTO `district` VALUES (3029, '安宁', 438, 'a', 'an', 'anning', '', '区', '620105', '0931', 4);
INSERT INTO `district` VALUES (3030, '红古', 438, 'h', 'hg', 'honggu', '', '区', '620111', '0931', 5);
INSERT INTO `district` VALUES (3031, '永登', 438, 'y', 'yd', 'yongdeng', '', '县', '620121', '0931', 6);
INSERT INTO `district` VALUES (3032, '皋兰', 438, 'g', 'gl', 'gaolan', '', '县', '620122', '0931', 7);
INSERT INTO `district` VALUES (3033, '榆中', 438, 'y', 'yz', 'yuzhong', '', '县', '620123', '0931', 8);
INSERT INTO `district` VALUES (3034, '镜铁', 439, 'j', 'jt', 'jingtie', '', '区', '620201', '0937', 1);
INSERT INTO `district` VALUES (3035, '长城', 439, 'c', 'cc', 'changcheng', '', '区', '620201', '0937', 2);
INSERT INTO `district` VALUES (3036, '雄关', 439, 'x', 'xg', 'xiongguan', '', '区', '620201', '0937', 3);
INSERT INTO `district` VALUES (3037, '金川', 440, 'j', 'jc', 'jinchuan', '', '区', '620302', '0935', 1);
INSERT INTO `district` VALUES (3038, '永昌', 440, 'y', 'yc', 'yongchang', '', '县', '620321', '0935', 2);
INSERT INTO `district` VALUES (3039, '白银', 441, 'b', 'by', 'baiyin', '', '区', '620402', '0943', 1);
INSERT INTO `district` VALUES (3040, '平川', 441, 'p', 'pc', 'pingchuan', '', '区', '620403', '0943', 2);
INSERT INTO `district` VALUES (3041, '靖远', 441, 'j', 'jy', 'jingyuan', '', '县', '620421', '0943', 3);
INSERT INTO `district` VALUES (3042, '会宁', 441, 'h', 'hn', 'huining', '', '县', '620422', '0943', 4);
INSERT INTO `district` VALUES (3043, '景泰', 441, 'j', 'jt', 'jingtai', '', '县', '620423', '0943', 5);
INSERT INTO `district` VALUES (3044, '秦州', 442, 'q', 'qz', 'qinzhou', '', '区', '620502', '0938', 1);
INSERT INTO `district` VALUES (3045, '麦积', 442, 'm', 'mj', 'maiji', '', '区', '620503', '0938', 2);
INSERT INTO `district` VALUES (3046, '清水', 442, 'q', 'qs', 'qingshui', '', '县', '620521', '0938', 3);
INSERT INTO `district` VALUES (3047, '秦安', 442, 'q', 'qa', 'qinan', '', '县', '620522', '0938', 4);
INSERT INTO `district` VALUES (3048, '甘谷', 442, 'g', 'gg', 'gangu', '', '县', '620523', '0938', 5);
INSERT INTO `district` VALUES (3049, '武山', 442, 'w', 'ws', 'wushan', '', '县', '620524', '0938', 6);
INSERT INTO `district` VALUES (3050, '张家川', 442, 'z', 'zjc', 'zhangjiachuan', '回族', '自治县', '620525', '0938', 7);
INSERT INTO `district` VALUES (3051, '凉州', 443, 'l', 'lz', 'liangzhou', '', '区', '620602', '0935', 1);
INSERT INTO `district` VALUES (3052, '民勤', 443, 'm', 'mq', 'minqin', '', '县', '620621', '0935', 2);
INSERT INTO `district` VALUES (3053, '古浪', 443, 'g', 'gl', 'gulang', '', '县', '620622', '0935', 3);
INSERT INTO `district` VALUES (3054, '天祝', 443, 't', 'tz', 'tianzhu', '藏族', '自治县', '620623', '0935', 4);
INSERT INTO `district` VALUES (3055, '甘州', 444, 'g', 'gz', 'ganzhou', '', '区', '620702', '0936', 1);
INSERT INTO `district` VALUES (3056, '肃南', 444, 's', 'sn', 'sunan', '裕固族', '自治县', '620721', '0936', 2);
INSERT INTO `district` VALUES (3057, '民乐', 444, 'm', 'ml', 'minle', '', '县', '620722', '0936', 3);
INSERT INTO `district` VALUES (3058, '临泽', 444, 'l', 'lz', 'linze', '', '县', '620723', '0936', 4);
INSERT INTO `district` VALUES (3059, '高台', 444, 'g', 'gt', 'gaotai', '', '县', '620724', '0936', 5);
INSERT INTO `district` VALUES (3060, '山丹', 444, 's', 'sd', 'shandan', '', '县', '620725', '0936', 6);
INSERT INTO `district` VALUES (3061, '崆峒', 445, 'k', 'kt', 'kongtong', '', '区', '620802', '0933', 1);
INSERT INTO `district` VALUES (3062, '泾川', 445, 'j', 'jc', 'jingchuan', '', '县', '620821', '0933', 2);
INSERT INTO `district` VALUES (3063, '灵台', 445, 'l', 'lt', 'lingtai', '', '县', '620822', '0933', 3);
INSERT INTO `district` VALUES (3064, '崇信', 445, 'c', 'cx', 'chongxin', '', '县', '620823', '0933', 4);
INSERT INTO `district` VALUES (3065, '华亭', 445, 'h', 'ht', 'huating', '', '市', '620881', '0933', 7);
INSERT INTO `district` VALUES (3066, '庄浪', 445, 'z', 'zl', 'zhuanglang', '', '县', '620825', '0933', 5);
INSERT INTO `district` VALUES (3067, '静宁', 445, 'j', 'jn', 'jingning', '', '县', '620826', '0933', 6);
INSERT INTO `district` VALUES (3068, '肃州', 446, 's', 'sz', 'suzhou', '', '区', '620902', '0937', 1);
INSERT INTO `district` VALUES (3069, '金塔', 446, 'j', 'jt', 'jinta', '', '县', '620921', '0937', 2);
INSERT INTO `district` VALUES (3070, '瓜州', 446, 'g', 'gz', 'guazhou', '', '县', '620922', '0937', 3);
INSERT INTO `district` VALUES (3071, '肃北', 446, 's', 'sb', 'subei', '蒙古族', '自治县', '620923', '0937', 4);
INSERT INTO `district` VALUES (3072, '阿克塞', 446, 'a', 'aks', 'akesai', '哈萨克族', '自治县', '620924', '0937', 5);
INSERT INTO `district` VALUES (3073, '玉门', 446, 'y', 'ym', 'yumen', '', '市', '620981', '0937', 6);
INSERT INTO `district` VALUES (3074, '敦煌', 446, 'd', 'dh', 'dunhuang', '', '市', '620982', '0937', 7);
INSERT INTO `district` VALUES (3075, '西峰', 447, 'x', 'xf', 'xifeng', '', '区', '621002', '0934', 1);
INSERT INTO `district` VALUES (3076, '庆城', 447, 'q', 'qc', 'qingcheng', '', '县', '621021', '0934', 2);
INSERT INTO `district` VALUES (3077, '环县', 447, 'h', 'hx', 'huanxian', '', '', '621022', '0934', 3);
INSERT INTO `district` VALUES (3078, '华池', 447, 'h', 'hc', 'huachi', '', '县', '621023', '0934', 4);
INSERT INTO `district` VALUES (3079, '合水', 447, 'h', 'hs', 'heshui', '', '县', '621024', '0934', 5);
INSERT INTO `district` VALUES (3080, '正宁', 447, 'z', 'zn', 'zhengning', '', '县', '621025', '0934', 6);
INSERT INTO `district` VALUES (3081, '宁县', 447, 'n', 'nx', 'ningxian', '', '', '621026', '0934', 7);
INSERT INTO `district` VALUES (3082, '镇原', 447, 'z', 'zy', 'zhenyuan', '', '县', '621027', '0934', 8);
INSERT INTO `district` VALUES (3083, '安定', 448, 'a', 'ad', 'anding', '', '区', '621102', '0932', 1);
INSERT INTO `district` VALUES (3084, '通渭', 448, 't', 'tw', 'tongwei', '', '县', '621121', '0932', 2);
INSERT INTO `district` VALUES (3085, '陇西', 448, 'l', 'lx', 'longxi', '', '县', '621122', '0932', 3);
INSERT INTO `district` VALUES (3086, '渭源', 448, 'w', 'wy', 'weiyuan', '', '县', '621123', '0932', 4);
INSERT INTO `district` VALUES (3087, '临洮', 448, 'l', 'lt', 'lintao', '', '县', '621124', '0932', 5);
INSERT INTO `district` VALUES (3088, '漳县', 448, 'z', 'zx', 'zhangxian', '', '', '621125', '0932', 6);
INSERT INTO `district` VALUES (3089, '岷县', 448, 'm', 'mx', 'minxian', '', '', '621126', '0932', 7);
INSERT INTO `district` VALUES (3090, '武都', 449, 'w', 'wd', 'wudu', '', '区', '621202', '0939', 1);
INSERT INTO `district` VALUES (3091, '成县', 449, 'c', 'cx', 'chengxian', '', '', '621221', '0939', 2);
INSERT INTO `district` VALUES (3092, '文县', 449, 'w', 'wx', 'wenxian', '', '', '621222', '0939', 3);
INSERT INTO `district` VALUES (3093, '宕昌', 449, 'd', 'dc', 'dangchang', '', '县', '621223', '0939', 4);
INSERT INTO `district` VALUES (3094, '康县', 449, 'k', 'kx', 'kangxian', '', '', '621224', '0939', 5);
INSERT INTO `district` VALUES (3095, '西和', 449, 'x', 'xh', 'xihe', '', '县', '621225', '0939', 6);
INSERT INTO `district` VALUES (3096, '礼县', 449, 'l', 'lx', 'lixian', '', '', '621226', '0939', 7);
INSERT INTO `district` VALUES (3097, '徽县', 449, 'h', 'hx', 'huixian', '', '', '621227', '0939', 8);
INSERT INTO `district` VALUES (3098, '两当', 449, 'l', 'ld', 'liangdang', '', '县', '621228', '0939', 9);
INSERT INTO `district` VALUES (3099, '临夏', 450, 'l', 'lx', 'linxia', '', '市', '622901', '0930', 1);
INSERT INTO `district` VALUES (3100, '临夏', 450, 'l', 'lx', 'linxia', '', '县', '622921', '0930', 2);
INSERT INTO `district` VALUES (3101, '康乐', 450, 'k', 'kl', 'kangle', '', '县', '622922', '0930', 3);
INSERT INTO `district` VALUES (3102, '永靖', 450, 'y', 'yj', 'yongjing', '', '县', '622923', '0930', 4);
INSERT INTO `district` VALUES (3103, '广河', 450, 'g', 'gh', 'guanghe', '', '县', '622924', '0930', 5);
INSERT INTO `district` VALUES (3104, '和政', 450, 'h', 'hz', 'hezheng', '', '县', '622925', '0930', 6);
INSERT INTO `district` VALUES (3105, '东乡族', 450, 'd', 'dxz', 'dongxiangzu', '', '自治县', '622926', '0930', 7);
INSERT INTO `district` VALUES (3106, '积石山', 450, 'j', 'jss', 'jishishan', '保安族东乡族撒拉族', '自治县', '622927', '0930', 8);
INSERT INTO `district` VALUES (3107, '合作', 451, 'h', 'hz', 'hezuo', '', '市', '623001', '0941', 1);
INSERT INTO `district` VALUES (3108, '临潭', 451, 'l', 'lt', 'lintan', '', '县', '623021', '0941', 2);
INSERT INTO `district` VALUES (3109, '卓尼', 451, 'z', 'zn', 'zhuoni', '', '县', '623022', '0941', 3);
INSERT INTO `district` VALUES (3110, '舟曲', 451, 'z', 'zq', 'zhouqu', '', '县', '623023', '0941', 4);
INSERT INTO `district` VALUES (3111, '迭部', 451, 'd', 'db', 'diebu', '', '县', '623024', '0941', 5);
INSERT INTO `district` VALUES (3112, '玛曲', 451, 'm', 'mq', 'maqu', '', '县', '623025', '0941', 6);
INSERT INTO `district` VALUES (3113, '碌曲', 451, 'l', 'lq', 'liuqu', '', '县', '623026', '0941', 7);
INSERT INTO `district` VALUES (3114, '夏河', 451, 'x', 'xh', 'xiahe', '', '县', '623027', '0941', 8);
INSERT INTO `district` VALUES (3115, '城东', 452, 'c', 'cd', 'chengdong', '', '区', '630102', '0971', 1);
INSERT INTO `district` VALUES (3116, '城中', 452, 'c', 'cz', 'chengzhong', '', '区', '630103', '0971', 2);
INSERT INTO `district` VALUES (3117, '城西', 452, 'c', 'cx', 'chengxi', '', '区', '630104', '0971', 3);
INSERT INTO `district` VALUES (3118, '城北', 452, 'c', 'cb', 'chengbei', '', '区', '630105', '0971', 4);
INSERT INTO `district` VALUES (3119, '大通', 452, 'd', 'dt', 'datong', '回族土族', '自治县', '630121', '0971', 6);
INSERT INTO `district` VALUES (3120, '湟中', 452, 'h', 'hz', 'huangzhong', '', '区', '630106', '0971', 5);
INSERT INTO `district` VALUES (3121, '湟源', 452, 'h', 'hy', 'huangyuan', '', '县', '630123', '0971', 7);
INSERT INTO `district` VALUES (3122, '乐都', 453, 'l', 'ld', 'ledu', '', '区', '630202', '0972', 1);
INSERT INTO `district` VALUES (3123, '平安', 453, 'p', 'pa', 'pingan', '', '区', '632121', '0972', 2);
INSERT INTO `district` VALUES (3124, '民和', 453, 'm', 'mh', 'minhe', '回族土族', '自治县', '632122', '0972', 3);
INSERT INTO `district` VALUES (3125, '互助', 453, 'h', 'hz', 'huzhu', '土族', '自治县', '632126', '0972', 4);
INSERT INTO `district` VALUES (3126, '化隆', 453, 'h', 'hl', 'hualong', '回族', '自治县', '632127', '0972', 5);
INSERT INTO `district` VALUES (3127, '循化', 453, 'x', 'xh', 'xunhua', '撒拉族', '自治县', '632128', '0972', 6);
INSERT INTO `district` VALUES (3128, '门源', 454, 'm', 'my', 'menyuan', '回族', '自治县', '632221', '0970', 1);
INSERT INTO `district` VALUES (3129, '祁连', 454, 'q', 'ql', 'qilian', '', '县', '632222', '0970', 2);
INSERT INTO `district` VALUES (3130, '海晏', 454, 'h', 'hy', 'haiyan', '', '县', '632223', '0970', 3);
INSERT INTO `district` VALUES (3131, '刚察', 454, 'g', 'gc', 'gangcha', '', '县', '632224', '0970', 4);
INSERT INTO `district` VALUES (3132, '同仁', 455, 't', 'tr', 'tongren', '', '县', '632321', '0973', 1);
INSERT INTO `district` VALUES (3133, '尖扎', 455, 'j', 'jz', 'jianzha', '', '县', '632322', '0973', 2);
INSERT INTO `district` VALUES (3134, '泽库', 455, 'z', 'zk', 'zeku', '', '县', '632323', '0973', 3);
INSERT INTO `district` VALUES (3135, '河南', 455, 'h', 'hn', 'henan', '蒙古族', '自治县', '632324', '0973', 4);
INSERT INTO `district` VALUES (3136, '共和', 456, 'g', 'gh', 'gonghe', '', '县', '632521', '0974', 1);
INSERT INTO `district` VALUES (3137, '同德', 456, 't', 'td', 'tongde', '', '县', '632522', '0974', 2);
INSERT INTO `district` VALUES (3138, '贵德', 456, 'g', 'gd', 'guide', '', '县', '632523', '0974', 3);
INSERT INTO `district` VALUES (3139, '兴海', 456, 'x', 'xh', 'xinghai', '', '县', '632524', '0974', 4);
INSERT INTO `district` VALUES (3140, '贵南', 456, 'g', 'gn', 'guinan', '', '县', '632525', '0974', 5);
INSERT INTO `district` VALUES (3141, '玛沁', 457, 'm', 'mq', 'maqin', '', '县', '632621', '0975', 1);
INSERT INTO `district` VALUES (3142, '班玛', 457, 'b', 'bm', 'banma', '', '县', '632622', '0975', 2);
INSERT INTO `district` VALUES (3143, '甘德', 457, 'g', 'gd', 'gande', '', '县', '632623', '0975', 3);
INSERT INTO `district` VALUES (3144, '达日', 457, 'd', 'dr', 'dari', '', '县', '632624', '0975', 4);
INSERT INTO `district` VALUES (3145, '久治', 457, 'j', 'jz', 'jiuzhi', '', '县', '632625', '0975', 5);
INSERT INTO `district` VALUES (3146, '玛多', 457, 'm', 'md', 'maduo', '', '县', '632626', '0975', 6);
INSERT INTO `district` VALUES (3147, '玉树', 458, 'y', 'ys', 'yushu', '', '市', '632721', '0976', 1);
INSERT INTO `district` VALUES (3148, '杂多', 458, 'z', 'zd', 'zaduo', '', '县', '632722', '0976', 2);
INSERT INTO `district` VALUES (3149, '治多', 458, 'z', 'zd', 'zhiduo', '', '县', '632724', '0976', 3);
INSERT INTO `district` VALUES (3150, '囊谦', 458, 'n', 'nq', 'nangqian', '', '县', '632725', '0976', 4);
INSERT INTO `district` VALUES (3151, '曲麻莱', 458, 'q', 'qml', 'qumalai', '', '县', '632726', '0976', 5);
INSERT INTO `district` VALUES (3154, '茫崖', 459, 'm', 'my', 'mangya', '', '市', '632803', '0977', 3);
INSERT INTO `district` VALUES (3155, '格尔木', 459, 'g', 'gem', 'geermu', '', '市', '632801', '0977', 1);
INSERT INTO `district` VALUES (3156, '德令哈', 459, 'd', 'dlh', 'delingha', '', '市', '632802', '0977', 2);
INSERT INTO `district` VALUES (3157, '乌兰', 459, 'w', 'wl', 'wulan', '', '县', '632821', '0977', 4);
INSERT INTO `district` VALUES (3158, '都兰', 459, 'd', 'dl', 'dulan', '', '县', '632822', '0977', 5);
INSERT INTO `district` VALUES (3159, '天峻', 459, 't', 'tj', 'tianjun', '', '县', '632823', '0977', 6);
INSERT INTO `district` VALUES (3160, '兴庆', 460, 'x', 'xq', 'xingqing', '', '区', '640104', '0951', 1);
INSERT INTO `district` VALUES (3161, '西夏', 460, 'x', 'xx', 'xixia', '', '区', '640105', '0951', 2);
INSERT INTO `district` VALUES (3162, '金凤', 460, 'j', 'jf', 'jinfeng', '', '区', '640106', '0951', 3);
INSERT INTO `district` VALUES (3163, '永宁', 460, 'y', 'yn', 'yongning', '', '县', '640121', '0951', 4);
INSERT INTO `district` VALUES (3164, '贺兰', 460, 'h', 'hl', 'helan', '', '县', '640122', '0951', 5);
INSERT INTO `district` VALUES (3165, '灵武', 460, 'l', 'lw', 'lingwu', '', '市', '640181', '0951', 6);
INSERT INTO `district` VALUES (3166, '大武口', 461, 'd', 'dwk', 'dawukou', '', '区', '640202', '0952', 1);
INSERT INTO `district` VALUES (3167, '惠农', 461, 'h', 'hn', 'huinong', '', '区', '640205', '0952', 2);
INSERT INTO `district` VALUES (3168, '平罗', 461, 'p', 'pl', 'pingluo', '', '县', '640221', '0952', 3);
INSERT INTO `district` VALUES (3169, '红寺堡', 462, 'h', 'hsb', 'hongsibao', '', '区', '', '0953', 1);
INSERT INTO `district` VALUES (3170, '利通', 462, 'l', 'lt', 'litong', '', '区', '640302', '0953', 2);
INSERT INTO `district` VALUES (3171, '盐池', 462, 'y', 'yc', 'yanchi', '', '县', '640323', '0953', 3);
INSERT INTO `district` VALUES (3172, '同心', 462, 't', 'tx', 'tongxin', '', '县', '640324', '0953', 4);
INSERT INTO `district` VALUES (3173, '青铜峡', 462, 'q', 'qtx', 'qingtongxia', '', '市', '640381', '0953', 5);
INSERT INTO `district` VALUES (3174, '原州', 463, 'y', 'yz', 'yuanzhou', '', '区', '640402', '0954', 1);
INSERT INTO `district` VALUES (3175, '西吉', 463, 'x', 'xj', 'xiji', '', '县', '640422', '0954', 2);
INSERT INTO `district` VALUES (3176, '隆德', 463, 'l', 'ld', 'longde', '', '县', '640423', '0954', 3);
INSERT INTO `district` VALUES (3177, '泾源', 463, 'j', 'jy', 'jingyuan', '', '县', '640424', '0954', 4);
INSERT INTO `district` VALUES (3178, '彭阳', 463, 'p', 'py', 'pengyang', '', '县', '640425', '0954', 5);
INSERT INTO `district` VALUES (3179, '沙坡头', 464, 's', 'spt', 'shapotou', '', '区', '640502', '', 1);
INSERT INTO `district` VALUES (3180, '中宁', 464, 'z', 'zn', 'zhongning', '', '县', '640521', '', 2);
INSERT INTO `district` VALUES (3181, '海原', 464, 'h', 'hy', 'haiyuan', '', '县', '640522', '', 3);
INSERT INTO `district` VALUES (3182, '天山', 465, 't', 'ts', 'tianshan', '', '区', '650102', '0991', 1);
INSERT INTO `district` VALUES (3183, '沙依巴克', 465, 's', 'sybk', 'shayibake', '', '区', '650103', '0991', 2);
INSERT INTO `district` VALUES (3184, '新市', 465, 'x', 'xs', 'xinshi', '', '区', '650104', '0991', 3);
INSERT INTO `district` VALUES (3185, '水磨沟', 465, 's', 'smg', 'shuimogou', '', '区', '650105', '0991', 4);
INSERT INTO `district` VALUES (3186, '头屯河', 465, 't', 'tth', 'toutunhe', '', '区', '650106', '0991', 5);
INSERT INTO `district` VALUES (3187, '达坂城', 465, 'd', 'dbc', 'dabancheng', '', '区', '650107', '0991', 6);
INSERT INTO `district` VALUES (3188, '米东', 465, 'm', 'md', 'midong', '', '区', '650109', '0991', 7);
INSERT INTO `district` VALUES (3189, '乌鲁木齐', 465, 'w', 'wlmq', 'wulumuqi', '', '县', '650121', '0991', 8);
INSERT INTO `district` VALUES (3190, '独山子', 466, 'd', 'dsz', 'dushanzi', '', '区', '650202', '0990', 1);
INSERT INTO `district` VALUES (3191, '克拉玛依', 466, 'k', 'klmy', 'kelamayi', '', '区', '650203', '0990', 2);
INSERT INTO `district` VALUES (3192, '白碱滩', 466, 'b', 'bjt', 'baijiantan', '', '区', '650204', '0990', 3);
INSERT INTO `district` VALUES (3193, '乌尔禾', 466, 'w', 'weh', 'wuerhe', '', '区', '650205', '0990', 4);
INSERT INTO `district` VALUES (3194, '高昌', 467, 'g', 'gc', 'gaochang', '', '区', '652101', '0995', 1);
INSERT INTO `district` VALUES (3195, '鄯善', 467, 's', 'ss', 'shanshan', '', '县', '652122', '0995', 2);
INSERT INTO `district` VALUES (3196, '托克逊', 467, 't', 'tkx', 'tuokexun', '', '县', '652123', '0995', 3);
INSERT INTO `district` VALUES (3197, '伊州', 468, 'y', 'yz', 'yizhou', '', '区', '650502', '0902', 1);
INSERT INTO `district` VALUES (3198, '巴里坤', 468, 'b', 'blk', 'balikun', '哈萨克', '自治县', '650521', '0902', 2);
INSERT INTO `district` VALUES (3199, '伊吾', 468, 'y', 'yw', 'yiwu', '', '县', '650522', '0902', 3);
INSERT INTO `district` VALUES (3200, '昌吉', 469, 'c', 'cj', 'changji', '', '市', '652301', '0994', 1);
INSERT INTO `district` VALUES (3201, '阜康', 469, 'f', 'fk', 'fukang', '', '市', '652302', '0994', 2);
INSERT INTO `district` VALUES (3202, '呼图壁', 469, 'h', 'htb', 'hutubi', '', '县', '652323', '0994', 3);
INSERT INTO `district` VALUES (3203, '玛纳斯', 469, 'm', 'mns', 'manasi', '', '县', '652324', '0994', 4);
INSERT INTO `district` VALUES (3204, '奇台', 469, 'q', 'qt', 'qitai', '', '县', '652325', '0994', 5);
INSERT INTO `district` VALUES (3205, '吉木萨尔', 469, 'j', 'jmse', 'jimusaer', '', '县', '652327', '0994', 6);
INSERT INTO `district` VALUES (3206, '木垒', 469, 'm', 'ml', 'mulei', '哈萨克', '自治县', '652328', '0994', 7);
INSERT INTO `district` VALUES (3207, '阿拉山口', 470, 'a', 'alsk', 'alashankou', '', '市', '', '0909', 1);
INSERT INTO `district` VALUES (3208, '博乐', 470, 'b', 'bl', 'bole', '', '市', '652701', '0909', 2);
INSERT INTO `district` VALUES (3209, '精河', 470, 'j', 'jh', 'jinghe', '', '县', '652722', '0909', 3);
INSERT INTO `district` VALUES (3210, '温泉', 470, 'w', 'wq', 'wenquan', '', '县', '652723', '0909', 4);
INSERT INTO `district` VALUES (3211, '库尔勒', 471, 'k', 'kel', 'kuerle', '', '市', '652801', '0996', 1);
INSERT INTO `district` VALUES (3212, '轮台', 471, 'l', 'lt', 'luntai', '', '县', '652822', '0996', 2);
INSERT INTO `district` VALUES (3213, '尉犁', 471, 'w', 'wl', 'weili', '', '县', '652823', '0996', 3);
INSERT INTO `district` VALUES (3214, '若羌', 471, 'r', 'rq', 'ruoqiang', '', '县', '652824', '0996', 4);
INSERT INTO `district` VALUES (3215, '且末', 471, 'q', 'qm', 'qiemo', '', '县', '652825', '0996', 5);
INSERT INTO `district` VALUES (3216, '焉耆', 471, 'y', 'yq', 'yanqi', '回族', '自治县', '652826', '0996', 6);
INSERT INTO `district` VALUES (3217, '和静', 471, 'h', 'hj', 'hejing', '', '县', '652827', '0996', 7);
INSERT INTO `district` VALUES (3218, '和硕', 471, 'h', 'hs', 'heshuo', '', '县', '652828', '0996', 8);
INSERT INTO `district` VALUES (3219, '博湖', 471, 'b', 'bh', 'bohu', '', '县', '652829', '0996', 9);
INSERT INTO `district` VALUES (3220, '阿克苏', 472, 'a', 'aks', 'akesu', '', '市', '652901', '', 1);
INSERT INTO `district` VALUES (3221, '温宿', 472, 'w', 'ws', 'wensu', '', '县', '652922', '', 3);
INSERT INTO `district` VALUES (3222, '库车', 472, 'k', 'kc', 'kuche', '', '市', '652902', '', 2);
INSERT INTO `district` VALUES (3223, '沙雅', 472, 's', 'sy', 'shaya', '', '县', '652924', '', 4);
INSERT INTO `district` VALUES (3224, '新和', 472, 'x', 'xh', 'xinhe', '', '县', '652925', '', 5);
INSERT INTO `district` VALUES (3225, '拜城', 472, 'b', 'bc', 'baicheng', '', '县', '652926', '', 6);
INSERT INTO `district` VALUES (3226, '乌什', 472, 'w', 'ws', 'wushen', '', '县', '652927', '', 7);
INSERT INTO `district` VALUES (3227, '阿瓦提', 472, 'a', 'awt', 'awati', '', '县', '652928', '', 8);
INSERT INTO `district` VALUES (3228, '柯坪', 472, 'k', 'kp', 'keping', '', '县', '652929', '', 9);
INSERT INTO `district` VALUES (3229, '阿图什', 473, 'a', 'ats', 'atushen', '', '市', '653001', '0908', 1);
INSERT INTO `district` VALUES (3230, '阿克陶', 473, 'a', 'akt', 'aketao', '', '县', '653022', '0908', 2);
INSERT INTO `district` VALUES (3231, '阿合奇', 473, 'a', 'ahq', 'aheqi', '', '县', '653023', '0997', 3);
INSERT INTO `district` VALUES (3232, '乌恰', 473, 'w', 'wq', 'wuqia', '', '县', '653024', '0908', 4);
INSERT INTO `district` VALUES (3233, '喀什', 474, 'k', 'ks', 'kashen', '', '市', '653101', '0998', 1);
INSERT INTO `district` VALUES (3234, '疏附', 474, 's', 'sf', 'shufu', '', '县', '653121', '0998', 2);
INSERT INTO `district` VALUES (3235, '疏勒', 474, 's', 'sl', 'shule', '', '县', '653122', '0998', 3);
INSERT INTO `district` VALUES (3236, '英吉沙', 474, 'y', 'yjs', 'yingjisha', '', '县', '653123', '0998', 4);
INSERT INTO `district` VALUES (3237, '泽普', 474, 'z', 'zp', 'zepu', '', '县', '653124', '0998', 5);
INSERT INTO `district` VALUES (3238, '莎车', 474, 's', 'sc', 'shache', '', '县', '653125', '0998', 6);
INSERT INTO `district` VALUES (3239, '叶城', 474, 'y', 'yc', 'yecheng', '', '县', '653126', '0998', 7);
INSERT INTO `district` VALUES (3240, '麦盖提', 474, 'm', 'mgt', 'maigaiti', '', '县', '653127', '0998', 8);
INSERT INTO `district` VALUES (3241, '岳普湖', 474, 'y', 'yph', 'yuepuhu', '', '县', '653128', '0998', 9);
INSERT INTO `district` VALUES (3242, '伽师', 474, 'j', 'js', 'jiashi', '', '县', '653129', '0998', 10);
INSERT INTO `district` VALUES (3243, '巴楚', 474, 'b', 'bc', 'bachu', '', '县', '653130', '0998', 11);
INSERT INTO `district` VALUES (3244, '塔什库尔干', 474, 't', 'tskeg', 'tashenkuergan', '塔吉克', '自治县', '653131', '0998', 12);
INSERT INTO `district` VALUES (3245, '和田', 475, 'h', 'ht', 'hetian', '', '市', '653201', '0903', 1);
INSERT INTO `district` VALUES (3246, '和田', 475, 'h', 'ht', 'hetian', '', '县', '653221', '0903', 2);
INSERT INTO `district` VALUES (3247, '墨玉', 475, 'm', 'my', 'moyu', '', '县', '653222', '0903', 3);
INSERT INTO `district` VALUES (3248, '皮山', 475, 'p', 'ps', 'pishan', '', '县', '653223', '0903', 4);
INSERT INTO `district` VALUES (3249, '洛浦', 475, 'l', 'lp', 'luopu', '', '县', '653224', '0903', 5);
INSERT INTO `district` VALUES (3250, '策勒', 475, 'c', 'cl', 'cele', '', '县', '653225', '0903', 6);
INSERT INTO `district` VALUES (3251, '于田', 475, 'y', 'yt', 'yutian', '', '县', '653226', '0903', 7);
INSERT INTO `district` VALUES (3252, '民丰', 475, 'm', 'mf', 'minfeng', '', '县', '653227', '0903', 8);
INSERT INTO `district` VALUES (3253, '伊宁', 476, 'y', 'yn', 'yining', '', '市', '654002', '0999', 1);
INSERT INTO `district` VALUES (3254, '奎屯', 476, 'k', 'kt', 'kuitun', '', '市', '654003', '0999', 2);
INSERT INTO `district` VALUES (3255, '伊宁', 476, 'y', 'yn', 'yining', '', '县', '654021', '0999', 4);
INSERT INTO `district` VALUES (3256, '察布查尔锡伯', 476, 'c', 'cbcexb', 'chabuchaerxibo', '', '自治县', '654022', '0999', 5);
INSERT INTO `district` VALUES (3257, '霍城', 476, 'h', 'hc', 'huocheng', '', '县', '654023', '0999', 6);
INSERT INTO `district` VALUES (3258, '巩留', 476, 'g', 'gl', 'gongliu', '', '县', '654024', '0999', 7);
INSERT INTO `district` VALUES (3259, '新源', 476, 'x', 'xy', 'xinyuan', '', '县', '654025', '0999', 8);
INSERT INTO `district` VALUES (3260, '昭苏', 476, 'z', 'zs', 'zhaosu', '', '县', '654026', '0999', 9);
INSERT INTO `district` VALUES (3261, '特克斯', 476, 't', 'tks', 'tekesi', '', '县', '654027', '0999', 10);
INSERT INTO `district` VALUES (3262, '尼勒克', 476, 'n', 'nlk', 'nileke', '', '县', '654028', '0999', 11);
INSERT INTO `district` VALUES (3263, '塔城', 477, 't', 'tc', 'tacheng', '', '市', '654201', '0901', 1);
INSERT INTO `district` VALUES (3264, '乌苏', 477, 'w', 'ws', 'wusu', '', '市', '654202', '0901', 2);
INSERT INTO `district` VALUES (3265, '额敏', 477, 'e', 'em', 'emin', '', '县', '654221', '0901', 3);
INSERT INTO `district` VALUES (3266, '沙湾', 477, 's', 'sw', 'shawan', '', '县', '654223', '0901', 4);
INSERT INTO `district` VALUES (3267, '托里', 477, 't', 'tl', 'tuoli', '', '县', '654224', '0901', 5);
INSERT INTO `district` VALUES (3268, '裕民', 477, 'y', 'ym', 'yumin', '', '县', '654225', '0901', 6);
INSERT INTO `district` VALUES (3269, '和布克赛尔', 477, 'h', 'hbkse', 'hebukesaier', '蒙古', '自治县', '654226', '0901', 7);
INSERT INTO `district` VALUES (3270, '阿勒泰', 478, 'a', 'alt', 'aletai', '', '市', '654301', '0906', 1);
INSERT INTO `district` VALUES (3271, '布尔津', 478, 'b', 'bej', 'buerjin', '', '县', '654321', '0906', 2);
INSERT INTO `district` VALUES (3272, '富蕴', 478, 'f', 'fy', 'fuyun', '', '县', '654322', '0906', 3);
INSERT INTO `district` VALUES (3273, '福海', 478, 'f', 'fh', 'fuhai', '', '县', '654323', '0906', 4);
INSERT INTO `district` VALUES (3274, '哈巴河', 478, 'h', 'hbh', 'habahe', '', '县', '654324', '0906', 5);
INSERT INTO `district` VALUES (3275, '青河', 478, 'q', 'qh', 'qinghe', '', '县', '654325', '0906', 6);
INSERT INTO `district` VALUES (3276, '吉木乃', 478, 'j', 'jmn', 'jimunai', '', '县', '654326', '0906', 7);
INSERT INTO `district` VALUES (3277, '松山', 485, 's', 'ss', 'songshan', '', '区', '6300100', '02', 1);
INSERT INTO `district` VALUES (3278, '信义', 485, 'x', 'xy', 'xinyi', '', '区', '6300200', '02', 2);
INSERT INTO `district` VALUES (3279, '大安', 485, 'd', 'da', 'daan', '', '区', '6300300', '02', 3);
INSERT INTO `district` VALUES (3280, '中山', 485, 'z', 'zs', 'zhongshan', '', '区', '6300400', '02', 4);
INSERT INTO `district` VALUES (3281, '中正', 485, 'z', 'zz', 'zhongzheng', '', '区', '6300500', '02', 5);
INSERT INTO `district` VALUES (3282, '大同', 485, 'd', 'dt', 'datong', '', '区', '6300600', '02', 6);
INSERT INTO `district` VALUES (3283, '万华', 485, 'w', 'wh', 'wanhua', '', '区', '6300700', '02', 7);
INSERT INTO `district` VALUES (3284, '文山', 485, 'w', 'ws', 'wenshan', '', '区', '6300800', '02', 8);
INSERT INTO `district` VALUES (3285, '南港', 485, 'n', 'ng', 'nangang', '', '区', '6300900', '02', 9);
INSERT INTO `district` VALUES (3286, '内湖', 485, 'n', 'nh', 'neihu', '', '区', '6301000', '02', 10);
INSERT INTO `district` VALUES (3287, '士林', 485, 's', 'sl', 'shilin', '', '区', '6301100', '02', 11);
INSERT INTO `district` VALUES (3288, '北投', 485, 'b', 'bt', 'beitou', '', '区', '6301200', '02', 12);
INSERT INTO `district` VALUES (3289, '盐埕', 486, 'y', 'yc', 'yancheng', '', '区', '6400100', '07', 1);
INSERT INTO `district` VALUES (3290, '鼓山', 486, 'g', 'gs', 'gushan', '', '区', '6400200', '07', 2);
INSERT INTO `district` VALUES (3291, '左营', 486, 'z', 'zy', 'zuoying', '', '区', '6400300', '07', 3);
INSERT INTO `district` VALUES (3292, '楠梓', 486, 'n', 'nz', 'nanzi', '', '区', '6400400', '07', 4);
INSERT INTO `district` VALUES (3293, '三民', 486, 's', 'sm', 'sanmin', '', '区', '6400500', '07', 5);
INSERT INTO `district` VALUES (3294, '新兴', 486, 'x', 'xx', 'xinxing', '', '区', '6400600', '07', 6);
INSERT INTO `district` VALUES (3295, '前金', 486, 'q', 'qj', 'qianjin', '', '区', '6400700', '07', 7);
INSERT INTO `district` VALUES (3296, '苓雅', 486, 'l', 'ly', 'lingya', '', '区', '6400800', '07', 8);
INSERT INTO `district` VALUES (3297, '前镇', 486, 'q', 'qz', 'qianzhen', '', '区', '6400900', '07', 9);
INSERT INTO `district` VALUES (3298, '旗津', 486, 'q', 'qj', 'qijin', '', '区', '6401000', '07', 10);
INSERT INTO `district` VALUES (3299, '小港', 486, 'x', 'xg', 'xiaogang', '', '区', '6401100', '07', 11);
INSERT INTO `district` VALUES (3300, '中正', 487, 'z', 'zz', 'zhongzheng', '', '区', '1001701', '02', 1);
INSERT INTO `district` VALUES (3301, '七堵', 487, 'q', 'qd', 'qidu', '', '区', '1001702', '02', 2);
INSERT INTO `district` VALUES (3302, '暖暖', 487, 'n', 'nn', 'nuannuan', '', '区', '1001703', '02', 3);
INSERT INTO `district` VALUES (3303, '仁爱', 487, 'r', 'ra', 'renai', '', '区', '1001704', '02', 4);
INSERT INTO `district` VALUES (3304, '中山', 487, 'z', 'zs', 'zhongshan', '', '区', '1001705', '02', 5);
INSERT INTO `district` VALUES (3305, '安乐', 487, 'a', 'al', 'anle', '', '区', '1001706', '02', 6);
INSERT INTO `district` VALUES (3306, '信义', 487, 'x', 'xy', 'xinyi', '', '区', '1001707', '02', 7);
INSERT INTO `district` VALUES (3307, '大安', 488, 'd', 'da', 'daan', '', '区', '', '04', 1);
INSERT INTO `district` VALUES (3308, '神冈', 488, 's', 'sg', 'shengang', '', '区', '', '04', 2);
INSERT INTO `district` VALUES (3309, '石冈', 488, 's', 'sg', 'shigang', '', '区', '', '04', 3);
INSERT INTO `district` VALUES (3310, '东势', 488, 'd', 'ds', 'dongshi', '', '区', '', '04', 4);
INSERT INTO `district` VALUES (3311, '新社', 488, 'x', 'xs', 'xinshe', '', '区', '', '04', 5);
INSERT INTO `district` VALUES (3312, '和平', 488, 'h', 'hp', 'heping', '', '区', '', '04', 6);
INSERT INTO `district` VALUES (3313, '大肚', 488, 'd', 'dd', 'dadu', '', '区', '', '04', 7);
INSERT INTO `district` VALUES (3314, '沙鹿', 488, 's', 'sl', 'shalu', '', '区', '', '04', 8);
INSERT INTO `district` VALUES (3315, '龙井', 488, 'l', 'lj', 'longjing', '', '区', '', '04', 9);
INSERT INTO `district` VALUES (3316, '梧栖', 488, 'w', 'wq', 'wuqi', '', '区', '', '04', 10);
INSERT INTO `district` VALUES (3317, '清水', 488, 'q', 'qs', 'qingshui', '', '区', '', '04', 11);
INSERT INTO `district` VALUES (3318, '大甲', 488, 'd', 'dj', 'dajia', '', '区', '', '04', 12);
INSERT INTO `district` VALUES (3319, '外埔', 488, 'w', 'wp', 'waipu', '', '区', '', '04', 13);
INSERT INTO `district` VALUES (3320, '大雅', 488, 'd', 'dy', 'daya', '', '区', '', '04', 14);
INSERT INTO `district` VALUES (3321, '潭子', 488, 't', 'tz', 'tanzi', '', '区', '', '04', 15);
INSERT INTO `district` VALUES (3322, '后里', 488, 'h', 'hl', 'houli', '', '区', '', '04', 16);
INSERT INTO `district` VALUES (3323, '丰原', 488, 'f', 'fy', 'fengyuan', '', '区', '', '04', 17);
INSERT INTO `district` VALUES (3324, '乌日', 488, 'w', 'wr', 'wuri', '', '区', '', '04', 18);
INSERT INTO `district` VALUES (3325, '雾峰', 488, 'w', 'wf', 'wufeng', '', '区', '', '04', 19);
INSERT INTO `district` VALUES (3326, '大里', 488, 'd', 'dl', 'dali', '', '区', '', '04', 20);
INSERT INTO `district` VALUES (3327, '太平', 488, 't', 'tp', 'taiping', '', '区', '', '04', 21);
INSERT INTO `district` VALUES (3328, '中区', 488, 'z', 'zq', 'zhongqu', '', '', '1001901', '04', 22);
INSERT INTO `district` VALUES (3329, '东区', 488, 'd', 'dq', 'dongqu', '', '', '1001902', '04', 23);
INSERT INTO `district` VALUES (3330, '南区', 488, 'n', 'nq', 'nanqu', '', '', '1001903', '04', 24);
INSERT INTO `district` VALUES (3331, '西区', 488, 'x', 'xq', 'xiqu', '', '', '1001904', '04', 25);
INSERT INTO `district` VALUES (3332, '北区', 488, 'b', 'bq', 'beiqu', '', '', '1001905', '04', 26);
INSERT INTO `district` VALUES (3333, '西屯', 488, 'x', 'xt', 'xitun', '', '区', '1001906', '04', 27);
INSERT INTO `district` VALUES (3334, '南屯', 488, 'n', 'nt', 'nantun', '', '区', '1001907', '04', 28);
INSERT INTO `district` VALUES (3335, '北屯', 488, 'b', 'bt', 'beitun', '', '区', '1001908', '04', 29);
INSERT INTO `district` VALUES (3336, '东区', 489, 'd', 'dq', 'dongqu', '', '', '1002101', '06', 1);
INSERT INTO `district` VALUES (3337, '南区', 489, 'n', 'nq', 'nanqu', '', '', '1002102', '06', 2);
INSERT INTO `district` VALUES (3338, '北区', 489, 'b', 'bq', 'beiqu', '', '', '1002104', '06', 3);
INSERT INTO `district` VALUES (3339, '安南', 489, 'a', 'an', 'annan', '', '区', '1002106', '06', 4);
INSERT INTO `district` VALUES (3340, '安平', 489, 'a', 'ap', 'anping', '', '区', '1002107', '06', 5);
INSERT INTO `district` VALUES (3341, '中西', 489, 'z', 'zx', 'zhongxi', '', '区', '1002108', '06', 6);
INSERT INTO `district` VALUES (3342, '东区', 490, 'd', 'dq', 'dongqu', '', '', '1001801', '', 1);
INSERT INTO `district` VALUES (3343, '北区', 490, 'b', 'bq', 'beiqu', '', '', '1001802', '', 2);
INSERT INTO `district` VALUES (3344, '香山', 490, 'x', 'xs', 'xiangshan', '', '区', '1001803', '', 3);
INSERT INTO `district` VALUES (3345, '东区', 491, 'd', 'dq', 'dongqu', '', '', '1002001', '05', 1);
INSERT INTO `district` VALUES (3346, '西区', 491, 'x', 'xq', 'xiqu', '', '', '1002002', '05', 2);
INSERT INTO `district` VALUES (3347, '板桥', 492, 'b', 'bq', 'banqiao', '', '区', '', '', 1);
INSERT INTO `district` VALUES (3348, '瑞芳', 492, 'r', 'rf', 'ruifang', '', '区', '', '', 2);
INSERT INTO `district` VALUES (3349, '八里', 492, 'b', 'bl', 'bali', '', '区', '', '', 3);
INSERT INTO `district` VALUES (3350, '深坑', 492, 's', 'sk', 'shenkeng', '', '区', '', '', 4);
INSERT INTO `district` VALUES (3351, '三芝', 492, 's', 'sz', 'sanzhi', '', '区', '', '', 5);
INSERT INTO `district` VALUES (3352, '金山', 492, 'j', 'js', 'jinshan', '', '区', '', '', 6);
INSERT INTO `district` VALUES (3353, '万里', 492, 'w', 'wl', 'wanli', '', '区', '', '', 7);
INSERT INTO `district` VALUES (3354, '贡寮', 492, 'g', 'gl', 'gongliao', '', '区', '', '', 8);
INSERT INTO `district` VALUES (3355, '石门', 492, 's', 'sm', 'shimen', '', '区', '', '', 9);
INSERT INTO `district` VALUES (3356, '双溪', 492, 's', 'sx', 'shuangxi', '', '区', '', '', 10);
INSERT INTO `district` VALUES (3357, '石碇', 492, 's', 'sd', 'shiding', '', '区', '', '', 11);
INSERT INTO `district` VALUES (3358, '坪林', 492, 'p', 'pl', 'pinglin', '', '区', '', '', 12);
INSERT INTO `district` VALUES (3359, '乌来', 492, 'w', 'wl', 'wulai', '', '区', '', '', 13);
INSERT INTO `district` VALUES (3360, '泰山', 492, 't', 'ts', 'taishan', '', '区', '', '', 14);
INSERT INTO `district` VALUES (3361, '五股', 492, 'w', 'wg', 'wugu', '', '区', '', '', 15);
INSERT INTO `district` VALUES (3362, '莺歌', 492, 'y', 'yg', 'yingge', '', '区', '', '', 16);
INSERT INTO `district` VALUES (3363, '中和', 492, 'z', 'zh', 'zhonghe', '', '区', '', '', 17);
INSERT INTO `district` VALUES (3364, '新庄', 492, 'x', 'xz', 'xinzhuang', '', '区', '', '', 18);
INSERT INTO `district` VALUES (3365, '三重', 492, 's', 'sz', 'sanzhong', '', '区', '', '', 19);
INSERT INTO `district` VALUES (3366, '新店', 492, 'x', 'xd', 'xindian', '', '区', '', '', 20);
INSERT INTO `district` VALUES (3367, '土城', 492, 't', 'tc', 'tucheng', '', '区', '', '', 21);
INSERT INTO `district` VALUES (3368, '永和', 492, 'y', 'yh', 'yonghe', '', '区', '', '', 22);
INSERT INTO `district` VALUES (3369, '芦洲', 492, 'l', 'lz', 'luzhou', '', '区', '', '', 23);
INSERT INTO `district` VALUES (3370, '汐止', 492, 'x', 'xz', 'xizhi', '', '区', '', '', 24);
INSERT INTO `district` VALUES (3371, '树林', 492, 's', 'sl', 'shulin', '', '区', '', '', 25);
INSERT INTO `district` VALUES (3372, '淡水', 492, 'd', 'ds', 'danshui', '', '区', '', '', 26);
INSERT INTO `district` VALUES (3373, '三峡', 492, 's', 'sx', 'sanxia', '', '区', '', '', 27);
INSERT INTO `district` VALUES (3374, '林口', 492, 'l', 'lk', 'linkou', '', '区', '', '', 28);
INSERT INTO `district` VALUES (3375, '平溪', 492, 'p', 'px', 'pingxi', '', '区', '', '', 29);
INSERT INTO `district` VALUES (3376, '宜兰', 493, 'y', 'yl', 'yilan', '', '市', '1000201', '', 1);
INSERT INTO `district` VALUES (3377, '罗东', 493, 'l', 'ld', 'luodong', '', '镇', '1000202', '', 2);
INSERT INTO `district` VALUES (3378, '苏澳', 493, 's', 'sa', 'suao', '', '镇', '1000203', '', 3);
INSERT INTO `district` VALUES (3379, '头城', 493, 't', 'tc', 'toucheng', '', '乡', '1000204', '', 4);
INSERT INTO `district` VALUES (3380, '礁溪', 493, 'j', 'jx', 'jiaoxi', '', '乡', '1000205', '', 5);
INSERT INTO `district` VALUES (3381, '壮围', 493, 'z', 'zw', 'zhuangwei', '', '乡', '1000206', '', 6);
INSERT INTO `district` VALUES (3382, '员山', 493, 'y', 'ys', 'yuanshan', '', '乡', '1000207', '', 7);
INSERT INTO `district` VALUES (3383, '冬山', 493, 'd', 'ds', 'dongshan', '', '乡', '1000208', '', 8);
INSERT INTO `district` VALUES (3384, '五结', 493, 'w', 'wj', 'wujie', '', '乡', '1000209', '', 9);
INSERT INTO `district` VALUES (3385, '三星', 493, 's', 'sx', 'sanxing', '', '乡', '1000210', '', 10);
INSERT INTO `district` VALUES (3386, '大同', 493, 'd', 'dt', 'datong', '', '乡', '1000211', '', 11);
INSERT INTO `district` VALUES (3387, '南澳', 493, 'n', 'na', 'nanao', '', '乡', '1000212', '', 12);
INSERT INTO `district` VALUES (3388, '桃园', 494, 't', 'ty', 'taoyuan', '', '市', '1000301', '', 1);
INSERT INTO `district` VALUES (3389, '中坜', 494, 'z', 'zl', 'zhongli', '', '市', '1000302', '', 2);
INSERT INTO `district` VALUES (3390, '大溪', 494, 'd', 'dx', 'daxi', '', '镇', '1000303', '', 3);
INSERT INTO `district` VALUES (3391, '杨梅', 494, 'y', 'ym', 'yangmei', '', '镇', '1000304', '', 4);
INSERT INTO `district` VALUES (3392, '芦竹', 494, 'l', 'lz', 'luzhu', '', '乡', '1000305', '', 5);
INSERT INTO `district` VALUES (3393, '大园', 494, 'd', 'dy', 'dayuan', '', '乡', '1000306', '', 6);
INSERT INTO `district` VALUES (3394, '龟山', 494, 'g', 'gs', 'guishan', '', '乡', '1000307', '', 7);
INSERT INTO `district` VALUES (3395, '八德', 494, 'b', 'bd', 'bade', '', '市', '1000308', '', 8);
INSERT INTO `district` VALUES (3396, '龙潭', 494, 'l', 'lt', 'longtan', '', '乡', '1000309', '', 9);
INSERT INTO `district` VALUES (3397, '平镇', 494, 'p', 'pz', 'pingzhen', '', '市', '1000310', '', 10);
INSERT INTO `district` VALUES (3398, '新屋', 494, 'x', 'xw', 'xinwu', '', '乡', '1000311', '', 11);
INSERT INTO `district` VALUES (3399, '观音', 494, 'g', 'gy', 'guanyin', '', '乡', '1000312', '', 12);
INSERT INTO `district` VALUES (3400, '复兴', 494, 'f', 'fx', 'fuxing', '', '乡', '1000313', '', 13);
INSERT INTO `district` VALUES (3401, '竹北', 495, 'z', 'zb', 'zhubei', '', '市', '1000401', '', 1);
INSERT INTO `district` VALUES (3402, '竹东', 495, 'z', 'zd', 'zhudong', '', '镇', '1000402', '', 2);
INSERT INTO `district` VALUES (3403, '新埔', 495, 'x', 'xp', 'xinpu', '', '镇', '1000403', '', 3);
INSERT INTO `district` VALUES (3404, '关西', 495, 'g', 'gx', 'guanxi', '', '镇', '1000404', '', 4);
INSERT INTO `district` VALUES (3405, '湖口', 495, 'h', 'hk', 'hukou', '', '乡', '1000405', '', 5);
INSERT INTO `district` VALUES (3406, '新丰', 495, 'x', 'xf', 'xinfeng', '', '乡', '1000406', '', 6);
INSERT INTO `district` VALUES (3407, '芎林', 495, 'x', 'xl', 'xionglin', '', '乡', '1000407', '', 7);
INSERT INTO `district` VALUES (3408, '横山', 495, 'h', 'hs', 'hengshan', '', '乡', '1000408', '', 8);
INSERT INTO `district` VALUES (3409, '北埔', 495, 'b', 'bp', 'beipu', '', '乡', '1000409', '', 9);
INSERT INTO `district` VALUES (3410, '宝山', 495, 'b', 'bs', 'baoshan', '', '乡', '1000410', '', 10);
INSERT INTO `district` VALUES (3411, '峨眉', 495, 'e', 'em', 'emei', '', '乡', '1000411', '', 11);
INSERT INTO `district` VALUES (3412, '尖石', 495, 'j', 'js', 'jianshi', '', '乡', '1000412', '', 12);
INSERT INTO `district` VALUES (3413, '五峰', 495, 'w', 'wf', 'wufeng', '', '乡', '1000413', '', 13);
INSERT INTO `district` VALUES (3414, '苗栗', 496, 'm', 'ml', 'miaoli', '', '市', '1000501', '', 1);
INSERT INTO `district` VALUES (3415, '苑里', 496, 'y', 'yl', 'yuanli', '', '镇', '1000502', '', 2);
INSERT INTO `district` VALUES (3416, '通霄', 496, 't', 'tx', 'tongxiao', '', '镇', '1000503', '', 3);
INSERT INTO `district` VALUES (3417, '竹南', 496, 'z', 'zn', 'zhunan', '', '镇', '1000504', '', 4);
INSERT INTO `district` VALUES (3418, '头份', 496, 't', 'tf', 'toufen', '', '镇', '1000505', '', 5);
INSERT INTO `district` VALUES (3419, '后龙', 496, 'h', 'hl', 'houlong', '', '镇', '1000506', '', 6);
INSERT INTO `district` VALUES (3420, '卓兰', 496, 'z', 'zl', 'zhuolan', '', '镇', '1000507', '', 7);
INSERT INTO `district` VALUES (3421, '大湖', 496, 'd', 'dh', 'dahu', '', '乡', '1000508', '', 8);
INSERT INTO `district` VALUES (3422, '公馆', 496, 'g', 'gg', 'gongguan', '', '乡', '1000509', '', 9);
INSERT INTO `district` VALUES (3423, '铜锣', 496, 't', 'tl', 'tongluo', '', '乡', '1000510', '', 10);
INSERT INTO `district` VALUES (3424, '南庄', 496, 'n', 'nz', 'nanzhuang', '', '乡', '1000511', '', 11);
INSERT INTO `district` VALUES (3425, '头屋', 496, 't', 'tw', 'touwu', '', '乡', '1000512', '', 12);
INSERT INTO `district` VALUES (3426, '三义', 496, 's', 'sy', 'sanyi', '', '乡', '1000513', '', 13);
INSERT INTO `district` VALUES (3427, '西湖', 496, 'x', 'xh', 'xihu', '', '乡', '1000514', '', 14);
INSERT INTO `district` VALUES (3428, '造桥', 496, 'z', 'zq', 'zaoqiao', '', '乡', '1000515', '', 15);
INSERT INTO `district` VALUES (3429, '三湾', 496, 's', 'sw', 'sanwan', '', '乡', '1000516', '', 16);
INSERT INTO `district` VALUES (3430, '狮潭', 496, 's', 'st', 'shitan', '', '乡', '1000517', '', 17);
INSERT INTO `district` VALUES (3431, '泰安', 496, 't', 'ta', 'taian', '', '乡', '1000518', '', 18);
INSERT INTO `district` VALUES (3432, '彰化', 497, 'z', 'zh', 'zhanghua', '', '市', '1000701', '', 1);
INSERT INTO `district` VALUES (3433, '鹿港', 497, 'l', 'lg', 'lugang', '', '镇', '1000702', '', 2);
INSERT INTO `district` VALUES (3434, '和美', 497, 'h', 'hm', 'hemei', '', '镇', '1000703', '', 3);
INSERT INTO `district` VALUES (3435, '线西', 497, 'x', 'xx', 'xianxi', '', '乡', '1000704', '', 4);
INSERT INTO `district` VALUES (3436, '伸港', 497, 's', 'sg', 'shengang', '', '乡', '1000705', '', 5);
INSERT INTO `district` VALUES (3437, '福兴', 497, 'f', 'fx', 'fuxing', '', '乡', '1000706', '', 6);
INSERT INTO `district` VALUES (3438, '秀水', 497, 'x', 'xs', 'xiushui', '', '乡', '1000707', '', 7);
INSERT INTO `district` VALUES (3439, '花坛', 497, 'h', 'ht', 'huatan', '', '乡', '1000708', '', 8);
INSERT INTO `district` VALUES (3440, '芬园', 497, 'f', 'fy', 'fenyuan', '', '乡', '1000709', '', 9);
INSERT INTO `district` VALUES (3441, '员林', 497, 'y', 'yl', 'yuanlin', '', '镇', '1000710', '', 10);
INSERT INTO `district` VALUES (3442, '溪湖', 497, 'x', 'xh', 'xihu', '', '镇', '1000711', '', 11);
INSERT INTO `district` VALUES (3443, '田中', 497, 't', 'tz', 'tianzhong', '', '镇', '1000712', '', 12);
INSERT INTO `district` VALUES (3444, '大村', 497, 'd', 'dc', 'dacun', '', '乡', '1000713', '', 13);
INSERT INTO `district` VALUES (3445, '埔盐', 497, 'p', 'py', 'puyan', '', '乡', '1000714', '', 14);
INSERT INTO `district` VALUES (3446, '埔心', 497, 'p', 'px', 'puxin', '', '乡', '1000715', '', 15);
INSERT INTO `district` VALUES (3447, '永靖', 497, 'y', 'yj', 'yongjing', '', '乡', '1000716', '', 16);
INSERT INTO `district` VALUES (3448, '社头', 497, 's', 'st', 'shetou', '', '乡', '1000717', '', 17);
INSERT INTO `district` VALUES (3449, '二水', 497, 'e', 'es', 'ershui', '', '乡', '1000718', '', 18);
INSERT INTO `district` VALUES (3450, '北斗', 497, 'b', 'bd', 'beidou', '', '镇', '1000719', '', 19);
INSERT INTO `district` VALUES (3451, '二林', 497, 'e', 'el', 'erlin', '', '镇', '1000720', '', 20);
INSERT INTO `district` VALUES (3452, '田尾', 497, 't', 'tw', 'tianwei', '', '乡', '1000721', '', 21);
INSERT INTO `district` VALUES (3453, '埤头', 497, 'p', 'pt', 'pitou', '', '乡', '1000722', '', 22);
INSERT INTO `district` VALUES (3454, '芳苑', 497, 'f', 'fy', 'fangyuan', '', '乡', '1000723', '', 23);
INSERT INTO `district` VALUES (3455, '大城', 497, 'd', 'dc', 'dacheng', '', '乡', '1000724', '', 24);
INSERT INTO `district` VALUES (3456, '竹塘', 497, 'z', 'zt', 'zhutang', '', '乡', '1000725', '', 25);
INSERT INTO `district` VALUES (3457, '溪州', 497, 'x', 'xz', 'xizhou', '', '乡', '1000726', '', 26);
INSERT INTO `district` VALUES (3458, '南投', 498, 'n', 'nt', 'nantou', '', '市', '1000801', '', 1);
INSERT INTO `district` VALUES (3459, '南投', 498, 'n', 'nt', 'nantou', '', '镇', '1000802', '', 2);
INSERT INTO `district` VALUES (3460, '草屯', 498, 'c', 'ct', 'caotun', '', '镇', '1000803', '', 3);
INSERT INTO `district` VALUES (3461, '竹山', 498, 'z', 'zs', 'zhushan', '', '镇', '1000804', '', 4);
INSERT INTO `district` VALUES (3462, '集集', 498, 'j', 'jj', 'jiji', '', '镇', '1000805', '', 5);
INSERT INTO `district` VALUES (3463, '名间', 498, 'm', 'mj', 'mingjian', '', '乡', '1000806', '', 6);
INSERT INTO `district` VALUES (3464, '鹿谷', 498, 'l', 'lg', 'lugu', '', '乡', '1000807', '', 7);
INSERT INTO `district` VALUES (3465, '中寮', 498, 'z', 'zl', 'zhongliao', '', '乡', '1000808', '', 8);
INSERT INTO `district` VALUES (3466, '鱼池', 498, 'y', 'yc', 'yuchi', '', '乡', '1000809', '', 9);
INSERT INTO `district` VALUES (3467, '国姓', 498, 'g', 'gx', 'guoxing', '', '乡', '1000810', '', 10);
INSERT INTO `district` VALUES (3468, '水里', 498, 's', 'sl', 'shuili', '', '乡', '1000811', '', 11);
INSERT INTO `district` VALUES (3469, '信义', 498, 'x', 'xy', 'xinyi', '', '乡', '1000812', '', 12);
INSERT INTO `district` VALUES (3470, '仁爱', 498, 'r', 'ra', 'renai', '', '乡', '1000813', '', 13);
INSERT INTO `district` VALUES (3471, '斗六', 499, 'd', 'dl', 'douliu', '', '市', '1000901', '', 1);
INSERT INTO `district` VALUES (3472, '斗南', 499, 'd', 'dn', 'dounan', '', '镇', '1000902', '', 2);
INSERT INTO `district` VALUES (3473, '虎尾', 499, 'h', 'hw', 'huwei', '', '镇', '1000903', '', 3);
INSERT INTO `district` VALUES (3474, '西螺', 499, 'x', 'xl', 'xiluo', '', '镇', '1000904', '', 4);
INSERT INTO `district` VALUES (3475, '土库', 499, 't', 'tk', 'tuku', '', '镇', '1000905', '', 5);
INSERT INTO `district` VALUES (3476, '北港', 499, 'b', 'bg', 'beigang', '', '镇', '1000906', '', 6);
INSERT INTO `district` VALUES (3477, '古坑', 499, 'g', 'gk', 'gukeng', '', '乡', '1000907', '', 7);
INSERT INTO `district` VALUES (3478, '大埤', 499, 'd', 'dp', 'dapi', '', '乡', '1000908', '', 8);
INSERT INTO `district` VALUES (3479, '莿桐', 499, 'c', 'ct', 'citong', '', '乡', '1000909', '', 9);
INSERT INTO `district` VALUES (3480, '林内', 499, 'l', 'ln', 'linnei', '', '乡', '1000910', '', 10);
INSERT INTO `district` VALUES (3481, '二仑', 499, 'e', 'el', 'erlun', '', '乡', '1000911', '', 11);
INSERT INTO `district` VALUES (3482, '仑背', 499, 'l', 'lb', 'lunbei', '', '乡', '1000912', '', 12);
INSERT INTO `district` VALUES (3483, '麦寮', 499, 'm', 'ml', 'mailiao', '', '乡', '1000913', '', 13);
INSERT INTO `district` VALUES (3484, '东势', 499, 'd', 'ds', 'dongshi', '', '乡', '1000914', '', 14);
INSERT INTO `district` VALUES (3485, '褒忠', 499, 'b', 'bz', 'baozhong', '', '乡', '1000915', '', 15);
INSERT INTO `district` VALUES (3486, '台西', 499, 't', 'tx', 'taixi', '', '乡', '1000916', '', 16);
INSERT INTO `district` VALUES (3487, '元长', 499, 'y', 'yc', 'yuanchang', '', '乡', '1000917', '', 17);
INSERT INTO `district` VALUES (3488, '四湖', 499, 's', 'sh', 'sihu', '', '乡', '1000918', '', 18);
INSERT INTO `district` VALUES (3489, '口湖', 499, 'k', 'kh', 'kouhu', '', '乡', '1000919', '', 19);
INSERT INTO `district` VALUES (3490, '水林', 499, 's', 'sl', 'shuilin', '', '乡', '1000920', '', 20);
INSERT INTO `district` VALUES (3491, '太保', 500, 't', 'tb', 'taibao', '', '市', '', '', 1);
INSERT INTO `district` VALUES (3492, '朴子', 500, 'p', 'pz', 'pozi', '', '市', '', '', 2);
INSERT INTO `district` VALUES (3493, '布袋', 500, 'b', 'bd', 'budai', '', '镇', '', '', 3);
INSERT INTO `district` VALUES (3494, '大林', 500, 'd', 'dl', 'dalin', '', '镇', '10010', '', 4);
INSERT INTO `district` VALUES (3495, '民雄', 500, 'm', 'mx', 'minxiong', '', '乡', '1001001', '', 5);
INSERT INTO `district` VALUES (3496, '溪口', 500, 'x', 'xk', 'xikou', '', '乡', '1001002', '', 6);
INSERT INTO `district` VALUES (3497, '新港', 500, 'x', 'xg', 'xingang', '', '乡', '1001003', '', 7);
INSERT INTO `district` VALUES (3498, '六脚', 500, 'l', 'lj', 'liujiao', '', '乡', '1001004', '', 8);
INSERT INTO `district` VALUES (3499, '东石', 500, 'd', 'ds', 'dongshi', '', '乡', '1001005', '', 9);
INSERT INTO `district` VALUES (3500, '义竹', 500, 'y', 'yz', 'yizhu', '', '乡', '1001006', '', 10);
INSERT INTO `district` VALUES (3501, '鹿草', 500, 'l', 'lc', 'lucao', '', '乡', '1001007', '', 11);
INSERT INTO `district` VALUES (3502, '水上', 500, 's', 'ss', 'shuishang', '', '乡', '1001008', '', 12);
INSERT INTO `district` VALUES (3503, '中埔', 500, 'z', 'zp', 'zhongpu', '', '乡', '1001009', '', 13);
INSERT INTO `district` VALUES (3504, '竹崎', 500, 'z', 'zq', 'zhuqi', '', '乡', '1001010', '', 14);
INSERT INTO `district` VALUES (3505, '梅山', 500, 'm', 'ms', 'meishan', '', '乡', '1001011', '', 15);
INSERT INTO `district` VALUES (3506, '番路', 500, 'f', 'fl', 'fanlu', '', '乡', '1001012', '', 16);
INSERT INTO `district` VALUES (3507, '大埔', 500, 'd', 'dp', 'dapu', '', '乡', '1001013', '', 17);
INSERT INTO `district` VALUES (3508, '阿里山', 500, 'a', 'als', 'alishan', '', '乡', '1001014', '', 18);
INSERT INTO `district` VALUES (3509, '屏东', 501, 'p', 'pd', 'pingdong', '', '市', '1001301', '', 1);
INSERT INTO `district` VALUES (3510, '潮州', 501, 'c', 'cz', 'chaozhou', '', '镇', '1001302', '', 2);
INSERT INTO `district` VALUES (3511, '东港', 501, 'd', 'dg', 'donggang', '', '镇', '1001303', '', 3);
INSERT INTO `district` VALUES (3512, '恒春', 501, 'h', 'hc', 'hengchun', '', '镇', '1001304', '', 4);
INSERT INTO `district` VALUES (3513, '万丹', 501, 'w', 'wd', 'wandan', '', '乡', '1001305', '', 5);
INSERT INTO `district` VALUES (3514, '长治', 501, 'c', 'cz', 'changzhi', '', '乡', '1001306', '', 6);
INSERT INTO `district` VALUES (3515, '麟洛', 501, 'l', 'll', 'linluo', '', '乡', '1001307', '', 7);
INSERT INTO `district` VALUES (3516, '九如', 501, 'j', 'jr', 'jiuru', '', '乡', '1001308', '', 8);
INSERT INTO `district` VALUES (3517, '里港', 501, 'l', 'lg', 'ligang', '', '乡', '1001309', '', 9);
INSERT INTO `district` VALUES (3518, '盐埔', 501, 'y', 'yp', 'yanpu', '', '乡', '1001310', '', 10);
INSERT INTO `district` VALUES (3519, '高树', 501, 'g', 'gs', 'gaoshu', '', '乡', '1001311', '', 11);
INSERT INTO `district` VALUES (3520, '万峦', 501, 'w', 'wl', 'wanluan', '', '乡', '1001312', '', 12);
INSERT INTO `district` VALUES (3521, '内埔', 501, 'n', 'np', 'neipu', '', '乡', '1001313', '', 13);
INSERT INTO `district` VALUES (3522, '竹田', 501, 'z', 'zt', 'zhutian', '', '乡', '1001314', '', 14);
INSERT INTO `district` VALUES (3523, '新埤', 501, 'x', 'xp', 'xinpi', '', '乡', '1001315', '', 15);
INSERT INTO `district` VALUES (3524, '枋寮', 501, 'f', 'fl', 'fangliao', '', '乡', '1001316', '', 16);
INSERT INTO `district` VALUES (3525, '新园', 501, 'x', 'xy', 'xinyuan', '', '乡', '1001317', '', 17);
INSERT INTO `district` VALUES (3526, '崁顶', 501, 'k', 'kd', 'kanding', '', '乡', '1001318', '', 18);
INSERT INTO `district` VALUES (3527, '林边', 501, 'l', 'lb', 'linbian', '', '乡', '1001319', '', 19);
INSERT INTO `district` VALUES (3528, '南州', 501, 'n', 'nz', 'nanzhou', '', '乡', '1001320', '', 20);
INSERT INTO `district` VALUES (3529, '佳冬', 501, 'j', 'jd', 'jiadong', '', '乡', '1001321', '', 21);
INSERT INTO `district` VALUES (3530, '琉球', 501, 'l', 'lq', 'liuqiu', '', '乡', '1001322', '', 22);
INSERT INTO `district` VALUES (3531, '车城', 501, 'c', 'cc', 'checheng', '', '乡', '1001323', '', 23);
INSERT INTO `district` VALUES (3532, '满州', 501, 'm', 'mz', 'manzhou', '', '乡', '1001324', '', 24);
INSERT INTO `district` VALUES (3533, '枋山', 501, 'f', 'fs', 'fangshan', '', '乡', '1001325', '', 25);
INSERT INTO `district` VALUES (3534, '三地门', 501, 's', 'sdm', 'sandimen', '', '乡', '1001326', '', 26);
INSERT INTO `district` VALUES (3535, '雾台', 501, 'w', 'wt', 'wutai', '', '乡', '1001327', '', 27);
INSERT INTO `district` VALUES (3536, '玛家', 501, 'm', 'mj', 'majia', '', '乡', '1001328', '', 28);
INSERT INTO `district` VALUES (3537, '泰武', 501, 't', 'tw', 'taiwu', '', '乡', '1001329', '', 29);
INSERT INTO `district` VALUES (3538, '来义', 501, 'l', 'ly', 'laiyi', '', '乡', '1001330', '', 30);
INSERT INTO `district` VALUES (3539, '春日', 501, 'c', 'cr', 'chunri', '', '乡', '1001331', '', 31);
INSERT INTO `district` VALUES (3540, '狮子', 501, 's', 'sz', 'shizi', '', '乡', '1001332', '', 32);
INSERT INTO `district` VALUES (3541, '牡丹', 501, 'm', 'md', 'mudan', '', '乡', '1001333', '', 33);
INSERT INTO `district` VALUES (3542, '卑南', 502, 'b', 'bn', 'beinan', '', '乡', '', '', 1);
INSERT INTO `district` VALUES (3543, '台东', 502, 't', 'td', 'taidong', '', '市', '1001401', '', 2);
INSERT INTO `district` VALUES (3544, '成功', 502, 'c', 'cg', 'chenggong', '', '镇', '1001402', '', 3);
INSERT INTO `district` VALUES (3545, '关山', 502, 'g', 'gs', 'guanshan', '', '镇', '1001403', '', 4);
INSERT INTO `district` VALUES (3546, '鹿野', 502, 'l', 'ly', 'luye', '', '乡', '1001405', '', 5);
INSERT INTO `district` VALUES (3547, '池上', 502, 'c', 'cs', 'chishang', '', '乡', '1001406', '', 6);
INSERT INTO `district` VALUES (3548, '东河', 502, 'd', 'dh', 'donghe', '', '乡', '1001407', '', 7);
INSERT INTO `district` VALUES (3549, '长滨', 502, 'c', 'cb', 'changbin', '', '乡', '1001408', '', 8);
INSERT INTO `district` VALUES (3550, '太麻里', 502, 't', 'tml', 'taimali', '', '乡', '1001409', '', 9);
INSERT INTO `district` VALUES (3551, '大武', 502, 'd', 'dw', 'dawu', '', '乡', '1001410', '', 10);
INSERT INTO `district` VALUES (3552, '绿岛', 502, 'l', 'ld', 'lu:dao', '', '乡', '1001411', '', 11);
INSERT INTO `district` VALUES (3553, '海端', 502, 'h', 'hd', 'haiduan', '', '乡', '1001412', '', 12);
INSERT INTO `district` VALUES (3554, '延平', 502, 'y', 'yp', 'yanping', '', '乡', '1001413', '', 13);
INSERT INTO `district` VALUES (3555, '金峰', 502, 'j', 'jf', 'jinfeng', '', '乡', '1001414', '', 14);
INSERT INTO `district` VALUES (3556, '达仁', 502, 'd', 'dr', 'daren', '', '乡', '1001415', '', 15);
INSERT INTO `district` VALUES (3557, '兰屿', 502, 'l', 'ly', 'lanyu', '', '乡', '1001416', '', 16);
INSERT INTO `district` VALUES (3558, '花莲', 503, 'h', 'hl', 'hualian', '', '市', '1001501', '', 1);
INSERT INTO `district` VALUES (3559, '凤林', 503, 'f', 'fl', 'fenglin', '', '镇', '1001502', '', 2);
INSERT INTO `district` VALUES (3560, '玉里', 503, 'y', 'yl', 'yuli', '', '镇', '1001503', '', 3);
INSERT INTO `district` VALUES (3561, '新城', 503, 'x', 'xc', 'xincheng', '', '乡', '1001504', '', 4);
INSERT INTO `district` VALUES (3562, '吉安', 503, 'j', 'ja', 'jian', '', '乡', '1001505', '', 5);
INSERT INTO `district` VALUES (3563, '寿丰', 503, 's', 'sf', 'shoufeng', '', '乡', '1001506', '', 6);
INSERT INTO `district` VALUES (3564, '光复', 503, 'g', 'gf', 'guangfu', '', '乡', '1001507', '', 7);
INSERT INTO `district` VALUES (3565, '丰滨', 503, 'f', 'fb', 'fengbin', '', '乡', '1001508', '', 8);
INSERT INTO `district` VALUES (3566, '瑞穗', 503, 'r', 'rs', 'ruisui', '', '乡', '1001509', '', 9);
INSERT INTO `district` VALUES (3567, '富里', 503, 'f', 'fl', 'fuli', '', '乡', '1001510', '', 10);
INSERT INTO `district` VALUES (3568, '秀林', 503, 'x', 'xl', 'xiulin', '', '乡', '1001511', '', 11);
INSERT INTO `district` VALUES (3569, '万荣', 503, 'w', 'wr', 'wanrong', '', '乡', '1001512', '', 12);
INSERT INTO `district` VALUES (3570, '卓溪', 503, 'z', 'zx', 'zhuoxi', '', '乡', '1001513', '', 13);
INSERT INTO `district` VALUES (3571, '马公', 504, 'm', 'mg', 'magong', '', '市', '1001601', '07', 1);
INSERT INTO `district` VALUES (3572, '湖西', 504, 'h', 'hx', 'huxi', '', '乡', '1001602', '07', 2);
INSERT INTO `district` VALUES (3573, '白沙', 504, 'b', 'bs', 'baisha', '', '乡', '1001603', '07', 3);
INSERT INTO `district` VALUES (3574, '西屿', 504, 'x', 'xy', 'xiyu', '', '乡', '1001604', '07', 4);
INSERT INTO `district` VALUES (3575, '望安', 504, 'w', 'wa', 'wangan', '', '乡', '1001605', '07', 5);
INSERT INTO `district` VALUES (3576, '七美', 504, 'q', 'qm', 'qimei', '', '乡', '1001606', '07', 6);
INSERT INTO `district` VALUES (3577, '双河', 31, 's', 'sh', 'shuanghe', '', '市', '659007', '0909', 21);
INSERT INTO `district` VALUES (3578, '海棠', 357, 'h', 'ht', 'haitang', '', '区', '', '0898', 1);
INSERT INTO `district` VALUES (3579, '吉阳', 357, 'j', 'jy', 'jiyang', '', '区', '', '0898', 2);
INSERT INTO `district` VALUES (3580, '天涯', 357, 't', 'ty', 'tianya', '', '区', '', '0898', 3);
INSERT INTO `district` VALUES (3581, '崖州', 357, 'y', 'yz', 'yazhou', '', '区', '', '0898', 4);
INSERT INTO `district` VALUES (3582, '霍尔果斯', 476, 'h', 'hegs', 'huoerguosi', '', '市', '654004', '0999', 3);
INSERT INTO `district` VALUES (3583, '前锋', 388, 'q', 'qf', 'qianfeng', '', '区', '', '0826', 2);
INSERT INTO `district` VALUES (3584, '福绵', 350, 'f', 'fm', 'fumian', '', '区', '450903', '0775', 2);
INSERT INTO `district` VALUES (3585, '可克达拉', 31, 'k', 'kdkl', 'kedakela', '', '市', '659008', '0999', 22);
INSERT INTO `district` VALUES (7036, '龙华', 323, 'l', 'lh', 'longhua', '', '区', '440309', '0755', 7);
INSERT INTO `district` VALUES (7037, '坪山', 323, 'p', 'ps', 'pingshan', '', '区', '440310', '0755', 8);
INSERT INTO `district` VALUES (7038, '昆玉', 31, 'k', 'ky', 'kunyu', '', '市', '659009', '0903', 23);
INSERT INTO `district` VALUES (7039, '平桂', 352, 'p', 'pg', 'pinggui', '', '区', '451103', '0774', 2);
INSERT INTO `district` VALUES (7040, '巴什', 152, 'b', 'bs', 'bashi', '', '区', '150603', '0477', 2);
INSERT INTO `district` VALUES (7041, '叶集', 231, 'y', 'yj', 'yeji', '', '区', '', '0564', 8);
INSERT INTO `district` VALUES (7042, '光明', 323, 'g', 'gm', 'guangming', '', '区', '440311', '0755', 9);
INSERT INTO `district` VALUES (7043, '龙港', 210, 'l', 'lg', 'longgang', '', '市', '330383', '0577', 12);
INSERT INTO `district` VALUES (7044, '胡杨河', 31, 'h', 'hyh', 'huyanghe', '', '市', '659010', '', 24);
INSERT INTO `district` VALUES (7045, '西沙', 358, 'x', 'xs', 'xisha', '', '区', '460300', '0898', 1);
INSERT INTO `district` VALUES (7046, '南沙', 358, 'n', 'ns', 'nansha', '', '区', '460300', '0898', 0);
COMMIT;

-- ----------------------------
-- Table structure for sample_general
-- ----------------------------
DROP TABLE IF EXISTS `sample_general`;
CREATE TABLE `sample_general` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `parent_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '地址',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='代码生成示例';

-- ----------------------------
-- Records of sample_general
-- ----------------------------
BEGIN;
INSERT INTO `sample_general` VALUES ('1548913939352399874', '1548913939377565700', '双初然', '2', 27, '17366392932', '1', 1, '江苏省南京市', 14, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939356594177', '1548913939377565700', '善燕子', '1', 23, '17366392815', '1', 2, '江苏省南京市', 2, '1', '2022-07-28 16:20:20', '1', '2023-02-13 14:08:55');
INSERT INTO `sample_general` VALUES ('1548913939356594178', '1548913939377565700', '庄善和', '1', 23, '17366393057', '1', 3, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939360788482', NULL, '乌雅冷雁', '1', 26, '17366392816', '1', 1, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939360788483', '1548913939360788482', '恭瑜敏', '1', 26, '17366392813', '1', 1, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939360788485', '1548913939373371396', '孔丽君', '1', 23, '17366392929', '1', 1, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939364982785', '1548913939360788485', '诸嘉禧', '1', 28, '17366392933', '1', 1, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939369177091', '1548913939364982785', '蓬子石', '1', 28, '17366392818', '1', 1, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939373371393', NULL, '亓官迎海', '1', 23, '17366392930', '1', 2, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939373371394', NULL, '陈绿凝', '1', 28, '17366392944', '1', 3, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939373371396', '1548913939360788482', '訾春柏', '1', 23, '17366392814', '1', 2, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939377565700', NULL, 'cc', '1', 30, '17366392808', '1', 4, 'xxx', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939381760002', '1548913939356594178', '普玉石', '1', 23, '17366393050', '1', 1, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939385954306', '1548913939356594177', '司寇傲儿', '1', 27, '17366392817', '1', 4, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939385954308', NULL, '麻寻桃', '1', 26, '17366392931', '1', 5, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939394342914', '1548913939356594177', '淦尔槐', '1', 23, '17366393056', '1', 3, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939398537219', '1548913939356594177', '六慕诗', '1', 28, '17366393065', '1', 2, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939729887234', NULL, '秋痴春', '2', 26, '17366393055', '1', 6, '江苏省南京市', 2, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939734081537', '1548913939377565700', '僧山', '2', 26, '17366392810', '1', 4, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939734081538', NULL, '答鸿信', '2', 27, '17366393053', '1', 7, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939734081539', '1548913939356594177', '上官飞章', '2', 26, '17366393052', '1', 1, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939738275841', NULL, '员绮梅', '2', 23, '17366393051', '1', 8, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939738275842', '1548913939352399874', '范姜雅韶', '2', 28, '17366392939', '1', 1, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939742470145', NULL, '濯丝琪', '2', 23, '17366392935', '1', 9, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939742470146', NULL, '势悠奕', '2', 23, '17366392808', '1', 10, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939746664450', NULL, '单玄清', '2', 26, '17366392934', '1', 11, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939759247362', NULL, '虎采珊', '2', 27, '17366392938', '1', 12, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939763441666', NULL, '针晓畅', '2', 26, '17366392937', '1', 13, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939767635970', NULL, '伯景彰', '2', 23, '17366392809', '1', 14, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939780218882', NULL, '叔雁露', '2', 28, '17366392812', '1', 15, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939784413185', NULL, '袭俊良', '2', 27, '17366393059', '1', 16, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939788607489', NULL, '祖流如', '2', 27, '17366392811', '1', 17, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939796996097', NULL, '夹谷芸儿', '2', 28, '17366393060', '1', 18, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939801190402', NULL, '淳于凝云', '2', 26, '17366393058', '1', 19, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939805384707', NULL, '候之玉', '2', 28, '17366393054', '1', 20, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939817967618', NULL, '寸白莲', '2', 23, '17366392936', '1', 21, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1548913939889270786', NULL, '鞠理群', '2', 28, '17366392823', '1', 22, '江苏省南京市', 0, '1', '2022-07-28 16:20:20', '1', '2022-07-28 16:20:01');
INSERT INTO `sample_general` VALUES ('1556203535532527617', NULL, '善燕子', '1', 23, '17366392815', NULL, 23, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535536721922', NULL, '庄善和', '1', 23, '17366393057', NULL, 24, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535545110529', NULL, '乌雅冷雁', '1', 26, '17366392816', NULL, 25, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535549304833', NULL, '恭瑜敏', '1', 26, '17366392813', NULL, 26, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535549304834', NULL, '孔丽君', '1', 23, '17366392929', NULL, 27, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535566082049', NULL, '诸嘉禧', '1', 28, '17366392933', NULL, 28, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535570276353', NULL, '蓬子石', '1', 28, '17366392818', NULL, 29, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535654162433', NULL, '亓官迎海', '1', 23, '17366392930', NULL, 30, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535662551041', NULL, '陈绿凝', '1', 28, '17366392944', NULL, 31, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535675133954', NULL, '訾春柏', '1', 23, '17366392814', NULL, 32, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535687716865', NULL, 'cc', '1', 30, '17366392808', NULL, 33, 'xxx', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535704494081', NULL, '普玉石', '1', 23, '17366393050', NULL, 34, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535708688385', NULL, '司寇傲儿', '1', 27, '17366392817', NULL, 35, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535733854209', NULL, '麻寻桃', '1', 26, '17366392931', NULL, 36, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535750631425', NULL, '淦尔槐', '1', 23, '17366393056', NULL, 37, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535767408642', NULL, '六慕诗', '1', 28, '17366393065', NULL, 38, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535779991554', NULL, '双初然', '2', 27, '17366392932', NULL, 39, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535788380162', NULL, '秋痴春', '2', 26, '17366393055', NULL, 40, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535805157378', NULL, '僧山', '2', 26, '17366392810', NULL, 41, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535813545985', NULL, '答鸿信', '2', 27, '17366393053', NULL, 42, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535826128898', NULL, '上官飞章', '2', 26, '17366393052', NULL, 43, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535834517505', NULL, '员绮梅', '2', 23, '17366393051', NULL, 44, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535851294722', NULL, '范姜雅韶', '2', 28, '17366392939', NULL, 45, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535859683330', NULL, '濯丝琪', '2', 23, '17366392935', NULL, 46, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535872266241', NULL, '势悠奕', '2', 23, '17366392808', NULL, 47, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535893237761', NULL, '单玄清', '2', 26, '17366392934', NULL, 48, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535905820674', NULL, '虎采珊', '2', 27, '17366392938', NULL, 49, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535918403586', NULL, '针晓畅', '2', 26, '17366392937', NULL, 50, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535939375106', NULL, '伯景彰', '2', 23, '17366392809', NULL, 51, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535960346626', NULL, '叔雁露', '2', 28, '17366392812', NULL, 52, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535964540929', NULL, '袭俊良', '2', 27, '17366393059', NULL, 53, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535977123842', NULL, '祖流如', '2', 27, '17366392811', NULL, 54, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535989706754', NULL, '夹谷芸儿', '2', 28, '17366393060', NULL, 55, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203535998095362', NULL, '淳于凝云', '2', 26, '17366393058', NULL, 56, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203536014872578', NULL, '候之玉', '2', 28, '17366393054', NULL, 57, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203536019066881', NULL, '寸白莲', '2', 23, '17366392936', NULL, 58, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1556203536031649794', NULL, '鞠理群', '2', 28, '17366392823', NULL, 59, '江苏省南京市', 0, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sample_work_flow
-- ----------------------------
DROP TABLE IF EXISTS `sample_work_flow`;
CREATE TABLE `sample_work_flow` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `leave_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请假类型',
  `start_date` datetime DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `reason` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '原因',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='流程示例';

-- ----------------------------
-- Records of sample_work_flow
-- ----------------------------
BEGIN;
INSERT INTO `sample_work_flow` VALUES ('0e1b6dd93535c9a3e0dc69c2e21a7a33', '1', '2021-01-29 22:43:00', '2021-01-29 22:43:00', '今天不想上班', NULL, NULL, '1', '2021-01-29 22:44:03', '1', '2021-01-29 22:44:03');
INSERT INTO `sample_work_flow` VALUES ('1926b9f7e8b30584cae2bb8a8ab4d3f9', '2', '2021-02-02 23:09:00', '2021-02-02 23:09:00', '昨天晚上加班到太晚，明天中午到公司', NULL, NULL, '1', '2021-02-02 23:11:51', '1', '2021-02-02 23:11:51');
INSERT INTO `sample_work_flow` VALUES ('41a48b3a809e0e91da71f7c03bd0a923', '2', '2021-01-18 08:00:00', '2021-01-18 18:00:00', '早上没起来', NULL, NULL, '1', '2021-01-18 12:59:40', '1', '2021-01-21 14:15:38');
INSERT INTO `sample_work_flow` VALUES ('570345ba9e47641ceb74abb927b3b620', '2', '2021-02-02 23:13:00', '2021-02-02 23:13:00', '今天帮同学家扛大白菜', NULL, NULL, '1', '2021-02-02 23:13:28', '1', '2021-02-02 23:13:28');
INSERT INTO `sample_work_flow` VALUES ('6280fcce665c070e2ceedd5b1c701f07', '2', '2021-01-16 13:00:00', '2021-01-16 18:00:00', '家里有事', NULL, NULL, '1', '2021-01-16 11:16:39', '1', '2021-01-16 11:16:39');
INSERT INTO `sample_work_flow` VALUES ('715edc6b5a64e9b626a34d8a415f3f41', '2', '2021-01-29 22:42:00', '2021-01-29 22:42:00', '朋友结婚', NULL, NULL, '1', '2021-01-29 22:43:33', '1', '2021-01-29 22:43:33');
INSERT INTO `sample_work_flow` VALUES ('935e1ff8d25d8c72b221883d3749ff91', '4', '2021-02-02 23:12:00', '2021-02-02 23:12:00', '中午吃的太多，坐着难受', NULL, NULL, '1', '2021-02-02 23:12:58', '1', '2021-02-02 23:12:58');
INSERT INTO `sample_work_flow` VALUES ('95760f367560fee920f2ba92193c50cc', '3', '2021-01-21 09:00:00', '2021-01-21 18:00:00', '生病了', NULL, NULL, '1', '2021-01-21 14:33:26', '1', '2021-01-21 14:33:26');
INSERT INTO `sample_work_flow` VALUES ('a36b4b99f3294d47013323cdae26c175', '2', '2021-01-29 22:43:00', '2021-01-29 22:43:00', '亲戚结婚', NULL, NULL, '1', '2021-01-29 22:43:48', '1', '2021-01-29 22:43:48');
INSERT INTO `sample_work_flow` VALUES ('cc51691988b08f1977b26e0feef1b365', '2', '2021-02-02 23:13:00', '2021-02-02 23:13:00', '我的几双袜子已经半个月没洗了，今天没的穿，只好在家呆着', NULL, NULL, '1', '2021-02-02 23:15:29', '1', '2021-02-02 23:15:29');
COMMIT;

-- ----------------------------
-- Table structure for scheduler_job
-- ----------------------------
DROP TABLE IF EXISTS `scheduler_job`;
CREATE TABLE `scheduler_job` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '任务代码',
  `cron` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'cron',
  `bean` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'bean',
  `method` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'method',
  `last_run_date` datetime DEFAULT NULL COMMENT '上次执行时间',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '状态',
  `sys` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '是否系统',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `edit_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `scheduler_job_code_pk` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='定时任务';

-- ----------------------------
-- Records of scheduler_job
-- ----------------------------
BEGIN;
INSERT INTO `scheduler_job` VALUES ('1535132693535129602', '示例任务1', 'sample-job', '0/5 * * * * ? *', 'sampleJob', 'sampleJob1', '2022-06-13 13:52:30', '2', '0', NULL, 0, '1', '2022-06-10 13:32:10', '1', '2022-06-10 13:32:10');
INSERT INTO `scheduler_job` VALUES ('1535134604426555394', '清理访问日志表里的数据', 'CleanSysLog', '0 0 0 1/1 * ? *', 'cleanSysLog', 'clean', '2023-02-16 11:10:44', '1', '1', NULL, 1, '1', '2022-06-10 13:39:46', '1', '2022-06-10 13:46:09');
INSERT INTO `scheduler_job` VALUES ('1535136351580663810', '清理异常日志表里的数据', 'CleanExceptionLog', '0 0 0 1/1 * ? *', 'cleanExceptionLog', 'clean', '2023-02-16 11:10:44', '1', '1', NULL, 1, '1', '2022-06-10 13:46:42', '1', '2022-06-10 13:47:16');
INSERT INTO `scheduler_job` VALUES ('1535136472057851906', '清理临时目录文件', 'CleanTemporaryFile', '0 0 0 1/1 * ? *', 'cleanTemporaryFile', 'clean', '2023-02-16 11:10:44', '1', '1', '', 1, '1', '2022-06-10 13:47:11', '1', '2022-06-10 13:47:19');
COMMIT;

-- ----------------------------
-- Table structure for scheduler_job_log
-- ----------------------------
DROP TABLE IF EXISTS `scheduler_job_log`;
CREATE TABLE `scheduler_job_log` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `scheduler_job_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '定时任务id',
  `run_date` datetime NOT NULL COMMENT '执行时间',
  `time_consuming` int(11) NOT NULL COMMENT '耗时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='执行日志';

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键;',
  `sys_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'key',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'value',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类型',
  `sys` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '是否系统',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_config_sys_key_pk` (`sys_key`),
  KEY `sys_config_sys_key_index` (`sys_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统参数';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` VALUES ('1', 'sessionInvalidateTime', '86400', 'number', '1', 'session失效时间 单位：秒', 1, '2019-03-03 16:06:49', '1', '2022-05-31 14:02:49', '1');
INSERT INTO `sys_config` VALUES ('1549277647232569346', 'projectName', 'Easy Vben Admin', 'text', '1', '系统名称，用于找回密码、绑定邮箱等', 0, '2022-07-19 14:19:09', '1', '2022-07-19 14:19:09', '1');
INSERT INTO `sys_config` VALUES ('1549628429522030593', 'rememberMeSessionInvalidateTime', '14', 'number', '0', '记住我session失效时间 单位：天', 1, '2022-07-20 13:33:02', '1', '2022-07-20 13:56:21', '1');
INSERT INTO `sys_config` VALUES ('16', 'loginAttempts', '10', 'number', '0', '登录时密码错误尝试次数，超过后会被账号会被锁定', 1, '2019-03-04 21:23:30', '1', '2022-05-31 10:11:47', '1');
INSERT INTO `sys_config` VALUES ('18', 'openRegistration', 'true', 'boolean', '0', '是否开启用户注册', 1, '2019-03-23 09:22:58', '1', '2022-05-31 10:11:41', '1');
INSERT INTO `sys_config` VALUES ('20', 'loginMultipoint', 'false', 'boolean', '0', '是否允许多地登录', 2, '2019-03-27 13:38:32', '1', '2022-05-31 10:18:57', '1');
INSERT INTO `sys_config` VALUES ('4', 'loginLockLength', '300', 'number', '1', '尝试登录次数过多账号锁定时长 单位：秒', 0, '2019-03-03 16:06:49', '1', '2019-03-04 17:47:22', '1');
INSERT INTO `sys_config` VALUES ('48bc9672ea38980c5031b86c73938690', 'cleanSysLog', '90', 'number', '1', '清理多少天前访问日志 单位: 天', 1, '2019-06-27 14:14:45', '1', '2022-06-12 14:54:14', '1');
INSERT INTO `sys_config` VALUES ('5', 'loginVerificationCode', 'false', 'boolean', '0', '是否开启登录验证码', 13, '2019-03-03 16:07:38', '1', '2022-08-05 10:57:45', '1');
INSERT INTO `sys_config` VALUES ('76474672180a3f83b87923c5bc9a86f9', 'messageCheckInterval', '60', 'number', '1', '新消息检查间隔时长 单位：秒', 2, '2019-06-18 22:34:10', '1', '2022-06-28 20:53:40', '1');
INSERT INTO `sys_config` VALUES ('9f20b7a0eb3757ed8c2b98af3148cc3b', 'messageExpire', '600', 'number', '0', '短信验证码有效期 单位：秒', 1, '2020-12-23 14:22:29', '1', '2022-05-31 10:12:14', '1');
INSERT INTO `sys_config` VALUES ('bec91595c56ef6d0d197b745ca6c855f', 'cleanExceptionLog', '90', 'number', '1', '清理多少天前异常日志 单位: 天', 2, '2019-06-27 09:21:12', '1', '2022-06-12 14:54:05', '1');
COMMIT;

-- ----------------------------
-- Table structure for sys_data_source
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_source`;
CREATE TABLE `sys_data_source` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `url` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'url',
  `username` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='数据源';

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '全称',
  `simple_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门代码',
  `type_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '部门类型代码',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '状态',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='部门';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` VALUES ('1', NULL, 'EF科技', 'EF', '', 'company', '1', '', 1, NULL, 5, '', NULL, '1', '2022-06-05 19:33:04');
INSERT INTO `sys_dept` VALUES ('1531875373476855810', '1', '人事部', NULL, NULL, 'hr', '1', '', 1, NULL, 1, '1', '2022-06-01 13:48:45', '1', '2022-06-01 14:09:51');
INSERT INTO `sys_dept` VALUES ('1531875399787724801', '1', '财务部', NULL, NULL, 'finance', '1', '', 2, NULL, 1, '1', '2022-06-01 13:48:51', '1', '2022-06-01 14:06:38');
INSERT INTO `sys_dept` VALUES ('1531875430343229442', '1', '政务事业部', NULL, NULL, 'business:division', '1', '', 3, NULL, 1, '1', '2022-06-01 13:48:58', '1', '2022-06-01 14:06:38');
INSERT INTO `sys_dept` VALUES ('1531875459619471361', '1', '交通事业部', NULL, NULL, 'business:division', '1', '', 4, NULL, 1, '1', '2022-06-01 13:49:05', '1', '2022-06-01 14:06:38');
INSERT INTO `sys_dept` VALUES ('1531875536031301633', '1531875430343229442', '融媒体', NULL, NULL, 'project:team', '1', '', 1, NULL, 1, '1', '2022-06-01 13:49:23', '1', '2022-06-01 14:06:38');
INSERT INTO `sys_dept` VALUES ('1531878177926914049', '1531875430343229442', '就业', NULL, NULL, 'project:team', '1', '', 4, NULL, 1, '1', '2022-06-01 13:59:53', '1', '2022-06-01 14:06:38');
INSERT INTO `sys_dept` VALUES ('1531878188660137986', '1531875430343229442', '体育', NULL, NULL, 'project:team', '1', '', 2, NULL, 0, '1', '2022-06-01 13:59:56', '1', '2022-06-01 14:06:38');
INSERT INTO `sys_dept` VALUES ('1531878205101809665', '1531875430343229442', '资助', NULL, NULL, 'project:team', '1', '', 3, NULL, 0, '1', '2022-06-01 14:00:00', '1', '2022-06-01 14:06:38');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_type`;
CREATE TABLE `sys_dept_type` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键;',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '代码',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值;',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '状态;',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_dept_type_code_pk` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='部门类型';

-- ----------------------------
-- Records of sys_dept_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept_type` VALUES ('1', NULL, 'company', '公司', 1, '1', '', NULL, 5, '', NULL, '1', '2022-06-01 10:21:04');
INSERT INTO `sys_dept_type` VALUES ('1531551871330713601', '1', 'business:division', '事业部', 3, '1', NULL, NULL, 4, '1', '2022-05-31 16:23:16', '1', '2022-06-01 10:21:39');
INSERT INTO `sys_dept_type` VALUES ('1531551893631827970', '1531551871330713601', 'project:team', '项目组', 1, '1', NULL, NULL, 4, '1', '2022-05-31 16:23:21', '1', '2022-06-01 10:22:16');
INSERT INTO `sys_dept_type` VALUES ('1531820984426848258', '1', 'hr', '人事', 2, '1', NULL, NULL, 6, '1', '2022-06-01 10:12:37', '1', '2022-06-01 14:09:51');
INSERT INTO `sys_dept_type` VALUES ('1531821039040880641', '1', 'finance', '财务', 1, '1', NULL, NULL, 2, '1', '2022-06-01 10:12:50', '1', '2022-06-01 10:21:32');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept_type_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_type_role`;
CREATE TABLE `sys_dept_type_role` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键;',
  `dept_type_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '部门类型id',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_dept_type_role_dept_type_id_role_id_pk` (`dept_type_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='部门类型&角色';

-- ----------------------------
-- Records of sys_dept_type_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept_type_role` VALUES ('1531823112172101633', '1', '1531819854540070914');
INSERT INTO `sys_dept_type_role` VALUES ('1531823112180490241', '1', '1531821964014936065');
INSERT INTO `sys_dept_type_role` VALUES ('1531823255067844609', '1531551871330713601', '1531821754819829762');
INSERT INTO `sys_dept_type_role` VALUES ('1531823412454907906', '1531551893631827970', '1531823375461146625');
INSERT INTO `sys_dept_type_role` VALUES ('1531880684606459906', '1531820984426848258', '1531819907467993089');
INSERT INTO `sys_dept_type_role` VALUES ('1531823226068426754', '1531821039040880641', '1531821666106105858');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '编码',
  `parent_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父code',
  `dict_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '字典类型',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `display_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '显示方式',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_dict_dict_type_code_pk` (`dict_type`,`code`),
  KEY `sys_dict_dict_type_index` (`dict_type`),
  KEY `sys_dict_dict_type_code_index` (`dict_type`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict` VALUES ('04a9e2a9562a5714a9b1cd6fe1fdc55f', '激活', '1', '', 'suspensionState', NULL, 'green', '1', '', 1, 0, '1', '2020-05-21 10:53:15', '1', '2020-05-22 13:26:10');
INSERT INTO `sys_dict` VALUES ('0e7da7a963cf78a28c94d05c95b2c382', '年假', '1', '', 'leaveType', NULL, '', '1', '', 1, 0, '1', '2020-04-26 15:15:25', '1', '2020-04-26 15:15:25');
INSERT INTO `sys_dict` VALUES ('1003', '启用', '1', '', 'userStatus', NULL, 'green', '1', '', 1, 0, '1', '2018-11-19 20:04:25', '1', '2018-11-19 20:05:50');
INSERT INTO `sys_dict` VALUES ('1004', '禁用', '2', '', 'userStatus', NULL, 'red', '1', '', 2, 0, '1', '2018-11-19 20:05:36', '1', '2018-11-19 20:05:36');
INSERT INTO `sys_dict` VALUES ('1005', '已删除', '0', '', 'userStatus', NULL, 'red', '1', '', 3, 0, '1', '2018-11-19 20:08:14', '1', '2019-05-26 12:45:47');
INSERT INTO `sys_dict` VALUES ('1008', '启用', '1', '', 'commonStatus', NULL, 'green', '1', '', 1, 0, '1', '2018-11-19 20:11:14', '1', '2018-11-19 20:11:14');
INSERT INTO `sys_dict` VALUES ('1009', '禁用', '2', '', 'commonStatus', NULL, 'red', '1', '', 2, 0, '1', '2018-11-19 20:11:26', '1', '2018-11-19 20:11:26');
INSERT INTO `sys_dict` VALUES ('1014', 'sys', 'sys', '', 'module', NULL, '', '1', '', 1, 0, '1', '2019-01-10 17:35:42', '1', '2019-01-10 17:35:42');
INSERT INTO `sys_dict` VALUES ('1015', 'business', 'business', '', 'module', NULL, '', '1', '', 2, 0, '1', '2019-01-10 17:36:12', '1', '2019-01-10 17:36:12');
INSERT INTO `sys_dict` VALUES ('1016', 'sample', 'sample', '', 'module', NULL, '', '1', '', 3, 0, '1', '2019-01-10 17:36:47', '1', '2019-01-10 17:36:47');
INSERT INTO `sys_dict` VALUES ('1021', '=', 'eq', NULL, 'matchingMode', NULL, NULL, '1', NULL, 1, 0, '1', '2019-01-11 15:18:06', '1', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1022', '!=', 'ne', '', 'matchingMode', NULL, '', '1', '', 2, 0, '1', '2019-01-11 15:18:06', '1', '2019-05-05 21:49:09');
INSERT INTO `sys_dict` VALUES ('1023', '>', 'gt', NULL, 'matchingMode', NULL, NULL, '1', NULL, 3, 0, '1', '2019-01-11 15:18:06', '1', '2021-01-22 16:02:16');
INSERT INTO `sys_dict` VALUES ('1024', '>=', 'gte', NULL, 'matchingMode', NULL, NULL, '1', NULL, 4, 0, '1', '2019-01-11 15:18:06', '1', '2021-01-22 16:02:24');
INSERT INTO `sys_dict` VALUES ('1025', '<', 'lt', NULL, 'matchingMode', NULL, NULL, '1', NULL, 5, 0, '1', '2019-01-11 15:18:06', '1', '2021-01-22 16:02:32');
INSERT INTO `sys_dict` VALUES ('1026', '<=', 'lte', NULL, 'matchingMode', NULL, NULL, '1', NULL, 6, 0, '1', '2019-01-11 15:18:06', '1', '2021-01-22 16:02:40');
INSERT INTO `sys_dict` VALUES ('1027', 'like', 'like', NULL, 'matchingMode', NULL, NULL, '1', NULL, 7, 0, '1', '2019-01-11 15:18:06', '1', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1028', '左 like', 'left_like', NULL, 'matchingMode', NULL, NULL, '1', NULL, 8, 0, '1', '2019-01-11 15:18:06', '1', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1029', '右 like', 'right_like', NULL, 'matchingMode', NULL, NULL, '1', NULL, 9, 0, '1', '2019-01-11 15:18:06', '1', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1039', '一行两列', '2', NULL, 'grid', NULL, NULL, '1', NULL, 2, 0, '1', '2019-01-11 15:18:06', '1', '2021-12-20 15:53:57');
INSERT INTO `sys_dict` VALUES ('1040', '一行一列', '1', NULL, 'grid', NULL, NULL, '1', NULL, 1, 0, '1', '2019-01-11 15:18:06', '1', '2021-12-20 15:53:45');
INSERT INTO `sys_dict` VALUES ('1046', '电子邮件', 'email', '', 'verification', NULL, NULL, '2', '', 2, 1, '1', '2019-01-11 15:18:06', '1', '2022-06-05 19:11:15');
INSERT INTO `sys_dict` VALUES ('1047', '网址', 'url', NULL, 'verification', NULL, NULL, '1', NULL, 3, 0, '1', '2019-01-11 15:18:06', '1', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1048', '日期', 'date', NULL, 'verification', NULL, NULL, '1', NULL, 4, 0, '1', '2019-01-11 15:18:06', '1', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1049', '日期 (YYYY-MM-DD)', 'dateISO', NULL, 'verification', NULL, NULL, '1', NULL, 5, 0, '1', '2019-01-11 15:18:06', '1', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1050', '数字', 'number', NULL, 'verification', NULL, NULL, '1', NULL, 6, 0, '1', '2019-01-11 15:18:06', '1', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1053', 'login:attempt:', 'login:attempt:', '', 'redisPrefix', NULL, '', '1', '用户登录尝试次数', 1, 4, '1', '2019-01-26 10:50:10', '1', '2022-07-25 14:29:30');
INSERT INTO `sys_dict` VALUES ('1055', 'shiro:authorization:', 'shiro:authorization:', '', 'redisPrefix', NULL, '', '1', 'Shiro 授权', 4, 3, '1', '2019-01-26 10:53:28', '1', '2022-07-25 14:30:15');
INSERT INTO `sys_dict` VALUES ('1056', '数字', 'number', '', 'dataType', NULL, '', '1', '', 1, 0, '1', '2019-03-02 21:38:28', '1', '2019-03-02 21:38:28');
INSERT INTO `sys_dict` VALUES ('1057', '字符串', 'text', '', 'dataType', NULL, '', '1', '', 2, 0, '1', '2019-03-02 21:38:40', '1', '2019-03-02 21:38:40');
INSERT INTO `sys_dict` VALUES ('1058', '布尔值', 'boolean', '', 'dataType', NULL, '', '1', '', 3, 0, '1', '2019-03-02 21:46:51', '1', '2019-03-02 21:46:51');
INSERT INTO `sys_dict` VALUES ('1059', 'sys:config:', 'sys:config:', '', 'redisPrefix', NULL, '', '1', '系统参数', 5, 2, '1', '2019-03-22 23:43:40', '1', '2022-07-25 14:30:56');
INSERT INTO `sys_dict` VALUES ('1061', 'reset:password:verification:code:', 'reset:password:verification:code:', '', 'redisPrefix', NULL, '', '1', '', 6, 0, '1', '2019-04-09 12:29:01', '1', '2019-04-09 12:29:01');
INSERT INTO `sys_dict` VALUES ('1062', '男', '1', '', 'sex', 'ant-design:man-outlined', 'blue', '1', '', 1, 1, '1', '2019-04-09 12:34:55', '1', '2022-06-09 16:29:52');
INSERT INTO `sys_dict` VALUES ('1063', '女', '2', '', 'sex', 'ant-design:woman-outlined', 'pink', '1', '', 2, 1, '1', '2019-04-09 12:35:02', '1', '2022-06-09 16:30:06');
INSERT INTO `sys_dict` VALUES ('1064', 'import', 'import', '', 'module', NULL, '', '1', '', 4, 0, '1', '2019-04-10 15:50:30', '1', '2019-04-10 15:50:30');
INSERT INTO `sys_dict` VALUES ('1067', 'scheduler', 'scheduler', '', 'module', NULL, '', '1', '', 5, 0, '1', '2019-05-11 22:59:39', '1', '2019-05-11 22:59:39');
INSERT INTO `sys_dict` VALUES ('1068', '开启', '1', '', 'schedulerJobStatus', NULL, 'green', '1', '', 1, 0, '1', '2019-05-12 10:12:32', '1', '2019-06-12 15:15:45');
INSERT INTO `sys_dict` VALUES ('1069', '暂停', '2', '', 'schedulerJobStatus', NULL, 'orange', '1', '', 2, 0, '1', '2019-05-12 10:12:48', '1', '2019-05-12 10:16:36');
INSERT INTO `sys_dict` VALUES ('1072', '通知', 'notice', '', 'messageType', NULL, 'blue', '1', '', 1, 0, '1', '2019-06-07 23:18:55', '1', '2019-06-07 23:22:16');
INSERT INTO `sys_dict` VALUES ('1073', '事件', 'event', '', 'messageType', NULL, 'orange', '1', '', 2, 0, '1', '2019-06-07 23:19:10', '1', '2019-06-07 23:22:23');
INSERT INTO `sys_dict` VALUES ('1074', '日志', 'journal', '', 'messageType', NULL, 'green', '1', '', 3, 0, '1', '2019-06-07 23:19:25', '1', '2019-11-06 16:24:07');
INSERT INTO `sys_dict` VALUES ('12f5cb3d041e411380669ab5925f82be', '高', '5', NULL, 'passwordStrength', NULL, 'blue', '1', NULL, 5, 0, '1', '2020-12-22 14:07:52', '1', '2020-12-22 14:07:52');
INSERT INTO `sys_dict` VALUES ('1527910661068193793', 'pink', 'pink', NULL, 'tagColor', NULL, 'pink', '1', NULL, 1, 1, '1', '2022-05-21 15:14:23', '1', '2022-05-21 15:14:33');
INSERT INTO `sys_dict` VALUES ('1527912701781639169', 'red', 'red', NULL, 'tagColor', NULL, 'red', '1', NULL, 2, 1, '1', '2022-05-21 15:22:30', '1', '2022-05-21 15:33:11');
INSERT INTO `sys_dict` VALUES ('1527912731217264642', 'orange', 'orange', NULL, 'tagColor', NULL, 'orange', '1', NULL, 3, 1, '1', '2022-05-21 15:22:37', '1', '2022-05-21 15:35:35');
INSERT INTO `sys_dict` VALUES ('1527916051981959169', 'green', 'green', NULL, 'tagColor', NULL, 'green', '1', NULL, 4, 0, '1', '2022-05-21 15:35:49', '1', '2022-05-21 15:35:49');
INSERT INTO `sys_dict` VALUES ('1527916087998447617', 'cyan', 'cyan', NULL, 'tagColor', NULL, 'cyan', '1', NULL, 5, 0, '1', '2022-05-21 15:35:57', '1', '2022-05-21 15:35:57');
INSERT INTO `sys_dict` VALUES ('1527916122504986625', 'blue', 'blue', NULL, 'tagColor', NULL, 'blue', '1', NULL, 6, 0, '1', '2022-05-21 15:36:06', '1', '2022-05-21 15:36:06');
INSERT INTO `sys_dict` VALUES ('1527916150556491777', 'purple', 'purple', NULL, 'tagColor', NULL, 'purple', '1', NULL, 7, 0, '1', '2022-05-21 15:36:12', '1', '2022-05-21 15:36:12');
INSERT INTO `sys_dict` VALUES ('1528582008094101506', '1', '1', NULL, 'levelSample', NULL, NULL, '1', NULL, 1, 0, '1', '2022-05-23 11:42:05', '1', '2022-05-23 11:42:05');
INSERT INTO `sys_dict` VALUES ('1528582021373267970', '2', '2', NULL, 'levelSample', NULL, NULL, '1', NULL, 2, 0, '1', '2022-05-23 11:42:08', '1', '2022-05-23 11:42:08');
INSERT INTO `sys_dict` VALUES ('1528582033419309057', '3', '3', NULL, 'levelSample', NULL, NULL, '1', NULL, 3, 0, '1', '2022-05-23 11:42:11', '1', '2022-05-23 11:42:11');
INSERT INTO `sys_dict` VALUES ('1528606637907021826', '1-1', '1-1', '1', 'levelSample', NULL, NULL, '1', NULL, 4, 2, '1', '2022-05-23 13:19:57', '1', '2022-05-23 13:23:52');
INSERT INTO `sys_dict` VALUES ('1528609552776335361', '1-2', '1-2', '1', 'levelSample', NULL, NULL, '1', NULL, 5, 0, '1', '2022-05-23 13:31:32', '1', '2022-05-23 13:31:32');
INSERT INTO `sys_dict` VALUES ('1528609580177723394', '1-3', '1-3', '1', 'levelSample', NULL, NULL, '1', NULL, 6, 0, '1', '2022-05-23 13:31:39', '1', '2022-05-23 13:31:39');
INSERT INTO `sys_dict` VALUES ('1528609630555508737', '1-1-1', '1-1-1', '1-1', 'levelSample', NULL, NULL, '1', NULL, 7, 0, '1', '2022-05-23 13:31:51', '1', '2022-05-23 13:31:51');
INSERT INTO `sys_dict` VALUES ('1528609650868523010', '1-1-2', '1-1-2', '1-1', 'levelSample', NULL, NULL, '1', NULL, 8, 0, '1', '2022-05-23 13:31:56', '1', '2022-05-23 13:31:56');
INSERT INTO `sys_dict` VALUES ('1528709421889261570', '2-1', '2-1', '2', 'levelSample', NULL, NULL, '1', NULL, 9, 0, '1', '2022-05-23 20:08:23', '1', '2022-05-23 20:08:23');
INSERT INTO `sys_dict` VALUES ('1528987370731376641', '菜单', 'menu', '', 'permissionType', NULL, 'green', '1', NULL, 2, 2, '1', '2022-05-24 14:32:51', '1', '2022-06-15 11:07:24');
INSERT INTO `sys_dict` VALUES ('1528987641930878978', '目录', 'catalogue', '', 'permissionType', NULL, 'blue', '1', NULL, 1, 1, '1', '2022-05-24 14:33:56', '1', '2022-06-15 11:07:17');
INSERT INTO `sys_dict` VALUES ('1528987675300761601', '按钮', 'button', '', 'permissionType', NULL, 'purple', '1', NULL, 3, 1, '1', '2022-05-24 14:34:04', '1', '2022-06-15 11:07:29');
INSERT INTO `sys_dict` VALUES ('1529346181879054338', '是', '1', '', 'external', NULL, 'red', '1', NULL, 1, 11, '1', '2022-05-25 14:18:38', '1', '2022-05-25 15:05:09');
INSERT INTO `sys_dict` VALUES ('1529346219996889089', '否', '0', '', 'external', NULL, 'green', '1', NULL, 2, 3, '1', '2022-05-25 14:18:47', '1', '2022-05-25 14:21:59');
INSERT INTO `sys_dict` VALUES ('1536225251468279809', 'GET', 'GET', '', 'httpMethod', NULL, 'green', '1', NULL, 1, 0, '1', '2022-06-13 13:53:36', '1', '2022-06-13 13:53:36');
INSERT INTO `sys_dict` VALUES ('1536225304308121602', 'POST', 'POST', NULL, 'httpMethod', NULL, 'blue', '1', NULL, 2, 0, '1', '2022-06-13 13:53:49', '1', '2022-06-13 13:53:49');
INSERT INTO `sys_dict` VALUES ('1536225343902351361', 'PUT', 'PUT', NULL, 'httpMethod', NULL, 'blue', '1', NULL, 3, 0, '1', '2022-06-13 13:53:58', '1', '2022-06-13 13:53:58');
INSERT INTO `sys_dict` VALUES ('1536225392333979649', 'DELETE', 'DELETE', NULL, 'httpMethod', NULL, 'red', '1', NULL, 4, 0, '1', '2022-06-13 13:54:10', '1', '2022-06-13 13:54:10');
INSERT INTO `sys_dict` VALUES ('1536225486085062658', 'OPTIONS', 'OPTIONS', NULL, 'httpMethod', NULL, 'cyan', '1', NULL, 5, 0, '1', '2022-06-13 13:54:32', '1', '2022-06-13 13:54:32');
INSERT INTO `sys_dict` VALUES ('1537341637397618690', 'start ~ end', 'start_end', '', 'matchingMode', NULL, NULL, '1', NULL, 10, 0, '1', '2022-06-16 15:49:43', '1', '2022-06-16 15:49:43');
INSERT INTO `sys_dict` VALUES ('1541698314917945345', '未读', '0', '', 'messageStatus', NULL, 'red', '1', NULL, 1, 0, '1', '2022-06-28 16:21:36', '1', '2022-06-28 16:21:36');
INSERT INTO `sys_dict` VALUES ('1541698354638004225', '已读', '1', NULL, 'messageStatus', NULL, 'green', '1', NULL, 2, 0, '1', '2022-06-28 16:21:45', '1', '2022-06-28 16:21:45');
INSERT INTO `sys_dict` VALUES ('1551454498096967681', 'login:lock:', 'login:lock:', '', 'redisPrefix', NULL, NULL, '1', '用户登录锁定账号', 2, 1, '1', '2022-07-25 14:29:11', '1', '2022-07-25 14:29:26');
INSERT INTO `sys_dict` VALUES ('1551454796261650433', 'shiro:session:', 'shiro:session:', '', 'redisPrefix', NULL, NULL, '1', '', 3, 0, '1', '2022-07-25 14:30:22', '1', '2022-07-25 14:30:22');
INSERT INTO `sys_dict` VALUES ('1551455106229104641', 'binding:phone:verification:code', 'binding:phone:verification:code', '', 'redisPrefix', NULL, NULL, '1', '绑定手机号短信验证码', 7, 0, '1', '2022-07-25 14:31:36', '1', '2022-07-25 14:31:36');
INSERT INTO `sys_dict` VALUES ('1623855425239711745', '表格 - Table', 'table', '', 'listGeneratorTemplate', NULL, NULL, '1', NULL, 1, 1, '1', '2023-02-10 09:24:38', '1', '2023-02-10 09:25:13');
INSERT INTO `sys_dict` VALUES ('1623855470072627202', '树表格 - TreeTable', 'tree-table', '', 'listGeneratorTemplate', NULL, NULL, '1', NULL, 2, 1, '1', '2023-02-10 09:24:48', '1', '2023-02-10 09:25:20');
INSERT INTO `sys_dict` VALUES ('1623855529438806017', '树 - Tree', 'tree', '', 'listGeneratorTemplate', NULL, NULL, '1', NULL, 3, 1, '1', '2023-02-10 09:25:03', '1', '2023-02-10 09:25:26');
INSERT INTO `sys_dict` VALUES ('1623855725040173057', '抽屉 - Drawer', 'drawer', '', 'inputGeneratorTemplate', NULL, NULL, '1', NULL, 2, 1, '1', '2023-02-10 09:25:49', '1', '2023-02-10 09:26:10');
INSERT INTO `sys_dict` VALUES ('1623855873698889729', '对话框 - Modal', 'modal', '', 'inputGeneratorTemplate', NULL, NULL, '1', NULL, 1, 0, '1', '2023-02-10 09:26:25', '1', '2023-02-10 09:26:25');
INSERT INTO `sys_dict` VALUES ('1623855956687388673', '页面 - Page', 'page', '', 'inputGeneratorTemplate', NULL, NULL, '1', NULL, 3, 0, '1', '2023-02-10 09:26:45', '1', '2023-02-10 09:26:45');
INSERT INTO `sys_dict` VALUES ('1760cfb5a2eea70a091a1f49801c16aa', '用户审批', 'userTask', '', 'activityType', '', 'orange', '1', '', 2, 28, '1', '2020-05-07 20:01:47', '1', '2022-07-13 14:03:08');
INSERT INTO `sys_dict` VALUES ('19428ffc5b02c47c2bb958eb293b72fa', 'save', 'save', NULL, 'genMethod', NULL, NULL, '1', NULL, 3, 0, '1', '2021-01-22 10:43:14', '1', '2021-01-22 10:43:14');
INSERT INTO `sys_dict` VALUES ('25145620da33d7828b7f12ab88dcf64d', '页面', 'page', NULL, 'cmsReleaseType', NULL, NULL, '1', NULL, 1, 0, '1', '2021-12-08 10:21:58', '1', '2021-12-08 10:21:58');
INSERT INTO `sys_dict` VALUES ('258aa110058920e3d25ab4a4f8c8606b', 'Model.java', 'model', '', 'genFile', NULL, NULL, '1', NULL, 1, 1, '1', '2021-01-22 10:45:27', '1', '2022-06-20 17:17:24');
INSERT INTO `sys_dict` VALUES ('2b9c81faded52d3c3f4753741b201d14', '病假', '3', '', 'leaveType', NULL, '', '1', '', 3, 0, '1', '2020-04-26 15:15:39', '1', '2020-04-26 15:15:39');
INSERT INTO `sys_dict` VALUES ('2c67e2515e5c4cd9640fb578ede02495', '文章', 'article', NULL, 'cmsReleaseType', NULL, NULL, '1', NULL, 3, 0, '1', '2021-12-08 10:22:46', '1', '2021-12-08 10:22:46');
INSERT INTO `sys_dict` VALUES ('2cb335b11141e600e4b6afbcfcb38a91', '当前页面', '1', NULL, 'openMode', NULL, NULL, '1', NULL, 1, 1, '1', '2021-01-04 10:23:18', '1', '2022-05-25 10:11:11');
INSERT INTO `sys_dict` VALUES ('3028aa52cd73fcb37264b14b3c2e2908', 'Input.vue', 'input.vue', '', 'genFile', NULL, NULL, '1', NULL, 8, 1, '1', '2021-01-22 10:46:32', '1', '2022-06-20 17:25:01');
INSERT INTO `sys_dict` VALUES ('397b3c02d8ea5e9e6b65316400312157', '挂起', '2', '', 'suspensionState', NULL, 'orange', '1', '', 2, 0, '1', '2020-05-21 10:52:58', '1', '2020-05-22 13:26:14');
INSERT INTO `sys_dict` VALUES ('39a161672dd6fa4178a329698c830e0b', '中', '3', NULL, 'passwordStrength', NULL, 'green', '1', NULL, 3, 0, '1', '2020-12-22 14:07:31', '1', '2020-12-22 14:07:31');
INSERT INTO `sys_dict` VALUES ('3f03e720aea2428e01787e067ea450bc', '发布中', '1', NULL, 'cmsReleaseStatus', NULL, 'cyan', '1', NULL, 2, 0, '1', '2021-12-01 16:15:10', '1', '2021-12-01 16:57:35');
INSERT INTO `sys_dict` VALUES ('40a7017e155919c64a51e6c151971753', '丧假', '8', '', 'leaveType', NULL, '', '1', '', 8, 0, '1', '2020-04-26 15:16:27', '1', '2020-04-26 15:16:27');
INSERT INTO `sys_dict` VALUES ('435db13414527a124821bd4328b87251', '视频', 'video', NULL, 'cmsMediaType', NULL, NULL, '1', NULL, 3, 0, '1', '2021-11-22 10:52:23', '1', '2021-11-22 10:52:23');
INSERT INTO `sys_dict` VALUES ('438f09448b2ce4c6767245af8eb249ce', '高', '4', NULL, 'passwordStrength', NULL, 'cyan', '1', NULL, 4, 0, '1', '2020-12-22 14:07:40', '1', '2020-12-22 14:07:40');
INSERT INTO `sys_dict` VALUES ('4583396985c52c5b02b10f6db6a127c2', '发布失败', '-2', NULL, 'cmsReleaseStatus', NULL, 'red', '1', NULL, 5, 0, '1', '2021-12-01 16:15:59', '1', '2021-12-08 10:31:34');
INSERT INTO `sys_dict` VALUES ('458cfa6224c1bd02ec544402b9a746b4', '事假', '2', '', 'leaveType', NULL, '', '1', '', 2, 0, '1', '2020-04-26 15:15:32', '1', '2020-04-26 15:15:32');
INSERT INTO `sys_dict` VALUES ('483277621a0e921fa0eed6c048096333', '条件网关', 'exclusiveGateway', '', 'activityType', NULL, 'orange', '1', '', 3, 0, '1', '2020-05-07 20:00:20', '1', '2020-05-14 14:14:37');
INSERT INTO `sys_dict` VALUES ('48e84b1c57b883ee54e80e44ab2c35ea', '否', '0', '', 'whether', NULL, 'red', '1', NULL, 2, 3, '1', '2021-11-18 14:40:06', '1', '2022-05-25 14:49:41');
INSERT INTO `sys_dict` VALUES ('4a05aea7b167e6d9cd0e74525579054d', '陪产假', '6', '', 'leaveType', NULL, '', '1', '', 6, 0, '1', '2020-04-26 15:16:00', '1', '2020-04-26 15:16:00');
INSERT INTO `sys_dict` VALUES ('4adcad08e2df1a9b91c11ee6ab88af1b', 'List.vue', 'list.vue', '', 'genFile', NULL, NULL, '1', NULL, 7, 1, '1', '2021-01-22 10:46:23', '1', '2022-06-20 17:24:55');
INSERT INTO `sys_dict` VALUES ('4f96ea5fbc3529db7cf3f8a262dace6a', '导出数据', 'exportData', NULL, 'genMethod', NULL, NULL, '1', NULL, 5, 0, '1', '2021-02-23 09:35:30', '1', '2021-02-23 09:35:30');
INSERT INTO `sys_dict` VALUES ('60fdc971326940a631bb8aec29536685', '已取消', '-1', NULL, 'cmsReleaseStatus', NULL, 'red', '1', NULL, 4, 0, '1', '2021-12-01 16:15:42', '1', '2021-12-01 16:15:42');
INSERT INTO `sys_dict` VALUES ('62936bbf418a384f442a519b40e55e4f', 'Api.ts', 'api.ts', '', 'genFile', NULL, NULL, '1', NULL, 9, 2, '1', '2021-01-22 10:46:48', '1', '2022-06-20 17:19:04');
INSERT INTO `sys_dict` VALUES ('64c22620aba0d2ad61346d8be1a3fb7d', '已撤销', '-1', '', 'taskStatus', NULL, 'orange', '1', '', 2, 0, '1', '2020-05-22 21:46:51', '1', '2020-05-22 21:46:51');
INSERT INTO `sys_dict` VALUES ('665c26f13ba2e173cd96f8340a7ceb5e', '手动', '1', NULL, 'cmsArticleReleaseType', NULL, 'blue', '1', NULL, 1, 0, '1', '2021-11-19 15:30:42', '1', '2021-11-19 15:30:42');
INSERT INTO `sys_dict` VALUES ('66b935e4c514ecd0c1e2572368f74161', 'Mapper.java', 'mapper', '', 'genFile', NULL, NULL, '1', NULL, 2, 2, '1', '2021-01-22 10:45:34', '1', '2022-06-20 17:21:33');
INSERT INTO `sys_dict` VALUES ('684149de7513dbf9b34784a754bd923f', '低', '2', NULL, 'passwordStrength', NULL, 'orange', '1', NULL, 2, 0, '1', '2020-12-22 14:07:12', '1', '2020-12-22 14:07:12');
INSERT INTO `sys_dict` VALUES ('6a00cf2f4001d74b1b3a7ac0385a7f6a', '是', '1', '', 'whether', NULL, 'green', '1', NULL, 1, 3, '1', '2021-11-18 14:39:53', '1', '2022-05-25 14:49:35');
INSERT INTO `sys_dict` VALUES ('6b19039d2e3144bf3ab7ea4b87ca75c0', 'true', 'true', '', 'boolean', NULL, 'green', '1', '', 1, 9, '1', '2021-01-14 13:55:29', '1', '2022-05-26 14:48:04');
INSERT INTO `sys_dict` VALUES ('6b7e8cfb87c04ed395ec5ea64b9fa48d', 'Controller.java', 'controller', '', 'genFile', NULL, NULL, '1', NULL, 6, 1, '1', '2021-01-22 10:46:11', '1', '2022-06-20 17:17:58');
INSERT INTO `sys_dict` VALUES ('72dff2db5a4785f5598187ca985241dc', '音频', 'audio', NULL, 'cmsMediaType', NULL, NULL, '1', NULL, 2, 0, '1', '2021-11-22 10:52:12', '1', '2021-11-22 10:52:12');
INSERT INTO `sys_dict` VALUES ('77bb9b37af3c8613622cad58b6304151', '自动', '2', NULL, 'cmsArticleReleaseType', NULL, 'green', '1', NULL, 2, 0, '1', '2021-11-19 15:30:57', '1', '2021-11-19 15:30:57');
INSERT INTO `sys_dict` VALUES ('782b05bc86650ebee8e0a63511117b81', '流程结束', 'endEvent', '', 'activityType', NULL, 'blue', '1', '', 10, 0, '1', '2020-05-07 20:03:06', '1', '2020-05-14 14:12:17');
INSERT INTO `sys_dict` VALUES ('81a9fe5b6ea8e48e9e277bbe002ed729', '调休', '4', '', 'leaveType', NULL, '', '1', '', 4, 0, '1', '2020-04-26 15:15:45', '1', '2020-04-26 15:15:45');
INSERT INTO `sys_dict` VALUES ('82a5eff09f8c6d937fb6bfb13efed39b', '导入数据', 'importData', NULL, 'genMethod', NULL, NULL, '1', NULL, 6, 0, '1', '2021-02-23 09:35:42', '1', '2021-02-23 09:35:42');
INSERT INTO `sys_dict` VALUES ('901e8d61eeb73a96822997e15064776c', '低', '1', NULL, 'passwordStrength', NULL, 'red', '1', NULL, 1, 0, '1', '2020-12-22 14:07:03', '1', '2020-12-22 14:07:03');
INSERT INTO `sys_dict` VALUES ('9a072d4f0f483abc6b2621a8257ff65d', 'Service.java', 'service', '', 'genFile', NULL, NULL, '1', NULL, 4, 1, '1', '2021-01-22 10:45:51', '1', '2022-06-20 17:17:46');
INSERT INTO `sys_dict` VALUES ('9d4641ff43b7b60a1a9d78f660926309', '产检假', '9', '', 'leaveType', NULL, '', '1', '', 9, 0, '1', '2020-04-26 15:16:36', '1', '2020-04-26 15:16:36');
INSERT INTO `sys_dict` VALUES ('9e1a3416550ac3582ea0b28fe8f8d607', 'false', 'false', '', 'boolean', NULL, 'red', '1', '', 2, 1, '1', '2021-01-14 13:55:37', '1', '2022-05-23 20:16:32');
INSERT INTO `sys_dict` VALUES ('a0a1f7c3b2dc9c599baa79b5bde97321', '已发布', '1', NULL, 'cmsArticleStatus', NULL, 'green', '1', NULL, 2, 0, '1', '2021-11-19 15:31:26', '1', '2021-11-19 15:31:26');
INSERT INTO `sys_dict` VALUES ('a700a0725ed3818b5d5e06ebcbdbdc7a', '产假', '5', '', 'leaveType', NULL, '', '1', '', 5, 0, '1', '2020-04-26 15:15:52', '1', '2020-04-26 15:15:52');
INSERT INTO `sys_dict` VALUES ('a94135a3521ecf3507b462a28a44aa83', '文档', 'doc', NULL, 'cmsMediaType', NULL, NULL, '1', NULL, 4, 0, '1', '2021-11-22 10:52:31', '1', '2021-11-22 10:52:31');
INSERT INTO `sys_dict` VALUES ('b88be5998e52644275e558cb27605e6d', '已办结', '2', '', 'taskStatus', NULL, 'green', '1', '', 3, 0, '1', '2020-05-22 21:47:03', '1', '2020-05-22 21:47:03');
INSERT INTO `sys_dict` VALUES ('b8de17a629fc368aa9d5060b6961b93d', '流程发起', 'startEvent', '', 'activityType', '', 'green', '1', '', 8, 1, '1', '2020-05-07 20:01:33', '1', '2022-05-23 15:57:41');
INSERT INTO `sys_dict` VALUES ('bc64972ab051639909c486eee09284ae', 'add', 'add', NULL, 'genMethod', NULL, NULL, '1', NULL, 1, 0, '1', '2021-01-22 10:42:55', '1', '2021-01-22 10:42:55');
INSERT INTO `sys_dict` VALUES ('c2408b1dc5d8bf627f0f4fd611a725f1', '图片', 'image', NULL, 'cmsMediaType', NULL, NULL, '1', NULL, 1, 0, '1', '2021-11-22 10:51:58', '1', '2021-11-22 10:51:58');
INSERT INTO `sys_dict` VALUES ('c89b35e88b0bb6d5bc4a07231d8a46b6', '待发布', '0', NULL, 'cmsReleaseStatus', NULL, 'orange', '1', NULL, 1, 0, '1', '2021-12-01 16:15:01', '1', '2021-12-01 16:16:13');
INSERT INTO `sys_dict` VALUES ('ca12852b5dc75f5c18eff0cf9fbfaea8', '婚假', '7', '', 'leaveType', NULL, '', '1', '', 7, 0, '1', '2020-04-26 15:16:08', '1', '2020-04-26 15:16:08');
INSERT INTO `sys_dict` VALUES ('cc74089891bda57d92ad8ee76cdcd071', '已完成', '2', NULL, 'cmsReleaseStatus', NULL, 'green', '1', NULL, 3, 0, '1', '2021-12-01 16:15:30', '1', '2021-12-01 16:57:41');
INSERT INTO `sys_dict` VALUES ('d06fe9ab7a91394f2884e549e76d1f0b', 'remove', 'remove', NULL, 'genMethod', NULL, NULL, '1', NULL, 2, 0, '1', '2021-01-22 10:43:07', '1', '2021-01-22 10:43:07');
INSERT INTO `sys_dict` VALUES ('d5d331b8c4f32c0f1b92eb4b2b1ffcd6', '其他', 'other', NULL, 'cmsMediaType', NULL, NULL, '1', NULL, 5, 0, '1', '2021-11-22 10:52:40', '1', '2021-11-22 10:52:40');
INSERT INTO `sys_dict` VALUES ('d807c53a3aaa8b2d5df8484093a78bf1', '已撤销', '-1', NULL, 'cmsArticleStatus', NULL, 'red', '1', NULL, 3, 0, '1', '2021-11-19 15:31:36', '1', '2021-11-19 15:31:36');
INSERT INTO `sys_dict` VALUES ('dcf701520b55e0381436c1fed7fe57cf', '办理中', '1', '', 'taskStatus', NULL, 'blue', '1', '', 1, 0, '1', '2020-05-22 21:44:17', '1', '2020-05-22 21:44:17');
INSERT INTO `sys_dict` VALUES ('e5a370445b0d81b6bde90ba1e7533039', 'select', 'select', NULL, 'genMethod', NULL, NULL, '1', NULL, 4, 0, '1', '2021-01-22 10:43:21', '1', '2021-01-22 10:43:21');
INSERT INTO `sys_dict` VALUES ('e6afb823cf7f1057dc5afc03a196480b', '栏目', 'column', NULL, 'cmsReleaseType', NULL, NULL, '1', NULL, 2, 0, '1', '2021-12-08 10:22:35', '1', '2021-12-08 10:22:35');
INSERT INTO `sys_dict` VALUES ('e71e1827d384550145ca83cd1140f3b0', '特殊工伤假', '10', '', 'leaveType', NULL, '', '1', '', 10, 0, '1', '2020-04-26 15:16:44', '1', '2020-04-26 15:16:44');
INSERT INTO `sys_dict` VALUES ('e75b3cf8a6ab33fe9c6e8a3c3fd50130', '新建标签页', '2', NULL, 'openMode', NULL, NULL, '1', NULL, 2, 1, '1', '2021-01-04 10:23:31', '1', '2022-05-25 10:11:19');
INSERT INTO `sys_dict` VALUES ('efd649d15808496398ac5386336ebb83', '草稿', '0', NULL, 'cmsArticleStatus', NULL, 'orange', '1', NULL, 1, 0, '1', '2021-11-19 15:31:15', '1', '2021-11-19 15:31:15');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键;',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类别名称',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '字典类别',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `sys` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '是否系统',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_dict_type_type_pk` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典类别';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_type` VALUES ('0e60608a45136e49b5cca43c88fc43a0', 'CMS网站发布状态', 'cmsReleaseStatus', '1', '0', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('10205d68a481cf177cbdd44093944ba1', '是否', 'whether', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('14b305d91fdb4244768204810366e631', '代码生成-生成方法', 'genMethod', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('15', '匹配方式', 'matchingMode', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('1527910454452584450', '标签颜色', 'tagColor', '1', '1', 0, '1', '2022-05-21 15:13:34', '1', '2022-05-21 15:13:34');
INSERT INTO `sys_dict_type` VALUES ('1528581578509291521', '级联示例', 'levelSample', '1', '0', 1, '1', '2022-05-23 11:40:23', '1', '2022-07-01 13:07:24');
INSERT INTO `sys_dict_type` VALUES ('1528987145396588545', '菜单类型', 'permissionType', '1', '1', 0, '1', '2022-05-24 14:31:57', '1', '2022-05-24 14:31:57');
INSERT INTO `sys_dict_type` VALUES ('1529303167152439297', '外链', 'external', '1', '1', 2, '1', '2022-05-25 11:27:43', '1', '2022-05-26 16:08:05');
INSERT INTO `sys_dict_type` VALUES ('1536225067569020930', 'HttpMethod', 'httpMethod', '1', '1', 0, '1', '2022-06-13 13:52:52', '1', '2022-06-13 13:52:52');
INSERT INTO `sys_dict_type` VALUES ('1541698091374125058', '消息状态', 'messageStatus', '1', '1', 6, '1', '2022-06-28 16:20:43', '1', '2022-07-02 21:56:15');
INSERT INTO `sys_dict_type` VALUES ('1623855266070069250', '详情/修改页模板', 'inputGeneratorTemplate', '1', '0', 0, '1', '2023-02-10 09:24:00', '1', '2023-02-10 09:24:00');
INSERT INTO `sys_dict_type` VALUES ('1623855306406690817', '列表页模板', 'listGeneratorTemplate', '1', '0', 0, '1', '2023-02-10 09:24:09', '1', '2023-02-10 09:24:09');
INSERT INTO `sys_dict_type` VALUES ('17', '栅格', 'grid', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('18', '字段验证', 'verification', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('19', 'redis前缀', 'redisPrefix', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('2', '用户状态', 'userStatus', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('20', '数据类型', 'dataType', '1', '1', 3, '1', '2022-05-18 16:43:47', '1', '2022-05-21 14:00:57');
INSERT INTO `sys_dict_type` VALUES ('22', '提示类型', 'tipType', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('23', '性别', 'sex', '1', '0', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('25', '定时任务状态', 'schedulerJobStatus', '1', '1', 1, '1', '2022-05-18 16:43:47', '1', '2022-05-21 14:28:49');
INSERT INTO `sys_dict_type` VALUES ('27', '消息类型', 'messageType', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('2e6ff3d8d1a1a650efad4f55e0dec273', 'CMS文章发布类型', 'cmsArticleReleaseType', '1', '0', 10, '1', '2022-05-18 16:43:47', '1', '2022-05-21 14:32:29');
INSERT INTO `sys_dict_type` VALUES ('7', '通用状态', 'commonStatus', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('7ad24fca207295e81f5b501a11d00ea2', '打开方式', 'openMode', '1', '1', 1, '1', '2022-05-18 16:43:47', '1', '2022-05-25 10:11:03');
INSERT INTO `sys_dict_type` VALUES ('86d9858565d0664c3f7eaba933e1de3a', '密码强度', 'passwordStrength', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('8b8e774ad38daa1cad3b0aa14217c735', '请假类型', 'leaveType', '1', '0', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('a088b7c12020ea213c103c938f0d33ec', '任务状态 - 工作流', 'taskStatus', '1', '0', 3, '1', '2022-05-18 16:43:47', '1', '2022-06-17 10:03:45');
INSERT INTO `sys_dict_type` VALUES ('a48450f20e70c3709a2c41a77dec74fd', 'CMS文章状态', 'cmsArticleStatus', '1', '0', 2, '1', '2022-05-18 16:43:47', '1', '2022-05-21 14:32:34');
INSERT INTO `sys_dict_type` VALUES ('a8ef4b74ef87817d67e5fcf91c985ea7', '代码生成-生成文件', 'genFile', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('c079e48f535aa6478e64c861ec2fbc1a', '流程状态', 'suspensionState', '1', '0', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('c8b27d7bc5ffbaa6d370f26f8c140a22', 'CMS媒体类型', 'cmsMediaType', '1', '0', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('d87a727bf068c7927fcbe3528f9e8c26', 'CMS发布类型', 'cmsReleaseType', '1', '0', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
INSERT INTO `sys_dict_type` VALUES ('dcc19ea57aa468ae96fd7f5f76f58e45', '活动类型 - 工作流', 'activityType', '1', '0', 1, '1', '2022-05-18 16:43:47', '1', '2022-06-17 10:04:18');
INSERT INTO `sys_dict_type` VALUES ('f645e5b01c77c004905673b97c091c93', 'boolean', 'boolean', '1', '1', 0, '1', '2022-05-18 16:43:47', '1', '2022-05-18 16:43:47');
COMMIT;

-- ----------------------------
-- Table structure for sys_download
-- ----------------------------
DROP TABLE IF EXISTS `sys_download`;
CREATE TABLE `sys_download` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `path` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '路径',
  `effective_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '有效期类型',
  `expire` datetime DEFAULT NULL COMMENT '过期时间',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文件类型',
  `length` int(11) DEFAULT NULL COMMENT '文件大小',
  `auth` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '授权',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限代码',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户Id',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='下载';

-- ----------------------------
-- Table structure for sys_exception
-- ----------------------------
DROP TABLE IF EXISTS `sys_exception`;
CREATE TABLE `sys_exception` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '触发用户',
  `trigger_time` datetime DEFAULT NULL COMMENT '触发时间',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '异常类型',
  `trace` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '错误堆栈',
  `message` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '错误信息',
  `url` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求地址',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '错误代码',
  `node` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '触发节点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='异常日志';

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '父id',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `display_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文件名称',
  `path` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '路径',
  `size` bigint(20) DEFAULT NULL COMMENT '大小',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户Id',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `edit_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `sys_file_parent_id_index` (`parent_id`),
  KEY `sys_file_parent_id_type_index` (`parent_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='文件';

-- ----------------------------
-- Table structure for sys_import_excel_template
-- ----------------------------
DROP TABLE IF EXISTS `sys_import_excel_template`;
CREATE TABLE `sys_import_excel_template` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '模板名称',
  `import_table` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '表',
  `start_row` int(11) NOT NULL COMMENT '起始行',
  `callback` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '回调',
  `import_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '模板代码',
  `permission_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限代码',
  `remarks` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `data_source` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据源',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_import_excel_template_import_code_pk` (`import_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='导入模板';

-- ----------------------------
-- Records of sys_import_excel_template
-- ----------------------------
BEGIN;
INSERT INTO `sys_import_excel_template` VALUES ('1556202254541754370', '代码生成示例', 'sample_general', 1, 'sampleGeneralServiceImpl', 'sample:general', 'sample:general:import:data', NULL, NULL, 0, '1', '2022-08-07 16:55:04', '1', '2022-08-07 16:55:04');
COMMIT;

-- ----------------------------
-- Table structure for sys_import_excel_template_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_import_excel_template_detail`;
CREATE TABLE `sys_import_excel_template_detail` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `template_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '模板id',
  `field_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '数据库字段名',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `field_length` int(11) DEFAULT NULL COMMENT '字段长度',
  `field_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '字段类型',
  `replace_table` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '替换表表名',
  `replace_table_field_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '替换表;名称',
  `replace_table_field_value` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '替换表;值',
  `replace_table_dict_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '替换表;字典类型',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `required` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否必填',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  `only` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否唯一',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_import_excel_template_detail_template_id_field_name_pk` (`template_id`,`field_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='导入模板详情';

-- ----------------------------
-- Records of sys_import_excel_template_detail
-- ----------------------------
BEGIN;
INSERT INTO `sys_import_excel_template_detail` VALUES ('1556202254986350594', '1556202254541754370', 'name', '姓名', 32, 'varchar(32)', NULL, NULL, NULL, NULL, 1, NULL, '1', '2022-08-07 17:00:05', '1', '2022-08-07 17:00:05', NULL);
INSERT INTO `sys_import_excel_template_detail` VALUES ('1556202254990544897', '1556202254541754370', 'sex', '性别', 32, 'varchar(32)', 'sys_dict', 'name', 'code', 'sex', 2, NULL, '1', '2022-08-07 17:00:05', '1', '2022-08-07 17:00:05', NULL);
INSERT INTO `sys_import_excel_template_detail` VALUES ('1556202254994739202', '1556202254541754370', 'age', '年龄', 11, 'int(11)', NULL, NULL, NULL, NULL, 3, NULL, '1', '2022-08-07 17:00:05', '1', '2022-08-07 17:00:05', NULL);
INSERT INTO `sys_import_excel_template_detail` VALUES ('1556202254998933505', '1556202254541754370', 'phone', '手机号码', 32, 'varchar(32)', NULL, NULL, NULL, NULL, 4, NULL, '1', '2022-08-07 17:00:05', '1', '2022-08-07 17:00:05', NULL);
INSERT INTO `sys_import_excel_template_detail` VALUES ('1556202255007322114', '1556202254541754370', 'address', '地址', 255, 'varchar(255)', NULL, NULL, NULL, NULL, 5, NULL, '1', '2022-08-07 17:00:05', '1', '2022-08-07 17:00:05', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_import_excel_temporary
-- ----------------------------
DROP TABLE IF EXISTS `sys_import_excel_temporary`;
CREATE TABLE `sys_import_excel_temporary` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `template_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '模板id',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '导入用户id',
  `verification_status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '验证结果',
  `verification_results` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '错误信息',
  `field1` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field2` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field3` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field4` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field5` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field6` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field7` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field8` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field9` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field10` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field11` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field12` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field13` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field14` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field15` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field16` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field17` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field18` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field19` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field20` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field21` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field22` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field23` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field24` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field25` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field26` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field27` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field28` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field29` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field30` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field31` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field32` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field33` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field34` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field35` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field36` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field37` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field38` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field39` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field40` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field41` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field42` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field43` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field44` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field45` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field46` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field47` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field48` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field49` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  `field50` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='导入临时表';

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `modular` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '模块',
  `method` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '方法',
  `ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ip',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'url',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'uri',
  `clazz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'class',
  `method_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '方法名',
  `http_method` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'Http Method',
  `params` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '参数',
  `time_consuming` int(11) DEFAULT NULL COMMENT '耗时',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户Id',
  `operation_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作人',
  `operation_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_log` VALUES ('1610549936221417474', 'sys', '用户登录', '0:0:0:0:0:0:0:1', 'http://localhost/api/login', '/api/login', 'com.easy.admin.auth.controller.AuthController', 'login', 'POST', '[LoginVO{username=\'sysadmin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=false, captchaVerification=\'null\'}]', NULL, NULL, '1', '2023-01-04 16:13:22');
INSERT INTO `sys_log` VALUES ('1610549936502435841', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:13:22');
INSERT INTO `sys_log` VALUES ('1610549995424018434', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:13:36');
INSERT INTO `sys_log` VALUES ('1610550057814290433', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:13:51');
INSERT INTO `sys_log` VALUES ('1610551053739192321', 'sys', '用户登录', '0:0:0:0:0:0:0:1', 'http://localhost/api/login', '/api/login', 'com.easy.admin.auth.controller.AuthController', 'login', 'POST', '[LoginVO{username=\'sysadmin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=false, captchaVerification=\'null\'}]', NULL, NULL, '1', '2023-01-04 16:17:48');
INSERT INTO `sys_log` VALUES ('1610551053961490433', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:17:49');
INSERT INTO `sys_log` VALUES ('1610551498498994178', 'sys', '用户登录', '0:0:0:0:0:0:0:1', 'http://localhost/api/login', '/api/login', 'com.easy.admin.auth.controller.AuthController', 'login', 'POST', '[LoginVO{username=\'sysadmin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=false, captchaVerification=\'null\'}]', NULL, NULL, '1', '2023-01-04 16:19:34');
INSERT INTO `sys_log` VALUES ('1610551498637406210', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:19:35');
INSERT INTO `sys_log` VALUES ('1610551631584260098', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:06');
INSERT INTO `sys_log` VALUES ('1610551700647669761', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:23');
INSERT INTO `sys_log` VALUES ('1610551705789886466', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:24');
INSERT INTO `sys_log` VALUES ('1610551707681517569', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:24');
INSERT INTO `sys_log` VALUES ('1610551709078220802', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:25');
INSERT INTO `sys_log` VALUES ('1610551710705610753', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:25');
INSERT INTO `sys_log` VALUES ('1610551711531888641', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:25');
INSERT INTO `sys_log` VALUES ('1610551712353972225', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:25');
INSERT INTO `sys_log` VALUES ('1610551713050226690', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:26');
INSERT INTO `sys_log` VALUES ('1610551717487800321', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:20:27');
INSERT INTO `sys_log` VALUES ('1610553131580616706', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 16:26:04');
INSERT INTO `sys_log` VALUES ('1610573153636020226', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 17:45:37');
INSERT INTO `sys_log` VALUES ('1610616916102180866', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 20:39:31');
INSERT INTO `sys_log` VALUES ('1610619093256335361', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 20:48:10');
INSERT INTO `sys_log` VALUES ('1610619860088352769', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-04 20:51:13');
INSERT INTO `sys_log` VALUES ('1610801074720043009', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-05 08:51:18');
INSERT INTO `sys_log` VALUES ('1613044005334011906', 'sys', '用户登录', '0:0:0:0:0:0:0:1', 'http://localhost/api/login', '/api/login', 'com.easy.admin.auth.controller.AuthController', 'login', 'POST', '[LoginVO{username=\'sysadmin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=false, captchaVerification=\'null\'}]', NULL, NULL, '1', '2023-01-11 13:23:54');
INSERT INTO `sys_log` VALUES ('1613044005967351810', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 13:23:55');
INSERT INTO `sys_log` VALUES ('1613049137413083137', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 13:44:18');
INSERT INTO `sys_log` VALUES ('1613049450274607106', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 13:45:33');
INSERT INTO `sys_log` VALUES ('1613050766107463681', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 13:50:46');
INSERT INTO `sys_log` VALUES ('1613051369856552961', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 13:53:10');
INSERT INTO `sys_log` VALUES ('1613052033651298306', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 13:55:49');
INSERT INTO `sys_log` VALUES ('1613052387944157185', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 13:57:13');
INSERT INTO `sys_log` VALUES ('1613053437753282561', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:01:23');
INSERT INTO `sys_log` VALUES ('1613053790246785026', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:02:47');
INSERT INTO `sys_log` VALUES ('1613054493719646210', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:05:35');
INSERT INTO `sys_log` VALUES ('1613055013343580162', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:07:39');
INSERT INTO `sys_log` VALUES ('1613055297172131842', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:08:47');
INSERT INTO `sys_log` VALUES ('1613055981535744002', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:11:30');
INSERT INTO `sys_log` VALUES ('1613057858868465665', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:18:57');
INSERT INTO `sys_log` VALUES ('1613058424403251202', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:21:12');
INSERT INTO `sys_log` VALUES ('1613058642834214914', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:22:04');
INSERT INTO `sys_log` VALUES ('1613059669583056898', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:26:09');
INSERT INTO `sys_log` VALUES ('1613061336667901954', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:32:47');
INSERT INTO `sys_log` VALUES ('1613062101646036994', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:35:49');
INSERT INTO `sys_log` VALUES ('1613062194675699714', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:36:11');
INSERT INTO `sys_log` VALUES ('1613062526382231554', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:37:30');
INSERT INTO `sys_log` VALUES ('1613062799427227650', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:38:35');
INSERT INTO `sys_log` VALUES ('1613063786099494914', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:42:31');
INSERT INTO `sys_log` VALUES ('1613064406365753345', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:44:58');
INSERT INTO `sys_log` VALUES ('1613064778840920065', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:46:27');
INSERT INTO `sys_log` VALUES ('1613064914237247490', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:47:00');
INSERT INTO `sys_log` VALUES ('1613065660626227201', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:49:57');
INSERT INTO `sys_log` VALUES ('1613066162566975490', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:51:57');
INSERT INTO `sys_log` VALUES ('1613066169529520130', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:51:59');
INSERT INTO `sys_log` VALUES ('1613066172192903169', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:51:59');
INSERT INTO `sys_log` VALUES ('1613066172964655105', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:52:00');
INSERT INTO `sys_log` VALUES ('1613066175724507137', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:52:00');
INSERT INTO `sys_log` VALUES ('1613066178387890177', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:52:01');
INSERT INTO `sys_log` VALUES ('1613067102137208833', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:55:41');
INSERT INTO `sys_log` VALUES ('1613067478215282690', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:57:11');
INSERT INTO `sys_log` VALUES ('1613068117020364802', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-01-11 14:59:43');
INSERT INTO `sys_log` VALUES ('1623492523383128065', 'sys', '用户登录', '0:0:0:0:0:0:0:1', 'http://localhost/api/login', '/api/login', 'com.easy.admin.auth.controller.AuthController', 'login', 'POST', '[LoginVO{username=\'sysadmin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=false, captchaVerification=\'null\'}]', NULL, NULL, '1', '2023-02-09 09:22:35');
INSERT INTO `sys_log` VALUES ('1623492523676729345', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-09 09:22:35');
INSERT INTO `sys_log` VALUES ('1623495748144398338', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-09 09:35:24');
INSERT INTO `sys_log` VALUES ('1623854174804443137', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:19:40');
INSERT INTO `sys_log` VALUES ('1623855070699388930', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:23:13');
INSERT INTO `sys_log` VALUES ('1623855131953004545', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:23:28');
INSERT INTO `sys_log` VALUES ('1623856096298991617', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:27:18');
INSERT INTO `sys_log` VALUES ('1623856236149669890', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:27:51');
INSERT INTO `sys_log` VALUES ('1623857359682076674', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:32:19');
INSERT INTO `sys_log` VALUES ('1623857538300706818', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:33:02');
INSERT INTO `sys_log` VALUES ('1623859532566429698', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:40:57');
INSERT INTO `sys_log` VALUES ('1623859567882469377', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:41:05');
INSERT INTO `sys_log` VALUES ('1623863338406576129', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:56:04');
INSERT INTO `sys_log` VALUES ('1623863519835389953', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:56:48');
INSERT INTO `sys_log` VALUES ('1623863710806245378', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 09:57:33');
INSERT INTO `sys_log` VALUES ('1623865473269563394', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 10:04:33');
INSERT INTO `sys_log` VALUES ('1623865512314339330', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 10:04:43');
INSERT INTO `sys_log` VALUES ('1623865892494442498', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 10:06:13');
INSERT INTO `sys_log` VALUES ('1623866186682925057', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 10:07:24');
INSERT INTO `sys_log` VALUES ('1623866423573020674', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 10:08:20');
INSERT INTO `sys_log` VALUES ('1623870162354634754', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 10:23:11');
INSERT INTO `sys_log` VALUES ('1623871029686370305', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 10:26:38');
INSERT INTO `sys_log` VALUES ('1623873021007691777', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 10:34:33');
INSERT INTO `sys_log` VALUES ('1623892500785725441', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 11:51:57');
INSERT INTO `sys_log` VALUES ('1623892500806696961', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 11:51:57');
INSERT INTO `sys_log` VALUES ('1623927066623803393', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 14:09:18');
INSERT INTO `sys_log` VALUES ('1623927160798511105', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 14:09:41');
INSERT INTO `sys_log` VALUES ('1623927596838354946', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 14:11:25');
INSERT INTO `sys_log` VALUES ('1623928046329331714', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 14:13:12');
INSERT INTO `sys_log` VALUES ('1623928770673049602', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 14:16:05');
INSERT INTO `sys_log` VALUES ('1623929242129596418', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 14:17:57');
INSERT INTO `sys_log` VALUES ('1623931032455675906', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 14:25:04');
INSERT INTO `sys_log` VALUES ('1623969848419786753', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 16:59:18');
INSERT INTO `sys_log` VALUES ('1623970374620299265', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 17:01:24');
INSERT INTO `sys_log` VALUES ('1623970387106742274', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 17:01:27');
INSERT INTO `sys_log` VALUES ('1623981537361936386', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 17:45:45');
INSERT INTO `sys_log` VALUES ('1623981539618471938', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 17:45:46');
INSERT INTO `sys_log` VALUES ('1624066750507139073', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 23:24:22');
INSERT INTO `sys_log` VALUES ('1624066752142917634', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-10 23:24:22');
INSERT INTO `sys_log` VALUES ('1624274307809034241', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-11 13:09:07');
INSERT INTO `sys_log` VALUES ('1624274308572397569', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-11 13:09:07');
INSERT INTO `sys_log` VALUES ('1624556133488279554', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-12 07:49:00');
INSERT INTO `sys_log` VALUES ('1624556134255837185', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-12 07:49:00');
INSERT INTO `sys_log` VALUES ('1624571198480334849', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-12 08:48:51');
INSERT INTO `sys_log` VALUES ('1624571199868649473', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-12 08:48:52');
INSERT INTO `sys_log` VALUES ('1624734750293901313', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-12 19:38:45');
INSERT INTO `sys_log` VALUES ('1624734751992594434', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-12 19:38:46');
INSERT INTO `sys_log` VALUES ('1624743743405965314', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-12 20:14:29');
INSERT INTO `sys_log` VALUES ('1624743745024966658', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-12 20:14:30');
INSERT INTO `sys_log` VALUES ('1624979319413555202', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 11:50:35');
INSERT INTO `sys_log` VALUES ('1624979321670090754', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 11:50:36');
INSERT INTO `sys_log` VALUES ('1624982000341368833', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 12:01:14');
INSERT INTO `sys_log` VALUES ('1624982001847123970', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 12:01:15');
INSERT INTO `sys_log` VALUES ('1625009392359325698', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 13:50:05');
INSERT INTO `sys_log` VALUES ('1625010306235252737', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 13:53:43');
INSERT INTO `sys_log` VALUES ('1625010473839640578', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 13:54:23');
INSERT INTO `sys_log` VALUES ('1625010676403552258', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 13:55:11');
INSERT INTO `sys_log` VALUES ('1625010885506383873', 'sys', '用户登录', '0:0:0:0:0:0:0:1', 'http://localhost/api/login', '/api/login', 'com.easy.admin.auth.controller.AuthController', 'login', 'POST', '[LoginVO{username=\'sysadmin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=false, captchaVerification=\'null\'}]', NULL, NULL, '1', '2023-02-13 13:56:01');
INSERT INTO `sys_log` VALUES ('1625010885988728833', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 13:56:01');
INSERT INTO `sys_log` VALUES ('1625010943119343618', 'sys', '用户登录', '0:0:0:0:0:0:0:1', 'http://localhost/api/login', '/api/login', 'com.easy.admin.auth.controller.AuthController', 'login', 'POST', '[LoginVO{username=\'sysadmin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=false, captchaVerification=\'null\'}]', NULL, NULL, '1', '2023-02-13 13:56:15');
INSERT INTO `sys_log` VALUES ('1625010943257755650', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 13:56:15');
INSERT INTO `sys_log` VALUES ('1625011017299804161', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 13:56:32');
INSERT INTO `sys_log` VALUES ('1625011786761650178', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 13:59:36');
INSERT INTO `sys_log` VALUES ('1625014065040486402', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 14:08:39');
INSERT INTO `sys_log` VALUES ('1625047632130895874', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 16:22:02');
INSERT INTO `sys_log` VALUES ('1625047966232375298', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 16:23:22');
INSERT INTO `sys_log` VALUES ('1625048030271008770', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 16:23:37');
INSERT INTO `sys_log` VALUES ('1625048400103763969', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 16:25:05');
INSERT INTO `sys_log` VALUES ('1625048780032208898', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 16:26:36');
INSERT INTO `sys_log` VALUES ('1625049398935318530', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 16:29:03');
INSERT INTO `sys_log` VALUES ('1625049737457594370', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 16:30:24');
INSERT INTO `sys_log` VALUES ('1625061793405620226', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 17:18:18');
INSERT INTO `sys_log` VALUES ('1625062005868089345', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 17:19:09');
INSERT INTO `sys_log` VALUES ('1625062170360303618', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 17:19:48');
INSERT INTO `sys_log` VALUES ('1625062678940729346', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 17:21:49');
INSERT INTO `sys_log` VALUES ('1625068825286393858', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 17:46:15');
INSERT INTO `sys_log` VALUES ('1625068828805414914', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 17:46:16');
INSERT INTO `sys_log` VALUES ('1625122681882001409', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 21:20:15');
INSERT INTO `sys_log` VALUES ('1625122682003636226', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 21:20:15');
INSERT INTO `sys_log` VALUES ('1625129530299629570', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 21:47:28');
INSERT INTO `sys_log` VALUES ('1625129530308018178', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-13 21:47:28');
INSERT INTO `sys_log` VALUES ('1625341745917181953', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 11:50:44');
INSERT INTO `sys_log` VALUES ('1625341745917181954', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 11:50:44');
INSERT INTO `sys_log` VALUES ('1625384527636275201', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 14:40:44');
INSERT INTO `sys_log` VALUES ('1625385618646048769', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 14:45:04');
INSERT INTO `sys_log` VALUES ('1625385872980254721', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 14:46:05');
INSERT INTO `sys_log` VALUES ('1625401352853237761', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 15:47:36');
INSERT INTO `sys_log` VALUES ('1625426422526906370', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 17:27:13');
INSERT INTO `sys_log` VALUES ('1625431679197777922', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 17:48:06');
INSERT INTO `sys_log` VALUES ('1625431679751426049', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-14 17:48:06');
INSERT INTO `sys_log` VALUES ('1625670907307532289', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-15 09:38:42');
INSERT INTO `sys_log` VALUES ('1625670941390446593', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-15 09:38:51');
INSERT INTO `sys_log` VALUES ('1625671011556958210', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-15 09:39:07');
INSERT INTO `sys_log` VALUES ('1625671733962907649', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-15 09:42:00');
INSERT INTO `sys_log` VALUES ('1625671938640748545', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-15 09:42:48');
INSERT INTO `sys_log` VALUES ('1626056840506793985', 'sys', '用户登录', '0:0:0:0:0:0:0:1', 'http://localhost/api/login', '/api/login', 'com.easy.admin.auth.controller.AuthController', 'login', 'POST', '[LoginVO{username=\'sysadmin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=false, captchaVerification=\'null\'}]', NULL, NULL, '1', '2023-02-16 11:12:16');
INSERT INTO `sys_log` VALUES ('1626056840859115521', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-16 11:12:16');
INSERT INTO `sys_log` VALUES ('1626057429542264834', 'sys', '获取当前登录用户', '0:0:0:0:0:0:0:1', 'http://localhost/api/auth/sys/user/current', '/api/auth/sys/user/current', 'com.easy.admin.auth.controller.SysUserController', 'getCurrent', 'GET', '[]', NULL, NULL, '1', '2023-02-16 11:14:37');
COMMIT;

-- ----------------------------
-- Table structure for sys_mail_verification
-- ----------------------------
DROP TABLE IF EXISTS `sys_mail_verification`;
CREATE TABLE `sys_mail_verification` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户标识/user_id/username',
  `mail` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
  `code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '效验码',
  `expired` datetime DEFAULT NULL COMMENT '过期时间',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='邮箱验证';

-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `subtitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '副标题;保留字段',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '内容',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '状态',
  `send_date` datetime DEFAULT NULL COMMENT '发送时间',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标;保留字段',
  `important` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否重要',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类型',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='通知';

-- ----------------------------
-- Records of sys_message
-- ----------------------------
BEGIN;
INSERT INTO `sys_message` VALUES ('1541335717311963138', 'Easy Vben Admin 发布', NULL, '<html>\n <head></head>\n <body>\n  <p style=\"text-align: center;\"><strong><span style=\"font-size: 24pt;\">Easy Vben Admin 发布</span></strong></p>\n  <p style=\"text-align: center;\"><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://127.0.0.1/static/formal/2022/6/28/30c43529-73c6-4e1b-9854-2bf4c4cb1748.png\" alt=\"pwa-512x512.png\"></p>\n  <p style=\"text-align: center;\">&nbsp;</p>\n </body>\n</html>', '1', '2022-06-28 13:45:59', NULL, '0', 'notice', 9, '1', '2022-06-27 16:20:46', '1', '2022-06-28 13:10:01');
INSERT INTO `sys_message` VALUES ('1541652296931328001', '测试1', NULL, '<html>\n <head></head>\n <body>\n  <p>测试1</p>\n </body>\n</html>', '1', '2022-06-28 13:22:56', NULL, '0', 'event', 2, '1', '2022-06-28 13:18:44', '1', '2022-06-28 13:22:55');
COMMIT;

-- ----------------------------
-- Table structure for sys_message_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_message_detail`;
CREATE TABLE `sys_message_detail` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `message_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '消息id',
  `receiver_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '接收人',
  `read_date` datetime DEFAULT NULL COMMENT '阅读时间',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `star` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否被标记※',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_message_detail_message_id_receiver_user_pk` (`message_id`,`receiver_user`),
  KEY `sys_message_detail_receiver_user_index` (`receiver_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='消息详情';

-- ----------------------------
-- Records of sys_message_detail
-- ----------------------------
BEGIN;
INSERT INTO `sys_message_detail` VALUES ('1541335753995345922', '1541335753357811714', '1', NULL, '0', '0');
INSERT INTO `sys_message_detail` VALUES ('1541335753999540225', '1541335753357811714', '1533320501638762498', NULL, '0', '0');
INSERT INTO `sys_message_detail` VALUES ('1541650101754249217', '1541335717311963138', '1', '2023-02-16 11:18:26', '1', '0');
INSERT INTO `sys_message_detail` VALUES ('1541650101758443522', '1541335717311963138', '1533320501638762498', NULL, '0', '0');
INSERT INTO `sys_message_detail` VALUES ('1541650101762637825', '1541335717311963138', '1533326426277695489', NULL, '0', '0');
INSERT INTO `sys_message_detail` VALUES ('1541650101762637826', '1541335717311963138', '1533326281821671425', NULL, '0', '0');
COMMIT;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键;',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类型',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '组件name',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标识',
  `icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '组件;页面地址',
  `external` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '是否外链',
  `order_no` int(11) NOT NULL COMMENT '排序值',
  `display` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否显示',
  `open_mode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '打开方式',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '状态',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  KEY `sys_permission_name_index` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限&菜单';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` VALUES ('03ad13494a492eee81d8d7d1e2d95d14', '7da1f5456b340b1fc94e8bb8e8ae5e8f', 'menu', '我发起的', NULL, 'activiti:historic:select:my', 'ant-design:solution-outlined', '/activiti/history/task-instance/my/list', '/activiti/history/task-instance/my/List.vue', '0', 3, '1', '1', '1', '我发起的办理中+已办结的任务', 1, '126', '2020-05-14 13:37:17', '1', '2022-07-01 16:21:16');
INSERT INTO `sys_permission` VALUES ('0c5ea7d50665e6a89050c15a446f964e', '39731ea992cfa03ce527ad0724b067fc', 'button', '保存/修改', NULL, 'sample:slave:general:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-12-20 14:00:00', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('14', '1529695376534106114', 'menu', '角色管理', NULL, 'sys:role:select', 'ant-design:team-outlined', '/auth/role/list', '/auth/role/List.vue', '0', 2, '1', '1', '1', '', 0, '', '2018-11-01 09:36:22', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('142a67a353c42c94e2d9cb638eb1a0b0', 'e58e18f8a48808a3824fef6d2efad912', 'button', '更改状态', NULL, 'cms:article:status', NULL, '', NULL, '0', 4, '1', '1', '1', '', 0, '1', '2021-11-22 15:32:09', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('149', NULL, 'menu', '代码生成', NULL, '', 'ant-design:codepen-outlined', '/generator/view', '/generator/View.vue', '0', 3, '1', '1', '1', '', 2, '', '2019-01-10 17:14:02', '1', '2022-06-13 14:01:39');
INSERT INTO `sys_permission` VALUES ('15', '5', 'menu', '数据监控', NULL, 'druid', 'ant-design:database-outlined', 'http://127.0.0.1/druid', NULL, '1', 1, '1', '1', '1', '', 4, '1', '2018-11-01 09:40:36', '1', '2022-07-28 13:29:49');
INSERT INTO `sys_permission` VALUES ('150', '16', 'button', '删除', NULL, 'sys:redis:remove', NULL, '', NULL, '0', 2, '1', '1', '1', '', 0, '126', '2019-01-26 14:27:38', '1', '2022-07-25 14:51:13');
INSERT INTO `sys_permission` VALUES ('150178d7eecb8c4aa8312ba2492ca050', '434c35c3fc3e06e132a44f78b0e7e118', 'button', '删除', NULL, 'cms:column:remove', NULL, NULL, NULL, '0', 2, '0', '1', '1', NULL, 0, '1', '2021-11-18 13:58:11', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('151', '16', 'button', '保存', NULL, 'sys:redis:save', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '126', '2019-01-26 14:27:38', '1', '2022-07-25 14:51:13');
INSERT INTO `sys_permission` VALUES ('152', '19', 'button', '踢出', NULL, 'sys:online:force', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '126', '2019-01-27 12:38:49', '1', '2022-07-26 10:42:28');
INSERT INTO `sys_permission` VALUES ('1529695376534106114', NULL, 'catalogue', '权限管理', NULL, NULL, 'ant-design:lock-outlined', NULL, NULL, '0', 6, '1', '1', '1', '', 6, '1', '2022-05-26 13:26:13', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('1529696851075231745', '1529695376534106114', 'menu', '菜单管理', NULL, 'sys:permission:select', 'ant-design:appstore-outlined', '/auth/permission/list', '/auth/permission/List.vue', '0', 1, '1', '1', '1', NULL, 1, '1', '2022-05-26 13:32:04', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('1530186899780431874', NULL, 'menu', '首页', 'Dashboard', '', 'ant-design:home-outlined', '/dashboard', '/dashboard/analysis/index.vue', '0', 1, '0', '1', '1', '', 6, '1', '2022-05-27 21:59:21', '1', '2022-07-27 11:32:31');
INSERT INTO `sys_permission` VALUES ('1542436081633390594', '93d659164c0cbb3716fcee100f029d5c', 'menu', '模型编辑', NULL, NULL, NULL, '/activiti/model/edit/:id', '/activiti/model/Edit.vue', '0', 4, '0', '1', '1', NULL, 2, '1', '2022-06-30 17:13:13', '1', '2022-06-30 17:17:39');
INSERT INTO `sys_permission` VALUES ('1552121553494224898', '228', 'catalogue', '页面', NULL, NULL, 'ant-design:profile-outlined', NULL, NULL, '0', 7, '1', '1', '1', NULL, 1, '1', '2022-07-27 10:39:50', '1', '2022-07-27 10:44:25');
INSERT INTO `sys_permission` VALUES ('1552122437028556801', '228', 'catalogue', '组件', NULL, NULL, 'ant-design:appstore-outlined', NULL, NULL, '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 10:43:20', '1', '2022-07-27 10:43:20');
INSERT INTO `sys_permission` VALUES ('1552123305312399362', '228', 'catalogue', '功能', NULL, NULL, 'ant-design:ungroup-outlined', NULL, NULL, '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 10:46:47', '1', '2022-07-27 10:46:47');
INSERT INTO `sys_permission` VALUES ('1552123414641127426', '228', 'catalogue', '图表', NULL, NULL, 'ant-design:bar-chart-outlined', NULL, NULL, '0', 5, '1', '1', '1', NULL, 1, '1', '2022-07-27 10:47:13', '1', '2022-07-27 10:47:22');
INSERT INTO `sys_permission` VALUES ('1552123729377505281', '228', 'catalogue', '外部页面', NULL, NULL, 'ant-design:desktop-outlined', NULL, NULL, '0', 10, '1', '1', '1', NULL, 0, '1', '2022-07-27 10:48:28', '1', '2022-07-27 10:48:28');
INSERT INTO `sys_permission` VALUES ('1552126948300304386', '1552123305312399362', 'menu', '图标', NULL, NULL, NULL, '/sample/feat/icon', '/sample/feat/icon/index.vue', '0', 1, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:01:16', '1', '2022-07-27 11:04:15');
INSERT INTO `sys_permission` VALUES ('1552126980588056578', '1552123305312399362', 'menu', '标签页操作', NULL, NULL, NULL, '/sample/feat/tabs', '/sample/feat/tabs/index.vue', '0', 2, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:01:23', '1', '2022-07-27 11:05:56');
INSERT INTO `sys_permission` VALUES ('1552127050326749186', '1552123305312399362', 'menu', '右键菜单', NULL, NULL, NULL, '/sample/feat/context-menu', '/sample/feat/context-menu/index.vue', '0', 3, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:01:40', '1', '2022-07-27 11:06:17');
INSERT INTO `sys_permission` VALUES ('1552127074058121217', '1552123305312399362', 'menu', '文件下载', NULL, NULL, NULL, '/sample/feat/download', '/sample/feat/download/index.vue', '0', 4, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:01:46', '1', '2022-07-27 11:06:36');
INSERT INTO `sys_permission` VALUES ('1552127135114604545', '1552123305312399362', 'menu', '图片预览', NULL, NULL, NULL, '/sample/feat/img-preview', '/sample/feat/img-preview/index.vue', '0', 5, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:02:00', '1', '2022-07-27 11:06:54');
INSERT INTO `sys_permission` VALUES ('1552127171101732865', '1552123305312399362', 'menu', '剪切板', NULL, NULL, NULL, '/sample/feat/copy', '/sample/feat/copy/index.vue', '0', 6, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:02:09', '1', '2022-07-27 11:07:11');
INSERT INTO `sys_permission` VALUES ('1552127195491610625', '1552123305312399362', 'menu', '消息提示', NULL, NULL, NULL, '/sample/feat/msg', '/sample/feat/msg/index.vue', '0', 7, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:02:15', '1', '2022-07-27 11:07:33');
INSERT INTO `sys_permission` VALUES ('1552127214743465986', '1552123305312399362', 'menu', '水印', NULL, NULL, NULL, '/sample/feat/watermark', '/sample/feat/watermark/index.vue', '0', 8, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:02:19', '1', '2022-07-27 11:07:52');
INSERT INTO `sys_permission` VALUES ('1552127228970545154', '1552123305312399362', 'menu', '水波纹', NULL, NULL, NULL, '/sample/feat/ripple', '/sample/feat/ripple/index.vue', '0', 9, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:02:23', '1', '2022-07-27 11:08:50');
INSERT INTO `sys_permission` VALUES ('1552127248763465730', '1552123305312399362', 'menu', '全屏', NULL, NULL, NULL, '/sample/feat/full-screen', '/sample/feat/full-screen/index.vue', '0', 10, '1', '1', '1', NULL, 1, '1', '2022-07-27 11:02:27', '1', '2022-07-27 11:09:07');
INSERT INTO `sys_permission` VALUES ('1552129202101170178', '1552123305312399362', 'menu', 'webscoket测试', NULL, NULL, NULL, '/sample/feat/ws', '/sample/feat/ws/index.vue', '0', 11, '1', '1', '1', NULL, 0, '1', '2022-07-27 11:10:13', '1', '2022-07-27 11:10:13');
INSERT INTO `sys_permission` VALUES ('1552130346173083650', '1552126980588056578', 'menu', '详情', NULL, NULL, NULL, '/sample/feat/tabs/detail/:id', '/sample/feat/tabs/TabDetail.vue', '0', 1, '0', '1', '1', NULL, 4, '1', '2022-07-27 11:14:46', '1', '2022-07-27 11:16:38');
INSERT INTO `sys_permission` VALUES ('1552162022194425858', '1552122437028556801', 'menu', 'Button - 按钮', NULL, NULL, NULL, '/sample/comp/button', '/sample/comp/button/index.vue', '0', 1, '1', '1', '1', NULL, 3, '1', '2022-07-27 13:20:38', '1', '2022-07-29 14:02:41');
INSERT INTO `sys_permission` VALUES ('1552162067870396417', '228', 'catalogue', '表单', NULL, '', 'ant-design:form-outlined', '', '', '0', 3, '1', '1', '1', '', 2, '1', '2022-07-27 13:20:49', '1', '2022-07-27 17:01:46');
INSERT INTO `sys_permission` VALUES ('1552162375333851138', '228', 'catalogue', '表格', NULL, '', 'ant-design:table-outlined', '', '', '0', 4, '1', '1', '1', '', 1, '1', '2022-07-27 13:22:02', '1', '2022-07-27 17:01:36');
INSERT INTO `sys_permission` VALUES ('1552162399434321922', '1552122437028556801', 'menu', 'Transition - 动画', NULL, NULL, NULL, '/sample/comp/transition', '/sample/comp/transition/index.vue', '0', 3, '1', '1', '1', NULL, 2, '1', '2022-07-27 13:22:08', '1', '2022-07-29 14:03:52');
INSERT INTO `sys_permission` VALUES ('1552162428064641025', '1552122437028556801', 'menu', 'Cropper - 图片裁剪', NULL, NULL, NULL, '/sample/comp/cropper', '/sample/comp/cropper/index.vue', '0', 4, '1', '1', '1', NULL, 2, '1', '2022-07-27 13:22:15', '1', '2022-07-29 14:04:08');
INSERT INTO `sys_permission` VALUES ('1552162459303817218', '1552122437028556801', 'menu', 'Time - 相对时间', NULL, NULL, NULL, '/sample/comp/time', '/sample/comp/time/index.vue', '0', 5, '1', '1', '1', NULL, 2, '1', '2022-07-27 13:22:22', '1', '2022-07-29 14:04:22');
INSERT INTO `sys_permission` VALUES ('1552162485774069761', '1552122437028556801', 'menu', 'CountTo - 数字动画', NULL, NULL, NULL, '/sample/comp/count-to', '/sample/comp/count-to/index.vue', '0', 6, '1', '1', '1', NULL, 2, '1', '2022-07-27 13:22:29', '1', '2022-07-29 14:04:37');
INSERT INTO `sys_permission` VALUES ('1552162507773194241', '1552122437028556801', 'catalogue', 'Tree - 树', NULL, NULL, NULL, NULL, NULL, '0', 7, '1', '1', '1', NULL, 1, '1', '2022-07-27 13:22:34', '1', '2022-07-29 14:05:22');
INSERT INTO `sys_permission` VALUES ('1552162542216818689', '1552122437028556801', 'catalogue', 'Editor - 编辑器', NULL, NULL, NULL, NULL, NULL, '0', 8, '1', '1', '1', NULL, 1, '1', '2022-07-27 13:22:42', '1', '2022-07-29 14:05:34');
INSERT INTO `sys_permission` VALUES ('1552162563725209602', '1552122437028556801', 'menu', 'Scroll - 滚动', NULL, NULL, NULL, '/sample/comp/scroll', '/sample/comp/scroll/index.vue', '0', 9, '1', '1', '1', NULL, 3, '1', '2022-07-27 13:22:47', '1', '2022-07-29 14:05:54');
INSERT INTO `sys_permission` VALUES ('1552162598462435330', '1552122437028556801', 'menu', 'Modal - 对话框', NULL, NULL, NULL, '/sample/comp/modal', '/sample/comp/modal/index.vue', '0', 10, '1', '1', '1', NULL, 3, '1', '2022-07-27 13:22:55', '1', '2022-08-19 16:44:46');
INSERT INTO `sys_permission` VALUES ('1552162619748528130', '1552122437028556801', 'menu', 'Drawer - 抽屉', NULL, NULL, NULL, '/sample/comp/drawer', '/sample/comp/drawer/index.vue', '0', 11, '1', '1', '1', NULL, 2, '1', '2022-07-27 13:23:00', '1', '2022-07-29 14:06:48');
INSERT INTO `sys_permission` VALUES ('1552162643572174850', '1552122437028556801', 'menu', 'Descriptions - 描述列表', NULL, NULL, NULL, '/sample/comp/desc', '/sample/comp/desc/index.vue', '0', 12, '1', '1', '1', NULL, 3, '1', '2022-07-27 13:23:06', '1', '2022-07-29 14:07:03');
INSERT INTO `sys_permission` VALUES ('1552162668285014017', '1552122437028556801', 'catalogue', 'Lazy - 懒加载', NULL, NULL, NULL, '', '', '0', 13, '1', '1', '1', NULL, 3, '1', '2022-07-27 13:23:12', '1', '2022-07-29 14:07:27');
INSERT INTO `sys_permission` VALUES ('1552162693387923458', '1552122437028556801', 'menu', 'SlideVerify - 滑块验证', NULL, NULL, NULL, '/sample/comp/verify', '/sample/comp/verify/index.vue', '0', 14, '1', '1', '1', NULL, 3, '1', '2022-07-27 13:23:18', '1', '2022-07-29 14:07:45');
INSERT INTO `sys_permission` VALUES ('1552162712996294658', '1552122437028556801', 'menu', 'QrCode - 二维码', NULL, NULL, NULL, '/sample/comp/qrcode', '/sample/comp/qrcode/index.vue', '0', 15, '1', '1', '1', NULL, 2, '1', '2022-07-27 13:23:23', '1', '2022-07-29 14:07:58');
INSERT INTO `sys_permission` VALUES ('1552162733850374146', '1552122437028556801', 'menu', 'StrengthMeter - 密码强度', NULL, NULL, NULL, '/sample/comp/strength-meter', '/sample/comp/strength-meter/index.vue', '0', 16, '1', '1', '1', NULL, 2, '1', '2022-07-27 13:23:28', '1', '2022-07-29 14:08:10');
INSERT INTO `sys_permission` VALUES ('1552162757757906946', '1552122437028556801', 'menu', 'BasicUpload - 文件上传', NULL, NULL, NULL, '/sample/comp/upload', '/sample/comp/upload/index.vue', '0', 17, '1', '1', '1', NULL, 4, '1', '2022-07-27 13:23:33', '1', '2022-07-29 14:08:26');
INSERT INTO `sys_permission` VALUES ('1552162774488985601', '1552122437028556801', 'menu', 'Loading - 加载中', NULL, NULL, NULL, '/sample/comp/loading', '/sample/comp/loading/index.vue', '0', 18, '1', '1', '1', NULL, 2, '1', '2022-07-27 13:23:37', '1', '2022-07-29 14:08:38');
INSERT INTO `sys_permission` VALUES ('1552196675919949826', '1552162668285014017', 'menu', '基础示例', NULL, NULL, NULL, '/sample/comp/lazy', '/sample/comp/lazy/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 15:38:20', '1', '2022-07-27 15:38:20');
INSERT INTO `sys_permission` VALUES ('1552196825329446913', '1552162668285014017', 'menu', '动画效果', NULL, NULL, NULL, '/sample/comp/lazy/transition', '/sample/comp/lazy/Transition.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 15:38:56', '1', '2022-07-27 15:38:56');
INSERT INTO `sys_permission` VALUES ('1552206108062396418', '1552162542216818689', 'menu', 'Json编辑器', NULL, NULL, NULL, '/sample/comp/editor/json', '/sample/comp/editor/json/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 16:15:49', '1', '2022-07-27 16:15:49');
INSERT INTO `sys_permission` VALUES ('1552206155193790466', '1552162542216818689', 'catalogue', 'markdown编辑器', NULL, NULL, NULL, '', '', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 16:16:00', '1', '2022-07-27 16:16:00');
INSERT INTO `sys_permission` VALUES ('1552206179273289730', '1552162542216818689', 'menu', '富文本', NULL, NULL, NULL, '/sample/comp/editor/tinymce', '/sample/comp/editor/tinymce/index.vue', '0', 3, '1', '1', '1', NULL, 1, '1', '2022-07-27 16:16:06', '1', '2022-07-27 16:18:30');
INSERT INTO `sys_permission` VALUES ('1552206451080966145', '1552206155193790466', 'menu', '基础使用', NULL, NULL, NULL, '/sample/comp/editor/markdown', '/sample/comp/editor/markdown/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 16:17:11', '1', '2022-07-27 16:17:11');
INSERT INTO `sys_permission` VALUES ('1552206587509092354', '1552206155193790466', 'menu', '嵌入Form', NULL, NULL, NULL, '/sample/comp/editor/markdown/editor', '/sample/comp/editor/markdown/Editor.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 16:17:43', '1', '2022-07-27 16:17:43');
INSERT INTO `sys_permission` VALUES ('1552214776560496642', '1552162507773194241', 'menu', '基础树', NULL, NULL, NULL, '/sample/comp/tree', '/sample/comp/tree/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 16:50:16', '1', '2022-07-27 16:50:16');
INSERT INTO `sys_permission` VALUES ('1552214944412348417', '1552162507773194241', 'menu', '可搜索/工具栏', NULL, NULL, NULL, '/sample/comp/tree/edit-tree', '/sample/comp/tree/EditTree.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 16:50:56', '1', '2022-07-27 16:50:56');
INSERT INTO `sys_permission` VALUES ('1552215050998001666', '1552162507773194241', 'menu', '函数操作示例', NULL, NULL, NULL, '/sample/comp/tree/action-tree', '/sample/comp/tree/ActionTree.vue', '0', 3, '1', '1', '1', NULL, 0, '1', '2022-07-27 16:51:21', '1', '2022-07-27 16:51:21');
INSERT INTO `sys_permission` VALUES ('1552222776289406978', '228', 'menu', '引导页', NULL, NULL, 'ant-design:rocket-outlined', '/sample/setup', '/sample/setup/index.vue', '0', 8, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:22:03', '1', '2022-07-27 17:22:03');
INSERT INTO `sys_permission` VALUES ('1552225255924183042', '1552121553494224898', 'catalogue', '表单', NULL, NULL, NULL, NULL, NULL, '0', 1, '1', '1', '1', NULL, 1, '1', '2022-07-27 17:31:54', '1', '2022-07-27 17:32:47');
INSERT INTO `sys_permission` VALUES ('1552225281513631746', '1552121553494224898', 'catalogue', '详情', NULL, NULL, NULL, NULL, NULL, '0', 2, '1', '1', '1', NULL, 1, '1', '2022-07-27 17:32:00', '1', '2022-07-27 17:32:52');
INSERT INTO `sys_permission` VALUES ('1552225302439014402', '1552121553494224898', 'catalogue', '结果', NULL, NULL, NULL, NULL, NULL, '0', 3, '1', '1', '1', NULL, 1, '1', '2022-07-27 17:32:05', '1', '2022-07-27 17:32:42');
INSERT INTO `sys_permission` VALUES ('1552225347573919746', '1552121553494224898', 'catalogue', '异常', NULL, NULL, NULL, NULL, NULL, '0', 4, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:32:16', '1', '2022-07-27 17:32:16');
INSERT INTO `sys_permission` VALUES ('1552225367438143489', '1552121553494224898', 'catalogue', '列表', NULL, NULL, NULL, NULL, NULL, '0', 5, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:32:21', '1', '2022-07-27 17:32:21');
INSERT INTO `sys_permission` VALUES ('1552225891688394753', '1552225255924183042', 'menu', '基础表单', NULL, NULL, NULL, '/sample/page/form/basic', '/sample/page/form/basic/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:34:26', '1', '2022-07-27 17:34:26');
INSERT INTO `sys_permission` VALUES ('1552225971967373314', '1552225255924183042', 'menu', '分步表单', NULL, NULL, NULL, '/sample/page/form/step', '/sample/page/form/step/index.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:34:45', '1', '2022-07-27 17:34:45');
INSERT INTO `sys_permission` VALUES ('1552226055807315969', '1552225255924183042', 'menu', '高级表单', NULL, NULL, NULL, '/sample/page/form/high', '/sample/page/form/high/index.vue', '0', 3, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:35:05', '1', '2022-07-27 17:35:05');
INSERT INTO `sys_permission` VALUES ('1552226198052941825', '1552225281513631746', 'menu', '基础详情', NULL, NULL, NULL, '/sample/page/desc/basic', '/sample/page/desc/basic/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:35:39', '1', '2022-07-27 17:35:39');
INSERT INTO `sys_permission` VALUES ('1552226261160439810', '1552225281513631746', 'menu', '高级详情', NULL, NULL, NULL, '/sample/page/desc/high', '/sample/page/desc/high/index.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:35:54', '1', '2022-07-27 17:35:54');
INSERT INTO `sys_permission` VALUES ('1552226412193132545', '1552225302439014402', 'menu', '成功', NULL, NULL, NULL, '/sample/page/result/success', '/sample/page/result/success/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:36:30', '1', '2022-07-27 17:36:30');
INSERT INTO `sys_permission` VALUES ('1552226475996884993', '1552225302439014402', 'menu', '失败', NULL, NULL, NULL, '/sample/page/result/fail', '/sample/page/result/fail/index.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:36:45', '1', '2022-07-27 17:36:45');
INSERT INTO `sys_permission` VALUES ('1552228496070160385', '1552225367438143489', 'menu', '标准列表', NULL, NULL, NULL, '/sample/page/list/basic', '/sample/page/list/basic/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:44:47', '1', '2022-07-27 17:44:47');
INSERT INTO `sys_permission` VALUES ('1552228571710238721', '1552225367438143489', 'menu', '卡片列表', NULL, NULL, NULL, '/sample/page/list/card', '/sample/page/list/card/index.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:45:05', '1', '2022-07-27 17:45:05');
INSERT INTO `sys_permission` VALUES ('1552228656779112449', '1552225367438143489', 'menu', '搜索列表', NULL, NULL, NULL, '/sample/page/list/search', '/sample/page/list/search/index.vue', '0', 3, '1', '1', '1', NULL, 0, '1', '2022-07-27 17:45:25', '1', '2022-07-27 17:45:25');
INSERT INTO `sys_permission` VALUES ('1552521429335941121', '1552225347573919746', 'menu', '403', NULL, '', NULL, '/#/exception/403', NULL, '1', 1, '1', '1', '1', '', 9, '1', '2022-07-28 13:08:47', '1', '2022-07-28 14:23:39');
INSERT INTO `sys_permission` VALUES ('1552521502904033281', '1552225347573919746', 'menu', '404', NULL, NULL, NULL, '/#/exception/404', NULL, '1', 2, '1', '1', '1', NULL, 1, '1', '2022-07-28 13:09:05', '1', '2022-07-28 14:23:03');
INSERT INTO `sys_permission` VALUES ('1552521541474852866', '1552225347573919746', 'menu', '500', NULL, '', NULL, '/#/exception/500', NULL, '1', 3, '1', '1', '1', '', 1, '1', '2022-07-28 13:09:14', '1', '2022-07-28 14:23:47');
INSERT INTO `sys_permission` VALUES ('1552521598907457537', '1552225347573919746', 'menu', '网络错误', NULL, '', NULL, '/#/exception/net-work-error', NULL, '1', 4, '1', '1', '1', '', 1, '1', '2022-07-28 13:09:28', '1', '2022-07-28 14:23:54');
INSERT INTO `sys_permission` VALUES ('1552521647586549761', '1552225347573919746', 'menu', '无数据', NULL, '', NULL, '/#/exception/not-data', NULL, '1', 5, '1', '1', '1', '', 1, '1', '2022-07-28 13:09:39', '1', '2022-07-28 14:23:59');
INSERT INTO `sys_permission` VALUES ('1552549270056345602', '1552123414641127426', 'menu', '地图', NULL, NULL, NULL, '/sample/charts/map', '/sample/charts/Map.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-28 14:59:25', '1', '2022-07-28 14:59:25');
INSERT INTO `sys_permission` VALUES ('1552549337102295041', '1552123414641127426', 'menu', '折线图', NULL, NULL, NULL, '/sample/charts/line', '/sample/charts/Line.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-28 14:59:41', '1', '2022-07-28 14:59:41');
INSERT INTO `sys_permission` VALUES ('1552549430933069825', '1552123414641127426', 'menu', '饼图', NULL, NULL, NULL, '/sample/charts/pie', '/sample/charts/Pie.vue', '0', 3, '1', '1', '1', NULL, 1, '1', '2022-07-28 15:00:03', '1', '2022-07-28 17:31:43');
INSERT INTO `sys_permission` VALUES ('1552549932991258625', '228', 'catalogue', '地图', NULL, NULL, 'ant-design:environment-outlined', '', '', '0', 6, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:02:03', '1', '2022-07-28 15:02:03');
INSERT INTO `sys_permission` VALUES ('1552550090034388993', '1552549932991258625', 'menu', '百度地图', NULL, NULL, NULL, '/sample/map/baidu', '/sample/map/Baidu.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:02:41', '1', '2022-07-28 15:02:41');
INSERT INTO `sys_permission` VALUES ('1552550173316489218', '1552549932991258625', 'menu', '高德地图', NULL, NULL, NULL, '/sample/map/gaode', '/sample/map/Gaode.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:03:00', '1', '2022-07-28 15:03:00');
INSERT INTO `sys_permission` VALUES ('1552555383464140801', '1552162067870396417', 'menu', '基础表单', NULL, NULL, NULL, '/sample/form', '/sample/form/index.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:23:43', '1', '2022-07-28 15:23:43');
INSERT INTO `sys_permission` VALUES ('1552555501416357890', '1552162067870396417', 'menu', 'useForm', NULL, NULL, NULL, '/sample/form/use-form', '/sample/form/UseForm.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:24:11', '1', '2022-07-28 15:24:11');
INSERT INTO `sys_permission` VALUES ('1552555597688217601', '1552162067870396417', 'menu', 'refForm', NULL, NULL, NULL, '/sample/form/ref-form', '/sample/form/RefForm.vue', '0', 3, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:24:34', '1', '2022-07-28 15:24:34');
INSERT INTO `sys_permission` VALUES ('1552555839296905217', '1552162067870396417', 'menu', '可收缩表单', NULL, NULL, NULL, '/sample/form/advanced-form', '/sample/form/AdvancedForm.vue', '0', 4, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:25:31', '1', '2022-07-28 15:25:31');
INSERT INTO `sys_permission` VALUES ('1552555956439621634', '1552162067870396417', 'menu', '表单验证', NULL, NULL, NULL, '/sample/form/rule-form', '/sample/form/RuleForm.vue', '0', 5, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:25:59', '1', '2022-07-28 15:25:59');
INSERT INTO `sys_permission` VALUES ('1552556056595406849', '1552162067870396417', 'menu', '动态表单', NULL, NULL, NULL, '/sample/form/dynamic-form', '/sample/form/DynamicForm.vue', '0', 6, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:26:23', '1', '2022-07-28 15:26:23');
INSERT INTO `sys_permission` VALUES ('1552556156063326209', '1552162067870396417', 'menu', '自定义组件', NULL, NULL, NULL, '/sample/form/customer-form', '/sample/form/CustomerForm.vue', '0', 7, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:26:47', '1', '2022-07-28 15:26:47');
INSERT INTO `sys_permission` VALUES ('1552556257078943745', '1552162067870396417', 'menu', '表单增删示例', NULL, NULL, NULL, '/sample/form/append-form', '/sample/form/AppendForm.vue', '0', 8, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:27:11', '1', '2022-07-28 15:27:11');
INSERT INTO `sys_permission` VALUES ('1552556727491108866', '1552162067870396417', 'menu', '标签页+多级field', NULL, NULL, NULL, '/sample/form/tabs-form', '/sample/form/TabsForm.vue', '0', 9, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:29:03', '1', '2022-07-28 15:29:03');
INSERT INTO `sys_permission` VALUES ('1552557023374090242', '1552162375333851138', 'menu', '基础表格', NULL, NULL, NULL, '/sample/table/basic', '/sample/table/Basic.vue', '0', 1, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:30:14', '1', '2022-07-28 15:30:14');
INSERT INTO `sys_permission` VALUES ('1552557141691211778', '1552162375333851138', 'menu', '树形表格', NULL, NULL, NULL, '/sample/table/tree-table', '/sample/table/TreeTable.vue', '0', 2, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:30:42', '1', '2022-07-28 15:30:42');
INSERT INTO `sys_permission` VALUES ('1552557259131723777', '1552162375333851138', 'menu', '远程加载示例', NULL, NULL, NULL, '/sample/table/fetch-table', '/sample/table/FetchTable.vue', '0', 3, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:31:10', '1', '2022-07-28 15:31:10');
INSERT INTO `sys_permission` VALUES ('1552557377524342786', '1552162375333851138', 'menu', '固定列', NULL, NULL, NULL, '/sample/table/fixed-column', '/sample/table/FixedColumn.vue', '0', 4, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:31:38', '1', '2022-07-28 15:31:38');
INSERT INTO `sys_permission` VALUES ('1552557463054589954', '1552162375333851138', 'menu', '自定义列', NULL, NULL, NULL, '/sample/table/customer-cell', '/sample/table/CustomerCell.vue', '0', 5, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:31:58', '1', '2022-07-28 15:31:58');
INSERT INTO `sys_permission` VALUES ('1552557668537737217', '1552162375333851138', 'menu', '开启搜索区域', NULL, NULL, NULL, '/sample/table/form-table', '/sample/table/FormTable.vue', '0', 6, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:32:47', '1', '2022-07-28 15:32:47');
INSERT INTO `sys_permission` VALUES ('1552557763144458242', '1552162375333851138', 'menu', 'useTable', NULL, NULL, NULL, '/sample/table/use-table', '/sample/table/UseTable.vue', '0', 7, '1', '1', '1', NULL, 1, '1', '2022-07-28 15:33:10', '1', '2022-07-28 17:30:30');
INSERT INTO `sys_permission` VALUES ('1552557850641833985', '1552162375333851138', 'menu', 'refTable', NULL, NULL, NULL, '/sample/table/ref-table', '/sample/table/RefTable.vue', '0', 8, '1', '1', '1', NULL, 1, '1', '2022-07-28 15:33:31', '1', '2022-07-28 17:30:38');
INSERT INTO `sys_permission` VALUES ('1552557975577567234', '1552162375333851138', 'menu', '多级表头', NULL, NULL, NULL, '/sample/table/multiple-header', '/sample/table/MultipleHeader.vue', '0', 9, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:34:01', '1', '2022-07-28 15:34:01');
INSERT INTO `sys_permission` VALUES ('1552558709345886209', '1552162375333851138', 'menu', '可编辑单元格', NULL, NULL, NULL, '/sample/table/edit-row-table', '/sample/table/EditRowTable.vue', '0', 10, '1', '1', '1', NULL, 1, '1', '2022-07-28 15:36:56', '1', '2022-07-28 17:30:45');
INSERT INTO `sys_permission` VALUES ('1552559000367669249', '1552162375333851138', 'menu', '继承父元素高度', NULL, NULL, NULL, '/sample/table/resize-parent-height-table', '/sample/table/ResizeParentHeightTable.vue', '0', 11, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:38:05', '1', '2022-07-28 15:38:05');
INSERT INTO `sys_permission` VALUES ('1552559431978328066', '1552123729377505281', 'menu', 'Easy-Vben（外联）', NULL, NULL, NULL, 'https://github.com/TengChongChong/Easy-Vben', NULL, '1', 1, '1', '2', '1', NULL, 1, '1', '2022-07-28 15:39:48', '1', '2022-07-28 15:40:39');
INSERT INTO `sys_permission` VALUES ('1552559574806962177', '1552123729377505281', 'menu', 'Easy-Vben-Admin（外链）', NULL, NULL, NULL, 'https://github.com/TengChongChong/Easy-Vben-Admin', NULL, '1', 2, '1', '2', '1', NULL, 1, '1', '2022-07-28 15:40:22', '1', '2022-07-28 15:40:43');
INSERT INTO `sys_permission` VALUES ('1552559830688866305', '1552123729377505281', 'menu', '文档（内嵌）', NULL, NULL, NULL, 'http://ev-doc.easy-frame.top/', NULL, '1', 3, '1', '1', '1', NULL, 0, '1', '2022-07-28 15:41:23', '1', '2022-07-28 15:41:23');
INSERT INTO `sys_permission` VALUES ('1552884393624838145', '1552122437028556801', 'menu', 'Dict - 字典', NULL, NULL, NULL, '/sample/comp/dict', '/sample/comp/dict/index.vue', '0', 2, '1', '1', '1', NULL, 1, '1', '2022-07-29 13:11:05', '1', '2022-07-29 14:02:54');
INSERT INTO `sys_permission` VALUES ('1560455577560219649', '1552122437028556801', 'menu', 'UserSelect - 用户选择', NULL, NULL, '', '/sample/comp/user-select', '/sample/comp/user-select/index.vue', '0', 19, '1', '1', '1', NULL, 1, '1', '2022-08-19 10:36:16', '1', '2022-08-19 10:37:43');
INSERT INTO `sys_permission` VALUES ('1560553057127825409', '1552122437028556801', 'menu', 'DeptSelect - 部门选择器', NULL, NULL, NULL, '/sample/comp/dept-select', '/sample/comp/dept-select/index.vue', '0', 20, '1', '1', '1', NULL, 0, '1', '2022-08-19 17:03:37', '1', '2022-08-19 17:03:37');
INSERT INTO `sys_permission` VALUES ('1560626135536947202', '1552122437028556801', 'menu', 'RoleSelect - 角色选择器', NULL, NULL, NULL, '/sample/comp/role-select', '/sample/comp/role-select/index.vue', '0', 21, '1', '1', '1', NULL, 0, '1', '2022-08-19 21:54:00', '1', '2022-08-19 21:54:00');
INSERT INTO `sys_permission` VALUES ('157', '164', 'menu', '系统参数', NULL, 'sys:config:select', 'ant-design:setting-outlined', '/sys/config/list', '/sys/config/List', '0', 1, '1', '1', '1', '', 3, '', '2019-02-26 22:29:36', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('158', '157', 'button', '保存', NULL, 'sys:config:save', NULL, '', '', '0', 2, '0', '1', '1', '', 0, '', '2019-02-26 22:29:36', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('159', '157', 'button', '删除', NULL, 'sys:config:remove', NULL, NULL, NULL, '0', 1, '1', '1', '1', NULL, 0, '126', '2019-02-26 22:29:36', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('16', '5', 'menu', '缓存监控', NULL, 'sys:redis:select', 'ant-design:ungroup-outlined', '/sys/redis/list', '/sys/redis/List.vue', '0', 2, '1', '1', '1', '', 4, '1', '2018-11-01 09:40:51', '1', '2022-07-25 14:53:12');
INSERT INTO `sys_permission` VALUES ('164', NULL, 'catalogue', '系统管理', NULL, '', 'ant-design:setting-outlined', NULL, NULL, '0', 8, '1', '1', '1', '', 2, '126', '2019-04-07 17:45:38', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('17', '5', 'menu', '服务器状态', NULL, 'sys:status:select', 'ant-design:hdd-outlined', '/sys/status/view', '/sys/status/View.vue', '0', 5, '1', '1', '1', '', 2, '1', '2018-11-01 09:41:01', '1', '2022-07-25 11:11:51');
INSERT INTO `sys_permission` VALUES ('170736698031e1469d4a1d5e96cd4243', '434c35c3fc3e06e132a44f78b0e7e118', 'button', '拖动', NULL, 'cms:column:move', NULL, '', NULL, '0', 3, '1', '1', '1', '', 0, '1', '2021-11-18 14:36:18', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('17dcc367a2c812c36b0d3e2710a567cd', '228', 'menu', '流程示例', NULL, 'sample:work:flow:select', 'ant-design:deployment-unit-outlined', '/sample/page/work/flow/list', '/sample/page/work/flow/List.vue', '0', 11, '1', '1', '1', '', 4, '126', '2020-04-26 15:07:59', '1', '2022-07-29 14:11:33');
INSERT INTO `sys_permission` VALUES ('19', '5', 'menu', '在线用户', NULL, 'sys:online:select', 'ant-design:user-outlined', '/auth/user/online/list', '/auth/user/online/List.vue', '0', 6, '1', '1', '1', '', 2, '1', '2018-11-01 09:41:42', '1', '2022-07-26 10:43:17');
INSERT INTO `sys_permission` VALUES ('1ef90655abbfff35b4503a88f4500f3a', NULL, 'catalogue', '网站管理', '', '', 'ant-design:global-outlined', '', '', '0', 5, '1', '1', '1', '', 1, '1', '2021-11-18 11:22:03', '1', '2022-07-27 11:29:51');
INSERT INTO `sys_permission` VALUES ('20', '1529695376534106114', 'menu', '部门管理', NULL, 'sys:dept:select', 'ant-design:solution-outlined', '/auth/dept/list', '/auth/dept/List', '0', 3, '1', '1', '1', '', 2, '', '2018-11-01 09:41:59', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('21', '1529695376534106114', 'menu', '用户管理', NULL, 'sys:user:select', 'ant-design:user-outlined', '/auth/user/list', '/auth/user/List', '0', 4, '1', '1', '1', '', 2, '', '2018-11-01 09:42:04', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('218', '5', 'menu', '异常日志', NULL, 'sys:exception:select', 'ant-design:bug-outlined', '/sys/exception/list', '/sys/exception/List.vue', '0', 3, '1', '1', '1', '', 4, '126', '2019-04-08 11:59:16', '1', '2022-06-12 21:30:40');
INSERT INTO `sys_permission` VALUES ('219', '218', 'button', '删除', NULL, 'sys:exception:remove', NULL, NULL, NULL, '0', 1, '1', '1', '1', NULL, 0, '126', '2019-04-08 11:59:16', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('220', '228', 'menu', '代码生成示例', NULL, 'sample:general:select', 'ant-design:code-sandbox-outlined', '/sample/general/list', '/sample/general/List.vue', '0', 12, '1', '1', '1', '', 7, '126', '2019-04-09 12:50:25', '1', '2023-02-13 13:55:48');
INSERT INTO `sys_permission` VALUES ('221', '220', 'button', '保存', NULL, 'sample:general:save', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '126', '2019-04-09 12:50:25', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('222', '220', 'button', '删除', NULL, 'sample:general:remove', NULL, NULL, NULL, '0', 2, '1', '1', '1', NULL, 0, '126', '2019-04-09 12:50:25', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('224', '164', 'menu', '导入模板', NULL, 'sys:import:excel:template:select', 'ant-design:cloud-upload-outlined', '/sys/import/excel/template/list', '/sys/import/excel/template/List.vue', '0', 4, '1', '1', '1', '', 2, '', '2019-04-10 15:55:00', '1', '2022-07-13 13:41:34');
INSERT INTO `sys_permission` VALUES ('225', '224', 'button', '保存', NULL, 'sys:import:excel:template:save', NULL, '', '', '0', 1, '1', '1', '1', '', 0, '', '2019-04-10 15:55:00', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('226', '224', 'button', '删除', NULL, 'sys:import:excel:template:remove', NULL, '', '', '0', 2, '1', '1', '1', '', 0, '', '2019-04-10 15:55:00', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('228', NULL, 'menu', '组件&功能', NULL, '', 'ant-design:appstore-outlined', '', '', '0', 2, '1', '1', '1', '', 2, '', '2019-04-16 21:56:25', '1', '2022-08-19 09:29:46');
INSERT INTO `sys_permission` VALUES ('236', '164', 'menu', '定时任务', NULL, 'scheduler:job:select', 'ant-design:clock-circle-outlined', '/scheduler/job/list', '/scheduler/job/List.vue', '0', 3, '1', '1', '1', '', 1, '126', '2019-05-11 17:49:15', '1', '2022-06-10 13:16:21');
INSERT INTO `sys_permission` VALUES ('237', '236', 'button', '保存', NULL, 'scheduler:job:save', NULL, NULL, NULL, '0', 1, '1', '1', '1', NULL, 0, '126', '2019-05-11 17:49:15', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('238', '236', 'button', '删除', NULL, 'scheduler:job:remove', NULL, NULL, NULL, '0', 2, '1', '1', '1', NULL, 0, '126', '2019-05-11 17:49:15', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('306994778c19b648dfde51acee6ec24a', '90201ca3ab25e2204e3c250b5cd399ac', 'button', '删除', NULL, 'sys:data:source:remove', NULL, NULL, NULL, '0', 2, '0', '1', '1', NULL, 0, '1', '2021-12-18 13:39:33', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('32', '7', 'menu', '字典类型管理', NULL, 'sys:dict:type:select', 'ant-design:bars-outlined', '/sys/dict/type/list', '/sys/dict/type/List.vue', '0', 3, '0', '1', '1', '', 1, '', '2018-11-04 01:37:10', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('3273e1c9ff7485e4a09c67410641ce29', '39731ea992cfa03ce527ad0724b067fc', 'button', '删除', NULL, 'sample:slave:general:remove', NULL, NULL, NULL, '0', 2, '0', '1', '1', NULL, 0, '1', '2021-12-20 14:00:01', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('3461d1e74115a0e7e13970dbf4a4affc', 'dfa9c32f1e6aa6141417713289541f31', 'button', '保存/修改', NULL, 'cms:site:user:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-11-18 13:52:29', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('3624d07e7c958b60f4a23a59d8a5db77', 'dfa9c32f1e6aa6141417713289541f31', 'button', '删除', NULL, 'cms:site:user:remove', NULL, NULL, NULL, '0', 2, '0', '1', '1', NULL, 0, '1', '2021-11-18 13:52:29', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('39731ea992cfa03ce527ad0724b067fc', '228', 'menu', '从库示例', NULL, 'sample:slave:general:select', 'ant-design:database-outlined', '/sample/page/slave/general/list', '/sample/page/slave/general/List.vue', '0', 13, '1', '1', '1', '', 4, '1', '2021-12-20 14:00:00', '1', '2022-07-29 14:11:54');
INSERT INTO `sys_permission` VALUES ('39c5c5bcdd9a15110e2c3e4014dd1531', NULL, 'catalogue', '流程管理', NULL, '', 'ant-design:branches-outlined', NULL, NULL, '0', 7, '1', '1', '1', '', 0, '126', '2019-07-03 09:43:27', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('3b79694872fa73ff05699bde511b238f', '7da1f5456b340b1fc94e8bb8e8ae5e8f', 'menu', '我办理的', NULL, 'activiti:historic:select:participate', 'ant-design:file-protect-outlined', '/activiti/history/task-instance/participate/list', '/activiti/history/task-instance/participate/List.vue', '0', 4, '1', '1', '1', '用户参与过的任务都可以看到', 1, '126', '2020-05-07 16:28:02', '1', '2022-07-01 16:21:33');
INSERT INTO `sys_permission` VALUES ('3bfaf265880f952d176911aa2b717b4b', 'f034db63a9263cefd9b30884c103491d', 'button', '保存/修改', NULL, 'cms:column:user:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-11-19 14:07:08', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('434c35c3fc3e06e132a44f78b0e7e118', '1ef90655abbfff35b4503a88f4500f3a', 'menu', '栏目管理', NULL, 'cms:column:select', 'ant-design:bars-outlined', '/cms/column', '/cms/column/View', '0', 2, '1', '1', '1', NULL, 0, '1', '2021-11-18 13:58:11', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('4351ef5e9957e8e4a0e0dcf085bf3218', '1ef90655abbfff35b4503a88f4500f3a', 'menu', '资源管理', NULL, 'cms:media:select', 'ant-design:database-outlined', '/cms/media/list', '/cms/media/List', '0', 6, '1', '1', '1', NULL, 0, '1', '2021-11-21 14:03:24', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('49e82dc86c44c465011b6ccb7f1b1911', 'd537e36f7948edd2c1fd371578d3749f', 'button', '更改状态', NULL, 'cms:site:status', NULL, '', NULL, '0', 4, '1', '1', '1', '', 0, '1', '2021-11-18 11:24:41', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('4aba9a2f7c81615c9ccdc07e980ccfe3', '17dcc367a2c812c36b0d3e2710a567cd', 'button', '删除', NULL, 'sample:work:flow:remove', NULL, NULL, NULL, '0', 2, '1', '1', '1', NULL, 0, '126', '2020-04-26 15:07:59', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('5', NULL, 'catalogue', '系统监控', NULL, '', 'ant-design:dashboard-outlined', NULL, NULL, '0', 9, '1', '1', '1', '', 0, '1', '2018-10-31 20:03:35', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('52', '32', 'button', '删除', NULL, 'sys:dict:type:remove', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '1', '2018-12-03 00:14:18', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('53', '32', 'button', '保存', NULL, 'sys:dict:type:save', NULL, '', '', '0', 2, '1', '1', '1', '', 0, '', '2018-12-03 00:14:51', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('55', '7', 'button', '删除', NULL, 'sys:dict:remove', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '1', '2018-12-03 00:16:26', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('56', '7', 'button', '保存', NULL, 'sys:dict:save', NULL, '', '', '0', 2, '0', '1', '1', '', 0, '', '2018-12-03 00:16:26', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('59f28fee0b781ada5722859993d3ed1c', '1ef90655abbfff35b4503a88f4500f3a', 'menu', '网站发布', NULL, NULL, 'ant-design:check-outlined', '/cms/release', '/cms/release/View', '0', 7, '1', '1', '1', NULL, 0, '1', '2021-11-29 09:53:05', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('61', '1529696851075231745', 'button', '删除', NULL, 'sys:permission:remove', NULL, '', NULL, '0', 1, '1', '1', '1', '', 1, '1', '2018-12-03 00:17:02', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('62', '1529696851075231745', 'button', '保存', NULL, 'sys:permission:save', NULL, '', '', '0', 2, '1', '1', '1', '', 1, '', '2018-12-03 00:17:02', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('64', '14', 'button', '删除', NULL, 'sys:role:remove', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '1', '2018-12-03 00:20:57', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('65', '14', 'button', '保存', NULL, 'sys:role:save', NULL, '', '', '0', 2, '1', '1', '1', '', 0, '', '2018-12-03 00:20:57', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('67', '21', 'button', '删除', NULL, 'sys:user:remove', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '1', '2018-12-03 00:21:48', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('68', '21', 'button', '保存', NULL, 'sys:user:save', NULL, '', NULL, '0', 2, '1', '1', '1', '', 0, '1', '2018-12-03 00:21:48', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('69df3ab67c7dc9fb593d0ec821856e6e', 'd537e36f7948edd2c1fd371578d3749f', 'button', '保存/修改', NULL, 'cms:site:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-11-18 10:53:22', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('6c93cf34d2a4edfcd9f82ac28c287400', 'f034db63a9263cefd9b30884c103491d', 'button', '删除', NULL, 'cms:column:user:remove', NULL, NULL, NULL, '0', 2, '0', '1', '1', NULL, 0, '1', '2021-11-19 14:07:08', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('7', '164', 'menu', '字典管理', NULL, 'sys:dict:select', 'ant-design:book-outlined', '/sys/dict/list', '/sys/dict/List.vue', '0', 2, '1', '1', '1', '', 3, '', '2018-11-01 08:42:06', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('70', '20', 'button', '删除', NULL, 'sys:dept:remove', NULL, '', NULL, '0', 2, '1', '1', '1', '', 0, '1', '2018-12-03 00:21:51', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('70045424498772773ed0e6628cd98fd8', '1ef90655abbfff35b4503a88f4500f3a', 'catalogue', '权限管理', NULL, NULL, 'ant-design:key-outlined', NULL, NULL, '0', 4, '1', '1', '1', NULL, 0, '1', '2021-11-19 14:10:07', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('70665e95906f682b3c0199804aa87a17', '434c35c3fc3e06e132a44f78b0e7e118', 'button', '保存/修改', NULL, 'cms:column:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-11-18 13:58:11', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('71', '20', 'button', '保存', NULL, 'sys:dept:save', NULL, '', NULL, '0', 3, '1', '1', '1', '', 0, '1', '2018-12-03 00:21:51', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('72', '20', 'menu', '部门类型管理', NULL, 'sys:dept:type:select', NULL, '/auth/dept/type/list', '/auth/dept/type/List', '0', 1, '0', '1', '1', '', 4, '', '2018-12-03 00:22:12', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('720e77810ca8ea77ec7f7871985ea018', '228', 'menu', '权限验证', NULL, NULL, 'ant-design:lock-outlined', '/sample/permission/view', '/sample/permission/View.vue', '0', 9, '1', '1', '1', NULL, 1, '1', '2021-02-01 15:33:59', '1', '2022-07-27 10:23:18');
INSERT INTO `sys_permission` VALUES ('734dacc38f293883683b68c6d3e5b56e', 'e7f55c6889bd826d6a62885ef2ffdb1d', 'button', '保存', NULL, 'activiti:process:save', NULL, '', NULL, '0', 2, '1', '1', '1', '', 0, '126', '2019-07-12 17:15:18', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('74', '72', 'button', '删除', NULL, 'sys:dept:type:remove', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '1', '2018-12-03 00:22:18', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('75', '72', 'button', '保存', NULL, 'sys:dept:type:save', NULL, '', NULL, '0', 2, '1', '1', '1', '', 0, '1', '2018-12-03 00:22:18', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('76180395fab6dbdab6f6c050169c5f97', '7da1f5456b340b1fc94e8bb8e8ae5e8f', 'menu', '待办任务', NULL, '', 'ant-design:audit-outlined', '/activiti/task/list', '/activiti/task/List.vue', '0', 2, '1', '1', '1', '', 1, '126', '2020-03-31 13:57:55', '1', '2022-07-01 16:23:34');
INSERT INTO `sys_permission` VALUES ('77ce77c2dd83b746657afbfb2acd21cd', '93d659164c0cbb3716fcee100f029d5c', 'button', '删除', NULL, 'activiti:model:remove', NULL, '', NULL, '0', 2, '1', '1', '1', '', 0, '126', '2019-07-03 09:52:52', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('792d3621d9d2f92acb7b9847dc0ef598', '5', 'menu', '访问日志', NULL, 'sys:log:select', 'ant-design:menu-outlined', '/sys/log/list', '/sys/log/List.vue', '0', 4, '1', '1', '1', '', 1, '126', '2019-06-27 12:32:32', '1', '2022-06-12 14:20:59');
INSERT INTO `sys_permission` VALUES ('7d059f6a3c13daaddf5895ca6323c0d7', 'e58e18f8a48808a3824fef6d2efad912', 'menu', '详情', NULL, NULL, NULL, '/cms/article/input', '/cms/article/Input', '0', 2, '0', '1', '1', NULL, 0, '1', '2021-11-19 14:17:19', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('7da1f5456b340b1fc94e8bb8e8ae5e8f', NULL, 'catalogue', '我的任务', '', '', 'ant-design:carry-out-outlined', '', '', '0', 4, '1', '1', '1', '', 5, '126', '2020-03-27 15:56:17', '1', '2022-07-27 11:28:31');
INSERT INTO `sys_permission` VALUES ('8d3d56a47ac2761edee85b41624d37d2', 'c2adf619e4744b5869c2296c2fdeeefd', 'button', '保存/修改', NULL, 'cms:page:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-11-24 15:40:23', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('90201ca3ab25e2204e3c250b5cd399ac', '164', 'menu', '数据源', NULL, 'sys:data:source:select', 'ant-design:database-outlined', '/sys/data-source/list', '/sys/data-source/List.vue', '0', 5, '1', '1', '1', NULL, 2, '1', '2021-12-18 13:39:33', '1', '2022-06-13 13:59:00');
INSERT INTO `sys_permission` VALUES ('906d1078178cb203bb142f8cf22d4245', '236', 'menu', '详情', NULL, NULL, NULL, '/scheduler/job/input', '/scheduler/job/Input', '0', 3, '0', '1', '1', '', 0, '1', '2021-01-21 17:21:40', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('93d659164c0cbb3716fcee100f029d5c', '39c5c5bcdd9a15110e2c3e4014dd1531', 'menu', '模型管理', NULL, 'activiti:model:select', 'ant-design:apartment-outlined', '/activiti/model/list', '/activiti/model/List.vue', '0', 1, '1', '1', '1', '', 1, '126', '2019-07-03 09:44:53', '1', '2022-06-29 10:48:41');
INSERT INTO `sys_permission` VALUES ('948f78628d82b531ccf89bd2134f161d', '4351ef5e9957e8e4a0e0dcf085bf3218', 'button', '保存/修改', NULL, 'cms:media:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-11-21 14:03:24', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('a3322940c314d1b6d9ba1d494740971e', 'e7f55c6889bd826d6a62885ef2ffdb1d', 'button', '挂起', NULL, 'activiti:process:suspend', NULL, '', NULL, '0', 3, '1', '1', '1', '', 0, '126', '2020-05-21 10:36:59', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('a72468406c6d3ae16ec96a4d888127cd', 'd537e36f7948edd2c1fd371578d3749f', 'button', '删除', NULL, 'cms:site:remove', NULL, NULL, NULL, '0', 2, '0', '1', '1', NULL, 0, '1', '2021-11-18 10:53:22', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('a95f4a835e7ca0277a77223572d3c29f', '220', 'button', '导入', NULL, 'sample:general:import:data', NULL, NULL, NULL, '0', 3, '1', '1', '1', NULL, 0, '1', '2021-07-07 17:36:59', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('ae53867719661453637074b18dd7f5ab', '17dcc367a2c812c36b0d3e2710a567cd', 'button', '保存', NULL, 'sample:work:flow:save', NULL, '', '', '0', 1, '1', '1', '1', '', 0, '', '2020-04-26 15:07:59', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('b0277e71073cb2851cf6f78a33ab36c3', 'c2adf619e4744b5869c2296c2fdeeefd', 'button', '删除', NULL, 'cms:page:remove', NULL, NULL, NULL, '0', 3, '0', '1', '1', NULL, 0, '1', '2021-11-24 15:40:23', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('b433703f1fd8a556d2dd6fdb58914339', 'd537e36f7948edd2c1fd371578d3749f', 'button', '拖动', NULL, 'cms:site:move', NULL, '', NULL, '0', 3, '1', '1', '1', '', 0, '1', '2021-11-18 11:23:47', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('b4aea4615759e8a6633c567cac8d2e35', '4351ef5e9957e8e4a0e0dcf085bf3218', 'button', '删除', NULL, 'cms:media:remove', NULL, NULL, NULL, '0', 2, '0', '1', '1', NULL, 0, '1', '2021-11-21 14:03:24', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('b935992acbd820a41c41484e6b342634', '59f28fee0b781ada5722859993d3ed1c', 'menu', '发布详情', NULL, 'cms:release:queue:select', NULL, '/cms/release/queue/list', '/cms/release/queue/List', '0', 1, '0', '1', '1', NULL, 0, '1', '2021-12-08 10:00:30', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('c25cf52649878c66073c4ac0d691e86b', '7da1f5456b340b1fc94e8bb8e8ae5e8f', 'menu', '待签任务', NULL, '', 'ant-design:file-protect-outlined', '/activiti/task/claim-list', '/activiti/task/claimList.vue', '0', 1, '1', '1', '1', '', 2, '126', '2020-03-30 13:46:02', '1', '2022-07-01 16:27:51');
INSERT INTO `sys_permission` VALUES ('c2adf619e4744b5869c2296c2fdeeefd', '1ef90655abbfff35b4503a88f4500f3a', 'menu', '页面管理', NULL, 'cms:page:select', 'ant-design:profile-outlined', '/cms/page/list', '/cms/page/List', '0', 3, '1', '1', '1', NULL, 0, '1', '2021-11-24 15:40:23', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('c44e35a713e6e68ab1825ff0f6dd0a41', '792d3621d9d2f92acb7b9847dc0ef598', 'menu', '详情', NULL, NULL, NULL, '/sys/log/info/:id', '/sys/log/Info.vue', '0', 1, '0', '1', '1', '', 2, '1', '2020-12-18 11:23:52', '1', '2022-06-12 14:22:20');
INSERT INTO `sys_permission` VALUES ('cbdd956e2a348039fe01d76c2e6d4e91', '93d659164c0cbb3716fcee100f029d5c', 'button', '保存/修改', NULL, 'activiti:model:save', NULL, '', '', '0', 1, '1', '1', '1', '', 0, '', '2019-07-03 09:52:52', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('ccd5c77412e5c8de82f61920174841b6', '434c35c3fc3e06e132a44f78b0e7e118', 'button', '更改状态', NULL, 'cms:column:status', NULL, '', NULL, '0', 4, '1', '1', '1', '', 0, '1', '2021-11-18 14:36:24', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('ccfeae90e4d3391ad54451fa2b4c1cd4', '218', 'menu', '详情', NULL, NULL, NULL, '/sys/exception/info/:id', '/sys/exception/Info.vue', '0', 2, '0', '1', '1', '', 2, '1', '2020-12-17 22:34:07', '1', '2022-06-12 12:42:37');
INSERT INTO `sys_permission` VALUES ('d457a36b43fd8e9ad6461c9d42d3a098', 'e7f55c6889bd826d6a62885ef2ffdb1d', 'button', '激活', NULL, 'activiti:process:activation', NULL, '', NULL, '0', 4, '1', '1', '1', '', 0, '126', '2020-05-21 10:37:21', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('d537e36f7948edd2c1fd371578d3749f', '1ef90655abbfff35b4503a88f4500f3a', 'menu', '站点管理', NULL, 'cms:site:select', 'ant-design:global-outlined', '/cms/site', '/cms/site/View', '0', 1, '1', '1', '1', NULL, 0, '1', '2021-11-18 10:53:22', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('dfa9c32f1e6aa6141417713289541f31', '70045424498772773ed0e6628cd98fd8', 'menu', '站点权限', NULL, 'cms:site:user:select', NULL, '/cms/site/user', '/cms/site/user/View', '0', 1, '1', '1', '1', NULL, 0, '1', '2021-11-18 13:52:29', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('e4d1ddeb3c3dc7a292ce76770bfdcc7f', '90201ca3ab25e2204e3c250b5cd399ac', 'button', '保存/修改', NULL, 'sys:data:source:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-12-18 13:39:33', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('e58e18f8a48808a3824fef6d2efad912', '1ef90655abbfff35b4503a88f4500f3a', 'menu', '文章管理', NULL, 'cms:article:select', 'ant-design:profile-outlined', '/cms/article/list', '/cms/article/List', '0', 5, '1', '1', '1', NULL, 0, '1', '2021-11-19 14:17:19', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('e5dc8061690a29ae6770c3c344465383', 'c2adf619e4744b5869c2296c2fdeeefd', 'menu', '详情', NULL, NULL, NULL, '/cms/page/input', '/cms/page/Input', '0', 2, '0', '1', '1', NULL, 0, '1', '2021-11-24 15:40:23', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('e7f55c6889bd826d6a62885ef2ffdb1d', '39c5c5bcdd9a15110e2c3e4014dd1531', 'menu', '流程管理', NULL, 'activiti:process:select', 'ant-design:cluster-outlined', '/activiti/process/list', '/activiti/process/List.vue', '0', 2, '1', '1', '1', '', 2, '126', '2019-07-03 09:45:12', '1', '2022-07-01 13:39:21');
INSERT INTO `sys_permission` VALUES ('f034db63a9263cefd9b30884c103491d', '70045424498772773ed0e6628cd98fd8', 'menu', '栏目权限', NULL, 'cms:column:user:select', NULL, '/cms/column/user', '/cms/column/user/View', '0', 2, '1', '1', '1', NULL, 0, '1', '2021-11-19 14:07:08', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('f1d3af076c2810d690edefbdc3462c23', 'e7f55c6889bd826d6a62885ef2ffdb1d', 'button', '删除', NULL, 'activiti:process:remove', NULL, '', NULL, '0', 1, '1', '1', '1', '', 0, '126', '2019-07-12 17:15:18', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('fe84bcc6e4781447ea21573eb04bf0fb', '39c5c5bcdd9a15110e2c3e4014dd1531', 'menu', '流程跟踪', NULL, 'activiti:historic:select:all', 'ant-design:node-expand-outlined', '/activiti/history/task-instance/all/list', '/activiti/history/task-instance/all/List.vue', '0', 3, '1', '1', '1', '查看所有任务，包含办理中和已办结，一般分配给管理员', 5, '126', '2020-05-14 13:28:39', '1', '2022-07-01 15:43:58');
INSERT INTO `sys_permission` VALUES ('fee57187cae386f067db09aeb0b16b4a', '93d659164c0cbb3716fcee100f029d5c', 'button', '部署流程', NULL, 'activiti:model:deployment', NULL, '', NULL, '0', 3, '1', '1', '1', '', 0, '126', '2019-07-11 21:55:01', '1', '2022-06-05 20:38:50');
INSERT INTO `sys_permission` VALUES ('ff25ce633431ec4c5d6a7dc333ab22bc', 'e58e18f8a48808a3824fef6d2efad912', 'button', '删除', NULL, 'cms:article:remove', NULL, NULL, NULL, '0', 3, '0', '1', '1', NULL, 0, '1', '2021-11-19 14:17:19', '1', '2022-06-05 20:38:49');
INSERT INTO `sys_permission` VALUES ('ff37eba32aaf21e139aa868dbc935b56', 'e58e18f8a48808a3824fef6d2efad912', 'button', '保存/修改', NULL, 'cms:article:save', NULL, NULL, NULL, '0', 1, '0', '1', '1', NULL, 0, '1', '2021-11-19 14:17:19', '1', '2022-06-05 20:38:49');
COMMIT;

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户Id',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='岗位';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键;',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标识',
  `sys` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '是否系统',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '状态',
  `order_no` int(11) NOT NULL COMMENT '排序值',
  `remarks` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户Id',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_role_code_pk` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1531819854540070914', NULL, '管理员', 'admin', '0', '1', 2, '', NULL, 2, '1', '2022-06-01 10:08:08', '1', '2022-07-27 10:37:03');
INSERT INTO `sys_role` VALUES ('1531819907467993089', NULL, '人事', 'hr', '0', '1', 3, NULL, NULL, 2, '1', '2022-06-01 10:08:20', '1', '2022-07-12 13:21:59');
INSERT INTO `sys_role` VALUES ('1531821666106105858', NULL, '财务', 'finance', '0', '1', 4, NULL, NULL, 0, '1', '2022-06-01 10:15:20', '1', '2022-06-28 22:29:31');
INSERT INTO `sys_role` VALUES ('1531821754819829762', NULL, '事业部', 'business:division', '0', '1', 5, NULL, NULL, 1, '1', '2022-06-01 10:15:41', '1', '2022-06-01 10:16:36');
INSERT INTO `sys_role` VALUES ('1531821964014936065', NULL, '总经理', 'general:manager', '0', '1', 6, NULL, NULL, 0, '1', '2022-06-01 10:16:31', '1', '2022-06-01 10:16:31');
INSERT INTO `sys_role` VALUES ('1531823375461146625', NULL, '项目经理', 'project:manager', '0', '1', 7, NULL, NULL, 0, '1', '2022-06-01 10:22:07', '1', '2022-06-01 10:22:07');
INSERT INTO `sys_role` VALUES ('3', NULL, '系统管理员', 'sys:admin', '1', '1', 1, '拥有至高无上的权利', NULL, 82, '1', '2018-11-26 23:14:42', '1', '2022-08-19 21:54:10');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键;',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色id;',
  `permission_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '权限id;',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_role_permission_role_id_permission_id_pk` (`role_id`,`permission_id`),
  KEY `sys_role_permission_role_id_index` (`role_id`),
  KEY `sys_role_permission_permission_id_index` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色权限';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_permission` VALUES ('1552120854257610758', '1531819854540070914', '03ad13494a492eee81d8d7d1e2d95d14');
INSERT INTO `sys_role_permission` VALUES ('1552120854282776580', '1531819854540070914', '0c5ea7d50665e6a89050c15a446f964e');
INSERT INTO `sys_role_permission` VALUES ('1552120854224056321', '1531819854540070914', '14');
INSERT INTO `sys_role_permission` VALUES ('1552120854303748098', '1531819854540070914', '1529695376534106114');
INSERT INTO `sys_role_permission` VALUES ('1552120854215667713', '1531819854540070914', '1530186899780431874');
INSERT INTO `sys_role_permission` VALUES ('1552120854299553795', '1531819854540070914', '1542436081633390594');
INSERT INTO `sys_role_permission` VALUES ('1552120854232444935', '1531819854540070914', '157');
INSERT INTO `sys_role_permission` VALUES ('1552120854245027846', '1531819854540070914', '158');
INSERT INTO `sys_role_permission` VALUES ('1552120854245027845', '1531819854540070914', '159');
INSERT INTO `sys_role_permission` VALUES ('1552120854303748097', '1531819854540070914', '164');
INSERT INTO `sys_role_permission` VALUES ('1552120854261805058', '1531819854540070914', '17dcc367a2c812c36b0d3e2710a567cd');
INSERT INTO `sys_role_permission` VALUES ('1552120854224056322', '1531819854540070914', '20');
INSERT INTO `sys_role_permission` VALUES ('1552120854224056323', '1531819854540070914', '21');
INSERT INTO `sys_role_permission` VALUES ('1552120854274387969', '1531819854540070914', '220');
INSERT INTO `sys_role_permission` VALUES ('1552120854274387971', '1531819854540070914', '221');
INSERT INTO `sys_role_permission` VALUES ('1552120854278582274', '1531819854540070914', '222');
INSERT INTO `sys_role_permission` VALUES ('1552120854257610760', '1531819854540070914', '228');
INSERT INTO `sys_role_permission` VALUES ('1552120854245027841', '1531819854540070914', '236');
INSERT INTO `sys_role_permission` VALUES ('1552120854249222146', '1531819854540070914', '237');
INSERT INTO `sys_role_permission` VALUES ('1552120854249222147', '1531819854540070914', '238');
INSERT INTO `sys_role_permission` VALUES ('1552120854245027844', '1531819854540070914', '32');
INSERT INTO `sys_role_permission` VALUES ('1552120854282776582', '1531819854540070914', '3273e1c9ff7485e4a09c67410641ce29');
INSERT INTO `sys_role_permission` VALUES ('1552120854274387970', '1531819854540070914', '39731ea992cfa03ce527ad0724b067fc');
INSERT INTO `sys_role_permission` VALUES ('1552120854282776583', '1531819854540070914', '39c5c5bcdd9a15110e2c3e4014dd1531');
INSERT INTO `sys_role_permission` VALUES ('1552120854257610759', '1531819854540070914', '3b79694872fa73ff05699bde511b238f');
INSERT INTO `sys_role_permission` VALUES ('1552120854282776579', '1531819854540070914', '4aba9a2f7c81615c9ccdc07e980ccfe3');
INSERT INTO `sys_role_permission` VALUES ('1552120854253416451', '1531819854540070914', '52');
INSERT INTO `sys_role_permission` VALUES ('1552120854257610754', '1531819854540070914', '53');
INSERT INTO `sys_role_permission` VALUES ('1552120854245027842', '1531819854540070914', '55');
INSERT INTO `sys_role_permission` VALUES ('1552120854245027843', '1531819854540070914', '56');
INSERT INTO `sys_role_permission` VALUES ('1552120854224056324', '1531819854540070914', '64');
INSERT INTO `sys_role_permission` VALUES ('1552120854228250626', '1531819854540070914', '65');
INSERT INTO `sys_role_permission` VALUES ('1552120854232444931', '1531819854540070914', '67');
INSERT INTO `sys_role_permission` VALUES ('1552120854232444932', '1531819854540070914', '68');
INSERT INTO `sys_role_permission` VALUES ('1552120854232444936', '1531819854540070914', '7');
INSERT INTO `sys_role_permission` VALUES ('1552120854228250628', '1531819854540070914', '70');
INSERT INTO `sys_role_permission` VALUES ('1552120854232444930', '1531819854540070914', '71');
INSERT INTO `sys_role_permission` VALUES ('1552120854228250627', '1531819854540070914', '72');
INSERT INTO `sys_role_permission` VALUES ('1552120854270193666', '1531819854540070914', '720e77810ca8ea77ec7f7871985ea018');
INSERT INTO `sys_role_permission` VALUES ('1552120854299553797', '1531819854540070914', '734dacc38f293883683b68c6d3e5b56e');
INSERT INTO `sys_role_permission` VALUES ('1552120854232444933', '1531819854540070914', '74');
INSERT INTO `sys_role_permission` VALUES ('1552120854232444934', '1531819854540070914', '75');
INSERT INTO `sys_role_permission` VALUES ('1552120854257610757', '1531819854540070914', '76180395fab6dbdab6f6c050169c5f97');
INSERT INTO `sys_role_permission` VALUES ('1552120854299553793', '1531819854540070914', '77ce77c2dd83b746657afbfb2acd21cd');
INSERT INTO `sys_role_permission` VALUES ('1552120854257610755', '1531819854540070914', '7da1f5456b340b1fc94e8bb8e8ae5e8f');
INSERT INTO `sys_role_permission` VALUES ('1552120854253416450', '1531819854540070914', '906d1078178cb203bb142f8cf22d4245');
INSERT INTO `sys_role_permission` VALUES ('1552120854286970881', '1531819854540070914', '93d659164c0cbb3716fcee100f029d5c');
INSERT INTO `sys_role_permission` VALUES ('1552120854299553798', '1531819854540070914', 'a3322940c314d1b6d9ba1d494740971e');
INSERT INTO `sys_role_permission` VALUES ('1552120854278582276', '1531819854540070914', 'a95f4a835e7ca0277a77223572d3c29f');
INSERT INTO `sys_role_permission` VALUES ('1552120854282776578', '1531819854540070914', 'ae53867719661453637074b18dd7f5ab');
INSERT INTO `sys_role_permission` VALUES ('1552120854257610756', '1531819854540070914', 'c25cf52649878c66073c4ac0d691e86b');
INSERT INTO `sys_role_permission` VALUES ('1552120854295359490', '1531819854540070914', 'cbdd956e2a348039fe01d76c2e6d4e91');
INSERT INTO `sys_role_permission` VALUES ('1552120854299553799', '1531819854540070914', 'd457a36b43fd8e9ad6461c9d42d3a098');
INSERT INTO `sys_role_permission` VALUES ('1552120854291165185', '1531819854540070914', 'e7f55c6889bd826d6a62885ef2ffdb1d');
INSERT INTO `sys_role_permission` VALUES ('1552120854299553796', '1531819854540070914', 'f1d3af076c2810d690edefbdc3462c23');
INSERT INTO `sys_role_permission` VALUES ('1552120854295359489', '1531819854540070914', 'fe84bcc6e4781447ea21573eb04bf0fb');
INSERT INTO `sys_role_permission` VALUES ('1552120854299553794', '1531819854540070914', 'fee57187cae386f067db09aeb0b16b4a');
INSERT INTO `sys_role_permission` VALUES ('1546726543017914370', '1531819907467993089', '03ad13494a492eee81d8d7d1e2d95d14');
INSERT INTO `sys_role_permission` VALUES ('1546726543009525762', '1531819907467993089', '1530186899780431874');
INSERT INTO `sys_role_permission` VALUES ('1546726543022108673', '1531819907467993089', '3b79694872fa73ff05699bde511b238f');
INSERT INTO `sys_role_permission` VALUES ('1546726543026302980', '1531819907467993089', '76180395fab6dbdab6f6c050169c5f97');
INSERT INTO `sys_role_permission` VALUES ('1546726543034691586', '1531819907467993089', '7da1f5456b340b1fc94e8bb8e8ae5e8f');
INSERT INTO `sys_role_permission` VALUES ('1546726543017914369', '1531819907467993089', 'c25cf52649878c66073c4ac0d691e86b');
INSERT INTO `sys_role_permission` VALUES ('1560626178029441028', '3', '03ad13494a492eee81d8d7d1e2d95d14');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241674', '3', '0c5ea7d50665e6a89050c15a446f964e');
INSERT INTO `sys_role_permission` VALUES ('1560626177912000514', '3', '14');
INSERT INTO `sys_role_permission` VALUES ('1560626178008469511', '3', '149');
INSERT INTO `sys_role_permission` VALUES ('1560626178004275201', '3', '15');
INSERT INTO `sys_role_permission` VALUES ('1560626178062995461', '3', '150');
INSERT INTO `sys_role_permission` VALUES ('1560626178062995460', '3', '151');
INSERT INTO `sys_role_permission` VALUES ('1560626178071384067', '3', '152');
INSERT INTO `sys_role_permission` VALUES ('1560626177995886594', '3', '1529695376534106114');
INSERT INTO `sys_role_permission` VALUES ('1560626177932972034', '3', '1529696851075231745');
INSERT INTO `sys_role_permission` VALUES ('1560626177953943554', '3', '1530186899780431874');
INSERT INTO `sys_role_permission` VALUES ('1560626178016858116', '3', '1542436081633390594');
INSERT INTO `sys_role_permission` VALUES ('1560626178083966981', '3', '1552121553494224898');
INSERT INTO `sys_role_permission` VALUES ('1560626178197213189', '3', '1552122437028556801');
INSERT INTO `sys_role_permission` VALUES ('1560626178071384069', '3', '1552123305312399362');
INSERT INTO `sys_role_permission` VALUES ('1560626178083966979', '3', '1552123414641127426');
INSERT INTO `sys_role_permission` VALUES ('1560626178092355587', '3', '1552123729377505281');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938505', '3', '1552126948300304386');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938506', '3', '1552126980588056578');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938507', '3', '1552127050326749186');
INSERT INTO `sys_role_permission` VALUES ('1560626178113327105', '3', '1552127074058121217');
INSERT INTO `sys_role_permission` VALUES ('1560626178121715713', '3', '1552127135114604545');
INSERT INTO `sys_role_permission` VALUES ('1560626178121715714', '3', '1552127171101732865');
INSERT INTO `sys_role_permission` VALUES ('1560626178121715715', '3', '1552127195491610625');
INSERT INTO `sys_role_permission` VALUES ('1560626178121715716', '3', '1552127214743465986');
INSERT INTO `sys_role_permission` VALUES ('1560626178121715717', '3', '1552127228970545154');
INSERT INTO `sys_role_permission` VALUES ('1560626178121715718', '3', '1552127248763465730');
INSERT INTO `sys_role_permission` VALUES ('1560626178121715719', '3', '1552129202101170178');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241673', '3', '1552130346173083650');
INSERT INTO `sys_role_permission` VALUES ('1560626178092355588', '3', '1552162022194425858');
INSERT INTO `sys_role_permission` VALUES ('1560626178075578369', '3', '1552162067870396417');
INSERT INTO `sys_role_permission` VALUES ('1560626178083966978', '3', '1552162375333851138');
INSERT INTO `sys_role_permission` VALUES ('1560626178092355590', '3', '1552162399434321922');
INSERT INTO `sys_role_permission` VALUES ('1560626178096549890', '3', '1552162428064641025');
INSERT INTO `sys_role_permission` VALUES ('1560626178096549891', '3', '1552162459303817218');
INSERT INTO `sys_role_permission` VALUES ('1560626178096549892', '3', '1552162485774069761');
INSERT INTO `sys_role_permission` VALUES ('1560626178096549893', '3', '1552162507773194241');
INSERT INTO `sys_role_permission` VALUES ('1560626178096549894', '3', '1552162542216818689');
INSERT INTO `sys_role_permission` VALUES ('1560626178100744194', '3', '1552162563725209602');
INSERT INTO `sys_role_permission` VALUES ('1560626178100744195', '3', '1552162598462435330');
INSERT INTO `sys_role_permission` VALUES ('1560626178100744196', '3', '1552162619748528130');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938498', '3', '1552162643572174850');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938499', '3', '1552162668285014017');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938500', '3', '1552162693387923458');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938501', '3', '1552162712996294658');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938502', '3', '1552162733850374146');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938503', '3', '1552162757757906946');
INSERT INTO `sys_role_permission` VALUES ('1560626178104938504', '3', '1552162774488985601');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241671', '3', '1552196675919949826');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241672', '3', '1552196825329446913');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241668', '3', '1552206108062396418');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241669', '3', '1552206155193790466');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241670', '3', '1552206179273289730');
INSERT INTO `sys_role_permission` VALUES ('1560626178193018887', '3', '1552206451080966145');
INSERT INTO `sys_role_permission` VALUES ('1560626178197213185', '3', '1552206587509092354');
INSERT INTO `sys_role_permission` VALUES ('1560626178172047367', '3', '1552214776560496642');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241666', '3', '1552214944412348417');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241667', '3', '1552215050998001666');
INSERT INTO `sys_role_permission` VALUES ('1560626178083966982', '3', '1552222776289406978');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658758', '3', '1552225255924183042');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658759', '3', '1552225281513631746');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658760', '3', '1552225302439014402');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658761', '3', '1552225347573919746');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658762', '3', '1552225367438143489');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241678', '3', '1552225891688394753');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241679', '3', '1552225971967373314');
INSERT INTO `sys_role_permission` VALUES ('1560626178184630273', '3', '1552226055807315969');
INSERT INTO `sys_role_permission` VALUES ('1560626178184630274', '3', '1552226198052941825');
INSERT INTO `sys_role_permission` VALUES ('1560626178184630275', '3', '1552226261160439810');
INSERT INTO `sys_role_permission` VALUES ('1560626178184630276', '3', '1552226412193132545');
INSERT INTO `sys_role_permission` VALUES ('1560626178184630277', '3', '1552226475996884993');
INSERT INTO `sys_role_permission` VALUES ('1560626178193018884', '3', '1552228496070160385');
INSERT INTO `sys_role_permission` VALUES ('1560626178193018885', '3', '1552228571710238721');
INSERT INTO `sys_role_permission` VALUES ('1560626178193018886', '3', '1552228656779112449');
INSERT INTO `sys_role_permission` VALUES ('1560626178184630278', '3', '1552521429335941121');
INSERT INTO `sys_role_permission` VALUES ('1560626178184630279', '3', '1552521502904033281');
INSERT INTO `sys_role_permission` VALUES ('1560626178184630280', '3', '1552521541474852866');
INSERT INTO `sys_role_permission` VALUES ('1560626178193018882', '3', '1552521598907457537');
INSERT INTO `sys_role_permission` VALUES ('1560626178193018883', '3', '1552521647586549761');
INSERT INTO `sys_role_permission` VALUES ('1560626178155270146', '3', '1552549270056345602');
INSERT INTO `sys_role_permission` VALUES ('1560626178155270147', '3', '1552549337102295041');
INSERT INTO `sys_role_permission` VALUES ('1560626178155270148', '3', '1552549430933069825');
INSERT INTO `sys_role_permission` VALUES ('1560626178083966980', '3', '1552549932991258625');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658753', '3', '1552550090034388993');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658754', '3', '1552550173316489218');
INSERT INTO `sys_role_permission` VALUES ('1560626178130104322', '3', '1552555383464140801');
INSERT INTO `sys_role_permission` VALUES ('1560626178130104323', '3', '1552555501416357890');
INSERT INTO `sys_role_permission` VALUES ('1560626178130104324', '3', '1552555597688217601');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298626', '3', '1552555839296905217');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298627', '3', '1552555956439621634');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298628', '3', '1552556056595406849');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298629', '3', '1552556156063326209');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298630', '3', '1552556257078943745');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298631', '3', '1552556727491108866');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298632', '3', '1552557023374090242');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298633', '3', '1552557141691211778');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298634', '3', '1552557259131723777');
INSERT INTO `sys_role_permission` VALUES ('1560626178134298635', '3', '1552557377524342786');
INSERT INTO `sys_role_permission` VALUES ('1560626178142687234', '3', '1552557463054589954');
INSERT INTO `sys_role_permission` VALUES ('1560626178142687235', '3', '1552557668537737217');
INSERT INTO `sys_role_permission` VALUES ('1560626178142687236', '3', '1552557763144458242');
INSERT INTO `sys_role_permission` VALUES ('1560626178142687237', '3', '1552557850641833985');
INSERT INTO `sys_role_permission` VALUES ('1560626178146881537', '3', '1552557975577567234');
INSERT INTO `sys_role_permission` VALUES ('1560626178146881538', '3', '1552558709345886209');
INSERT INTO `sys_role_permission` VALUES ('1560626178146881539', '3', '1552559000367669249');
INSERT INTO `sys_role_permission` VALUES ('1560626178172047361', '3', '1552559431978328066');
INSERT INTO `sys_role_permission` VALUES ('1560626178172047362', '3', '1552559574806962177');
INSERT INTO `sys_role_permission` VALUES ('1560626178172047363', '3', '1552559830688866305');
INSERT INTO `sys_role_permission` VALUES ('1560626178092355589', '3', '1552884393624838145');
INSERT INTO `sys_role_permission` VALUES ('1560626178197213186', '3', '1560455577560219649');
INSERT INTO `sys_role_permission` VALUES ('1560626178197213187', '3', '1560553057127825409');
INSERT INTO `sys_role_permission` VALUES ('1560626178197213190', '3', '1560626135536947202');
INSERT INTO `sys_role_permission` VALUES ('1560626178046218241', '3', '157');
INSERT INTO `sys_role_permission` VALUES ('1560626178050412552', '3', '158');
INSERT INTO `sys_role_permission` VALUES ('1560626178050412551', '3', '159');
INSERT INTO `sys_role_permission` VALUES ('1560626178062995459', '3', '16');
INSERT INTO `sys_role_permission` VALUES ('1560626178037829634', '3', '164');
INSERT INTO `sys_role_permission` VALUES ('1560626178062995458', '3', '17');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658756', '3', '17dcc367a2c812c36b0d3e2710a567cd');
INSERT INTO `sys_role_permission` VALUES ('1560626178071384066', '3', '19');
INSERT INTO `sys_role_permission` VALUES ('1560626177974915074', '3', '20');
INSERT INTO `sys_role_permission` VALUES ('1560626177983303682', '3', '21');
INSERT INTO `sys_role_permission` VALUES ('1560626178008469508', '3', '218');
INSERT INTO `sys_role_permission` VALUES ('1560626178008469506', '3', '219');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658757', '3', '220');
INSERT INTO `sys_role_permission` VALUES ('1560626178172047364', '3', '221');
INSERT INTO `sys_role_permission` VALUES ('1560626178172047365', '3', '222');
INSERT INTO `sys_role_permission` VALUES ('1560626178050412546', '3', '224');
INSERT INTO `sys_role_permission` VALUES ('1560626178054606849', '3', '225');
INSERT INTO `sys_role_permission` VALUES ('1560626178054606850', '3', '226');
INSERT INTO `sys_role_permission` VALUES ('1560626178197213188', '3', '228');
INSERT INTO `sys_role_permission` VALUES ('1560626178050412545', '3', '236');
INSERT INTO `sys_role_permission` VALUES ('1560626178054606851', '3', '237');
INSERT INTO `sys_role_permission` VALUES ('1560626178058801153', '3', '238');
INSERT INTO `sys_role_permission` VALUES ('1560626178058801156', '3', '306994778c19b648dfde51acee6ec24a');
INSERT INTO `sys_role_permission` VALUES ('1560626178050412550', '3', '32');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241675', '3', '3273e1c9ff7485e4a09c67410641ce29');
INSERT INTO `sys_role_permission` VALUES ('1560626178163658755', '3', '39731ea992cfa03ce527ad0724b067fc');
INSERT INTO `sys_role_permission` VALUES ('1560626178029441026', '3', '39c5c5bcdd9a15110e2c3e4014dd1531');
INSERT INTO `sys_role_permission` VALUES ('1560626178033635330', '3', '3b79694872fa73ff05699bde511b238f');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241677', '3', '4aba9a2f7c81615c9ccdc07e980ccfe3');
INSERT INTO `sys_role_permission` VALUES ('1560626178071384068', '3', '5');
INSERT INTO `sys_role_permission` VALUES ('1560626178058801157', '3', '52');
INSERT INTO `sys_role_permission` VALUES ('1560626178062995457', '3', '53');
INSERT INTO `sys_role_permission` VALUES ('1560626178050412548', '3', '55');
INSERT INTO `sys_role_permission` VALUES ('1560626178050412549', '3', '56');
INSERT INTO `sys_role_permission` VALUES ('1560626177932972035', '3', '61');
INSERT INTO `sys_role_permission` VALUES ('1560626177941360641', '3', '62');
INSERT INTO `sys_role_permission` VALUES ('1560626177928777729', '3', '64');
INSERT INTO `sys_role_permission` VALUES ('1560626177928777730', '3', '65');
INSERT INTO `sys_role_permission` VALUES ('1560626177983303683', '3', '67');
INSERT INTO `sys_role_permission` VALUES ('1560626177983303684', '3', '68');
INSERT INTO `sys_role_permission` VALUES ('1560626178046218242', '3', '7');
INSERT INTO `sys_role_permission` VALUES ('1560626177974915075', '3', '70');
INSERT INTO `sys_role_permission` VALUES ('1560626177974915076', '3', '71');
INSERT INTO `sys_role_permission` VALUES ('1560626177958137857', '3', '72');
INSERT INTO `sys_role_permission` VALUES ('1560626178092355586', '3', '720e77810ca8ea77ec7f7871985ea018');
INSERT INTO `sys_role_permission` VALUES ('1560626178021052417', '3', '734dacc38f293883683b68c6d3e5b56e');
INSERT INTO `sys_role_permission` VALUES ('1560626177970720770', '3', '74');
INSERT INTO `sys_role_permission` VALUES ('1560626177970720771', '3', '75');
INSERT INTO `sys_role_permission` VALUES ('1560626178033635331', '3', '76180395fab6dbdab6f6c050169c5f97');
INSERT INTO `sys_role_permission` VALUES ('1560626178016858114', '3', '77ce77c2dd83b746657afbfb2acd21cd');
INSERT INTO `sys_role_permission` VALUES ('1560626178008469509', '3', '792d3621d9d2f92acb7b9847dc0ef598');
INSERT INTO `sys_role_permission` VALUES ('1560626178037829633', '3', '7da1f5456b340b1fc94e8bb8e8ae5e8f');
INSERT INTO `sys_role_permission` VALUES ('1560626178050412547', '3', '90201ca3ab25e2204e3c250b5cd399ac');
INSERT INTO `sys_role_permission` VALUES ('1560626178058801154', '3', '906d1078178cb203bb142f8cf22d4245');
INSERT INTO `sys_role_permission` VALUES ('1560626178016858117', '3', '93d659164c0cbb3716fcee100f029d5c');
INSERT INTO `sys_role_permission` VALUES ('1560626178021052418', '3', 'a3322940c314d1b6d9ba1d494740971e');
INSERT INTO `sys_role_permission` VALUES ('1560626178172047366', '3', 'a95f4a835e7ca0277a77223572d3c29f');
INSERT INTO `sys_role_permission` VALUES ('1560626178176241676', '3', 'ae53867719661453637074b18dd7f5ab');
INSERT INTO `sys_role_permission` VALUES ('1560626178029441027', '3', 'c25cf52649878c66073c4ac0d691e86b');
INSERT INTO `sys_role_permission` VALUES ('1560626178008469510', '3', 'c44e35a713e6e68ab1825ff0f6dd0a41');
INSERT INTO `sys_role_permission` VALUES ('1560626178008469512', '3', 'cbdd956e2a348039fe01d76c2e6d4e91');
INSERT INTO `sys_role_permission` VALUES ('1560626178008469507', '3', 'ccfeae90e4d3391ad54451fa2b4c1cd4');
INSERT INTO `sys_role_permission` VALUES ('1560626178021052419', '3', 'd457a36b43fd8e9ad6461c9d42d3a098');
INSERT INTO `sys_role_permission` VALUES ('1560626178058801155', '3', 'e4d1ddeb3c3dc7a292ce76770bfdcc7f');
INSERT INTO `sys_role_permission` VALUES ('1560626178016858118', '3', 'e7f55c6889bd826d6a62885ef2ffdb1d');
INSERT INTO `sys_role_permission` VALUES ('1560626178016858119', '3', 'f1d3af076c2810d690edefbdc3462c23');
INSERT INTO `sys_role_permission` VALUES ('1560626178021052420', '3', 'fe84bcc6e4781447ea21573eb04bf0fb');
INSERT INTO `sys_role_permission` VALUES ('1560626178016858115', '3', 'fee57187cae386f067db09aeb0b16b4a');
COMMIT;

-- ----------------------------
-- Table structure for sys_tenant
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE `sys_tenant` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `contacts` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='租户';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `dept_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '部门id',
  `post_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '岗位id',
  `nickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码盐',
  `sex` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '状态',
  `source` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户来源',
  `last_login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户Id',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁保留字段',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_username_pk` (`username`),
  UNIQUE KEY `sys_user_email_pk` (`email`),
  UNIQUE KEY `sys_user_phone_number_pk` (`phone_number`),
  KEY `sys_user_nickname_index_2` (`nickname`),
  KEY `sys_user_username_index` (`username`),
  KEY `sys_user_dept_id_index` (`dept_id`),
  KEY `sys_user_email_index` (`email`),
  KEY `sys_user_phone_number_index` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', '1', NULL, '系统管理员', 'sysadmin', '76c7d59df99d0b60d89da94df5062511', 'ezmfjc59pn', '1', 'easyframe@sina.com', '17366392808', '1990-11-25 00:00:00', '/static/formal/2023/1/11/ea3b2d2b-41ea-4ffc-a389-78e03a827662.jpg', '1', NULL, '2023-02-16 11:12:16', NULL, 3, '1', '2020-12-11 10:54:00', '1', '2023-01-11 14:52:01');
INSERT INTO `sys_user` VALUES ('1533320501638762498', '1', NULL, '管理员', 'admin', '07706d9563127464ee6643319203cafc', '9oszdqrwu1', '1', NULL, NULL, NULL, NULL, '1', NULL, '2022-07-27 10:37:18', NULL, 4, '1', '2022-06-05 13:31:10', '1', '2022-06-12 21:59:48');
INSERT INTO `sys_user` VALUES ('1533322492788117506', '1531875373476855810', NULL, '人事经理', 'hr', '8ca24c20d083f0ad886bb67f6669909e', 'bjihdcoyzj', '2', NULL, NULL, NULL, NULL, '1', NULL, '2022-07-29 10:48:27', NULL, 1, '1', '2022-06-05 13:39:05', '1', '2022-06-05 13:39:15');
INSERT INTO `sys_user` VALUES ('1533326281821671425', '1531875536031301633', NULL, 'cc', 'cc', '288c53514aa1d1080b5fb2b2d7dd4f93', 'lyxgtbu443', '1', NULL, '', NULL, NULL, '1', NULL, NULL, NULL, 0, '1', '2022-06-05 13:54:08', '1', '2022-06-05 13:54:08');
INSERT INTO `sys_user` VALUES ('1533326426277695489', '1531875536031301633', NULL, '甜甜', 'tt', '59f4a2f0c0c5adde1c8f5f9a22b81d83', '6u51fzztjc', '1', NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, 0, '1', '2022-06-05 13:54:43', '1', '2022-06-05 13:54:43');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_role_user_id_role_id_pk` (`user_id`,`role_id`),
  KEY `sys_user_role_user_id_index` (`user_id`),
  KEY `sys_user_role_role_id_index` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES ('1560632049396535297', '1', '3');
INSERT INTO `sys_user_role` VALUES ('1535985220063256578', '1533320501638762498', '1531819854540070914');
INSERT INTO `sys_user_role` VALUES ('1533322534836015105', '1533322492788117506', '1531819907467993089');
INSERT INTO `sys_user_role` VALUES ('1533326281863614466', '1533326281821671425', '1531823375461146625');
INSERT INTO `sys_user_role` VALUES ('1533326426311249922', '1533326426277695489', '1531823375461146625');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
