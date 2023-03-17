package Entidades;

public class Peticao {
    private String client;
    private String descricao;
    private String causa;
    private Double valorCausa;



    public Peticao(String client, String descricao, String causa, Double valorCausa ) {

        this.client = client;
        this.descricao = descricao;
        this.causa = causa;
        this.valorCausa = valorCausa;
    }

    public Peticao(String causa, Double valorCausa, String client, String descricao) {
    }

    public static void add(Peticao peticao) {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public Double getValorCausa() {
        return valorCausa;
    }

    public void setValorCausa(Double valorCausa) {
        this.valorCausa = valorCausa;
    }

    public Object getvalorCausa() {
        return valorCausa;
    }
}
