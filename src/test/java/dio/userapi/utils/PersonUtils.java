package dio.userapi.utils;

import dio.userapi.dto.request.UserDTO;
import dio.userapi.entity.User;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Math";
    private static final String LAST_NAME = "Thomaz";
    private static final String CPF_NUMBER = "432.360.798-94";
    private static final long USER_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static UserDTO createFakeDTO() {
        return UserDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("05-07-1994")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static User createFakeEntity() {
        return User.builder()
                .id(USER_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
