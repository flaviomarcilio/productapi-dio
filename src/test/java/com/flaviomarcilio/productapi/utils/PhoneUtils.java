package com.flaviomarcilio.productapi.utils;

import com.flaviomarcilio.productapi.dto.request.PhoneDTO;
import com.flaviomarcilio.productapi.entity.Phone;
import com.flaviomarcilio.productapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "(31)99876-5432";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
