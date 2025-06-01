public class Fueler {
    // this is not a car's responsibility.
    public void reFuel(Vehicle v){
        v.setRemainingFuel(v.getMaxFuel());
    }
}