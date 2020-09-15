package yangcs2020.com.flutter_app_native;

import android.os.Bundle;
import androidx.annotation.Nullable;
import io.flutter.app.FlutterActivity;

public class MainActivity extends FlutterActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyViewFlutterPlugin.registerWith(this);
    }
}
