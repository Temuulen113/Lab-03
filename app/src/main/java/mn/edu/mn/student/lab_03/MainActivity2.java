package mn.edu.mn.student.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private final String LOG_TAG = "labEvent ";

    EditText name;
    EditText age;
    Button ok;
    Button cancel;

    Intent intentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intentMain = getIntent();

        name = this.findViewById(R.id.name);
        age = this.findViewById(R.id.age);

        if (intentMain.getExtras() != null)
        {
            Bundle bundle = intentMain.getExtras();
            if (bundle.getString("name") != null) {
                name.setText(String.valueOf(bundle.get("name")));
                age.setText(String.valueOf(bundle.get("age")));
            }
        }

        ok = this.findViewById(R.id.ok_activity1);
        ok.setOnClickListener(viewOk -> {
            if (!TextUtils.isEmpty(name.getText()) && !TextUtils.isEmpty(age.getText())) {
                Intent intentCurrent = new Intent(MainActivity2.this, MainActivity.class);
                intentCurrent.putExtra("name", name.getText());
                intentCurrent.putExtra("age", Integer.parseInt(String.valueOf(age.getText())));
                setResult(11, intentCurrent);
                finish();
            } else {
                Log.e(LOG_TAG, "Invalid input");
            }
        });

        cancel = this.findViewById(R.id.cancel_activity1);
        cancel.setOnClickListener(viewCancel -> {
            setResult(11, intentMain);
            finish();
        });
    }
}