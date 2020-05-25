package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private int referenceSpeed;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		//this.referenceSpeed = controller.getReferenceSpeed();
		this.referenceSpeed = 100;
	}

	public void setReferenceSpeed(int referenceSpeed) {
		this.referenceSpeed = referenceSpeed;
	}

	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		alarm(speedLimit);
		controller.setSpeedLimit(speedLimit);
	}

	private void alarm(int speedLimit) {
		if (isAbsoluteMargin() || isRelativeMargin(speedLimit)) {
			user.setAlarmState(true);
		} else {
			user.setAlarmState(false);
		}
	}

	private boolean isAbsoluteMargin() {
		return speedLimit > 500 || speedLimit < 0;
	}

	private boolean isRelativeMargin(int speedLimit) {
		return 0.5 * getReferenceSpeed() > speedLimit;
	}

}
