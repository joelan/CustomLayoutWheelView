package cn.crazyjoe.customlayoutwheelview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;


import cn.crazyjoe.customlayoutwheelview.wheel.WheelView;

public class MainActivity extends AppCompatActivity {


    WheelView wheelrView;

    List<databean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheelrView=findViewById(R.id.wv2);
        list=new ArrayList<>();
        list.add(new databean("1砸"));
        list.add(new databean("10砸"));
        list.add(new databean("50砸"));
        wheelrView.setAdapter(new ViewAdapter(R.layout.wheelview_item,list));

       // wheelrView.setTheAdapter(adapter);
        wheelrView.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                Toast.makeText(MainActivity.this, list.get(index).datastr, Toast.LENGTH_SHORT).show();
            }
        });
        wheelrView.postDelayed(new Runnable() {
            @Override
            public void run() {

                wheelrView.scrollToposition(3);
            }
        },200);



    }


 public   static class   databean{

        String datastr;

        public String getDatastr() {
            return datastr;
        }

        public void setDatastr(String datastr) {
            this.datastr = datastr;
        }

        public databean(String datastr) {
            this.datastr = datastr;
        }
    }

   public class  ViewAdapter  extends BaseQuickAdapter<databean,BaseViewHolder>
    {


        public ViewAdapter(int layoutResId, @Nullable List<databean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, databean item) {


            helper.setText(R.id.number,item.getDatastr());
        }
    }

}
