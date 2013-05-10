package com.ailk.tess.util;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午3:02
 */
public class TessConst {

    public static final int PAGE_SIZE_CASE_TEMPLATE = 5;
    public static final int PAGE_SIZE_TASK = 5;

    /**
     * 用例模板状态
     */
   public enum CaseTemplateStatus {
         /** 1 在用 */
         ENABLE("1"),
        /** 2 失效*/
        DISABLE("0");
        private String statusCd;
        private CaseTemplateStatus(String statusCd) {
            this.statusCd = statusCd;
        }
        public String toString() {
            return this.statusCd;
        }
    }
}
