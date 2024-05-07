public class CuentaCorriente extends Cuenta{

    protected float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual, float sobregiro) {
        super(saldo, tasaAnual);
        this.sobregiro = sobregiro;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    @Override
    public float consignar(float cantidad) {
        return 0;
    }

    @Override
    public float retirar(float cantidad) {
        return 0;
    }

    @Override
    public float extractoMensual() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "CuentaCorriente{" +
                "sobregiro=" + sobregiro +
                '}';
    }
}
