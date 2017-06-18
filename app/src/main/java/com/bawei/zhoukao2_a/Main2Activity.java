package com.bawei.zhoukao2_a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;
import static android.R.attr.text;

public class Main2Activity extends Activity {

    private TextView name;
    private TextView pwd;
    private Button chaKan;

    private boolean memory_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        name = (TextView) findViewById(R.id.name);
        pwd = (TextView) findViewById(R.id.pwd);
        chaKan = (Button) findViewById(R.id.chaKan);

        Intent intent = getIntent();
        String mimgZi = intent.getStringExtra("mingZi");
        String miMa = intent.getStringExtra("miMa");
        memory_pwd = intent.getBooleanExtra("memory_pwd", true);

        name.setText("你的用户名："+mimgZi);
        pwd.setText("你的密码："+miMa);



        chaKan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chaKan.setBackgroundColor(Color.BLUE);
//                myToast();


                switch (view.getId()) {
                    case R.id.chaKan:

                        if (memory_pwd) {
                            new MyToast(Main2Activity.this, "你选择的是记住密码");

                        } else {
                            new MyToast(Main2Activity.this, "你未选择记住密码");
                        }

                        break;
                }


//                // 创建 Toast 实例
//                Toast toast = new Toast(getApplicationContext());
//                // 创建自定义 view
//                View view1 = getLayoutInflater().inflate(R.layout.toast, null);
//                // 设置自定义 view
//                toast.setView(view1);
//                // 设置显示持续时间
//                toast.setDuration(Toast.LENGTH_LONG);
//                // 设置位置
//                toast.setGravity(Gravity.CENTER| Gravity.CENTER_VERTICAL, 0, 0);
//                // 显示 Toast
//                toast.show();


            }
        });

    }


    public class MyToast {

        public MyToast(Context context, String prompt) {
            Toast toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_SHORT);
            View view = View.inflate(context, R.layout.toast, null);
            TextView tvPrompt = (TextView) view.findViewById(R.id.txtMessage);
            tvPrompt.setText(prompt);
            toast.setView(view);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }


//    private void myToast() {
//        // 1.0将自定义吐司的布局文件转换成view
//        View view = View.inflate(getApplicationContext(), R.layout.toast, null);
//        // 2.0参照系统吐司写法
//        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.gravity = Gravity.TOP + Gravity.LEFT;
//        // 当指定与左边对齐时，x为到左边的距离；为右边对齐时则为到右边的距离;y同理。
//
//        params.x = 500;
//        params.y = 300;
//
//        params.format = PixelFormat.TRANSLUCENT;
//        params.type = WindowManager.LayoutParams.TYPE_TOAST;
//        params.type = WindowManager.LayoutParams.TYPE_PRIORITY_PHONE;
//        params.setTitle("Toast");
//        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
//                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//
//        // 3.0得到窗体管理类实例
//        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
//        wm.addView(view, params);
//
//
//    }


}
