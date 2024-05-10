public class CuentaCorriente extends Cuenta{

    protected float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    @Override
    public float consignar(float cantidad) {
        if(getSobregiro() > 0){
            float nuevoSobregiro = Math.abs(getSobregiro() - cantidad);
            if(nuevoSobregiro > 0){
                setSobregiro(0);
                float nuevoSaldo = getSaldo() + nuevoSobregiro;
                setSaldo(nuevoSaldo);
            }else{
                setSobregiro(nuevoSobregiro);
            }
        }else{
            float nuevoSaldo = getSaldo() + cantidad;
            setSaldo(nuevoSaldo);
        }
        return getSaldo();
    }

    @Override
    public float retirar(float cantidad) {
            float nuevaCantidad = getSaldo() - cantidad;
            if(nuevaCantidad < 0){
                setSaldo(0);
                int numeroRetirosNuevo = getNumeroRetiros() + 1;
                setNumeroRetiros(numeroRetirosNuevo);
                float nuevoSobregiro = getSobregiro() + nuevaCantidad;
                setSobregiro(nuevoSobregiro);
            }else{
                int numeroRetirosNuevo = getNumeroRetiros() + 1;
                setNumeroRetiros(numeroRetirosNuevo);
                setSaldo(nuevaCantidad);
            }
        return getSaldo();
    }

    @Override
    public void extractoMensual(float cantidad) {
        super.extractoMensual(cantidad);
        setSobregiro(0);
    }

    @Override
    public String toString() {
        return super.toString() +
                "CuentaCorriente{" +
                "sobregiro=" + sobregiro +
                '}';
    }
}
