package com.example.myhouse.Loan;

import com.example.myhouse.user.UserVO;

public class wooriSmartLoan implements loanProducts {

    //부동산 중개업소를 통해 주택 임대차계약을 채결한 임차보증금의 5%이상을 지급한 세대주 혹은 세대원

    float interestRate = -1.0f;
    boolean _isEnable = true;
    public Boolean isRecommand = false;

    @Override
    public String getProductName() {
        return "우리 스마트 전세론(서울보증)";
    }

    @Override
    public boolean isEnable() {
        return _isEnable;
    }

    @Override
    public void setUserData(UserVO user) {
        interestRate = 3.75f;
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
        return 50000;
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
