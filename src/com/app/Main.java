package com.app;

import com.core.servico.ProfissionalServicoImple;

public class Main {

	public static void main(String[] args) {
		ProfissionalServicoImple prof = new ProfissionalServicoImple();
		System.out.println(prof.findByNome("Andreia").getProfId());
	}

}
