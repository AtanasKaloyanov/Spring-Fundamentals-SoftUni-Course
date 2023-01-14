package bg.softuni.mobilele.repository;

import bg.softuni.mobilele.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
