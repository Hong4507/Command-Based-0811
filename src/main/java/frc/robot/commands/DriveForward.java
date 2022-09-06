package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForward extends CommandBase{

    private DriveSubsystem drive;
    private double initTime;

    public DriveForward(DriveSubsystem drive){
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        initTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        drive.arcadeDrive(0.7, 0);
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("Interrupted");
        }
        drive.arcadeDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        if(Timer.getFPGATimestamp() > initTime + 0.5){
            return true;
        }
        return false;
    }
} 
