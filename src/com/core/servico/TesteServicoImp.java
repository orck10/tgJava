package com.core.servico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.api.modelo.Crianca;
import com.api.modelo.Fase;
import com.api.modelo.Teste;
import com.api.servico.TesteServico;
import com.core.dao.CriancaDaoImp;
import com.core.dao.FaseDaoImp;
import com.core.dao.TesteDaoImp;

public class TesteServicoImp implements TesteServico{
	
	private TesteDaoImp teste = new TesteDaoImp();
	private CriancaDaoImp crianca = new CriancaDaoImp();
	private FaseDaoImp fases = new FaseDaoImp();
	
	@Override
	public Teste insert(Teste t) {
		Teste teste = new Teste();
		teste = this.teste.insert(t);
		return teste;
	}

	@Override
	public Teste findById(Integer id) {
		Teste teste = new Teste();
		teste = this.teste.findById(id);
		return teste;
	}

	@Override
	public Teste findCrianca(Integer id) {
		Teste teste = new Teste();
		teste = this.teste.findCrianca(id);
		return teste;
	}

	@Override
	public List<Teste> findProficinal(Integer id) {
		List<Teste> lista = new ArrayList<Teste>();
		lista = this.teste.findProficinal(id);
		return lista;
	}

	@Override
	public Teste update(Teste ant, Teste atu) {
		Teste teste = new Teste();
		teste = this.teste.update(ant, atu);
		return teste;
	}

	@Override
	public Boolean delete(Integer id) {
		return this.teste.delete(id);
	}

	@Override
	public List<Crianca> findCriancaProfId(Integer i) {
		return this.teste.findCriancaProfId(i);
	}

