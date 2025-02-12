package entidades;

import java.time.LocalDate;

public class Pedido {
    private int idPedido;
    private int codigoPedido;
    private LocalDate fechaPedido;
    private LocalDate fechaEsperada;
    private LocalDate fechaEntrega;
    private String estado;
    private String text;
    private int idCliente;

    public Pedido() {
    }

    public Pedido(int idPedido, int codigoPedido, LocalDate fechaPedido, LocalDate fechaEsperada, LocalDate fechaEntrega, String estado, String text, int idCliente) {
        this.idPedido = idPedido;
        this.codigoPedido = codigoPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEsperada = fechaEsperada;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.text = text;
        this.idCliente = idCliente;
    }

    public Pedido(int codigoPedido, LocalDate fechaPedido, LocalDate fechaEsperada, LocalDate fechaEntrega, String estado, String text, int idCliente) {
        this.codigoPedido = codigoPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEsperada = fechaEsperada;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.text = text;
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEsperada() {
        return fechaEsperada;
    }

    public void setFechaEsperada(LocalDate fechaEsperada) {
        this.fechaEsperada = fechaEsperada;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", codigoPedido=" + codigoPedido +
                ", fechaPedido=" + fechaPedido +
                ", fechaEsperada=" + fechaEsperada +
                ", fechaEntrega=" + fechaEntrega +
                ", estado='" + estado + '\'' +
                ", text='" + text + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }
}