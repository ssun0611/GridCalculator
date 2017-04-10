package rlathfdl463.kr.hs.emirim.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int SELECT_EDIT1 = 0;
    public static final int SELECT_EDIT2= 1;
    int selectEdit=SELECT_EDIT1;
    Button[] butNums=new Button[10];
    Button[] butOps=new Button[4];
    String numStr="";

    EditText ed_first, ed_second;
    TextView view_result;
    int num, num2, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_first = (EditText) findViewById(R.id.ed_first);
        ed_second = (EditText) findViewById(R.id.ed_second);

        ed_first.setOnTouchListener(edHandler);
        ed_second.setOnTouchListener(edHandler);

        for (int i = 0; i < butNums.length; i++) {
            butNums[i] = (Button) findViewById(R.id.but_zero + i);
            butNums[i].setOnClickListener(numbutHandler);
        }
        for (int i = 0; i < butOps.length; i++) {
            butOps[i] = (Button) findViewById(R.id.but_plus + i);
            butOps[i].setOnClickListener(butHandler);
        }

        view_result = (TextView) findViewById(R.id.view_result);
    }


    View.OnTouchListener edHandler = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            numStr="";
            switch (v.getId()) {
                case R.id.ed_first:
                    selectEdit=SELECT_EDIT1;
                    break;
                case R.id.ed_second:
                    selectEdit=SELECT_EDIT2;
                    break;
            }
            return false;
        }
    };

    View.OnClickListener numbutHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button but=(Button)view;
            numStr+=but.getText(); // 버튼이 클릭 될 때마다 누적해서 연결

            switch (selectEdit) {

                case SELECT_EDIT1:
                    ed_first.setText(numStr);
                    break;

                case SELECT_EDIT2:
                    ed_second.setText(numStr);

            }
        }
    };

   View.OnClickListener butHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            num= Integer.parseInt(ed_first.getText().toString());
            num2 = Integer.parseInt(ed_second.getText().toString());
            int result = 0;

            switch (view.getId()) {

                case R.id.but_plus:
                    result = num + num2;
                    break;

                case R.id.but_minus:
                    result = num - num2;
                    break;

                case R.id.but_multy:
                    result = num * num2;
                    break;

                case R.id.but_div:
                    result = num / num2;
                    break;
            }
            view_result.setText(result + "");
        }
    };

}
