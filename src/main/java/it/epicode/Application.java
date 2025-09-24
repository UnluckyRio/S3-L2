package it.epicode;

import it.epicode.dao.EventoDAO;
import it.epicode.entity.Evento;
import it.epicode.enums.TipoEvento;
import java.time.LocalDate;

/**
 * Classe principale per testare il funzionamento dell'applicazione
 * Dimostra l'utilizzo del DAO per le operazioni CRUD
 */
public class Application {
    
    public static void main(String[] args) {
        // Crea un'istanza del DAO
        EventoDAO eventoDAO = new EventoDAO();
        
        try {
            System.out.println("=== GESTIONE EVENTI - TEST APPLICAZIONE ===\n");
            
            // Test 1: Creazione e salvataggio di un nuovo evento
            System.out.println("1. Creazione e salvataggio di un nuovo evento...");
            Evento evento1 = new Evento(
                "Concerto Rock", 
                LocalDate.of(2024, 6, 15), 
                "Concerto di musica rock con band internazionali", 
                TipoEvento.PUBBLICO, 
                5000
            );
            eventoDAO.save(evento1);
            System.out.println("Evento creato: " + evento1 + "\n");
            
            // Test 2: Creazione di un secondo evento
            System.out.println("2. Creazione di un secondo evento...");
            Evento evento2 = new Evento(
                "Cena Aziendale", 
                LocalDate.of(2024, 7, 20), 
                "Cena di fine anno per i dipendenti dell'azienda", 
                TipoEvento.PRIVATO, 
                50
            );
            eventoDAO.save(evento2);
            System.out.println("Evento creato: " + evento2 + "\n");
            
            // Test 3: Ricerca di un evento per ID
            System.out.println("3. Ricerca evento per ID...");
            Evento eventoTrovato = eventoDAO.getById(1L);
            if (eventoTrovato != null) {
                System.out.println("Evento trovato: " + eventoTrovato);
            }
            System.out.println();
            
            // Test 4: Tentativo di ricerca con ID inesistente
            System.out.println("4. Ricerca con ID inesistente...");
            Evento eventoInesistente = eventoDAO.getById(999L); 
            if (eventoInesistente == null) {
                System.out.println("Evento non trovato (come previsto).");
            }
            System.out.println();
            
            // Test 5: Eliminazione di un evento
            System.out.println("5. Eliminazione di un evento...");
            eventoDAO.delete(2L);
            System.out.println();
            
            // Test 6: Verifica che l'evento sia stato eliminato
            System.out.println("6. Verifica eliminazione...");
            if (eventoDAO.getById(2L) == null) {
                System.out.println("Evento 2 eliminato con successo.");
            } else {
                System.out.println("Evento 2 ancora presente nel database.");
            }
            System.out.println();
            
            System.out.println("=== TEST COMPLETATI CON SUCCESSO ===");
            
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione dei test: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Chiude il DAO
            eventoDAO.close();
            System.out.println("Connessione al database chiusa.");
        }
    }
}