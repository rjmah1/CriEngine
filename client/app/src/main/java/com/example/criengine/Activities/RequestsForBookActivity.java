package com.example.criengine.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.criengine.Objects.Book;
import com.example.criengine.R;
import com.example.criengine.Adapters.RequestsForBookAdapter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Requests for Book Activity. Displays all users who have requested an available book.
 * Navigation to:
 * @version  1.0
 */
public class RequestsForBookActivity extends AppCompatActivity implements Serializable {
    private RequestsForBookAdapter userListAdapter;
    private ArrayList<String> userNameList;
    private ListView userListView;
    private TextView header;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests_for_book);

        // Grabs the gears object from DisplayGearListActivity.java
        if (getIntent().getExtras() != null) {
            book = (Book) getIntent().getSerializableExtra("Book");
        } else {
            // TODO: If the intent fails to send, then redirect user to Error Screen. (in general this should not fail)
        }

        // Set the adapter.
        userListAdapter = new RequestsForBookAdapter(this, (ArrayList<String>) book.getRequesters(), book);

        userListView = findViewById(R.id.requestsListView);
        header = findViewById(R.id.requests_for_book_header);
        header.setText("Requests for \"" + book.getTitle() + "\"");

        userListView.setAdapter(userListAdapter);

        // Opens to the book information screen when you click on a specific book.
        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: redirect to view the user profile.
            }
        });
    }
}