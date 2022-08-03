package id.vsga.ariefaryudisyidik.taskfive.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import id.vsga.ariefaryudisyidik.taskfive.R;
import id.vsga.ariefaryudisyidik.taskfive.databinding.ActivityListViewBinding;

public class ListViewActivity extends AppCompatActivity {

    private ActivityListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.listview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_mobile) {
            startActivity(new Intent(this, MobileActivity.class));
        } else {
            startActivity(new Intent(this, CalculatorActivity.class));
        }
        finish();
        return true;
    }

    private void setupListView() {
        final String[] country = getResources().getStringArray(R.array.country_list);
        binding.lvCountry.setOnItemClickListener((adapterView, view, i, l) -> Toast.makeText(this, country[i], Toast.LENGTH_SHORT).show());
    }
}