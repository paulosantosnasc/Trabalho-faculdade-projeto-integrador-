package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.EfeitoAdverso;
import repository.EfeitoAdversoRepository;

@Controller
public class EfeitoAdversoController {

    @Autowired
    private EfeitoAdversoRepository efeitoAdversoRepository;

    @GetMapping("/efeitos")
    public String listarEfeitos(Model model) {
        model.addAttribute("efeitos", efeitoAdversoRepository.findAll());
        return "efeitos"; // <- arquivo efeitos.html
    }

    @PostMapping("/efeitos")
    public String cadastrarEfeito(
        @RequestParam String descricao,
        @RequestParam String intensidade,
        @RequestParam String data_relato
    ) {
        EfeitoAdverso e = new EfeitoAdverso();
        e.setDescricao(descricao);
        e.setIntensidade(intensidade);
        e.setDataRelato(data_relato);
        efeitoAdversoRepository.save(e);
        return "redirect:/efeitos";
    }
}
