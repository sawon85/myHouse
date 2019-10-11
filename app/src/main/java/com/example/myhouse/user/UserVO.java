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
    public int marryState;    // 결혼 유무
    public boolean isNewRecruits;
    public int jobState; //미취업, 중소기업, 대기업, 개인사업
    public int salary; //연봉
    public int property; //자산
    public int deposit; //보증금
    public int age;
    public String name; //이름
    public String birth; //생년월일 8자리
    public int childrenNumber; //자식 수
    public int resLoan; //남은 부채
    public int credit;      //신용등급
    public double financialCostBurdenRatio; //금융비용부담율

    UserVO()
    {
        Arrays.fill(cardData,0);
    }

    // 대출
    public ArrayList<Double> loanResRate = new ArrayList<>();  //이율
    public ArrayList<Integer> resLoanBalance = new ArrayList<>(); // 대출 잔액 //단위 : 1원



    public ArrayList<String> BKconnectedID = new ArrayList<>();
    public ArrayList<String> CDconnectedID = new ArrayList<>();

    public ArrayList<String> cardResult = new ArrayList<>();
}
