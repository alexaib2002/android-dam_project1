package com.dam.resultadosmundial;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SelectionActivity extends TraversableActivity {

    public static final int RESULT_CANCELLED = 0;
    public static final int RESULT_ACCEPTED = 1;

    private ConstraintLayout rootSelect;
    private Flow flowCountryListSelect;
    private EditText txtEditCountrySelect;
    private Button btnAcceptSelect;
    private Button btnCancelSelect;

    public SelectionActivity() {
        super(R.layout.activity_selection);
    }

    @Override
    protected void initActivityLayout() {
        rootSelect = findViewById(R.id.rootSelect);
        flowCountryListSelect = findViewById(R.id.flowCountryListSelect);
        txtEditCountrySelect = findViewById(R.id.txtEditCountrySelect);
        btnAcceptSelect = findViewById(R.id.btnAcceptSelect);
        btnCancelSelect = findViewById(R.id.btnCancelSelect);
        // append teams to flow layout
        int i = 0;
        for (String teamName:
             getResources().getStringArray(R.array.enum_team_names)) {
            Button btnTeam = new Button(this);
            btnTeam.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            btnTeam.setText(teamName);
            btnTeam.setId(View.generateViewId());
            // make btnTeam borderless style
            btnTeam.setBackgroundResource(android.R.color.transparent);
            btnTeam.setOnClickListener(v -> txtEditCountrySelect.setText(teamName));
            rootSelect.addView(btnTeam, 0);
            flowCountryListSelect.addView(btnTeam);
        }
    }

    @Override
    protected void initListeners() {
        btnAcceptSelect.setOnClickListener(v -> {
            getIntent().putExtra(InsertionActivity.KEY_TEAM_SELECTED,
                    getIntent().getStringExtra(InsertionActivity.KEY_TEAM_SELECTED));
            getIntent().putExtra(InsertionActivity.KEY_COUNTRY_SELECTED,
                    txtEditCountrySelect.getText().toString());
            setResult(RESULT_ACCEPTED, this.getIntent());
            finish();
        });
        btnCancelSelect.setOnClickListener(v -> {
            setResult(RESULT_CANCELLED, this.getIntent());
            finish();
        });
    }
}