/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Pessoajuridica;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author crist
 */
@Local
public interface PessoajuridicaFacadeLocal {

    void create(Pessoajuridica pessoajuridica);

    void edit(Pessoajuridica pessoajuridica);

    void remove(Pessoajuridica pessoajuridica);

    Pessoajuridica find(Object id);

    List<Pessoajuridica> findAll();

    List<Pessoajuridica> findRange(int[] range);

    int count();
    
}
