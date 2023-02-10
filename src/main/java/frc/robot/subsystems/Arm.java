// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.AbsoluteEncoder;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//TODO FINISH THIS AND WRITE ENCODER CODE
public class Arm extends SubsystemBase {
  MotorController shoudler1;
  MotorController shoudler2;
  MotorControllerGroup shoudler;

  MotorController      arm1;
  MotorController      arm2;
  MotorControllerGroup arm;

  MotorController wrist;

  /** Creates a new Arm. */
  public Arm() {

    shoudler1 = new CANSparkMax(Constants.Shoulder1Motor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) shoudler1).restoreFactoryDefaults();
    shoudler2 = new CANSparkMax(Constants.Shoulder2Motor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) shoudler2).restoreFactoryDefaults();

    shoudler = new MotorControllerGroup(shoudler1, shoudler2);

    arm1 = new CANSparkMax(Constants.Arm1Motor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) arm1).restoreFactoryDefaults();
    arm2 = new CANSparkMax(Constants.Arm2Motor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) arm2).restoreFactoryDefaults();

    arm = new MotorControllerGroup(arm1, arm2);

    wrist = new CANSparkMax(Constants.WristMotor, MotorType.kBrushless);
    ((CANSparkMaxLowLevel) wrist).restoreFactoryDefaults();
  }

  public void moveShoulder(Double speed) {
    shoudler.set(speed);
  }

  public void moveArm(Double speed) {
    arm.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