	@Override
	public boolean persistirFase(String crianca, List<Fase> fases) {
		try {
			CriancaServicoImp servCri = new CriancaServicoImp();
			Crianca cri = servCri.findByNome(crianca);
			
			Teste teste = this.teste.findCrianca(cri.getId().intValue());
			
			FaseDaoImp fase = new FaseDaoImp();
			
			for(Fase f: fases) {
				f.setTesteId(teste.getTesteId());	
				fase.insert(f);
			}
			
			Teste teste1 = new Teste();
			teste1.setCriancaId(teste.getCriancaId());
			teste1.setPsicoId(teste.getPsicoId());
			Calendar data = Calendar.getInstance();
			teste1.setTesteData(data);
			teste1.setTesteId(teste.getTesteId());
			teste1.setTesteTipo(teste.getTesteTipo());
			this.teste.update(teste, teste1);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<String> resultados(String crianca) {
		Crianca cri = this.crianca.findByNome(crianca);
		Teste teste = this.teste.findCrianca(cri.getId().intValue());
		List<Fase> listaFases = this.fases.findByTesteId(teste.getTesteId());
		
		List<String> lista = new ArrayList<String>();
		int count = 0;
		int count2 = 0;
		int count3 = 0;
		if(!listaFases.isEmpty()){
			for(int i = 0; i < listaFases.size(); i++) {
				switch(listaFases.get(i).getFaseTentativas()) {
					case 1:
						count +=3;
						if(i >= 4 && i < 8) {
							count2 += 3;
						}
						if(i >= 8) {
							count3 += 3;
						}
						break;
					case 2:
						count +=2;
						if(i >= 4 && i < 8) {
							count2 += 2;
						}
						if(i >= 8) {
							count3 += 2;
						}
						break;
					case 3:
						count +=1;
						if(i >= 4 && i < 8) {
							count2 += 1;
						}
						if(i >= 8) {
							count3 += 1;
						}
						break;
				}
			}
			Integer ponto = 0;
			int idade = teste.getTesteData().getWeekYear() - cri.getCriancaNasc().getWeeksInWeekYear();
			if(idade <= 11){
				if(count <= 9) {
					ponto = 3;
				}
				else if(count == 10) {
					ponto = 8;
				}
				else if(count == 11) {
					ponto = 13;
				}
				else if(count == 12) {
					ponto = 18;
				}
				else if(count == 13) {
					ponto = 24;
				}
				else if(count == 14) {
					ponto = 29;
				}
				else if(count == 15) {
					ponto = 34;
				}
				else if(count == 16) {
					ponto = 39;
				}
				else if(count == 17) {
					ponto = 44;
				}
				else if(count == 18) {
					ponto = 50;
				}
				else if(count == 19) {
					ponto = 55;
				}
				else if(count == 20) {
					ponto = 60;
				}
				else if(count == 21) {
					ponto = 65;
				}
				else if(count == 22) {
					ponto = 70;
				}
				else if(count == 23) {
					ponto = 76;
				}
				else if(count == 24) {
					ponto = 81;
				}
				else if(count == 25) {
					ponto = 86;
				}
				else if(count == 26) {
					ponto = 91;
				}
				else if(count == 27) {
					ponto = 96;
				}
				else if(count == 28) {
					ponto = 102;
				}
				else if(count == 29) {
					ponto = 107;
				}
				else if(count == 30) {
					ponto = 112;
				}
				else if(count == 31) {
					ponto = 117;
				}
				else if(count == 32) {
					ponto = 122;
				}
				else if(count == 33) {
					ponto = 128;
				}
				else if(count == 34) {
					ponto = 133;
				}
				else if(count == 35) {
					ponto = 138;
				}
				else if(count == 36) {
					ponto = 143;
				}
			}
			else if(idade == 12){
				if(count <= 13) {
					ponto = 4;
				}
				else if(count == 14) {
					ponto = 10;
				}
				else if(count == 15) {
					ponto = 16;
				}
				else if(count == 16) {
					ponto = 22;
				}
				else if(count == 17) {
					ponto = 28;
				}
				else if(count == 18) {
					ponto = 34;
				}
				else if(count == 19) {
					ponto = 40;
				}
				else if(count == 20) {
					ponto = 46;
				}
				else if(count == 21) {
					ponto = 51;
				}
				else if(count == 22) {
					ponto = 57;
				}
				else if(count == 23) {
					ponto = 63;
				}
				else if(count == 24) {
					ponto = 69;
				}
				else if(count == 25) {
					ponto = 75;
				}
				else if(count == 26) {
					ponto = 81;
				}
				else if(count == 27) {
					ponto = 87;
				}
				else if(count == 28) {
					ponto = 93;
				}
				else if(count == 29) {
					ponto = 99;
				}
				else if(count == 30) {
					ponto = 105;
				}
				else if(count == 31) {
					ponto = 111;
				}
				else if(count == 32) {
					ponto = 116;
				}
				else if(count == 33) {
					ponto = 122;
				}
				else if(count == 34) {
					ponto = 128;
				}
				else if(count == 35) {
					ponto = 134;
				}
				else if(count == 36) {
					ponto = 140;
				}
			}
			else if(idade == 13){
				if(count <= 9) {
					ponto = 1;
				}
				else if(count == 10) {
					ponto = 6;
				}
				else if(count == 11) {
					ponto = 11;
				}
				else if(count == 12) {
					ponto = 15;
				}
				else if(count == 13) {
					ponto = 20;
				}
				else if(count == 14) {
					ponto = 25;
				}
				else if(count == 15) {
					ponto = 29;
				}
				else if(count == 16) {
					ponto = 34;
				}
				else if(count == 17) {
					ponto = 39;
				}
				else if(count == 18) {
					ponto = 43;
				}
				else if(count == 19) {
					ponto = 48;
				}
				else if(count == 20) {
					ponto = 53;
				}
				else if(count == 21) {
					ponto = 58;
				}
				else if(count == 22) {
					ponto = 62;
				}
				else if(count == 23) {
					ponto = 67;
				}
				else if(count == 24) {
					ponto = 72;
				}
				else if(count == 25) {
					ponto = 76;
				}
				else if(count == 26) {
					ponto = 81;
				}
				else if(count == 27) {
					ponto = 86;
				}
				else if(count == 28) {
					ponto = 90;
				}
				else if(count == 29) {
					ponto = 95;
				}
				else if(count == 30) {
					ponto = 100;
				}
				else if(count == 31) {
					ponto = 104;
				}
				else if(count == 32) {
					ponto = 109;
				}
				else if(count == 33) {
					ponto = 114;
				}
				else if(count == 34) {
					ponto = 118;
				}
				else if(count == 35) {
					ponto = 123;
				}
				else if(count == 36) {
					ponto = 128;
				}
			}
			else if(idade == 14){
				if(count <= 5) {
					ponto = 4;
				}
				else if(count == 6) {
					ponto = 8;
				}
				else if(count == 7) {
					ponto = 12;
				}
				else if(count == 8) {
					ponto = 16;
				}
				else if(count == 9) {
					ponto = 20;
				}
				else if(count == 10) {
					ponto = 24;
				}
				else if(count == 11) {
					ponto = 27;
				}
				else if(count == 12) {
					ponto = 31;
				}
				else if(count == 13) {
					ponto = 35;
				}
				else if(count == 14) {
					ponto = 39;
				}
				else if(count == 15) {
					ponto = 43;
				}
				else if(count == 16) {
					ponto = 47;
				}
				else if(count == 17) {
					ponto = 50;
				}
				else if(count == 18) {
					ponto = 54;
				}
				else if(count == 19) {
					ponto = 58;
				}
				else if(count == 20) {
					ponto = 62;
				}
				else if(count == 21) {
					ponto = 66;
				}
				else if(count == 22) {
					ponto = 70;
				}
				else if(count == 23) {
					ponto = 74;
				}
				else if(count == 24) {
					ponto = 77;
				}
				else if(count == 25) {
					ponto = 81;
				}
				else if(count == 26) {
					ponto = 85;
				}
				else if(count == 27) {
					ponto = 89;
				}
				else if(count == 28) {
					ponto = 93;
				}
				else if(count == 29) {
					ponto = 97;
				}
				else if(count == 30) {
					ponto = 100;
				}
				else if(count == 31) {
					ponto = 104;
				}
				else if(count == 32) {
					ponto = 108;
				}
				else if(count == 33) {
					ponto = 112;
				}
				else if(count == 34) {
					ponto = 116;
				}
				else if(count == 35) {
					ponto = 120;
				}
				else if(count == 36) {
					ponto = 123;
				}
			}
			else{
				if(count <= 23) {
					ponto = 4;
				}
				else if(count == 24) {
					ponto = 13;
				}
				else if(count == 25) {
					ponto = 22;
				}
				else if(count == 26) {
					ponto = 31;
				}
				else if(count == 27) {
					ponto = 39;
				}
				else if(count == 28) {
					ponto = 48;
				}
				else if(count == 29) {
					ponto = 57;
				}
				else if(count == 30) {
					ponto = 66;
				}
				else if(count == 31) {
					ponto = 75;
				}
				else if(count == 32) {
					ponto = 83;
				}
				else if(count == 33) {
					ponto = 92;
				}
				else if(count == 34) {
					ponto = 101;
				}
				else if(count == 35) {
					ponto = 110;
				}
				else if(count == 36) {
					ponto = 119;
				}
			}
			Integer ponto4mov = 0;
			if(idade <= 11){
				if(count2 == 1) {
					ponto4mov = 56;
				}
				else if(count2 == 2) {
					ponto4mov = 64;
				}
				else if(count2 == 3) {
					ponto4mov = 72;
				}
				else if(count2 == 4) {
					ponto4mov = 80;
				}
				else if(count2 == 5) {
					ponto4mov = 89;
				}
				else if(count2 == 6) {
					ponto4mov = 97;
				}
				else if(count2 == 7) {
					ponto4mov = 105;
				}
				else if(count2 == 8) {
					ponto4mov = 113;
				}
				else if(count2 == 9) {
					ponto4mov = 122;
				}
				else if(count2 == 10) {
					ponto4mov = 130;
				}
				else if(count2 == 11) {
					ponto4mov = 138;
				}
				else if(count2 == 12) {
					ponto4mov = 146;
				}
			}
			else if(idade <= 12){
				if(count2 == 1) {
					ponto4mov = 56;
				}
				else if(count2 == 2) {
					ponto4mov = 65;
				}
				else if(count2 == 3) {
					ponto4mov = 73;
				}
				else if(count2 == 4) {
					ponto4mov = 81;
				}
				else if(count2 == 5) {
					ponto4mov = 89;
				}
				else if(count2 == 6) {
					ponto4mov = 97;
				}
				else if(count2 == 7) {
					ponto4mov = 106;
				}
				else if(count2 == 8) {
					ponto4mov = 114;
				}
				else if(count2 == 9) {
					ponto4mov = 122;
				}
				else if(count2 == 10) {
					ponto4mov = 130;
				}
				else if(count2 == 11) {
					ponto4mov = 139;
				}
				else if(count2 == 12) {
					ponto4mov = 147;
				}
			}
			else if(idade <= 13){
				if(count2 == 1) {
					ponto4mov = 44;
				}
				else if(count2 == 2) {
					ponto4mov = 54;
				}
				else if(count2 == 3) {
					ponto4mov = 63;
				}
				else if(count2 == 4) {
					ponto4mov = 73;
				}
				else if(count2 == 5) {
					ponto4mov = 82;
				}
				else if(count2 == 6) {
					ponto4mov = 92;
				}
				else if(count2 == 7) {
					ponto4mov = 101;
				}
				else if(count2 == 8) {
					ponto4mov = 111;
				}
				else if(count2 == 9) {
					ponto4mov = 120;
				}
				else if(count2 == 10) {
					ponto4mov = 129;
				}
				else if(count2 == 11) {
					ponto4mov = 139;
				}
				else if(count2 == 12) {
					ponto4mov = 148;
				}
			}
			else if(idade <= 14){
				if(count2 == 1) {
					ponto4mov = 55;
				}
				else if(count2 == 2) {
					ponto4mov = 62;
				}
				else if(count2 == 3) {
					ponto4mov = 69;
				}
				else if(count2 == 4) {
					ponto4mov = 76;
				}
				else if(count2 == 5) {
					ponto4mov = 84;
				}
				else if(count2 == 6) {
					ponto4mov = 91;
				}
				else if(count2 == 7) {
					ponto4mov = 98;
				}
				else if(count2 == 8) {
					ponto4mov = 106;
				}
				else if(count2 == 9) {
					ponto4mov = 113;
				}
				else if(count2 == 10) {
					ponto4mov = 120;
				}
				else if(count2 == 11) {
					ponto4mov = 127;
				}
				else if(count2 == 12) {
					ponto4mov = 135;
				}
			}
			else if(idade > 14){
				if(count2 == 3) {
					ponto4mov = 15;
				}
				else if(count2 == 4) {
					ponto4mov = 31;
				}
				else if(count2 == 5) {
					ponto4mov = 47;
				}
				else if(count2 == 6) {
					ponto4mov = 64;
				}
				else if(count2 == 7) {
					ponto4mov = 80;
				}
				else if(count2 == 8) {
					ponto4mov = 96;
				}
				else if(count2 == 9) {
					ponto4mov = 112;
				}
				else if(count2 == 10) {
					ponto4mov = 128;
				}
				else if(count2 == 11) {
					ponto4mov = 144;
				}
				else if(count2 == 12) {
					ponto4mov = 161;
				}
			}
			Integer ponto5mov = 0;
			if(idade == 11){
				if(count3 == 1) {
					ponto5mov = 69;
				}
				else if(count3 == 2) {
					ponto5mov = 77;
				}
				else if(count3 == 3) {
					ponto5mov = 84;
				}
				else if(count3 == 4) {
					ponto5mov = 92;
				}
				else if(count3 == 5) {
					ponto5mov = 99;
				}
				else if(count3 == 6) {
					ponto5mov = 107;
				}
				else if(count3 == 7) {
					ponto5mov = 115;
				}
				else if(count3 == 8) {
					ponto5mov = 122;
				}
				else if(count3 == 9) {
					ponto5mov = 130;
				}
				else if(count3 == 10) {
					ponto5mov = 137;
				}
				else if(count3 == 11) {
					ponto5mov = 145;
				}
				else if(count3 == 12) {
					ponto5mov = 152;
				}
			}
			else if(idade == 12){
				if(count3 == 1) {
					ponto5mov = 59;
				}
				else if(count3 == 2) {
					ponto5mov = 67;
				}
				else if(count3 == 3) {
					ponto5mov = 76;
				}
				else if(count3 == 4) {
					ponto5mov = 84;
				}
				else if(count3 == 5) {
					ponto5mov = 93;
				}
				else if(count3 == 6) {
					ponto5mov = 101;
				}
				else if(count3 == 7) {
					ponto5mov = 110;
				}
				else if(count3 == 8) {
					ponto5mov = 118;
				}
				else if(count3 == 9) {
					ponto5mov = 127;
				}
				else if(count3 == 10) {
					ponto5mov = 135;
				}
				else if(count3 == 11) {
					ponto5mov = 144;
				}
				else if(count3 == 12) {
					ponto5mov = 152;
				}
			}
			else if(idade == 13){
				if(count3 == 1) {
					ponto5mov = 58;
				}
				else if(count3 == 2) {
					ponto5mov = 66;
				}
				else if(count3 == 3) {
					ponto5mov = 74;
				}
				else if(count3 == 4) {
					ponto5mov = 82;
				}
				else if(count3 == 5) {
					ponto5mov = 90;
				}
				else if(count3 == 6) {
					ponto5mov = 98;
				}
				else if(count3 == 7) {
					ponto5mov = 106;
				}
				else if(count3 == 8) {
					ponto5mov = 114;
				}
				else if(count3 == 9) {
					ponto5mov = 122;
				}
				else if(count3 == 10) {
					ponto5mov = 130;
				}
				else if(count3 == 11) {
					ponto5mov = 138;
				}
				else if(count3 == 12) {
					ponto5mov = 146;
				}
			}
			else if(idade == 14){
				if(count3 == 1) {
					ponto5mov = 71;
				}
				else if(count3 == 2) {
					ponto5mov = 77;
				}
				else if(count3 == 3) {
					ponto5mov = 83;
				}
				else if(count3 == 4) {
					ponto5mov = 90;
				}
				else if(count3 == 5) {
					ponto5mov = 96;
				}
				else if(count3 == 6) {
					ponto5mov = 102;
				}
				else if(count3 == 7) {
					ponto5mov = 108;
				}
				else if(count3 == 8) {
					ponto5mov = 114;
				}
				else if(count3 == 9) {
					ponto5mov = 120;
				}
				else if(count3 == 10) {
					ponto5mov = 126;
				}
				else if(count3 == 11) {
					ponto5mov = 132;
				}
				else if(count3 == 12) {
					ponto5mov = 138;
				}
			}
			else if(idade > 14){
				if(count3 == 1) {
					ponto5mov = 7;
				}
				else if(count3 == 2) {
					ponto5mov = 21;
				}
				else if(count3 == 3) {
					ponto5mov = 34;
				}
				else if(count3 == 4) {
					ponto5mov = 47;
				}
				else if(count3 == 5) {
					ponto5mov = 61;
				}
				else if(count3 == 6) {
					ponto5mov = 74;
				}
				else if(count3 == 7) {
					ponto5mov = 88;
				}
				else if(count3 == 8) {
					ponto5mov = 101;
				}
				else if(count3 == 9) {
					ponto5mov = 114;
				}
				else if(count3 == 10) {
					ponto5mov = 128;
				}
				else if(count3 == 11) {
					ponto5mov = 141;
				}
				else if(count3 == 12) {
					ponto5mov = 155;
				}
			}
			lista.add(ponto.toString());
			lista.add(ponto4mov.toString());
			lista.add(ponto5mov.toString());
			return lista;
		}
		return null;
	}
}
