package com.tactfactory.monsuperprojet.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tactfactory.monsuperprojet.database.contracts.EntrepriseContract;

@Entity
@Table(name = EntrepriseContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name=EntrepriseContract.COL_ID))
public class Entreprise extends EntityDb {

  @JsonProperty(value = EntrepriseContract.COL_NOM)
  @Column(name = EntrepriseContract.COL_NOM, nullable = false)
  private String nom;

  @JsonProperty(value = EntrepriseContract.COL_ADRESSE)
  @Column(name = EntrepriseContract.COL_ADRESSE, nullable = false)
  private String adresse;

  @JsonProperty(value = EntrepriseContract.COL_TYPE)
  @Column(name = EntrepriseContract.COL_TYPE, nullable = false)
  private String type;

  public String getNom() {
      return nom;
  }

  public void setNom(String nom) {
      this.nom = nom;
  }

  public String getAdresse() {
      return adresse;
  }

  public void setAdresse(String adresse) {
      this.adresse = adresse;
  }

  public String getType() {
      return type;
  }

  public void setType(String type) {
      this.type = type;
  }

  public Entreprise(String nom, String adresse, String type) {
      super();
      this.nom = nom;
      this.adresse = adresse;
      this.type = type;
  }

  public Entreprise() {

  }

  @Override
  public String toString() {
      return "Entreprise [nom=" + nom + ", adresse=" + adresse + ", type=" + type + ", getId()=" + getId() + "]";
  }


}
