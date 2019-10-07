package com.example.myhouse.CardApi;

public class CardAPITest {

    public void test(){
        String token_url = "https://oauth.codef.io/oauth/token";
        String access_token = RequestToken.getToken("558073ff-5057-4711-9f7b-b80f93f5ff91", "32f2abdc-8944-4d7e-9241-f2251c031b59");
        if (access_token != null){
            System.out.println(access_token);
        }
        else{
            System.out.println("토큰 발급 오류");
        }
    }
}
