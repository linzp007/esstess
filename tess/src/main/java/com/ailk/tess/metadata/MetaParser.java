package com.ailk.tess.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板解析, 获取其中的metadata
 * User: Administrator
 * Date: 13-2-23
 * Time: 上午2:04
 */
public class MetaParser {
    public List<MetaData> getTemplateMeta(String xml) {
        char[] charArr = xml.toCharArray();
        List<MetaData> metas = new ArrayList<MetaData>();
        String meta = "";
        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] == '$') {
                meta = "$";
            } else if(charArr[i] == '{') {
                if(meta.equals("$")) {
                    meta = "";
                }
            } else if(charArr[i] == '}') {
                metas.add(new MetaData(meta));
                meta = "";
            }else {
                meta += charArr[i];
            }
        }
        return metas;
    }
}
