package com.example.myhouse.Card;

import android.util.Log;

public class CardAnalysis {

    public static final int Nothing = 0;
    public static final int Food = 1;
    public static final int Cafe = 2;
    public static final int Study = 3;
    public static final int Traffic = 4;
    public static final int Beauty = 5;
    public static final int Health = 6;
    public static final int Care = 7;
    public static final int Mart = 8;
    public static final int Online = 9;
    public static final int MAXIMUM = 10;


    public int getShopType(String shopName)
    {
        if(isStudyString(shopName)) return Study;
        if(isTrafficString(shopName)) return Traffic;
        if(isMartString(shopName)) return Mart;
        if(isCafeString(shopName)) return Cafe;
        if(isCareString(shopName)) return Care;
        if(isBeautyString(shopName)) return Beauty;
        if(isOnlineString(shopName)) return Online;
        if(isFoodString(shopName)) return Food;
        if(isHealthString(shopName)) return Health;

        Log.d("shop:",shopName);
        return Nothing;
    }

    private boolean isMartString (String shopName)
    {
        if( shopName.contains("씨유") ||
                shopName.contains("코리아세븐") ||
                shopName.contains("GS") ||
                shopName.contains("마트") ||
                shopName.contains("노브랜드") ||
                shopName.contains("다이소")

        )
            return true;

        return  false;
    }

    private boolean isOnlineString (String shopName)
    {
        if( shopName.contains("쿠팡") ||
                shopName.contains("인터파크") ||
                shopName.contains("온라인") ||
                shopName.contains("마켓")


        )
            return true;
        return  false;
    }

    private boolean isCareString (String shopName)   //제일 마지막
    {
        if( shopName.contains("의원") ||
                shopName.contains("병원") ||
                shopName.contains("약국")
        )
            return true;

        return  false;
    }

    private boolean isHealthString (String shopName)   //제일 마지막
    {
        if( shopName.contains("헬스") ||
                shopName.contains("휘트니스") ||
                shopName.contains("짐")  ||
                shopName.contains("FITNESS")
        )
            return true;

        return  false;
    }

    private boolean isBeautyString (String shopName)
    {
        if( shopName.contains("미용") ||
                shopName.contains("헤어")
        )
            return true;

        return  false;
    }

    private boolean isTrafficString (String shopName)
    {
        if( shopName.contains("종합터미널") ||
                shopName.contains("버스") ||
                shopName.contains("택시") ||
                shopName.contains("교통")
        )
            return true;

        return  false;
    }


    private boolean isStudyString (String shopName)
    {
        if( shopName.contains("스터디") ||
                shopName.contains("독서") ||
                shopName.contains("도서") ||
                shopName.contains("학원")
        )
            return true;

        return  false;
    }

    private boolean isCafeString (String shopName)
    {
        if( shopName.contains("카페") ||
                shopName.contains("커피") ||
                shopName.contains("탐앤탐스") ||
                shopName.contains("투썸") ||
                shopName.contains("스타벅스") ||
                shopName.contains("엔제리너스") ||
                shopName.contains("컵안에버블") ||
                shopName.contains("빽다방")   ||
                shopName.contains("이디야")

        )
            return true;

        return  false;
    }

    private boolean isFoodString(String shopName)
    {
        if( shopName.contains("식당") ||
                shopName.contains("푸드") ||
                shopName.contains("우아한형제들") ||
                shopName.contains("요기요") ||
                shopName.contains("반점") ||
                shopName.contains("국밥") ||
                shopName.contains("맥도") ||
                shopName.contains("롯데리아") ||
                shopName.contains("버거킹") ||
                shopName.contains("비비큐")  ||
                shopName.contains("터치")  ||
                shopName.contains("족발")  ||
                shopName.contains("보쌈")  ||
                shopName.contains("분식")  ||
                shopName.contains("떡볶")  ||
                shopName.contains("피자")  ||
                shopName.contains("짜장")

        )
            return true;

        return  false;
    }





}
