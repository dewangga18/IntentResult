package com.dycode.edu.intentresult;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditNameActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "EXTRA_NAME";
    @BindView(R.id.edtText)
    EditText edtText;
    @BindView(R.id.btn_save)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_save)
    public void onViewClicked(){
        String name = edtText.getText().toString();
        Intent o = new Intent();
        o.putExtra(EXTRA_NAME, name);
        setResult(RESULT_OK, o);
        finish();
    }
}