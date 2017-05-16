package br.com.uff.model;

import javax.persistence.*;

@Entity
public class Fotos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Usuario Usuario;

    private String dirFoto;

    public Fotos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public br.com.uff.model.Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(br.com.uff.model.Usuario usuario) {
        Usuario = usuario;
    }

    public String getDirFoto() {
        return dirFoto;
    }

    public void setDirFoto(String dirFoto) {
        this.dirFoto = dirFoto;
    }
}
