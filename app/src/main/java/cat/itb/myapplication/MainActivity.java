package cat.itb.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button_next;
    EditText editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_next = findViewById(R.id.button_next);
        editTextUsername = findViewById(R.id.edit_text_username);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_next.setText("Logged");
                Intent next = new Intent(MainActivity.this, SecondActivity.class);
                next.putExtra("username", editTextUsername.getText().toString());
                startActivity(next);
            }
        });
    }
}