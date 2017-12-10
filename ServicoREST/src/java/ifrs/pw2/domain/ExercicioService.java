/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifrs.pw2.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExercicioService {
	private List<Exercicio> db = new ArrayList<>();

        
        public ExercicioService(){
            db.add(new Exercicio(1L, "Supino inclinado","http://muscul.az.free.fr/pt/Mp23h.gif","1"));
            db.add(new Exercicio(2L, "Agachamento","http://muscul.az.free.fr/uk/Mc15.gif","2"));
            db.add(new Exercicio(3L, "Rosca com alteres", "http://muscul.az.free.fr/uk/club_mc/supset3.gif", "3"));
            db.add(new Exercicio(4L, "Leg press","http://muscul.az.free.fr/pt/Mp06b.gif","1"));
            db.add(new Exercicio(5L, "Cadeira abdutora","http://muscul.az.free.fr/pt/hm03.gif","2"));
            db.add(new Exercicio(6L, "Panturrilha na cadeira", "http://muscul.az.free.fr/pt/mc10m.gif", "3"));
            db.add(new Exercicio(7L, "Rosca com alteres","http://muscul.az.free.fr/pt/Mep09h.gif","1"));
            db.add(new Exercicio(8L, "Puxada vertical","http://muscul.az.free.fr/pt/Cep09h.gif","2"));
            db.add(new Exercicio(9L, "Supino reto", "http://muscul.az.free.fr/pt/pg05.gif", "3"));

        }
	// Lista todos os livro do banco de dados
	public List<Exercicio> getExercicios() {
		return db;
	}

	// Busca um livro pelo id
	public Exercicio getExercicio(Long id) {
            for (Exercicio exercicio : db) {
               if(exercicio.getId().equals(id)) 
                   return exercicio;
            }
	    return null;   
	}
}