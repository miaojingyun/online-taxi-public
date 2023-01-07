package top.lucky.common.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jane
 * @date 2022/10/7, 18:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerificationCodeDto {
	private String passengerPhone;
	private String verificationCode;
}
