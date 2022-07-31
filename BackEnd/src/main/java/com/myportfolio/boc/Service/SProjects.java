/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myportfolio.boc.Service;

import com.myportfolio.boc.Entity.Projects;
import com.myportfolio.boc.Repository.RProjects;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProjects {
    @Autowired
    RProjects rProjects;

    public List<Projects> list() {
        return rProjects.findAll();
    }

    public Optional<Projects> getOne(int id) {
        return rProjects.findById(id);
    }
    
   public Optional <Projects> getByNombreP(String nombreP){
       return rProjects.findByNombreP(nombreP);
   }
   
   public void save(Projects pro) {
       rProjects.save(pro);
   }
   
   public void delete(int id){
       rProjects.deleteById(id);
   }
   
   public boolean existsById(int id){
       return rProjects.existsById(id);
   }
   
   public boolean existsByNombreP(String nombreP){
       return rProjects.existsByNombreP(nombreP);
   }
}
