package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.journaldev.spring.model.Persona;
import com.journaldev.spring.service.PersonService;

@Controller
public class PersonController {

	private PersonService personService;

	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}

	//Con este metodo musetra la lista de las personas al acceder al sitio
	@RequestMapping(value = "/persona", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Persona());
		model.addAttribute("listaPersonas", this.personService.listPersons());
		return "person";		//Carga los datos en la vista
	}

	//Para a�adir y actualizar los datos de las personas
	@RequestMapping(value= "/persona/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Persona p){
		if(p.getPersonaID() == 0){
			//nueva persona, agregalo
			this.personService.addPerson(p);
		}else{
			//Existe la persona llama a actualizar
			this.personService.updatePerson(p);
		}
		return "redirect:/persona";
	}

	@RequestMapping("/elimina/{personaID}")
    public String removePerson(@PathVariable("personaID") int id){
        this.personService.removePerson(id);
        return "redirect:/persona";				//con persona volvemos a recargar los datos de la pagina person
    }

		//Cuando es click en el enlace editar carga los datos al formulario y cuando se actualizan los datos se va a add person
    @RequestMapping("/edita/{personaID}")
    public String editPerson(@PathVariable("personaID") int id, Model model){
				//Obtiene los datos de la persona por si id y los muestra en el formulario
        model.addAttribute("person", this.personService.getPersonById(id));   //Esto es a la pagina que se va a dirigir con los valores obtenidos
        model.addAttribute("listaPersonas", this.personService.listPersons());
        return "person";  //Carga todos los datos en la pagina person
    }

}
