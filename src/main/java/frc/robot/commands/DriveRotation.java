// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveRotation extends CommandBase {

  private DriveSubsystem drive;
  private boolean direction; //true = right, false = left
  private double currentAngle;

  /** Creates a new DriveRotation. */
  public DriveRotation(DriveSubsystem drive, boolean direction) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    this.direction = direction;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (direction) {
      drive.arcadeDrive(0, 0.7);
    } else {
      drive.arcadeDrive(0, -0.7);
    }
    currentAngle = drive.getRotation().getDegrees();
    System.out.println(currentAngle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
    System.out.println(currentAngle);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(currentAngle) > 80) {
      return true;
    }
    return false;
  }
}
