package com.example.myhouse.House;

public class HouseVO {

    public HouseVO(int number, String type, int area1, int area2, String administationArea, String houseNumber, String name, String block, String unit, String floor,
                   double x, double y, int sellingPrice, int deposit, int monthlyRent, int loan, String description, String feature, boolean isLoanable, String transmitDate,
                   String registrationDate, String registrarNumber){

        this.number = number;
        this.type = type;
        this.area1 = area1;
        this.area2 = area2;
        this.administrationArea = administationArea;
        this.houseNumber = houseNumber;
        this.name = name;
        this.block = block;
        this.unit = unit;
        this.floor = floor;
        this.x = x;
        this.y = y;
        this.sellingPrice = sellingPrice;
        this.deposit = deposit;
        this.monthlyRent = monthlyRent;
        this.loan = loan;
        this.description = description;
        this.feature = feature;
        this.isLoanable = isLoanable;
        this.transmitDate = transmitDate;
        this.registrationDate = registrationDate;
        this.registrarNumber = registrarNumber;
    }

    public int number;          // 매물 번호
    public String type;
    public int area1;
    public int area2;
    public String administrationArea; // 행정동
    public String houseNumber; // 번지
    public String name;         // 매물 이름
    public String block;        // 동
    public String unit;         // 호
    public String floor;        // 층
    public double y; // 위도
    public double x; // 경도
    public int sellingPrice;    // 매매가
    public int deposit;         // 보증금
    public int monthlyRent;     // 월세
    public int loan;         // 융자금
    public String description;   // 매물 설명
    public String feature;      // 특징
    public boolean isLoanable; // 대출 가능 여부
    public String transmitDate; // 전송일
    public String registrationDate; // 등록일
    public String registrarNumber; // 매물 등록 중개업자 번호
}
