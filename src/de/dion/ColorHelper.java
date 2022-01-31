package de.dion;

import java.awt.Color;

public class ColorHelper {
	
	public static String toHexFormat(Color col) {
		String out = "";
		String temp;
		
		temp = Integer.toHexString(col.getAlpha());
		if(!temp.equalsIgnoreCase("ff")) {
			out += temp.length() == 2 ? temp : "0" + temp;
		}
		
		temp = Integer.toHexString(col.getRed());
		out += temp.length() == 2 ? temp : "0" + temp;
		temp = Integer.toHexString(col.getGreen());
		out += temp.length() == 2 ? temp : "0" + temp;
		temp = Integer.toHexString(col.getBlue());
		out += temp.length() == 2 ? temp : "0" + temp;
		
		if(out.length() > 0) {
			return "#" + out.toUpperCase();
		}
		return null;
	}
	
	public static Color toColor(String hex) {
		Color col;
		int value;
		
		//Formatiere String
		hex = hex.trim().toUpperCase();
		if(hex.startsWith("#")) {
			hex = hex.substring(1);
		}
		
		//Wenn die Länge 8 ist, enthällt der String Alpha Werte.
		if(hex.length() >= 8) {
			int a = hexToInt(hex.substring(0, 2));
			int r = hexToInt(hex.substring(2, 4));
			int g = hexToInt(hex.substring(4, 6));
			int b = hexToInt(hex.substring(6, 8));
			
			value = a << 24 | r << 16 | g << 8 | b;
			col = new Color(value, true);
		} else {
			value = hexToInt(hex);
			col = new Color(value, false);
		}
		
		return col;
	}
	
	private static int hexToInt(String hex) {
		int count = 0;
		
		int hoch = 0;
		for(int i = hex.length() - 1; i >= 0; i--) {
			int z = 0;
			
			switch(hex.charAt(i)) {
				case 'A':
					z = 10;
					break;
				case 'B':
					z = 11;
					break;
				case 'C':
					z = 12;
					break;
				case 'D':
					z = 13;
					break;
				case 'E':
					z = 14;
					break;
				case 'F':
					z = 15;
					break;
				default:
					z = Integer.parseInt(hex.charAt(i) + "");
			}
			
			count += Math.pow(16, hoch) * z;
			hoch++;
		}
		return count;
	}
	
}
