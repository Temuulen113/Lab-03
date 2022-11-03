package mn.edu.mn.student.lab_03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private static final String ACTIVITY_1 = "activity1";

    Button activity1;
    Button activity2;
    Button activity3;
    Button activity4;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity1 = this.findViewById(R.id.activity1);
        activity1.setOnClickListener(view1 -> {
            Intent activityIntent = new Intent(MainActivity.this, MainActivity2.class);
            if (intent != null)
            {
                Bundle bundle = intent.getExtras();
                activityIntent.putExtra("name", String.valueOf(bundle.get("name")));
                activityIntent.putExtra("age", String.valueOf(bundle.get("age")));
            }
            startActivityForResult(activityIntent, 1);
        });

        activity2 = this.findViewById(R.id.activity2);
        activity2.setOnClickListener(view2 -> {
            Intent activityIntent = new Intent(MainActivity.this, MainActivity3.class);
            if (intent != null)
            {
                Bundle bundle = intent.getExtras();
                activityIntent.putExtra("date", bundle.getLong("date"));
                activityIntent.putExtra("checkBox1", bundle.getBoolean("checkBox1"));
                activityIntent.putExtra("checkBox2", bundle.getBoolean("checkBox2"));
                activityIntent.putExtra("checkBox3", bundle.getBoolean("checkBox3"));
            }
            startActivityForResult(activityIntent, 2);
        });

        activity3 = this.findViewById(R.id.activity3);
        activity3.setOnClickListener(view3 -> {
            Intent activityIntent = new Intent(MainActivity.this, MainActivity4.class);
            if (intent != null)
            {
                Bundle bundle = intent.getExtras();
                activityIntent.putExtra("hour", bundle.getInt("hour"));
                activityIntent.putExtra("minute", bundle.getInt("minute"));
                activityIntent.putExtra("male", bundle.getBoolean("male"));
                activityIntent.putExtra("female", bundle.getBoolean("female"));
            }
            startActivityForResult(activityIntent, 3);
        });

        activity4 = this.findViewById(R.id.activity4);
        activity4.setOnClickListener(view4 -> {
            Intent activityIntent = new Intent(MainActivity.this, MainActivity5.class);
            if (intent != null)
            {
                Bundle bundle = intent.getExtras();
                activityIntent.putExtra("hour1", bundle.getInt("hour1"));
                activityIntent.putExtra("minute1", bundle.getInt("minute1"));
                activityIntent.putExtra("rating", bundle.getFloat("rating"));
            }
            startActivityForResult(activityIntent, 4);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (
            (requestCode == 1 && resultCode == 11) ||
            (requestCode == 2 && resultCode == 22) ||
            (requestCode == 3 && resultCode == 33) ||
            (requestCode == 4 && resultCode == 44)
        )
        {
            intent = data;
        }
    }
}