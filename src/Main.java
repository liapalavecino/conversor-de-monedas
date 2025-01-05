import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson("Hola, soy un commit");
        System.out.println(json);
    }
}
