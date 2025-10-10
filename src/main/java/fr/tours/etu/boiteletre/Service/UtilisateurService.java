package fr.tours.etu.boiteletre.Service;


import fr.tours.etu.boiteletre.Model.Utilisateur;
import fr.tours.etu.boiteletre.Repository.UtilisateurRepository;
import jdk.jshell.execution.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
   private final UtilisateurRepository repo;


    public UtilisateurService(UtilisateurRepository repo) {
        this.repo = repo;
    }

    public Utilisateur getById(int id) {
        return repo.findById(id).orElse(null);
    }
    public List<Utilisateur> getAll() {
        return repo.findAll();
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return repo.save(utilisateur);
    }


    public void deleteUtilisateur(Utilisateur utilisateur) {
        repo.delete(utilisateur);
    }

    public void deleteUtilisateurById(int id) {
        Utilisateur utilisateur = repo.findById(id).orElse(null);
        repo.delete(utilisateur);
    }

    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur , int id) {
        return repo.findById(id).map(user ->{
            user.setNom(utilisateur.getNom());
            user.setPrenom(utilisateur.getPrenom());
            user.setEmail(utilisateur.getEmail());
            user.setPassword(utilisateur.getPassword());
            user.setUsername(utilisateur.getUsername());
            return repo.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
