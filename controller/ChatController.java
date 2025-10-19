package controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @GetMapping
    public String chatPage() {
        return "chat";
    }

    @GetMapping("/enviar")
    @ResponseBody
    public String responder(@RequestParam String mensagem) {
        // respostas simples por enquanto
        mensagem = mensagem.toLowerCase();

        if (mensagem.contains("dor")) return "A dor é comum em até 24h após a vacinação. Se persistir, procure um posto de saúde.";
        if (mensagem.contains("febre")) return "Febre leve é normal. Mantenha hidratação e, se necessário, use antitérmico.";
        if (mensagem.contains("obrigado")) return "De nada! Estou aqui para ajudar.";
        if (mensagem.contains("oi")) return "Olá! Sou o assistente do Monitor de Vacinas.";

        return "Não entendi bem. Pode reformular?";
    }
}
