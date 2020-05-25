package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController mockTrainController;
    TrainUser mockTrainUser;
    TrainSensor mockTrainSensor;

    @Before
    public void before() {
        mockTrainController = mock(TrainController.class);
        mockTrainUser = mock(TrainUser.class);
        mockTrainSensor = new TrainSensorImpl(mockTrainController, mockTrainUser);
    }

    @Test
    public void testAlarmAbsoluteMarginBiggerThanLimit() {
        mockTrainSensor.overrideSpeedLimit(510);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void testAlarmAbsoluteMarginSmallerThanLimit() {
        mockTrainSensor.overrideSpeedLimit(-10);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void testAlarmRelativeMarginNotAllowed() {
        mockTrainSensor.overrideSpeedLimit(70);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }

    @Test
    public void testAlarmRelativeMarginAllowed() {
        mockTrainSensor.overrideSpeedLimit(40);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }
}
