package tires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class TiresTests {

    @Test
    public void alarmShouldBeTurnedOnOnLowPressure() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Sensor mockedSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(10.0);

        Field field = alarm.getClass().getDeclaredField("sensor");

        field.setAccessible(true);

        field.set(alarm, mockedSensor);

        alarm.check();

        assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void alarmShouldBeTurnedOnOnHighPressure() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Sensor mockedSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(30.0);

        Field field = alarm.getClass().getDeclaredField("sensor");

        field.setAccessible(true);

        field.set(alarm, mockedSensor);

        alarm.check();

        assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void alarmShouldBeTurnedOffOnEdgePressure() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Sensor mockedSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(17.0);

        Field field = alarm.getClass().getDeclaredField("sensor");

        field.setAccessible(true);

        field.set(alarm, mockedSensor);

        alarm.check();

        assertFalse(alarm.getAlarmOn());

    }

    @Test
    public void alarmShouldBeTurnedOffOnLowPressure() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Sensor mockedSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(19.0);

        Field field = alarm.getClass().getDeclaredField("sensor");

        field.setAccessible(true);

        field.set(alarm, mockedSensor);

        alarm.check();

        assertFalse(alarm.getAlarmOn());

    }

}
