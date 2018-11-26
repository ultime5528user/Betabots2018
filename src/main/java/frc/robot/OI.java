/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoPlateformeDroiteA;
import frc.robot.commands.BougerTreuil;
import frc.robot.commands.CracherBalles;
import frc.robot.commands.PrendreBalles;
import frc.robot.commands.Viser;
import frc.robot.util.CubicInterpolator;
import frc.robot.commands.DescendreTreuil;
import frc.robot.commands.FermerPorte;
import frc.robot.commands.MonterTreuil;
import frc.robot.commands.OuvrirPorte;

public class OI {

  private Joystick joystick;
  private XboxController xbox;
  private JoystickButton buttonA;
  private JoystickButton buttonB;
  private JoystickButton buttonX;
  private JoystickButton buttonY;
  private JoystickButton button6;
  private JoystickButton button5;
  private JoystickButton button7;
  private JoystickButton button1, button2, button3;

  private CubicInterpolator interY;

  public OI() {

    interY = new CubicInterpolator(K.BasePilotable.INTERY_COURBURE, K.BasePilotable.INTERY_DEADZONE_VITESSE, K.BasePilotable.INTERY_DEADZONE_JOYSTICK);

    joystick = new Joystick(0);
    xbox = new XboxController(1);

    buttonA = new JoystickButton(xbox, 1);
    buttonA.whileHeld(new BougerTreuil(K.Intake.TREUIL_POT_MIN));

    buttonB = new JoystickButton(xbox, 2);
    buttonB.whileHeld(new BougerTreuil(K.Intake.TREUIL_HAUTEUR_CAROTTE));

    button3 = new JoystickButton(joystick, 3);
    button3.toggleWhenPressed(new Viser());
    buttonX = new JoystickButton(xbox, 3);
    buttonX.toggleWhenPressed(new BougerTreuil(K.Intake.TREUIL_POT_MAX));


    buttonY = new JoystickButton(xbox, 4);
    buttonY.toggleWhenPressed(new BougerTreuil(K.Intake.TREUIL_HAUTEUR_BALLE));

    button7 = new JoystickButton(joystick, 7);
    button7.toggleWhenPressed(new AutoPlateformeDroiteA());
    button5 = new JoystickButton(joystick, 5);
    button5.toggleWhenPressed(new OuvrirPorte());

    SmartDashboard.putData("AutonomePlateformeDroiteA", new AutoPlateformeDroiteA());

    button6 = new JoystickButton(joystick, 6);
    button6.toggleWhenPressed(new FermerPorte());


  }

  public Joystick getJoystick() {

    return joystick;

  }

  public CubicInterpolator getInterY() {

    return interY;

  }

}