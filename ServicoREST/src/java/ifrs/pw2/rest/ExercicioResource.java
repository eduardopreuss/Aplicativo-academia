
package ifrs.pw2.rest;
import ifrs.pw2.domain.Exercicio;
import ifrs.pw2.domain.ExercicioService;
import ifrs.pw2.domain.Response;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Exercicios")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ExercicioResource {
	private ExercicioService exercicioService = new ExercicioService();

	@GET
	public String get() {
		List<Exercicio> exercicios = (ArrayList<Exercicio>) exercicioService.getExercicios();
                System.out.println(exercicios.toString());
		return exercicios.toString();
	}
       

	@GET
	@Path("{id}")
	public Exercicio get(@PathParam("id") long id) {
		Exercicio exercicio = exercicioService.getExercicio(id);
		return exercicio;
        }


}
