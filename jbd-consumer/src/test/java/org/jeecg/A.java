package org.jeecg;

import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class A {
    public static void main(String[] args) {
            converToHttpUrl("thunder://QUFlZDJrOi8vfGZpbGV8W+eci+eci+Wxi3d3dy5rYW5rYW53dS5jb21d55Sf5rS75aSn54iG54K456ys5Y2B5LiA5a2jMDEubXA0fDI1MzI0NjAyMHw1NzJhNzY4ZTNmZjI5NWU3M2I4YzkzMDViNjMyZDJhMHxoPXRzcXp3N3ZhM21zbTR6NjZxdnprZmcyNXZ4bGgzYnlkfC9aWg==");
    }
    private static void converToHttpUrl(String sourceUrl) {

        Map<String,Object> para=new HashMap<>();
        para.put("link",sourceUrl);
        String post = HttpUtil.post("https://tool.lu/urlconvert/ajax.html", para);
        System.out.println(
                ( ((HashMap)
                        (JSONObject.parseObject(UnicodeUtil.toString(post)).get("text"))))
                                            .get("http"));

    }
    
}
