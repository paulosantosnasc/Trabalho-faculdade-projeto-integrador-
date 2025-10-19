package model;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_mensagem")
public class ChatMensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String mensagemUsuario;
    private String respostaBot;
    private String dataHora;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getMensagemUsuario() { return mensagemUsuario; }
    public void setMensagemUsuario(String mensagemUsuario) { this.mensagemUsuario = mensagemUsuario; }

    public String getRespostaBot() { return respostaBot; }
    public void setRespostaBot(String respostaBot) { this.respostaBot = respostaBot; }

    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }
}
