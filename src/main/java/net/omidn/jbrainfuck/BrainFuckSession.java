package net.omidn.jbrainfuck;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class BrainFuckSession {
	private List<Character> charList;
	private int pointer;
	private InputStream stdin;
	private OutputStream stdout;
	
	public BrainFuckSession(int intitialCapacity, InputStream stdin, OutputStream stdout) {

		this.pointer = 0;
		charList = new ArrayList<Character>(intitialCapacity);
		this.stdin = stdin;
		this.stdout = stdout;

	}
	
	public BrainFuckSession() {
		this(300, System.in, System.out);
	}
	/**
	 * Increments the char at cell which <code>pointer</code> points to.<br>
	 * This does what character + (plus) does in BrainFuck.
	 */
	public void doIncrement() {
		charList.set(pointer, (char) (charList.get(pointer) + 1));
	}

	/**
	 * Decrements the char at cell which <code>pointer</code> points to.<br>
	 * This does what character - (minus) does in BrainFuck.
	 */
	public void doDecrement() {
		charList.set(pointer, (char) (charList.get(pointer) - 1));
	}
	
	/**
	 * Shifts the pointer to the right by 1.<br>
	 * This does what character > does in BrainFuck.
	 */
	public void rightShift() {
		pointer++;
		if (pointer > charList.size()) {
			charList.add((char) 0);
		}
	}
	
}
