package com.example.myhouse.House;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myhouse.AppManager;
import com.example.myhouse.Loan.loanProducts;
import com.example.myhouse.R;
import com.example.myhouse.user.UserVO;

public class LoanProductAdapter extends BaseAdapter {
    public HouseVO houseVO;

    public LoanProductAdapter(HouseVO houseVO){
        this.houseVO = houseVO;
    }

    @Override
    public int getCount() {
        return AppManager.getInstance().sortedAvailableLoans.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        Log.d("으아아악","ㅁㄴㅇㄹ");
        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.loan_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        LinearLayout layout = (LinearLayout) convertView.findViewById(R.id.layout);
        TextView titleView = (TextView) convertView.findViewById(R.id.title) ;
        TextView rateView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2) ;

        loanProducts loan = AppManager.getInstance().sortedAvailableLoans.get(i);
        Log.d("으아아아아아악", AppManager.getInstance().sortedAvailableLoans.get(i).getProductName());
        // 아이템 내 각 위젯에 데이터 반영
        titleView.setText(loan.getProductName());
        Log.d("으아아악","ㅁㄴㅇㄹ");
        rateView.setText("금리 : " + loan.getInterestRate());
        descTextView.setText(loan.getLimit());

        return convertView;
    }
}
