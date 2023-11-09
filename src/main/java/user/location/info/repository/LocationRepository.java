package user.location.info.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.location.info.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	boolean existsByUserId(Long userId);

	boolean existsByUserIdAndLatitudeAndLongitude(Long userId, double latitude, double longitude);

	List<Location> findByUserIdOrderByTimestampDesc(Long userId);

}
