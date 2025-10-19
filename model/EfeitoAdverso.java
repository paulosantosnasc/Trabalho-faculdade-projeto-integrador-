package model;

import jakarta.persistence.*;

@Entity
@Table(name = "efeito_adverso")
public class EfeitoAdverso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEfeito;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vacina_id")
    private Vacina vacina;

    @Column(nullable = false)
    private String descricao;

    private String intensidade; // leve, moderado, grave
    private String dataRelato;

    // Getters e Setters
    public int getIdEfeito() { return idEfeito; }
    public void setIdEfeito(int idEfeito) { this.idEfeito = idEfeito; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Vacina getVacina() { return vacina; }
    public void setVacina(Vacina vacina) { this.vacina = vacina; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getIntensidade() { return intensidade; }
    public void setIntensidade(String intensidade) { this.intensidade = intensidade; }

    public String getDataRelato() { return dataRelato; }
    public void setDataRelato(String dataRelato) { this.dataRelato = dataRelato; }
}
