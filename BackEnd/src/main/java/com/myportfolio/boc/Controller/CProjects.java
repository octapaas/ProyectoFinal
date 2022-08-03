/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myportfolio.boc.Controller;

import com.myportfolio.boc.Dto.dtoProjects;
import com.myportfolio.boc.Entity.Projects;
import com.myportfolio.boc.Security.Controller.Mensaje;
import com.myportfolio.boc.Service.SProjects;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proURL/")
@CrossOrigin(origins = "https://bocback.herokuapp.com/proURL/")
public class CProjects {

    @Autowired
    SProjects sProjects;

    @GetMapping("/lista")
    public ResponseEntity<List< Projects>> list() {
        List<Projects> list = sProjects.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProjects dtop) {
        if (StringUtils.isBlank(dtop.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProjects.existsByNombreP(dtop.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Projects projects = new Projects(dtop.getNombreP(), dtop.getDescripcionP(), dtop.getImgP());
        sProjects.save(projects);

        return new ResponseEntity(new Mensaje("Proyecto agregado!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProjects dtop) {
        //validamos ID
        if (!sProjects.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //compara nombres de experiencias
        if (sProjects.existsByNombreP(dtop.getNombreP()) && sProjects.getByNombreP(dtop.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        // no puede estar vacio
        if (StringUtils.isBlank(dtop.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Projects projects = sProjects.getOne(id).get();
        projects.setNombreP(dtop.getNombreP());
        projects.setDescripcionP(dtop.getDescripcionP());

        sProjects.save(projects);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProjects.existsById(id)) {
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        sProjects.delete(id);
        return new ResponseEntity(new Mensaje("Producto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Projects> getById(@PathVariable("id") int id) {
        if (!sProjects.existsById(id)) {
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        Projects projects = sProjects.getOne(id).get();
        return new ResponseEntity(projects, HttpStatus.OK);
    }
}
