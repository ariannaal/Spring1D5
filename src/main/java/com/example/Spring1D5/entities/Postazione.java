package com.example.Spring1D5.entities;

import com.example.Spring1D5.enums.TipoPostazione;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "postazione")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private UUID codiceUnivoco;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int maxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione( String descrizione, TipoPostazione tipoPostazione, int maxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.maxOccupanti = maxOccupanti;
        this.edificio = edificio;
    }

    public Postazione() {
    }

    public int getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public UUID getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoPostazione getTipoPostazione() {
        return tipoPostazione;
    }

    public void setTipoPostazione(TipoPostazione tipoPostazione) {
        this.tipoPostazione = tipoPostazione;
    }

    public int getMaxOccupanti() {
        return maxOccupanti;
    }

    public void setMaxOccupanti(int maxOccupanti) {
        this.maxOccupanti = maxOccupanti;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    // se il codice univoco e' null ne crea uno prima di effettuare l'operazione
    @PrePersist
    protected void onCreate() {
        if (codiceUnivoco == null) {
            codiceUnivoco = UUID.randomUUID();
        }
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", maxOccupanti=" + maxOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}
