package uni.sw.unit.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest{

    @Test
    public void testGenericTriangle(){
        Triangle triangle = new Triangle(3,4,6);
        assertTrue(triangle instanceof Triangle);
        assertFalse(triangle.isIsosceles());
        assertFalse(triangle.isEquilateral());
        assertFalse(triangle.isRightAngeled());
    }

    @Test
    public void testIsoscelesTriangle(){
        Triangle triangle = new Triangle(3,3,5);
        assertTrue(triangle.isIsosceles());

        Triangle triangle2 = new Triangle(3,5,5);
        assertTrue(triangle2.isIsosceles());
    }

    @Test
    public void testEquilateralTriangle(){
        Triangle triangle = new Triangle(5, 5, 5);
        assertTrue(triangle.isIsosceles());
        assertTrue(triangle.isEquilateral());
    }

    @Test
    public void testRightAngledTriangle(){
        Triangle triangle = new Triangle(3, 4, 5);
        assertTrue(triangle.isRightAngeled());
        assertFalse(triangle.isEquilateral());
    }

    @Test
    public void testPerimeter(){
        Triangle triangle = new Triangle(3,5,5);
        assertEquals(13, triangle.getPerimeter(), "Expected value does not match the actual perimeter");
    }

    @Test
    public void testArea(){
        Triangle triangle = new Triangle(3,4,5);
        assertEquals(6, triangle.getArea(), "Expected value does not match the actual area");
    }

    @Test
    public void testNotConstructableTriangle(){
        Exception exception = assertThrows(ArithmeticException.class, () ->{
            new Triangle(3,4,7);
        });
        assertTrue(exception.getMessage().contains("The triangle cannot be constructed from the the numbers"));

        assertThrows(ArithmeticException.class, () ->{
            new Triangle(3,7,4);
        });

        assertThrows(ArithmeticException.class, () ->{
            new Triangle(7,3,4);
        });

    }
}