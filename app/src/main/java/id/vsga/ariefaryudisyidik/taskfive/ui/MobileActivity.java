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
import id.vsga.ariefaryudisyidik.taskfive.databinding.ActivityMobileBinding;

public class MobileActivity extends AppCompatActivity {

    private ActivityMobileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMobileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onButtonClicked();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mobile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_calculator) {
            startActivity(new Intent(this, CalculatorActivity.class));
        } else {
            startActivity(new Intent(this, ListViewActivity.class));
        }
        finish();
        return true;
    }

    private void onButtonClicked() {
        binding.btnShow.setOnClickListener(view -> {
            String name = binding.edtName.getText().toString().trim();
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        });
    }
}