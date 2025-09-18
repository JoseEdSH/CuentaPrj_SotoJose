import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Cuenta {
    private String codCuenta = "cta-";
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreadas = 0;
    
    public Cuenta(String nombreCuentaHabiente, double pSaldo) {
        this.nombreCuentaHabiente = nombreCuentaHabiente;
        saldo = pSaldo;
        
        fechaCreacion = determinarFechaCreacion();
        
        cantDepositosRealizados = 0;
        cantRetirosExitososRealizados = 0;
        
        cantCuentasCreadas ++;
        codCuenta += cantCuentasCreadas;
    }
    
    public Cuenta(double pSaldo) {
        this("", pSaldo);
    }
    
    public void setNombreCuentaHabiente(String pNombreCuentaHabiente) {
        nombreCuentaHabiente = pNombreCuentaHabiente;
    }
    
    public String getCodCuenta() {
        return codCuenta;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public double depositar(double monto) {
        cantDepositosRealizados += 1;
        return(saldo += monto);
    }
    
    public double retirar(double monto) {
        if(validarRetiro(monto)){
            cantRetirosExitososRealizados += 1;
            saldo -= monto;
        }
        return saldo;
    }
    
    private boolean validarRetiro(double monto) {
        if(saldo >= monto)
            return true;
        else
            return false;
    }
    
    public static int getCantCuentasCreadas() {
        return cantCuentasCreadas;
    }
    
    public String toString() {
        String mensaje = "";
        
        mensaje += "========== Ficha de la Cuenta ==========\n";
        mensaje += "Código de cuenta: " + codCuenta + "\n";
        mensaje += "Nombre de la cuenta Habiente: " + nombreCuentaHabiente + "\n";
        mensaje += "Fecha de creación: " + fechaCreacion + "\n";
        mensaje += "Saldo en cuenta: " + saldo + "\n";
        mensaje += "Depósitos realizados: " + cantDepositosRealizados + "\n";
        mensaje += "Retiros realizados: " + cantRetirosExitososRealizados + "\n";
        mensaje += "=====================================\n\n";
        
        return mensaje;
    }
    
    private String determinarFechaCreacion() {
        Date fecha = new Date(System.currentTimeMillis());
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        return formatoFecha.format(fecha);
    }
    
    //Colocar en principalCuenta para validar si hay un nombre ya puesto
    private boolean validarExistenciaNombreCuentaHabiente() {
        if(nombreCuentaHabiente == "")
            return true;
        else
            return false;
    }
}