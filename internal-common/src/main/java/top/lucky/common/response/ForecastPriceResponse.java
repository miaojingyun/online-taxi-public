package top.lucky.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ForecastPriceResponse {

    private double price;

    private String cityCode;

    private String vehicleType;

    private String fareType;

    private Integer fareVersion;
}