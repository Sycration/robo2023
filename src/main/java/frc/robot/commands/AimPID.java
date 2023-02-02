// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Limelight;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AimPID extends PIDCommand {
  /** Creates a new AimPID. */
  public AimPID() {
    
    super(
        // The controller that the command will use
        new PIDController(Constants.AimPidP, Constants.AimPidI, Constants.AimPidD),
        // This should return the measurement
        Limelight::getYaw,
        // This should return the setpoint (can also be a constant)
        () -> 0,
        // This uses the output
        output -> {
          SmartDashboard.putNumber("Aim PID output", output);
          Double div = output / Constants.AimDivide;
          Double min = 0.0;
          if(div > 0) {
            min = Math.min(div, 1) * Constants.AimSpeedScale;
          } else {
            min = Math.max(div, -1) * Constants.AimSpeedScale;
          }
          SmartDashboard.putNumber("Aim PID divided", div);

          SmartDashboard.putNumber("Aim PID calculated", min);

          RobotContainer.drive.drive(min, -min);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drive);
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
