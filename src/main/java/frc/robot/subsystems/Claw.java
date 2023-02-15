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

public class Claw extends SubsystemBase {

  MotorController claw;
  RelativeEncoder clawEncoder;

  /** Creates a new Claw. */
  public Claw() {
    claw = new CANSparkMax(Constants.ClawMotor, MotorType.kBrushless);
    clawEncoder = ((CANSparkMax) claw).getEncoder();
    clawEncoder.setPosition(0);

  }

  //FIXME Possibly fucked. Beware
  public void moveClaw(Double speed) {
    double pos = clawEncoder.getPosition();
    if (speed > Constants.ClawDeadzone && pos < Constants.ClawMaxExtent) {
      claw.set(speed);
    } else if (speed <= Constants.ClawDeadzone && pos > 0) {
      claw.set(Constants.ClawCloseSpeed);
    } else {
      claw.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
