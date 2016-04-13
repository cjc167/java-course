-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES ('GET', '查看');
INSERT INTO `operation` VALUES ('POST', '创建');
INSERT INTO `operation` VALUES ('PUT', '修改');

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '/**', '根路径', null);
INSERT INTO `resource` VALUES ('2', '/test/**', '测试路径', null);

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('ROLE_ADMIN', '管理员', '系统管理员，可以做任何操作');

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('ROLE_ADMIN', '1', 'GET', '/**');

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('hippo', 'ROLE_ADMIN');

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('hippo', '12345678', '5a0fc352-3100-4a42-b1d3-2c62e68b9c6f', '1');
