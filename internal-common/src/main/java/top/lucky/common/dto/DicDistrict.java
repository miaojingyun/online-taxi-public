package top.lucky.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DicDistrict {

    private String addressCode;

    private String addressName;

    private String parentAddressCode;

    private Integer level;
}