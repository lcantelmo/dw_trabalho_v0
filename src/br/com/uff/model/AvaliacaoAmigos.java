package br.com.uff.model;

import javax.persistence.*;

@Entity
public class AvaliacaoAmigos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Usuario avaliador;

    @OneToOne
    private Usuario avaliado;

    private Integer nota;
    private String descricao;
    private Boolean publicar;

    public AvaliacaoAmigos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Usuario avaliador) {
        this.avaliador = avaliador;
    }

    public Usuario getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(Usuario avaliado) {
        this.avaliado = avaliado;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getPublicar() {
        return publicar;
    }

    public void setPublicar(Boolean publicar) {
        this.publicar = publicar;
    }
}
