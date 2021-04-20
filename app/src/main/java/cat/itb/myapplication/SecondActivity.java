package cat.itb.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button buttonBack;
    TextView titleWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonBack = findViewById(R.id.button_back);
        titleWelcome = findViewById(R.id.second_activity_title);
        String username = getIntent().getExtras().getString("username");
        titleWelcome.setText("Welcome Back " + username);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(back);
            }
        });

    }
}
