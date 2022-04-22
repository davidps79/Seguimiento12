package model;

public class TurnSystem {
	private LinkedList<Integer> waitingLine;
	private int currentTurn;
	
	public TurnSystem() {
		this.currentTurn = 1;
		this.waitingLine = new LinkedList<>();
	}
	
	public String addTurn() {
		if (waitingLine.size()<50) {
			waitingLine.add(currentTurn);
			currentTurn++;
			return "Se ha agregado el turno " + waitingLine.getLast().toString();
		} else return "Se ha alcanzado el limite de 50 turnos asignados";
	}
	
	public String getTurn() {
		if (waitingLine.getFirst()==null) return "No hay turnos";
		return "El turno actual es el " + waitingLine.getFirst().toString();
	}
	
	public String skipTurn() {
		return waitingLine.skipFirst();
	}
	
	public String removeTurn() {
		if (waitingLine.getFirst() == null) return "No hay turnos";
		
		String s = "Se ha atentido al turno " + waitingLine.getFirst().getItem().toString();
		waitingLine.removeFirst();
		return s;
	}
}
