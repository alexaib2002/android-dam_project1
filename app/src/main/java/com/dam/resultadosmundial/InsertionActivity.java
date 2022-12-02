package com.dam.resultadosmundial;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class InsertionActivity extends TraversableActivity {

    public static final String KEY_COUNTRY_SELECTED = "CountrySelected";
    public static final String KEY_TEAM_SELECTED = "TeamSelected";
    public static final String VALUE_TEAM1_SELECTED = "Team1";
    public static final String VALUE_TEAM2_SELECTED = "Team2";

    private EditText txtEditDateInsert;
    private EditText txtEditTimeInsert;
    private Spinner spinPhaseInsert;
    private EditText txtEditTeam1Insert;
    private EditText txtEditTeam2Insert;
    private EditText txtEditGoalT1Insert;
    private EditText txtEditGoalT2Insert;
    private Button btnSelectTeam1Insert;
    private Button btnSelectTeam2Insert;
    private Button btnSaveInsert;
    private Button btnClearInsert;

    private View.OnClickListener btnClearInsertListener = v -> {
        txtEditDateInsert.setText("");
        txtEditTimeInsert.setText("");
        spinPhaseInsert.setSelection(0);
        txtEditTeam1Insert.setText("");
        txtEditTeam2Insert.setText("");
        txtEditGoalT1Insert.setText("");
        txtEditGoalT2Insert.setText("");
    };

    private ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == SelectionActivity.RESULT_ACCEPTED) {
                    assert result.getData() != null;
                    if (result.getData().getStringExtra(KEY_TEAM_SELECTED)
                            .equals(VALUE_TEAM1_SELECTED)) {
                        txtEditTeam1Insert.setText(result.getData()
                                .getStringExtra(InsertionActivity.KEY_COUNTRY_SELECTED));
                    } else if (result.getData().getStringExtra(KEY_TEAM_SELECTED)
                            .equals(VALUE_TEAM2_SELECTED)) {
                        txtEditTeam2Insert.setText(result.getData()
                                .getStringExtra(InsertionActivity.KEY_COUNTRY_SELECTED));
                    }
                }
            });

    public InsertionActivity() {
        super(R.layout.activity_insertion);
    }

    @Override
    protected void initActivityLayout() {
        txtEditDateInsert = findViewById(R.id.txtEditDateInsert);
        txtEditTimeInsert = findViewById(R.id.txtEditTimeInsert);
        spinPhaseInsert = findViewById(R.id.spinPhaseInsert);
        txtEditTeam1Insert = findViewById(R.id.txtEditTeam1Insert);
        txtEditTeam2Insert = findViewById(R.id.txtEditTeam2Insert);
        txtEditGoalT1Insert = findViewById(R.id.txtEditGoalT1Insert);
        txtEditGoalT2Insert = findViewById(R.id.txtEditGoalT2Insert);
        btnSaveInsert = findViewById(R.id.btnSaveInsert);
        btnClearInsert = findViewById(R.id.btnClearInsert);
        btnSelectTeam1Insert = findViewById(R.id.btnSelectTeam1Insert);
        btnSelectTeam2Insert = findViewById(R.id.btnSelectTeam2Insert);
        // initialize pickers
        DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            txtEditDateInsert.setText(date);
        };
        txtEditDateInsert.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,
                    2021, 0, 1);
            datePickerDialog.show();
        });
        TimePickerDialog.OnTimeSetListener timeSetListener = (view, hourOfDay, minute) -> {
            String time = hourOfDay + ":" + minute;
            txtEditTimeInsert.setText(time);
        };
        txtEditTimeInsert.setOnClickListener(v -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeSetListener,
                    0, 0, true);
            timePickerDialog.show();
        });
    }

    @Override
    protected void initListeners() {
        btnSelectTeam1Insert.setOnClickListener(v -> {
            Intent intent = new Intent(this, SelectionActivity.class);
            intent.putExtra(InsertionActivity.KEY_TEAM_SELECTED, VALUE_TEAM1_SELECTED);
            resultLauncher.launch(intent);
        });
        btnSelectTeam2Insert.setOnClickListener(v -> {
            Intent intent = new Intent(this, SelectionActivity.class);
            intent.putExtra(InsertionActivity.KEY_TEAM_SELECTED, VALUE_TEAM2_SELECTED);
            resultLauncher.launch(intent);
        });
        btnSaveInsert.setOnClickListener(v -> {
            System.err.println("Saving not implemented");
            btnClearInsertListener.onClick(v);
        });
        btnClearInsert.setOnClickListener(btnClearInsertListener);
    }
}