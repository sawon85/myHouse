package com.example.myhouse.Loan;

import com.example.myhouse.user.UserConstant;
import com.example.myhouse.user.UserVO;

public class beotimmogForNewlyweds implements loanProducts {

    float interestRate = 2.5f;
    boolean _isEnable = true;
    public Boolean isRecommand = false;
    @Override
    public String getProductName() { return "버팀목 - 신혼부부"; }

    @Override
    public boolean isEnable() {
        return _isEnable;
    }

    @Override
    public void setUserData(UserVO user) {
        if( user.marryState != UserConstant.newlyMarried){
            _isEnable = false;
            return;
        }

        if( user.deposit <= 5000 ){
            if( user.salary <= 2000 )
                interestRate = 1.2f;
            else if( user.salary <= 4000 )
                interestRate = 1.5f;
            else if( user.salary <= 6000 )
                interestRate = 1.8f;
        }
        else if( user.deposit <= 10000 ){
            if( user.salary <= 2000 )
                interestRate = 1.3f;
            else if( user.salary <= 4000 )
                interestRate = 1.6f;
            else if( user.salary <= 6000 )
                interestRate = 1.9f;
        }
        else if( user.deposit <= 15000){
            if( user.salary <= 2000 )
                interestRate = 1.4f;
            else if( user.salary <= 4000 )
                interestRate = 1.7f;
            else if( user.salary <= 6000 )
                interestRate = 2.0f;
        }
        else {
            if( user.salary <= 2000 )
                interestRate = 1.5f;
            else if( user.salary <= 4000 )
                interestRate = 1.8f;
            else if( user.salary <= 6000 )
                interestRate = 2.1f;
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
        return 17000; //수도권
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
