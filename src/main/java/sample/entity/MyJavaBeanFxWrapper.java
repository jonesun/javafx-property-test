package sample.entity;

import javafx.beans.property.*;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 包装java对象的javafx测试类
 *
 * @author jone.sun
 * @date 2020-11-19 10:19
 */
public class MyJavaBeanFxWrapper {

    private MyJavaBean myJavaBean;

    private IntegerProperty myInt;

    private ObjectProperty<Integer> myInteger;

    private StringProperty myString;

    private ListProperty<String> myStringList;

    private ObjectProperty<MyChildJavaBean> myChildJavaBean;

    public MyJavaBeanFxWrapper(MyJavaBean myJavaBean) throws NoSuchMethodException {
        this.myJavaBean = myJavaBean;
        intProperty();
    }

    private MyJavaBeanFxWrapper() {
    }

    @SuppressWarnings({"unchecked"})
    private void intProperty() throws NoSuchMethodException {

        myInt = JavaBeanIntegerPropertyBuilder.create().bean(this.myJavaBean).name("myInt").build();

        //IntegerProperty如果遇到bean中属性值为null时，初始化会报错(内部使用int，转换出错)，故需使用ObjectProperty<Integer>
        myInteger = JavaBeanObjectPropertyBuilder.create().bean(this.myJavaBean).name("myInteger").build();

        myString = JavaBeanStringPropertyBuilder.create().bean(this.myJavaBean).name("myString").build();

        myStringList = new SimpleListProperty<>(FXCollections.observableArrayList());
        if (myJavaBean.getMyStringList() != null) {
            myStringList.addAll(myJavaBean.getMyStringList());
        }

        myStringList.addListener((observable, oldValue, newValue) -> myJavaBean.setMyStringList(newValue));

        myChildJavaBean = JavaBeanObjectPropertyBuilder.create().bean(this.myJavaBean).name("myChildJavaBean").build();
    }

    public MyJavaBean getMyJavaBean() {
        return myJavaBean;
    }

    public void setMyJavaBean(MyJavaBean myJavaBean) throws NoSuchMethodException {
        this.myJavaBean = myJavaBean;
        intProperty();
    }

    public int getMyInt() {
        return myInt.get();
    }

    public IntegerProperty myIntProperty() {
        return myInt;
    }

    public Integer getMyInteger() {
        return myInteger.get();
    }

    public ObjectProperty<Integer> myIntegerProperty() {
        return myInteger;
    }


    public String getMyString() {
        return myString.get();
    }

    public StringProperty myStringProperty() {
        return myString;
    }

    public ObservableList<String> getMyStringList() {
        return myStringList.get();
    }

    public ListProperty<String> myStringListProperty() {
        return myStringList;
    }

    public MyChildJavaBean getMyChildJavaBean() {
        return myChildJavaBean.get();
    }

    public ObjectProperty<MyChildJavaBean> myChildJavaBeanProperty() {
        return myChildJavaBean;
    }
}
