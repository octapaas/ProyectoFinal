/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myportfolio.boc.Service;

import com.myportfolio.boc.Entity.Habilidades;
import com.myportfolio.boc.Repository.RHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidades {
    @Autowired
    RHabilidades rHabilidades;

    public List<Habilidades> list() {
        return rHabilidades.findAll();
    }

    public Optional<Habilidades> getOne(int id) {
        return rHabilidades.findById(id);
    }

    public Optional<Habilidades> getByNombreH(String nombreH) {
        return rHabilidades.findByNombreH(nombreH);
    }

    public void save(Habilidades Habilidad) {
        rHabilidades.save(Habilidad);
    }

    public void delete(int id) {
        rHabilidades.deleteById(id);
    }

    public boolean existsById(int id) {
        return rHabilidades.existsById(id);
    }

    public boolean existsByNombreH(String nombreH) {
        return rHabilidades.existsByNombreH(nombreH);
    }
}
