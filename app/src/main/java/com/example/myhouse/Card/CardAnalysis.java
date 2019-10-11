package com.example.myhouse.Card;

import android.util.Log;

public class CardAnalysis {

    public static final int Nothing = 0;
    public static final int Food = 1;
    public static final int Cafe = 2;
    public static final int Study = 3;
    public static final int Traffic = 4;
    public static final int Service = 5;
    public static final int Health = 6;
    public static final int Care = 7;
    public static final int Mart = 8;
    public static final int Online = 9;
    public static final int Culture = 10;
    public static final int Beauty = 11;
    public static final int MAXIMUM = 12;

    public int getShopType(String shopName)
    {
        if(isStudyString(shopName)) return Study;
        if(isTrafficString(shopName)) return Traffic;
        if(isMartString(shopName)) return Mart;
        if(isCafeString(shopName)) return Cafe;
        if(isCareString(shopName)) return Care;
        if(isServiceString(shopName)) return Service;
        if(isOnlineString(shopName)) return Online;
        if(isCultureString(shopName)) return Culture;
        if(isBeautyString(shopName)) return Beauty;
        if(isHealthString(shopName)) return Health;
        if(isFoodString(shopName)) return Food;

        Log.d("shop:",shopName);
        return Nothing;
    }

    private boolean isCultureString (String shopName)
    {
        if( shopName.contains("CGV") ||
                shopName.contains("시지브") ||
                shopName.contains("메가") ||
                shopName.contains("MEGABOX") ||
                shopName.contains("롯데시") ||
                shopName.contains("볼링") ||
                shopName.contains("당구") ||
                shopName.contains("수영") ||
                shopName.contains("PC방") ||
                shopName.contains("노래연") ||
                shopName.contains("에버랜") ||
                shopName.contains("롯데월") ||
                shopName.contains("휘닉스") ||
                shopName.contains("모텔")  ||
                shopName.contains("호텔")  ||
                shopName.contains("CJ")
        )
            return true;

        return  false;
    }

    private boolean isBeautyString (String shopName)
    {
        if( shopName.contains("리브영") ||
                shopName.contains("에뛰") ||
                shopName.contains("따움") ||
                shopName.contains("스프리") ||
                shopName.contains("토니모") ||
                shopName.contains("러쉬") ||
                shopName.contains("LUSH")
        )
            return true;

        return  false;
    }

    private boolean isMartString (String shopName)
    {
        if( shopName.contains("CU") ||
                shopName.contains("코리아세") ||
                shopName.contains("GS") ||
                shopName.contains("마트") ||
                shopName.contains("노브랜") ||
                shopName.contains("다이소") ||
                shopName.contains("씨유") ||
                shopName.contains("지에스") ||
                shopName.contains("미니스") ||
                shopName.contains("자판기") ||
                shopName.contains("농산") ||
                shopName.contains("아울렛")
        )
            return true;

        return  false;
    }

    private boolean isOnlineString (String shopName)
    {
        if( shopName.contains("쿠팡") ||
                shopName.contains("인터파크") ||
                shopName.contains("온라인") ||
                shopName.contains("마켓")  ||
                shopName.contains("카카오") ||
                shopName.contains("네이버")

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

    private boolean isServiceString(String shopName)
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
                shopName.contains("교통")||
                shopName.contains("티머") ||
                shopName.contains("주유") ||
                shopName.contains("하철")
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
                shopName.contains("탐앤") ||
                shopName.contains("투썸") ||
                shopName.contains("스타벅") ||
                shopName.contains("엔제리") ||
                shopName.contains("컵안에") ||
                shopName.contains("다방")   ||
                shopName.contains("이디야")   ||
                shopName.contains("요거")  ||
                shopName.contains("프레소")  ||
                shopName.contains("할리")   ||
                shopName.contains("공차")  ||
                shopName.contains("파리바") ||
                shopName.contains("뚜레")   ||
                shopName.contains("파스") ||
                shopName.contains("베스킨") ||
                shopName.contains("설빙")  ||
                shopName.contains("던킨")

        )
            return true;

        return  false;
    }

    private boolean isFoodString(String shopName)
    {
        if( shopName.contains("식당") ||
                shopName.contains("푸드") ||
                shopName.contains("우아한") ||
                shopName.contains("요기요") ||
                shopName.contains("반점") ||
                shopName.contains("국밥") ||
                shopName.contains("맥도") ||
                shopName.contains("롯데리아") ||
                shopName.contains("버거킹") ||
                shopName.contains("비비큐") ||
                shopName.contains("터치")  ||
                shopName.contains("족발")  ||
                shopName.contains("보쌈")  ||
                shopName.contains("분식")  ||
                shopName.contains("떡볶")  ||
                shopName.contains("피자")  ||
                shopName.contains("짜장")  ||
                shopName.contains("치킨")  ||
                shopName.contains("서브웨") ||
                shopName.contains("미스사") ||
                shopName.contains("청년")  ||
                shopName.contains("스시") ||
                shopName.contains("샤브") ||
                shopName.contains("라멘")  ||
                shopName.contains("원조")  ||
                shopName.contains("KFC") ||
                shopName.contains("포차") ||
                shopName.contains("펍")  ||
                shopName.contains("이자") ||
                shopName.contains("맘스") ||
                shopName.contains("아웃") ||
                shopName.contains("빕스") ||
                shopName.contains("양꼬치") ||
                shopName.contains("핫도") ||
                shopName.contains("맛닭꼬") ||
                shopName.contains("배달") ||
                shopName.contains("김치") ||
                shopName.contains("찌개")

        )
            return true;

        return  false;
    }

}
