package com.example.myhouse.Loan;

import com.example.myhouse.user.UserVO;

public class beotimmogForMothlyRentLoan implements loanProducts {

    // 우대형, 일반형 금리 다름
    // 무소득자일 경우 --> 부모 소득 필요함.
    // 근로장려금 수급자, 자녀 장려금 수급자 --> 필요

    boolean _isEnable = true;
    float interestRate = 2.5f;  // 금

    @Override
    public String getProductName() {
        return "버팀목 - 주거 안정 월세 대출";
    }

    @Override
    public boolean isEnable() { return _isEnable; }

    @Override
    public void setUserData(UserVO user) {

        //우대형
        if ( (user.age <= 35 && user.salary == 0) &&   //부모 소득 처리 부분.
             (user.isNewRecruits && user.age <= 35 && user.salary <= 4000)  // 근로장려금 수급자, 자녀장려금 수급자 내
        )
        {
            interestRate = 1.5f;
            return;
        }

        //일반형
        if(user.salary <= 5000 ) {
            interestRate = 2.5f;
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
        return 480;
    }

    @Override
    public float getLimitPercent() {
        return 1.0f;
    }

    @Override
    public String getSpecialNote() {
        return null;
    }
}
