package org.firstinspires.ftc.teamcode.opmodes.teleop

import alonlib.TelemetryLevel
import alonlib.commands.CommandOpMode
import alonlib.throttleTo
import alonlib.units.Alliance
import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry
import com.qualcomm.hardware.lynx.LynxModule
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.RobotContainer

@TeleOp(name = "Blue Main Teleop", group = "Teleop")
class BlueTestingTeleop : CommandOpMode() {

	val telemetryLevel = TelemetryLevel.Testing
	val alliance = Alliance.Blue

	override fun initialize() {
		hardwareMap.get(LynxModule::class.java, "Control Hub").apply {
			bulkCachingMode = LynxModule.BulkCachingMode.MANUAL
		}
		telemetry = MultipleTelemetry(telemetry, FtcDashboard.getInstance().telemetry)
		telemetry.throttleTo(telemetryLevel)
		telemetry.addLine("Robot initializing")
		RobotContainer(
			hardwareMap,
			telemetry,
			gamepad1,
			gamepad2,
			alliance,
			telemetryLevel
		)
		telemetry.update()
	}

	override fun run() {
		hardwareMap.get(LynxModule::class.java, "Control Hub").clearBulkCache()
		super.run()
		telemetry.update()
	}
}
