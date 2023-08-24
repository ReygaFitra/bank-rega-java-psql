package com.bankrega.bankregapsql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Nasabah")
public class Nasabah {
    
    @Id
    @Column(name = "nomorKtp")
    private String nomorKtp;

    @Column(name = "namaLengkap")
    private String namaLengkap;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tempatLahir")
    private String tempatLahir;

    @Column(name = "tanggalLahir")
    private String tanggalLahir;

    @Column(name = "nomorHandphone")
    private String nomorHandphone;
}
