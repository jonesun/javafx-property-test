/**
 * @author jone.sun
 * @date 2020-11-19 15:14
 */
module javafx.property.test {

    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.core;
    requires spring.beans;

    exports sample;
    exports sample.entity;
    opens sample;
    opens sample.service;
}