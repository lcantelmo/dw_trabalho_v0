package br.com.uff.model;

import javax.persistence.*;

@Entity
public class Amizade {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Usuario usuarioInvited;
    private Boolean aceito;

    public Amizade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioInvited() {
        return usuarioInvited;
    }

    public void setUsuarioInvited(Usuario usuarioInvited) {
        this.usuarioInvited = usuarioInvited;
    }

    public Boolean getAceito() {
        return aceito;
    }

    public void setAceito(Boolean aceito) {
        this.aceito = aceito;
    }
}
