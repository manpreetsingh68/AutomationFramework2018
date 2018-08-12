package com.automation.DataProviders;

import com.automation.Utils.ExcelReader;
import com.automation.core.Constants;
import org.testng.annotations.DataProvider;

public class AltoroMutualDataProvider {

    public static final String DP_UNAME_PASS_ACC_EXPBAL= "dpUnamePassAccExpBal";
    public static final String DP_MAP_UNAME_PASS_ACC_EXPBAL_FROMEXCEL= "dpMapUnamePassAccExpBal";

    @DataProvider(name = DP_UNAME_PASS_ACC_EXPBAL)
    public static Object[][] getAccountData(){
        Object[][] data= new Object[][]{
                {"jsmith","demo1234","1001160140 Checking","-800"},
                {"jsmith","demo1234","1001160141 Savings","3000"}
        };
        return data;
    }

    @DataProvider(name = DP_MAP_UNAME_PASS_ACC_EXPBAL_FROMEXCEL, parallel = true)
    public static Object[][] getAccountDataFromExcel(){
        Object[][] data= ExcelReader.getExcelData(Constants.ALTORO_MUTUAL_USERS_DATA,"Sheet1");
        return data;
    }
}
