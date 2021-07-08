package com.test;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-05-10 13:42
 */
public class RealData implements Data{
    protected final String result;

    public RealData(String str){
        StringBuffer sb=new StringBuffer();
        result=sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
