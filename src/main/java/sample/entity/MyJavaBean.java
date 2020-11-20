package sample.entity;

import java.io.Serializable;
import java.util.List;

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

    private List<String> myStringList;

    private MyChildJavaBean myChildJavaBean;

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

    public List<String> getMyStringList() {
        return myStringList;
    }

    public void setMyStringList(List<String> myStringList) {
        this.myStringList = myStringList;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public MyChildJavaBean getMyChildJavaBean() {
        return myChildJavaBean;
    }

    public void setMyChildJavaBean(MyChildJavaBean myChildJavaBean) {
        this.myChildJavaBean = myChildJavaBean;
    }

    @Override
    public String toString() {
        return "MyJavaBean{" +
                "myInt=" + myInt +
                ", myInteger=" + myInteger +
                ", myString='" + myString + '\'' +
                ", myStringList=" + myStringList +
                ", myChildJavaBean=" + myChildJavaBean +
                '}';
    }
}
