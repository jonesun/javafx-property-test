package sample.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;

/**
 * @author jone.sun
 * @date 2020-11-20 13:22
 */
public class MyChildJavaBeanFxWrapper {

    private MyChildJavaBean myChildJavaBean;

    private StringProperty str1;

    private StringProperty str2;

    private MyChildJavaBeanFxWrapper() {}

    public MyChildJavaBeanFxWrapper(MyChildJavaBean myChildJavaBean) throws NoSuchMethodException {
        this.myChildJavaBean = myChildJavaBean;
        initProperty();
    }

    private void initProperty() throws NoSuchMethodException {
        str1 = JavaBeanStringPropertyBuilder.create().bean(this.myChildJavaBean).name("str1").build();
        str2 = JavaBeanStringPropertyBuilder.create().bean(this.myChildJavaBean).name("str2").build();
    }

    public MyChildJavaBean getMyChildJavaBean() {
        return myChildJavaBean;
    }

    public void setMyChildJavaBean(MyChildJavaBean myChildJavaBean) throws NoSuchMethodException {
        this.myChildJavaBean = myChildJavaBean;
        initProperty();
    }

    public String getStr1() {
        return str1.get();
    }

    public StringProperty str1Property() {
        return str1;
    }

    public String getStr2() {
        return str2.get();
    }

    public StringProperty str2Property() {
        return str2;
    }
}
