package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockTC;
    TrainUser mockTU;
    TrainSensor trainSensor;
    @Before
    public void before() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC,mockTU);
    }

    @Test
    public void AbsoluteMinMarginTest() {
        trainSensor.overrideSpeedLimit(-1);
        verify(mockTU, times(1)).setAlarmState(true);
    }


    @Test
    public void AbsoluteMaxMarginTest() {
        trainSensor.overrideSpeedLimit(501);
        verify(mockTU, times(1)).setAlarmState(true);
    }


    @Test
    public void RelativeBigMarginTest() {
        trainSensor.overrideSpeedLimit(50);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void RelativeSmallMarginTest() {
        trainSensor.overrideSpeedLimit(140);
        verify(mockTU, times(1)).setAlarmState(false);
    }

}
