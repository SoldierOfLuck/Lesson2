package ru.lukmanov.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends BaseActivity {
    private TextView text;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';
    private DecimalFormat decimalFormat;
    boolean flag_DOT=false;
    private char CURRENT_ACTION;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    static final String THEME="THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.##########");
        text = findViewById(R.id.textView_Result);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button button0 = findViewById(R.id.button_0);
        Button buttonC = findViewById(R.id.button_C);
        Button buttonDot = findViewById(R.id.button_point);
        Button buttonAdd = findViewById(R.id.button_plus);
        Button buttonSubtract = findViewById(R.id.button_minus);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_split);
        Button buttonEqual = findViewById(R.id.button_ravno);
        Button button_settings = findViewById(R.id.button_settings);

        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Чтобы стартовать активити, надо подготовить интент
// В данном случае это будет явный интент, поскольку здесь передаётся класс активити
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
// Метод стартует активити, указанную в интенте
                startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                text.setText("");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag_DOT==false){
                    text.setText(text.getText() + ".");
                    flag_DOT=true;
                } else text.setText(text.getText());
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                text.setText(decimalFormat.format(valueOne) + "+");
                text.setText(null);
                flag_DOT=false;
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                text.setText(decimalFormat.format(valueOne) + "-");
                text.setText(null);
                flag_DOT=false;
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                text.setText(decimalFormat.format(valueOne) + "*");
                text.setText(null);
                flag_DOT=false;
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                text.setText(decimalFormat.format(valueOne) + "/");
                text.setText(null);
                flag_DOT=false;
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                text.setText(" = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });
    }
    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(text.getText().toString());
            text.setText(null);
            switch (CURRENT_ACTION) {
                case  (ADDITION):
                    valueOne = this.valueOne + valueTwo;
                    break;
                case (SUBTRACTION):
                    valueOne = this.valueOne - valueTwo;
                    break;
                case (MULTIPLICATION):
                    valueOne = this.valueOne * valueTwo;
                    break;
                case (DIVISION):
                    valueOne = this.valueOne / valueTwo;
                    break;}
        }
        else {
            try {
                valueOne = Double.parseDouble(text.getText().toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK){
            int code=getIntent().getIntExtra(THEME, R.style.CalcStyleMain);
            setAppTheme(code);
        }
        recreate();
    }

}