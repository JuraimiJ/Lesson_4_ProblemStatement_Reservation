package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etMobile;
    EditText etSize;

    DatePicker dp;
    TimePicker tp;

    CheckBox cbSmoke;
    CheckBox cbNonSmoke;

    Button btnConfirm;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.edit_name);
        etMobile = findViewById(R.id.edit_mobile);
        etSize = findViewById(R.id.edit_size);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cbSmoke = findViewById(R.id.cb_smoking);
        cbNonSmoke = findViewById(R.id.cb_nonsmoking);
        btnConfirm = findViewById(R.id.btn_confirm);
        btnReset = findViewById(R.id.btn_reset);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String mobile = etMobile.getText().toString();
                String size = etSize.getText().toString();

                String hour = tp.getCurrentHour().toString();
                String minute = tp.getCurrentMinute().toString();
                String time = hour + ":" + minute;

                Integer day = dp.getDayOfMonth();
                Integer month = dp.getMonth() + 1;
                Integer year = dp.getYear();
                String date = day.toString() + "/" + month.toString() + "/" + year.toString();

                if (cbSmoke.isChecked()) {

                    // Toast Setting
                    CharSequence text = "Dear " + name + "," + " your reservation for a family of " + size + " has been reserved on " + date + " at " + time + " located in the Smoking Area." ;
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(MainActivity.this, text, duration);
                    toast.show();

                }
                else {
                    CharSequence text = "Dear " + name + "," + " your reservation for a family of " + size + " has been reserved on " + date + " at " + time + " located in the Non-Smoking Area." ;
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(MainActivity.this, text, duration);
                    toast.show();
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate( 2019, 01 -1,01);
                tp.setCurrentHour(00);
                tp.setCurrentMinute(00);

                etName.setText("");
                etMobile.setText("");
                etSize.setText("");
                cbSmoke.setChecked(false);
                cbNonSmoke.setChecked(false);
            }
        });

    }
}
