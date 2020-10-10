package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private static Temperatures temperaturesMock;

    @BeforeEach
    void createTemperaturesMap() {
        Map<String, Double> temperaturesMap;
        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }


    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testMeanValueOfTemperatureWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        Double sumOfTemperatures = 0.0;
        for (Double temperatureValue : weatherForecast.calculateForecast().values()) {
            sumOfTemperatures += temperatureValue;
        }
        //weatherForecast.calculateForecast().values().a
        double meanValueOfTemperature = sumOfTemperatures / weatherForecast.calculateForecast().size();

        //zaokrąglenie wyniku z weatherForecast ponieważ wychodziło jakieś 26.560000000000002
        BigDecimal bd = new BigDecimal(meanValueOfTemperature);
        bd = bd.round(new MathContext(4));
        double roundedMeanValueOfTemperature = bd.doubleValue();

        //Then
        Assertions.assertEquals(26.56, roundedMeanValueOfTemperature);
    }

    @Test
    void testMedianOfTemperatureWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        Double medianValueOfTemperature;
        List<Double> values = new ArrayList<>();
        for (Double key: weatherForecast.calculateForecast().values()) {
            for (int i = 0; i < temperaturesMock.getTemperatures().size(); i++) {
                values.add(key);
            }
        }
        Collections.sort(values);

        if (values.size() % 2 == 1)
            medianValueOfTemperature = values.get((values.size() + 1) / 2 - 1);
        else {
            Double lower = values.get(values.size() / 2 - 1);
            Double upper = values.get(values.size() / 2);
            medianValueOfTemperature = (lower + upper) / 2.0;
        }
        //Then
        Assertions.assertEquals(26.5, medianValueOfTemperature);

    }
}
