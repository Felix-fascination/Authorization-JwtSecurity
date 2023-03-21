package ru.cgpb.securityappauth.models;

import java.io.Serializable;


public class Otdels implements Serializable {
    String V40V;
    String OTDEL;

    public Otdels(String V40V, String OTDEL) {
        this.V40V = V40V;
        this.OTDEL = OTDEL;
    }

    public String getV40V() {
        return V40V;
    }

    public void setV40V(String v40V) {
        V40V = v40V;
    }

    public String getOTDEL() {
        return OTDEL;
    }

    public void setOTDEL(String OTDEL) {
        this.OTDEL = OTDEL;
    }
}
