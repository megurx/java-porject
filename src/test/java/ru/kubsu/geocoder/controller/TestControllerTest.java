package ru.kubsu.geocoder.controller;

import org.junit.jupiter.api.*;
import ru.kubsu.geocoder.util.TestUtil;

import static org.junit.jupiter.api.Assertions.*;

class TestControllerTest {


    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUP");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");

    }

    @Test
    void test() {
        assertEquals(3,TestUtil.sum(1,2));
        assertEquals(35,TestUtil.sum(30,5));
        assertEquals(0,TestUtil.sum(0,0));
        assertEquals(10,TestUtil.sum(5,5));

    }

    @Test
    void test2() {
        assertEquals(4,2 + 2);
    }

    @Test
    void test3() {
        System.out.println("test2");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }
}