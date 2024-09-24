import com.example.MessageModel;
import com.example.PrintService;

public class MyApplication {

    public static void main(String[] args) {
        new PrintService().print(new MessageModel("Hello world from my first application built with gradle"));
    }
}
