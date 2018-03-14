package com.sumit.vodhalhai;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sumit.vodhalhai.Helper.Constants;
import com.sumit.vodhalhai.Helper.Jsonparser;
import com.sumit.vodhalhai.POJO.MenuList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MR.Cutevil on 11/6/2017.
 */

public class MenuListActivity extends AppCompatActivity {
    JSONObject jsonObject;
    ProgressDialog mprogressdialog;
    int flag = 0;
    Jsonparser jsonp = new Jsonparser();
    ArrayList<MenuList> arrayofmenulist = new ArrayList<>();
    ListView mMenuListView;
    MenuList menuList;
    MenuListAdapter menuListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        mMenuListView = (ListView) findViewById(R.id.activity_menu_list_listview);
        new ShowMenuList().execute();
    }

    public class ShowMenuList extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            mprogressdialog = new ProgressDialog(MenuListActivity.this);
            mprogressdialog.setMessage("please wait");
            mprogressdialog.setCancelable(false);
            mprogressdialog.show();
        }


        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("id", "1");
            String url = Constants.BASE_URL + "api/showmenulist";
            jsonObject = jsonp.performPostCI(url, hm);
            if (jsonObject == null) {
                flag = 1;
            } else {
                try {
                    if (jsonObject.getString("status").equals("success")) {
                        //url call garda succesful ayo vane postman
                        flag = 2;
                        //data array chaincha so jsonarray ko object banera jsonobject bata data vanne array haru taneko
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        //data array ma tannai array haru xa so loop lagako
                        for (int i = 0; i < jsonArray.length(); i++) {
                            //array ko lenght napuge samma last data samma
                            JSONObject menuObject = jsonArray.getJSONObject(i);
                            //jsonobjecct ko naya objecct banaune jata data matra rakhne
                            String name, price, details, image, materials;
                            name = menuObject.getString("name");
                            price = menuObject.getString("price");
                            details = menuObject.getString("details");
                            image = menuObject.getString("image");
                            materials = menuObject.getString("materials");

                            menuList = new MenuList(name, price, details, image, materials);
                            arrayofmenulist.add(menuList);

                        }
                    } else {
                        flag = 3;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mprogressdialog.dismiss();
            if (flag == 2) {
                menuListAdapter = new MenuListAdapter(MenuListActivity.this, arrayofmenulist);
                mMenuListView.setAdapter(menuListAdapter);
                mMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        menuList = (MenuList) parent.getItemAtPosition(position);
                        Intent in = new Intent(MenuListActivity.this, MenuDetailActivity.class);
                        in.putExtra("key", menuList);
                        startActivity(in);
                    }
                });
            }
        }
    }
}