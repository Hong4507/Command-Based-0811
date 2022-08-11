package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.SPI;

public class DriveSubsystem extends SubsystemBase{

  // Declare motors
  WPI_TalonFX motorFR = new WPI_TalonFX(Constants.FRmotorID);
  WPI_TalonFX motorFL = new WPI_TalonFX(Constants.FLmotorID);
  WPI_TalonFX motorRR = new WPI_TalonFX(Constants.RRmotorID);
  WPI_TalonFX motorRL = new WPI_TalonFX(Constants.RLmotorID);

  MotorControllerGroup m_rightGroup = new MotorControllerGroup(motorFR, motorFL);
  MotorControllerGroup m_leftGroup = new MotorControllerGroup(motorRL, motorRR);

  DifferentialDrive m_drive = new DifferentialDrive(m_rightGroup, m_leftGroup);

  AHRS m_gyro = new AHRS(SPI.Port.kMXP);
    
  public DriveSubsystem() {
      motorFR.setInverted(true);
      motorFL.setInverted(true);
      m_gyro.reset();
  }

  public void arcadeDrive(double speed, double turn) {
      m_drive.arcadeDrive(speed, turn);
  }

  public Rotation2d getRotation() {
    return m_gyro.getRotation2d();
  }
}
