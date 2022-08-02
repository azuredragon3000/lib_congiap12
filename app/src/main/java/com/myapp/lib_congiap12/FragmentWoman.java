package com.myapp.lib_congiap12;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.myapp.lib_congiap12.databinding.FragmentWomanBinding;
import com.myapp.mylibrary.DB.DatabaseNamSinh;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWoman extends Fragment {

    private DatabaseNamSinh databaseTuViManager1;
    FragmentWomanBinding binding;

    public FragmentWoman() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseTuViManager1 = ((SubApp) getActivity().getApplication()).getDatabaseNamSinh();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWomanBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        Intent intent = getActivity().getIntent();
        String tuoiId = intent.getStringExtra(ActivityNamSinh.KEY_TUOI_ID);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(databaseTuViManager1.getTuVi(tuoiId,"0").getTdName());

        binding.womanContentTxt.setText(databaseTuViManager1.getTuVi(tuoiId, "0").getIntro());

        return root;
    }

}
