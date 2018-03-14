package com.sumit.vodhalhai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sumit.vodhalhai.POJO.MenuList;

/**
 * Created by MR.Cutevil on 11/12/2017.
 */

public class MenuDetailActivity extends AppCompatActivity {
    MenuList menuList;
    ImageView mMenuImageview;
    TextView mName,mPrice,mMaterialUsed,mAboutFood;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        mName=(TextView)findViewById(R.id.activity_menu_detail_foodName);
        mPrice=(TextView)findViewById(R.id.activity_menu_detail_foodPrice);
        mMaterialUsed=(TextView)findViewById(R.id.activity_menu_detail_materialUsed);
        mAboutFood=(TextView)findViewById(R.id.activity_menu_detail_aboutFood);
        mMenuImageview=(ImageView)findViewById(R.id.activity_menu_detail_foodImage);

        menuList=(MenuList)getIntent().getSerializableExtra("key");


        mName.setText("Name:" +menuList.getName());
        mPrice.setText("Price"+menuList.getPrice());
        mMaterialUsed.setText("Material Used:"+menuList.getMaterials());
        mAboutFood.setText("Details"+menuList.getDetails());

        Glide.with(MenuDetailActivity.this).load(menuList.getImage()).into(mMenuImageview);

    }
}
