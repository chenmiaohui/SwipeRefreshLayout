package swiperefreshlayout.chenmh.com.swiperefreshlayout;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * SwipeRefreshLayout实现下拉刷新
 */
public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.container_swipe);
        tv = (TextView) findViewById(R.id.content_tv);
        //设置刷新时的动画颜色
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.background_dark,
                android.R.color.holo_orange_dark
        );
        //设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        //正在刷新
        tv.setText("正在刷新,请稍后...");
        //模拟耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText("刷新完毕");
                swipeRefreshLayout.setRefreshing(false);
            }
        },5000);
    }
}
