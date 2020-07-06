package ma.gymmanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "abonnements")
@Data
@NoArgsConstructor
public class Abonnement {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private Date dateDebut;
    private int nbMois;
    private Date datePaiment;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="fk_adherent",referencedColumnName="id",nullable=false)
    Adherent adherent;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="fk_sport",referencedColumnName="id",nullable=false)
    Sport sport;
}