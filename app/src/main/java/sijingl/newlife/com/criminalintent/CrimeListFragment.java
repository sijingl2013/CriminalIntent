package sijingl.newlife.com.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sijingl on 2017-02-09.
 */

public class CrimeListFragment extends ListFragment {
    private static final String TAG = "CrimeListFragment";
    private static final int REQUEST_CRIME = 1;
    private ArrayList<Crime> crimes;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);

        crimes = CrimeLab.getInstance(getActivity()).getCrimes();
        ArrayAdapter<Crime> adapter = new CrimeAdapter(crimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = ((CrimeAdapter) getListAdapter()).getItem(position);
        Log.d(TAG, c.getmTitle());
        Intent i = new Intent(getActivity(), CrimeActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
//        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }

    private class CrimeAdapter extends  ArrayAdapter<Crime> {
        public CrimeAdapter(ArrayList<Crime> crimes) {
            super (getActivity(), 0, crimes);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }

            Crime c = getItem(position);
            TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getmTitle());
            TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDate().toString());
            CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());
            return convertView;
        }
    }
}
