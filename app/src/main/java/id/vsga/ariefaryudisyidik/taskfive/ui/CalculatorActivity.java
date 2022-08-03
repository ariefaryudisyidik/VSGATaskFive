package id.vsga.ariefaryudisyidik.taskfive.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import id.vsga.ariefaryudisyidik.taskfive.R;
import id.vsga.ariefaryudisyidik.taskfive.databinding.ActivityCalculatorBinding;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    String firstNumber, secondNumber;
    int result;
    private ActivityCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        buttonClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.calculator_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_mobile) {
            startActivity(new Intent(this, MobileActivity.class));
        } else {
            startActivity(new Intent(this, ListViewActivity.class));
        }
        finish();
        return true;
    }

    private void buttonClick() {
        binding.btnPlus.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnMutliply.setOnClickListener(this);
        binding.btnDivide.setOnClickListener(this);
        binding.btnClear.setOnClickListener(this);
    }

    private void fieldIsEmpty() {
        Toast.makeText(this, "Field tidak boleh kosong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        firstNumber = binding.edtFirstNumber.getText().toString().trim();
        secondNumber = binding.edtSecondNumber.getText().toString().trim();

        if (view.getId() == R.id.btn_plus) {
            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                fieldIsEmpty();
            } else {
                result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
            }
        } else if (view.getId() == R.id.btn_minus) {
            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                fieldIsEmpty();
            } else {
                result = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
            }
        } else if (view.getId() == R.id.btn_mutliply) {
            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                fieldIsEmpty();
            } else {
                result = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
            }
        } else if (view.getId() == R.id.btn_divide) {
            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                fieldIsEmpty();
            } else {
                result = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
            }
        } else {
            binding.edtFirstNumber.setText("");
            binding.edtSecondNumber.setText("");
            result = 0;
            getWindow().getDecorView().clearFocus();
        }

        binding.tvResult.setText(getString(R.string.result_value, result));
    }
}