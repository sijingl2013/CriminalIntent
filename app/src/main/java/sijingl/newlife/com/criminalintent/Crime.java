package sijingl.newlife.com.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sijingl on 2017-02-06.
 */

public class Crime {
    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_SOLVED = "solved";
    private static final String JSON_DATE = "date";
    private UUID mId;
    private String mTitle;
    private Date date;
    private boolean solved;

    public Crime() {
        mId = UUID.randomUUID();
        date = new Date();
    }

    public Crime(JSONObject json) throws JSONException {
        mId = UUID.fromString(json.getString(JSON_ID));
        if(json.has(JSON_TITLE)) {
            mTitle = json.getString(JSON_TITLE);
        }
        solved = json.getBoolean(JSON_SOLVED);
        date = new Date(json.getLong(JSON_DATE));
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {

        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, mId.toString());
        json.put(JSON_TITLE, mTitle);
        json.put(JSON_SOLVED, solved);
        json.put(JSON_DATE, date.getTime());
        return json;
    }
}
