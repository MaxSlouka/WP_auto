package auto.backe.auto_project.repo;

import auto.backe.auto_project.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findCarById(Long id);
}
