// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//TODO FINISH THIS AND WRITE ENCODER CODE
public class Arm extends SubsystemBase {
  MotorController shoudler1;
  MotorController shoudler2;
  MotorControllerGroup shoudler;
  RelativeEncoder shoulderEncoder;

  MotorController arm1;
  MotorController arm2;
  MotorControllerGroup arm;
  RelativeEncoder armEncoder;

  MotorController wrist;
  RelativeEncoder wristEncoder;

  /** Creates a new Arm. */
  public Arm() {

    shoudler1 = new CANSparkMax(Constants.Shoulder1Motor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) shoudler1).restoreFactoryDefaults();
    shoudler2 = new CANSparkMax(Constants.Shoulder2Motor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) shoudler2).restoreFactoryDefaults();

    shoudler = new MotorControllerGroup(shoudler1, shoudler2);
    shoulderEncoder = ((CANSparkMax) shoudler1).getEncoder();
    shoulderEncoder.setPosition(0);

    arm1 = new CANSparkMax(Constants.Arm1Motor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) arm1).restoreFactoryDefaults();
    arm2 = new CANSparkMax(Constants.Arm2Motor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) arm2).restoreFactoryDefaults();

    arm = new MotorControllerGroup(arm1, arm2);
    armEncoder = ((CANSparkMax) arm1).getEncoder();
    armEncoder.setPosition(0);

    wrist = new CANSparkMax(Constants.WristMotor, MotorType.kBrushless);
    wristEncoder = ((CANSparkMax) wrist).getEncoder();
    wristEncoder.setPosition(0);

    ((CANSparkMaxLowLevel) wrist).restoreFactoryDefaults();
  }

  public void moveShoulder(Double speed) {
    double pos = shoulderEncoder.getPosition();
    if (speed >= 0 && pos < Constants.ShoulderMaxExtent) {
      shoudler.set(speed);
    } else if (speed < 0 && pos > 0) {
      shoudler.set(speed);
    } else {
      shoudler.set(0);
    }
  }

  public void moveArm(Double speed) {
    double pos = armEncoder.getPosition();
    if (speed >= 0 && pos < Constants.ArmMaxExtent) {
      arm.set(speed);
    } else if (speed < 0 && pos > 0) {
      arm.set(speed);
    } else {
      arm.set(0);
    }
  }

  public void moveWrist(Double speed) {
    double pos = wristEncoder.getPosition();
    if (speed > Constants.WristDeadzone && pos < Constants.WristMaxExtent) {
      wrist.set(speed);
    } else if (speed <= Constants.WristDeadzone && pos > 0) {
      wrist.set(Constants.WristCloseSpeed);
    } else {
      wrist.set(0);
    }
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }
}
