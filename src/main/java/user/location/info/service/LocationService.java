package user.location.info.service;

import java.util.List;

import user.location.info.dto.LocationDto;
import user.location.info.dto.LocationResponseDto;

public interface LocationService {

	void saveUserCurrentLocation(LocationDto locationDto, Long userId);

	boolean userLocationExists(Long userId);

	List<LocationResponseDto> viewUserCurrentLocation(Long userId, int limit);

}
