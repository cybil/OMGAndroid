package cybil.omgandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ClientActivity extends ActionBarActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ListView client_list;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        setTitle("Clients");

        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        Client client1 = new Client("Cybil Bourely", "0665203151", "7 allee du Vallon", "91620", "La Ville du Bois", false);
        Client client2 = new Client("Louis Barth", "0623275956", "37 rue de la liberte", "94400", "Villejuif", true);
        client_list = (ListView) findViewById(R.id.client_list);

        list = new ArrayList<String>();
        list.add(client1.getName() + " " + (client1.isWalter() ? "(Walter)": ""));
        list.add(client2.getName() + " " + (client2.isWalter() ? "(Walter)": ""));

        adapter = new ArrayAdapter<String>(this, R.layout.client_list_row, list);

        client_list.setAdapter(adapter);
        client_list.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_client, menu);
        return true;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent client_detail_page = new Intent(ClientActivity.this, ClientDetailActivity.class);
        Bundle b = new Bundle();
        b.putInt("key", position);
        client_detail_page.putExtras(b);
        startActivity(client_detail_page);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_button) {
            finish();
        }
    }
}
