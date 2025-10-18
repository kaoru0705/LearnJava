package dynamic.binding;

public class App {
    public static void main(String[] args) {
        Electronics elec;
        elec = new TV();
        elec.turnOff();
    }
}

class Electronics {
    private int nVoltage = 0;
    public void turnOn(int nInputVoltage) {nVoltage = nInputVoltage;}
    public void turnOff() {nVoltage = 0;}
    public int getVoltage() {return nVoltage;}
}

class TV extends Electronics {
    private int nSize = 0;
    public void setSize(int new_size) {nSize = new_size;}
    public int getSize() {return nSize;}
}
