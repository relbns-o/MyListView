package com.bb.mylistview2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private final int CALL_CONTACTS_CODE = 1;
    private ListView lstContacts;
    private List<Contact> contacts;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointer();


    }

    private void setPointer() {
        this.context = this;
        lstContacts = findViewById(R.id.lstContacts);
        aSwitch = findViewById(R.id.switchLayout);
        contacts = ContactsList.getContacts();
        final ContactBaseAdapter adapter = new ContactBaseAdapter(context, contacts, aSwitch);
        lstContacts.setAdapter(adapter);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adapter.notifyDataSetChanged();
            }
        });
    }

    // Request Permissions callback
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Checks if there is any grantResult in this request
        if (grantResults.length < 1) {
            return;
        }
        // Switch between the request codes
        switch (requestCode){
            case CALL_CONTACTS_CODE:
                /**  Checks if the first grantResults (we sent only one grant request for one permission)
                 *  is equal to thr permission-granted value and pops up toast according to the permission state
                  */
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(context, "Permission GRANTED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Permission DENIED", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
