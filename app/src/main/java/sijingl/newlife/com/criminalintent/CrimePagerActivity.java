package sijingl.newlife.com.criminalintent;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by sijingl on 2017-02-10.
 */

public class CrimePagerActivity extends AppCompatActivity {
    private static final String TAG = "CrimePagerActivity";
    private ViewPager viewPager;
    private ArrayList<Crime> crimes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager = new ViewPager(this);
        viewPager.setId(R.id.viewPager);

        crimes = CrimeLab.getInstance(this).getCrimes();

        FragmentManager fm =  getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Log.d(TAG, "=======" + position);
                Crime crime = crimes.get(position);
                return CrimeFragment.newInstance(crime.getmId());
            }

            @Override
            public int getCount() {
                return crimes.size();
            }
        });
        setContentView(viewPager);

        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for(int i=0; i<crimes.size(); i++) {
            if (crimes.get(i).getmId().equals(crimeId)) {
                viewPager.setCurrentItem(i);
                break;
            }
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Crime crime = crimes.get(position);
                if (crime.getmTitle() != null) {
                    setTitle(crime.getmTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
