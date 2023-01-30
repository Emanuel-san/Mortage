package app.mortage.calculator;

import app.mortage.Mortage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortageCalculatorTest {

    @Test
    void monthlyPayment() {
        Mortage p1 = new Mortage("Juha",1000,5,2);
        Mortage p2 = new Mortage("Karvinen",4356,1.27,6);
        Mortage p3 = new Mortage("Claes Månsson",1300.55,8.67,2);
    }
}