package com.example.myhouse.Loan;

import com.example.myhouse.user.UserVO;

public class sinhanSolLoan implements loanProducts{

    // 부동산 중개업소를 통해 주택 임대차계약을 채결한 임차보증금의 5%이상을 지급한 고객
    // 현재 직장에서 1년 이상 근무한 직장인 혹은 개인사업자

    float interestRate = -1.0f;
    boolean _isEnable = true;
    public Boolean isRecommand = false;

    @Override
    public String getProductName() {
        return "신한 쏠편한 전세대출(주택금융공사)";
    }

    @Override
    public boolean isEnable() {
        return _isEnable;
    }

    @Override
    public void setUserData(UserVO user) {
        if(user.hasHouse ||
            user.salary > 10000){
            _isEnable = false;
            return;
        }
        else{
            interestRate = 3.325f; // 최고-최저 금리 평균
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
        return 22200;
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
