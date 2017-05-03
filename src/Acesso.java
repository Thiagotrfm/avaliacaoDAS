
public class Acesso {
	
	public String placa;
	public int dia, mes, ano;
	public int horaEntrada, 
	           minutosEntrada;
	public int horaSaida, 
			   minutosSaida;
	


	public Acesso() {}

	
	public Acesso(int dia, int mes, int ano, int horaEntrada, int minutosEntrada) { 
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.horaEntrada = horaEntrada;
		this.minutosEntrada = minutosEntrada;
	}
	
	public float calcularValor() { 
		return new CalcularValor(this).Compute();
	}
	
	public int getHoraEntrada() {
		return this.horaEntrada;
	}
	
	public void setHoraEntrada(int horaEntrada) {
		this.horaSaida = horaEntrada;
	}
	
	public int getHoraSaida() {
		return this.horaSaida;
	}
	
	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}

	public int getMinutosEntrada() {
		return this.minutosEntrada;
	}

	public void setMinutosEntrada(int minutosEntrada) {
		this.minutosEntrada = minutosEntrada;
	}
	
	public int getMinutosSaida() {
		return this.minutosSaida;
	}

	public void setMinutosSaida(int minutosSaida) {
		this.minutosSaida = minutosSaida;
	}
	
	
	
}
