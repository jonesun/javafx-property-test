package sample.entity;

import java.io.Serializable;

/**
 * 测试java类
 *
 * @author jone.sun
 * @date 2020-11-19 10:02
 */
public class MyJavaBean implements Serializable {

    private int myInt;

    private Integer myInteger;

    private String myString;

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public Integer getMyInteger() {
        return myInteger;
    }

    public void setMyInteger(Integer myInteger) {
        this.myInteger = myInteger;
    }


    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    @Override
    public String toString() {
        return "MyJavaBean{" +
                "myInt=" + myInt +
                ", myInteger=" + myInteger +
                ", myString='" + myString + '\'' +
                '}';
    }
}
