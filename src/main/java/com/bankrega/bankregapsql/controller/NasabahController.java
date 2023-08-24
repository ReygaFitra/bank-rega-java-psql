package com.bankrega.bankregapsql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bankrega.bankregapsql.model.Nasabah;
import com.bankrega.bankregapsql.services.NasabahService;

import java.util.List;

@RestController
@RequestMapping("/nasabah")
public class NasabahController {
    @Autowired
    private NasabahService nasabahService;

    @GetMapping
     public ResponseEntity<List<Nasabah>> getAllNasabah() {
        List<Nasabah> nasabahList = nasabahService.getAllNasabah();
        return new ResponseEntity<>(nasabahList, HttpStatus.OK);
    }

    @GetMapping("/{nomorKtp}")
    public ResponseEntity<Nasabah> getNasabahByNomorKtp(@PathVariable String nomorKtp) {
        Nasabah nasabah = nasabahService.getNasabahByNomorKtp(nomorKtp);
        if (nasabah != null) {
            return new ResponseEntity<>(nasabah, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Nasabah> createNasabah(@RequestBody Nasabah nasabah) {
        try {
            Nasabah createdNasabah = nasabahService.createNasabah(nasabah);
            return new ResponseEntity<>(createdNasabah, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{nomorKtp}")
    public ResponseEntity<Nasabah> updateNasabah(@PathVariable String nomorKtp, @RequestBody Nasabah nasabah) {
        try {
            nasabah.setNomorKtp(nomorKtp);
            Nasabah updatedNasabah = nasabahService.updateNasabah(nasabah);
            return new ResponseEntity<>(updatedNasabah, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{nomorKtp}")
    public ResponseEntity<Void> deleteNasabah(@PathVariable String nomorKtp) {
        try {
            nasabahService.deleteNasabah(nomorKtp);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
