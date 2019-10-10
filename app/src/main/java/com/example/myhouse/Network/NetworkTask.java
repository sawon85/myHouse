package com.example.myhouse.Network;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myhouse.AppManager;
import com.example.myhouse.House.HouseAdapter;
import com.example.myhouse.House.HouseVO;
import com.example.myhouse.MainActivity;
import com.example.myhouse.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Void, Void, String> {
    private Context context;
    private String url;
    private String data;
    ProgressDialog asyncDialog;
    private int selection;

    public NetworkTask(Context _context, String url, String data, int action){
        this.context = _context;
        this.url = url;
        this.data = data;
        this.selection = action;
        if(_context != null)
            this.asyncDialog = new ProgressDialog(_context);
    }

    @Override
    protected void onPreExecute(){
        //로딩
        if(asyncDialog != null) {
            asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            asyncDialog.setMessage("Loading");
            asyncDialog.show();
            asyncDialog.setCanceledOnTouchOutside(false);
        }
        super.onPreExecute();
    }



    @Override
    protected String doInBackground(Void... voids) {
        String result = null;

        try {
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.Request(url, data);

        }catch (Exception e){
            result = "Error";
        }

        return result;

    }

    @Override
    protected void onPostExecute(String result) {

        try {
            //경우에 따라 결과 값을 받아 일어났으면 하는 작업
            switch (this.selection) {
                case NetworkConstants.getHouseByDong:
                    try {
                        ArrayList<HouseVO> houseVOS = new ArrayList<>();
                        JSONObject jsonObject = new JSONObject(result);
                        String real_result = jsonObject.getString("result");
                        JSONArray resultObjectArray = new JSONArray(real_result);
                        Log.d("하나", real_result);
                        if (!real_result.equals("fail")) {
                            JSONObject resultObject;
                            if (resultObjectArray.length() != 0) {
                                for (int i = 0; i < resultObjectArray.length(); i++) {
                                    resultObject = resultObjectArray.getJSONObject(i);
                                    Log.d("둘", resultObject.toString());
                                    int home_index = resultObject.getInt("home_index");
                                    Log.d("하우스", home_index+"");
                                    String type = resultObject.getString("type");
                                    int spacious1 = resultObject.getInt("spacious1");
                                    int spacious2 = resultObject.getInt("spacious2");
                                    String dong = resultObject.getString("dong");
                                    String lotNnumber = resultObject.getString("lot_number");
                                    String name = resultObject.getString("name");
                                    String address1 = resultObject.getString("address1");
                                    String address2 = resultObject.getString("address2");
                                    String floor = resultObject.getString("floor");
                                    double x = resultObject.getDouble("latitude");
                                    double y = resultObject.getDouble("longitude");
                                    int price = Integer.parseInt(resultObject.getString("price").replace(",", ""));
                                    int deposit = Integer.parseInt(resultObject.getString("deposit").replace(",", ""));
                                    int monthlyRent = Integer.parseInt(resultObject.getString("monthly_rent").replace(",", ""));
                                    int loan = Integer.parseInt(resultObject.getString("loan").replace(",", ""));
                                    String information = resultObject.getString("information");
                                    String featrue = resultObject.getString("feature");
                                    Boolean possible = (resultObject.getInt("possible") != 0);
                                    String transmit_date = resultObject.getString("transmit_date");
                                    String registration_date = resultObject.getString("registration_date");
                                    String registrarNumber = resultObject.getString("registrarNumber");

                                    Log.d("하우스22", name);
                                    HouseVO houseVO = new HouseVO(home_index, type, spacious1, spacious2, dong, lotNnumber, name, address1, address2, floor,
                                            x, y, price, deposit, monthlyRent, loan, information, featrue, possible, transmit_date, registration_date, registrarNumber);
                                    houseVOS.add(houseVO);
                                    Log.d("서버", houseVO.description);
                                }

                                //후기 설정
                                HouseAdapter houseAdapter = new HouseAdapter(houseVOS);
                                AppManager.getInstance().houseAdapter = houseAdapter;
                                Log.d("앱매니저 이름", ((HouseVO)AppManager.getInstance().houseAdapter.getItem(0)).name);
                            }
                        } else if (real_result.equals("fail1")) {
                            Toast.makeText(this.context, "실패하였습니다.", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
            //로딩 종료
            if(asyncDialog!=null) {
                asyncDialog.setCanceledOnTouchOutside(true);
                asyncDialog.dismiss();
            }

        } catch (Exception e) {
            e.printStackTrace();
            //로딩 종료
            if(asyncDialog!=null) {
                asyncDialog.setCanceledOnTouchOutside(true);
                asyncDialog.dismiss();
            }
        }

    }
}
