	package br.ufscar.pooa.cinema_api.domain;

	import java.util.Collection;
	import java.time.LocalDateTime;
	import java.util.Objects;

	public class Cliente extends Usuario {
		public Cliente(String nome,
					   String email,
					   String senha,
					   Cinema cinema,
					   String cpf,
					   Integer genero,
					   LocalDateTime dataNascimento,
					   Collection<Ingresso> ingressos) {
            super(nome, email, senha, cinema);
            this.cpf = cpf;
			this.genero = genero;
			this.dataNascimento = dataNascimento;
			this.ingressos = ingressos;
		}

		private String cpf;

		private Integer genero;

		private LocalDateTime dataNascimento;

		private Collection<Ingresso> ingressos;

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public Integer getGenero() {
			return genero;
		}

		public void setGenero(Integer genero) {
			this.genero = genero;
		}

		public LocalDateTime getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(LocalDateTime dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public Collection<Ingresso> getIngressos() {
			return ingressos;
		}

		public void setIngressos(Collection<Ingresso> ingressos) {
			this.ingressos = ingressos;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass()) return false;
			Cliente cliente = (Cliente) o;
			return Objects.equals(cpf, cliente.cpf) && Objects.equals(genero, cliente.genero) && Objects.equals(dataNascimento, cliente.dataNascimento) && Objects.equals(ingressos, cliente.ingressos);
		}

		@Override
		public int hashCode() {
			return Objects.hash(cpf, genero, dataNascimento, ingressos);
		}
	}
