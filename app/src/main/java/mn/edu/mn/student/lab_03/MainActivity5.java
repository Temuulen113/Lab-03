package mn.edu.mn.student.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TimePicker;

public class MainActivity5 extends AppCompatActivity {

    RatingBar ratingBar;
    TimePicker timePicker;
    Button ok;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ratingBar = this.findViewById(R.id.ratingBar);
        timePicker = this.findViewById(R.id.timePickerAct4);

        Intent intentMain = getIntent();
        if (intentMain.getExtras() != null)
        {
            Bundle bundle = intentMain.getExtras();
            if (bundle != null) {
                timePicker.setCurrentHour(bundle.getInt("hour1"));
                timePicker.setCurrentMinute(bundle.getInt("minute1"));
                ratingBar.setRating(bundle.getFloat("rating"));
            }
        }

        ok = this.findViewById(R.id.ok_activity4);
        ok.setOnClickListener(viewOk -> {
            Intent intentCurrent = new Intent(MainActivity5.this, MainActivity.class);
            intentCurrent.putExtra("hour1", timePicker.getCurrentHour());
            intentCurrent.putExtra("minute1", timePicker.getCurrentMinute());
            intentCurrent.putExtra("rating", ratingBar.getRating());
            setResult(44, intentCurrent);
            finish();
        });

        cancel = this.findViewById(R.id.cancel_activity4);
        cancel.setOnClickListener(viewCancel -> {
            setResult(44, intentMain);
            finish();
        });
    }
}