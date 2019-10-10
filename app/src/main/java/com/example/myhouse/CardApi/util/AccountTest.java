package com.example.myhouse.CardApi.util;

import android.util.Log;

import com.example.myhouse.AppManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import android.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;



/**
 * 계정관리 테스트
 */
public class AccountTest {
	/**
	 * 계정 등록을 통한 커넥티트 아이디 발급
	 * 
	 * @throws ParseException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */

	String keyFileEncoded;
	String derFileEncoded;

	@Test  
	@Ignore
	public void create() throws IOException, InterruptedException, ParseException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		/// 요청 URL 설정
		String urlPath = CommonConstant.API_DOMAIN + CommonConstant.CREATE_ACCOUNT;
		
		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();	
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> accountMap1 = new HashMap<String, Object>();
		accountMap1.put("countryCode",	"KR");
		accountMap1.put("businessType",	"BK");
		accountMap1.put("clientType",  	"P");
		accountMap1.put("organization",	"0011");
		accountMap1.put("loginType",  	"0");
		
		String password1 = "";
		Log.d("errrrrr", "");
		accountMap1.put("password",  	RSAUtil.encryptRSA(password1, CommonConstant.PUBLIC_KEY));	/**	password RSA encrypt */

		File certFile = new File(AppManager.getInstance().getNpkiPath() + "/signCert.der");
		File keyFile = new File(AppManager.getInstance().getNpkiPath() + "/signPri.key");

		byte[] fileContent = FileUtils.readFileToByteArray(certFile);
		String encodedString = Base64.encodeToString(fileContent ,Base64.NO_WRAP);
		derFileEncoded = encodedString;

		fileContent = FileUtils.readFileToByteArray(keyFile);
		encodedString = Base64.encodeToString(fileContent, Base64.NO_WRAP);
		keyFileEncoded = encodedString;

		accountMap1.put("keyFile",keyFileEncoded);
		accountMap1.put("derFile",derFileEncoded);
		list.add(accountMap1);
		
		bodyMap.put("accountList", list);
		// 요청 파라미터 설정 종료

