package com.dycode.edu.intentresult;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final int RC_EDIT_NAME = 112;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_edit)
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_edit)
    public void onViewClicked(){
        Intent i = new Intent(this, EditNameActivity.class);
        startActivityForResult(i, RC_EDIT_NAME);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_EDIT_NAME && resultCode == RESULT_OK) {
            assert data != null;
            String name = Objects.requireNonNull(data.getExtras()).getString(EditNameActivity.EXTRA_NAME);
            tvResult.setText(name);
        }
    }
}