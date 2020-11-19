package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import sample.entity.MyJavaBean;
import sample.entity.MyJavafxBean;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;

public class Controller implements Initializable {

    public Label intLabel, integerLabel, stringLabel;

    public TextField intTextField, integerTextField, stringTextField;

    private MyJavafxBean myJavafxBean;
    private MyJavaBean myJavaBean;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //定义java对象
            myJavaBean = new MyJavaBean();

            //将java对象设置到javafx包装类中，以支持属性绑定
            myJavafxBean = new MyJavafxBean(myJavaBean);

            //控件只做显示, 单向绑定即可
            intLabel.textProperty().bind(myJavafxBean.myIntProperty().asString());
            integerLabel.textProperty().bind(myJavafxBean.myIntegerProperty().asString());
            stringLabel.textProperty().bind(myJavafxBean.myStringProperty());

            //控件可编辑，双向绑定
            intTextField.textProperty().bindBidirectional(myJavafxBean.myIntProperty(), new StringConverter<>() {
                @Override
                public String toString(Number object) {
                    return String.valueOf(object);
                }

                @Override
                public Number fromString(String string) {
                    return Integer.valueOf(string);
                }
            });

            integerTextField.textProperty().bindBidirectional(myJavafxBean.myIntegerProperty(), new StringConverter<>() {
                @Override
                public String toString(Integer object) {
                    return String.valueOf(object);
                }

                @Override
                public Integer fromString(String string) {
                    if("".equals(string)) {
                        return null;
                    }
                    return Integer.valueOf(string);
                }
            });

            stringTextField.textProperty().bindBidirectional(myJavafxBean.myStringProperty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doSetJavaBean(ActionEvent actionEvent) {
        System.out.println("------设置javaBean值前------");
        print();
        myJavaBean.setMyInt(new Random().nextInt(100));
        myJavaBean.setMyInteger(new Random().nextInt(100));
        myJavaBean.setMyString(String.valueOf(System.currentTimeMillis()));
        System.out.println("------设置javaBean值后------");
        print();
    }

    public void doSetJavafxBean(ActionEvent actionEvent) {
        System.out.println("------设置javafxBean中的javaBean值前------");
        print();
        myJavafxBean.getMyJavaBean().setMyInt(new Random().nextInt(100));
        myJavafxBean.getMyJavaBean().setMyInteger(new Random().nextInt(100));
        myJavafxBean.getMyJavaBean().setMyString(String.valueOf(System.currentTimeMillis()));
        System.out.println("------设置javafxBean中的javaBean值后------");
        print();
    }

    public void doSetJavafxBeanProperty(ActionEvent actionEvent) {
        System.out.println("------设置javafxBean中xxxProperty值前------");
        print();
        myJavafxBean.myIntProperty().set(new Random().nextInt(100));
        myJavafxBean.myIntegerProperty().set(new Random().nextInt(100));
        myJavafxBean.myStringProperty().set(String.valueOf(System.currentTimeMillis()));
        System.out.println("------设置javafxBean中xxxProperty值后------");
        print();
    }

    private void print() {
        System.out.println("myJavaBean: " + myJavaBean.toString());
        System.out.println("myJavafxBean>>myJavaBean: " + myJavafxBean.getMyJavaBean().toString());
        System.out.println("myJavafxBean>>intProperty: " + myJavafxBean.myIntProperty().getValue());
        System.out.println("myJavafxBean>>integerProperty: " + myJavafxBean.myIntegerProperty().getValue());
        System.out.println("myJavafxBean>>stringProperty: " + myJavafxBean.myStringProperty().getValue());
    }
}
