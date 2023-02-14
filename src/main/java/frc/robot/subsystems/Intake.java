// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake extends SubsystemBase {

  MotorController intake;
  RelativeEncoder intakeEncoder;

  /** Creates a new Intake. */
  public Intake() {
    intake = new CANSparkMax(Constants.IntakeMotor, MotorType.kBrushless);
    intakeEncoder = ((CANSparkMax) intake).getEncoder();
    intakeEncoder.setPosition(0);

  }

  //FIXME Possibly fucked. Beware
  public void moveIntake(Double speed) {
    double pos = intakeEncoder.getPosition();
    if (speed > Constants.IntakeDeadzone && pos < Constants.IntakeMaxExtent) {
      intake.set(speed);
    } else if (speed <= Constants.IntakeDeadzone && pos > 0) {
      intake.set(Constants.IntakeCloseSpeed);
    } else {
      intake.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
