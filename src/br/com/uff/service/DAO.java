package br.com.uff.service;


import br.com.uff.model.Usuario;
import br.com.uff.util.JPAUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO {

    private EntityManager manager = new JPAUtil().getEntityManager();

    public List<Usuario> retornarTodosOsUsuarios ( ) {

        List<Usuario> usuariosEncontrados = new ArrayList<>();
        usuariosEncontrados  = manager.createQuery("select usuario from Usuario usuario",Usuario.class).getResultList();
        return usuariosEncontrados;
    }

    public Usuario retornaUsuarioPorEmail(String email){
        Usuario usuarioFiltrado = new Usuario();
        String jpql = "select usuario from Usuario usuario " + "where usuario.email = ?1";
        usuarioFiltrado = manager.createQuery(jpql,Usuario.class)
                .setParameter(1, email).getSingleResult();
        return usuarioFiltrado;
    }

    public Usuario retornaUsuarioPorId(Integer id){
        Usuario usuarioFiltrado = new Usuario();
        String jpql = "select usuario from Usuario usuario " + "where usuario.id = ?1";
        usuarioFiltrado = manager.createQuery(jpql,Usuario.class)
                .setParameter(1, id).getSingleResult();
        return usuarioFiltrado;
    }

    /*
    public Voo buscarVooPeloId (Integer idVoo){
        Voo vooEncontrado;
        String jpql = "select voo from Voo voo" +" where voo.id= ?1";
        vooEncontrado = manager.createQuery(jpql,Voo.class)
                .setParameter(1,idVoo).getSingleResult();
        return vooEncontrado;
    }
    public List<Voo> retornarVoo(Date data, String localOrigem, String localDestino){
        //Consulta passando os filtros para busca do voo, retornando uma lista com os voos encontrados
        List<Voo> voosFiltrados = new ArrayList<>();
        String jpql = "select voo from Voo voo " + "where voo.data= ?1 and voo.localOrigem= ?2 and voo.localDestino= ?3";
        voosFiltrados  = manager.createQuery(jpql,Voo.class)
                .setParameter(1,data)
                .setParameter(2,localOrigem)
                .setParameter(3,localDestino)
                .getResultList();
        return voosFiltrados;
    }

    public Poltrona buscarPoltronaPeloId (Integer idPoltrona){
        Poltrona poltronaEncontrada = new Poltrona();
        String jpql = "select poltrona from Poltrona poltrona" + " where poltrona.idPoltrona= ?1";

        poltronaEncontrada = manager.createQuery(jpql,Poltrona.class)
                .setParameter(1,idPoltrona)
                .getSingleResult();

        return poltronaEncontrada;
    }


    public List<Poltrona> buscarPoltronaIdaDisponivelVoo(Integer idVoo){
        Voo vooEncontrado;
        Aviao aviao = new Aviao();
        Voo vooAdquirido = buscarVooPeloId(idVoo);
        aviao = vooAdquirido.getAviao();
        List<Poltrona> poltronas;
        String jpql = "select poltrona from Poltrona poltrona" + " where poltrona.voo.id=?1 and poltrona.statusPoltronaIda = ?2";

        poltronas = manager.createQuery(jpql,Poltrona.class)
                .setParameter(1,idVoo)
                .setParameter(2,DISPONIVEL)
                .getResultList();
        return poltronas;
    }

    public List<Poltrona> buscarPoltronasVoo (Voo voo){
        List<Poltrona> poltronas = new ArrayList<>();
        String jpql = "select poltrona from Poltrona poltrona" + " where poltrona.voo.id=?1";
        poltronas = manager.createQuery(jpql,Poltrona.class)
                .setParameter(1,voo.getId())
                .getResultList();
        return poltronas;
    }

    public List<Poltrona> buscarPoltronaVoltaDisponivelVoo(Integer idVoo){
        Voo vooEncontrado;
        Aviao aviao = new Aviao();
        Voo vooAdquirido = buscarVooPeloId(idVoo);
        aviao = vooAdquirido.getAviao();
        List<Poltrona> poltronas;
        String jpql = "select poltrona from Poltrona poltrona" + " where poltrona.voo.id=?1 and poltrona.statusPoltronaVolta = ?2";
        poltronas = manager.createQuery(jpql,Poltrona.class)
                .setParameter(1,idVoo)
                .setParameter(2,DISPONIVEL)
                .getResultList();
        return poltronas;
    }

    public List<Poltrona> buscarPoltronasPeloId (String[] idPoltronas){
        List<Poltrona> poltronasSelecionadas = new ArrayList<>();
        for(String poltronaId: idPoltronas){
            poltronasSelecionadas.add(buscarPoltronaPeloId(Integer.valueOf(poltronaId)));
        }
        return poltronasSelecionadas;
    }

    public void setarPoltronaEmCompra(String[] idPoltrona, String tipoVoo){
        if (tipoVoo.equals("IDA")){
            manager.getTransaction().begin();
            List<Poltrona> poltronasSelecionadas = buscarPoltronasPeloId(idPoltrona);
            for(Poltrona poltrona: poltronasSelecionadas){
                String jpql = "update Poltrona poltrona set poltrona.statusPoltronaIda ='AGUARDANDO_COMPRA' where poltrona.idPoltrona = ?1";
                Query query = manager.createQuery(jpql)
                        .setParameter(1,poltrona.getIdPoltrona());
                query.executeUpdate();
            }
            manager.getTransaction().commit();

        } else{
            manager.getTransaction().begin();
            List<Poltrona> poltronasSelecionadas = buscarPoltronasPeloId(idPoltrona);
            for(Poltrona poltrona: poltronasSelecionadas){
                String jpql = "update Poltrona poltrona set poltrona.statusPoltronaVolta = 'AGUARDANDO_COMPRA' where poltrona.idPoltrona = ?1";
                Query query = manager.createQuery(jpql)
                        .setParameter(1,poltrona.getIdPoltrona());
                query.executeUpdate();
            }
            manager.getTransaction().commit();
        }
    }

    public void setarPoltronasDisponivel(Poltrona poltrona){
        manager.getTransaction().begin();
        String jpql = "update Poltrona poltrona set poltrona.statusPoltronaIda ='DISPONIVEL' where poltrona.idPoltrona = ?1";
        Query query = manager.createQuery(jpql) .setParameter(1,poltrona.getIdPoltrona());
        query.executeUpdate();
        manager.getTransaction().commit();
    }

    public void setarPoltronasDisponivel(String[] poltronas){
        manager.getTransaction().begin();
        for(Integer idPoltrona=0; idPoltrona<poltronas.length; idPoltrona++){
            String jpql = "update Poltrona poltrona set poltrona.statusPoltronaIda ='DISPONIVEL' where poltrona.idPoltrona = ?1";
            Query query = manager.createQuery(jpql) .setParameter(1,idPoltrona);
            query.executeUpdate();
        }
        manager.getTransaction().commit();
    }


    public void setarPoltronaDisponivel(List<Poltrona> poltronas, String tipoVoo){
        if (tipoVoo.equals("IDA")){
            manager.getTransaction().begin();
            for(Poltrona poltrona: poltronas){
                String jpql = "update Poltrona poltrona set poltrona.statusPoltronaIda ='DISPONIVEL' where poltrona.idPoltrona = ?1";
                Query query = manager.createQuery(jpql)
                        .setParameter(1,poltrona.getIdPoltrona());
                query.executeUpdate();
            }
            manager.getTransaction().commit();

        } else{
            manager.getTransaction().begin();
            for(Poltrona poltrona: poltronas){
                String jpql = "update Poltrona poltrona set poltrona.statusPoltronaVolta = 'DISPONIVEL' where poltrona.idPoltrona = ?1";
                Query query = manager.createQuery(jpql)
                        .setParameter(1,poltrona.getIdPoltrona());
                query.executeUpdate();
            }
            manager.getTransaction().commit();
        }
    }

    public void inserirPassageiroNoBanco (Passageiro passageiro){

    }

*/
    /*
    Classe Economica: ID = 1  /  Classe Primeira_Classe: ID = 2 /  Classe Executiva: ID = 3
    Fórmula do cálculo do preço: ClasseID * preçoVoo.
    Lógica: Comparamos o avião do voo e o avião da poltrona. Encontrando, aplicamos a formula e adiconamos ao contador.
     *//*
    public Double calcularPrecoPoltronas(List<Voo> voos,List<Poltrona> poltronasUsuario){
        Double precoTotal = 0.0;

        if(poltronasUsuario == null){
            precoTotal = calcularPrecoVoos(voos);
            return precoTotal;
        } else{
            Double precoVooPoltrona;
            for(Voo voo: voos){
                boolean vooPossuiPoltrona = false;
                for(Poltrona poltrona: poltronasUsuario){
                    Integer idClasse = poltrona.getClasse().getId();
                    //Se o voo já possui uma poltrona escolhida...
                    if (voo.getId() == poltrona.getVoo().getId()){
                        precoVooPoltrona = voo.getPreco();
                        precoVooPoltrona = (idClasse * precoVooPoltrona) + voo.getAeroporto().getTaxa();
                        precoTotal = precoTotal + precoVooPoltrona;
                        vooPossuiPoltrona = true;
                    }
                }
                if (!vooPossuiPoltrona){
                    precoTotal = precoTotal + voo.getPreco() + voo.getAeroporto().getTaxa();
                }
            }

        }
        return precoTotal;
    }

    public Double calcularPrecoVoos(List<Voo> voos){
        if(voos.isEmpty()){
            return 0.0;
        } else{
            Double precoTotal = 0.0;
            for(Voo voo:voos){
                precoTotal = precoTotal + voo.getPreco() + voo.getAeroporto().getTaxa();
            }
            return precoTotal;
        }
    }

    public Boolean escolhaPoltronasFinalizado(List<Voo> voos,List<Poltrona> poltronasUsuario,Integer numeroPassageiros){
        if(poltronasUsuario == null) {
            return false;
        } else {
            return poltronasUsuario.size() >= numeroPassageiros;
        }
    }

    public List<Poltrona> buscarPoltronasEscolhidas (List<Poltrona> poltronasSession){
        List<Poltrona> poltronasEscolhidas = poltronasSession;
        return poltronasEscolhidas;
    }

    public StringBuilder buscarPoltronasEscolhidasString (List<Poltrona> poltronasPassageiro){
//        String idPoltronas = "";
        StringBuilder idPoltronas = new StringBuilder();
        for(Poltrona poltrona: poltronasPassageiro){
            idPoltronas.append(" | ").append(poltrona.getIdPoltrona().toString()).append(" | ");
        }
        return idPoltronas;
    }
*/
}
