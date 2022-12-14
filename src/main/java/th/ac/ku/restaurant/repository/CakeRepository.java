package th.ac.ku.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.restaurant.model.Cake;

import java.util.UUID;

@Repository
public interface CakeRepository extends JpaRepository<Cake, UUID>
{
}

