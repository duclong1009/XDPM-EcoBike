package controller;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class ValidateSecretCode {

    private DepositController depositController;
    @BeforeEach
    void setUp() throws Exception {
        depositController = new DepositController();
    }

    @ParameterizedTest
    @CsvSource({
            ", false",
            "'', false",
            "'12', false",
            "'123451234561234512345', false",
            "'123a bscd df', false",
            "'1231asbg, true"
    })


    void test(String s, boolean expected) {
        // when
        boolean isValid = depositController.validateSecurityCode(s);
        //then
        assertEquals(expected, isValid);
    }

}
