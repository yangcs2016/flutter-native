package yangcs2020.com.flutter_app_native;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Map;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;


public class MyView implements PlatformView, MethodChannel.MethodCallHandler {
    private final TextView myNativeView;
    MyView(Context context, BinaryMessenger messenger, int id, Map<String, Object> params) {
        MethodChannel methodChannel = new MethodChannel(messenger, "plugins.nightfarmer.top/myview_" + id);
        methodChannel.setMethodCallHandler(this);
        TextView newText = new TextView(context);
        newText.setText("我是来自Android的原生TextView");
        this.myNativeView = newText;
    }

    @Override
    public View getView() {
        return myNativeView;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        if (call.method.equals("setText")){
           String text = (String) call.arguments;
            Log.d("android myview", "onMethodCall: "+text);
        }
    }
}
