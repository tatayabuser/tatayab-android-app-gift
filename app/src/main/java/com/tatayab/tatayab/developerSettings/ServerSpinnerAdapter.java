package com.tatayab.tatayab.developerSettings;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tatayab.tatayab.R;

import java.util.List;

/**
 * Created by Ahmed on 11/30/2017.
 */

public class ServerSpinnerAdapter extends ArrayAdapter<DeveoperSettingsActivity.ServerModel> {


    private Activity activity;
    private List<DeveoperSettingsActivity.ServerModel> data;
    public Resources res;
    DeveoperSettingsActivity.ServerModel tempValues = null;
    LayoutInflater inflater;

    public ServerSpinnerAdapter(Activity activitySpinner, int textViewResourceId, List<DeveoperSettingsActivity.ServerModel> objects, Resources resLocal) {
        super(activitySpinner, textViewResourceId, objects);
        this.data = objects;
        activity = activitySpinner;
        res = resLocal;

        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.item_server, parent, false);
        tempValues = null;
        tempValues = (DeveoperSettingsActivity.ServerModel) data.get(position);

        TextView txt = (TextView) row.findViewById(R.id.tv_title);
        txt.setText(tempValues.getName());
        txt.setSingleLine(true);

        return row;
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.item_server, parent, false);
        tempValues = null;
        tempValues = (DeveoperSettingsActivity.ServerModel) data.get(position);
        TextView txt = (TextView) row.findViewById(R.id.tv_title);
        txt.setText(tempValues.getName());
        txt.setSingleLine(true);

        return row;
    }

}
