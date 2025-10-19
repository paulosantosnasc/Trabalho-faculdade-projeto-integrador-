package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Vacina;
import repository.VacinaRepository;

@Controller
public class VacinaController {

    @Autowired
    private VacinaRepository vacinaRepository;

    @GetMapping("/vacinas")
    public String listarVacinas(Model model) {
        model.addAttribute("vacinas", vacinaRepository.findAll());
        return "vacinas"; // <- esse é o nome do arquivo vacinas.html
    }

    @PostMapping("/vacinas")
    public String cadastrarVacina(
        @RequestParam String nome,
        @RequestParam String fabricante,
        @RequestParam String lote,
        @RequestParam int doses
    ) {
        Vacina vacina = new Vacina();
        vacina.setNome(nome);
        vacina.setFabricante(fabricante);
        vacina.setLote(lote);
        vacina.setDoses(doses);
        vacinaRepository.save(vacina);
        return "redirect:/vacinas";
    }
}
