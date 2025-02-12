package entidades;

import java.time.LocalDate;

public class Pago {
    private int idPago;
    private int idCliente;
    private String formaPago;
    private String idTransaccion;
    private LocalDate fecha_pago;
    private double total;

    public Pago() {
    }

    public Pago(int idCliente, String formaPago, String idTransaccion, LocalDate fecha_pago, double total) {
        this.idCliente = idCliente;
        this.formaPago = formaPago;
        this.idTransaccion = idTransaccion;
        this.fecha_pago = fecha_pago;
        this.total = total;
    }

    public Pago(int idPago, int idCliente, String formaPago, String idTransaccion, LocalDate fecha_pago, double total) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.formaPago = formaPago;
        this.idTransaccion = idTransaccion;
        this.fecha_pago = fecha_pago;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", idCliente=" + idCliente +
                ", formaPago='" + formaPago + '\'' +
                ", idTransaccion='" + idTransaccion + '\'' +
                ", fecha_pago=" + fecha_pago +
                ", total=" + total +
                '}';
    }

    public int getId_pago() {
        return idPago;
    }

    public int getId_cliente() {
        return idCliente;
    }

    public void setId_cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getForma_pago() {
        return formaPago;
    }

    public void setForma_pago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getId_transaccion() {
        return idTransaccion;
    }

    public void setId_transaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
