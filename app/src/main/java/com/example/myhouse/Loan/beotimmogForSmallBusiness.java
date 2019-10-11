package com.example.myhouse.Loan;
import com.example.myhouse.user.UserConstant;
import com.example.myhouse.user.UserVO;

public class beotimmogForSmallBusiness implements loanProducts {

    // 현역 나이 제한 나이 39세 처리 해야함. (만 34 ~ 39세일 경우)
    boolean _isEnalbe = true;

    @Override
    public String getProductName() {
        return "버팀목 - 중소기업청년";
    }

    @Override
    public boolean isEnable() {
        return _isEnalbe;
    }

    @Override
    public void setUserData(UserVO user) {

            if( user.hasHouse ||                            // 세대원 모두 무주택
                (user.marryState != UserConstant.notMarried && user.salary <= 5000) ||      // 부부합산 5000만원이하
                (user.marryState == UserConstant.notMarried && user.salary <= 3500) ||     // 단독세대주 3500만원이하
                user.property <= 28000 ||                        // 순 자산 2.8억 이하
                user.age <= 34 )                                 //만 34세 ===> 현역 39세
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
        return 1.2f;
    }

    @Override
    public int getLimit() {
        return 10000;
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
