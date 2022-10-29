import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class urinalsTest{

    @Test
    @DisplayName("====== Shivanjay Wagh == GoodString Method ---> Empty string test =======")
    void is_Empty_String() {
        boolean check = urinals.goodString(" ");
        assertFalse(check);
    }

    @Test
    @DisplayName("====== Shivanjay Wagh == Good String Method -> good string test =======")
    void is_Good_String() {
        boolean check1 = urinals.goodString("010101");
        assertTrue(check1);
    }







}