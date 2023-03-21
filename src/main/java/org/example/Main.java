package org.example;

import org.example.config.Config;
import org.example.controller.MenuController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        MenuController menuController = (MenuController) applicationContext.getBean("menuController");
menuController.mainMenu();
        System.out.println("Hello world!");
    }
}