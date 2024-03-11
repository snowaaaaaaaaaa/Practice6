package com.mycompany.ex02;

import com.mycompany.ex02.DUCHKA;
import com.mycompany.ex02.ViewableResult;
import javax.swing.text.View;

public class ex02 {

    public static void main(String[] args) {
        DUCHKA duchka = new DUCHKA(new ViewableResult().getView());
        duchka.menu();
    }
}
