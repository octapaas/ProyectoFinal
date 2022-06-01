/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myportfolio.boc.Interface;

import com.myportfolio.boc.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una lista de Personas
    public List<Persona> getPersona();
    
    // Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    // Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id);
    
    // Busar una persona por ID
    public Persona findPersona(Long id);
}
