package br.com.uff.util;

import br.com.uff.model.Usuario;
import br.com.uff.service.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 17/05/2017.
 */
public class testaHibernate {
    public static void main(String[] args) throws ParseException {
        EntityManager manager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        DAO daoTeste = new DAO();
        Usuario usuarioTeste = daoTeste.retornaUsuarioPorEmail("antonio.jose@gmail.com");

        System.out.println("Nome: " + usuarioTeste.getNome()+"\n");
        System.out.println("E-mail: " + usuarioTeste.getEmail()+"\n");
        System.out.println("Senha: " + usuarioTeste.getSenha()+"\n");
    }
}
