package auto.backe.auto_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import auto.backe.auto_project.models.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
