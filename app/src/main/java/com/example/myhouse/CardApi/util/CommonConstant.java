package com.example.myhouse.CardApi.util;

/**
 *	상수 클래스 
 */
public class CommonConstant {
	
	public static final String API_DOMAIN 	= "https://api.codef.io";										// API서버 도메인		
	public static final String TEST_DOMAIN 	= "https://development.codef.io";								// API서버 데모 도메인		
	
	public static final String TOKEN_DOMAIN = "https://oauth.codef.io";										// OAUTH2.0 테스트 도메인
	public static final String GET_TOKEN 	= "/oauth/token";												// OAUTH2.0 토큰 발급 요청 URL
	
	public static final String CONNECTED_ID = "connectedId";												// 유저 식별 연결 아이디
	public static final String PAGE_NO 		= "pageNo";														// 페이지 번호
	                                                                                                        
	public static final String KR_BK_1_B_001	= "/v1/kr/bank/b/account/account-list";                     // 은행 기업 보유계좌
	public static final String KR_BK_1_B_002	= "/v1/kr/bank/b/account/transaction-list";                 // 은행 기업 수시입출 거래내역
	public static final String KR_BK_1_B_003	= "/v1/kr/bank/b/installment-savings/transaction-list";     // 은행 기업 적금 거래내역
	public static final String KR_BK_1_B_004	= "/v1/kr/bank/b/loan/transaction-list";                    // 은행 기업 대출 거래내역
	public static final String KR_BK_1_B_005	= "/v1/kr/bank/b/exchange/transaction-list";                // 은행 기업 외화 거래내역
	public static final String KR_BK_1_B_006	= "/v1/kr/bank/b/fund/transaction-list";                    // 은행 기업 펀드 거래내역
	public static final String KR_BK_1_B_007	= "/v1/kr/bank/b/fast-account/transaction-list";            // 은행 기업 빠른계좌조회
	                                                                                                        
	public static final String KR_BK_1_P_001	= "/v1/kr/bank/p/account/account-list";                     // 은행 개인 보유계좌				
	public static final String KR_BK_1_P_002	= "/v1/kr/bank/p/account/transaction-list";                 // 은행 개인 수시입출 거래내역
	public static final String KR_BK_1_P_003	= "/v1/kr/bank/p/installment-savings/transaction-list";     // 은행 개인 적금 거래내역
	public static final String KR_BK_1_P_004	= "/v1/kr/bank/p/loan/transaction-list";                    // 은행 개인 대출 거래내역
	public static final String KR_BK_1_P_005	= "/v1/kr/bank/p/fast-account/transaction-list";            // 은행 개인 빠른계좌조회
	                                                                                                        
	public static final String KR_BK_2_P_001	= "/v1/kr/bank2/p/account/account-list";                    // 저축은행 개인 보유계좌 조회
	public static final String KR_BK_2_P_002	= "/v1/kr/bank2/p/account/transaction-list";                // 저축은행 개인 수시입출 거래내역
	               
	public static final String KR_CD_B_001	= "/v1/kr/card/b/account/card-list";                            // 카드 법인 보유카드
	public static final String KR_CD_B_002	= "/v1/kr/card/b/account/approval-list";                        // 카드 법인 승인내역
	public static final String KR_CD_B_003	= "/v1/kr/card/b/account/billing-list";                         // 카드 법인 청구내역
	public static final String KR_CD_B_004	= "/v1/kr/card/b/account/limit";                                // 카드 법인 한도조회

	public static final String KR_CD_P_001	= "/v1/kr/card/p/account/card-list";                            // 카드 개인 보유카드
	public static final String KR_CD_P_002	= "/v1/kr/card/p/account/approval-list";                        // 카드 개인 승인내역
	public static final String KR_CD_P_003	= "/v1/kr/card/p/account/billing-list";                         // 카드 개인 청구내역
	public static final String KR_CD_P_004	= "/v1/kr/card/p/account/limit";                                // 카드 개인 한도조회
	              
	public static final String KR_PB_NT_001	= "/v1/kr/public/nt/business/status";                            // 공공 사업자상태
	public static final String KR_PB_CK_001	= "/v1/kr/public/ck/real-estate-register/status";                // 공공 부동산등기
	public static final String KR_PB_EF_001	= "/v1/kr/public/ef/driver-license/status";                      // 공공 운전면허 진위여부
	public static final String KR_PB_MW_001	= "/v1/kr/public/mw/identity-card/status";                       // 공공 주민등록 진위여부
	
