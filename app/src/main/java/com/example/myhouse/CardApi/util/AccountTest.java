package com.example.myhouse.CardApi.util;

import android.util.Log;

import com.example.myhouse.AppManager;

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
		String urlPath = CommonConstant.getRequestDomain() + CommonConstant.CREATE_ACCOUNT;
		
		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();	
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> accountMap1 = new HashMap<String, Object>();
		accountMap1.put("countryCode",	"KR");
		accountMap1.put("businessType",	"BK");
		accountMap1.put("clientType",  	"P");
		accountMap1.put("organization",	"0011");
		accountMap1.put("loginType",  	"0");
		
		String password1 = "비버";
		Log.d("errrrrr", "패스워드 입력");
		accountMap1.put("password",  	RSAUtil.encryptRSA(password1, CommonConstant.PUBLIC_KEY));	/**	password RSA encrypt */

		File certFile = new File(AppManager.getInstance().getNpkiPath() + "/signCert.der");
		File keyFile = new File(AppManager.getInstance().getNpkiPath() + "/signPri.key");

		byte[] fileContent = FileUtils.readFileToByteArray(certFile);
		String encodedString = Base64.encodeToString(fileContent ,0);
		derFileEncoded = encodedString;

		fileContent = FileUtils.readFileToByteArray(keyFile);
		encodedString = Base64.encodeToString(fileContent, 0);
		keyFileEncoded = encodedString;

		accountMap1.put("keyFile",      keyFileEncoded);
		accountMap1.put("derFile",      derFileEncoded);
		list.add(accountMap1);
		
		bodyMap.put("accountList", list);
		// 요청 파라미터 설정 종료

		// API 요청
		System.out.println("요청");
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		System.out.println("완료");

		System.out.println("아이디");
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
	public void list() throws IOException, InterruptedException, ParseException {
		// 요청 URL 설정
		String urlPath = CommonConstant.getRequestDomain() + CommonConstant.GET_ACCOUNTS;	
		
		// 요청 파라미터 설정 시작
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		
		String connectedId = "45t4DJOD44M9uwH7zxSgBg";	// 엔드유저의 은행/카드사 계정 등록 후 발급받은 커넥티드아이디 예시
		bodyMap.put(CommonConstant.CONNECTED_ID, connectedId);
		// 요청 파라미터 설정 종료
		
		// API 요청
		String result = ApiRequest.reqeust(urlPath, bodyMap);
		
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


