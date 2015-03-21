package cybil.omgandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainMenuActivity extends ActionBarActivity implements View.OnClickListener {

    private Button button_et_client;
    private Button button_et_employee;
    private Button button_client;
    private Button button_employee;
    private Button button_provider;
    private Button button_param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        setTitle("Lis Service");
        button_et_client = (Button) findViewById(R.id.et_client_button);
        button_et_employee = (Button) findViewById(R.id.et_employee_button);
        button_client = (Button) findViewById(R.id.client_button);
        button_employee = (Button) findViewById(R.id.employee_button);
        button_provider = (Button) findViewById(R.id.provider_button);
        button_param = (Button) findViewById(R.id.param_button);

        button_et_client.setOnClickListener(this);
        button_et_employee.setOnClickListener(this);
        button_client.setOnClickListener(this);
        button_employee.setOnClickListener(this);
        button_provider.setOnClickListener(this);
        button_param.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.et_client_button) {
        }
        if (v.getId() == R.id.et_employee_button) {
        }
        if (v.getId() == R.id.client_button) {
            Toast response = Toast.makeText(getApplicationContext(), "CLIENTS", Toast.LENGTH_LONG);
            response.show();
            Intent client_list_page = new Intent(MainMenuActivity.this, ClientActivity.class);
            startActivity(client_list_page);
        }
        if (v.getId() == R.id.employee_button) {
        }
        if (v.getId() == R.id.provider_button) {
        }
        if (v.getId() == R.id.param_button) {
        }
    }
}
