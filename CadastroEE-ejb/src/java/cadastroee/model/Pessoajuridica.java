/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author crist
 */
@Entity
@Table(name = "pessoajuridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoajuridica.findAll", query = "SELECT p FROM Pessoajuridica p"),
    @NamedQuery(name = "Pessoajuridica.findByIdPessoaJuridica", query = "SELECT p FROM Pessoajuridica p WHERE p.idPessoaJuridica = :idPessoaJuridica"),
    @NamedQuery(name = "Pessoajuridica.findByCnpj", query = "SELECT p FROM Pessoajuridica p WHERE p.cnpj = :cnpj")})
public class Pessoajuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPessoa_Juridica")
    private Integer idPessoaJuridica;
    @Size(max = 14)
    @Column(name = "cnpj")
    private String cnpj;
    @JoinColumn(name = "idPessoa_Fk", referencedColumnName = "idPessoa")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;

    public Pessoajuridica() {
    }

    public Pessoajuridica(Integer idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public Integer getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(Integer idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoaJuridica != null ? idPessoaJuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoajuridica)) {
            return false;
        }
        Pessoajuridica other = (Pessoajuridica) object;
        if ((this.idPessoaJuridica == null && other.idPessoaJuridica != null) || (this.idPessoaJuridica != null && !this.idPessoaJuridica.equals(other.idPessoaJuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Pessoajuridica[ idPessoaJuridica=" + idPessoaJuridica + " ]";
    }
    
}
