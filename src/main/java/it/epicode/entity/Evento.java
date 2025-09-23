package it.epicode.entity;

import it.epicode.enums.TipoEvento;
import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Classe entity che rappresenta un evento
 * Utilizza le annotations JPA per il mapping con il database
 */
@Entity
@Table(name = "eventi")
public class Evento {
    
    // Chiave primaria con generazione automatica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Titolo dell'evento (obbligatorio)
    @Column(name = "titolo", nullable = false, length = 255)
    private String titolo;
    
    // Data dell'evento
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    
    // Descrizione dell'evento
    @Column(name = "descrizione", columnDefinition = "TEXT")
    private String descrizione;
    
    // Tipo di evento (enum)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;
    
    // Numero massimo di partecipanti
    @Column(name = "numero_massimo_partecipanti")
    private Integer numeroMassimoPartecipanti;
    
    // Costruttore vuoto richiesto da JPA
    public Evento() {}
    
    // Costruttore con parametri
    public Evento(String titolo, LocalDate dataEvento, String descrizione, 
                  TipoEvento tipoEvento, Integer numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitolo() {
        return titolo;
    }
    
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    public LocalDate getDataEvento() {
        return dataEvento;
    }
    
    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }
    
    public String getDescrizione() {
        return descrizione;
    }
    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }
    
    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    
    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }
    
    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
    
    // Metodo toString per debug
    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}