	public static final String GET_CONNECTED_IDS = "/v1/account/connectedId-list";       					// 커넥티드아이디 목록 조회			
	public static final String GET_ACCOUNTS = "/v1/account/list";            								// 계정 목록 조회			
	public static final String CREATE_ACCOUNT = "/v1/account/create";            							// 계정 등록(커넥티드아이디 발급)			
	public static final String ADD_ACCOUNT = "/v1/account/add";            									// 계정 추가			
	public static final String UPDATE_ACCOUNT = "/v1/account/update";            							// 계정 수정			
	public static final String DELETE_ACCOUNT = "/v1/account/delete";            							// 계정 삭제			

	public static final String BK_NH = "0011";
	public static final String BK_KB = "0004";
	public static final String BK_SH = "0088";
	public static final String BK_URI = "0020";

	public static final String CD_NH = "0304";
	public static final String CD_KB = "0301";
	public static final String CD_SH = "0306";
	public static final String CD_SAM = "0303";


	/**
	 * API 요청 도메인 반환
	 * @return
	 */
	public static String getRequestDomain() {
		return CommonConstant.TEST_DOMAIN;
	}
	
	
	/**	CODEF로부터 발급받은 클라이언트 아이디	*/
	public static final String CLIENT_ID 	= "558073ff-5057-4711-9f7b-b80f93f5ff91";
	
	/**	CODEF로부터 발급받은 시크릿 키	*/
	public static final String SECERET_KEY 	= "32f2abdc-8944-4d7e-9241-f2251c031b59";
	
	/**	CODEF로부터 발급받은 퍼블릭 키	*/
	public static final String PUBLIC_KEY 	= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmL7AHOzBT8FjXQ+MuCcDyDITr+XhfRGDLWENRLsmuEXz2Z0xqdP3nGq8BvhrJApcDkL6CX3lRy0M6RByDos/FPTSPcDDqRXf6jbj2X5/cIIyb92PLu7dALSciIWrqgEaAnMEO0WQwKzX9+dyBRhg2baaQ3+AgRLwpdp1GjX6bQpgmUPCCBWxu4BLqy1MYRX8rULf/D1I69Cv3ZDLwYgdZjApGE13vK/AQ4OB/8qotSgugy4M1ajPOvyyO2VO9UxxOU0WwiQX4j8QL+Ui1W7Y8tAU0MCDhafQ4rNbX/VRJMKCI42BSq2n+8Su3ArE6fwV6ODLE4psa23epGGnGnspOQIDAQAB";
	/**	OAUTH2.0 토큰 샘플	*/
	public static String ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZXJ2aWNlX3R5cGUiOiIxIiwic2NvcGUiOlsicmVhZCJdLCJzZXJ2aWNlX25vIjoiMDAwMDAwMjc4MDAxIiwiZXhwIjoxNTcxMDc4MjM5LCJhdXRob3JpdGllcyI6WyJJTlNVUkFOQ0UiLCJQVUJMSUMiLCJCQU5LIiwiRVRDIiwiU1RPQ0siLCJDQVJEIl0sImp0aSI6ImU4MDA2NmM4LTEwODEtNDQ0ZC1hN2NjLWU5YThiMTUxZGJmZSIsImNsaWVudF9pZCI6IjU1ODA3M2ZmLTUwNTctNDcxMS05ZjdiLWI4MGY5M2Y1ZmY5MSJ9.WaR_A3RjW-3AYzWGHqUGNOKq7AeASnpmqQRvNPnjx_-bkEHT9464dnxkANgOLdgDcruqclkGmYCNDu9e22ncmWZoptrFgfQMp2DEkruHcAExTtWuVXkai4uuRKKfQ4aj0gviA8rzPnuAYTkg08kNR9Evxm1U6V1Z1ainQwPZv8LfN4NriiwB1XqJMeOjXc2JvqB1lQLh5MdYeUqwfdJrLPUBufKSZrK9puEvrl73NYl2xtkYl8gEELjnfRu4AqlFM9AR2qjJq6Fj81ItkHnV_FnkPMJqJlsGkTJF1sFiVUCPKy0tKz4V6Ox5zG0cimhz4IRqlg4IKDMpiXiLoYorCQ";
	
	
	/**	샌드박스 테스트용 상수	*/
	public static final String SANDBOX_DOMAIN = "https://sandbox.codef.io";									// API서버 샌드박스 도메인		
	public static final String SANDBOX_CLIENT_ID 	= "ef27cfaa-10c1-4470-adac-60ba476273f9";				// CODEF 샌드박스 클라이언트 아이디
	public static final String SANDBOX_SECERET_KEY 	= "83160c33-9045-4915-86d8-809473cdf5c3";				// CODEF 샌드박스 클라이언트 시크릿
	
}
