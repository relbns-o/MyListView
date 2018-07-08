package com.bb.mylistview2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ContactBaseAdapter extends BaseAdapter{
    private Context context;
    private List<Contact> contacts;
    private final int CALL_CONTACTS_CODE = 1;
    private Switch aSwitch;

    public ContactBaseAdapter(Context context, List<Contact> contacts, Switch aSwitch) {
        this.context = context;
        this.contacts = contacts;
        this.aSwitch = aSwitch;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Creating view according to the state of the layout button
       if(!aSwitch.isChecked()){
           // Inflates the regular row layout and its corresponding logics (Call Action)
           View view = LayoutInflater.from(context).inflate(R.layout.row_item,null,false);
           ImageView personImage = view.findViewById(R.id.imgContactPicture);
           TextView txtName = view.findViewById(R.id.lblContactName);
           ImageButton btnDial = view.findViewById(R.id.btnCallContact);

           txtName.setText(contacts.get(position).getName());
           // Fetch contact image from url via Glide and shows unknown-default icon as a placeholder
           Glide
                   .with(context)
                   .load(contacts.get(position).getImageUrl())
                   .apply(new RequestOptions()
                           .placeholder(R.drawable.ic_person_unknown_80px)
                           .centerCrop()
                           .dontAnimate()
                           .dontTransform())
                   .into(personImage);
           btnDial.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   // Check if CALL_PHONE permission granted
                   if (ContextCompat.checkSelfPermission(context,
                           Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                       try {
                           // starts action call with the contact number
                           context.startActivity(new Intent(Intent.ACTION_CALL,
                                   Uri.parse("tel:" + contacts.get(position).getPhoneNumber())));
                       } catch(Exception e) {
                           e.printStackTrace();
                           Toast.makeText(context, "Unable to make the call", Toast.LENGTH_LONG).show();
                       }

                   } else {
                       // Request for CALL_PHONE permission
                       requestCallPhonePermission();
                   }

               }
           });
           // Toast contact contact number if image clicked
           personImage.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(context, contacts.get(position).getPhoneNumber(), Toast.LENGTH_SHORT).show();
               }
           });
           return view;

       }else{

           // Inflates the "BIG PICTURE" layout and its corresponding logics (Dial action)
           View view = LayoutInflater.from(context).inflate(R.layout.row_item2,null,false);
           ImageView personImage = view.findViewById(R.id.imgContactPicture);
           TextView txtName = view.findViewById(R.id.lblContactName);

           txtName.setText(contacts.get(position).getName());
           // Fetch contact image from url via Glide and shows unknown-default icon as a placeholder
           Glide
                   .with(context)
                   .load(contacts.get(position).getImageUrl())
                   .apply(new RequestOptions()
                           .placeholder(R.drawable.ic_person_unknown_80px)
                           .centerCrop()
                           .dontAnimate()
                           .dontTransform())
                   .into(personImage);
           personImage.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   // Check if CALL_PHONE permission granted
                   if (ContextCompat.checkSelfPermission(context,
                           Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                       try {
                           // starts action dial with the contact number
                           context.startActivity(new Intent(Intent.ACTION_DIAL,
                                   Uri.parse("tel:" + contacts.get(position).getPhoneNumber())));
                       } catch(Exception e) {
                           e.printStackTrace();
                           Toast.makeText(context, "Unable to make the call", Toast.LENGTH_LONG).show();
                       }

                   } else {
                       // Request for CALL_PHONE permission
                       requestCallPhonePermission();
                   }
               }
           });
           return view;
       }
    }

    private void requestCallPhonePermission() {
        // Checks whether the user was previously asked about this permission
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                Manifest.permission.CALL_PHONE)) {
            // Pops-up an alert dialog that explains why the app needs this permission
            new AlertDialog.Builder(context)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed to use the dial function in the app")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Asks for CALL_PHONE permission (the response-handling is performed in the callback function on the MainActivity)
                            ActivityCompat.requestPermissions((Activity) context,
                                    new String[]{Manifest.permission.CALL_PHONE}, CALL_CONTACTS_CODE);
                        }
                    })
                    // Dismiss the dialog
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        }else{
            // Asks for CALL_PHONE permission (the response-handling is performed in the callback function on the MainActivity)
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.CALL_PHONE}, CALL_CONTACTS_CODE);
        }
    }

}