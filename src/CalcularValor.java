
public class CalcularValor {

	public static final float VALOR_FRACAO = (float) 2.0;
	public static final float VALOR_HORA = (float) 7.0;
	public static final float VALOR_DIARIA = (float) 30.0;
	
	Acesso acesso;
	
	private int quantidadeHoras;
	private int quantidadeMinutos;
	private float valorPorHora;
	private float valorPorFracaoExcedente;
	
	public CalcularValor(Acesso acesso) {
		this.acesso = acesso;
		
		// atribuindo a variaveis temporarias apenas para diminuir a duplicacao de get desses atributos da classe Acesso
		int horaEntrada = acesso.getHoraEntrada();
		int horaSaida = acesso.getHoraSaida();
		int minutosEntrada = acesso.getMinutosEntrada();
		int minutosSaida = acesso.getMinutosSaida();
		
		// atribuindo valores aos atributos da classe CalcularValor
		if (horaSaida == horaEntrada)
			this.setQuantidadeMinutos(minutosSaida - minutosEntrada);
		else if (horaSaida > horaEntrada && minutosEntrada == minutosSaida){
			this.setQuantidadeMinutos(0);
			this.setQuantidadeHoras(horaSaida - horaEntrada);
		}
		else if (horaSaida > horaEntrada && minutosEntrada > minutosSaida)
			this.setQuantidadeMinutos(minutosSaida - minutosEntrada);
		else if (horaSaida > horaEntrada && minutosSaida < minutosEntrada){
			this.setQuantidadeMinutos(minutosSaida + (60 - minutosEntrada));
			this.setQuantidadeHoras(horaSaida - horaEntrada - 1);
		}
		else {
			this.setQuantidadeHoras(0);
			this.setQuantidadeMinutos(0);
		}
		
		this.setValorPorHora(this.getQuantidadeHoras() * VALOR_HORA);
		this.setValorPorFracaoExcedente((float) (Math.ceil(this.getQuantidadeMinutos() / 15.0) * VALOR_FRACAO));
	}
	
	public float Compute() {
		// logica para calcular o valor total
		float valorTotal = this.getValorPorHora() + this.getValorPorFracaoExcedente();		
		
		if (this.getQuantidadeHoras() >=9)
			return VALOR_DIARIA;
		else 
			return valorTotal;
	}
	
	// getters e setters
	
	public void setQuantidadeHoras(int horas) {
		this.quantidadeHoras = horas;
	}
	
	public int getQuantidadeHoras() {
		return this.quantidadeHoras;
	}
	
	public void setQuantidadeMinutos(int minutos) {
		this.quantidadeMinutos = minutos;
	}
	
	public int getQuantidadeMinutos() {
		return this.quantidadeMinutos;
	}
	
	public void setValorPorHora(float valor) {
		this.valorPorHora = valor;
	}
	
	public float getValorPorHora() {
		return this.valorPorHora;
	}
	
	public void setValorPorFracaoExcedente(float valor) {
		this.valorPorFracaoExcedente = valor;
	}
	
	public float getValorPorFracaoExcedente() {
		return this.valorPorFracaoExcedente;
	}
	
}
