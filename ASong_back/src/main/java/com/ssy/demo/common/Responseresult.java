package com.ssy.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Responseresult implements Serializable {
    private String code;
    private String msg;
    private Object data;
    private Object pra;


    public static Responseresult succ(Object data) {
        return succ("200","操作成功",data);

    }

    public static Responseresult succ(String code,String msg,Object data) {
        Responseresult responseresult = new Responseresult();
        responseresult.setCode(code);
        responseresult.setMsg(msg);
        responseresult.setData(data);
        return responseresult;
    }

    public static Responseresult fail(String msg) {
        return fail("400",msg,null);
    }

    public static Responseresult fail(String code,String msg,Object data) {
        Responseresult responseresult = new Responseresult();
        responseresult.setCode(code);
        responseresult.setMsg(msg);
        responseresult.setData(data);
        return responseresult;
    }

}
