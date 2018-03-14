package com.sumit.vodhalhai;

import java.io.Serializable;

/**
 * Created by MR.Cutevil on 10/7/2017.
 */

public class ObjActivity implements Serializable {
    public String fid,sid;

    public ObjActivity(String fid, String sid) {
        this.fid = fid;
        this.sid = sid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
