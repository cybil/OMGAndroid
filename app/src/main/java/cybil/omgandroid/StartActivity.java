package cybil.omgandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class StartActivity extends ActionBarActivity implements View.OnClickListener {

    private String password = "0000";
    private Button button_send_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        setTitle("Lis Service");
        button_send_password = (Button) findViewById(R.id.send_password_button);
        button_send_password.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        String sent_password = (((EditText) findViewById(R.id.password_field)).getText().toString());
        if (sent_password.equals(this.password)) {
            Toast response = Toast.makeText(getApplicationContext(), "Vous êtes connecté.", Toast.LENGTH_SHORT);
            response.show();
            Intent main_menu_page = new Intent(StartActivity.this, MainMenuActivity.class);
            startActivity(main_menu_page);
            finish();
        }
    }
}
