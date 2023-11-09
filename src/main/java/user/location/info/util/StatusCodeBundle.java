package user.location.info.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:MessagesAndCodes.properties")

public class StatusCodeBundle {

	// Common Success code
	@Value("${code.success.common}")
	private String commonSuccessCode;

	@Value("${code.failure.common}")
	private String failureCode;

	// Location
	@Value("${message.success.save.location}")
	private String saveUserCurrentLocationSuccessMessage;

	@Value("${message.validation.view.location}")
	private String getUserCurrentLocationValidationMessage;

	@Value("${code.validation.view.location}")
	private String getUserCurrentLocationValidationCode;

	public String getCommonSuccessCode() {
		return commonSuccessCode;
	}

	public void setCommonSuccessCode(String commonSuccessCode) {
		this.commonSuccessCode = commonSuccessCode;
	}

	public String getFailureCode() {
		return failureCode;
	}

	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}

	public String getSaveUserCurrentLocationSuccessMessage() {
		return saveUserCurrentLocationSuccessMessage;
	}

	public void setSaveUserCurrentLocationSuccessMessage(String saveUserCurrentLocationSuccessMessage) {
		this.saveUserCurrentLocationSuccessMessage = saveUserCurrentLocationSuccessMessage;
	}

	public String getGetUserCurrentLocationValidationMessage() {
		return getUserCurrentLocationValidationMessage;
	}

	public void setGetUserCurrentLocationValidationMessage(String getUserCurrentLocationValidationMessage) {
		this.getUserCurrentLocationValidationMessage = getUserCurrentLocationValidationMessage;
	}

	public String getGetUserCurrentLocationValidationCode() {
		return getUserCurrentLocationValidationCode;
	}

	public void setGetUserCurrentLocationValidationCode(String getUserCurrentLocationValidationCode) {
		this.getUserCurrentLocationValidationCode = getUserCurrentLocationValidationCode;
	}
}
