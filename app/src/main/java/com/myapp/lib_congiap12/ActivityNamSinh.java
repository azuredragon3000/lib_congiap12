package com.myapp.lib_congiap12;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.lib_congiap12.databinding.ActivityNamsinhBinding;
import com.myapp.mylibrary.DB.DatabaseNamSinh;


public class ActivityNamSinh extends AppCompatActivity implements View.OnClickListener {

    private DatabaseNamSinh databaseTuViManager1;
    private String id;
    public static final String KEY_TUOI_ID = "key_tuoi_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNamsinhBinding binding = ActivityNamsinhBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        databaseTuViManager1 = ((SubApp) getApplication()).getDatabaseNamSinh();
        Intent intent = getIntent();

        id = intent.getStringExtra(ActivityNamSinhMain.KEY_CONGIAP);
        String title = intent.getStringExtra(ActivityNamSinhMain.KEY_CONGIAP_NAME);

        actionBar.setTitle("Tu Vi " + title);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        binding.rclView.setLayoutManager(manager);
        AdapterNamSinh adapter = new AdapterNamSinh(this, databaseTuViManager1.getNamSinh(id), this);
        binding.rclView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        int pos = (int) v.getTag();
        if (v.getId() == R.id.nam_sinh_layout) {
            Intent intent = new Intent(this, ActivityNamSinhDetail.class);
            intent.putExtra(KEY_TUOI_ID, databaseTuViManager1.getNamSinh(id).get(pos).getIdTuoi());
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
