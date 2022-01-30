package com.geekbrains.Lesson4;

import Lesson4.Functions;
import org.junit.jupiter.api.*;

public class FunctionTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Выаполнение 1 раз перед тестами");

    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Выполение перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка метода isPrime с целым числом")
    void givenPrimeNumberWhenRunIsPrimeMethodThenTrue() {
        boolean result = Functions.isPrime(7);
        Assertions.assertTrue(result);
    }

    @Test
    void isPolindromeTest (){
        Assertions.assertEquals(true,Functions.isPolindrome("1235321"));
    }

    @AfterEach
    void afterEach() {
        System.out.println("Выполнение после каждого теста");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Выполенине 1 раз после всех тестов");
    }

}
