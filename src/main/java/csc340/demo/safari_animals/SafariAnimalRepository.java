package csc340.demo.safari_animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SafariAnimalRepository extends JpaRepository<SafariAnimal, Integer> {

    @Query(value = "select * from animals s where s.name like %?1% ", nativeQuery = true)
    List<SafariAnimal> getSafariAnimalsByName(String name);

    @Query(value = "select * from animals s where s.diet like %?1% ", nativeQuery = true)
    List<SafariAnimal> getSafariAnimalsByDiet(String diet);


}
