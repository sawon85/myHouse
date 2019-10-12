package com.example.myhouse.Loan;

import com.example.myhouse.user.UserVO;

public class beotimmogForYouth implements loanProducts {

    //다자녀 우대금리 있음.  --> 처리 해야함

    boolean _isEnalbe = true;
    public Boolean isRecommand = false;

    @Override
    public String getProductName() {
        return "버팀목 - 청년";
    }

    @Override
    public boolean isEnable() {
        return false;
    }

    @Override
    public void setUserData(UserVO user) {

        if( user.age < 19 && user.age >= 25 &&    // 19세 이상 25세 미만
                user.hasHouse &&   // 무주택
                user.salary > 5000 &&   // 연봉 5000 이하
                user.property > 28000 ) //자산 2.8억 이하
           {
                _isEnalbe = false;
                return;
            }
    }

    @Override
    public boolean setHouseData() {
        return false;
    }

    @Override
    public float getInterestRate() {
        return 0;
    }

    @Override
    public int getLimit() {
        return 3500;
    }

    @Override
    public float getLimitPercent() {
        return 0.8f;
    }

    @Override
    public String getSpecialNote() {
        return null;
    }

    @Override
    public boolean isRecommanded() {
        return isRecommand;
    }

    @Override
    public void setRecommand(boolean recommand) {
        isRecommand = recommand;
    }
}
