package com.example.myhouse.Loan;

import com.example.myhouse.user.UserVO;

public class NHForYouthLoan implements loanProducts {

    //34세 이하 무주택 청년
    //연소득 7000이하, 주택금융신용보증서 임차자금 보증이 가능한 자
    // 월세대출은 한도 월 50, 보증금 및 월세 동시 대출시 월세한도는 25

    float interestRate = -1.0f;
    boolean _isEnable = true;


    @Override
    public String getProductName() {
        return "NH 청년 전,월세 대출";
    }

    @Override
    public boolean isEnable() {
        return _isEnable;
    }

    @Override
    public void setUserData(UserVO user) {
        if(user.age > 34 ||
            user.hasHouse ||
            user.salary > 7000){
            _isEnable = false;
            return;
        }
        else{
            interestRate = 2.42f; // 금융채(24개월)고정
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
        return 1.0f;
    }

    @Override
    public String getSpecialNote() {
        return "주택금융신용보증서 임차자금 보증이 가능시 이용 가능";
    }
}
