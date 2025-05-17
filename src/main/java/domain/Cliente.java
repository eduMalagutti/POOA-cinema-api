	package domain;

	import java.util.Collection;
	import java.time.LocalDateTime;

	public class Cliente extends Usuario {

		private String cpf;

		private Integer genero;

		private LocalDateTime dataNascimento;

		private Collection<Ingresso> ingressos;

	}
