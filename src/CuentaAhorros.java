public class CuentaAhorros extends Cuenta{
    protected boolean activa;

    public CuentaAhorros(boolean activa, float saldo, float tasaAnual){
        super(saldo, tasaAnual);
        this.activa = !(saldo < 10000);
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String toString() {
        return super.toString() +
                "CuentaAhorros{" +
                "activa=" + activa +
                "saldo=" + saldo +
                ", Numero de Transacciones=" + (numeroConsignaciones + numeroRetiros) +
                ", comisionMensual=" + comisionMensual +
                '}';
    }

    public float extractoMensual(){
        if(getNumeroRetiros() > 4){
            return getSaldo() - 1000;
        }else{
            return getSaldo();
        }
    }

    @Override
    public float consignar(float cantidad){
        if(isActiva()){
            float nuevaCantidad = getSaldo() + cantidad;
            setSaldo(nuevaCantidad);
            return getSaldo();
        }else{
            return 0;
        }
    }

    @Override
    public float retirar(float cantidad){
        if(isActiva()){
            float nuevaCantidad = getSaldo() - cantidad;
            float cantidadExctracto = this.extractoMensual();
            if(cantidadExctracto > 0){
                setSaldo(nuevaCantidad);
                int numeroRetirosNuevo = getNumeroRetiros() + 1;
                setNumeroRetiros(numeroRetirosNuevo);
                return getSaldo();
            }else {
                setActiva(false);
            }
        }
        return 0;
    }
}
