package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD:  ShapeCollector Test Suite")
class ShapeCollectorTestSuite {
    ShapeCollector shapeCollector;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Let the tests begin.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished. Thank you for your patience.");
    }

    @Nested
    public class TestsAddFigure {
        @DisplayName("Test of adding new figure to empty base")
        @Test
        public void testAddFigureToEmptyBase() {
            //Given
            shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle());

            //Then
            assertEquals("Circle", shapeCollector.getFigure(0).getShapeName());
        }

        @DisplayName("Test of adding new figure to base with some records")
        @Test
        public void testAddNextFigure() {
            //Given
            shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Triangle());
            boolean result = shapeCollector.addFigure(new Circle());

            //Then
            assertTrue(result);

        }
    }

    @Nested
    public class TestsRemoveFigure {
        @DisplayName("Test of removing figure")
        @Test
        public void testRemoveFigure() {
            //Given
            shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Triangle());

            boolean result = shapeCollector.removeFigure(new Circle());

            //Then
            assertTrue(result);
        }

        @DisplayName("Test of removing figure from empty base")
        @Test
        public void testRemoveFigureEmptyBase() {
            //Given
            shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Circle());

            //When
            boolean result = shapeCollector.removeFigure(new Circle());

            //Then
            assertTrue(result);
        }
    }

    @Nested
    public class TestsGetFigure {
        @DisplayName("Test of getting figure from 1st position")
        @Test
        public void testGetFigure1stPosition() {
            //Given
            shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());

            //Then
            assertEquals("Circle", shapeCollector.getFigure(0).getShapeName());
        }

        @DisplayName("Test of getting figure from 4th position")
        @Test
        public void testGetFigure3rdPosition() {
            //Given
            shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());
            shapeCollector.addFigure(new Triangle());
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());

            //Then
            assertEquals("Circle", shapeCollector.getFigure(3).getShapeName());
        }

        @DisplayName("Test of getting figure from empty base")
        @Test
        public void testGetFigureEmptyBase() {
            //Given
            shapeCollector = new ShapeCollector();

            //When

            //Then
            assertNull(shapeCollector.getFigure(0));
        }
    }

    @Nested
    public class TestsShowFigures {
        @DisplayName("Test of showing figures from existing base")
        @Test
        public void testShowFigures() {
            //Given
            shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());
            shapeCollector.addFigure(new Triangle());
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());

            //Then
            assertEquals("Circle Square Triangle Circle Square", shapeCollector.showFigures());
        }

        @DisplayName("Test of showing figures from empty base")
        @Test
        public void testShowFiguresEmptyBase() {
            //Given
            shapeCollector = new ShapeCollector();

            //When
            shapeCollector.removeFigure(new Circle());

            //Then
            assertEquals("", shapeCollector.showFigures());
        }
    }
}
