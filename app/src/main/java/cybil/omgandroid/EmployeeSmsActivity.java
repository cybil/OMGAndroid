package cybil.omgandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class EmployeeSmsActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView employee_list;
    ArrayList<String> list;
    ArrayList<Partner> partner_list;
    ArrayAdapter<String> adapter;

    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_sms);
        setTitle("Envoyer un sms");

        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);


        Partner partner1 = new Partner("Julie", "INFO", "0665203151");
        Partner partner2 = new Partner("Sophia", "INFO", "0665203151");
        employee_list = (ListView) findViewById(R.id.employee_sms_list);
        partner_list = new ArrayList<Partner>();
        partner_list.add(partner1);
        partner_list.add(partner2);


        list = new ArrayList<String>();
        list.add(partner1.getName());
        list.add(partner2.getName());

        adapter = new ArrayAdapter<String>(this, R.layout.client_list_row, list);

        employee_list.setAdapter(adapter);
        employee_list.setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_employee_sms, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_button) {
            finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Partner partner = partner_list.get(position);
        Bundle bundle = getIntent().getExtras();
        String full_address = bundle.getString("address");

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(partner.getPhone(), null, full_address, null, null);
        Toast feedback = Toast.makeText(getApplicationContext(), "Infos envoyées à " + partner.getName(), Toast.LENGTH_LONG);
        feedback.show();
    }
}
