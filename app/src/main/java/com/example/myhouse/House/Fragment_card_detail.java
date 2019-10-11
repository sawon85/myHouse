package com.example.myhouse.House;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myhouse.R;
import com.example.myhouse.user.UserVO;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;


public class Fragment_card_detail extends Fragment {

    private GraphicalView mChartView;
    LinearLayout layout;

    private String[] mMonth = new String[]{

            "기타", "식비", "카페", "교육", "교통", "서비스",

            "헬스", "의료", "마트", "온라인", "문화", "미용"

    };

    public static Fragment_card_detail newInstance(){
        Fragment_card_detail fragment = new Fragment_card_detail();
        return fragment;
    }

    public Fragment_card_detail ()
    {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layout =  ((LinearLayout) view.findViewById(R.id.chart_bar));
        drawChart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_card_detail, container, false);

       return view;
    }

    private void drawChart() {

        int[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        int[] income = {UserVO.getInstance().cardData[0] ,
                UserVO.getInstance().cardData[1],
                UserVO.getInstance().cardData[2],
                UserVO.getInstance().cardData[3],
                UserVO.getInstance().cardData[4],
                UserVO.getInstance().cardData[5],
                UserVO.getInstance().cardData[6],
                UserVO.getInstance().cardData[7],
                UserVO.getInstance().cardData[8],
                UserVO.getInstance().cardData[9],
                UserVO.getInstance().cardData[10],
                UserVO.getInstance().cardData[11] };

        int[] expense = {2200, 2700, 2900, 2800, 2600, 3000, 3300, 3400, 0, 0, 0, 0};


        // Creating an XYSeries for Income

        XYSeries incomeSeries = new XYSeries("현재 지출");

        // Creating an XYSeries for Expense

        XYSeries expenseSeries = new XYSeries("예상 지출");

        // Adding data to Income and Expense Series

        for (int i = 0; i < x.length; i++) {

            incomeSeries.add(i, income[i]);

            expenseSeries.add(i, expense[i]);

        }


        // Creating a dataset to hold each series

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

        // Adding Income Series to the dataset

        dataset.addSeries(incomeSeries);

        // Adding Expense Series to dataset

        dataset.addSeries(expenseSeries);


        // Creating XYSeriesRenderer to customize incomeSeries

        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();

        incomeRenderer.setColor(Color.GREEN); //color of the graph set to cyan

        incomeRenderer.setFillPoints(true);

        incomeRenderer.setLineWidth(2);

        incomeRenderer.setDisplayChartValues(true);

        incomeRenderer.setDisplayChartValuesDistance(10); //setting chart value distance


        // Creating XYSeriesRenderer to customize expenseSeries

        XYSeriesRenderer expenseRenderer = new XYSeriesRenderer();

        expenseRenderer.setColor(R.color.colorPrimary);

        expenseRenderer.setFillPoints(true);

        expenseRenderer.setLineWidth(2);

        expenseRenderer.setDisplayChartValues(true);

        // Creating a XYMultipleSeriesRenderer to customize the whole chart

        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();

        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);

        multiRenderer.setXLabels(0);

        multiRenderer.setChartTitle("물가지수 분석 차트");

        multiRenderer.setXTitle("Year 2017");

        multiRenderer.setYTitle("Amount in Dollars");


        /***

         * Customizing graphs

         */

        //setting text size of the title

        multiRenderer.setChartTitleTextSize(28);

        multiRenderer.setAxisTitleTextSize(24);

        //setting text size of the graph lable

        multiRenderer.setLabelsTextSize(24);

        //setting zoom buttons visiblity

        multiRenderer.setZoomButtonsVisible(false);

        //setting pan enablity which uses graph to move on both axis

        multiRenderer.setPanEnabled(false, false);

        //setting click false on graph

        multiRenderer.setClickEnabled(false);

        //setting zoom to false on both axis

        multiRenderer.setZoomEnabled(false, false);

        //setting lines to display on y axis

        multiRenderer.setShowGridY(false);

        //setting lines to display on x axis

        multiRenderer.setShowGridX(false);

        //setting legend to fit the screen size

        multiRenderer.setFitLegend(true);

        //setting displaying line on grid

        multiRenderer.setShowGrid(false);

        //setting zoom to false

        multiRenderer.setZoomEnabled(false);

        //setting external zoom functions to false

        multiRenderer.setExternalZoomEnabled(false);

        //setting displaying lines on graph to be formatted(like using graphics)

        multiRenderer.setAntialiasing(true);

        //setting to in scroll to false

        multiRenderer.setInScroll(false);

        //setting to set legend height of the graph

        multiRenderer.setLegendHeight(30);

        //setting x axis label align

        multiRenderer.setXLabelsAlign(Paint.Align.CENTER);

        //setting y axis label to align

        multiRenderer.setYLabelsAlign(Paint.Align.LEFT);

        //setting text style

        multiRenderer.setTextTypeface("sans_serif", Typeface.NORMAL);

        //setting no of values to display in y axis

        multiRenderer.setYLabels(10);

        // setting y axis max value, Since i'm using static values inside the graph so i'm setting y max value to 4000.

        // if you use dynamic values then get the max y value and set here

        multiRenderer.setYAxisMax(4000);

        //setting used to move the graph on xaxiz to .5 to the right

        multiRenderer.setXAxisMin(-0.5);

        //setting max values to be display in x axis

        multiRenderer.setXAxisMax(11);

        //setting bar size or space between two bars

        multiRenderer.setBarSpacing(0.5);

        //Setting background color of the graph to transparent

        multiRenderer.setBackgroundColor(Color.TRANSPARENT);

        //Setting margin color of the graph to transparent

        multiRenderer.setMarginsColor(Color.MAGENTA);

        multiRenderer.setApplyBackgroundColor(true);

        //setting the margin size for the graph in the order top, left, bottom, right

        multiRenderer.setMargins(new int[]{30, 30, 30, 30});

        for (int i = 0; i < x.length; i++) {

            multiRenderer.addXTextLabel(i, mMonth[i]);

        }

        // Adding incomeRenderer and expenseRenderer to multipleRenderer

        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer

        // should be same

        multiRenderer.addSeriesRenderer(incomeRenderer);

        multiRenderer.addSeriesRenderer(expenseRenderer);

        //this part is used to display graph on the xml


        //remove any views before u paint the chart

        layout.removeAllViews();

        //drawing bar chart

        mChartView = ChartFactory.getBarChartView(getContext(), dataset, multiRenderer, BarChart.Type.DEFAULT);


        layout.addView(mChartView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,

                LinearLayout.LayoutParams.FILL_PARENT));

    }

}
