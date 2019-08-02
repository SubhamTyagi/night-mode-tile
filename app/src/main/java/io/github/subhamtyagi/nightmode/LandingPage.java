package io.github.subhamtyagi.nightmode;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LandingPage extends AppCompatActivity {

    RadioGroup radioGroup;
    //RadioButton day, night, auto;

    UiModeManager uiModeManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        // day = findViewById(R.id.radioDay);
        // night = findViewById(R.id.radioNight);
        // auto = findViewById(R.id.radioAuto);
        uiModeManager = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);

        switch (uiModeManager.getNightMode()) {
            case UiModeManager.MODE_NIGHT_NO:
                radioGroup.check(R.id.radioDay);
                break;
            case UiModeManager.MODE_NIGHT_YES:
                radioGroup.check(R.id.radioNight);
                break;
            case UiModeManager.MODE_NIGHT_AUTO:
                radioGroup.check(R.id.radioAuto);
                break;
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioDay:
                        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
                        break;
                    case R.id.radioNight:
                        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_YES);
                        break;
                    case R.id.radioAuto:
                        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_AUTO);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {

        }

      /*  if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            Settings Button.visibility = View.GONE;
        } else {
            settings Button.setOnClickListener {
                startActivityForResult(Intent(android.provider.Settings.ACTION_NIGHT_DISPLAY_SETTINGS), 0)
            }
        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
