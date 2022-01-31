package de.dion;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		Crosshair cross = new Crosshair();

		if (args.length > 0) {
			parseArgument(cross, args[0]);
			
			if(args.length > 1) {
				parseArgument(cross, args[1]);
			}
			
		} else {
			System.out.println();
			System.out.println("java -jar Crosshair.jar [<Größe>] [<Farbcode>]");
			System.out.println("StandartGröße: " + DefaultSettings.size);
			System.out.println("StandartFarbe: " + ColorHelper.toHexFormat(DefaultSettings.color));
		}
		System.out.println();
		
		//Make and Start the Frame
		cross.init();
		cross.start();
	}
	
	public static void keepAlive(Crosshair cross) {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {}
		}
	}

	public static void parseArgument(Crosshair cross, String arg) {
		if (arg.startsWith("#")) {
			Color col = ColorHelper.toColor(arg);
			cross.setColor(col);
			
		} else {
			try {
				int size = Integer.parseInt(arg);
				cross.setSize(size);
				
			} catch (NumberFormatException e) {
				System.out.println("unbekanntes Argument:");
				System.out.println("\"" + arg + "\" ist keine Farbe, aber auch keine Größe!");
			}
		}
	}

}
