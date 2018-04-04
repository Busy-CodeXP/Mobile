package model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinhaDetalheResult {

    @SerializedName("vs")
    @Expose
    //private List<model.LinhasDetalhe> vs = null;
    public List<model.LinhasDetalhe> vs = null;

    @SerializedName("hr")
    @Expose
    private String hr;

    public List<model.LinhasDetalhe> getVs() {
        return vs;
    }

    public void setVs(List<LinhasDetalhe> vs) {
        this.vs = vs;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

}
