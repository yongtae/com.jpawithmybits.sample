package jpawithmybatis.jpasrc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdsRepository extends JpaRepository<IdsEntity, Long>  {
}
