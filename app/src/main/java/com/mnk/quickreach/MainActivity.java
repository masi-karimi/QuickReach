package com.mnk.quickreach;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ExpandableListView;
import com.mnk.quickreach.CustomExpandableListAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private List<String> categoryList; // Contact Categories
    private HashMap<String, List<Map<String, String>>> contactsList; // Contact details under each category

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 1: Initialize ExpandableListView
        ExpandableListView expandableListView = findViewById(R.id.expandable_contact_list);

        // Step 2: Populate Categories & Contacts
        populateContacts();

        // Step 3: Set Custom Adapter for ExpandableListView
        CustomExpandableListAdapter adapter = new CustomExpandableListAdapter(this, categoryList, contactsList);
        expandableListView.setAdapter(adapter);

        // Step 4: Handle Contact Clicks for Direct Dialing
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String phoneNumber = contactsList.get(categoryList.get(groupPosition)).get(childPosition).get("Phone");
            dialContact(phoneNumber);
            return true;
        });
    }

    // Helper Method: Populate Categories & Contacts
    private void populateContacts() {
        categoryList = Arrays.asList("Hospitals", "Restaurants", "Stores"); // Define categories
        contactsList = new HashMap<>();

        // Define Contacts for Each Category
        contactsList.put("Hospitals", Arrays.asList(
                createContact("City Hospital", "+123456789", R.drawable.hospital_icon),
                createContact("Health Clinic", "+987654321", R.drawable.clinic_icon)
        ));

        contactsList.put("Restaurants", Arrays.asList(
                createContact("Italian Bistro", "+1122334455", R.drawable.restaurant_icon),
                createContact("Sushi Place", "+5566778899", R.drawable.sushi_icon)
        ));

        contactsList.put("Stores", Arrays.asList(
                createContact("SuperMart", "+2233445566", R.drawable.store_icon),
                createContact("Tech Shop", "+6677889900", R.drawable.tech_icon)
        ));
    }

    // Helper Method: Create Contact Map
    private Map<String, String> createContact(String name, String phone, int imageResource) {
        Map<String, String> contact = new HashMap<>();
        contact.put("Contact Info", name + "\n" + phone); // Stores name & phone together
        contact.put("Phone", phone); // Separate key to retrieve phone for dialing
        contact.put("Image", String.valueOf(imageResource)); // Convert image resource to string
        return contact;
    }


    // Method to Dial a Contact
    private void dialContact(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }
}