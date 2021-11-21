/*
 Navicat Premium Data Transfer

 Source Server         : 本地 - MySql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 127.0.0.1:3306
 Source Schema         : easy-admin

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 26/04/2021 11:14:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sample_general
-- ----------------------------
DROP TABLE IF EXISTS `sample_general`;
CREATE TABLE `sample_general` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '地址',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='代码生成示例';

-- ----------------------------
-- Records of sample_general
-- ----------------------------
BEGIN;
INSERT INTO `sample_general` VALUES ('00bfb9b8c0240712d17f3389228d451f', '势悠奕', '2', 23, '17366392808', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('018698bf94eb54347db1eb096162437d', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0228ef4dd45be1bc1e022d82c2f2679f', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('03f1fdb129153d9afa8736cbf3e5f0d0', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0400e91399212745bbf928be79ee1496', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('05488bb7ae7b82b404e17dcf58856269', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0826ca62d38942801d75c75f582bb3bc', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('0842dfed15581436ef80e8164e4d09ee', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('08b28ff6397c0bfb737a525bbcda98d7', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('091df4c8fddc204e5ff3fa97415f0baf', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0a338a363b107704fc1c59065b6715a3', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0c0e9ebc4818e36ebffa14c90da6c383', '势悠奕', '2', 23, '17366392808', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0c0ee2114a7547c6ff284298ea193e03', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0e2b1ac49f76da21c269082258e2b917', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0e2fb2f7a4a60530be7f2432f5757874', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0ec56afbfa259ac06cc4742ec5afd68d', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('0ed618e283d6d6a39cfce071ef109c4f', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0f14e7ad4a0bacd43d22b540f9b2e16f', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('0fd099585b6a26bb968b4798508b03d2', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('0ff12eb85b60e6196792daef10dc567b', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('10d1cd8962d00885f08e358cc62f5d47', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('114ff0d6069e00c6a54c3ff55ff1c546', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('11977c0a4ee700b580d0ef103920d3b3', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('119d22a399379a6dbd366893f979e4fd', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('120a275ac6adb60c2182f5062b739cd6', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('125fbd0e828a08e01795e99b62f9293b', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1291a5a058985cf476f0dc345fa78fd8', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('12e3c46f2f686a66406232ec687b6b3b', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('14d3d3b141fc5e812aab91435b16f464', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1616c5653514b09ca3bd4f77754c620f', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('16b667f85c4474e61b0b2c22899fd325', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('17f183fa79bf57aa3960f60997773eec', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('188ff5e3ce431d6f172591872f90f3c4', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('18c3f9e6528573ea80132afbd3bcd309', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('19080c756656b70c82cccaebea1731b3', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('19092d7f4d236bbdf9feb0d1ec53b149', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('19d3e219dece82ef342e768113204d3b', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1afa4413ff894ff7ee585a4b68d65daa', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1b8179fa2c678718a9062c50a29cc38a', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1c107b61e687e1a7d592649470ea78d2', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1c68f7e01c10fd6fffc4d724010a410a', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1c9d7c2101c20a0a0f6ac5a99147038c', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1d0cb93b72f496eceab2d01d1024afd1', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('1e4d77744665652d6981db3939d3c7f1', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1e8dd2a78cd158b3137648a5edcb758a', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1f05fc6437e269ae161700424192b859', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('1fb595ff2aab24c6c8913a11cee950c1', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('209b65e06d60f0a0726ac8bb0cde1e63', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('223dc69cce15965b628dfd49ceadd4ef', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('22d432a2deb93e40f094ca637704c967', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('231de4c68858f12d2b44647450738ca1', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('238f1d6b549272fedea2a2d3483c2997', 'cc', '1', 30, '17366392808', NULL, 'xxx', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('245ff29b2fe0da6763acf0386287d20f', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('24a58b77e2134273213fc23f93e7e6c4', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('24cf7456c7a443c69cbe3606025beac9', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('252992597346a163114e0ebf05caef3a', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('25af611bfb72eb3029b83ab934eba06d', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('26d8ba91d53868c3f8f317372c0a1284', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('272ce9879ac6f789ce38da317cbe6d40', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('2785688f26d4a0a1ce0ec16dfd0518f1', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('2973631a1cfc04acb3b39fe54e00f10d', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('29ac2c110940f55123f0af84eca6ae18', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('29de48c8dc4f556974f0dc282b25fb97', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('29f85aa6e090591619581e8c876bb3ae', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('2a88f210810cd13bd2b10119bcf665b8', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('2b30cd483ce0398f3839941803181fa3', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('2c39d651d4583af3b873ec5b7ffd7e36', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('2c72ce62eba2c84d4218ff5e6967246f', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('2ce822bb8c13af4ec0a23b84841ff947', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('2dc6e447668b9e7b33239b738935f116', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('2f7a0f77865fca1eb466c06e47c61b8f', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('302f58baf2ff4c210bc371f16c14811f', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3036a125170d8d01ca394417516adac4', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('30a204e8be4ebdf32901c0deae9c2ec2', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('30f2075d0e6ca4cab73a6f088aedc09a', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('313b00479815f9c0fe955e77aa56ec3c', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('31c0461cb71f8d9e37f54c1b2a816fb8', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('32904ae45308653f94383a8645461001', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3339ce23797b9195f7ff98eb61d2501c', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('344bbefc75c4c7e3dadab2e17d02a78e', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3452544af18dac4b2567bc5435239780', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('34c13ea2ae04a5e8fdc74b7a997cc4fd', '势悠奕', '2', 23, '17366392808', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3665f4aa2efe7d4354ec86b0abcbfe14', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('36701a2ed2c99e29a637aad2410fe545', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('3670687d6684963fe6b3e7671a477fbc', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('36bb932678d4c6a7cd0e58120988954f', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('36bfe46d782cbc56476cde94d5c5f9e3', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('3928b3697b73bdc0c139958242b1843c', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('39c2d4cc5bfafc56d86dc83a07ce74e6', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('39d67e753bf94916883282c8d2db94e7', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3c0da9db4fb7585882ddf344c1a984a5', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('3c5700343850686cccbda75e31d1386b', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3c66363fee06fa97944a780928a80594', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('3c6ffec07742cab0acfb4673db20614f', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('3c7c8e88ec16e540a573f9c0ea3dab0a', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3d19530edbb031623d8f882b7423cf6b', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('3d911c250e5d888f18841688268fd71c', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3e66a0a20e66db79dc590c36902c0595', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('3ee5c8c0b1c049bfdb89f54f87a78525', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3f0a4f9813189091692342eb12781c42', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3f130b77eda601188236d7163b0c68f0', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3f8e27bbe7f35f1416a2a875c14c8c8a', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('3fcd5c1c3c1695a165dc8e1ec0f9a031', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('401a4ae68fa33cd5909eb89696418d6f', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('405b4cef8358cb0573168e9f1ed5e16d', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('40ec8ecf3372552cc6217d1dd055b5dc', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('425dc6c886812b0dcdd8d193e7a968d1', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('42d9cebde7c2f88ff30e3b37c5c94440', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('42db37cfeffc50d5604ddf32360dfcce', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('46597e2ad713a403cefb8362f10a15a1', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('46711b1e8def2220b911918e2c520a4e', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('468f51cb54283b36d9135ecd702d5a8f', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('46b81ea18e521ce3ece5c3a35fb8fbf1', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('47bc5a749b53e037071085227ee281f7', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('47f58bc83525383145df47e835322ebf', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('4882dc987f5988469d8801372e721af2', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('49ad2d5279ec446554fa85d10704fb67', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('4bd99f0407d5207374aa13535fb4e4f8', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('4cb756a9f02e65594102da4182a2532d', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('4d7f0db4d0917ca8cc95520ec757a224', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('4d9d206568d5e7613da39dd371bc3ed4', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('4fc3308b58bf85486d4b93fde9c908a4', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('4fd035205e56582d040f8e199002b063', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('51c055ca22fa013164375b0b7193cf40', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('525d7fb5c3b50e168d985d2e3b848cba', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('531cd0c4491869bba298b9e13470387d', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('538531c4ce035daf6c4d99c949d3e2aa', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('542bae753275085a125bc695200a3e85', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('545702eb011a09efb260e640d93cb762', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('54e54bc3bb866faed6fc357cacc372ff', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('54ffb8c8a9c83e0b8250fcaf55ea4e80', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('5680db2302e57add829a43056b25fc3c', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('5685d3d40b183dd6aaa35266237e1807', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('568f1c4723f22592a5a1c08c21a3d706', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('57227e73c2a54995a898a6225e8513ba', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('577acf4eb70b75bf2f7e85691b9b1e35', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('58b0f2b98939fd2ca61853454579859a', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('59d25b63acb817feb573ec5bb4185658', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('5a21d23eeb56bf74fe0f7fb64dee71b8', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('5aac68b5f928af1221e9dd2f377731f1', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('5ba3f40f2fc03a171b04c59278cb1d92', '势悠奕', '2', 23, '17366392808', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('5d8b50ed63a7038f8ac15ae855753558', '势悠奕', '2', 23, '17366392808', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('5d90e95b586208023579eb9475097c59', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('5da17a4a8bf80292bb90cc783d3745f7', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('5def5cdc4fd76d6c39371a1906a7da63', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('5fa9d44ac6cdf0eda93c033082678f9f', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('605463674b5b044c8d003e3f45b1ee63', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('611e67b1f1162f48040153caf919a95a', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('61261cb03cb84bc0587e7d6f3db03711', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('616bf50bda883b161d18e38a479b2b83', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('618d68bfc0427288a44099c698dbe3fb', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('61a27b123fc0aaa329ee093058da3746', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('627b9c3cbcce109eb44d63417d438e38', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('632455b0c82340d664d0f2094eda9c20', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('63f675876c2cfa24390833a05a468479', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6472d8450207d9018656e065cf792f7f', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6498adba1e48b17803a8eca2b14333e3', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('65cd401d7ee91d1f39af5de3aa9652fc', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('65e4a20930aeddf5d6851f1fe0eb6c3f', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('668e437214f25ac39861dca89761546f', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('66a823af42ea876187387a3555a0d1d5', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('67a3f48326798f8f6677ce80194449bf', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('67e95571d8294f53c448fa1a7d157a56', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('698d8c1f98861484dd3a7de72a47158a', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('69b7cfc01145a9f0c1fba697f7fff3cf', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6acb0ef62783fcb2259a21b36efe62c1', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6af17b4e88c1836b518243b084c55419', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('6b00a73b62fe8a21f6e93e020038be5c', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6b0d96eb37a8da07e91129fcff1368d9', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6ba55c0c90e63d3e92307a605f25ca7e', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6bcbff2c81a2a690da317da07817f8c3', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6bee0a93c53055dcb3fe0697c83c9d9f', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('6c1711be06ce21c049be3850ae8d2212', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('6c79f29bc58f6abd0de7e9783c857b7f', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('6c9a85264cf6c25808f0785b935966bc', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('6cd631839fd93f6c1af5f4b90e6815f4', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('6d2efd25531f1f51e9329fb0a4515462', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6d80407c40fb8f9b9522dc876927820f', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6db4af2b300d0a9d4f2f19f455c63972', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('6dbc206fe864813da17f78f6c5cfc618', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('6f077e6543b3d68eee8fd8fbabfa5ffb', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('6fa86824482d9913bdecfa0b60ee7d9e', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('723f2cbcbdac0d16f71d9d142dd2bdf8', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('72656056d471f510918ac8f98cb36eea', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('72b043dd96e67b4db32d37d80192775d', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('72b1c6802c1b15914b1b847c0d5c2311', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('742350c4d426e0d30772c030304caee3', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('7434ba67f3d6d9a74f0ba041f367f805', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('74be2d086dcc299173270d090df3780b', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('755673dc48521d337f7d0bc222fd2fb8', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('7633174667b25b6e7fea18a7510826b1', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('76f317471b21a82434783abb4cb0dcf8', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('78431834857d6a1e8eaf7d817b38b759', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('78fb6f7ebd883caab470bdeca7b22217', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('79246658f3d476390bea6f156d41d9c4', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('7951f7f25690a16f27ce5169c67252ad', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('7959efe8d14a225c8de498eb1729817d', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('79af8527b96a0a828bdf1388f5d183d0', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('79d21092ba2bf07afb209b6a205f10c9', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('7bf45ca505be3837c2cc7581090f5957', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('7d63a89b1d9d967391cec42dc0b26a5a', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('7d9e5a0fe03a783f1b00fd2cad62deb6', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('7e5716d62985699ed53b2da6a0e1c187', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('7e7b659827b0a3e1f58490e7a0d2933f', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('7e8ae9fdb450d0eebaa0b7afdd26d225', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('7f8ba4eb8be29377a2e1704c7ff96feb', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('80313ae5f1395af173df2489fff9a6c3', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('808bcd4c2b0428c0c939995d5d2ec87d', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('80d5fdf20493f73a1c145f036136b537', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('81160240ffaf34f738dfb113516c2e30', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('81639218a0ac8e0edf20429160d80fa3', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('81e8dedbd1c4c6748da7fc29d6f950c8', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('8215852f102d57eedb3944077b8ae0ec', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('830f555ad33a635e4a794f518eae1c83', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('8329a219b96e074154f74442024b5a3c', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('832f650a0a858a1cb246fb44f314cb9e', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('834b8038ff0d02d36b8c2eade37c28e4', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('840b3b8d8d16b20bffc8744fd662f7ba', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('846c5154139e8d6a269fcb31469647cd', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('84b1938f027d899f92540fec0eae1911', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('85053e9b4973be7049188a33955ebec1', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('8514b7befb55d06a1489c75ccefab9b0', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('8539c2646875167df2467cef60226247', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('85594e58e21a80b6caa6da4ac0866238', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('864b08ea9ec37eb4853a0b521a4747ba', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('8a1194bcf1f4bb2bb28a825ea099415f', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('8a49bc9232c2ce3ec2ca8e47ac7c34cb', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('8a685f4fd4a058f74fc8237cb28f4023', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('8a82a329d6f384fdf02c9f86cae4ccca', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('8afb41c5f5fe4003b2c8e37705aa5d4e', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('8cc919f900e1053e4a99b3b851af57c2', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('8d01e6defe0af2e66a444a0936e645c5', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('8dafc19e1bdb7fab35ae379d9a7799de', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('8e37373cd205a6bfee9d76def58cf5d9', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9048ff36e1d83e9b81dd95e50478dd0a', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('92034f640a88b73b2329594501a6e6f2', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9315c9fbf6d029b8f71117a70755ab24', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('936ab36eabc2801de9225486bfd117dc', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('941dcbf6d0206a9cc74eb2d62d12c4b9', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9834d11ff8a50cbe081ca7424e301147', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('987ee88ea66c84ff5b82ed63f7212a2a', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('9905415414c9262bbb2c207c4c5292ac', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('99593836cb7003191fb298addb64b28b', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('996b8f87d7e749dcb451c0487e4383fe', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('99da017b2c0180c23b0ac42cad5649bb', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9a59c4c333ce6ae7161f461d464d53ba', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9b7222d9082b5af73d0d439e67f87dd2', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9bb00218539a204b532ca85b619243e4', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('9bbdf44b8702d657907d389ca892c1e0', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9c32ddcfdc707ffcb719796163714712', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('9c8b1d597ff46c9327c5b965d53bb75e', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('9cf2a910eb817dd0d362f8b92e64dc1d', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9d0cfc2d5b991180dc396f76671deb92', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('9d3001d2e5e2644eb7eb35563f4f20ca', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9d7f56bf87faa2ff6ac9cc2c3bc85257', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9da79041040e2ff864dacde5ebc4cb62', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('9fa5b50dba365706b165f5f442f6fd7d', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('9fc75ef2c031c06808d9e7a570b30ff7', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a0a7d290326ef7fdcc9049edc57d5d99', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a1e7cca8f0251dc6f96d16705683273a', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a216ddfaeec7be852f5d28ae296321ae', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a3177f4e93b9fb9360562e701581e36c', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a3b1cc6aaeff36a3735ebce6f4f17061', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a417ee502260da2f340e8cba8c21b3d5', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a462d74ade718806d1ca8c89a4e3d3ff', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a5058de2c98da0167ec67c920c21d760', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a583697f784e2dea0c813b36d5504dec', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a6759c6219539bd29ab12fcae4a51ed0', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a6a45a16b484f8e7f704717bf351d2a6', '势悠奕', '2', 23, '17366392808', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a6c6948be50eda5c70e41b1c2aa92c55', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a6f01097791b8cf8e34ea6d10f1c9b77', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a7071e7386ea751b7ef3cb74af4ecfcb', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a72c9a8e146383193ba128f93029422b', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a777601bc7d1335e21a71a2a2453d8e9', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a808f3d880ab8f90063a43ae19552f80', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a89650de52ccb2470dd3a9f5955d6b8b', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a8b2c2ea225fb13db569343a12896b3e', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a8f5ca95a299a1001463d0cba15e8bd9', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a8fb5983a429a8e344ec7f72f1706499', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('a91501a8e55abb358bd1148bf5084eaf', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a93ce4e10afe6d7052234b1cd7dea11e', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('a9d01131821cb7bdb1538f5e32a27240', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('aa4f674f75fa0ea551855df9ea3e407d', '陈绿凝', '1', 28, '17366392944', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('aa7941fe7e7a7906c4afccd3ebc4258a', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('abb4d1ff6a44043d2c4ae990fd42fb99', 'cc', '1', 30, '17366392808', NULL, 'xxx', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('abce9a1623b085521f79d4be67da66b4', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('ac16b76fafe22f43a2cbe1e828243e95', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('ac437a3dc38597c1c470837bcc0d51c9', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('ae7cff597e651c2250ef29172beb80ac', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('aee051023da94be5bce6a50073d4d6cd', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('af992ab4565eac2f20f3cc2e92023669', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('afa08ff5fdcf33ef68a7102406bd8373', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('b046e5536914757489f7e23c8dd3616c', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('b04773dd3463a54aa0dc923bf7d041d0', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('b0dc5281da3d7b665dcf6dbe11a4a6dc', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('b155e0cb496253ea6d597f80980ffad0', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('b18588aabe34ee204b8568a91757a898', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('b1f8faa87e497147f26959c1da4d9874', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('b346c9b56e91493a99918a6d7effb74d', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('b3db3e578e750cb6f21cad0307c91902', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('b59eae8e56e4a110181863bfc889fd42', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('b5be542f3d2e9bb23dcf8820b549b1d0', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('b74339c6ccfcff5b7e80427eb369d022', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('b84cf9d20ec8a663e84c13e13082a82a', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('b89714b7c2f5971423d3033777166352', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('b8bfaa01790eeddc9355dfcf1599d61e', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('bb18b3b24a096a44a406eb5a3ac20b0a', '秋痴春', '2', 26, '17366393055', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('bb227758058c7191af4eeffa3a5e8217', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('bb2eeedb5fb2573737226dabb0764633', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('bb51c105812e5e728f476f5a2daa5cfc', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('bbd74baeb5d99b79566d6267c2858614', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('bc1bed7522eeefdd004ad1114f5dec12', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('bcdd2c401cdfccffd987e5470ff53760', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('c00110cae2b7c52363546801baa7759d', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c04ea9b381cb6b302cbdf33b8e61d0f9', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c04f225b6a6beac1088a96dc8eab7279', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('c26c48c17633bb527f01afa00288bb6a', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c30df0af34c426fc9939461fe7c14657', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('c33447cf828a71e070c24d4d42a0c67d', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c339ccb9229525c64425eb7cd8fb7821', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c3b3c31baca9bf1648a84ae91a6e5ab4', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c429b22b3a13bdc2c2b354ceb6c09590', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c472ce5498d6e019a234d536f5cca297', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c4895e756a2f4c21d090fda5150c9e65', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('c4ef969c6a863a8da5f7b2df6aabf984', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('c5060fdaa7902a2b76af5ff5229ce295', '僧山', '2', 26, '17366392810', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('c5a0a84f445a920734f90fc18c1e1df0', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c604b06f6d4a2cab9240d7bb0c0cb3bc', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c72dbf46af96f4fe29d5bcbcf78da2c1', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c78dd5d7f0d38a1fad5b02095294c1c0', '蓬子石', '1', 28, '17366392818', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c7db5179955b2fd2a399269ed735c9d8', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c878b2d051c32c86c7ca0402636562c3', '善燕子', '1', 23, '17366392815', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('c87a851daa7facde9934e832c3cef6d8', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c91c2801f9837412086aae74627d5702', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('c9a8925298742675d2600c5bc13ae312', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('c9f274b3c43ec51aa5fd316757bda68b', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ca175d4e8c552a4e3be0e1ff85c01a0b', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ca3c02342c648d01dc0ce10905cef0d2', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('cb16602fb416fa0ad03b0f0045945bdf', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('cb43f60b28ef4fdaef25486ba90acd2b', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('cbb3bb310a26a158f6f0d6d8a126b543', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('cc4b708c986dc4eac83634d78f8fe8b8', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('cc660cd6ef466a3a764da80111c14b1b', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ccaf9ab9071b49a5101d7cfde01b9e26', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ccbb325d46529e8f2da68a5f20c1f89b', '势悠奕', '2', 23, '17366392808', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ce0adfe4b0c2f3c737bca9eebb94eb3d', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('ce2883f681080b177c7209ee777d4b03', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('ce41044b340df3f3d293e8bda80c6a21', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ce5f64c2d7cba7c0c5484fc26a4803c4', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('cea11d62cbda9ec2cefdd1532f4f21d6', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('cf104edad827e6471aaa43e14db7c5a5', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('cf45db05e0c1210135361e74f44f2349', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('cf627d5c91d610f9c4a477bd791d2afe', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('d1b3d519f806876d85a337b71d3b30e8', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('d1ce1b148197356cef1094aa54c4bf38', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('d3586b849f8964d6d623f42b7a7952b5', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('d4136d4eeddea812c198a70e8f83889e', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('d43a69c07425ab89d86eb9765f301153', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('d551ab3e8a4db44f03e5bb080e13aea7', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('d690fe889c3e8aab01d98ee66b06a321', '员绮梅', '2', 23, '17366393051', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('d6fb178655d94196065d728039ea5541', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('d70f49c9328c74618b869e72cb302336', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('d74d75bd26460e729f6226709d9e5a04', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('d74ee057762d847d0802c5a5af27f496', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('d75bc59fea133e101e00f7e0c6033f24', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('d7d36bf017cca9e85a00528a8ac18317', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('d859eeb73a10ce94ee714950b960470b', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('d9b2ed8b54bd64ef78a8d27ddffbc752', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('da237a0d96d5cc6e0d34930b4967d55d', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('db819fc097c596df77419544297c4261', '候之玉', '2', 28, '17366393054', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('dba6c911794b8502c474c6b8b7a0e34a', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('de613716c068b9edc0cb5fdf5d0db483', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('de64713f1b966349bc89b8fb3e82102a', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('debaf1ea990300abe70834dd4d27883e', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('df0866ce6cb2f55ffb06706ae08bae4b', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('df5728c4673f6740978f70aa1e990363', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('e10397ccbe952b97d03655732b277cb0', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('e12d3500d7562e9157e1ef4b7241c22b', '答鸿信', '2', 27, '17366393053', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('e2b81ec9137edc50a8997d2dc4199f0a', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('e2f2ce7b54fc27c188de11d07418d9e8', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('e301288f13b1d100daf3e44e27ca7c1b', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('e3c1025b8107254b044a0a6967b83f5c', '麻寻桃', '1', 26, '17366392931', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('e3fb4228862ee9f48becbab687207866', '孔丽君', '1', 23, '17366392929', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('e4147d0f00cfe8de30078b2d2b1c099f', '淳于凝云', '2', 26, '17366393058', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('e4877285bdaa4f842c4bef22a3e1869d', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('e48c4f96b6bf478287b157ed145acdcd', '濯丝琪', '2', 23, '17366392935', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('e49bf123391cc6dbd4d4cead993d16f8', '针晓畅', '2', 26, '17366392937', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('e592a176755d5987cadc947bdd512d33', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('e8c5354225244abf975cdce9d3f9545d', '鞠理群', '2', 28, '17366392823', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('e8fa0578d2305610825155d267496632', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('e92451a7a595ca45a91bd3fb14761dc0', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('e990510b19f0e8cff72c3f4d053e8259', '伯景彰', '2', 23, '17366392809', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ea940c3d745065599e1e2001026bd76a', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('eb351878eb626caf1df98b9ab1b1a090', '普玉石', '1', 23, '17366393050', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('ec5bf3fef7dc581554582afc1f0c61a6', '祖流如', '2', 27, '17366392811', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('eebcc83a90fce5b2ebf07ba88e57fb7a', '六慕诗', '1', 28, '17366393065', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('eebe84e7b30511b9799cdae697b6e1d3', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ef05dc1f5ebf502c42a0920d4d805b1a', '范姜雅韶', '2', 28, '17366392939', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f01442eac8646884129e35116e8489d2', '势悠奕', '2', 23, '17366392808', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f043ea9ace431e61af6803adf33d2540', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f0810519bcaf63868728b9b5042a4c7b', '乌雅冷雁', '1', 26, '17366392816', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('f0c0dac4455945d4287ca0a4504a46f5', '訾春柏', '1', 23, '17366392814', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('f273fd5972145fd39e768c4069ae3669', '单玄清', '2', 26, '17366392934', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f2d72da1a296d4c117ff4b5ed7a63f48', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f47406fa816845387bb828c7d3f1dce6', '寸白莲', '2', 23, '17366392936', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('f538821c5379f3f6207b967740f63131', '袭俊良', '2', 27, '17366393059', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f5f05e0a28f19bc617ef7be532d0b57e', '庄善和', '1', 23, '17366393057', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f6bdd6598aacdd5a94904397c3fe3b65', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f7736c882a3982de5ec4c99299179a20', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('f7b415deb7e4f8a67504066e28f74bec', '虎采珊', '2', 27, '17366392938', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('f89b5d93628c46048a429dea07cf8e7a', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('fa183c65954ff8a61ce678c899c7bf3f', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('fa267f8ea55e7e8687a3be8ef38e03e1', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('fb50f0ecb680a701d4bbdef66c95ea44', '司寇傲儿', '1', 27, '17366392817', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('fb870e08eee4aec477c2d68bce63b3bb', '双初然', '1', 27, '17366392932', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('fcdce1e1ccff31f368ac43db40281b6f', '恭瑜敏', '1', 26, '17366392813', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('fd0ccbfe8a05524c69ddcde7bfa35b6a', '诸嘉禧', '1', 28, '17366392933', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('fd5b82413d300972a965e4b768152e3b', '夹谷芸儿', '2', 28, '17366393060', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('fd88a07457f5ec867cab6fc72d5683a4', '叔雁露', '2', 28, '17366392812', NULL, '江苏省南京市', NULL, NULL, NULL, NULL);
INSERT INTO `sample_general` VALUES ('febc0ca737f60adf2cee3312c92b8985', '淦尔槐', '1', 23, '17366393056', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ff7464a5b6ffac7a19215e2afafd4231', '上官飞章', '2', 26, '17366393052', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
INSERT INTO `sample_general` VALUES ('ffbdea89651de56e3db73bfff01c8446', '亓官迎海', '1', 23, '17366392930', NULL, '江苏省南京市', '1', '2021-02-04 15:57:02', '1', '2021-02-04 15:57:02');
COMMIT;

-- ----------------------------
-- Table structure for sample_work_flow
-- ----------------------------
DROP TABLE IF EXISTS `sample_work_flow`;
CREATE TABLE `sample_work_flow` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '流程实例id',
  `leave_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请假类型',
  `start_date` datetime DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `reason` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '原因',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='流程示例';

-- ----------------------------
-- Records of sample_work_flow
-- ----------------------------
BEGIN;
INSERT INTO `sample_work_flow` VALUES ('0e1b6dd93535c9a3e0dc69c2e21a7a33', NULL, '1', '2021-01-29 22:43:00', '2021-01-29 22:43:00', '今天不想上班', '1', '2021-01-29 22:44:03', '1', '2021-01-29 22:44:03', NULL);
INSERT INTO `sample_work_flow` VALUES ('1926b9f7e8b30584cae2bb8a8ab4d3f9', NULL, '2', '2021-02-02 23:09:00', '2021-02-02 23:09:00', '昨天晚上加班到太晚，明天中午到公司', '1', '2021-02-02 23:11:51', '1', '2021-02-02 23:11:51', NULL);
INSERT INTO `sample_work_flow` VALUES ('41a48b3a809e0e91da71f7c03bd0a923', NULL, '2', '2021-01-18 08:00:00', '2021-01-18 18:00:00', '早上没起来', '1', '2021-01-18 12:59:40', '1', '2021-01-21 14:15:38', NULL);
INSERT INTO `sample_work_flow` VALUES ('570345ba9e47641ceb74abb927b3b620', NULL, '2', '2021-02-02 23:13:00', '2021-02-02 23:13:00', '今天帮同学家扛大白菜', '1', '2021-02-02 23:13:28', '1', '2021-02-02 23:13:28', NULL);
INSERT INTO `sample_work_flow` VALUES ('6280fcce665c070e2ceedd5b1c701f07', NULL, '2', '2021-01-16 13:00:00', '2021-01-16 18:00:00', '家里有事', '1', '2021-01-16 11:16:39', '1', '2021-01-16 11:16:39', NULL);
INSERT INTO `sample_work_flow` VALUES ('715edc6b5a64e9b626a34d8a415f3f41', NULL, '2', '2021-01-29 22:42:00', '2021-01-29 22:42:00', '朋友结婚', '1', '2021-01-29 22:43:33', '1', '2021-01-29 22:43:33', NULL);
INSERT INTO `sample_work_flow` VALUES ('935e1ff8d25d8c72b221883d3749ff91', NULL, '4', '2021-02-02 23:12:00', '2021-02-02 23:12:00', '中午吃的太多，坐着难受', '1', '2021-02-02 23:12:58', '1', '2021-02-02 23:12:58', NULL);
INSERT INTO `sample_work_flow` VALUES ('95760f367560fee920f2ba92193c50cc', NULL, '3', '2021-01-21 09:00:00', '2021-01-21 18:00:00', '生病了', '1', '2021-01-21 14:33:26', '1', '2021-01-21 14:33:26', NULL);
INSERT INTO `sample_work_flow` VALUES ('a36b4b99f3294d47013323cdae26c175', NULL, '2', '2021-01-29 22:43:00', '2021-01-29 22:43:00', '亲戚结婚', '1', '2021-01-29 22:43:48', '1', '2021-01-29 22:43:48', NULL);
INSERT INTO `sample_work_flow` VALUES ('c5b32f4693ad445b26c5a5493f404b21', NULL, '2', '2021-02-02 23:16:00', '2021-02-02 23:16:00', '我拣了一块钱，找了一天的警察叔叔', '1', '2021-02-02 23:16:17', '1', '2021-02-02 23:16:29', NULL);
INSERT INTO `sample_work_flow` VALUES ('cc51691988b08f1977b26e0feef1b365', NULL, '2', '2021-02-02 23:13:00', '2021-02-02 23:13:00', '我的几双袜子已经半个月没洗了，今天没的穿，只好在家呆着', '1', '2021-02-02 23:15:29', '1', '2021-02-02 23:15:29', NULL);
COMMIT;

-- ----------------------------
-- Table structure for scheduler_job
-- ----------------------------
DROP TABLE IF EXISTS `scheduler_job`;
CREATE TABLE `scheduler_job` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `cron` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'cron表达式',
  `bean` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'bean',
  `method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'method',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `version` int(10) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `edit_date` datetime DEFAULT NULL COMMENT '修改时间',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务代码',
  `last_run_date` datetime DEFAULT NULL COMMENT '上次执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='定时任务 ';

-- ----------------------------
-- Records of scheduler_job
-- ----------------------------
BEGIN;
INSERT INTO `scheduler_job` VALUES ('1', '示例任务1', '0/5 * * * * ? *', 'sampleJob', 'sampleJob1', 2, NULL, NULL, '126', '2019-05-12 09:36:10', '1', '2021-01-21 17:43:40', 'sample-job', '2021-01-21 22:02:15');
INSERT INTO `scheduler_job` VALUES ('2', '示例任务2', '0/10 * * * * ? *', 'sampleJob', 'sampleJob2', 2, NULL, NULL, '126', '2019-05-13 21:03:42', '126', '2019-05-13 21:03:42', 'sample-job-2', '2021-01-21 22:02:10');
INSERT INTO `scheduler_job` VALUES ('2c83db466678081d2d65a99d2cc5c140', '清理异常日志表里的数据', '0 0 0 1/1 * ? *', 'cleanExceptionLog', 'clean', 1, NULL, NULL, '126', '2019-06-27 09:27:28', '126', '2019-06-27 09:29:24', 'CleanExceptionLog', '2021-04-26 11:13:12');
INSERT INTO `scheduler_job` VALUES ('7a10407344e5c99a4423dca02c9e5b81', '清理访问日志表里的数据', '0 0 0 1/1 * ? *', 'cleanSysLog', 'clean', 1, NULL, NULL, '126', '2019-06-27 14:16:16', '126', '2019-11-05 21:00:05', 'CleanSysLog', '2021-04-26 11:13:12');
INSERT INTO `scheduler_job` VALUES ('d82d3da7ab2ad39a2b2065f950d68f5b', '清理临时目录文件', '0 0 0 1/1 * ? *', 'cleanTemporaryFile', 'clean', 1, NULL, NULL, '126', '2019-06-26 20:38:01', '126', '2019-06-26 21:26:44', 'CleanTemporaryFile', '2021-04-26 11:13:12');
COMMIT;

-- ----------------------------
-- Table structure for scheduler_job_log
-- ----------------------------
DROP TABLE IF EXISTS `scheduler_job_log`;
CREATE TABLE `scheduler_job_log` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `job_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务id',
  `run_date` datetime DEFAULT NULL COMMENT '执行时间',
  `time_consuming` int(10) DEFAULT NULL COMMENT '耗时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='定时任务执行日志';

-- ----------------------------
-- Records of scheduler_job_log
-- ----------------------------
BEGIN;
INSERT INTO `scheduler_job_log` VALUES ('195bc5bb0153ea94b9f3786d260782cf', '2c83db466678081d2d65a99d2cc5c140', '2021-04-26 11:13:12', 258);
INSERT INTO `scheduler_job_log` VALUES ('8a99130cdd0ac74d0540a1f052aa738f', '7a10407344e5c99a4423dca02c9e5b81', '2021-04-26 11:13:12', 208);
INSERT INTO `scheduler_job_log` VALUES ('dde4c8cd9e6120fdbc2aa0cd021ae039', 'd82d3da7ab2ad39a2b2065f950d68f5b', '2021-04-26 11:13:12', 163);
COMMIT;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `sys_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'key',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'value',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统参数';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` VALUES ('1', 'sessionInvalidateTime', '1800', 'session失效时间 单位：秒', 'number', '2019-03-03 16:06:49', '126', '2020-06-29 16:53:33', '126');
INSERT INTO `sys_config` VALUES ('14', 'projectName', 'Easy Frame', '系统名称', 'text', '2019-03-03 23:22:41', '126', '2020-12-11 18:06:40', '1');
INSERT INTO `sys_config` VALUES ('15', 'defaultPassword', '123', '新增用户时的默认密码', 'text', '2019-03-04 17:49:34', '126', '2019-05-05 21:49:23', '126');
INSERT INTO `sys_config` VALUES ('16', 'loginAttempts', '10', '登录时密码错误尝试次数，超过后会被账号会被锁定', 'number', '2019-03-04 21:23:30', '126', '2021-02-03 10:24:19', '1');
INSERT INTO `sys_config` VALUES ('18', 'openRegistration', 'true', '是否开启用户注册', 'boolean', '2019-03-23 09:22:58', '126', '2019-03-23 09:22:58', '126');
INSERT INTO `sys_config` VALUES ('20', 'loginMultipoint', 'true', '是否允许多地登录', 'boolean', '2019-03-27 13:38:32', '126', '2021-01-14 14:03:43', '1');
INSERT INTO `sys_config` VALUES ('21', 'passwordSecurityLevel', '2', '修改密码时密码的等级要求，分为0~5级，默认为3级', 'number', '2019-06-01 21:41:37', '126', '2020-12-22 14:14:23', '1');
INSERT INTO `sys_config` VALUES ('4', 'loginLockLength', '300', '尝试登录次数过多账号锁定时长 单位：秒', 'number', '2019-03-03 16:06:49', '126', '2019-03-04 17:47:22', '126');
INSERT INTO `sys_config` VALUES ('48bc9672ea38980c5031b86c73938690', 'cleanSysLog', '30', '清理多少天前访问日志 单位: 天', 'number', '2019-06-27 14:14:45', '126', '2019-06-27 14:14:45', '126');
INSERT INTO `sys_config` VALUES ('5', 'loginVerificationCode', 'false', '是否开启验证码', 'boolean', '2019-03-03 16:07:38', '126', '2021-02-03 10:59:42', '1');
INSERT INTO `sys_config` VALUES ('76474672180a3f83b87923c5bc9a86f9', 'messageCheckInterval', '60', '新消息检查间隔时长 单位：秒', 'number', '2019-06-18 22:34:10', '126', '2019-06-25 20:43:14', '126');
INSERT INTO `sys_config` VALUES ('9f20b7a0eb3757ed8c2b98af3148cc3b', 'messageExpire', '600', '短信验证码有效期 单位：秒', 'number', '2020-12-23 14:22:29', '1', '2021-01-14 13:45:51', '1');
INSERT INTO `sys_config` VALUES ('bec91595c56ef6d0d197b745ca6c855f', 'cleanExceptionLog', '7', '清理多少天前异常日志 单位: 天', 'number', '2019-06-27 09:21:12', '126', '2020-12-23 10:07:27', '1');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `p_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '全称',
  `simple_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简称',
  `code` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '机构代码',
  `type_code` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '机构类型代码',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁保留字段',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='机构';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` VALUES ('1', '0', 'EF科技', 'EF', '', '1', '1', '', 1, 1, '', NULL, '1', '2020-12-10 17:07:02');
INSERT INTO `sys_dept` VALUES ('1750cbea9db36f3ad6e6d995b2e4a0f9', '1', 'EF科技南京分公司', '南京', '', '1-1', '1', '', 1, NULL, '1', '2020-12-10 17:10:20', '1', '2020-12-11 18:08:33');
INSERT INTO `sys_dept` VALUES ('6336975fdd306a7a35cbdad37ae4dd9f', '1750cbea9db36f3ad6e6d995b2e4a0f9', '实施部', '', '', '1-1-1', '1', '', 2, NULL, '1', '2020-12-10 17:10:41', '1', '2020-12-10 17:13:03');
INSERT INTO `sys_dept` VALUES ('c830d4d5ebe7386ea64b1305569140a7', '1750cbea9db36f3ad6e6d995b2e4a0f9', '研发部', '', '', '1-1-1', '1', '', 1, NULL, '1', '2020-12-10 17:10:30', '1', '2020-12-10 17:12:58');
INSERT INTO `sys_dept` VALUES ('f77347d80fc809aa49c2cb9a1782cab5', '1', '研发部', '', '', '2', '1', '', 2, NULL, '1', '2020-12-10 17:12:25', '1', '2021-02-01 17:25:58');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_type`;
CREATE TABLE `sys_dept_type` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `p_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '代码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  `order_no` int(5) DEFAULT NULL,
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='机构类型';

-- ----------------------------
-- Records of sys_dept_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept_type` VALUES ('1', '0', '1', '总公司', '', '', NULL, '1', '2020-12-14 14:37:07', 7, '1');
INSERT INTO `sys_dept_type` VALUES ('85ff5b68422f932ce40b1e607ae69b3b', '1', '2', '部门', '', '1', '2020-12-10 17:11:58', '1', '2020-12-10 17:11:58', 5, '1');
INSERT INTO `sys_dept_type` VALUES ('90918a8e4ea8b8df43cb613016c80480', 'f61256accdb0db23118ee1538873579e', '1-1-1', '部门', '', '', '2020-12-10 15:50:52', '1', '2020-12-10 16:10:51', 6, '1');
INSERT INTO `sys_dept_type` VALUES ('f61256accdb0db23118ee1538873579e', '1', '1-1', '分公司', '', '', '2020-12-10 15:49:55', '1', '2020-12-10 16:10:47', 4, '1');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept_type_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_type_role`;
CREATE TABLE `sys_dept_type_role` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `dept_type_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门类型id',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='配置机构类型对应角色';

-- ----------------------------
-- Records of sys_dept_type_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept_type_role` VALUES ('1ef7bb857363c6a31e1748cf7f6bb960', 'f61256accdb0db23118ee1538873579e', '3');
INSERT INTO `sys_dept_type_role` VALUES ('34b028ce6bcc850250ee2a1fb6fa6b79', '1', '4');
INSERT INTO `sys_dept_type_role` VALUES ('48dbcd264a0f60e6f55cf6622ad607ef', '12460e7279fb86428a2e445a83ffab69', '4');
INSERT INTO `sys_dept_type_role` VALUES ('8f8e1b927ac52aaf80d10e3cd0eaf93b', '1', '65bdd699e5b623c8efec4eb74639bafc');
INSERT INTO `sys_dept_type_role` VALUES ('96f023d4ffef712cd137ff19bc04c932', '1', '0');
INSERT INTO `sys_dept_type_role` VALUES ('daf51ff46dcf1d41e4c2bfb340502e8c', '1', '920f6f953610571e740fc517e3c99899');
INSERT INTO `sys_dept_type_role` VALUES ('eeb6210df0a7a8498000b13d9b965fc7', '1', '3');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `order_no` int(5) DEFAULT NULL COMMENT '排序值',
  `p_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父code',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编码',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `dict_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典类型',
  `css` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'class',
  `icon` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict` VALUES ('04a9e2a9562a5714a9b1cd6fe1fdc55f', 1, '', '激活', '1', '', '1', 'suspensionState', 'green', NULL, '126', '2020-05-21 10:53:15', '126', '2020-05-22 13:26:10');
INSERT INTO `sys_dict` VALUES ('0e7da7a963cf78a28c94d05c95b2c382', 1, '', '年假', '1', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:15:25', '126', '2020-04-26 15:15:25');
INSERT INTO `sys_dict` VALUES ('1001', 1, '', '启用', '1', '', '1', 'permissionsStatus', 'green', NULL, '1', '2018-11-19 00:43:49', '126', '2020-06-06 22:06:20');
INSERT INTO `sys_dict` VALUES ('1002', 2, '', '禁用', '2', '', '1', 'permissionsStatus', 'red', NULL, '1', '2018-11-19 02:33:32', '1', '2018-11-19 03:06:59');
INSERT INTO `sys_dict` VALUES ('1003', 1, '', '启用', '1', '', '1', 'userStatus', 'green', NULL, '1', '2018-11-19 20:04:25', '1', '2018-11-19 20:05:50');
INSERT INTO `sys_dict` VALUES ('1004', 2, '', '禁用', '2', '', '1', 'userStatus', 'red', NULL, '1', '2018-11-19 20:05:36', '1', '2018-11-19 20:05:36');
INSERT INTO `sys_dict` VALUES ('1005', 3, '', '已删除', '0', '', '1', 'userStatus', 'red', NULL, '1', '2018-11-19 20:08:14', '126', '2019-05-26 12:45:47');
INSERT INTO `sys_dict` VALUES ('1006', 1, '', '启用', '1', '', '1', 'roleStatus', 'green', NULL, '1', '2018-11-19 20:09:01', '1', '2018-11-19 20:09:01');
INSERT INTO `sys_dict` VALUES ('1007', 2, '', '禁用', '2', '', '1', 'roleStatus', 'red', NULL, '1', '2018-11-19 20:09:18', '1', '2018-11-19 20:09:18');
INSERT INTO `sys_dict` VALUES ('1008', 1, '', '启用', '1', '', '1', 'commonStatus', 'green', NULL, '1', '2018-11-19 20:11:14', '1', '2018-11-19 20:11:14');
INSERT INTO `sys_dict` VALUES ('1009', 2, '', '禁用', '2', '', '1', 'commonStatus', 'red', NULL, '1', '2018-11-19 20:11:26', '1', '2018-11-19 20:11:26');
INSERT INTO `sys_dict` VALUES ('1014', 1, '', 'sys', 'sys', '', '1', 'module', '', NULL, '126', '2019-01-10 17:35:42', '126', '2019-01-10 17:35:42');
INSERT INTO `sys_dict` VALUES ('1015', 2, '', 'business', 'business', '', '1', 'module', '', NULL, '126', '2019-01-10 17:36:12', '126', '2019-01-10 17:36:12');
INSERT INTO `sys_dict` VALUES ('1016', 3, '', 'sample', 'sample', '', '1', 'module', '', NULL, '126', '2019-01-10 17:36:47', '126', '2019-01-10 17:36:47');
INSERT INTO `sys_dict` VALUES ('1017', 1, '', '默认（增/删/改/查）', 'default', '', '1', 'generatorTemplate', '', NULL, '126', '2019-01-11 12:54:21', '126', '2019-01-11 12:54:21');
INSERT INTO `sys_dict` VALUES ('1018', 3, '', '业务层+持久层', 'bizAndDao', '', '1', 'generatorTemplate', '', NULL, '126', '2019-01-11 13:05:34', '126', '2019-01-11 13:14:01');
INSERT INTO `sys_dict` VALUES ('1019', 4, '', '持久层', 'dao', '', '1', 'generatorTemplate', '', NULL, '126', '2019-01-11 13:05:55', '126', '2019-01-11 13:14:10');
INSERT INTO `sys_dict` VALUES ('1020', 2, '', '默认（仅查询）', 'defaultOnlySelect', '', '1', 'generatorTemplate', '', NULL, '126', '2019-01-11 13:06:50', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1021', 1, NULL, '=', 'eq', NULL, '1', 'matchingMode', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1022', 2, '', '!=', 'ne', '', '1', 'matchingMode', '', NULL, '126', '2019-01-11 15:18:06', '126', '2019-05-05 21:49:09');
INSERT INTO `sys_dict` VALUES ('1023', 3, NULL, '>', 'gt', NULL, '1', 'matchingMode', NULL, NULL, '126', '2019-01-11 15:18:06', '1', '2021-01-22 16:02:16');
INSERT INTO `sys_dict` VALUES ('1024', 4, NULL, '>=', 'gte', NULL, '1', 'matchingMode', NULL, NULL, '126', '2019-01-11 15:18:06', '1', '2021-01-22 16:02:24');
INSERT INTO `sys_dict` VALUES ('1025', 5, NULL, '<', 'lt', NULL, '1', 'matchingMode', NULL, NULL, '126', '2019-01-11 15:18:06', '1', '2021-01-22 16:02:32');
INSERT INTO `sys_dict` VALUES ('1026', 6, NULL, '<=', 'lte', NULL, '1', 'matchingMode', NULL, NULL, '126', '2019-01-11 15:18:06', '1', '2021-01-22 16:02:40');
INSERT INTO `sys_dict` VALUES ('1027', 7, NULL, 'like', 'like', NULL, '1', 'matchingMode', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1028', 8, NULL, '左 like', 'left_like', NULL, '1', 'matchingMode', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1029', 9, NULL, '右 like', 'right_like', NULL, '1', 'matchingMode', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1030', 1, NULL, '文本框', 'text', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1031', 5, NULL, '文本域', 'textarea', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1033', 2, NULL, '单选下拉框', 'select', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1035', 6, NULL, '单选框', 'radio', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1036', 7, NULL, '多选框', 'checkbox', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1037', 8, NULL, '日期', 'date', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1038', 9, NULL, '日期时间', 'datetime', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1039', 2, NULL, '两列', '2', NULL, '1', 'grid', NULL, NULL, '126', '2019-01-11 15:18:06', '1', '2021-01-22 23:48:26');
INSERT INTO `sys_dict` VALUES ('1040', 1, NULL, '一列', '1', NULL, '1', 'grid', NULL, NULL, '126', '2019-01-11 15:18:06', '1', '2021-01-22 23:48:08');
INSERT INTO `sys_dict` VALUES ('1045', 1, '', '必填', 'required', '', '2', 'verification', '', NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-12 21:09:37');
INSERT INTO `sys_dict` VALUES ('1046', 2, NULL, '电子邮件', 'email', NULL, '1', 'verification', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1047', 3, NULL, '网址', 'url', NULL, '1', 'verification', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1048', 4, NULL, '日期', 'date', NULL, '1', 'verification', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1049', 5, NULL, '日期 (YYYY-MM-DD)', 'dateISO', NULL, '1', 'verification', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1050', 6, NULL, '数字', 'number', NULL, '1', 'verification', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1051', 10, NULL, '密码', 'password', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1052', 11, NULL, '数字', 'number', NULL, '1', 'elementType', NULL, NULL, '126', '2019-01-11 15:18:06', '126', '2019-01-11 13:15:18');
INSERT INTO `sys_dict` VALUES ('1053', 1, '', 'account:', 'account:', '', '1', 'redisPrefix', '', NULL, '126', '2019-01-26 10:50:10', '126', '2019-01-26 10:50:10');
INSERT INTO `sys_dict` VALUES ('1054', 2, '', 'shiro:session:', 'shiro:session:', '', '1', 'redisPrefix', '', NULL, '126', '2019-01-26 10:51:58', '126', '2019-01-26 10:51:58');
INSERT INTO `sys_dict` VALUES ('1055', 3, '', 'shiro:authorization:', 'shiro:authorization:', '', '1', 'redisPrefix', '', NULL, '126', '2019-01-26 10:53:28', '126', '2019-01-26 10:53:28');
INSERT INTO `sys_dict` VALUES ('1056', 1, '', '数字', 'number', '', '1', 'dataType', '', NULL, '126', '2019-03-02 21:38:28', '126', '2019-03-02 21:38:28');
INSERT INTO `sys_dict` VALUES ('1057', 2, '', '字符串', 'text', '', '1', 'dataType', '', NULL, '126', '2019-03-02 21:38:40', '126', '2019-03-02 21:38:40');
INSERT INTO `sys_dict` VALUES ('1058', 3, '', '布尔值', 'boolean', '', '1', 'dataType', '', NULL, '126', '2019-03-02 21:46:51', '126', '2019-03-02 21:46:51');
INSERT INTO `sys_dict` VALUES ('1059', 4, '', 'sys:config:', 'sys:config:', '', '1', 'redisPrefix', '', NULL, '126', '2019-03-22 23:43:40', '126', '2019-05-26 20:25:16');
INSERT INTO `sys_dict` VALUES ('1060', 5, '', 'account:session:', 'account:session:', '当前会话尝试登录次数', '1', 'redisPrefix', '', NULL, '126', '2019-04-09 12:27:51', '126', '2019-04-09 12:27:51');
INSERT INTO `sys_dict` VALUES ('1061', 6, '', 'reset:password:verification:code:', 'reset:password:verification:code:', '', '1', 'redisPrefix', '', NULL, '126', '2019-04-09 12:29:01', '126', '2019-04-09 12:29:01');
INSERT INTO `sys_dict` VALUES ('1062', 1, '', '男', '1', '', '1', 'sex', 'blue', '', '126', '2019-04-09 12:34:55', '1', '2020-12-11 11:01:23');
INSERT INTO `sys_dict` VALUES ('1063', 2, '', '女', '2', '', '1', 'sex', 'pink', '', '126', '2019-04-09 12:35:02', '1', '2020-12-11 11:01:31');
INSERT INTO `sys_dict` VALUES ('1064', 4, '', 'import', 'import', '', '1', 'module', '', NULL, '126', '2019-04-10 15:50:30', '126', '2019-04-10 15:50:30');
INSERT INTO `sys_dict` VALUES ('1065', 1, '', '菜单', '1', '', '1', 'permissionsType', '', NULL, '126', '2019-04-17 21:22:59', '126', '2019-04-17 21:22:59');
INSERT INTO `sys_dict` VALUES ('1066', 2, '', '权限', '2', '', '1', 'permissionsType', '', NULL, '126', '2019-04-17 21:23:09', '126', '2019-04-17 21:23:09');
INSERT INTO `sys_dict` VALUES ('1067', 5, '', 'scheduler', 'scheduler', '', '1', 'module', '', NULL, '126', '2019-05-11 22:59:39', '126', '2019-05-11 22:59:39');
INSERT INTO `sys_dict` VALUES ('1068', 1, '', '开启', '1', '', '1', 'schedulerJobStatus', 'green', NULL, '126', '2019-05-12 10:12:32', '126', '2019-06-12 15:15:45');
INSERT INTO `sys_dict` VALUES ('1069', 2, '', '暂停', '2', '', '1', 'schedulerJobStatus', 'orange', NULL, '126', '2019-05-12 10:12:48', '126', '2019-05-12 10:16:36');
INSERT INTO `sys_dict` VALUES ('1070', 1, '', '主库', 'master', 'easy-frame', '1', 'dataSource', '', NULL, '126', '2019-05-16 21:41:52', '126', '2019-05-16 21:42:42');
INSERT INTO `sys_dict` VALUES ('1072', 1, '', '通知', 'notice', '', '1', 'messageType', 'blue', NULL, '126', '2019-06-07 23:18:55', '126', '2019-06-07 23:22:16');
INSERT INTO `sys_dict` VALUES ('1073', 2, '', '事件', 'event', '', '1', 'messageType', 'orange', NULL, '126', '2019-06-07 23:19:10', '126', '2019-06-07 23:22:23');
INSERT INTO `sys_dict` VALUES ('1074', 3, '', '日志', 'journal', '', '1', 'messageType', 'green', NULL, '126', '2019-06-07 23:19:25', '126', '2019-11-06 16:24:07');
INSERT INTO `sys_dict` VALUES ('1075', 1, NULL, '隐藏', '1', NULL, '1', 'hideMenu', NULL, NULL, '126', '2020-04-26 15:16:44', '126', '2020-04-26 15:16:44');
INSERT INTO `sys_dict` VALUES ('1076', 2, NULL, '显示', '0', NULL, '1', 'hideMenu', NULL, NULL, '126', '2020-04-26 15:16:44', '126', '2020-04-26 15:16:44');
INSERT INTO `sys_dict` VALUES ('12f5cb3d041e411380669ab5925f82be', 5, NULL, '高', '5', NULL, '1', 'passwordStrength', 'blue', NULL, '1', '2020-12-22 14:07:52', '1', '2020-12-22 14:07:52');
INSERT INTO `sys_dict` VALUES ('1760cfb5a2eea70a091a1f49801c16aa', 2, '', '用户审批', 'userTask', '', '1', 'activityType', 'orange', NULL, '126', '2020-05-07 20:01:47', '1', '2021-02-21 15:21:04');
INSERT INTO `sys_dict` VALUES ('19428ffc5b02c47c2bb958eb293b72fa', 3, NULL, 'save', 'save', NULL, '1', 'genMethod', NULL, NULL, '1', '2021-01-22 10:43:14', '1', '2021-01-22 10:43:14');
INSERT INTO `sys_dict` VALUES ('258aa110058920e3d25ab4a4f8c8606b', 1, NULL, 'model', 'model', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:45:27', '1', '2021-01-22 10:45:27');
INSERT INTO `sys_dict` VALUES ('2b9c81faded52d3c3f4753741b201d14', 3, '', '病假', '3', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:15:39', '126', '2020-04-26 15:15:39');
INSERT INTO `sys_dict` VALUES ('2cb335b11141e600e4b6afbcfcb38a91', 1, NULL, '当前页面', '1', NULL, '1', 'target', NULL, NULL, '1', '2021-01-04 10:23:18', '1', '2021-01-04 10:23:18');
INSERT INTO `sys_dict` VALUES ('2fa104fae1e7914ef3ec3c92b1e9435e', 3, NULL, 'mapping', 'mapping', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:45:43', '1', '2021-01-22 10:45:43');
INSERT INTO `sys_dict` VALUES ('3028aa52cd73fcb37264b14b3c2e2908', 8, NULL, 'Input.vue', 'Input.vue', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:46:32', '1', '2021-01-22 10:46:32');
INSERT INTO `sys_dict` VALUES ('397b3c02d8ea5e9e6b65316400312157', 2, '', '挂起', '2', '', '1', 'suspensionState', 'orange', NULL, '126', '2020-05-21 10:52:58', '126', '2020-05-22 13:26:14');
INSERT INTO `sys_dict` VALUES ('39a161672dd6fa4178a329698c830e0b', 3, NULL, '中', '3', NULL, '1', 'passwordStrength', 'green', NULL, '1', '2020-12-22 14:07:31', '1', '2020-12-22 14:07:31');
INSERT INTO `sys_dict` VALUES ('40a7017e155919c64a51e6c151971753', 8, '', '丧假', '8', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:16:27', '126', '2020-04-26 15:16:27');
INSERT INTO `sys_dict` VALUES ('438f09448b2ce4c6767245af8eb249ce', 4, NULL, '高', '4', NULL, '1', 'passwordStrength', 'cyan', NULL, '1', '2020-12-22 14:07:40', '1', '2020-12-22 14:07:40');
INSERT INTO `sys_dict` VALUES ('458cfa6224c1bd02ec544402b9a746b4', 2, '', '事假', '2', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:15:32', '126', '2020-04-26 15:15:32');
INSERT INTO `sys_dict` VALUES ('483277621a0e921fa0eed6c048096333', 3, '', '条件网关', 'exclusiveGateway', '', '1', 'activityType', 'orange', NULL, '126', '2020-05-07 20:00:20', '126', '2020-05-14 14:14:37');
INSERT INTO `sys_dict` VALUES ('4a05aea7b167e6d9cd0e74525579054d', 6, '', '陪产假', '6', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:16:00', '126', '2020-04-26 15:16:00');
INSERT INTO `sys_dict` VALUES ('4adcad08e2df1a9b91c11ee6ab88af1b', 7, NULL, 'List.vue', 'List.vue', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:46:23', '1', '2021-01-22 10:46:23');
INSERT INTO `sys_dict` VALUES ('4f96ea5fbc3529db7cf3f8a262dace6a', 5, NULL, '导出数据', 'exportData', NULL, '1', 'genMethod', NULL, NULL, '1', '2021-02-23 09:35:30', '1', '2021-02-23 09:35:30');
INSERT INTO `sys_dict` VALUES ('62936bbf418a384f442a519b40e55e4f', 9, NULL, 'api.js', 'api.js', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:46:48', '1', '2021-01-22 10:46:48');
INSERT INTO `sys_dict` VALUES ('64c22620aba0d2ad61346d8be1a3fb7d', 2, '', '已撤销', '-1', '', '1', 'taskStatus', 'orange', NULL, '126', '2020-05-22 21:46:51', '126', '2020-05-22 21:46:51');
INSERT INTO `sys_dict` VALUES ('66b935e4c514ecd0c1e2572368f74161', 2, NULL, 'dao', 'dao', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:45:34', '1', '2021-01-22 10:45:34');
INSERT INTO `sys_dict` VALUES ('684149de7513dbf9b34784a754bd923f', 2, NULL, '低', '2', NULL, '1', 'passwordStrength', 'orange', NULL, '1', '2020-12-22 14:07:12', '1', '2020-12-22 14:07:12');
INSERT INTO `sys_dict` VALUES ('6b19039d2e3144bf3ab7ea4b87ca75c0', 1, NULL, 'true', 'true', NULL, '1', 'boolean', NULL, NULL, '1', '2021-01-14 13:55:29', '1', '2021-01-14 13:55:29');
INSERT INTO `sys_dict` VALUES ('6b7e8cfb87c04ed395ec5ea64b9fa48d', 6, NULL, 'controller', 'controller', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:46:11', '1', '2021-01-22 10:46:11');
INSERT INTO `sys_dict` VALUES ('782b05bc86650ebee8e0a63511117b81', 10, '', '流程结束', 'endEvent', '', '1', 'activityType', 'blue', NULL, '126', '2020-05-07 20:03:06', '126', '2020-05-14 14:12:17');
INSERT INTO `sys_dict` VALUES ('81a9fe5b6ea8e48e9e277bbe002ed729', 4, '', '调休', '4', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:15:45', '126', '2020-04-26 15:15:45');
INSERT INTO `sys_dict` VALUES ('82a5eff09f8c6d937fb6bfb13efed39b', 6, NULL, '导入数据', 'importData', NULL, '1', 'genMethod', NULL, NULL, '1', '2021-02-23 09:35:42', '1', '2021-02-23 09:35:42');
INSERT INTO `sys_dict` VALUES ('901e8d61eeb73a96822997e15064776c', 1, NULL, '低', '1', NULL, '1', 'passwordStrength', 'red', NULL, '1', '2020-12-22 14:07:03', '1', '2020-12-22 14:07:03');
INSERT INTO `sys_dict` VALUES ('9a072d4f0f483abc6b2621a8257ff65d', 4, NULL, 'service', 'service', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:45:51', '1', '2021-01-22 10:45:51');
INSERT INTO `sys_dict` VALUES ('9d4641ff43b7b60a1a9d78f660926309', 9, '', '产检假', '9', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:16:36', '126', '2020-04-26 15:16:36');
INSERT INTO `sys_dict` VALUES ('9e1a3416550ac3582ea0b28fe8f8d607', 2, NULL, 'false', 'false', NULL, '1', 'boolean', NULL, NULL, '1', '2021-01-14 13:55:37', '1', '2021-01-14 13:55:37');
INSERT INTO `sys_dict` VALUES ('a700a0725ed3818b5d5e06ebcbdbdc7a', 5, '', '产假', '5', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:15:52', '126', '2020-04-26 15:15:52');
INSERT INTO `sys_dict` VALUES ('b88be5998e52644275e558cb27605e6d', 3, '', '已办结', '2', '', '1', 'taskStatus', 'green', NULL, '126', '2020-05-22 21:47:03', '126', '2020-05-22 21:47:03');
INSERT INTO `sys_dict` VALUES ('b8de17a629fc368aa9d5060b6961b93d', 8, '', '流程发起', 'startEvent', '', '1', 'activityType', 'green', '', '126', '2020-05-07 20:01:33', '1', '2020-12-08 17:20:22');
INSERT INTO `sys_dict` VALUES ('bc64972ab051639909c486eee09284ae', 1, NULL, 'add', 'add', NULL, '1', 'genMethod', NULL, NULL, '1', '2021-01-22 10:42:55', '1', '2021-01-22 10:42:55');
INSERT INTO `sys_dict` VALUES ('ca12852b5dc75f5c18eff0cf9fbfaea8', 7, '', '婚假', '7', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:16:08', '126', '2020-04-26 15:16:08');
INSERT INTO `sys_dict` VALUES ('d06fe9ab7a91394f2884e549e76d1f0b', 2, NULL, 'remove', 'remove', NULL, '1', 'genMethod', NULL, NULL, '1', '2021-01-22 10:43:07', '1', '2021-01-22 10:43:07');
INSERT INTO `sys_dict` VALUES ('dcf701520b55e0381436c1fed7fe57cf', 1, '', '办理中', '1', '', '1', 'taskStatus', 'blue', NULL, '126', '2020-05-22 21:44:17', '126', '2020-05-22 21:44:17');
INSERT INTO `sys_dict` VALUES ('e5a370445b0d81b6bde90ba1e7533039', 4, NULL, 'select', 'select', NULL, '1', 'genMethod', NULL, NULL, '1', '2021-01-22 10:43:21', '1', '2021-01-22 10:43:21');
INSERT INTO `sys_dict` VALUES ('e71e1827d384550145ca83cd1140f3b0', 10, '', '特殊工伤假', '10', '', '1', 'leaveType', '', NULL, '126', '2020-04-26 15:16:44', '126', '2020-04-26 15:16:44');
INSERT INTO `sys_dict` VALUES ('e75b3cf8a6ab33fe9c6e8a3c3fd50130', 2, NULL, '新建标签页', '2', NULL, '1', 'target', NULL, NULL, '1', '2021-01-04 10:23:31', '1', '2021-01-04 10:23:31');
INSERT INTO `sys_dict` VALUES ('f2fb2f1aa7d82d3869e7a3c69307f6c9', 5, NULL, 'serviceImpl', 'serviceImpl', NULL, '1', 'genFile', NULL, NULL, '1', '2021-01-22 10:45:59', '1', '2021-01-22 10:45:59');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类别名称',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典类别',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典类别';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_type` VALUES ('1', '权限/菜单状态', 'permissionsStatus', '1');
INSERT INTO `sys_dict_type` VALUES ('13', '代码生成-模块名称', 'module', '1');
INSERT INTO `sys_dict_type` VALUES ('14', '代码生成-生成模板', 'generatorTemplate', '1');
INSERT INTO `sys_dict_type` VALUES ('14b305d91fdb4244768204810366e631', '代码生成-生成方法', 'genMethod', '1');
INSERT INTO `sys_dict_type` VALUES ('15', '匹配方式', 'matchingMode', '1');
INSERT INTO `sys_dict_type` VALUES ('16', '元素类型', 'elementType', '1');
INSERT INTO `sys_dict_type` VALUES ('17', '栅格', 'grid', '1');
INSERT INTO `sys_dict_type` VALUES ('18', '字段验证', 'verification', '1');
INSERT INTO `sys_dict_type` VALUES ('19', 'redis前缀', 'redisPrefix', '1');
INSERT INTO `sys_dict_type` VALUES ('2', '用户状态', 'userStatus', '1');
INSERT INTO `sys_dict_type` VALUES ('20', '数据类型', 'dataType', '1');
INSERT INTO `sys_dict_type` VALUES ('21', '主题', 'themes', '1');
INSERT INTO `sys_dict_type` VALUES ('22', '提示类型', 'tipType', '1');
INSERT INTO `sys_dict_type` VALUES ('23', '性别', 'sex', '1');
INSERT INTO `sys_dict_type` VALUES ('24', '权限类型', 'permissionsType', '1');
INSERT INTO `sys_dict_type` VALUES ('25', '任务状态', 'schedulerJobStatus', '1');
INSERT INTO `sys_dict_type` VALUES ('26', '数据源', 'dataSource', '1');
INSERT INTO `sys_dict_type` VALUES ('27', '消息类型', 'messageType', '1');
INSERT INTO `sys_dict_type` VALUES ('28', '隐藏菜单', 'hideMenu', '1');
INSERT INTO `sys_dict_type` VALUES ('7', '通用状态', 'commonStatus', '1');
INSERT INTO `sys_dict_type` VALUES ('7ad24fca207295e81f5b501a11d00ea2', '打开方式', 'target', '1');
INSERT INTO `sys_dict_type` VALUES ('8', '角色状态', 'roleStatus', '1');
INSERT INTO `sys_dict_type` VALUES ('86d9858565d0664c3f7eaba933e1de3a', '密码强度', 'passwordStrength', '1');
INSERT INTO `sys_dict_type` VALUES ('8b8e774ad38daa1cad3b0aa14217c735', '请假类型', 'leaveType', '1');
INSERT INTO `sys_dict_type` VALUES ('9', '角色类型', 'roleType', '1');
INSERT INTO `sys_dict_type` VALUES ('a088b7c12020ea213c103c938f0d33ec', '任务状态', 'taskStatus', '1');
INSERT INTO `sys_dict_type` VALUES ('a8ef4b74ef87817d67e5fcf91c985ea7', '代码生成-生成文件', 'genFile', '1');
INSERT INTO `sys_dict_type` VALUES ('c079e48f535aa6478e64c861ec2fbc1a', '流程状态', 'suspensionState', '1');
INSERT INTO `sys_dict_type` VALUES ('dcc19ea57aa468ae96fd7f5f76f58e45', '活动类型', 'activityType', '1');
INSERT INTO `sys_dict_type` VALUES ('ed2090fc0b2a27f70456eef5e4fafa25', '测试', 'test', '1');
INSERT INTO `sys_dict_type` VALUES ('f645e5b01c77c004905673b97c091c93', 'boolean', 'boolean', '1');
COMMIT;

-- ----------------------------
-- Table structure for sys_district
-- ----------------------------
DROP TABLE IF EXISTS `sys_district`;
CREATE TABLE `sys_district` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(270) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `p_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父 ID',
  `initial` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '拼音首字母',
  `initials` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '拼音首字母集合',
  `pinyin` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '拼音',
  `extra` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '附加说明',
  `suffix` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '行政级别',
  `code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '行政代码',
  `area_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '区号',
  `order_no` int(2) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='行政区划';

-- ----------------------------
-- Records of sys_district
-- ----------------------------
BEGIN;
INSERT INTO `sys_district` VALUES ('1', '北京', '0', 'b', 'bj', 'beijing', '', '市', '110000', '010', 1);
INSERT INTO `sys_district` VALUES ('10', '黑龙江', '0', 'h', 'hlj', 'heilongjiang', '', '省', '230000', '', 11);
INSERT INTO `sys_district` VALUES ('100', '黔江', '4', 'q', 'qj', 'qianjiang', '', '区', '500114', '023', 14);
INSERT INTO `sys_district` VALUES ('1000', '太子河', '168', 't', 'tzh', 'taizihe', '', '区', '211110', '0419', 7);
INSERT INTO `sys_district` VALUES ('1001', '双台子', '169', 's', 'stz', 'shuangtaizi', '', '区', '211103', '0427', 1);
INSERT INTO `sys_district` VALUES ('1002', '兴隆台', '169', 'x', 'xlt', 'xinglongtai', '', '区', '211103', '0427', 2);
INSERT INTO `sys_district` VALUES ('1003', '大洼', '169', 'd', 'dw', 'dawa', '', '区', '211121', '0427', 3);
INSERT INTO `sys_district` VALUES ('1004', '盘山', '169', 'p', 'ps', 'panshan', '', '县', '211122', '0427', 4);
INSERT INTO `sys_district` VALUES ('1005', '银州', '170', 'y', 'yz', 'yinzhou', '', '区', '211202', '0410', 1);
INSERT INTO `sys_district` VALUES ('1006', '清河', '170', 'q', 'qh', 'qinghe', '', '区', '211204', '0410', 2);
INSERT INTO `sys_district` VALUES ('1007', '铁岭', '170', 't', 'tl', 'tieling', '', '县', '211221', '0410', 3);
INSERT INTO `sys_district` VALUES ('1008', '西丰', '170', 'x', 'xf', 'xifeng', '', '县', '211223', '0410', 4);
INSERT INTO `sys_district` VALUES ('1009', '昌图', '170', 'c', 'ct', 'changtu', '', '县', '211224', '0410', 5);
INSERT INTO `sys_district` VALUES ('101', '长寿', '4', 'z', 'zs', 'zhangshou', '', '区', '500115', '023', 15);
INSERT INTO `sys_district` VALUES ('1010', '调兵山', '170', 'd', 'dbs', 'diaobingshan', '', '市', '211281', '0410', 6);
INSERT INTO `sys_district` VALUES ('1011', '开原', '170', 'k', 'ky', 'kaiyuan', '', '市', '211282', '0410', 7);
INSERT INTO `sys_district` VALUES ('1012', '双塔', '171', 's', 'st', 'shuangta', '', '区', '211302', '0421', 1);
INSERT INTO `sys_district` VALUES ('1013', '龙城', '171', 'l', 'lc', 'longcheng', '', '区', '211303', '0421', 2);
INSERT INTO `sys_district` VALUES ('1014', '朝阳', '171', 'c', 'cy', 'chaoyang', '', '县', '211321', '0421', 3);
INSERT INTO `sys_district` VALUES ('1015', '建平', '171', 'j', 'jp', 'jianping', '', '县', '211322', '0421', 4);
INSERT INTO `sys_district` VALUES ('1016', '喀喇沁左翼', '171', 'k', 'klqzy', 'kalaqinzuoyi', '蒙古族', '自治县', '211324', '0421', 5);
INSERT INTO `sys_district` VALUES ('1017', '北票', '171', 'b', 'bp', 'beipiao', '', '市', '211381', '0421', 6);
INSERT INTO `sys_district` VALUES ('1018', '凌源', '171', 'l', 'ly', 'lingyuan', '', '市', '211382', '0421', 7);
INSERT INTO `sys_district` VALUES ('1019', '连山', '172', 'l', 'ls', 'lianshan', '', '区', '211402', '0429', 1);
INSERT INTO `sys_district` VALUES ('102', '江津', '4', 'j', 'jj', 'jiangjin', '', '区', '500116', '023', 16);
INSERT INTO `sys_district` VALUES ('1020', '龙港', '172', 'l', 'lg', 'longgang', '', '区', '211403', '0429', 2);
INSERT INTO `sys_district` VALUES ('1021', '南票', '172', 'n', 'np', 'nanpiao', '', '区', '211404', '0429', 3);
INSERT INTO `sys_district` VALUES ('1022', '绥中', '172', 's', 'sz', 'suizhong', '', '县', '211421', '0429', 4);
INSERT INTO `sys_district` VALUES ('1023', '建昌', '172', 'j', 'jc', 'jianchang', '', '县', '211422', '0429', 5);
INSERT INTO `sys_district` VALUES ('1024', '兴城', '172', 'x', 'xc', 'xingcheng', '', '市', '211481', '0429', 6);
INSERT INTO `sys_district` VALUES ('1025', '南关', '173', 'n', 'ng', 'nanguan', '', '区', '220102', '0431', 1);
INSERT INTO `sys_district` VALUES ('1026', '宽城', '173', 'k', 'kc', 'kuancheng', '', '区', '220103', '0431', 2);
INSERT INTO `sys_district` VALUES ('1027', '朝阳', '173', 'c', 'cy', 'chaoyang', '', '区', '220104', '0431', 3);
INSERT INTO `sys_district` VALUES ('1028', '二道', '173', 'e', 'ed', 'erdao', '', '区', '220105', '0431', 4);
INSERT INTO `sys_district` VALUES ('1029', '绿园', '173', 'l', 'ly', 'lu:yuan', '', '区', '220106', '0431', 5);
INSERT INTO `sys_district` VALUES ('103', '合川', '4', 'h', 'hc', 'hechuan', '', '区', '500117', '023', 17);
INSERT INTO `sys_district` VALUES ('1030', '双阳', '173', 's', 'sy', 'shuangyang', '', '区', '220112', '0431', 6);
INSERT INTO `sys_district` VALUES ('1031', '农安', '173', 'n', 'na', 'nongan', '', '县', '220122', '0431', 8);
INSERT INTO `sys_district` VALUES ('1032', '九台', '173', 'j', 'jt', 'jiutai', '', '区', '220113', '0431', 7);
INSERT INTO `sys_district` VALUES ('1033', '榆树', '173', 'y', 'ys', 'yushu', '', '市', '220182', '0431', 9);
INSERT INTO `sys_district` VALUES ('1034', '德惠', '173', 'd', 'dh', 'dehui', '', '市', '220183', '0431', 10);
INSERT INTO `sys_district` VALUES ('1035', '昌邑', '174', 'c', 'cy', 'changyi', '', '区', '220202', '0432', 1);
INSERT INTO `sys_district` VALUES ('1036', '龙潭', '174', 'l', 'lt', 'longtan', '', '区', '220203', '0432', 2);
INSERT INTO `sys_district` VALUES ('1037', '船营', '174', 'c', 'cy', 'chuanying', '', '区', '220204', '0432', 3);
INSERT INTO `sys_district` VALUES ('1038', '丰满', '174', 'f', 'fm', 'fengman', '', '区', '220211', '0432', 4);
INSERT INTO `sys_district` VALUES ('1039', '永吉', '174', 'y', 'yj', 'yongji', '', '县', '220221', '0432', 5);
INSERT INTO `sys_district` VALUES ('104', '永川', '4', 'y', 'yc', 'yongchuan', '', '区', '500118', '023', 18);
INSERT INTO `sys_district` VALUES ('1040', '桦甸', '174', 'h', 'hd', 'huadian', '', '市', '220281', '0432', 6);
INSERT INTO `sys_district` VALUES ('1041', '蛟河', '174', 'j', 'jh', 'jiaohe', '', '市', '220282', '0432', 7);
INSERT INTO `sys_district` VALUES ('1042', '舒兰', '174', 's', 'sl', 'shulan', '', '市', '220283', '0432', 8);
INSERT INTO `sys_district` VALUES ('1043', '磐石', '174', 'p', 'ps', 'panshi', '', '市', '220284', '0432', 9);
INSERT INTO `sys_district` VALUES ('1044', '铁西', '175', 't', 'tx', 'tiexi', '', '区', '220302', '0434', 1);
INSERT INTO `sys_district` VALUES ('1045', '铁东', '175', 't', 'td', 'tiedong', '', '区', '220303', '0434', 2);
INSERT INTO `sys_district` VALUES ('1046', '梨树', '175', 'l', 'ls', 'lishu', '', '县', '220322', '0434', 3);
INSERT INTO `sys_district` VALUES ('1047', '伊通', '175', 'y', 'yt', 'yitong', '满族', '自治县', '220323', '0434', 4);
INSERT INTO `sys_district` VALUES ('1048', '公主岭', '175', 'g', 'gzl', 'gongzhuling', '', '市', '220381', '0434', 5);
INSERT INTO `sys_district` VALUES ('1049', '双辽', '175', 's', 'sl', 'shuangliao', '', '市', '220382', '0434', 6);
INSERT INTO `sys_district` VALUES ('105', '南川', '4', 'n', 'nc', 'nanchuan', '', '区', '500119', '023', 19);
INSERT INTO `sys_district` VALUES ('1050', '龙山', '176', 'l', 'ls', 'longshan', '', '区', '220402', '0437', 1);
INSERT INTO `sys_district` VALUES ('1051', '西安', '176', 'x', 'xa', 'xian', '', '区', '220403', '0437', 2);
INSERT INTO `sys_district` VALUES ('1052', '东丰', '176', 'd', 'df', 'dongfeng', '', '县', '220421', '0437', 3);
INSERT INTO `sys_district` VALUES ('1053', '东辽', '176', 'd', 'dl', 'dongliao', '', '县', '220422', '0437', 4);
INSERT INTO `sys_district` VALUES ('1054', '东昌', '177', 'd', 'dc', 'dongchang', '', '区', '220502', '0435', 1);
INSERT INTO `sys_district` VALUES ('1055', '二道江', '177', 'e', 'edj', 'erdaojiang', '', '区', '220503', '0435', 2);
INSERT INTO `sys_district` VALUES ('1056', '通化', '177', 't', 'th', 'tonghua', '', '县', '220521', '0435', 3);
INSERT INTO `sys_district` VALUES ('1057', '辉南', '177', 'h', 'hn', 'huinan', '', '县', '220523', '0435', 4);
INSERT INTO `sys_district` VALUES ('1058', '柳河', '177', 'l', 'lh', 'liuhe', '', '县', '220524', '0435', 5);
INSERT INTO `sys_district` VALUES ('1059', '梅河口', '177', 'm', 'mhk', 'meihekou', '', '市', '220581', '0435', 6);
INSERT INTO `sys_district` VALUES ('106', '潼南', '4', 't', 'tn', 'tongnan', '', '区', '500223', '023', 22);
INSERT INTO `sys_district` VALUES ('1060', '集安', '177', 'j', 'ja', 'jian', '', '市', '220582', '0435', 7);
INSERT INTO `sys_district` VALUES ('1061', '浑江', '178', 'h', 'hj', 'hunjiang', '', '区', '220602', '0439', 1);
INSERT INTO `sys_district` VALUES ('1062', '江源', '178', 'j', 'jy', 'jiangyuan', '', '区', '220604', '0439', 2);
INSERT INTO `sys_district` VALUES ('1063', '抚松', '178', 'f', 'fs', 'fusong', '', '县', '220621', '0439', 3);
INSERT INTO `sys_district` VALUES ('1064', '靖宇', '178', 'j', 'jy', 'jingyu', '', '县', '220622', '0439', 4);
INSERT INTO `sys_district` VALUES ('1065', '长白', '178', 'z', 'zb', 'zhangbai', '朝鲜族', '自治县', '220623', '0439', 5);
INSERT INTO `sys_district` VALUES ('1066', '临江', '178', 'l', 'lj', 'linjiang', '', '市', '220681', '0439', 6);
INSERT INTO `sys_district` VALUES ('1067', '宁江', '179', 'n', 'nj', 'ningjiang', '', '区', '220702', '0438', 1);
INSERT INTO `sys_district` VALUES ('1068', '前郭尔罗斯', '179', 'q', 'qgels', 'qianguoerluosi', '蒙古族', '自治县', '220721', '0438', 2);
INSERT INTO `sys_district` VALUES ('1069', '长岭', '179', 'z', 'zl', 'zhangling', '', '县', '220722', '0438', 3);
INSERT INTO `sys_district` VALUES ('107', '铜梁', '4', 't', 'tl', 'tongliang', '', '区', '500151', '023', 21);
INSERT INTO `sys_district` VALUES ('1070', '乾安', '179', 'q', 'qa', 'qianan', '', '县', '220723', '0438', 4);
INSERT INTO `sys_district` VALUES ('1071', '扶余', '179', 'f', 'fy', 'fuyu', '', '市', '220724', '0438', 5);
INSERT INTO `sys_district` VALUES ('1072', '洮北', '180', 't', 'tb', 'taobei', '', '区', '220802', '0436', 1);
INSERT INTO `sys_district` VALUES ('1073', '镇赉', '180', 'z', 'zl', 'zhenlai', '', '县', '220821', '0436', 2);
INSERT INTO `sys_district` VALUES ('1074', '洮南', '180', 't', 'tn', 'taonan', '', '市', '220881', '0436', 4);
INSERT INTO `sys_district` VALUES ('1075', '大安', '180', 'd', 'da', 'daan', '', '市', '220882', '0436', 5);
INSERT INTO `sys_district` VALUES ('1076', '通榆', '180', 't', 'ty', 'tongyu', '', '县', '220822', '0436', 3);
INSERT INTO `sys_district` VALUES ('1077', '延吉', '181', 'y', 'yj', 'yanji', '', '市', '222401', '0433', 1);
INSERT INTO `sys_district` VALUES ('1078', '图们', '181', 't', 'tm', 'tumen', '', '市', '222402', '0433', 2);
INSERT INTO `sys_district` VALUES ('1079', '敦化', '181', 'd', 'dh', 'dunhua', '', '市', '222403', '0433', 3);
INSERT INTO `sys_district` VALUES ('108', '荣昌', '4', 'r', 'rc', 'rongchang', '', '区', '500226', '023', 23);
INSERT INTO `sys_district` VALUES ('1080', '珲春', '181', 'h', 'hc', 'hunchun', '', '市', '222404', '0433', 4);
INSERT INTO `sys_district` VALUES ('1081', '龙井', '181', 'l', 'lj', 'longjing', '', '市', '222405', '0433', 5);
INSERT INTO `sys_district` VALUES ('1082', '和龙', '181', 'h', 'hl', 'helong', '', '市', '222406', '0433', 6);
INSERT INTO `sys_district` VALUES ('1083', '汪清', '181', 'w', 'wq', 'wangqing', '', '县', '222424', '0433', 7);
INSERT INTO `sys_district` VALUES ('1084', '安图', '181', 'a', 'at', 'antu', '', '县', '222426', '0433', 8);
INSERT INTO `sys_district` VALUES ('1085', '道里', '182', 'd', 'dl', 'daoli', '', '区', '230102', '0451', 1);
INSERT INTO `sys_district` VALUES ('1086', '南岗', '182', 'n', 'ng', 'nangang', '', '区', '230103', '0451', 2);
INSERT INTO `sys_district` VALUES ('1087', '道外', '182', 'd', 'dw', 'daowai', '', '区', '230104', '0451', 3);
INSERT INTO `sys_district` VALUES ('1088', '平房', '182', 'p', 'pf', 'pingfang', '', '区', '230108', '0451', 4);
INSERT INTO `sys_district` VALUES ('1089', '松北', '182', 's', 'sb', 'songbei', '', '区', '230109', '0451', 5);
INSERT INTO `sys_district` VALUES ('109', '璧山', '4', 'b', 'bs', 'bishan', '', '区', '500120', '023', 20);
INSERT INTO `sys_district` VALUES ('1090', '香坊', '182', 'x', 'xf', 'xiangfang', '', '区', '230110', '0451', 6);
INSERT INTO `sys_district` VALUES ('1091', '呼兰', '182', 'h', 'hl', 'hulan', '', '区', '230111', '0451', 7);
INSERT INTO `sys_district` VALUES ('1092', '阿城', '182', 'a', 'ac', 'acheng', '', '区', '230112', '0451', 8);
INSERT INTO `sys_district` VALUES ('1093', '依兰', '182', 'y', 'yl', 'yilan', '', '县', '230123', '0451', 9);
INSERT INTO `sys_district` VALUES ('1094', '方正', '182', 'f', 'fz', 'fangzheng', '', '县', '230124', '0451', 10);
INSERT INTO `sys_district` VALUES ('1095', '宾县', '182', 'b', 'bx', 'binxian', '', '', '230125', '0451', 11);
INSERT INTO `sys_district` VALUES ('1096', '巴彦', '182', 'b', 'by', 'bayan', '', '县', '230126', '0451', 12);
INSERT INTO `sys_district` VALUES ('1097', '木兰', '182', 'm', 'ml', 'mulan', '', '县', '230127', '0451', 13);
INSERT INTO `sys_district` VALUES ('1098', '通河', '182', 't', 'th', 'tonghe', '', '县', '230128', '0451', 14);
INSERT INTO `sys_district` VALUES ('1099', '延寿', '182', 'y', 'ys', 'yanshou', '', '县', '230129', '0451', 15);
INSERT INTO `sys_district` VALUES ('11', '江苏', '0', 'j', 'js', 'jiangsu', '', '省', '320000', '', 12);
INSERT INTO `sys_district` VALUES ('110', '梁平', '4', 'l', 'lp', 'liangping', '', '区', '500228', '023', 24);
INSERT INTO `sys_district` VALUES ('1100', '双城', '182', 's', 'sc', 'shuangcheng', '', '区', '230182', '0451', 16);
INSERT INTO `sys_district` VALUES ('1101', '尚志', '182', 's', 'sz', 'shangzhi', '', '市', '230183', '0451', 17);
INSERT INTO `sys_district` VALUES ('1102', '五常', '182', 'w', 'wc', 'wuchang', '', '市', '230184', '0451', 18);
INSERT INTO `sys_district` VALUES ('1103', '龙沙', '183', 'l', 'ls', 'longsha', '', '区', '230202', '0452', 1);
INSERT INTO `sys_district` VALUES ('1104', '建华', '183', 'j', 'jh', 'jianhua', '', '区', '230203', '0452', 2);
INSERT INTO `sys_district` VALUES ('1105', '铁锋', '183', 't', 'tf', 'tiefeng', '', '区', '230204', '0452', 3);
INSERT INTO `sys_district` VALUES ('1106', '昂昂溪', '183', 'a', 'aax', 'angangxi', '', '区', '230205', '0452', 4);
INSERT INTO `sys_district` VALUES ('1107', '富拉尔基', '183', 'f', 'flej', 'fulaerji', '', '区', '230206', '0452', 5);
INSERT INTO `sys_district` VALUES ('1108', '碾子山', '183', 'n', 'nzs', 'nianzishan', '', '区', '230207', '0452', 6);
INSERT INTO `sys_district` VALUES ('1109', '梅里斯', '183', 'm', 'mls', 'meilisi', '达斡尔族', '区', '230208', '0452', 7);
INSERT INTO `sys_district` VALUES ('111', '城口', '4', 'c', 'ck', 'chengkou', '', '县', '500229', '023', 25);
INSERT INTO `sys_district` VALUES ('1110', '龙江', '183', 'l', 'lj', 'longjiang', '', '县', '230221', '0452', 8);
INSERT INTO `sys_district` VALUES ('1111', '依安', '183', 'y', 'ya', 'yian', '', '县', '230223', '0452', 9);
INSERT INTO `sys_district` VALUES ('1112', '泰来', '183', 't', 'tl', 'tailai', '', '县', '230224', '0452', 10);
INSERT INTO `sys_district` VALUES ('1113', '甘南', '183', 'g', 'gn', 'gannan', '', '县', '230225', '0452', 11);
INSERT INTO `sys_district` VALUES ('1114', '富裕', '183', 'f', 'fy', 'fuyu', '', '县', '230227', '0452', 12);
INSERT INTO `sys_district` VALUES ('1115', '克山', '183', 'k', 'ks', 'keshan', '', '县', '230229', '0452', 13);
INSERT INTO `sys_district` VALUES ('1116', '克东', '183', 'k', 'kd', 'kedong', '', '县', '230230', '0452', 14);
INSERT INTO `sys_district` VALUES ('1117', '拜泉', '183', 'b', 'bq', 'baiquan', '', '县', '230231', '0452', 15);
INSERT INTO `sys_district` VALUES ('1118', '讷河', '183', 'n', 'nh', 'nehe', '', '市', '230281', '0452', 16);
INSERT INTO `sys_district` VALUES ('1119', '鸡冠', '184', 'j', 'jg', 'jiguan', '', '区', '230302', '0467', 1);
INSERT INTO `sys_district` VALUES ('112', '丰都', '4', 'f', 'fd', 'fengdu', '', '县', '500230', '023', 26);
INSERT INTO `sys_district` VALUES ('1120', '恒山', '184', 'h', 'hs', 'hengshan', '', '区', '230303', '0467', 2);
INSERT INTO `sys_district` VALUES ('1121', '滴道', '184', 'd', 'dd', 'didao', '', '区', '230304', '0467', 3);
INSERT INTO `sys_district` VALUES ('1122', '梨树', '184', 'l', 'ls', 'lishu', '', '区', '230305', '0467', 4);
INSERT INTO `sys_district` VALUES ('1123', '城子河', '184', 'c', 'czh', 'chengzihe', '', '区', '230306', '0467', 5);
INSERT INTO `sys_district` VALUES ('1124', '麻山', '184', 'm', 'ms', 'mashan', '', '区', '230307', '0467', 6);
INSERT INTO `sys_district` VALUES ('1125', '鸡东', '184', 'j', 'jd', 'jidong', '', '县', '230321', '0467', 7);
INSERT INTO `sys_district` VALUES ('1126', '虎林', '184', 'h', 'hl', 'hulin', '', '市', '230381', '0467', 8);
INSERT INTO `sys_district` VALUES ('1127', '密山', '184', 'm', 'ms', 'mishan', '', '市', '230382', '0467', 9);
INSERT INTO `sys_district` VALUES ('1128', '向阳', '185', 'x', 'xy', 'xiangyang', '', '区', '230402', '0468', 1);
INSERT INTO `sys_district` VALUES ('1129', '工农', '185', 'g', 'gn', 'gongnong', '', '区', '230403', '0468', 2);
INSERT INTO `sys_district` VALUES ('113', '垫江', '4', 'd', 'dj', 'dianjiang', '', '县', '500231', '023', 27);
INSERT INTO `sys_district` VALUES ('1130', '南山', '185', 'n', 'ns', 'nanshan', '', '区', '230404', '0468', 3);
INSERT INTO `sys_district` VALUES ('1131', '兴安', '185', 'x', 'xa', 'xingan', '', '区', '230405', '0468', 4);
INSERT INTO `sys_district` VALUES ('1132', '东山', '185', 'd', 'ds', 'dongshan', '', '区', '230406', '0468', 5);
INSERT INTO `sys_district` VALUES ('1133', '兴山', '185', 'x', 'xs', 'xingshan', '', '区', '230407', '0468', 6);
INSERT INTO `sys_district` VALUES ('1134', '萝北', '185', 'l', 'lb', 'luobei', '', '县', '230421', '0468', 7);
INSERT INTO `sys_district` VALUES ('1135', '绥滨', '185', 's', 'sb', 'suibin', '', '县', '230422', '0468', 8);
INSERT INTO `sys_district` VALUES ('1136', '尖山', '186', 'j', 'js', 'jianshan', '', '区', '230502', '0469', 1);
INSERT INTO `sys_district` VALUES ('1137', '岭东', '186', 'l', 'ld', 'lingdong', '', '区', '230503', '0469', 2);
INSERT INTO `sys_district` VALUES ('1138', '四方台', '186', 's', 'sft', 'sifangtai', '', '区', '230505', '0469', 3);
INSERT INTO `sys_district` VALUES ('1139', '宝山', '186', 'b', 'bs', 'baoshan', '', '区', '230506', '0469', 4);
INSERT INTO `sys_district` VALUES ('114', '武隆', '4', 'w', 'wl', 'wulong', '', '区', '500232', '023', 28);
INSERT INTO `sys_district` VALUES ('1140', '集贤', '186', 'j', 'jx', 'jixian', '', '县', '230521', '0469', 5);
INSERT INTO `sys_district` VALUES ('1141', '友谊', '186', 'y', 'yy', 'youyi', '', '县', '230522', '0469', 6);
INSERT INTO `sys_district` VALUES ('1142', '宝清', '186', 'b', 'bq', 'baoqing', '', '县', '230523', '0469', 7);
INSERT INTO `sys_district` VALUES ('1143', '饶河', '186', 'r', 'rh', 'raohe', '', '县', '230524', '0469', 8);
INSERT INTO `sys_district` VALUES ('1144', '萨尔图', '187', 's', 'set', 'saertu', '', '区', '230602', '0459', 1);
INSERT INTO `sys_district` VALUES ('1145', '龙凤', '187', 'l', 'lf', 'longfeng', '', '区', '230603', '0459', 2);
INSERT INTO `sys_district` VALUES ('1146', '让胡路', '187', 'r', 'rhl', 'ranghulu', '', '区', '230604', '0459', 3);
INSERT INTO `sys_district` VALUES ('1147', '红岗', '187', 'h', 'hg', 'honggang', '', '区', '230605', '0459', 4);
INSERT INTO `sys_district` VALUES ('1148', '大同', '187', 'd', 'dt', 'datong', '', '区', '230606', '0459', 5);
INSERT INTO `sys_district` VALUES ('1149', '肇州', '187', 'z', 'zz', 'zhaozhou', '', '县', '230621', '0459', 6);
INSERT INTO `sys_district` VALUES ('115', '忠县', '4', 'z', 'zx', 'zhongxian', '', '', '500233', '023', 29);
INSERT INTO `sys_district` VALUES ('1150', '肇源', '187', 'z', 'zy', 'zhaoyuan', '', '县', '230622', '0459', 7);
INSERT INTO `sys_district` VALUES ('1151', '林甸', '187', 'l', 'ld', 'lindian', '', '县', '230623', '0459', 8);
INSERT INTO `sys_district` VALUES ('1152', '杜尔伯特', '187', 'd', 'debt', 'duerbote', '蒙古族', '自治县', '230624', '0459', 9);
INSERT INTO `sys_district` VALUES ('1153', '伊春', '188', 'y', 'yc', 'yichun', '', '区', '230702', '0458', 1);
INSERT INTO `sys_district` VALUES ('1154', '南岔', '188', 'n', 'nc', 'nancha', '', '区', '230703', '0458', 2);
INSERT INTO `sys_district` VALUES ('1155', '友好', '188', 'y', 'yh', 'youhao', '', '区', '230704', '0458', 3);
INSERT INTO `sys_district` VALUES ('1156', '西林', '188', 'x', 'xl', 'xilin', '', '区', '230705', '0458', 4);
INSERT INTO `sys_district` VALUES ('1157', '翠峦', '188', 'c', 'cl', 'cuiluan', '', '区', '230706', '0458', 5);
INSERT INTO `sys_district` VALUES ('1158', '新青', '188', 'x', 'xq', 'xinqing', '', '区', '230707', '0458', 6);
INSERT INTO `sys_district` VALUES ('1159', '美溪', '188', 'm', 'mx', 'meixi', '', '区', '230708', '0458', 7);
INSERT INTO `sys_district` VALUES ('116', '开州', '4', 'k', 'kz', 'kaizhou', '', '区', '500234', '023', 30);
INSERT INTO `sys_district` VALUES ('1160', '金山屯', '188', 'j', 'jst', 'jinshantun', '', '区', '230709', '0458', 8);
INSERT INTO `sys_district` VALUES ('1161', '五营', '188', 'w', 'wy', 'wuying', '', '区', '230710', '0458', 9);
INSERT INTO `sys_district` VALUES ('1162', '乌马河', '188', 'w', 'wmh', 'wumahe', '', '区', '230711', '0458', 10);
INSERT INTO `sys_district` VALUES ('1163', '汤旺河', '188', 't', 'twh', 'tangwanghe', '', '区', '230712', '0458', 11);
INSERT INTO `sys_district` VALUES ('1164', '带岭', '188', 'd', 'dl', 'dailing', '', '区', '230713', '0458', 12);
INSERT INTO `sys_district` VALUES ('1165', '乌伊岭', '188', 'w', 'wyl', 'wuyiling', '', '区', '230714', '0458', 13);
INSERT INTO `sys_district` VALUES ('1166', '红星', '188', 'h', 'hx', 'hongxing', '', '区', '230715', '0458', 14);
INSERT INTO `sys_district` VALUES ('1167', '上甘岭', '188', 's', 'sgl', 'shangganling', '', '区', '230716', '0458', 15);
INSERT INTO `sys_district` VALUES ('1168', '嘉荫', '188', 'j', 'jy', 'jiayin', '', '县', '230722', '0458', 16);
INSERT INTO `sys_district` VALUES ('1169', '铁力', '188', 't', 'tl', 'tieli', '', '市', '230781', '0458', 17);
INSERT INTO `sys_district` VALUES ('117', '云阳', '4', 'y', 'yy', 'yunyang', '', '县', '500235', '023', 31);
INSERT INTO `sys_district` VALUES ('1170', '向阳', '189', 'x', 'xy', 'xiangyang', '', '区', '230803', '0454', 1);
INSERT INTO `sys_district` VALUES ('1171', '前进', '189', 'q', 'qj', 'qianjin', '', '区', '230804', '0454', 2);
INSERT INTO `sys_district` VALUES ('1172', '东风', '189', 'd', 'df', 'dongfeng', '', '区', '230805', '0454', 3);
INSERT INTO `sys_district` VALUES ('1173', '郊区', '189', 'j', 'jq', 'jiaoqu', '', '', '230811', '0454', 4);
INSERT INTO `sys_district` VALUES ('1174', '桦南', '189', 'h', 'hn', 'huanan', '', '县', '230822', '0454', 5);
INSERT INTO `sys_district` VALUES ('1175', '桦川', '189', 'h', 'hc', 'huachuan', '', '县', '230826', '0454', 6);
INSERT INTO `sys_district` VALUES ('1176', '汤原', '189', 't', 'ty', 'tangyuan', '', '县', '230828', '0454', 7);
INSERT INTO `sys_district` VALUES ('1177', '抚远', '189', 'f', 'fy', 'fuyuan', '', '市', '230833', '0454', 8);
INSERT INTO `sys_district` VALUES ('1178', '同江', '189', 't', 'tj', 'tongjiang', '', '市', '230881', '0454', 9);
INSERT INTO `sys_district` VALUES ('1179', '富锦', '189', 'f', 'fj', 'fujin', '', '市', '230882', '0454', 10);
INSERT INTO `sys_district` VALUES ('118', '奉节', '4', 'f', 'fj', 'fengjie', '', '县', '500236', '023', 32);
INSERT INTO `sys_district` VALUES ('1180', '新兴', '190', 'x', 'xx', 'xinxing', '', '区', '230902', '0464', 1);
INSERT INTO `sys_district` VALUES ('1181', '桃山', '190', 't', 'ts', 'taoshan', '', '区', '230903', '0464', 2);
INSERT INTO `sys_district` VALUES ('1182', '茄子河', '190', 'q', 'qzh', 'qiezihe', '', '区', '230904', '0464', 3);
INSERT INTO `sys_district` VALUES ('1183', '勃利', '190', 'b', 'bl', 'boli', '', '县', '230921', '0464', 4);
INSERT INTO `sys_district` VALUES ('1184', '东安', '191', 'd', 'da', 'dongan', '', '区', '231002', '0453', 1);
INSERT INTO `sys_district` VALUES ('1185', '阳明', '191', 'y', 'ym', 'yangming', '', '区', '231003', '0453', 2);
INSERT INTO `sys_district` VALUES ('1186', '爱民', '191', 'a', 'am', 'aimin', '', '区', '231004', '0453', 3);
INSERT INTO `sys_district` VALUES ('1187', '西安', '191', 'x', 'xa', 'xian', '', '区', '231005', '0453', 4);
INSERT INTO `sys_district` VALUES ('1188', '东宁', '191', 'd', 'dn', 'dongning', '', '市', '231024', '0453', 5);
INSERT INTO `sys_district` VALUES ('1189', '林口', '191', 'l', 'lk', 'linkou', '', '县', '231025', '0453', 6);
INSERT INTO `sys_district` VALUES ('119', '巫山', '4', 'w', 'ws', 'wushan', '', '县', '500237', '023', 33);
INSERT INTO `sys_district` VALUES ('1190', '绥芬河', '191', 's', 'sfh', 'suifenhe', '', '市', '231081', '0453', 7);
INSERT INTO `sys_district` VALUES ('1191', '海林', '191', 'h', 'hl', 'hailin', '', '市', '231083', '0453', 8);
INSERT INTO `sys_district` VALUES ('1192', '宁安', '191', 'n', 'na', 'ningan', '', '市', '231084', '0453', 9);
INSERT INTO `sys_district` VALUES ('1193', '穆棱', '191', 'm', 'ml', 'muleng', '', '市', '231085', '0453', 10);
INSERT INTO `sys_district` VALUES ('1194', '爱辉', '192', 'a', 'ah', 'aihui', '', '区', '231102', '0456', 1);
INSERT INTO `sys_district` VALUES ('1195', '嫩江', '192', 'n', 'nj', 'nenjiang', '', '县', '231121', '0456', 2);
INSERT INTO `sys_district` VALUES ('1196', '逊克', '192', 'x', 'xk', 'xunke', '', '县', '231123', '0456', 3);
INSERT INTO `sys_district` VALUES ('1197', '孙吴', '192', 's', 'sw', 'sunwu', '', '县', '231124', '0456', 4);
INSERT INTO `sys_district` VALUES ('1198', '北安', '192', 'b', 'ba', 'beian', '', '市', '231181', '0456', 5);
INSERT INTO `sys_district` VALUES ('1199', '五大连池', '192', 'w', 'wdlc', 'wudalianchi', '', '市', '231182', '0456', 6);
INSERT INTO `sys_district` VALUES ('12', '浙江', '0', 'z', 'zj', 'zhejiang', '', '省', '330000', '', 13);
INSERT INTO `sys_district` VALUES ('120', '巫溪', '4', 'w', 'wx', 'wuxi', '', '县', '500238', '023', 34);
INSERT INTO `sys_district` VALUES ('1200', '北林', '193', 'b', 'bl', 'beilin', '', '区', '231202', '0455', 1);
INSERT INTO `sys_district` VALUES ('1201', '望奎', '193', 'w', 'wk', 'wangkui', '', '县', '231221', '0455', 2);
INSERT INTO `sys_district` VALUES ('1202', '兰西', '193', 'l', 'lx', 'lanxi', '', '县', '231222', '0455', 3);
INSERT INTO `sys_district` VALUES ('1203', '青冈', '193', 'q', 'qg', 'qinggang', '', '县', '231223', '0455', 4);
INSERT INTO `sys_district` VALUES ('1204', '庆安', '193', 'q', 'qa', 'qingan', '', '县', '231224', '0455', 5);
INSERT INTO `sys_district` VALUES ('1205', '明水', '193', 'm', 'ms', 'mingshui', '', '县', '231225', '0455', 6);
INSERT INTO `sys_district` VALUES ('1206', '绥棱', '193', 's', 'sl', 'suileng', '', '县', '231226', '0455', 7);
INSERT INTO `sys_district` VALUES ('1207', '安达', '193', 'a', 'ad', 'anda', '', '市', '231281', '0455', 8);
INSERT INTO `sys_district` VALUES ('1208', '肇东', '193', 'z', 'zd', 'zhaodong', '', '市', '231282', '0455', 9);
INSERT INTO `sys_district` VALUES ('1209', '海伦', '193', 'h', 'hl', 'hailun', '', '市', '231283', '0455', 10);
INSERT INTO `sys_district` VALUES ('121', '石柱', '4', 's', 'sz', 'shizhu', '土家族', '自治县', '500240', '023', 35);
INSERT INTO `sys_district` VALUES ('1210', '加格达奇', '194', 'j', 'jgdq', 'jiagedaqi', '', '区', '232701', '0457', 1);
INSERT INTO `sys_district` VALUES ('1211', '松岭', '194', 's', 'sl', 'songling', '', '区', '232702', '0457', 2);
INSERT INTO `sys_district` VALUES ('1212', '新林', '194', 'x', 'xl', 'xinlin', '', '区', '232703', '0457', 3);
INSERT INTO `sys_district` VALUES ('1213', '呼中', '194', 'h', 'hz', 'huzhong', '', '区', '232704', '0457', 4);
INSERT INTO `sys_district` VALUES ('1214', '呼玛', '194', 'h', 'hm', 'huma', '', '县', '232721', '0457', 5);
INSERT INTO `sys_district` VALUES ('1215', '塔河', '194', 't', 'th', 'tahe', '', '县', '232722', '0457', 6);
INSERT INTO `sys_district` VALUES ('1216', '漠河', '194', 'm', 'mh', 'mohe', '', '市', '232701', '0457', 7);
INSERT INTO `sys_district` VALUES ('1217', '玄武', '195', 'x', 'xw', 'xuanwu', '', '区', '320102', '', 1);
INSERT INTO `sys_district` VALUES ('1218', '秦淮', '195', 'q', 'qh', 'qinhuai', '', '区', '320104', '', 2);
INSERT INTO `sys_district` VALUES ('1219', '建邺', '195', 'j', 'jy', 'jianye', '', '区', '320105', '', 3);
INSERT INTO `sys_district` VALUES ('122', '秀山', '4', 'x', 'xs', 'xiushan', '土家族苗族', '自治县', '500241', '023', 36);
INSERT INTO `sys_district` VALUES ('1220', '鼓楼', '195', 'g', 'gl', 'gulou', '', '区', '320106', '', 4);
INSERT INTO `sys_district` VALUES ('1221', '浦口', '195', 'p', 'pk', 'pukou', '', '区', '320111', '', 5);
INSERT INTO `sys_district` VALUES ('1222', '栖霞', '195', 'q', 'qx', 'qixia', '', '区', '320113', '', 6);
INSERT INTO `sys_district` VALUES ('1223', '雨花台', '195', 'y', 'yht', 'yuhuatai', '', '区', '320114', '', 7);
INSERT INTO `sys_district` VALUES ('1224', '江宁', '195', 'j', 'jn', 'jiangning', '', '区', '320115', '', 8);
INSERT INTO `sys_district` VALUES ('1225', '六合', '195', 'l', 'lh', 'liuhe', '', '区', '320116', '', 9);
INSERT INTO `sys_district` VALUES ('1226', '溧水', '195', 'l', 'ls', 'lishui', '', '区', '320124', '', 10);
INSERT INTO `sys_district` VALUES ('1227', '高淳', '195', 'g', 'gc', 'gaochun', '', '区', '320125', '', 11);
INSERT INTO `sys_district` VALUES ('1228', '梁溪', '196', 'l', 'lx', 'liangxi', '', '区', '320202', '0510', 1);
INSERT INTO `sys_district` VALUES ('1229', '新吴', '196', 'x', 'xw', 'xinwu', '', '区', '', '0510', 2);
INSERT INTO `sys_district` VALUES ('123', '酉阳', '4', 'y', 'yy', 'youyang', '土家族苗族', '自治县', '500242', '023', 37);
INSERT INTO `sys_district` VALUES ('1231', '锡山', '196', 'x', 'xs', 'xishan', '', '区', '320205', '0510', 4);
INSERT INTO `sys_district` VALUES ('1232', '惠山', '196', 'h', 'hs', 'huishan', '', '区', '320206', '0510', 5);
INSERT INTO `sys_district` VALUES ('1233', '滨湖', '196', 'b', 'bh', 'binhu', '', '区', '320211', '0510', 6);
INSERT INTO `sys_district` VALUES ('1234', '江阴', '196', 'j', 'jy', 'jiangyin', '', '市', '320281', '0510', 7);
INSERT INTO `sys_district` VALUES ('1235', '宜兴', '196', 'y', 'yx', 'yixing', '', '市', '320282', '0510', 8);
INSERT INTO `sys_district` VALUES ('1236', '鼓楼', '197', 'g', 'gl', 'gulou', '', '区', '320302', '0516', 1);
INSERT INTO `sys_district` VALUES ('1237', '云龙', '197', 'y', 'yl', 'yunlong', '', '区', '320303', '0516', 2);
INSERT INTO `sys_district` VALUES ('1238', '贾汪', '197', 'j', 'jw', 'jiawang', '', '区', '320305', '0516', 3);
INSERT INTO `sys_district` VALUES ('1239', '泉山', '197', 'q', 'qs', 'quanshan', '', '区', '320311', '0516', 4);
INSERT INTO `sys_district` VALUES ('124', '彭水', '4', 'p', 'ps', 'pengshui', '苗族土家族', '自治县', '500243', '023', 38);
INSERT INTO `sys_district` VALUES ('1240', '铜山', '197', 't', 'ts', 'tongshan', '', '区', '320312', '0516', 5);
INSERT INTO `sys_district` VALUES ('1241', '丰县', '197', 'f', 'fx', 'fengxian', '', '', '320321', '0516', 6);
INSERT INTO `sys_district` VALUES ('1242', '沛县', '197', 'p', 'px', 'peixian', '', '', '320322', '0516', 7);
INSERT INTO `sys_district` VALUES ('1243', '睢宁', '197', 's', 'sn', 'suining', '', '县', '320324', '0516', 8);
INSERT INTO `sys_district` VALUES ('1244', '新沂', '197', 'x', 'xy', 'xinyi', '', '市', '320381', '0516', 9);
INSERT INTO `sys_district` VALUES ('1245', '邳州', '197', 'p', 'pz', 'pizhou', '', '市', '320382', '0516', 10);
INSERT INTO `sys_district` VALUES ('1246', '天宁', '198', 't', 'tn', 'tianning', '', '区', '320402', '0519', 1);
INSERT INTO `sys_district` VALUES ('1247', '钟楼', '198', 'z', 'zl', 'zhonglou', '', '区', '320404', '0519', 2);
INSERT INTO `sys_district` VALUES ('1249', '新北', '198', 'x', 'xb', 'xinbei', '', '区', '320411', '0519', 4);
INSERT INTO `sys_district` VALUES ('125', '石家庄', '5', 's', 'sjz', 'shijiazhuang', '', '市', '130100', '0311', 1);
INSERT INTO `sys_district` VALUES ('1250', '武进', '198', 'w', 'wj', 'wujin', '', '区', '320412', '0519', 5);
INSERT INTO `sys_district` VALUES ('1251', '溧阳', '198', 'l', 'ly', 'liyang', '', '市', '320481', '0519', 6);
INSERT INTO `sys_district` VALUES ('1252', '金坛', '198', 'j', 'jt', 'jintan', '', '区', '320482', '0519', 7);
INSERT INTO `sys_district` VALUES ('1253', '虎丘', '199', 'h', 'hq', 'huqiu', '', '区', '320505', '0512', 1);
INSERT INTO `sys_district` VALUES ('1254', '吴中', '199', 'w', 'wz', 'wuzhong', '', '区', '320506', '0512', 2);
INSERT INTO `sys_district` VALUES ('1255', '相城', '199', 'x', 'xc', 'xiangcheng', '', '区', '320507', '0512', 3);
INSERT INTO `sys_district` VALUES ('1256', '姑苏', '199', 'g', 'gs', 'gusu', '', '区', '320508', '0512', 4);
INSERT INTO `sys_district` VALUES ('1257', '吴江', '199', 'w', 'wj', 'wujiang', '', '市', '320509', '0512', 5);
INSERT INTO `sys_district` VALUES ('1258', '常熟', '199', 'c', 'cs', 'changshu', '', '市', '320581', '0512', 6);
INSERT INTO `sys_district` VALUES ('1259', '张家港', '199', 'z', 'zjg', 'zhangjiagang', '', '市', '320582', '0512', 7);
INSERT INTO `sys_district` VALUES ('126', '唐山', '5', 't', 'ts', 'tangshan', '', '市', '130200', '0315', 2);
INSERT INTO `sys_district` VALUES ('1260', '昆山', '199', 'k', 'ks', 'kunshan', '', '市', '320583', '0512', 8);
INSERT INTO `sys_district` VALUES ('1261', '太仓', '199', 't', 'tc', 'taicang', '', '市', '320585', '0512', 9);
INSERT INTO `sys_district` VALUES ('1262', '崇川', '200', 'c', 'cc', 'chongchuan', '', '区', '320602', '0513', 1);
INSERT INTO `sys_district` VALUES ('1263', '港闸', '200', 'g', 'gz', 'gangzha', '', '区', '320611', '0513', 2);
INSERT INTO `sys_district` VALUES ('1264', '通州', '200', 't', 'tz', 'tongzhou', '', '区', '320612', '0513', 3);
INSERT INTO `sys_district` VALUES ('1265', '海安', '200', 'h', 'ha', 'haian', '', '县', '320621', '0513', 4);
INSERT INTO `sys_district` VALUES ('1266', '如东', '200', 'r', 'rd', 'rudong', '', '县', '320623', '0513', 5);
INSERT INTO `sys_district` VALUES ('1267', '启东', '200', 'q', 'qd', 'qidong', '', '市', '320681', '0513', 6);
INSERT INTO `sys_district` VALUES ('1268', '如皋', '200', 'r', 'rg', 'rugao', '', '市', '320682', '0513', 7);
INSERT INTO `sys_district` VALUES ('1269', '海门', '200', 'h', 'hm', 'haimen', '', '市', '320684', '0513', 8);
INSERT INTO `sys_district` VALUES ('127', '秦皇岛', '5', 'q', 'qhd', 'qinhuangdao', '', '市', '130300', '0335', 3);
INSERT INTO `sys_district` VALUES ('1270', '连云', '201', 'l', 'ly', 'lianyun', '', '区', '320703', '0518', 1);
INSERT INTO `sys_district` VALUES ('1272', '海州', '201', 'h', 'hz', 'haizhou', '', '区', '320706', '0518', 2);
INSERT INTO `sys_district` VALUES ('1273', '赣榆', '201', 'g', 'gy', 'ganyu', '', '区', '320721', '0518', 3);
INSERT INTO `sys_district` VALUES ('1274', '东海', '201', 'd', 'dh', 'donghai', '', '县', '320722', '0518', 4);
INSERT INTO `sys_district` VALUES ('1275', '灌云', '201', 'g', 'gy', 'guanyun', '', '县', '320723', '0518', 5);
INSERT INTO `sys_district` VALUES ('1276', '灌南', '201', 'g', 'gn', 'guannan', '', '县', '320724', '0518', 6);
INSERT INTO `sys_district` VALUES ('1277', '清河', '202', 'q', 'qh', 'qinghe', '', '区', '320802', '0517', 1);
INSERT INTO `sys_district` VALUES ('1278', '淮安', '202', 'h', 'ha', 'huaian', '', '区', '320803', '0517', 2);
INSERT INTO `sys_district` VALUES ('1279', '淮阴', '202', 'h', 'hy', 'huaiyin', '', '区', '320804', '0517', 3);
INSERT INTO `sys_district` VALUES ('128', '邯郸', '5', 'h', 'hd', 'handan', '', '市', '130400', '0310', 4);
INSERT INTO `sys_district` VALUES ('1280', '清浦', '202', 'q', 'qp', 'qingpu', '', '区', '320811', '0517', 4);
INSERT INTO `sys_district` VALUES ('1281', '涟水', '202', 'l', 'ls', 'lianshui', '', '县', '320826', '0517', 5);
INSERT INTO `sys_district` VALUES ('1282', '洪泽', '202', 'h', 'hz', 'hongze', '', '县', '320829', '0517', 6);
INSERT INTO `sys_district` VALUES ('1283', '盱眙', '202', 'x', 'xy', 'xuyi', '', '县', '320830', '0517', 7);
INSERT INTO `sys_district` VALUES ('1284', '金湖', '202', 'j', 'jh', 'jinhu', '', '县', '320831', '0517', 8);
INSERT INTO `sys_district` VALUES ('1285', '亭湖', '203', 't', 'th', 'tinghu', '', '区', '320902', '0515', 1);
INSERT INTO `sys_district` VALUES ('1286', '盐都', '203', 'y', 'yd', 'yandu', '', '区', '320903', '0515', 2);
INSERT INTO `sys_district` VALUES ('1287', '响水', '203', 'x', 'xs', 'xiangshui', '', '县', '320921', '0515', 3);
INSERT INTO `sys_district` VALUES ('1288', '滨海', '203', 'b', 'bh', 'binhai', '', '县', '320922', '0515', 4);
INSERT INTO `sys_district` VALUES ('1289', '阜宁', '203', 'f', 'fn', 'funing', '', '县', '320923', '0515', 5);
INSERT INTO `sys_district` VALUES ('129', '邢台', '5', 'x', 'xt', 'xingtai', '', '市', '130500', '0319', 5);
INSERT INTO `sys_district` VALUES ('1290', '射阳', '203', 's', 'sy', 'sheyang', '', '县', '320924', '0515', 6);
INSERT INTO `sys_district` VALUES ('1291', '建湖', '203', 'j', 'jh', 'jianhu', '', '县', '320925', '0515', 7);
INSERT INTO `sys_district` VALUES ('1292', '东台', '203', 'd', 'dt', 'dongtai', '', '市', '320981', '0515', 8);
INSERT INTO `sys_district` VALUES ('1293', '大丰', '203', 'd', 'df', 'dafeng', '', '区', '320982', '0515', 9);
INSERT INTO `sys_district` VALUES ('1294', '广陵', '204', 'g', 'gl', 'guangling', '', '区', '321002', '0514', 1);
INSERT INTO `sys_district` VALUES ('1295', '邗江', '204', 'h', 'hj', 'hanjiang', '', '区', '321003', '0514', 2);
INSERT INTO `sys_district` VALUES ('1296', '江都', '204', 'j', 'jd', 'jiangu', '', '区', '321012', '0514', 3);
INSERT INTO `sys_district` VALUES ('1297', '宝应', '204', 'b', 'by', 'baoying', '', '县', '321023', '0514', 4);
INSERT INTO `sys_district` VALUES ('1298', '仪征', '204', 'y', 'yz', 'yizheng', '', '市', '321081', '0514', 5);
INSERT INTO `sys_district` VALUES ('1299', '高邮', '204', 'g', 'gy', 'gaoyou', '', '市', '321084', '0514', 6);
INSERT INTO `sys_district` VALUES ('13', '安徽', '0', 'a', 'ah', 'anhui', '', '省', '340000', '', 14);
INSERT INTO `sys_district` VALUES ('130', '保定', '5', 'b', 'bd', 'baoding', '', '市', '130600', '0312', 6);
INSERT INTO `sys_district` VALUES ('1300', '京口', '205', 'j', 'jk', 'jingkou', '', '区', '321102', '0511', 1);
INSERT INTO `sys_district` VALUES ('1301', '润州', '205', 'r', 'rz', 'runzhou', '', '区', '321111', '0511', 2);
INSERT INTO `sys_district` VALUES ('1302', '丹徒', '205', 'd', 'dt', 'dantu', '', '区', '321112', '0511', 3);
INSERT INTO `sys_district` VALUES ('1303', '丹阳', '205', 'd', 'dy', 'danyang', '', '市', '321181', '0511', 4);
INSERT INTO `sys_district` VALUES ('1304', '扬中', '205', 'y', 'yz', 'yangzhong', '', '市', '321182', '0511', 5);
INSERT INTO `sys_district` VALUES ('1305', '句容', '205', 'j', 'jr', 'jurong', '', '市', '321183', '0511', 6);
INSERT INTO `sys_district` VALUES ('1306', '海陵', '206', 'h', 'hl', 'hailing', '', '区', '321202', '0523', 1);
INSERT INTO `sys_district` VALUES ('1307', '高港', '206', 'g', 'gg', 'gaogang', '', '区', '321203', '0523', 2);
INSERT INTO `sys_district` VALUES ('1308', '兴化', '206', 'x', 'xh', 'xinghua', '', '市', '321281', '0523', 3);
INSERT INTO `sys_district` VALUES ('1309', '靖江', '206', 'j', 'jj', 'jingjiang', '', '市', '321282', '0523', 4);
INSERT INTO `sys_district` VALUES ('131', '张家口', '5', 'z', 'zjk', 'zhangjiakou', '', '市', '130700', '0313', 7);
INSERT INTO `sys_district` VALUES ('1310', '泰兴', '206', 't', 'tx', 'taixing', '', '市', '321283', '0523', 5);
INSERT INTO `sys_district` VALUES ('1311', '姜堰', '206', 'j', 'jy', 'jiangyan', '', '区', '321284', '0523', 6);
INSERT INTO `sys_district` VALUES ('1312', '宿城', '207', 's', 'sc', 'sucheng', '', '区', '321302', '0527', 1);
INSERT INTO `sys_district` VALUES ('1313', '宿豫', '207', 's', 'sy', 'suyu', '', '区', '321311', '0527', 2);
INSERT INTO `sys_district` VALUES ('1314', '沭阳', '207', 's', 'sy', 'shuyang', '', '县', '321322', '0527', 3);
INSERT INTO `sys_district` VALUES ('1315', '泗阳', '207', 's', 'sy', 'siyang', '', '县', '321323', '0527', 4);
INSERT INTO `sys_district` VALUES ('1316', '泗洪', '207', 's', 'sh', 'sihong', '', '县', '321324', '0527', 5);
INSERT INTO `sys_district` VALUES ('1317', '上城', '208', 's', 'sc', 'shangcheng', '', '区', '330102', '0571', 1);
INSERT INTO `sys_district` VALUES ('1318', '下城', '208', 'x', 'xc', 'xiacheng', '', '区', '330103', '0571', 2);
INSERT INTO `sys_district` VALUES ('1319', '江干', '208', 'j', 'jg', 'jianggan', '', '区', '330104', '0571', 3);
INSERT INTO `sys_district` VALUES ('132', '承德', '5', 'c', 'cd', 'chengde', '', '市', '130800', '0314', 8);
INSERT INTO `sys_district` VALUES ('1320', '拱墅', '208', 'g', 'gs', 'gongshu', '', '区', '330105', '0571', 4);
INSERT INTO `sys_district` VALUES ('1321', '西湖', '208', 'x', 'xh', 'xihu', '', '区', '330106', '0571', 5);
INSERT INTO `sys_district` VALUES ('1322', '滨江', '208', 'b', 'bj', 'binjiang', '', '区', '330108', '0571', 6);
INSERT INTO `sys_district` VALUES ('1323', '萧山', '208', 'x', 'xs', 'xiaoshan', '', '区', '330109', '0571', 7);
INSERT INTO `sys_district` VALUES ('1324', '余杭', '208', 'y', 'yh', 'yuhang', '', '区', '330110', '0571', 8);
INSERT INTO `sys_district` VALUES ('1325', '桐庐', '208', 't', 'tl', 'tonglu', '', '县', '330122', '0571', 9);
INSERT INTO `sys_district` VALUES ('1326', '淳安', '208', 'c', 'ca', 'chunan', '', '县', '330127', '0571', 11);
INSERT INTO `sys_district` VALUES ('1327', '建德', '208', 'j', 'jd', 'jiande', '', '市', '330182', '0571', 12);
INSERT INTO `sys_district` VALUES ('1328', '富阳', '208', 'f', 'fy', 'fuyang', '', '区', '330183', '0571', 10);
INSERT INTO `sys_district` VALUES ('1329', '临安', '208', 'l', 'la', 'linan', '', '市', '330185', '0571', 13);
INSERT INTO `sys_district` VALUES ('133', '沧州', '5', 'c', 'cz', 'cangzhou', '', '市', '130900', '0317', 9);
INSERT INTO `sys_district` VALUES ('1330', '海曙', '209', 'h', 'hs', 'haishu', '', '区', '330203', '0574', 1);
INSERT INTO `sys_district` VALUES ('1332', '江北', '209', 'j', 'jb', 'jiangbei', '', '区', '330205', '0574', 3);
INSERT INTO `sys_district` VALUES ('1333', '北仑', '209', 'b', 'bl', 'beilun', '', '区', '330206', '0574', 4);
INSERT INTO `sys_district` VALUES ('1334', '镇海', '209', 'z', 'zh', 'zhenhai', '', '区', '330211', '0574', 5);
INSERT INTO `sys_district` VALUES ('1335', '鄞州', '209', 'y', 'yz', 'yinzhou', '', '区', '330212', '0574', 6);
INSERT INTO `sys_district` VALUES ('1336', '象山', '209', 'x', 'xs', 'xiangshan', '', '县', '330225', '0574', 7);
INSERT INTO `sys_district` VALUES ('1337', '宁海', '209', 'n', 'nh', 'ninghai', '', '县', '330226', '0574', 8);
INSERT INTO `sys_district` VALUES ('1338', '余姚', '209', 'y', 'yy', 'yuyao', '', '市', '330281', '0574', 9);
INSERT INTO `sys_district` VALUES ('1339', '慈溪', '209', 'c', 'cx', 'cixi', '', '市', '330282', '0574', 10);
INSERT INTO `sys_district` VALUES ('134', '廊坊', '5', 'l', 'lf', 'langfang', '', '市', '131000', '0316', 10);
INSERT INTO `sys_district` VALUES ('1340', '奉化', '209', 'f', 'fh', 'fenghua', '', '区', '330283', '0574', 11);
INSERT INTO `sys_district` VALUES ('1341', '鹿城', '210', 'l', 'lc', 'lucheng', '', '区', '330302', '0577', 1);
INSERT INTO `sys_district` VALUES ('1342', '龙湾', '210', 'l', 'lw', 'longwan', '', '区', '330303', '0577', 2);
INSERT INTO `sys_district` VALUES ('1343', '瓯海', '210', 'o', 'oh', 'ouhai', '', '区', '330304', '0577', 3);
INSERT INTO `sys_district` VALUES ('1344', '洞头', '210', 'd', 'dt', 'dongtou', '', '区', '330322', '0577', 4);
INSERT INTO `sys_district` VALUES ('1345', '永嘉', '210', 'y', 'yj', 'yongjia', '', '县', '330324', '0577', 5);
INSERT INTO `sys_district` VALUES ('1346', '平阳', '210', 'p', 'py', 'pingyang', '', '县', '330326', '0577', 6);
INSERT INTO `sys_district` VALUES ('1347', '苍南', '210', 'c', 'cn', 'cangnan', '', '县', '330327', '0577', 7);
INSERT INTO `sys_district` VALUES ('1348', '文成', '210', 'w', 'wc', 'wencheng', '', '县', '330328', '0577', 8);
INSERT INTO `sys_district` VALUES ('1349', '泰顺', '210', 't', 'ts', 'taishun', '', '县', '330329', '0577', 9);
INSERT INTO `sys_district` VALUES ('135', '衡水', '5', 'h', 'hs', 'hengshui', '', '市', '131100', '0318', 11);
INSERT INTO `sys_district` VALUES ('1350', '瑞安', '210', 'r', 'ra', 'ruian', '', '市', '330381', '0577', 10);
INSERT INTO `sys_district` VALUES ('1351', '乐清', '210', 'l', 'lq', 'leqing', '', '市', '330382', '0577', 11);
INSERT INTO `sys_district` VALUES ('1352', '南湖', '211', 'n', 'nh', 'nanhu', '', '区', '330402', '0573', 1);
INSERT INTO `sys_district` VALUES ('1353', '秀洲', '211', 'x', 'xz', 'xiuzhou', '', '区', '330411', '0573', 2);
INSERT INTO `sys_district` VALUES ('1354', '嘉善', '211', 'j', 'js', 'jiashan', '', '县', '330421', '0573', 3);
INSERT INTO `sys_district` VALUES ('1355', '海盐', '211', 'h', 'hy', 'haiyan', '', '县', '330424', '0573', 4);
INSERT INTO `sys_district` VALUES ('1356', '海宁', '211', 'h', 'hn', 'haining', '', '市', '330481', '0573', 5);
INSERT INTO `sys_district` VALUES ('1357', '平湖', '211', 'p', 'ph', 'pinghu', '', '市', '330482', '0573', 6);
INSERT INTO `sys_district` VALUES ('1358', '桐乡', '211', 't', 'tx', 'tongxiang', '', '市', '330483', '0573', 7);
INSERT INTO `sys_district` VALUES ('1359', '吴兴', '212', 'w', 'wx', 'wuxing', '', '区', '330502', '0572', 1);
INSERT INTO `sys_district` VALUES ('136', '太原', '6', 't', 'ty', 'taiyuan', '', '市', '140100', '0351', 1);
INSERT INTO `sys_district` VALUES ('1360', '南浔', '212', 'n', 'nx', 'nanxun', '', '区', '330503', '0572', 2);
INSERT INTO `sys_district` VALUES ('1361', '德清', '212', 'd', 'dq', 'deqing', '', '县', '330521', '0572', 3);
INSERT INTO `sys_district` VALUES ('1362', '长兴', '212', 'z', 'zx', 'zhangxing', '', '县', '330522', '0572', 4);
INSERT INTO `sys_district` VALUES ('1363', '安吉', '212', 'a', 'aj', 'anji', '', '县', '330523', '0572', 5);
INSERT INTO `sys_district` VALUES ('1364', '越城', '213', 'y', 'yc', 'yuecheng', '', '区', '330602', '0575', 1);
INSERT INTO `sys_district` VALUES ('1365', '柯桥', '213', 'k', 'kq', 'keqiao', '', '区', '330603', '0575', 2);
INSERT INTO `sys_district` VALUES ('1366', '新昌', '213', 'x', 'xc', 'xinchang', '', '县', '330624', '0575', 4);
INSERT INTO `sys_district` VALUES ('1367', '诸暨', '213', 'z', 'zj', 'zhuji', '', '市', '330681', '0575', 5);
INSERT INTO `sys_district` VALUES ('1368', '上虞', '213', 's', 'sy', 'shangyu', '', '区', '330604', '0575', 3);
INSERT INTO `sys_district` VALUES ('1369', '嵊州', '213', 's', 'sz', 'shengzhou', '', '市', '330683', '0575', 6);
INSERT INTO `sys_district` VALUES ('137', '大同', '6', 'd', 'dt', 'datong', '', '市', '140200', '0352', 2);
INSERT INTO `sys_district` VALUES ('1370', '婺城', '214', 'w', 'wc', 'wucheng', '', '区', '330702', '0579', 1);
INSERT INTO `sys_district` VALUES ('1371', '金东', '214', 'j', 'jd', 'jindong', '', '区', '330703', '0579', 2);
INSERT INTO `sys_district` VALUES ('1372', '武义', '214', 'w', 'wy', 'wuyi', '', '县', '330723', '0579', 3);
INSERT INTO `sys_district` VALUES ('1373', '浦江', '214', 'p', 'pj', 'pujiang', '', '县', '330726', '0579', 4);
INSERT INTO `sys_district` VALUES ('1374', '磐安', '214', 'p', 'pa', 'panan', '', '县', '330727', '0579', 5);
INSERT INTO `sys_district` VALUES ('1375', '兰溪', '214', 'l', 'lx', 'lanxi', '', '市', '330781', '0579', 6);
INSERT INTO `sys_district` VALUES ('1376', '义乌', '214', 'y', 'yw', 'yiwu', '', '市', '330782', '0579', 7);
INSERT INTO `sys_district` VALUES ('1377', '东阳', '214', 'd', 'dy', 'dongyang', '', '市', '330783', '0579', 8);
INSERT INTO `sys_district` VALUES ('1378', '永康', '214', 'y', 'yk', 'yongkang', '', '市', '330784', '0579', 9);
INSERT INTO `sys_district` VALUES ('1379', '柯城', '215', 'k', 'kc', 'kecheng', '', '区', '330802', '0570', 1);
INSERT INTO `sys_district` VALUES ('138', '阳泉', '6', 'y', 'yq', 'yangquan', '', '市', '140300', '0353', 3);
INSERT INTO `sys_district` VALUES ('1380', '衢江', '215', 'q', 'qj', 'qujiang', '', '区', '330803', '0570', 2);
INSERT INTO `sys_district` VALUES ('1381', '常山', '215', 'c', 'cs', 'changshan', '', '县', '330822', '0570', 3);
INSERT INTO `sys_district` VALUES ('1382', '开化', '215', 'k', 'kh', 'kaihua', '', '县', '330824', '0570', 4);
INSERT INTO `sys_district` VALUES ('1383', '龙游', '215', 'l', 'ly', 'longyou', '', '县', '330825', '0570', 5);
INSERT INTO `sys_district` VALUES ('1384', '江山', '215', 'j', 'js', 'jiangshan', '', '市', '330881', '0570', 6);
INSERT INTO `sys_district` VALUES ('1385', '定海', '216', 'd', 'dh', 'dinghai', '', '区', '330902', '0580', 1);
INSERT INTO `sys_district` VALUES ('1386', '普陀', '216', 'p', 'pt', 'putuo', '', '区', '330903', '0580', 2);
INSERT INTO `sys_district` VALUES ('1387', '岱山', '216', 'd', 'ds', 'daishan', '', '县', '330921', '0580', 3);
INSERT INTO `sys_district` VALUES ('1388', '嵊泗', '216', 's', 'ss', 'shengsi', '', '县', '330922', '0580', 4);
INSERT INTO `sys_district` VALUES ('1389', '椒江', '217', 'j', 'jj', 'jiaojiang', '', '区', '331002', '0576', 1);
INSERT INTO `sys_district` VALUES ('139', '长治', '6', 'z', 'zz', 'zhangzhi', '', '市', '140400', '0355', 4);
INSERT INTO `sys_district` VALUES ('1390', '黄岩', '217', 'h', 'hy', 'huangyan', '', '区', '331003', '0576', 2);
INSERT INTO `sys_district` VALUES ('1391', '路桥', '217', 'l', 'lq', 'luqiao', '', '区', '331004', '0576', 3);
INSERT INTO `sys_district` VALUES ('1392', '玉环', '217', 'y', 'yh', 'yuhuan', '', '县', '331021', '0576', 4);
INSERT INTO `sys_district` VALUES ('1393', '三门', '217', 's', 'sm', 'sanmen', '', '县', '331022', '0576', 5);
INSERT INTO `sys_district` VALUES ('1394', '天台', '217', 't', 'tt', 'tiantai', '', '县', '331023', '0576', 6);
INSERT INTO `sys_district` VALUES ('1395', '仙居', '217', 'x', 'xj', 'xianju', '', '县', '331024', '0576', 7);
INSERT INTO `sys_district` VALUES ('1396', '温岭', '217', 'w', 'wl', 'wenling', '', '市', '331081', '0576', 8);
INSERT INTO `sys_district` VALUES ('1397', '临海', '217', 'l', 'lh', 'linhai', '', '市', '331082', '0576', 9);
INSERT INTO `sys_district` VALUES ('1398', '莲都', '218', 'l', 'ld', 'liandu', '', '区', '331102', '0578', 1);
INSERT INTO `sys_district` VALUES ('1399', '青田', '218', 'q', 'qt', 'qingtian', '', '县', '331121', '0578', 2);
INSERT INTO `sys_district` VALUES ('14', '福建', '0', 'f', 'fj', 'fujian', '', '省', '350000', '', 15);
INSERT INTO `sys_district` VALUES ('140', '晋城', '6', 'j', 'jc', 'jincheng', '', '市', '140500', '0356', 5);
INSERT INTO `sys_district` VALUES ('1400', '缙云', '218', 'j', 'jy', 'jinyun', '', '县', '331122', '0578', 3);
INSERT INTO `sys_district` VALUES ('1401', '遂昌', '218', 's', 'sc', 'suichang', '', '县', '331123', '0578', 4);
INSERT INTO `sys_district` VALUES ('1402', '松阳', '218', 's', 'sy', 'songyang', '', '县', '331124', '0578', 5);
INSERT INTO `sys_district` VALUES ('1403', '云和', '218', 'y', 'yh', 'yunhe', '', '县', '331125', '0578', 6);
INSERT INTO `sys_district` VALUES ('1404', '庆元', '218', 'q', 'qy', 'qingyuan', '', '县', '331126', '0578', 7);
INSERT INTO `sys_district` VALUES ('1405', '景宁', '218', 'j', 'jn', 'jingning', '畲族', '自治县', '331127', '0578', 8);
INSERT INTO `sys_district` VALUES ('1406', '龙泉', '218', 'l', 'lq', 'longquan', '', '市', '331181', '0578', 9);
INSERT INTO `sys_district` VALUES ('1407', '瑶海', '219', 'y', 'yh', 'yaohai', '', '区', '340102', '0551', 1);
INSERT INTO `sys_district` VALUES ('1408', '庐阳', '219', 'l', 'ly', 'luyang', '', '区', '340103', '0551', 2);
INSERT INTO `sys_district` VALUES ('1409', '蜀山', '219', 's', 'ss', 'shushan', '', '区', '340104', '0551', 3);
INSERT INTO `sys_district` VALUES ('141', '朔州', '6', 's', 'sz', 'shuozhou', '', '市', '140600', '0349', 6);
INSERT INTO `sys_district` VALUES ('1410', '包河', '219', 'b', 'bh', 'baohe', '', '区', '340111', '0551', 4);
INSERT INTO `sys_district` VALUES ('1411', '长丰', '219', 'z', 'zf', 'zhangfeng', '', '县', '340121', '0551', 5);
INSERT INTO `sys_district` VALUES ('1412', '肥东', '219', 'f', 'fd', 'feidong', '', '县', '340122', '0551', 6);
INSERT INTO `sys_district` VALUES ('1413', '肥西', '219', 'f', 'fx', 'feixi', '', '县', '340123', '0551', 7);
INSERT INTO `sys_district` VALUES ('1414', '庐江', '219', 'l', 'lj', 'lujiang', '', '县', '340124', '0551', 8);
INSERT INTO `sys_district` VALUES ('1415', '巢湖', '219', 'c', 'ch', 'chaohu', '', '市', '340181', '0551', 9);
INSERT INTO `sys_district` VALUES ('1416', '镜湖', '220', 'j', 'jh', 'jinghu', '', '区', '340202', '0553', 1);
INSERT INTO `sys_district` VALUES ('1417', '弋江', '220', 'y', 'yj', 'yijiang', '', '区', '340203', '0553', 2);
INSERT INTO `sys_district` VALUES ('1418', '鸠江', '220', 'j', 'jj', 'jiujiang', '', '区', '340207', '0553', 3);
INSERT INTO `sys_district` VALUES ('1419', '三山', '220', 's', 'ss', 'sanshan', '', '区', '340208', '0553', 4);
INSERT INTO `sys_district` VALUES ('142', '晋中', '6', 'j', 'jz', 'jinzhong', '', '市', '140700', '0354', 7);
INSERT INTO `sys_district` VALUES ('1420', '芜湖', '220', 'w', 'wh', 'wuhu', '', '县', '340221', '0553', 5);
INSERT INTO `sys_district` VALUES ('1421', '繁昌', '220', 'f', 'fc', 'fanchang', '', '县', '340222', '0553', 6);
INSERT INTO `sys_district` VALUES ('1422', '南陵', '220', 'n', 'nl', 'nanling', '', '县', '340223', '0553', 7);
INSERT INTO `sys_district` VALUES ('1423', '无为', '220', 'w', 'ww', 'wuwei', '', '县', '340225', '0553', 8);
INSERT INTO `sys_district` VALUES ('1424', '龙子湖', '221', 'l', 'lzh', 'longzihu', '', '区', '340302', '0552', 1);
INSERT INTO `sys_district` VALUES ('1425', '蚌山', '221', 'b', 'bs', 'bangshan', '', '区', '340303', '0552', 2);
INSERT INTO `sys_district` VALUES ('1426', '禹会', '221', 'y', 'yh', 'yuhui', '', '区', '340304', '0552', 3);
INSERT INTO `sys_district` VALUES ('1427', '淮上', '221', 'h', 'hs', 'huaishang', '', '区', '340311', '0552', 4);
INSERT INTO `sys_district` VALUES ('1428', '怀远', '221', 'h', 'hy', 'huaiyuan', '', '县', '340321', '0552', 5);
INSERT INTO `sys_district` VALUES ('1429', '五河', '221', 'w', 'wh', 'wuhe', '', '县', '340322', '0552', 6);
INSERT INTO `sys_district` VALUES ('143', '运城', '6', 'y', 'yc', 'yuncheng', '', '市', '140800', '0359', 8);
INSERT INTO `sys_district` VALUES ('1430', '固镇', '221', 'g', 'gz', 'guzhen', '', '县', '340323', '0552', 7);
INSERT INTO `sys_district` VALUES ('1431', '大通', '222', 'd', 'dt', 'datong', '', '区', '340402', '0554', 1);
INSERT INTO `sys_district` VALUES ('1432', '田家庵', '222', 't', 'tja', 'tianjiaan', '', '区', '340403', '0554', 2);
INSERT INTO `sys_district` VALUES ('1433', '谢家集', '222', 'x', 'xjj', 'xiejiaji', '', '区', '340404', '0554', 3);
INSERT INTO `sys_district` VALUES ('1434', '八公山', '222', 'b', 'bgs', 'bagongshan', '', '区', '340405', '0554', 4);
INSERT INTO `sys_district` VALUES ('1435', '潘集', '222', 'p', 'pj', 'panji', '', '区', '340406', '0554', 5);
INSERT INTO `sys_district` VALUES ('1436', '凤台', '222', 'f', 'ft', 'fengtai', '', '县', '340421', '0554', 6);
INSERT INTO `sys_district` VALUES ('1437', '花山', '223', 'h', 'hs', 'huashan', '', '区', '340503', '0555', 1);
INSERT INTO `sys_district` VALUES ('1438', '雨山', '223', 'y', 'ys', 'yushan', '', '区', '340504', '0555', 2);
INSERT INTO `sys_district` VALUES ('1439', '博望', '223', 'b', 'bw', 'bowang', '', '区', '340506', '0555', 3);
INSERT INTO `sys_district` VALUES ('144', '忻州', '6', 'x', 'xz', 'xinzhou', '', '市', '140900', '0350', 9);
INSERT INTO `sys_district` VALUES ('1440', '当涂', '223', 'd', 'dt', 'dangtu', '', '县', '340521', '0555', 4);
INSERT INTO `sys_district` VALUES ('1441', '含山', '223', 'h', 'hs', 'hanshan', '', '县', '340522', '0555', 5);
INSERT INTO `sys_district` VALUES ('1442', '和县', '223', 'h', 'hx', 'hexian', '', '', '340523', '0555', 6);
INSERT INTO `sys_district` VALUES ('1443', '杜集', '224', 'd', 'dj', 'duji', '', '区', '340602', '0561', 1);
INSERT INTO `sys_district` VALUES ('1444', '相山', '224', 'x', 'xs', 'xiangshan', '', '区', '340603', '0561', 2);
INSERT INTO `sys_district` VALUES ('1445', '烈山', '224', 'l', 'ls', 'lieshan', '', '区', '340604', '0561', 3);
INSERT INTO `sys_district` VALUES ('1446', '濉溪', '224', 's', 'sx', 'suixi', '', '县', '340621', '0561', 4);
INSERT INTO `sys_district` VALUES ('1447', '铜官山', '225', 't', 'tgs', 'tongguanshan', '', '区', '340702', '0562', 1);
INSERT INTO `sys_district` VALUES ('1449', '郊区', '225', 'j', 'jq', 'jiaoqu', '', '', '340711', '0562', 3);
INSERT INTO `sys_district` VALUES ('145', '临汾', '6', 'l', 'lf', 'linfen', '', '市', '141000', '0357', 10);
INSERT INTO `sys_district` VALUES ('1450', '义安', '225', 'y', 'ya', 'yian', '', '区', '340721', '0562', 4);
INSERT INTO `sys_district` VALUES ('1451', '迎江', '226', 'y', 'yj', 'yingjiang', '', '区', '340802', '0556', 1);
INSERT INTO `sys_district` VALUES ('1452', '大观', '226', 'd', 'dg', 'daguan', '', '区', '340803', '0556', 2);
INSERT INTO `sys_district` VALUES ('1453', '宜秀', '226', 'y', 'yx', 'yixiu', '', '区', '340811', '0556', 3);
INSERT INTO `sys_district` VALUES ('1454', '怀宁', '226', 'h', 'hn', 'huaining', '', '县', '340822', '0556', 4);
INSERT INTO `sys_district` VALUES ('1455', '枞阳', '225', 'z', 'zy', 'zongyang', '', '县', '340823', '0556', 5);
INSERT INTO `sys_district` VALUES ('1456', '潜山', '226', 'q', 'qs', 'qianshan', '', '县', '340824', '0556', 6);
INSERT INTO `sys_district` VALUES ('1457', '太湖', '226', 't', 'th', 'taihu', '', '县', '340825', '0556', 7);
INSERT INTO `sys_district` VALUES ('1458', '宿松', '226', 's', 'ss', 'susong', '', '县', '340826', '0556', 8);
INSERT INTO `sys_district` VALUES ('1459', '望江', '226', 'w', 'wj', 'wangjiang', '', '县', '340827', '0556', 9);
INSERT INTO `sys_district` VALUES ('146', '吕梁', '6', 'l', 'll', 'lvliang', '', '市', '141100', '0358', 11);
INSERT INTO `sys_district` VALUES ('1460', '岳西', '226', 'y', 'yx', 'yuexi', '', '县', '340828', '0556', 10);
INSERT INTO `sys_district` VALUES ('1461', '桐城', '226', 't', 'tc', 'tongcheng', '', '市', '340881', '0556', 11);
INSERT INTO `sys_district` VALUES ('1462', '屯溪', '227', 't', 'tx', 'tunxi', '', '区', '341002', '0559', 1);
INSERT INTO `sys_district` VALUES ('1463', '黄山', '227', 'h', 'hs', 'huangshan', '', '区', '341003', '0559', 2);
INSERT INTO `sys_district` VALUES ('1464', '徽州', '227', 'h', 'hz', 'huizhou', '', '区', '341004', '0559', 3);
INSERT INTO `sys_district` VALUES ('1465', '歙县', '227', 's', 'sx', 'shexian', '', '', '341021', '0559', 4);
INSERT INTO `sys_district` VALUES ('1466', '休宁', '227', 'x', 'xn', 'xiuning', '', '县', '341022', '0559', 5);
INSERT INTO `sys_district` VALUES ('1467', '黟县', '227', 'y', 'yx', 'yixian', '', '', '341023', '0559', 6);
INSERT INTO `sys_district` VALUES ('1468', '祁门', '227', 'q', 'qm', 'qimen', '', '县', '341024', '0559', 7);
INSERT INTO `sys_district` VALUES ('1469', '琅玡', '228', 'l', 'ly', 'langya', '', '区', '341102', '0550', 1);
INSERT INTO `sys_district` VALUES ('147', '呼和浩特', '7', 'h', 'hhht', 'huhehaote', '', '市', '150100', '0471', 1);
INSERT INTO `sys_district` VALUES ('1470', '南谯', '228', 'n', 'nq', 'nanqiao', '', '区', '341103', '0550', 2);
INSERT INTO `sys_district` VALUES ('1471', '来安', '228', 'l', 'la', 'laian', '', '县', '341122', '0550', 3);
INSERT INTO `sys_district` VALUES ('1472', '全椒', '228', 'q', 'qj', 'quanjiao', '', '县', '341124', '0550', 4);
INSERT INTO `sys_district` VALUES ('1473', '定远', '228', 'd', 'dy', 'dingyuan', '', '县', '341125', '0550', 5);
INSERT INTO `sys_district` VALUES ('1474', '凤阳', '228', 'f', 'fy', 'fengyang', '', '县', '341126', '0550', 6);
INSERT INTO `sys_district` VALUES ('1475', '天长', '228', 't', 'tz', 'tianzhang', '', '市', '341181', '0550', 7);
INSERT INTO `sys_district` VALUES ('1476', '明光', '228', 'm', 'mg', 'mingguang', '', '市', '341182', '0550', 8);
INSERT INTO `sys_district` VALUES ('1477', '颍州', '229', 'y', 'yz', 'yingzhou', '', '区', '341202', '0558', 1);
INSERT INTO `sys_district` VALUES ('1478', '颍东', '229', 'y', 'yd', 'yingdong', '', '区', '341203', '0558', 2);
INSERT INTO `sys_district` VALUES ('1479', '颍泉', '229', 'y', 'yq', 'yingquan', '', '区', '341204', '0558', 3);
INSERT INTO `sys_district` VALUES ('148', '包头', '7', 'b', 'bt', 'baotou', '', '市', '150200', '0472', 2);
INSERT INTO `sys_district` VALUES ('1480', '临泉', '229', 'l', 'lq', 'linquan', '', '县', '341221', '0558', 4);
INSERT INTO `sys_district` VALUES ('1481', '太和', '229', 't', 'th', 'taihe', '', '县', '341222', '0558', 5);
INSERT INTO `sys_district` VALUES ('1482', '阜南', '229', 'f', 'fn', 'funan', '', '县', '341225', '0558', 6);
INSERT INTO `sys_district` VALUES ('1483', '颖上', '229', 'y', 'ys', 'yingshang', '', '县', '341226', '0558', 7);
INSERT INTO `sys_district` VALUES ('1484', '界首', '229', 'j', 'js', 'jieshou', '', '市', '341282', '0558', 8);
INSERT INTO `sys_district` VALUES ('1485', '埇桥', '230', 'y', 'yq', 'yongqiao', '', '区', '341302', '0557', 1);
INSERT INTO `sys_district` VALUES ('1486', '砀山', '230', 'd', 'ds', 'dangshan', '', '县', '341321', '0557', 2);
INSERT INTO `sys_district` VALUES ('1487', '萧县', '230', 'x', 'xx', 'xiaoxian', '', '', '341322', '0557', 3);
INSERT INTO `sys_district` VALUES ('1488', '灵璧', '230', 'l', 'lb', 'lingbi', '', '县', '341323', '0557', 4);
INSERT INTO `sys_district` VALUES ('1489', '泗县', '230', 's', 'sx', 'sixian', '', '', '341324', '0557', 5);
INSERT INTO `sys_district` VALUES ('149', '乌海', '7', 'w', 'wh', 'wuhai', '', '市', '150300', '0473', 3);
INSERT INTO `sys_district` VALUES ('1490', '金安', '231', 'j', 'ja', 'jinan', '', '区', '341502', '0564', 1);
INSERT INTO `sys_district` VALUES ('1491', '裕安', '231', 'y', 'ya', 'yuan', '', '区', '341503', '0564', 2);
INSERT INTO `sys_district` VALUES ('1492', '寿县', '222', 's', 'sx', 'shouxian', '', '', '341521', '0564', 3);
INSERT INTO `sys_district` VALUES ('1493', '霍邱', '231', 'h', 'hq', 'huoqiu', '', '县', '341522', '0564', 4);
INSERT INTO `sys_district` VALUES ('1494', '舒城', '231', 's', 'sc', 'shucheng', '', '县', '341523', '0564', 5);
INSERT INTO `sys_district` VALUES ('1495', '金寨', '231', 'j', 'jz', 'jinzhai', '', '县', '341524', '0564', 6);
INSERT INTO `sys_district` VALUES ('1496', '霍山', '231', 'h', 'hs', 'huoshan', '', '县', '341525', '0564', 7);
INSERT INTO `sys_district` VALUES ('1497', '谯城', '232', 'q', 'qc', 'qiaocheng', '', '区', '341602', '0558', 1);
INSERT INTO `sys_district` VALUES ('1498', '涡阳', '232', 'w', 'wy', 'woyang', '', '县', '341621', '0558', 2);
INSERT INTO `sys_district` VALUES ('1499', '蒙城', '232', 'm', 'mc', 'mengcheng', '', '县', '341622', '0558', 3);
INSERT INTO `sys_district` VALUES ('15', '江西', '0', 'j', 'jx', 'jiangxi', '', '省', '360000', '', 16);
INSERT INTO `sys_district` VALUES ('150', '赤峰', '7', 'c', 'cf', 'chifeng', '', '市', '150400', '0476', 4);
INSERT INTO `sys_district` VALUES ('1500', '利辛', '232', 'l', 'lx', 'lixin', '', '县', '341623', '0558', 4);
INSERT INTO `sys_district` VALUES ('1501', '贵池', '233', 'g', 'gc', 'guichi', '', '区', '341702', '0566', 1);
INSERT INTO `sys_district` VALUES ('1502', '东至', '233', 'd', 'dz', 'dongzhi', '', '县', '341721', '0566', 2);
INSERT INTO `sys_district` VALUES ('1503', '石台', '233', 's', 'st', 'shitai', '', '县', '341722', '0566', 3);
INSERT INTO `sys_district` VALUES ('1504', '青阳', '233', 'q', 'qy', 'qingyang', '', '县', '341723', '0566', 4);
INSERT INTO `sys_district` VALUES ('1505', '宣州', '234', 'x', 'xz', 'xuanzhou', '', '区', '341802', '0563', 1);
INSERT INTO `sys_district` VALUES ('1506', '郎溪', '234', 'l', 'lx', 'langxi', '', '县', '341821', '0563', 2);
INSERT INTO `sys_district` VALUES ('1507', '广德', '234', 'g', 'gd', 'guangde', '', '县', '341822', '0563', 3);
INSERT INTO `sys_district` VALUES ('1508', '泾县', '234', 'j', 'jx', 'jingxian', '', '', '341823', '0563', 4);
INSERT INTO `sys_district` VALUES ('1509', '绩溪', '234', 'j', 'jx', 'jixi', '', '县', '341824', '0563', 5);
INSERT INTO `sys_district` VALUES ('151', '通辽', '7', 't', 'tl', 'tongliao', '', '市', '150500', '0475', 5);
INSERT INTO `sys_district` VALUES ('1510', '旌德', '234', 'j', 'jd', 'jingde', '', '县', '341825', '0563', 6);
INSERT INTO `sys_district` VALUES ('1511', '宁国', '234', 'n', 'ng', 'ningguo', '', '市', '341881', '0563', 7);
INSERT INTO `sys_district` VALUES ('1512', '鼓楼', '235', 'g', 'gl', 'gulou', '', '区', '350102', '0591', 1);
INSERT INTO `sys_district` VALUES ('1513', '台江', '235', 't', 'tj', 'taijiang', '', '区', '350103', '0591', 2);
INSERT INTO `sys_district` VALUES ('1514', '仓山', '235', 'c', 'cs', 'cangshan', '', '区', '350104', '0591', 3);
INSERT INTO `sys_district` VALUES ('1515', '马尾', '235', 'm', 'mw', 'mawei', '', '区', '350105', '0591', 4);
INSERT INTO `sys_district` VALUES ('1516', '晋安', '235', 'j', 'ja', 'jinan', '', '区', '350111', '0591', 5);
INSERT INTO `sys_district` VALUES ('1517', '闽侯', '235', 'm', 'mh', 'minhou', '', '县', '350121', '0591', 7);
INSERT INTO `sys_district` VALUES ('1518', '连江', '235', 'l', 'lj', 'lianjiang', '', '县', '350122', '0591', 8);
INSERT INTO `sys_district` VALUES ('1519', '罗源', '235', 'l', 'ly', 'luoyuan', '', '县', '350123', '0591', 9);
INSERT INTO `sys_district` VALUES ('152', '鄂尔多斯', '7', 'e', 'eeds', 'eerduosi', '', '市', '150600', '0477', 6);
INSERT INTO `sys_district` VALUES ('1520', '闽清', '235', 'm', 'mq', 'minqing', '', '县', '350124', '0591', 10);
INSERT INTO `sys_district` VALUES ('1521', '永泰', '235', 'y', 'yt', 'yongtai', '', '县', '350125', '0591', 11);
INSERT INTO `sys_district` VALUES ('1522', '平潭', '235', 'p', 'pt', 'pingtan', '', '县', '350128', '0591', 12);
INSERT INTO `sys_district` VALUES ('1523', '福清', '235', 'f', 'fq', 'fuqing', '', '市', '350181', '0591', 13);
INSERT INTO `sys_district` VALUES ('1524', '长乐', '235', 'z', 'zl', 'zhangle', '', '区', '350112', '0591', 6);
INSERT INTO `sys_district` VALUES ('1525', '思明', '236', 's', 'sm', 'siming', '', '区', '350203', '0592', 1);
INSERT INTO `sys_district` VALUES ('1526', '海沧', '236', 'h', 'hc', 'haicang', '', '区', '350205', '0592', 2);
INSERT INTO `sys_district` VALUES ('1527', '湖里', '236', 'h', 'hl', 'huli', '', '区', '350206', '0592', 3);
INSERT INTO `sys_district` VALUES ('1528', '集美', '236', 'j', 'jm', 'jimei', '', '区', '350211', '0592', 4);
INSERT INTO `sys_district` VALUES ('1529', '同安', '236', 't', 'ta', 'tongan', '', '区', '350212', '0592', 5);
INSERT INTO `sys_district` VALUES ('153', '呼伦贝尔', '7', 'h', 'hlbe', 'hulunbeier', '', '市', '150700', '0470', 7);
INSERT INTO `sys_district` VALUES ('1530', '翔安', '236', 'x', 'xa', 'xiangan', '', '区', '350213', '0592', 6);
INSERT INTO `sys_district` VALUES ('1531', '城厢', '237', 'c', 'cx', 'chengxiang', '', '区', '350302', '0594', 1);
INSERT INTO `sys_district` VALUES ('1532', '涵江', '237', 'h', 'hj', 'hanjiang', '', '区', '350303', '0594', 2);
INSERT INTO `sys_district` VALUES ('1533', '荔城', '237', 'l', 'lc', 'licheng', '', '区', '350304', '0594', 3);
INSERT INTO `sys_district` VALUES ('1534', '秀屿', '237', 'x', 'xy', 'xiuyu', '', '区', '350305', '0594', 4);
INSERT INTO `sys_district` VALUES ('1535', '仙游', '237', 'x', 'xy', 'xianyou', '', '县', '350322', '0594', 5);
INSERT INTO `sys_district` VALUES ('1536', '梅列', '238', 'm', 'ml', 'meilie', '', '区', '350402', '0598', 1);
INSERT INTO `sys_district` VALUES ('1537', '三元', '238', 's', 'sy', 'sanyuan', '', '区', '350403', '0598', 2);
INSERT INTO `sys_district` VALUES ('1538', '明溪', '238', 'm', 'mx', 'mingxi', '', '县', '350421', '0598', 3);
INSERT INTO `sys_district` VALUES ('1539', '清流', '238', 'q', 'ql', 'qingliu', '', '县', '350423', '0598', 4);
INSERT INTO `sys_district` VALUES ('154', '巴彦淖尔', '7', 'b', 'byne', 'bayannaoer', '', '市', '150800', '0478', 8);
INSERT INTO `sys_district` VALUES ('1540', '宁化', '238', 'n', 'nh', 'ninghua', '', '县', '350424', '0598', 5);
INSERT INTO `sys_district` VALUES ('1541', '大田', '238', 'd', 'dt', 'datian', '', '县', '350425', '0598', 6);
INSERT INTO `sys_district` VALUES ('1542', '尤溪', '238', 'y', 'yx', 'youxi', '', '县', '350426', '0598', 7);
INSERT INTO `sys_district` VALUES ('1543', '沙县', '238', 's', 'sx', 'shaxian', '', '', '350427', '0598', 8);
INSERT INTO `sys_district` VALUES ('1544', '将乐', '238', 'j', 'jl', 'jiangle', '', '县', '350428', '0598', 9);
INSERT INTO `sys_district` VALUES ('1545', '泰宁', '238', 't', 'tn', 'taining', '', '县', '350429', '0598', 10);
INSERT INTO `sys_district` VALUES ('1546', '建宁', '238', 'j', 'jn', 'jianning', '', '县', '350430', '0598', 11);
INSERT INTO `sys_district` VALUES ('1547', '永安', '238', 'y', 'ya', 'yongan', '', '市', '350481', '0598', 12);
INSERT INTO `sys_district` VALUES ('1548', '鲤城', '239', 'l', 'lc', 'licheng', '', '区', '350502', '0595', 1);
INSERT INTO `sys_district` VALUES ('1549', '丰泽', '239', 'f', 'fz', 'fengze', '', '区', '350503', '0595', 2);
INSERT INTO `sys_district` VALUES ('155', '乌兰察布', '7', 'w', 'wlcb', 'wulanchabu', '', '市', '150900', '0474', 9);
INSERT INTO `sys_district` VALUES ('1550', '洛江', '239', 'l', 'lj', 'luojiang', '', '区', '350504', '0595', 3);
INSERT INTO `sys_district` VALUES ('1551', '泉港', '239', 'q', 'qg', 'quangang', '', '区', '350505', '0595', 4);
INSERT INTO `sys_district` VALUES ('1552', '惠安', '239', 'h', 'ha', 'huian', '', '县', '350521', '0595', 5);
INSERT INTO `sys_district` VALUES ('1553', '安溪', '239', 'a', 'ax', 'anxi', '', '县', '350524', '0595', 6);
INSERT INTO `sys_district` VALUES ('1554', '永春', '239', 'y', 'yc', 'yongchun', '', '县', '350525', '0595', 7);
INSERT INTO `sys_district` VALUES ('1555', '德化', '239', 'd', 'dh', 'dehua', '', '县', '350526', '0595', 8);
INSERT INTO `sys_district` VALUES ('1556', '金门', '239', 'j', 'jm', 'jinmen', '', '县', '350527', '0595', 9);
INSERT INTO `sys_district` VALUES ('1557', '石狮', '239', 's', 'ss', 'shishi', '', '市', '350581', '0595', 10);
INSERT INTO `sys_district` VALUES ('1558', '晋江', '239', 'j', 'jj', 'jinjiang', '', '市', '350582', '0595', 11);
INSERT INTO `sys_district` VALUES ('1559', '南安', '239', 'n', 'na', 'nanan', '', '市', '350583', '0595', 12);
INSERT INTO `sys_district` VALUES ('156', '兴安', '7', 'x', 'xa', 'xingan', '', '盟', '152200', '0482', 10);
INSERT INTO `sys_district` VALUES ('1560', '芗城', '240', 'x', 'xc', 'xiangcheng', '', '区', '350602', '0596', 1);
INSERT INTO `sys_district` VALUES ('1561', '龙文', '240', 'l', 'lw', 'longwen', '', '区', '350603', '0596', 2);
INSERT INTO `sys_district` VALUES ('1562', '云霄', '240', 'y', 'yx', 'yunxiao', '', '县', '350622', '0596', 3);
INSERT INTO `sys_district` VALUES ('1563', '漳浦', '240', 'z', 'zp', 'zhangpu', '', '县', '350623', '0596', 4);
INSERT INTO `sys_district` VALUES ('1564', '诏安', '240', 'z', 'za', 'zhaoan', '', '县', '350624', '0596', 5);
INSERT INTO `sys_district` VALUES ('1565', '长泰', '240', 'z', 'zt', 'zhangtai', '', '县', '350625', '0596', 6);
INSERT INTO `sys_district` VALUES ('1566', '东山', '240', 'd', 'ds', 'dongshan', '', '县', '350626', '0596', 7);
INSERT INTO `sys_district` VALUES ('1567', '南靖', '240', 'n', 'nj', 'nanjing', '', '县', '350627', '0596', 8);
INSERT INTO `sys_district` VALUES ('1568', '平和', '240', 'p', 'ph', 'pinghe', '', '县', '350628', '0596', 9);
INSERT INTO `sys_district` VALUES ('1569', '华安', '240', 'h', 'ha', 'huaan', '', '县', '350629', '0596', 10);
INSERT INTO `sys_district` VALUES ('157', '锡林郭勒', '7', 'x', 'xlgl', 'xilinguole', '', '盟', '152500', '0479', 11);
INSERT INTO `sys_district` VALUES ('1570', '龙海', '240', 'l', 'lh', 'longhai', '', '市', '350681', '0596', 11);
INSERT INTO `sys_district` VALUES ('1571', '延平', '241', 'y', 'yp', 'yanping', '', '区', '350702', '0599', 1);
INSERT INTO `sys_district` VALUES ('1572', '顺昌', '241', 's', 'sc', 'shunchang', '', '县', '350721', '0599', 3);
INSERT INTO `sys_district` VALUES ('1573', '浦城', '241', 'p', 'pc', 'pucheng', '', '县', '350722', '0599', 4);
INSERT INTO `sys_district` VALUES ('1574', '光泽', '241', 'g', 'gz', 'guangze', '', '县', '350723', '0599', 5);
INSERT INTO `sys_district` VALUES ('1575', '松溪', '241', 's', 'sx', 'songxi', '', '县', '350724', '0599', 6);
INSERT INTO `sys_district` VALUES ('1576', '政和', '241', 'z', 'zh', 'zhenghe', '', '县', '350725', '0599', 7);
INSERT INTO `sys_district` VALUES ('1577', '邵武', '241', 's', 'sw', 'shaowu', '', '市', '350781', '0599', 8);
INSERT INTO `sys_district` VALUES ('1578', '武夷山', '241', 'w', 'wys', 'wuyishan', '', '市', '350782', '0599', 9);
INSERT INTO `sys_district` VALUES ('1579', '建瓯', '241', 'j', 'jo', 'jianou', '', '市', '350783', '0599', 10);
INSERT INTO `sys_district` VALUES ('158', '阿拉善', '7', 'a', 'als', 'alashan', '', '盟', '152900', '0483', 12);
INSERT INTO `sys_district` VALUES ('1580', '建阳', '241', 'j', 'jy', 'jianyang', '', '区', '350703', '0599', 2);
INSERT INTO `sys_district` VALUES ('1581', '新罗', '242', 'x', 'xl', 'xinluo', '', '区', '350802', '0597', 1);
INSERT INTO `sys_district` VALUES ('1582', '长汀', '242', 'z', 'zt', 'zhangting', '', '县', '350821', '0597', 3);
INSERT INTO `sys_district` VALUES ('1583', '永定', '242', 'y', 'yd', 'yongding', '', '区', '350803', '0597', 2);
INSERT INTO `sys_district` VALUES ('1584', '上杭', '242', 's', 'sh', 'shanghang', '', '县', '350823', '0597', 4);
INSERT INTO `sys_district` VALUES ('1585', '武平', '242', 'w', 'wp', 'wuping', '', '县', '350824', '0597', 5);
INSERT INTO `sys_district` VALUES ('1586', '连城', '242', 'l', 'lc', 'liancheng', '', '县', '350825', '0597', 6);
INSERT INTO `sys_district` VALUES ('1587', '漳平', '242', 'z', 'zp', 'zhangping', '', '市', '350881', '0597', 7);
INSERT INTO `sys_district` VALUES ('1588', '蕉城', '243', 'j', 'jc', 'jiaocheng', '', '区', '350902', '0593', 1);
INSERT INTO `sys_district` VALUES ('1589', '霞浦', '243', 'x', 'xp', 'xiapu', '', '县', '350921', '0593', 2);
INSERT INTO `sys_district` VALUES ('159', '沈阳', '8', 's', 'sy', 'shenyang', '', '市', '210100', '024', 1);
INSERT INTO `sys_district` VALUES ('1590', '古田', '243', 'g', 'gt', 'gutian', '', '县', '350922', '0593', 3);
INSERT INTO `sys_district` VALUES ('1591', '屏南', '243', 'p', 'pn', 'pingnan', '', '县', '350923', '0593', 4);
INSERT INTO `sys_district` VALUES ('1592', '寿宁', '243', 's', 'sn', 'shouning', '', '县', '350924', '0593', 5);
INSERT INTO `sys_district` VALUES ('1593', '周宁', '243', 'z', 'zn', 'zhouning', '', '县', '350925', '0593', 6);
INSERT INTO `sys_district` VALUES ('1594', '柘荣', '243', 'z', 'zr', 'zherong', '', '县', '350926', '0593', 7);
INSERT INTO `sys_district` VALUES ('1595', '福安', '243', 'f', 'fa', 'fuan', '', '市', '350981', '0593', 8);
INSERT INTO `sys_district` VALUES ('1596', '福鼎', '243', 'f', 'fd', 'fuding', '', '市', '350982', '0593', 9);
INSERT INTO `sys_district` VALUES ('1597', '东湖', '244', 'd', 'dh', 'donghu', '', '区', '360102', '0791', 1);
INSERT INTO `sys_district` VALUES ('1598', '西湖', '244', 'x', 'xh', 'xihu', '', '区', '360103', '0791', 2);
INSERT INTO `sys_district` VALUES ('1599', '青云谱', '244', 'q', 'qyp', 'qingyunpu', '', '区', '360104', '0791', 3);
INSERT INTO `sys_district` VALUES ('16', '山东', '0', 's', 'sd', 'shandong', '', '省', '370000', '', 17);
INSERT INTO `sys_district` VALUES ('160', '大连', '8', 'd', 'dl', 'dalian', '', '市', '210200', '0411', 2);
INSERT INTO `sys_district` VALUES ('1600', '湾里', '244', 'w', 'wl', 'wanli', '', '区', '360105', '0791', 4);
INSERT INTO `sys_district` VALUES ('1601', '青山湖', '244', 'q', 'qsh', 'qingshanhu', '', '区', '360111', '0791', 5);
INSERT INTO `sys_district` VALUES ('1602', '南昌', '244', 'n', 'nc', 'nanchang', '', '县', '360121', '0791', 6);
INSERT INTO `sys_district` VALUES ('1603', '新建', '244', 'x', 'xj', 'xinjian', '', '区', '360122', '0791', 7);
INSERT INTO `sys_district` VALUES ('1604', '安义', '244', 'a', 'ay', 'anyi', '', '县', '360123', '0791', 8);
INSERT INTO `sys_district` VALUES ('1605', '进贤', '244', 'j', 'jx', 'jinxian', '', '县', '360124', '0791', 9);
INSERT INTO `sys_district` VALUES ('1606', '昌江', '245', 'c', 'cj', 'changjiang', '', '区', '360202', '0798', 1);
INSERT INTO `sys_district` VALUES ('1607', '珠山', '245', 'z', 'zs', 'zhushan', '', '区', '360203', '0798', 2);
INSERT INTO `sys_district` VALUES ('1608', '浮梁', '245', 'f', 'fl', 'fuliang', '', '县', '360222', '0798', 3);
INSERT INTO `sys_district` VALUES ('1609', '乐平', '245', 'l', 'lp', 'leping', '', '市', '360281', '0798', 4);
INSERT INTO `sys_district` VALUES ('161', '鞍山', '8', 'a', 'as', 'anshan', '', '市', '210300', '0412', 3);
INSERT INTO `sys_district` VALUES ('1610', '安源', '246', 'a', 'ay', 'anyuan', '', '区', '360302', '0799', 1);
INSERT INTO `sys_district` VALUES ('1611', '湘东', '246', 'x', 'xd', 'xiangdong', '', '区', '360313', '0799', 2);
INSERT INTO `sys_district` VALUES ('1612', '莲花', '246', 'l', 'lh', 'lianhua', '', '县', '360321', '0799', 3);
INSERT INTO `sys_district` VALUES ('1613', '上栗', '246', 's', 'sl', 'shangli', '', '县', '360322', '0799', 4);
INSERT INTO `sys_district` VALUES ('1614', '芦溪', '246', 'l', 'lx', 'luxi', '', '县', '360323', '0799', 5);
INSERT INTO `sys_district` VALUES ('1615', '濂溪', '247', 'l', 'lx', 'lianxi', '', '区', '360402', '0792', 1);
INSERT INTO `sys_district` VALUES ('1616', '浔阳', '247', 'x', 'xy', 'xunyang', '', '区', '360403', '0792', 2);
INSERT INTO `sys_district` VALUES ('1617', '九江', '247', 'j', 'jj', 'jiujiang', '', '县', '360421', '0792', 3);
INSERT INTO `sys_district` VALUES ('1618', '武宁', '247', 'w', 'wn', 'wuning', '', '县', '360423', '0792', 4);
INSERT INTO `sys_district` VALUES ('1619', '修水', '247', 'x', 'xs', 'xiushui', '', '县', '360424', '0792', 5);
INSERT INTO `sys_district` VALUES ('162', '抚顺', '8', 'f', 'fs', 'fushun', '', '市', '210400', '0413', 4);
INSERT INTO `sys_district` VALUES ('1620', '永修', '247', 'y', 'yx', 'yongxiu', '', '县', '360425', '0792', 6);
INSERT INTO `sys_district` VALUES ('1621', '德安', '247', 'd', 'da', 'dean', '', '县', '360426', '0792', 7);
INSERT INTO `sys_district` VALUES ('1622', '庐山', '247', 'l', 'ls', 'lushan', '', '市', '360427', '0792', 8);
INSERT INTO `sys_district` VALUES ('1623', '都昌', '247', 'd', 'dc', 'duchang', '', '县', '360428', '0792', 9);
INSERT INTO `sys_district` VALUES ('1624', '湖口', '247', 'h', 'hk', 'hukou', '', '县', '360429', '0792', 10);
INSERT INTO `sys_district` VALUES ('1625', '彭泽', '247', 'p', 'pz', 'pengze', '', '县', '360430', '0792', 11);
INSERT INTO `sys_district` VALUES ('1626', '瑞昌', '247', 'r', 'rc', 'ruichang', '', '市', '360481', '0792', 12);
INSERT INTO `sys_district` VALUES ('1627', '共青城', '247', 'g', 'gqc', 'gongqingcheng', '', '市', '360482', '0792', 13);
INSERT INTO `sys_district` VALUES ('1628', '渝水', '248', 'y', 'ys', 'yushui', '', '区', '360502', '0790', 1);
INSERT INTO `sys_district` VALUES ('1629', '分宜', '248', 'f', 'fy', 'fenyi', '', '县', '360521', '0790', 2);
INSERT INTO `sys_district` VALUES ('163', '本溪', '8', 'b', 'bx', 'benxi', '', '市', '210500', '0414', 5);
INSERT INTO `sys_district` VALUES ('1630', '月湖', '249', 'y', 'yh', 'yuehu', '', '区', '360602', '0701', 1);
INSERT INTO `sys_district` VALUES ('1631', '余江', '249', 'y', 'yj', 'yujiang', '', '县', '360622', '0701', 2);
INSERT INTO `sys_district` VALUES ('1632', '贵溪', '249', 'g', 'gx', 'guixi', '', '市', '360681', '0701', 3);
INSERT INTO `sys_district` VALUES ('1633', '章贡', '250', 'z', 'zg', 'zhanggong', '', '区', '360702', '0797', 1);
INSERT INTO `sys_district` VALUES ('1634', '赣县', '250', 'g', 'gx', 'ganxian', '', '区', '360721', '0797', 2);
INSERT INTO `sys_district` VALUES ('1635', '信丰', '250', 'x', 'xf', 'xinfeng', '', '县', '360722', '0797', 3);
INSERT INTO `sys_district` VALUES ('1636', '大余', '250', 'd', 'dy', 'dayu', '', '县', '360723', '0797', 4);
INSERT INTO `sys_district` VALUES ('1637', '上犹', '250', 's', 'sy', 'shangyou', '', '县', '360724', '0797', 5);
INSERT INTO `sys_district` VALUES ('1638', '崇义', '250', 'c', 'cy', 'chongyi', '', '县', '360725', '0797', 6);
INSERT INTO `sys_district` VALUES ('1639', '安远', '250', 'a', 'ay', 'anyuan', '', '县', '360726', '0797', 7);
INSERT INTO `sys_district` VALUES ('164', '丹东', '8', 'd', 'dd', 'dandong', '', '市', '210600', '0415', 6);
INSERT INTO `sys_district` VALUES ('1640', '龙南', '250', 'l', 'ln', 'longnan', '', '县', '360727', '0797', 8);
INSERT INTO `sys_district` VALUES ('1641', '定南', '250', 'd', 'dn', 'dingnan', '', '县', '360728', '0797', 9);
INSERT INTO `sys_district` VALUES ('1642', '全南', '250', 'q', 'qn', 'quannan', '', '县', '360729', '0797', 10);
INSERT INTO `sys_district` VALUES ('1643', '宁都', '250', 'n', 'nd', 'ningdu', '', '县', '360730', '0797', 11);
INSERT INTO `sys_district` VALUES ('1644', '于都', '250', 'y', 'yd', 'yudu', '', '县', '360731', '0797', 12);
INSERT INTO `sys_district` VALUES ('1645', '兴国', '250', 'x', 'xg', 'xingguo', '', '县', '360732', '0797', 13);
INSERT INTO `sys_district` VALUES ('1646', '会昌', '250', 'h', 'hc', 'huichang', '', '县', '360733', '0797', 14);
INSERT INTO `sys_district` VALUES ('1647', '寻乌', '250', 'x', 'xw', 'xunwu', '', '县', '360734', '0797', 15);
INSERT INTO `sys_district` VALUES ('1648', '石城', '250', 's', 'sc', 'shicheng', '', '县', '360735', '0797', 16);
INSERT INTO `sys_district` VALUES ('1649', '瑞金', '250', 'r', 'rj', 'ruijin', '', '市', '360781', '0797', 17);
INSERT INTO `sys_district` VALUES ('165', '锦州', '8', 'j', 'jz', 'jinzhou', '', '市', '210700', '0416', 7);
INSERT INTO `sys_district` VALUES ('1650', '南康', '250', 'n', 'nk', 'nankang', '', '区', '360782', '0797', 18);
INSERT INTO `sys_district` VALUES ('1651', '吉州', '251', 'j', 'jz', 'jizhou', '', '区', '360802', '0796', 1);
INSERT INTO `sys_district` VALUES ('1652', '青原', '251', 'q', 'qy', 'qingyuan', '', '区', '360803', '0796', 2);
INSERT INTO `sys_district` VALUES ('1653', '吉安', '251', 'j', 'ja', 'jian', '', '县', '360821', '0796', 3);
INSERT INTO `sys_district` VALUES ('1654', '吉水', '251', 'j', 'js', 'jishui', '', '县', '360822', '0796', 4);
INSERT INTO `sys_district` VALUES ('1655', '峡江', '251', 'x', 'xj', 'xiajiang', '', '县', '360823', '0796', 5);
INSERT INTO `sys_district` VALUES ('1656', '新干', '251', 'x', 'xg', 'xingan', '', '县', '360824', '0796', 6);
INSERT INTO `sys_district` VALUES ('1657', '永丰', '251', 'y', 'yf', 'yongfeng', '', '县', '360825', '0796', 7);
INSERT INTO `sys_district` VALUES ('1658', '泰和', '251', 't', 'th', 'taihe', '', '县', '360826', '0796', 8);
INSERT INTO `sys_district` VALUES ('1659', '遂川', '251', 's', 'sc', 'suichuan', '', '县', '360827', '0796', 9);
INSERT INTO `sys_district` VALUES ('166', '营口', '8', 'y', 'yk', 'yingkou', '', '市', '210800', '0417', 8);
INSERT INTO `sys_district` VALUES ('1660', '万安', '251', 'w', 'wa', 'wanan', '', '县', '360828', '0796', 10);
INSERT INTO `sys_district` VALUES ('1661', '安福', '251', 'a', 'af', 'anfu', '', '县', '360829', '0796', 11);
INSERT INTO `sys_district` VALUES ('1662', '永新', '251', 'y', 'yx', 'yongxin', '', '县', '360830', '0796', 12);
INSERT INTO `sys_district` VALUES ('1663', '井冈山', '251', 'j', 'jgs', 'jinggangshan', '', '市', '360881', '0796', 13);
INSERT INTO `sys_district` VALUES ('1664', '袁州', '252', 'y', 'yz', 'yuanzhou', '', '区', '360902', '0795', 1);
INSERT INTO `sys_district` VALUES ('1665', '奉新', '252', 'f', 'fx', 'fengxin', '', '县', '360921', '0795', 2);
INSERT INTO `sys_district` VALUES ('1666', '万载', '252', 'w', 'wz', 'wanzai', '', '县', '360922', '0795', 3);
INSERT INTO `sys_district` VALUES ('1667', '上高', '252', 's', 'sg', 'shanggao', '', '县', '360923', '0795', 4);
INSERT INTO `sys_district` VALUES ('1668', '宜丰', '252', 'y', 'yf', 'yifeng', '', '县', '360924', '0795', 5);
INSERT INTO `sys_district` VALUES ('1669', '靖安', '252', 'j', 'ja', 'jingan', '', '县', '360925', '0795', 6);
INSERT INTO `sys_district` VALUES ('167', '阜新', '8', 'f', 'fx', 'fuxin', '', '市', '210900', '0418', 9);
INSERT INTO `sys_district` VALUES ('1670', '铜鼓', '252', 't', 'tg', 'tonggu', '', '县', '360926', '0795', 7);
INSERT INTO `sys_district` VALUES ('1671', '丰城', '252', 'f', 'fc', 'fengcheng', '', '市', '360981', '0795', 8);
INSERT INTO `sys_district` VALUES ('1672', '樟树', '252', 'z', 'zs', 'zhangshu', '', '市', '360982', '0795', 9);
INSERT INTO `sys_district` VALUES ('1673', '高安', '252', 'g', 'ga', 'gaoan', '', '市', '360983', '0795', 10);
INSERT INTO `sys_district` VALUES ('1674', '临川', '253', 'l', 'lc', 'linchuan', '', '区', '361002', '0794', 1);
INSERT INTO `sys_district` VALUES ('1675', '南城', '253', 'n', 'nc', 'nancheng', '', '县', '361021', '0794', 2);
INSERT INTO `sys_district` VALUES ('1676', '黎川', '253', 'l', 'lc', 'lichuan', '', '县', '361022', '0794', 3);
INSERT INTO `sys_district` VALUES ('1677', '南丰', '253', 'n', 'nf', 'nanfeng', '', '县', '361023', '0794', 4);
INSERT INTO `sys_district` VALUES ('1678', '崇仁', '253', 'c', 'cr', 'chongren', '', '县', '361024', '0794', 5);
INSERT INTO `sys_district` VALUES ('1679', '乐安', '253', 'l', 'la', 'lean', '', '县', '361025', '0794', 6);
INSERT INTO `sys_district` VALUES ('168', '辽阳', '8', 'l', 'ly', 'liaoyang', '', '市', '211000', '0419', 10);
INSERT INTO `sys_district` VALUES ('1680', '宜黄', '253', 'y', 'yh', 'yihuang', '', '县', '361026', '0794', 7);
INSERT INTO `sys_district` VALUES ('1681', '金溪', '253', 'j', 'jx', 'jinxi', '', '县', '361027', '0794', 8);
INSERT INTO `sys_district` VALUES ('1682', '资溪', '253', 'z', 'zx', 'zixi', '', '县', '361028', '0794', 9);
INSERT INTO `sys_district` VALUES ('1683', '东乡', '253', 'd', 'dx', 'dongxiang', '', '县', '361029', '0794', 10);
INSERT INTO `sys_district` VALUES ('1684', '广昌', '253', 'g', 'gc', 'guangchang', '', '县', '361030', '0794', 11);
INSERT INTO `sys_district` VALUES ('1685', '信州', '254', 'x', 'xz', 'xinzhou', '', '区', '361102', '0793', 1);
INSERT INTO `sys_district` VALUES ('1686', '上饶', '254', 's', 'sr', 'shangrao', '', '县', '361121', '0793', 3);
INSERT INTO `sys_district` VALUES ('1687', '广丰', '254', 'g', 'gf', 'guangfeng', '', '区', '361122', '0793', 2);
INSERT INTO `sys_district` VALUES ('1688', '玉山', '254', 'y', 'ys', 'yushan', '', '县', '361123', '0793', 4);
INSERT INTO `sys_district` VALUES ('1689', '铅山', '254', 'q', 'qs', 'qianshan', '', '县', '361124', '0793', 5);
INSERT INTO `sys_district` VALUES ('169', '盘锦', '8', 'p', 'pj', 'panjin', '', '市', '211100', '0427', 11);
INSERT INTO `sys_district` VALUES ('1690', '横峰', '254', 'h', 'hf', 'hengfeng', '', '县', '361125', '0793', 6);
INSERT INTO `sys_district` VALUES ('1691', '弋阳', '254', 'y', 'yy', 'yiyang', '', '县', '361126', '0793', 7);
INSERT INTO `sys_district` VALUES ('1692', '余干', '254', 'y', 'yg', 'yugan', '', '县', '361127', '0793', 8);
INSERT INTO `sys_district` VALUES ('1693', '鄱阳', '254', 'p', 'py', 'poyang', '', '县', '361128', '0793', 9);
INSERT INTO `sys_district` VALUES ('1694', '万年', '254', 'w', 'wn', 'wannian', '', '县', '361129', '0793', 10);
INSERT INTO `sys_district` VALUES ('1695', '婺源', '254', 'w', 'wy', 'wuyuan', '', '县', '361130', '0793', 11);
INSERT INTO `sys_district` VALUES ('1696', '德兴', '254', 'd', 'dx', 'dexing', '', '市', '361181', '0793', 12);
INSERT INTO `sys_district` VALUES ('1697', '历下', '255', 'l', 'lx', 'lixia', '', '区', '370102', '0531', 1);
INSERT INTO `sys_district` VALUES ('1698', '市中', '255', 's', 'sz', 'shizhong', '', '区', '370103', '0531', 2);
INSERT INTO `sys_district` VALUES ('1699', '槐荫', '255', 'h', 'hy', 'huaiyin', '', '区', '370104', '0531', 3);
INSERT INTO `sys_district` VALUES ('17', '河南', '0', 'h', 'hn', 'henan', '', '省', '410000', '', 18);
INSERT INTO `sys_district` VALUES ('170', '铁岭', '8', 't', 'tl', 'tieling', '', '市', '211200', '0410', 12);
INSERT INTO `sys_district` VALUES ('1700', '天桥', '255', 't', 'tq', 'tianqiao', '', '区', '370105', '0531', 4);
INSERT INTO `sys_district` VALUES ('1701', '历城', '255', 'l', 'lc', 'licheng', '', '区', '370112', '0531', 5);
INSERT INTO `sys_district` VALUES ('1702', '长清', '255', 'z', 'zq', 'zhangqing', '', '区', '370113', '0531', 6);
INSERT INTO `sys_district` VALUES ('1703', '平阴', '255', 'p', 'py', 'pingyin', '', '县', '370124', '0531', 7);
INSERT INTO `sys_district` VALUES ('1704', '济阳', '255', 'j', 'jy', 'jiyang', '', '区', '370125', '0531', 8);
INSERT INTO `sys_district` VALUES ('1705', '商河', '255', 's', 'sh', 'shanghe', '', '县', '370126', '0531', 9);
INSERT INTO `sys_district` VALUES ('1706', '章丘', '255', 'z', 'zq', 'zhangqiu', '', '区', '370181', '0531', 10);
INSERT INTO `sys_district` VALUES ('1707', '市南', '256', 's', 'sn', 'shinan', '', '区', '370202', '0532', 1);
INSERT INTO `sys_district` VALUES ('1708', '市北', '256', 's', 'sb', 'shibei', '', '区', '370203', '0532', 2);
INSERT INTO `sys_district` VALUES ('1709', '黄岛', '256', 'h', 'hd', 'huangdao', '', '区', '370211', '0532', 3);
INSERT INTO `sys_district` VALUES ('171', '朝阳', '8', 'c', 'cy', 'chaoyang', '', '市', '211300', '0421', 13);
INSERT INTO `sys_district` VALUES ('1710', '崂山', '256', 'l', 'ls', 'laoshan', '', '区', '370212', '0532', 4);
INSERT INTO `sys_district` VALUES ('1711', '李沧', '256', 'l', 'lc', 'licang', '', '区', '370213', '0532', 5);
INSERT INTO `sys_district` VALUES ('1712', '城阳', '256', 'c', 'cy', 'chengyang', '', '区', '370214', '0532', 6);
INSERT INTO `sys_district` VALUES ('1713', '胶州', '256', 'j', 'jz', 'jiaozhou', '', '市', '370281', '0532', 7);
INSERT INTO `sys_district` VALUES ('1714', '即墨', '256', 'j', 'jm', 'jimo', '', '市', '370282', '0532', 8);
INSERT INTO `sys_district` VALUES ('1715', '平度', '256', 'p', 'pd', 'pingdu', '', '市', '370283', '0532', 9);
INSERT INTO `sys_district` VALUES ('1716', '莱西', '256', 'l', 'lx', 'laixi', '', '市', '370285', '0532', 10);
INSERT INTO `sys_district` VALUES ('1717', '淄川', '257', 'z', 'zc', 'zichuan', '', '区', '370302', '0533', 1);
INSERT INTO `sys_district` VALUES ('1718', '张店', '257', 'z', 'zd', 'zhangdian', '', '区', '370303', '0533', 2);
INSERT INTO `sys_district` VALUES ('1719', '博山', '257', 'b', 'bs', 'boshan', '', '区', '370304', '0533', 3);
INSERT INTO `sys_district` VALUES ('172', '葫芦岛', '8', 'h', 'hld', 'huludao', '', '市', '211400', '0429', 14);
INSERT INTO `sys_district` VALUES ('1720', '临淄', '257', 'l', 'lz', 'linzi', '', '区', '370305', '0533', 4);
INSERT INTO `sys_district` VALUES ('1721', '周村', '257', 'z', 'zc', 'zhoucun', '', '区', '370306', '0533', 5);
INSERT INTO `sys_district` VALUES ('1722', '桓台', '257', 'h', 'ht', 'huantai', '', '县', '370321', '0533', 6);
INSERT INTO `sys_district` VALUES ('1723', '高青', '257', 'g', 'gq', 'gaoqing', '', '县', '370322', '0533', 7);
INSERT INTO `sys_district` VALUES ('1724', '沂源', '257', 'y', 'yy', 'yiyuan', '', '县', '370323', '0533', 8);
INSERT INTO `sys_district` VALUES ('1725', '市中', '258', 's', 'sz', 'shizhong', '', '区', '370402', '0632', 1);
INSERT INTO `sys_district` VALUES ('1726', '薛城', '258', 'x', 'xc', 'xuecheng', '', '区', '370403', '0632', 2);
INSERT INTO `sys_district` VALUES ('1727', '峄城', '258', 'y', 'yc', 'yicheng', '', '区', '370404', '0632', 3);
INSERT INTO `sys_district` VALUES ('1728', '台儿庄', '258', 't', 'tez', 'taierzhuang', '', '区', '370405', '0632', 4);
INSERT INTO `sys_district` VALUES ('1729', '山亭', '258', 's', 'st', 'shanting', '', '区', '370406', '0632', 5);
INSERT INTO `sys_district` VALUES ('173', '长春', '9', 'z', 'zc', 'zhangchun', '', '市', '220100', '0431', 1);
INSERT INTO `sys_district` VALUES ('1730', '滕州', '258', 't', 'tz', 'tengzhou', '', '市', '370481', '0632', 6);
INSERT INTO `sys_district` VALUES ('1731', '东营', '259', 'd', 'dy', 'dongying', '', '区', '370502', '0546', 1);
INSERT INTO `sys_district` VALUES ('1732', '河口', '259', 'h', 'hk', 'hekou', '', '区', '370503', '0546', 2);
INSERT INTO `sys_district` VALUES ('1733', '垦利', '259', 'k', 'kl', 'kenli', '', '区', '370521', '0546', 3);
INSERT INTO `sys_district` VALUES ('1734', '利津', '259', 'l', 'lj', 'lijin', '', '县', '370522', '0546', 4);
INSERT INTO `sys_district` VALUES ('1735', '广饶', '259', 'g', 'gr', 'guangrao', '', '县', '370523', '0546', 5);
INSERT INTO `sys_district` VALUES ('1736', '芝罘', '260', 'z', 'zf', 'zhifu', '', '区', '370602', '0535', 1);
INSERT INTO `sys_district` VALUES ('1737', '福山', '260', 'f', 'fs', 'fushan', '', '区', '370611', '0535', 2);
INSERT INTO `sys_district` VALUES ('1738', '牟平', '260', 'm', 'mp', 'mouping', '', '区', '370612', '0535', 3);
INSERT INTO `sys_district` VALUES ('1739', '莱山', '260', 'l', 'ls', 'laishan', '', '区', '370613', '0535', 4);
INSERT INTO `sys_district` VALUES ('174', '吉林', '9', 'j', 'jl', 'jilin', '', '市', '220200', '0432', 2);
INSERT INTO `sys_district` VALUES ('1740', '长岛', '260', 'z', 'zd', 'zhangdao', '', '县', '370634', '0535', 5);
INSERT INTO `sys_district` VALUES ('1741', '龙口', '260', 'l', 'lk', 'longkou', '', '市', '370681', '0535', 6);
INSERT INTO `sys_district` VALUES ('1742', '莱阳', '260', 'l', 'ly', 'laiyang', '', '市', '370682', '0535', 7);
INSERT INTO `sys_district` VALUES ('1743', '莱州', '260', 'l', 'lz', 'laizhou', '', '市', '370683', '0535', 8);
INSERT INTO `sys_district` VALUES ('1744', '蓬莱', '260', 'p', 'pl', 'penglai', '', '市', '370684', '0535', 9);
INSERT INTO `sys_district` VALUES ('1745', '招远', '260', 'z', 'zy', 'zhaoyuan', '', '市', '370685', '0535', 10);
INSERT INTO `sys_district` VALUES ('1746', '栖霞', '260', 'q', 'qx', 'qixia', '', '市', '370686', '0535', 11);
INSERT INTO `sys_district` VALUES ('1747', '海阳', '260', 'h', 'hy', 'haiyang', '', '市', '370687', '0535', 12);
INSERT INTO `sys_district` VALUES ('1748', '潍城', '261', 'w', 'wc', 'weicheng', '', '区', '370702', '0536', 1);
INSERT INTO `sys_district` VALUES ('1749', '寒亭', '261', 'h', 'ht', 'hanting', '', '区', '370703', '0536', 2);
INSERT INTO `sys_district` VALUES ('175', '四平', '9', 's', 'sp', 'siping', '', '市', '220300', '0434', 3);
INSERT INTO `sys_district` VALUES ('1750', '坊子', '261', 'f', 'fz', 'fangzi', '', '区', '370704', '0536', 3);
INSERT INTO `sys_district` VALUES ('1751', '奎文', '261', 'k', 'kw', 'kuiwen', '', '区', '370705', '0536', 4);
INSERT INTO `sys_district` VALUES ('1752', '临朐', '261', 'l', 'lq', 'linqu', '', '县', '370724', '0536', 5);
INSERT INTO `sys_district` VALUES ('1753', '昌乐', '261', 'c', 'cl', 'changle', '', '县', '370725', '0536', 6);
INSERT INTO `sys_district` VALUES ('1754', '青州', '261', 'q', 'qz', 'qingzhou', '', '市', '370781', '0536', 7);
INSERT INTO `sys_district` VALUES ('1755', '诸城', '261', 'z', 'zc', 'zhucheng', '', '市', '370782', '0536', 8);
INSERT INTO `sys_district` VALUES ('1756', '寿光', '261', 's', 'sg', 'shouguang', '', '市', '370783', '0536', 9);
INSERT INTO `sys_district` VALUES ('1757', '安丘', '261', 'a', 'aq', 'anqiu', '', '市', '370784', '0536', 10);
INSERT INTO `sys_district` VALUES ('1758', '高密', '261', 'g', 'gm', 'gaomi', '', '市', '370785', '0536', 11);
INSERT INTO `sys_district` VALUES ('1759', '昌邑', '261', 'c', 'cy', 'changyi', '', '市', '370786', '0536', 12);
INSERT INTO `sys_district` VALUES ('176', '辽源', '9', 'l', 'ly', 'liaoyuan', '', '市', '220400', '0437', 4);
INSERT INTO `sys_district` VALUES ('1761', '任城', '262', 'r', 'rc', 'rencheng', '', '区', '370811', '0537', 1);
INSERT INTO `sys_district` VALUES ('1762', '微山', '262', 'w', 'ws', 'weishan', '', '县', '370826', '0537', 3);
INSERT INTO `sys_district` VALUES ('1763', '鱼台', '262', 'y', 'yt', 'yutai', '', '县', '370827', '0537', 4);
INSERT INTO `sys_district` VALUES ('1764', '金乡', '262', 'j', 'jx', 'jinxiang', '', '县', '370828', '0537', 5);
INSERT INTO `sys_district` VALUES ('1765', '嘉祥', '262', 'j', 'jx', 'jiaxiang', '', '县', '370829', '0537', 6);
INSERT INTO `sys_district` VALUES ('1766', '汶上', '262', 'w', 'ws', 'wenshang', '', '县', '370830', '0537', 7);
INSERT INTO `sys_district` VALUES ('1767', '泗水', '262', 's', 'ss', 'sishui', '', '县', '370831', '0537', 8);
INSERT INTO `sys_district` VALUES ('1768', '梁山', '262', 'l', 'ls', 'liangshan', '', '县', '370832', '0537', 9);
INSERT INTO `sys_district` VALUES ('1769', '曲阜', '262', 'q', 'qf', 'qufu', '', '市', '370881', '0537', 10);
INSERT INTO `sys_district` VALUES ('177', '通化', '9', 't', 'th', 'tonghua', '', '市', '220500', '0435', 5);
INSERT INTO `sys_district` VALUES ('1770', '兖州', '262', 'y', 'yz', 'yanzhou', '', '区', '370812', '0537', 2);
INSERT INTO `sys_district` VALUES ('1771', '邹城', '262', 'z', 'zc', 'zoucheng', '', '市', '370883', '0537', 11);
INSERT INTO `sys_district` VALUES ('1772', '泰山', '263', 't', 'ts', 'taishan', '', '区', '370902', '0538', 1);
INSERT INTO `sys_district` VALUES ('1773', '岱岳', '263', 'd', 'dy', 'daiyue', '', '区', '370911', '0538', 2);
INSERT INTO `sys_district` VALUES ('1774', '宁阳', '263', 'n', 'ny', 'ningyang', '', '县', '370921', '0538', 3);
INSERT INTO `sys_district` VALUES ('1775', '东平', '263', 'd', 'dp', 'dongping', '', '县', '370923', '0538', 4);
INSERT INTO `sys_district` VALUES ('1776', '新泰', '263', 'x', 'xt', 'xintai', '', '市', '370982', '0538', 5);
INSERT INTO `sys_district` VALUES ('1777', '肥城', '263', 'f', 'fc', 'feicheng', '', '市', '370983', '0538', 6);
INSERT INTO `sys_district` VALUES ('1778', '环翠', '264', 'h', 'hc', 'huancui', '', '区', '371002', '0631', 1);
INSERT INTO `sys_district` VALUES ('1779', '文登', '264', 'w', 'wd', 'wendeng', '', '区', '371003', '0631', 2);
INSERT INTO `sys_district` VALUES ('178', '白山', '9', 'b', 'bs', 'baishan', '', '市', '220600', '0439', 6);
INSERT INTO `sys_district` VALUES ('1780', '荣成', '264', 'r', 'rc', 'rongcheng', '', '市', '371082', '0631', 3);
INSERT INTO `sys_district` VALUES ('1781', '乳山', '264', 'r', 'rs', 'rushan', '', '市', '371083', '0631', 4);
INSERT INTO `sys_district` VALUES ('1782', '东港', '265', 'd', 'dg', 'donggang', '', '区', '371102', '0633', 1);
INSERT INTO `sys_district` VALUES ('1783', '岚山', '265', 'l', 'ls', 'lanshan', '', '区', '371103', '0633', 2);
INSERT INTO `sys_district` VALUES ('1784', '五莲', '265', 'w', 'wl', 'wulian', '', '县', '371121', '0633', 3);
INSERT INTO `sys_district` VALUES ('1785', '莒县', '265', 'j', 'jx', 'juxian', '', '', '371122', '0633', 4);
INSERT INTO `sys_district` VALUES ('1786', '莱城', '266', 'l', 'lc', 'laicheng', '', '区', '371202', '0634', 1);
INSERT INTO `sys_district` VALUES ('1787', '钢城', '266', 'g', 'gc', 'gangcheng', '', '区', '371203', '0634', 2);
INSERT INTO `sys_district` VALUES ('1788', '兰山', '267', 'l', 'ls', 'lanshan', '', '区', '371302', '0539', 1);
INSERT INTO `sys_district` VALUES ('1789', '罗庄', '267', 'l', 'lz', 'luozhuang', '', '区', '371311', '0539', 2);
INSERT INTO `sys_district` VALUES ('179', '松原', '9', 's', 'sy', 'songyuan', '', '市', '220700', '0438', 7);
INSERT INTO `sys_district` VALUES ('1790', '河东', '267', 'h', 'hd', 'hedong', '', '区', '371312', '0539', 3);
INSERT INTO `sys_district` VALUES ('1791', '沂南', '267', 'y', 'yn', 'yinan', '', '县', '371321', '0539', 4);
INSERT INTO `sys_district` VALUES ('1792', '郯城', '267', 't', 'tc', 'tancheng', '', '县', '371322', '0539', 5);
INSERT INTO `sys_district` VALUES ('1793', '沂水', '267', 'y', 'ys', 'yishui', '', '县', '371323', '0539', 6);
INSERT INTO `sys_district` VALUES ('1794', '兰陵', '267', 'l', 'll', 'lanling', '', '县', '371324', '0539', 7);
INSERT INTO `sys_district` VALUES ('1795', '费县', '267', 'f', 'fx', 'feixian', '', '', '371325', '0539', 8);
INSERT INTO `sys_district` VALUES ('1796', '平邑', '267', 'p', 'py', 'pingyi', '', '县', '371326', '0539', 9);
INSERT INTO `sys_district` VALUES ('1797', '莒南', '267', 'j', 'jn', 'junan', '', '县', '371327', '0539', 10);
INSERT INTO `sys_district` VALUES ('1798', '蒙阴', '267', 'm', 'my', 'mengyin', '', '县', '371328', '0539', 11);
INSERT INTO `sys_district` VALUES ('1799', '临沭', '267', 'l', 'ls', 'linshu', '', '县', '371329', '0539', 12);
INSERT INTO `sys_district` VALUES ('18', '湖北', '0', 'h', 'hb', 'hubei', '', '省', '420000', '', 19);
INSERT INTO `sys_district` VALUES ('180', '白城', '9', 'b', 'bc', 'baicheng', '', '市', '220800', '0436', 8);
INSERT INTO `sys_district` VALUES ('1800', '德城', '268', 'd', 'dc', 'decheng', '', '区', '371402', '0534', 1);
INSERT INTO `sys_district` VALUES ('1801', '陵城', '268', 'l', 'lc', 'lingcheng', '', '区', '371403', '0534', 2);
INSERT INTO `sys_district` VALUES ('1802', '宁津', '268', 'n', 'nj', 'ningjin', '', '县', '371422', '0534', 3);
INSERT INTO `sys_district` VALUES ('1803', '庆云', '268', 'q', 'qy', 'qingyun', '', '县', '371423', '0534', 4);
INSERT INTO `sys_district` VALUES ('1804', '临邑', '268', 'l', 'ly', 'linyi', '', '县', '371424', '0534', 5);
INSERT INTO `sys_district` VALUES ('1805', '齐河', '268', 'q', 'qh', 'qihe', '', '县', '371425', '0534', 6);
INSERT INTO `sys_district` VALUES ('1806', '平原', '268', 'p', 'py', 'pingyuan', '', '县', '371426', '0534', 7);
INSERT INTO `sys_district` VALUES ('1807', '夏津', '268', 'x', 'xj', 'xiajin', '', '县', '371427', '0534', 8);
INSERT INTO `sys_district` VALUES ('1808', '武城', '268', 'w', 'wc', 'wucheng', '', '县', '371428', '0534', 9);
INSERT INTO `sys_district` VALUES ('1809', '乐陵', '268', 'l', 'll', 'leling', '', '市', '371481', '0534', 10);
INSERT INTO `sys_district` VALUES ('181', '延边', '9', 'y', 'yb', 'yanbian', '朝鲜族', '自治州', '222400', '0433', 9);
INSERT INTO `sys_district` VALUES ('1810', '禹城', '268', 'y', 'yc', 'yucheng', '', '市', '371482', '0534', 11);
INSERT INTO `sys_district` VALUES ('1811', '东昌府', '269', 'd', 'dcf', 'dongchangfu', '', '区', '371502', '0635', 1);
INSERT INTO `sys_district` VALUES ('1812', '阳谷', '269', 'y', 'yg', 'yanggu', '', '县', '371521', '0635', 2);
INSERT INTO `sys_district` VALUES ('1813', '莘县', '269', 'x', 'xx', 'xinxian', '', '', '371522', '0635', 3);
INSERT INTO `sys_district` VALUES ('1814', '茌平', '269', 'c', 'cp', 'chiping', '', '县', '371523', '0635', 4);
INSERT INTO `sys_district` VALUES ('1815', '东阿', '269', 'd', 'da', 'donga', '', '县', '371524', '0635', 5);
INSERT INTO `sys_district` VALUES ('1816', '冠县', '269', 'g', 'gx', 'guanxian', '', '', '371525', '0635', 6);
INSERT INTO `sys_district` VALUES ('1817', '高唐', '269', 'g', 'gt', 'gaotang', '', '县', '371526', '0635', 7);
INSERT INTO `sys_district` VALUES ('1818', '临清', '269', 'l', 'lq', 'linqing', '', '市', '371581', '0635', 8);
INSERT INTO `sys_district` VALUES ('1819', '滨城', '270', 'b', 'bc', 'bincheng', '', '区', '371602', '0543', 1);
INSERT INTO `sys_district` VALUES ('182', '哈尔滨', '10', 'h', 'heb', 'haerbin', '', '市', '230100', '0451', 1);
INSERT INTO `sys_district` VALUES ('1820', '惠民', '270', 'h', 'hm', 'huimin', '', '县', '371621', '0543', 2);
INSERT INTO `sys_district` VALUES ('1821', '阳信', '270', 'y', 'yx', 'yangxin', '', '县', '371622', '0543', 3);
INSERT INTO `sys_district` VALUES ('1822', '无棣', '270', 'w', 'wd', 'wudi', '', '县', '371623', '0543', 4);
INSERT INTO `sys_district` VALUES ('1823', '沾化', '270', 'z', 'zh', 'zhanhua', '', '区', '371624', '0543', 5);
INSERT INTO `sys_district` VALUES ('1824', '博兴', '270', 'b', 'bx', 'boxing', '', '县', '371625', '0543', 6);
INSERT INTO `sys_district` VALUES ('1825', '邹平', '270', 'z', 'zp', 'zouping', '', '县', '371626', '0543', 7);
INSERT INTO `sys_district` VALUES ('1826', '牡丹', '271', 'm', 'md', 'mudan', '', '区', '371702', '0530', 1);
INSERT INTO `sys_district` VALUES ('1827', '曹县', '271', 'c', 'cx', 'caoxian', '', '', '371721', '0530', 2);
INSERT INTO `sys_district` VALUES ('1828', '单县', '271', 'd', 'dx', 'danxian', '', '', '371722', '0530', 3);
INSERT INTO `sys_district` VALUES ('1829', '成武', '271', 'c', 'cw', 'chengwu', '', '县', '371723', '0530', 4);
INSERT INTO `sys_district` VALUES ('183', '齐齐哈尔', '10', 'q', 'qqhe', 'qiqihaer', '', '市', '230200', '0452', 2);
INSERT INTO `sys_district` VALUES ('1830', '巨野', '271', 'j', 'jy', 'juye', '', '县', '371724', '0530', 5);
INSERT INTO `sys_district` VALUES ('1831', '郓城', '271', 'y', 'yc', 'yuncheng', '', '县', '371725', '0530', 6);
INSERT INTO `sys_district` VALUES ('1832', '鄄城', '271', 'j', 'jc', 'juancheng', '', '县', '371726', '0530', 7);
INSERT INTO `sys_district` VALUES ('1833', '定陶', '271', 'd', 'dt', 'dingtao', '', '区', '371727', '0530', 8);
INSERT INTO `sys_district` VALUES ('1834', '东明', '271', 'd', 'dm', 'dongming', '', '县', '371728', '0530', 9);
INSERT INTO `sys_district` VALUES ('1835', '中原', '272', 'z', 'zy', 'zhongyuan', '', '区', '410102', '0371', 1);
INSERT INTO `sys_district` VALUES ('1836', '二七', '272', 'e', 'eq', 'erqi', '', '区', '410103', '0371', 2);
INSERT INTO `sys_district` VALUES ('1837', '管城', '272', 'g', 'gc', 'guancheng', '回族', '区', '410104', '0371', 3);
INSERT INTO `sys_district` VALUES ('1838', '金水', '272', 'j', 'js', 'jinshui', '', '区', '410105', '0371', 4);
INSERT INTO `sys_district` VALUES ('1839', '上街', '272', 's', 'sj', 'shangjie', '', '区', '410106', '0371', 5);
INSERT INTO `sys_district` VALUES ('184', '鸡西', '10', 'j', 'jx', 'jixi', '', '市', '230300', '0467', 3);
INSERT INTO `sys_district` VALUES ('1840', '惠济', '272', 'h', 'hj', 'huiji', '', '区', '410108', '0371', 6);
INSERT INTO `sys_district` VALUES ('1841', '中牟', '272', 'z', 'zm', 'zhongmou', '', '县', '410122', '0371', 7);
INSERT INTO `sys_district` VALUES ('1842', '巩义', '272', 'g', 'gy', 'gongyi', '', '市', '410181', '0371', 8);
INSERT INTO `sys_district` VALUES ('1843', '荥阳', '272', 'y', 'yy', 'yingyang', '', '市', '410182', '0371', 9);
INSERT INTO `sys_district` VALUES ('1844', '新密', '272', 'x', 'xm', 'xinmi', '', '市', '410183', '0371', 10);
INSERT INTO `sys_district` VALUES ('1845', '新郑', '272', 'x', 'xz', 'xinzheng', '', '市', '410184', '0371', 11);
INSERT INTO `sys_district` VALUES ('1846', '登封', '272', 'd', 'df', 'dengfeng', '', '市', '410185', '0371', 12);
INSERT INTO `sys_district` VALUES ('1847', '龙亭', '273', 'l', 'lt', 'longting', '', '区', '410202', '0378', 1);
INSERT INTO `sys_district` VALUES ('1848', '顺河', '273', 's', 'sh', 'shunhe', '回族', '区', '410203', '0378', 2);
INSERT INTO `sys_district` VALUES ('1849', '鼓楼', '273', 'g', 'gl', 'gulou', '', '区', '410204', '0378', 3);
INSERT INTO `sys_district` VALUES ('185', '鹤岗', '10', 'h', 'hg', 'hegang', '', '市', '230400', '0468', 4);
INSERT INTO `sys_district` VALUES ('1850', '禹王台', '273', 'y', 'ywt', 'yuwangtai', '', '区', '410205', '0378', 4);
INSERT INTO `sys_district` VALUES ('1852', '杞县', '273', 'q', 'qx', 'qixian', '', '', '410221', '0378', 6);
INSERT INTO `sys_district` VALUES ('1853', '通许', '273', 't', 'tx', 'tongxu', '', '县', '410222', '0378', 7);
INSERT INTO `sys_district` VALUES ('1854', '尉氏', '273', 'w', 'ws', 'weishi', '', '县', '410223', '0378', 8);
INSERT INTO `sys_district` VALUES ('1855', '祥符', '273', 'x', 'xf', 'kaifeng', '', '区', '410212', '0378', 5);
INSERT INTO `sys_district` VALUES ('1856', '兰考', '273', 'l', 'lk', 'lankao', '', '县', '410225', '0378', 9);
INSERT INTO `sys_district` VALUES ('1857', '老城', '274', 'l', 'lc', 'laocheng', '', '区', '410302', '0376', 1);
INSERT INTO `sys_district` VALUES ('1858', '西工', '274', 'x', 'xg', 'xigong', '', '区', '410303', '0376', 2);
INSERT INTO `sys_district` VALUES ('1859', '瀍河', '274', 'c', 'ch', 'chanhe', '回族', '区', '410304', '0376', 3);
INSERT INTO `sys_district` VALUES ('186', '双鸭山', '10', 's', 'sys', 'shuangyashan', '', '市', '230500', '0469', 5);
INSERT INTO `sys_district` VALUES ('1860', '涧西', '274', 'j', 'jx', 'jianxi', '', '区', '410305', '0376', 4);
INSERT INTO `sys_district` VALUES ('1861', '吉利', '274', 'j', 'jl', 'jili', '', '区', '410306', '0376', 5);
INSERT INTO `sys_district` VALUES ('1862', '洛龙', '274', 'l', 'll', 'luolong', '', '区', '410311', '0376', 6);
INSERT INTO `sys_district` VALUES ('1863', '孟津', '274', 'm', 'mj', 'mengjin', '', '县', '410322', '0376', 7);
INSERT INTO `sys_district` VALUES ('1864', '新安', '274', 'x', 'xa', 'xinan', '', '县', '410323', '0376', 8);
INSERT INTO `sys_district` VALUES ('1865', '栾川', '274', 'l', 'lc', 'luanchuan', '', '县', '410324', '0376', 9);
INSERT INTO `sys_district` VALUES ('1866', '嵩县', '274', 's', 'sx', 'songxian', '', '', '410325', '0376', 10);
INSERT INTO `sys_district` VALUES ('1867', '汝阳', '274', 'r', 'ry', 'ruyang', '', '县', '410326', '0376', 11);
INSERT INTO `sys_district` VALUES ('1868', '宜阳', '274', 'y', 'yy', 'yiyang', '', '县', '410327', '0376', 12);
INSERT INTO `sys_district` VALUES ('1869', '洛宁', '274', 'l', 'ln', 'luoning', '', '县', '410328', '0376', 13);
INSERT INTO `sys_district` VALUES ('187', '大庆', '10', 'd', 'dq', 'daqing', '', '市', '230600', '0459', 6);
INSERT INTO `sys_district` VALUES ('1870', '伊川', '274', 'y', 'yc', 'yichuan', '', '县', '410329', '0376', 14);
INSERT INTO `sys_district` VALUES ('1871', '偃师', '274', 'y', 'ys', 'yanshi', '', '市', '410381', '0376', 15);
INSERT INTO `sys_district` VALUES ('1872', '新华', '275', 'x', 'xh', 'xinhua', '', '区', '410402', '0375', 1);
INSERT INTO `sys_district` VALUES ('1873', '卫东', '275', 'w', 'wd', 'weidong', '', '区', '410403', '0375', 2);
INSERT INTO `sys_district` VALUES ('1874', '石龙', '275', 's', 'sl', 'shilong', '', '区', '410404', '0375', 3);
INSERT INTO `sys_district` VALUES ('1875', '湛河', '275', 'z', 'zh', 'zhanhe', '', '区', '410411', '0375', 4);
INSERT INTO `sys_district` VALUES ('1876', '宝丰', '275', 'b', 'bf', 'baofeng', '', '县', '410421', '0375', 5);
INSERT INTO `sys_district` VALUES ('1877', '叶县', '275', 'y', 'yx', 'yexian', '', '', '410422', '0375', 6);
INSERT INTO `sys_district` VALUES ('1878', '鲁山', '275', 'l', 'ls', 'lushan', '', '县', '410423', '0375', 7);
INSERT INTO `sys_district` VALUES ('1879', '郏县', '275', 'j', 'jx', 'jiaxian', '', '', '410425', '0375', 8);
INSERT INTO `sys_district` VALUES ('188', '伊春', '10', 'y', 'yc', 'yichun', '', '市', '230700', '0458', 7);
INSERT INTO `sys_district` VALUES ('1880', '舞钢', '275', 'w', 'wg', 'wugang', '', '市', '410481', '0375', 9);
INSERT INTO `sys_district` VALUES ('1881', '汝州', '275', 'r', 'rz', 'ruzhou', '', '市', '410482', '0375', 10);
INSERT INTO `sys_district` VALUES ('1882', '文峰', '276', 'w', 'wf', 'wenfeng', '', '区', '410502', '0372', 1);
INSERT INTO `sys_district` VALUES ('1883', '北关', '276', 'b', 'bg', 'beiguan', '', '区', '410503', '0372', 2);
INSERT INTO `sys_district` VALUES ('1884', '殷都', '276', 'y', 'yd', 'yindu', '', '区', '410505', '0372', 3);
INSERT INTO `sys_district` VALUES ('1885', '龙安', '276', 'l', 'la', 'longan', '', '区', '410506', '0372', 4);
INSERT INTO `sys_district` VALUES ('1886', '安阳', '276', 'a', 'ay', 'anyang', '', '县', '410522', '0372', 5);
INSERT INTO `sys_district` VALUES ('1887', '汤阴', '276', 't', 'ty', 'tangyin', '', '县', '410523', '0372', 6);
INSERT INTO `sys_district` VALUES ('1888', '滑县', '276', 'h', 'hx', 'huaxian', '', '', '410526', '0372', 7);
INSERT INTO `sys_district` VALUES ('1889', '内黄', '276', 'n', 'nh', 'neihuang', '', '县', '410527', '0372', 8);
INSERT INTO `sys_district` VALUES ('189', '佳木斯', '10', 'j', 'jms', 'jiamusi', '', '市', '230800', '0454', 8);
INSERT INTO `sys_district` VALUES ('1890', '林州', '276', 'l', 'lz', 'linzhou', '', '市', '410581', '0372', 9);
INSERT INTO `sys_district` VALUES ('1891', '鹤山', '277', 'h', 'hs', 'heshan', '', '区', '410602', '0392', 1);
INSERT INTO `sys_district` VALUES ('1892', '山城', '277', 's', 'sc', 'shancheng', '', '区', '410603', '0392', 2);
INSERT INTO `sys_district` VALUES ('1893', '淇滨', '277', 'q', 'qb', 'qibin', '', '区', '410611', '0392', 3);
INSERT INTO `sys_district` VALUES ('1894', '浚县', '277', 'j', 'jx', 'junxian', '', '', '410621', '0392', 4);
INSERT INTO `sys_district` VALUES ('1895', '淇县', '277', 'q', 'qx', 'qixian', '', '', '410622', '0392', 5);
INSERT INTO `sys_district` VALUES ('1896', '红旗', '278', 'h', 'hq', 'hongqi', '', '区', '410702', '0373', 1);
INSERT INTO `sys_district` VALUES ('1897', '卫滨', '278', 'w', 'wb', 'weibin', '', '区', '410703', '0373', 2);
INSERT INTO `sys_district` VALUES ('1898', '凤泉', '278', 'f', 'fq', 'fengquan', '', '区', '410704', '0373', 3);
INSERT INTO `sys_district` VALUES ('1899', '牧野', '278', 'm', 'my', 'muye', '', '区', '410711', '0373', 4);
INSERT INTO `sys_district` VALUES ('19', '湖南', '0', 'h', 'hn', 'hunan', '', '省', '430000', '', 20);
INSERT INTO `sys_district` VALUES ('190', '七台河', '10', 'q', 'qth', 'qitaihe', '', '市', '230900', '0464', 9);
INSERT INTO `sys_district` VALUES ('1900', '新乡', '278', 'x', 'xx', 'xinxiang', '', '县', '410721', '0373', 5);
INSERT INTO `sys_district` VALUES ('1901', '获嘉', '278', 'h', 'hj', 'huojia', '', '县', '410724', '0373', 6);
INSERT INTO `sys_district` VALUES ('1902', '原阳', '278', 'y', 'yy', 'yuanyang', '', '县', '410725', '0373', 7);
INSERT INTO `sys_district` VALUES ('1903', '延津', '278', 'y', 'yj', 'yanjin', '', '县', '410726', '0373', 8);
INSERT INTO `sys_district` VALUES ('1904', '封丘', '278', 'f', 'fq', 'fengqiu', '', '县', '410727', '0373', 9);
INSERT INTO `sys_district` VALUES ('1905', '长垣', '278', 'z', 'zy', 'zhangyuan', '', '县', '410728', '0373', 10);
INSERT INTO `sys_district` VALUES ('1906', '卫辉', '278', 'w', 'wh', 'weihui', '', '市', '410781', '0373', 11);
INSERT INTO `sys_district` VALUES ('1907', '辉县', '278', 'h', 'hx', 'huixian', '', '市', '410782', '0373', 12);
INSERT INTO `sys_district` VALUES ('1908', '解放', '279', 'j', 'jf', 'jiefang', '', '区', '410802', '0391', 1);
INSERT INTO `sys_district` VALUES ('1909', '中站', '279', 'z', 'zz', 'zhongzhan', '', '区', '410803', '0391', 2);
INSERT INTO `sys_district` VALUES ('191', '牡丹江', '10', 'm', 'mdj', 'mudanjiang', '', '市', '231000', '0453', 10);
INSERT INTO `sys_district` VALUES ('1910', '马村', '279', 'm', 'mc', 'macun', '', '区', '410804', '0391', 3);
INSERT INTO `sys_district` VALUES ('1911', '山阳', '279', 's', 'sy', 'shanyang', '', '区', '410811', '0391', 4);
INSERT INTO `sys_district` VALUES ('1912', '修武', '279', 'x', 'xw', 'xiuwu', '', '县', '410821', '0391', 5);
INSERT INTO `sys_district` VALUES ('1913', '博爱', '279', 'b', 'ba', 'boai', '', '县', '410822', '0391', 6);
INSERT INTO `sys_district` VALUES ('1914', '武陟', '279', 'w', 'wz', 'wuzhi', '', '县', '410823', '0391', 7);
INSERT INTO `sys_district` VALUES ('1915', '温县', '279', 'w', 'wx', 'wenxian', '', '', '410825', '0391', 8);
INSERT INTO `sys_district` VALUES ('1916', '沁阳', '279', 'q', 'qy', 'qinyang', '', '市', '410882', '0391', 9);
INSERT INTO `sys_district` VALUES ('1917', '孟州', '279', 'm', 'mz', 'mengzhou', '', '市', '410883', '0391', 10);
INSERT INTO `sys_district` VALUES ('1918', '华龙', '280', 'h', 'hl', 'hualong', '', '区', '410902', '', 1);
INSERT INTO `sys_district` VALUES ('1919', '清丰', '280', 'q', 'qf', 'qingfeng', '', '县', '410922', '', 2);
INSERT INTO `sys_district` VALUES ('192', '黑河', '10', 'h', 'hh', 'heihe', '', '市', '231100', '0456', 11);
INSERT INTO `sys_district` VALUES ('1920', '南乐', '280', 'n', 'nl', 'nanle', '', '县', '410923', '', 3);
INSERT INTO `sys_district` VALUES ('1921', '范县', '280', 'f', 'fx', 'fanxian', '', '', '410926', '', 4);
INSERT INTO `sys_district` VALUES ('1922', '台前', '280', 't', 'tq', 'taiqian', '', '县', '410927', '', 5);
INSERT INTO `sys_district` VALUES ('1923', '濮阳', '280', 'p', 'py', 'puyang', '', '县', '410928', '', 6);
INSERT INTO `sys_district` VALUES ('1924', '魏都', '281', 'w', 'wd', 'weidu', '', '区', '411002', '0374', 1);
INSERT INTO `sys_district` VALUES ('1925', '建安', '281', 'j', 'ja', 'jianan', '', '区', '411023', '0374', 2);
INSERT INTO `sys_district` VALUES ('1926', '鄢陵', '281', 'y', 'yl', 'yanling', '', '县', '411024', '0374', 3);
INSERT INTO `sys_district` VALUES ('1927', '襄城', '281', 'x', 'xc', 'xiangcheng', '', '县', '411025', '0374', 4);
INSERT INTO `sys_district` VALUES ('1928', '禹州', '281', 'y', 'yz', 'yuzhou', '', '市', '411081', '0374', 5);
INSERT INTO `sys_district` VALUES ('1929', '长葛', '281', 'z', 'zg', 'zhangge', '', '市', '411082', '0374', 6);
INSERT INTO `sys_district` VALUES ('193', '绥化', '10', 's', 'sh', 'suihua', '', '市', '231200', '0455', 12);
INSERT INTO `sys_district` VALUES ('1930', '源汇', '282', 'y', 'yh', 'yuanhui', '', '区', '411102', '0395', 1);
INSERT INTO `sys_district` VALUES ('1931', '郾城', '282', 'y', 'yc', 'yancheng', '', '区', '411103', '0395', 2);
INSERT INTO `sys_district` VALUES ('1932', '召陵', '282', 'z', 'zl', 'zhaoling', '', '区', '411104', '0395', 3);
INSERT INTO `sys_district` VALUES ('1933', '舞阳', '282', 'w', 'wy', 'wuyang', '', '县', '411121', '0395', 4);
INSERT INTO `sys_district` VALUES ('1934', '临颍', '282', 'l', 'ly', 'linying', '', '县', '411122', '0395', 5);
INSERT INTO `sys_district` VALUES ('1935', '湖滨', '283', 'h', 'hb', 'hubin', '', '区', '411202', '0398', 1);
INSERT INTO `sys_district` VALUES ('1936', '渑池', '283', 'm', 'mc', 'mianchi', '', '县', '411221', '0398', 3);
INSERT INTO `sys_district` VALUES ('1937', '陕州', '283', 's', 'sz', 'shanzhou', '', '区', '411222', '0398', 2);
INSERT INTO `sys_district` VALUES ('1938', '卢氏', '283', 'l', 'ls', 'lushi', '', '县', '411224', '0398', 4);
INSERT INTO `sys_district` VALUES ('1939', '义马', '283', 'y', 'ym', 'yima', '', '市', '411281', '0398', 5);
INSERT INTO `sys_district` VALUES ('194', '大兴安岭', '10', 'd', 'dxal', 'daxinganling', '', '地区', '232700', '0457', 13);
INSERT INTO `sys_district` VALUES ('1940', '灵宝', '283', 'l', 'lb', 'lingbao', '', '市', '411282', '0398', 6);
INSERT INTO `sys_district` VALUES ('1941', '宛城', '284', 'w', 'wc', 'wancheng', '', '区', '411302', '0377', 1);
INSERT INTO `sys_district` VALUES ('1942', '卧龙', '284', 'w', 'wl', 'wolong', '', '区', '411303', '0377', 2);
INSERT INTO `sys_district` VALUES ('1943', '南召', '284', 'n', 'nz', 'nanzhao', '', '县', '411321', '0377', 3);
INSERT INTO `sys_district` VALUES ('1944', '方城', '284', 'f', 'fc', 'fangcheng', '', '县', '411322', '0377', 4);
INSERT INTO `sys_district` VALUES ('1945', '西峡', '284', 'x', 'xx', 'xixia', '', '县', '411323', '0377', 5);
INSERT INTO `sys_district` VALUES ('1946', '镇平', '284', 'z', 'zp', 'zhenping', '', '县', '411324', '0377', 6);
INSERT INTO `sys_district` VALUES ('1947', '内乡', '284', 'n', 'nx', 'neixiang', '', '县', '411325', '0377', 7);
INSERT INTO `sys_district` VALUES ('1948', '淅川', '284', 'x', 'xc', 'xichuan', '', '县', '411326', '0377', 8);
INSERT INTO `sys_district` VALUES ('1949', '社旗', '284', 's', 'sq', 'sheqi', '', '县', '411327', '0377', 9);
INSERT INTO `sys_district` VALUES ('195', '南京', '11', 'n', 'nj', 'nanjing', '', '市', '320100', '', 1);
INSERT INTO `sys_district` VALUES ('1950', '唐河', '284', 't', 'th', 'tanghe', '', '县', '411328', '0377', 10);
INSERT INTO `sys_district` VALUES ('1951', '新野', '284', 'x', 'xy', 'xinye', '', '县', '411329', '0377', 11);
INSERT INTO `sys_district` VALUES ('1952', '桐柏', '284', 't', 'tb', 'tongbo', '', '县', '411330', '0377', 12);
INSERT INTO `sys_district` VALUES ('1953', '邓州', '284', 'd', 'dz', 'dengzhou', '', '市', '411381', '0377', 13);
INSERT INTO `sys_district` VALUES ('1954', '粱园', '285', 'l', 'ly', 'liangyuan', '', '区', '411402', '0370', 1);
INSERT INTO `sys_district` VALUES ('1955', '睢阳', '285', 's', 'sy', 'suiyang', '', '区', '411403', '0370', 2);
INSERT INTO `sys_district` VALUES ('1956', '民权', '285', 'm', 'mq', 'minquan', '', '县', '411421', '0370', 3);
INSERT INTO `sys_district` VALUES ('1957', '睢县', '285', 's', 'sx', 'suixian', '', '', '411422', '0370', 4);
INSERT INTO `sys_district` VALUES ('1958', '宁陵', '285', 'n', 'nl', 'ningling', '', '县', '411423', '0370', 5);
INSERT INTO `sys_district` VALUES ('1959', '柘城', '285', 'z', 'zc', 'zhecheng', '', '县', '411424', '0370', 6);
INSERT INTO `sys_district` VALUES ('196', '无锡', '11', 'w', 'wx', 'wuxi', '', '市', '320200', '0510', 2);
INSERT INTO `sys_district` VALUES ('1960', '虞城', '285', 'y', 'yc', 'yucheng', '', '县', '411425', '0370', 7);
INSERT INTO `sys_district` VALUES ('1961', '夏邑', '285', 'x', 'xy', 'xiayi', '', '县', '411426', '0370', 8);
INSERT INTO `sys_district` VALUES ('1962', '永城', '285', 'y', 'yc', 'yongcheng', '', '市', '411481', '0370', 9);
INSERT INTO `sys_district` VALUES ('1963', '浉河', '286', 's', 'sh', 'shihe', '', '区', '411502', '0376', 1);
INSERT INTO `sys_district` VALUES ('1964', '平桥', '286', 'p', 'pq', 'pingqiao', '', '区', '411503', '0376', 2);
INSERT INTO `sys_district` VALUES ('1965', '罗山', '286', 'l', 'ls', 'luoshan', '', '县', '411521', '0376', 3);
INSERT INTO `sys_district` VALUES ('1966', '光山', '286', 'g', 'gs', 'guangshan', '', '县', '411522', '0376', 4);
INSERT INTO `sys_district` VALUES ('1967', '新县', '286', 'x', 'xx', 'xinxian', '', '', '411523', '0376', 5);
INSERT INTO `sys_district` VALUES ('1968', '商城', '286', 's', 'sc', 'shangcheng', '', '县', '411524', '0376', 6);
INSERT INTO `sys_district` VALUES ('1969', '固始', '286', 'g', 'gs', 'gushi', '', '县', '411525', '0376', 7);
INSERT INTO `sys_district` VALUES ('197', '徐州', '11', 'x', 'xz', 'xuzhou', '', '市', '320300', '0516', 3);
INSERT INTO `sys_district` VALUES ('1970', '潢川', '286', 'h', 'hc', 'huangchuan', '', '县', '411526', '0376', 8);
INSERT INTO `sys_district` VALUES ('1971', '淮滨', '286', 'h', 'hb', 'huaibin', '', '县', '411527', '0376', 9);
INSERT INTO `sys_district` VALUES ('1972', '息县', '286', 'x', 'xx', 'xixian', '', '', '411528', '0376', 10);
INSERT INTO `sys_district` VALUES ('1973', '川汇', '287', 'c', 'ch', 'chuanhui', '', '区', '411602', '0394', 1);
INSERT INTO `sys_district` VALUES ('1974', '扶沟', '287', 'f', 'fg', 'fugou', '', '县', '411621', '0394', 2);
INSERT INTO `sys_district` VALUES ('1975', '西华', '287', 'x', 'xh', 'xihua', '', '县', '411622', '0394', 3);
INSERT INTO `sys_district` VALUES ('1976', '商水', '287', 's', 'ss', 'shangshui', '', '县', '411623', '0394', 4);
INSERT INTO `sys_district` VALUES ('1977', '沈丘', '287', 's', 'sq', 'shenqiu', '', '县', '411624', '0394', 5);
INSERT INTO `sys_district` VALUES ('1978', '郸城', '287', 'd', 'dc', 'dancheng', '', '县', '411625', '0394', 6);
INSERT INTO `sys_district` VALUES ('1979', '淮阳', '287', 'h', 'hy', 'huaiyang', '', '县', '411626', '0394', 7);
INSERT INTO `sys_district` VALUES ('198', '常州', '11', 'c', 'cz', 'changzhou', '', '市', '320400', '0519', 4);
INSERT INTO `sys_district` VALUES ('1980', '太康', '287', 't', 'tk', 'taikang', '', '县', '411627', '0394', 8);
INSERT INTO `sys_district` VALUES ('1981', '鹿邑', '287', 'l', 'ly', 'luyi', '', '县', '411628', '0394', 9);
INSERT INTO `sys_district` VALUES ('1982', '项城', '287', 'x', 'xc', 'xiangcheng', '', '市', '411681', '0394', 10);
INSERT INTO `sys_district` VALUES ('1983', '驿城', '288', 'y', 'yc', 'yicheng', '', '区', '411702', '0396', 1);
INSERT INTO `sys_district` VALUES ('1984', '西平', '288', 'x', 'xp', 'xiping', '', '县', '411721', '0396', 2);
INSERT INTO `sys_district` VALUES ('1985', '上蔡', '288', 's', 'sc', 'shangcai', '', '县', '411722', '0396', 3);
INSERT INTO `sys_district` VALUES ('1986', '平舆', '288', 'p', 'py', 'pingyu', '', '县', '411723', '0396', 4);
INSERT INTO `sys_district` VALUES ('1987', '正阳', '288', 'z', 'zy', 'zhengyang', '', '县', '411724', '0396', 5);
INSERT INTO `sys_district` VALUES ('1988', '确山', '288', 'q', 'qs', 'queshan', '', '县', '411725', '0396', 6);
INSERT INTO `sys_district` VALUES ('1989', '泌阳', '288', 'm', 'my', 'miyang', '', '县', '411726', '0396', 7);
INSERT INTO `sys_district` VALUES ('199', '苏州', '11', 's', 'sz', 'suzhou', '', '市', '320500', '0512', 5);
INSERT INTO `sys_district` VALUES ('1990', '汝南', '288', 'r', 'rn', 'runan', '', '县', '411727', '0396', 8);
INSERT INTO `sys_district` VALUES ('1991', '遂平', '288', 's', 'sp', 'suiping', '', '县', '411728', '0396', 9);
INSERT INTO `sys_district` VALUES ('1992', '新蔡', '288', 'x', 'xc', 'xincai', '', '县', '411729', '0396', 10);
INSERT INTO `sys_district` VALUES ('1993', '江岸', '290', 'j', 'ja', 'jiangan', '', '区', '420102', '027', 1);
INSERT INTO `sys_district` VALUES ('1994', '江汉', '290', 'j', 'jh', 'jianghan', '', '区', '420103', '027', 2);
INSERT INTO `sys_district` VALUES ('1995', '硚口', '290', 'q', 'qk', 'qiaokou', '', '区', '420104', '027', 3);
INSERT INTO `sys_district` VALUES ('1996', '汉阳', '290', 'h', 'hy', 'hanyang', '', '区', '420105', '027', 4);
INSERT INTO `sys_district` VALUES ('1997', '武昌', '290', 'w', 'wc', 'wuchang', '', '区', '420106', '027', 5);
INSERT INTO `sys_district` VALUES ('1998', '青山', '290', 'q', 'qs', 'qingshan', '', '区', '420107', '027', 6);
INSERT INTO `sys_district` VALUES ('1999', '洪山', '290', 'h', 'hs', 'hongshan', '', '区', '420111', '027', 7);
INSERT INTO `sys_district` VALUES ('2', '天津', '', 't', 'tj', 'tianjin', '', '市', '120000', '022', 1);
INSERT INTO `sys_district` VALUES ('20', '广东', '0', 'g', 'gd', 'guangdong', '', '省', '440000', '', 21);
INSERT INTO `sys_district` VALUES ('200', '南通', '11', 'n', 'nt', 'nantong', '', '市', '320600', '0513', 6);
INSERT INTO `sys_district` VALUES ('2000', '东西湖', '290', 'd', 'dxh', 'dongxihu', '', '区', '420112', '027', 8);
INSERT INTO `sys_district` VALUES ('2001', '汉南', '290', 'h', 'hn', 'hannan', '', '区', '420113', '027', 9);
INSERT INTO `sys_district` VALUES ('2002', '蔡甸', '290', 'c', 'cd', 'caidian', '', '区', '420114', '027', 10);
INSERT INTO `sys_district` VALUES ('2003', '江夏', '290', 'j', 'jx', 'jiangxia', '', '区', '420115', '027', 11);
INSERT INTO `sys_district` VALUES ('2004', '黄陂', '290', 'h', 'hp', 'huangpo', '', '区', '420116', '027', 12);
INSERT INTO `sys_district` VALUES ('2005', '新洲', '290', 'x', 'xz', 'xinzhou', '', '区', '420117', '027', 13);
INSERT INTO `sys_district` VALUES ('2006', '黄石港', '291', 'h', 'hsg', 'huangshigang', '', '区', '420202', '0714', 1);
INSERT INTO `sys_district` VALUES ('2007', '西塞山', '291', 'x', 'xss', 'xisaishan', '', '区', '420203', '0714', 2);
INSERT INTO `sys_district` VALUES ('2008', '下陆', '291', 'x', 'xl', 'xialu', '', '区', '420204', '0714', 3);
INSERT INTO `sys_district` VALUES ('2009', '铁山', '291', 't', 'ts', 'tieshan', '', '区', '420205', '0714', 4);
INSERT INTO `sys_district` VALUES ('201', '连云港', '11', 'l', 'lyg', 'lianyungang', '', '市', '320700', '0518', 7);
INSERT INTO `sys_district` VALUES ('2010', '阳新', '291', 'y', 'yx', 'yangxin', '', '县', '420222', '0714', 5);
INSERT INTO `sys_district` VALUES ('2011', '大冶', '291', 'd', 'dy', 'daye', '', '市', '420281', '0714', 6);
INSERT INTO `sys_district` VALUES ('2012', '茅箭', '292', 'm', 'mj', 'maojian', '', '区', '420302', '0719', 1);
INSERT INTO `sys_district` VALUES ('2013', '张湾', '292', 'z', 'zw', 'zhangwan', '', '区', '420303', '0719', 2);
INSERT INTO `sys_district` VALUES ('2014', '郧阳', '292', 'y', 'yy', 'yunyang', '', '区', '420304', '0719', 3);
INSERT INTO `sys_district` VALUES ('2015', '郧西', '292', 'y', 'yx', 'yunxi', '', '县', '420322', '0719', 4);
INSERT INTO `sys_district` VALUES ('2016', '竹山', '292', 'z', 'zs', 'zhushan', '', '县', '420323', '0719', 5);
INSERT INTO `sys_district` VALUES ('2017', '竹溪', '292', 'z', 'zx', 'zhuxi', '', '县', '420324', '0719', 6);
INSERT INTO `sys_district` VALUES ('2018', '房县', '292', 'f', 'fx', 'fangxian', '', '', '420325', '0719', 7);
INSERT INTO `sys_district` VALUES ('2019', '丹江口', '292', 'd', 'djk', 'danjiangkou', '', '市', '420381', '0719', 8);
INSERT INTO `sys_district` VALUES ('202', '淮安', '11', 'h', 'ha', 'huaian', '', '市', '320800', '0517', 8);
INSERT INTO `sys_district` VALUES ('2020', '西陵', '293', 'x', 'xl', 'xiling', '', '区', '420502', '0717', 1);
INSERT INTO `sys_district` VALUES ('2021', '伍家岗', '293', 'w', 'wjg', 'wujiagang', '', '区', '420503', '0717', 2);
INSERT INTO `sys_district` VALUES ('2022', '点军', '293', 'd', 'dj', 'dianjun', '', '区', '420504', '0717', 3);
INSERT INTO `sys_district` VALUES ('2023', '猇亭', '293', 'g', 'gt', 'guoting', '', '区', '420505', '0717', 14);
INSERT INTO `sys_district` VALUES ('2024', '夷陵', '293', 'y', 'yl', 'yiling', '', '区', '420506', '0717', 5);
INSERT INTO `sys_district` VALUES ('2025', '远安', '293', 'y', 'ya', 'yuanan', '', '县', '420525', '0717', 6);
INSERT INTO `sys_district` VALUES ('2026', '兴山', '293', 'x', 'xs', 'xingshan', '', '县', '420526', '0717', 7);
INSERT INTO `sys_district` VALUES ('2027', '秭归', '293', 'z', 'zg', 'zigui', '', '县', '420527', '0717', 8);
INSERT INTO `sys_district` VALUES ('2028', '长阳', '293', 'z', 'zy', 'zhangyang', '土家族', '自治县', '420528', '0717', 9);
INSERT INTO `sys_district` VALUES ('2029', '五峰', '293', 'w', 'wf', 'wufeng', '土家族', '自治县', '420529', '0717', 10);
INSERT INTO `sys_district` VALUES ('203', '盐城', '11', 'y', 'yc', 'yancheng', '', '市', '320900', '0515', 9);
INSERT INTO `sys_district` VALUES ('2030', '宜都', '293', 'y', 'yd', 'yidu', '', '市', '420581', '0717', 11);
INSERT INTO `sys_district` VALUES ('2031', '当阳', '293', 'd', 'dy', 'dangyang', '', '市', '420582', '0717', 12);
INSERT INTO `sys_district` VALUES ('2032', '枝江', '293', 'z', 'zj', 'zhijiang', '', '市', '420583', '0717', 13);
INSERT INTO `sys_district` VALUES ('2033', '襄城', '294', 'x', 'xc', 'xiangcheng', '', '区', '420602', '0710', 1);
INSERT INTO `sys_district` VALUES ('2034', '樊城', '294', 'f', 'fc', 'fancheng', '', '区', '420606', '0710', 2);
INSERT INTO `sys_district` VALUES ('2035', '襄州', '294', 'x', 'xz', 'xiangzhou', '', '区', '420607', '0710', 3);
INSERT INTO `sys_district` VALUES ('2036', '南漳', '294', 'n', 'nz', 'nanzhang', '', '县', '420624', '0710', 4);
INSERT INTO `sys_district` VALUES ('2037', '谷城', '294', 'g', 'gc', 'gucheng', '', '县', '420625', '0710', 5);
INSERT INTO `sys_district` VALUES ('2038', '保康', '294', 'b', 'bk', 'baokang', '', '县', '420626', '0710', 6);
INSERT INTO `sys_district` VALUES ('2039', '老河口', '294', 'l', 'lhk', 'laohekou', '', '市', '420682', '0710', 7);
INSERT INTO `sys_district` VALUES ('204', '扬州', '11', 'y', 'yz', 'yangzhou', '', '市', '321000', '0514', 10);
INSERT INTO `sys_district` VALUES ('2040', '枣阳', '294', 'z', 'zy', 'zaoyang', '', '市', '420683', '0710', 8);
INSERT INTO `sys_district` VALUES ('2041', '宜城', '294', 'y', 'yc', 'yicheng', '', '市', '420684', '0710', 9);
INSERT INTO `sys_district` VALUES ('2042', '粱子湖', '295', 'l', 'lzh', 'liangzihu', '', '区', '420702', '', 1);
INSERT INTO `sys_district` VALUES ('2043', '华容', '295', 'h', 'hr', 'huarong', '', '区', '420703', '', 2);
INSERT INTO `sys_district` VALUES ('2044', '鄂城', '295', 'e', 'ec', 'echeng', '', '区', '420704', '', 3);
INSERT INTO `sys_district` VALUES ('2045', '东宝', '296', 'd', 'db', 'dongbao', '', '区', '420802', '0724', 1);
INSERT INTO `sys_district` VALUES ('2046', '掇刀', '296', 'd', 'dd', 'duodao', '', '区', '420804', '0724', 2);
INSERT INTO `sys_district` VALUES ('2047', '京山', '296', 'j', 'js', 'jingshan', '', '县', '420821', '0724', 3);
INSERT INTO `sys_district` VALUES ('2048', '沙洋', '296', 's', 'sy', 'shayang', '', '县', '420822', '0724', 4);
INSERT INTO `sys_district` VALUES ('2049', '钟祥', '296', 'z', 'zx', 'zhongxiang', '', '市', '420881', '0724', 5);
INSERT INTO `sys_district` VALUES ('205', '镇江', '11', 'z', 'zj', 'zhenjiang', '', '市', '321100', '0511', 11);
INSERT INTO `sys_district` VALUES ('2050', '孝南', '297', 'x', 'xn', 'xiaonan', '', '区', '420902', '0712', 1);
INSERT INTO `sys_district` VALUES ('2051', '大悟', '297', 'd', 'dw', 'dawu', '', '县', '420922', '0712', 2);
INSERT INTO `sys_district` VALUES ('2052', '云梦', '297', 'y', 'ym', 'yunmeng', '', '县', '420923', '0712', 3);
INSERT INTO `sys_district` VALUES ('2053', '应城', '297', 'y', 'yc', 'yingcheng', '', '市', '420981', '0712', 4);
INSERT INTO `sys_district` VALUES ('2054', '安陆', '297', 'a', 'al', 'anlu', '', '市', '420982', '0712', 5);
INSERT INTO `sys_district` VALUES ('2055', '汉川', '297', 'h', 'hc', 'hanchuan', '', '市', '420984', '0712', 6);
INSERT INTO `sys_district` VALUES ('2056', '沙市', '298', 's', 'ss', 'shashi', '', '区', '421002', '0716', 1);
INSERT INTO `sys_district` VALUES ('2057', '荆州', '298', 'j', 'jz', 'jingzhou', '', '区', '421003', '0716', 2);
INSERT INTO `sys_district` VALUES ('2058', '公安', '298', 'g', 'ga', 'gongan', '', '县', '421022', '0716', 3);
INSERT INTO `sys_district` VALUES ('2059', '监利', '298', 'j', 'jl', 'jianli', '', '县', '421023', '0716', 4);
INSERT INTO `sys_district` VALUES ('206', '泰州', '11', 't', 'tz', 'taizhou', '', '市', '321200', '0523', 12);
INSERT INTO `sys_district` VALUES ('2060', '江陵', '298', 'j', 'jl', 'jiangling', '', '县', '421024', '0716', 5);
INSERT INTO `sys_district` VALUES ('2061', '石首', '298', 's', 'ss', 'shishou', '', '市', '421081', '0716', 6);
INSERT INTO `sys_district` VALUES ('2062', '洪湖', '298', 'h', 'hh', 'honghu', '', '市', '421083', '0716', 7);
INSERT INTO `sys_district` VALUES ('2063', '松滋', '298', 's', 'sz', 'songzi', '', '市', '421087', '0716', 8);
INSERT INTO `sys_district` VALUES ('2064', '黄州', '299', 'h', 'hz', 'huangzhou', '', '区', '421102', '0713', 1);
INSERT INTO `sys_district` VALUES ('2065', '团风', '299', 't', 'tf', 'tuanfeng', '', '县', '421121', '0713', 2);
INSERT INTO `sys_district` VALUES ('2066', '红安', '299', 'h', 'ha', 'hongan', '', '县', '421122', '0713', 3);
INSERT INTO `sys_district` VALUES ('2067', '罗田', '299', 'l', 'lt', 'luotian', '', '县', '421123', '0713', 4);
INSERT INTO `sys_district` VALUES ('2068', '英山', '299', 'y', 'ys', 'yingshan', '', '县', '421124', '0713', 5);
INSERT INTO `sys_district` VALUES ('2069', '浠水', '299', 'x', 'xs', 'xishui', '', '县', '421125', '0713', 6);
INSERT INTO `sys_district` VALUES ('207', '宿迁', '11', 's', 'sq', 'suqian', '', '市', '321300', '0527', 13);
INSERT INTO `sys_district` VALUES ('2070', '蕲春', '299', 'q', 'qc', 'qichun', '', '县', '421126', '0713', 7);
INSERT INTO `sys_district` VALUES ('2071', '黄梅', '299', 'h', 'hm', 'huangmei', '', '县', '421127', '0713', 8);
INSERT INTO `sys_district` VALUES ('2072', '麻城', '299', 'm', 'mc', 'macheng', '', '市', '421181', '0713', 9);
INSERT INTO `sys_district` VALUES ('2073', '武穴', '299', 'w', 'wx', 'wuxue', '', '市', '421182', '0713', 10);
INSERT INTO `sys_district` VALUES ('2074', '咸安', '300', 'x', 'xa', 'xianan', '', '区', '421202', '0715', 1);
INSERT INTO `sys_district` VALUES ('2075', '嘉鱼', '300', 'j', 'jy', 'jiayu', '', '县', '421221', '0715', 2);
INSERT INTO `sys_district` VALUES ('2076', '通城', '300', 't', 'tc', 'tongcheng', '', '县', '421222', '0715', 3);
INSERT INTO `sys_district` VALUES ('2077', '崇阳', '300', 'c', 'cy', 'chongyang', '', '县', '421223', '0715', 4);
INSERT INTO `sys_district` VALUES ('2078', '通山', '300', 't', 'ts', 'tongshan', '', '县', '421224', '0715', 5);
INSERT INTO `sys_district` VALUES ('2079', '赤壁', '300', 'c', 'cb', 'chibi', '', '市', '421281', '0715', 6);
INSERT INTO `sys_district` VALUES ('208', '杭州', '12', 'h', 'hz', 'hangzhou', '', '市', '330100', '0571', 1);
INSERT INTO `sys_district` VALUES ('2080', '曾都', '301', 'c', 'cd', 'cengdu', '', '区', '421303', '0722', 1);
INSERT INTO `sys_district` VALUES ('2081', '随县', '301', 's', 'sx', 'suixian', '', '', '421321', '0722', 2);
INSERT INTO `sys_district` VALUES ('2082', '广水', '301', 'g', 'gs', 'guangshui', '', '市', '421381', '0722', 3);
INSERT INTO `sys_district` VALUES ('2083', '恩施', '302', 'e', 'es', 'enshi', '', '市', '422801', '0718', 1);
INSERT INTO `sys_district` VALUES ('2084', '利川', '302', 'l', 'lc', 'lichuan', '', '市', '422802', '0718', 2);
INSERT INTO `sys_district` VALUES ('2085', '建始', '302', 'j', 'js', 'jianshi', '', '县', '422822', '0718', 3);
INSERT INTO `sys_district` VALUES ('2086', '巴东', '302', 'b', 'bd', 'badong', '', '县', '422823', '0718', 4);
INSERT INTO `sys_district` VALUES ('2087', '宣恩', '302', 'x', 'xe', 'xuanen', '', '县', '422825', '0718', 5);
INSERT INTO `sys_district` VALUES ('2088', '咸丰', '302', 'x', 'xf', 'xianfeng', '', '县', '422826', '0718', 6);
INSERT INTO `sys_district` VALUES ('2089', '来凤', '302', 'l', 'lf', 'laifeng', '', '县', '422827', '0718', 7);
INSERT INTO `sys_district` VALUES ('209', '宁波', '12', 'n', 'nb', 'ningbo', '', '市', '330200', '0574', 2);
INSERT INTO `sys_district` VALUES ('2090', '鹤峰', '302', 'h', 'hf', 'hefeng', '', '县', '422828', '0718', 8);
INSERT INTO `sys_district` VALUES ('2091', '芙蓉', '307', 'f', 'fr', 'furong', '', '区', '430102', '0731', 1);
INSERT INTO `sys_district` VALUES ('2092', '天心', '307', 't', 'tx', 'tianxin', '', '区', '430103', '0731', 2);
INSERT INTO `sys_district` VALUES ('2093', '岳麓', '307', 'y', 'yl', 'yuelu', '', '区', '430104', '0731', 3);
INSERT INTO `sys_district` VALUES ('2094', '开福', '307', 'k', 'kf', 'kaifu', '', '区', '430105', '0731', 4);
INSERT INTO `sys_district` VALUES ('2095', '雨花', '307', 'y', 'yh', 'yuhua', '', '区', '430111', '0731', 5);
INSERT INTO `sys_district` VALUES ('2096', '望城', '307', 'w', 'wc', 'wangcheng', '', '区', '430112', '0731', 6);
INSERT INTO `sys_district` VALUES ('2097', '长沙', '307', 'z', 'zs', 'zhangsha', '', '县', '430121', '0731', 7);
INSERT INTO `sys_district` VALUES ('2098', '宁乡', '307', 'n', 'nx', 'ningxiang', '', '县', '430124', '0731', 8);
INSERT INTO `sys_district` VALUES ('2099', '浏阳', '307', 'l', 'ly', 'liuyang', '', '市', '430181', '0731', 9);
INSERT INTO `sys_district` VALUES ('21', '广西', '0', 'g', 'gx', 'guangxi', '壮族', '自治区', '450000', '', 22);
INSERT INTO `sys_district` VALUES ('210', '温州', '12', 'w', 'wz', 'wenzhou', '', '市', '330300', '0577', 3);
INSERT INTO `sys_district` VALUES ('2100', '荷塘', '308', 'h', 'ht', 'hetang', '', '区', '430202', '0731', 1);
INSERT INTO `sys_district` VALUES ('2101', '芦淞', '308', 'l', 'ls', 'lusong', '', '区', '430203', '0731', 2);
INSERT INTO `sys_district` VALUES ('2102', '石峰', '308', 's', 'sf', 'shifeng', '', '区', '430204', '0731', 3);
INSERT INTO `sys_district` VALUES ('2103', '天元', '308', 't', 'ty', 'tianyuan', '', '区', '430211', '0731', 4);
INSERT INTO `sys_district` VALUES ('2104', '株洲', '308', 'z', 'zz', 'zhuzhou', '', '县', '430221', '0731', 5);
INSERT INTO `sys_district` VALUES ('2105', '攸县', '308', 'y', 'yx', 'youxian', '', '', '430223', '0731', 6);
INSERT INTO `sys_district` VALUES ('2106', '茶陵', '308', 'c', 'cl', 'chaling', '', '县', '430224', '0731', 7);
INSERT INTO `sys_district` VALUES ('2107', '炎陵', '308', 'y', 'yl', 'yanling', '', '县', '430225', '0731', 8);
INSERT INTO `sys_district` VALUES ('2108', '醴陵', '308', 'l', 'll', 'liling', '', '市', '430281', '0731', 9);
INSERT INTO `sys_district` VALUES ('2109', '雨湖', '309', 'y', 'yh', 'yuhu', '', '区', '430302', '0731', 1);
INSERT INTO `sys_district` VALUES ('211', '嘉兴', '12', 'j', 'jx', 'jiaxing', '', '市', '330400', '0573', 4);
INSERT INTO `sys_district` VALUES ('2110', '岳塘', '309', 'y', 'yt', 'yuetang', '', '区', '430304', '0731', 2);
INSERT INTO `sys_district` VALUES ('2111', '湘潭', '309', 'x', 'xt', 'xiangtan', '', '县', '430321', '0731', 3);
INSERT INTO `sys_district` VALUES ('2112', '湘乡', '309', 'x', 'xx', 'xiangxiang', '', '市', '430381', '0731', 4);
INSERT INTO `sys_district` VALUES ('2113', '韶山', '309', 's', 'ss', 'shaoshan', '', '市', '430382', '0731', 5);
INSERT INTO `sys_district` VALUES ('2114', '珠晖', '310', 'z', 'zh', 'zhuhui', '', '区', '430405', '0734', 1);
INSERT INTO `sys_district` VALUES ('2115', '雁峰', '310', 'y', 'yf', 'yanfeng', '', '区', '430406', '0734', 2);
INSERT INTO `sys_district` VALUES ('2116', '石鼓', '310', 's', 'sg', 'shigu', '', '区', '430407', '0734', 3);
INSERT INTO `sys_district` VALUES ('2117', '蒸湘', '310', 'z', 'zx', 'zhengxiang', '', '区', '430408', '0734', 4);
INSERT INTO `sys_district` VALUES ('2118', '南岳', '310', 'n', 'ny', 'nanyue', '', '区', '430412', '0734', 5);
INSERT INTO `sys_district` VALUES ('2119', '衡阳', '310', 'h', 'hy', 'hengyang', '', '县', '430421', '0734', 6);
INSERT INTO `sys_district` VALUES ('212', '湖州', '12', 'h', 'hz', 'huzhou', '', '市', '330500', '0572', 5);
INSERT INTO `sys_district` VALUES ('2120', '衡南', '310', 'h', 'hn', 'hengnan', '', '县', '430422', '0734', 7);
INSERT INTO `sys_district` VALUES ('2121', '衡山', '310', 'h', 'hs', 'hengshan', '', '县', '430423', '0734', 8);
INSERT INTO `sys_district` VALUES ('2122', '衡东', '310', 'h', 'hd', 'hengdong', '', '县', '430424', '0734', 9);
INSERT INTO `sys_district` VALUES ('2123', '祁东', '310', 'q', 'qd', 'qidong', '', '县', '430426', '0734', 10);
INSERT INTO `sys_district` VALUES ('2124', '耒阳', '310', 'l', 'ly', 'leiyang', '', '市', '430481', '0734', 11);
INSERT INTO `sys_district` VALUES ('2125', '常宁', '310', 'c', 'cn', 'changning', '', '市', '430482', '0734', 12);
INSERT INTO `sys_district` VALUES ('2126', '双清', '311', 's', 'sq', 'shuangqing', '', '区', '430502', '0739', 1);
INSERT INTO `sys_district` VALUES ('2127', '大祥', '311', 'd', 'dx', 'daxiang', '', '区', '430503', '0739', 2);
INSERT INTO `sys_district` VALUES ('2128', '北塔', '311', 'b', 'bt', 'beita', '', '区', '430511', '0739', 3);
INSERT INTO `sys_district` VALUES ('2129', '邵东', '311', 's', 'sd', 'shaodong', '', '县', '430521', '0739', 4);
INSERT INTO `sys_district` VALUES ('213', '绍兴', '12', 's', 'sx', 'shaoxing', '', '市', '330600', '0575', 6);
INSERT INTO `sys_district` VALUES ('2130', '新邵', '311', 'x', 'xs', 'xinshao', '', '县', '430522', '0739', 5);
INSERT INTO `sys_district` VALUES ('2131', '邵阳', '311', 's', 'sy', 'shaoyang', '', '县', '430523', '0739', 6);
INSERT INTO `sys_district` VALUES ('2132', '隆回', '311', 'l', 'lh', 'longhui', '', '县', '430524', '0739', 7);
INSERT INTO `sys_district` VALUES ('2133', '洞口', '311', 'd', 'dk', 'dongkou', '', '县', '430525', '0739', 8);
INSERT INTO `sys_district` VALUES ('2134', '绥宁', '311', 's', 'sn', 'suining', '', '县', '430527', '0739', 9);
INSERT INTO `sys_district` VALUES ('2135', '新宁', '311', 'x', 'xn', 'xinning', '', '县', '430528', '0739', 10);
INSERT INTO `sys_district` VALUES ('2136', '城步', '311', 'c', 'cb', 'chengbu', '苗族', '自治县', '430529', '0739', 11);
INSERT INTO `sys_district` VALUES ('2137', '武冈', '311', 'w', 'wg', 'wugang', '', '市', '430581', '0739', 12);
INSERT INTO `sys_district` VALUES ('2138', '岳阳楼', '312', 'y', 'yyl', 'yueyanglou', '', '区', '430602', '0730', 1);
INSERT INTO `sys_district` VALUES ('2139', '云溪', '312', 'y', 'yx', 'yunxi', '', '区', '430603', '0730', 2);
INSERT INTO `sys_district` VALUES ('214', '金华', '12', 'j', 'jh', 'jinhua', '', '市', '330700', '0579', 7);
INSERT INTO `sys_district` VALUES ('2140', '君山', '312', 'j', 'js', 'junshan', '', '区', '430611', '0730', 3);
INSERT INTO `sys_district` VALUES ('2141', '岳阳', '312', 'y', 'yy', 'yueyang', '', '县', '430621', '0730', 4);
INSERT INTO `sys_district` VALUES ('2142', '华容', '312', 'h', 'hr', 'huarong', '', '县', '430623', '0730', 5);
INSERT INTO `sys_district` VALUES ('2143', '湘阴', '312', 'x', 'xy', 'xiangyin', '', '县', '430624', '0730', 6);
INSERT INTO `sys_district` VALUES ('2144', '平江', '312', 'p', 'pj', 'pingjiang', '', '县', '430626', '0730', 7);
INSERT INTO `sys_district` VALUES ('2145', '汨罗', '312', 'm', 'ml', 'miluo', '', '市', '430681', '0730', 8);
INSERT INTO `sys_district` VALUES ('2146', '临湘', '312', 'l', 'lx', 'linxiang', '', '市', '430682', '0730', 9);
INSERT INTO `sys_district` VALUES ('2147', '武陵', '313', 'w', 'wl', 'wuling', '', '区', '430702', '0736', 1);
INSERT INTO `sys_district` VALUES ('2148', '鼎城', '313', 'd', 'dc', 'dingcheng', '', '区', '430703', '0736', 2);
INSERT INTO `sys_district` VALUES ('2149', '安乡', '313', 'a', 'ax', 'anxiang', '', '县', '430721', '0736', 3);
INSERT INTO `sys_district` VALUES ('215', '衢州', '12', 'q', 'qz', 'quzhou', '', '市', '330800', '0570', 8);
INSERT INTO `sys_district` VALUES ('2150', '汉寿', '313', 'h', 'hs', 'hanshou', '', '县', '430722', '0736', 4);
INSERT INTO `sys_district` VALUES ('2151', '澧县', '313', 'l', 'lx', 'lixian', '', '', '430723', '0736', 5);
INSERT INTO `sys_district` VALUES ('2152', '临澧', '313', 'l', 'll', 'linli', '', '县', '430724', '0736', 6);
INSERT INTO `sys_district` VALUES ('2153', '桃源', '313', 't', 'ty', 'taoyuan', '', '县', '430725', '0736', 7);
INSERT INTO `sys_district` VALUES ('2154', '石门', '313', 's', 'sm', 'shimen', '', '县', '430726', '0736', 8);
INSERT INTO `sys_district` VALUES ('2155', '津市', '313', 'j', 'js', 'jinshi', '', '市', '430781', '0736', 9);
INSERT INTO `sys_district` VALUES ('2156', '永定', '314', 'y', 'yd', 'yongding', '', '区', '430802', '0744', 1);
INSERT INTO `sys_district` VALUES ('2157', '武陵源', '314', 'w', 'wly', 'wulingyuan', '', '区', '430811', '0744', 2);
INSERT INTO `sys_district` VALUES ('2158', '慈利', '314', 'c', 'cl', 'cili', '', '县', '430821', '0744', 3);
INSERT INTO `sys_district` VALUES ('2159', '桑植', '314', 's', 'sz', 'sangzhi', '', '县', '430822', '0744', 4);
INSERT INTO `sys_district` VALUES ('216', '舟山', '12', 'z', 'zs', 'zhoushan', '', '市', '330900', '0580', 9);
INSERT INTO `sys_district` VALUES ('2160', '资阳', '315', 'z', 'zy', 'ziyang', '', '区', '430902', '0737', 1);
INSERT INTO `sys_district` VALUES ('2161', '赫山', '315', 'h', 'hs', 'heshan', '', '区', '430903', '0737', 2);
INSERT INTO `sys_district` VALUES ('2162', '南县', '315', 'n', 'nx', 'nanxian', '', '', '430921', '0737', 3);
INSERT INTO `sys_district` VALUES ('2163', '桃江', '315', 't', 'tj', 'taojiang', '', '县', '430922', '0737', 4);
INSERT INTO `sys_district` VALUES ('2164', '安化', '315', 'a', 'ah', 'anhua', '', '县', '430923', '0737', 5);
INSERT INTO `sys_district` VALUES ('2165', '沅江', '315', 'y', 'yj', 'yuanjiang', '', '市', '430981', '0737', 6);
INSERT INTO `sys_district` VALUES ('2166', '北湖', '316', 'b', 'bh', 'beihu', '', '区', '431002', '0735', 1);
INSERT INTO `sys_district` VALUES ('2167', '苏仙', '316', 's', 'sx', 'suxian', '', '区', '431003', '0735', 2);
INSERT INTO `sys_district` VALUES ('2168', '桂阳', '316', 'g', 'gy', 'guiyang', '', '县', '431021', '0735', 3);
INSERT INTO `sys_district` VALUES ('2169', '宜章', '316', 'y', 'yz', 'yizhang', '', '县', '431022', '0735', 4);
INSERT INTO `sys_district` VALUES ('217', '台州', '12', 't', 'tz', 'taizhou', '', '市', '331000', '0576', 10);
INSERT INTO `sys_district` VALUES ('2170', '永兴', '316', 'y', 'yx', 'yongxing', '', '县', '431023', '0735', 5);
INSERT INTO `sys_district` VALUES ('2171', '嘉禾', '316', 'j', 'jh', 'jiahe', '', '县', '431024', '0735', 6);
INSERT INTO `sys_district` VALUES ('2172', '临武', '316', 'l', 'lw', 'linwu', '', '县', '431025', '0735', 7);
INSERT INTO `sys_district` VALUES ('2173', '汝城', '316', 'r', 'rc', 'rucheng', '', '县', '431026', '0735', 8);
INSERT INTO `sys_district` VALUES ('2174', '桂东', '316', 'g', 'gd', 'guidong', '', '县', '431027', '0735', 9);
INSERT INTO `sys_district` VALUES ('2175', '安仁', '316', 'a', 'ar', 'anren', '', '县', '431028', '0735', 10);
INSERT INTO `sys_district` VALUES ('2176', '资兴', '316', 'z', 'zx', 'zixing', '', '市', '431081', '0735', 11);
INSERT INTO `sys_district` VALUES ('2177', '零陵', '317', 'l', 'll', 'lingling', '', '区', '431102', '0746', 1);
INSERT INTO `sys_district` VALUES ('2178', '冷水滩', '317', 'l', 'lst', 'lengshuitan', '', '区', '431103', '0746', 2);
INSERT INTO `sys_district` VALUES ('2179', '祁阳', '317', 'q', 'qy', 'qiyang', '', '县', '431121', '0746', 3);
INSERT INTO `sys_district` VALUES ('218', '丽水', '12', 'l', 'ls', 'lishui', '', '市', '331100', '0578', 11);
INSERT INTO `sys_district` VALUES ('2180', '东安', '317', 'd', 'da', 'dongan', '', '县', '431122', '0746', 4);
INSERT INTO `sys_district` VALUES ('2181', '双牌', '317', 's', 'sp', 'shuangpai', '', '县', '431123', '0746', 5);
INSERT INTO `sys_district` VALUES ('2182', '道县', '317', 'd', 'dx', 'daoxian', '', '', '431124', '0746', 6);
INSERT INTO `sys_district` VALUES ('2183', '江永', '317', 'j', 'jy', 'jiangyong', '', '县', '431125', '0746', 7);
INSERT INTO `sys_district` VALUES ('2184', '宁远', '317', 'n', 'ny', 'ningyuan', '', '县', '431126', '0746', 8);
INSERT INTO `sys_district` VALUES ('2185', '蓝山', '317', 'l', 'ls', 'lanshan', '', '县', '431127', '0746', 9);
INSERT INTO `sys_district` VALUES ('2186', '新田', '317', 'x', 'xt', 'xintian', '', '县', '431128', '0746', 10);
INSERT INTO `sys_district` VALUES ('2187', '江华', '317', 'j', 'jh', 'jianghua', '瑶族', '自治县', '431129', '0746', 11);
INSERT INTO `sys_district` VALUES ('2188', '鹤城', '318', 'h', 'hc', 'hecheng', '', '区', '431202', '0745', 1);
INSERT INTO `sys_district` VALUES ('2189', '中方', '318', 'z', 'zf', 'zhongfang', '', '县', '431221', '0745', 2);
INSERT INTO `sys_district` VALUES ('219', '合肥', '13', 'h', 'hf', 'hefei', '', '市', '340100', '0551', 1);
INSERT INTO `sys_district` VALUES ('2190', '沅陵', '318', 'y', 'yl', 'yuanling', '', '县', '431222', '0745', 3);
INSERT INTO `sys_district` VALUES ('2191', '辰溪', '318', 'c', 'cx', 'chenxi', '', '县', '431223', '0745', 4);
INSERT INTO `sys_district` VALUES ('2192', '溆浦', '318', 'x', 'xp', 'xupu', '', '县', '431224', '0745', 5);
INSERT INTO `sys_district` VALUES ('2193', '会同', '318', 'h', 'ht', 'huitong', '', '县', '431225', '0745', 6);
INSERT INTO `sys_district` VALUES ('2194', '麻阳', '318', 'm', 'my', 'mayang', '苗族', '自治县', '431226', '0745', 7);
INSERT INTO `sys_district` VALUES ('2195', '新晃', '318', 'x', 'xh', 'xinhuang', '侗族', '自治县', '431227', '0745', 8);
INSERT INTO `sys_district` VALUES ('2196', '芷江', '318', 'z', 'zj', 'zhijiang', '侗族', '自治县', '431228', '0745', 9);
INSERT INTO `sys_district` VALUES ('2197', '靖州', '318', 'j', 'jz', 'jingzhou', '苗族侗族', '自治县', '431229', '0745', 10);
INSERT INTO `sys_district` VALUES ('2198', '通道', '318', 't', 'td', 'tongdao', '侗族', '自治县', '431230', '0745', 11);
INSERT INTO `sys_district` VALUES ('2199', '洪江', '318', 'h', 'hj', 'hongjiang', '', '市', '431281', '0745', 12);
INSERT INTO `sys_district` VALUES ('22', '海南', '0', 'h', 'hn', 'hainan', '', '省', '460000', '', 23);
INSERT INTO `sys_district` VALUES ('220', '芜湖', '13', 'w', 'wh', 'wuhu', '', '市', '340200', '0553', 2);
INSERT INTO `sys_district` VALUES ('2200', '娄星', '319', 'l', 'lx', 'louxing', '', '区', '431302', '0738', 1);
INSERT INTO `sys_district` VALUES ('2201', '双峰', '319', 's', 'sf', 'shuangfeng', '', '县', '431321', '0738', 2);
INSERT INTO `sys_district` VALUES ('2202', '新化', '319', 'x', 'xh', 'xinhua', '', '县', '431322', '0738', 3);
INSERT INTO `sys_district` VALUES ('2203', '冷水江', '319', 'l', 'lsj', 'lengshuijiang', '', '市', '431381', '0738', 4);
INSERT INTO `sys_district` VALUES ('2204', '涟源', '319', 'l', 'ly', 'lianyuan', '', '市', '431382', '0738', 5);
INSERT INTO `sys_district` VALUES ('2205', '吉首', '320', 'j', 'js', 'jishou', '', '市', '433101', '0743', 1);
INSERT INTO `sys_district` VALUES ('2206', '泸溪', '320', 'l', 'lx', 'luxi', '', '县', '433122', '0743', 2);
INSERT INTO `sys_district` VALUES ('2207', '凤凰', '320', 'f', 'fh', 'fenghuang', '', '县', '433123', '0743', 3);
INSERT INTO `sys_district` VALUES ('2208', '花垣', '320', 'h', 'hy', 'huayuan', '', '县', '433124', '0743', 4);
INSERT INTO `sys_district` VALUES ('2209', '保靖', '320', 'b', 'bj', 'baojing', '', '县', '433125', '0743', 5);
INSERT INTO `sys_district` VALUES ('221', '蚌埠', '13', 'b', 'bb', 'bengbu', '', '市', '340300', '0552', 3);
INSERT INTO `sys_district` VALUES ('2210', '古丈', '320', 'g', 'gz', 'guzhang', '', '县', '433126', '0743', 6);
INSERT INTO `sys_district` VALUES ('2211', '永顺', '320', 'y', 'ys', 'yongshun', '', '县', '433127', '0743', 7);
INSERT INTO `sys_district` VALUES ('2212', '龙山', '320', 'l', 'ls', 'longshan', '', '县', '433130', '0743', 8);
INSERT INTO `sys_district` VALUES ('2213', '荔湾', '321', 'l', 'lw', 'liwan', '', '区', '440103', '020', 1);
INSERT INTO `sys_district` VALUES ('2214', '越秀', '321', 'y', 'yx', 'yuexiu', '', '区', '440104', '020', 2);
INSERT INTO `sys_district` VALUES ('2215', '海珠', '321', 'h', 'hz', 'haizhu', '', '区', '440105', '020', 3);
INSERT INTO `sys_district` VALUES ('2216', '天河', '321', 't', 'th', 'tianhe', '', '区', '440106', '020', 4);
INSERT INTO `sys_district` VALUES ('2217', '白云', '321', 'b', 'by', 'baiyun', '', '区', '440111', '020', 5);
INSERT INTO `sys_district` VALUES ('2218', '黄埔', '321', 'h', 'hp', 'huangpu', '', '区', '440112', '020', 6);
INSERT INTO `sys_district` VALUES ('2219', '番禺', '321', 'f', 'fy', 'fanyu', '', '区', '440113', '020', 7);
INSERT INTO `sys_district` VALUES ('222', '淮南', '13', 'h', 'hn', 'huainan', '', '市', '340400', '0554', 4);
INSERT INTO `sys_district` VALUES ('2220', '花都', '321', 'h', 'hd', 'huadu', '', '区', '440114', '020', 8);
INSERT INTO `sys_district` VALUES ('2221', '南沙', '321', 'n', 'ns', 'nansha', '', '区', '440115', '020', 9);
INSERT INTO `sys_district` VALUES ('2223', '增城', '321', 'z', 'zc', 'zengcheng', '', '区', '440118', '020', 12);
INSERT INTO `sys_district` VALUES ('2224', '从化', '321', 'c', 'ch', 'conghua', '', '区', '440117', '020', 11);
INSERT INTO `sys_district` VALUES ('2225', '武江', '322', 'w', 'wj', 'wujiang', '', '区', '440203', '0751', 1);
INSERT INTO `sys_district` VALUES ('2226', '浈江', '322', 'z', 'zj', 'zhenjiang', '', '区', '440204', '0751', 2);
INSERT INTO `sys_district` VALUES ('2227', '曲江', '322', 'q', 'qj', 'qujiang', '', '区', '440205', '0751', 3);
INSERT INTO `sys_district` VALUES ('2228', '始兴', '322', 's', 'sx', 'shixing', '', '县', '440222', '0751', 4);
INSERT INTO `sys_district` VALUES ('2229', '仁化', '322', 'r', 'rh', 'renhua', '', '县', '440224', '0751', 5);
INSERT INTO `sys_district` VALUES ('223', '马鞍山', '13', 'm', 'mas', 'maanshan', '', '市', '340500', '0555', 5);
INSERT INTO `sys_district` VALUES ('2230', '翁源', '322', 'w', 'wy', 'wengyuan', '', '县', '440229', '0751', 6);
INSERT INTO `sys_district` VALUES ('2231', '乳源', '322', 'r', 'ry', 'ruyuan', '瑶族', '自治县', '440232', '0751', 7);
INSERT INTO `sys_district` VALUES ('2232', '新丰', '322', 'x', 'xf', 'xinfeng', '', '县', '440233', '0751', 8);
INSERT INTO `sys_district` VALUES ('2233', '乐昌', '322', 'l', 'lc', 'lechang', '', '市', '440281', '0751', 9);
INSERT INTO `sys_district` VALUES ('2234', '南雄', '322', 'n', 'nx', 'nanxiong', '', '市', '440282', '0751', 10);
INSERT INTO `sys_district` VALUES ('2235', '罗湖', '323', 'l', 'lh', 'luohu', '', '区', '440303', '0755', 1);
INSERT INTO `sys_district` VALUES ('2236', '福田', '323', 'f', 'ft', 'futian', '', '区', '440304', '0755', 2);
INSERT INTO `sys_district` VALUES ('2237', '南山', '323', 'n', 'ns', 'nanshan', '', '区', '440305', '0755', 3);
INSERT INTO `sys_district` VALUES ('2238', '宝安', '323', 'b', 'ba', 'baoan', '', '区', '440306', '0755', 4);
INSERT INTO `sys_district` VALUES ('2239', '龙岗', '323', 'l', 'lg', 'longgang', '', '区', '440307', '0755', 5);
INSERT INTO `sys_district` VALUES ('224', '淮北', '13', 'h', 'hb', 'huaibei', '', '市', '340600', '0561', 6);
INSERT INTO `sys_district` VALUES ('2240', '盐田', '323', 'y', 'yt', 'yantian', '', '区', '440308', '0755', 6);
INSERT INTO `sys_district` VALUES ('2241', '香洲', '324', 'x', 'xz', 'xiangzhou', '', '区', '440402', '0756', 1);
INSERT INTO `sys_district` VALUES ('2242', '斗门', '324', 'd', 'dm', 'doumen', '', '区', '440403', '0756', 2);
INSERT INTO `sys_district` VALUES ('2243', '金湾', '324', 'j', 'jw', 'jinwan', '', '区', '440404', '0756', 3);
INSERT INTO `sys_district` VALUES ('2244', '龙湖', '325', 'l', 'lh', 'longhu', '', '区', '440507', '0754', 1);
INSERT INTO `sys_district` VALUES ('2245', '金平', '325', 'j', 'jp', 'jinping', '', '区', '440511', '0754', 2);
INSERT INTO `sys_district` VALUES ('2246', '濠江', '325', 'h', 'hj', 'haojiang', '', '区', '440512', '0754', 3);
INSERT INTO `sys_district` VALUES ('2247', '潮阳', '325', 'c', 'cy', 'chaoyang', '', '区', '440513', '0754', 4);
INSERT INTO `sys_district` VALUES ('2248', '潮南', '325', 'c', 'cn', 'chaonan', '', '区', '440514', '0754', 5);
INSERT INTO `sys_district` VALUES ('2249', '澄海', '325', 'c', 'ch', 'chenghai', '', '区', '440515', '0754', 6);
INSERT INTO `sys_district` VALUES ('225', '铜陵', '13', 't', 'tl', 'tongling', '', '市', '340700', '0562', 7);
INSERT INTO `sys_district` VALUES ('2250', '南澳', '325', 'n', 'na', 'nanao', '', '县', '440523', '0754', 7);
INSERT INTO `sys_district` VALUES ('2251', '禅城', '326', 's', 'sc', 'shancheng', '', '区', '440604', '0757', 1);
INSERT INTO `sys_district` VALUES ('2252', '南海', '326', 'n', 'nh', 'nanhai', '', '区', '440605', '0757', 2);
INSERT INTO `sys_district` VALUES ('2253', '顺德', '326', 's', 'sd', 'shunde', '', '区', '440606', '0757', 3);
INSERT INTO `sys_district` VALUES ('2254', '三水', '326', 's', 'ss', 'sanshui', '', '区', '440607', '0757', 4);
INSERT INTO `sys_district` VALUES ('2255', '高明', '326', 'g', 'gm', 'gaoming', '', '区', '440608', '0757', 5);
INSERT INTO `sys_district` VALUES ('2256', '蓬江', '327', 'p', 'pj', 'pengjiang', '', '区', '440703', '0750', 1);
INSERT INTO `sys_district` VALUES ('2257', '江海', '327', 'j', 'jh', 'jianghai', '', '区', '440704', '0750', 2);
INSERT INTO `sys_district` VALUES ('2258', '新会', '327', 'x', 'xh', 'xinhui', '', '区', '440705', '0750', 3);
INSERT INTO `sys_district` VALUES ('2259', '台山', '327', 't', 'ts', 'taishan', '', '市', '440781', '0750', 4);
INSERT INTO `sys_district` VALUES ('226', '安庆', '13', 'a', 'aq', 'anqing', '', '市', '340800', '0556', 8);
INSERT INTO `sys_district` VALUES ('2260', '开平', '327', 'k', 'kp', 'kaiping', '', '市', '440783', '0750', 5);
INSERT INTO `sys_district` VALUES ('2261', '鹤山', '327', 'h', 'hs', 'heshan', '', '市', '440784', '0750', 6);
INSERT INTO `sys_district` VALUES ('2262', '恩平', '327', 'e', 'ep', 'enping', '', '市', '440785', '0750', 7);
INSERT INTO `sys_district` VALUES ('2263', '赤坎', '328', 'c', 'ck', 'chikan', '', '区', '440802', '0759', 1);
INSERT INTO `sys_district` VALUES ('2264', '霞山', '328', 'x', 'xs', 'xiashan', '', '区', '440803', '0759', 2);
INSERT INTO `sys_district` VALUES ('2265', '坡头', '328', 'p', 'pt', 'potou', '', '区', '440804', '0759', 3);
INSERT INTO `sys_district` VALUES ('2266', '麻章', '328', 'm', 'mz', 'mazhang', '', '区', '440811', '0759', 4);
INSERT INTO `sys_district` VALUES ('2267', '遂溪', '328', 's', 'sx', 'suixi', '', '县', '440823', '0759', 5);
INSERT INTO `sys_district` VALUES ('2268', '徐闻', '328', 'x', 'xw', 'xuwen', '', '县', '440825', '0759', 6);
INSERT INTO `sys_district` VALUES ('2269', '廉江', '328', 'l', 'lj', 'lianjiang', '', '市', '440881', '0759', 7);
INSERT INTO `sys_district` VALUES ('227', '黄山', '13', 'h', 'hs', 'huangshan', '', '市', '341000', '0559', 9);
INSERT INTO `sys_district` VALUES ('2270', '雷州', '328', 'l', 'lz', 'leizhou', '', '市', '440882', '0759', 8);
INSERT INTO `sys_district` VALUES ('2271', '吴川', '328', 'w', 'wc', 'wuchuan', '', '市', '440883', '0759', 9);
INSERT INTO `sys_district` VALUES ('2272', '茂南', '329', 'm', 'mn', 'maonan', '', '区', '440902', '0668', 1);
INSERT INTO `sys_district` VALUES ('2274', '电白', '329', 'd', 'db', 'dianbai', '', '区', '440904', '0668', 2);
INSERT INTO `sys_district` VALUES ('2275', '高州', '329', 'g', 'gz', 'gaozhou', '', '市', '440981', '0668', 3);
INSERT INTO `sys_district` VALUES ('2276', '化州', '329', 'h', 'hz', 'huazhou', '', '市', '440982', '0668', 4);
INSERT INTO `sys_district` VALUES ('2277', '信宜', '329', 'x', 'xy', 'xinyi', '', '市', '440983', '0668', 5);
INSERT INTO `sys_district` VALUES ('2278', '端州', '330', 'd', 'dz', 'duanzhou', '', '区', '441202', '0758', 1);
INSERT INTO `sys_district` VALUES ('2279', '鼎湖', '330', 'd', 'dh', 'dinghu', '', '区', '441203', '0758', 2);
INSERT INTO `sys_district` VALUES ('228', '滁州', '13', 'c', 'cz', 'chuzhou', '', '市', '341100', '0550', 10);
INSERT INTO `sys_district` VALUES ('2280', '广宁', '330', 'g', 'gn', 'guangning', '', '县', '441223', '0758', 3);
INSERT INTO `sys_district` VALUES ('2281', '怀集', '330', 'h', 'hj', 'huaiji', '', '县', '441224', '0758', 4);
INSERT INTO `sys_district` VALUES ('2282', '封开', '330', 'f', 'fk', 'fengkai', '', '县', '441225', '0758', 5);
INSERT INTO `sys_district` VALUES ('2283', '德庆', '330', 'd', 'dq', 'deqing', '', '县', '441226', '0758', 6);
INSERT INTO `sys_district` VALUES ('2284', '高要', '330', 'g', 'gy', 'gaoyao', '', '区', '441283', '0758', 7);
INSERT INTO `sys_district` VALUES ('2285', '四会', '330', 's', 'sh', 'sihui', '', '市', '441284', '0758', 8);
INSERT INTO `sys_district` VALUES ('2286', '惠城', '331', 'h', 'hc', 'huicheng', '', '区', '441302', '0752', 1);
INSERT INTO `sys_district` VALUES ('2287', '惠阳', '331', 'h', 'hy', 'huiyang', '', '区', '441303', '0752', 2);
INSERT INTO `sys_district` VALUES ('2288', '博罗', '331', 'b', 'bl', 'boluo', '', '县', '441322', '0752', 3);
INSERT INTO `sys_district` VALUES ('2289', '惠东', '331', 'h', 'hd', 'huidong', '', '县', '441323', '0752', 4);
INSERT INTO `sys_district` VALUES ('229', '阜阳', '13', 'f', 'fy', 'fuyang', '', '市', '341200', '0558', 11);
INSERT INTO `sys_district` VALUES ('2290', '龙门', '331', 'l', 'lm', 'longmen', '', '县', '441324', '0752', 5);
INSERT INTO `sys_district` VALUES ('2291', '梅江', '332', 'm', 'mj', 'meijiang', '', '区', '441402', '0753', 1);
INSERT INTO `sys_district` VALUES ('2292', '梅县', '332', 'm', 'mx', 'meixian', '', '区', '441403', '0753', 2);
INSERT INTO `sys_district` VALUES ('2293', '大埔', '332', 'd', 'dp', 'dapu', '', '县', '441422', '0753', 3);
INSERT INTO `sys_district` VALUES ('2294', '丰顺', '332', 'f', 'fs', 'fengshun', '', '县', '441423', '0753', 4);
INSERT INTO `sys_district` VALUES ('2295', '五华', '332', 'w', 'wh', 'wuhua', '', '县', '441424', '0753', 5);
INSERT INTO `sys_district` VALUES ('2296', '平远', '332', 'p', 'py', 'pingyuan', '', '县', '441426', '0753', 6);
INSERT INTO `sys_district` VALUES ('2297', '蕉岭', '332', 'j', 'jl', 'jiaoling', '', '县', '441427', '0753', 7);
INSERT INTO `sys_district` VALUES ('2298', '兴宁', '332', 'x', 'xn', 'xingning', '', '市', '441481', '0753', 8);
INSERT INTO `sys_district` VALUES ('2299', '城区', '333', 'c', 'cq', 'chengqu', '', '区', '441502', '0660', 1);
INSERT INTO `sys_district` VALUES ('23', '四川', '0', 's', 'sc', 'sichuan', '', '省', '510000', '', 24);
INSERT INTO `sys_district` VALUES ('230', '宿州', '13', 's', 'sz', 'suzhou', '', '市', '341300', '0557', 12);
INSERT INTO `sys_district` VALUES ('2300', '海丰', '333', 'h', 'hf', 'haifeng', '', '县', '441521', '0660', 2);
INSERT INTO `sys_district` VALUES ('2301', '陆河', '333', 'l', 'lh', 'luhe', '', '县', '441523', '0660', 3);
INSERT INTO `sys_district` VALUES ('2302', '陆丰', '333', 'l', 'lf', 'lufeng', '', '市', '441581', '0660', 4);
INSERT INTO `sys_district` VALUES ('2303', '源城', '334', 'y', 'yc', 'yuancheng', '', '区', '441602', '0762', 1);
INSERT INTO `sys_district` VALUES ('2304', '紫金', '334', 'z', 'zj', 'zijin', '', '县', '441621', '0762', 2);
INSERT INTO `sys_district` VALUES ('2305', '龙川', '334', 'l', 'lc', 'longchuan', '', '县', '441622', '0762', 3);
INSERT INTO `sys_district` VALUES ('2306', '连平', '334', 'l', 'lp', 'lianping', '', '县', '441623', '0762', 4);
INSERT INTO `sys_district` VALUES ('2307', '和平', '334', 'h', 'hp', 'heping', '', '县', '441624', '0762', 5);
INSERT INTO `sys_district` VALUES ('2308', '东源', '334', 'd', 'dy', 'dongyuan', '', '县', '441625', '0762', 6);
INSERT INTO `sys_district` VALUES ('2309', '江城', '335', 'j', 'jc', 'jiangcheng', '', '区', '441702', '0662', 1);
INSERT INTO `sys_district` VALUES ('231', '六安', '13', 'l', 'la', 'liuan', '', '市', '341500', '0564', 13);
INSERT INTO `sys_district` VALUES ('2310', '阳西', '335', 'y', 'yx', 'yangxi', '', '县', '441721', '0662', 2);
INSERT INTO `sys_district` VALUES ('2311', '阳东', '335', 'y', 'yd', 'yangdong', '', '区', '441723', '0662', 3);
INSERT INTO `sys_district` VALUES ('2312', '阳春', '335', 'y', 'yc', 'yangchun', '', '市', '441781', '0662', 4);
INSERT INTO `sys_district` VALUES ('2313', '清城', '336', 'q', 'qc', 'qingcheng', '', '区', '441802', '0763', 1);
INSERT INTO `sys_district` VALUES ('2314', '佛冈', '336', 'f', 'fg', 'fogang', '', '县', '441821', '0763', 2);
INSERT INTO `sys_district` VALUES ('2315', '阳山', '336', 'y', 'ys', 'yangshan', '', '县', '441823', '0763', 3);
INSERT INTO `sys_district` VALUES ('2316', '连山', '336', 'l', 'ls', 'lianshan', '壮族瑶族', '自治县', '441825', '0763', 4);
INSERT INTO `sys_district` VALUES ('2317', '连南', '336', 'l', 'ln', 'liannan', '瑶族', '自治县', '441826', '0763', 5);
INSERT INTO `sys_district` VALUES ('2318', '清新', '336', 'q', 'qx', 'qingxin', '', '县', '441827', '0763', 6);
INSERT INTO `sys_district` VALUES ('2319', '英德', '336', 'y', 'yd', 'yingde', '', '市', '441881', '0763', 7);
INSERT INTO `sys_district` VALUES ('232', '亳州', '13', 'b', 'bz', 'bozhou', '', '市', '341600', '0558', 14);
INSERT INTO `sys_district` VALUES ('2320', '连州', '336', 'l', 'lz', 'lianzhou', '', '市', '441882', '0763', 8);
INSERT INTO `sys_district` VALUES ('2321', '湘桥', '339', 'x', 'xq', 'xiangqiao', '', '区', '445102', '0768', 1);
INSERT INTO `sys_district` VALUES ('2322', '潮安', '339', 'c', 'ca', 'chaoan', '', '区', '445121', '0768', 2);
INSERT INTO `sys_district` VALUES ('2323', '饶平', '339', 'r', 'rp', 'raoping', '', '县', '445122', '0768', 3);
INSERT INTO `sys_district` VALUES ('2324', '榕城', '340', 'r', 'rc', 'rongcheng', '', '区', '445202', '0663', 1);
INSERT INTO `sys_district` VALUES ('2325', '揭东', '340', 'j', 'jd', 'jiedong', '', '县', '445221', '0663', 2);
INSERT INTO `sys_district` VALUES ('2326', '揭西', '340', 'j', 'jx', 'jiexi', '', '县', '445222', '0663', 3);
INSERT INTO `sys_district` VALUES ('2327', '惠来', '340', 'h', 'hl', 'huilai', '', '县', '445224', '0663', 4);
INSERT INTO `sys_district` VALUES ('2328', '普宁', '340', 'p', 'pn', 'puning', '', '市', '445281', '0663', 5);
INSERT INTO `sys_district` VALUES ('2329', '云城', '341', 'y', 'yc', 'yuncheng', '', '区', '445302', '0766', 1);
INSERT INTO `sys_district` VALUES ('233', '池州', '13', 'c', 'cz', 'chizhou', '', '市', '341700', '0566', 15);
INSERT INTO `sys_district` VALUES ('2330', '新兴', '341', 'x', 'xx', 'xinxing', '', '县', '445321', '0766', 3);
INSERT INTO `sys_district` VALUES ('2331', '郁南', '341', 'y', 'yn', 'yunan', '', '县', '445322', '0766', 4);
INSERT INTO `sys_district` VALUES ('2332', '云安', '341', 'y', 'ya', 'yunan', '', '区', '445302', '0766', 2);
INSERT INTO `sys_district` VALUES ('2333', '罗定', '341', 'l', 'ld', 'luoding', '', '市', '445381', '0766', 5);
INSERT INTO `sys_district` VALUES ('2334', '兴宁', '342', 'x', 'xn', 'xingning', '', '区', '450102', '0771', 1);
INSERT INTO `sys_district` VALUES ('2335', '青秀', '342', 'q', 'qx', 'qingxiu', '', '区', '450103', '0771', 2);
INSERT INTO `sys_district` VALUES ('2336', '江南', '342', 'j', 'jn', 'jiangnan', '', '区', '450105', '0771', 3);
INSERT INTO `sys_district` VALUES ('2337', '西乡塘', '342', 'x', 'xxt', 'xixiangtang', '', '区', '450107', '0771', 4);
INSERT INTO `sys_district` VALUES ('2338', '良庆', '342', 'l', 'lq', 'liangqing', '', '区', '450108', '0771', 5);
INSERT INTO `sys_district` VALUES ('2339', '邕宁', '342', 'y', 'yn', 'yongning', '', '区', '450109', '0771', 6);
INSERT INTO `sys_district` VALUES ('234', '宣城', '13', 'x', 'xc', 'xuancheng', '', '市', '341800', '0563', 16);
INSERT INTO `sys_district` VALUES ('2340', '武鸣', '342', 'w', 'wm', 'wuming', '', '区', '450122', '0771', 7);
INSERT INTO `sys_district` VALUES ('2341', '隆安', '342', 'l', 'la', 'longan', '', '县', '450123', '0771', 8);
INSERT INTO `sys_district` VALUES ('2342', '马山', '342', 'm', 'ms', 'mashan', '', '县', '450124', '0771', 9);
INSERT INTO `sys_district` VALUES ('2343', '上林', '342', 's', 'sl', 'shanglin', '', '县', '450125', '0771', 10);
INSERT INTO `sys_district` VALUES ('2344', '宾阳', '342', 'b', 'by', 'binyang', '', '县', '450126', '0771', 11);
INSERT INTO `sys_district` VALUES ('2345', '横县', '342', 'h', 'hx', 'hengxian', '', '', '450127', '0771', 12);
INSERT INTO `sys_district` VALUES ('2346', '城中', '343', 'c', 'cz', 'chengzhong', '', '区', '450202', '0772', 1);
INSERT INTO `sys_district` VALUES ('2347', '鱼峰', '343', 'y', 'yf', 'yufeng', '', '区', '450203', '0772', 2);
INSERT INTO `sys_district` VALUES ('2348', '柳南', '343', 'l', 'ln', 'liunan', '', '区', '450204', '0772', 3);
INSERT INTO `sys_district` VALUES ('2349', '柳北', '343', 'l', 'lb', 'liubei', '', '区', '450205', '0772', 4);
INSERT INTO `sys_district` VALUES ('235', '福州', '14', 'f', 'fz', 'fuzhou', '', '市', '350100', '0591', 1);
INSERT INTO `sys_district` VALUES ('2350', '柳江', '343', 'l', 'lj', 'liujiang', '', '区', '450221', '0772', 5);
INSERT INTO `sys_district` VALUES ('2351', '柳城', '343', 'l', 'lc', 'liucheng', '', '县', '450222', '0772', 6);
INSERT INTO `sys_district` VALUES ('2352', '鹿寨', '343', 'l', 'lz', 'luzhai', '', '县', '450223', '0772', 7);
INSERT INTO `sys_district` VALUES ('2353', '融安', '343', 'r', 'ra', 'rongan', '', '县', '450224', '0772', 8);
INSERT INTO `sys_district` VALUES ('2354', '融水', '343', 'r', 'rs', 'rongshui', '苗族', '自治县', '450225', '0772', 9);
INSERT INTO `sys_district` VALUES ('2355', '三江', '343', 's', 'sj', 'sanjiang', '侗族', '自治县', '450226', '0772', 10);
INSERT INTO `sys_district` VALUES ('2356', '秀峰', '344', 'x', 'xf', 'xiufeng', '', '区', '450302', '0773', 1);
INSERT INTO `sys_district` VALUES ('2357', '叠彩', '344', 'd', 'dc', 'diecai', '', '区', '450303', '0773', 2);
INSERT INTO `sys_district` VALUES ('2358', '象山', '344', 'x', 'xs', 'xiangshan', '', '区', '450304', '0773', 3);
INSERT INTO `sys_district` VALUES ('2359', '七星', '344', 'q', 'qx', 'qixing', '', '区', '450305', '0773', 4);
INSERT INTO `sys_district` VALUES ('236', '厦门', '14', 'x', 'xm', 'xiamen', '', '市', '350200', '0592', 2);
INSERT INTO `sys_district` VALUES ('2360', '雁山', '344', 'y', 'ys', 'yanshan', '', '区', '450311', '0773', 5);
INSERT INTO `sys_district` VALUES ('2361', '阳朔', '344', 'y', 'ys', 'yangshuo', '', '县', '450321', '0773', 6);
INSERT INTO `sys_district` VALUES ('2362', '临桂', '344', 'l', 'lg', 'lingui', '', '区', '450322', '0773', 7);
INSERT INTO `sys_district` VALUES ('2363', '灵川', '344', 'l', 'lc', 'lingchuan', '', '县', '450323', '0773', 8);
INSERT INTO `sys_district` VALUES ('2364', '全州', '344', 'q', 'qz', 'quanzhou', '', '县', '450324', '0773', 9);
INSERT INTO `sys_district` VALUES ('2365', '兴安', '344', 'x', 'xa', 'xingan', '', '县', '450325', '0773', 10);
INSERT INTO `sys_district` VALUES ('2366', '永福', '344', 'y', 'yf', 'yongfu', '', '县', '450326', '0773', 11);
INSERT INTO `sys_district` VALUES ('2367', '灌阳', '344', 'g', 'gy', 'guanyang', '', '县', '450327', '0773', 12);
INSERT INTO `sys_district` VALUES ('2368', '龙胜', '344', 'l', 'ls', 'longsheng', '各族', '自治县', '450328', '0773', 13);
INSERT INTO `sys_district` VALUES ('2369', '资源', '344', 'z', 'zy', 'ziyuan', '', '县', '450329', '0773', 14);
INSERT INTO `sys_district` VALUES ('237', '莆田', '14', 'p', 'pt', 'putian', '', '市', '350300', '0594', 3);
INSERT INTO `sys_district` VALUES ('2370', '平乐', '344', 'p', 'pl', 'pingle', '', '县', '450330', '0773', 15);
INSERT INTO `sys_district` VALUES ('2371', '荔浦', '344', 'l', 'lp', 'lipu', '', '县', '450331', '0773', 16);
INSERT INTO `sys_district` VALUES ('2372', '恭城', '344', 'g', 'gc', 'gongcheng', '瑶族', '自治县', '450332', '0773', 17);
INSERT INTO `sys_district` VALUES ('2373', '龙圩', '345', 'l', 'lw', 'longwei', '', '区', '', '0774', 1);
INSERT INTO `sys_district` VALUES ('2374', '万秀', '345', 'w', 'wx', 'wanxiu', '', '区', '450403', '0774', 2);
INSERT INTO `sys_district` VALUES ('2375', '长洲', '345', 'z', 'zz', 'zhangzhou', '', '区', '450405', '0774', 3);
INSERT INTO `sys_district` VALUES ('2376', '苍梧', '345', 'c', 'cw', 'cangwu', '', '县', '450421', '0774', 4);
INSERT INTO `sys_district` VALUES ('2377', '藤县', '345', 't', 'tx', 'tengxian', '', '', '450422', '0774', 5);
INSERT INTO `sys_district` VALUES ('2378', '蒙山', '345', 'm', 'ms', 'mengshan', '', '县', '450423', '0774', 6);
INSERT INTO `sys_district` VALUES ('2379', '岑溪', '345', 'c', 'cx', 'cenxi', '', '市', '450481', '0774', 7);
INSERT INTO `sys_district` VALUES ('238', '三明', '14', 's', 'sm', 'sanming', '', '市', '350400', '0598', 4);
INSERT INTO `sys_district` VALUES ('2380', '海城', '346', 'h', 'hc', 'haicheng', '', '区', '450502', '0779', 1);
INSERT INTO `sys_district` VALUES ('2381', '银海', '346', 'y', 'yh', 'yinhai', '', '区', '450503', '0779', 2);
INSERT INTO `sys_district` VALUES ('2382', '铁山港', '346', 't', 'tsg', 'tieshangang', '', '区', '450512', '0779', 3);
INSERT INTO `sys_district` VALUES ('2383', '合浦', '346', 'h', 'hp', 'hepu', '', '县', '450521', '0779', 4);
INSERT INTO `sys_district` VALUES ('2384', '港口', '347', 'g', 'gk', 'gangkou', '', '区', '450602', '0770', 1);
INSERT INTO `sys_district` VALUES ('2385', '防城', '347', 'f', 'fc', 'fangcheng', '', '区', '450603', '0770', 2);
INSERT INTO `sys_district` VALUES ('2386', '上思', '347', 's', 'ss', 'shangsi', '', '县', '450621', '0770', 3);
INSERT INTO `sys_district` VALUES ('2387', '东兴', '347', 'd', 'dx', 'dongxing', '', '市', '450681', '0770', 4);
INSERT INTO `sys_district` VALUES ('2388', '钦南', '348', 'q', 'qn', 'qinnan', '', '区', '450702', '0777', 1);
INSERT INTO `sys_district` VALUES ('2389', '钦北', '348', 'q', 'qb', 'qinbei', '', '区', '450703', '0777', 2);
INSERT INTO `sys_district` VALUES ('239', '泉州', '14', 'q', 'qz', 'quanzhou', '', '市', '350500', '0595', 5);
INSERT INTO `sys_district` VALUES ('2390', '灵山', '348', 'l', 'ls', 'lingshan', '', '县', '450721', '0777', 3);
INSERT INTO `sys_district` VALUES ('2391', '浦北', '348', 'p', 'pb', 'pubei', '', '县', '450722', '0777', 4);
INSERT INTO `sys_district` VALUES ('2392', '港北', '349', 'g', 'gb', 'gangbei', '', '区', '450802', '0775', 1);
INSERT INTO `sys_district` VALUES ('2393', '港南', '349', 'g', 'gn', 'gangnan', '', '区', '450803', '0775', 2);
INSERT INTO `sys_district` VALUES ('2394', '覃塘', '349', 't', 'tt', 'tantang', '', '区', '450804', '0775', 3);
INSERT INTO `sys_district` VALUES ('2395', '桂平', '349', 'g', 'gp', 'guiping', '', '市', '450821', '0775', 4);
INSERT INTO `sys_district` VALUES ('2396', '平南', '349', 'p', 'pn', 'pingnan', '', '县', '450881', '0775', 5);
INSERT INTO `sys_district` VALUES ('2397', '玉州', '350', 'y', 'yz', 'yuzhou', '', '区', '450902', '0775', 1);
INSERT INTO `sys_district` VALUES ('2398', '容县', '350', 'r', 'rx', 'rongxian', '', '', '450921', '0775', 3);
INSERT INTO `sys_district` VALUES ('2399', '陆川', '350', 'l', 'lc', 'luchuan', '', '县', '450922', '0775', 4);
INSERT INTO `sys_district` VALUES ('24', '贵州', '0', 'g', 'gz', 'guizhou', '', '省', '520000', '', 25);
INSERT INTO `sys_district` VALUES ('240', '漳州', '14', 'z', 'zz', 'zhangzhou', '', '市', '350600', '0596', 6);
INSERT INTO `sys_district` VALUES ('2400', '博白', '350', 'b', 'bb', 'bobai', '', '县', '450923', '0775', 5);
INSERT INTO `sys_district` VALUES ('2401', '兴业', '350', 'x', 'xy', 'xingye', '', '县', '450924', '0775', 6);
INSERT INTO `sys_district` VALUES ('2402', '北流', '350', 'b', 'bl', 'beiliu', '', '市', '450981', '0775', 7);
INSERT INTO `sys_district` VALUES ('2403', '右江', '351', 'y', 'yj', 'youjiang', '', '区', '451002', '0776', 1);
INSERT INTO `sys_district` VALUES ('2404', '田阳', '351', 't', 'ty', 'tianyang', '', '县', '451021', '0776', 2);
INSERT INTO `sys_district` VALUES ('2405', '田东', '351', 't', 'td', 'tiandong', '', '县', '451022', '0776', 3);
INSERT INTO `sys_district` VALUES ('2406', '平果', '351', 'p', 'pg', 'pingguo', '', '县', '451023', '0776', 4);
INSERT INTO `sys_district` VALUES ('2407', '德保', '351', 'd', 'db', 'debao', '', '县', '451024', '0776', 5);
INSERT INTO `sys_district` VALUES ('2408', '靖西', '351', 'j', 'jx', 'jingxi', '', '市', '451025', '0776', 6);
INSERT INTO `sys_district` VALUES ('2409', '那坡', '351', 'n', 'np', 'neipo', '', '县', '451026', '0776', 7);
INSERT INTO `sys_district` VALUES ('241', '南平', '14', 'n', 'np', 'nanping', '', '市', '350700', '0599', 7);
INSERT INTO `sys_district` VALUES ('2410', '凌云', '351', 'l', 'ly', 'lingyun', '', '县', '451027', '0776', 8);
INSERT INTO `sys_district` VALUES ('2411', '乐业', '351', 'l', 'ly', 'leye', '', '县', '451028', '0776', 9);
INSERT INTO `sys_district` VALUES ('2412', '田林', '351', 't', 'tl', 'tianlin', '', '县', '451029', '0776', 10);
INSERT INTO `sys_district` VALUES ('2413', '西林', '351', 'x', 'xl', 'xilin', '', '县', '451030', '0776', 11);
INSERT INTO `sys_district` VALUES ('2414', '隆林', '351', 'l', 'll', 'longlin', '各族', '自治县', '451031', '0776', 12);
INSERT INTO `sys_district` VALUES ('2415', '八步', '352', 'b', 'bb', 'babu', '', '区', '451102', '0774', 1);
INSERT INTO `sys_district` VALUES ('2416', '昭平', '352', 'z', 'zp', 'zhaoping', '', '县', '451121', '0774', 3);
INSERT INTO `sys_district` VALUES ('2417', '钟山', '352', 'z', 'zs', 'zhongshan', '', '县', '451122', '0774', 4);
INSERT INTO `sys_district` VALUES ('2418', '富川', '352', 'f', 'fc', 'fuchuan', '瑶族', '自治县', '451123', '0774', 5);
INSERT INTO `sys_district` VALUES ('2419', '金城江', '353', 'j', 'jcj', 'jinchengjiang', '', '区', '451202', '0778', 1);
INSERT INTO `sys_district` VALUES ('242', '龙岩', '14', 'l', 'ly', 'longyan', '', '市', '350800', '0597', 8);
INSERT INTO `sys_district` VALUES ('2420', '南丹', '353', 'n', 'nd', 'nandan', '', '县', '451221', '0778', 3);
INSERT INTO `sys_district` VALUES ('2421', '天峨', '353', 't', 'te', 'tiane', '', '县', '451222', '0778', 4);
INSERT INTO `sys_district` VALUES ('2422', '凤山', '353', 'f', 'fs', 'fengshan', '', '县', '451223', '0778', 5);
INSERT INTO `sys_district` VALUES ('2423', '东兰', '353', 'd', 'dl', 'donglan', '', '县', '451224', '0778', 6);
INSERT INTO `sys_district` VALUES ('2424', '罗城', '353', 'l', 'lc', 'luocheng', '仫佬族', '自治县', '451225', '0778', 7);
INSERT INTO `sys_district` VALUES ('2425', '环江', '353', 'h', 'hj', 'huanjiang', '毛南族', '自治县', '451226', '0778', 8);
INSERT INTO `sys_district` VALUES ('2426', '巴马', '353', 'b', 'bm', 'bama', '瑶族', '自治县', '451227', '0778', 9);
INSERT INTO `sys_district` VALUES ('2427', '都安', '353', 'd', 'da', 'duan', '瑶族', '自治县', '451228', '0778', 10);
INSERT INTO `sys_district` VALUES ('2428', '大化', '353', 'd', 'dh', 'dahua', '瑶族', '自治县', '451229', '0778', 11);
INSERT INTO `sys_district` VALUES ('2429', '宜州', '353', 'y', 'yz', 'yizhou', '', '区', '451281', '0778', 2);
INSERT INTO `sys_district` VALUES ('243', '宁德', '14', 'n', 'nd', 'ningde', '', '市', '350900', '0593', 9);
INSERT INTO `sys_district` VALUES ('2430', '兴宾', '354', 'x', 'xb', 'xingbin', '', '区', '451302', '0772', 1);
INSERT INTO `sys_district` VALUES ('2431', '忻城', '354', 'x', 'xc', 'xincheng', '', '县', '451321', '0772', 2);
INSERT INTO `sys_district` VALUES ('2432', '象州', '354', 'x', 'xz', 'xiangzhou', '', '县', '451322', '0772', 3);
INSERT INTO `sys_district` VALUES ('2433', '武宣', '354', 'w', 'wx', 'wuxuan', '', '县', '451323', '0772', 4);
INSERT INTO `sys_district` VALUES ('2434', '金秀', '354', 'j', 'jx', 'jinxiu', '瑶族', '自治县', '451324', '0772', 5);
INSERT INTO `sys_district` VALUES ('2435', '合山', '354', 'h', 'hs', 'heshan', '', '市', '451381', '0772', 6);
INSERT INTO `sys_district` VALUES ('2436', '江州', '355', 'j', 'jz', 'jiangzhou', '', '区', '451402', '0771', 1);
INSERT INTO `sys_district` VALUES ('2437', '扶绥', '355', 'f', 'fs', 'fusui', '', '县', '451421', '0771', 2);
INSERT INTO `sys_district` VALUES ('2438', '宁明', '355', 'n', 'nm', 'ningming', '', '县', '451422', '0771', 3);
INSERT INTO `sys_district` VALUES ('2439', '龙州', '355', 'l', 'lz', 'longzhou', '', '县', '451423', '0771', 4);
INSERT INTO `sys_district` VALUES ('244', '南昌', '15', 'n', 'nc', 'nanchang', '', '市', '360100', '0791', 1);
INSERT INTO `sys_district` VALUES ('2440', '大新', '355', 'd', 'dx', 'daxin', '', '县', '451424', '0771', 5);
INSERT INTO `sys_district` VALUES ('2441', '天等', '355', 't', 'td', 'tiandeng', '', '县', '451425', '0771', 6);
INSERT INTO `sys_district` VALUES ('2442', '凭祥', '355', 'p', 'px', 'pingxiang', '', '市', '451481', '0771', 7);
INSERT INTO `sys_district` VALUES ('2443', '秀英', '356', 'x', 'xy', 'xiuying', '', '区', '460105', '0898', 1);
INSERT INTO `sys_district` VALUES ('2444', '龙华', '356', 'l', 'lh', 'longhua', '', '区', '460106', '0898', 2);
INSERT INTO `sys_district` VALUES ('2445', '琼山', '356', 'q', 'qs', 'qiongshan', '', '区', '460107', '0898', 3);
INSERT INTO `sys_district` VALUES ('2446', '美兰', '356', 'm', 'ml', 'meilan', '', '区', '460108', '0898', 4);
INSERT INTO `sys_district` VALUES ('2447', '锦江', '375', 'j', 'jj', 'jinjiang', '', '区', '510104', '028', 1);
INSERT INTO `sys_district` VALUES ('2448', '青羊', '375', 'q', 'qy', 'qingyang', '', '区', '510105', '028', 2);
INSERT INTO `sys_district` VALUES ('2449', '金牛', '375', 'j', 'jn', 'jinniu', '', '区', '510106', '028', 3);
INSERT INTO `sys_district` VALUES ('245', '景德镇', '15', 'j', 'jdz', 'jingdezhen', '', '市', '360200', '0798', 2);
INSERT INTO `sys_district` VALUES ('2450', '武侯', '375', 'w', 'wh', 'wuhou', '', '区', '510107', '028', 4);
INSERT INTO `sys_district` VALUES ('2451', '成华', '375', 'c', 'ch', 'chenghua', '', '区', '510108', '028', 5);
INSERT INTO `sys_district` VALUES ('2452', '龙泉驿', '375', 'l', 'lqy', 'longquanyi', '', '区', '510112', '028', 6);
INSERT INTO `sys_district` VALUES ('2453', '青白江', '375', 'q', 'qbj', 'qingbaijiang', '', '区', '510113', '028', 7);
INSERT INTO `sys_district` VALUES ('2454', '新都', '375', 'x', 'xd', 'xindu', '', '区', '510114', '028', 8);
INSERT INTO `sys_district` VALUES ('2455', '温江', '375', 'w', 'wj', 'wenjiang', '', '区', '510115', '028', 9);
INSERT INTO `sys_district` VALUES ('2456', '金堂', '375', 'j', 'jt', 'jintang', '', '县', '510121', '028', 10);
INSERT INTO `sys_district` VALUES ('2457', '双流', '375', 's', 'sl', 'shuangliu', '', '区', '510122', '028', 11);
INSERT INTO `sys_district` VALUES ('2458', '郫都', '375', 'p', 'pd', 'pidu', '', '区', '510124', '028', 12);
INSERT INTO `sys_district` VALUES ('2459', '大邑', '375', 'd', 'dy', 'dayi', '', '县', '510129', '028', 13);
INSERT INTO `sys_district` VALUES ('246', '萍乡', '15', 'p', 'px', 'pingxiang', '', '市', '360300', '0799', 3);
INSERT INTO `sys_district` VALUES ('2460', '蒲江', '375', 'p', 'pj', 'pujiang', '', '县', '510131', '028', 14);
INSERT INTO `sys_district` VALUES ('2461', '新津', '375', 'x', 'xj', 'xinjin', '', '县', '510132', '028', 15);
INSERT INTO `sys_district` VALUES ('2462', '都江堰', '375', 'd', 'djy', 'dujiangyan', '', '市', '510181', '028', 16);
INSERT INTO `sys_district` VALUES ('2463', '彭州', '375', 'p', 'pz', 'pengzhou', '', '市', '510182', '028', 17);
INSERT INTO `sys_district` VALUES ('2464', '邛崃', '375', 'q', 'ql', 'qionglai', '', '市', '510183', '028', 18);
INSERT INTO `sys_district` VALUES ('2465', '崇州', '375', 'c', 'cz', 'chongzhou', '', '市', '510184', '028', 19);
INSERT INTO `sys_district` VALUES ('2466', '自流井', '376', 'z', 'zlj', 'ziliujing', '', '区', '510302', '0813', 1);
INSERT INTO `sys_district` VALUES ('2467', '贡井', '376', 'g', 'gj', 'gongjing', '', '区', '510303', '0813', 2);
INSERT INTO `sys_district` VALUES ('2468', '大安', '376', 'd', 'da', 'daan', '', '区', '510304', '0813', 3);
INSERT INTO `sys_district` VALUES ('2469', '沿滩', '376', 'y', 'yt', 'yantan', '', '区', '510311', '0813', 4);
INSERT INTO `sys_district` VALUES ('247', '九江', '15', 'j', 'jj', 'jiujiang', '', '市', '360400', '0792', 4);
INSERT INTO `sys_district` VALUES ('2470', '荣县', '376', 'r', 'rx', 'rongxian', '', '', '510321', '0813', 5);
INSERT INTO `sys_district` VALUES ('2471', '富顺', '376', 'f', 'fs', 'fushun', '', '县', '510322', '0813', 6);
INSERT INTO `sys_district` VALUES ('2472', '东区', '377', 'd', 'dq', 'dongqu', '', '', '510402', '0812', 1);
INSERT INTO `sys_district` VALUES ('2473', '西区', '377', 'x', 'xq', 'xiqu', '', '', '510403', '0812', 2);
INSERT INTO `sys_district` VALUES ('2474', '仁和', '377', 'r', 'rh', 'renhe', '', '区', '510411', '0812', 3);
INSERT INTO `sys_district` VALUES ('2475', '米易', '377', 'm', 'my', 'miyi', '', '县', '510421', '0812', 4);
INSERT INTO `sys_district` VALUES ('2476', '盐边', '377', 'y', 'yb', 'yanbian', '', '县', '510422', '0812', 5);
INSERT INTO `sys_district` VALUES ('2477', '江阳', '378', 'j', 'jy', 'jiangyang', '', '区', '510502', '0830', 1);
INSERT INTO `sys_district` VALUES ('2478', '纳溪', '378', 'n', 'nx', 'naxi', '', '区', '510503', '0830', 2);
INSERT INTO `sys_district` VALUES ('2479', '龙马潭', '378', 'l', 'lmt', 'longmatan', '', '区', '510504', '0830', 3);
INSERT INTO `sys_district` VALUES ('248', '新余', '15', 'x', 'xy', 'xinyu', '', '市', '360500', '0790', 5);
INSERT INTO `sys_district` VALUES ('2480', '泸县', '378', 'l', 'lx', 'luxian', '', '', '510521', '0830', 4);
INSERT INTO `sys_district` VALUES ('2481', '合江', '378', 'h', 'hj', 'hejiang', '', '县', '510522', '0830', 5);
INSERT INTO `sys_district` VALUES ('2482', '叙永', '378', 'x', 'xy', 'xuyong', '', '县', '510524', '0830', 6);
INSERT INTO `sys_district` VALUES ('2483', '古蔺', '378', 'g', 'gl', 'gulin', '', '县', '510525', '0830', 7);
INSERT INTO `sys_district` VALUES ('2484', '旌阳', '379', 'j', 'jy', 'jingyang', '', '区', '510603', '0838', 1);
INSERT INTO `sys_district` VALUES ('2485', '中江', '379', 'z', 'zj', 'zhongjiang', '', '县', '510623', '0838', 2);
INSERT INTO `sys_district` VALUES ('2486', '罗江', '379', 'l', 'lj', 'luojiang', '', '县', '510626', '0838', 3);
INSERT INTO `sys_district` VALUES ('2487', '广汉', '379', 'g', 'gh', 'guanghan', '', '市', '510681', '0838', 4);
INSERT INTO `sys_district` VALUES ('2488', '什邡', '379', 's', 'sf', 'shenfang', '', '市', '510682', '0838', 5);
INSERT INTO `sys_district` VALUES ('2489', '绵竹', '379', 'm', 'mz', 'mianzhu', '', '市', '510683', '0838', 6);
INSERT INTO `sys_district` VALUES ('249', '鹰潭', '15', 'y', 'yt', 'yingtan', '', '市', '360600', '0701', 6);
INSERT INTO `sys_district` VALUES ('2490', '涪城', '380', 'f', 'fc', 'fucheng', '', '区', '510703', '0816', 1);
INSERT INTO `sys_district` VALUES ('2491', '游仙', '380', 'y', 'yx', 'youxian', '', '区', '510704', '0816', 2);
INSERT INTO `sys_district` VALUES ('2492', '三台', '380', 's', 'st', 'santai', '', '县', '510722', '0816', 3);
INSERT INTO `sys_district` VALUES ('2493', '盐亭', '380', 'y', 'yt', 'yanting', '', '县', '510723', '0816', 4);
INSERT INTO `sys_district` VALUES ('2494', '安州', '380', 'a', 'az', 'anzhou', '', '区', '510724', '0816', 5);
INSERT INTO `sys_district` VALUES ('2495', '梓潼', '380', 'z', 'zt', 'zitong', '', '县', '510725', '0816', 6);
INSERT INTO `sys_district` VALUES ('2496', '北川', '380', 'b', 'bc', 'beichuan', '羌族', '自治县', '510726', '0816', 7);
INSERT INTO `sys_district` VALUES ('2497', '平武', '380', 'p', 'pw', 'pingwu', '', '县', '510727', '0816', 8);
INSERT INTO `sys_district` VALUES ('2498', '江油', '380', 'j', 'jy', 'jiangyou', '', '市', '510781', '0816', 9);
INSERT INTO `sys_district` VALUES ('2499', '利州', '381', 'l', 'lz', 'lizhou', '', '区', '510802', '0839', 1);
INSERT INTO `sys_district` VALUES ('25', '云南', '0', 'y', 'yn', 'yunnan', '', '省', '530000', '', 26);
INSERT INTO `sys_district` VALUES ('250', '赣州', '15', 'g', 'gz', 'ganzhou', '', '市', '360700', '0797', 7);
INSERT INTO `sys_district` VALUES ('2500', '昭化', '381', 'z', 'zh', 'zhaohua', '', '区', '510811', '0839', 2);
INSERT INTO `sys_district` VALUES ('2501', '朝天', '381', 'c', 'ct', 'chaotian', '', '区', '510812', '0839', 3);
INSERT INTO `sys_district` VALUES ('2502', '旺苍', '381', 'w', 'wc', 'wangcang', '', '县', '510821', '0839', 4);
INSERT INTO `sys_district` VALUES ('2503', '青川', '381', 'q', 'qc', 'qingchuan', '', '县', '510822', '0839', 5);
INSERT INTO `sys_district` VALUES ('2504', '剑阁', '381', 'j', 'jg', 'jiange', '', '县', '510823', '0839', 6);
INSERT INTO `sys_district` VALUES ('2505', '苍溪', '381', 'c', 'cx', 'cangxi', '', '县', '510824', '0839', 7);
INSERT INTO `sys_district` VALUES ('2506', '船山', '382', 'c', 'cs', 'chuanshan', '', '区', '510903', '0825', 1);
INSERT INTO `sys_district` VALUES ('2507', '安居', '382', 'a', 'aj', 'anju', '', '区', '510904', '0825', 2);
INSERT INTO `sys_district` VALUES ('2508', '蓬溪', '382', 'p', 'px', 'pengxi', '', '县', '510921', '0825', 3);
INSERT INTO `sys_district` VALUES ('2509', '射洪', '382', 's', 'sh', 'shehong', '', '县', '510922', '0825', 4);
INSERT INTO `sys_district` VALUES ('251', '吉安', '15', 'j', 'ja', 'jian', '', '市', '360800', '0796', 8);
INSERT INTO `sys_district` VALUES ('2510', '大英', '382', 'd', 'dy', 'daying', '', '县', '510923', '0825', 5);
INSERT INTO `sys_district` VALUES ('2511', '市中', '383', 's', 'sz', 'shizhong', '', '区', '511002', '', 1);
INSERT INTO `sys_district` VALUES ('2512', '东兴', '383', 'd', 'dx', 'dongxing', '', '区', '511011', '', 2);
INSERT INTO `sys_district` VALUES ('2513', '威远', '383', 'w', 'wy', 'weiyuan', '', '县', '511024', '', 3);
INSERT INTO `sys_district` VALUES ('2514', '资中', '383', 'z', 'zz', 'zizhong', '', '县', '511025', '', 4);
INSERT INTO `sys_district` VALUES ('2515', '隆昌', '383', 'l', 'lc', 'longchang', '', '县', '511028', '', 5);
INSERT INTO `sys_district` VALUES ('2516', '市中', '384', 's', 'sz', 'shizhong', '', '区', '511102', '0833', 1);
INSERT INTO `sys_district` VALUES ('2517', '沙湾', '384', 's', 'sw', 'shawan', '', '区', '511111', '0833', 2);
INSERT INTO `sys_district` VALUES ('2518', '五通桥', '384', 'w', 'wtq', 'wutongqiao', '', '区', '511112', '0833', 3);
INSERT INTO `sys_district` VALUES ('2519', '金口河', '384', 'j', 'jkh', 'jinkouhe', '', '区', '511113', '0833', 4);
INSERT INTO `sys_district` VALUES ('252', '宜春', '15', 'y', 'yc', 'yichun', '', '市', '360900', '0795', 9);
INSERT INTO `sys_district` VALUES ('2520', '犍为', '384', 'j', 'jw', 'jianwei', '', '县', '511123', '0833', 5);
INSERT INTO `sys_district` VALUES ('2521', '井研', '384', 'j', 'jy', 'jingyan', '', '县', '511124', '0833', 6);
INSERT INTO `sys_district` VALUES ('2522', '夹江', '384', 'j', 'jj', 'jiajiang', '', '县', '511126', '0833', 7);
INSERT INTO `sys_district` VALUES ('2523', '沐川', '384', 'm', 'mc', 'muchuan', '', '县', '511129', '0833', 8);
INSERT INTO `sys_district` VALUES ('2524', '峨边', '384', 'e', 'eb', 'ebian', '彝族', '自治县', '511132', '0833', 9);
INSERT INTO `sys_district` VALUES ('2525', '马边', '384', 'm', 'mb', 'mabian', '彝族', '自治县', '511133', '0833', 10);
INSERT INTO `sys_district` VALUES ('2526', '峨眉山', '384', 'e', 'ems', 'emeishan', '', '市', '511181', '0833', 11);
INSERT INTO `sys_district` VALUES ('2527', '顺庆', '385', 's', 'sq', 'shunqing', '', '区', '511302', '0817', 1);
INSERT INTO `sys_district` VALUES ('2528', '高坪', '385', 'g', 'gp', 'gaoping', '', '区', '511303', '0817', 2);
INSERT INTO `sys_district` VALUES ('2529', '嘉陵', '385', 'j', 'jl', 'jialing', '', '区', '511304', '0817', 3);
INSERT INTO `sys_district` VALUES ('253', '抚州', '15', 'f', 'fz', 'fuzhou', '', '市', '361000', '0794', 10);
INSERT INTO `sys_district` VALUES ('2530', '南部', '385', 'n', 'nb', 'nanbu', '', '县', '511321', '0817', 4);
INSERT INTO `sys_district` VALUES ('2531', '营山', '385', 'y', 'ys', 'yingshan', '', '县', '511322', '0817', 5);
INSERT INTO `sys_district` VALUES ('2532', '蓬安', '385', 'p', 'pa', 'pengan', '', '县', '511323', '0817', 6);
INSERT INTO `sys_district` VALUES ('2533', '仪陇', '385', 'y', 'yl', 'yilong', '', '县', '511324', '0817', 7);
INSERT INTO `sys_district` VALUES ('2534', '西充', '385', 'x', 'xc', 'xichong', '', '县', '511325', '0817', 8);
INSERT INTO `sys_district` VALUES ('2535', '阆中', '385', 'l', 'lz', 'langzhong', '', '市', '511381', '0817', 9);
INSERT INTO `sys_district` VALUES ('2536', '东坡', '386', 'd', 'dp', 'dongpo', '', '区', '511402', '028', 1);
INSERT INTO `sys_district` VALUES ('2537', '仁寿', '386', 'r', 'rs', 'renshou', '', '县', '511421', '028', 2);
INSERT INTO `sys_district` VALUES ('2538', '彭山', '386', 'p', 'ps', 'pengshan', '', '区', '511422', '028', 3);
INSERT INTO `sys_district` VALUES ('2539', '洪雅', '386', 'h', 'hy', 'hongya', '', '县', '511423', '028', 4);
INSERT INTO `sys_district` VALUES ('254', '上饶', '15', 's', 'sr', 'shangrao', '', '市', '361100', '0793', 11);
INSERT INTO `sys_district` VALUES ('2540', '丹棱', '386', 'd', 'dl', 'danleng', '', '县', '511424', '028', 5);
INSERT INTO `sys_district` VALUES ('2541', '青神', '386', 'q', 'qs', 'qingshen', '', '县', '511425', '028', 6);
INSERT INTO `sys_district` VALUES ('2542', '翠屏', '387', 'c', 'cp', 'cuiping', '', '区', '511502', '0831', 1);
INSERT INTO `sys_district` VALUES ('2543', '南溪', '387', 'n', 'nx', 'nanxi', '', '区', '511503', '0831', 2);
INSERT INTO `sys_district` VALUES ('2544', '宜宾', '387', 'y', 'yb', 'yibin', '', '县', '511521', '0831', 3);
INSERT INTO `sys_district` VALUES ('2545', '江安', '387', 'j', 'ja', 'jiangan', '', '县', '511523', '0831', 4);
INSERT INTO `sys_district` VALUES ('2546', '长宁', '387', 'z', 'zn', 'zhangning', '', '县', '511524', '0831', 5);
INSERT INTO `sys_district` VALUES ('2547', '高县', '387', 'g', 'gx', 'gaoxian', '', '', '511525', '0831', 6);
INSERT INTO `sys_district` VALUES ('2548', '珙县', '387', 'g', 'gx', 'gongxian', '', '', '511526', '0831', 7);
INSERT INTO `sys_district` VALUES ('2549', '筠连', '387', 'y', 'yl', 'yunlian', '', '县', '511527', '0831', 8);
INSERT INTO `sys_district` VALUES ('255', '济南', '16', 'j', 'jn', 'jinan', '', '市', '370100', '0531', 1);
INSERT INTO `sys_district` VALUES ('2550', '兴文', '387', 'x', 'xw', 'xingwen', '', '县', '511528', '0831', 9);
INSERT INTO `sys_district` VALUES ('2551', '屏山', '387', 'p', 'ps', 'pingshan', '', '县', '511529', '0831', 10);
INSERT INTO `sys_district` VALUES ('2552', '广安', '388', 'g', 'ga', 'guangan', '', '区', '511602', '0826', 1);
INSERT INTO `sys_district` VALUES ('2553', '岳池', '388', 'y', 'yc', 'yuechi', '', '县', '511621', '0826', 3);
INSERT INTO `sys_district` VALUES ('2554', '武胜', '388', 'w', 'ws', 'wusheng', '', '县', '511622', '0826', 4);
INSERT INTO `sys_district` VALUES ('2555', '邻水', '388', 'l', 'ls', 'linshui', '', '县', '511623', '0826', 5);
INSERT INTO `sys_district` VALUES ('2556', '华蓥', '388', 'h', 'hy', 'huaying', '', '市', '511681', '0826', 6);
INSERT INTO `sys_district` VALUES ('2557', '通川', '389', 't', 'tc', 'tongchuan', '', '区', '511702', '0818', 1);
INSERT INTO `sys_district` VALUES ('2558', '达川', '389', 'd', 'dc', 'dachuan', '', '区', '511721', '0818', 2);
INSERT INTO `sys_district` VALUES ('2559', '宣汉', '389', 'x', 'xh', 'xuanhan', '', '县', '511722', '0818', 3);
INSERT INTO `sys_district` VALUES ('256', '青岛', '16', 'q', 'qd', 'qingdao', '', '市', '370200', '0532', 2);
INSERT INTO `sys_district` VALUES ('2560', '开江', '389', 'k', 'kj', 'kaijiang', '', '县', '511723', '0818', 4);
INSERT INTO `sys_district` VALUES ('2561', '大竹', '389', 'd', 'dz', 'dazhu', '', '县', '511724', '0818', 5);
INSERT INTO `sys_district` VALUES ('2562', '渠县', '389', 'q', 'qx', 'quxian', '', '', '511725', '0818', 6);
INSERT INTO `sys_district` VALUES ('2563', '万源', '389', 'w', 'wy', 'wanyuan', '', '市', '511781', '0818', 7);
INSERT INTO `sys_district` VALUES ('2564', '雨城', '390', 'y', 'yc', 'yucheng', '', '区', '511802', '0835', 1);
INSERT INTO `sys_district` VALUES ('2565', '名山', '390', 'm', 'ms', 'mingshan', '', '区', '511803', '0835', 2);
INSERT INTO `sys_district` VALUES ('2566', '荥经', '390', 'y', 'yj', 'yingjing', '', '县', '511822', '0835', 3);
INSERT INTO `sys_district` VALUES ('2567', '汉源', '390', 'h', 'hy', 'hanyuan', '', '县', '511823', '0835', 4);
INSERT INTO `sys_district` VALUES ('2568', '石棉', '390', 's', 'sm', 'shimian', '', '县', '511824', '0835', 5);
INSERT INTO `sys_district` VALUES ('2569', '天全', '390', 't', 'tq', 'tianquan', '', '县', '511825', '0835', 6);
INSERT INTO `sys_district` VALUES ('257', '淄博', '16', 'z', 'zb', 'zibo', '', '市', '370300', '0533', 3);
INSERT INTO `sys_district` VALUES ('2570', '芦山', '390', 'l', 'ls', 'lushan', '', '县', '511826', '0835', 7);
INSERT INTO `sys_district` VALUES ('2571', '宝兴', '390', 'b', 'bx', 'baoxing', '', '县', '511827', '0835', 8);
INSERT INTO `sys_district` VALUES ('2572', '巴州', '391', 'b', 'bz', 'bazhou', '', '区', '511902', '0827', 1);
INSERT INTO `sys_district` VALUES ('2573', '通江', '391', 't', 'tj', 'tongjiang', '', '县', '511921', '0827', 2);
INSERT INTO `sys_district` VALUES ('2574', '南江', '391', 'n', 'nj', 'nanjiang', '', '县', '511922', '0827', 3);
INSERT INTO `sys_district` VALUES ('2575', '平昌', '391', 'p', 'pc', 'pingchang', '', '县', '511923', '0827', 4);
INSERT INTO `sys_district` VALUES ('2576', '雁江', '392', 'y', 'yj', 'yanjiang', '', '区', '512002', '028', 1);
INSERT INTO `sys_district` VALUES ('2577', '安岳', '392', 'a', 'ay', 'anyue', '', '县', '512021', '028', 2);
INSERT INTO `sys_district` VALUES ('2578', '乐至', '392', 'l', 'lz', 'lezhi', '', '县', '512022', '028', 3);
INSERT INTO `sys_district` VALUES ('2579', '简阳', '375', 'j', 'jy', 'jianyang', '', '市', '512081', '028', 4);
INSERT INTO `sys_district` VALUES ('258', '枣庄', '16', 'z', 'zz', 'zaozhuang', '', '市', '370400', '0632', 4);
INSERT INTO `sys_district` VALUES ('2580', '马尔康', '393', 'm', 'mek', 'maerkang', '', '市', '513229', '0837', 1);
INSERT INTO `sys_district` VALUES ('2581', '汶川', '393', 'w', 'wc', 'wenchuan', '', '县', '513221', '0837', 2);
INSERT INTO `sys_district` VALUES ('2582', '理县', '393', 'l', 'lx', 'lixian', '', '', '513222', '0837', 3);
INSERT INTO `sys_district` VALUES ('2583', '茂县', '393', 'm', 'mx', 'maoxian', '', '', '513223', '0837', 4);
INSERT INTO `sys_district` VALUES ('2584', '松潘', '393', 's', 'sp', 'songpan', '', '县', '513224', '0837', 5);
INSERT INTO `sys_district` VALUES ('2585', '九寨沟', '393', 'j', 'jzg', 'jiuzhaigou', '', '县', '513225', '0837', 6);
INSERT INTO `sys_district` VALUES ('2586', '金川', '393', 'j', 'jc', 'jinchuan', '', '县', '513226', '0837', 7);
INSERT INTO `sys_district` VALUES ('2587', '小金', '393', 'x', 'xj', 'xiaojin', '', '县', '513227', '0837', 8);
INSERT INTO `sys_district` VALUES ('2588', '黑水', '393', 'h', 'hs', 'heishui', '', '县', '513228', '0837', 9);
INSERT INTO `sys_district` VALUES ('2589', '壤塘', '393', 'r', 'rt', 'rangtang', '', '县', '513230', '0837', 10);
INSERT INTO `sys_district` VALUES ('259', '东营', '16', 'd', 'dy', 'dongying', '', '市', '370500', '0546', 5);
INSERT INTO `sys_district` VALUES ('2590', '阿坝', '393', 'a', 'ab', 'aba', '', '县', '513231', '0837', 11);
INSERT INTO `sys_district` VALUES ('2591', '若尔盖', '393', 'r', 'reg', 'ruoergai', '', '县', '513232', '0837', 12);
INSERT INTO `sys_district` VALUES ('2592', '红原', '393', 'h', 'hy', 'hongyuan', '', '县', '513233', '0837', 13);
INSERT INTO `sys_district` VALUES ('2593', '康定', '394', 'k', 'kd', 'kangding', '', '市', '513301', '0836', 1);
INSERT INTO `sys_district` VALUES ('2594', '泸定', '394', 'l', 'ld', 'luding', '', '县', '513322', '0836', 2);
INSERT INTO `sys_district` VALUES ('2595', '丹巴', '394', 'd', 'db', 'danba', '', '县', '513323', '0836', 3);
INSERT INTO `sys_district` VALUES ('2596', '九龙', '394', 'j', 'jl', 'jiulong', '', '县', '513324', '0836', 4);
INSERT INTO `sys_district` VALUES ('2597', '雅江', '394', 'y', 'yj', 'yajiang', '', '县', '513325', '0836', 5);
INSERT INTO `sys_district` VALUES ('2598', '道孚', '394', 'd', 'df', 'daofu', '', '县', '513326', '0836', 6);
INSERT INTO `sys_district` VALUES ('2599', '炉霍', '394', 'l', 'lh', 'luhuo', '', '县', '513327', '0836', 7);
INSERT INTO `sys_district` VALUES ('26', '西藏', '0', 'x', 'xz', 'xizang', '', '自治区', '540000', '', 27);
INSERT INTO `sys_district` VALUES ('260', '烟台', '16', 'y', 'yt', 'yantai', '', '市', '370600', '0535', 6);
INSERT INTO `sys_district` VALUES ('2600', '甘孜', '394', 'g', 'gz', 'ganzi', '', '县', '513328', '0836', 8);
INSERT INTO `sys_district` VALUES ('2601', '新龙', '394', 'x', 'xl', 'xinlong', '', '县', '513329', '0836', 9);
INSERT INTO `sys_district` VALUES ('2602', '德格', '394', 'd', 'dg', 'dege', '', '县', '513330', '0836', 10);
INSERT INTO `sys_district` VALUES ('2603', '白玉', '394', 'b', 'by', 'baiyu', '', '县', '513331', '0836', 11);
INSERT INTO `sys_district` VALUES ('2604', '石渠', '394', 's', 'sq', 'shiqu', '', '县', '513332', '0836', 12);
INSERT INTO `sys_district` VALUES ('2605', '色达', '394', 's', 'sd', 'seda', '', '县', '513333', '0836', 13);
INSERT INTO `sys_district` VALUES ('2606', '理塘', '394', 'l', 'lt', 'litang', '', '县', '513334', '0836', 14);
INSERT INTO `sys_district` VALUES ('2607', '巴塘', '394', 'b', 'bt', 'batang', '', '县', '513335', '0836', 15);
INSERT INTO `sys_district` VALUES ('2608', '乡城', '394', 'x', 'xc', 'xiangcheng', '', '县', '513336', '0836', 16);
INSERT INTO `sys_district` VALUES ('2609', '稻城', '394', 'd', 'dc', 'daocheng', '', '县', '513337', '0836', 17);
INSERT INTO `sys_district` VALUES ('261', '潍坊', '16', 'w', 'wf', 'weifang', '', '市', '370700', '0536', 7);
INSERT INTO `sys_district` VALUES ('2610', '得荣', '394', 'd', 'dr', 'derong', '', '县', '513338', '0836', 18);
INSERT INTO `sys_district` VALUES ('2611', '西昌', '395', 'x', 'xc', 'xichang', '', '市', '513401', '0834', 1);
INSERT INTO `sys_district` VALUES ('2612', '木里', '395', 'm', 'ml', 'muli', '藏族', '自治县', '513422', '0834', 2);
INSERT INTO `sys_district` VALUES ('2613', '盐源', '395', 'y', 'yy', 'yanyuan', '', '县', '513423', '0834', 3);
INSERT INTO `sys_district` VALUES ('2614', '德昌', '395', 'd', 'dc', 'dechang', '', '县', '513424', '0834', 4);
INSERT INTO `sys_district` VALUES ('2615', '会理', '395', 'h', 'hl', 'huili', '', '县', '513425', '0834', 5);
INSERT INTO `sys_district` VALUES ('2616', '会东', '395', 'h', 'hd', 'huidong', '', '县', '513426', '0834', 6);
INSERT INTO `sys_district` VALUES ('2617', '宁南', '395', 'n', 'nn', 'ningnan', '', '县', '513427', '0834', 7);
INSERT INTO `sys_district` VALUES ('2618', '普格', '395', 'p', 'pg', 'puge', '', '县', '513428', '0834', 8);
INSERT INTO `sys_district` VALUES ('2619', '布拖', '395', 'b', 'bt', 'butuo', '', '县', '513429', '0834', 9);
INSERT INTO `sys_district` VALUES ('262', '济宁', '16', 'j', 'jn', 'jining', '', '市', '370800', '0537', 8);
INSERT INTO `sys_district` VALUES ('2620', '金阳', '395', 'j', 'jy', 'jinyang', '', '县', '513430', '0834', 10);
INSERT INTO `sys_district` VALUES ('2621', '昭觉', '395', 'z', 'zj', 'zhaojue', '', '县', '513431', '0834', 11);
INSERT INTO `sys_district` VALUES ('2622', '喜德', '395', 'x', 'xd', 'xide', '', '县', '513432', '0834', 12);
INSERT INTO `sys_district` VALUES ('2623', '冕宁', '395', 'm', 'mn', 'mianning', '', '县', '513433', '0834', 13);
INSERT INTO `sys_district` VALUES ('2624', '越西', '395', 'y', 'yx', 'yuexi', '', '县', '513434', '0834', 14);
INSERT INTO `sys_district` VALUES ('2625', '甘洛', '395', 'g', 'gl', 'ganluo', '', '县', '513435', '0834', 15);
INSERT INTO `sys_district` VALUES ('2626', '美姑', '395', 'm', 'mg', 'meigu', '', '县', '513436', '0834', 16);
INSERT INTO `sys_district` VALUES ('2627', '雷波', '395', 'l', 'lb', 'leibo', '', '县', '513437', '0834', 17);
INSERT INTO `sys_district` VALUES ('2628', '观山湖', '396', 'g', 'gsh', 'guanshanhu', '', '区', '', '0851', 1);
INSERT INTO `sys_district` VALUES ('2629', '南明', '396', 'n', 'nm', 'nanming', '', '区', '520102', '0851', 2);
INSERT INTO `sys_district` VALUES ('263', '泰安', '16', 't', 'ta', 'taian', '', '市', '370900', '0538', 9);
INSERT INTO `sys_district` VALUES ('2630', '云岩', '396', 'y', 'yy', 'yunyan', '', '区', '520103', '0851', 3);
INSERT INTO `sys_district` VALUES ('2631', '花溪', '396', 'h', 'hx', 'huaxi', '', '区', '520111', '0851', 4);
INSERT INTO `sys_district` VALUES ('2632', '乌当', '396', 'w', 'wd', 'wudang', '', '区', '520112', '0851', 5);
INSERT INTO `sys_district` VALUES ('2633', '白云', '396', 'b', 'by', 'baiyun', '', '区', '520113', '0851', 6);
INSERT INTO `sys_district` VALUES ('2634', '开阳', '396', 'k', 'ky', 'kaiyang', '', '县', '520121', '0851', 7);
INSERT INTO `sys_district` VALUES ('2635', '息烽', '396', 'x', 'xf', 'xifeng', '', '县', '520122', '0851', 8);
INSERT INTO `sys_district` VALUES ('2636', '修文', '396', 'x', 'xw', 'xiuwen', '', '县', '520123', '0851', 9);
INSERT INTO `sys_district` VALUES ('2637', '清镇', '396', 'q', 'qz', 'qingzhen', '', '市', '520181', '0851', 10);
INSERT INTO `sys_district` VALUES ('2638', '钟山', '397', 'z', 'zs', 'zhongshan', '', '区', '520201', '0858', 1);
INSERT INTO `sys_district` VALUES ('2639', '六枝特', '397', 'l', 'lzt', 'liuzhite', '', '区', '520203', '0858', 2);
INSERT INTO `sys_district` VALUES ('264', '威海', '16', 'w', 'wh', 'weihai', '', '市', '371000', '0631', 10);
INSERT INTO `sys_district` VALUES ('2640', '水城', '397', 's', 'sc', 'shuicheng', '', '县', '520221', '0858', 3);
INSERT INTO `sys_district` VALUES ('2641', '盘县', '397', 'p', 'px', 'panxian', '', '', '520222', '0858', 4);
INSERT INTO `sys_district` VALUES ('2642', '红花岗', '398', 'h', 'hhg', 'honghuagang', '', '区', '520302', '0852', 1);
INSERT INTO `sys_district` VALUES ('2643', '汇川', '398', 'h', 'hc', 'huichuan', '', '区', '520303', '0852', 2);
INSERT INTO `sys_district` VALUES ('2644', '播州', '398', 'b', 'bz', 'bozhou', '', '区', '520321', '0852', 3);
INSERT INTO `sys_district` VALUES ('2645', '桐梓', '398', 't', 'tz', 'tongzi', '', '县', '520322', '0852', 4);
INSERT INTO `sys_district` VALUES ('2646', '绥阳', '398', 's', 'sy', 'suiyang', '', '县', '520323', '0852', 5);
INSERT INTO `sys_district` VALUES ('2647', '正安', '398', 'z', 'za', 'zhengan', '', '县', '520324', '0852', 6);
INSERT INTO `sys_district` VALUES ('2648', '道真', '398', 'd', 'dz', 'daozhen', '仡佬族苗族', '自治县', '520325', '0852', 7);
INSERT INTO `sys_district` VALUES ('2649', '务川', '398', 'w', 'wc', 'wuchuan', '仡佬族苗族', '自治县', '520326', '0852', 8);
INSERT INTO `sys_district` VALUES ('265', '日照', '16', 'r', 'rz', 'rizhao', '', '市', '371100', '0633', 11);
INSERT INTO `sys_district` VALUES ('2650', '凤冈', '398', 'f', 'fg', 'fenggang', '', '县', '520327', '0852', 9);
INSERT INTO `sys_district` VALUES ('2651', '湄潭', '398', 'm', 'mt', 'meitan', '', '县', '520328', '0852', 10);
INSERT INTO `sys_district` VALUES ('2652', '余庆', '398', 'y', 'yq', 'yuqing', '', '县', '520329', '0852', 11);
INSERT INTO `sys_district` VALUES ('2653', '习水', '398', 'x', 'xs', 'xishui', '', '县', '520330', '0852', 12);
INSERT INTO `sys_district` VALUES ('2654', '赤水', '398', 'c', 'cs', 'chishui', '', '市', '520381', '0852', 13);
INSERT INTO `sys_district` VALUES ('2655', '仁怀', '398', 'r', 'rh', 'renhuai', '', '市', '520382', '0852', 14);
INSERT INTO `sys_district` VALUES ('2656', '西秀', '399', 'x', 'xx', 'xixiu', '', '区', '520402', '0853', 1);
INSERT INTO `sys_district` VALUES ('2657', '平坝', '399', 'p', 'pb', 'pingba', '', '区', '520403', '0853', 2);
INSERT INTO `sys_district` VALUES ('2658', '普定', '399', 'p', 'pd', 'puding', '', '县', '520422', '0853', 3);
INSERT INTO `sys_district` VALUES ('2659', '镇宁', '399', 'z', 'zn', 'zhenning', '布依族苗族', '自治县', '520423', '0853', 4);
INSERT INTO `sys_district` VALUES ('266', '莱芜', '16', 'l', 'lw', 'laiwu', '', '市', '371200', '0634', 12);
INSERT INTO `sys_district` VALUES ('2660', '关岭', '399', 'g', 'gl', 'guanling', '布依族苗族', '自治县', '520424', '0853', 5);
INSERT INTO `sys_district` VALUES ('2661', '紫云', '399', 'z', 'zy', 'ziyun', '苗族布依族', '自治县', '520425', '0853', 6);
INSERT INTO `sys_district` VALUES ('2662', '七星关', '400', 'q', 'qxg', 'qixingguan', '', '区', '520502', '0857', 1);
INSERT INTO `sys_district` VALUES ('2663', '大方', '400', 'd', 'df', 'dafang', '', '县', '520521', '0857', 2);
INSERT INTO `sys_district` VALUES ('2664', '黔西', '400', 'q', 'qx', 'qianxi', '', '县', '520522', '0857', 3);
INSERT INTO `sys_district` VALUES ('2665', '金沙', '400', 'j', 'js', 'jinsha', '', '县', '520523', '0857', 4);
INSERT INTO `sys_district` VALUES ('2666', '织金', '400', 'z', 'zj', 'zhijin', '', '县', '520524', '0857', 5);
INSERT INTO `sys_district` VALUES ('2667', '纳雍', '400', 'n', 'ny', 'nayong', '', '县', '520525', '0857', 6);
INSERT INTO `sys_district` VALUES ('2668', '威宁', '400', 'w', 'wn', 'weining', '彝族回族苗族', '自治县', '520526', '0857', 7);
INSERT INTO `sys_district` VALUES ('2669', '赫章', '400', 'h', 'hz', 'hezhang', '', '县', '520527', '0857', 8);
INSERT INTO `sys_district` VALUES ('267', '临沂', '16', 'l', 'ly', 'linyi', '', '市', '371300', '0539', 13);
INSERT INTO `sys_district` VALUES ('2670', '碧江', '401', 'b', 'bj', 'bijiang', '', '区', '520602', '0856', 1);
INSERT INTO `sys_district` VALUES ('2671', '万山', '401', 'w', 'ws', 'wanshan', '', '区', '520603', '0856', 2);
INSERT INTO `sys_district` VALUES ('2672', '江口', '401', 'j', 'jk', 'jiangkou', '', '县', '520621', '0856', 3);
INSERT INTO `sys_district` VALUES ('2673', '玉屏', '401', 'y', 'yp', 'yuping', '侗族', '自治县', '520622', '0856', 4);
INSERT INTO `sys_district` VALUES ('2674', '石阡', '401', 's', 'sq', 'shiqian', '', '县', '520623', '0856', 5);
INSERT INTO `sys_district` VALUES ('2675', '思南', '401', 's', 'sn', 'sinan', '', '县', '520624', '0856', 6);
INSERT INTO `sys_district` VALUES ('2676', '印江', '401', 'y', 'yj', 'yinjiang', '土家族苗族', '自治县', '520625', '0856', 7);
INSERT INTO `sys_district` VALUES ('2677', '德江', '401', 'd', 'dj', 'dejiang', '', '县', '520626', '0856', 8);
INSERT INTO `sys_district` VALUES ('2678', '沿河', '401', 'y', 'yh', 'yanhe', '土家族', '自治县', '520627', '0856', 9);
INSERT INTO `sys_district` VALUES ('2679', '松桃', '401', 's', 'st', 'songtao', '苗族', '自治县', '520628', '0856', 10);
INSERT INTO `sys_district` VALUES ('268', '德州', '16', 'd', 'dz', 'dezhou', '', '市', '371400', '0534', 14);
INSERT INTO `sys_district` VALUES ('2680', '兴义', '402', 'x', 'xy', 'xingyi', '', '市', '522301', '0859', 1);
INSERT INTO `sys_district` VALUES ('2681', '兴仁', '402', 'x', 'xr', 'xingren', '', '县', '522322', '0859', 2);
INSERT INTO `sys_district` VALUES ('2682', '普安', '402', 'p', 'pa', 'puan', '', '县', '522323', '0859', 3);
INSERT INTO `sys_district` VALUES ('2683', '晴隆', '402', 'q', 'ql', 'qinglong', '', '县', '522324', '0859', 4);
INSERT INTO `sys_district` VALUES ('2684', '贞丰', '402', 'z', 'zf', 'zhenfeng', '', '县', '522325', '0859', 5);
INSERT INTO `sys_district` VALUES ('2685', '望谟', '402', 'w', 'wm', 'wangmo', '', '县', '522326', '0859', 6);
INSERT INTO `sys_district` VALUES ('2686', '册亨', '402', 'c', 'ch', 'ceheng', '', '县', '522327', '0859', 7);
INSERT INTO `sys_district` VALUES ('2687', '安龙', '402', 'a', 'al', 'anlong', '', '县', '522328', '0859', 8);
INSERT INTO `sys_district` VALUES ('2688', '凯里', '403', 'k', 'kl', 'kaili', '', '市', '522601', '0855', 1);
INSERT INTO `sys_district` VALUES ('2689', '黄平', '403', 'h', 'hp', 'huangping', '', '县', '522622', '0855', 2);
INSERT INTO `sys_district` VALUES ('269', '聊城', '16', 'l', 'lc', 'liaocheng', '', '市', '371500', '0635', 15);
INSERT INTO `sys_district` VALUES ('2690', '施秉', '403', 's', 'sb', 'shibing', '', '县', '522623', '0855', 3);
INSERT INTO `sys_district` VALUES ('2691', '三穗', '403', 's', 'ss', 'sansui', '', '县', '522624', '0855', 4);
INSERT INTO `sys_district` VALUES ('2692', '镇远', '403', 'z', 'zy', 'zhenyuan', '', '县', '522625', '0855', 5);
INSERT INTO `sys_district` VALUES ('2693', '岑巩', '403', 'c', 'cg', 'cengong', '', '县', '522626', '0855', 6);
INSERT INTO `sys_district` VALUES ('2694', '天柱', '403', 't', 'tz', 'tianzhu', '', '县', '522627', '0855', 7);
INSERT INTO `sys_district` VALUES ('2695', '锦屏', '403', 'j', 'jp', 'jinping', '', '县', '522628', '0855', 8);
INSERT INTO `sys_district` VALUES ('2696', '剑河', '403', 'j', 'jh', 'jianhe', '', '县', '522629', '0855', 9);
INSERT INTO `sys_district` VALUES ('2697', '台江', '403', 't', 'tj', 'taijiang', '', '县', '522630', '0855', 10);
INSERT INTO `sys_district` VALUES ('2698', '黎平', '403', 'l', 'lp', 'liping', '', '县', '522631', '0855', 11);
INSERT INTO `sys_district` VALUES ('2699', '榕江', '403', 'r', 'rj', 'rongjiang', '', '县', '522632', '0855', 12);
INSERT INTO `sys_district` VALUES ('27', '陕西', '0', 's', 'sx', 'shanxi', '', '省', '610000', '', 28);
INSERT INTO `sys_district` VALUES ('270', '滨州', '16', 'b', 'bz', 'binzhou', '', '市', '371600', '0543', 16);
INSERT INTO `sys_district` VALUES ('2700', '从江', '403', 'c', 'cj', 'congjiang', '', '县', '522633', '0855', 13);
INSERT INTO `sys_district` VALUES ('2701', '雷山', '403', 'l', 'ls', 'leishan', '', '县', '522634', '0855', 14);
INSERT INTO `sys_district` VALUES ('2702', '麻江', '403', 'm', 'mj', 'majiang', '', '县', '522635', '0855', 15);
INSERT INTO `sys_district` VALUES ('2703', '丹寨', '403', 'd', 'dz', 'danzhai', '', '县', '522636', '0855', 16);
INSERT INTO `sys_district` VALUES ('2704', '都匀', '404', 'd', 'dy', 'duyun', '', '市', '522701', '0854', 1);
INSERT INTO `sys_district` VALUES ('2705', '福泉', '404', 'f', 'fq', 'fuquan', '', '市', '522702', '0854', 2);
INSERT INTO `sys_district` VALUES ('2706', '荔波', '404', 'l', 'lb', 'libo', '', '县', '522722', '0854', 3);
INSERT INTO `sys_district` VALUES ('2707', '贵定', '404', 'g', 'gd', 'guiding', '', '县', '522723', '0854', 4);
INSERT INTO `sys_district` VALUES ('2708', '瓮安', '404', 'w', 'wa', 'wengan', '', '县', '522725', '0854', 5);
INSERT INTO `sys_district` VALUES ('2709', '独山', '404', 'd', 'ds', 'dushan', '', '县', '522726', '0854', 6);
INSERT INTO `sys_district` VALUES ('271', '菏泽', '16', 'h', 'hz', 'heze', '', '市', '371700', '0530', 17);
INSERT INTO `sys_district` VALUES ('2710', '平塘', '404', 'p', 'pt', 'pingtang', '', '县', '522727', '0854', 7);
INSERT INTO `sys_district` VALUES ('2711', '罗甸', '404', 'l', 'ld', 'luodian', '', '县', '522728', '0854', 8);
INSERT INTO `sys_district` VALUES ('2712', '长顺', '404', 'z', 'zs', 'zhangshun', '', '县', '522729', '0854', 9);
INSERT INTO `sys_district` VALUES ('2713', '龙里', '404', 'l', 'll', 'longli', '', '县', '522730', '0854', 10);
INSERT INTO `sys_district` VALUES ('2714', '惠水', '404', 'h', 'hs', 'huishui', '', '县', '522731', '0854', 11);
INSERT INTO `sys_district` VALUES ('2715', '三都', '404', 's', 'sd', 'sandu', '水族', '自治县', '522732', '0854', 12);
INSERT INTO `sys_district` VALUES ('2716', '五华', '405', 'w', 'wh', 'wuhua', '', '区', '530102', '0871', 1);
INSERT INTO `sys_district` VALUES ('2717', '盘龙', '405', 'p', 'pl', 'panlong', '', '区', '530103', '0871', 2);
INSERT INTO `sys_district` VALUES ('2718', '官渡', '405', 'g', 'gd', 'guandu', '', '区', '530111', '0871', 3);
INSERT INTO `sys_district` VALUES ('2719', '西山', '405', 'x', 'xs', 'xishan', '', '区', '530112', '0871', 4);
INSERT INTO `sys_district` VALUES ('272', '郑州', '17', 'z', 'zz', 'zhengzhou', '', '市', '410100', '0371', 1);
INSERT INTO `sys_district` VALUES ('2720', '东川', '405', 'd', 'dc', 'dongchuan', '', '区', '530113', '0871', 5);
INSERT INTO `sys_district` VALUES ('2721', '呈贡', '405', 'c', 'cg', 'chenggong', '', '区', '530114', '0871', 6);
INSERT INTO `sys_district` VALUES ('2722', '晋宁', '405', 'j', 'jn', 'jinning', '', '区', '530122', '0871', 7);
INSERT INTO `sys_district` VALUES ('2723', '富民', '405', 'f', 'fm', 'fumin', '', '县', '530124', '0871', 8);
INSERT INTO `sys_district` VALUES ('2724', '宜良', '405', 'y', 'yl', 'yiliang', '', '县', '530125', '0871', 9);
INSERT INTO `sys_district` VALUES ('2725', '石林', '405', 's', 'sl', 'shilin', '彝族', '自治县', '530126', '0871', 10);
INSERT INTO `sys_district` VALUES ('2726', '嵩明', '405', 's', 'sm', 'songming', '', '县', '530127', '0871', 11);
INSERT INTO `sys_district` VALUES ('2727', '禄劝', '405', 'l', 'lq', 'luquan', '彝族苗族', '自治县', '530128', '0871', 12);
INSERT INTO `sys_district` VALUES ('2728', '寻甸', '405', 'x', 'xd', 'xundian', '回族彝族', '自治县', '530129', '0871', 13);
INSERT INTO `sys_district` VALUES ('2729', '安宁', '405', 'a', 'an', 'anning', '', '市', '530181', '0871', 14);
INSERT INTO `sys_district` VALUES ('273', '开封', '17', 'k', 'kf', 'kaifeng', '', '市', '410200', '0378', 2);
INSERT INTO `sys_district` VALUES ('2730', '麒麟', '406', 'q', 'ql', 'qilin', '', '区', '530302', '0874', 1);
INSERT INTO `sys_district` VALUES ('2731', '马龙', '406', 'm', 'ml', 'malong', '', '县', '530321', '0874', 2);
INSERT INTO `sys_district` VALUES ('2732', '陆良', '406', 'l', 'll', 'luliang', '', '县', '530322', '0874', 3);
INSERT INTO `sys_district` VALUES ('2733', '师宗', '406', 's', 'sz', 'shizong', '', '县', '530323', '0874', 4);
INSERT INTO `sys_district` VALUES ('2734', '罗平', '406', 'l', 'lp', 'luoping', '', '县', '530324', '0874', 5);
INSERT INTO `sys_district` VALUES ('2735', '富源', '406', 'f', 'fy', 'fuyuan', '', '县', '530325', '0874', 6);
INSERT INTO `sys_district` VALUES ('2736', '会泽', '406', 'h', 'hz', 'huize', '', '县', '530326', '0874', 7);
INSERT INTO `sys_district` VALUES ('2737', '沾益', '406', 'z', 'zy', 'zhanyi', '', '区', '530328', '0874', 8);
INSERT INTO `sys_district` VALUES ('2738', '宣威', '406', 'x', 'xw', 'xuanwei', '', '市', '530381', '0874', 9);
INSERT INTO `sys_district` VALUES ('2739', '红塔', '407', 'h', 'ht', 'hongta', '', '区', '530402', '0877', 1);
INSERT INTO `sys_district` VALUES ('274', '洛阳', '17', 'l', 'ly', 'luoyang', '', '市', '410300', '0376', 3);
INSERT INTO `sys_district` VALUES ('2740', '江川', '407', 'j', 'jc', 'jiangchuan', '', '区', '530421', '0877', 2);
INSERT INTO `sys_district` VALUES ('2741', '澄江', '407', 'c', 'cj', 'chengjiang', '', '县', '530422', '0877', 3);
INSERT INTO `sys_district` VALUES ('2742', '通海', '407', 't', 'th', 'tonghai', '', '县', '530423', '0877', 4);
INSERT INTO `sys_district` VALUES ('2743', '华宁', '407', 'h', 'hn', 'huaning', '', '县', '530424', '0877', 5);
INSERT INTO `sys_district` VALUES ('2744', '易门', '407', 'y', 'ym', 'yimen', '', '县', '530425', '0877', 6);
INSERT INTO `sys_district` VALUES ('2745', '峨山', '407', 'e', 'es', 'eshan', '彝族', '自治县', '530426', '0877', 7);
INSERT INTO `sys_district` VALUES ('2746', '新平', '407', 'x', 'xp', 'xinping', '彝族傣族', '自治县', '530427', '0877', 8);
INSERT INTO `sys_district` VALUES ('2747', '元江', '407', 'y', 'yj', 'yuanjiang', '哈尼族彝族傣族', '自治县', '530428', '0877', 9);
INSERT INTO `sys_district` VALUES ('2748', '昭阳', '408', 'z', 'zy', 'zhaoyang', '', '区', '530602', '0870', 1);
INSERT INTO `sys_district` VALUES ('2749', '鲁甸', '408', 'l', 'ld', 'ludian', '', '县', '530621', '0870', 2);
INSERT INTO `sys_district` VALUES ('275', '平顶山', '17', 'p', 'pds', 'pingdingshan', '', '市', '410400', '0375', 4);
INSERT INTO `sys_district` VALUES ('2750', '巧家', '408', 'q', 'qj', 'qiaojia', '', '县', '530622', '0870', 3);
INSERT INTO `sys_district` VALUES ('2751', '盐津', '408', 'y', 'yj', 'yanjin', '', '县', '530623', '0870', 4);
INSERT INTO `sys_district` VALUES ('2752', '大关', '408', 'd', 'dg', 'daguan', '', '县', '530624', '0870', 5);
INSERT INTO `sys_district` VALUES ('2753', '永善', '408', 'y', 'ys', 'yongshan', '', '县', '530625', '0870', 6);
INSERT INTO `sys_district` VALUES ('2754', '绥江', '408', 's', 'sj', 'suijiang', '', '县', '530626', '0870', 7);
INSERT INTO `sys_district` VALUES ('2755', '镇雄', '408', 'z', 'zx', 'zhenxiong', '', '县', '530627', '0870', 8);
INSERT INTO `sys_district` VALUES ('2756', '彝良', '408', 'y', 'yl', 'yiliang', '', '县', '530628', '0870', 9);
INSERT INTO `sys_district` VALUES ('2757', '威信', '408', 'w', 'wx', 'weixin', '', '县', '530629', '0870', 10);
INSERT INTO `sys_district` VALUES ('2758', '水富', '408', 's', 'sf', 'shuifu', '', '县', '530630', '0870', 11);
INSERT INTO `sys_district` VALUES ('2759', '古城', '409', 'g', 'gc', 'gucheng', '', '区', '530702', '0888', 1);
INSERT INTO `sys_district` VALUES ('276', '安阳', '17', 'a', 'ay', 'anyang', '', '市', '410500', '0372', 5);
INSERT INTO `sys_district` VALUES ('2760', '玉龙', '409', 'y', 'yl', 'yulong', '纳西族', '自治县', '530721', '0888', 2);
INSERT INTO `sys_district` VALUES ('2761', '永胜', '409', 'y', 'ys', 'yongsheng', '', '县', '530722', '0888', 3);
INSERT INTO `sys_district` VALUES ('2762', '华坪', '409', 'h', 'hp', 'huaping', '', '县', '530723', '0888', 4);
INSERT INTO `sys_district` VALUES ('2763', '宁蒗', '409', 'n', 'nl', 'ninglang', '彝族', '自治县', '530724', '0888', 5);
INSERT INTO `sys_district` VALUES ('2764', '思茅', '410', 's', 'sm', 'simao', '', '区', '530802', '0879', 1);
INSERT INTO `sys_district` VALUES ('2765', '宁洱', '410', 'n', 'ne', 'ninger', '哈尼族彝族', '县', '530821', '0879', 2);
INSERT INTO `sys_district` VALUES ('2766', '墨江', '410', 'm', 'mj', 'mojiang', '哈尼族', '县', '530822', '0879', 3);
INSERT INTO `sys_district` VALUES ('2767', '景东', '410', 'j', 'jd', 'jingdong', '彝族', '县', '530823', '0879', 4);
INSERT INTO `sys_district` VALUES ('2768', '景谷', '410', 'j', 'jg', 'jinggu', '傣族彝族', '县', '530824', '0879', 5);
INSERT INTO `sys_district` VALUES ('2769', '镇沅', '410', 'z', 'zy', 'zhenyuan', '彝族哈尼族拉祜族', '县', '530825', '0879', 6);
INSERT INTO `sys_district` VALUES ('277', '鹤壁', '17', 'h', 'hb', 'hebi', '', '市', '410600', '0392', 6);
INSERT INTO `sys_district` VALUES ('2770', '江城', '410', 'j', 'jc', 'jiangcheng', '哈尼族彝族', '县', '530826', '0879', 7);
INSERT INTO `sys_district` VALUES ('2771', '孟连', '410', 'm', 'ml', 'menglian', '傣族拉祜族佤族', '县', '530827', '0879', 8);
INSERT INTO `sys_district` VALUES ('2772', '澜沧', '410', 'l', 'lc', 'lancang', '拉祜族', '县', '530828', '0879', 9);
INSERT INTO `sys_district` VALUES ('2773', '西盟', '410', 'x', 'xm', 'ximeng', '佤族', '县', '530829', '0879', 10);
INSERT INTO `sys_district` VALUES ('2774', '临翔', '411', 'l', 'lx', 'linxiang', '', '区', '530902', '0883', 1);
INSERT INTO `sys_district` VALUES ('2775', '凤庆', '411', 'f', 'fq', 'fengqing', '', '县', '530921', '0883', 2);
INSERT INTO `sys_district` VALUES ('2776', '云县', '411', 'y', 'yx', 'yunxian', '', '', '530922', '0883', 3);
INSERT INTO `sys_district` VALUES ('2777', '永德', '411', 'y', 'yd', 'yongde', '', '县', '530923', '0883', 4);
INSERT INTO `sys_district` VALUES ('2778', '镇康', '411', 'z', 'zk', 'zhenkang', '', '县', '530924', '0883', 5);
INSERT INTO `sys_district` VALUES ('2779', '双江', '411', 's', 'sj', 'shuangjiang', '拉祜族佤族布朗族傣族', '自治县', '530925', '0883', 6);
INSERT INTO `sys_district` VALUES ('278', '新乡', '17', 'x', 'xx', 'xinxiang', '', '市', '410700', '0373', 7);
INSERT INTO `sys_district` VALUES ('2780', '耿马', '411', 'g', 'gm', 'gengma', '傣族佤族', '自治县', '530926', '0883', 7);
INSERT INTO `sys_district` VALUES ('2781', '沧源', '411', 'c', 'cy', 'cangyuan', '佤族', '自治县', '530927', '0883', 8);
INSERT INTO `sys_district` VALUES ('2782', '楚雄', '412', 'c', 'cx', 'chuxiong', '', '市', '532301', '0878', 1);
INSERT INTO `sys_district` VALUES ('2783', '双柏', '412', 's', 'sb', 'shuangbo', '', '县', '532322', '0878', 2);
INSERT INTO `sys_district` VALUES ('2784', '牟定', '412', 'm', 'md', 'mouding', '', '县', '532323', '0878', 3);
INSERT INTO `sys_district` VALUES ('2785', '南华', '412', 'n', 'nh', 'nanhua', '', '县', '532324', '0878', 4);
INSERT INTO `sys_district` VALUES ('2786', '姚安', '412', 'y', 'ya', 'yaoan', '', '县', '532325', '0878', 5);
INSERT INTO `sys_district` VALUES ('2787', '大姚', '412', 'd', 'dy', 'dayao', '', '县', '532326', '0878', 6);
INSERT INTO `sys_district` VALUES ('2788', '永仁', '412', 'y', 'yr', 'yongren', '', '县', '532327', '0878', 7);
INSERT INTO `sys_district` VALUES ('2789', '元谋', '412', 'y', 'ym', 'yuanmou', '', '县', '532328', '0878', 8);
INSERT INTO `sys_district` VALUES ('279', '焦作', '17', 'j', 'jz', 'jiaozuo', '', '市', '410800', '0391', 8);
INSERT INTO `sys_district` VALUES ('2790', '武定', '412', 'w', 'wd', 'wuding', '', '县', '532329', '0878', 9);
INSERT INTO `sys_district` VALUES ('2791', '禄丰', '412', 'l', 'lf', 'lufeng', '', '县', '532331', '0878', 10);
INSERT INTO `sys_district` VALUES ('2792', '个旧', '413', 'g', 'gj', 'gejiu', '', '市', '532501', '0873', 1);
INSERT INTO `sys_district` VALUES ('2793', '开远', '413', 'k', 'ky', 'kaiyuan', '', '市', '532502', '0873', 2);
INSERT INTO `sys_district` VALUES ('2794', '蒙自', '413', 'm', 'mz', 'mengzi', '', '市', '532503', '0873', 3);
INSERT INTO `sys_district` VALUES ('2795', '屏边', '413', 'p', 'pb', 'pingbian', '苗族', '自治县', '532523', '0873', 4);
INSERT INTO `sys_district` VALUES ('2796', '建水', '413', 'j', 'js', 'jianshui', '', '县', '532524', '0873', 5);
INSERT INTO `sys_district` VALUES ('2797', '石屏', '413', 's', 'sp', 'shiping', '', '县', '532525', '0873', 6);
INSERT INTO `sys_district` VALUES ('2798', '弥勒', '413', 'm', 'ml', 'mile', '', '市', '532526', '0873', 7);
INSERT INTO `sys_district` VALUES ('2799', '泸西', '413', 'l', 'lx', 'luxi', '', '县', '532527', '0873', 8);
INSERT INTO `sys_district` VALUES ('28', '甘肃', '0', 'g', 'gs', 'gansu', '', '省', '620000', '', 29);
INSERT INTO `sys_district` VALUES ('280', '濮阳', '17', 'p', 'py', 'puyang', '', '市', '410900', '', 9);
INSERT INTO `sys_district` VALUES ('2800', '元阳', '413', 'y', 'yy', 'yuanyang', '', '县', '532528', '0873', 9);
INSERT INTO `sys_district` VALUES ('2801', '红河', '413', 'h', 'hh', 'honghe', '', '县', '532529', '0873', 10);
INSERT INTO `sys_district` VALUES ('2802', '金平', '413', 'j', 'jp', 'jinping', '苗族瑶族傣族', '自治县', '532530', '0873', 11);
INSERT INTO `sys_district` VALUES ('2803', '绿春', '413', 'l', 'lc', 'lu:chun', '', '县', '532531', '0873', 12);
INSERT INTO `sys_district` VALUES ('2804', '河口', '413', 'h', 'hk', 'hekou', '瑶族', '自治县', '532532', '0873', 13);
INSERT INTO `sys_district` VALUES ('2805', '文山', '414', 'w', 'ws', 'wenshan', '', '县', '532601', '0876', 1);
INSERT INTO `sys_district` VALUES ('2806', '砚山', '414', 'y', 'ys', 'yanshan', '', '县', '532622', '0876', 2);
INSERT INTO `sys_district` VALUES ('2807', '西畴', '414', 'x', 'xc', 'xichou', '', '县', '532623', '0876', 3);
INSERT INTO `sys_district` VALUES ('2808', '麻栗坡', '414', 'm', 'mlp', 'malipo', '', '县', '532624', '0876', 4);
INSERT INTO `sys_district` VALUES ('2809', '马关', '414', 'm', 'mg', 'maguan', '', '县', '532625', '0876', 5);
INSERT INTO `sys_district` VALUES ('281', '许昌', '17', 'x', 'xc', 'xuchang', '', '市', '411000', '0374', 10);
INSERT INTO `sys_district` VALUES ('2810', '丘北', '414', 'q', 'qb', 'qiubei', '', '县', '532626', '0876', 6);
INSERT INTO `sys_district` VALUES ('2811', '广南', '414', 'g', 'gn', 'guangnan', '', '县', '532627', '0876', 7);
INSERT INTO `sys_district` VALUES ('2812', '富宁', '414', 'f', 'fn', 'funing', '', '县', '532628', '0876', 8);
INSERT INTO `sys_district` VALUES ('2813', '景洪', '415', 'j', 'jh', 'jinghong', '', '市', '532801', '0691', 1);
INSERT INTO `sys_district` VALUES ('2814', '勐海', '415', 'm', 'mh', 'menghai', '', '县', '532822', '0691', 2);
INSERT INTO `sys_district` VALUES ('2815', '勐腊', '415', 'm', 'ml', 'mengla', '', '县', '532823', '0691', 3);
INSERT INTO `sys_district` VALUES ('2816', '大理', '416', 'd', 'dl', 'dali', '', '市', '532901', '0872', 1);
INSERT INTO `sys_district` VALUES ('2817', '漾濞', '416', 'y', 'yb', 'yangbi', '彝族', '自治县', '532922', '0872', 2);
INSERT INTO `sys_district` VALUES ('2818', '祥云', '416', 'x', 'xy', 'xiangyun', '', '县', '532923', '0872', 3);
INSERT INTO `sys_district` VALUES ('2819', '宾川', '416', 'b', 'bc', 'binchuan', '', '县', '532924', '0872', 4);
INSERT INTO `sys_district` VALUES ('282', '漯河', '17', 'l', 'lh', 'luohe', '', '市', '411100', '0395', 11);
INSERT INTO `sys_district` VALUES ('2820', '弥渡', '416', 'm', 'md', 'midu', '', '县', '532925', '0872', 5);
INSERT INTO `sys_district` VALUES ('2821', '南涧', '416', 'n', 'nj', 'nanjian', '彝族', '自治县', '532926', '0872', 6);
INSERT INTO `sys_district` VALUES ('2822', '巍山', '416', 'w', 'ws', 'weishan', '彝族回族', '自治县', '532927', '0872', 7);
INSERT INTO `sys_district` VALUES ('2823', '永平', '416', 'y', 'yp', 'yongping', '', '县', '532928', '0872', 8);
INSERT INTO `sys_district` VALUES ('2824', '云龙', '416', 'y', 'yl', 'yunlong', '', '县', '532929', '0872', 9);
INSERT INTO `sys_district` VALUES ('2825', '洱源', '416', 'e', 'ey', 'eryuan', '', '县', '532930', '0872', 10);
INSERT INTO `sys_district` VALUES ('2826', '剑川', '416', 'j', 'jc', 'jianchuan', '', '县', '532931', '0872', 11);
INSERT INTO `sys_district` VALUES ('2827', '鹤庆', '416', 'h', 'hq', 'heqing', '', '县', '532932', '0872', 12);
INSERT INTO `sys_district` VALUES ('2828', '瑞丽', '417', 'r', 'rl', 'ruili', '', '市', '533102', '0692', 1);
INSERT INTO `sys_district` VALUES ('2829', '芒市', '417', 'm', 'ms', 'mangshi', '', '', '533103', '0692', 2);
INSERT INTO `sys_district` VALUES ('283', '三门峡', '17', 's', 'smx', 'sanmenxia', '', '市', '411200', '0398', 12);
INSERT INTO `sys_district` VALUES ('2830', '梁河', '417', 'l', 'lh', 'lianghe', '', '县', '533122', '0692', 3);
INSERT INTO `sys_district` VALUES ('2831', '盈江', '417', 'y', 'yj', 'yingjiang', '', '县', '533123', '0692', 4);
INSERT INTO `sys_district` VALUES ('2832', '陇川', '417', 'l', 'lc', 'longchuan', '', '县', '533124', '0692', 5);
INSERT INTO `sys_district` VALUES ('2833', '泸水', '418', 'l', 'ls', 'lushui', '', '市', '533321', '0886', 1);
INSERT INTO `sys_district` VALUES ('2834', '福贡', '418', 'f', 'fg', 'fugong', '', '县', '533323', '0886', 2);
INSERT INTO `sys_district` VALUES ('2835', '贡山', '418', 'g', 'gs', 'gongshan', '独龙族怒族', '县', '533324', '0886', 3);
INSERT INTO `sys_district` VALUES ('2836', '兰坪', '418', 'l', 'lp', 'lanping', '白族普米族', '县', '533325', '0886', 4);
INSERT INTO `sys_district` VALUES ('2837', '香格里拉', '419', 'x', 'xgll', 'xianggelila', '', '市', '533421', '0887', 1);
INSERT INTO `sys_district` VALUES ('2838', '德钦', '419', 'd', 'dq', 'deqin', '', '县', '533422', '0887', 2);
INSERT INTO `sys_district` VALUES ('2839', '维西', '419', 'w', 'wx', 'weixi', '', '县', '533423', '0887', 3);
INSERT INTO `sys_district` VALUES ('284', '南阳', '17', 'n', 'ny', 'nanyang', '', '市', '411300', '0377', 13);
INSERT INTO `sys_district` VALUES ('2840', '隆阳', '420', 'l', 'ly', 'longyang', '', '区', '530502', '0875', 1);
INSERT INTO `sys_district` VALUES ('2841', '施甸', '420', 's', 'sd', 'shidian', '', '县', '530521', '0875', 2);
INSERT INTO `sys_district` VALUES ('2842', '腾冲', '420', 't', 'tc', 'tengchong', '', '市', '530522', '0875', 3);
INSERT INTO `sys_district` VALUES ('2843', '龙陵', '420', 'l', 'll', 'longling', '', '县', '530523', '0875', 4);
INSERT INTO `sys_district` VALUES ('2844', '昌宁', '420', 'c', 'cn', 'changning', '', '县', '530524', '0875', 5);
INSERT INTO `sys_district` VALUES ('2845', '城关', '421', 'c', 'cg', 'chengguan', '', '区', '540102', '0891', 1);
INSERT INTO `sys_district` VALUES ('2846', '林周', '421', 'l', 'lz', 'linzhou', '', '县', '540121', '0891', 2);
INSERT INTO `sys_district` VALUES ('2847', '当雄', '421', 'd', 'dx', 'dangxiong', '', '县', '540122', '0891', 3);
INSERT INTO `sys_district` VALUES ('2848', '尼木', '421', 'n', 'nm', 'nimu', '', '县', '540123', '0891', 4);
INSERT INTO `sys_district` VALUES ('2849', '曲水', '421', 'q', 'qs', 'qushui', '', '县', '540124', '0891', 5);
INSERT INTO `sys_district` VALUES ('285', '商丘', '17', 's', 'sq', 'shangqiu', '', '市', '411400', '0370', 14);
INSERT INTO `sys_district` VALUES ('2850', '堆龙德庆', '421', 'd', 'dldq', 'duilongdeqing', '', '区', '540125', '0891', 6);
INSERT INTO `sys_district` VALUES ('2851', '达孜', '421', 'd', 'dz', 'dazi', '', '县', '540126', '0891', 7);
INSERT INTO `sys_district` VALUES ('2852', '墨竹工卡', '421', 'm', 'mzgk', 'mozhugongka', '', '县', '540127', '0891', 8);
INSERT INTO `sys_district` VALUES ('2853', '卡若', '422', 'k', 'kr', 'karuo', '', '区', '542121', '0895', 1);
INSERT INTO `sys_district` VALUES ('2854', '江达', '422', 'j', 'jd', 'jiangda', '', '县', '542122', '0895', 2);
INSERT INTO `sys_district` VALUES ('2855', '贡觉', '422', 'g', 'gj', 'gongjue', '', '县', '542123', '0895', 3);
INSERT INTO `sys_district` VALUES ('2856', '类乌齐', '422', 'l', 'lwq', 'leiwuqi', '', '县', '542124', '0895', 4);
INSERT INTO `sys_district` VALUES ('2857', '丁青', '422', 'd', 'dq', 'dingqing', '', '县', '542125', '0895', 5);
INSERT INTO `sys_district` VALUES ('2858', '察雅', '422', 'c', 'cy', 'chaya', '', '县', '542126', '0895', 6);
INSERT INTO `sys_district` VALUES ('2859', '八宿', '422', 'b', 'bs', 'basu', '', '县', '542127', '0895', 7);
INSERT INTO `sys_district` VALUES ('286', '信阳', '17', 'x', 'xy', 'xinyang', '', '市', '411500', '0376', 15);
INSERT INTO `sys_district` VALUES ('2860', '左贡', '422', 'z', 'zg', 'zuogong', '', '县', '542128', '0895', 8);
INSERT INTO `sys_district` VALUES ('2861', '芒康', '422', 'm', 'mk', 'mangkang', '', '县', '542129', '0895', 9);
INSERT INTO `sys_district` VALUES ('2862', '洛隆', '422', 'l', 'll', 'luolong', '', '县', '542132', '0895', 10);
INSERT INTO `sys_district` VALUES ('2863', '边坝', '422', 'b', 'bb', 'bianba', '', '县', '542133', '0895', 11);
INSERT INTO `sys_district` VALUES ('2864', '乃东', '423', 'n', 'nd', 'naidong', '', '区', '542221', '0893', 1);
INSERT INTO `sys_district` VALUES ('2865', '扎囊', '423', 'z', 'zn', 'zhanang', '', '县', '542222', '0893', 2);
INSERT INTO `sys_district` VALUES ('2866', '贡嘎', '423', 'g', 'gg', 'gongga', '', '县', '542223', '0893', 3);
INSERT INTO `sys_district` VALUES ('2867', '桑日', '423', 's', 'sr', 'sangri', '', '县', '542224', '0893', 4);
INSERT INTO `sys_district` VALUES ('2868', '琼结', '423', 'q', 'qj', 'qiongjie', '', '县', '542225', '0893', 5);
INSERT INTO `sys_district` VALUES ('2869', '曲松', '423', 'q', 'qs', 'qusong', '', '县', '542226', '0893', 6);
INSERT INTO `sys_district` VALUES ('287', '周口', '17', 'z', 'zk', 'zhoukou', '', '市', '411600', '0394', 16);
INSERT INTO `sys_district` VALUES ('2870', '措美', '423', 'c', 'cm', 'cuomei', '', '县', '542227', '0893', 7);
INSERT INTO `sys_district` VALUES ('2871', '洛扎', '423', 'l', 'lz', 'luozha', '', '县', '542228', '0893', 8);
INSERT INTO `sys_district` VALUES ('2872', '加查', '423', 'j', 'jc', 'jiacha', '', '县', '542229', '0893', 9);
INSERT INTO `sys_district` VALUES ('2873', '隆子', '423', 'l', 'lz', 'longzi', '', '县', '542231', '0893', 10);
INSERT INTO `sys_district` VALUES ('2874', '错那', '423', 'c', 'cn', 'cuonei', '', '县', '542232', '0893', 11);
INSERT INTO `sys_district` VALUES ('2875', '浪卡子', '423', 'l', 'lkz', 'langkazi', '', '县', '542233', '0893', 12);
INSERT INTO `sys_district` VALUES ('2876', '桑珠孜', '424', 's', 'szz', 'sangzhuzi', '', '区', '542301', '0892', 1);
INSERT INTO `sys_district` VALUES ('2877', '南木林', '424', 'n', 'nml', 'nanmulin', '', '县', '542322', '0892', 2);
INSERT INTO `sys_district` VALUES ('2878', '江孜', '424', 'j', 'jz', 'jiangzi', '', '县', '542323', '0892', 3);
INSERT INTO `sys_district` VALUES ('2879', '定日', '424', 'd', 'dr', 'dingri', '', '县', '542324', '0892', 4);
INSERT INTO `sys_district` VALUES ('288', '驻马店', '17', 'z', 'zmd', 'zhumadian', '', '市', '411700', '0396', 17);
INSERT INTO `sys_district` VALUES ('2880', '萨迦', '424', 's', 'sj', 'sajia', '', '县', '542325', '0892', 5);
INSERT INTO `sys_district` VALUES ('2881', '拉孜', '424', 'l', 'lz', 'lazi', '', '县', '542326', '0892', 6);
INSERT INTO `sys_district` VALUES ('2882', '昂仁', '424', 'a', 'ar', 'angren', '', '县', '542327', '0892', 7);
INSERT INTO `sys_district` VALUES ('2883', '谢通门', '424', 'x', 'xtm', 'xietongmen', '', '县', '542328', '0892', 8);
INSERT INTO `sys_district` VALUES ('2884', '白朗', '424', 'b', 'bl', 'bailang', '', '县', '542329', '0892', 9);
INSERT INTO `sys_district` VALUES ('2885', '仁布', '424', 'r', 'rb', 'renbu', '', '县', '542330', '0892', 10);
INSERT INTO `sys_district` VALUES ('2886', '康马', '424', 'k', 'km', 'kangma', '', '县', '542331', '0892', 11);
INSERT INTO `sys_district` VALUES ('2887', '定结', '424', 'd', 'dj', 'dingjie', '', '县', '542332', '0892', 12);
INSERT INTO `sys_district` VALUES ('2888', '仲巴', '424', 'z', 'zb', 'zhongba', '', '县', '542333', '0892', 13);
INSERT INTO `sys_district` VALUES ('2889', '亚东', '424', 'y', 'yd', 'yadong', '', '县', '542334', '0892', 14);
INSERT INTO `sys_district` VALUES ('289', '济源', '17', 'j', 'jy', 'jiyuan', '', '市', '419001', '0391', 18);
INSERT INTO `sys_district` VALUES ('2890', '吉隆', '424', 'j', 'jl', 'jilong', '', '县', '542335', '0892', 15);
INSERT INTO `sys_district` VALUES ('2891', '聂拉木', '424', 'n', 'nlm', 'nielamu', '', '县', '542336', '0892', 16);
INSERT INTO `sys_district` VALUES ('2892', '萨嘎', '424', 's', 'sg', 'saga', '', '县', '542337', '0892', 17);
INSERT INTO `sys_district` VALUES ('2893', '岗巴', '424', 'g', 'gb', 'gangba', '', '县', '542338', '0892', 18);
INSERT INTO `sys_district` VALUES ('2894', '双湖', '425', 's', 'sh', 'shuanghu', '', '县', '542431', '0896', 1);
INSERT INTO `sys_district` VALUES ('2895', '那曲', '425', 'n', 'nq', 'neiqu', '', '县', '542421', '0896', 2);
INSERT INTO `sys_district` VALUES ('2896', '嘉黎', '425', 'j', 'jl', 'jiali', '', '县', '542421', '0896', 3);
INSERT INTO `sys_district` VALUES ('2897', '比如', '425', 'b', 'br', 'biru', '', '县', '542423', '0896', 4);
INSERT INTO `sys_district` VALUES ('2898', '聂荣', '425', 'n', 'nr', 'nierong', '', '县', '542424', '0896', 5);
INSERT INTO `sys_district` VALUES ('2899', '安多', '425', 'a', 'ad', 'anduo', '', '县', '542425', '0896', 6);
INSERT INTO `sys_district` VALUES ('29', '青海', '0', 'q', 'qh', 'qinghai', '', '省', '630000', '', 30);
INSERT INTO `sys_district` VALUES ('290', '武汉', '18', 'w', 'wh', 'wuhan', '', '市', '420100', '027', 1);
INSERT INTO `sys_district` VALUES ('2900', '申扎', '425', 's', 'sz', 'shenzha', '', '县', '542426', '0896', 7);
INSERT INTO `sys_district` VALUES ('2901', '索县', '425', 's', 'sx', 'suoxian', '', '', '542427', '0896', 8);
INSERT INTO `sys_district` VALUES ('2902', '班戈', '425', 'b', 'bg', 'bange', '', '县', '542428', '0896', 9);
INSERT INTO `sys_district` VALUES ('2903', '巴青', '425', 'b', 'bq', 'baqing', '', '县', '542429', '0896', 10);
INSERT INTO `sys_district` VALUES ('2904', '尼玛', '425', 'n', 'nm', 'nima', '', '县', '542430', '0896', 11);
INSERT INTO `sys_district` VALUES ('2905', '普兰', '426', 'p', 'pl', 'pulan', '', '县', '542521', '0897', 1);
INSERT INTO `sys_district` VALUES ('2906', '札达', '426', 'z', 'zd', 'zhada', '', '县', '542522', '0897', 2);
INSERT INTO `sys_district` VALUES ('2907', '噶尔', '426', 'g', 'ge', 'gaer', '', '县', '542523', '0897', 3);
INSERT INTO `sys_district` VALUES ('2908', '日土', '426', 'r', 'rt', 'ritu', '', '县', '542524', '0897', 4);
INSERT INTO `sys_district` VALUES ('2909', '革吉', '426', 'g', 'gj', 'geji', '', '县', '542525', '0897', 5);
INSERT INTO `sys_district` VALUES ('291', '黄石', '18', 'h', 'hs', 'huangshi', '', '市', '420200', '0714', 2);
INSERT INTO `sys_district` VALUES ('2910', '改则', '426', 'g', 'gz', 'gaize', '', '县', '542526', '0897', 6);
INSERT INTO `sys_district` VALUES ('2911', '措勤', '426', 'c', 'cq', 'cuoqin', '', '县', '542527', '0897', 7);
INSERT INTO `sys_district` VALUES ('2912', '巴宜', '427', 'b', 'by', 'bayi', '', '区', '540402', '0894', 1);
INSERT INTO `sys_district` VALUES ('2913', '工布江达', '427', 'g', 'gbjd', 'gongbujiangda', '', '县', '542621', '0894', 2);
INSERT INTO `sys_district` VALUES ('2914', '米林', '427', 'm', 'ml', 'milin', '', '县', '542621', '0894', 3);
INSERT INTO `sys_district` VALUES ('2915', '墨脱', '427', 'm', 'mt', 'motuo', '', '县', '542621', '0894', 4);
INSERT INTO `sys_district` VALUES ('2916', '波密', '427', 'b', 'bm', 'bomi', '', '县', '542621', '0894', 5);
INSERT INTO `sys_district` VALUES ('2917', '察隅', '427', 'c', 'cy', 'chayu', '', '县', '542621', '0894', 6);
INSERT INTO `sys_district` VALUES ('2918', '朗县', '427', 'l', 'lx', 'langxian', '', '', '542621', '0894', 7);
INSERT INTO `sys_district` VALUES ('2919', '新城', '428', 'x', 'xc', 'xincheng', '', '区', '610102', '029', 1);
INSERT INTO `sys_district` VALUES ('292', '十堰', '18', 's', 'sy', 'shiyan', '', '市', '420300', '0719', 3);
INSERT INTO `sys_district` VALUES ('2920', '碑林', '428', 'b', 'bl', 'beilin', '', '区', '610103', '029', 2);
INSERT INTO `sys_district` VALUES ('2921', '莲湖', '428', 'l', 'lh', 'lianhu', '', '区', '610104', '029', 3);
INSERT INTO `sys_district` VALUES ('2922', '灞桥', '428', 'b', 'bq', 'baqiao', '', '区', '610111', '029', 4);
INSERT INTO `sys_district` VALUES ('2923', '未央', '428', 'w', 'wy', 'weiyang', '', '区', '610112', '029', 5);
INSERT INTO `sys_district` VALUES ('2924', '雁塔', '428', 'y', 'yt', 'yanta', '', '区', '610113', '029', 6);
INSERT INTO `sys_district` VALUES ('2925', '阎良', '428', 'y', 'yl', 'yanliang', '', '区', '610114', '029', 7);
INSERT INTO `sys_district` VALUES ('2926', '临潼', '428', 'l', 'lt', 'lintong', '', '区', '610115', '029', 8);
INSERT INTO `sys_district` VALUES ('2927', '长安', '428', 'z', 'za', 'zhangan', '', '区', '610116', '029', 9);
INSERT INTO `sys_district` VALUES ('2928', '蓝田', '428', 'l', 'lt', 'lantian', '', '县', '610122', '029', 11);
INSERT INTO `sys_district` VALUES ('2929', '周至', '428', 'z', 'zz', 'zhouzhi', '', '县', '610124', '029', 12);
INSERT INTO `sys_district` VALUES ('293', '宜昌', '18', 'y', 'yc', 'yichang', '', '市', '420500', '0717', 4);
INSERT INTO `sys_district` VALUES ('2930', '鄠邑', '428', 'h', 'hy', 'huyi', '', '区', '610125', '029', 13);
INSERT INTO `sys_district` VALUES ('2931', '高陵', '428', 'g', 'gl', 'gaoling', '', '区', '610117', '029', 10);
INSERT INTO `sys_district` VALUES ('2932', '王益', '429', 'w', 'wy', 'wangyi', '', '区', '610202', '0919', 1);
INSERT INTO `sys_district` VALUES ('2933', '印台', '429', 'y', 'yt', 'yintai', '', '区', '610203', '0919', 2);
INSERT INTO `sys_district` VALUES ('2934', '耀州', '429', 'y', 'yz', 'yaozhou', '', '区', '610204', '0919', 3);
INSERT INTO `sys_district` VALUES ('2935', '宜君', '429', 'y', 'yj', 'yijun', '', '县', '610222', '0919', 4);
INSERT INTO `sys_district` VALUES ('2936', '渭滨', '430', 'w', 'wb', 'weibin', '', '区', '610302', '0917', 1);
INSERT INTO `sys_district` VALUES ('2937', '金台', '430', 'j', 'jt', 'jintai', '', '区', '610303', '0917', 2);
INSERT INTO `sys_district` VALUES ('2938', '陈仓', '430', 'c', 'cc', 'chencang', '', '区', '610304', '0917', 3);
INSERT INTO `sys_district` VALUES ('2939', '凤翔', '430', 'f', 'fx', 'fengxiang', '', '县', '610322', '0917', 4);
INSERT INTO `sys_district` VALUES ('294', '襄阳', '18', 'x', 'xy', 'xiangyang', '', '市', '420600', '0710', 5);
INSERT INTO `sys_district` VALUES ('2940', '岐山', '430', 'q', 'qs', 'qishan', '', '县', '610323', '0917', 5);
INSERT INTO `sys_district` VALUES ('2941', '扶风', '430', 'f', 'ff', 'fufeng', '', '县', '610324', '0917', 6);
INSERT INTO `sys_district` VALUES ('2942', '眉县', '430', 'm', 'mx', 'meixian', '', '', '610326', '0917', 7);
INSERT INTO `sys_district` VALUES ('2943', '陇县', '430', 'l', 'lx', 'longxian', '', '', '610327', '0917', 8);
INSERT INTO `sys_district` VALUES ('2944', '千阳', '430', 'q', 'qy', 'qianyang', '', '县', '610328', '0917', 9);
INSERT INTO `sys_district` VALUES ('2945', '麟游', '430', 'l', 'ly', 'linyou', '', '县', '610329', '0917', 10);
INSERT INTO `sys_district` VALUES ('2946', '凤县', '430', 'f', 'fx', 'fengxian', '', '', '610330', '0917', 11);
INSERT INTO `sys_district` VALUES ('2947', '太白', '430', 't', 'tb', 'taibai', '', '县', '610331', '0917', 12);
INSERT INTO `sys_district` VALUES ('2948', '秦都', '431', 'q', 'qd', 'qindu', '', '区', '610402', '029', 1);
INSERT INTO `sys_district` VALUES ('2949', '杨陵', '431', 'y', 'yl', 'yangling', '', '区', '610403', '029', 2);
INSERT INTO `sys_district` VALUES ('295', '鄂州', '18', 'e', 'ez', 'ezhou', '', '市', '420700', '', 6);
INSERT INTO `sys_district` VALUES ('2950', '渭城', '431', 'w', 'wc', 'weicheng', '', '区', '610404', '029', 3);
INSERT INTO `sys_district` VALUES ('2951', '三原', '431', 's', 'sy', 'sanyuan', '', '县', '610422', '029', 4);
INSERT INTO `sys_district` VALUES ('2952', '泾阳', '431', 'j', 'jy', 'jingyang', '', '县', '610423', '029', 5);
INSERT INTO `sys_district` VALUES ('2953', '乾县', '431', 'q', 'qx', 'qianxian', '', '', '610424', '029', 6);
INSERT INTO `sys_district` VALUES ('2954', '礼泉', '431', 'l', 'lq', 'liquan', '', '县', '610425', '029', 7);
INSERT INTO `sys_district` VALUES ('2955', '永寿', '431', 'y', 'ys', 'yongshou', '', '县', '610426', '029', 8);
INSERT INTO `sys_district` VALUES ('2956', '彬县', '431', 'b', 'bx', 'binxian', '', '', '610427', '029', 9);
INSERT INTO `sys_district` VALUES ('2957', '长武', '431', 'z', 'zw', 'zhangwu', '', '县', '610428', '029', 10);
INSERT INTO `sys_district` VALUES ('2958', '旬邑', '431', 'x', 'xy', 'xunyi', '', '县', '610429', '029', 11);
INSERT INTO `sys_district` VALUES ('2959', '淳化', '431', 'c', 'ch', 'chunhua', '', '县', '610430', '029', 12);
INSERT INTO `sys_district` VALUES ('296', '荆门', '18', 'j', 'jm', 'jingmen', '', '市', '420800', '0724', 7);
INSERT INTO `sys_district` VALUES ('2960', '武功', '431', 'w', 'wg', 'wugong', '', '县', '610431', '029', 13);
INSERT INTO `sys_district` VALUES ('2961', '兴平', '431', 'x', 'xp', 'xingping', '', '市', '610481', '029', 14);
INSERT INTO `sys_district` VALUES ('2962', '临渭', '432', 'l', 'lw', 'linwei', '', '区', '610502', '0913', 1);
INSERT INTO `sys_district` VALUES ('2963', '华州', '432', 'h', 'hz', 'huazhou', '', '区', '610521', '0913', 2);
INSERT INTO `sys_district` VALUES ('2964', '潼关', '432', 't', 'tg', 'tongguan', '', '县', '610522', '0913', 3);
INSERT INTO `sys_district` VALUES ('2965', '大荔', '432', 'd', 'dl', 'dali', '', '县', '610523', '0913', 4);
INSERT INTO `sys_district` VALUES ('2966', '合阳', '432', 'h', 'hy', 'heyang', '', '县', '610524', '0913', 5);
INSERT INTO `sys_district` VALUES ('2967', '澄城', '432', 'c', 'cc', 'chengcheng', '', '县', '610525', '0913', 6);
INSERT INTO `sys_district` VALUES ('2968', '蒲城', '432', 'p', 'pc', 'pucheng', '', '县', '610526', '0913', 7);
INSERT INTO `sys_district` VALUES ('2969', '白水', '432', 'b', 'bs', 'baishui', '', '县', '610527', '0913', 8);
INSERT INTO `sys_district` VALUES ('297', '孝感', '18', 'x', 'xg', 'xiaogan', '', '市', '420900', '0712', 8);
INSERT INTO `sys_district` VALUES ('2970', '富平', '432', 'f', 'fp', 'fuping', '', '县', '610528', '0913', 9);
INSERT INTO `sys_district` VALUES ('2971', '韩城', '432', 'h', 'hc', 'hancheng', '', '市', '610581', '0913', 10);
INSERT INTO `sys_district` VALUES ('2972', '华阴', '432', 'h', 'hy', 'huayin', '', '市', '610582', '0913', 11);
INSERT INTO `sys_district` VALUES ('2973', '宝塔', '433', 'b', 'bt', 'baota', '', '区', '610602', '0911', 1);
INSERT INTO `sys_district` VALUES ('2974', '延长', '433', 'y', 'yz', 'yanzhang', '', '县', '610621', '0911', 2);
INSERT INTO `sys_district` VALUES ('2975', '延川', '433', 'y', 'yc', 'yanchuan', '', '县', '610622', '0911', 3);
INSERT INTO `sys_district` VALUES ('2976', '子长', '433', 'z', 'zz', 'zizhang', '', '县', '610623', '0911', 4);
INSERT INTO `sys_district` VALUES ('2977', '安塞', '433', 'a', 'as', 'ansai', '', '区', '610624', '0911', 5);
INSERT INTO `sys_district` VALUES ('2978', '志丹', '433', 'z', 'zd', 'zhidan', '', '县', '610625', '0911', 6);
INSERT INTO `sys_district` VALUES ('2979', '吴起', '433', 'w', 'wq', 'wuqi', '', '县', '610626', '0911', 7);
INSERT INTO `sys_district` VALUES ('298', '荆州', '18', 'j', 'jz', 'jingzhou', '', '市', '421000', '0716', 9);
INSERT INTO `sys_district` VALUES ('2980', '甘泉', '433', 'g', 'gq', 'ganquan', '', '县', '610627', '0911', 8);
INSERT INTO `sys_district` VALUES ('2981', '富县', '433', 'f', 'fx', 'fuxian', '', '', '610628', '0911', 9);
INSERT INTO `sys_district` VALUES ('2982', '洛川', '433', 'l', 'lc', 'luochuan', '', '县', '610629', '0911', 10);
INSERT INTO `sys_district` VALUES ('2983', '宜川', '433', 'y', 'yc', 'yichuan', '', '县', '610630', '0911', 11);
INSERT INTO `sys_district` VALUES ('2984', '黄龙', '433', 'h', 'hl', 'huanglong', '', '县', '610631', '0911', 12);
INSERT INTO `sys_district` VALUES ('2985', '黄陵', '433', 'h', 'hl', 'huangling', '', '县', '610632', '0911', 13);
INSERT INTO `sys_district` VALUES ('2986', '汉台', '434', 'h', 'ht', 'hantai', '', '区', '610702', '0916', 1);
INSERT INTO `sys_district` VALUES ('2987', '南郑', '434', 'n', 'nz', 'nanzheng', '', '县', '610721', '0916', 2);
INSERT INTO `sys_district` VALUES ('2988', '城固', '434', 'c', 'cg', 'chenggu', '', '县', '610722', '0916', 3);
INSERT INTO `sys_district` VALUES ('2989', '洋县', '434', 'y', 'yx', 'yangxian', '', '', '610723', '0916', 4);
INSERT INTO `sys_district` VALUES ('299', '黄冈', '18', 'h', 'hg', 'huanggang', '', '市', '421100', '0713', 10);
INSERT INTO `sys_district` VALUES ('2990', '西乡', '434', 'x', 'xx', 'xixiang', '', '县', '610724', '0916', 5);
INSERT INTO `sys_district` VALUES ('2991', '勉县', '434', 'm', 'mx', 'mianxian', '', '', '610725', '0916', 6);
INSERT INTO `sys_district` VALUES ('2992', '宁强', '434', 'n', 'nq', 'ningqiang', '', '县', '610726', '0916', 7);
INSERT INTO `sys_district` VALUES ('2993', '略阳', '434', 'l', 'ly', 'lu:eyang', '', '县', '610727', '0916', 8);
INSERT INTO `sys_district` VALUES ('2994', '镇巴', '434', 'z', 'zb', 'zhenba', '', '县', '610728', '0916', 9);
INSERT INTO `sys_district` VALUES ('2995', '留坝', '434', 'l', 'lb', 'liuba', '', '县', '610729', '0916', 10);
INSERT INTO `sys_district` VALUES ('2996', '佛坪', '434', 'f', 'fp', 'foping', '', '县', '610730', '0916', 11);
INSERT INTO `sys_district` VALUES ('2997', '榆阳', '435', 'y', 'yy', 'yuyang', '', '区', '610802', '0912', 1);
INSERT INTO `sys_district` VALUES ('2998', '神木', '435', 's', 'sm', 'shenmu', '', '县', '610821', '0912', 2);
INSERT INTO `sys_district` VALUES ('2999', '府谷', '435', 'f', 'fg', 'fugu', '', '县', '610822', '0912', 3);
INSERT INTO `sys_district` VALUES ('3', '上海', '0', 's', 'sh', 'shanghai', '', '市', '310000', '021', 4);
INSERT INTO `sys_district` VALUES ('30', '宁夏', '0', 'n', 'nx', 'ningxia', '回族', '自治区', '640000', '', 31);
INSERT INTO `sys_district` VALUES ('300', '咸宁', '18', 'x', 'xn', 'xianning', '', '市', '421200', '0715', 11);
INSERT INTO `sys_district` VALUES ('3000', '横山', '435', 'h', 'hs', 'hengshan', '', '区', '610823', '0912', 4);
INSERT INTO `sys_district` VALUES ('3001', '靖边', '435', 'j', 'jb', 'jingbian', '', '县', '610824', '0912', 5);
INSERT INTO `sys_district` VALUES ('3002', '定边', '435', 'd', 'db', 'dingbian', '', '县', '610825', '0912', 6);
INSERT INTO `sys_district` VALUES ('3003', '绥德', '435', 's', 'sd', 'suide', '', '县', '610826', '0912', 7);
INSERT INTO `sys_district` VALUES ('3004', '米脂', '435', 'm', 'mz', 'mizhi', '', '县', '610827', '0912', 8);
INSERT INTO `sys_district` VALUES ('3005', '佳县', '435', 'j', 'jx', 'jiaxian', '', '', '610828', '0912', 9);
INSERT INTO `sys_district` VALUES ('3006', '吴堡', '435', 'w', 'wb', 'wubao', '', '县', '610829', '0912', 10);
INSERT INTO `sys_district` VALUES ('3007', '清涧', '435', 'q', 'qj', 'qingjian', '', '县', '610830', '0912', 11);
INSERT INTO `sys_district` VALUES ('3008', '子洲', '435', 'z', 'zz', 'zizhou', '', '县', '610831', '0912', 12);
INSERT INTO `sys_district` VALUES ('3009', '汉滨', '436', 'h', 'hb', 'hanbin', '', '区', '610902', '0915', 1);
INSERT INTO `sys_district` VALUES ('301', '随州', '18', 's', 'sz', 'suizhou', '', '市', '421300', '0722', 12);
INSERT INTO `sys_district` VALUES ('3010', '汉阴', '436', 'h', 'hy', 'hanyin', '', '县', '610921', '0915', 2);
INSERT INTO `sys_district` VALUES ('3011', '石泉', '436', 's', 'sq', 'shiquan', '', '县', '610922', '0915', 3);
INSERT INTO `sys_district` VALUES ('3012', '宁陕', '436', 'n', 'ns', 'ningshan', '', '县', '610923', '0915', 4);
INSERT INTO `sys_district` VALUES ('3013', '紫阳', '436', 'z', 'zy', 'ziyang', '', '县', '610924', '0915', 5);
INSERT INTO `sys_district` VALUES ('3014', '岚皋', '436', 'l', 'lg', 'langao', '', '县', '610925', '0915', 6);
INSERT INTO `sys_district` VALUES ('3015', '平利', '436', 'p', 'pl', 'pingli', '', '县', '610926', '0915', 7);
INSERT INTO `sys_district` VALUES ('3016', '镇坪', '436', 'z', 'zp', 'zhenping', '', '县', '610927', '0915', 8);
INSERT INTO `sys_district` VALUES ('3017', '旬阳', '436', 'x', 'xy', 'xunyang', '', '县', '610928', '0915', 9);
INSERT INTO `sys_district` VALUES ('3018', '白河', '436', 'b', 'bh', 'baihe', '', '县', '610929', '0915', 10);
INSERT INTO `sys_district` VALUES ('3019', '商州', '437', 's', 'sz', 'shangzhou', '', '区', '611002', '0914', 1);
INSERT INTO `sys_district` VALUES ('302', '恩施', '18', 'e', 'es', 'enshi', '土家族苗族', '自治州', '422800', '0718', 13);
INSERT INTO `sys_district` VALUES ('3020', '洛南', '437', 'l', 'ln', 'luonan', '', '县', '611021', '0914', 2);
INSERT INTO `sys_district` VALUES ('3021', '丹凤', '437', 'd', 'df', 'danfeng', '', '县', '611022', '0914', 3);
INSERT INTO `sys_district` VALUES ('3022', '商南', '437', 's', 'sn', 'shangnan', '', '县', '611023', '0914', 4);
INSERT INTO `sys_district` VALUES ('3023', '山阳', '437', 's', 'sy', 'shanyang', '', '县', '611024', '0914', 5);
INSERT INTO `sys_district` VALUES ('3024', '镇安', '437', 'z', 'za', 'zhenan', '', '县', '611025', '0914', 6);
INSERT INTO `sys_district` VALUES ('3025', '柞水', '437', 'z', 'zs', 'zuoshui', '', '县', '611026', '0914', 7);
INSERT INTO `sys_district` VALUES ('3026', '城关', '438', 'c', 'cg', 'chengguan', '', '区', '620102', '0931', 1);
INSERT INTO `sys_district` VALUES ('3027', '七里河', '438', 'q', 'qlh', 'qilihe', '', '区', '620103', '0931', 2);
INSERT INTO `sys_district` VALUES ('3028', '西固', '438', 'x', 'xg', 'xigu', '', '区', '620104', '0931', 3);
INSERT INTO `sys_district` VALUES ('3029', '安宁', '438', 'a', 'an', 'anning', '', '区', '620105', '0931', 4);
INSERT INTO `sys_district` VALUES ('303', '仙桃', '18', 'x', 'xt', 'xiantao', '', '市', '429004', '0728', 14);
INSERT INTO `sys_district` VALUES ('3030', '红古', '438', 'h', 'hg', 'honggu', '', '区', '620111', '0931', 5);
INSERT INTO `sys_district` VALUES ('3031', '永登', '438', 'y', 'yd', 'yongdeng', '', '县', '620121', '0931', 6);
INSERT INTO `sys_district` VALUES ('3032', '皋兰', '438', 'g', 'gl', 'gaolan', '', '县', '620122', '0931', 7);
INSERT INTO `sys_district` VALUES ('3033', '榆中', '438', 'y', 'yz', 'yuzhong', '', '县', '620123', '0931', 8);
INSERT INTO `sys_district` VALUES ('3034', '镜铁', '439', 'j', 'jt', 'jingtie', '', '区', '620201', '0937', 1);
INSERT INTO `sys_district` VALUES ('3035', '长城', '439', 'z', 'zc', 'zhangcheng', '', '区', '620201', '0937', 2);
INSERT INTO `sys_district` VALUES ('3036', '雄关', '439', 'x', 'xg', 'xiongguan', '', '区', '620201', '0937', 3);
INSERT INTO `sys_district` VALUES ('3037', '金川', '440', 'j', 'jc', 'jinchuan', '', '区', '620302', '0935', 1);
INSERT INTO `sys_district` VALUES ('3038', '永昌', '440', 'y', 'yc', 'yongchang', '', '县', '620321', '0935', 2);
INSERT INTO `sys_district` VALUES ('3039', '白银', '441', 'b', 'by', 'baiyin', '', '区', '620402', '0943', 1);
INSERT INTO `sys_district` VALUES ('304', '潜江', '18', 'q', 'qj', 'qianjiang', '', '市', '429005', '0728', 15);
INSERT INTO `sys_district` VALUES ('3040', '平川', '441', 'p', 'pc', 'pingchuan', '', '区', '620403', '0943', 2);
INSERT INTO `sys_district` VALUES ('3041', '靖远', '441', 'j', 'jy', 'jingyuan', '', '县', '620421', '0943', 3);
INSERT INTO `sys_district` VALUES ('3042', '会宁', '441', 'h', 'hn', 'huining', '', '县', '620422', '0943', 4);
INSERT INTO `sys_district` VALUES ('3043', '景泰', '441', 'j', 'jt', 'jingtai', '', '县', '620423', '0943', 5);
INSERT INTO `sys_district` VALUES ('3044', '秦州', '442', 'q', 'qz', 'qinzhou', '', '区', '620502', '0938', 1);
INSERT INTO `sys_district` VALUES ('3045', '麦积', '442', 'm', 'mj', 'maiji', '', '区', '620503', '0938', 2);
INSERT INTO `sys_district` VALUES ('3046', '清水', '442', 'q', 'qs', 'qingshui', '', '县', '620521', '0938', 3);
INSERT INTO `sys_district` VALUES ('3047', '秦安', '442', 'q', 'qa', 'qinan', '', '县', '620522', '0938', 4);
INSERT INTO `sys_district` VALUES ('3048', '甘谷', '442', 'g', 'gg', 'gangu', '', '县', '620523', '0938', 5);
INSERT INTO `sys_district` VALUES ('3049', '武山', '442', 'w', 'ws', 'wushan', '', '县', '620524', '0938', 6);
INSERT INTO `sys_district` VALUES ('305', '天门', '18', 't', 'tm', 'tianmen', '', '市', '429006', '0728', 16);
INSERT INTO `sys_district` VALUES ('3050', '张家川', '442', 'z', 'zjc', 'zhangjiachuan', '回族', '自治县', '620525', '0938', 7);
INSERT INTO `sys_district` VALUES ('3051', '凉州', '443', 'l', 'lz', 'liangzhou', '', '区', '620602', '0935', 1);
INSERT INTO `sys_district` VALUES ('3052', '民勤', '443', 'm', 'mq', 'minqin', '', '县', '620621', '0935', 2);
INSERT INTO `sys_district` VALUES ('3053', '古浪', '443', 'g', 'gl', 'gulang', '', '县', '620622', '0935', 3);
INSERT INTO `sys_district` VALUES ('3054', '天祝', '443', 't', 'tz', 'tianzhu', '藏族', '自治县', '620623', '0935', 4);
INSERT INTO `sys_district` VALUES ('3055', '甘州', '444', 'g', 'gz', 'ganzhou', '', '区', '620702', '0936', 1);
INSERT INTO `sys_district` VALUES ('3056', '肃南', '444', 's', 'sn', 'sunan', '裕固族', '自治县', '620721', '0936', 2);
INSERT INTO `sys_district` VALUES ('3057', '民乐', '444', 'm', 'ml', 'minle', '', '县', '620722', '0936', 3);
INSERT INTO `sys_district` VALUES ('3058', '临泽', '444', 'l', 'lz', 'linze', '', '县', '620723', '0936', 4);
INSERT INTO `sys_district` VALUES ('3059', '高台', '444', 'g', 'gt', 'gaotai', '', '县', '620724', '0936', 5);
INSERT INTO `sys_district` VALUES ('306', '神农架林区', '18', 's', 'snjlq', 'shennongjialinqu', '', '', '429021', '0719', 17);
INSERT INTO `sys_district` VALUES ('3060', '山丹', '444', 's', 'sd', 'shandan', '', '县', '620725', '0936', 6);
INSERT INTO `sys_district` VALUES ('3061', '崆峒', '445', 'k', 'kt', 'kongtong', '', '区', '620802', '0933', 1);
INSERT INTO `sys_district` VALUES ('3062', '泾川', '445', 'j', 'jc', 'jingchuan', '', '县', '620821', '0933', 2);
INSERT INTO `sys_district` VALUES ('3063', '灵台', '445', 'l', 'lt', 'lingtai', '', '县', '620822', '0933', 3);
INSERT INTO `sys_district` VALUES ('3064', '崇信', '445', 'c', 'cx', 'chongxin', '', '县', '620823', '0933', 4);
INSERT INTO `sys_district` VALUES ('3065', '华亭', '445', 'h', 'ht', 'huating', '', '县', '620824', '0933', 5);
INSERT INTO `sys_district` VALUES ('3066', '庄浪', '445', 'z', 'zl', 'zhuanglang', '', '县', '620825', '0933', 6);
INSERT INTO `sys_district` VALUES ('3067', '静宁', '445', 'j', 'jn', 'jingning', '', '县', '620826', '0933', 7);
INSERT INTO `sys_district` VALUES ('3068', '肃州', '446', 's', 'sz', 'suzhou', '', '区', '620902', '0937', 1);
INSERT INTO `sys_district` VALUES ('3069', '金塔', '446', 'j', 'jt', 'jinta', '', '县', '620921', '0937', 2);
INSERT INTO `sys_district` VALUES ('307', '长沙', '19', 'z', 'zs', 'zhangsha', '', '市', '430100', '0731', 1);
INSERT INTO `sys_district` VALUES ('3070', '瓜州', '446', 'g', 'gz', 'guazhou', '', '县', '620922', '0937', 3);
INSERT INTO `sys_district` VALUES ('3071', '肃北', '446', 's', 'sb', 'subei', '蒙古族', '自治县', '620923', '0937', 4);
INSERT INTO `sys_district` VALUES ('3072', '阿克塞', '446', 'a', 'aks', 'akesai', '哈萨克族', '自治县', '620924', '0937', 5);
INSERT INTO `sys_district` VALUES ('3073', '玉门', '446', 'y', 'ym', 'yumen', '', '市', '620981', '0937', 6);
INSERT INTO `sys_district` VALUES ('3074', '敦煌', '446', 'd', 'dh', 'dunhuang', '', '市', '620982', '0937', 7);
INSERT INTO `sys_district` VALUES ('3075', '西峰', '447', 'x', 'xf', 'xifeng', '', '区', '621002', '0934', 1);
INSERT INTO `sys_district` VALUES ('3076', '庆城', '447', 'q', 'qc', 'qingcheng', '', '县', '621021', '0934', 2);
INSERT INTO `sys_district` VALUES ('3077', '环县', '447', 'h', 'hx', 'huanxian', '', '', '621022', '0934', 3);
INSERT INTO `sys_district` VALUES ('3078', '华池', '447', 'h', 'hc', 'huachi', '', '县', '621023', '0934', 4);
INSERT INTO `sys_district` VALUES ('3079', '合水', '447', 'h', 'hs', 'heshui', '', '县', '621024', '0934', 5);
INSERT INTO `sys_district` VALUES ('308', '株洲', '19', 'z', 'zz', 'zhuzhou', '', '市', '430200', '0731', 2);
INSERT INTO `sys_district` VALUES ('3080', '正宁', '447', 'z', 'zn', 'zhengning', '', '县', '621025', '0934', 6);
INSERT INTO `sys_district` VALUES ('3081', '宁县', '447', 'n', 'nx', 'ningxian', '', '', '621026', '0934', 7);
INSERT INTO `sys_district` VALUES ('3082', '镇原', '447', 'z', 'zy', 'zhenyuan', '', '县', '621027', '0934', 8);
INSERT INTO `sys_district` VALUES ('3083', '安定', '448', 'a', 'ad', 'anding', '', '区', '621102', '0932', 1);
INSERT INTO `sys_district` VALUES ('3084', '通渭', '448', 't', 'tw', 'tongwei', '', '县', '621121', '0932', 2);
INSERT INTO `sys_district` VALUES ('3085', '陇西', '448', 'l', 'lx', 'longxi', '', '县', '621122', '0932', 3);
INSERT INTO `sys_district` VALUES ('3086', '渭源', '448', 'w', 'wy', 'weiyuan', '', '县', '621123', '0932', 4);
INSERT INTO `sys_district` VALUES ('3087', '临洮', '448', 'l', 'lt', 'lintao', '', '县', '621124', '0932', 5);
INSERT INTO `sys_district` VALUES ('3088', '漳县', '448', 'z', 'zx', 'zhangxian', '', '', '621125', '0932', 6);
INSERT INTO `sys_district` VALUES ('3089', '岷县', '448', 'm', 'mx', 'minxian', '', '', '621126', '0932', 7);
INSERT INTO `sys_district` VALUES ('309', '湘潭', '19', 'x', 'xt', 'xiangtan', '', '市', '430300', '0731', 3);
INSERT INTO `sys_district` VALUES ('3090', '武都', '449', 'w', 'wd', 'wudu', '', '区', '621202', '0939', 1);
INSERT INTO `sys_district` VALUES ('3091', '成县', '449', 'c', 'cx', 'chengxian', '', '', '621221', '0939', 2);
INSERT INTO `sys_district` VALUES ('3092', '文县', '449', 'w', 'wx', 'wenxian', '', '', '621222', '0939', 3);
INSERT INTO `sys_district` VALUES ('3093', '宕昌', '449', 'd', 'dc', 'dangchang', '', '县', '621223', '0939', 4);
INSERT INTO `sys_district` VALUES ('3094', '康县', '449', 'k', 'kx', 'kangxian', '', '', '621224', '0939', 5);
INSERT INTO `sys_district` VALUES ('3095', '西和', '449', 'x', 'xh', 'xihe', '', '县', '621225', '0939', 6);
INSERT INTO `sys_district` VALUES ('3096', '礼县', '449', 'l', 'lx', 'lixian', '', '', '621226', '0939', 7);
INSERT INTO `sys_district` VALUES ('3097', '徽县', '449', 'h', 'hx', 'huixian', '', '', '621227', '0939', 8);
INSERT INTO `sys_district` VALUES ('3098', '两当', '449', 'l', 'ld', 'liangdang', '', '县', '621228', '0939', 9);
INSERT INTO `sys_district` VALUES ('3099', '临夏', '450', 'l', 'lx', 'linxia', '', '市', '622901', '0930', 1);
INSERT INTO `sys_district` VALUES ('31', '新疆', '0', 'x', 'xj', 'xinjiang', '维吾尔', '自治区', '650000', '', 32);
INSERT INTO `sys_district` VALUES ('310', '衡阳', '19', 'h', 'hy', 'hengyang', '', '市', '430400', '0734', 4);
INSERT INTO `sys_district` VALUES ('3100', '临夏', '450', 'l', 'lx', 'linxia', '', '县', '622921', '0930', 2);
INSERT INTO `sys_district` VALUES ('3101', '康乐', '450', 'k', 'kl', 'kangle', '', '县', '622922', '0930', 3);
INSERT INTO `sys_district` VALUES ('3102', '永靖', '450', 'y', 'yj', 'yongjing', '', '县', '622923', '0930', 4);
INSERT INTO `sys_district` VALUES ('3103', '广河', '450', 'g', 'gh', 'guanghe', '', '县', '622924', '0930', 5);
INSERT INTO `sys_district` VALUES ('3104', '和政', '450', 'h', 'hz', 'hezheng', '', '县', '622925', '0930', 6);
INSERT INTO `sys_district` VALUES ('3105', '东乡族', '450', 'd', 'dxz', 'dongxiangzu', '', '自治县', '622926', '0930', 7);
INSERT INTO `sys_district` VALUES ('3106', '积石山', '450', 'j', 'jss', 'jishishan', '保安族东乡族撒拉族', '自治县', '622927', '0930', 8);
INSERT INTO `sys_district` VALUES ('3107', '合作', '451', 'h', 'hz', 'hezuo', '', '市', '623001', '0941', 1);
INSERT INTO `sys_district` VALUES ('3108', '临潭', '451', 'l', 'lt', 'lintan', '', '县', '623021', '0941', 2);
INSERT INTO `sys_district` VALUES ('3109', '卓尼', '451', 'z', 'zn', 'zhuoni', '', '县', '623022', '0941', 3);
INSERT INTO `sys_district` VALUES ('311', '邵阳', '19', 's', 'sy', 'shaoyang', '', '市', '430500', '0739', 5);
INSERT INTO `sys_district` VALUES ('3110', '舟曲', '451', 'z', 'zq', 'zhouqu', '', '县', '623023', '0941', 4);
INSERT INTO `sys_district` VALUES ('3111', '迭部', '451', 'd', 'db', 'diebu', '', '县', '623024', '0941', 5);
INSERT INTO `sys_district` VALUES ('3112', '玛曲', '451', 'm', 'mq', 'maqu', '', '县', '623025', '0941', 6);
INSERT INTO `sys_district` VALUES ('3113', '碌曲', '451', 'l', 'lq', 'liuqu', '', '县', '623026', '0941', 7);
INSERT INTO `sys_district` VALUES ('3114', '夏河', '451', 'x', 'xh', 'xiahe', '', '县', '623027', '0941', 8);
INSERT INTO `sys_district` VALUES ('3115', '城东', '452', 'c', 'cd', 'chengdong', '', '区', '630102', '0971', 1);
INSERT INTO `sys_district` VALUES ('3116', '城中', '452', 'c', 'cz', 'chengzhong', '', '区', '630103', '0971', 2);
INSERT INTO `sys_district` VALUES ('3117', '城西', '452', 'c', 'cx', 'chengxi', '', '区', '630104', '0971', 3);
INSERT INTO `sys_district` VALUES ('3118', '城北', '452', 'c', 'cb', 'chengbei', '', '区', '630105', '0971', 4);
INSERT INTO `sys_district` VALUES ('3119', '大通', '452', 'd', 'dt', 'datong', '回族土族', '自治县', '630121', '0971', 5);
INSERT INTO `sys_district` VALUES ('312', '岳阳', '19', 'y', 'yy', 'yueyang', '', '市', '430600', '0730', 6);
INSERT INTO `sys_district` VALUES ('3120', '湟中', '452', 'h', 'hz', 'huangzhong', '', '县', '630122', '0971', 6);
INSERT INTO `sys_district` VALUES ('3121', '湟源', '452', 'h', 'hy', 'huangyuan', '', '县', '630123', '0971', 7);
INSERT INTO `sys_district` VALUES ('3122', '乐都', '453', 'l', 'ld', 'ledu', '', '区', '630202', '0972', 1);
INSERT INTO `sys_district` VALUES ('3123', '平安', '453', 'p', 'pa', 'pingan', '', '区', '632121', '0972', 2);
INSERT INTO `sys_district` VALUES ('3124', '民和', '453', 'm', 'mh', 'minhe', '回族土族', '自治县', '632122', '0972', 3);
INSERT INTO `sys_district` VALUES ('3125', '互助', '453', 'h', 'hz', 'huzhu', '土族', '自治县', '632126', '0972', 4);
INSERT INTO `sys_district` VALUES ('3126', '化隆', '453', 'h', 'hl', 'hualong', '回族', '自治县', '632127', '0972', 5);
INSERT INTO `sys_district` VALUES ('3127', '循化', '453', 'x', 'xh', 'xunhua', '撒拉族', '自治县', '632128', '0972', 6);
INSERT INTO `sys_district` VALUES ('3128', '门源', '454', 'm', 'my', 'menyuan', '回族', '自治县', '632221', '0970', 1);
INSERT INTO `sys_district` VALUES ('3129', '祁连', '454', 'q', 'ql', 'qilian', '', '县', '632222', '0970', 2);
INSERT INTO `sys_district` VALUES ('313', '常德', '19', 'c', 'cd', 'changde', '', '市', '430700', '0736', 7);
INSERT INTO `sys_district` VALUES ('3130', '海晏', '454', 'h', 'hy', 'haiyan', '', '县', '632223', '0970', 3);
INSERT INTO `sys_district` VALUES ('3131', '刚察', '454', 'g', 'gc', 'gangcha', '', '县', '632224', '0970', 4);
INSERT INTO `sys_district` VALUES ('3132', '同仁', '455', 't', 'tr', 'tongren', '', '县', '632321', '0973', 1);
INSERT INTO `sys_district` VALUES ('3133', '尖扎', '455', 'j', 'jz', 'jianzha', '', '县', '632322', '0973', 2);
INSERT INTO `sys_district` VALUES ('3134', '泽库', '455', 'z', 'zk', 'zeku', '', '县', '632323', '0973', 3);
INSERT INTO `sys_district` VALUES ('3135', '河南', '455', 'h', 'hn', 'henan', '蒙古族', '自治县', '632324', '0973', 4);
INSERT INTO `sys_district` VALUES ('3136', '共和', '456', 'g', 'gh', 'gonghe', '', '县', '632521', '0974', 1);
INSERT INTO `sys_district` VALUES ('3137', '同德', '456', 't', 'td', 'tongde', '', '县', '632522', '0974', 2);
INSERT INTO `sys_district` VALUES ('3138', '贵德', '456', 'g', 'gd', 'guide', '', '县', '632523', '0974', 3);
INSERT INTO `sys_district` VALUES ('3139', '兴海', '456', 'x', 'xh', 'xinghai', '', '县', '632524', '0974', 4);
INSERT INTO `sys_district` VALUES ('314', '张家界', '19', 'z', 'zjj', 'zhangjiajie', '', '市', '430800', '0744', 8);
INSERT INTO `sys_district` VALUES ('3140', '贵南', '456', 'g', 'gn', 'guinan', '', '县', '632525', '0974', 5);
INSERT INTO `sys_district` VALUES ('3141', '玛沁', '457', 'm', 'mq', 'maqin', '', '县', '632621', '0975', 1);
INSERT INTO `sys_district` VALUES ('3142', '班玛', '457', 'b', 'bm', 'banma', '', '县', '632622', '0975', 2);
INSERT INTO `sys_district` VALUES ('3143', '甘德', '457', 'g', 'gd', 'gande', '', '县', '632623', '0975', 3);
INSERT INTO `sys_district` VALUES ('3144', '达日', '457', 'd', 'dr', 'dari', '', '县', '632624', '0975', 4);
INSERT INTO `sys_district` VALUES ('3145', '久治', '457', 'j', 'jz', 'jiuzhi', '', '县', '632625', '0975', 5);
INSERT INTO `sys_district` VALUES ('3146', '玛多', '457', 'm', 'md', 'maduo', '', '县', '632626', '0975', 6);
INSERT INTO `sys_district` VALUES ('3147', '玉树', '458', 'y', 'ys', 'yushu', '', '市', '632721', '0976', 1);
INSERT INTO `sys_district` VALUES ('3148', '杂多', '458', 'z', 'zd', 'zaduo', '', '县', '632722', '0976', 2);
INSERT INTO `sys_district` VALUES ('3149', '治多', '458', 'z', 'zd', 'zhiduo', '', '县', '632724', '0976', 3);
INSERT INTO `sys_district` VALUES ('315', '益阳', '19', 'y', 'yy', 'yiyang', '', '市', '430900', '0737', 9);
INSERT INTO `sys_district` VALUES ('3150', '囊谦', '458', 'n', 'nq', 'nangqian', '', '县', '632725', '0976', 4);
INSERT INTO `sys_district` VALUES ('3151', '曲麻莱', '458', 'q', 'qml', 'qumalai', '', '县', '632726', '0976', 5);
INSERT INTO `sys_district` VALUES ('3152', '大柴旦', '459', 'd', 'dcd', 'dachaidan', '', '行委', '', '0977', 1);
INSERT INTO `sys_district` VALUES ('3153', '冷湖', '459', 'l', 'lh', 'lenghu', '', '行委', '', '0977', 2);
INSERT INTO `sys_district` VALUES ('3154', '茫崖', '459', 'm', 'my', 'mangya', '', '行委', '', '0977', 3);
INSERT INTO `sys_district` VALUES ('3155', '格尔木', '459', 'g', 'gem', 'geermu', '', '市', '632801', '0977', 4);
INSERT INTO `sys_district` VALUES ('3156', '德令哈', '459', 'd', 'dlh', 'delingha', '', '市', '632802', '0977', 5);
INSERT INTO `sys_district` VALUES ('3157', '乌兰', '459', 'w', 'wl', 'wulan', '', '县', '632821', '0977', 6);
INSERT INTO `sys_district` VALUES ('3158', '都兰', '459', 'd', 'dl', 'dulan', '', '县', '632822', '0977', 7);
INSERT INTO `sys_district` VALUES ('3159', '天峻', '459', 't', 'tj', 'tianjun', '', '县', '632823', '0977', 8);
INSERT INTO `sys_district` VALUES ('316', '郴州', '19', 'c', 'cz', 'chenzhou', '', '市', '431000', '0735', 10);
INSERT INTO `sys_district` VALUES ('3160', '兴庆', '460', 'x', 'xq', 'xingqing', '', '区', '640104', '0951', 1);
INSERT INTO `sys_district` VALUES ('3161', '西夏', '460', 'x', 'xx', 'xixia', '', '区', '640105', '0951', 2);
INSERT INTO `sys_district` VALUES ('3162', '金凤', '460', 'j', 'jf', 'jinfeng', '', '区', '640106', '0951', 3);
INSERT INTO `sys_district` VALUES ('3163', '永宁', '460', 'y', 'yn', 'yongning', '', '县', '640121', '0951', 4);
INSERT INTO `sys_district` VALUES ('3164', '贺兰', '460', 'h', 'hl', 'helan', '', '县', '640122', '0951', 5);
INSERT INTO `sys_district` VALUES ('3165', '灵武', '460', 'l', 'lw', 'lingwu', '', '市', '640181', '0951', 6);
INSERT INTO `sys_district` VALUES ('3166', '大武口', '461', 'd', 'dwk', 'dawukou', '', '区', '640202', '0952', 1);
INSERT INTO `sys_district` VALUES ('3167', '惠农', '461', 'h', 'hn', 'huinong', '', '区', '640205', '0952', 2);
INSERT INTO `sys_district` VALUES ('3168', '平罗', '461', 'p', 'pl', 'pingluo', '', '县', '640221', '0952', 3);
INSERT INTO `sys_district` VALUES ('3169', '红寺堡', '462', 'h', 'hsb', 'hongsibao', '', '区', '', '0953', 1);
INSERT INTO `sys_district` VALUES ('317', '永州', '19', 'y', 'yz', 'yongzhou', '', '市', '431100', '0746', 11);
INSERT INTO `sys_district` VALUES ('3170', '利通', '462', 'l', 'lt', 'litong', '', '区', '640302', '0953', 2);
INSERT INTO `sys_district` VALUES ('3171', '盐池', '462', 'y', 'yc', 'yanchi', '', '县', '640323', '0953', 3);
INSERT INTO `sys_district` VALUES ('3172', '同心', '462', 't', 'tx', 'tongxin', '', '县', '640324', '0953', 4);
INSERT INTO `sys_district` VALUES ('3173', '青铜峡', '462', 'q', 'qtx', 'qingtongxia', '', '市', '640381', '0953', 5);
INSERT INTO `sys_district` VALUES ('3174', '原州', '463', 'y', 'yz', 'yuanzhou', '', '区', '640402', '0954', 1);
INSERT INTO `sys_district` VALUES ('3175', '西吉', '463', 'x', 'xj', 'xiji', '', '县', '640422', '0954', 2);
INSERT INTO `sys_district` VALUES ('3176', '隆德', '463', 'l', 'ld', 'longde', '', '县', '640423', '0954', 3);
INSERT INTO `sys_district` VALUES ('3177', '泾源', '463', 'j', 'jy', 'jingyuan', '', '县', '640424', '0954', 4);
INSERT INTO `sys_district` VALUES ('3178', '彭阳', '463', 'p', 'py', 'pengyang', '', '县', '640425', '0954', 5);
INSERT INTO `sys_district` VALUES ('3179', '沙坡头', '464', 's', 'spt', 'shapotou', '', '区', '640502', '', 1);
INSERT INTO `sys_district` VALUES ('318', '怀化', '19', 'h', 'hh', 'huaihua', '', '市', '431200', '0745', 12);
INSERT INTO `sys_district` VALUES ('3180', '中宁', '464', 'z', 'zn', 'zhongning', '', '县', '640521', '', 2);
INSERT INTO `sys_district` VALUES ('3181', '海原', '464', 'h', 'hy', 'haiyuan', '', '县', '640522', '', 3);
INSERT INTO `sys_district` VALUES ('3182', '天山', '465', 't', 'ts', 'tianshan', '', '区', '650102', '0991', 1);
INSERT INTO `sys_district` VALUES ('3183', '沙依巴克', '465', 's', 'sybk', 'shayibake', '', '区', '650103', '0991', 2);
INSERT INTO `sys_district` VALUES ('3184', '新市', '465', 'x', 'xs', 'xinshi', '', '区', '650104', '0991', 3);
INSERT INTO `sys_district` VALUES ('3185', '水磨沟', '465', 's', 'smg', 'shuimogou', '', '区', '650105', '0991', 4);
INSERT INTO `sys_district` VALUES ('3186', '头屯河', '465', 't', 'tth', 'toutunhe', '', '区', '650106', '0991', 5);
INSERT INTO `sys_district` VALUES ('3187', '达坂城', '465', 'd', 'dbc', 'dabancheng', '', '区', '650107', '0991', 6);
INSERT INTO `sys_district` VALUES ('3188', '米东', '465', 'm', 'md', 'midong', '', '区', '650109', '0991', 7);
INSERT INTO `sys_district` VALUES ('3189', '乌鲁木齐', '465', 'w', 'wlmq', 'wulumuqi', '', '县', '650121', '0991', 8);
INSERT INTO `sys_district` VALUES ('319', '娄底', '19', 'l', 'ld', 'loudi', '', '市', '431300', '0738', 13);
INSERT INTO `sys_district` VALUES ('3190', '独山子', '466', 'd', 'dsz', 'dushanzi', '', '区', '650202', '0990', 1);
INSERT INTO `sys_district` VALUES ('3191', '克拉玛依', '466', 'k', 'klmy', 'kelamayi', '', '区', '650203', '0990', 2);
INSERT INTO `sys_district` VALUES ('3192', '白碱滩', '466', 'b', 'bjt', 'baijiantan', '', '区', '650204', '0990', 3);
INSERT INTO `sys_district` VALUES ('3193', '乌尔禾', '466', 'w', 'weh', 'wuerhe', '', '区', '650205', '0990', 4);
INSERT INTO `sys_district` VALUES ('3194', '高昌', '467', 'g', 'gc', 'gaochang', '', '区', '652101', '0995', 1);
INSERT INTO `sys_district` VALUES ('3195', '鄯善', '467', 's', 'ss', 'shanshan', '', '县', '652122', '0995', 2);
INSERT INTO `sys_district` VALUES ('3196', '托克逊', '467', 't', 'tkx', 'tuokexun', '', '县', '652123', '0995', 3);
INSERT INTO `sys_district` VALUES ('3197', '伊州', '468', 'y', 'yz', 'yizhou', '', '区', '652201', '0902', 1);
INSERT INTO `sys_district` VALUES ('3198', '巴里坤', '468', 'b', 'blk', 'balikun', '哈萨克', '自治县', '650521', '0902', 2);
INSERT INTO `sys_district` VALUES ('3199', '伊吾', '468', 'y', 'yw', 'yiwu', '', '县', '652223', '0902', 3);
INSERT INTO `sys_district` VALUES ('32', '台湾', '0', 't', 'tw', 'taiwan', '', '省', '710000', '', 33);
INSERT INTO `sys_district` VALUES ('320', '湘西', '19', 'x', 'xx', 'xiangxi', '土家族苗族', '自治州', '433100', '0743', 14);
INSERT INTO `sys_district` VALUES ('3200', '昌吉', '469', 'c', 'cj', 'changji', '', '市', '652301', '0994', 1);
INSERT INTO `sys_district` VALUES ('3201', '阜康', '469', 'f', 'fk', 'fukang', '', '市', '652302', '0994', 2);
INSERT INTO `sys_district` VALUES ('3202', '呼图壁', '469', 'h', 'htb', 'hutubi', '', '县', '652323', '0994', 3);
INSERT INTO `sys_district` VALUES ('3203', '玛纳斯', '469', 'm', 'mns', 'manasi', '', '县', '652324', '0994', 4);
INSERT INTO `sys_district` VALUES ('3204', '奇台', '469', 'q', 'qt', 'qitai', '', '县', '652325', '0994', 5);
INSERT INTO `sys_district` VALUES ('3205', '吉木萨尔', '469', 'j', 'jmse', 'jimusaer', '', '县', '652327', '0994', 6);
INSERT INTO `sys_district` VALUES ('3206', '木垒', '469', 'm', 'ml', 'mulei', '哈萨克', '自治县', '652328', '0994', 7);
INSERT INTO `sys_district` VALUES ('3207', '阿拉山口', '470', 'a', 'alsk', 'alashankou', '', '市', '', '0909', 1);
INSERT INTO `sys_district` VALUES ('3208', '博乐', '470', 'b', 'bl', 'bole', '', '市', '652701', '0909', 2);
INSERT INTO `sys_district` VALUES ('3209', '精河', '470', 'j', 'jh', 'jinghe', '', '县', '652722', '0909', 3);
INSERT INTO `sys_district` VALUES ('321', '广州', '20', 'g', 'gz', 'guangzhou', '', '市', '440100', '020', 1);
INSERT INTO `sys_district` VALUES ('3210', '温泉', '470', 'w', 'wq', 'wenquan', '', '县', '652723', '0909', 4);
INSERT INTO `sys_district` VALUES ('3211', '库尔勒', '471', 'k', 'kel', 'kuerle', '', '市', '652801', '0996', 1);
INSERT INTO `sys_district` VALUES ('3212', '轮台', '471', 'l', 'lt', 'luntai', '', '县', '652822', '0996', 2);
INSERT INTO `sys_district` VALUES ('3213', '尉犁', '471', 'w', 'wl', 'weili', '', '县', '652823', '0996', 3);
INSERT INTO `sys_district` VALUES ('3214', '若羌', '471', 'r', 'rq', 'ruoqiang', '', '县', '652824', '0996', 4);
INSERT INTO `sys_district` VALUES ('3215', '且末', '471', 'q', 'qm', 'qiemo', '', '县', '652825', '0996', 5);
INSERT INTO `sys_district` VALUES ('3216', '焉耆', '471', 'y', 'yq', 'yanqi', '回族', '自治县', '652826', '0996', 6);
INSERT INTO `sys_district` VALUES ('3217', '和静', '471', 'h', 'hj', 'hejing', '', '县', '652827', '0996', 7);
INSERT INTO `sys_district` VALUES ('3218', '和硕', '471', 'h', 'hs', 'heshuo', '', '县', '652828', '0996', 8);
INSERT INTO `sys_district` VALUES ('3219', '博湖', '471', 'b', 'bh', 'bohu', '', '县', '652829', '0996', 9);
INSERT INTO `sys_district` VALUES ('322', '韶关', '20', 's', 'sg', 'shaoguan', '', '市', '440200', '0751', 2);
INSERT INTO `sys_district` VALUES ('3220', '阿克苏', '472', 'a', 'aks', 'akesu', '', '市', '652901', '', 1);
INSERT INTO `sys_district` VALUES ('3221', '温宿', '472', 'w', 'ws', 'wensu', '', '县', '652922', '', 2);
INSERT INTO `sys_district` VALUES ('3222', '库车', '472', 'k', 'kc', 'kuche', '', '县', '652923', '', 3);
INSERT INTO `sys_district` VALUES ('3223', '沙雅', '472', 's', 'sy', 'shaya', '', '县', '652924', '', 4);
INSERT INTO `sys_district` VALUES ('3224', '新和', '472', 'x', 'xh', 'xinhe', '', '县', '652925', '', 5);
INSERT INTO `sys_district` VALUES ('3225', '拜城', '472', 'b', 'bc', 'baicheng', '', '县', '652926', '', 6);
INSERT INTO `sys_district` VALUES ('3226', '乌什', '472', 'w', 'ws', 'wushen', '', '县', '652927', '', 7);
INSERT INTO `sys_district` VALUES ('3227', '阿瓦提', '472', 'a', 'awt', 'awati', '', '县', '652928', '', 8);
INSERT INTO `sys_district` VALUES ('3228', '柯坪', '472', 'k', 'kp', 'keping', '', '县', '652929', '', 9);
INSERT INTO `sys_district` VALUES ('3229', '阿图什', '473', 'a', 'ats', 'atushen', '', '市', '653001', '0908', 1);
INSERT INTO `sys_district` VALUES ('323', '深圳', '20', 's', 'sz', 'shenzhen', '', '市', '440300', '0755', 3);
INSERT INTO `sys_district` VALUES ('3230', '阿克陶', '473', 'a', 'akt', 'aketao', '', '县', '653022', '0908', 2);
INSERT INTO `sys_district` VALUES ('3231', '阿合奇', '473', 'a', 'ahq', 'aheqi', '', '县', '653023', '0997', 3);
INSERT INTO `sys_district` VALUES ('3232', '乌恰', '473', 'w', 'wq', 'wuqia', '', '县', '653024', '0908', 4);
INSERT INTO `sys_district` VALUES ('3233', '喀什', '474', 'k', 'ks', 'kashen', '', '市', '653101', '0998', 1);
INSERT INTO `sys_district` VALUES ('3234', '疏附', '474', 's', 'sf', 'shufu', '', '县', '653121', '0998', 2);
INSERT INTO `sys_district` VALUES ('3235', '疏勒', '474', 's', 'sl', 'shule', '', '县', '653122', '0998', 3);
INSERT INTO `sys_district` VALUES ('3236', '英吉沙', '474', 'y', 'yjs', 'yingjisha', '', '县', '653123', '0998', 4);
INSERT INTO `sys_district` VALUES ('3237', '泽普', '474', 'z', 'zp', 'zepu', '', '县', '653124', '0998', 5);
INSERT INTO `sys_district` VALUES ('3238', '莎车', '474', 's', 'sc', 'shache', '', '县', '653125', '0998', 6);
INSERT INTO `sys_district` VALUES ('3239', '叶城', '474', 'y', 'yc', 'yecheng', '', '县', '653126', '0998', 7);
INSERT INTO `sys_district` VALUES ('324', '珠海', '20', 'z', 'zh', 'zhuhai', '', '市', '440400', '0756', 4);
INSERT INTO `sys_district` VALUES ('3240', '麦盖提', '474', 'm', 'mgt', 'maigaiti', '', '县', '653127', '0998', 8);
INSERT INTO `sys_district` VALUES ('3241', '岳普湖', '474', 'y', 'yph', 'yuepuhu', '', '县', '653128', '0998', 9);
INSERT INTO `sys_district` VALUES ('3242', '伽师', '474', 'j', 'js', 'jiashi', '', '县', '653129', '0998', 10);
INSERT INTO `sys_district` VALUES ('3243', '巴楚', '474', 'b', 'bc', 'bachu', '', '县', '653130', '0998', 11);
INSERT INTO `sys_district` VALUES ('3244', '塔什库尔干', '474', 't', 'tskeg', 'tashenkuergan', '塔吉克', '自治县', '653131', '0998', 12);
INSERT INTO `sys_district` VALUES ('3245', '和田', '475', 'h', 'ht', 'hetian', '', '市', '653201', '0903', 1);
INSERT INTO `sys_district` VALUES ('3246', '和田', '475', 'h', 'ht', 'hetian', '', '县', '653221', '0903', 2);
INSERT INTO `sys_district` VALUES ('3247', '墨玉', '475', 'm', 'my', 'moyu', '', '县', '653222', '0903', 3);
INSERT INTO `sys_district` VALUES ('3248', '皮山', '475', 'p', 'ps', 'pishan', '', '县', '653223', '0903', 4);
INSERT INTO `sys_district` VALUES ('3249', '洛浦', '475', 'l', 'lp', 'luopu', '', '县', '653224', '0903', 5);
INSERT INTO `sys_district` VALUES ('325', '汕头', '20', 's', 'st', 'shantou', '', '市', '440500', '0754', 5);
INSERT INTO `sys_district` VALUES ('3250', '策勒', '475', 'c', 'cl', 'cele', '', '县', '653225', '0903', 6);
INSERT INTO `sys_district` VALUES ('3251', '于田', '475', 'y', 'yt', 'yutian', '', '县', '653226', '0903', 7);
INSERT INTO `sys_district` VALUES ('3252', '民丰', '475', 'm', 'mf', 'minfeng', '', '县', '653227', '0903', 8);
INSERT INTO `sys_district` VALUES ('3253', '伊宁', '476', 'y', 'yn', 'yining', '', '市', '654002', '0999', 1);
INSERT INTO `sys_district` VALUES ('3254', '奎屯', '476', 'k', 'kt', 'kuitun', '', '市', '654003', '0999', 2);
INSERT INTO `sys_district` VALUES ('3255', '伊宁', '476', 'y', 'yn', 'yining', '', '县', '654021', '0999', 4);
INSERT INTO `sys_district` VALUES ('3256', '察布查尔锡伯', '476', 'c', 'cbcexb', 'chabuchaerxibo', '', '自治县', '654022', '0999', 5);
INSERT INTO `sys_district` VALUES ('3257', '霍城', '476', 'h', 'hc', 'huocheng', '', '县', '654023', '0999', 6);
INSERT INTO `sys_district` VALUES ('3258', '巩留', '476', 'g', 'gl', 'gongliu', '', '县', '654024', '0999', 7);
INSERT INTO `sys_district` VALUES ('3259', '新源', '476', 'x', 'xy', 'xinyuan', '', '县', '654025', '0999', 8);
INSERT INTO `sys_district` VALUES ('326', '佛山', '20', 'f', 'fs', 'foshan', '', '市', '440600', '0757', 6);
INSERT INTO `sys_district` VALUES ('3260', '昭苏', '476', 'z', 'zs', 'zhaosu', '', '县', '654026', '0999', 9);
INSERT INTO `sys_district` VALUES ('3261', '特克斯', '476', 't', 'tks', 'tekesi', '', '县', '654027', '0999', 10);
INSERT INTO `sys_district` VALUES ('3262', '尼勒克', '476', 'n', 'nlk', 'nileke', '', '县', '654028', '0999', 11);
INSERT INTO `sys_district` VALUES ('3263', '塔城', '477', 't', 'tc', 'tacheng', '', '市', '654201', '0901', 1);
INSERT INTO `sys_district` VALUES ('3264', '乌苏', '477', 'w', 'ws', 'wusu', '', '市', '654202', '0901', 2);
INSERT INTO `sys_district` VALUES ('3265', '额敏', '477', 'e', 'em', 'emin', '', '县', '654221', '0901', 3);
INSERT INTO `sys_district` VALUES ('3266', '沙湾', '477', 's', 'sw', 'shawan', '', '县', '654223', '0901', 4);
INSERT INTO `sys_district` VALUES ('3267', '托里', '477', 't', 'tl', 'tuoli', '', '县', '654224', '0901', 5);
INSERT INTO `sys_district` VALUES ('3268', '裕民', '477', 'y', 'ym', 'yumin', '', '县', '654225', '0901', 6);
INSERT INTO `sys_district` VALUES ('3269', '和布克赛尔', '477', 'h', 'hbkse', 'hebukesaier', '蒙古', '自治县', '654226', '0901', 7);
INSERT INTO `sys_district` VALUES ('327', '江门', '20', 'j', 'jm', 'jiangmen', '', '市', '440700', '0750', 7);
INSERT INTO `sys_district` VALUES ('3270', '阿勒泰', '478', 'a', 'alt', 'aletai', '', '市', '654301', '0906', 1);
INSERT INTO `sys_district` VALUES ('3271', '布尔津', '478', 'b', 'bej', 'buerjin', '', '县', '654321', '0906', 2);
INSERT INTO `sys_district` VALUES ('3272', '富蕴', '478', 'f', 'fy', 'fuyun', '', '县', '654322', '0906', 3);
INSERT INTO `sys_district` VALUES ('3273', '福海', '478', 'f', 'fh', 'fuhai', '', '县', '654323', '0906', 4);
INSERT INTO `sys_district` VALUES ('3274', '哈巴河', '478', 'h', 'hbh', 'habahe', '', '县', '654324', '0906', 5);
INSERT INTO `sys_district` VALUES ('3275', '青河', '478', 'q', 'qh', 'qinghe', '', '县', '654325', '0906', 6);
INSERT INTO `sys_district` VALUES ('3276', '吉木乃', '478', 'j', 'jmn', 'jimunai', '', '县', '654326', '0906', 7);
INSERT INTO `sys_district` VALUES ('3277', '松山', '485', 's', 'ss', 'songshan', '', '区', '6300100', '02', 1);
INSERT INTO `sys_district` VALUES ('3278', '信义', '485', 'x', 'xy', 'xinyi', '', '区', '6300200', '02', 2);
INSERT INTO `sys_district` VALUES ('3279', '大安', '485', 'd', 'da', 'daan', '', '区', '6300300', '02', 3);
INSERT INTO `sys_district` VALUES ('328', '湛江', '20', 'z', 'zj', 'zhanjiang', '', '市', '440800', '0759', 8);
INSERT INTO `sys_district` VALUES ('3280', '中山', '485', 'z', 'zs', 'zhongshan', '', '区', '6300400', '02', 4);
INSERT INTO `sys_district` VALUES ('3281', '中正', '485', 'z', 'zz', 'zhongzheng', '', '区', '6300500', '02', 5);
INSERT INTO `sys_district` VALUES ('3282', '大同', '485', 'd', 'dt', 'datong', '', '区', '6300600', '02', 6);
INSERT INTO `sys_district` VALUES ('3283', '万华', '485', 'w', 'wh', 'wanhua', '', '区', '6300700', '02', 7);
INSERT INTO `sys_district` VALUES ('3284', '文山', '485', 'w', 'ws', 'wenshan', '', '区', '6300800', '02', 8);
INSERT INTO `sys_district` VALUES ('3285', '南港', '485', 'n', 'ng', 'nangang', '', '区', '6300900', '02', 9);
INSERT INTO `sys_district` VALUES ('3286', '内湖', '485', 'n', 'nh', 'neihu', '', '区', '6301000', '02', 10);
INSERT INTO `sys_district` VALUES ('3287', '士林', '485', 's', 'sl', 'shilin', '', '区', '6301100', '02', 11);
INSERT INTO `sys_district` VALUES ('3288', '北投', '485', 'b', 'bt', 'beitou', '', '区', '6301200', '02', 12);
INSERT INTO `sys_district` VALUES ('3289', '盐埕', '486', 'y', 'yc', 'yancheng', '', '区', '6400100', '07', 1);
INSERT INTO `sys_district` VALUES ('329', '茂名', '20', 'm', 'mm', 'maoming', '', '市', '440900', '0668', 9);
INSERT INTO `sys_district` VALUES ('3290', '鼓山', '486', 'g', 'gs', 'gushan', '', '区', '6400200', '07', 2);
INSERT INTO `sys_district` VALUES ('3291', '左营', '486', 'z', 'zy', 'zuoying', '', '区', '6400300', '07', 3);
INSERT INTO `sys_district` VALUES ('3292', '楠梓', '486', 'n', 'nz', 'nanzi', '', '区', '6400400', '07', 4);
INSERT INTO `sys_district` VALUES ('3293', '三民', '486', 's', 'sm', 'sanmin', '', '区', '6400500', '07', 5);
INSERT INTO `sys_district` VALUES ('3294', '新兴', '486', 'x', 'xx', 'xinxing', '', '区', '6400600', '07', 6);
INSERT INTO `sys_district` VALUES ('3295', '前金', '486', 'q', 'qj', 'qianjin', '', '区', '6400700', '07', 7);
INSERT INTO `sys_district` VALUES ('3296', '苓雅', '486', 'l', 'ly', 'lingya', '', '区', '6400800', '07', 8);
INSERT INTO `sys_district` VALUES ('3297', '前镇', '486', 'q', 'qz', 'qianzhen', '', '区', '6400900', '07', 9);
INSERT INTO `sys_district` VALUES ('3298', '旗津', '486', 'q', 'qj', 'qijin', '', '区', '6401000', '07', 10);
INSERT INTO `sys_district` VALUES ('3299', '小港', '486', 'x', 'xg', 'xiaogang', '', '区', '6401100', '07', 11);
INSERT INTO `sys_district` VALUES ('33', '香港', '0', 'x', 'xg', 'xianggang', '', '特别行政区', '810000', '852', 34);
INSERT INTO `sys_district` VALUES ('330', '肇庆', '20', 'z', 'zq', 'zhaoqing', '', '市', '441200', '0758', 10);
INSERT INTO `sys_district` VALUES ('3300', '中正', '487', 'z', 'zz', 'zhongzheng', '', '区', '1001701', '02', 1);
INSERT INTO `sys_district` VALUES ('3301', '七堵', '487', 'q', 'qd', 'qidu', '', '区', '1001702', '02', 2);
INSERT INTO `sys_district` VALUES ('3302', '暖暖', '487', 'n', 'nn', 'nuannuan', '', '区', '1001703', '02', 3);
INSERT INTO `sys_district` VALUES ('3303', '仁爱', '487', 'r', 'ra', 'renai', '', '区', '1001704', '02', 4);
INSERT INTO `sys_district` VALUES ('3304', '中山', '487', 'z', 'zs', 'zhongshan', '', '区', '1001705', '02', 5);
INSERT INTO `sys_district` VALUES ('3305', '安乐', '487', 'a', 'al', 'anle', '', '区', '1001706', '02', 6);
INSERT INTO `sys_district` VALUES ('3306', '信义', '487', 'x', 'xy', 'xinyi', '', '区', '1001707', '02', 7);
INSERT INTO `sys_district` VALUES ('3307', '大安', '488', 'd', 'da', 'daan', '', '区', '', '04', 1);
INSERT INTO `sys_district` VALUES ('3308', '神冈', '488', 's', 'sg', 'shengang', '', '区', '', '04', 2);
INSERT INTO `sys_district` VALUES ('3309', '石冈', '488', 's', 'sg', 'shigang', '', '区', '', '04', 3);
INSERT INTO `sys_district` VALUES ('331', '惠州', '20', 'h', 'hz', 'huizhou', '', '市', '441300', '0752', 11);
INSERT INTO `sys_district` VALUES ('3310', '东势', '488', 'd', 'ds', 'dongshi', '', '区', '', '04', 4);
INSERT INTO `sys_district` VALUES ('3311', '新社', '488', 'x', 'xs', 'xinshe', '', '区', '', '04', 5);
INSERT INTO `sys_district` VALUES ('3312', '和平', '488', 'h', 'hp', 'heping', '', '区', '', '04', 6);
INSERT INTO `sys_district` VALUES ('3313', '大肚', '488', 'd', 'dd', 'dadu', '', '区', '', '04', 7);
INSERT INTO `sys_district` VALUES ('3314', '沙鹿', '488', 's', 'sl', 'shalu', '', '区', '', '04', 8);
INSERT INTO `sys_district` VALUES ('3315', '龙井', '488', 'l', 'lj', 'longjing', '', '区', '', '04', 9);
INSERT INTO `sys_district` VALUES ('3316', '梧栖', '488', 'w', 'wq', 'wuqi', '', '区', '', '04', 10);
INSERT INTO `sys_district` VALUES ('3317', '清水', '488', 'q', 'qs', 'qingshui', '', '区', '', '04', 11);
INSERT INTO `sys_district` VALUES ('3318', '大甲', '488', 'd', 'dj', 'dajia', '', '区', '', '04', 12);
INSERT INTO `sys_district` VALUES ('3319', '外埔', '488', 'w', 'wp', 'waipu', '', '区', '', '04', 13);
INSERT INTO `sys_district` VALUES ('332', '梅州', '20', 'm', 'mz', 'meizhou', '', '市', '441400', '0753', 12);
INSERT INTO `sys_district` VALUES ('3320', '大雅', '488', 'd', 'dy', 'daya', '', '区', '', '04', 14);
INSERT INTO `sys_district` VALUES ('3321', '潭子', '488', 't', 'tz', 'tanzi', '', '区', '', '04', 15);
INSERT INTO `sys_district` VALUES ('3322', '后里', '488', 'h', 'hl', 'houli', '', '区', '', '04', 16);
INSERT INTO `sys_district` VALUES ('3323', '丰原', '488', 'f', 'fy', 'fengyuan', '', '区', '', '04', 17);
INSERT INTO `sys_district` VALUES ('3324', '乌日', '488', 'w', 'wr', 'wuri', '', '区', '', '04', 18);
INSERT INTO `sys_district` VALUES ('3325', '雾峰', '488', 'w', 'wf', 'wufeng', '', '区', '', '04', 19);
INSERT INTO `sys_district` VALUES ('3326', '大里', '488', 'd', 'dl', 'dali', '', '区', '', '04', 20);
INSERT INTO `sys_district` VALUES ('3327', '太平', '488', 't', 'tp', 'taiping', '', '区', '', '04', 21);
INSERT INTO `sys_district` VALUES ('3328', '中区', '488', 'z', 'zq', 'zhongqu', '', '', '1001901', '04', 22);
INSERT INTO `sys_district` VALUES ('3329', '东区', '488', 'd', 'dq', 'dongqu', '', '', '1001902', '04', 23);
INSERT INTO `sys_district` VALUES ('333', '汕尾', '20', 's', 'sw', 'shanwei', '', '市', '441500', '0660', 13);
INSERT INTO `sys_district` VALUES ('3330', '南区', '488', 'n', 'nq', 'nanqu', '', '', '1001903', '04', 24);
INSERT INTO `sys_district` VALUES ('3331', '西区', '488', 'x', 'xq', 'xiqu', '', '', '1001904', '04', 25);
INSERT INTO `sys_district` VALUES ('3332', '北区', '488', 'b', 'bq', 'beiqu', '', '', '1001905', '04', 26);
INSERT INTO `sys_district` VALUES ('3333', '西屯', '488', 'x', 'xt', 'xitun', '', '区', '1001906', '04', 27);
INSERT INTO `sys_district` VALUES ('3334', '南屯', '488', 'n', 'nt', 'nantun', '', '区', '1001907', '04', 28);
INSERT INTO `sys_district` VALUES ('3335', '北屯', '488', 'b', 'bt', 'beitun', '', '区', '1001908', '04', 29);
INSERT INTO `sys_district` VALUES ('3336', '东区', '489', 'd', 'dq', 'dongqu', '', '', '1002101', '06', 1);
INSERT INTO `sys_district` VALUES ('3337', '南区', '489', 'n', 'nq', 'nanqu', '', '', '1002102', '06', 2);
INSERT INTO `sys_district` VALUES ('3338', '北区', '489', 'b', 'bq', 'beiqu', '', '', '1002104', '06', 3);
INSERT INTO `sys_district` VALUES ('3339', '安南', '489', 'a', 'an', 'annan', '', '区', '1002106', '06', 4);
INSERT INTO `sys_district` VALUES ('334', '河源', '20', 'h', 'hy', 'heyuan', '', '市', '441600', '0762', 14);
INSERT INTO `sys_district` VALUES ('3340', '安平', '489', 'a', 'ap', 'anping', '', '区', '1002107', '06', 5);
INSERT INTO `sys_district` VALUES ('3341', '中西', '489', 'z', 'zx', 'zhongxi', '', '区', '1002108', '06', 6);
INSERT INTO `sys_district` VALUES ('3342', '东区', '490', 'd', 'dq', 'dongqu', '', '', '1001801', '', 1);
INSERT INTO `sys_district` VALUES ('3343', '北区', '490', 'b', 'bq', 'beiqu', '', '', '1001802', '', 2);
INSERT INTO `sys_district` VALUES ('3344', '香山', '490', 'x', 'xs', 'xiangshan', '', '区', '1001803', '', 3);
INSERT INTO `sys_district` VALUES ('3345', '东区', '491', 'd', 'dq', 'dongqu', '', '', '1002001', '05', 1);
INSERT INTO `sys_district` VALUES ('3346', '西区', '491', 'x', 'xq', 'xiqu', '', '', '1002002', '05', 2);
INSERT INTO `sys_district` VALUES ('3347', '板桥', '492', 'b', 'bq', 'banqiao', '', '区', '', '', 1);
INSERT INTO `sys_district` VALUES ('3348', '瑞芳', '492', 'r', 'rf', 'ruifang', '', '区', '', '', 2);
INSERT INTO `sys_district` VALUES ('3349', '八里', '492', 'b', 'bl', 'bali', '', '区', '', '', 3);
INSERT INTO `sys_district` VALUES ('335', '阳江', '20', 'y', 'yj', 'yangjiang', '', '市', '441700', '0662', 15);
INSERT INTO `sys_district` VALUES ('3350', '深坑', '492', 's', 'sk', 'shenkeng', '', '区', '', '', 4);
INSERT INTO `sys_district` VALUES ('3351', '三芝', '492', 's', 'sz', 'sanzhi', '', '区', '', '', 5);
INSERT INTO `sys_district` VALUES ('3352', '金山', '492', 'j', 'js', 'jinshan', '', '区', '', '', 6);
INSERT INTO `sys_district` VALUES ('3353', '万里', '492', 'w', 'wl', 'wanli', '', '区', '', '', 7);
INSERT INTO `sys_district` VALUES ('3354', '贡寮', '492', 'g', 'gl', 'gongliao', '', '区', '', '', 8);
INSERT INTO `sys_district` VALUES ('3355', '石门', '492', 's', 'sm', 'shimen', '', '区', '', '', 9);
INSERT INTO `sys_district` VALUES ('3356', '双溪', '492', 's', 'sx', 'shuangxi', '', '区', '', '', 10);
INSERT INTO `sys_district` VALUES ('3357', '石碇', '492', 's', 'sd', 'shiding', '', '区', '', '', 11);
INSERT INTO `sys_district` VALUES ('3358', '坪林', '492', 'p', 'pl', 'pinglin', '', '区', '', '', 12);
INSERT INTO `sys_district` VALUES ('3359', '乌来', '492', 'w', 'wl', 'wulai', '', '区', '', '', 13);
INSERT INTO `sys_district` VALUES ('336', '清远', '20', 'q', 'qy', 'qingyuan', '', '市', '441800', '0763', 16);
INSERT INTO `sys_district` VALUES ('3360', '泰山', '492', 't', 'ts', 'taishan', '', '区', '', '', 14);
INSERT INTO `sys_district` VALUES ('3361', '五股', '492', 'w', 'wg', 'wugu', '', '区', '', '', 15);
INSERT INTO `sys_district` VALUES ('3362', '莺歌', '492', 'y', 'yg', 'yingge', '', '区', '', '', 16);
INSERT INTO `sys_district` VALUES ('3363', '中和', '492', 'z', 'zh', 'zhonghe', '', '区', '', '', 17);
INSERT INTO `sys_district` VALUES ('3364', '新庄', '492', 'x', 'xz', 'xinzhuang', '', '区', '', '', 18);
INSERT INTO `sys_district` VALUES ('3365', '三重', '492', 's', 'sz', 'sanzhong', '', '区', '', '', 19);
INSERT INTO `sys_district` VALUES ('3366', '新店', '492', 'x', 'xd', 'xindian', '', '区', '', '', 20);
INSERT INTO `sys_district` VALUES ('3367', '土城', '492', 't', 'tc', 'tucheng', '', '区', '', '', 21);
INSERT INTO `sys_district` VALUES ('3368', '永和', '492', 'y', 'yh', 'yonghe', '', '区', '', '', 22);
INSERT INTO `sys_district` VALUES ('3369', '芦洲', '492', 'l', 'lz', 'luzhou', '', '区', '', '', 23);
INSERT INTO `sys_district` VALUES ('337', '东莞', '20', 'd', 'dg', 'dongguan', '', '市', '441900', '0769', 17);
INSERT INTO `sys_district` VALUES ('3370', '汐止', '492', 'x', 'xz', 'xizhi', '', '区', '', '', 24);
INSERT INTO `sys_district` VALUES ('3371', '树林', '492', 's', 'sl', 'shulin', '', '区', '', '', 25);
INSERT INTO `sys_district` VALUES ('3372', '淡水', '492', 'd', 'ds', 'danshui', '', '区', '', '', 26);
INSERT INTO `sys_district` VALUES ('3373', '三峡', '492', 's', 'sx', 'sanxia', '', '区', '', '', 27);
INSERT INTO `sys_district` VALUES ('3374', '林口', '492', 'l', 'lk', 'linkou', '', '区', '', '', 28);
INSERT INTO `sys_district` VALUES ('3375', '平溪', '492', 'p', 'px', 'pingxi', '', '区', '', '', 29);
INSERT INTO `sys_district` VALUES ('3376', '宜兰', '493', 'y', 'yl', 'yilan', '', '市', '1000201', '', 1);
INSERT INTO `sys_district` VALUES ('3377', '罗东', '493', 'l', 'ld', 'luodong', '', '镇', '1000202', '', 2);
INSERT INTO `sys_district` VALUES ('3378', '苏澳', '493', 's', 'sa', 'suao', '', '镇', '1000203', '', 3);
INSERT INTO `sys_district` VALUES ('3379', '头城', '493', 't', 'tc', 'toucheng', '', '乡', '1000204', '', 4);
INSERT INTO `sys_district` VALUES ('338', '中山', '20', 'z', 'zs', 'zhongshan', '', '市', '442000', '0760', 18);
INSERT INTO `sys_district` VALUES ('3380', '礁溪', '493', 'j', 'jx', 'jiaoxi', '', '乡', '1000205', '', 5);
INSERT INTO `sys_district` VALUES ('3381', '壮围', '493', 'z', 'zw', 'zhuangwei', '', '乡', '1000206', '', 6);
INSERT INTO `sys_district` VALUES ('3382', '员山', '493', 'y', 'ys', 'yuanshan', '', '乡', '1000207', '', 7);
INSERT INTO `sys_district` VALUES ('3383', '冬山', '493', 'd', 'ds', 'dongshan', '', '乡', '1000208', '', 8);
INSERT INTO `sys_district` VALUES ('3384', '五结', '493', 'w', 'wj', 'wujie', '', '乡', '1000209', '', 9);
INSERT INTO `sys_district` VALUES ('3385', '三星', '493', 's', 'sx', 'sanxing', '', '乡', '1000210', '', 10);
INSERT INTO `sys_district` VALUES ('3386', '大同', '493', 'd', 'dt', 'datong', '', '乡', '1000211', '', 11);
INSERT INTO `sys_district` VALUES ('3387', '南澳', '493', 'n', 'na', 'nanao', '', '乡', '1000212', '', 12);
INSERT INTO `sys_district` VALUES ('3388', '桃园', '494', 't', 'ty', 'taoyuan', '', '市', '1000301', '', 1);
INSERT INTO `sys_district` VALUES ('3389', '中坜', '494', 'z', 'zl', 'zhongli', '', '市', '1000302', '', 2);
INSERT INTO `sys_district` VALUES ('339', '潮州', '20', 'c', 'cz', 'chaozhou', '', '市', '445100', '0768', 19);
INSERT INTO `sys_district` VALUES ('3390', '大溪', '494', 'd', 'dx', 'daxi', '', '镇', '1000303', '', 3);
INSERT INTO `sys_district` VALUES ('3391', '杨梅', '494', 'y', 'ym', 'yangmei', '', '镇', '1000304', '', 4);
INSERT INTO `sys_district` VALUES ('3392', '芦竹', '494', 'l', 'lz', 'luzhu', '', '乡', '1000305', '', 5);
INSERT INTO `sys_district` VALUES ('3393', '大园', '494', 'd', 'dy', 'dayuan', '', '乡', '1000306', '', 6);
INSERT INTO `sys_district` VALUES ('3394', '龟山', '494', 'g', 'gs', 'guishan', '', '乡', '1000307', '', 7);
INSERT INTO `sys_district` VALUES ('3395', '八德', '494', 'b', 'bd', 'bade', '', '市', '1000308', '', 8);
INSERT INTO `sys_district` VALUES ('3396', '龙潭', '494', 'l', 'lt', 'longtan', '', '乡', '1000309', '', 9);
INSERT INTO `sys_district` VALUES ('3397', '平镇', '494', 'p', 'pz', 'pingzhen', '', '市', '1000310', '', 10);
INSERT INTO `sys_district` VALUES ('3398', '新屋', '494', 'x', 'xw', 'xinwu', '', '乡', '1000311', '', 11);
INSERT INTO `sys_district` VALUES ('3399', '观音', '494', 'g', 'gy', 'guanyin', '', '乡', '1000312', '', 12);
INSERT INTO `sys_district` VALUES ('34', '澳门', '0', 'a', 'am', 'aomen', '', '特别行政区', '820000', '853', 35);
INSERT INTO `sys_district` VALUES ('340', '揭阳', '20', 'j', 'jy', 'jieyang', '', '市', '445200', '0663', 20);
INSERT INTO `sys_district` VALUES ('3400', '复兴', '494', 'f', 'fx', 'fuxing', '', '乡', '1000313', '', 13);
INSERT INTO `sys_district` VALUES ('3401', '竹北', '495', 'z', 'zb', 'zhubei', '', '市', '1000401', '', 1);
INSERT INTO `sys_district` VALUES ('3402', '竹东', '495', 'z', 'zd', 'zhudong', '', '镇', '1000402', '', 2);
INSERT INTO `sys_district` VALUES ('3403', '新埔', '495', 'x', 'xp', 'xinpu', '', '镇', '1000403', '', 3);
INSERT INTO `sys_district` VALUES ('3404', '关西', '495', 'g', 'gx', 'guanxi', '', '镇', '1000404', '', 4);
INSERT INTO `sys_district` VALUES ('3405', '湖口', '495', 'h', 'hk', 'hukou', '', '乡', '1000405', '', 5);
INSERT INTO `sys_district` VALUES ('3406', '新丰', '495', 'x', 'xf', 'xinfeng', '', '乡', '1000406', '', 6);
INSERT INTO `sys_district` VALUES ('3407', '芎林', '495', 'x', 'xl', 'xionglin', '', '乡', '1000407', '', 7);
INSERT INTO `sys_district` VALUES ('3408', '横山', '495', 'h', 'hs', 'hengshan', '', '乡', '1000408', '', 8);
INSERT INTO `sys_district` VALUES ('3409', '北埔', '495', 'b', 'bp', 'beipu', '', '乡', '1000409', '', 9);
INSERT INTO `sys_district` VALUES ('341', '云浮', '20', 'y', 'yf', 'yunfu', '', '市', '445300', '0766', 21);
INSERT INTO `sys_district` VALUES ('3410', '宝山', '495', 'b', 'bs', 'baoshan', '', '乡', '1000410', '', 10);
INSERT INTO `sys_district` VALUES ('3411', '峨眉', '495', 'e', 'em', 'emei', '', '乡', '1000411', '', 11);
INSERT INTO `sys_district` VALUES ('3412', '尖石', '495', 'j', 'js', 'jianshi', '', '乡', '1000412', '', 12);
INSERT INTO `sys_district` VALUES ('3413', '五峰', '495', 'w', 'wf', 'wufeng', '', '乡', '1000413', '', 13);
INSERT INTO `sys_district` VALUES ('3414', '苗栗', '496', 'm', 'ml', 'miaoli', '', '市', '1000501', '', 1);
INSERT INTO `sys_district` VALUES ('3415', '苑里', '496', 'y', 'yl', 'yuanli', '', '镇', '1000502', '', 2);
INSERT INTO `sys_district` VALUES ('3416', '通霄', '496', 't', 'tx', 'tongxiao', '', '镇', '1000503', '', 3);
INSERT INTO `sys_district` VALUES ('3417', '竹南', '496', 'z', 'zn', 'zhunan', '', '镇', '1000504', '', 4);
INSERT INTO `sys_district` VALUES ('3418', '头份', '496', 't', 'tf', 'toufen', '', '镇', '1000505', '', 5);
INSERT INTO `sys_district` VALUES ('3419', '后龙', '496', 'h', 'hl', 'houlong', '', '镇', '1000506', '', 6);
INSERT INTO `sys_district` VALUES ('342', '南宁', '21', 'n', 'nn', 'nanning', '', '市', '450100', '0771', 1);
INSERT INTO `sys_district` VALUES ('3420', '卓兰', '496', 'z', 'zl', 'zhuolan', '', '镇', '1000507', '', 7);
INSERT INTO `sys_district` VALUES ('3421', '大湖', '496', 'd', 'dh', 'dahu', '', '乡', '1000508', '', 8);
INSERT INTO `sys_district` VALUES ('3422', '公馆', '496', 'g', 'gg', 'gongguan', '', '乡', '1000509', '', 9);
INSERT INTO `sys_district` VALUES ('3423', '铜锣', '496', 't', 'tl', 'tongluo', '', '乡', '1000510', '', 10);
INSERT INTO `sys_district` VALUES ('3424', '南庄', '496', 'n', 'nz', 'nanzhuang', '', '乡', '1000511', '', 11);
INSERT INTO `sys_district` VALUES ('3425', '头屋', '496', 't', 'tw', 'touwu', '', '乡', '1000512', '', 12);
INSERT INTO `sys_district` VALUES ('3426', '三义', '496', 's', 'sy', 'sanyi', '', '乡', '1000513', '', 13);
INSERT INTO `sys_district` VALUES ('3427', '西湖', '496', 'x', 'xh', 'xihu', '', '乡', '1000514', '', 14);
INSERT INTO `sys_district` VALUES ('3428', '造桥', '496', 'z', 'zq', 'zaoqiao', '', '乡', '1000515', '', 15);
INSERT INTO `sys_district` VALUES ('3429', '三湾', '496', 's', 'sw', 'sanwan', '', '乡', '1000516', '', 16);
INSERT INTO `sys_district` VALUES ('343', '柳州', '21', 'l', 'lz', 'liuzhou', '', '市', '450200', '0772', 2);
INSERT INTO `sys_district` VALUES ('3430', '狮潭', '496', 's', 'st', 'shitan', '', '乡', '1000517', '', 17);
INSERT INTO `sys_district` VALUES ('3431', '泰安', '496', 't', 'ta', 'taian', '', '乡', '1000518', '', 18);
INSERT INTO `sys_district` VALUES ('3432', '彰化', '497', 'z', 'zh', 'zhanghua', '', '市', '1000701', '', 1);
INSERT INTO `sys_district` VALUES ('3433', '鹿港', '497', 'l', 'lg', 'lugang', '', '镇', '1000702', '', 2);
INSERT INTO `sys_district` VALUES ('3434', '和美', '497', 'h', 'hm', 'hemei', '', '镇', '1000703', '', 3);
INSERT INTO `sys_district` VALUES ('3435', '线西', '497', 'x', 'xx', 'xianxi', '', '乡', '1000704', '', 4);
INSERT INTO `sys_district` VALUES ('3436', '伸港', '497', 's', 'sg', 'shengang', '', '乡', '1000705', '', 5);
INSERT INTO `sys_district` VALUES ('3437', '福兴', '497', 'f', 'fx', 'fuxing', '', '乡', '1000706', '', 6);
INSERT INTO `sys_district` VALUES ('3438', '秀水', '497', 'x', 'xs', 'xiushui', '', '乡', '1000707', '', 7);
INSERT INTO `sys_district` VALUES ('3439', '花坛', '497', 'h', 'ht', 'huatan', '', '乡', '1000708', '', 8);
INSERT INTO `sys_district` VALUES ('344', '桂林', '21', 'g', 'gl', 'guilin', '', '市', '450300', '0773', 3);
INSERT INTO `sys_district` VALUES ('3440', '芬园', '497', 'f', 'fy', 'fenyuan', '', '乡', '1000709', '', 9);
INSERT INTO `sys_district` VALUES ('3441', '员林', '497', 'y', 'yl', 'yuanlin', '', '镇', '1000710', '', 10);
INSERT INTO `sys_district` VALUES ('3442', '溪湖', '497', 'x', 'xh', 'xihu', '', '镇', '1000711', '', 11);
INSERT INTO `sys_district` VALUES ('3443', '田中', '497', 't', 'tz', 'tianzhong', '', '镇', '1000712', '', 12);
INSERT INTO `sys_district` VALUES ('3444', '大村', '497', 'd', 'dc', 'dacun', '', '乡', '1000713', '', 13);
INSERT INTO `sys_district` VALUES ('3445', '埔盐', '497', 'p', 'py', 'puyan', '', '乡', '1000714', '', 14);
INSERT INTO `sys_district` VALUES ('3446', '埔心', '497', 'p', 'px', 'puxin', '', '乡', '1000715', '', 15);
INSERT INTO `sys_district` VALUES ('3447', '永靖', '497', 'y', 'yj', 'yongjing', '', '乡', '1000716', '', 16);
INSERT INTO `sys_district` VALUES ('3448', '社头', '497', 's', 'st', 'shetou', '', '乡', '1000717', '', 17);
INSERT INTO `sys_district` VALUES ('3449', '二水', '497', 'e', 'es', 'ershui', '', '乡', '1000718', '', 18);
INSERT INTO `sys_district` VALUES ('345', '梧州', '21', 'w', 'wz', 'wuzhou', '', '市', '450400', '0774', 4);
INSERT INTO `sys_district` VALUES ('3450', '北斗', '497', 'b', 'bd', 'beidou', '', '镇', '1000719', '', 19);
INSERT INTO `sys_district` VALUES ('3451', '二林', '497', 'e', 'el', 'erlin', '', '镇', '1000720', '', 20);
INSERT INTO `sys_district` VALUES ('3452', '田尾', '497', 't', 'tw', 'tianwei', '', '乡', '1000721', '', 21);
INSERT INTO `sys_district` VALUES ('3453', '埤头', '497', 'p', 'pt', 'pitou', '', '乡', '1000722', '', 22);
INSERT INTO `sys_district` VALUES ('3454', '芳苑', '497', 'f', 'fy', 'fangyuan', '', '乡', '1000723', '', 23);
INSERT INTO `sys_district` VALUES ('3455', '大城', '497', 'd', 'dc', 'dacheng', '', '乡', '1000724', '', 24);
INSERT INTO `sys_district` VALUES ('3456', '竹塘', '497', 'z', 'zt', 'zhutang', '', '乡', '1000725', '', 25);
INSERT INTO `sys_district` VALUES ('3457', '溪州', '497', 'x', 'xz', 'xizhou', '', '乡', '1000726', '', 26);
INSERT INTO `sys_district` VALUES ('3458', '南投', '498', 'n', 'nt', 'nantou', '', '市', '1000801', '', 1);
INSERT INTO `sys_district` VALUES ('3459', '南投', '498', 'n', 'nt', 'nantou', '', '镇', '1000802', '', 2);
INSERT INTO `sys_district` VALUES ('346', '北海', '21', 'b', 'bh', 'beihai', '', '市', '450500', '0779', 5);
INSERT INTO `sys_district` VALUES ('3460', '草屯', '498', 'c', 'ct', 'caotun', '', '镇', '1000803', '', 3);
INSERT INTO `sys_district` VALUES ('3461', '竹山', '498', 'z', 'zs', 'zhushan', '', '镇', '1000804', '', 4);
INSERT INTO `sys_district` VALUES ('3462', '集集', '498', 'j', 'jj', 'jiji', '', '镇', '1000805', '', 5);
INSERT INTO `sys_district` VALUES ('3463', '名间', '498', 'm', 'mj', 'mingjian', '', '乡', '1000806', '', 6);
INSERT INTO `sys_district` VALUES ('3464', '鹿谷', '498', 'l', 'lg', 'lugu', '', '乡', '1000807', '', 7);
INSERT INTO `sys_district` VALUES ('3465', '中寮', '498', 'z', 'zl', 'zhongliao', '', '乡', '1000808', '', 8);
INSERT INTO `sys_district` VALUES ('3466', '鱼池', '498', 'y', 'yc', 'yuchi', '', '乡', '1000809', '', 9);
INSERT INTO `sys_district` VALUES ('3467', '国姓', '498', 'g', 'gx', 'guoxing', '', '乡', '1000810', '', 10);
INSERT INTO `sys_district` VALUES ('3468', '水里', '498', 's', 'sl', 'shuili', '', '乡', '1000811', '', 11);
INSERT INTO `sys_district` VALUES ('3469', '信义', '498', 'x', 'xy', 'xinyi', '', '乡', '1000812', '', 12);
INSERT INTO `sys_district` VALUES ('347', '防城港', '21', 'f', 'fcg', 'fangchenggang', '', '市', '450600', '0770', 6);
INSERT INTO `sys_district` VALUES ('3470', '仁爱', '498', 'r', 'ra', 'renai', '', '乡', '1000813', '', 13);
INSERT INTO `sys_district` VALUES ('3471', '斗六', '499', 'd', 'dl', 'douliu', '', '市', '1000901', '', 1);
INSERT INTO `sys_district` VALUES ('3472', '斗南', '499', 'd', 'dn', 'dounan', '', '镇', '1000902', '', 2);
INSERT INTO `sys_district` VALUES ('3473', '虎尾', '499', 'h', 'hw', 'huwei', '', '镇', '1000903', '', 3);
INSERT INTO `sys_district` VALUES ('3474', '西螺', '499', 'x', 'xl', 'xiluo', '', '镇', '1000904', '', 4);
INSERT INTO `sys_district` VALUES ('3475', '土库', '499', 't', 'tk', 'tuku', '', '镇', '1000905', '', 5);
INSERT INTO `sys_district` VALUES ('3476', '北港', '499', 'b', 'bg', 'beigang', '', '镇', '1000906', '', 6);
INSERT INTO `sys_district` VALUES ('3477', '古坑', '499', 'g', 'gk', 'gukeng', '', '乡', '1000907', '', 7);
INSERT INTO `sys_district` VALUES ('3478', '大埤', '499', 'd', 'dp', 'dapi', '', '乡', '1000908', '', 8);
INSERT INTO `sys_district` VALUES ('3479', '莿桐', '499', 'c', 'ct', 'citong', '', '乡', '1000909', '', 9);
INSERT INTO `sys_district` VALUES ('348', '钦州', '21', 'q', 'qz', 'qinzhou', '', '市', '450700', '0777', 7);
INSERT INTO `sys_district` VALUES ('3480', '林内', '499', 'l', 'ln', 'linnei', '', '乡', '1000910', '', 10);
INSERT INTO `sys_district` VALUES ('3481', '二仑', '499', 'e', 'el', 'erlun', '', '乡', '1000911', '', 11);
INSERT INTO `sys_district` VALUES ('3482', '仑背', '499', 'l', 'lb', 'lunbei', '', '乡', '1000912', '', 12);
INSERT INTO `sys_district` VALUES ('3483', '麦寮', '499', 'm', 'ml', 'mailiao', '', '乡', '1000913', '', 13);
INSERT INTO `sys_district` VALUES ('3484', '东势', '499', 'd', 'ds', 'dongshi', '', '乡', '1000914', '', 14);
INSERT INTO `sys_district` VALUES ('3485', '褒忠', '499', 'b', 'bz', 'baozhong', '', '乡', '1000915', '', 15);
INSERT INTO `sys_district` VALUES ('3486', '台西', '499', 't', 'tx', 'taixi', '', '乡', '1000916', '', 16);
INSERT INTO `sys_district` VALUES ('3487', '元长', '499', 'y', 'yz', 'yuanzhang', '', '乡', '1000917', '', 17);
INSERT INTO `sys_district` VALUES ('3488', '四湖', '499', 's', 'sh', 'sihu', '', '乡', '1000918', '', 18);
INSERT INTO `sys_district` VALUES ('3489', '口湖', '499', 'k', 'kh', 'kouhu', '', '乡', '1000919', '', 19);
INSERT INTO `sys_district` VALUES ('349', '贵港', '21', 'g', 'gg', 'guigang', '', '市', '450800', '0775', 8);
INSERT INTO `sys_district` VALUES ('3490', '水林', '499', 's', 'sl', 'shuilin', '', '乡', '1000920', '', 20);
INSERT INTO `sys_district` VALUES ('3491', '太保', '500', 't', 'tb', 'taibao', '', '市', '', '', 1);
INSERT INTO `sys_district` VALUES ('3492', '朴子', '500', 'p', 'pz', 'pozi', '', '市', '', '', 2);
INSERT INTO `sys_district` VALUES ('3493', '布袋', '500', 'b', 'bd', 'budai', '', '镇', '', '', 3);
INSERT INTO `sys_district` VALUES ('3494', '大林', '500', 'd', 'dl', 'dalin', '', '镇', '10010', '', 4);
INSERT INTO `sys_district` VALUES ('3495', '民雄', '500', 'm', 'mx', 'minxiong', '', '乡', '1001001', '', 5);
INSERT INTO `sys_district` VALUES ('3496', '溪口', '500', 'x', 'xk', 'xikou', '', '乡', '1001002', '', 6);
INSERT INTO `sys_district` VALUES ('3497', '新港', '500', 'x', 'xg', 'xingang', '', '乡', '1001003', '', 7);
INSERT INTO `sys_district` VALUES ('3498', '六脚', '500', 'l', 'lj', 'liujiao', '', '乡', '1001004', '', 8);
INSERT INTO `sys_district` VALUES ('3499', '东石', '500', 'd', 'ds', 'dongshi', '', '乡', '1001005', '', 9);
INSERT INTO `sys_district` VALUES ('350', '玉林', '21', 'y', 'yl', 'yulin', '', '市', '450900', '0775', 9);
INSERT INTO `sys_district` VALUES ('3500', '义竹', '500', 'y', 'yz', 'yizhu', '', '乡', '1001006', '', 10);
INSERT INTO `sys_district` VALUES ('3501', '鹿草', '500', 'l', 'lc', 'lucao', '', '乡', '1001007', '', 11);
INSERT INTO `sys_district` VALUES ('3502', '水上', '500', 's', 'ss', 'shuishang', '', '乡', '1001008', '', 12);
INSERT INTO `sys_district` VALUES ('3503', '中埔', '500', 'z', 'zp', 'zhongpu', '', '乡', '1001009', '', 13);
INSERT INTO `sys_district` VALUES ('3504', '竹崎', '500', 'z', 'zq', 'zhuqi', '', '乡', '1001010', '', 14);
INSERT INTO `sys_district` VALUES ('3505', '梅山', '500', 'm', 'ms', 'meishan', '', '乡', '1001011', '', 15);
INSERT INTO `sys_district` VALUES ('3506', '番路', '500', 'f', 'fl', 'fanlu', '', '乡', '1001012', '', 16);
INSERT INTO `sys_district` VALUES ('3507', '大埔', '500', 'd', 'dp', 'dapu', '', '乡', '1001013', '', 17);
INSERT INTO `sys_district` VALUES ('3508', '阿里山', '500', 'a', 'als', 'alishan', '', '乡', '1001014', '', 18);
INSERT INTO `sys_district` VALUES ('3509', '屏东', '501', 'p', 'pd', 'pingdong', '', '市', '1001301', '', 1);
INSERT INTO `sys_district` VALUES ('351', '百色', '21', 'b', 'bs', 'baise', '', '市', '451000', '0776', 10);
INSERT INTO `sys_district` VALUES ('3510', '潮州', '501', 'c', 'cz', 'chaozhou', '', '镇', '1001302', '', 2);
INSERT INTO `sys_district` VALUES ('3511', '东港', '501', 'd', 'dg', 'donggang', '', '镇', '1001303', '', 3);
INSERT INTO `sys_district` VALUES ('3512', '恒春', '501', 'h', 'hc', 'hengchun', '', '镇', '1001304', '', 4);
INSERT INTO `sys_district` VALUES ('3513', '万丹', '501', 'w', 'wd', 'wandan', '', '乡', '1001305', '', 5);
INSERT INTO `sys_district` VALUES ('3514', '长治', '501', 'z', 'zz', 'zhangzhi', '', '乡', '1001306', '', 6);
INSERT INTO `sys_district` VALUES ('3515', '麟洛', '501', 'l', 'll', 'linluo', '', '乡', '1001307', '', 7);
INSERT INTO `sys_district` VALUES ('3516', '九如', '501', 'j', 'jr', 'jiuru', '', '乡', '1001308', '', 8);
INSERT INTO `sys_district` VALUES ('3517', '里港', '501', 'l', 'lg', 'ligang', '', '乡', '1001309', '', 9);
INSERT INTO `sys_district` VALUES ('3518', '盐埔', '501', 'y', 'yp', 'yanpu', '', '乡', '1001310', '', 10);
INSERT INTO `sys_district` VALUES ('3519', '高树', '501', 'g', 'gs', 'gaoshu', '', '乡', '1001311', '', 11);
INSERT INTO `sys_district` VALUES ('352', '贺州', '21', 'h', 'hz', 'hezhou', '', '市', '451100', '0774', 11);
INSERT INTO `sys_district` VALUES ('3520', '万峦', '501', 'w', 'wl', 'wanluan', '', '乡', '1001312', '', 12);
INSERT INTO `sys_district` VALUES ('3521', '内埔', '501', 'n', 'np', 'neipu', '', '乡', '1001313', '', 13);
INSERT INTO `sys_district` VALUES ('3522', '竹田', '501', 'z', 'zt', 'zhutian', '', '乡', '1001314', '', 14);
INSERT INTO `sys_district` VALUES ('3523', '新埤', '501', 'x', 'xp', 'xinpi', '', '乡', '1001315', '', 15);
INSERT INTO `sys_district` VALUES ('3524', '枋寮', '501', 'f', 'fl', 'fangliao', '', '乡', '1001316', '', 16);
INSERT INTO `sys_district` VALUES ('3525', '新园', '501', 'x', 'xy', 'xinyuan', '', '乡', '1001317', '', 17);
INSERT INTO `sys_district` VALUES ('3526', '崁顶', '501', 'k', 'kd', 'kanding', '', '乡', '1001318', '', 18);
INSERT INTO `sys_district` VALUES ('3527', '林边', '501', 'l', 'lb', 'linbian', '', '乡', '1001319', '', 19);
INSERT INTO `sys_district` VALUES ('3528', '南州', '501', 'n', 'nz', 'nanzhou', '', '乡', '1001320', '', 20);
INSERT INTO `sys_district` VALUES ('3529', '佳冬', '501', 'j', 'jd', 'jiadong', '', '乡', '1001321', '', 21);
INSERT INTO `sys_district` VALUES ('353', '河池', '21', 'h', 'hc', 'hechi', '', '市', '451200', '0778', 12);
INSERT INTO `sys_district` VALUES ('3530', '琉球', '501', 'l', 'lq', 'liuqiu', '', '乡', '1001322', '', 22);
INSERT INTO `sys_district` VALUES ('3531', '车城', '501', 'c', 'cc', 'checheng', '', '乡', '1001323', '', 23);
INSERT INTO `sys_district` VALUES ('3532', '满州', '501', 'm', 'mz', 'manzhou', '', '乡', '1001324', '', 24);
INSERT INTO `sys_district` VALUES ('3533', '枋山', '501', 'f', 'fs', 'fangshan', '', '乡', '1001325', '', 25);
INSERT INTO `sys_district` VALUES ('3534', '三地门', '501', 's', 'sdm', 'sandimen', '', '乡', '1001326', '', 26);
INSERT INTO `sys_district` VALUES ('3535', '雾台', '501', 'w', 'wt', 'wutai', '', '乡', '1001327', '', 27);
INSERT INTO `sys_district` VALUES ('3536', '玛家', '501', 'm', 'mj', 'majia', '', '乡', '1001328', '', 28);
INSERT INTO `sys_district` VALUES ('3537', '泰武', '501', 't', 'tw', 'taiwu', '', '乡', '1001329', '', 29);
INSERT INTO `sys_district` VALUES ('3538', '来义', '501', 'l', 'ly', 'laiyi', '', '乡', '1001330', '', 30);
INSERT INTO `sys_district` VALUES ('3539', '春日', '501', 'c', 'cr', 'chunri', '', '乡', '1001331', '', 31);
INSERT INTO `sys_district` VALUES ('354', '来宾', '21', 'l', 'lb', 'laibin', '', '市', '451300', '0772', 13);
INSERT INTO `sys_district` VALUES ('3540', '狮子', '501', 's', 'sz', 'shizi', '', '乡', '1001332', '', 32);
INSERT INTO `sys_district` VALUES ('3541', '牡丹', '501', 'm', 'md', 'mudan', '', '乡', '1001333', '', 33);
INSERT INTO `sys_district` VALUES ('3542', '卑南', '502', 'b', 'bn', 'beinan', '', '乡', '', '', 1);
INSERT INTO `sys_district` VALUES ('3543', '台东', '502', 't', 'td', 'taidong', '', '市', '1001401', '', 2);
INSERT INTO `sys_district` VALUES ('3544', '成功', '502', 'c', 'cg', 'chenggong', '', '镇', '1001402', '', 3);
INSERT INTO `sys_district` VALUES ('3545', '关山', '502', 'g', 'gs', 'guanshan', '', '镇', '1001403', '', 4);
INSERT INTO `sys_district` VALUES ('3546', '鹿野', '502', 'l', 'ly', 'luye', '', '乡', '1001405', '', 5);
INSERT INTO `sys_district` VALUES ('3547', '池上', '502', 'c', 'cs', 'chishang', '', '乡', '1001406', '', 6);
INSERT INTO `sys_district` VALUES ('3548', '东河', '502', 'd', 'dh', 'donghe', '', '乡', '1001407', '', 7);
INSERT INTO `sys_district` VALUES ('3549', '长滨', '502', 'z', 'zb', 'zhangbin', '', '乡', '1001408', '', 8);
INSERT INTO `sys_district` VALUES ('355', '崇左', '21', 'c', 'cz', 'chongzuo', '', '市', '451400', '0771', 14);
INSERT INTO `sys_district` VALUES ('3550', '太麻里', '502', 't', 'tml', 'taimali', '', '乡', '1001409', '', 9);
INSERT INTO `sys_district` VALUES ('3551', '大武', '502', 'd', 'dw', 'dawu', '', '乡', '1001410', '', 10);
INSERT INTO `sys_district` VALUES ('3552', '绿岛', '502', 'l', 'ld', 'lu:dao', '', '乡', '1001411', '', 11);
INSERT INTO `sys_district` VALUES ('3553', '海端', '502', 'h', 'hd', 'haiduan', '', '乡', '1001412', '', 12);
INSERT INTO `sys_district` VALUES ('3554', '延平', '502', 'y', 'yp', 'yanping', '', '乡', '1001413', '', 13);
INSERT INTO `sys_district` VALUES ('3555', '金峰', '502', 'j', 'jf', 'jinfeng', '', '乡', '1001414', '', 14);
INSERT INTO `sys_district` VALUES ('3556', '达仁', '502', 'd', 'dr', 'daren', '', '乡', '1001415', '', 15);
INSERT INTO `sys_district` VALUES ('3557', '兰屿', '502', 'l', 'ly', 'lanyu', '', '乡', '1001416', '', 16);
INSERT INTO `sys_district` VALUES ('3558', '花莲', '503', 'h', 'hl', 'hualian', '', '市', '1001501', '', 1);
INSERT INTO `sys_district` VALUES ('3559', '凤林', '503', 'f', 'fl', 'fenglin', '', '镇', '1001502', '', 2);
INSERT INTO `sys_district` VALUES ('356', '海口', '22', 'h', 'hk', 'haikou', '', '市', '460100', '0898', 1);
INSERT INTO `sys_district` VALUES ('3560', '玉里', '503', 'y', 'yl', 'yuli', '', '镇', '1001503', '', 3);
INSERT INTO `sys_district` VALUES ('3561', '新城', '503', 'x', 'xc', 'xincheng', '', '乡', '1001504', '', 4);
INSERT INTO `sys_district` VALUES ('3562', '吉安', '503', 'j', 'ja', 'jian', '', '乡', '1001505', '', 5);
INSERT INTO `sys_district` VALUES ('3563', '寿丰', '503', 's', 'sf', 'shoufeng', '', '乡', '1001506', '', 6);
INSERT INTO `sys_district` VALUES ('3564', '光复', '503', 'g', 'gf', 'guangfu', '', '乡', '1001507', '', 7);
INSERT INTO `sys_district` VALUES ('3565', '丰滨', '503', 'f', 'fb', 'fengbin', '', '乡', '1001508', '', 8);
INSERT INTO `sys_district` VALUES ('3566', '瑞穗', '503', 'r', 'rs', 'ruisui', '', '乡', '1001509', '', 9);
INSERT INTO `sys_district` VALUES ('3567', '富里', '503', 'f', 'fl', 'fuli', '', '乡', '1001510', '', 10);
INSERT INTO `sys_district` VALUES ('3568', '秀林', '503', 'x', 'xl', 'xiulin', '', '乡', '1001511', '', 11);
INSERT INTO `sys_district` VALUES ('3569', '万荣', '503', 'w', 'wr', 'wanrong', '', '乡', '1001512', '', 12);
INSERT INTO `sys_district` VALUES ('357', '三亚', '22', 's', 'sy', 'sanya', '', '市', '460200', '0898', 2);
INSERT INTO `sys_district` VALUES ('3570', '卓溪', '503', 'z', 'zx', 'zhuoxi', '', '乡', '1001513', '', 13);
INSERT INTO `sys_district` VALUES ('3571', '马公', '504', 'm', 'mg', 'magong', '', '市', '1001601', '07', 1);
INSERT INTO `sys_district` VALUES ('3572', '湖西', '504', 'h', 'hx', 'huxi', '', '乡', '1001602', '07', 2);
INSERT INTO `sys_district` VALUES ('3573', '白沙', '504', 'b', 'bs', 'baisha', '', '乡', '1001603', '07', 3);
INSERT INTO `sys_district` VALUES ('3574', '西屿', '504', 'x', 'xy', 'xiyu', '', '乡', '1001604', '07', 4);
INSERT INTO `sys_district` VALUES ('3575', '望安', '504', 'w', 'wa', 'wangan', '', '乡', '1001605', '07', 5);
INSERT INTO `sys_district` VALUES ('3576', '七美', '504', 'q', 'qm', 'qimei', '', '乡', '1001606', '07', 6);
INSERT INTO `sys_district` VALUES ('3577', '双河', '31', 's', 'sh', 'shuanghe', '', '市', '659007', '0909', 21);
INSERT INTO `sys_district` VALUES ('3578', '海棠', '357', 'h', 'ht', 'haitang', '', '区', '', '0898', 1);
INSERT INTO `sys_district` VALUES ('3579', '吉阳', '357', 'j', 'jy', 'jiyang', '', '区', '', '0898', 2);
INSERT INTO `sys_district` VALUES ('358', '三沙', '22', 's', 'ss', 'sansha', '', '市', '460300', '0898', 3);
INSERT INTO `sys_district` VALUES ('3580', '天涯', '357', 't', 'ty', 'tianya', '', '区', '', '0898', 3);
INSERT INTO `sys_district` VALUES ('3581', '崖州', '357', 'y', 'yz', 'yazhou', '', '区', '', '0898', 4);
INSERT INTO `sys_district` VALUES ('3582', '霍尔果斯', '476', 'h', 'hegs', 'huoerguosi', '', '市', '654004', '0999', 3);
INSERT INTO `sys_district` VALUES ('3583', '前锋', '388', 'q', 'qf', 'qianfeng', '', '区', '', '0826', 2);
INSERT INTO `sys_district` VALUES ('3584', '福绵', '350', 'f', 'fm', 'fumian', '', '区', '450903', '0775', 2);
INSERT INTO `sys_district` VALUES ('3585', '可克达拉', '31', 'k', 'kdkl', 'kedakela', '', '市', '659008', '0999', 22);
INSERT INTO `sys_district` VALUES ('359', '五指山', '22', 'w', 'wzs', 'wuzhishan', '', '市', '469001', '0898', 4);
INSERT INTO `sys_district` VALUES ('36', '东城', '1', 'd', 'dc', 'dongcheng', '', '区', '110101', '010', 1);
INSERT INTO `sys_district` VALUES ('360', '琼海', '22', 'q', 'qh', 'qionghai', '', '市', '469002', '0898', 5);
INSERT INTO `sys_district` VALUES ('361', '儋州', '22', 'd', 'dz', 'danzhou', '', '市', '460400', '0898', 6);
INSERT INTO `sys_district` VALUES ('362', '文昌', '22', 'w', 'wc', 'wenchang', '', '市', '469005', '0898', 7);
INSERT INTO `sys_district` VALUES ('363', '万宁', '22', 'w', 'wn', 'wanning', '', '市', '469006', '0898', 8);
INSERT INTO `sys_district` VALUES ('364', '东方', '22', 'd', 'df', 'dongfang', '', '市', '469007', '0898', 9);
INSERT INTO `sys_district` VALUES ('365', '定安', '22', 'd', 'da', 'dingan', '', '县', '469025', '0898', 10);
INSERT INTO `sys_district` VALUES ('366', '屯昌', '22', 't', 'tc', 'tunchang', '', '县', '469026', '0898', 11);
INSERT INTO `sys_district` VALUES ('367', '澄迈', '22', 'c', 'cm', 'chengmai', '', '县', '469027', '0898', 12);
INSERT INTO `sys_district` VALUES ('368', '临高', '22', 'l', 'lg', 'lingao', '', '县', '469028', '0898', 13);
INSERT INTO `sys_district` VALUES ('369', '白沙', '22', 'b', 'bs', 'baisha', '黎族', '自治县', '469030', '0898', 14);
INSERT INTO `sys_district` VALUES ('37', '西城', '1', 'x', 'xc', 'xicheng', '', '区', '110102', '010', 2);
INSERT INTO `sys_district` VALUES ('370', '昌江', '22', 'c', 'cj', 'changjiang', '黎族', '自治县', '469031', '0898', 15);
INSERT INTO `sys_district` VALUES ('371', '乐东', '22', 'l', 'ld', 'ledong', '黎族', '自治县', '469033', '0898', 16);
INSERT INTO `sys_district` VALUES ('372', '陵水', '22', 'l', 'ls', 'lingshui', '黎族', '自治县', '469034', '0898', 17);
INSERT INTO `sys_district` VALUES ('373', '保亭', '22', 'b', 'bt', 'baoting', '黎族苗族', '自治县', '469035', '0898', 18);
INSERT INTO `sys_district` VALUES ('374', '琼中', '22', 'q', 'qz', 'qiongzhong', '黎族苗族', '自治县', '469036', '0898', 19);
INSERT INTO `sys_district` VALUES ('375', '成都', '23', 'c', 'cd', 'chengdu', '', '市', '510100', '028', 1);
INSERT INTO `sys_district` VALUES ('376', '自贡', '23', 'z', 'zg', 'zigong', '', '市', '510300', '0813', 2);
INSERT INTO `sys_district` VALUES ('377', '攀枝花', '23', 'p', 'pzh', 'panzhihua', '', '市', '510400', '0812', 3);
INSERT INTO `sys_district` VALUES ('378', '泸州', '23', 'l', 'lz', 'luzhou', '', '市', '510500', '0830', 4);
INSERT INTO `sys_district` VALUES ('379', '德阳', '23', 'd', 'dy', 'deyang', '', '市', '510600', '0838', 5);
INSERT INTO `sys_district` VALUES ('380', '绵阳', '23', 'm', 'my', 'mianyang', '', '市', '510700', '0816', 6);
INSERT INTO `sys_district` VALUES ('381', '广元', '23', 'g', 'gy', 'guangyuan', '', '市', '510800', '0839', 7);
INSERT INTO `sys_district` VALUES ('382', '遂宁', '23', 's', 'sn', 'suining', '', '市', '510900', '0825', 8);
INSERT INTO `sys_district` VALUES ('383', '内江', '23', 'n', 'nj', 'neijiang', '', '市', '511000', '', 9);
INSERT INTO `sys_district` VALUES ('384', '乐山', '23', 'l', 'ls', 'leshan', '', '市', '511100', '0833', 10);
INSERT INTO `sys_district` VALUES ('385', '南充', '23', 'n', 'nc', 'nanchong', '', '市', '511300', '0817', 11);
INSERT INTO `sys_district` VALUES ('386', '眉山', '23', 'm', 'ms', 'meishan', '', '市', '511400', '028', 12);
INSERT INTO `sys_district` VALUES ('387', '宜宾', '23', 'y', 'yb', 'yibin', '', '市', '511500', '0831', 13);
INSERT INTO `sys_district` VALUES ('388', '广安', '23', 'g', 'ga', 'guangan', '', '市', '511600', '0826', 14);
INSERT INTO `sys_district` VALUES ('389', '达州', '23', 'd', 'dz', 'dazhou', '', '市', '511700', '0818', 15);
INSERT INTO `sys_district` VALUES ('390', '雅安', '23', 'y', 'ya', 'yaan', '', '市', '511800', '0835', 16);
INSERT INTO `sys_district` VALUES ('391', '巴中', '23', 'b', 'bz', 'bazhong', '', '市', '511900', '0827', 17);
INSERT INTO `sys_district` VALUES ('392', '资阳', '23', 'z', 'zy', 'ziyang', '', '市', '512000', '028', 18);
INSERT INTO `sys_district` VALUES ('393', '阿坝', '23', 'a', 'ab', 'aba', '藏族羌族', '自治州', '513200', '0837', 19);
INSERT INTO `sys_district` VALUES ('394', '甘孜', '23', 'g', 'gz', 'ganzi', '藏族', '自治州', '513300', '0836', 20);
INSERT INTO `sys_district` VALUES ('395', '凉山', '23', 'l', 'ls', 'liangshan', '彝族', '自治州', '615000', '0834', 21);
INSERT INTO `sys_district` VALUES ('396', '贵阳', '24', 'g', 'gy', 'guiyang', '', '市', '520100', '0851', 1);
INSERT INTO `sys_district` VALUES ('397', '六盘水', '24', 'l', 'lps', 'liupanshui', '', '市', '520200', '0858', 2);
INSERT INTO `sys_district` VALUES ('398', '遵义', '24', 'z', 'zy', 'zunyi', '', '市', '520300', '0852', 3);
INSERT INTO `sys_district` VALUES ('399', '安顺', '24', 'a', 'as', 'anshun', '', '市', '520400', '0853', 4);
INSERT INTO `sys_district` VALUES ('4', '重庆', '0', 'c', 'cq', 'chongqing', '', '市', '500000', '023', 5);
INSERT INTO `sys_district` VALUES ('40', '朝阳', '1', 'c', 'cy', 'chaoyang', '', '区', '110105', '010', 5);
INSERT INTO `sys_district` VALUES ('400', '毕节', '24', 'b', 'bj', 'bijie', '', '市', '520500', '0857', 5);
INSERT INTO `sys_district` VALUES ('401', '铜仁', '24', 't', 'tr', 'tongren', '', '市', '520600', '0856', 6);
INSERT INTO `sys_district` VALUES ('402', '黔西南', '24', 'q', 'qxn', 'qianxinan', '布依族苗族', '自治州', '522300', '0859', 7);
INSERT INTO `sys_district` VALUES ('403', '黔东南', '24', 'q', 'qdn', 'qiandongnan', '苗族侗族', '自治州', '522600', '0855', 8);
INSERT INTO `sys_district` VALUES ('404', '黔南', '24', 'q', 'qn', 'qiannan', '布依族苗族', '自治州', '522700', '0854', 9);
INSERT INTO `sys_district` VALUES ('405', '昆明', '25', 'k', 'km', 'kunming', '', '市', '530100', '0871', 1);
INSERT INTO `sys_district` VALUES ('406', '曲靖', '25', 'q', 'qj', 'qujing', '', '市', '530300', '0874', 2);
INSERT INTO `sys_district` VALUES ('407', '玉溪', '25', 'y', 'yx', 'yuxi', '', '市', '530400', '0877', 3);
INSERT INTO `sys_district` VALUES ('408', '昭通', '25', 'z', 'zt', 'zhaotong', '', '市', '530600', '0870', 4);
INSERT INTO `sys_district` VALUES ('409', '丽江', '25', 'l', 'lj', 'lijiang', '', '市', '530700', '0888', 5);
INSERT INTO `sys_district` VALUES ('41', '丰台', '1', 'f', 'ft', 'fengtai', '', '区', '110106', '010', 6);
INSERT INTO `sys_district` VALUES ('410', '普洱', '25', 'p', 'pe', 'puer', '', '市', '530800', '0879', 6);
INSERT INTO `sys_district` VALUES ('411', '临沧', '25', 'l', 'lc', 'lincang', '', '市', '530900', '0883', 7);
INSERT INTO `sys_district` VALUES ('412', '楚雄', '25', 'c', 'cx', 'chuxiong', '彝族', '自治州', '532300', '0878', 8);
INSERT INTO `sys_district` VALUES ('413', '红河', '25', 'h', 'hh', 'honghe', '哈尼族彝族', '自治州', '532500', '0873', 9);
INSERT INTO `sys_district` VALUES ('414', '文山', '25', 'w', 'ws', 'wenshan', '壮族苗族', '自治州', '532600', '0876', 10);
INSERT INTO `sys_district` VALUES ('415', '西双版纳', '25', 'x', 'xsbn', 'xishuangbanna', '傣族', '自治州', '532800', '0691', 11);
INSERT INTO `sys_district` VALUES ('416', '大理', '25', 'd', 'dl', 'dali', '白族', '自治州', '532900', '0872', 12);
INSERT INTO `sys_district` VALUES ('417', '德宏', '25', 'd', 'dh', 'dehong', '傣族景颇族', '自治州', '533100', '0692', 13);
INSERT INTO `sys_district` VALUES ('418', '怒江', '25', 'n', 'nj', 'nujiang', '傈僳族', '自治州', '533300', '0886', 14);
INSERT INTO `sys_district` VALUES ('419', '迪庆', '25', 'd', 'dq', 'diqing', '藏族', '自治州', '533400', '0887', 15);
INSERT INTO `sys_district` VALUES ('42', '石景山', '1', 's', 'sjs', 'shijingshan', '', '区', '110107', '010', 7);
INSERT INTO `sys_district` VALUES ('420', '保山', '25', 'b', 'bs', 'baoshan', '', '市', '678000', '0875', 16);
INSERT INTO `sys_district` VALUES ('421', '拉萨', '26', 'l', 'ls', 'lasa', '', '市', '540100', '0891', 1);
INSERT INTO `sys_district` VALUES ('422', '昌都', '26', 'c', 'cd', 'changdu', '', '市', '542100', '0895', 2);
INSERT INTO `sys_district` VALUES ('423', '山南', '26', 's', 'sn', 'shannan', '', '市', '542200', '0893', 3);
INSERT INTO `sys_district` VALUES ('424', '日喀则', '26', 'r', 'rkz', 'rikaze', '', '市', '542300', '0892', 4);
INSERT INTO `sys_district` VALUES ('425', '那曲', '26', 'n', 'nq', 'neiqu', '', '地区', '542400', '0896', 5);
INSERT INTO `sys_district` VALUES ('426', '阿里', '26', 'a', 'al', 'ali', '', '地区', '542500', '0897', 6);
INSERT INTO `sys_district` VALUES ('427', '林芝', '26', 'l', 'lz', 'linzhi', '', '市', '540400', '0894', 7);
INSERT INTO `sys_district` VALUES ('428', '西安', '27', 'x', 'xa', 'xian', '', '市', '610100', '029', 1);
INSERT INTO `sys_district` VALUES ('429', '铜川', '27', 't', 'tc', 'tongchuan', '', '市', '610200', '0919', 2);
INSERT INTO `sys_district` VALUES ('43', '海淀', '1', 'h', 'hd', 'haidian', '', '区', '110108', '010', 8);
INSERT INTO `sys_district` VALUES ('430', '宝鸡', '27', 'b', 'bj', 'baoji', '', '市', '610300', '0917', 3);
INSERT INTO `sys_district` VALUES ('431', '咸阳', '27', 'x', 'xy', 'xianyang', '', '市', '610400', '029', 4);
INSERT INTO `sys_district` VALUES ('432', '渭南', '27', 'w', 'wn', 'weinan', '', '市', '610500', '0913', 5);
INSERT INTO `sys_district` VALUES ('433', '延安', '27', 'y', 'ya', 'yanan', '', '市', '610600', '0911', 6);
INSERT INTO `sys_district` VALUES ('434', '汉中', '27', 'h', 'hz', 'hanzhong', '', '市', '610700', '0916', 7);
INSERT INTO `sys_district` VALUES ('435', '榆林', '27', 'y', 'yl', 'yulin', '', '市', '610800', '0912', 8);
INSERT INTO `sys_district` VALUES ('436', '安康', '27', 'a', 'ak', 'ankang', '', '市', '610900', '0915', 9);
INSERT INTO `sys_district` VALUES ('437', '商洛', '27', 's', 'sl', 'shangluo', '', '市', '611000', '0914', 10);
INSERT INTO `sys_district` VALUES ('438', '兰州', '28', 'l', 'lz', 'lanzhou', '', '市', '620100', '0931', 1);
INSERT INTO `sys_district` VALUES ('439', '嘉峪关', '28', 'j', 'jyg', 'jiayuguan', '', '市', '620200', '0937', 2);
INSERT INTO `sys_district` VALUES ('44', '门头沟', '1', 'm', 'mtg', 'mentougou', '', '区', '110109', '010', 9);
INSERT INTO `sys_district` VALUES ('440', '金昌', '28', 'j', 'jc', 'jinchang', '', '市', '620300', '0935', 3);
INSERT INTO `sys_district` VALUES ('441', '白银', '28', 'b', 'by', 'baiyin', '', '市', '620400', '0943', 4);
INSERT INTO `sys_district` VALUES ('442', '天水', '28', 't', 'ts', 'tianshui', '', '市', '620500', '0938', 5);
INSERT INTO `sys_district` VALUES ('443', '武威', '28', 'w', 'ww', 'wuwei', '', '市', '620600', '0935', 6);
INSERT INTO `sys_district` VALUES ('444', '张掖', '28', 'z', 'zy', 'zhangye', '', '市', '620700', '0936', 7);
INSERT INTO `sys_district` VALUES ('445', '平凉', '28', 'p', 'pl', 'pingliang', '', '市', '620800', '0933', 8);
INSERT INTO `sys_district` VALUES ('446', '酒泉', '28', 'j', 'jq', 'jiuquan', '', '市', '620900', '0937', 9);
INSERT INTO `sys_district` VALUES ('447', '庆阳', '28', 'q', 'qy', 'qingyang', '', '市', '621000', '0934', 10);
INSERT INTO `sys_district` VALUES ('448', '定西', '28', 'd', 'dx', 'dingxi', '', '市', '621100', '0932', 11);
INSERT INTO `sys_district` VALUES ('449', '陇南', '28', 'l', 'ln', 'longnan', '', '市', '621200', '0939', 12);
INSERT INTO `sys_district` VALUES ('45', '房山', '1', 'f', 'fs', 'fangshan', '', '区', '110111', '010', 10);
INSERT INTO `sys_district` VALUES ('450', '临夏', '28', 'l', 'lx', 'linxia', '回族', '自治州', '622900', '0930', 13);
INSERT INTO `sys_district` VALUES ('451', '甘南', '28', 'g', 'gn', 'gannan', '藏族', '自治州', '623000', '0941', 14);
INSERT INTO `sys_district` VALUES ('452', '西宁', '29', 'x', 'xn', 'xining', '', '市', '630100', '0971', 1);
INSERT INTO `sys_district` VALUES ('453', '海东', '29', 'h', 'hd', 'haidong', '', '市', '632100', '0972', 2);
INSERT INTO `sys_district` VALUES ('454', '海北', '29', 'h', 'hb', 'haibei', '藏族', '自治州', '632200', '0970', 3);
INSERT INTO `sys_district` VALUES ('455', '黄南', '29', 'h', 'hn', 'huangnan', '藏族', '自治州', '632300', '0973', 4);
INSERT INTO `sys_district` VALUES ('456', '海南', '29', 'h', 'hn', 'hainan', '藏族', '自治州', '632500', '0974', 5);
INSERT INTO `sys_district` VALUES ('457', '果洛', '29', 'g', 'gl', 'guoluo', '藏族', '自治州', '632600', '0975', 6);
INSERT INTO `sys_district` VALUES ('458', '玉树', '29', 'y', 'ys', 'yushu', '藏族', '自治州', '632700', '0976', 7);
INSERT INTO `sys_district` VALUES ('459', '海西', '29', 'h', 'hx', 'haixi', '蒙古族藏族', '自治州', '632800', '0977', 8);
INSERT INTO `sys_district` VALUES ('46', '通州', '1', 't', 'tz', 'tongzhou', '', '区', '110112', '010', 11);
INSERT INTO `sys_district` VALUES ('460', '银川', '30', 'y', 'yc', 'yinchuan', '', '市', '640100', '0951', 1);
INSERT INTO `sys_district` VALUES ('461', '石嘴山', '30', 's', 'szs', 'shizuishan', '', '市', '640200', '0952', 2);
INSERT INTO `sys_district` VALUES ('462', '吴忠', '30', 'w', 'wz', 'wuzhong', '', '市', '640300', '0953', 3);
INSERT INTO `sys_district` VALUES ('463', '固原', '30', 'g', 'gy', 'guyuan', '', '市', '640400', '0954', 4);
INSERT INTO `sys_district` VALUES ('464', '中卫', '30', 'z', 'zw', 'zhongwei', '', '市', '640500', '', 5);
INSERT INTO `sys_district` VALUES ('465', '乌鲁木齐', '31', 'w', 'wlmq', 'wulumuqi', '', '市', '650100', '0991', 1);
INSERT INTO `sys_district` VALUES ('466', '克拉玛依', '31', 'k', 'klmy', 'kelamayi', '', '市', '650200', '0990', 2);
INSERT INTO `sys_district` VALUES ('467', '吐鲁番', '31', 't', 'tlf', 'tulufan', '', '市', '652100', '0995', 3);
INSERT INTO `sys_district` VALUES ('468', '哈密', '31', 'h', 'hm', 'hami', '', '市', '652200', '0902', 4);
INSERT INTO `sys_district` VALUES ('469', '昌吉', '31', 'c', 'cj', 'changji', '', '自治州', '652300', '0994', 5);
INSERT INTO `sys_district` VALUES ('47', '顺义', '1', 's', 'sy', 'shunyi', '', '区', '110113', '010', 12);
INSERT INTO `sys_district` VALUES ('470', '博尔塔拉', '31', 'b', 'betl', 'boertala', '蒙古', '自治州', '652700', '0909', 6);
INSERT INTO `sys_district` VALUES ('471', '巴音郭楞', '31', 'b', 'bygl', 'bayinguoleng', '蒙古', '自治州', '652800', '0996', 7);
INSERT INTO `sys_district` VALUES ('472', '阿克苏', '31', 'a', 'aks', 'akesu', '柯尔克孜', '地区', '652900', '0997', 8);
INSERT INTO `sys_district` VALUES ('473', '克孜勒苏', '31', 'k', 'kzls', 'kezilesu', '', '自治州', '653000', '0908', 9);
INSERT INTO `sys_district` VALUES ('474', '喀什', '31', 'k', 'ks', 'kashi', '', '地区', '653100', '0998', 10);
INSERT INTO `sys_district` VALUES ('475', '和田', '31', 'h', 'ht', 'hetian', '哈萨克', '地区', '653200', '0903', 11);
INSERT INTO `sys_district` VALUES ('476', '伊犁', '31', 'y', 'yl', 'yili', '', '自治州', '654000', '0999', 12);
INSERT INTO `sys_district` VALUES ('477', '塔城', '31', 't', 'tc', 'tacheng', '', '地区', '654200', '0901', 13);
INSERT INTO `sys_district` VALUES ('478', '阿勒泰', '31', 'a', 'alt', 'aletai', '', '地区', '654300', '0906', 14);
INSERT INTO `sys_district` VALUES ('479', '石河子', '31', 's', 'shz', 'shihezi', '', '市', '659001', '0993', 15);
INSERT INTO `sys_district` VALUES ('48', '昌平', '1', 'c', 'cp', 'changping', '', '区', '110114', '010', 13);
INSERT INTO `sys_district` VALUES ('480', '阿拉尔', '31', 'a', 'ale', 'alaer', '', '市', '659002', '0997', 16);
INSERT INTO `sys_district` VALUES ('481', '图木舒克', '31', 't', 'tmsk', 'tumushuke', '', '市', '659003', '0998', 17);
INSERT INTO `sys_district` VALUES ('482', '五家渠', '31', 'w', 'wjq', 'wujiaqu', '', '市', '659004', '0994', 18);
INSERT INTO `sys_district` VALUES ('483', '北屯', '31', 'b', 'bt', 'beitun', '', '市', '659005', '0906', 19);
INSERT INTO `sys_district` VALUES ('484', '铁门关', '31', 't', 'tmg', 'tiemenguan', '', '市', '659006', '0996', 20);
INSERT INTO `sys_district` VALUES ('485', '台北', '32', 't', 'tb', 'taibei', '', '市', '63', '02', 1);
INSERT INTO `sys_district` VALUES ('486', '高雄', '32', 'g', 'gx', 'gaoxiong', '', '市', '64', '07', 2);
INSERT INTO `sys_district` VALUES ('487', '基隆', '32', 'j', 'jl', 'jilong', '', '市', '10017', '02', 3);
INSERT INTO `sys_district` VALUES ('488', '台中', '32', 't', 'tz', 'taizhong', '', '市', '10019', '04', 4);
INSERT INTO `sys_district` VALUES ('489', '台南', '32', 't', 'tn', 'tainan', '', '市', '10021', '06', 5);
INSERT INTO `sys_district` VALUES ('49', '大兴', '1', 'd', 'dx', 'daxing', '', '区', '110115', '010', 14);
INSERT INTO `sys_district` VALUES ('490', '新竹', '32', 'x', 'xz', 'xinzhu', '', '市', '10018', '', 6);
INSERT INTO `sys_district` VALUES ('491', '嘉义', '32', 'j', 'jy', 'jiayi', '', '市', '10020', '05', 7);
INSERT INTO `sys_district` VALUES ('492', '新北', '32', 'x', 'xb', 'xinbei', '', '市', '', '', 8);
INSERT INTO `sys_district` VALUES ('493', '宜兰', '32', 'y', 'yl', 'yilan', '', '县', '10002', '', 9);
INSERT INTO `sys_district` VALUES ('494', '桃园', '32', 't', 'ty', 'taoyuan', '', '县', '10003', '', 10);
INSERT INTO `sys_district` VALUES ('495', '新竹', '32', 'x', 'xz', 'xinzhu', '', '县', '10004', '', 11);
INSERT INTO `sys_district` VALUES ('496', '苗栗', '32', 'm', 'ml', 'miaoli', '', '县', '10005', '', 12);
INSERT INTO `sys_district` VALUES ('497', '彰化', '32', 'z', 'zh', 'zhanghua', '', '县', '10007', '', 13);
INSERT INTO `sys_district` VALUES ('498', '南投', '32', 'n', 'nt', 'nantou', '', '县', '10008', '', 14);
INSERT INTO `sys_district` VALUES ('499', '云林', '32', 'y', 'yl', 'yunlin', '', '县', '10009', '', 15);
INSERT INTO `sys_district` VALUES ('5', '河北', '0', 'h', 'hb', 'hebei', '', '省', '130000', '', 6);
INSERT INTO `sys_district` VALUES ('50', '怀柔', '1', 'h', 'hr', 'huairou', '', '区', '110116', '010', 15);
INSERT INTO `sys_district` VALUES ('500', '嘉义', '32', 'j', 'jy', 'jiayi', '', '县', '10020', '', 16);
INSERT INTO `sys_district` VALUES ('501', '屏东', '32', 'p', 'pd', 'pingdong', '', '县', '10013', '', 17);
INSERT INTO `sys_district` VALUES ('502', '台东', '32', 't', 'td', 'taidong', '', '县', '10014', '', 18);
INSERT INTO `sys_district` VALUES ('503', '花莲', '32', 'h', 'hl', 'hualian', '', '县', '10015', '', 19);
INSERT INTO `sys_district` VALUES ('504', '澎湖', '32', 'p', 'ph', 'penghu', '', '县', '10016', '07', 20);
INSERT INTO `sys_district` VALUES ('505', '连江', '32', 'l', 'lj', 'lianjiang', '', '县', '', '', 21);
INSERT INTO `sys_district` VALUES ('506', '金门', '32', 'j', 'jm', 'jinmen', '', '县', '', '', 22);
INSERT INTO `sys_district` VALUES ('507', '中西', '33', 'z', 'zx', 'zhongxi', '', '区', '', '852', 1);
INSERT INTO `sys_district` VALUES ('508', '葵青', '33', 'k', 'kq', 'kuiqing', '', '区', '', '852', 2);
INSERT INTO `sys_district` VALUES ('509', '元朗', '33', 'y', 'yl', 'yuanlang', '', '区', '', '852', 3);
INSERT INTO `sys_district` VALUES ('51', '平谷', '1', 'p', 'pg', 'pinggu', '', '区', '110117', '010', 16);
INSERT INTO `sys_district` VALUES ('510', '屯门', '33', 't', 'tm', 'tunmen', '', '区', '', '852', 4);
INSERT INTO `sys_district` VALUES ('511', '荃湾', '33', 'q', 'qw', 'quanwan', '', '区', '', '852', 5);
INSERT INTO `sys_district` VALUES ('512', '西贡', '33', 'x', 'xg', 'xigong', '', '区', '', '852', 6);
INSERT INTO `sys_district` VALUES ('513', '沙田', '33', 's', 'st', 'shatian', '', '区', '', '852', 7);
INSERT INTO `sys_district` VALUES ('514', '大埔', '33', 'd', 'dp', 'dapu', '', '区', '', '852', 8);
INSERT INTO `sys_district` VALUES ('515', '北区', '33', 'b', 'bq', 'beiqu', '', '', '', '852', 9);
INSERT INTO `sys_district` VALUES ('516', '观塘', '33', 'g', 'gt', 'guantang', '', '区', '', '852', 10);
INSERT INTO `sys_district` VALUES ('517', '黄大仙', '33', 'h', 'hdx', 'huangdaxian', '', '区', '', '852', 11);
INSERT INTO `sys_district` VALUES ('518', '深水埗', '33', 's', 'ssb', 'shenshuibu', '', '区', '', '852', 12);
INSERT INTO `sys_district` VALUES ('519', '油尖旺', '33', 'y', 'yjw', 'youjianwang', '', '区', '', '852', 13);
INSERT INTO `sys_district` VALUES ('52', '密云', '1', 'm', 'my', 'miyun', '', '区', '110228', '010', 17);
INSERT INTO `sys_district` VALUES ('520', '九龙城', '33', 'j', 'jlc', 'jiulongcheng', '', '区', '', '852', 14);
INSERT INTO `sys_district` VALUES ('521', '南区', '33', 'n', 'nq', 'nanqu', '', '', '', '852', 15);
INSERT INTO `sys_district` VALUES ('522', '东区', '33', 'd', 'dq', 'dongqu', '', '', '', '852', 16);
INSERT INTO `sys_district` VALUES ('523', '湾仔', '33', 'w', 'wz', 'wanzi', '', '区', '', '852', 17);
INSERT INTO `sys_district` VALUES ('524', '离岛', '33', 'l', 'ld', 'lidao', '', '区', '', '852', 18);
INSERT INTO `sys_district` VALUES ('525', '花地玛', '34', 'h', 'hdm', 'huadima', '', '堂区', '', '853', 1);
INSERT INTO `sys_district` VALUES ('526', '圣安多', '34', 's', 'sad', 'shenganduo', '', '堂区', '', '853', 2);
INSERT INTO `sys_district` VALUES ('527', '大堂区', '34', 'd', 'dtq', 'datangqu', '', '堂区', '', '853', 3);
INSERT INTO `sys_district` VALUES ('528', '望德', '34', 'w', 'wd', 'wangde', '', '堂区', '', '853', 4);
INSERT INTO `sys_district` VALUES ('529', '风顺', '34', 'f', 'fs', 'fengshun', '', '堂区', '', '853', 5);
INSERT INTO `sys_district` VALUES ('53', '延庆', '1', 'y', 'yq', 'yanqing', '', '区', '110229', '010', 18);
INSERT INTO `sys_district` VALUES ('530', '嘉模', '34', 'j', 'jm', 'jiamo', '', '堂区', '', '853', 6);
INSERT INTO `sys_district` VALUES ('531', '圣方济各', '34', 's', 'sfjg', 'shengfangjige', '', '堂区', '', '853', 7);
INSERT INTO `sys_district` VALUES ('532', '路氹城', '34', 'l', 'ldc', 'ludangcheng', '', '', '', '853', 8);
INSERT INTO `sys_district` VALUES ('533', '长安', '125', 'z', 'za', 'zhangan', '', '区', '130102', '0311', 1);
INSERT INTO `sys_district` VALUES ('535', '桥西', '125', 'q', 'qx', 'qiaoxi', '', '区', '130104', '0311', 2);
INSERT INTO `sys_district` VALUES ('536', '新华', '125', 'x', 'xh', 'xinhua', '', '区', '130105', '0311', 3);
INSERT INTO `sys_district` VALUES ('537', '井陉矿', '125', 'j', 'jxk', 'jingxingkuang', '', '区', '130107', '0311', 4);
INSERT INTO `sys_district` VALUES ('538', '裕华', '125', 'y', 'yh', 'yuhua', '', '区', '130108', '0311', 5);
INSERT INTO `sys_district` VALUES ('539', '井陉', '125', 'j', 'jx', 'jingxing', '', '县', '130121', '0311', 9);
INSERT INTO `sys_district` VALUES ('54', '和平', '2', 'h', 'hp', 'heping', '', '区', '120101', '022', 2);
INSERT INTO `sys_district` VALUES ('540', '正定', '125', 'z', 'zd', 'zhengding', '', '县', '130123', '0311', 10);
INSERT INTO `sys_district` VALUES ('541', '栾城', '125', 'l', 'lc', 'luancheng', '', '区', '130111', '0311', 8);
INSERT INTO `sys_district` VALUES ('542', '行唐', '125', 'x', 'xt', 'xingtang', '', '县', '130125', '0311', 11);
INSERT INTO `sys_district` VALUES ('543', '灵寿', '125', 'l', 'ls', 'lingshou', '', '县', '130126', '0311', 12);
INSERT INTO `sys_district` VALUES ('544', '高邑', '125', 'g', 'gy', 'gaoyi', '', '县', '130127', '0311', 13);
INSERT INTO `sys_district` VALUES ('545', '深泽', '125', 's', 'sz', 'shenze', '', '县', '130128', '0311', 14);
INSERT INTO `sys_district` VALUES ('546', '赞皇', '125', 'z', 'zh', 'zanhuang', '', '县', '130129', '0311', 15);
INSERT INTO `sys_district` VALUES ('547', '无极', '125', 'w', 'wj', 'wuji', '', '县', '130130', '0311', 16);
INSERT INTO `sys_district` VALUES ('548', '平山', '125', 'p', 'ps', 'pingshan', '', '县', '130131', '0311', 17);
INSERT INTO `sys_district` VALUES ('549', '元氏', '125', 'y', 'ys', 'yuanshi', '', '县', '130132', '0311', 18);
INSERT INTO `sys_district` VALUES ('55', '河东', '2', 'h', 'hd', 'hedong', '', '区', '120102', '022', 3);
INSERT INTO `sys_district` VALUES ('550', '赵县', '125', 'z', 'zx', 'zhaoxian', '', '', '130133', '0311', 19);
INSERT INTO `sys_district` VALUES ('551', '辛集', '125', 'x', 'xj', 'xinji', '', '市', '130181', '0311', 20);
INSERT INTO `sys_district` VALUES ('552', '藁城', '125', 'g', 'gc', 'gaocheng', '', '区', '130109', '0311', 6);
INSERT INTO `sys_district` VALUES ('553', '晋州', '125', 'j', 'jz', 'jinzhou', '', '市', '130183', '0311', 21);
INSERT INTO `sys_district` VALUES ('554', '新乐', '125', 'x', 'xl', 'xinle', '', '市', '130184', '0311', 22);
INSERT INTO `sys_district` VALUES ('555', '鹿泉', '125', 'l', 'lq', 'luquan', '', '区', '130110', '0311', 7);
INSERT INTO `sys_district` VALUES ('556', '路南', '126', 'l', 'ln', 'lunan', '', '区', '130202', '0315', 1);
INSERT INTO `sys_district` VALUES ('557', '路北', '126', 'l', 'lb', 'lubei', '', '区', '130203', '0315', 2);
INSERT INTO `sys_district` VALUES ('558', '古冶', '126', 'g', 'gy', 'guye', '', '区', '130204', '0315', 3);
INSERT INTO `sys_district` VALUES ('559', '开平', '126', 'k', 'kp', 'kaiping', '', '区', '130205', '0315', 4);
INSERT INTO `sys_district` VALUES ('56', '河西', '2', 'h', 'hx', 'hexi', '', '区', '120103', '022', 4);
INSERT INTO `sys_district` VALUES ('560', '丰南', '126', 'f', 'fn', 'fengnan', '', '区', '130207', '0315', 5);
INSERT INTO `sys_district` VALUES ('561', '丰润', '126', 'f', 'fr', 'fengrun', '', '区', '130208', '0315', 6);
INSERT INTO `sys_district` VALUES ('562', '滦县', '126', 'l', 'lx', 'luanxian', '', '', '130223', '0315', 7);
INSERT INTO `sys_district` VALUES ('563', '滦南', '126', 'l', 'ln', 'luannan', '', '县', '130224', '0315', 8);
INSERT INTO `sys_district` VALUES ('564', '乐亭', '126', 'l', 'lt', 'leting', '', '县', '130225', '0315', 9);
INSERT INTO `sys_district` VALUES ('565', '迁西', '126', 'q', 'qx', 'qianxi', '', '县', '130227', '0315', 10);
INSERT INTO `sys_district` VALUES ('566', '玉田', '126', 'y', 'yt', 'yutian', '', '县', '130229', '0315', 11);
INSERT INTO `sys_district` VALUES ('567', '唐海', '126', 't', 'th', 'tanghai', '', '县', '130230', '0315', 12);
INSERT INTO `sys_district` VALUES ('568', '遵化', '126', 'z', 'zh', 'zunhua', '', '市', '130281', '0315', 13);
INSERT INTO `sys_district` VALUES ('569', '迁安', '126', 'q', 'qa', 'qianan', '', '市', '130283', '0315', 14);
INSERT INTO `sys_district` VALUES ('57', '南开', '2', 'n', 'nk', 'nankai', '', '区', '120104', '022', 5);
INSERT INTO `sys_district` VALUES ('570', '海港', '127', 'h', 'hg', 'haigang', '', '区', '130302', '0335', 1);
INSERT INTO `sys_district` VALUES ('571', '山海关', '127', 's', 'shg', 'shanhaiguan', '', '区', '130303', '0335', 2);
INSERT INTO `sys_district` VALUES ('572', '北戴河', '127', 'b', 'bdh', 'beidaihe', '', '区', '130304', '0335', 3);
INSERT INTO `sys_district` VALUES ('573', '青龙', '127', 'q', 'ql', 'qinglong', '满族', '自治县', '130321', '0335', 4);
INSERT INTO `sys_district` VALUES ('574', '昌黎', '127', 'c', 'cl', 'changli', '', '县', '130322', '0335', 5);
INSERT INTO `sys_district` VALUES ('575', '抚宁', '127', 'f', 'fn', 'funing', '', '区', '130323', '0335', 6);
INSERT INTO `sys_district` VALUES ('576', '卢龙', '127', 'l', 'll', 'lulong', '', '县', '130324', '0335', 7);
INSERT INTO `sys_district` VALUES ('577', '邯山', '128', 'h', 'hs', 'hanshan', '', '区', '130402', '0310', 1);
INSERT INTO `sys_district` VALUES ('578', '丛台', '128', 'c', 'ct', 'congtai', '', '区', '130403', '0310', 2);
INSERT INTO `sys_district` VALUES ('579', '复兴', '128', 'f', 'fx', 'fuxing', '', '区', '130404', '0310', 3);
INSERT INTO `sys_district` VALUES ('58', '河北', '2', 'h', 'hb', 'hebei', '', '区', '120105', '022', 6);
INSERT INTO `sys_district` VALUES ('580', '峰峰矿', '128', 'f', 'ffk', 'fengfengkuang', '', '区', '130406', '0310', 4);
INSERT INTO `sys_district` VALUES ('582', '临漳', '128', 'l', 'lz', 'linzhang', '', '县', '130423', '0310', 6);
INSERT INTO `sys_district` VALUES ('583', '成安', '128', 'c', 'ca', 'chengan', '', '县', '130424', '0310', 7);
INSERT INTO `sys_district` VALUES ('584', '大名', '128', 'd', 'dm', 'daming', '', '县', '130425', '0310', 8);
INSERT INTO `sys_district` VALUES ('585', '涉县', '128', 's', 'sx', 'shexian', '', '', '130426', '0310', 9);
INSERT INTO `sys_district` VALUES ('586', '磁县', '128', 'c', 'cx', 'cixian', '', '', '130427', '0310', 10);
INSERT INTO `sys_district` VALUES ('587', '肥乡', '128', 'f', 'fx', 'feixiang', '', '区', '130428', '0310', 11);
INSERT INTO `sys_district` VALUES ('588', '永年', '128', 'y', 'yn', 'yongnian', '', '区', '130429', '0310', 12);
INSERT INTO `sys_district` VALUES ('589', '邱县', '128', 'q', 'qx', 'qiuxian', '', '', '130430', '0310', 13);
INSERT INTO `sys_district` VALUES ('59', '红桥', '2', 'h', 'hq', 'hongqiao', '', '区', '120106', '022', 7);
INSERT INTO `sys_district` VALUES ('590', '鸡泽', '128', 'j', 'jz', 'jize', '', '县', '130431', '0310', 14);
INSERT INTO `sys_district` VALUES ('591', '广平', '128', 'g', 'gp', 'guangping', '', '县', '130432', '0310', 15);
INSERT INTO `sys_district` VALUES ('592', '馆陶', '128', 'g', 'gt', 'guantao', '', '县', '130433', '0310', 16);
INSERT INTO `sys_district` VALUES ('593', '魏县', '128', 'w', 'wx', 'weixian', '', '', '130434', '0310', 17);
INSERT INTO `sys_district` VALUES ('594', '曲周', '128', 'q', 'qz', 'quzhou', '', '县', '130435', '0310', 18);
INSERT INTO `sys_district` VALUES ('595', '武安', '128', 'w', 'wa', 'wuan', '', '市', '130481', '0310', 19);
INSERT INTO `sys_district` VALUES ('596', '桥东', '129', 'q', 'qd', 'qiaodong', '', '区', '130502', '0319', 1);
INSERT INTO `sys_district` VALUES ('597', '桥西', '129', 'q', 'qx', 'qiaoxi', '', '区', '130503', '0319', 2);
INSERT INTO `sys_district` VALUES ('598', '邢台', '129', 'x', 'xt', 'xingtai', '', '县', '130521', '0319', 3);
INSERT INTO `sys_district` VALUES ('599', '临城', '129', 'l', 'lc', 'lincheng', '', '县', '130522', '0319', 4);
INSERT INTO `sys_district` VALUES ('6', '山西', '0', 's', 'sx', 'shanxi', '', '省', '140000', '', 7);
INSERT INTO `sys_district` VALUES ('60', '东丽', '2', 'd', 'dl', 'dongli', '', '区', '120110', '022', 8);
INSERT INTO `sys_district` VALUES ('600', '内丘', '129', 'n', 'nq', 'neiqiu', '', '县', '130523', '0319', 5);
INSERT INTO `sys_district` VALUES ('601', '柏乡', '129', 'b', 'bx', 'boxiang', '', '县', '130524', '0319', 6);
INSERT INTO `sys_district` VALUES ('602', '隆尧', '129', 'l', 'ly', 'longyao', '', '县', '130525', '0319', 7);
INSERT INTO `sys_district` VALUES ('603', '任县', '129', 'r', 'rx', 'renxian', '', '', '130526', '0319', 8);
INSERT INTO `sys_district` VALUES ('604', '南和', '129', 'n', 'nh', 'nanhe', '', '县', '130527', '0319', 9);
INSERT INTO `sys_district` VALUES ('605', '宁晋', '129', 'n', 'nj', 'ningjin', '', '县', '130528', '0319', 10);
INSERT INTO `sys_district` VALUES ('606', '巨鹿', '129', 'j', 'jl', 'julu', '', '县', '130529', '0319', 11);
INSERT INTO `sys_district` VALUES ('607', '新河', '129', 'x', 'xh', 'xinhe', '', '县', '130530', '0319', 12);
INSERT INTO `sys_district` VALUES ('608', '广宗', '129', 'g', 'gz', 'guangzong', '', '县', '130531', '0319', 13);
INSERT INTO `sys_district` VALUES ('609', '平乡', '129', 'p', 'px', 'pingxiang', '', '县', '130532', '0319', 14);
INSERT INTO `sys_district` VALUES ('61', '西青', '2', 'x', 'xq', 'xiqing', '', '区', '120111', '022', 9);
INSERT INTO `sys_district` VALUES ('610', '威县', '129', 'w', 'wx', 'weixian', '', '', '130533', '0319', 15);
INSERT INTO `sys_district` VALUES ('611', '清河', '129', 'q', 'qh', 'qinghe', '', '县', '130534', '0319', 16);
INSERT INTO `sys_district` VALUES ('612', '临西', '129', 'l', 'lx', 'linxi', '', '县', '130535', '0319', 17);
INSERT INTO `sys_district` VALUES ('613', '南宫', '129', 'n', 'ng', 'nangong', '', '市', '130581', '0319', 18);
INSERT INTO `sys_district` VALUES ('614', '沙河', '129', 's', 'sh', 'shahe', '', '市', '130582', '0319', 19);
INSERT INTO `sys_district` VALUES ('615', '竞秀', '130', 'j', 'jx', 'jingxiu', '', '区', '130602', '0312', 1);
INSERT INTO `sys_district` VALUES ('616', '莲池', '130', 'l', 'lc', 'lianchi', '', '区', '130603', '0312', 2);
INSERT INTO `sys_district` VALUES ('618', '满城', '130', 'm', 'mc', 'mancheng', '', '区', '130621', '0312', 4);
INSERT INTO `sys_district` VALUES ('619', '清苑', '130', 'q', 'qy', 'qingyuan', '', '区', '130622', '0312', 5);
INSERT INTO `sys_district` VALUES ('62', '津南', '2', 'j', 'jn', 'jinnan', '', '区', '120112', '022', 10);
INSERT INTO `sys_district` VALUES ('620', '涞水', '130', 'l', 'ls', 'laishui', '', '县', '130623', '0312', 6);
INSERT INTO `sys_district` VALUES ('621', '阜平', '130', 'f', 'fp', 'fuping', '', '县', '130624', '0312', 7);
INSERT INTO `sys_district` VALUES ('622', '徐水', '130', 'x', 'xs', 'xushui', '', '区', '130625', '0312', 8);
INSERT INTO `sys_district` VALUES ('623', '定兴', '130', 'd', 'dx', 'dingxing', '', '县', '130626', '0312', 9);
INSERT INTO `sys_district` VALUES ('624', '唐县', '130', 't', 'tx', 'tangxian', '', '', '130627', '0312', 10);
INSERT INTO `sys_district` VALUES ('625', '高阳', '130', 'g', 'gy', 'gaoyang', '', '县', '130628', '0312', 11);
INSERT INTO `sys_district` VALUES ('626', '容城', '130', 'r', 'rc', 'rongcheng', '', '县', '130629', '0312', 12);
INSERT INTO `sys_district` VALUES ('627', '涞源', '130', 'l', 'ly', 'laiyuan', '', '县', '130630', '0312', 13);
INSERT INTO `sys_district` VALUES ('628', '望都', '130', 'w', 'wd', 'wangdu', '', '县', '130631', '0312', 14);
INSERT INTO `sys_district` VALUES ('629', '安新', '130', 'a', 'ax', 'anxin', '', '县', '130632', '0312', 15);
INSERT INTO `sys_district` VALUES ('63', '北辰', '2', 'b', 'bc', 'beichen', '', '区', '120113', '022', 11);
INSERT INTO `sys_district` VALUES ('630', '易县', '130', 'y', 'yx', 'yixian', '', '', '130633', '0312', 16);
INSERT INTO `sys_district` VALUES ('631', '曲阳', '130', 'q', 'qy', 'quyang', '', '县', '130634', '0312', 17);
INSERT INTO `sys_district` VALUES ('632', '蠡县', '130', 'l', 'lx', 'lixian', '', '', '130635', '0312', 18);
INSERT INTO `sys_district` VALUES ('633', '顺平', '130', 's', 'sp', 'shunping', '', '县', '130636', '0312', 19);
INSERT INTO `sys_district` VALUES ('634', '博野', '130', 'b', 'by', 'boye', '', '县', '130637', '0312', 20);
INSERT INTO `sys_district` VALUES ('635', '雄县', '130', 'x', 'xx', 'xiongxian', '', '', '130638', '0312', 21);
INSERT INTO `sys_district` VALUES ('636', '涿州', '130', 'z', 'zz', 'zhuozhou', '', '市', '130681', '0312', 22);
INSERT INTO `sys_district` VALUES ('637', '定州', '130', 'd', 'dz', 'dingzhou', '', '市', '130682', '0312', 23);
INSERT INTO `sys_district` VALUES ('638', '安国', '130', 'a', 'ag', 'anguo', '', '市', '130683', '0312', 24);
INSERT INTO `sys_district` VALUES ('639', '高碑店', '130', 'g', 'gbd', 'gaobeidian', '', '市', '130684', '0312', 25);
INSERT INTO `sys_district` VALUES ('64', '武清', '2', 'w', 'wq', 'wuqing', '', '区', '120114', '022', 12);
INSERT INTO `sys_district` VALUES ('640', '桥东', '131', 'q', 'qd', 'qiaodong', '', '区', '130702', '0313', 1);
INSERT INTO `sys_district` VALUES ('641', '桥西', '131', 'q', 'qx', 'qiaoxi', '', '区', '130703', '0313', 2);
INSERT INTO `sys_district` VALUES ('642', '宣化', '131', 'x', 'xh', 'xuanhua', '', '区', '130705', '0313', 3);
INSERT INTO `sys_district` VALUES ('643', '下花园', '131', 'x', 'xhy', 'xiahuayuan', '', '区', '130706', '0313', 4);
INSERT INTO `sys_district` VALUES ('645', '张北', '131', 'z', 'zb', 'zhangbei', '', '县', '130722', '0313', 6);
INSERT INTO `sys_district` VALUES ('646', '康保', '131', 'k', 'kb', 'kangbao', '', '县', '130723', '0313', 7);
INSERT INTO `sys_district` VALUES ('647', '沽源', '131', 'g', 'gy', 'guyuan', '', '县', '130724', '0313', 8);
INSERT INTO `sys_district` VALUES ('648', '尚义', '131', 's', 'sy', 'shangyi', '', '县', '130725', '0313', 9);
INSERT INTO `sys_district` VALUES ('649', '蔚县', '131', 'y', 'yx', 'yuxian', '', '', '130726', '0313', 10);
INSERT INTO `sys_district` VALUES ('65', '宝坻', '2', 'b', 'bc', 'baochi', '', '区', '120115', '022', 13);
INSERT INTO `sys_district` VALUES ('650', '阳原', '131', 'y', 'yy', 'yangyuan', '', '县', '130727', '0313', 11);
INSERT INTO `sys_district` VALUES ('651', '怀安', '131', 'h', 'ha', 'huaian', '', '县', '130728', '0313', 12);
INSERT INTO `sys_district` VALUES ('652', '万全', '131', 'w', 'wq', 'wanquan', '', '县', '130729', '0313', 13);
INSERT INTO `sys_district` VALUES ('653', '怀来', '131', 'h', 'hl', 'huailai', '', '县', '130730', '0313', 14);
INSERT INTO `sys_district` VALUES ('654', '涿鹿', '131', 'z', 'zl', 'zhuolu', '', '县', '130731', '0313', 15);
INSERT INTO `sys_district` VALUES ('655', '赤城', '131', 'c', 'cc', 'chicheng', '', '县', '130732', '0313', 16);
INSERT INTO `sys_district` VALUES ('656', '崇礼', '131', 'c', 'cl', 'chongli', '', '县', '130733', '0313', 17);
INSERT INTO `sys_district` VALUES ('657', '双桥', '132', 's', 'sq', 'shuangqiao', '', '区', '130802', '0314', 1);
INSERT INTO `sys_district` VALUES ('658', '双滦', '132', 's', 'sl', 'shuangluan', '', '区', '130803', '0314', 2);
INSERT INTO `sys_district` VALUES ('659', '鹰手营子', '132', 'y', 'ysyz', 'yingshouyingzi', '矿', '区', '130804', '0314', 3);
INSERT INTO `sys_district` VALUES ('66', '滨海新区', '2', 'b', 'bhxq', 'binhaixinqu', '', '', '120116', '022', 14);
INSERT INTO `sys_district` VALUES ('660', '承德', '132', 'c', 'cd', 'chengde', '', '县', '130821', '0314', 4);
INSERT INTO `sys_district` VALUES ('661', '兴隆', '132', 'x', 'xl', 'xinglong', '', '县', '130822', '0314', 5);
INSERT INTO `sys_district` VALUES ('662', '平泉', '132', 'p', 'pq', 'pingquan', '', '县', '130823', '0314', 6);
INSERT INTO `sys_district` VALUES ('663', '滦平', '132', 'l', 'lp', 'luanping', '', '县', '130824', '0314', 7);
INSERT INTO `sys_district` VALUES ('664', '隆化', '132', 'l', 'lh', 'longhua', '', '县', '130825', '0314', 8);
INSERT INTO `sys_district` VALUES ('665', '丰宁', '132', 'f', 'fn', 'fengning', '满族', '自治县', '130826', '0314', 9);
INSERT INTO `sys_district` VALUES ('666', '宽城', '132', 'k', 'kc', 'kuancheng', '满族', '自治县', '130827', '0314', 10);
INSERT INTO `sys_district` VALUES ('667', '围场', '132', 'w', 'wc', 'weichang', '满族蒙古族', '自治县', '130828', '0314', 11);
INSERT INTO `sys_district` VALUES ('668', '新华', '133', 'x', 'xh', 'xinhua', '', '区', '130902', '0317', 1);
INSERT INTO `sys_district` VALUES ('669', '运河', '133', 'y', 'yh', 'yunhe', '', '区', '130903', '0317', 2);
INSERT INTO `sys_district` VALUES ('67', '宁河', '2', 'n', 'nh', 'ninghe', '', '区', '120221', '022', 15);
INSERT INTO `sys_district` VALUES ('670', '沧县', '133', 'c', 'cx', 'cangxian', '', '', '130921', '0317', 3);
INSERT INTO `sys_district` VALUES ('671', '青县', '133', 'q', 'qx', 'qingxian', '', '', '130922', '0317', 4);
INSERT INTO `sys_district` VALUES ('672', '东光', '133', 'd', 'dg', 'dongguang', '', '县', '130923', '0317', 5);
INSERT INTO `sys_district` VALUES ('673', '海兴', '133', 'h', 'hx', 'haixing', '', '县', '130924', '0317', 6);
INSERT INTO `sys_district` VALUES ('674', '盐山', '133', 'y', 'ys', 'yanshan', '', '县', '130925', '0317', 7);
INSERT INTO `sys_district` VALUES ('675', '肃宁', '133', 's', 'sn', 'suning', '', '县', '130926', '0317', 8);
INSERT INTO `sys_district` VALUES ('676', '南皮', '133', 'n', 'np', 'nanpi', '', '县', '130927', '0317', 9);
INSERT INTO `sys_district` VALUES ('677', '吴桥', '133', 'w', 'wq', 'wuqiao', '', '县', '130928', '0317', 10);
INSERT INTO `sys_district` VALUES ('678', '献县', '133', 'x', 'xx', 'xianxian', '', '', '130929', '0317', 11);
INSERT INTO `sys_district` VALUES ('679', '孟村', '133', 'm', 'mc', 'mengcun', '回族', '自治县', '130930', '0317', 12);
INSERT INTO `sys_district` VALUES ('68', '蓟州', '2', 'j', 'jz', 'jizhou', '', '区', '120223', '022', 16);
INSERT INTO `sys_district` VALUES ('680', '泊头', '133', 'b', 'bt', 'botou', '', '市', '130981', '0317', 13);
INSERT INTO `sys_district` VALUES ('681', '任丘', '133', 'r', 'rq', 'renqiu', '', '市', '130982', '0317', 14);
INSERT INTO `sys_district` VALUES ('682', '黄骅', '133', 'h', 'hh', 'huanghua', '', '市', '130983', '0317', 15);
INSERT INTO `sys_district` VALUES ('683', '河间', '133', 'h', 'hj', 'hejian', '', '市', '130984', '0317', 16);
INSERT INTO `sys_district` VALUES ('684', '安次', '134', 'a', 'ac', 'anci', '', '区', '131002', '0316', 1);
INSERT INTO `sys_district` VALUES ('685', '广阳', '134', 'g', 'gy', 'guangyang', '', '区', '131003', '0316', 2);
INSERT INTO `sys_district` VALUES ('686', '固安', '134', 'g', 'ga', 'guan', '', '县', '131022', '0316', 3);
INSERT INTO `sys_district` VALUES ('687', '永清', '134', 'y', 'yq', 'yongqing', '', '县', '131023', '0316', 4);
INSERT INTO `sys_district` VALUES ('688', '香河', '134', 'x', 'xh', 'xianghe', '', '县', '131024', '0316', 5);
INSERT INTO `sys_district` VALUES ('689', '大城', '134', 'd', 'dc', 'dacheng', '', '县', '131025', '0316', 6);
INSERT INTO `sys_district` VALUES ('69', '静海', '2', 'j', 'jh', 'jinghai', '', '区', '120225', '022', 17);
INSERT INTO `sys_district` VALUES ('690', '文安', '134', 'w', 'wa', 'wenan', '', '县', '131026', '0316', 7);
INSERT INTO `sys_district` VALUES ('691', '大厂', '134', 'd', 'dc', 'dachang', '回族', '自治县', '131028', '0316', 8);
INSERT INTO `sys_district` VALUES ('692', '霸州', '134', 'b', 'bz', 'bazhou', '', '市', '131081', '0316', 9);
INSERT INTO `sys_district` VALUES ('693', '三河', '134', 's', 'sh', 'sanhe', '', '市', '131082', '0316', 10);
INSERT INTO `sys_district` VALUES ('694', '桃城', '135', 't', 'tc', 'taocheng', '', '区', '131102', '0318', 1);
INSERT INTO `sys_district` VALUES ('695', '枣强', '135', 'z', 'zq', 'zaoqiang', '', '县', '131121', '0318', 2);
INSERT INTO `sys_district` VALUES ('696', '武邑', '135', 'w', 'wy', 'wuyi', '', '县', '131122', '0318', 3);
INSERT INTO `sys_district` VALUES ('697', '武强', '135', 'w', 'wq', 'wuqiang', '', '县', '131123', '0318', 4);
INSERT INTO `sys_district` VALUES ('698', '饶阳', '135', 'r', 'ry', 'raoyang', '', '县', '131124', '0318', 5);
INSERT INTO `sys_district` VALUES ('699', '安平', '135', 'a', 'ap', 'anping', '', '县', '131125', '0318', 6);
INSERT INTO `sys_district` VALUES ('7', '内蒙古', '0', 'n', 'nmg', 'neimenggu', '', '自治区', '150000', '', 8);
INSERT INTO `sys_district` VALUES ('70', '黄浦', '3', 'h', 'hp', 'huangpu', '', '区', '310101', '021', 1);
INSERT INTO `sys_district` VALUES ('700', '故城', '135', 'g', 'gc', 'gucheng', '', '县', '131126', '0318', 7);
INSERT INTO `sys_district` VALUES ('701', '景县', '135', 'j', 'jx', 'jingxian', '', '', '131127', '0318', 8);
INSERT INTO `sys_district` VALUES ('702', '阜城', '135', 'f', 'fc', 'fucheng', '', '县', '131128', '0318', 9);
INSERT INTO `sys_district` VALUES ('703', '冀州', '135', 'j', 'jz', 'jizhou', '', '区', '131181', '0318', 10);
INSERT INTO `sys_district` VALUES ('7036', '龙华', '323', 'l', 'lh', 'longhua', '', '区', '', '0755', 7);
INSERT INTO `sys_district` VALUES ('7037', '坪山', '323', 'p', 'ps', 'pingshan', '', '区', '', '0755', 8);
INSERT INTO `sys_district` VALUES ('7038', '昆玉', '31', 'k', 'ky', 'kunyu', '', '市', '659009', '0903', 23);
INSERT INTO `sys_district` VALUES ('7039', '平桂', '352', 'p', 'pg', 'pinggui', '', '区', '', '0774', 2);
INSERT INTO `sys_district` VALUES ('704', '深州', '135', 's', 'sz', 'shenzhou', '', '市', '131182', '0318', 11);
INSERT INTO `sys_district` VALUES ('7040', '巴什', '152', 'b', 'bs', 'bashi', '', '区', '', '0477', 9);
INSERT INTO `sys_district` VALUES ('7041', '叶集', '231', 'y', 'yj', 'yeji', '', '区', '', '0564', 8);
INSERT INTO `sys_district` VALUES ('705', '小店', '136', 'x', 'xd', 'xiaodian', '', '区', '140105', '0351', 1);
INSERT INTO `sys_district` VALUES ('706', '迎泽', '136', 'y', 'yz', 'yingze', '', '区', '140106', '0351', 2);
INSERT INTO `sys_district` VALUES ('707', '杏花岭', '136', 'x', 'xhl', 'xinghualing', '', '区', '140107', '0351', 3);
INSERT INTO `sys_district` VALUES ('708', '尖草坪', '136', 'j', 'jcp', 'jiancaoping', '', '区', '140108', '0351', 4);
INSERT INTO `sys_district` VALUES ('709', '万柏林', '136', 'w', 'wbl', 'wanbolin', '', '区', '140109', '0351', 5);
INSERT INTO `sys_district` VALUES ('71', '徐汇', '3', 'x', 'xh', 'xuhui', '', '区', '310104', '021', 2);
INSERT INTO `sys_district` VALUES ('710', '晋源', '136', 'j', 'jy', 'jinyuan', '', '区', '140110', '0351', 6);
INSERT INTO `sys_district` VALUES ('711', '清徐', '136', 'q', 'qx', 'qingxu', '', '县', '140121', '0351', 7);
INSERT INTO `sys_district` VALUES ('712', '阳曲', '136', 'y', 'yq', 'yangqu', '', '县', '140122', '0351', 8);
INSERT INTO `sys_district` VALUES ('713', '娄烦', '136', 'l', 'lf', 'loufan', '', '县', '140123', '0351', 9);
INSERT INTO `sys_district` VALUES ('714', '古交', '136', 'g', 'gj', 'gujiao', '', '市', '140181', '0351', 10);
INSERT INTO `sys_district` VALUES ('715', '城区', '137', 'c', 'cq', 'chengqu', '', '', '140202', '0352', 1);
INSERT INTO `sys_district` VALUES ('716', '矿区', '137', 'k', 'kq', 'kuangqu', '', '', '140203', '0352', 2);
INSERT INTO `sys_district` VALUES ('717', '南郊', '137', 'n', 'nj', 'nanjiao', '', '区', '140211', '0352', 3);
INSERT INTO `sys_district` VALUES ('718', '新荣', '137', 'x', 'xr', 'xinrong', '', '区', '140212', '0352', 4);
INSERT INTO `sys_district` VALUES ('719', '阳高', '137', 'y', 'yg', 'yanggao', '', '县', '140221', '0352', 5);
INSERT INTO `sys_district` VALUES ('72', '长宁', '3', 'z', 'zn', 'zhangning', '', '区', '310105', '021', 3);
INSERT INTO `sys_district` VALUES ('720', '天镇', '137', 't', 'tz', 'tianzhen', '', '县', '140222', '0352', 6);
INSERT INTO `sys_district` VALUES ('721', '广灵', '137', 'g', 'gl', 'guangling', '', '县', '140223', '0352', 7);
INSERT INTO `sys_district` VALUES ('722', '灵丘', '137', 'l', 'lq', 'lingqiu', '', '县', '140224', '0352', 8);
INSERT INTO `sys_district` VALUES ('723', '浑源', '137', 'h', 'hy', 'hunyuan', '', '县', '140225', '0352', 9);
INSERT INTO `sys_district` VALUES ('724', '左云', '137', 'z', 'zy', 'zuoyun', '', '县', '140226', '0352', 10);
INSERT INTO `sys_district` VALUES ('725', '大同', '137', 'd', 'dt', 'datong', '', '县', '140227', '0352', 11);
INSERT INTO `sys_district` VALUES ('726', '城区', '138', 'c', 'cq', 'chengqu', '', '', '140302', '0353', 1);
INSERT INTO `sys_district` VALUES ('727', '矿区', '138', 'k', 'kq', 'kuangqu', '', '', '140303', '0353', 2);
INSERT INTO `sys_district` VALUES ('728', '郊区', '138', 'j', 'jq', 'jiaoqu', '', '', '140311', '0353', 3);
INSERT INTO `sys_district` VALUES ('729', '平定', '138', 'p', 'pd', 'pingding', '', '县', '140321', '0353', 4);
INSERT INTO `sys_district` VALUES ('73', '静安', '3', 'j', 'ja', 'jingan', '', '区', '310106', '021', 4);
INSERT INTO `sys_district` VALUES ('730', '盂县', '138', 'y', 'yx', 'yuxian', '', '', '140322', '0353', 5);
INSERT INTO `sys_district` VALUES ('731', '城区', '139', 'c', 'cq', 'chengqu', '', '', '140402', '0355', 1);
INSERT INTO `sys_district` VALUES ('732', '郊区', '139', 'j', 'jq', 'jiaoqu', '', '', '140411', '0355', 2);
INSERT INTO `sys_district` VALUES ('733', '长治', '139', 'z', 'zz', 'zhangzhi', '', '县', '140421', '0355', 3);
INSERT INTO `sys_district` VALUES ('734', '襄垣', '139', 'x', 'xy', 'xiangyuan', '', '县', '140423', '0355', 4);
INSERT INTO `sys_district` VALUES ('735', '屯留', '139', 't', 'tl', 'tunliu', '', '县', '140424', '0355', 5);
INSERT INTO `sys_district` VALUES ('736', '平顺', '139', 'p', 'ps', 'pingshun', '', '县', '140425', '0355', 6);
INSERT INTO `sys_district` VALUES ('737', '黎城', '139', 'l', 'lc', 'licheng', '', '县', '140426', '0355', 7);
INSERT INTO `sys_district` VALUES ('738', '壶关', '139', 'h', 'hg', 'huguan', '', '县', '140427', '0355', 8);
INSERT INTO `sys_district` VALUES ('739', '长子', '139', 'z', 'zz', 'zhangzi', '', '县', '140428', '0355', 9);
INSERT INTO `sys_district` VALUES ('74', '普陀', '3', 'p', 'pt', 'putuo', '', '区', '310107', '021', 5);
INSERT INTO `sys_district` VALUES ('740', '武乡', '139', 'w', 'wx', 'wuxiang', '', '县', '140429', '0355', 10);
INSERT INTO `sys_district` VALUES ('741', '沁县', '139', 'q', 'qx', 'qinxian', '', '', '140430', '0355', 11);
INSERT INTO `sys_district` VALUES ('742', '沁源', '139', 'q', 'qy', 'qinyuan', '', '县', '140431', '0355', 12);
INSERT INTO `sys_district` VALUES ('743', '潞城', '139', 'l', 'lc', 'lucheng', '', '县', '140481', '0355', 13);
INSERT INTO `sys_district` VALUES ('744', '城区', '140', 'c', 'cq', 'chengqu', '', '', '140502', '0356', 1);
INSERT INTO `sys_district` VALUES ('745', '沁水', '140', 'q', 'qs', 'qinshui', '', '县', '140521', '0356', 2);
INSERT INTO `sys_district` VALUES ('746', '阳城', '140', 'y', 'yc', 'yangcheng', '', '县', '140522', '0356', 3);
INSERT INTO `sys_district` VALUES ('747', '陵川', '140', 'l', 'lc', 'lingchuan', '', '县', '140524', '0356', 4);
INSERT INTO `sys_district` VALUES ('748', '泽州', '140', 'z', 'zz', 'zezhou', '', '县', '140525', '0356', 5);
INSERT INTO `sys_district` VALUES ('749', '高平', '140', 'g', 'gp', 'gaoping', '', '市', '140581', '0356', 6);
INSERT INTO `sys_district` VALUES ('750', '朔城', '141', 's', 'sc', 'shuocheng', '', '区', '140602', '0349', 1);
INSERT INTO `sys_district` VALUES ('751', '平鲁', '141', 'p', 'pl', 'pinglu', '', '区', '140603', '0349', 2);
INSERT INTO `sys_district` VALUES ('752', '山阴', '141', 's', 'sy', 'shanyin', '', '县', '140621', '0349', 3);
INSERT INTO `sys_district` VALUES ('753', '应县', '141', 'y', 'yx', 'yingxian', '', '', '140622', '0349', 4);
INSERT INTO `sys_district` VALUES ('754', '右玉', '141', 'y', 'yy', 'youyu', '', '县', '140623', '0349', 5);
INSERT INTO `sys_district` VALUES ('755', '怀仁', '141', 'h', 'hr', 'huairen', '', '县', '140624', '0349', 6);
INSERT INTO `sys_district` VALUES ('756', '榆次', '142', 'y', 'yc', 'yuci', '', '区', '030600', '0354', 1);
INSERT INTO `sys_district` VALUES ('757', '榆社', '142', 'y', 'ys', 'yushe', '', '县', '140721', '0354', 2);
INSERT INTO `sys_district` VALUES ('758', '左权', '142', 'z', 'zq', 'zuoquan', '', '县', '140722', '0354', 3);
INSERT INTO `sys_district` VALUES ('759', '和顺', '142', 'h', 'hs', 'heshun', '', '县', '140723', '0354', 4);
INSERT INTO `sys_district` VALUES ('76', '虹口', '3', 'h', 'hk', 'hongkou', '', '区', '310109', '021', 7);
INSERT INTO `sys_district` VALUES ('760', '昔阳', '142', 'x', 'xy', 'xiyang', '', '县', '140724', '0354', 5);
INSERT INTO `sys_district` VALUES ('761', '寿阳', '142', 's', 'sy', 'shouyang', '', '县', '140725', '0354', 6);
INSERT INTO `sys_district` VALUES ('762', '太谷', '142', 't', 'tg', 'taigu', '', '县', '140726', '0354', 7);
INSERT INTO `sys_district` VALUES ('763', '祁县', '142', 'q', 'qx', 'qixian', '', '', '140727', '0354', 8);
INSERT INTO `sys_district` VALUES ('764', '平遥', '142', 'p', 'py', 'pingyao', '', '县', '140728', '0354', 9);
INSERT INTO `sys_district` VALUES ('765', '灵石', '142', 'l', 'ls', 'lingshi', '', '县', '140729', '0354', 10);
INSERT INTO `sys_district` VALUES ('766', '介休', '142', 'j', 'jx', 'jiexiu', '', '市', '140781', '0354', 11);
INSERT INTO `sys_district` VALUES ('767', '盐湖', '143', 'y', 'yh', 'yanhu', '', '区', '140802', '0359', 1);
INSERT INTO `sys_district` VALUES ('768', '临猗', '143', 'l', 'ly', 'linyi', '', '县', '140821', '0359', 2);
INSERT INTO `sys_district` VALUES ('769', '万荣', '143', 'w', 'wr', 'wanrong', '', '县', '140822', '0359', 3);
INSERT INTO `sys_district` VALUES ('77', '杨浦', '3', 'y', 'yp', 'yangpu', '', '区', '310110', '021', 8);
INSERT INTO `sys_district` VALUES ('770', '闻喜', '143', 'w', 'wx', 'wenxi', '', '县', '140823', '0359', 4);
INSERT INTO `sys_district` VALUES ('771', '稷山', '143', 'j', 'js', 'jishan', '', '县', '140824', '0359', 5);
INSERT INTO `sys_district` VALUES ('772', '新绛', '143', 'x', 'xj', 'xinjiang', '', '县', '140825', '0359', 6);
INSERT INTO `sys_district` VALUES ('773', '绛县', '143', 'j', 'jx', 'jiangxian', '', '', '140826', '0359', 7);
INSERT INTO `sys_district` VALUES ('774', '垣曲', '143', 'y', 'yq', 'yuanqu', '', '县', '140827', '0359', 8);
INSERT INTO `sys_district` VALUES ('775', '夏县', '143', 'x', 'xx', 'xiaxian', '', '', '140828', '0359', 9);
INSERT INTO `sys_district` VALUES ('776', '平陆', '143', 'p', 'pl', 'pinglu', '', '县', '140829', '0359', 10);
INSERT INTO `sys_district` VALUES ('777', '芮城', '143', 'r', 'rc', 'ruicheng', '', '县', '140830', '0359', 11);
INSERT INTO `sys_district` VALUES ('778', '永济', '143', 'y', 'yj', 'yongji', '', '市', '140881', '0359', 12);
INSERT INTO `sys_district` VALUES ('779', '河津', '143', 'h', 'hj', 'hejin', '', '市', '140882', '0359', 13);
INSERT INTO `sys_district` VALUES ('78', '闵行', '3', 'm', 'mx', 'minxing', '', '区', '310112', '021', 9);
INSERT INTO `sys_district` VALUES ('780', '忻府', '144', 'x', 'xf', 'xinfu', '', '区', '140902', '0350', 1);
INSERT INTO `sys_district` VALUES ('781', '定襄', '144', 'd', 'dx', 'dingxiang', '', '县', '140921', '0350', 2);
INSERT INTO `sys_district` VALUES ('782', '五台', '144', 'w', 'wt', 'wutai', '', '县', '140922', '0350', 3);
INSERT INTO `sys_district` VALUES ('783', '代县', '144', 'd', 'dx', 'daixian', '', '', '140923', '0350', 4);
INSERT INTO `sys_district` VALUES ('784', '繁峙', '144', 'f', 'fz', 'fanzhi', '', '县', '140924', '0350', 5);
INSERT INTO `sys_district` VALUES ('785', '宁武', '144', 'n', 'nw', 'ningwu', '', '县', '140925', '0350', 6);
INSERT INTO `sys_district` VALUES ('786', '静乐', '144', 'j', 'jl', 'jingle', '', '县', '140926', '0350', 7);
INSERT INTO `sys_district` VALUES ('787', '神池', '144', 's', 'sc', 'shenchi', '', '县', '140927', '0350', 8);
INSERT INTO `sys_district` VALUES ('788', '五寨', '144', 'w', 'wz', 'wuzhai', '', '县', '140928', '0350', 9);
INSERT INTO `sys_district` VALUES ('789', '岢岚', '144', 'k', 'kl', 'kelan', '', '县', '140929', '0350', 10);
INSERT INTO `sys_district` VALUES ('79', '宝山', '3', 'b', 'bs', 'baoshan', '', '区', '310113', '021', 10);
INSERT INTO `sys_district` VALUES ('790', '河曲', '144', 'h', 'hq', 'hequ', '', '县', '140930', '0350', 11);
INSERT INTO `sys_district` VALUES ('791', '保德', '144', 'b', 'bd', 'baode', '', '县', '140931', '0350', 12);
INSERT INTO `sys_district` VALUES ('792', '偏关', '144', 'p', 'pg', 'pianguan', '', '县', '140932', '0350', 13);
INSERT INTO `sys_district` VALUES ('793', '原平', '144', 'y', 'yp', 'yuanping', '', '市', '140981', '0350', 14);
INSERT INTO `sys_district` VALUES ('794', '尧都', '145', 'y', 'yd', 'yaodu', '', '区', '141002', '0357', 1);
INSERT INTO `sys_district` VALUES ('795', '曲沃', '145', 'q', 'qw', 'quwo', '', '县', '141021', '0357', 2);
INSERT INTO `sys_district` VALUES ('796', '翼城', '145', 'y', 'yc', 'yicheng', '', '县', '141022', '0357', 3);
INSERT INTO `sys_district` VALUES ('797', '襄汾', '145', 'x', 'xf', 'xiangfen', '', '县', '141023', '0357', 4);
INSERT INTO `sys_district` VALUES ('798', '洪洞', '145', 'h', 'hd', 'hongdong', '', '县', '141024', '0357', 5);
INSERT INTO `sys_district` VALUES ('799', '古县', '145', 'g', 'gx', 'guxian', '', '', '141025', '0357', 6);
INSERT INTO `sys_district` VALUES ('8', '辽宁', '0', 'l', 'ln', 'liaoning', '', '省', '210000', '', 9);
INSERT INTO `sys_district` VALUES ('80', '嘉定', '3', 'j', 'jd', 'jiading', '', '区', '310114', '021', 11);
INSERT INTO `sys_district` VALUES ('800', '安泽', '145', 'a', 'az', 'anze', '', '县', '141026', '0357', 7);
INSERT INTO `sys_district` VALUES ('801', '浮山', '145', 'f', 'fs', 'fushan', '', '县', '141027', '0357', 8);
INSERT INTO `sys_district` VALUES ('802', '吉县', '145', 'j', 'jx', 'jixian', '', '', '141028', '0357', 9);
INSERT INTO `sys_district` VALUES ('803', '乡宁', '145', 'x', 'xn', 'xiangning', '', '县', '141029', '0357', 10);
INSERT INTO `sys_district` VALUES ('804', '大宁', '145', 'd', 'dn', 'daning', '', '县', '141030', '0357', 11);
INSERT INTO `sys_district` VALUES ('805', '隰县', '145', 'x', 'xx', 'xixian', '', '', '141031', '0357', 12);
INSERT INTO `sys_district` VALUES ('806', '永和', '145', 'y', 'yh', 'yonghe', '', '县', '141032', '0357', 13);
INSERT INTO `sys_district` VALUES ('807', '蒲县', '145', 'p', 'px', 'puxian', '', '', '141033', '0357', 14);
INSERT INTO `sys_district` VALUES ('808', '汾西', '145', 'f', 'fx', 'fenxi', '', '县', '141034', '0357', 15);
INSERT INTO `sys_district` VALUES ('809', '侯马', '145', 'h', 'hm', 'houma', '', '市', '141081', '0357', 16);
INSERT INTO `sys_district` VALUES ('81', '浦东新区', '3', 'p', 'pdxq', 'pudongxinqu', '', '', '310115', '021', 12);
INSERT INTO `sys_district` VALUES ('810', '霍州', '145', 'h', 'hz', 'huozhou', '', '市', '141082', '0357', 17);
INSERT INTO `sys_district` VALUES ('811', '离石', '146', 'l', 'ls', 'lishi', '', '区', '141102', '0358', 1);
INSERT INTO `sys_district` VALUES ('812', '文水', '146', 'w', 'ws', 'wenshui', '', '县', '141121', '0358', 2);
INSERT INTO `sys_district` VALUES ('813', '交城', '146', 'j', 'jc', 'jiaocheng', '', '县', '141122', '0358', 3);
INSERT INTO `sys_district` VALUES ('814', '兴县', '146', 'x', 'xx', 'xingxian', '', '', '141123', '0358', 4);
INSERT INTO `sys_district` VALUES ('815', '临县', '146', 'l', 'lx', 'linxian', '', '', '141124', '0358', 5);
INSERT INTO `sys_district` VALUES ('816', '柳林', '146', 'l', 'll', 'liulin', '', '县', '141125', '0358', 6);
INSERT INTO `sys_district` VALUES ('817', '石楼', '146', 's', 'sl', 'shilou', '', '县', '141126', '0358', 7);
INSERT INTO `sys_district` VALUES ('818', '岚县', '146', 'l', 'lx', 'lanxian', '', '', '141127', '0358', 8);
INSERT INTO `sys_district` VALUES ('819', '方山', '146', 'f', 'fs', 'fangshan', '', '县', '141128', '0358', 9);
INSERT INTO `sys_district` VALUES ('82', '金山', '3', 'j', 'js', 'jinshan', '', '区', '310116', '021', 13);
INSERT INTO `sys_district` VALUES ('820', '中阳', '146', 'z', 'zy', 'zhongyang', '', '县', '141129', '0358', 10);
INSERT INTO `sys_district` VALUES ('821', '交口', '146', 'j', 'jk', 'jiaokou', '', '县', '141130', '0358', 11);
INSERT INTO `sys_district` VALUES ('822', '孝义', '146', 'x', 'xy', 'xiaoyi', '', '市', '141181', '0358', 12);
INSERT INTO `sys_district` VALUES ('823', '汾阳', '146', 'f', 'fy', 'fenyang', '', '市', '141182', '0358', 13);
INSERT INTO `sys_district` VALUES ('824', '新城', '147', 'x', 'xc', 'xincheng', '', '区', '150102', '0471', 1);
INSERT INTO `sys_district` VALUES ('825', '回民', '147', 'h', 'hm', 'huimin', '', '区', '150103', '0471', 2);
INSERT INTO `sys_district` VALUES ('826', '玉泉', '147', 'y', 'yq', 'yuquan', '', '区', '150104', '0471', 3);
INSERT INTO `sys_district` VALUES ('827', '赛罕', '147', 's', 'sh', 'saihan', '', '区', '150105', '0471', 4);
INSERT INTO `sys_district` VALUES ('828', '土默特左', '147', 't', 'tmtz', 'tumotezuo', '', '旗', '150121', '0471', 5);
INSERT INTO `sys_district` VALUES ('829', '托克托', '147', 't', 'tkt', 'tuoketuo', '', '县', '150122', '0471', 6);
INSERT INTO `sys_district` VALUES ('83', '松江', '3', 's', 'sj', 'songjiang', '', '区', '310117', '021', 14);
INSERT INTO `sys_district` VALUES ('830', '和林格尔', '147', 'h', 'hlge', 'helingeer', '', '县', '150123', '0471', 7);
INSERT INTO `sys_district` VALUES ('831', '清水河', '147', 'q', 'qsh', 'qingshuihe', '', '县', '150124', '0471', 8);
INSERT INTO `sys_district` VALUES ('832', '武川', '147', 'w', 'wc', 'wuchuan', '', '县', '150125', '0471', 9);
INSERT INTO `sys_district` VALUES ('833', '东河', '148', 'd', 'dh', 'donghe', '', '区', '150202', '0472', 1);
INSERT INTO `sys_district` VALUES ('834', '昆都仑', '148', 'k', 'kdl', 'kundulun', '', '区', '150203', '0472', 2);
INSERT INTO `sys_district` VALUES ('835', '青山', '148', 'q', 'qs', 'qingshan', '', '区', '150204', '0472', 3);
INSERT INTO `sys_district` VALUES ('836', '石拐', '148', 's', 'sg', 'shiguai', '', '区', '150205', '0472', 4);
INSERT INTO `sys_district` VALUES ('837', '白云', '148', 'b', 'by', 'baiyun', '矿', '区', '150206', '0472', 5);
INSERT INTO `sys_district` VALUES ('838', '九原', '148', 'j', 'jy', 'jiuyuan', '', '区', '150207', '0472', 6);
INSERT INTO `sys_district` VALUES ('839', '土默特右', '148', 't', 'tmty', 'tumoteyou', '', '旗', '150221', '0472', 7);
INSERT INTO `sys_district` VALUES ('84', '青浦', '3', 'q', 'qp', 'qingpu', '', '区', '310118', '021', 15);
INSERT INTO `sys_district` VALUES ('840', '固阳', '148', 'g', 'gy', 'guyang', '', '县', '150222', '0472', 8);
INSERT INTO `sys_district` VALUES ('841', '达尔罕茂明安', '148', 'd', 'dehmma', 'daerhanmaomingan', '联合', '旗', '150223', '0472', 9);
INSERT INTO `sys_district` VALUES ('842', '海勃湾', '149', 'h', 'hbw', 'haibowan', '', '区', '150302', '0473', 1);
INSERT INTO `sys_district` VALUES ('843', '海南', '149', 'h', 'hn', 'hainan', '', '区', '150303', '0473', 2);
INSERT INTO `sys_district` VALUES ('844', '乌达', '149', 'w', 'wd', 'wuda', '', '区', '150304', '0473', 3);
INSERT INTO `sys_district` VALUES ('845', '红山', '150', 'h', 'hs', 'hongshan', '', '区', '150402', '0476', 1);
INSERT INTO `sys_district` VALUES ('846', '元宝山', '150', 'y', 'ybs', 'yuanbaoshan', '', '区', '150403', '0476', 2);
INSERT INTO `sys_district` VALUES ('847', '松山', '150', 's', 'ss', 'songshan', '', '区', '150404', '0476', 3);
INSERT INTO `sys_district` VALUES ('848', '阿鲁科尔沁', '150', 'a', 'alkeq', 'alukeerqin', '', '旗', '150421', '0476', 4);
INSERT INTO `sys_district` VALUES ('849', '巴林左', '150', 'b', 'blz', 'balinzuo', '', '旗', '150422', '0476', 5);
INSERT INTO `sys_district` VALUES ('85', '奉贤', '3', 'f', 'fx', 'fengxian', '', '区', '310120', '021', 16);
INSERT INTO `sys_district` VALUES ('850', '巴林右', '150', 'b', 'bly', 'balinyou', '', '旗', '150423', '0476', 6);
INSERT INTO `sys_district` VALUES ('851', '林西', '150', 'l', 'lx', 'linxi', '', '县', '150424', '0476', 7);
INSERT INTO `sys_district` VALUES ('852', '克什克腾', '150', 'k', 'kskt', 'keshenketeng', '', '旗', '150425', '0476', 8);
INSERT INTO `sys_district` VALUES ('853', '翁牛特', '150', 'w', 'wnt', 'wengniute', '', '旗', '150426', '0476', 9);
INSERT INTO `sys_district` VALUES ('854', '喀喇沁', '150', 'k', 'klq', 'kalaqin', '', '旗', '150428', '0476', 10);
INSERT INTO `sys_district` VALUES ('855', '宁城', '150', 'n', 'nc', 'ningcheng', '', '县', '150429', '0476', 11);
INSERT INTO `sys_district` VALUES ('856', '敖汉', '150', 'a', 'ah', 'aohan', '', '旗', '150430', '0476', 12);
INSERT INTO `sys_district` VALUES ('857', '科尔沁', '151', 'k', 'keq', 'keerqin', '', '区', '150502', '0475', 1);
INSERT INTO `sys_district` VALUES ('858', '科尔沁左翼中', '151', 'k', 'keqzyz', 'keerqinzuoyizhong', '', '旗', '150521', '0475', 2);
INSERT INTO `sys_district` VALUES ('859', '科尔沁左翼后', '151', 'k', 'keqzyh', 'keerqinzuoyihou', '', '旗', '150522', '0475', 3);
INSERT INTO `sys_district` VALUES ('86', '崇明', '3', 'c', 'cm', 'chongming', '', '区', '310230', '021', 17);
INSERT INTO `sys_district` VALUES ('860', '开鲁', '151', 'k', 'kl', 'kailu', '', '县', '150523', '0475', 4);
INSERT INTO `sys_district` VALUES ('861', '库伦', '151', 'k', 'kl', 'kulun', '', '旗', '150524', '0475', 5);
INSERT INTO `sys_district` VALUES ('862', '奈曼', '151', 'n', 'nm', 'naiman', '', '旗', '150525', '0475', 6);
INSERT INTO `sys_district` VALUES ('863', '扎鲁特', '151', 'z', 'zlt', 'zhalute', '', '旗', '150526', '0475', 7);
INSERT INTO `sys_district` VALUES ('864', '霍林郭勒', '151', 'h', 'hlgl', 'huolinguole', '', '市', '150581', '0475', 8);
INSERT INTO `sys_district` VALUES ('865', '东胜', '152', 'd', 'ds', 'dongsheng', '', '区', '150602', '0477', 1);
INSERT INTO `sys_district` VALUES ('866', '达拉特', '152', 'd', 'dlt', 'dalate', '', '旗', '150621', '0477', 2);
INSERT INTO `sys_district` VALUES ('867', '准格尔', '152', 'z', 'zge', 'zhungeer', '', '旗', '150622', '0477', 3);
INSERT INTO `sys_district` VALUES ('868', '鄂托克前', '152', 'e', 'etkq', 'etuokeqian', '', '旗', '150623', '0477', 4);
INSERT INTO `sys_district` VALUES ('869', '鄂托克', '152', 'e', 'etk', 'etuoke', '', '旗', '150624', '0477', 5);
INSERT INTO `sys_district` VALUES ('87', '万州', '4', 'w', 'wz', 'wanzhou', '', '区', '500101', '023', 1);
INSERT INTO `sys_district` VALUES ('870', '杭锦', '152', 'h', 'hj', 'hangjin', '', '旗', '150625', '0477', 6);
INSERT INTO `sys_district` VALUES ('871', '乌审', '152', 'w', 'ws', 'wushen', '', '旗', '150626', '0477', 7);
INSERT INTO `sys_district` VALUES ('872', '伊金霍洛', '152', 'y', 'yjhl', 'yijinhuoluo', '', '旗', '150627', '0477', 8);
INSERT INTO `sys_district` VALUES ('873', '海拉尔', '153', 'h', 'hle', 'hailaer', '', '区', '150702', '0470', 1);
INSERT INTO `sys_district` VALUES ('874', '阿荣', '153', 'a', 'ar', 'arong', '', '旗', '150721', '0470', 2);
INSERT INTO `sys_district` VALUES ('875', '莫力达瓦', '153', 'm', 'mldw', 'molidawa', '达斡尔族', '自治旗', '150722', '0470', 3);
INSERT INTO `sys_district` VALUES ('876', '鄂伦春', '153', 'e', 'elc', 'elunchun', '', '自治旗', '150723', '0470', 4);
INSERT INTO `sys_district` VALUES ('877', '鄂温克族', '153', 'e', 'ewkz', 'ewenkezu', '', '自治旗', '150724', '0470', 5);
INSERT INTO `sys_district` VALUES ('878', '陈巴尔虎', '153', 'c', 'cbeh', 'chenbaerhu', '', '旗', '150725', '0470', 6);
INSERT INTO `sys_district` VALUES ('879', '新巴尔虎左', '153', 'x', 'xbehz', 'xinbaerhuzuo', '', '旗', '150726', '0470', 7);
INSERT INTO `sys_district` VALUES ('88', '涪陵', '4', 'f', 'fl', 'fuling', '', '区', '500102', '023', 2);
INSERT INTO `sys_district` VALUES ('880', '新巴尔虎右', '153', 'x', 'xbehy', 'xinbaerhuyou', '', '旗', '150727', '0470', 8);
INSERT INTO `sys_district` VALUES ('881', '满洲里', '153', 'm', 'mzl', 'manzhouli', '', '市', '150781', '0470', 9);
INSERT INTO `sys_district` VALUES ('882', '牙克石', '153', 'y', 'yks', 'yakeshi', '', '市', '150782', '0470', 10);
INSERT INTO `sys_district` VALUES ('883', '扎兰屯', '153', 'z', 'zlt', 'zhalantun', '', '市', '150783', '0470', 11);
INSERT INTO `sys_district` VALUES ('884', '额尔古纳', '153', 'e', 'eegn', 'eerguna', '', '市', '150784', '0470', 12);
INSERT INTO `sys_district` VALUES ('885', '根河', '153', 'g', 'gh', 'genhe', '', '市', '150785', '0470', 13);
INSERT INTO `sys_district` VALUES ('886', '临河', '154', 'l', 'lh', 'linhe', '', '区', '150802', '0478', 1);
INSERT INTO `sys_district` VALUES ('887', '五原', '154', 'w', 'wy', 'wuyuan', '', '县', '150821', '0478', 2);
INSERT INTO `sys_district` VALUES ('888', '磴口', '154', 'd', 'dk', 'dengkou', '', '县', '150822', '0478', 3);
INSERT INTO `sys_district` VALUES ('889', '乌拉特前', '154', 'w', 'wltq', 'wulateqian', '', '旗', '150823', '0478', 4);
INSERT INTO `sys_district` VALUES ('89', '渝中', '4', 'y', 'yz', 'yuzhong', '', '区', '500103', '023', 3);
INSERT INTO `sys_district` VALUES ('890', '乌拉特中', '154', 'w', 'wltz', 'wulatezhong', '', '旗', '150824', '0478', 5);
INSERT INTO `sys_district` VALUES ('891', '乌拉特后', '154', 'w', 'wlth', 'wulatehou', '', '旗', '150825', '0478', 6);
INSERT INTO `sys_district` VALUES ('892', '杭锦后', '154', 'h', 'hjh', 'hangjinhou', '', '旗', '150826', '0478', 7);
INSERT INTO `sys_district` VALUES ('893', '集宁', '155', 'j', 'jn', 'jining', '', '区', '150902', '0474', 1);
INSERT INTO `sys_district` VALUES ('894', '卓资', '155', 'z', 'zz', 'zhuozi', '', '县', '150921', '0474', 2);
INSERT INTO `sys_district` VALUES ('895', '化德', '155', 'h', 'hd', 'huade', '', '县', '150922', '0474', 3);
INSERT INTO `sys_district` VALUES ('896', '商都', '155', 's', 'sd', 'shangdu', '', '县', '150923', '0474', 4);
INSERT INTO `sys_district` VALUES ('897', '兴和', '155', 'x', 'xh', 'xinghe', '', '县', '150924', '0474', 5);
INSERT INTO `sys_district` VALUES ('898', '凉城', '155', 'l', 'lc', 'liangcheng', '', '县', '150925', '0474', 6);
INSERT INTO `sys_district` VALUES ('899', '察哈尔右翼前', '155', 'c', 'cheyyq', 'chahaeryouyiqian', '', '旗', '150926', '0474', 7);
INSERT INTO `sys_district` VALUES ('9', '吉林', '0', 'j', 'jl', 'jilin', '', '省', '220000', '', 10);
INSERT INTO `sys_district` VALUES ('90', '大渡口', '4', 'd', 'ddk', 'dadukou', '', '区', '500104', '023', 4);
INSERT INTO `sys_district` VALUES ('900', '察哈尔右翼中', '155', 'c', 'cheyyz', 'chahaeryouyizhong', '', '旗', '150927', '0474', 8);
INSERT INTO `sys_district` VALUES ('901', '察哈尔右翼后', '155', 'c', 'cheyyh', 'chahaeryouyihou', '', '旗', '150928', '0474', 9);
INSERT INTO `sys_district` VALUES ('902', '四子王', '155', 's', 'szw', 'siziwang', '', '旗', '150929', '0474', 10);
INSERT INTO `sys_district` VALUES ('903', '丰镇', '155', 'f', 'fz', 'fengzhen', '', '市', '150981', '0474', 11);
INSERT INTO `sys_district` VALUES ('904', '乌兰浩特', '156', 'w', 'wlht', 'wulanhaote', '', '市', '152201', '0482', 1);
INSERT INTO `sys_district` VALUES ('905', '阿尔山', '156', 'a', 'aes', 'aershan', '', '市', '152202', '0482', 2);
INSERT INTO `sys_district` VALUES ('906', '科尔沁右翼前', '156', 'k', 'keqyyq', 'keerqinyouyiqian', '', '旗', '152221', '0482', 3);
INSERT INTO `sys_district` VALUES ('907', '科尔沁右翼中', '156', 'k', 'keqyyz', 'keerqinyouyizhong', '', '旗', '152222', '0482', 4);
INSERT INTO `sys_district` VALUES ('908', '扎赉特', '156', 'z', 'zlt', 'zhalaite', '', '旗', '152223', '0482', 5);
INSERT INTO `sys_district` VALUES ('909', '突泉', '156', 't', 'tq', 'tuquan', '', '县', '152224', '0482', 6);
INSERT INTO `sys_district` VALUES ('91', '江北', '4', 'j', 'jb', 'jiangbei', '', '区', '500105', '023', 5);
INSERT INTO `sys_district` VALUES ('910', '二连浩特', '157', 'e', 'elht', 'erlianhaote', '', '市', '152501', '0479', 1);
INSERT INTO `sys_district` VALUES ('911', '锡林浩特', '157', 'x', 'xlht', 'xilinhaote', '', '市', '152502', '0479', 2);
INSERT INTO `sys_district` VALUES ('912', '阿巴嘎', '157', 'a', 'abg', 'abaga', '', '旗', '152522', '0479', 3);
INSERT INTO `sys_district` VALUES ('913', '苏尼特左', '157', 's', 'sntz', 'sunitezuo', '', '旗', '152523', '0479', 4);
INSERT INTO `sys_district` VALUES ('914', '苏尼特右', '157', 's', 'snty', 'suniteyou', '', '旗', '152524', '0479', 5);
INSERT INTO `sys_district` VALUES ('915', '东乌珠穆沁', '157', 'd', 'dwzmq', 'dongwuzhumuqin', '', '旗', '152525', '0479', 6);
INSERT INTO `sys_district` VALUES ('916', '西乌珠穆沁', '157', 'x', 'xwzmq', 'xiwuzhumuqin', '', '旗', '152526', '0479', 7);
INSERT INTO `sys_district` VALUES ('917', '太仆寺', '157', 't', 'tps', 'taipusi', '', '旗', '152527', '0479', 8);
INSERT INTO `sys_district` VALUES ('918', '镶黄', '157', 'x', 'xh', 'xianghuang', '', '旗', '152528', '0479', 9);
INSERT INTO `sys_district` VALUES ('919', '正镶白', '157', 'z', 'zxb', 'zhengxiangbai', '', '旗', '152529', '0479', 10);
INSERT INTO `sys_district` VALUES ('92', '沙坪坝', '4', 's', 'spb', 'shapingba', '', '区', '500106', '023', 6);
INSERT INTO `sys_district` VALUES ('920', '正蓝', '157', 'z', 'zl', 'zhenglan', '', '旗', '152530', '0479', 11);
INSERT INTO `sys_district` VALUES ('921', '多伦', '157', 'd', 'dl', 'duolun', '', '县', '152531', '0479', 12);
INSERT INTO `sys_district` VALUES ('922', '阿拉善左', '158', 'a', 'alsz', 'alashanzuo', '', '旗', '152921', '0483', 1);
INSERT INTO `sys_district` VALUES ('923', '阿拉善右', '158', 'a', 'alsy', 'alashanyou', '', '旗', '152922', '0483', 2);
INSERT INTO `sys_district` VALUES ('924', '额济纳', '158', 'e', 'ejn', 'ejina', '', '旗', '152923', '0483', 3);
INSERT INTO `sys_district` VALUES ('925', '和平', '159', 'h', 'hp', 'heping', '', '区', '210102', '024', 1);
INSERT INTO `sys_district` VALUES ('926', '沈河', '159', 's', 'sh', 'shenhe', '', '区', '210103', '024', 2);
INSERT INTO `sys_district` VALUES ('927', '大东', '159', 'd', 'dd', 'dadong', '', '区', '210104', '024', 3);
INSERT INTO `sys_district` VALUES ('928', '皇姑', '159', 'h', 'hg', 'huanggu', '', '区', '210105', '024', 4);
INSERT INTO `sys_district` VALUES ('929', '铁西', '159', 't', 'tx', 'tiexi', '', '区', '210106', '024', 5);
INSERT INTO `sys_district` VALUES ('93', '九龙坡', '4', 'j', 'jlp', 'jiulongpo', '', '区', '500107', '023', 7);
INSERT INTO `sys_district` VALUES ('930', '苏家屯', '159', 's', 'sjt', 'sujiatun', '', '区', '210111', '024', 6);
INSERT INTO `sys_district` VALUES ('931', '浑南', '159', 'h', 'hn', 'hunnan', '', '区', '210112', '024', 7);
INSERT INTO `sys_district` VALUES ('932', '沈北新区', '159', 's', 'sbxq', 'shenbeixinqu', '', '', '210113', '024', 8);
INSERT INTO `sys_district` VALUES ('933', '于洪', '159', 'y', 'yh', 'yuhong', '', '区', '210114', '024', 9);
INSERT INTO `sys_district` VALUES ('934', '辽中', '159', 'l', 'lz', 'liaozhong', '', '区', '210122', '024', 10);
INSERT INTO `sys_district` VALUES ('935', '康平', '159', 'k', 'kp', 'kangping', '', '县', '210123', '024', 11);
INSERT INTO `sys_district` VALUES ('936', '法库', '159', 'f', 'fk', 'faku', '', '县', '210124', '024', 12);
INSERT INTO `sys_district` VALUES ('937', '新民', '159', 'x', 'xm', 'xinmin', '', '市', '210181', '024', 13);
INSERT INTO `sys_district` VALUES ('938', '中山', '160', 'z', 'zs', 'zhongshan', '', '区', '210202', '0411', 1);
INSERT INTO `sys_district` VALUES ('939', '西岗', '160', 'x', 'xg', 'xigang', '', '区', '210203', '0411', 2);
INSERT INTO `sys_district` VALUES ('94', '南岸', '4', 'n', 'na', 'nanan', '', '区', '500108', '023', 8);
INSERT INTO `sys_district` VALUES ('940', '沙河口', '160', 's', 'shk', 'shahekou', '', '区', '210204', '0411', 3);
INSERT INTO `sys_district` VALUES ('941', '甘井子', '160', 'g', 'gjz', 'ganjingzi', '', '区', '210211', '0411', 4);
INSERT INTO `sys_district` VALUES ('942', '旅顺口', '160', 'l', 'lsk', 'lu:shunkou', '', '区', '210212', '0411', 5);
INSERT INTO `sys_district` VALUES ('943', '金州', '160', 'j', 'jz', 'jinzhou', '', '区', '210213', '0411', 6);
INSERT INTO `sys_district` VALUES ('944', '长海', '160', 'z', 'zh', 'zhanghai', '', '县', '210224', '0411', 7);
INSERT INTO `sys_district` VALUES ('945', '瓦房店', '160', 'w', 'wfd', 'wafangdian', '', '市', '210281', '0411', 8);
INSERT INTO `sys_district` VALUES ('946', '普兰店', '160', 'p', 'pld', 'pulandian', '', '区', '210282', '0411', 9);
INSERT INTO `sys_district` VALUES ('947', '庄河', '160', 'z', 'zh', 'zhuanghe', '', '市', '210283', '0411', 10);
INSERT INTO `sys_district` VALUES ('948', '铁东', '161', 't', 'td', 'tiedong', '', '区', '210302', '0412', 1);
INSERT INTO `sys_district` VALUES ('949', '铁西', '161', 't', 'tx', 'tiexi', '', '区', '210303', '0412', 2);
INSERT INTO `sys_district` VALUES ('95', '北碚', '4', 'b', 'bb', 'beibei', '', '区', '500109', '023', 9);
INSERT INTO `sys_district` VALUES ('950', '立山', '161', 'l', 'ls', 'lishan', '', '区', '210304', '0412', 3);
INSERT INTO `sys_district` VALUES ('951', '千山', '161', 'q', 'qs', 'qianshan', '', '区', '210311', '0412', 4);
INSERT INTO `sys_district` VALUES ('952', '台安', '161', 't', 'ta', 'taian', '', '县', '210321', '0412', 5);
INSERT INTO `sys_district` VALUES ('953', '岫岩', '161', 'x', 'xy', 'xiuyan', '满族', '自治县', '210323', '0412', 6);
INSERT INTO `sys_district` VALUES ('954', '海城', '161', 'h', 'hc', 'haicheng', '', '市', '210381', '0412', 7);
INSERT INTO `sys_district` VALUES ('955', '新抚', '162', 'x', 'xf', 'xinfu', '', '区', '210402', '0413', 1);
INSERT INTO `sys_district` VALUES ('956', '东洲', '162', 'd', 'dz', 'dongzhou', '', '区', '210403', '0413', 2);
INSERT INTO `sys_district` VALUES ('957', '望花', '162', 'w', 'wh', 'wanghua', '', '区', '210404', '0413', 3);
INSERT INTO `sys_district` VALUES ('958', '顺城', '162', 's', 'sc', 'shuncheng', '', '区', '210411', '0413', 4);
INSERT INTO `sys_district` VALUES ('959', '抚顺', '162', 'f', 'fs', 'fushun', '', '县', '210421', '0413', 5);
INSERT INTO `sys_district` VALUES ('96', '綦江', '4', 'q', 'qj', 'qijiang', '', '区', '500110', '023', 10);
INSERT INTO `sys_district` VALUES ('960', '新宾', '162', 'x', 'xb', 'xinbin', '满族', '自治县', '210422', '0413', 6);
INSERT INTO `sys_district` VALUES ('961', '清原', '162', 'q', 'qy', 'qingyuan', '满族', '自治县', '210423', '0413', 7);
INSERT INTO `sys_district` VALUES ('962', '平山', '163', 'p', 'ps', 'pingshan', '', '区', '210502', '0414', 1);
INSERT INTO `sys_district` VALUES ('963', '溪湖', '163', 'x', 'xh', 'xihu', '', '区', '210503', '0414', 2);
INSERT INTO `sys_district` VALUES ('964', '明山', '163', 'm', 'ms', 'mingshan', '', '区', '210504', '0414', 3);
INSERT INTO `sys_district` VALUES ('965', '南芬', '163', 'n', 'nf', 'nanfen', '', '区', '210505', '0414', 4);
INSERT INTO `sys_district` VALUES ('966', '本溪', '163', 'b', 'bx', 'benxi', '满族', '自治县', '210521', '0414', 5);
INSERT INTO `sys_district` VALUES ('967', '桓仁', '163', 'h', 'hr', 'huanren', '满族', '自治县', '210522', '0414', 6);
INSERT INTO `sys_district` VALUES ('968', '元宝', '164', 'y', 'yb', 'yuanbao', '', '区', '210602', '0415', 1);
INSERT INTO `sys_district` VALUES ('969', '振兴', '164', 'z', 'zx', 'zhenxing', '', '区', '210603', '0415', 2);
INSERT INTO `sys_district` VALUES ('97', '大足', '4', 'd', 'dz', 'dazu', '', '区', '500111', '023', 11);
INSERT INTO `sys_district` VALUES ('970', '振安', '164', 'z', 'za', 'zhenan', '', '区', '210604', '0415', 3);
INSERT INTO `sys_district` VALUES ('971', '宽甸', '164', 'k', 'kd', 'kuandian', '满族', '自治县', '210624', '0415', 4);
INSERT INTO `sys_district` VALUES ('972', '东港', '164', 'd', 'dg', 'donggang', '', '市', '210681', '0415', 5);
INSERT INTO `sys_district` VALUES ('973', '凤城', '164', 'f', 'fc', 'fengcheng', '', '市', '210682', '0415', 6);
INSERT INTO `sys_district` VALUES ('974', '古塔', '165', 'g', 'gt', 'guta', '', '区', '210702', '0416', 1);
INSERT INTO `sys_district` VALUES ('975', '凌河', '165', 'l', 'lh', 'linghe', '', '区', '210703', '0416', 2);
INSERT INTO `sys_district` VALUES ('976', '太和', '165', 't', 'th', 'taihe', '', '区', '210711', '0416', 3);
INSERT INTO `sys_district` VALUES ('977', '黑山', '165', 'h', 'hs', 'heishan', '', '县', '210726', '0416', 4);
INSERT INTO `sys_district` VALUES ('978', '义县', '165', 'y', 'yx', 'yixian', '', '', '210727', '0416', 5);
INSERT INTO `sys_district` VALUES ('979', '凌海', '165', 'l', 'lh', 'linghai', '', '市', '210781', '0416', 6);
INSERT INTO `sys_district` VALUES ('98', '渝北', '4', 'y', 'yb', 'yubei', '', '区', '500112', '023', 12);
INSERT INTO `sys_district` VALUES ('980', '北镇', '165', 'b', 'bz', 'beizhen', '', '市', '210782', '0416', 7);
INSERT INTO `sys_district` VALUES ('981', '站前', '166', 'z', 'zq', 'zhanqian', '', '区', '210802', '0417', 1);
INSERT INTO `sys_district` VALUES ('982', '西市', '166', 'x', 'xs', 'xishi', '', '区', '210803', '0417', 2);
INSERT INTO `sys_district` VALUES ('983', '鲅鱼圈', '166', 'b', 'byq', 'bayuquan', '', '区', '210804', '0417', 3);
INSERT INTO `sys_district` VALUES ('984', '老边', '166', 'l', 'lb', 'laobian', '', '区', '210811', '0417', 4);
INSERT INTO `sys_district` VALUES ('985', '盖州', '166', 'g', 'gz', 'gaizhou', '', '市', '210881', '0417', 5);
INSERT INTO `sys_district` VALUES ('986', '大石桥', '166', 'd', 'dsq', 'dashiqiao', '', '市', '210882', '0417', 6);
INSERT INTO `sys_district` VALUES ('987', '海州', '167', 'h', 'hz', 'haizhou', '', '区', '210902', '0418', 1);
INSERT INTO `sys_district` VALUES ('988', '新邱', '167', 'x', 'xq', 'xinqiu', '', '区', '210903', '0418', 2);
INSERT INTO `sys_district` VALUES ('989', '太平', '167', 't', 'tp', 'taiping', '', '区', '210904', '0418', 3);
INSERT INTO `sys_district` VALUES ('99', '巴南', '4', 'b', 'bn', 'banan', '', '区', '500113', '023', 13);
INSERT INTO `sys_district` VALUES ('990', '清河门', '167', 'q', 'qhm', 'qinghemen', '', '区', '210905', '0418', 4);
INSERT INTO `sys_district` VALUES ('991', '细河', '167', 'x', 'xh', 'xihe', '', '区', '210911', '0418', 5);
INSERT INTO `sys_district` VALUES ('992', '阜新', '167', 'f', 'fx', 'fuxin', '蒙古族', '自治县', '210921', '0418', 6);
INSERT INTO `sys_district` VALUES ('993', '彰武', '167', 'z', 'zw', 'zhangwu', '', '县', '210922', '0418', 7);
INSERT INTO `sys_district` VALUES ('994', '白塔', '168', 'b', 'bt', 'baita', '', '区', '211002', '0419', 1);
INSERT INTO `sys_district` VALUES ('995', '文圣', '168', 'w', 'ws', 'wensheng', '', '区', '211003', '0419', 2);
INSERT INTO `sys_district` VALUES ('996', '宏伟', '168', 'h', 'hw', 'hongwei', '', '区', '211004', '0419', 3);
INSERT INTO `sys_district` VALUES ('997', '弓长岭', '168', 'g', 'gzl', 'gongzhangling', '', '区', '211005', '0419', 4);
INSERT INTO `sys_district` VALUES ('998', '辽阳', '168', 'l', 'ly', 'liaoyang', '', '县', '211021', '0419', 5);
INSERT INTO `sys_district` VALUES ('999', '灯塔', '168', 'd', 'dt', 'dengta', '', '市', '211081', '0419', 6);
COMMIT;

-- ----------------------------
-- Table structure for sys_download
-- ----------------------------
DROP TABLE IF EXISTS `sys_download`;
CREATE TABLE `sys_download` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '路径',
  `effective_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '有效期类型',
  `expire` datetime DEFAULT NULL COMMENT '过期时间',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '文件类型',
  `length` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `auth` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '授权（保留）',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '权限代码（保留）',
  `status` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='下载 ';

-- ----------------------------
-- Records of sys_download
-- ----------------------------
BEGIN;
INSERT INTO `sys_download` VALUES ('0e31d218aa264fa4afb202337381a34b', '导出示例', '/Users/tengchong/development/easy-admin/temporary/2021/2/4/46cfedc2-cdca-490b-925c-7f7aab0b2eeb.xlsx', 'general', '2021-02-05 10:00:55', 'xlsx', 25088, NULL, NULL, NULL, NULL, '1', '2021-02-04 22:00:55');
INSERT INTO `sys_download` VALUES ('5ba90bca83d0b2ce3c4eec08e237e087', '导出示例.xls', '/Users/tengchong/development/easy-admin/temporary/2021/2/4/9ef61abf-e989-4694-9745-3b43d40b614a.xls', 'general', '2021-02-05 10:05:18', 'xls', 25088, NULL, NULL, NULL, NULL, '1', '2021-02-04 22:05:18');
INSERT INTO `sys_download` VALUES ('5e4615e3ef1ad789663102ad6e006238', '导出示例', '/Users/tengchong/development/easy-admin/temporary/2021/2/4/1d82ffc5-eb52-4251-853d-4017dcbb42b0.xls', 'general', '2021-02-05 10:03:05', 'xls', 25088, NULL, NULL, NULL, NULL, '1', '2021-02-04 22:03:05');
INSERT INTO `sys_download` VALUES ('735ee01cef7026a10a3b4f93be919838', '导出示例', '/Users/tengchong/development/easy-admin/temporary/2021/2/4/2f081cc7-7bc9-4c48-be3b-289b4d4cda00.xls', 'general', '2021-02-05 10:04:50', 'xls', 25088, NULL, NULL, NULL, NULL, '1', '2021-02-04 22:04:50');
INSERT INTO `sys_download` VALUES ('78f281a55f66b1893defdb86d644ac75', '导出示例', '/Users/tengchong/development/easy-admin/temporary/2021/2/4/dc5500e7-1c60-4713-9b5b-b2cc95507364.xls', 'general', '2021-02-05 10:03:31', 'xls', 25088, NULL, NULL, NULL, NULL, '1', '2021-02-04 22:03:31');
INSERT INTO `sys_download` VALUES ('7b2e3763a32aab46c43b021c1220ac7d', '代码生成示例.xls', '/Users/tengchong/development/easy-admin/temporary/2021/2/23/aa28ea7d-72eb-4b09-877f-c9cd0aa2c096.xls', 'general', '2021-02-24 04:35:37', 'xls', 27648, NULL, NULL, NULL, NULL, '1', '2021-02-23 16:35:37');
INSERT INTO `sys_download` VALUES ('904b8d79a043f01660f4b2f9ad4e173b', '导出示例', '/Users/tengchong/development/easy-admin/temporary/2021/2/4/bdf38b59-d1bb-4a9b-90bf-eb3f5d8e4c2a.xls', 'general', '2021-02-05 10:02:08', 'xls', 25088, NULL, NULL, NULL, NULL, '1', '2021-02-04 22:02:08');
INSERT INTO `sys_download` VALUES ('c905fd15f33781cb7eb283d0f22da5ed', '导出示例', '/Users/tengchong/development/easy-admin/temporary/2021/2/4/d541330c-499d-48e6-997c-04287892df9c.xlsx', 'general', '2021-02-05 10:01:35', 'xlsx', 25088, NULL, NULL, NULL, NULL, '1', '2021-02-04 22:01:35');
COMMIT;

-- ----------------------------
-- Table structure for sys_exception
-- ----------------------------
DROP TABLE IF EXISTS `sys_exception`;
CREATE TABLE `sys_exception` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '触发用户',
  `trigger_time` datetime DEFAULT NULL COMMENT '触发时间',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '异常类型',
  `trace` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '错误堆栈',
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '错误信息',
  `url` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求地址',
  `code` int(11) DEFAULT NULL COMMENT '错误代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='异常日志';

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `p_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '父id',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `display_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '文件名称',
  `path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '路径',
  `size` bigint(20) DEFAULT NULL COMMENT '大小',
  `order_no` int(3) DEFAULT NULL COMMENT '排序值',
  `remarks` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `edit_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文件 ';

-- ----------------------------
-- Table structure for sys_import_excel_template
-- ----------------------------
DROP TABLE IF EXISTS `sys_import_excel_template`;
CREATE TABLE `sys_import_excel_template` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入模板名称',
  `import_table` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入表',
  `start_row` int(11) DEFAULT NULL COMMENT '起始行',
  `callback` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '回调',
  `import_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '模板代码',
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限代码',
  `remarks` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `data_source` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据源',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `edit_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='导入模板';

-- ----------------------------
-- Records of sys_import_excel_template
-- ----------------------------
BEGIN;
INSERT INTO `sys_import_excel_template` VALUES ('aa09908efded36b3d1784486995b39d4', '代码生成示例', 'sample_general', 1, 'sampleGeneralServiceImpl', 'sample:general', 'sample:general:import:data', NULL, NULL, '1', '2021-02-23 16:44:56', '1', '2021-02-23 16:44:56');
COMMIT;

-- ----------------------------
-- Table structure for sys_import_excel_template_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_import_excel_template_details`;
CREATE TABLE `sys_import_excel_template_details` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `template_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '模板id',
  `field_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据库字段名',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `field_length` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段长度',
  `field_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段类型',
  `replace_table` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '替换表',
  `replace_table_field_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '替换表-名称',
  `replace_table_field_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '替换表-值',
  `replace_table_dict_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '替换表-字典类型',
  `order_no` int(3) DEFAULT NULL COMMENT '排序值',
  `required` int(1) DEFAULT NULL COMMENT '是否必填',
  `only` int(1) DEFAULT NULL COMMENT '是否唯一',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `edit_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='导入模板详情';

-- ----------------------------
-- Records of sys_import_excel_template_details
-- ----------------------------
BEGIN;
INSERT INTO `sys_import_excel_template_details` VALUES ('080c1300dfac53e7bacd4d182ccf6f19', 'aa09908efded36b3d1784486995b39d4', 'status', '状态', '2', 'int', 'sys_dict', 'name', 'code', 'commonStatus', 5, NULL, NULL, '1', '2021-02-25 09:35:01', '1', '2021-02-25 09:35:01');
INSERT INTO `sys_import_excel_template_details` VALUES ('4b08fe9a8d475cc450ee951a245d726f', 'aa09908efded36b3d1784486995b39d4', 'phone', '手机号码', '20', 'varchar', NULL, NULL, NULL, NULL, 4, NULL, NULL, '1', '2021-02-25 09:35:01', '1', '2021-02-25 09:35:01');
INSERT INTO `sys_import_excel_template_details` VALUES ('5d740c222d2a257c8b14fd541c869c7a', 'aa09908efded36b3d1784486995b39d4', 'address', '地址', '255', 'varchar', NULL, NULL, NULL, NULL, 6, NULL, NULL, '1', '2021-02-25 09:35:01', '1', '2021-02-25 09:35:01');
INSERT INTO `sys_import_excel_template_details` VALUES ('a0bb313ca40ff7a2a418dc68ae3b09a9', 'aa09908efded36b3d1784486995b39d4', 'age', '年龄', '3', 'int', NULL, NULL, NULL, NULL, 3, NULL, NULL, '1', '2021-02-25 09:35:01', '1', '2021-02-25 09:35:01');
INSERT INTO `sys_import_excel_template_details` VALUES ('c79ab80caf846ee3d326de7caf41f81b', 'aa09908efded36b3d1784486995b39d4', 'name', '姓名', '50', 'varchar', NULL, NULL, NULL, NULL, 1, NULL, NULL, '1', '2021-02-25 09:35:01', '1', '2021-02-25 09:35:01');
INSERT INTO `sys_import_excel_template_details` VALUES ('f67c35aa89a30c0d3ecf0bba3b37bab2', 'aa09908efded36b3d1784486995b39d4', 'sex', '性别', '1', 'varchar', 'sys_dict', 'name', 'code', 'sex', 2, NULL, NULL, '1', '2021-02-25 09:35:01', '1', '2021-02-25 09:35:01');
COMMIT;

-- ----------------------------
-- Table structure for sys_import_excel_temporary
-- ----------------------------
DROP TABLE IF EXISTS `sys_import_excel_temporary`;
CREATE TABLE `sys_import_excel_temporary` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `template_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '模板id',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导入用户id',
  `verification_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '验证结果',
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
  `ip` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ip',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'url',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'uri',
  `clazz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'class',
  `method_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '方法名',
  `params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '参数',
  `time_consuming` bigint(20) DEFAULT NULL COMMENT '耗时',
  `operation_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作人',
  `operation_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='日志 ';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_log` VALUES ('01862e2c1e0a5636e359c56bea674f0a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:30:56');
INSERT INTO `sys_log` VALUES ('02cfc967316b228d0b8adc730bad4e17', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-15 13:13:28');
INSERT INTO `sys_log` VALUES ('033ac1fe442321b9e5179c992ba943a3', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-02 16:26:00');
INSERT INTO `sys_log` VALUES ('045d1fd132cf2aed7758e23b5a234958', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:23:45');
INSERT INTO `sys_log` VALUES ('04c5212dbe4fabf24b940a69576905c4', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:21:07');
INSERT INTO `sys_log` VALUES ('06236ed84b16ef907f2331943a99f4f7', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:19:28');
INSERT INTO `sys_log` VALUES ('06bd261a21b3589f50b4d8390ff89237', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:53:03');
INSERT INTO `sys_log` VALUES ('0740695e253fc397bd33992d3288a02c', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:17:44');
INSERT INTO `sys_log` VALUES ('0ad84862fb4912c63d7848ea3d46fa34', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-02 14:20:59');
INSERT INTO `sys_log` VALUES ('0b7b4dbe8630abb61f55e20ab34a3d1b', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-06 16:12:39');
INSERT INTO `sys_log` VALUES ('0c4b8048d825b2c97afef7dd7b3facef', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-02 13:56:38');
INSERT INTO `sys_log` VALUES ('0c7e6a40144779dedecf6af8f5a37239', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-06 16:16:13');
INSERT INTO `sys_log` VALUES ('0c828f6100788b05bb382f3fce1aeb9a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:34:20');
INSERT INTO `sys_log` VALUES ('0d8e4615425e98aa62e9148e18263010', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:06:05');
INSERT INTO `sys_log` VALUES ('0e73e039c6f602bd24d3ff14f8c08e66', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:10:03');
INSERT INTO `sys_log` VALUES ('119b67e8524a00fc7641c86cb929ee3f', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:13:56');
INSERT INTO `sys_log` VALUES ('12c10cbaabfce0d51c66f285965abdbe', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:17:32');
INSERT INTO `sys_log` VALUES ('12e9bff1cc224bbe9552b3a8b2b81149', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:51:17');
INSERT INTO `sys_log` VALUES ('143f1117889c99f65de6b89001ffcc5b', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:07:26');
INSERT INTO `sys_log` VALUES ('175d1af3329d165cdf82ade2c7210dcb', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:11:23');
INSERT INTO `sys_log` VALUES ('17ed1206cfa37e33df9ed78a01abf787', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:48:34');
INSERT INTO `sys_log` VALUES ('19e02217af45f08deec67005ef4addf2', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:05:45');
INSERT INTO `sys_log` VALUES ('1fb08ccada3d140857bfb6d77a180d96', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:33:43');
INSERT INTO `sys_log` VALUES ('22f66dff254647a6a6ebdea1b7a84129', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:31:44');
INSERT INTO `sys_log` VALUES ('237ae1a93eefc470fe4dfe9db5d6c01c', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-02 17:33:42');
INSERT INTO `sys_log` VALUES ('23ab7a1d4b11b57aac9abc3918bd18d8', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:11:11');
INSERT INTO `sys_log` VALUES ('263fe8a186a496fbf5ba23a08ca9ca2d', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:31:29');
INSERT INTO `sys_log` VALUES ('26d42599c51a00dc43eb99380364bafc', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-06 16:10:44');
INSERT INTO `sys_log` VALUES ('27993f6cddbe8b3798a203aaa540ddf8', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-15 13:41:47');
INSERT INTO `sys_log` VALUES ('2911501a7e2045e04f566461debfdb31', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:43:24');
INSERT INTO `sys_log` VALUES ('3341bcc8e80a7c6256f6ebd17b68d8d7', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:02:32');
INSERT INTO `sys_log` VALUES ('337b9f403137b4978dab0a6ba4e1004e', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:22:24');
INSERT INTO `sys_log` VALUES ('35c936013a22f87cc1b9f04102abf784', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:45:20');
INSERT INTO `sys_log` VALUES ('35d509d96b53af1b75d4afb0115bb101', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-06 16:10:48');
INSERT INTO `sys_log` VALUES ('376f5e11e1c337deb6de0759c649d469', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:43:14');
INSERT INTO `sys_log` VALUES ('392b85b3c050d178172ef44b1ae3f9f7', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:35:42');
INSERT INTO `sys_log` VALUES ('3b38c9c3b5f842d82c5e1c4d3ffac7c7', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:32:56');
INSERT INTO `sys_log` VALUES ('3dba04ed04a4ea0660b5ca808a1d4222', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:37:07');
INSERT INTO `sys_log` VALUES ('3ea75bc70437d82285809154b92eac7d', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:40:42');
INSERT INTO `sys_log` VALUES ('4119339d667bb25f9edd813b1bcafad7', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:13:10');
INSERT INTO `sys_log` VALUES ('411fb930b9b73fb5e78eac469d696440', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:27:40');
INSERT INTO `sys_log` VALUES ('421dfadd096eceb4401ac9b2ef0d7bcb', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:40:43');
INSERT INTO `sys_log` VALUES ('4411211ab5836e2f9d7687803fee9463', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-15 13:22:07');
INSERT INTO `sys_log` VALUES ('4542012d27c2392db83325ba2927c0ea', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:19:03');
INSERT INTO `sys_log` VALUES ('460b1081a9e36965b4b99f1b8524ec07', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:23:09');
INSERT INTO `sys_log` VALUES ('481003972548a880b663ef714a3a8f1e', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:34:57');
INSERT INTO `sys_log` VALUES ('48aecacc7dea20e5ba6f8c5af7d5807f', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-06 16:14:15');
INSERT INTO `sys_log` VALUES ('48d6a4c68730c6274642484d73035c57', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-15 13:22:06');
INSERT INTO `sys_log` VALUES ('4ba553c9e7afd30130de3e5110f5e9ce', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:36:06');
INSERT INTO `sys_log` VALUES ('4e3256baffb82043f1f24ba6f56742f9', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:10:21');
INSERT INTO `sys_log` VALUES ('503fe366f992bade9f01675ed3df6f65', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:20:52');
INSERT INTO `sys_log` VALUES ('51212ce55862af5688ca888aa9d93496', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:29:06');
INSERT INTO `sys_log` VALUES ('5195e1a0608a08abc624bb4ae39308a8', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:32:29');
INSERT INTO `sys_log` VALUES ('51cfdcf4f90416bd9e57fd92bb632ba3', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:36:51');
INSERT INTO `sys_log` VALUES ('528784380922b965bf851ebffca584f4', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:40:07');
INSERT INTO `sys_log` VALUES ('544da76337045aa7666c90419e433317', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:29:42');
INSERT INTO `sys_log` VALUES ('54519fd5b75b2f3b82630c8ce48be67d', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:28:12');
INSERT INTO `sys_log` VALUES ('5541276049b152de6c475f6d28757e12', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:30:15');
INSERT INTO `sys_log` VALUES ('57aa2dd5fe427fddf389fc14cb931901', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:36:12');
INSERT INTO `sys_log` VALUES ('5bcb7a8dbe87139d41d2e44bcbd3310a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:35:37');
INSERT INTO `sys_log` VALUES ('5d07d86e4d9b478a5c3cdd0a47e1b2ae', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:20:59');
INSERT INTO `sys_log` VALUES ('5ef6309d64abfc5300934f5c351b185a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:33:42');
INSERT INTO `sys_log` VALUES ('635113c8efe7523efc2509a9a186a4a9', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:20:23');
INSERT INTO `sys_log` VALUES ('642ab2b82ab9d0b1847e73c9cecdd299', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:41:17');
INSERT INTO `sys_log` VALUES ('6444854732461d34743f1e03e7c58845', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:42:22');
INSERT INTO `sys_log` VALUES ('65bb5e95dc595958108ef8767a8ab153', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:53:22');
INSERT INTO `sys_log` VALUES ('65d59de14ca35cb1060397099b37a729', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:42:25');
INSERT INTO `sys_log` VALUES ('676a4341ab8a359ab5144ab099717745', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:07:39');
INSERT INTO `sys_log` VALUES ('68501b367b4112ec179e66fb14c4ceb8', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:15:26');
INSERT INTO `sys_log` VALUES ('6b9798770125eca0e85dd5cc0ad38857', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 13:56:38');
INSERT INTO `sys_log` VALUES ('6c129635d309bedbd60e3a93587b7208', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:35:08');
INSERT INTO `sys_log` VALUES ('717b06aeb0040459ceb44b5bdb63b558', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:36:31');
INSERT INTO `sys_log` VALUES ('739241d6930ee914c9cca2ecbbe52e79', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:10:32');
INSERT INTO `sys_log` VALUES ('76dc7579725d382cde9acc611e2dfd7d', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-15 13:07:15');
INSERT INTO `sys_log` VALUES ('79cbd798b97a9b81f17737ca09867dec', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:33:14');
INSERT INTO `sys_log` VALUES ('7a63ab3321026fdac3b79cc616886c91', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:24:55');
INSERT INTO `sys_log` VALUES ('7a74c356b938afec63f7fb68717f6f6e', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-15 13:07:35');
INSERT INTO `sys_log` VALUES ('7bcc805f5d67058de5532f6373bdb18a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:41:47');
INSERT INTO `sys_log` VALUES ('7c5639a58ad37dda2b4358952264d04c', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:40:10');
INSERT INTO `sys_log` VALUES ('7f2c9fc945182ac6a91e60c0b27ed634', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-15 13:35:48');
INSERT INTO `sys_log` VALUES ('81cf24ac4bc45a0b83e64b980ce10e44', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:01:39');
INSERT INTO `sys_log` VALUES ('82abe3ec12e1b488532a96df1d0029c0', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-02 15:30:45');
INSERT INTO `sys_log` VALUES ('82f0b73760a078fab4f2519115cf1950', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:00:46');
INSERT INTO `sys_log` VALUES ('85d93e8cec42fe79161493d1b6dff32a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:32:24');
INSERT INTO `sys_log` VALUES ('8895dc4c91313799dcdf7b0379fb4dae', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:32:29');
INSERT INTO `sys_log` VALUES ('8a418ef94d5950c27a8e6466aaf934e4', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:34:20');
INSERT INTO `sys_log` VALUES ('8a8ffc97aa10657172698a39f41d65df', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:36:37');
INSERT INTO `sys_log` VALUES ('8a909f79dd25ec20fe89119ad44f12fc', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:29:55');
INSERT INTO `sys_log` VALUES ('8db624cdc708e8c75a5ee6a48cf2942a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:38:18');
INSERT INTO `sys_log` VALUES ('90b4cf26ca5f34634645c15ba21fc7c7', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:31:17');
INSERT INTO `sys_log` VALUES ('91a939037923e93d32954bf18ded0eea', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:35:47');
INSERT INTO `sys_log` VALUES ('9ca2bbcf3ebd7118bbc9d4aded2b1209', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-02 17:33:40');
INSERT INTO `sys_log` VALUES ('9cb78372b7a7e493b9ddf58e71fa179c', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:20:56');
INSERT INTO `sys_log` VALUES ('9d9571032e23c339f2150f27fd228ef2', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:32:48');
INSERT INTO `sys_log` VALUES ('9e78dbc0e4d56117201e8e4dad484477', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:01:34');
INSERT INTO `sys_log` VALUES ('9ecde8b9225e69f15708c4db4d061d52', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:11:57');
INSERT INTO `sys_log` VALUES ('9f426428b0863a2589c6bccf8a0f5a60', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-06 16:11:07');
INSERT INTO `sys_log` VALUES ('a06628310bb46e7e61516edb3f7f1c37', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:42:03');
INSERT INTO `sys_log` VALUES ('a1171d35c3f385a09bed18f647bcfa7a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:06:21');
INSERT INTO `sys_log` VALUES ('a57f8ba9740aff39d272a9ada2da3c73', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:35:26');
INSERT INTO `sys_log` VALUES ('a74a03a1cd73b905751df85900f4eaae', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:37:36');
INSERT INTO `sys_log` VALUES ('a912add4cf64d42808fad6e927d2f4d1', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-02 17:50:09');
INSERT INTO `sys_log` VALUES ('a9cf1d3c2b2313bb235d609226b8a7a5', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:39:50');
INSERT INTO `sys_log` VALUES ('aad4931796e2a7ef04bdf95f356f9552', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:35:49');
INSERT INTO `sys_log` VALUES ('ad7ecfb1c4c32747b0b385818ed5d4c6', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:38:07');
INSERT INTO `sys_log` VALUES ('adfafed51f27c275bfc3077c02383aa7', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:29:01');
INSERT INTO `sys_log` VALUES ('b168bceabb1e4c1ae79d24cf8ad79239', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:42:34');
INSERT INTO `sys_log` VALUES ('b511292475ab1fef73c25d1d3701cb02', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:50:10');
INSERT INTO `sys_log` VALUES ('b52510c882a6d00ec9afb8eec4e5ee55', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:40:20');
INSERT INTO `sys_log` VALUES ('b56a80b4aa59d80ad479326152bf9e5c', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:43:27');
INSERT INTO `sys_log` VALUES ('b5a978718317f419de308fd11ba46e53', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:43:18');
INSERT INTO `sys_log` VALUES ('b859fc2551cf208dd21f37f0a3cab11a', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-02 14:20:58');
INSERT INTO `sys_log` VALUES ('b9e188ad0e44af42c0742340348f8513', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-06 16:28:05');
INSERT INTO `sys_log` VALUES ('ba654dadbaf8fd10521fbfa75af0f548', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:31:14');
INSERT INTO `sys_log` VALUES ('bbacff5f4127f3c23c7cc41faa2d42ff', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-06 16:28:05');
INSERT INTO `sys_log` VALUES ('bc4005268cebd0d291f9755f7cdfda44', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:31:01');
INSERT INTO `sys_log` VALUES ('bc7cc19499f5ad8e787542921963b6a6', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:30:10');
INSERT INTO `sys_log` VALUES ('bdb3ca94f300420ebd3b962d082996be', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:17:41');
INSERT INTO `sys_log` VALUES ('c00d87f87473816d203b6a5754e96783', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-15 13:13:29');
INSERT INTO `sys_log` VALUES ('c2296939376099a03f717accf67a452a', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-06 16:10:47');
INSERT INTO `sys_log` VALUES ('c590a99560390cbed7daffad52ac9cae', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:07:34');
INSERT INTO `sys_log` VALUES ('c7f37c26fe7e185e3f7954120bdf8875', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:30:47');
INSERT INTO `sys_log` VALUES ('c93c72a661a207a1db67e8af2745b2f3', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:40:04');
INSERT INTO `sys_log` VALUES ('ca100f644b9df61c0e7263001aaaa788', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:33:47');
INSERT INTO `sys_log` VALUES ('ca7ac1649fa6e94adecdf6db803e39a5', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:40:55');
INSERT INTO `sys_log` VALUES ('cbed094c3809dee59fd932e1efe41614', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:03:00');
INSERT INTO `sys_log` VALUES ('ce7d7d1dcbc6788f765da6bcc40c28c5', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:36:10');
INSERT INTO `sys_log` VALUES ('d3b904bd6b0bd7d9bb5d8312f2d193f7', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-15 13:41:46');
INSERT INTO `sys_log` VALUES ('d57ddee293ee29cb517ab22c2609c791', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:50:50');
INSERT INTO `sys_log` VALUES ('d760751f6bfffd2a9c2b1197f3ef79dd', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:39:24');
INSERT INTO `sys_log` VALUES ('d7afb471ed4e73357ae3e576c7f94f57', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-16 14:53:54');
INSERT INTO `sys_log` VALUES ('d87a265979834582f7693ce39396dc4b', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:41:30');
INSERT INTO `sys_log` VALUES ('d9b2444e51a791da4bfc525cfa852c62', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:15:06');
INSERT INTO `sys_log` VALUES ('dae97953d95324fa3cd7b73ff66f1b1a', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:37:09');
INSERT INTO `sys_log` VALUES ('db1c982b6c1c3a58db0a78f5ea29bb6d', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:20:48');
INSERT INTO `sys_log` VALUES ('db49b103a1f04180aefd24bb436fc3a2', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:16:25');
INSERT INTO `sys_log` VALUES ('db6e8aabc31f2c25819f5e1ad0e6e3d0', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:22:07');
INSERT INTO `sys_log` VALUES ('dbb08b0266ab430322c6e23154fe2e04', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:34:10');
INSERT INTO `sys_log` VALUES ('dea65bbac6be923c10a3539c05860648', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-02 16:26:01');
INSERT INTO `sys_log` VALUES ('e105de60c45adaee6d29cce0481bd55b', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:33:10');
INSERT INTO `sys_log` VALUES ('e15c3013170ed5a2c73f6d38aac3f0cf', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:23:19');
INSERT INTO `sys_log` VALUES ('e4b1134533546c366c7cf372921065cc', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:35:40');
INSERT INTO `sys_log` VALUES ('e7e1b474f69cf36491e130855eff42c7', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:18:32');
INSERT INTO `sys_log` VALUES ('e89ef8a5f6b2aa7d2a20592a41880937', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:37:00');
INSERT INTO `sys_log` VALUES ('e9e6aff85448a42fa5188b5eba116a11', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:26:01');
INSERT INTO `sys_log` VALUES ('eb609d1f2d44c1c7de5df251d80a4c2e', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:40:33');
INSERT INTO `sys_log` VALUES ('eb7fc3f98540b1057ec99fd703cdbe66', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:22:37');
INSERT INTO `sys_log` VALUES ('ec1278e48c51111d56b9d49dc7db82f0', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:40:55');
INSERT INTO `sys_log` VALUES ('ecf1574584d3b1126edda6ec3bfec495', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:29:34');
INSERT INTO `sys_log` VALUES ('ed197afdfdf4408fbad2f9934b01b831', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 15:06:23');
INSERT INTO `sys_log` VALUES ('edbf33052d820204103fbd3b4d4a9c42', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-02 17:50:10');
INSERT INTO `sys_log` VALUES ('ee3a9592198596e1dc13d3bba8da5c71', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:13:29');
INSERT INTO `sys_log` VALUES ('f25adfc076266df4226ddd32ea130593', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:18:04');
INSERT INTO `sys_log` VALUES ('f435bb300cc50796bd9c9c7dae8db9a8', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:21:19');
INSERT INTO `sys_log` VALUES ('f49e005381888e4a8e82676ee69ab0e4', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:04:26');
INSERT INTO `sys_log` VALUES ('f548625f30eb44e54fd03014958483ce', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:13:33');
INSERT INTO `sys_log` VALUES ('f64efde018343e0ce00e613845116d39', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-15 13:35:48');
INSERT INTO `sys_log` VALUES ('f8949551593ca2100c6a0f60054dee41', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 16:54:45');
INSERT INTO `sys_log` VALUES ('f8d7aaff3e5ba199b1cba382136600c4', 'sys', '退出登录', '127.0.0.1', 'http://127.0.0.1/logout', '/logout', 'com.easy.admin.auth.controller.AuthController', 'logout', '[]', NULL, NULL, '2021-04-06 16:28:03');
INSERT INTO `sys_log` VALUES ('fa9b00441152fba45add9fd48bd05a7f', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 17:42:44');
INSERT INTO `sys_log` VALUES ('fd6d0e4dd2da37efacefbacc8f7d5d9b', 'sys', '用户登录', '127.0.0.1', 'http://127.0.0.1/auth/login', '/auth/login', 'com.easy.admin.auth.controller.AuthController', 'login', '[LoginVO{username=\'admin\', password=\'0192023a7bbd73250516f069df18b500\', rememberMe=null, codeId=\'null\', verificationCode=\'null\'}]', NULL, '1', '2021-04-02 15:30:46');
INSERT INTO `sys_log` VALUES ('fdca24469b7cf7c13a96efe9a93a0a8d', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-02 14:01:51');
INSERT INTO `sys_log` VALUES ('fe2ecac3060d37edda68c190ecc9e8f5', 'sys', '获取当前登录用户', '127.0.0.1', 'http://127.0.0.1/auth/sys/user/current', '/auth/sys/user/current', 'com.easy.admin.sys.controller.SysUserController', 'getCurrent', '[]', NULL, '1', '2021-04-15 13:07:35');
COMMIT;

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `log_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '日志名称',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `login_date` datetime DEFAULT NULL COMMENT '登录时间',
  `is_success` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否成功',
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '消息',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='登录日志';

-- ----------------------------
-- Table structure for sys_mail_verifies
-- ----------------------------
DROP TABLE IF EXISTS `sys_mail_verifies`;
CREATE TABLE `sys_mail_verifies` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户标识/user_id/username',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '效验码',
  `expired` datetime DEFAULT NULL COMMENT '过期时间',
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='邮箱验证';

-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `subtitle` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '副标题(保留字段)',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '内容',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `send_date` datetime DEFAULT NULL COMMENT '发送时间',
  `icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标(保留字段)',
  `important` int(2) DEFAULT NULL COMMENT '重要',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='通知 ';

-- ----------------------------
-- Records of sys_message
-- ----------------------------
BEGIN;
INSERT INTO `sys_message` VALUES ('0989b413891ccca33d490b8c23d5264a', '[流程撤销]你发起的[请假][病假]生病了被[系统管理员]撤销', NULL, '<div class=\"ant-row\">\n    <div class=\"ant-col ant-col-sm-24\">\n        <div class=\"ant-row ant-form-item\">\n            <div class=\"ant-col ant-col-6 ant-form-item-label\">\n                <label title=\"流程\" class=\"\">流程：</label>\n            </div>\n            <div class=\"ant-col ant-col-18 ant-form-item-control-wrapper\">\n                <div class=\"ant-form-item-control\">\n                    <span class=\"ant-form-item-children\"> 请假 </span>\n                </div>\n            </div>\n        </div>\n        <div class=\"ant-row ant-form-item\">\n            <div class=\"ant-col ant-col-6 ant-form-item-label\">\n                <label title=\"发起时间\" class=\"\">发起时间：</label>\n            </div>\n            <div class=\"ant-col ant-col-18 ant-form-item-control-wrapper\">\n                <div class=\"ant-form-item-control\">\n                    <span class=\"ant-form-item-children\"> 2021-01-21 14:35 </span>\n                </div>\n            </div>\n        </div>\n        <div class=\"ant-row ant-form-item\">\n            <div class=\"ant-col ant-col-6 ant-form-item-label\">\n                <label title=\"流水号\" class=\"\">流水号：</label>\n            </div>\n            <div class=\"ant-col ant-col-18 ant-form-item-control-wrapper\">\n                <div class=\"ant-form-item-control\">\n                    <span class=\"ant-form-item-children\"> 47647 </span>\n                </div>\n            </div>\n        </div>\n        <div class=\"ant-row ant-form-item\">\n            <div class=\"ant-col ant-col-6 ant-form-item-label\">\n                <label title=\"业务\" class=\"\">业务：</label>\n            </div>\n            <div class=\"ant-col ant-col-18 ant-form-item-control-wrapper\">\n                <div class=\"ant-form-item-control\">\n                    <span class=\"ant-form-item-children\"> [病假]生病了 </span>\n                </div>\n            </div>\n        </div>\n        <div class=\"ant-row ant-form-item\">\n            <div class=\"ant-col ant-col-6 ant-form-item-label\">\n                <label title=\"撤销时间\" class=\"\">撤销时间：</label>\n            </div>\n            <div class=\"ant-col ant-col-18 ant-form-item-control-wrapper\">\n                <div class=\"ant-form-item-control\">\n                    <span class=\"ant-form-item-children\"> 2021-01-21 14:51 </span>\n                </div>\n            </div>\n        </div>\n        <div class=\"ant-row ant-form-item\">\n            <div class=\"ant-col ant-col-6 ant-form-item-label\">\n                <label title=\"撤销人\" class=\"\">撤销人：</label>\n            </div>\n            <div class=\"ant-col ant-col-18 ant-form-item-control-wrapper\">\n                <div class=\"ant-form-item-control\">\n                    <span class=\"ant-form-item-children\"> 系统管理员 </span>\n                </div>\n            </div>\n        </div>\n        <div class=\"ant-row ant-form-item\">\n            <div class=\"ant-col ant-col-6 ant-form-item-label\">\n                <label title=\"撤销原由\" class=\"\">撤销原由：</label>\n            </div>\n            <div class=\"ant-col ant-col-18 ant-form-item-control-wrapper\">\n                <div class=\"ant-form-item-control\">\n                    <span class=\"ant-form-item-children\"> 生病了也不能请假 </span>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>', '1', '2021-01-21 14:51:03', NULL, 1, 'notice', NULL, '1', '2021-01-21 14:51:03', '1', '2021-01-21 14:51:03');
INSERT INTO `sys_message` VALUES ('243caf60ff241322124f91cf55cb6ccc', '测试消息20201230', NULL, '<p>测试消息20201230</p>', '0', NULL, NULL, 0, 'notice', NULL, '1', '2020-12-30 22:12:36', '1', '2020-12-30 22:12:36');
INSERT INTO `sys_message` VALUES ('5cf8b79df98a26c5a5567c34b28ddb10', '测试信息20200105', NULL, '<p>测试信息20200105</p>', '1', '2021-01-05 14:52:24', NULL, 0, 'notice', NULL, '1', '2021-01-05 14:52:24', '1', '2021-01-05 14:52:24');
INSERT INTO `sys_message` VALUES ('6df077ecd60e9de06fb7114ab891cf8b', '测试信息20200105', NULL, '<p>测试信息20200105</p>', '1', '2021-01-05 14:53:10', NULL, 0, 'notice', NULL, '1', '2021-01-05 14:53:10', '1', '2021-01-05 14:53:10');
INSERT INTO `sys_message` VALUES ('8180f7b750bde6d9a3e8e10958eadb57', '请绑定密保手机', NULL, '<p>请在<b>个人设置&gt;安全设置</b>中绑定<b>密保手机</b>。密保手机可以进行帐号登录、找回密码等敏感操作的安全验证，请勿随意泄露手机号、短信验证码，以防不法分子利用造成个人损失<br></p>', '1', '2020-12-30 16:26:47', NULL, 1, 'notice', NULL, '1', '2020-12-30 16:26:47', '1', '2020-12-30 16:26:47');
INSERT INTO `sys_message` VALUES ('9bab646a0d4812a8c9692a8dbd100f41', '请绑定密保邮箱', NULL, '<p><font face=\"仿宋\"></font><span style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\">请在<b>个人设置&gt;安全设置</b>中绑定<b>密保邮箱</b>。密保邮箱可以进行帐号登录、找回密码等敏感操作的安全验证，请勿泄露邮箱信息，轻信他人邮件，以防不法分子利用造成个人损失。</span><br></p>', '1', '2020-12-30 16:23:34', NULL, 1, 'notice', NULL, '1', '2020-12-30 16:23:34', '1', '2020-12-30 16:23:34');
INSERT INTO `sys_message` VALUES ('b9cfec298881bec17837490c45db8e63', '测试信息20200105-2', NULL, '<p>测试信息20200105-2</p>', '1', '2021-01-05 15:07:26', NULL, 1, 'notice', NULL, '1', '2021-01-05 15:07:26', '1', '2021-01-05 15:07:26');
INSERT INTO `sys_message` VALUES ('db71bc2907551aafb53467ec429337c6', '测试信息20200105-1', NULL, '<p>测试信息20200105-1</p>', '1', '2021-01-05 15:06:20', NULL, 0, 'notice', NULL, '1', '2021-01-05 15:06:20', '1', '2021-01-05 15:06:20');
INSERT INTO `sys_message` VALUES ('f91280d1203082db48a8f011ee0deef5', '测试信息20200105', NULL, '<p>测试信息20200105</p>', '1', '2021-01-05 14:53:24', NULL, 0, 'notice', NULL, '1', '2021-01-05 14:53:24', '1', '2021-01-05 14:53:24');
COMMIT;

-- ----------------------------
-- Table structure for sys_message_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_message_details`;
CREATE TABLE `sys_message_details` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `message_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '消息id',
  `receiver_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '接收人',
  `read_date` datetime DEFAULT NULL COMMENT '阅读时间',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `star` int(1) DEFAULT NULL COMMENT '是否被标记※',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='消息详情 ';

-- ----------------------------
-- Records of sys_message_details
-- ----------------------------
BEGIN;
INSERT INTO `sys_message_details` VALUES ('0fc5370e36ed6f9ba85ffa4c90a2716a', '5cf8b79df98a26c5a5567c34b28ddb10', '1', NULL, '0', 0);
INSERT INTO `sys_message_details` VALUES ('391eaf3764c9803e9119c536f31dc988', '0989b413891ccca33d490b8c23d5264a', '1', '2021-02-01 17:51:54', '1', 0);
INSERT INTO `sys_message_details` VALUES ('3d397fd11375254c61282c72e6f162ce', '8180f7b750bde6d9a3e8e10958eadb57', '1', '2021-01-04 10:13:35', '1', 1);
INSERT INTO `sys_message_details` VALUES ('5a3d734e02e0b4791193f625c73a7717', 'f91280d1203082db48a8f011ee0deef5', '1', '2021-01-07 22:52:53', '1', 0);
INSERT INTO `sys_message_details` VALUES ('5a6c9966b6981b3061d5d186c2c90e79', 'db71bc2907551aafb53467ec429337c6', '1', NULL, '0', 0);
INSERT INTO `sys_message_details` VALUES ('68ab802ef775e35623a4744b0a8ce25b', '243caf60ff241322124f91cf55cb6ccc', '1', NULL, '0', 0);
INSERT INTO `sys_message_details` VALUES ('a37a7a9e4b3827427e1595d8038d064f', 'f91280d1203082db48a8f011ee0deef5', '068cf9e66de5d067627d08519681895a', NULL, '0', 0);
INSERT INTO `sys_message_details` VALUES ('a71c4095dab8f067abce8093e6b74c34', '6df077ecd60e9de06fb7114ab891cf8b', '1', NULL, '0', 0);
INSERT INTO `sys_message_details` VALUES ('bf9bd9a6dba96bc9e0e881437603dd53', 'b9cfec298881bec17837490c45db8e63', '1', '2021-01-29 22:17:52', '-1', 1);
INSERT INTO `sys_message_details` VALUES ('f4c142b522427a430c393454b92b9a62', '9bab646a0d4812a8c9692a8dbd100f41', '1', NULL, '0', 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` varchar(32) NOT NULL,
  `p_id` varchar(32) DEFAULT NULL COMMENT '父权限id',
  `code` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `path` varchar(255) DEFAULT NULL COMMENT '权限地址',
  `component` varchar(255) DEFAULT NULL COMMENT 'views 页面地址',
  `order_no` int(3) DEFAULT NULL COMMENT '排序值',
  `type` int(1) DEFAULT NULL COMMENT '类型',
  `hide` varchar(32) DEFAULT NULL COMMENT '隐藏路由',
  `target` varchar(32) DEFAULT NULL COMMENT '打开方式',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `version` int(5) DEFAULT NULL COMMENT '乐观锁保留字段',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限/菜单';

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
BEGIN;
INSERT INTO `sys_permissions` VALUES ('006606eb1a80f98445844312e8c69d70', '6aa7ed074b144ab2c2d31a41c2ac4fc0', NULL, 'Data Display', 'pic-left', NULL, NULL, 5, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 14:17:16', '1', '2021-04-02 14:17:16');
INSERT INTO `sys_permissions` VALUES ('03ad13494a492eee81d8d7d1e2d95d14', '7da1f5456b340b1fc94e8bb8e8ae5e8f', 'activiti:historic:select:my', '我发起的', 'solution', '/activiti/history/task-instance/my', '/activiti/history/taskInstance/My', 5, 1, '0', '1', '1', '我发起的办理中+已办结的任务', NULL, '126', '2020-05-14 13:37:17', '1', '2021-01-26 15:31:43');
INSERT INTO `sys_permissions` VALUES ('0ad4783abe1e84e630c630ed78d7ec53', '6aa7ed074b144ab2c2d31a41c2ac4fc0', NULL, 'Data Entry', 'edit', NULL, NULL, 4, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 14:16:27', '1', '2021-04-02 14:16:36');
INSERT INTO `sys_permissions` VALUES ('0c77991b94e723d454898e53e6708b41', '6aa7ed074b144ab2c2d31a41c2ac4fc0', NULL, 'Layout', 'layout', NULL, NULL, 3, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 14:13:59', '1', '2021-04-02 14:16:31');
INSERT INTO `sys_permissions` VALUES ('0f5f756d9f287ea1e8172bb2e6e170d8', '76180395fab6dbdab6f6c050169c5f97', NULL, '任务办理', NULL, '/activiti/task/input/:id', '/activiti/task/Input', 1, 1, '1', '1', '1', NULL, NULL, '1', '2021-01-19 15:18:36', '1', '2021-01-19 15:30:08');
INSERT INTO `sys_permissions` VALUES ('128152f2dc1b2a37ddfebaa4b175446a', 'dfcbf9982ac55701115056a7e09e3cd0', NULL, '开发中', 'codepen', '/global/under-development', '/global/UnderDevelopment', 43, 1, '0', '1', '1', NULL, NULL, '1', '2021-01-25 16:38:22', '1', '2021-02-25 09:41:29');
INSERT INTO `sys_permissions` VALUES ('14', '164', 'sys:role:select', '角色管理', 'team', '/sys/role', '/sys/role/View', 9, 1, '0', '1', '1', '', NULL, '', '2018-11-01 09:36:22', '1', '2021-02-02 13:44:46');
INSERT INTO `sys_permissions` VALUES ('149', '0', '', '代码生成', 'codepen', '/generator', '/generator/View', 39, 1, '0', '1', '1', '', NULL, '', '2019-01-10 17:14:02', '1', '2021-04-02 14:11:12');
INSERT INTO `sys_permissions` VALUES ('15', '5', 'druid', '数据监控', NULL, 'http://127.0.0.1/druid', NULL, 30, 1, '0', '2', '1', '', NULL, '1', '2018-11-01 09:40:36', '1', '2021-01-04 10:49:45');
INSERT INTO `sys_permissions` VALUES ('150', '16', 'sys:redis:remove', '删除', NULL, '', NULL, 4, 2, '0', '1', '1', '', NULL, '126', '2019-01-26 14:27:38', '126', '2019-01-26 14:27:51');
INSERT INTO `sys_permissions` VALUES ('151', '16', 'sys:redis:save', '保存', NULL, '', NULL, 3, 2, '0', '1', '1', '', NULL, '126', '2019-01-26 14:27:38', '126', '2019-01-26 14:27:46');
INSERT INTO `sys_permissions` VALUES ('152', '19', 'sys:online:force', '踢出', NULL, '', NULL, 1, 2, '0', '1', '2', '', NULL, '126', '2019-01-27 12:38:49', '1', '2021-01-21 16:27:45');
INSERT INTO `sys_permissions` VALUES ('157', '4', 'sys:config:select', '系统参数', '', '/sys/config/list', '/sys/config/List', 21, 1, '0', '1', '1', '', NULL, '', '2019-02-26 22:29:36', '1', '2020-12-09 22:00:35');
INSERT INTO `sys_permissions` VALUES ('158', '157', 'sys:config:save', '保存', '', '', '', 3, 1, '1', '1', '1', '', NULL, '', '2019-02-26 22:29:36', '1', '2020-12-09 22:58:50');
INSERT INTO `sys_permissions` VALUES ('159', '157', 'sys:config:remove', '删除', NULL, NULL, NULL, 2, 2, '0', '1', '1', NULL, NULL, '126', '2019-02-26 22:29:36', '1', '2020-12-09 22:57:41');
INSERT INTO `sys_permissions` VALUES ('16', '5', 'sys:redis:select', '缓存监控', NULL, '/sys/redis/view', '/sys/redis/View', 31, 1, '0', '1', '1', '', NULL, '1', '2018-11-01 09:40:51', '1', '2021-01-04 16:49:28');
INSERT INTO `sys_permissions` VALUES ('164', '0', '', '系统管理', 'setting', NULL, NULL, 44, 1, '0', '1', '1', '', NULL, '126', '2019-04-07 17:45:38', '1', '2021-04-02 14:11:12');
INSERT INTO `sys_permissions` VALUES ('17', '5', 'sys:status:select', '服务器状态', NULL, '/sys/status/view', '/sys/status/View', 32, 1, '0', '1', '1', '', NULL, '1', '2018-11-01 09:41:01', '1', '2021-01-04 11:07:07');
INSERT INTO `sys_permissions` VALUES ('17dcc367a2c812c36b0d3e2710a567cd', '228', 'sample:work:flow:select', '流程示例', 'gateway', '/sample/work-flow/list', '/sample/work-flow/List', 3, 1, '0', '1', '1', '', NULL, '126', '2020-04-26 15:07:59', '1', '2021-02-01 16:52:35');
INSERT INTO `sys_permissions` VALUES ('19', '5', 'sys:online:select', '在线用户', NULL, '/sys/online', NULL, 34, 1, '0', '1', '2', '', NULL, '1', '2018-11-01 09:41:42', '1', '2021-01-21 16:27:39');
INSERT INTO `sys_permissions` VALUES ('20', '164', 'sys:dept:select', '部门管理', 'solution', '/sys/dept', '/sys/dept/View', 10, 1, '0', '1', '1', '', NULL, '', '2018-11-01 09:41:59', '1', '2021-02-02 13:44:46');
INSERT INTO `sys_permissions` VALUES ('21', '164', 'sys:user:select', '用户管理', 'user', '/sys/user', '/sys/user/View', 11, 1, '0', '1', '1', '', NULL, '', '2018-11-01 09:42:04', '1', '2021-02-02 13:44:46');
INSERT INTO `sys_permissions` VALUES ('218', '5', 'sys:exception:select', '异常日志', NULL, '/sys/exception', '/sys/exception/List', 38, 1, '0', '1', '1', '', NULL, '126', '2019-04-08 11:59:16', '1', '2020-12-17 22:33:45');
INSERT INTO `sys_permissions` VALUES ('219', '218', 'sys:exception:remove', '删除', NULL, NULL, NULL, 1, 2, '0', '1', '1', NULL, NULL, '126', '2019-04-08 11:59:16', '126', '2019-04-08 11:59:16');
INSERT INTO `sys_permissions` VALUES ('220', '228', 'sample:general:select', '代码生成示例', 'codepen', '/sample/general/list', '/sample/general/List', 9, 1, '0', '1', '1', '', NULL, '126', '2019-04-09 12:50:25', '1', '2021-02-01 16:52:40');
INSERT INTO `sys_permissions` VALUES ('221', '220', 'sample:general:save', '保存', NULL, '', NULL, 1, 2, '0', '1', '1', '', NULL, '126', '2019-04-09 12:50:25', '126', '2019-11-08 07:56:23');
INSERT INTO `sys_permissions` VALUES ('222', '220', 'sample:general:remove', '删除', NULL, NULL, NULL, 2, 2, '0', '1', '1', NULL, NULL, '126', '2019-04-09 12:50:25', '126', '2019-06-12 15:15:25');
INSERT INTO `sys_permissions` VALUES ('224', '4', 'sys:import:excel:template:select', '导入模板', '', '/sys/import-excel-template/list', '/sys/import-excel-template/List', 7, 1, '0', '1', '1', '', NULL, '', '2019-04-10 15:55:00', '1', '2021-02-03 13:33:10');
INSERT INTO `sys_permissions` VALUES ('225', '224', 'sys:import:excel:template:save', '保存', '', '', '', 4, 2, '0', '1', '1', '', NULL, '', '2019-04-10 15:55:00', '1', '2020-11-19 10:20:10');
INSERT INTO `sys_permissions` VALUES ('226', '224', 'sys:import:excel:template:remove', '删除', '', '', '', 5, 2, '0', '1', '1', '', NULL, '', '2019-04-10 15:55:00', '1', '2020-11-19 10:13:51');
INSERT INTO `sys_permissions` VALUES ('228', '0', '', '功能示例', 'appstore', '', '', 41, 1, '0', '1', '1', '', NULL, '', '2019-04-16 21:56:25', '1', '2021-04-02 14:11:12');
INSERT INTO `sys_permissions` VALUES ('231', '0ad4783abe1e84e630c630ed78d7ec53', '', '文件上传', '', '', '', 3, 1, '0', '1', '1', '', NULL, '', '2019-04-16 21:57:29', '1', '2021-04-02 16:25:45');
INSERT INTO `sys_permissions` VALUES ('234', '0', '', '系统功能', 'gold', '', '', 45, 1, '1', '1', '1', '', NULL, '', '2019-04-21 15:10:10', '1', '2021-04-02 14:11:12');
INSERT INTO `sys_permissions` VALUES ('235', '234', 'import:data', '数据导入', 'upload', '/sys/import-excel-data/input', '/sys/import-excel-data/Input', 14, 1, '1', '1', '1', '', NULL, '', '2019-04-21 15:10:26', '1', '2021-02-04 16:09:49');
INSERT INTO `sys_permissions` VALUES ('236', '164', 'scheduler:job:select', '定时任务 ', 'clock-circle', '/scheduler/job/list', '/scheduler/job/List', 15, 1, '0', '1', '1', '', NULL, '126', '2019-05-11 17:49:15', '1', '2021-02-01 23:40:59');
INSERT INTO `sys_permissions` VALUES ('237', '236', 'scheduler:job:save', '保存', NULL, NULL, NULL, 2, 2, '0', '1', '1', NULL, NULL, '126', '2019-05-11 17:49:15', '126', '2019-05-11 17:49:15');
INSERT INTO `sys_permissions` VALUES ('238', '236', 'scheduler:job:remove', '删除', NULL, NULL, NULL, 3, 2, '0', '1', '1', NULL, NULL, '126', '2019-05-11 17:49:15', '126', '2019-05-11 17:49:15');
INSERT INTO `sys_permissions` VALUES ('240', '236', 'scheduler:job:log:select', '执行日志', '', '', '', 1, 2, '0', '1', '1', '', NULL, '', '2019-05-11 23:00:36', '1', '2020-11-19 10:42:12');
INSERT INTO `sys_permissions` VALUES ('241', '234', 'sys:message:select', '消息', 'mail', '/sys/message', '/sys/message/View', 12, 1, '0', '1', '1', '', NULL, '126', '2019-06-02 23:24:40', '1', '2020-12-30 15:19:41');
INSERT INTO `sys_permissions` VALUES ('242', '241', 'sys:message:save', '保存', '', '', '', 1, 2, '0', '1', '1', '', NULL, '', '2019-06-02 23:24:41', '1', '2020-11-19 10:19:56');
INSERT INTO `sys_permissions` VALUES ('243', '241', 'sys:message:remove', '删除', NULL, '', NULL, 2, 2, '0', '1', '1', '', NULL, '126', '2019-06-02 23:24:41', '126', '2019-06-06 20:55:24');
INSERT INTO `sys_permissions` VALUES ('24850d7f708a4c3514f1d3c61a2d1bb6', '6aa7ed074b144ab2c2d31a41c2ac4fc0', NULL, 'General', 'build', NULL, NULL, 2, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 14:15:19', '1', '2021-04-02 14:16:39');
INSERT INTO `sys_permissions` VALUES ('258f7c40fca863460ba002f2fb759734', 'dfcbf9982ac55701115056a7e09e3cd0', NULL, '图表', 'bar-chart', NULL, NULL, 18, 1, '0', '1', '1', NULL, NULL, '1', '2021-02-22 16:11:36', '1', '2021-02-25 09:41:29');
INSERT INTO `sys_permissions` VALUES ('2b33f190aa0543c8e1acfddbf224361f', '006606eb1a80f98445844312e8c69d70', NULL, 'NumberInfo', NULL, '/sample/components/data-display/numberInfo', '/sample/components/data-display/NumberInfo', 2, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-15 13:21:50', '1', '2021-04-15 13:21:50');
INSERT INTO `sys_permissions` VALUES ('2fb368f87b018eb6858abc8703945623', '17dcc367a2c812c36b0d3e2710a567cd', NULL, '详情', '', '/sample/work-flow/input', '/sample/work-flow/Input', 3, 1, '1', NULL, '1', '', NULL, '1', '2021-01-16 10:47:02', '1', '2021-01-16 10:47:31');
INSERT INTO `sys_permissions` VALUES ('32', '7', 'sys:dict:type:select', '字典类型管理', '', '/sys/dict/type/list', '/sys/dict/type/List', 13, 1, '1', '1', '1', '', NULL, '', '2018-11-04 01:37:10', '1', '2020-12-09 22:56:07');
INSERT INTO `sys_permissions` VALUES ('3907ba1a0c6196d98314434c6fd44f00', '0ad4783abe1e84e630c630ed78d7ec53', NULL, '用户选择', NULL, '/sample/components/data-entry/user-search-select', '/sample/components/data-entry/UserSearchSelect', 2, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 15:30:27', '1', '2021-04-02 16:25:45');
INSERT INTO `sys_permissions` VALUES ('39c5c5bcdd9a15110e2c3e4014dd1531', '164', '', '流程管理', 'branches', NULL, NULL, 12, 1, '0', '1', '1', '', NULL, '126', '2019-07-03 09:43:27', '1', '2021-02-01 23:40:59');
INSERT INTO `sys_permissions` VALUES ('3b79694872fa73ff05699bde511b238f', '7da1f5456b340b1fc94e8bb8e8ae5e8f', 'activiti:historic:select:participate', '我办理的', 'file-protect', '/activiti/history/task-instance/participate', '/activiti/history/taskInstance/Participate', 7, 1, '0', '1', '1', '用户参与过的任务都可以看到', NULL, '126', '2020-05-07 16:28:02', '1', '2021-01-26 15:31:51');
INSERT INTO `sys_permissions` VALUES ('3e76a9e2bcab94d347203a178765e621', '0', NULL, '个人中心', 'user', '/sys/personal/center', '/sys/personal/center/View', 30, 1, '0', '1', '1', NULL, NULL, '1', '2020-12-18 14:20:30', '1', '2021-04-02 14:11:12');
INSERT INTO `sys_permissions` VALUES ('4', '164', '', '系统设置', 'setting', '/sys', '', 20, 1, '0', '1', '1', '', NULL, '', '2018-10-31 20:02:03', '1', '2021-02-01 23:41:05');
INSERT INTO `sys_permissions` VALUES ('4aba9a2f7c81615c9ccdc07e980ccfe3', '17dcc367a2c812c36b0d3e2710a567cd', 'sample:work:flow:remove', '删除', NULL, NULL, NULL, 2, 2, '0', '1', '1', NULL, NULL, '126', '2020-04-26 15:07:59', '126', '2020-04-26 15:07:59');
INSERT INTO `sys_permissions` VALUES ('4dd114436fd08e63cada54d6c32c1fe3', '157', '', '详情', '', '/sys/config/input', '/sys/config/Input', 4, 1, '1', '1', '1', '', NULL, '', '2020-12-09 22:57:57', '1', '2020-12-09 22:58:43');
INSERT INTO `sys_permissions` VALUES ('5', '164', '', '系统监控', 'dashboard', NULL, NULL, 19, 1, '0', '1', '1', '', NULL, '1', '2018-10-31 20:03:35', '1', '2021-02-01 23:41:05');
INSERT INTO `sys_permissions` VALUES ('51d7635a9faf42627e5b0c33715a8fcc', '006606eb1a80f98445844312e8c69d70', NULL, 'Trend', NULL, '/sample/components/data-display/trend', '/sample/components/data-display/Trend', 3, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-15 13:35:36', '1', '2021-04-15 13:35:36');
INSERT INTO `sys_permissions` VALUES ('52', '32', 'sys:dict:type:remove', '删除', NULL, '', NULL, 9, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:14:18', '1', '2018-12-03 00:17:47');
INSERT INTO `sys_permissions` VALUES ('53', '32', 'sys:dict:type:save', '保存', '', '', '', 10, 2, '0', '1', '1', '', NULL, '', '2018-12-03 00:14:51', '1', '2020-12-09 22:59:26');
INSERT INTO `sys_permissions` VALUES ('55', '7', 'sys:dict:remove', '删除', NULL, '', NULL, 6, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:16:26', '1', '2020-12-09 22:56:12');
INSERT INTO `sys_permissions` VALUES ('56', '7', 'sys:dict:save', '保存', '', '', '', 7, 1, '1', '1', '1', '', NULL, '', '2018-12-03 00:16:26', '1', '2020-12-09 22:56:24');
INSERT INTO `sys_permissions` VALUES ('5fd40d8344c4a5e71fe606364c8fb9d9', 'dfcbf9982ac55701115056a7e09e3cd0', '', '500', 'frown', '/global/500', '/global/500', 42, 1, '0', '1', '1', '', NULL, '126', '2019-08-20 21:27:55', '1', '2021-02-25 09:41:29');
INSERT INTO `sys_permissions` VALUES ('6', '4', 'sys:permissions:select', '菜单管理', '', '/sys/permissions', '/sys/permissions/View', 22, 1, '0', '1', '1', '', NULL, '', '2018-11-01 04:51:56', '1', '2020-12-08 12:36:53');
INSERT INTO `sys_permissions` VALUES ('60a83e7df038e40410526510e5a12cbc', '7', '', '详情', '', '/sys/dict/input', '/sys/dict/Input', 10, 1, '1', '1', '1', '', NULL, '', '2020-12-09 22:04:01', '1', '2020-12-09 22:56:24');
INSERT INTO `sys_permissions` VALUES ('61', '6', 'sys:permissions:remove', '删除', NULL, '', NULL, 7, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:17:02', '1', '2018-12-03 00:17:17');
INSERT INTO `sys_permissions` VALUES ('62', '6', 'sys:permissions:save', '保存', '', '', '', 8, 2, '0', '1', '1', '', NULL, '', '2018-12-03 00:17:02', '1', '2020-12-09 22:56:56');
INSERT INTO `sys_permissions` VALUES ('64', '14', 'sys:role:remove', '删除', NULL, '', NULL, 2, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:20:57', '1', '2018-12-03 00:20:57');
INSERT INTO `sys_permissions` VALUES ('645350c2c094dc8a7ccf71563a4f7cbb', 'dfcbf9982ac55701115056a7e09e3cd0', '', '403', 'lock', '/global/403', '/global/403', 20, 1, '0', '1', '1', '', NULL, '126', '2019-08-20 21:27:37', '1', '2021-02-25 09:41:29');
INSERT INTO `sys_permissions` VALUES ('65', '14', 'sys:role:save', '保存', '', '', '', 3, 2, '0', '1', '1', '', NULL, '', '2018-12-03 00:20:57', '1', '2020-12-09 22:59:40');
INSERT INTO `sys_permissions` VALUES ('67', '21', 'sys:user:remove', '删除', NULL, '', NULL, 13, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:21:48', '1', '2018-12-10 14:55:59');
INSERT INTO `sys_permissions` VALUES ('68', '21', 'sys:user:save', '保存', NULL, '', NULL, 14, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:21:48', '1', '2018-12-10 14:56:03');
INSERT INTO `sys_permissions` VALUES ('6aa7ed074b144ab2c2d31a41c2ac4fc0', '0', NULL, '组件示例', 'appstore', NULL, NULL, 40, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 14:11:04', '1', '2021-04-02 14:11:35');
INSERT INTO `sys_permissions` VALUES ('7', '4', 'sys:dict:select', '字典管理', '', '/sys/dict/list', '/sys/dict/List', 23, 1, '0', '1', '1', '', NULL, '', '2018-11-01 08:42:06', '1', '2020-12-08 12:37:05');
INSERT INTO `sys_permissions` VALUES ('70', '20', 'sys:dept:remove', '删除', NULL, '', NULL, 3, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:21:51', '1', '2018-12-03 00:21:51');
INSERT INTO `sys_permissions` VALUES ('70cf9bdeb9024f91be95715d6ed2192a', 'dfcbf9982ac55701115056a7e09e3cd0', '', '404', 'meh', '/global/404', '/global/404', 41, 1, '0', '1', '1', '', NULL, '126', '2019-08-20 21:27:44', '1', '2021-02-25 09:41:29');
INSERT INTO `sys_permissions` VALUES ('71', '20', 'sys:dept:save', '保存', NULL, '', NULL, 4, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:21:51', '1', '2018-12-03 00:21:51');
INSERT INTO `sys_permissions` VALUES ('72', '20', 'sys:dept:type:select', '部门类型管理', '', '/sys/dept/type', '/sys/dept/type/View', 14, 1, '1', '1', '1', '', NULL, '', '2018-12-03 00:22:12', '1', '2020-11-20 17:56:18');
INSERT INTO `sys_permissions` VALUES ('720e77810ca8ea77ec7f7871985ea018', '228', NULL, '权限验证', 'lock', '/sample/permissions/view', '/sample/permissions/View', 2, 1, '0', '1', '1', NULL, NULL, '1', '2021-02-01 15:33:59', '1', '2021-02-01 16:52:35');
INSERT INTO `sys_permissions` VALUES ('72707fe2c7d4dfd8e23a8e47d3e1169b', '24850d7f708a4c3514f1d3c61a2d1bb6', NULL, 'Loading', NULL, '/sample/components/general/loading', '/sample/components/general/Loading', 2, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 17:33:25', '1', '2021-04-02 17:33:25');
INSERT INTO `sys_permissions` VALUES ('734dacc38f293883683b68c6d3e5b56e', 'e7f55c6889bd826d6a62885ef2ffdb1d', 'activiti:process:save', '保存', NULL, '', NULL, 5, 2, '0', '1', '1', '', NULL, '126', '2019-07-12 17:15:18', '126', '2020-03-30 15:24:11');
INSERT INTO `sys_permissions` VALUES ('74', '72', 'sys:dept:type:remove', '删除', NULL, '', NULL, 2, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:22:18', '1', '2018-12-03 00:22:18');
INSERT INTO `sys_permissions` VALUES ('75', '72', 'sys:dept:type:save', '保存', NULL, '', NULL, 3, 2, '0', '1', '1', '', NULL, '1', '2018-12-03 00:22:18', '1', '2018-12-03 00:22:18');
INSERT INTO `sys_permissions` VALUES ('76', '21', 'sys:user:disable', '禁用用户', NULL, '', NULL, 16, 2, '0', '1', '1', '', NULL, '1', '2018-12-10 14:54:18', '1', '2020-12-11 15:19:21');
INSERT INTO `sys_permissions` VALUES ('76180395fab6dbdab6f6c050169c5f97', '7da1f5456b340b1fc94e8bb8e8ae5e8f', '', '待办任务', 'audit', '/activiti/task/to-do', '/activiti/task/ToDo', 4, 1, '0', '1', '1', '', NULL, '126', '2020-03-31 13:57:55', '1', '2021-01-26 15:30:44');
INSERT INTO `sys_permissions` VALUES ('77', '21', 'sys:user:enable', '启用用户', NULL, '', NULL, 17, 2, '0', '1', '1', '', NULL, '1', '2018-12-10 14:54:49', '1', '2020-12-11 15:19:21');
INSERT INTO `sys_permissions` VALUES ('77ce77c2dd83b746657afbfb2acd21cd', '93d659164c0cbb3716fcee100f029d5c', 'activiti:model:remove', '删除', NULL, '', NULL, 2, 2, '0', '1', '1', '', NULL, '126', '2019-07-03 09:52:52', '126', '2020-03-30 15:24:32');
INSERT INTO `sys_permissions` VALUES ('78', '21', 'sys:user:reset:password', '重置密码', NULL, '', NULL, 18, 2, '0', '1', '1', '', NULL, '1', '2018-12-10 14:55:47', '1', '2020-12-11 15:19:21');
INSERT INTO `sys_permissions` VALUES ('79', '20', 'sys:dept:disable', '禁用', '', '', '', 12, 2, '0', '1', '1', '', NULL, '', '2018-12-10 14:58:09', '1', '2020-11-20 15:57:19');
INSERT INTO `sys_permissions` VALUES ('792d3621d9d2f92acb7b9847dc0ef598', '5', 'sys:log:select', '访问日志', NULL, '/sys/log', '/sys/log/List', 40, 1, '0', '1', '1', '', NULL, '126', '2019-06-27 12:32:32', '1', '2020-12-18 11:23:44');
INSERT INTO `sys_permissions` VALUES ('7da1f5456b340b1fc94e8bb8e8ae5e8f', '0', '', '我的任务', 'carry-out', NULL, NULL, 38, 1, '0', '1', '1', '', NULL, '126', '2020-03-27 15:56:17', '1', '2021-04-02 14:11:12');
INSERT INTO `sys_permissions` VALUES ('7fc6d72df2216b9fecb29d6948d713f2', '0ad4783abe1e84e630c630ed78d7ec53', NULL, 'IconSelector', NULL, '/sample/components/data-entry/iconSelector', '/sample/components/data-entry/IconSelector', 5, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-15 13:13:13', '1', '2021-04-15 13:13:13');
INSERT INTO `sys_permissions` VALUES ('80', '20', 'sys:dept:enable', '启用', '', '', '', 11, 2, '0', '1', '1', '', NULL, '', '2018-12-10 14:58:09', '1', '2020-11-20 15:57:16');
INSERT INTO `sys_permissions` VALUES ('804344d2acf844862d29e6c0438cb09b', '21', '', '详情', '', '/sys/user/input', '/sys/user/Input', 15, 1, '1', '1', '1', '', NULL, '', '2020-12-11 15:19:07', '1', '2020-12-11 15:19:40');
INSERT INTO `sys_permissions` VALUES ('81', '6', 'sys:permissions:status', '更改状态', NULL, '', NULL, 9, 2, '0', '1', '1', '', NULL, '1', '2018-12-13 15:30:32', '1', '2018-12-13 15:30:32');
INSERT INTO `sys_permissions` VALUES ('82', '72', 'sys:dept:type:status', '更改状态', NULL, '', NULL, 5, 2, '0', '1', '1', '', NULL, '1', '2018-12-13 15:56:03', '1', '2018-12-13 16:21:25');
INSERT INTO `sys_permissions` VALUES ('83', '14', 'sys:role:status', '更改状态', NULL, '', NULL, 5, 2, '0', '1', '1', '', NULL, '1', '2018-12-13 15:57:33', '1', '2018-12-13 15:57:50');
INSERT INTO `sys_permissions` VALUES ('830d7d2e1b48277a90308d83193092c4', '0', NULL, '个人设置', 'setting', '/sys/personal/settings', '/sys/personal/settings/View', 37, 1, '1', '1', '1', NULL, NULL, '1', '2020-12-18 14:56:13', '1', '2021-04-02 14:11:12');
INSERT INTO `sys_permissions` VALUES ('84', '7', 'sys:dict:select:status', '更改状态', NULL, '', NULL, 11, 2, '0', '1', '1', '', NULL, '1', '2018-12-13 15:58:39', '1', '2020-12-09 22:56:07');
INSERT INTO `sys_permissions` VALUES ('85', '6', 'sys:permissions:move', '拖动', NULL, '', NULL, 11, 2, '0', '1', '1', '', NULL, '1', '2018-12-13 15:59:38', '1', '2018-12-13 16:00:15');
INSERT INTO `sys_permissions` VALUES ('87', '14', 'sys:role:move', '拖动', NULL, '', NULL, 7, 2, '0', '1', '1', '', NULL, '1', '2018-12-18 13:37:18', '1', '2018-12-18 13:37:28');
INSERT INTO `sys_permissions` VALUES ('8c598d0f30dc9b39aa2ba61fbc8b6d55', '72', 'sys:dept:type:move', '拖动', '', '', '', 6, 1, '0', '1', '1', '', NULL, '1', '2020-11-24 16:04:14', '1', '2020-11-24 16:04:14');
INSERT INTO `sys_permissions` VALUES ('8f8006a8fe45ec55809e35a9c80d5efa', '220', NULL, '详情', '', '/sample/general/input', '/sample/general/Input', 3, 1, '1', NULL, '1', '', NULL, '1', '2021-01-25 12:49:59', '1', '2021-01-25 12:50:26');
INSERT INTO `sys_permissions` VALUES ('906d1078178cb203bb142f8cf22d4245', '236', NULL, '详情', '', '/scheduler/job/input', '/scheduler/job/Input', 4, 1, '1', '1', '1', '', NULL, '1', '2021-01-21 17:21:40', '1', '2021-01-21 17:22:17');
INSERT INTO `sys_permissions` VALUES ('93d659164c0cbb3716fcee100f029d5c', '39c5c5bcdd9a15110e2c3e4014dd1531', 'activiti:model:select', '模型管理', NULL, '/activiti/model/list', '/activiti/model/List', 1, 1, '0', '1', '1', '', NULL, '126', '2019-07-03 09:44:53', '1', '2021-01-05 23:29:05');
INSERT INTO `sys_permissions` VALUES ('a3322940c314d1b6d9ba1d494740971e', 'e7f55c6889bd826d6a62885ef2ffdb1d', 'activiti:process:suspend', '挂起', NULL, '', NULL, 6, 2, '0', '1', '1', '', NULL, '126', '2020-05-21 10:36:59', '126', '2020-05-21 10:37:24');
INSERT INTO `sys_permissions` VALUES ('a45fe4e97ec13806b1b764bf45a6907e', '7', 'sys:dict:generate', '更新字典资源', '', '', '', 12, 2, '0', '1', '1', '', NULL, '1', '2020-12-09 15:26:41', '1', '2020-12-09 22:56:07');
INSERT INTO `sys_permissions` VALUES ('a49b5f6745d8d1516c451ab651994241', '224', NULL, '详情', '', '/sys/import-excel-template/input', '/sys/import-excel-template/Input', 6, 1, '1', '1', '1', '', NULL, '1', '2021-02-03 13:33:47', '1', '2021-02-03 13:36:45');
INSERT INTO `sys_permissions` VALUES ('a90369995b54a72ef84b8c50ca87f185', '0ad4783abe1e84e630c630ed78d7ec53', '', 'Cron', NULL, '/sample/components/data-entry/cron', '/sample/components/data-entry/Cron', 6, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-15 13:41:36', '1', '2021-04-15 13:41:36');
INSERT INTO `sys_permissions` VALUES ('ae53867719661453637074b18dd7f5ab', '17dcc367a2c812c36b0d3e2710a567cd', 'sample:work:flow:save', '保存', '', '', '', 1, 2, '0', '1', '1', '', NULL, '', '2020-04-26 15:07:59', '1', '2020-11-19 10:18:11');
INSERT INTO `sys_permissions` VALUES ('b60d19ba001712231b5c0fc49d057cf3', '258f7c40fca863460ba002f2fb759734', NULL, '柱状图', NULL, '/sample/charts/bar', '/sample/charts/Bar', 1, 1, '0', '1', '1', NULL, NULL, '1', '2021-02-22 16:12:15', '1', '2021-02-22 16:12:15');
INSERT INTO `sys_permissions` VALUES ('c25cf52649878c66073c4ac0d691e86b', '7da1f5456b340b1fc94e8bb8e8ae5e8f', '', '待签任务', 'file-protect', '/activiti/task/waitingClaim', '/activiti/task/WaitingClaim', 3, 1, '0', '1', '1', '', NULL, '126', '2020-03-30 13:46:02', '1', '2021-01-26 15:30:30');
INSERT INTO `sys_permissions` VALUES ('c27ed60160a14953aa9870e7ef30161d', '0ad4783abe1e84e630c630ed78d7ec53', NULL, '字典', NULL, '/sample/components/data-entry/dict', '/sample/components/data-entry/Dict', 1, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 16:25:30', '1', '2021-04-02 16:25:36');
INSERT INTO `sys_permissions` VALUES ('c300bc141a442467ba8321c9ba296845', '224', NULL, '导入规则', NULL, '/sys/import-excel-template-details/input', '/sys/import-excel-template-details/Input', 7, 1, '1', '1', '1', NULL, NULL, '1', '2021-02-03 14:43:56', '1', '2021-02-03 14:43:56');
INSERT INTO `sys_permissions` VALUES ('c44e35a713e6e68ab1825ff0f6dd0a41', '792d3621d9d2f92acb7b9847dc0ef598', NULL, '详情', '', '/sys/log/input', '/sys/log/Input', 1, 1, '1', '1', '1', '', NULL, '1', '2020-12-18 11:23:52', '1', '2020-12-18 11:24:01');
INSERT INTO `sys_permissions` VALUES ('c8309ab70e379fc180bfc0ea78b44660', '0ad4783abe1e84e630c630ed78d7ec53', NULL, 'LimitTextArea', NULL, '/sample/components/data-entry/limit-text-area', '/sample/components/data-entry/LimitTextArea', 4, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 17:49:55', '1', '2021-04-06 16:18:11');
INSERT INTO `sys_permissions` VALUES ('c87e9bfb5e509135b4fb2516629e72cd', 'dfcbf9982ac55701115056a7e09e3cd0', '', '百度', 'api', '/sample/baidu/view', '/sample/baidu/View', 19, 1, '0', '1', '1', '', NULL, '', '2020-06-29 21:17:43', '1', '2021-02-25 09:41:29');
INSERT INTO `sys_permissions` VALUES ('cbdd956e2a348039fe01d76c2e6d4e91', '93d659164c0cbb3716fcee100f029d5c', 'activiti:model:save', '保存/修改', '', '', '', 1, 2, '0', '1', '1', '', NULL, '', '2019-07-03 09:52:52', '1', '2021-01-05 17:35:12');
INSERT INTO `sys_permissions` VALUES ('ccfeae90e4d3391ad54451fa2b4c1cd4', '218', NULL, '详情', '', '/sys/exception/input', '/sys/exception/Input', 2, 1, '1', '1', '1', '', NULL, '1', '2020-12-17 22:34:07', '1', '2020-12-17 22:34:22');
INSERT INTO `sys_permissions` VALUES ('d457a36b43fd8e9ad6461c9d42d3a098', 'e7f55c6889bd826d6a62885ef2ffdb1d', 'activiti:process:activation', '激活', NULL, '', NULL, 7, 2, '0', '1', '1', '', NULL, '126', '2020-05-21 10:37:21', '126', '2020-05-21 10:37:21');
INSERT INTO `sys_permissions` VALUES ('dfcbf9982ac55701115056a7e09e3cd0', '0', '', '页面示例', 'file-text', '', '', 43, 1, '0', '1', '1', '', NULL, '', '2019-08-20 21:26:44', '1', '2021-04-02 14:11:12');
INSERT INTO `sys_permissions` VALUES ('e6c67a0706a8ea62dac289f74b4a498e', '17dcc367a2c812c36b0d3e2710a567cd', NULL, '详情', NULL, '/sample/work-flow/info', '/sample/work-flow/Info', 4, 1, '1', '1', '1', NULL, NULL, '1', '2021-01-19 16:04:59', '1', '2021-01-19 16:05:01');
INSERT INTO `sys_permissions` VALUES ('e7f55c6889bd826d6a62885ef2ffdb1d', '39c5c5bcdd9a15110e2c3e4014dd1531', 'activiti:process:select', '流程管理', NULL, '/activiti/process/list', '/activiti/process/List', 2, 1, '0', '1', '1', '', NULL, '126', '2019-07-03 09:45:12', '1', '2021-01-08 22:52:16');
INSERT INTO `sys_permissions` VALUES ('eff43f39d4199f9352e6f150b53d3e22', '006606eb1a80f98445844312e8c69d70', NULL, 'Ellipsis', NULL, '/sample/components/data-display/ellipsis', '/sample/components/data-display/Ellipsis', 1, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 17:46:06', '1', '2021-04-02 17:46:06');
INSERT INTO `sys_permissions` VALUES ('f1d3af076c2810d690edefbdc3462c23', 'e7f55c6889bd826d6a62885ef2ffdb1d', 'activiti:process:remove', '删除', NULL, '', NULL, 4, 2, '0', '1', '1', '', NULL, '126', '2019-07-12 17:15:18', '126', '2020-03-30 15:24:07');
INSERT INTO `sys_permissions` VALUES ('fad6510a4f85d5645a1fe7d7964587eb', '24850d7f708a4c3514f1d3c61a2d1bb6', NULL, 'Button', NULL, '/sample/components/general/button', '/sample/components/general/Button', 1, 1, '0', '1', '1', NULL, NULL, '1', '2021-04-02 14:19:53', '1', '2021-04-02 14:20:10');
INSERT INTO `sys_permissions` VALUES ('fe84bcc6e4781447ea21573eb04bf0fb', '39c5c5bcdd9a15110e2c3e4014dd1531', 'activiti:historic:select:all', '流程跟踪', NULL, '/activiti/history-task-instance/all', '/activiti/history/taskInstance/All', 3, 1, '0', '1', '1', '查看所有任务，包含办理中和已办结，一般分配给管理员', NULL, '126', '2020-05-14 13:28:39', '1', '2021-01-19 14:10:22');
INSERT INTO `sys_permissions` VALUES ('fee57187cae386f067db09aeb0b16b4a', '93d659164c0cbb3716fcee100f029d5c', 'activiti:model:deployment', '部署流程', NULL, '', NULL, 4, 2, '0', '1', '1', '', NULL, '126', '2019-07-11 21:55:01', '126', '2020-03-30 15:24:42');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL,
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `p_id` varchar(32) DEFAULT NULL COMMENT '父id',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  `code` varchar(50) DEFAULT NULL COMMENT '角色标识',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(1.启用 0.禁用)',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁保留字段',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('3', 191, '0', '系统管理员', '', 'sys:admin', '2018-11-26 23:14:42', '', '1', '2021-04-15 13:41:43', '1', NULL, '拥有至高无上的权利');
INSERT INTO `sys_role` VALUES ('4', 177, '0', '演示', '', 'demo', '2018-11-27 07:48:43', '', '1', '2021-02-02 09:38:40', '1', NULL, '');
INSERT INTO `sys_role` VALUES ('65bdd699e5b623c8efec4eb74639bafc', 178, '0', '人事', '', 'hr:audit', '2020-03-27 15:43:41', '', '1', '2021-02-02 09:38:53', '1', NULL, '');
INSERT INTO `sys_role` VALUES ('920f6f953610571e740fc517e3c99899', 176, '0', '部门领导', '', 'dept:leader', '2020-03-27 15:43:24', '', '1', '2021-02-02 09:38:23', '1', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permissions`;
CREATE TABLE `sys_role_permissions` (
  `role_id` varchar(32) NOT NULL,
  `permissions_id` varchar(32) NOT NULL,
  `id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';

-- ----------------------------
-- Records of sys_role_permissions
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_permissions` VALUES ('3', '17dcc367a2c812c36b0d3e2710a567cd', '00c5f89aefcd354fdf3e58cdaabbf2e8');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '70cf9bdeb9024f91be95715d6ed2192a', '01a9d9ebee8abe0baa5a57fe7c257aa9');
INSERT INTO `sys_role_permissions` VALUES ('3', '8f8006a8fe45ec55809e35a9c80d5efa', '022d20bb4c37c048b1f1af04a34ccf47');
INSERT INTO `sys_role_permissions` VALUES ('3', '222', '03a7e47eb8015a9e28ab5cd7825e4875');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '235', '045f21bdd55e769cf744830a361cf70d');
INSERT INTO `sys_role_permissions` VALUES ('3', '164', '063089ba26a07e716c38f8436a68926b');
INSERT INTO `sys_role_permissions` VALUES ('4', '720e77810ca8ea77ec7f7871985ea018', '068919611498db04a3f4d117341d343b');
INSERT INTO `sys_role_permissions` VALUES ('3', '2b33f190aa0543c8e1acfddbf224361f', '06bf120b1fc8c50ad9e54c7871cfd3cf');
INSERT INTO `sys_role_permissions` VALUES ('3', '128152f2dc1b2a37ddfebaa4b175446a', '070d73052ded37e0b1de5f9c0446aa91');
INSERT INTO `sys_role_permissions` VALUES ('3', '77', '08ef6c027ebf756287c8f4f8afd14898');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '242', '098edf70a5c5b5a0b6d8af39b9f5ec1d');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '7da1f5456b340b1fc94e8bb8e8ae5e8f', '0b490c13907619fe97c9e5eb008a651f');
INSERT INTO `sys_role_permissions` VALUES ('3', '20', '0e13f3094122695e60060e5e3c2844b0');
INSERT INTO `sys_role_permissions` VALUES ('3', '238', '0ea895c0f7504dc8ddd567579b8deeef');
INSERT INTO `sys_role_permissions` VALUES ('3', '231', '1098ed4cc88d0848cf786d308991d3b2');
INSERT INTO `sys_role_permissions` VALUES ('3', '70', '120c0654b070e069aa5b5041801273e9');
INSERT INTO `sys_role_permissions` VALUES ('4', '241', '133f4a7cf4cca102ccf9a7222b5c6fe8');
INSERT INTO `sys_role_permissions` VALUES ('3', '906d1078178cb203bb142f8cf22d4245', '185bf044fe9f8f90640a5b6b2888f2f0');
INSERT INTO `sys_role_permissions` VALUES ('3', '68', '19ac0b37d6d174ecde4d5bab276b2a92');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '128152f2dc1b2a37ddfebaa4b175446a', '19b95b3ab8ccf094657331a7a2d8d08a');
INSERT INTO `sys_role_permissions` VALUES ('4', 'c25cf52649878c66073c4ac0d691e86b', '1a469211891fc4bb9e458961fc39ccf2');
INSERT INTO `sys_role_permissions` VALUES ('3', '53', '1a5dd6a69588c7fc0169593d83f27e12');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', 'e6c67a0706a8ea62dac289f74b4a498e', '1ac0b497d47d60d6bb54d94fcccf48a2');
INSERT INTO `sys_role_permissions` VALUES ('3', 'd457a36b43fd8e9ad6461c9d42d3a098', '1b637df6ec6648aea2a2be09efb251d7');
INSERT INTO `sys_role_permissions` VALUES ('3', 'f1d3af076c2810d690edefbdc3462c23', '1d7d27bfc401049fc1c18949b6a5f54c');
INSERT INTO `sys_role_permissions` VALUES ('3', 'c87e9bfb5e509135b4fb2516629e72cd', '1da312f4fa045a7e95f6c5f4d77edbc8');
INSERT INTO `sys_role_permissions` VALUES ('3', 'a49b5f6745d8d1516c451ab651994241', '1e1e7752f66bfb3bcaba9c63f522e4bb');
INSERT INTO `sys_role_permissions` VALUES ('3', '81', '1e59ad0aa71053bd98733e07ae19b959');
INSERT INTO `sys_role_permissions` VALUES ('4', '243', '23ab991ba78ad7e4ca811fbbd9f6720f');
INSERT INTO `sys_role_permissions` VALUES ('3', 'dfcbf9982ac55701115056a7e09e3cd0', '2485accc0c681c6cb8f867b058e246bd');
INSERT INTO `sys_role_permissions` VALUES ('3', '159', '24cda044ec34dbfe1dbfecf711e1078c');
INSERT INTO `sys_role_permissions` VALUES ('3', 'b60d19ba001712231b5c0fc49d057cf3', '274b3c57c653e13c8aed3e13196a6829');
INSERT INTO `sys_role_permissions` VALUES ('3', '4aba9a2f7c81615c9ccdc07e980ccfe3', '277e7ef327a9c23248b13e9b45586eef');
INSERT INTO `sys_role_permissions` VALUES ('3', 'c8309ab70e379fc180bfc0ea78b44660', '27fe43c12e3ec33e9b3f8b1908bddef2');
INSERT INTO `sys_role_permissions` VALUES ('3', '0', '287536a7746c823ac7d8bb90d1007944');
INSERT INTO `sys_role_permissions` VALUES ('3', '645350c2c094dc8a7ccf71563a4f7cbb', '2943e9d9983322bd09068c3bb91c3979');
INSERT INTO `sys_role_permissions` VALUES ('3', '240', '2bb3318a6631a80747fe2fd4020dcdbd');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '03ad13494a492eee81d8d7d1e2d95d14', '2d16ba330520f04bf82f945e3d2a0772');
INSERT INTO `sys_role_permissions` VALUES ('3', '220', '2fbb99f0058fa3c0b6c7c0317981ca90');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', 'c25cf52649878c66073c4ac0d691e86b', '311b3bdf40fe8dda1d8e840745686710');
INSERT INTO `sys_role_permissions` VALUES ('3', '55', '31f4288ba9d1f2714e4d26eb5eda3524');
INSERT INTO `sys_role_permissions` VALUES ('3', '149', '3201807cc9f9138503a1e3ab0451f0ad');
INSERT INTO `sys_role_permissions` VALUES ('3', '64', '33b7eec1867598db2f96d9d2db0605a7');
INSERT INTO `sys_role_permissions` VALUES ('3', '84', '35878d3b628fba09ac1eac35d8190531');
INSERT INTO `sys_role_permissions` VALUES ('3', '60a83e7df038e40410526510e5a12cbc', '37a84e594023822943d41596e3aec474');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '830d7d2e1b48277a90308d83193092c4', '3a39299d3f37d55743dd6230380b3aa0');
INSERT INTO `sys_role_permissions` VALUES ('3', '87', '3be16400392a196d9b7d2131b5c072ba');
INSERT INTO `sys_role_permissions` VALUES ('4', '235', '3d1e70a69260b55fc4f19ad90ab43e9a');
INSERT INTO `sys_role_permissions` VALUES ('3', '3907ba1a0c6196d98314434c6fd44f00', '3d316ff83608b17ee6f9f15a85ea8ad9');
INSERT INTO `sys_role_permissions` VALUES ('3', '258f7c40fca863460ba002f2fb759734', '3d984832d99f28c5d54f216413267e2b');
INSERT INTO `sys_role_permissions` VALUES ('3', '85', '3e940ff6014fa5c7fed2a76cb04c0601');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '242', '3ebea7089b03db9869547915cd5cb1ee');
INSERT INTO `sys_role_permissions` VALUES ('3', '3e76a9e2bcab94d347203a178765e621', '3fdd458650fccf26fcdffc3a70b35837');
INSERT INTO `sys_role_permissions` VALUES ('3', 'c44e35a713e6e68ab1825ff0f6dd0a41', '41a7111767756e878005bfad8a0774e1');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '3e76a9e2bcab94d347203a178765e621', '42da02ddfb3366160cba8a251bae5679');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', 'c25cf52649878c66073c4ac0d691e86b', '4324081686f92546320772006fb1e180');
INSERT INTO `sys_role_permissions` VALUES ('3', '32', '4388d64a0da3a8031016af66ad8b028c');
INSERT INTO `sys_role_permissions` VALUES ('4', '76180395fab6dbdab6f6c050169c5f97', '44ca27d30ea131a2b4578e43ff6b865e');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '03ad13494a492eee81d8d7d1e2d95d14', '46c4fa8a4d04201e4fa838e63a7a3c5b');
INSERT INTO `sys_role_permissions` VALUES ('3', '52', '46dad5ef122d72c2716498b24abfc5bc');
INSERT INTO `sys_role_permissions` VALUES ('3', 'fe84bcc6e4781447ea21573eb04bf0fb', '48dc075ddcd9b99e9f8a3cc2680d7151');
INSERT INTO `sys_role_permissions` VALUES ('3', '79', '49b77d3a43a8cb9250e7b25b9d575bd8');
INSERT INTO `sys_role_permissions` VALUES ('3', 'e6c67a0706a8ea62dac289f74b4a498e', '4a91819858591acb4071bd022657479a');
INSERT INTO `sys_role_permissions` VALUES ('3', '62', '4af2c47ffce92a2a31bd7d2cb2fbea84');
INSERT INTO `sys_role_permissions` VALUES ('3', '4dd114436fd08e63cada54d6c32c1fe3', '4b0776a203091d8f9ff03ac64eddc967');
INSERT INTO `sys_role_permissions` VALUES ('4', '228', '4d8d49109f5bc7b88bfdc08dcba097a8');
INSERT INTO `sys_role_permissions` VALUES ('4', '3e76a9e2bcab94d347203a178765e621', '4ee55b87355c94d4973fa2c4ae830126');
INSERT INTO `sys_role_permissions` VALUES ('3', '7fc6d72df2216b9fecb29d6948d713f2', '4fd270c401fd7de99e6062ba41fa374c');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '8f8006a8fe45ec55809e35a9c80d5efa', '52260db2481c1e38ad656785bc35744d');
INSERT INTO `sys_role_permissions` VALUES ('3', '74', '52869ee7a86500f2ab1c2b0dd6784665');
INSERT INTO `sys_role_permissions` VALUES ('4', 'ae53867719661453637074b18dd7f5ab', '54f501cb450737e9989da50705e60c2c');
INSERT INTO `sys_role_permissions` VALUES ('3', 'fee57187cae386f067db09aeb0b16b4a', '54fce9795e44e1abbde35e0b22ef9a54');
INSERT INTO `sys_role_permissions` VALUES ('3', '226', '55f262542be4d19a6d3c760d02a1f0ae');
INSERT INTO `sys_role_permissions` VALUES ('3', '006606eb1a80f98445844312e8c69d70', '56758fc2cdb6d8541081fc0da1759d30');
INSERT INTO `sys_role_permissions` VALUES ('4', '221', '5693a9e51c7f9669d95be9ec2e7b0dc7');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '243', '56ea47a2ba06beae44417970cd436f71');
INSERT INTO `sys_role_permissions` VALUES ('3', '3b79694872fa73ff05699bde511b238f', '57ce87b8efe875689cc2fbbcce0bac4f');
INSERT INTO `sys_role_permissions` VALUES ('3', '17', '608a6b5ff1b542cfc97dc96978abceba');
INSERT INTO `sys_role_permissions` VALUES ('3', '67', '61c3fb90d1703b543bdea9094ddefa26');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '76180395fab6dbdab6f6c050169c5f97', '63bec182e2347c19a4517b397dc570f8');
INSERT INTO `sys_role_permissions` VALUES ('3', 'cbdd956e2a348039fe01d76c2e6d4e91', '6437fee7f06671103b1dc5db2b62cdaa');
INSERT INTO `sys_role_permissions` VALUES ('3', '5fd40d8344c4a5e71fe606364c8fb9d9', '6654681bda2a3ee6090b5984e8dfed8e');
INSERT INTO `sys_role_permissions` VALUES ('3', '0f5f756d9f287ea1e8172bb2e6e170d8', '6785e16ff9eab1e10200db2c5508bd14');
INSERT INTO `sys_role_permissions` VALUES ('3', 'e7f55c6889bd826d6a62885ef2ffdb1d', '6a3dc990975ef1e80ee66769ac2dcdcb');
INSERT INTO `sys_role_permissions` VALUES ('3', '71', '6a4726261c63d2d827cdb2bc5b195eac');
INSERT INTO `sys_role_permissions` VALUES ('3', '7da1f5456b340b1fc94e8bb8e8ae5e8f', '6c278a15b188923968a1b58153fffcdf');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', 'ae53867719661453637074b18dd7f5ab', '6c4670ebaf61ebe565c558bb16ed15cb');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '3b79694872fa73ff05699bde511b238f', '6c6ff4cc63bd0d57ba6526143efa0031');
INSERT INTO `sys_role_permissions` VALUES ('3', '5', '6d964d8021e4ce66c8b1c70a4ac877b1');
INSERT INTO `sys_role_permissions` VALUES ('3', '76', '7070e71426c0e9ad08c27f82aa6caf22');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '17dcc367a2c812c36b0d3e2710a567cd', '7143f911ee23751f8c6c87648027482c');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '3e76a9e2bcab94d347203a178765e621', '719a677bef4c3e711fae38fb83682f78');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '243', '729605458d04073b129298e774ad191f');
INSERT INTO `sys_role_permissions` VALUES ('3', '720e77810ca8ea77ec7f7871985ea018', '739f33b4a15da2d44b5691e971f416ac');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '231', '7483e1c965733cdaf239be0bdf535458');
INSERT INTO `sys_role_permissions` VALUES ('4', '2fb368f87b018eb6858abc8703945623', '756529e691f30aadf0313a1cd9185cf4');
INSERT INTO `sys_role_permissions` VALUES ('3', '151', '75eadd52fbed86f8ecf25d09e9284b39');
INSERT INTO `sys_role_permissions` VALUES ('3', 'c300bc141a442467ba8321c9ba296845', '7684255f54f30188b0c73e006befddcf');
INSERT INTO `sys_role_permissions` VALUES ('4', 'c87e9bfb5e509135b4fb2516629e72cd', '780dee904079646a800d276794348c72');
INSERT INTO `sys_role_permissions` VALUES ('3', '6aa7ed074b144ab2c2d31a41c2ac4fc0', '7b44bba092fffcf28ba1eff6419004ef');
INSERT INTO `sys_role_permissions` VALUES ('3', '56', '7cb63a7c8722bdf8ea10218c0fa5909c');
INSERT INTO `sys_role_permissions` VALUES ('4', '234', '7ce3f31ea6b92f92bd637ec6240ede2a');
INSERT INTO `sys_role_permissions` VALUES ('3', '8c598d0f30dc9b39aa2ba61fbc8b6d55', '7da9c606862f48b5df7b43376da7626b');
INSERT INTO `sys_role_permissions` VALUES ('3', 'a3322940c314d1b6d9ba1d494740971e', '7f8a3a24792fe9a43773e7e9b042075e');
INSERT INTO `sys_role_permissions` VALUES ('3', '243', '8270d36f3703031b87aa829c6e5f7061');
INSERT INTO `sys_role_permissions` VALUES ('4', '3b79694872fa73ff05699bde511b238f', '82a19f33b6446b3084cd05cf1e0726d8');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '241', '8343a1899583f05512a346c904531a86');
INSERT INTO `sys_role_permissions` VALUES ('3', '80', '83f43f5257e76c148f5eb00f59eef2d8');
INSERT INTO `sys_role_permissions` VALUES ('4', '17dcc367a2c812c36b0d3e2710a567cd', '855858ea9037c9aa24709596dce76cc0');
INSERT INTO `sys_role_permissions` VALUES ('3', '150', '85c9108d558dc6226d3be6914209ab0e');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', 'dfcbf9982ac55701115056a7e09e3cd0', '87512eb6d1cd52755e05c1579d91ea50');
INSERT INTO `sys_role_permissions` VALUES ('3', '70cf9bdeb9024f91be95715d6ed2192a', '88da36ac32330c8d6b9599ac165333be');
INSERT INTO `sys_role_permissions` VALUES ('3', '39c5c5bcdd9a15110e2c3e4014dd1531', '8b7baf30f7b694fe9a7c8ecc9ebb3768');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '241', '8cdd3f45935447d0b1b3513088e3d9ad');
INSERT INTO `sys_role_permissions` VALUES ('3', '51d7635a9faf42627e5b0c33715a8fcc', '8e5a876f5c7de7ebeb5e4f7adc934917');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', 'c87e9bfb5e509135b4fb2516629e72cd', '9032d6d775e6b17ab988e4bb4878adc1');
INSERT INTO `sys_role_permissions` VALUES ('3', 'c25cf52649878c66073c4ac0d691e86b', '91554c6b3e98e8985ca86ac1d44cb1da');
INSERT INTO `sys_role_permissions` VALUES ('4', '4aba9a2f7c81615c9ccdc07e980ccfe3', '9156414790077cd3afa7fb5a17d7619a');
INSERT INTO `sys_role_permissions` VALUES ('4', '242', '91e82e2bb8876fb5eb403a3a53edd5ea');
INSERT INTO `sys_role_permissions` VALUES ('af56f74db7a90f428ff91235ba0340ab', '234', '92ce23d3c36ec76db18eccffaf939a27');
INSERT INTO `sys_role_permissions` VALUES ('3', '0ad4783abe1e84e630c630ed78d7ec53', '9ab2656355e14ecd9281e2c25e346d59');
INSERT INTO `sys_role_permissions` VALUES ('3', '7', '9dabc651b066986a89d9636b624d6465');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '0f5f756d9f287ea1e8172bb2e6e170d8', '9e38a612822ffdd1081bbc93dea66884');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '2fb368f87b018eb6858abc8703945623', '9e6b3a650d7f29184990cdcec97b8b3a');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '645350c2c094dc8a7ccf71563a4f7cbb', '9e92187acde872a0b835caf9641d426b');
INSERT INTO `sys_role_permissions` VALUES ('3', '77ce77c2dd83b746657afbfb2acd21cd', 'a2647c01267b9c0b11d266845549556b');
INSERT INTO `sys_role_permissions` VALUES ('4', '8f8006a8fe45ec55809e35a9c80d5efa', 'a37dd3ab70524d3dfd00229bb1c0883b');
INSERT INTO `sys_role_permissions` VALUES ('3', '157', 'a46c4efb956c5ee6054fa2ae686364f3');
INSERT INTO `sys_role_permissions` VALUES ('3', 'c27ed60160a14953aa9870e7ef30161d', 'a4c34d78b613c9540267eeab025f3b12');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '0f5f756d9f287ea1e8172bb2e6e170d8', 'a57b3cc8eee19fbe794d0c384c593764');
INSERT INTO `sys_role_permissions` VALUES ('3', '14', 'a5de1e23cd550602c7c659cacabe5082');
INSERT INTO `sys_role_permissions` VALUES ('3', '225', 'a6c29f29a3affcb44195ef9b775904f5');
INSERT INTO `sys_role_permissions` VALUES ('3', '242', 'a7c3ca691c5696373d6ae2a889a1fa23');
INSERT INTO `sys_role_permissions` VALUES ('3', '0c77991b94e723d454898e53e6708b41', 'a8099e280226c676d25d1382d6e3a07a');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '228', 'a8fa0944541f155d649e2dc4480d28e0');
INSERT INTO `sys_role_permissions` VALUES ('3', 'a90369995b54a72ef84b8c50ca87f185', 'a9eded475126fd38aa05f24825941926');
INSERT INTO `sys_role_permissions` VALUES ('3', '830d7d2e1b48277a90308d83193092c4', 'ac2cd00970386175cc1f276a8902f7a2');
INSERT INTO `sys_role_permissions` VALUES ('3', '76180395fab6dbdab6f6c050169c5f97', 'ac830395350db5ebcedf6b6f9a22dc05');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '235', 'ad1a601272b42f781f271f4bd654faf4');
INSERT INTO `sys_role_permissions` VALUES ('4', 'e6c67a0706a8ea62dac289f74b4a498e', 'adef0d8c855ad7fa81b20a3978b10539');
INSERT INTO `sys_role_permissions` VALUES ('4', '830d7d2e1b48277a90308d83193092c4', 'af09b369a5510a0f2462861faf78dec6');
INSERT INTO `sys_role_permissions` VALUES ('3', '72707fe2c7d4dfd8e23a8e47d3e1169b', 'af3950f9032dbd197a64ce925773cbb2');
INSERT INTO `sys_role_permissions` VALUES ('3', '237', 'af97c060c818e571418acdf2b91fa18b');
INSERT INTO `sys_role_permissions` VALUES ('4', '0f5f756d9f287ea1e8172bb2e6e170d8', 'afbf834d8e663f707699385932e0ed94');
INSERT INTO `sys_role_permissions` VALUES ('3', '241', 'afd9694645b17937e810cbd527eda0f1');
INSERT INTO `sys_role_permissions` VALUES ('3', 'ccfeae90e4d3391ad54451fa2b4c1cd4', 'b0f4f536ec1b86f339a9ef09d6bf21c6');
INSERT INTO `sys_role_permissions` VALUES ('3', 'a45fe4e97ec13806b1b764bf45a6907e', 'b0ffb733b0024d5a9fda4d2c34fc6998');
INSERT INTO `sys_role_permissions` VALUES ('3', '93d659164c0cbb3716fcee100f029d5c', 'b22260f03c2a6d83fa5075ad291b316b');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '222', 'b2b60519183e9d06adff77e63587831a');
INSERT INTO `sys_role_permissions` VALUES ('4', '231', 'b697be2b1babc428494d4a17c4f8f486');
INSERT INTO `sys_role_permissions` VALUES ('3', '72', 'b6b2708490de0bbdb60f660e9e6a058b');
INSERT INTO `sys_role_permissions` VALUES ('3', '734dacc38f293883683b68c6d3e5b56e', 'bc038409838b490ea035d61c20240c26');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '220', 'becacb4df2811f80bfa54c77ca4f6a5e');
INSERT INTO `sys_role_permissions` VALUES ('4', '220', 'c08b99e40c217c091154b1ff9e3e1dc7');
INSERT INTO `sys_role_permissions` VALUES ('3', '16', 'c0fd56c52cc6ef02db186bb064cd9e49');
INSERT INTO `sys_role_permissions` VALUES ('3', '221', 'c295efe23642568bd4f21f0cb139ba2d');
INSERT INTO `sys_role_permissions` VALUES ('3', '15', 'c2a96f4b89f3fd263f89bb32debe6207');
INSERT INTO `sys_role_permissions` VALUES ('3', '235', 'c373b43f22013cf9cb7d640777e9b392');
INSERT INTO `sys_role_permissions` VALUES ('3', '234', 'c52a4ddbf40297d593dc0a2fb3b799b7');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '7da1f5456b340b1fc94e8bb8e8ae5e8f', 'c65bac5ee03f1356d2e31eb8a663c87f');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '234', 'cd7b2f5cb712a9643612841908324f47');
INSERT INTO `sys_role_permissions` VALUES ('3', '228', 'cf1e4effe946e5dfa2cb7025c351c7dc');
INSERT INTO `sys_role_permissions` VALUES ('3', 'eff43f39d4199f9352e6f150b53d3e22', 'd2141d4a4beeeaa04f8bbfc6d8175ab7');
INSERT INTO `sys_role_permissions` VALUES ('3', '158', 'd30240e0a7eeb7007f815ae2c0ae1dce');
INSERT INTO `sys_role_permissions` VALUES ('3', '82', 'd3455ddf4e527059e2a6bc95867ee892');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '720e77810ca8ea77ec7f7871985ea018', 'd3b841a9f079243e58fb19ea95d4e405');
INSERT INTO `sys_role_permissions` VALUES ('3', '4', 'd688f62a0e5d2aa116cad71c633a756e');
INSERT INTO `sys_role_permissions` VALUES ('3', 'fad6510a4f85d5645a1fe7d7964587eb', 'd81868b7cd30124b1d43b708fec4c62c');
INSERT INTO `sys_role_permissions` VALUES ('4', '222', 'd89d807cc1e16ee3b2f07d88f81f738c');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '221', 'd921459367e1bcebac137a7dc520a0b6');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '3b79694872fa73ff05699bde511b238f', 'd9f7a808590d9220a61962e6aed911be');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '76180395fab6dbdab6f6c050169c5f97', 'db2b99ccbb8da8c519cb91ed4eff3b0a');
INSERT INTO `sys_role_permissions` VALUES ('3', '75', 'dc4439381e4c33bb2b41816684bc19ba');
INSERT INTO `sys_role_permissions` VALUES ('3', '792d3621d9d2f92acb7b9847dc0ef598', 'dd2473c3a7e826a663f6f215aa5837f3');
INSERT INTO `sys_role_permissions` VALUES ('3', '83', 'dda6614e794d087dfd9397b211eda131');
INSERT INTO `sys_role_permissions` VALUES ('4', '7da1f5456b340b1fc94e8bb8e8ae5e8f', 'e0e42e155ac059b3018744220754ab2d');
INSERT INTO `sys_role_permissions` VALUES ('3', '218', 'e0fafc90780b54fea8330ecd5cc25253');
INSERT INTO `sys_role_permissions` VALUES ('3', '03ad13494a492eee81d8d7d1e2d95d14', 'e11b6bce722e0020c97bc016090ec36e');
INSERT INTO `sys_role_permissions` VALUES ('3', '21', 'e2cd9961b62cc55d73be4b69188d4bd5');
INSERT INTO `sys_role_permissions` VALUES ('3', '804344d2acf844862d29e6c0438cb09b', 'e4dc5a8cfc7976caa1c637138f457af6');
INSERT INTO `sys_role_permissions` VALUES ('3', '61', 'e903a0e123b0d291692e302ce68463b5');
INSERT INTO `sys_role_permissions` VALUES ('3', '236', 'ea07bc00d1c0016a1dbdfc9e32a84785');
INSERT INTO `sys_role_permissions` VALUES ('3', '78', 'ed9bc15bfedbc34c5d02ebc8f6f28aa8');
INSERT INTO `sys_role_permissions` VALUES ('3', '65', 'ee87c400294430d8e30b61cfbcd1ca29');
INSERT INTO `sys_role_permissions` VALUES ('3', 'ae53867719661453637074b18dd7f5ab', 'eec5ea387d584c45f69f19d3490eaf32');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '5fd40d8344c4a5e71fe606364c8fb9d9', 'ef0c34851f10918f0763f645b63c6d24');
INSERT INTO `sys_role_permissions` VALUES ('3', '2fb368f87b018eb6858abc8703945623', 'f0dde92a153875291397194a251c9b87');
INSERT INTO `sys_role_permissions` VALUES ('3', '219', 'f217e1f3e4578a70eefcd3e572d79305');
INSERT INTO `sys_role_permissions` VALUES ('3', '24850d7f708a4c3514f1d3c61a2d1bb6', 'f30591284a0c92f43154148a915f8a18');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '830d7d2e1b48277a90308d83193092c4', 'f591b803999bc156c33dcf4cc94ab80b');
INSERT INTO `sys_role_permissions` VALUES ('65bdd699e5b623c8efec4eb74639bafc', '234', 'f89e91d963f57ee0a9da1211a353df9e');
INSERT INTO `sys_role_permissions` VALUES ('4', '03ad13494a492eee81d8d7d1e2d95d14', 'fb56efaa8b556ed23bfb7d811dfd5304');
INSERT INTO `sys_role_permissions` VALUES ('3', '6', 'fbcb4e1f88f66d5c965fc62843a1d5be');
INSERT INTO `sys_role_permissions` VALUES ('3', '224', 'fccb1b63fa992f6b3554ccb4d92c573b');
INSERT INTO `sys_role_permissions` VALUES ('920f6f953610571e740fc517e3c99899', '4aba9a2f7c81615c9ccdc07e980ccfe3', 'fd9dcc7e117dc89a287ec519f7b7c24d');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL,
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `password_strength` varchar(32) DEFAULT NULL COMMENT '密码强度',
  `salt` varchar(20) DEFAULT NULL COMMENT 'md5密码盐',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(1.正常 2.冻结 0.已删除)',
  `source` varchar(32) DEFAULT NULL COMMENT '用户来源',
  `last_login` datetime DEFAULT NULL COMMENT '最后登录时间',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁保留字段',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '编辑人',
  `edit_date` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('068cf9e66de5d067627d08519681895a', '1750cbea9db36f3ad6e6d995b2e4a0f9', 'EF科技南京分公司', 'nanjing-admin', '9745daec482ea4fcb46ff92e6a621b04', '1', 'umq6los8z8', '1', NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, '1', '2020-12-14 15:32:37', '1', '2020-12-14 15:32:37');
INSERT INTO `sys_user` VALUES ('0d77057dcae2af878ee7bb336bb2f254', '1', '世冬萱', 'shidongxuan', '7d9d91e4ee6fbf45991146edbc532d15', NULL, 'm7ijb3ptic', '2', NULL, NULL, '2003-02-01', NULL, '1', NULL, NULL, NULL, '1', '2021-02-02 09:34:32', '1', '2021-02-02 09:34:32');
INSERT INTO `sys_user` VALUES ('1', '1', '系统管理员', 'admin', 'fe0910dd87ae121058852c2efe7756db', '2', '32o5g80pks', '1', '26172583@qq.com', '17366392809', '1990-11-25', '/static/formal/2020/12/19/e4027bb6-063b-4e56-9038-589f50dd9a08.jpg', '1', NULL, '2021-04-15 13:41:47', NULL, '1', '2020-12-11 10:54:00', '1', '2021-01-14 13:49:42');
INSERT INTO `sys_user` VALUES ('5630e03759279b4975d2a02dca9ffe8a', '1', '王怡慧', 'wangyihui', '846971c1737871a0011b2f657f8b07ac', '2', 'khob1dft0z', '2', NULL, NULL, '2000-02-01', NULL, '1', NULL, NULL, NULL, '1', '2021-02-02 09:32:17', '1', '2021-02-03 00:01:58');
INSERT INTO `sys_user` VALUES ('cf26892b40eff71b7bef0f750e2a958d', '1', '楚逸', 'hr', 'd91b6959ba841dfdac1eb204babfbf83', NULL, 'w5ud39hvwr', '1', NULL, NULL, '1990-02-01', NULL, '1', NULL, '2021-02-02 23:55:20', NULL, '1', '2021-01-19 14:47:10', '1', '2021-02-02 09:37:08');
INSERT INTO `sys_user` VALUES ('eaa694bb8af207ef668c2a7312b12128', '1', '折庆生', 'zheqingsheng', 'ffb91071ccfbc38d24be0cbad57f7b03', NULL, 'ljaxptzf2y', '1', NULL, NULL, '2002-02-02', NULL, '1', NULL, '2021-02-02 10:32:12', NULL, '1', '2021-02-02 09:35:06', '1', '2021-02-02 09:35:06');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES ('2323e6c33e8901dcd21c1ae5f24ec706', '068cf9e66de5d067627d08519681895a', '3');
INSERT INTO `sys_user_role` VALUES ('2561246a85ad1215b30135e2f49cdb5a', '0d77057dcae2af878ee7bb336bb2f254', '920f6f953610571e740fc517e3c99899');
INSERT INTO `sys_user_role` VALUES ('7809aef64ca8aeb1351b8174a708ea0b', '1', '3');
INSERT INTO `sys_user_role` VALUES ('84060fa391a981d10ba171eac5a0f7f3', 'eaa694bb8af207ef668c2a7312b12128', '4');
INSERT INTO `sys_user_role` VALUES ('ae53c17178daf3ab6332df8087878053', '5630e03759279b4975d2a02dca9ffe8a', '4');
INSERT INTO `sys_user_role` VALUES ('c323d1895561fe54bdacec1a29935c75', 'cf26892b40eff71b7bef0f750e2a958d', '65bdd699e5b623c8efec4eb74639bafc');
INSERT INTO `sys_user_role` VALUES ('e8a02e7bfaa3780e18b58b9334a83e7f', '5630e03759279b4975d2a02dca9ffe8a', '920f6f953610571e740fc517e3c99899');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_setting`;
CREATE TABLE `sys_user_setting` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户id',
  `tip_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '提示类型',
  `themes` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '主题',
  `fixed_footer` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '固定footer',
  `allow_aside_minimizing` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '默认收起菜单',
  `fixed_header` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '固定头部',
  `page_loader` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '页面loader',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户偏好设置';

SET FOREIGN_KEY_CHECKS = 1;
