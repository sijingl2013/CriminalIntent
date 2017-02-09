package sijingl.newlife.com.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sijingl on 2017-02-06.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date date;
    private boolean solved;

    public Crime() {
        mId = UUID.randomUUID();
        date = new Date();
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
}
