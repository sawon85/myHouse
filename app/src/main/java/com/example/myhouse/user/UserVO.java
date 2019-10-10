package com.example.myhouse.user;

import com.example.myhouse.Card.CardAnalysis;

import java.util.ArrayList;
import java.util.Arrays;

public class UserVO {

    private static UserVO instance = null;

    public static UserVO getInstance() {
        if (instance == null)
            instance = new UserVO();
        return instance;
    }

    public int[] cardData = new int[CardAnalysis.MAXIMUM];

    public boolean hasHouse;  // 갖고잇는 주택
    public boolean doesMarry;    // 결혼 유무
    public boolean isNewRecruits;
    
    public int salary; //연봉
    public int property; //자산
    public int deposit; //보증금
    public int age;

    UserVO()
    {
        Arrays.fill(cardData,0);
    }

    // 대출
    public ArrayList<Double> loanResRate = new ArrayList<>();  //이율
    public ArrayList<Integer> resLoanBalance = new ArrayList<>(); // 대출 잔액 //단위 : 1원
}
