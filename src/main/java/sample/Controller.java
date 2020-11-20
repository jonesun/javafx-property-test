package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import sample.entity.MyChildJavaBean;
import sample.entity.MyJavaBean;
import sample.entity.MyJavaBeanFxWrapper;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Label intLabel, integerLabel, stringLabel;

    public TextField intTextField, integerTextField, stringTextField;
    public ListView<String> listView;
    public TextField listValueTextField;
    public Label str1Label, str2Label;
    public TextField str1TextField, str2TextField;

    private MyJavaBeanFxWrapper myJavaBeanFxWrapper;
    private MyJavaBean myJavaBean;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //定义java对象
            myJavaBean = new MyJavaBean();
//            myJavaBean.setMyChildJavaBean(new MyChildJavaBean());
            //将java对象设置到javafx包装类中，以支持属性绑定
            myJavaBeanFxWrapper = new MyJavaBeanFxWrapper(myJavaBean);

            //控件只做显示, 单向绑定即可
            intLabel.textProperty().bind(myJavaBeanFxWrapper.myIntProperty().asString());
            integerLabel.textProperty().bind(myJavaBeanFxWrapper.myIntegerProperty().asString());
            stringLabel.textProperty().bind(myJavaBeanFxWrapper.myStringProperty());

            //控件可编辑，双向绑定
            intTextField.textProperty().bindBidirectional(myJavaBeanFxWrapper.myIntProperty(), new StringConverter<>() {
                @Override
                public String toString(Number object) {
                    return String.valueOf(object);
                }

                @Override
                public Number fromString(String string) {
                    return Integer.valueOf(string);
                }
            });

            integerTextField.textProperty().bindBidirectional(myJavaBeanFxWrapper.myIntegerProperty(), new StringConverter<>() {
                @Override
                public String toString(Integer object) {
                    return String.valueOf(object);
                }

                @Override
                public Integer fromString(String string) {
                    if ("".equals(string)) {
                        return null;
                    }
                    return Integer.valueOf(string);
                }
            });

            stringTextField.textProperty().bindBidirectional(myJavaBeanFxWrapper.myStringProperty());

            listView.itemsProperty().bindBidirectional(myJavaBeanFxWrapper.myStringListProperty());

//            myJavaBeanFxWrapper.myChildJavaBeanProperty().addListener(new ChangeListener<MyChildJavaBean>() {
//                @Override
//                public void changed(ObservableValue<? extends MyChildJavaBean> observable, MyChildJavaBean oldValue, MyChildJavaBean newValue) {
//                    System.err.println("djkdjdkdkfjkd: " + newValue);
//                }
//            });

            str1Label.textProperty().bindBidirectional(myJavaBeanFxWrapper.getMyChildJavaBeanFxWrapper().str1Property(), new StringConverter<String>() {
                @Override
                public String toString(String object) {
                    if(object == null) {
                        return "";
                    }
                    return object;
                }

                @Override
                public String fromString(String string) {
                    return string;
                }
            });

            str1TextField.textProperty().bindBidirectional(myJavaBeanFxWrapper.getMyChildJavaBeanFxWrapper().str1Property());

//            str2Label.textProperty().bind(myJavaBeanFxWrapper.getMyChildJavaBeanFxWrapper().str2Property());

            str2TextField.textProperty().bindBidirectional(myJavaBeanFxWrapper.getMyChildJavaBeanFxWrapper().str2Property());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doSetJavaBean(ActionEvent actionEvent) {
        System.out.println("sss: " + myJavaBean.getMyChildJavaBean());
        System.out.println("sss: " + myJavaBeanFxWrapper.getMyChildJavaBeanFxWrapper().getStr1());
        System.out.println("sss: " + myJavaBeanFxWrapper.getMyChildJavaBeanFxWrapper().getStr2());
        System.out.println("------设置javaBean值前------");
        print();
        myJavaBean.setMyInt(new Random().nextInt(100));
        myJavaBean.setMyInteger(new Random().nextInt(100));
        myJavaBean.setMyString(String.valueOf(System.currentTimeMillis()));
        System.out.println("------设置javaBean值后------");
        print();
    }

    public void doSetJavaBeanFxWrapper(ActionEvent actionEvent) {
        System.out.println("------设置javaBeanFxWrapper中的javaBean值前------");
        print();
        myJavaBeanFxWrapper.getMyJavaBean().setMyInt(new Random().nextInt(100));
        myJavaBeanFxWrapper.getMyJavaBean().setMyInteger(new Random().nextInt(100));
        myJavaBeanFxWrapper.getMyJavaBean().setMyString(String.valueOf(System.currentTimeMillis()));
        System.out.println("------设置javaBeanFxWrapper中的javaBean值后------");
        print();
    }

    public void doSetJavaBeanFxWrapperProperty(ActionEvent actionEvent) {
        System.out.println("------设置javaBeanFxWrapper中xxxProperty值前------");
        print();
        myJavaBeanFxWrapper.myIntProperty().set(new Random().nextInt(100));
        myJavaBeanFxWrapper.myIntegerProperty().set(new Random().nextInt(100));
        myJavaBeanFxWrapper.myStringProperty().set(String.valueOf(System.currentTimeMillis()));
        System.out.println("------设置javaBeanFxWrapper中xxxProperty值后------");
        print();
    }

    public void doAddListValue(ActionEvent actionEvent) {
        listView.getItems().add(listValueTextField.getText());
        System.out.println("list: " + myJavaBean.getMyStringList());
        System.out.println("list: " + myJavaBeanFxWrapper.myStringListProperty().toString());
    }

    public void doRemoveListValue(ActionEvent actionEvent) {
        if (!listView.getItems().isEmpty()) {
            listView.getItems().remove(0);
        }
        System.out.println("list: " + myJavaBean.getMyStringList());
        System.out.println("list: " + myJavaBeanFxWrapper.myStringListProperty().toString());

    }

    private void print() {
        System.out.println("myJavaBean: " + myJavaBean.toString());
        System.out.println("javaBeanFxWrapper>>myJavaBean: " + myJavaBeanFxWrapper.getMyJavaBean().toString());
        System.out.println("javaBeanFxWrapper>>intProperty: " + myJavaBeanFxWrapper.myIntProperty().getValue());
        System.out.println("javaBeanFxWrapper>>integerProperty: " + myJavaBeanFxWrapper.myIntegerProperty().getValue());
        System.out.println("javaBeanFxWrapper>>stringProperty: " + myJavaBeanFxWrapper.myStringProperty().getValue());
    }

}
