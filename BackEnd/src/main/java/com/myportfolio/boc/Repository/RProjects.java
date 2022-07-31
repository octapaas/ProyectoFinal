/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myportfolio.boc.Repository;

import com.myportfolio.boc.Entity.Projects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProjects extends JpaRepository<Projects, Integer>{
    public Optional<Projects> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP); 
}