		// API 요청
		System.out.println("요청");
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		System.out.println("완료");
		// 응답결과 확인
		System.out.println(result);
	}
	
	/**	
	 * 계정 목록조회
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test 
	@Ignore
	public void list() throws IOException, InterruptedException, ParseException{
		// 요청 URL 설정
		String urlPath = CommonConstant.getRequestDomain()  + CommonConstant.KR_CD_P_002;
		
		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("connectedId",	"");	// 엔드유저의 은행/카드사 계정 등록 후 발급받은 커넥티드아이디 예시
		bodyMap.put("organization",	"0011");
		bodyMap.put("birthDate",	"19950805");
		bodyMap.put("startDate", "20181001");
		bodyMap.put("endDate",	"20190930");
		bodyMap.put("orderBy",		"1");
		bodyMap.put("inquiryType",	"1");


		// 요청 파라미터 설정 종료
		
		// API 요청
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		AppManager.getInstance().result = result;


		// 응답결과 확인
		System.out.println(result);
	}

	/**	
	 * connectedId 목록조회
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test 
	@Ignore
	public void connectedIdList() throws IOException, InterruptedException, ParseException {
		// 요청 URL 설정
		String urlPath = CommonConstant.getRequestDomain() + CommonConstant.GET_CONNECTED_IDS;	
		
		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put(CommonConstant.PAGE_NO, 0);		// 페이지 번호(생략 가능) 생략시 1페이지 값(0) 자동 설정
		// 요청 파라미터 설정 종료
		
		// API 요청
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		
		// 응답결과 확인
		System.out.println(result);
	}
	
	/**
	 * 계정 추가 테스트
	 * 
	 * @throws ParseException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	@Test 
	@Ignore
	public void add() throws IOException, InterruptedException, ParseException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// 요청 URL 설정
		String urlPath = CommonConstant.getRequestDomain() + CommonConstant.ADD_ACCOUNT;	
		
		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> accountMap1 = new HashMap<String, Object>();
		accountMap1.put("countryCode",	"KR");
		accountMap1.put("businessType",	"BK");
		accountMap1.put("clientType",  	"P");
		accountMap1.put("organization",	"0020");
		accountMap1.put("loginType",  	"0");
		
		String password1 = "!";
		accountMap1.put("password",  	RSAUtil.encryptRSA(password1, CommonConstant.PUBLIC_KEY));	/**	password RSA encrypt */
				
		accountMap1.put("keyFile",      "BASE64로 Encoding된 엔드유저의 인증서 key파일 문자열");
		accountMap1.put("derFile",      "BASE64로 Encoding된 엔드유저의 인증서 der파일 문자열");
		list.add(accountMap1);
		
		bodyMap.put("accountList", list);
		
		String connectedId = "45t4DJOD44M9uwH7zxSgBg";	// 엔드유저의 은행/카드사 계정 등록 후 발급받은 커넥티드아이디 예시
		bodyMap.put(CommonConstant.CONNECTED_ID, connectedId);
		// 요청 파라미터 설정 종료

		// API 요청
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		
		// 응답결과 확인
		System.out.println(result);
	}
	
	/**
	 * 계정 수정 테스트
	 * 
	 * @throws ParseException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	@Test 
	@Ignore
	public void update() throws IOException, InterruptedException, ParseException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// 요청 URL 설정
		String urlPath = CommonConstant.getRequestDomain() + CommonConstant.UPDATE_ACCOUNT;	
		
		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> accountMap1 = new HashMap<String, Object>();
		accountMap1.put("countryCode",	"KR");
		accountMap1.put("businessType",	"BK");
		accountMap1.put("clientType",  	"P");
		accountMap1.put("organization",	"0020");
		accountMap1.put("loginType",  	"0");
		
		String password1 = "엔드유저의 인증서 비밀번호";
		accountMap1.put("password",  	RSAUtil.encryptRSA(password1, CommonConstant.PUBLIC_KEY));	/**	password RSA encrypt */
				
		accountMap1.put("keyFile",      "BASE64로 Encoding된 엔드유저의 인증서 key파일 문자열");
		accountMap1.put("derFile",      "BASE64로 Encoding된 엔드유저의 인증서 der파일 문자열");
		list.add(accountMap1);
		
		bodyMap.put("accountList", list);
		
		String connectedId = "45t4DJOD44M9uwH7zxSgBg";	// 엔드유저의 은행/카드사 계정 등록 후 발급받은 커넥티드아이디 예시
		bodyMap.put(CommonConstant.CONNECTED_ID, connectedId);
		// 요청 파라미터 설정 종료

		// API 요청
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		
		// 응답결과 확인
		System.out.println(result);
	}
	
	

	/**
	 * 계정 삭제 테스트
	 * 
	 * @throws ParseException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test 
	@Ignore
	public void delete() throws IOException, InterruptedException, ParseException {
		// 요청 URL 설정
		String urlPath = CommonConstant.getRequestDomain() + CommonConstant.DELETE_ACCOUNT;	
		
		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> accountMap1 = new HashMap<String, Object>();
		accountMap1.put("countryCode",	"KR");
		accountMap1.put("businessType", "BK");
		accountMap1.put("clientType",   "P");
		accountMap1.put("organization", "0020");
		accountMap1.put("loginType",  	"0");
		list.add(accountMap1);
		
		bodyMap.put("accountList", list);
		
		String connectedId = "45t4DJOD44M9uwH7zxSgBg";	// 엔드유저의 은행/카드사 계정 등록 후 발급받은 커넥티드아이디 예시
		bodyMap.put(CommonConstant.CONNECTED_ID, connectedId);
		// 요청 파라미터 설정 종료

		// API 요청
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		
		// 응답결과 확인
		System.out.println(result);
	}


	/**
	 * 계정 목록조회
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test
	@Ignore
	public void LoanList() throws IOException, InterruptedException, ParseException{
		// 요청 URL 설정
		String urlPath = CommonConstant.getRequestDomain()  + CommonConstant.KR_BK_1_P_001;

		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("connectedId",	"9uZVOm6FQky8pYzb.FSlqR");	// 엔드유저의 은행/카드사 계정 등록 후 발급받은 커넥티드아이디 예시
		bodyMap.put("organization",	"0011");

		// API 요청
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		AppManager.getInstance().result = result;

		// 응답결과 확인
		System.out.println(result);

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;

		try{
			ObjectMapper mapper = new ObjectMapper();
			jsonObject = (JSONObject) jsonParser.parse(AppManager.getInstance().result);
			JSONObject jsonObject1= (JSONObject) jsonObject.get("data");
			JSONArray jsonArray1 = (JSONArray) jsonObject1.get("resDepositTrust");
			JSONObject objectInArray;
			AppManager.getInstance().account = new ArrayList<String>();
			for( int i = 0; i < jsonArray1.size(); i++) {

				objectInArray = (JSONObject) jsonArray1.get(i);
				String account = (String) objectInArray.get("resAccount");
				AppManager.getInstance().account.add(account);
				System.out.println(account);

				String urlPath2 = CommonConstant.getRequestDomain() + CommonConstant.KR_BK_1_P_004;
				HashMap<String, Object> bodyMap2 = new HashMap<String, Object>();
				bodyMap2.put("connectedId", "9uZVOm6FQky8pYzb.FSlqR");    // 엔드유저의 은행/카드사 계정 등록 후 발급받은 커넥티드아이디 예시
				bodyMap2.put("organization", "0011");
				bodyMap2.put("account", account);
				bodyMap2.put("startDate", "20000101");
				bodyMap2.put("endDate", "20191010");
				bodyMap2.put("orderBy", "0");

				result = ApiRequest.reqeust(urlPath2, bodyMap2);
				AppManager.getInstance().result = result;

				// 응답결과 확인
				System.out.println(result);

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}


	}
	
	/**
	 * BASE64로 Encoding된 엔드유저의 인증서 key파일 문자열 추출 샘플
	 *  
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	@Test 
	@Ignore
	public void getBase64FromCertFile() throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		File certFile = new File(AppManager.getInstance().getNpkiPath() + "signCert.der");
		File keyFile = new File(AppManager.getInstance().getNpkiPath() + "signPri.key");
		
		byte[] fileContent = FileUtils.readFileToByteArray(certFile);
		String encodedString = Base64.encodeToString(fileContent ,0);
		derFileEncoded = encodedString;
		System.out.println(encodedString);
		
		fileContent = FileUtils.readFileToByteArray(keyFile);
		encodedString = Base64.encodeToString(fileContent, 0);
		System.out.println(encodedString);
		keyFileEncoded = encodedString;
	}
	
}


