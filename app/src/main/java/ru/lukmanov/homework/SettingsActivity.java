package ru.lukmanov.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.CalcStyleMain));
        setContentView(R.layout.activity_settings);
        initThemeChooser();
        Button button_back = findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Метод finish() завершает активити
                finish();
            }
        });
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMainStyle), CalcStyleMain);
        initRadioButton(findViewById(R.id.radioButtonMaterialDark), AppThemeDarkCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLight), AppThemeLightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLightDarkAction), AppThemeCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(CalcStyleMain))).setChecked(true);
    }

    public void initRadioButton(View button, final int codeStyle){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// сохраним настройки
                Intent intentResult = new Intent();
                intentResult.putExtra(MainActivity.THEME, codeStyle);
                setResult(RESULT_OK, intentResult);
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }
}