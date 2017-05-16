package br.com.uff.util;

import br.com.uff.model.*;

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

        try{
            EntityTransaction transaction = manager.getTransaction();

            transaction.begin();

            Aeroporto aeroporto1 = new Aeroporto();
            aeroporto1.setId(1);
            aeroporto1.setNomeAeroporto("Galeao");
            aeroporto1.setTaxa(50.00);
            manager.merge(aeroporto1);

            Aeroporto aeroporto2 = new Aeroporto();
            aeroporto2.setId(2);
            aeroporto2.setNomeAeroporto("Augusto Severo");
            aeroporto2.setTaxa(40.00);
            manager.merge(aeroporto2);

            Aeroporto aeroporto3 = new Aeroporto();
            aeroporto3.setId(3);
            aeroporto3.setNomeAeroporto("Congonhas");
            aeroporto3.setTaxa(90.00);
            manager.merge(aeroporto3);

            Aeroporto aeroporto4 = new Aeroporto();
            aeroporto4.setId(4);
            aeroporto4.setNomeAeroporto("Cumbica");
            aeroporto4.setTaxa(60.00);
            manager.merge(aeroporto4);

            Aeroporto aeroporto5 = new Aeroporto();
            aeroporto5.setId(5);
            aeroporto5.setNomeAeroporto("Sydney Airport");
            aeroporto5.setTaxa(50.00);
            manager.merge(aeroporto5);


            Classe classeEconomica = new Classe();
            classeEconomica.setId(1);
            classeEconomica.setTipoClasse(TipoClasse.ECONOMICA);

            Classe classePrimeiraClasse = new Classe();
            classePrimeiraClasse.setId(2);
            classePrimeiraClasse.setTipoClasse(TipoClasse.PRIMEIRA_CLASSE);

            Classe classeExecutiva = new Classe();
            classeExecutiva.setId(3);
            classeExecutiva.setTipoClasse(TipoClasse.EXECUTIVA);

            manager.merge(classeEconomica);
            manager.merge(classePrimeiraClasse);
            manager.merge(classeExecutiva);



            Usuario usuario1 = new Usuario();
            usuario1.setEmail("joao@uff.br");
            usuario1.setNome("Joao");
            usuario1.setSenha(1234);
            manager.persist(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setEmail("pedro@uff.br");
            usuario2.setNome("Pedro");
            usuario2.setSenha(1234);
            manager.persist(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setEmail("bruno@uff.br");
            usuario3.setNome("Bruno");
            usuario3.setSenha(1234);
            manager.persist(usuario3);

            Usuario usuario4 = new Usuario();
            usuario4.setEmail("caio@uff.br");
            usuario4.setNome("Caio");
            usuario4.setSenha(1234);
            manager.persist(usuario4);



            Aviao aviao1 = new Aviao();
            aviao1.setId(1);
            aviao1.setModelo("Super Constelation L-1049");
            manager.merge(aviao1);

            Aviao aviao2 = new Aviao();
            aviao2.setId(2);
            aviao2.setModelo("Airbus A320" );
            manager.merge(aviao2);

            Aviao aviao3 = new Aviao();
            aviao3.setId(3);
            aviao3.setModelo("BAC ONE-ELEVEN" );
            manager.merge(aviao3);

            //Funcionamento: Para uma passagem de ida e volta, são gerados dois objetos Voo, um Voo pro destino e um Voo pra volta.

            Voo voo1Ida = new Voo();
            voo1Ida.setId(1);
            voo1Ida.setDuracao(24);
            voo1Ida.setNumParadas(3);
            voo1Ida.setAeroporto(aeroporto1);
            voo1Ida.setData(retornaDataFormatada("2016-01-01"));
            voo1Ida.setLocalOrigem("Bahia");
            voo1Ida.setLocalDestino("Maranhao");
            voo1Ida.setPreco(200.00);
            voo1Ida.setTipoVoo(TipoVoo.IDA);
            voo1Ida.setAviao(aviao1);
            aviao1.setVooIda(voo1Ida);
            manager.merge(voo1Ida);
            manager.merge(aviao1);

            Voo voo1Volta = new Voo();
            voo1Volta.setId(2);
            voo1Volta.setDuracao(24);
            voo1Volta.setNumParadas(3);
            voo1Volta.setAeroporto(aeroporto1);
            voo1Volta.setData(retornaDataFormatada("2016-01-10"));
            voo1Volta.setLocalOrigem("Maranhao");
            voo1Volta.setLocalDestino("Bahia");
            voo1Volta.setPreco(200.00);
            voo1Volta.setTipoVoo(TipoVoo.VOLTA);
            voo1Volta.setAviao(aviao2);
            aviao2.setVooVolta(voo1Volta);
            manager.merge(voo1Volta);
            manager.merge(aviao2);


            Voo voo2Ida = new Voo();
            voo2Ida.setId(3);
            voo2Ida.setDuracao(30);
            voo2Ida.setNumParadas(2);
            voo2Ida.setAeroporto(aeroporto1);
            voo2Ida.setData(retornaDataFormatada("2016-01-01"));
            voo2Ida.setLocalOrigem("Rio de Janeiro");
            voo2Ida.setLocalDestino("Sao Paulo");
            voo2Ida.setPreco(250.00);
            voo2Ida.setTipoVoo(TipoVoo.IDA);
            manager.merge(voo2Ida);

            Voo voo2Volta = new Voo();
            voo2Volta.setId(4);
            voo2Volta.setDuracao(30);
            voo2Volta.setNumParadas(2);
            voo2Volta.setAeroporto(aeroporto1);
            voo2Volta.setData(retornaDataFormatada("2016-01-10"));
            voo2Volta.setLocalOrigem("Sao Paulo");
            voo2Volta.setLocalDestino("Rio de Janeiro");
            voo2Volta.setPreco(250.00);
            voo2Volta.setTipoVoo(TipoVoo.VOLTA);
            manager.merge(voo2Volta);

            Voo voo3Ida = new Voo();
            voo3Ida.setId(5);
            voo3Ida.setDuracao(60*32);
            voo3Ida.setNumParadas(3);
            voo3Ida.setAeroporto(aeroporto1);
            voo3Ida.setData(retornaDataFormatada("2016-02-03"));
            voo3Ida.setLocalOrigem("Rio de Janeiro");
            voo3Ida.setLocalDestino("Sydney");
            voo3Ida.setTipoVoo(TipoVoo.IDA);
            voo3Ida.setPreco(3000.00);
            manager.merge(voo3Ida);

            Voo voo3Volta = new Voo();
            voo3Volta.setId(6);
            voo3Volta.setDuracao(60*32);
            voo3Volta.setNumParadas(3);
            voo3Volta.setAeroporto(aeroporto5);
            voo3Volta.setData(retornaDataFormatada("2016-03-10"));
            voo3Volta.setLocalOrigem("Sydney");
            voo3Volta.setLocalDestino("Rio de Janeiro");
            voo3Volta.setPreco(3000.00);
            voo3Volta.setTipoVoo(TipoVoo.VOLTA);
            manager.merge(voo3Volta);



            Poltrona poltrona1 = new Poltrona();
            poltrona1.setIdPoltrona(1);
            poltrona1.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona1.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona1.setClasse(classeEconomica);
            classeEconomica.setPoltrona(poltrona1);
            poltrona1.setAviao(aviao1);
            poltrona1.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona1);
            aviao1.setPoltronasDoAviao(poltrona1);
            manager.merge(poltrona1);
            manager.merge(voo1Ida);

            Poltrona poltrona2 = new Poltrona();
            poltrona2.setIdPoltrona(2);
            poltrona2.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona2.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona2.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona2);
            poltrona2.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona2);
            poltrona2.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona2);
            manager.merge(poltrona2);
            manager.merge(voo1Ida);

            Poltrona poltrona3 = new Poltrona();
            poltrona3.setIdPoltrona(3);
            poltrona3.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona3.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona3.setClasse(classePrimeiraClasse);
            classePrimeiraClasse.setPoltrona(poltrona3);
            poltrona3.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona3);
            poltrona3.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona3);
            manager.merge(poltrona3);
            manager.merge(voo1Ida);

            Poltrona poltrona4 = new Poltrona();
            poltrona4.setIdPoltrona(4);
            poltrona4.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona4.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona4.setClasse(classeEconomica);
            classeEconomica.setPoltrona(poltrona4);
            poltrona4.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona4);
            poltrona4.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona4);
            manager.merge(poltrona4);
            manager.merge(voo1Ida);



            Poltrona poltrona5 = new Poltrona();
            poltrona5.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona5.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona5.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona5);
            poltrona5.setIdPoltrona(5);
            poltrona5.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona5);
            poltrona5.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona5);
            manager.merge(poltrona5);
            manager.merge(voo1Ida);

            Poltrona poltrona6 = new Poltrona();
            poltrona6.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona6.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona6.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona6);
            poltrona6.setIdPoltrona(6);
            poltrona6.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona6);
            poltrona6.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona6);
            manager.merge(poltrona6);
            manager.merge(voo1Ida);

            Poltrona poltrona7 = new Poltrona();
            poltrona7.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona7.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona7.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona7);
            poltrona7.setIdPoltrona(7);
            poltrona7.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona7);
            poltrona7.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona7);

            manager.merge(poltrona7);
            manager.merge(voo1Ida);
            Poltrona poltrona8 = new Poltrona();
            poltrona8.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona8.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona8.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona8);
            poltrona8.setIdPoltrona(8);
            poltrona8.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona8);
            poltrona8.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona8);
            manager.merge(poltrona8);
            manager.merge(voo1Ida);

            Poltrona poltrona9 = new Poltrona();
            poltrona9.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona9.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona9.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona9);
            poltrona9.setIdPoltrona(9);
            poltrona9.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona9);
            poltrona9.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona9);
            manager.merge(poltrona9);
            manager.merge(voo1Ida);

            Poltrona poltrona10 = new Poltrona();
            poltrona10.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona10.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona10.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona10);
            poltrona10.setIdPoltrona(10);
            poltrona10.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona10);
            poltrona10.setVoo(voo1Ida);
            voo1Ida.setPoltrona(poltrona10);
            manager.merge(poltrona10);
            manager.merge(voo1Ida);

            Poltrona poltrona11 = new Poltrona();
            poltrona11.setIdPoltrona(11);
            poltrona11.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona11.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona11.setClasse(classeEconomica);
            classeEconomica.setPoltrona(poltrona11);
            poltrona11.setAviao(aviao3);
            aviao3.setPoltronasDoAviao(poltrona11);
            poltrona11.setVoo(voo1Volta);
            voo1Volta.setPoltrona(poltrona11);
            manager.merge(poltrona11);
            manager.merge(voo1Volta);

            Poltrona poltrona12 = new Poltrona();
            poltrona12.setIdPoltrona(12);
            poltrona12.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona12.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona12.setClasse(classeEconomica);
            classeEconomica.setPoltrona(poltrona12);
            poltrona12.setAviao(aviao3);
            aviao3.setPoltronasDoAviao(poltrona12);
            poltrona12.setVoo(voo1Volta);
            voo1Volta.setPoltrona(poltrona12);
            manager.merge(poltrona12);
            manager.merge(voo1Volta);

            Poltrona poltrona13 = new Poltrona();
            poltrona13.setIdPoltrona(13);
            poltrona13.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona13.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona13.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona13);
            poltrona13.setAviao(aviao3);
            aviao3.setPoltronasDoAviao(poltrona13);
            poltrona13.setVoo(voo1Volta);
            voo1Volta.setPoltrona(poltrona13);
            manager.merge(poltrona13);
            manager.merge(voo1Volta);

            Poltrona poltrona14 = new Poltrona();
            poltrona14.setIdPoltrona(14);
            poltrona14.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona14.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona14.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona14);
            poltrona14.setAviao(aviao3);
            aviao3.setPoltronasDoAviao(poltrona14);
            poltrona14.setVoo(voo1Volta);
            voo1Volta.setPoltrona(poltrona14);
            manager.merge(poltrona14);
            manager.merge(voo1Volta);


            Poltrona poltrona15 = new Poltrona();
            poltrona15.setIdPoltrona(15);
            poltrona15.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona15.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona15.setClasse(classePrimeiraClasse);
            classePrimeiraClasse.setPoltrona(poltrona15);
            poltrona15.setAviao(aviao3);
            aviao3.setPoltronasDoAviao(poltrona15);
            poltrona15.setVoo(voo1Volta);
            voo1Volta.setPoltrona(poltrona15);
            manager.merge(poltrona15);
            manager.merge(voo1Volta);


            /*
            Passageiro passageiro1 = new Passageiro();
            passageiro1.setNome("Joao da Silva");
            passageiro1.setEndereco("Rua Sao Jose, 456");
            passageiro1.setDataNasc(retornaDataFormatada("1994-05-10"));
            manager.persist(passageiro1);

            Passageiro passageiro2 = new Passageiro();
            passageiro2.setNome("Pedro Alfradique");
            passageiro2.setEndereco("Rua Doutor Sardinha, 432");
            passageiro2.setDataNasc(retornaDataFormatada("1995-03-06"));
            manager.persist(passageiro2);


            Passageiro passageiro3 = new Passageiro();
            passageiro3.setNome("Bruno Hilario");
            passageiro3.setEndereco("Rua Presidente Pedreira, 56");
            passageiro3.setDataNasc(retornaDataFormatada("1980-06-28"));
            manager.persist(passageiro3);

            Passageiro passageiro4 = new Passageiro();
            passageiro4.setNome("Caio Serra");
            passageiro4.setEndereco("Rua Alvares de Azevedo, 25");
            passageiro4.setDataNasc(retornaDataFormatada("1996-07-10"));
            manager.persist(passageiro4);
*/

            /*Anotações:

                         Aviao1 --> A entidade possui apenas determinadas poltronas.
                         As poltronas pertencerão a uma passagem. Essa passagem possui um Voo.

                         Poltrona 1 --> Aviao1
                         Poltrona 2 --> Aviao1
                         Poltrona 3 --> Aviao1
                         Poltrona 4 --> Aviao1

            //Sobre a passagem 1:

                         Passageiro --> Passageiro1
                         Poltrona 1 --> passagem1
                         Poltrona 3 --> passagem1

                         Poltrona1 --> passagem1
                         Poltrona2 --> passagem1

                         Voo1Ida   --> passagem1
                         Voo1Volta --> passagem1


            Passagem passagem1 = new Passagem();
            passagem1.setId(1);
            manager.merge(passagem1);
            passagem1.setPoltronaIda(poltrona1);
            poltrona1.setPassagemIda(passagem1);
            poltrona1.setStatusPoltronaIda(StatusPoltrona.OCUPADO);
            passagem1.setPoltronaVolta(poltrona3);
            poltrona3.setPassagemVolta(passagem1);
            passagem1.setPassageiro(passageiro1);
            poltrona3.setStatusPoltronaVolta(StatusPoltrona.OCUPADO);
            passageiro1.setPassagemComprada(passagem1);
            passagem1.setVooIda(voo1Ida);
            voo1Ida.setPassagensIda(passagem1);
            passagem1.setVooVolta(voo1Volta);
            voo1Volta.setPassagensVolta(passagem1);
            manager.merge(passagem1);
            manager.merge(poltrona1);
            manager.merge(poltrona3);


            Passagem passagem2 = new Passagem();
            passagem2.setId(2);
            passagem2.setPoltronaIda(poltrona4);
            poltrona4.setPassagemIda(passagem2);
            poltrona4.setStatusPoltronaIda(StatusPoltrona.OCUPADO);
            passagem2.setPoltronaVolta(poltrona4);
            poltrona4.setPassagemVolta(passagem2);
            poltrona4.setStatusPoltronaVolta(StatusPoltrona.OCUPADO);
            passagem2.setPassageiro(passageiro2);
            passageiro2.setPassagemComprada(passagem2);
            passagem2.setVooIda(voo2Ida);
            voo2Ida.setPassagensIda(passagem2);
            passagem2.setVooVolta(voo2Volta);
            voo2Volta.setPassagensVolta(passagem2);
            manager.merge(passagem2);
            manager.merge(poltrona4);
            manager.merge(poltrona2);


            Passagem passagem3 = new Passagem();
            passagem3.setId(3);
            manager.merge(passagem3);
            passagem3.setPoltronaIda(poltrona11);
            poltrona11.setPassagemIda(passagem3);
            poltrona11.setStatusPoltronaIda(StatusPoltrona.OCUPADO);
            passagem3.setPoltronaVolta(poltrona13);
            poltrona13.setPassagemVolta(passagem3);
            passagem3.setPassageiro(passageiro1);
            poltrona13.setStatusPoltronaVolta(StatusPoltrona.OCUPADO);
            passageiro1.setPassagemComprada(passagem3);
            passagem3.setVooIda(voo3Ida);
            voo3Ida.setPassagensIda(passagem3);
            passagem3.setVooVolta(voo3Volta);
            voo3Volta.setPassagensVolta(passagem3);
            manager.merge(passagem3);
            manager.merge(poltrona11);
            manager.merge(poltrona13);


            Passagem passagem4 = new Passagem();
            passagem4.setId(4);
            passagem4.setPoltronaIda(poltrona12);
            poltrona12.setPassagemIda(passagem4);
            poltrona12.setStatusPoltronaIda(StatusPoltrona.OCUPADO);
            passagem4.setPoltronaVolta(poltrona14);
            poltrona14.setPassagemVolta(passagem4);
            poltrona14.setStatusPoltronaVolta(StatusPoltrona.OCUPADO);
            passagem4.setPassageiro(passageiro2);
            passageiro2.setPassagemComprada(passagem4);
            passagem4.setVooIda(voo3Ida);
            voo3Ida.setPassagensIda(passagem4);
            passagem4.setVooVolta(voo3Volta);
            voo3Volta.setPassagensVolta(passagem4);
            manager.merge(passagem4);
            manager.merge(poltrona4);
            manager.merge(poltrona2);

            /* MODELO DE INSERÇÃO DE PASSAGENS

            Passagem passagem2 = new Passagem();
            passagem2.setId(2);
            passagem2.setPoltronaIda();
            passagem2.setPoltronaVolta();
            passagem2.setPassageiro();
            passagem2.setVooIda();
            passagem2.setVooVolta();
            manager.merge(passagem2);



            Venda venda1 = new Venda();
            venda1.setId(1);
            venda1.setNumPassagensCompradas(passagem1);
            passagem1.setNumeroVenda(venda1);
            venda1.setNumPassagensCompradas(passagem2);
            passagem2.setNumeroVenda(venda1);
            manager.merge(venda1);
            manager.merge(passagem1);
            manager.merge(passagem2);
             */

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
}



