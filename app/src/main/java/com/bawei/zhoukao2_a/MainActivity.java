package com.bawei.zhoukao2_a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText mingZi;
    private EditText miMa;
    private Button dengLu;
    private CheckBox memory_pwd;

    /*
    B、登录界面布局完成（50分）
	不符合项扣分细则：用户名不能输入-5分，密码不能输入-5分，记住密码-5分
	自动登录-5分，我已阅读并同意服务条款-10分；
    C、点击登录跳转到的界面不能点击弹出自定义位置吐司扣15分
    D、跳转和传值不成功扣25分
    E、查看是否记住密码，点击背景颜色变化，背景颜色不变扣5分

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mingZi = (EditText) findViewById(R.id.mingZi);
        miMa = (EditText) findViewById(R.id.miMa);
        dengLu = (Button) findViewById(R.id.dengLu);
        memory_pwd = (CheckBox) findViewById(R.id.memory_pwd);


        dengLu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameString = mingZi.getText().toString().trim();
                if (TextUtils.isEmpty(nameString)) {
                    Toast.makeText(MainActivity.this, "账号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                String pwdString = miMa.getText().toString().trim();
                if (TextUtils.isEmpty(pwdString)) {
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                intent.putExtra("mingZi", nameString);
                intent.putExtra("miMa", pwdString);
                intent.putExtra("memory_pwd", memory_pwd.isChecked());

                startActivity(intent);

            }
        });

    }
}
