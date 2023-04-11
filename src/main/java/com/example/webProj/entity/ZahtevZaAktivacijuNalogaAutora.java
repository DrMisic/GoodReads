package com.example.webProj.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;


enum Status {
    NA_CEKANJU,
    ODOBREN,
    ODBIJEN
}

public class ZahtevZaAktivacijuNalogaAutora implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.email}")
    private String email;

    @Column
    private String telefon;

    @Column
    private String poruka;

    @Column
    private Date datum;

    @Column
    private Status status;
}
