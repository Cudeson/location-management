package user.location.info.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.location.info.dto.LocationDto;
import user.location.info.dto.LocationResponseDto;
import user.location.info.entity.Location;
import user.location.info.entity.User;
import user.location.info.repository.LocationRepository;
import user.location.info.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository LocationRepository;

	@Transactional
	public void saveUserCurrentLocation(LocationDto locationDto, Long userId) {
		Location location = new Location();
		BeanUtils.copyProperties(locationDto, location);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		location.setTimestamp(timestamp);
		User user = new User();
		user.setId(userId);
		location.setUser(user);
		LocationRepository.save(location);
	}

	@Override
	public boolean userLocationExists(Long userId) {
		return LocationRepository.existsByUserId(userId);
	}

	@Override
	public List<LocationResponseDto> viewUserCurrentLocation(Long userId, int limit) {
		List<LocationResponseDto> locationResponseDtoList = new ArrayList<>();
		List<Location> locationList = LocationRepository.findByUserIdOrderByTimestampDesc(userId);
		for (Location location : locationList) {
			LocationResponseDto locationResponseDto = new LocationResponseDto();
			BeanUtils.copyProperties(location, locationResponseDto);
			locationResponseDtoList.add(locationResponseDto);
		}
		return locationResponseDtoList.stream().limit(limit).collect(Collectors.toList());
	}

}
