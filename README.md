# GestioneEventi

Applicazione Java per la gestione degli eventi utilizzando JPA e Hibernate.

## Prerequisiti

- Java 17 o superiore
- Maven 3.6 o superiore
- PostgreSQL 12 o superiore

## Configurazione del Database

1. Installa PostgreSQL se non è già presente
2. Crea un nuovo database chiamato `gestioneeventi`:
   ```sql
   CREATE DATABASE gestioneeventi;
   ```
3. Modifica le credenziali nel file `persistence.xml` se necessario:
   - Username: `postgres`
   - Password: `password`
   - URL: `jdbc:postgresql://localhost:5432/gestioneeventi`

## Struttura del Progetto

```
src/
├── main/
│   ├── java/
│   │   └── it/epicode/
│   │       ├── Application.java          # Classe principale per i test
│   │       ├── dao/
│   │       │   └── EventoDAO.java        # Data Access Object
│   │       ├── entity/
│   │       │   └── Evento.java           # Entità JPA
│   │       └── enums/
│   │           └── TipoEvento.java       # Enum per i tipi di evento
│   └── resources/
│       └── META-INF/
│           └── persistence.xml           # Configurazione JPA
└── pom.xml                              # Configurazione Maven
```

## Funzionalità

### Entità Evento
- **ID**: Chiave primaria auto-generata
- **Titolo**: Nome dell'evento
- **Data Evento**: Data di svolgimento (LocalDate)
- **Descrizione**: Descrizione dettagliata
- **Tipo Evento**: PUBBLICO o PRIVATO
- **Numero Massimo Partecipanti**: Limite di partecipanti

### Operazioni DAO
- `save(Evento evento)`: Salva un nuovo evento
- `getById(Long id)`: Recupera un evento per ID
- `delete(Long id)`: Elimina un evento per ID

## Come Eseguire

1. Compila il progetto:
   ```bash
   mvn clean compile
   ```

2. Esegui l'applicazione di test:
   ```bash
   mvn exec:java -Dexec.mainClass="it.epicode.Application"
   ```

## Dipendenze Principali

- **Hibernate Core 6.2.7**: Implementazione JPA
- **PostgreSQL Driver 42.6.0**: Driver per PostgreSQL
- **JUnit 5.10.0**: Framework per i test
- **SLF4J Simple 2.0.7**: Logging

## Note

- Il database viene creato automaticamente grazie alla configurazione `hibernate.hbm2ddl.auto=update`
- Le query SQL vengono mostrate nel log per debug
- L'applicazione include gestione delle transazioni e degli errori