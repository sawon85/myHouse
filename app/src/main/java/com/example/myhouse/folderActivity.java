package com.example.myhouse;


import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class folderActivity extends ListActivity {

    private File file;
    private List myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);

        myList = new ArrayList();

        String rootSD = Environment.getExternalStorageDirectory().toString();
        file = new File( rootSD + "/NPKI/yessign/USER" ) ;
        File list[] = file.listFiles();

        for( int i=0; i<list.length; i++)
        {
            myList.add( list[i].getName() );
        }

        setListAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, myList ));

    }


    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);

        File temp_file = new File( file, (String) myList.get( position ));

        if( !temp_file.isFile())
        {
            file = new File( file, (String) myList.get( position ));
            File list[] = file.listFiles();

            myList.clear();

            for( int i=0; i< list.length; i++)
            {
                myList.add( list[i].getName() );
            }
            Toast.makeText(getApplicationContext(), file.toString(), Toast.LENGTH_LONG).show();
            setListAdapter(new ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, myList ));

        }

    }

}
