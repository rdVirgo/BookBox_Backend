package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.Model.Utilisateur;
import fr.tours.etu.boiteletre.Repository.UtilisateurRepository;
import fr.tours.etu.boiteletre.Service.UtilisateurService;
import jdk.jshell.execution.Util;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    public UtilisateurController(UtilisateurService utilisateurService) {
      this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getUtilisateurs() {
     return utilisateurService.getAll();
}

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
      return utilisateurService.createUtilisateur(utilisateur);
    }


    @GetMapping("/{id}")
    public Utilisateur getUserById(@PathVariable int id) {
        return utilisateurService.getById(id);
    }

    @PutMapping
    public Utilisateur updateUtilisateur(@PathVariable int id, @RequestBody Utilisateur user) {
        return utilisateurService.UpdateUtilisateur(user,id);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable int id) {
        utilisateurService.deleteUtilisateurById(id);
    }

}
