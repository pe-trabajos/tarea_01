package pe.edu.cibertec.proyemp.jpa.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.edu.cibertec.proyemp.jpa.domain.Departamento;
import pe.edu.cibertec.proyemp.jpa.domain.Empleado;

public class EclipseLinkTest {

	public static void main(String[] args) {

		crearEmpleado();
		listarEmpleado();

	}

	private static void crearEmpleado() {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Clase_01");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Departamento departamento = new Departamento("Java");		
			Empleado bob = new Empleado("Loco1");
			Empleado mike = new Empleado("Loco2");

			departamento.setEmpleados(Arrays.asList(bob, mike));
			em.persist(departamento);
				
			bob.setDepartamento(departamento);
			mike.setDepartamento(departamento);
			em.getTransaction().commit();
			
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private static void listarEmpleado() {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Clase_01");
		EntityManager em = emf.createEntityManager();

		try {
			Query q = em.createQuery("select e from Empleado e");
			List lista = q.getResultList();
			Empleado obj;
			for (int i = 0; i < lista.size(); i++) {
				obj = (Empleado) lista.get(i);
				System.out.println(obj.getId() + " - " + obj.getNombre()
						+ " - " + obj.getDepartamento().getNombre());
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			emf.close();
		}
		
	}
}
