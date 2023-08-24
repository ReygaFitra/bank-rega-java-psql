package com.bankrega.bankregapsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankrega.bankregapsql.model.Nasabah;

import jakarta.transaction.Transactional;

public interface NasabahRepository extends JpaRepository<Nasabah, Long> {
    
    Nasabah findOneByNomorKtp(String nomorKtp);

    @Transactional
    void deleteByNomorKtp(String nomorKtp);
}
