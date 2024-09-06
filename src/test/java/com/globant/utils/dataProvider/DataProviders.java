package com.globant.utils.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "persona")
    public Object[][] dataProvider() {
        Object[][] data = new Object[][] {{"Alejandro","Fajardo","761540"},{"Valentina","Henao","761540"}};
        return new Object[][] {data[1]};
    }

}
