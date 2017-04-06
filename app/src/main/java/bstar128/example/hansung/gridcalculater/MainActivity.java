package bstar128.example.hansung.gridcalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Edit1, Edit2;
    TextView results;
    String num1,num2;
    Button[] butNums=new Button[10];
    Button[] but_ops=new Button[4];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<butNums.length;i++){
            butNums[i]=(Button)findViewById(R.id.but_num0+i);
            butNums[i].setOnClickListener(butNumHandler);
        }

        for(int i=0;i<but_ops.length;i++){
            but_ops[i]=(Button)findViewById(R.id.but_add+i);
            but_ops[i].setOnClickListener(butOpHandler);
        }
    }
    View.OnClickListener butNumHandler=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    View.OnClickListener butOpHandler=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
}
