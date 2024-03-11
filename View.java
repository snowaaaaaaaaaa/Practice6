package com.mycompany.ex02;
import java.util.List;

public interface View {
    int DEFAULT_NUM = 10;

    void viewShow();

    void viewInit();

    List<?> getItems();
}