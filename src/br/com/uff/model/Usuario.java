package br.com.uff.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String senha;

    private String nome;

    @ManyToOne
    private Endereco endereco;

    private String numero;

    @Nullable
    private String complemento;

    @Nullable
    @Temporal(TemporalType.DATE)
    private Date data_nascimento;

    @Nullable
    private String foto_perfil;


    private String esporte_fav;

    private boolean hospedeiro;

    private Integer qnt_hospedes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getEsporte_fav() {
        return esporte_fav;
    }

    public void setEsporte_fav(String esporte_fav) {
        this.esporte_fav = esporte_fav;
    }

    public boolean isHospedeiro() {
        return hospedeiro;
    }

    public void setHospedeiro(boolean hospedeiro) {
        this.hospedeiro = hospedeiro;
    }

    public Integer getQnt_hospedes() {
        return qnt_hospedes;
    }

    public void setQnt_hospedes(Integer qnt_hospedes) {
        this.qnt_hospedes = qnt_hospedes;
    }
}
