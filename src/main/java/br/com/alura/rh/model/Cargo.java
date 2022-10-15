package br.com.alura.rh.model;

import br.com.alura.rh.ValidacaoException;

public enum Cargo {

	ASSISTENTE {
		@Override
		public Cargo getProximoCargo() {
			return Cargo.ANALISTA;
		}
	},
	ANALISTA{
		@Override
		public Cargo getProximoCargo() {
			return Cargo.ESPECIALISTA;
		}
	},
	ESPECIALISTA{
		@Override
		public Cargo getProximoCargo() {
			return Cargo.GERENTE;
		}
	},
	GERENTE{
		@Override
		public Cargo getProximoCargo() {
			return Cargo.GERENTE;
		}
	};

	public abstract Cargo getProximoCargo();

}
