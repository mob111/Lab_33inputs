package my.edu.taruc.lab_33inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremium);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_group, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Position ="+ position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

    public void calculatePremium(View view){

        int position;
        float premium = 0;
        position = spinnerAge.getSelectedItemPosition();
        switch (position){
            case 0: premium = 50;
            break;

        }

        int gender;
        gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            //TODO calculate premium of male
        }

        if(checkBoxSmoker.isChecked()){
            //TODO calculate premium of smoker
        }

        textViewPremium.setText(getString(R.string.premium)+ " " + premium);
    }
}
