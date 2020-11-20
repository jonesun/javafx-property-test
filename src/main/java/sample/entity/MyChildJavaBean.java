package sample.entity;

import java.io.Serializable;

/**
 * 测试对象属性
 *
 * @author jone.sun
 * @date 2020-11-20 11:15
 */
public class MyChildJavaBean implements Serializable {

    private String str1;

    private String str2;

    public MyChildJavaBean(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public MyChildJavaBean() {}

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    @Override
    public String toString() {
        return "MyChildJavaBean{" +
                "str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                '}';
    }
}
