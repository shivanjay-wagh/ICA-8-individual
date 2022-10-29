import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    @DisplayName("====== Shivanjay Wagh == Good String Method -> bad string test =======")
    void is_Bad_String() {
        boolean check2 = urinals.goodString("0101100");
        assertFalse(check2);
    }

    @Test
    @DisplayName("====== Shivanjay Wagh == Good String Method -> string length test =======")
    void checkStringLength() {
        boolean check1 = urinals.goodString("010101010101010101010101010101");
        assertFalse(check1);
    }


    @Test
    @DisplayName("====== Shivanjay Wagh == countUrinals Method =======")
    void countUrinals() {
        int empty_Urinals = urinals.countUrinals("10001");
        assertEquals(1, empty_Urinals);
    }


    @Test
    @DisplayName("====== Shivanjay Wagh == Test Case if File Exists =======")
    void fileNotFound()  {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL fileURL = classLoader.getResource("urinal.dat");
        assert fileURL != null;
        File file = new File(fileURL.getFile());
        assertTrue(file.exists());
    }



}