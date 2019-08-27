package com.tactfactory.monsuperprojet.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.tactfactory.monsuperprojet.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
