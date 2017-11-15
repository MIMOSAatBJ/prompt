package com.cicc.common.base;

public interface Dict {

    /**
     * 环境定义
     */
    enum Environment {
        dev,
        test,
        prod;
    }

    enum Header {
        token("x-access-token", "登录token");
        private String key;
        private String desc;

        Header(String key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        public String getKey() {
            return key;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 模块编码及描述信息
     * 三位整数
     */
    enum Module {
        unknown(900, ""),web(800,"web"), common(100, "common");
        private Integer sn;
        private String desc;

        Module(Integer sn, String desc) {
            this.sn = sn;
            this.desc = desc;
        }

        public Integer getSn() {
            return sn;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 具体错误服信息
     *
     * @desc code为三位整数，最大code是999
     */
    enum Factor {
        unknown(000, ""), incorrect(100, "密码错误"), unlogin(101, "当前用户未登录");
        private Integer code;
        private String info;

        Factor(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }
}
