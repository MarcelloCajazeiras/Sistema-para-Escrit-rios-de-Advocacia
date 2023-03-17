package Entidades;

public class Processo {
    private String processo;
    private String advogado;
    private String client;
    private String descricao;

    public Processo(String processo, String advogado, String client, String descricao) {
        this.processo = processo;
        this.advogado = advogado;
        this.client = client;
        this.descricao = descricao;
    }

    public static void add(Processo processoo) {
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getAdvogado() {
        return advogado;
    }

    public void setAdvogado(String advogado) {
        this.advogado = advogado;
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
}
