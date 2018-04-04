package model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Linhas {

    @SerializedName("cl")
    @Expose
    private Integer cl;
    @SerializedName("lc")
    @Expose
    private Boolean lc;
    @SerializedName("lt")
    @Expose
    private String lt;
    @SerializedName("sl")
    @Expose
    private Integer sl;
    @SerializedName("tl")
    @Expose
    private Integer tl;
    @SerializedName("tp")
    @Expose
    private String tp;
    @SerializedName("ts")
    @Expose
    private String ts;





    public Integer getCl() {
        return cl;
    }

    public void setCl(Integer cl) {
        this.cl = cl;
    }

    public Boolean getLc() {
        return lc;
    }

    public void setLc(Boolean lc) {
        this.lc = lc;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public Integer getTl() {
        return tl;
    }

    public void setTl(Integer tl) {
        this.tl = tl;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }





}
