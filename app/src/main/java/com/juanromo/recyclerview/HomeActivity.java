package com.juanromo.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements ItemAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView items = (RecyclerView) findViewById(R.id.items);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        items.setLayoutManager(layoutManager);

        DividerItemDecoration divider =
                new DividerItemDecoration(items.getContext(), layoutManager.getOrientation());
        items.addItemDecoration(divider);

        ItemAdapter adapter = new ItemAdapter(Data.getData(), this);
        items.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Item item) {
        Toast.makeText(this, "Item " + item.getId() + " clicked", Toast.LENGTH_SHORT)
                .show();
    }
}
