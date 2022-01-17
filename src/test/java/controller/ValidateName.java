package controller;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class ValidateName {

    private DepositController depositController;
    @BeforeEach
    void setUp() throws Exception {
        depositController = new DepositController();
    }

    @ParameterizedTest
    @CsvSource({
            ", false",
            "'', false",
            "'#12 asbfdd?', false",
            "'123213 4acv', true"
    })


    void test(String s, boolean expected) {
        // when
        boolean isValid = depositController.validateName(s);
        //then
        assertEquals(expected, isValid);
    }

}
