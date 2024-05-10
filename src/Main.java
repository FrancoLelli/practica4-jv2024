//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(15000, 10);
        CuentaCorriente cuentaCorriente = new CuentaCorriente(15000, 100);

        cuentaAhorros.consignar(10);
        cuentaAhorros.retirar(500);
        float cantRetirosAhorros = cuentaAhorros.getNumeroRetiros();
        System.out.println("El saldo actual es de: "+cuentaAhorros.getSaldo()+" y la cantidad de veces que se retiro dinero fue: "+cantRetirosAhorros);

        cuentaCorriente.retirar(10000);
        cuentaCorriente.retirar(5000);
        cuentaCorriente.retirar(4000);
        cuentaCorriente.retirar(100);
        cuentaCorriente.retirar(100);
        cuentaCorriente.retirar(100);
        float cantRetirosCorriente = cuentaCorriente.getNumeroRetiros();
        System.out.println("El saldo es de: "+cuentaCorriente.getSaldo()+", se retiraron "+cantRetirosCorriente+" veces.");
        System.out.println("Se debe: "+Math.abs(cuentaCorriente.getSobregiro()));
    }
}