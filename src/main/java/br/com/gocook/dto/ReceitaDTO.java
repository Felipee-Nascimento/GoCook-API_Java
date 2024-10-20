package br.com.gocook.dto;

public class ReceitaDTO {
    private Long id;
    private String titulo;
    private Integer tempoDePreparo;
    private String modoDePreparo;
    private Integer quantidadeDePessoasServidas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Integer tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public Integer getQuantidadeDePessoasServidas() {
        return quantidadeDePessoasServidas;
    }

    public void setQuantidadeDePessoasServidas(Integer quantidadeDePessoasServidas) {
        this.quantidadeDePessoasServidas = quantidadeDePessoasServidas;
    }
}
