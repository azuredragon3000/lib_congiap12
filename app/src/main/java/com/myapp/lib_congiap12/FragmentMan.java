package com.myapp.lib_congiap12;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.myapp.lib_congiap12.databinding.FragmentManBinding;
import com.myapp.mylibrary.DB.DatabaseNamSinh;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMan extends Fragment {

    private DatabaseNamSinh databaseTuViManager1;

    FragmentManBinding binding;

    public FragmentMan() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseTuViManager1 =  ((SubApp) getActivity().getApplication()).getDatabaseNamSinh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentManBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Intent intent = getActivity().getIntent();
        String tuoiId = intent.getStringExtra(ActivityNamSinh.KEY_TUOI_ID);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(databaseTuViManager1.getTuVi(tuoiId,"1").getTdName());

        binding.manContentTxt.setText(databaseTuViManager1.getTuVi(tuoiId, "1").getIntro());

        return root;
    }

}
