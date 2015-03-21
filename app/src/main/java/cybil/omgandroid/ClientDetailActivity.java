package cybil.omgandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class ClientDetailActivity extends ActionBarActivity implements View.OnClickListener {

    TextView view_client_name;
    TextView view_client_address;
    TextView view_client_city;
    TextView view_client_phone;
    TextView view_client_walter;
    Bundle bundle;

    Button back_button;
    Button call_client_button;
    Button send_info_button;

    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);
        setTitle("Détails client");

        Client client1 = new Client("Cybil Bourely", "0665203151", "7 allee du Vallon", "91620", "La Ville du Bois", false);
        Client client2 = new Client("Louis Barth", "0665203151", "37 rue de la liberte", "94400", "Villejuif", true);
        ArrayList<Client> client_list = new ArrayList<Client>();
        client_list.add(client1);
        client_list.add(client2);

        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
        call_client_button = (Button) findViewById(R.id.call_client_button);
        call_client_button.setOnClickListener(this);
        send_info_button = (Button) findViewById(R.id.send_info_button);
        send_info_button.setOnClickListener(this);

        bundle = getIntent().getExtras();
        client = client_list.get(bundle.getInt("key"));

        view_client_name = (TextView) findViewById(R.id.client_name);
        view_client_name.setText(client.getName());
        view_client_address = (TextView) findViewById(R.id.client_address);
        view_client_address.setText(client.getAddress());
        view_client_city = (TextView) findViewById(R.id.client_city);
        view_client_city.setText(client.getFullCity());
        view_client_phone = (TextView) findViewById(R.id.client_phone);
        view_client_phone.setText(client.getPhone());
        view_client_walter = (TextView) findViewById(R.id.client_walter);
        view_client_walter.setText(client.isWalter() ? "Walter" : "");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_client_detail, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_button) {
            finish();
        }
        if (v.getId() == R.id.call_client_button) {
            Intent call = new Intent(Intent.ACTION_CALL);
            call.setData(Uri.parse("tel:" +  client.getPhone()));
            startActivity(call);
        }
        if (v.getId() == R.id.send_info_button) {
            Intent search_for_employee = new Intent(ClientDetailActivity.this, EmployeeSmsActivity.class);
            Bundle b = new Bundle();
            b.putString("address", client.getFullAddress());
            search_for_employee.putExtras(b);
            startActivity(search_for_employee);

//            Intent sms = new Intent(Intent.ACTION_VIEW);
//            sms.putExtra("sms body", "content");
//            sms.setType("vnd.android-dir/mms-sms");
//            startActivity(sms);
        }
    }
}
