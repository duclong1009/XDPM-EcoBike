package controller;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class ValidateCardNumber {

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
            "'12ac', false",
            "'123', true",
            "'123123123123123', false"
    })


    void test(String s, boolean expected) {
        // when
        boolean isValid = depositController.validateCardNumber(s);
        //then
        assertEquals(expected, isValid);
    }

}
