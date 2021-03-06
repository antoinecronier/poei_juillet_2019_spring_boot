package com.tactfactory.monsuperprojet.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tactfactory.monsuperprojet.converters.StringToAESConverter;
import com.tactfactory.monsuperprojet.database.contracts.EntrepriseContract;
import com.tactfactory.monsuperprojet.database.contracts.RoleContract;
import com.tactfactory.monsuperprojet.database.contracts.UserContract;
import com.tactfactory.monsuperprojet.validators.PasswordValidatorConstraint;

@Entity
@Table(name = UserContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = UserContract.COL_ID))
public class User extends EntityDb {

  @Column(unique=true)
  @Convert(converter = StringToAESConverter.class)
  private String login;

  //@Convert(converter = StringToBcryptConverter.class)
  private String password;

  @PasswordValidatorConstraint
  @Transient
  @JsonIgnore
  private String noEncodedPassword;

  @JsonProperty(value = UserContract.COL_FIRSTNAME)
  @Column(name = UserContract.COL_FIRSTNAME, nullable = false)
  private String firstname;

  @JsonProperty(value = UserContract.COL_LASTNAME)
  @Column(name = UserContract.COL_LASTNAME, nullable = false)
  private String lastname;

  @JsonProperty(value = UserContract.COL_DATE_OF_BIRTH)
  @Column(name = UserContract.COL_DATE_OF_BIRTH, nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)
  private Date dateOfBirth;

  @JsonProperty(value = UserContract.COL_FK_ID_ROLE)
  @ManyToOne(targetEntity = Role.class, optional = true)
  @JoinColumn(name = UserContract.COL_FK_ID_ROLE, referencedColumnName = RoleContract.COL_ID)
  private Role role;

  @JsonProperty(value = UserContract.COL_FK_ID_ENTREPRISE)
  @ManyToOne(targetEntity = Entreprise.class, optional = true)
  @JoinColumn(name = UserContract.COL_FK_ID_ENTREPRISE, referencedColumnName = EntrepriseContract.COL_ID)
  private Entreprise entreprise;

  /**
   * @return the firstname
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * @param firstname the firstname to set
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * @return the lastname
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * @param lastname the lastname to set
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * @return the dateOfBirth
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * @param dateOfBirth the dateOfBirth to set
   */
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Entreprise getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(Entreprise entreprise) {
    this.entreprise = entreprise;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }



//  @Override
//  public String toString() {
//    return "User [firstname=" + firstname + ", lastname=" + lastname + ", dateOfBirth=" + dateOfBirth + ", role=" + role
//        + ", entreprise=" + entreprise + ", getId()=" + getId() + "]";
//  }


@JsonIgnore
  public String getNoEncodedPassword() {
    return noEncodedPassword;
  }

@JsonIgnore
  public void setNoEncodedPassword(String noEncodedPassword) {
    this.noEncodedPassword = noEncodedPassword;
  }

  public User() {
  }

  @Override
  public String toString() {
    return "User [login=" + login + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
        + ", dateOfBirth=" + dateOfBirth + ", role=" + role + ", entreprise=" + entreprise + ", getId()=" + getId()
        + "]";
  }

  public User(String firstname, String lastname, Date dateOfBirth) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
    this.dateOfBirth = dateOfBirth;
  }

  public User(String firstname, String lastname, Date dateOfBirth, String login, String noEncodedPassword) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
    this.dateOfBirth = dateOfBirth;
    this.login = login;
    this.noEncodedPassword = noEncodedPassword;
  }

  public User(String firstname, String lastname, Date dateOfBirth, Role role, Entreprise entreprise) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.dateOfBirth = dateOfBirth;
    this.role = role;
    this.entreprise = entreprise;
  }
}
