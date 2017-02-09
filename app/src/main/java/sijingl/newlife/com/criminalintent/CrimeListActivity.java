package sijingl.newlife.com.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by sijingl on 2017-02-09.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
