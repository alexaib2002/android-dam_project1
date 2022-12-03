package com.dam.resultadosmundial.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.dam.resultadosmundial.R;
import com.dam.resultadosmundial.model.MatchResult;

public class MatchResultFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private MatchResult mParam1;

    public MatchResultFragment() {
        // Required empty public constructor
    }

    /**
     * @param matchResult The MatchResult about to be displayed.
     * @return A new instance of fragment MatchResultFragment.
     */
    public static MatchResultFragment newInstance(MatchResult matchResult) {
        MatchResultFragment fragment = new MatchResultFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, matchResult);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (MatchResult) getArguments().getSerializable(ARG_PARAM1);
            assert mParam1 != null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match_result, container, false);
        // Initialize the views
        ((TextView) view.findViewById(R.id.phaseResultFrag)).setText(mParam1.getPhase());
        ((TextView) view.findViewById(R.id.team1ResultFrag)).setText(mParam1.getTeam1());
        ((TextView) view.findViewById(R.id.team2ResultFrag)).setText(mParam1.getTeam2());
        ((TextView) view.findViewById(R.id.score1ResultFrag)).setText(String.valueOf(mParam1.getScore1()));
        ((TextView) view.findViewById(R.id.score2ResultFrag)).setText(String.valueOf(mParam1.getScore2()));
        ((TextView) view.findViewById(R.id.dateResultFrag)).setText(mParam1.getDate());
        return view;
    }
}