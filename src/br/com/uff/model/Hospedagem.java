package br.com.uff.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Hospedagem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Usuario hospedeiro;

    @OneToOne
    private Usuario hospede;

    @Temporal(TemporalType.DATE)
    private Date dataInicial;

    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    public Hospedagem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getHospedeiro() {
        return hospedeiro;
    }

    public void setHospedeiro(Usuario hospedeiro) {
        this.hospedeiro = hospedeiro;
    }

    public Usuario getHospede() {
        return hospede;
    }

    public void setHospede(Usuario hospede) {
        this.hospede = hospede;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
