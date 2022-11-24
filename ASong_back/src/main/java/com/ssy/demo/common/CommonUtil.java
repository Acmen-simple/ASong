package com.ssy.demo.common;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class CommonUtil {

    public static List<Map<String, Object>> listToHump(List<Map<String, Object>> list) {
        List<Map<String, Object>> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            LinkedHashMap<String, Object> newMap = new LinkedHashMap<>();
            Iterator<Map.Entry<String, Object>> iterator = list.get(i).entrySet().iterator();
            Map.Entry<String, Object> entry;
            while (iterator.hasNext()) {
                entry = iterator.next();
                // 往newMap中放入新的Entry
                newMap.put(lineToHump(entry.getKey()), entry.getValue());
                // 删除老的Entry
                iterator.remove();
            }

            list2.add(newMap);
        }

        return list2;
    }

    /**
     * 下划线转驼峰
     *
     * @param str 需要转换的字符串
     * @return 转换完成的字符串
     */
    public static String lineToHump(String str) {
        // 正则
        Pattern linePattern = compile("_(\\w)");
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 返回结果
     * @param  code 返回编码
     * @param  msg 返回消息
     * @param  data 返回数据
     * @return Responseresult
     */
    public static  Responseresult setResult(String code,String msg,Object data){
        Responseresult result = new Responseresult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
