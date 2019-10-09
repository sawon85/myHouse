package com.example.myhouse.Loan;

import com.example.myhouse.user.UserVO;

public interface loanProducts {

    String getProductName();

    boolean isEnable();

    void setUserData(UserVO user);

    boolean setHouseData();

    float getInterestRate();

    int getLimit();

    float getLimitPercent();
}
