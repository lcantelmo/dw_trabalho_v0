package br.com.uff.model;

import javax.persistence.*;

@Entity
public class AvaliacaoParticipantexorganizador {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private EventoEsportivo evento;

    @OneToOne
    private Usuario avaliador;

    @OneToOne
    private Usuario avaliado;

    private String descricao;
    private Integer nota;
    private Boolean publicar;

    public AvaliacaoParticipantexorganizador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EventoEsportivo getEvento() {
        return evento;
    }

    public void setEvento(EventoEsportivo evento) {
        this.evento = evento;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Boolean getPublicar() {
        return publicar;
    }

    public void setPublicar(Boolean publicar) {
        this.publicar = publicar;
    }
}
