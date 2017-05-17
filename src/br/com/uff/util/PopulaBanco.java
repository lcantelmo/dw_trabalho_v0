package br.com.uff.util;

import br.com.uff.model.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PopulaBanco {

    public static void main(String[] args) throws ParseException {

         /*
            Abrindo conexão com o banco. Chamamos o EntityManager que vai cuidar das transações com o banco.
            Lembrando, criar o BANCO DE DADOS chamado "sistema_aeroporto_dw"
         */
        EntityManager manager = new JPAUtil().getEntityManager();

        /*
            Estado Managed: Dados estão sincronizados com o banco. Esse é o objetivo.
            Estado Transient: Os dados ainda não estão no banco
            Estado Detached: Já existem dados no banco, mas os dados da entidade estão desatualizados. Para resolver, precisamos fazer um Merge.
         */

        try {
            EntityTransaction transaction = manager.getTransaction();

            transaction.begin();

            Endereco endereco1 = new Endereco();
            endereco1.setId(1);
            endereco1.setCep(24220008);
            endereco1.setRua("Miguel de Frias");
            endereco1.setBairro("Icaraí");
            endereco1.setCidade("Niterói");
            endereco1.setEstado("RJ");
            endereco1.setPais("Brasil");
            manager.merge(endereco1);

            Endereco endereco2 = new Endereco();
            endereco2.setId(2);
            endereco2.setCep(24325100);
            endereco2.setRua("Rua Pendotiba");
            endereco2.setBairro("Maria Paula");
            endereco2.setCidade("Niterói");
            endereco2.setEstado("RJ");
            endereco2.setPais("Brasil");
            manager.merge(endereco2);

            Endereco endereco3 = new Endereco();
            endereco3.setId(3);
            endereco3.setCep(20271110);
            endereco3.setRua("Avenida Maracanã");
            endereco3.setBairro("Maracanã");
            endereco3.setCidade("Rio de Janeiro");
            endereco3.setEstado("RJ");
            endereco3.setPais("Brasil");
            manager.merge(endereco3);

            Endereco endereco4 = new Endereco();
            endereco4.setId(4);
            endereco4.setCep(22070011);
            endereco4.setRua("Avenida Nossa Senhora de Copacabana");
            endereco4.setBairro("Copacabana");
            endereco4.setCidade("Rio de Janeiro");
            endereco4.setEstado("RJ");
            endereco4.setPais("Brasil");
            manager.merge(endereco4);

            Endereco endereco5 = new Endereco();
            endereco5.setId(5);
            endereco5.setCep(24358750);
            endereco5.setRua("Rua Desembargador Soares de Pinho");
            endereco5.setBairro("Camboinhas");
            endereco5.setCidade("Niterói");
            endereco5.setEstado("RJ");
            endereco5.setPais("Brasil");
            manager.merge(endereco5);

            Usuario usuario1 = new Usuario();
            usuario1.setId(1);
            usuario1.setEmail("antonio.jose@gmail.com");
            usuario1.setSenha("123456");
            usuario1.setNome("Antonio Jose");
            usuario1.setEndereco(endereco1);
            usuario1.setNumero("77");
            usuario1.setComplemento("Cobertura");
            usuario1.setData_nascimento(retornaDataFormatada("1967-12-15"));
            usuario1.setFoto_perfil("/fotos/1perfil.png");
            usuario1.setEsporte_fav("Surf");
            usuario1.setHospedeiro(Boolean.FALSE);
            usuario1.setQnt_hospedes(0);
            manager.merge(endereco1);
            manager.merge(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setId(2);
            usuario2.setEmail("basilio.luiz@gmail.com");
            usuario2.setSenha("123456");
            usuario2.setNome("Basilo Luiz");
            usuario2.setEndereco(endereco2);
            usuario2.setNumero("88");
            usuario2.setComplemento("");
            usuario2.setData_nascimento(retornaDataFormatada("1967-12-15"));
            usuario2.setFoto_perfil("/fotos/2perfil.png");
            usuario2.setEsporte_fav("Surf");
            usuario2.setHospedeiro(Boolean.TRUE);
            usuario2.setQnt_hospedes(1);
            manager.merge(endereco2);
            manager.merge(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setId(3);
            usuario3.setEmail("cristiano.ronaldo@gmail.com");
            usuario3.setSenha("123456");
            usuario3.setNome("Cristiano Ronaldo");
            usuario3.setEndereco(endereco3);
            usuario3.setNumero("298");
            usuario3.setComplemento("apto 202");
            usuario3.setData_nascimento(retornaDataFormatada("1968-01-16"));
            usuario3.setFoto_perfil("/fotos/3perfil.png");
            usuario3.setEsporte_fav("Surf");
            usuario3.setHospedeiro(Boolean.TRUE);
            usuario3.setQnt_hospedes(2);
            manager.merge(endereco3);
            manager.merge(usuario3);

            Usuario usuario4 = new Usuario();
            usuario4.setId(4);
            usuario4.setEmail("daniel.oliveira@gmail.com");
            usuario4.setSenha("123456");
            usuario4.setNome("Daniel Oliveira");
            usuario4.setEndereco(endereco3);
            usuario4.setNumero("1109");
            usuario4.setComplemento("apto 305");
            usuario4.setData_nascimento(retornaDataFormatada("1978-02-26"));
            usuario4.setFoto_perfil("/fotos/4perfil.png");
            usuario4.setEsporte_fav("Surf");
            usuario4.setHospedeiro(Boolean.TRUE);
            usuario4.setQnt_hospedes(1);
            manager.merge(endereco3);
            manager.merge(usuario4);

            Usuario usuario5 = new Usuario();
            usuario5.setId(5);
            usuario5.setEmail("eliano.jose@gmail.com");
            usuario5.setSenha("123456");
            usuario5.setNome("Eliano Jose");
            usuario5.setEndereco(endereco5);
            usuario5.setNumero("109");
            usuario5.setComplemento("apto 109");
            usuario5.setData_nascimento(retornaDataFormatada("1988-04-06"));
            usuario5.setFoto_perfil("/fotos/5perfil.png");
            usuario5.setEsporte_fav("Surf");
            usuario5.setHospedeiro(Boolean.TRUE);
            usuario5.setQnt_hospedes(3);
            manager.merge(endereco5);
            manager.merge(usuario5);

            Amizade amizade1 = new Amizade();
            amizade1.setUsuario(usuario1);
            amizade1.setUsuarioInvited(usuario2);
            amizade1.setAceito(Boolean.TRUE);
            manager.merge(amizade1);

            Amizade amizade2 = new Amizade();
            amizade2.setUsuario(usuario4);
            amizade2.setUsuarioInvited(usuario5);
            amizade2.setAceito(Boolean.TRUE);
            manager.merge(amizade2);

            Amizade amizade3 = new Amizade();
            amizade3.setUsuario(usuario2);
            amizade3.setUsuarioInvited(usuario3);
            amizade3.setAceito(Boolean.FALSE);
            manager.merge(amizade3);

            AvaliacaoAmigos avaliacaoAmigos = new AvaliacaoAmigos();
            avaliacaoAmigos.setAvaliador(usuario1);
            avaliacaoAmigos.setAvaliado(usuario2);
            avaliacaoAmigos.setNota(5);
            avaliacaoAmigos.setDescricao("Ele é muito legal!");
            avaliacaoAmigos.setPublicar(Boolean.TRUE);
            manager.merge(avaliacaoAmigos);

            Hospedagem hospedagem = new Hospedagem();
            hospedagem.setId(1);
            hospedagem.setHospedeiro(usuario4);
            hospedagem.setHospede(usuario5);
            hospedagem.setDataInicial(retornaDataFormatada("2017-01-01"));
            hospedagem.setDataFinal(retornaDataFormatada("2017-02-01"));
            manager.merge(hospedagem);

            AvaliacaoHospedeiroxhospede avaliacaoHospedeiroxhospede = new AvaliacaoHospedeiroxhospede();
            avaliacaoHospedeiroxhospede.setHospedagem(hospedagem);
            avaliacaoHospedeiroxhospede.setAvaliador(usuario4);
            avaliacaoHospedeiroxhospede.setAvaliado(usuario5);
            avaliacaoHospedeiroxhospede.setDescricao("Ótimo Guest");
            avaliacaoHospedeiroxhospede.setNota(3);
            avaliacaoHospedeiroxhospede.setPublicar(Boolean.TRUE);
            manager.merge(avaliacaoHospedeiroxhospede);

            AvaliacaoHospedexhospedeiro avaliacaoHospedexhospedeiro = new AvaliacaoHospedexhospedeiro();
            avaliacaoHospedexhospedeiro.setHospedagem(hospedagem);
            avaliacaoHospedexhospedeiro.setAvaliador(usuario5);
            avaliacaoHospedexhospedeiro.setAvaliado(usuario4);
            avaliacaoHospedexhospedeiro.setDescricao("Foi bem ruim..");
            avaliacaoHospedexhospedeiro.setNota(1);
            avaliacaoHospedexhospedeiro.setPublicar(Boolean.TRUE);
            manager.merge(avaliacaoHospedexhospedeiro);

            EventoEsportivo eventoEsportivo = new EventoEsportivo();
            eventoEsportivo.setId(1);
            eventoEsportivo.setOrganizador(usuario1);
            eventoEsportivo.setParticipante(usuario2);
            eventoEsportivo.setDescricao("Vamos surfar na praia de Ipanema");
            eventoEsportivo.setDataInicial(retornaDataFormatada("2017-05-10"));
            eventoEsportivo.setHoraIncial(retornaHoraFormatada("06:00"));
            eventoEsportivo.setHoraFinal(retornaHoraFormatada("09:00"));
            eventoEsportivo.setTotalParticipantes(2);
            manager.merge(eventoEsportivo);

            AvaliacaoOrganizadorxparticipante avaliacaoOrganizadorxparticipante = new AvaliacaoOrganizadorxparticipante();
            avaliacaoOrganizadorxparticipante.setEvento(eventoEsportivo);
            avaliacaoOrganizadorxparticipante.setAvaliador(usuario1);
            avaliacaoOrganizadorxparticipante.setAvaliado(usuario2);
            avaliacaoOrganizadorxparticipante.setDescricao("Ótima companhia!");
            avaliacaoOrganizadorxparticipante.setNota(5);
            avaliacaoOrganizadorxparticipante.setPublicar(Boolean.TRUE);
            manager.merge(avaliacaoOrganizadorxparticipante);

            AvaliacaoParticipantexorganizador avaliacaoParticipantexorganizador = new AvaliacaoParticipantexorganizador();
            avaliacaoParticipantexorganizador.setEvento(eventoEsportivo);
            avaliacaoParticipantexorganizador.setAvaliador(usuario2);
            avaliacaoParticipantexorganizador.setAvaliado(usuario1);
            avaliacaoParticipantexorganizador.setDescricao("Muito bom o evento!!");
            avaliacaoParticipantexorganizador.setNota(5);
            avaliacaoParticipantexorganizador.setPublicar(Boolean.TRUE);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (manager.isOpen()) {
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager.isOpen()) {
                manager.close();
            }
        }
        System.exit(0);
    }

    //Método para converter uma data em String para Date
    public static Date retornaDataFormatada(String stringData) throws ParseException {

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dataSql = new java.sql.Date(myFormat.parse(stringData).getTime());

        return (dataSql);
    }

    public static Date retornaHoraFormatada(String stringHora) throws ParseException {

        SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm");
        java.sql.Date dataSql = new java.sql.Date(myFormat.parse(stringHora).getTime());

        return (dataSql);
    }
}

