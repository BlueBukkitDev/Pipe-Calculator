package dev.blue.pipecalc;

public class Pipe {
	private double length;
	private byte threads;
	/**
	 *Creates a new Pipe object with the length set to Main.pipeLength and the hasCoupling set to true. 
	 **/
	public Pipe() {
		length = Main.pipeLength;
		threads = 2;
	}
	/**
	 *Creates a new Pipe object with the length and hasCoupling defined in the parameters. 
	 **/
	public Pipe(double length, byte threads) {
		this.length = length;
		this.threads = threads;
	}
	
	public boolean canDerive(double length, boolean needsThreads) {
		if(this.length - length >= 0) {
			if((needsThreads && threads > 0) ||!needsThreads) {
				return true;
			}
		}
		return false;
	}
	
	public Pipe derivePart(double length, boolean needsThreads) {
		if(canDerive(length, needsThreads)) {
			this.length -= length;
			if(needsThreads||this.length == Main.pipeLength) {
				threads--;
			}
			return new Pipe(length, (byte)1);
		}
		return null;
	}
	
	public double getLength() {
		return length;
	}
	public byte getThreads() {
		return threads;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
}
