/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Monnalisa Medeiros
 */
public class EMF {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CORRESYS_1.0PU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}