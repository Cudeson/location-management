package user.location.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import user.location.info.dto.LocationDto;
import user.location.info.response.BaseResponse;
import user.location.info.response.ValidationFailureResponse;
import user.location.info.rest.enums.RequestStatus;
import user.location.info.service.LocationService;
import user.location.info.util.StatusCodeBundle;

@RestController
public class LocationController {

	@Autowired
	private StatusCodeBundle statusCodeBundle;
	@Autowired
	private LocationService locationService;

	@PostMapping("/users/{user_id}/locations")
	public ResponseEntity<Object> createUserLocation(@PathVariable Long user_id, @RequestBody LocationDto locationDto) {
		locationService.saveUserCurrentLocation(locationDto, user_id);
		return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
				statusCodeBundle.getCommonSuccessCode(), statusCodeBundle.getSaveUserCurrentLocationSuccessMessage()));
	}

	@GetMapping("/users/{userId}/locations")
	public ResponseEntity<Object> getUserCurrentLocation(@PathVariable Long userId,
			@RequestParam(name = "limit", required = false, defaultValue = "1") int limit) {

		if (!locationService.userLocationExists(userId)) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(statusCodeBundle.getGetUserCurrentLocationValidationMessage(),
							statusCodeBundle.getGetUserCurrentLocationValidationCode()),
					HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(locationService.viewUserCurrentLocation(userId, limit), HttpStatus.OK);
	}
}
