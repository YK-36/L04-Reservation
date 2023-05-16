package sg.edu.rp.c346.id22015127.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText mobile;
    EditText groupSize;
    RadioGroup area;
    TimePicker resTime;
    DatePicker resDate;
    CheckBox confirm;
    Button submit;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobNo);
        groupSize = findViewById(R.id.grp);
        area = findViewById(R.id.area);
        resDate = findViewById(R.id.datePicker);
        resTime = findViewById(R.id.timePicker);
        confirm = findViewById(R.id.cnfCB);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        resDate.updateDate(2023,5,1);
        resTime.setCurrentMinute(30);
        resTime.setCurrentHour(19);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resName = name.getText().toString();
                String mobNo = mobile.getText().toString();
                String grp = groupSize.getText().toString();
                int rbArea = area.getCheckedRadioButtonId();
                int day = resDate.getDayOfMonth();
                int month = resDate.getMonth()+1;
                int year = resDate.getYear();
                int hour = resTime.getCurrentHour();
                int min = resTime.getCurrentMinute();
                String date = String.format("%02d/%02d/%02d", day, month, year);
                String time = String.format("%02d:%02d", hour, min);
                String smoke = "";
                if (rbArea == R.id.nonSmoke){
                    smoke = "non-smoking area";
                }else {
                    smoke = "smoking area";
                }

                if(confirm.isChecked()==true){
                    String reserve = "Reservation for "+resName+"(Mobile Number: "+mobNo+") with a group of "+grp+" for a "+smoke+" has been confirmed on "+date+" at "+time;
                    Toast.makeText(MainActivity.this, reserve, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Please Confirm Reservation Before Submitting", Toast.LENGTH_SHORT).show();
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resDate.updateDate(2023,5,1);
                resTime.setCurrentMinute(30);
                resTime.setCurrentHour(19);
                name.getText().clear();
                mobile.getText().clear();
                groupSize.getText().clear();
                area.clearCheck();
                confirm.setChecked(false);
            }
        });

    }
}