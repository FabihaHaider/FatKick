package com.example.fatkick.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.fatkick.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private TextView mTVResult;
    private Button mBtView;
    private Button mBtUpadate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTVResult = (TextView) findViewById(R.id.tv_result);
        mBtView = (Button) findViewById(R.id.bt_view_daily_task);
        mBtUpadate = (Button) findViewById(R.id.bt_update_daily_task);

        /*OkHttpClient client = new OkHttpClient();

        String url = "https://fitness-calculator.p.rapidapi.com/dailycalorie?age=25&gender=male&height=175&weight=70&activitylevel=level_1";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", "51434c9f6fmshf357c3b5f512284p18ce3fjsnf60e0881670d")
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String stringResponse = response.body().string();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject JSONresponse = new JSONObject(stringResponse);

                                //Integer cal1 = JSONresponse.getJSONObject("data").getJSONObject("goals").getJSONObject("Weight loss").getInt("calory");
                                Double cal1 = JSONresponse.getJSONObject("data").getJSONObject("goals").getJSONObject("Weight loss").getDouble("calory");
                                String sCal1 = cal1.toString();

                                mTVResult.setText(sCal1);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    });
                }
            }
        });*/

        mBtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowDailyTaskActivity.class);
                startActivity(intent);
            }
        });

        mBtUpadate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateDailyTaskActivity.class);
                startActivity(intent);
            }
        });



    }



}