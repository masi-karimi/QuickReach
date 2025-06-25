package com.mnk.quickreach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final List<String> groupList;
    private final Map<String, List<Map<String, String>>> childData;

    public CustomExpandableListAdapter(Context context, List<String> groupList, Map<String, List<Map<String, String>>> childData) {
        this.context = context;
        this.groupList = groupList;
        this.childData = childData;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData.get(groupList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData.get(groupList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = groupList.get(groupPosition);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.group_item, parent, false);
        }

        TextView groupName = convertView.findViewById(R.id.group_name);
        groupName.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Map<String, String> contact = childData.get(groupList.get(groupPosition)).get(childPosition);
        String info = contact.get("Contact Info");
        int imageResId = Integer.parseInt(contact.get("Image"));

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.child_item, parent, false);
        }

        TextView contactText = convertView.findViewById(R.id.contact_info);
        ImageView contactImage = convertView.findViewById(R.id.contact_image);

        contactText.setText(info);
        contactImage.setImageResource(imageResId);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}