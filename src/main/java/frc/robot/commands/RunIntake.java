// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
 import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;

public class RunIntake extends CommandBase {
  private final CommandXboxController m_driverController;

  /** Creates a new runIntake. */
  public RunIntake() {
    m_driverController = new CommandXboxController(OperatorConstants.kArmControllerPort);

    addRequirements(RobotContainer.intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double t = m_driverController.getRightTriggerAxis();

    double sgnT = Math.signum(t);
    RobotContainer.intake.moveIntake((t * t * sgnT) * Constants.IntakeSpeedScale);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
