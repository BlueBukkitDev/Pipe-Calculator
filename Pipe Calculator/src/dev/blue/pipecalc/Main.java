package dev.blue.pipecalc;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<Pipe> parts = new ArrayList<Pipe>();
	public static String version = "1.3";
	public static int format = 1;
	public static int accuracy = 16;
	public static double arrays = 1;
	public static double maxPostSpacing = 99;
	public static double pipeLength = 120;
	public static double pipeSize = 1.5;
	public static int pipeSched = 40;
	public static double postSpacingX;
	public static double postSpacingY = 84;
	public static double concreteDepth = 60;
	public static double concreteBase = 3;
	public static double pipeEmbed = 48;
	public static double frontPostHeight = 24;
	public static double backPostHeight = 72;
	
	public static double backPostLength = pipeEmbed+backPostHeight;
	public static double frontPostLength = pipeEmbed+frontPostHeight;
	public static double XBraceLength = Math.hypot(frontPostHeight - concreteBase, postSpacingY);//multiple arrays next thing. Also look into a "print dialog"?
	public static double vBraceLength;
	public static boolean usesVBraces = true;
	
	public static double panelsWide = 1;
	public static double panelWidth = 39.06;
	public static double panelHeight = 77.01;
	public static double xSpacing = 1.25;
	public static double ySpacing = 0.625;
	public static double railSpacing;
	public static double panelProtrusion;
	public static double railExcess = 3;
	
	public static double arrayWidth;
	public static double arrayHeight;
	public static double frameWidth;
	public static double supportWidth;
	public static double sets;
	
	public static double backPosts;
	public static double frontPosts;
	public static double xBraces;
	public static double vBraces;
	public static double rails;
	
	public static double midClamps;
	public static double endClamps;
	public static double adjustableElbows;
	public static double pipeTees;
	public static double lBrackets;
	
	public static double pipesForFrontSupport;
	public static double pipesForBackSupport;
	public static double pipesForXBraces;
	public static double pipesForVBraces;
	public static double pipesForFrontPosts;
	public static double pipesForBackPosts;
	public static double pipesUsed;
	public static double scrapsUsed;
	public static double pipeSaved;
	public static double pipeWasted;
	public static double pipesNeeded;
	private static Window window;
	
	public static void main(String[] args) {
		window = new Window();
	}
	
	public static void runCalculation() {
		reset();
		calculate();
	}
	
	
	/*
Calculating post spacing
Calculating back posts
Waste: 0.0
Calculating front posts
Waste: 1200.0
Calculating V-braces
Waste: -840.0
Calculating cross braces
Waste: 835.369546550728
Calculating front support
Waste: -33.44083333333333
Calculating back support
Waste: -33.44083333333356


Calculating post spacing
Calculating back posts
Waste: 0.0
Calculating front posts
Waste: 2400.0
Calculating V-braces
Waste: -1800.0
Calculating cross braces
Waste: 1670.739093101453
Calculating front support
Waste: 206.55916666666644
Calculating back support
Waste: 206.559166666666

	 */
	
	
	private static void calculate() {
		calculatePostSpacing();
		double panelAndSpace = (((panelsWide-1)*xSpacing)+(panelsWide*panelHeight))/panelsWide;
		railSpacing = panelAndSpace/2;
		panelProtrusion = panelAndSpace/4;
		
		rails = panelsWide*2*arrays;
		endClamps = rails*2;
		midClamps = rails*3;
		arrayWidth = (panelHeight*panelsWide)+(xSpacing*(panelsWide-1));//Figuring the distance between posts
		frameWidth = railSpacing*(rails/arrays-1)-6;//frameWidth is used only for posts. 
		sets = Math.ceil(frameWidth/maxPostSpacing)+1;
		postSpacingX = frameWidth/(sets-1);
		sets *= arrays;
		
		arrayHeight = (panelWidth*4)+(ySpacing*3);
		
		backPosts = sets;
		frontPosts = sets;
		xBraces = sets;
		if(usesVBraces) {
			vBraces = sets*2;
		}else vBraces = 0;
		adjustableElbows = vBraces*2+xBraces*2;
		pipeTees = frontPosts+backPosts;
		lBrackets = rails*2;
		supportWidth = frameWidth+12;
		calculateBackPosts();
		calculateFrontPosts();
		calculateXBraces();
		if(usesVBraces) {
			calculateVBraces();
		}
		calculateFrontSupport();
		calculateBackSupport();
		
		for(Pipe each:parts) {
			pipeWasted += each.getLength();
		}
		pipesNeeded = 
			pipesForBackPosts+
			pipesForFrontPosts+
			pipesForBackSupport+
			pipesForFrontSupport+
			pipesForVBraces+
			pipesForXBraces;
	}
	
	private static void calculateBackPosts() {
		System.out.println("Calculating back posts");
		for(int i = 0; i < backPosts; i++) {//Iterate through every back post
			getBestMatchedPipe(backPostLength, PartType.BACK_POST);//Returns a pipe from the parts list. Doesn't matter if there is one. 
		}
	}
	
	private static void calculateFrontPosts() {
		System.out.println("Calculating front posts");
		for(int i = 0; i < frontPosts; i++) {//Iterate through every front post
			getBestMatchedPipe(frontPostLength, PartType.FRONT_POST);//Returns a length from the parts list. Doesn't matter if there is one. 
		}
	}
	
	private static void calculateVBraces() {//Perhaps divide the front post calculation into two separate parts so as to allow for more possibility in waste reduction; half after front posts, half after x braces. 
		System.out.println("Calculating V-braces");
		vBraceLength = Math.hypot(frontPostHeight - concreteBase, postSpacingX/2-4);
		if((vBraceLength + frontPostLength) - pipeLength > 0 && (vBraceLength + frontPostLength) - pipeLength < 4) {//4 is the number of inches willing to be chopped off for the purpose of conserving pipe
			vBraceLength = pipeLength - frontPostLength;
		}
		for(int i = 0; i < vBraces; i++) {//Iterate through every V-Brace
			getBestMatchedPipe(vBraceLength, PartType.V_BRACE);//Returns a length from the parts list. Doesn't matter if there is one. 
		}
	}
	
	private static void calculateXBraces() {
		System.out.println("Calculating cross braces");
		for(int i = 0; i < backPosts; i++) {//Iterate through every X-Brace
			getBestMatchedPipe(XBraceLength, PartType.X_BRACE);//Returns a length from the parts list. Doesn't matter if there is one. 
		}
	}
	
	private static void calculateFrontSupport() {
		System.out.println("Calculating front support");
		for(int i = 0; i < arrays; i++) {
			getBestMatchedPipe(supportWidth, PartType.FRONT_SUPPORT);//Returns a length from the parts list. Doesn't matter if there is one. 
		}
	}
	
	private static void calculateBackSupport() {
		System.out.println("Calculating back support");
		for(int i = 0; i < arrays; i++) {
			getBestMatchedPipe(supportWidth, PartType.BACK_SUPPORT);//Returns a length from the parts list. Doesn't matter if there is one. 
		}
	}
	
	public static void calculatePostSpacing() {
		System.out.println("Calculating post spacing");
		boolean vBrace = usesVBraces;
		boolean sch40 = pipeSched == 40;
		boolean inch1_5 = pipeSize == 1.5;
		
		if(vBrace&&sch40&&inch1_5) {
			maxPostSpacing = 99;
		}else if(!vBrace&&sch40&&inch1_5) {
			maxPostSpacing = 69;
		}else if(vBrace&&!sch40&&inch1_5) {
			maxPostSpacing = 108;
		}else if(!vBrace&&!sch40&&inch1_5) {
			maxPostSpacing = 78;
		}else if(vBrace&&sch40&&!inch1_5) {
			maxPostSpacing = 117;
		}else if(!vBrace&&sch40&&!inch1_5) {
			maxPostSpacing = 87;
		}else if(vBrace&&!sch40&&!inch1_5) {
			maxPostSpacing = 132;
		}else if(!vBrace&&!sch40&&!inch1_5) {
			maxPostSpacing = 102;
		}
	}
	
	/**
	 * @param currentLength
	 * @param requiredLength
	 * @return The <code>Pipe</code> that was found and applied
	 */
	public static Pipe getBestMatchedPipe(double requiredLength, PartType type) {//General electric, LV, GM, 3MW
		int wholes = 0;
		while(requiredLength > pipeLength) {
			requiredLength -= pipeLength;
			pipesUsed++;
			wholes++;
			switch(type) {
			case FRONT_POST:pipesForFrontPosts++;break;
			case BACK_POST:pipesForBackPosts++;break;
			case FRONT_SUPPORT:pipesForFrontSupport++;break;
			case BACK_SUPPORT:pipesForBackSupport++;break;
			case V_BRACE:pipesForVBraces++;break;
			case X_BRACE:pipesForXBraces++;break;
			}
		}
		Pipe[] currentSpares = new Pipe[2];
		currentSpares[0] = new Pipe();
		
		for(Pipe each:parts) {
			if(wholes == 0) {
				if(each.canDerive(requiredLength, false) && each.getLength() < currentSpares[0].getLength()) {
					currentSpares[0] = each;
				}
			}else {
				if(each.canDerive(requiredLength, true) && each.getLength() < currentSpares[0].getLength()) {
					currentSpares[0] = each;
				}
			}
		}
		if(type == PartType.FRONT_SUPPORT||type == PartType.BACK_SUPPORT||type == PartType.V_BRACE) {
			if(currentSpares[0].getLength() == pipeLength) {
				requiredLength /= 2;
				for(int partNeeded = 0; partNeeded < 2; partNeeded++) {
					for(Pipe each:parts) {
						if(each.canDerive(requiredLength, true) && each.getLength() < currentSpares[partNeeded].getLength()) {
							currentSpares[partNeeded] = each;
						}
					}
					if(currentSpares[0].getLength() == pipeLength) {
						break;
					}else {
						currentSpares[1] = new Pipe();
					}
				}
			}
		}
		
		if(currentSpares[0].getLength() == pipeLength) {
			pipesUsed++;
			switch(type) {
			case FRONT_POST:pipesForFrontPosts++;break;
			case BACK_POST:pipesForBackPosts++;break;
			case FRONT_SUPPORT:pipesForFrontSupport++;break;
			case BACK_SUPPORT:pipesForBackSupport++;break;
			case V_BRACE:pipesForVBraces++;break;
			case X_BRACE:pipesForXBraces++;break;
			}
		}else {
			parts.remove(currentSpares[0]);
			if(currentSpares[1] != null) {
				parts.remove(currentSpares[1]);
				scrapsUsed++;
			}
			scrapsUsed++;
			pipeSaved += requiredLength;
		}
		/*switch(type) {
		case FRONT_POST:System.out.println("Pipes used: "+pipesForFrontPosts);break;
		case BACK_POST:System.out.println("Pipes used: "+pipesForBackPosts);break;
		case FRONT_SUPPORT:System.out.println("Pipes used: "+pipesForFrontSupport);break;
		case BACK_SUPPORT:System.out.println("Pipes used: "+pipesForBackSupport);break;
		case V_BRACE:System.out.println("Pipes used: "+pipesForVBraces);break;
		case X_BRACE:System.out.println("Pipes used: "+pipesForXBraces);break;
		}*/
		if(currentSpares[1] != null) {
			currentSpares[0] = new Pipe(currentSpares[0].getLength()+currentSpares[1].getLength(), (byte)0);
		}
		Pipe finalSpare = currentSpares[0].derivePart(requiredLength, false);
		if(currentSpares[0].getLength() > 0.125) {
			parts.add(currentSpares[0]);
		}
		return finalSpare;
	}
	//freecell #6244769
	
	private static void reset() {
		vBraceLength = 0;
		
		railSpacing = 0;
		panelProtrusion = 0;
		
		arrayWidth = 0;
		arrayHeight = 0;
		frameWidth = 0;
		supportWidth = 0;
		sets = 0;
		
		backPosts = 0;
		frontPosts = 0;
		xBraces = 0;
		vBraces = 0;
		rails = 0;
		
		adjustableElbows = 0;
		pipeTees = 0;
		lBrackets = 0;
		
		pipesForFrontSupport = 0;
		pipesForBackSupport = 0;
		pipesForXBraces = 0;
		pipesForVBraces = 0;
		pipesForFrontPosts = 0;
		pipesForBackPosts = 0;
		pipesUsed = 0;
		scrapsUsed = 0;
		pipeSaved = 0;
		pipeWasted = 0;
		pipesNeeded = 0;
		
		parts.clear();
	}
	public static void writeOut() {
		if(format == 1) {
			window.output.setText("");
			window.println("============================================");
			window.println("Array Width: "+inchesToFeet(arrayWidth));
			window.println("Frame Width: "+inchesToFeet(frameWidth));
			window.println("Rail Length: "+inchesToFeet(arrayHeight+railExcess*2));
			window.println("Rail Spacing: "+inchesToFeet(railSpacing));
			window.println("Panel overhang past rail: "+inchesToFeet(panelProtrusion));
			window.println("Front Rail Support length: "+inchesToFeet(supportWidth));
			window.println("Back Rail Support length: "+inchesToFeet(supportWidth));
			if(usesVBraces) {
				window.println("V-Brace length: "+inchesToFeet(vBraceLength));
			}
			window.println("Cross Brace length: "+inchesToFeet(XBraceLength));
			window.println("Front Post length: "+inchesToFeet(frontPostLength));
			window.println("Back Post Length: "+inchesToFeet(backPostLength));
			window.println("Post Spacing (x): "+inchesToFeet(postSpacingX));///////////////////
			window.println("Post Spacing (y): "+inchesToFeet(postSpacingY)+"\n");
			
			window.println("Rails: "+(int)rails);
			window.println("Back Posts: "+(int)backPosts);
			window.println("Front Posts: "+(int)frontPosts);
			if(usesVBraces) {
				window.println("V-Braces: "+(int)vBraces);
			}
			window.println("Cross Braces: "+(int)xBraces);
			window.println("Rail Supports: "+(int)arrays*2);
			window.println("Mid Clamps: "+(int)midClamps);
			window.println("End Clamps: "+(int)endClamps);
			window.println("Adjustable Elbows: "+(int)adjustableElbows);
			window.println("Pipe Tees: "+(int)pipeTees);
			window.println("Rail Mounting L-Brackets: "+(int)lBrackets+"\n");
			
			window.println("Pipes used for front posts: "+(int)pipesForFrontPosts);
			window.println("Pipes used for back posts: "+(int)pipesForBackPosts);
			window.println("Pipes used for cross braces: "+(int)pipesForXBraces);
			if(usesVBraces) {
				window.println("Pipes used for v-braces: "+(int)pipesForVBraces);
			}
			window.println("Pipes used for front rail support: "+(int)pipesForFrontSupport);
			window.println("Pipes used for back rail support: "+(int)pipesForBackSupport+"\n");
			
			window.println("Total pipes used: "+(int)pipesUsed);
			window.println("Parts left over: "+parts.size());
			window.println("Total pipe wasted: "+inchesToFeet(pipeWasted));
			window.println("Scraps used: "+(int)scrapsUsed);
			window.println("Total pipe salvaged: "+inchesToFeet(pipeSaved));
			window.println("Total pipes needed: "+(int)pipesNeeded);
			window.println("============================================");
		}else if(format == 2){
			window.output.setText("");
			window.println("============================================");
			window.println("Array Width: "+ratDec(arrayWidth)+"\"");
			window.println("Frame Width: "+ratDec(frameWidth)+"\"");
			window.println("Rail Length: "+ratDec(arrayHeight+railExcess*2)+"\"");
			window.println("Rail Spacing: "+ratDec(railSpacing)+"\"");
			window.println("Panel overhang past rail: "+ratDec(panelProtrusion)+"\"");
			window.println("Front Rail Support length: "+ratDec(supportWidth)+"\"");
			window.println("Back Rail Support length: "+ratDec(supportWidth)+"\"");
			if(usesVBraces) {
				window.println("V-Brace length: "+ratDec(vBraceLength)+"\"");
			}
			window.println("Cross Brace length: "+ratDec(XBraceLength)+"\"");
			window.println("Front Post length: "+ratDec(frontPostLength)+"\"");
			window.println("Back Post Length: "+ratDec(backPostLength)+"\"");
			window.println("Post Spacing (x): "+ratDec(postSpacingX)+"\"");
			window.println("Post Spacing (y): "+ratDec(postSpacingY)+"\"\n");
			
			window.println("Rails: "+(int)rails);
			window.println("Back Posts: "+(int)backPosts);
			window.println("Front Posts: "+(int)frontPosts);
			if(usesVBraces) {
				window.println("V-Braces: "+(int)vBraces);
			}
			window.println("Cross Braces: "+(int)xBraces);
			window.println("Rail Supports: "+(int)arrays*2);
			window.println("Mid Clamps: "+(int)midClamps);
			window.println("End Clamps: "+(int)endClamps);
			window.println("Adjustable Elbows: "+(int)adjustableElbows);
			window.println("Pipe Tees: "+(int)pipeTees);
			window.println("Rail Mounting L-Brackets: "+(int)lBrackets+"\n");
			
			window.println("Pipes used for front posts: "+(int)pipesForFrontPosts);
			window.println("Pipes used for back posts: "+(int)pipesForBackPosts);
			window.println("Pipes used for cross braces: "+(int)pipesForXBraces);
			if(usesVBraces) {
				window.println("Pipes used for v-braces: "+(int)pipesForVBraces);
			}
			window.println("Pipes used for front rail support: "+(int)pipesForFrontSupport);
			window.println("Pipes used for back rail support: "+(int)pipesForBackSupport+"\n");
			
			window.println("Total pipes used: "+(int)pipesUsed);
			window.println("Parts left over: "+parts.size());
			window.println("Total pipe wasted: "+ratDec(pipeWasted)+"\"");
			window.println("Scraps used: "+(int)scrapsUsed);
			window.println("Total pipe salvaged: "+ratDec(pipeSaved)+"\"");
			window.println("Total pipes needed: "+(int)pipesNeeded);
			window.println("============================================");
		}else if(format == 3) {
			window.output.setText("");
			window.println("============================================");
			window.println("Array Width: "+inchesToFeetWords(arrayWidth));
			window.println("Frame Width: "+inchesToFeetWords(frameWidth));
			window.println("Rail Length: "+inchesToFeetWords(arrayHeight+railExcess*2));
			window.println("Rail Spacing: "+inchesToFeetWords(railSpacing));
			window.println("Panel overhang past rail: "+inchesToFeetWords(panelProtrusion));
			window.println("Front Rail Support length: "+inchesToFeetWords(supportWidth));
			window.println("Back Rail Support length: "+inchesToFeetWords(supportWidth));
			if(usesVBraces) {
				window.println("V-Brace length: "+inchesToFeetWords(vBraceLength));
			}
			window.println("Cross Brace length: "+inchesToFeetWords(XBraceLength));
			window.println("Front Post length: "+inchesToFeetWords(frontPostLength));
			window.println("Back Post Length: "+inchesToFeetWords(backPostLength));
			window.println("Post Spacing (x): "+inchesToFeetWords(postSpacingX));///////////////////
			window.println("Post Spacing (y): "+inchesToFeetWords(postSpacingY)+"\n");
			
			window.println("Rails: "+(int)rails);
			window.println("Back Posts: "+(int)backPosts);
			window.println("Front Posts: "+(int)frontPosts);
			if(usesVBraces) {
				window.println("V-Braces: "+(int)vBraces);
			}
			window.println("Cross Braces: "+(int)xBraces);
			window.println("Rail Supports: "+(int)arrays*2);
			window.println("Mid Clamps: "+(int)midClamps);
			window.println("End Clamps: "+(int)endClamps);
			window.println("Adjustable Elbows: "+(int)adjustableElbows);
			window.println("Pipe Tees: "+(int)pipeTees);
			window.println("Rail Mounting L-Brackets: "+(int)lBrackets+"\n");
			
			window.println("Pipes used for front posts: "+(int)pipesForFrontPosts);
			window.println("Pipes used for back posts: "+(int)pipesForBackPosts);
			window.println("Pipes used for cross braces: "+(int)pipesForXBraces);
			if(usesVBraces) {
				window.println("Pipes used for v-braces: "+(int)pipesForVBraces);
			}
			window.println("Pipes used for front rail support: "+(int)pipesForFrontSupport);
			window.println("Pipes used for back rail support: "+(int)pipesForBackSupport+"\n");
			
			window.println("Total pipes used: "+(int)pipesUsed);
			window.println("Parts left over: "+parts.size());
			window.println("Total pipe wasted: "+inchesToFeetWords(pipeWasted));
			window.println("Scraps used: "+(int)scrapsUsed);
			window.println("Total pipe salvaged: "+inchesToFeetWords(pipeSaved));
			window.println("Total pipes needed: "+(int)pipesNeeded);
			window.println("============================================");
		}
	}
	private static double ratDec(double d) {
		return Math.ceil(d*100)/100;
	}
	private static String inchesToFeet(double inches) {
		return (int)(inches/12)+"\' "+ratDec((inches%12.0))+"\"";
	}
	private static String inchesToFeetWords(double inches) {
		double inDec = ratDec(inches-((int)(inches/12)*12)-Math.floor(inches%12.0));//This is our inches after the decimal.
		return (int)(inches/12)+"ft, "+(int)Math.floor(inches%12)+decimalToFraction(inDec)+"in";
	}
	private static String decimalToFraction(double decimal) {
		int den = accuracy;
		int num = (int)(decimal*(double)den);
		while(den%2 == 0 && num%2 == 0) {
			den /= 2;
			num /= 2;
		}
		if(num == 0) {
			return "";
		}
		return " "+num+"/"+den;
	}
}
