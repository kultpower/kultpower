package org.kultpower.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AusgabeKey implements Serializable {

    @Column(name = "zeitschrift", nullable = false)
    private int zeitschrift;

    @Column(name = "shortname", nullable = false)
    private int shortname;

    public int getShortname() {
        return shortname;
    }

    public int getZeitschrift() {
        return zeitschrift;
    }

    public void setShortname(int shortname) {
        this.shortname = shortname;
    }

    public void setZeitschrift(int zeitschrift) {
        this.zeitschrift = zeitschrift;
    }
}