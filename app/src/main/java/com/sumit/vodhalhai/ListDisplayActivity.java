package com.sumit.vodhalhai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by MR.Cutevil on 11/10/2017.
 */

public class ListDisplayActivity extends AppCompatActivity {
   String[] mobile_brand={"Samsung","colors","blackberry","htc","nokia","sony","lg","apple"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_display);
        final ListView listView=(ListView)findViewById(R.id.activity_list_display_iv_mobile_list);
        //Adapter are used to provide data to the listview
        final ArrayAdapter adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mobile_brand);
        listView.setAdapter(adapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(ListDisplayActivity.this, "Position"+position, Toast.LENGTH_SHORT).show();
             }
         });
        }
    }
