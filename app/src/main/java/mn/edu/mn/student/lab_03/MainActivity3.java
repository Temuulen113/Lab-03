package mn.edu.mn.student.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity3 extends AppCompatActivity {

    private static final String LOG_TAG = "labEvent ";

    CalendarView calendar;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    Button ok;
    Button cancel;

    long date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intentMain = getIntent();

        calendar = this.findViewById(R.id.calendar);
        checkBox1 = this.findViewById(R.id.checkbox1);
        checkBox2 = this.findViewById(R.id.checkbox2);
        checkBox3 = this.findViewById(R.id.checkbox3);

        calendar.setOnDateChangeListener((view, year, month, day) -> date = new GregorianCalendar(year, month, day).getTimeInMillis());

        if (intentMain.getExtras() != null)
        {
            Bundle bundle = intentMain.getExtras();
            if (bundle.getLong("date") != 0) {
                long date = bundle.getLong("date");
                calendar.setDate(date, true, true);
                checkBox1.setChecked(bundle.getBoolean("checkBox1"));
                checkBox2.setChecked(bundle.getBoolean("checkBox2"));
                checkBox3.setChecked(bundle.getBoolean("checkBox3"));
            }
        }

        ok = this.findViewById(R.id.ok_activity2);
        ok.setOnClickListener(viewOk -> {
            Intent intentCurrent = new Intent(MainActivity3.this, MainActivity.class);
            intentCurrent.putExtra("date", date);
            intentCurrent.putExtra("checkBox1", checkBox1.isChecked());
            intentCurrent.putExtra("checkBox2", checkBox2.isChecked());
            intentCurrent.putExtra("checkBox3", checkBox3.isChecked());
            setResult(22, intentCurrent);
            finish();
        });

        cancel = this.findViewById(R.id.cancel_activity2);
        cancel.setOnClickListener(viewCancel -> {
            setResult(22, intentMain);
            finish();
        });
    }
}