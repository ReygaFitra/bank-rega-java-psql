package com.bankrega.bankregapsql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankrega.bankregapsql.model.Nasabah;
import com.bankrega.bankregapsql.repository.NasabahRepository;

import java.util.List;

@Service
public class NasabahService {
    @Autowired
    private NasabahRepository nasabahRepository;

    public List<Nasabah> getAllNasabah() {
        return nasabahRepository.findAll();
    }

    public Nasabah getNasabahByNomorKtp(String nomorKtp) {
        if (nomorKtp == null) {
            System.out.println("Nasabah tidak ditemukan");
        }
        return nasabahRepository.findOneByNomorKtp(nomorKtp);
    }

    public Nasabah createNasabah(Nasabah nasabah) {
        if (nasabah.getNomorKtp() == null && nasabah.getNamaLengkap() == null && nasabah.getAlamat() == null && nasabah.getTempatLahir() == null && nasabah.getTanggalLahir() == null && nasabah.getNomorHandphone() == null) {
            System.out.println("Data tidak boleh kosong");
            
        }
        return nasabahRepository.save(nasabah);
    }

    public Nasabah updateNasabah(Nasabah nasabah) {
        if (nasabah.getNomorKtp() == null) {
            System.out.println("Nasabah tidak ditemukan");
        }
        return nasabahRepository.save(nasabah);
    }

    public void deleteNasabah(String nomorKtp) {
        Nasabah existingNasabah = nasabahRepository.findOneByNomorKtp(nomorKtp);
        if (existingNasabah == null) {
            System.out.println("Nasabah tidak ditemukan");
        }
        if (nomorKtp == null) {
            System.out.println("Nomorktp tidak boleh kosong");
        }
        nasabahRepository.deleteByNomorKtp(nomorKtp);
    }
}
