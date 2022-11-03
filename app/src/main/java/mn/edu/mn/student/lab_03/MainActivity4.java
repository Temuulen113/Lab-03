package mn.edu.mn.student.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TimePicker;

public class MainActivity4 extends AppCompatActivity {

    TimePicker timePicker;
    RadioButton radioButton1;
    RadioButton radioButton2;
    Button ok;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        timePicker = this.findViewById(R.id.timePicker);
        radioButton1= this.findViewById(R.id.radio1);
        radioButton2= this.findViewById(R.id.radio2);

        Intent intentMain = getIntent();
        if (intentMain.getExtras() != null)
        {
            Bundle bundle = intentMain.getExtras();
            if (bundle != null) {
                timePicker.setCurrentHour(bundle.getInt("hour"));
                timePicker.setCurrentMinute(bundle.getInt("minute"));
                radioButton1.setChecked(bundle.getBoolean("male"));
                radioButton2.setChecked(bundle.getBoolean("female"));
            }
        }

        ok = this.findViewById(R.id.ok_activity3);
        ok.setOnClickListener(viewOk -> {
            Intent intentCurrent = new Intent(MainActivity4.this, MainActivity.class);
            intentCurrent.putExtra("hour", timePicker.getCurrentHour());
            intentCurrent.putExtra("minute", timePicker.getCurrentMinute());
            intentCurrent.putExtra("male", radioButton1.isChecked());
            intentCurrent.putExtra("female", radioButton2.isChecked());
            setResult(33, intentCurrent);
            finish();
        });

        cancel = this.findViewById(R.id.cancel_activity3);
        cancel.setOnClickListener(viewCancel -> {
            setResult(33, intentMain);
            finish();
        });
    }
}