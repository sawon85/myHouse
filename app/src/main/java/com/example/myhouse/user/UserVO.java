package com.example.myhouse.user;

public class UserVO {

    private static UserVO instance = null;

    public static UserVO getInstance() {
        if (instance == null)
            instance = new UserVO();
        return instance;
    }


    public boolean hasHouse;  // 갖고잇는 주택
    public boolean doesMarry;    // 결혼 유무
    public boolean isNewRecruits;
    
    public int salary; //연봉
    public int property; //자산
    public int deposit; //보증금
    public int age;

}
