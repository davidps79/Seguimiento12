package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.TurnSystem;

public class Main {
	private BufferedReader in;
	private BufferedWriter out;
	private TurnSystem back;
	private boolean exit;
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.start();
	}
	
	public Main() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = new BufferedWriter(new OutputStreamWriter(System.out));
		this.back = new TurnSystem();
	}
	
	public void println(String s) throws IOException {
		out.write(s);
		out.write("\n");
		out.flush();
	}
	
	public void start() throws IOException {
		while(!exit) showMenu();
	}
	
	public void showMenu() throws IOException {
		println("Menu\n"
				+ "1. Dar turno\n"
				+ "2. Mostrar turno\n"
				+ "3. Pasar turno\n"
				+ "4. Eliminar turno actual\n"
				+ "5. Salir");
		int selection = Integer.parseInt(in.readLine());
		switch(selection) {
		case 1:
			println(back.addTurn());
			break;
		case 2:
			println(back.getTurn());
			break;
		case 3:
			println(back.skipTurn());
			break;
		case 4:
			println(back.removeTurn());
			break;
		case 5:
			println("Bye");
			exit = true;
			break;
		}
	}
}
