package sijingl.newlife.com.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by sijingl on 2017-02-09.
 */

public class CrimeLab {
    private ArrayList<Crime> crimes;
    private static CrimeLab instance;
    private Context context;
    private CrimeLab(Context context) {
        this.context = context;
        crimes = new ArrayList<Crime>();
        for (int i=0; i< 100; i++) {
            Crime c = new Crime();
            c.setmTitle("Crime #" + i);
            c.setSolved( i%2 == 0);
            crimes.add(c);
        }
    }

    public static CrimeLab getInstance(Context context) {
        if (instance == null) {
            instance = new CrimeLab(context.getApplicationContext());
        }
        return instance;
    }

    public ArrayList<Crime> getCrimes() {
        return crimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c:crimes) {
            if (c.getmId().equals(id)) {
                return c;
            }
        }
        return null;
    }
}
