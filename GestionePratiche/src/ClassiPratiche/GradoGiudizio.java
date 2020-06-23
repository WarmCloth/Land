package ClassiPratiche;

public enum GradoGiudizio {
	
	PRIMO_GRADO(1), APPELLO(2), CASSAZIONE(3);
	
	private int grado;

	GradoGiudizio(int i) {
		this.grado = i;
	}
	
	public int getGrado() {
		return this.grado;
	}
	
	public GradoGiudizio next() throws GradoNonAumentabileException {
		if(this.getGrado() == 3)
			throw new GradoNonAumentabileException();
		return values()[ordinal() + 1];
	}

}