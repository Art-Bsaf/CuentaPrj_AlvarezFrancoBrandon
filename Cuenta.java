import java.time.LocalDate;

public class Cuenta {
    
    private double saldo;
    private String codCuenta = "cta-";
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    
    private static int cantCuentasCreadas = 0;
    
    public Cuenta(String pNombreCuentaHabiente, double pSaldo) {
        
        String fechaActual = LocalDate.now().toString();
        
        this.saldo = pSaldo;
        this.nombreCuentaHabiente = pNombreCuentaHabiente;
        this.fechaCreacion = fechaActual;
        
        cantCuentasCreadas += 1;
        
        this.codCuenta += cantCuentasCreadas;
        
    }
    
    public Cuenta(double pSaldo) {
        
        String fechaActual = LocalDate.now().toString();
        
        this.saldo = pSaldo;
        this.fechaCreacion = fechaActual;
        
        cantCuentasCreadas += 1;
        
        this.codCuenta += cantCuentasCreadas;
        
    }
    
    public String getCodCuenta() {
        
        return codCuenta;
        
    }

    public double getSaldo() {
        
        return saldo;
        
    }
    
    public void setNombreCuentaHabiente(String pNombreCuentaHabiente){
        
        this.nombreCuentaHabiente = pNombreCuentaHabiente;
        
    }
    
    public double depositar(double monto){
        
        this.saldo += monto;
        this.cantDepositosRealizados += 1;
        
        return getSaldo();
    }
    
    
    private boolean validarRetiro(double monto){
        
        if ((saldo - monto) >= 0){
            return true;
        }
        
        return false;
        
    }
    
    public double retirar(double monto) {
        
        if (validarRetiro(monto)){
            this.saldo -= monto;
            this.cantRetirosExitososRealizados += 1;
            
            return getSaldo();
        }else {
            return getSaldo();
        }
        
    }
    
    public static int getCantCuentasCreadas() {
         return cantCuentasCreadas;
     }
     
    public String toString() {
        return "Codigo: " + codCuenta + " | Nombre: " + nombreCuentaHabiente + " | Saldo: " + saldo + " | Fecha de creacion: " + fechaCreacion + " | Depositos: " + cantDepositosRealizados + " | Retiros exitosos: " + cantRetirosExitososRealizados;
    }
}