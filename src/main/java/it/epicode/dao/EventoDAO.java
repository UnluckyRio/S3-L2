package it.epicode.dao;

import it.epicode.entity.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Data Access Object per la gestione delle operazioni CRUD sull'entità Evento
 * Utilizza l'EntityManager di JPA per interagire con il database
 */
public class EventoDAO {
    
    private EntityManagerFactory emf;
    
    // Costruttore che inizializza l'EntityManagerFactory
    public EventoDAO() {
        this.emf = Persistence.createEntityManagerFactory("gestioneeventi");
    }
    
    /**
     * Salva un nuovo evento nel database
     * @param evento L'evento da salvare
     */
    public void save(Evento evento) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            // Inizia la transazione
            transaction.begin();
            
            // Persiste l'evento nel database
            em.persist(evento);
            
            // Conferma la transazione
            transaction.commit();
            
            System.out.println("Evento salvato con successo: " + evento.getTitolo());
            
        } catch (Exception e) {
            // In caso di errore, rollback della transazione
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio dell'evento: " + e.getMessage());
            throw new RuntimeException("Errore durante il salvataggio", e);
        } finally {
            // Chiude l'EntityManager
            em.close();
        }
    }
    
    /**
     * Recupera un evento dal database tramite il suo ID
     * @param id L'ID dell'evento da recuperare
     * @return L'evento trovato o null se non esiste
     */
    public Evento getById(Long id) {
        EntityManager em = emf.createEntityManager();
        
        try {
            // Cerca l'evento per ID
            Evento evento = em.find(Evento.class, id);
            
            if (evento != null) {
                System.out.println("Evento trovato: " + evento.getTitolo());
            } else {
                System.out.println("Nessun evento trovato con ID: " + id);
            }
            
            return evento;
            
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca dell'evento: " + e.getMessage());
            throw new RuntimeException("Errore durante la ricerca", e);
        } finally {
            // Chiude l'EntityManager
            em.close();
        }
    }
    
    /**
     * Elimina un evento dal database tramite il suo ID
     * @param id L'ID dell'evento da eliminare
     */
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            // Inizia la transazione
            transaction.begin();
            
            // Trova l'evento da eliminare
            Evento evento = em.find(Evento.class, id);
            
            if (evento != null) {
                // Rimuove l'evento dal database
                em.remove(evento);
                System.out.println("Evento eliminato con successo: " + evento.getTitolo());
            } else {
                System.out.println("Nessun evento trovato con ID: " + id);
            }
            
            // Conferma la transazione
            transaction.commit();
            
        } catch (Exception e) {
            // In caso di errore, rollback della transazione
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante l'eliminazione dell'evento: " + e.getMessage());
            throw new RuntimeException("Errore durante l'eliminazione", e);
        } finally {
            // Chiude l'EntityManager
            em.close();
        }
    }
    
    /**
     * Chiude l'EntityManagerFactory
     * Deve essere chiamato quando non si ha più bisogno del DAO
     */
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}