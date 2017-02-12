package sijingl.newlife.com.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.Exchanger;

/**
 * Created by sijingl on 2017-02-09.
 */

public class CrimeLab {
    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crimes.json";
    private ArrayList<Crime> crimes;
    private static CrimeLab instance;
    private Context context;
    private CriminalIntentJSONSerializer serializer;
    private CrimeLab(Context context) {
        this.context = context;
        crimes = new ArrayList<Crime>();
//        for (int i=0; i< 100; i++) {
//            Crime c = new Crime();
//            c.setmTitle("Crime #" + i);
//            c.setSolved( i%2 == 0);
//            crimes.add(c);
//        }
        serializer = new CriminalIntentJSONSerializer(context, FILENAME);
        try {
            crimes = serializer.loadCrimes();

        } catch (Exception e) {
            Log.e(TAG, "Error loading crimes:", e);
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


    public void addCrime(Crime c) {
        crimes.add(c);
    }
    public boolean saveCrimes() {
        try {
            serializer.saveCrimes(crimes);
            Log.d(TAG, "crimes saved to file");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error saving crimes:", e);
            return false;
        }
    }

    public void deleteCrime(Crime c) {
        crimes.remove(c);
    }
}
