package com.example.myhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.example.myhouse.Card.CardAnalysis;
import com.example.myhouse.user.UserVO;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class graphActivity extends AppCompatActivity {

    PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        JSONParser jsonParser = new JSONParser();

        CardAnalysis cardAnalysis = new CardAnalysis();

        for(String result : UserVO.getInstance().cardResult) {

            System.out.println(result);
            try {

                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
                JSONArray jsonArray1 = (JSONArray) jsonObject.get("data");
                JSONObject objectInArray;
                for (int i = 0; i < jsonArray1.size(); i++) {
                    objectInArray = (JSONObject) jsonArray1.get(i);
                    if ("KRW".equals((String) objectInArray.get("resAccountCurrency")))
                        UserVO.getInstance().cardData[cardAnalysis.getShopType((String) objectInArray.get("resMemberStoreName"))]
                                += Integer.parseInt((String) objectInArray.get("resUsedAmount"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i=0; i< CardAnalysis.MAXIMUM; i++)
        {
           Log.d( " 품목 : " , String.valueOf(UserVO.getInstance().cardData[i]));
        }

        pieChart = (PieChart)findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.0f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Nothing],"기타"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Food],"식비"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Cafe],"카페"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Care],"의료"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Study],"교육비"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Traffic],"교통"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Service],"개인 서비스"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Mart],"마트, 편의점"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Online],"온라"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Health],"헬스"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Beauty],"미용"));
        yValues.add(new PieEntry(UserVO.getInstance().cardData[CardAnalysis.Culture],"문화"));

        Description description = new Description();
        description.setText("개인 지출"); //라벨
        description.setTextSize(15);
        pieChart.setDescription(description);

        PieDataSet dataSet = new PieDataSet(yValues,": 품목");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);

    }
}
