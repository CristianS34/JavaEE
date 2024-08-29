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
@Table(name = "pessoafisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoafisica.findAll", query = "SELECT p FROM Pessoafisica p"),
    @NamedQuery(name = "Pessoafisica.findByIdPessoaFisica", query = "SELECT p FROM Pessoafisica p WHERE p.idPessoaFisica = :idPessoaFisica"),
    @NamedQuery(name = "Pessoafisica.findByCpf", query = "SELECT p FROM Pessoafisica p WHERE p.cpf = :cpf")})
public class Pessoafisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPessoa_Fisica")
    private Integer idPessoaFisica;
    @Size(max = 11)
    @Column(name = "cpf")
    private String cpf;
    @JoinColumn(name = "idPessoa_Fk", referencedColumnName = "idPessoa")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;

    public Pessoafisica() {
    }

    public Pessoafisica(Integer idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

    public Integer getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(Integer idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        hash += (idPessoaFisica != null ? idPessoaFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoafisica)) {
            return false;
        }
        Pessoafisica other = (Pessoafisica) object;
        if ((this.idPessoaFisica == null && other.idPessoaFisica != null) || (this.idPessoaFisica != null && !this.idPessoaFisica.equals(other.idPessoaFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Pessoafisica[ idPessoaFisica=" + idPessoaFisica + " ]";
    }
    
}
