package cn.chuangblog.canvasdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BasicView1 view1 = new BasicView1(this);
        BasicView2 view2 = new BasicView2(this);
        setContentView(view2);
    }

}
