package com.example.todolist.write.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist.R;
import com.example.todolist.base.BaseActivity;
import com.example.todolist.model.Item;
import com.example.todolist.write.WriteContract;
import com.example.todolist.write.WritePresenter;

import butterknife.BindView;

public class WriteActivity
        extends BaseActivity<WriteContract.View, WriteContract.Presenter>
        implements WriteContract.View {

    @BindView(R.id.btnSave)
    Button btnSave;

    @BindView(R.id.etTitle)
    EditText etTitle;

    @BindView(R.id.etContent)
    EditText etContent;

    public WriteContract.Presenter setPresenter() {
        return new WritePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO new Item

                Item item = new Item();
                item.setTitle(getEtString(etTitle));
                item.setContent(getEtString(etContent));
//                item.setDone(true);
                // TODO save item
                mPresenter.save(item);
            }
        });
    }

    private String getEtString(EditText et) {
        return et.getText().toString();
    }

    @Override
    public void saveDone() {
        Toast.makeText(this, "Save Done", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }
}
