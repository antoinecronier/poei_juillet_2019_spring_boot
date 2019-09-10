package com.tactfactory.monsuperprojet.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.tactfactory.monsuperprojet.database.repositories.EntrepriseRepository;
import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.database.repositories.UserRepository;
import com.tactfactory.monsuperprojet.entities.Entreprise;
import com.tactfactory.monsuperprojet.entities.Role;
import com.tactfactory.monsuperprojet.entities.User;
import com.tactfactory.monsuperprojet.services.security.UserServiceImpl;

@Service(value="baseDatasInsertors")
public class DatasInsertors {

  @Autowired
  private EntrepriseRepository entrepriseRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserServiceImpl userService;

  public DatasInsertors() {
    System.out.println("coucou");
  }

  public DatasInsertors(Integer test) {
    System.out.println("coucou2");
  }

  @PostConstruct
  public void InsertData() {
    Faker faker = new Faker(Locale.FRENCH);

    List<String> professions = new ArrayList<String>();
    int i = 0;
    while (i < 2) {
      String prof = faker.company().profession();
      if (!professions.contains(prof)) {
        professions.add(prof);
        i++;
      }
    }

    List<Role> roles = new ArrayList<>();
    for (String prof : professions) {
      Role role = new Role(prof);
      roles.add(role);
    }

    // Save all roles
    roleRepository.saveAll(roles);

    List<String> companies = new ArrayList<String>();
    List<Entreprise> entreprises = new ArrayList<Entreprise>();

    i = 0;
    while (i < 2) {
      String comp = faker.company().name();
      if (!companies.contains(comp)) {
        companies.add(comp);

        Entreprise entreprise = new Entreprise(comp, faker.address().streetAddress(), faker.company().industry());
        entreprises.add(entreprise);

        i++;
      }
    }

    // Save all entreprise
    entrepriseRepository.saveAll(entreprises);

//    i = 0;
//    while (i < 5) {
//      User user = new User(faker.name().firstName(), faker.name().lastName(), faker.date().birthday(),faker.name().firstName(),faker.name().lastName());
//      user.setEntreprise(entreprises.get(faker.random().nextInt(0, entreprises.size() - 1)));
//      user.setRole(roles.get(faker.random().nextInt(0, roles.size() - 1)));
//
//      // Save all user
//      userRepository.save(user);
//
//      i++;
//    }

    User user = new User(faker.name().firstName(), faker.name().lastName(), faker.date().birthday(),"antoine","adminadmin");
    userService.save(user);
  }

  public void insertOneShoot() {
    Faker faker = new Faker(Locale.FRENCH);

    List<String> professions = new ArrayList<String>();
    int i = 0;
    while (i < 10) {
      String prof = faker.company().profession();
      if (!professions.contains(prof)) {
        professions.add(prof);
        i++;
      }
    }

    List<String> companies = new ArrayList<String>();
    i = 0;
    while (i < 10) {
      String comp = faker.company().name();
      if (!companies.contains(comp)) {
        companies.add(comp);
        i++;
      }
    }

    Entreprise entreprise = new Entreprise(companies.get(faker.random().nextInt(0, companies.size() - 1)),
        faker.address().streetAddress(), faker.company().industry());
    entrepriseRepository.save(entreprise);

    Role role = new Role(professions.get(faker.random().nextInt(0, professions.size() - 1)));
    roleRepository.save(role);

    User user = new User(faker.name().firstName(), faker.name().lastName(), faker.date().birthday());
    user.setEntreprise(entreprise);
    user.setRole(role);

    userRepository.save(user);
  }
}
