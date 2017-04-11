package bstar128.example.hansung.gridcalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Edit1, Edit2;
    TextView results;
    Button[] butNums=new Button[10];
    Button[] but_ops=new Button[4];
    public static final int SELEECT_EDIT1=0;
    public static final int SELEECT_EDIT2=1;
    int selectEdit=SELEECT_EDIT1;
    String numStr="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edit1=(EditText)findViewById(R.id.edit1) ;
        Edit2=(EditText)findViewById(R.id.edit2) ;
        Edit1.setOnTouchListener(editHandler);
        Edit2.setOnTouchListener(editHandler);
        results=(TextView)findViewById(R.id.result);

        for (int i=0;i<butNums.length;i++){
            butNums[i]=(Button)findViewById(R.id.but_num0+i);
            butNums[i].setOnClickListener(butNumHandler);
        }

        for(int i=0;i<but_ops.length;i++){
            but_ops[i]=(Button)findViewById(R.id.but_add0+i);
            but_ops[i].setOnClickListener(butOpHandler);
        }
    }
    View.OnClickListener butNumHandler=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button but=(Button) view;
            numStr+=but.getText();
            switch (selectEdit) {
                case SELEECT_EDIT1:
                    Edit1.setText(numStr+"");
                    break;
                case SELEECT_EDIT2:
                    Edit2.setText(numStr+"");
                    break;
            }
        }
    };
    View.OnClickListener butOpHandler=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int num1 = Integer.parseInt(Edit1.getText().toString().trim());
            int num2 = Integer.parseInt(Edit2.getText().toString().trim());
            String opStr="";
            double result=0;
            switch(((Button)view).getText().toString()){
                case "+":
                    result=num1+num2;
                    break;
                case "-":
                    result=num1-num2;
                    break;
                case "×":
                    result=num1*num2;
                    break;
                case "÷":
                    result=(double)num1/num2;
                    break;
            }
            results.setText(result+"");
        }
    };

    View.OnTouchListener editHandler=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            numStr=" ";
            switch (v.getId()){
                case R.id.edit1:
                    selectEdit=SELEECT_EDIT1;
                    break;
                case R.id.edit2:
                    selectEdit=SELEECT_EDIT2;
                    break;
            }
            return false;
        }
    };

}
