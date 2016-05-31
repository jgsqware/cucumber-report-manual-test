package be.bnpp.fortis.cucumber;

/**
 * Created by juliengarcia on 5/31/16.
 */
public class Result {
    public String status;
    public String error_message;

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", error_message='" + error_message + '\'' +
                '}';
    }
}
