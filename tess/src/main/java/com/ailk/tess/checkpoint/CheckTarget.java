package com.ailk.tess.checkpoint;

/**
 * 检查点检查目标
 * User: Administrator
 * Date: 13-2-23
 * Time: 下午5:00
 */
public enum CheckTarget {
    TARGET_TASK_RETURN("1"), TARGET_DB("2");

    private String value;
    private CheckTarget(String value) {
        this.value = value;
    }
}
