package entidades;

public class GamaProducto {
    private int idGamaProducto;
    private String gama;
    private String descripcionTexto;
    private String descripcionHtml;
    private String imagen;

    public GamaProducto() {
    }

    public GamaProducto(String gama, String descripcionTexto, String descripcionHtml, String imagen) {
        this.gama = gama;
        this.descripcionTexto = descripcionTexto;
        this.descripcionHtml = descripcionHtml;
        this.imagen = imagen;
    }

    public GamaProducto(int idGamaProducto, String gama, String descripcionTexto, String descripcionHtml, String imagen) {
        this.idGamaProducto = idGamaProducto;
        this.gama = gama;
        this.descripcionTexto = descripcionTexto;
        this.descripcionHtml = descripcionHtml;
        this.imagen = imagen;
    }

    public int getIdGamaProducto() {
        return idGamaProducto;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "GamaProducto{" +
                "idGamaProducto=" + idGamaProducto +
                ", gama='" + gama + '\'' +
                ", descripcionTexto='" + descripcionTexto + '\'' +
                ", descripcionHtml='" + descripcionHtml + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}

