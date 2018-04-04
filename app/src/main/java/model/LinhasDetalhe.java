package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinhasDetalhe {

    @SerializedName("p")
    @Expose
    private Integer p;
    @SerializedName("a")
    @Expose
    private Boolean a;
    @SerializedName("ta")
    @Expose
    private String ta;
    @SerializedName("py")
    @Expose
    private Double py;
    @SerializedName("px")
    @Expose
    private Double px;
    @SerializedName("capacidade")
    @Expose
    private Integer capacidade;
    @SerializedName("lotacao")
    @Expose
    private String lotacao;

    public Integer getP() {return p;}

    public void setP(Integer p) {this.p = p;}

    public Boolean getA() {return a;}

    public void setA(Boolean a) {this.a = a;}

    public String getTa() {return ta;}

    public void setTa(String ta) {this.ta = ta; }

    public Double getPy() {return py;}

    public void setPy(Double py) {this.py = py;}

    public Double getPx() {return px;}

    public void setPx(Double px) {this.px = px;}

    public Integer getCapacidade() {return capacidade;}

    public void setCapacidade(Integer capacidade) {this.capacidade = capacidade;}

    public String getLotacao() {return lotacao;}

    public void setLotacao(String lotacao) {this.lotacao = lotacao;}

}