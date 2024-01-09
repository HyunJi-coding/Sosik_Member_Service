package com.example.sosikmemberservice.dto.response;

import com.example.sosikmemberservice.model.entity.WeightEntity;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class GetWeight {

    private Long id;
    private BigDecimal currentWeight;
    private BigDecimal targetWeight;

    @Builder
    public GetWeight(Long id, BigDecimal currentWeight, BigDecimal targetWeight) {
        this.id = id;
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
    }

    public static GetWeight create(WeightEntity weight) {
        return GetWeight.builder()
                .id(weight.getId())
                .currentWeight(weight.getCurrentWeight())
                .targetWeight(weight.getTargetWeight())
                .build();
    }


}
