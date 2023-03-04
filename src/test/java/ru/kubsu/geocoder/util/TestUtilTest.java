package ru.kubsu.geocoder.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestUtilTest {

    @Test
    void unitTes() {
        assertEquals(3,TestUtil.sum(1,2));
        assertEquals(35,TestUtil.sum(30,5));
        assertEquals(0,TestUtil.sum(0,0));
        assertEquals(10,TestUtil.sum(5,5));

    }
}