package example.day02.day02실습.model실습.dto실습;

public class WaitingDto {
    private int W_No;
    private String phone;
    private int count;

    public WaitingDto() { }

    public WaitingDto(int w_No, String phone, int count) {
        W_No = w_No;
        this.phone = phone;
        this.count = count;
    }

    public int getW_No() {
        return W_No;
    }

    public void setW_No(int w_No) {
        W_No = w_No;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto [W_No=" + W_No + ", phone=" + phone + ", count=" + count + "]";
    }
   

} // class end
