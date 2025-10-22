package p1;

public class MyString {
    private byte[] string = null;

    public int length() {
        if (string == null) {
            return 0;
        }
        return string.length;
    }

    MyString() {

    }

    MyString(String param) {
        this.setString(param);
    }

    MyString(int param) {
        // string = String.valueOf(param).getBytes().clone();
        String tmp = String.format("%d", param);
        // this.setString(tmp);
        string = tmp.getBytes();
    }

    MyString(MyString rhs) {
        string = new byte[rhs.string.length];
        deepCopy(rhs.string);
    }

    private void deepCopy(byte[] copy) {
        for (int i = 0; i < copy.length; i++) {
            string[i] = copy[i];
        }
    }

    // MyString(MyString rhs) {
    // deepCopy(rhs);
    // }

    // private void deepCopy(MyString rhs) {
    // this.string = rhs.string.clone();
    // }

    public void setString(String param) {
        string = param.getBytes().clone();
    }

    public String getString() {
        if (string == null || string.length <= 0) {
            return "";
        }

        return new String(string);
    }

    public int compareTo(String param) {
        if (string == null) {
            return -1;
        }
        return new String(string).compareTo(param);
    }
}
