package com.example.myhouse.Loan;

import com.example.myhouse.user.UserVO;

public class sinhanForYouthLoan implements loanProducts {

    // 19-34세 무주택자
    // 임차보증금 5% 지급, 연소득 7천 이하, 보증금 5억 이하

    float interestRate = -1.0f;
    boolean _isEnable = true;
    public Boolean isRecommand = false;

    @Override
    public String getProductName() {
        return "신한 청년 전세 대출";
    }

    @Override
    public boolean isEnable() {
        return _isEnable;
    }

    @Override
    public void setUserData(UserVO user) {
        if(user.salary > 7000 ||        //연소득 7천 이상, 주택소유자, 19미만 34초과 대출 불가
            user.hasHouse ||
                !(user.age >= 19 && user.age <= 34) ){
            _isEnable = false;
            return;
        }
        else{
            interestRate = 2.53f;
            return;
        }
    }

    @Override
    public boolean setHouseData() {
        return false;
    }

    @Override
    public float getInterestRate() {
        return interestRate;
    }

    @Override
    public int getLimit() {
        return 7000;
    }

    @Override
    public float getLimitPercent() {
        return 0.9f;
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
