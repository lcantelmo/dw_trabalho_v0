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
    private Integer id

    private String email;

    private String senha;

    private String nome;

    @ManyToOne
    private Endereco endereco;

    private Integer numero;

    @Nullable
    private String complemento;

    @Nullable
    @Temporal(TemporalType.DATE)
    private Calendar data_nascimento;

    @Nullable
    private String foto_perfil;


    private String esporte_fav;

    private boolean hospedeiro;


    /*id_usuario INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    email VARCHAR(50),
    senha VARCHAR(30),
    nome VARCHAR(50),
    endereco INT,
    numero INT,
    complemento VARCHAR(50),
    data_nascimento DATE,
    foto_perfil VARCHAR(100),
    esporte_fav VARCHAR(50),
    hospedeiro BOOLEAN,
    qnt_hospedes INT,*/


}
