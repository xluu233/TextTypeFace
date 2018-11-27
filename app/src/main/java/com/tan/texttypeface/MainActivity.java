package com.tan.texttypeface;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv_size;
    Button add,reduce;
    Button style1,style2,style3,style4;
    Spinner spinner;

    int size = 15;  //字体大小

    Typeface tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        onClick();

    }


    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv_size = (TextView) findViewById(R.id.tv_size);

        add = (Button)findViewById(R.id.tv_add);
        reduce = (Button)findViewById(R.id.tv_reduce);
        style1 = (Button) findViewById(R.id.tv_style1);
        style2 = (Button) findViewById(R.id.tv_style2);
        style3 = (Button) findViewById(R.id.tv_style3);
        style4 = (Button)findViewById(R.id.tv_style4);
        spinner = (Spinner) findViewById(R.id.spinner);

        String[] arr={"仿宋","幼圆-常规","华文行楷","BRUSHSCI斜体","方正姚体","华文琥珀","楷体-常规","方正舒体","Raleway-常规","隶书"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adapter);

        //从asset 读取字体
        //得到AssetManager
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf1 = Typeface.createFromAsset(mgr, "fonts/fangsong.TTF");//仿宋
        tf2 = Typeface.createFromAsset(mgr, "fonts/SIMYOU.TTF");//幼圆-常规
        tf3 = Typeface.createFromAsset(mgr, "fonts/STXINGKA.TTF");//华文行楷
        tf4 = Typeface.createFromAsset(mgr, "fonts/BRUSHSCI.TTF");//BRUSHSCI斜体
        tf5 = Typeface.createFromAsset(mgr, "fonts/FZYTK.TTF");//方正姚体
        tf6 = Typeface.createFromAsset(mgr, "fonts/STHUPO.TTF");//华文琥珀
        tf7 = Typeface.createFromAsset(mgr, "fonts/simkai.ttf");//楷体-常规
        tf8 = Typeface.createFromAsset(mgr, "fonts/FZSTK.TTF");//方正舒体
        tf9 = Typeface.createFromAsset(mgr, "fonts/Raleway-Regular.ttf");//Raleway-常规
        tf10 = Typeface.createFromAsset(mgr, "fonts/SIMLI.TTF");//隶书

    }


    private void onClick() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size ++;    //字体++++
                tv_size.setText(size+"sp");
                tv1.setTextSize(size);
                tv2.setTextSize(size);
            }
        });



        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size --;    //字体 ----
                tv_size.setText(size+"sp");
                tv1.setTextSize(size);
                tv2.setTextSize(size);
            }
        });


        style1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
                tv2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
            }
        });


        style2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));//斜体
                tv2.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));//斜体
            }
        });

        style3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));//加粗斜体
                tv2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));//加粗斜体
            }
        });

        style4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//正常
                tv2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//正常
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        tv1.setTypeface(tf1);
                        tv2.setTypeface(tf1);
                        break;
                    case 1:
                        tv1.setTypeface(tf2);
                        tv2.setTypeface(tf2);
                        break;
                    case 2:
                        tv1.setTypeface(tf3);
                        tv2.setTypeface(tf3);
                        break;
                    case 3:
                        tv1.setTypeface(tf4);
                        tv2.setTypeface(tf4);
                        break;
                    case 4:
                        tv1.setTypeface(tf5);
                        tv2.setTypeface(tf5);
                        break;
                    case 5:
                        tv1.setTypeface(tf6);
                        tv2.setTypeface(tf6);
                        break;
                    case 6:
                        tv1.setTypeface(tf7);
                        tv2.setTypeface(tf7);
                        break;
                    case 7:
                        tv1.setTypeface(tf8);
                        tv2.setTypeface(tf8);
                        break;
                    case 8:
                        tv1.setTypeface(tf9);
                        tv2.setTypeface(tf9);
                        break;
                    case 9:
                        tv1.setTypeface(tf10);
                        tv2.setTypeface(tf10);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
