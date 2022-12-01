package com.dam.resultadosmundial;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InsertionActivity extends TraversableActivity {

    public static final String KEY_COUNTRY_SELECTED = "CountrySelected";
    public static final String KEY_TEAM_SELECTED = "TeamSelected";
    public static final String VALUE_TEAM1_SELECTED = "Team1";
    public static final String VALUE_TEAM2_SELECTED = "Team2";

    private EditText txtEditDate;
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
        txtEditDate.setText("");
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
        txtEditDate = findViewById(R.id.txtEditDate);
        spinPhaseInsert = findViewById(R.id.spinPhaseInsert);
        txtEditTeam1Insert = findViewById(R.id.txtEditTeam1Insert);
        txtEditTeam2Insert = findViewById(R.id.txtEditTeam2Insert);
        txtEditGoalT1Insert = findViewById(R.id.txtEditGoalT1Insert);
        txtEditGoalT2Insert = findViewById(R.id.txtEditGoalT2Insert);
        btnSaveInsert = findViewById(R.id.btnSaveInsert);
        btnClearInsert = findViewById(R.id.btnClearInsert);
        btnSelectTeam1Insert = findViewById(R.id.btnSelectTeam1Insert);
        btnSelectTeam2Insert = findViewById(R.id.btnSelectTeam2Insert);
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